package com.baicizhan.client.business.thrift;

import android.content.Context;
//import com.baicizhan.client.business.thrift.ThriftServiceProxy.DomainEntry;
//import com.baicizhan.online.bs_users.BSUsers.Client.Factory;
//import com.baicizhan.online.bs_words.BSWords.Client;

public class BaicizhanThrifts {
    public static final int[] DEFAULT_FAST_RETRY_TIMEOUTS = {3000, 5000, 10000};
    public static final RetryPolicy DEFAULT_FAST_RETRY_POLICY = new ManualRetryPolicy(DEFAULT_FAST_RETRY_TIMEOUTS);
    public static final String DEFAULT_MASTER_SERVICE_URL = "http://www.baicizhan.com";
    public static final String DEFAULT_SLAVE_SERVICE_URL = "http://42.121.253.195";
    public static final String USERS = "/rpc/users";
    private static final boolean USE_TEST = false;
    public static final String WORDS = "/rpc/words";
//    private static ThriftServiceProxy sInstance;
//
//    public static void initialize(Context context) {
//        if (sInstance == null) {
//            synchronized (ThriftServiceProxy.class) {
//                if (sInstance == null) {
//                    BaicizhanCookieInflator baicizhanCookieInflator = new BaicizhanCookieInflator(context);
//                    ThriftServiceProxy thriftServiceProxy = new ThriftServiceProxy();
//                    sInstance = thriftServiceProxy;
//                    thriftServiceProxy.setCookieInflator(baicizhanCookieInflator);
////                    sInstance.registerDomain(new DomainEntry(USERS, new BackupUrlPolicy(USERS, DEFAULT_MASTER_SERVICE_URL, DEFAULT_SLAVE_SERVICE_URL), new Factory()));
////                    sInstance.registerDomain(new DomainEntry(WORDS, new BackupUrlPolicy(WORDS, DEFAULT_MASTER_SERVICE_URL, DEFAULT_SLAVE_SERVICE_URL), new Client.Factory()));
//                    sInstance.start();
//                }
//            }
//        }
//    }
//
//    public static ThriftServiceProxy getProxy() {
//        return sInstance;
//    }
//
//    public static void updateServiceUrl(String str, String str2) {
//        for (DomainEntry domainEntry : sInstance.getDomainEntries().values()) {
//            domainEntry.urlPolicy.setMasterUrl(str);
//            domainEntry.urlPolicy.setSlaveUrl(str2);
//        }
//    }
}
