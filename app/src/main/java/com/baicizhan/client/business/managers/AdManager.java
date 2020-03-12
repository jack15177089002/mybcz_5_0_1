//package com.baicizhan.client.business.managers;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask.Listener;
//import com.baicizhan.client.business.download_service.ChannelPriority;
//import com.baicizhan.client.business.download_service.DownloadService;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.framework.BaseAppHandler;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.online.bs_users.BBAdInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import java.io.File;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import org.p100a.p101a.p107f.C2120g;
//import p012ch.qos.logback.core.CoreConstants;
//
//public class AdManager {
//    public static final String AD_IMAGE_SUFFIX = ".loadingbaicizhan";
//    /* access modifiers changed from: private */
//    public static final String TAG = AdManager.class.getSimpleName();
//    private static AdManager sInstance = null;
//    private List<BBAdInfo> mAllAdInfos = Collections.emptyList();
//    /* access modifiers changed from: private */
//    public Map<Integer, BBAdInfo> mAvailableAdInfos = new ArrayMap();
//    /* access modifiers changed from: private */
//    public Map<String, List<BBAdInfo>> mDownloadingSlots = new ConcurrentHashMap();
//    private int mShowIndex = 0;
//    private List<Integer> mShowOrder = Collections.emptyList();
//
//    class AdDownloadTask extends AbstractDownloadTask {
//        private String mImageUrl;
//
//        public AdDownloadTask(String str) {
//            this.mImageUrl = str;
//        }
//
//        public String toString() {
//            return "AdDownloadTask{mImageUrl='" + this.mImageUrl + CoreConstants.SINGLE_QUOTE_CHAR + CoreConstants.CURLY_RIGHT;
//        }
//
//        public Object getUniqueKey() {
//            return null;
//        }
//
//        public String getImageUrl() {
//            return this.mImageUrl;
//        }
//
//        /* access modifiers changed from: protected */
//        public void run() {
//            try {
//                File download = this.mDownloader.download(this.mImageUrl, PathUtil.getBaicizhanFile(AdManager.urlToFileName(this.mImageUrl)).getAbsolutePath());
//                File adImageFile = AdManager.getAdImageFile(this.mImageUrl);
//                if (adImageFile.exists()) {
//                    adImageFile.delete();
//                }
//                download.renameTo(adImageFile);
//                postSuccess();
//            } catch (Exception e) {
//                postError(e);
//            }
//        }
//    }
//
//    public static AdManager getInstance() {
//        if (sInstance == null) {
//            synchronized (AdManager.class) {
//                if (sInstance == null) {
//                    sInstance = new AdManager();
//                }
//            }
//        }
//        return sInstance;
//    }
//
//    public void init(Client client) {
//        try {
//            this.mAllAdInfos = client.get_ads_list();
//            this.mShowOrder = client.get_show_ads();
//            this.mDownloadingSlots.clear();
//            downloadAll();
//            this.mShowIndex = Settings.getInt(Settings.PREF_AD_SHOW_INDEX);
//        } catch (Exception e) {
//            if (!(e instanceof C2120g)) {
//                LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public static String urlToFileName(String str) {
//        String trim = str.trim();
//        try {
//            if (trim.startsWith("http")) {
//                return new File(new URL(trim).getFile()).getName();
//            }
//            return trim;
//        } catch (Exception e) {
//            return trim;
//        }
//    }
//
//    public static File getAdImageFile(String str) {
//        return PathUtil.getBaicizhanResourceFile(urlToFileName(str), AD_IMAGE_SUFFIX);
//    }
//
//    private synchronized void downloadAll() {
//        for (BBAdInfo bBAdInfo : this.mAllAdInfos) {
//            File adImageFile = getAdImageFile(bBAdInfo.getImage_url());
//            if (adImageFile == null || !adImageFile.exists() || adImageFile.length() <= 0) {
//                List list = (List) this.mDownloadingSlots.get(bBAdInfo.getImage_url());
//                if (list == null) {
//                    list = new ArrayList();
//                    this.mDownloadingSlots.put(bBAdInfo.getImage_url(), list);
//                }
//                list.add(bBAdInfo);
//            } else {
//                this.mAvailableAdInfos.put(Integer.valueOf(bBAdInfo.getAd_id()), bBAdInfo);
//            }
//        }
//        if (NetworkUtils.isWiFiConnected(BaseAppHandler.getApp())) {
//            for (String adDownloadTask : this.mDownloadingSlots.keySet()) {
//                AdDownloadTask adDownloadTask2 = new AdDownloadTask(adDownloadTask);
//                LogWrapper.m2796v(TAG, "add " + adDownloadTask2);
//                adDownloadTask2.setListener(new Listener() {
//                    public void onSuccess(AbstractDownloadTask abstractDownloadTask) {
//                        synchronized (this) {
//                            List<BBAdInfo> list = (List) AdManager.this.mDownloadingSlots.get(((AdDownloadTask) abstractDownloadTask).getImageUrl());
//                            if (list != null) {
//                                for (BBAdInfo bBAdInfo : list) {
//                                    AdManager.this.mAvailableAdInfos.put(Integer.valueOf(bBAdInfo.getAd_id()), bBAdInfo);
//                                }
//                                LogWrapper.m2796v(AdManager.TAG, "ad download success " + TextUtils.join(",", list));
//                            }
//                        }
//                    }
//
//                    public void onError(AbstractDownloadTask abstractDownloadTask, Throwable th) {
//                        LogWrapper.m2794e(AdManager.TAG, Log.getStackTraceString(th));
//                    }
//                });
//                DownloadService.getInstance().add(ChannelPriority.LOW, adDownloadTask2);
//            }
//        }
//    }
//
//    public BBAdInfo fetchOneAd() {
//        int i;
//        if (CollectionUtils.isEmpty(this.mAvailableAdInfos) || CollectionUtils.isEmpty((Collection<?>) this.mShowOrder)) {
//            return null;
//        }
//        if (this.mShowIndex < 0 || this.mShowIndex >= this.mShowOrder.size()) {
//            this.mShowIndex = 0;
//        }
//        for (int i2 = 0; i2 < this.mShowOrder.size(); i2++) {
//            if (((Integer) this.mShowOrder.get(this.mShowIndex)).intValue() == -1) {
//                return null;
//            }
//            BBAdInfo bBAdInfo = (BBAdInfo) this.mAvailableAdInfos.get(this.mShowOrder.get(this.mShowIndex));
//            if (this.mShowIndex + 1 >= this.mShowOrder.size()) {
//                i = 0;
//            } else {
//                i = this.mShowIndex + 1;
//            }
//            this.mShowIndex = i;
//            if (bBAdInfo != null) {
//                Settings.putInt(Settings.PREF_AD_SHOW_INDEX, this.mShowIndex);
//                return bBAdInfo;
//            }
//        }
//        return null;
//    }
//}
