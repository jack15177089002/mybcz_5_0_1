//package com.baicizhan.main.resource;
//
//import com.baicizhan.client.business.dataset.helpers.TopicRecordHelper;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.TEnhancedHttpClient;
//import com.baicizhan.client.business.thrift.ThriftServiceProxy;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.framework.BaseAppHandler;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.online.bs_words.BBWordPackage;
//import com.baicizhan.online.bs_words.BSWords.Client;
//import java.io.File;
//import java.util.Collections;
//import java.util.concurrent.atomic.AtomicBoolean;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class TopicDownloadTask extends AbstractDownloadTask {
//    private static final int MAX_UPDATE_FAILED_COUNT = 1;
//    private static final String TAG = TopicDownloadTask.class.getSimpleName();
//    private static AtomicInteger sRoundRobinGen = new AtomicInteger(0);
//    private static final AtomicBoolean sSkipTopicUpdate = new AtomicBoolean(false);
//    private static final AtomicInteger sUpdateFailedCount = new AtomicInteger(0);
//    private int mBookId = 0;
//    private TopicRecord mExistRecord = null;
//    private boolean mRandomizeInitialDnsIndex = false;
//    private TopicRecord mResult = null;
//    private int mTopicId = 0;
//    private BBWordPackage mWordPackage;
//
//    public static void resetCtrlState() {
//        sUpdateFailedCount.set(0);
//        sSkipTopicUpdate.set(false);
//    }
//
//    public static boolean isSkipTopicUpdate() {
//        return sSkipTopicUpdate.get();
//    }
//
//    public static void setSkipTopicUpdate(boolean z) {
//        sSkipTopicUpdate.set(z);
//    }
//
//    public TopicDownloadTask(int i, int i2) {
//        this.mBookId = i;
//        this.mTopicId = i2;
//    }
//
//    public void randomizeInitialDnsIndex() {
//        this.mRandomizeInitialDnsIndex = true;
//    }
//
//    public String toString() {
//        return "TopicDownloadTask [bookId=" + this.mBookId + ", topicId=" + this.mTopicId + "]";
//    }
//
//    public void setWordPackage(BBWordPackage bBWordPackage) {
//        this.mWordPackage = bBWordPackage;
//    }
//
//    public void setExistTopicRecord(TopicRecord topicRecord) {
//        this.mExistRecord = topicRecord;
//    }
//
//    /* access modifiers changed from: protected */
//    public void postSuccess() {
//        if (isValid()) {
//            super.postSuccess();
//        }
//    }
//
//    public void run() {
//        boolean z = false;
//        boolean z2 = this.mExistRecord != null && TopicResourceChecker.checkIntegrity(this.mExistRecord);
//        if (this.mExistRecord != null && TopicResourceChecker.checkUpdateFlagMD5(this.mExistRecord)) {
//            z = true;
//        }
//        try {
//            TopicResourceManager instance = TopicResourceManager.getInstance();
//            if (!z2) {
//                this.mDownloader.setConnectTimeout(5000);
//                this.mDownloader.setReadTimeout(10000);
//                this.mDownloader.setPerDNSMaxRetryCount(3);
//            } else if (z || sSkipTopicUpdate.get() || NetworkUtils.getActiveNetworkType(BaseAppHandler.getApp()) != 0) {
//                postSuccess();
//                return;
//            } else {
//                this.mDownloader.setConnectTimeout(1000);
//                this.mDownloader.setReadTimeout(2000);
//                this.mDownloader.setPerDNSMaxRetryCount(1);
//            }
//            if (this.mRandomizeInitialDnsIndex) {
//                this.mDownloader.setInitialDnsIndex(sRoundRobinGen.incrementAndGet());
//            }
//            if (this.mWordPackage == null) {
//                this.mWordPackage = TopicResourceManager.getInstance().getOfflineResRepo().getWordPackage(this.mTopicId);
//                if (this.mWordPackage == null) {
//                    Client client = (Client) BaicizhanThrifts.getProxy().createClient(BaicizhanThrifts.WORDS);
//                    if (z2) {
//                        TEnhancedHttpClient transport = ThriftServiceProxy.getTransport(client);
//                        if (transport != null) {
//                            transport.setMaxRetryCount(1);
//                            transport.setConnectTimeout(1000);
//                            transport.setReadTimeout(2000);
//                        }
//                    }
//                    this.mWordPackage = (BBWordPackage) client.get_word_package(Collections.singletonList(Integer.valueOf(this.mTopicId)), this.mBookId).get(0);
//                }
//            }
//            TopicRecord downloadResources = downloadResources();
//            if (isValid()) {
//                instance.putTopicRecord(downloadResources);
//                this.mResult = downloadResources;
//                postSuccess();
//                return;
//            }
//            TopicRecordHelper.saveBookTopicRecord(instance.getContext(), this.mBookId, downloadResources);
//        } catch (Exception e) {
//            if (z2) {
//                int incrementAndGet = sUpdateFailedCount.incrementAndGet();
//                LogWrapper.m2796v(TAG, "update failed count " + incrementAndGet + ", use old ");
//                if (incrementAndGet > 0) {
//                    LogWrapper.m2797w(TAG, "setSkipTopicUpdate true");
//                    sSkipTopicUpdate.set(true);
//                }
//                this.mResult = this.mExistRecord;
//                postSuccess();
//                return;
//            }
//            LogWrapper.m2794e(TAG, e.toString());
//            postError(e);
//        }
//    }
//
//    private boolean isValid() {
//        return this.mBookId == TopicResourceManager.getInstance().getBookId();
//    }
//
//    private TopicRecord downloadResources() {
//        File zpkFileByName = ZPackUtils.getZpkFileByName(this.mBookId, this.mWordPackage.getZpk_path());
//        if (zpkFileByName == null) {
//            throw new RuntimeException("zpk path null: " + this.mWordPackage.getZpk_path());
//        }
//        File download = this.mDownloader.download(this.mWordPackage.getZpk_path(), zpkFileByName.getPath());
//        TopicRecord readMetaTopicRecord = ZPackUtils.readMetaTopicRecord(download.getAbsolutePath());
//        if (readMetaTopicRecord == null) {
//            throw new RuntimeException("zpk meta null: " + download.getAbsolutePath());
//        }
//        readMetaTopicRecord.zpkPath = this.mWordPackage.getZpk_path();
//        readMetaTopicRecord.updateFlagMD5 = this.mWordPackage.getZpk_md5();
//        return readMetaTopicRecord;
//    }
//
//    public Object getUniqueKey() {
//        return Integer.valueOf(this.mTopicId);
//    }
//
//    public int getBookId() {
//        return this.mBookId;
//    }
//
//    public TopicRecord getResult() {
//        return this.mResult;
//    }
//
//    public int getTopicId() {
//        return this.mTopicId;
//    }
//}
