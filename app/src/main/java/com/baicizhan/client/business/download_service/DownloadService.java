package com.baicizhan.client.business.download_service;

import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadService {
    /* access modifiers changed from: private */
    public static final String TAG = DownloadService.class.getSimpleName();
    private static DownloadService sInstance = null;
    private MultiplexChannel<AbstractDownloadTask> mDownloadChannel = new MultiplexChannel<>();
    private List<Worker> mDownloadWorkers = new ArrayList();

    class Worker extends Thread {
        MultiplexChannel<AbstractDownloadTask> channel;

        /* renamed from: id */
        int f2235id;
        volatile boolean quited;

        public Worker(int i, MultiplexChannel<AbstractDownloadTask> multiplexChannel) {
            this.f2235id = i;
            this.channel = multiplexChannel;
        }

        public void quit() {
            this.quited = true;
            interrupt();
        }

        public void run() {
            Process.setThreadPriority(10);
            while (!this.quited) {
                try {
                    AbstractDownloadTask abstractDownloadTask = (AbstractDownloadTask) this.channel.take();
                    if (abstractDownloadTask != null) {
                        try {
                            abstractDownloadTask.run();
                        } catch (Exception e) {
                            Log.e(DownloadService.TAG, Log.getStackTraceString(e));
                        }
                    }
                } catch (Exception e2) {
                    if (this.quited) {
                        return;
                    }
                }
            }
        }
    }

    public static DownloadService getInstance() {
        if (sInstance == null) {
            synchronized (DownloadService.class) {
                if (sInstance == null) {
                    sInstance = new DownloadService();
                }
            }
        }
        return sInstance;
    }

    public synchronized void init(int i) {
        shutdown();
        adjustPoolSize(i);
    }

    public synchronized void shutdown() {
        for (Worker quit : this.mDownloadWorkers) {
            quit.quit();
        }
        this.mDownloadWorkers.clear();
        this.mDownloadChannel.clearAll();
    }

    public synchronized void clearAllTask() {
        this.mDownloadChannel.clearAll();
    }

    public synchronized void adjustPoolSize(int i) {
        if (this.mDownloadWorkers.size() < i) {
            for (int size = this.mDownloadWorkers.size(); size < i; size++) {
                Worker worker = new Worker(size, this.mDownloadChannel);
                worker.start();
                this.mDownloadWorkers.add(worker);
            }
        } else if (this.mDownloadWorkers.size() > i) {
            Iterator it = this.mDownloadWorkers.iterator();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mDownloadWorkers.size()) {
                    break;
                }
                Worker worker2 = (Worker) it.next();
                if (i3 >= i) {
                    worker2.quit();
                    it.remove();
                }
                i2 = i3 + 1;
            }
        }
    }

    public void add(ChannelPriority channelPriority, AbstractDownloadTask abstractDownloadTask) {
        this.mDownloadChannel.put(channelPriority, abstractDownloadTask);
    }

    public void pause(ChannelPriority channelPriority) {
        this.mDownloadChannel.pause(channelPriority);
    }

    public void resume(ChannelPriority channelPriority) {
        this.mDownloadChannel.resume(channelPriority);
    }
}
