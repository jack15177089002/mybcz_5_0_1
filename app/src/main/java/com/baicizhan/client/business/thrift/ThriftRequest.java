//package com.baicizhan.client.business.thrift;
//
//import android.os.Handler;
//import android.os.Looper;
//import java.util.concurrent.atomic.AtomicBoolean;
//import org.p100a.p101a.TServiceClient;
//
//public abstract class ThriftRequest<Client extends TServiceClient, Result> implements Comparable<ThriftRequest<Client, Result>> {
//    private static Handler sHandler = new Handler(Looper.getMainLooper());
//    private AtomicBoolean mCanceled = new AtomicBoolean(false);
//    private Client mClient;
//    private String mDomain;
//    private Priority mPriority = Priority.NORMAL;
//    private String mTag = null;
//
//    public enum Priority {
//        HIGH,
//        NORMAL,
//        LOW
//    }
//
//    public abstract Result doInBackground(Client client);
//
//    public abstract void onError(Exception exc);
//
//    public abstract void onResult(Result result);
//
//    public ThriftRequest(String str) {
//        this.mDomain = str;
//    }
//
//    public String getDomain() {
//        return this.mDomain;
//    }
//
//    public String getTag() {
//        return this.mTag;
//    }
//
//    public void setTag(String str) {
//        this.mTag = str;
//    }
//
//    public int compareTo(ThriftRequest<Client, Result> thriftRequest) {
//        return getPriority().ordinal() - thriftRequest.getPriority().ordinal();
//    }
//
//    public void cancel() {
//        this.mCanceled.set(true);
//    }
//
//    public boolean isCanceled() {
//        return this.mCanceled.get();
//    }
//
//    public void setPriority(Priority priority) {
//        this.mPriority = priority;
//    }
//
//    public Priority getPriority() {
//        return this.mPriority;
//    }
//
//    public final TEnhancedHttpClient getHttpClient() {
//        return ThriftServiceProxy.getTransport(this.mClient);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public final void execute(ThriftServiceProxy thriftServiceProxy) {
//        Client client = null;
//        try {
//            if (!isCanceled()) {
//                client = thriftServiceProxy.createClient(getDomain());
//                this.mClient = client;
//                Object doInBackground = doInBackground(this.mClient);
//                if (!isCanceled()) {
//                    postResult(doInBackground);
//                    if (client != null) {
//                        thriftServiceProxy.destroyClient(client);
//                    }
//                } else if (client != null) {
//                    thriftServiceProxy.destroyClient(client);
//                }
//            }
//        } catch (Exception e) {
//            postError(e);
//            if (client != null) {
//                thriftServiceProxy.destroyClient(client);
//            }
//        } catch (Throwable th) {
//            if (client != null) {
//                thriftServiceProxy.destroyClient(client);
//            }
//            throw th;
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public final void postError(final Exception exc) {
//        sHandler.post(new Runnable() {
//            public void run() {
//                ThriftRequest.this.onError(exc);
//            }
//        });
//    }
//
//    /* access modifiers changed from: 0000 */
//    public final void postResult(final Result result) {
//        sHandler.post(new Runnable() {
//            public void run() {
//                ThriftRequest.this.onResult(result);
//            }
//        });
//    }
//
//    /* access modifiers changed from: 0000 */
//    public final void post(Runnable runnable) {
//        sHandler.post(runnable);
//    }
//}
