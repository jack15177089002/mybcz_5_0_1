package com.baicizhan.client.business.thrift;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;

public class ThriftWorkerThread extends Thread {
//    private final ThriftServiceProxy mProxy;
//    private final BlockingQueue<ThriftRequest<?, ?>> mQueue;
//    private boolean mQuit = false;
//
//    ThriftWorkerThread(ThriftServiceProxy thriftServiceProxy, BlockingQueue<ThriftRequest<?, ?>> blockingQueue) {
//        this.mProxy = thriftServiceProxy;
//        this.mQueue = blockingQueue;
//    }
//
//    public void quit() {
//        this.mQuit = true;
//        interrupt();
//    }
//
//    public void run() {
//        Process.setThreadPriority(10);
//        while (true) {
//            try {
//                ThriftRequest thriftRequest = (ThriftRequest) this.mQueue.take();
//                if (thriftRequest != null) {
//                    thriftRequest.execute(this.mProxy);
//                    this.mProxy.finish(thriftRequest);
//                }
//            } catch (InterruptedException e) {
//                if (this.mQuit) {
//                    Log.d("leijie", "stop thread worker " + getId());
//                    return;
//                }
//            }
//        }
//    }
}
