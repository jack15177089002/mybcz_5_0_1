package p012ch.qos.logback.core.spi;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p012ch.qos.logback.core.Appender;

/* renamed from: ch.qos.logback.core.spi.AppenderAttachableImpl */
public class AppenderAttachableImpl<E> implements AppenderAttachable<E> {
    static final long START = System.currentTimeMillis();
    private final CopyOnWriteArrayList<Appender<E>> appenderList = new CopyOnWriteArrayList<>();

    public void addAppender(Appender<E> appender) {
        if (appender == null) {
            throw new IllegalArgumentException("Null argument disallowed");
        }
        this.appenderList.addIfAbsent(appender);
    }

    public int appendLoopOnAppenders(E e) {
        int i = 0;
        Iterator it = this.appenderList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            ((Appender) it.next()).doAppend(e);
            i = i2 + 1;
        }
    }

    public Iterator<Appender<E>> iteratorForAppenders() {
        return this.appenderList.iterator();
    }

    public Appender<E> getAppender(String str) {
        if (str == null) {
            return null;
        }
        Iterator it = this.appenderList.iterator();
        while (it.hasNext()) {
            Appender<E> appender = (Appender) it.next();
            if (str.equals(appender.getName())) {
                return appender;
            }
        }
        return null;
    }

    public boolean isAttached(Appender<E> appender) {
        if (appender == null) {
            return false;
        }
        Iterator it = this.appenderList.iterator();
        while (it.hasNext()) {
            if (((Appender) it.next()) == appender) {
                return true;
            }
        }
        return false;
    }

    public void detachAndStopAllAppenders() {
        Iterator it = this.appenderList.iterator();
        while (it.hasNext()) {
            ((Appender) it.next()).stop();
        }
        this.appenderList.clear();
    }

    public boolean detachAppender(Appender<E> appender) {
        if (appender == null) {
            return false;
        }
        return this.appenderList.remove(appender);
    }

    public boolean detachAppender(String str) {
        boolean z;
        if (str == null) {
            return false;
        }
        Iterator it = this.appenderList.iterator();
        while (true) {
            if (it.hasNext()) {
                Appender appender = (Appender) it.next();
                if (str.equals(appender.getName())) {
                    z = this.appenderList.remove(appender);
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z;
    }
}
