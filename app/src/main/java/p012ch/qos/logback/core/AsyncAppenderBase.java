package p012ch.qos.logback.core;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import p012ch.qos.logback.core.spi.AppenderAttachable;
import p012ch.qos.logback.core.spi.AppenderAttachableImpl;

/* renamed from: ch.qos.logback.core.AsyncAppenderBase */
public class AsyncAppenderBase<E> extends UnsynchronizedAppenderBase<E> implements AppenderAttachable<E> {
    public static final int DEFAULT_QUEUE_SIZE = 256;
    static final int UNDEFINED = -1;
    AppenderAttachableImpl<E> aai = new AppenderAttachableImpl<>();
    int appenderCount = 0;
    BlockingQueue<E> blockingQueue;
    int discardingThreshold = -1;
    int queueSize = 256;
    Worker worker = new Worker<>();

    /* renamed from: ch.qos.logback.core.AsyncAppenderBase$Worker */
    class Worker extends Thread {
        Worker() {
        }

        public void run() {
            AsyncAppenderBase asyncAppenderBase = AsyncAppenderBase.this;
            AppenderAttachableImpl<E> appenderAttachableImpl = asyncAppenderBase.aai;
            while (asyncAppenderBase.isStarted()) {
                try {
                    appenderAttachableImpl.appendLoopOnAppenders(asyncAppenderBase.blockingQueue.take());
                } catch (InterruptedException e) {
                }
            }
            AsyncAppenderBase.this.addInfo("Worker thread will flush remaining events before exiting.");
            for (E appendLoopOnAppenders : asyncAppenderBase.blockingQueue) {
                appenderAttachableImpl.appendLoopOnAppenders(appendLoopOnAppenders);
            }
            appenderAttachableImpl.detachAndStopAllAppenders();
        }
    }

    public boolean isDiscardable(E e) {
        return false;
    }

    public void preprocess(E e) {
    }

    public void start() {
        if (this.appenderCount == 0) {
            addError("No attached appenders found.");
        } else if (this.queueSize <= 0) {
            addError("Invalid queue size [" + this.queueSize + "]");
        } else {
            this.blockingQueue = new ArrayBlockingQueue(this.queueSize);
            if (this.discardingThreshold == -1) {
                this.discardingThreshold = this.queueSize / 5;
            }
            addInfo("Setting discardingThreshold to " + this.discardingThreshold);
            this.worker.setDaemon(true);
            this.worker.setName("AsyncAppender-Worker-" + this.worker.getName());
            super.start();
            this.worker.start();
        }
    }

    public void stop() {
        if (isStarted()) {
            super.stop();
            this.worker.interrupt();
            try {
                this.worker.join(1000);
            } catch (InterruptedException e) {
                addError("Failed to join worker thread", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void append(E e) {
        if (!isQueueBelowDiscardingThreshold() || !isDiscardable(e)) {
            preprocess(e);
            put(e);
        }
    }

    private boolean isQueueBelowDiscardingThreshold() {
        return this.blockingQueue.remainingCapacity() < this.discardingThreshold;
    }

    private void put(E e) {
        try {
            this.blockingQueue.put(e);
        } catch (InterruptedException e2) {
        }
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public void setQueueSize(int i) {
        this.queueSize = i;
    }

    public int getDiscardingThreshold() {
        return this.discardingThreshold;
    }

    public void setDiscardingThreshold(int i) {
        this.discardingThreshold = i;
    }

    public int getNumberOfElementsInQueue() {
        return this.blockingQueue.size();
    }

    public int getRemainingCapacity() {
        return this.blockingQueue.remainingCapacity();
    }

    public void addAppender(Appender<E> appender) {
        if (this.appenderCount == 0) {
            this.appenderCount++;
            addInfo("Attaching appender named [" + appender.getName() + "] to AsyncAppender.");
            this.aai.addAppender(appender);
            return;
        }
        addWarn("One and only one appender may be attached to AsyncAppender.");
        addWarn("Ignoring additional appender named [" + appender.getName() + "]");
    }

    public Iterator<Appender<E>> iteratorForAppenders() {
        return this.aai.iteratorForAppenders();
    }

    public Appender<E> getAppender(String str) {
        return this.aai.getAppender(str);
    }

    public boolean isAttached(Appender<E> appender) {
        return this.aai.isAttached(appender);
    }

    public void detachAndStopAllAppenders() {
        this.aai.detachAndStopAllAppenders();
    }

    public boolean detachAppender(Appender<E> appender) {
        return this.aai.detachAppender(appender);
    }

    public boolean detachAppender(String str) {
        return this.aai.detachAppender(str);
    }
}
