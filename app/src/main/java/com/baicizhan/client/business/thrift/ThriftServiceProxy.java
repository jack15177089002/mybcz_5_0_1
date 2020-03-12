//package com.baicizhan.client.business.thrift;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import android.text.TextUtils;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.PriorityBlockingQueue;
//import org.p100a.p101a.TServiceClient;
//import org.p100a.p101a.TServiceClientFactory;
//import org.p100a.p101a.p104c.C2096a;
//import org.p100a.p101a.p107f.C2119f;
//import org.p100a.p101a.p107f.C2120g;
//
//public class ThriftServiceProxy {
//    private static final int DEFAULT_THREADPOOL_SIZE = 4;
//    private CookieInflator mCookieInflator;
//    private Set<ThriftRequest<?, ?>> mCurrentRequests;
//    private Map<String, DomainEntry> mDomainMap;
//    private PriorityBlockingQueue<ThriftRequest<?, ?>> mRequestQueue;
//    private int mThreadPoolSize;
//    private ArrayList<ThriftWorkerThread> mWorkers;
//
//    public class DomainEntry {
//        public TServiceClientFactory<?> factory;
//        public String name;
//        public BackupUrlPolicy urlPolicy;
//
//        public DomainEntry(String str, BackupUrlPolicy backupUrlPolicy, TServiceClientFactory<?> oVar) {
//            this.name = str;
//            this.urlPolicy = backupUrlPolicy;
//            this.factory = oVar;
//        }
//    }
//
//    public ThriftServiceProxy() {
//        this(4);
//    }
//
//    public ThriftServiceProxy(int i) {
//        this.mDomainMap = new ArrayMap();
//        this.mCurrentRequests = new HashSet();
//        this.mThreadPoolSize = i;
//        this.mWorkers = new ArrayList<>(i);
//        this.mRequestQueue = new PriorityBlockingQueue<>();
//    }
//
//    public void registerDomain(DomainEntry domainEntry) {
//        this.mDomainMap.put(domainEntry.name, domainEntry);
//    }
//
//    public void unregisterDomain(String str) {
//        this.mDomainMap.remove(str);
//    }
//
//    public DomainEntry getDomainEntry(String str) {
//        return (DomainEntry) this.mDomainMap.get(str);
//    }
//
//    public Map<String, DomainEntry> getDomainEntries() {
//        return this.mDomainMap;
//    }
//
//    public void setCookieInflator(CookieInflator cookieInflator) {
//        this.mCookieInflator = cookieInflator;
//    }
//
//    public TServiceClient createClient(String str) {
//        DomainEntry domainEntry = getDomainEntry(str);
//        if (domainEntry == null) {
//            throw new C2120g("service domain not exists " + str);
//        }
//        TEnhancedHttpClient tEnhancedHttpClient = new TEnhancedHttpClient((UrlPolicy) domainEntry.urlPolicy);
//        TEnhancedFramedTransport tEnhancedFramedTransport = new TEnhancedFramedTransport(tEnhancedHttpClient);
//        tEnhancedHttpClient.setCookieInflator(this.mCookieInflator);
//        tEnhancedHttpClient.setMaxRetryCount(3);
//        tEnhancedFramedTransport.open();
//        return domainEntry.factory.getClient(new C2096a(tEnhancedFramedTransport, 0));
//    }
//
//    public static TEnhancedHttpClient getTransport(TServiceClient nVar) {
//        C2119f s = nVar.getInputProtocol().mo18524s();
//        if (s instanceof TEnhancedFramedTransport) {
//            C2119f innerTransport = ((TEnhancedFramedTransport) s).getInnerTransport();
//            if (innerTransport instanceof TEnhancedHttpClient) {
//                return (TEnhancedHttpClient) innerTransport;
//            }
//        }
//        throw new IllegalStateException("thrift transport is not http");
//    }
//
//    public void destroyClient(TServiceClient nVar) {
//        nVar.getInputProtocol().mo18524s().close();
//        nVar.getOutputProtocol().mo18524s().close();
//    }
//
//    static void setClientConnectTimeout(TServiceClient nVar, int i) {
//    }
//
//    static void setClientReadTimeout(TServiceClient nVar, int i) {
//    }
//
//    public void start() {
//        stop();
//        for (int i = 0; i < this.mThreadPoolSize; i++) {
//            ThriftWorkerThread thriftWorkerThread = new ThriftWorkerThread(this, this.mRequestQueue);
//            this.mWorkers.add(thriftWorkerThread);
//            thriftWorkerThread.start();
//        }
//    }
//
//    public void stop() {
//        Iterator it = this.mWorkers.iterator();
//        while (it.hasNext()) {
//            ((ThriftWorkerThread) it.next()).quit();
//        }
//        this.mWorkers.clear();
//        this.mRequestQueue.clear();
//    }
//
//    public void cancelAll() {
//        synchronized (this.mCurrentRequests) {
//            for (ThriftRequest cancel : this.mCurrentRequests) {
//                cancel.cancel();
//            }
//        }
//    }
//
//    public void cancelAllWithTag(String str) {
//        synchronized (this.mCurrentRequests) {
//            for (ThriftRequest thriftRequest : this.mCurrentRequests) {
//                if (TextUtils.equals(thriftRequest.getTag(), str)) {
//                    thriftRequest.cancel();
//                }
//            }
//        }
//    }
//
//    public void add(ThriftRequest<?, ?> thriftRequest) {
//        if (thriftRequest != null) {
//            synchronized (this.mCurrentRequests) {
//                this.mCurrentRequests.add(thriftRequest);
//            }
//            this.mRequestQueue.add(thriftRequest);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void finish(ThriftRequest<?, ?> thriftRequest) {
//        if (thriftRequest != null) {
//            synchronized (this.mCurrentRequests) {
//                this.mCurrentRequests.remove(thriftRequest);
//            }
//        }
//    }
//
//    public void putCookie(String str, String str2) {
//        this.mCookieInflator.put(str, str2);
//    }
//
//    public boolean hasCookie(String str) {
//        return this.mCookieInflator.hasKey(str);
//    }
//
//    public void removeCookie(String str) {
//        this.mCookieInflator.remove(str);
//    }
//}
