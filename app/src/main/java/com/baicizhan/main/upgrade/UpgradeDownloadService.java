//package com.baicizhan.main.upgrade;
//
//import android.annotation.TargetApi;
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.net.Uri;
//import android.os.Build.VERSION;
//import android.os.IBinder;
//import android.util.Log;
//import android.widget.RemoteViews;
//import android.widget.Toast;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.http.download.DownloadManager;
//import com.baicizhan.client.framework.network.http.download.IDownloadManager.DownloadCallback;
//import com.baicizhan.client.framework.network.http.download.IDownloadManager.State;
//import com.baicizhan.main.activity.MainTabActivity;
//import com.jiongji.andriod.card.R;
//import java.io.File;
//import java.util.List;
//import java.util.Locale;
//
//public class UpgradeDownloadService extends Service {
//    public static final String ACTION_UPGRADE_DOWNLOAD = "com.jiongji.andriod.card.action.UPGRADE_DOWNLOAD";
//    public static final String ACTION_UPGRADE_INSTALL = "com.jiongji.andriod.card.action.UPGRADE_INSTALL";
//    public static final String ACTION_UPGRADE_STOP = "com.jiongji.andriod.card.action.UPGRADE_STOP";
//    public static final String EXTRA_UPGRADE_APP_MD5 = "app_md5";
//    public static final String EXTRA_UPGRADE_APP_PATH = "app_path";
//    public static final String EXTRA_UPGRADE_APP_URL = "app_url";
//    public static final String PREFS_NAME = "APKUpgradeManager";
//    public static final String PREF_UPGRADE_APP_MD5 = "www.baicizhan.com.upgrade.last_app_md5";
//    public static final String PREF_UPGRADE_APP_PATH = "www.baicizhan.com.upgrade.last_app_path";
//    public static final String PREF_UPGRADE_STATUS = "www.baicizhan.com.upgrade.last_app_status";
//    private static final String TAG = UpgradeDownloadService.class.getSimpleName();
//    private static final int UPGRADE_PROGRESS_NOTIFICATION_ID = 1;
//    /* access modifiers changed from: private */
//    public String mAppMD5;
//    /* access modifiers changed from: private */
//    public String mAppPath;
//    private String mAppURL;
//    private DownloadCallback mDownloadCallback = new Callback();
//    private DownloadManager mDownloadManager = new DownloadManager();
//    /* access modifiers changed from: private */
//    public Notification mNotification;
//    /* access modifiers changed from: private */
//    public NotificationManager mNotificationManager;
//    /* access modifiers changed from: private */
//    public SharedPreferences mSettings;
//    /* access modifiers changed from: private */
//    public RemoteViews mStatusline;
//    /* access modifiers changed from: private */
//    public boolean mStickyStart = false;
//
//    class Callback implements DownloadCallback {
//        private Callback() {
//        }
//
//        public void onStop() {
//            C0789L.log.debug("onStop");
//            if (UpgradeDownloadService.this.mStickyStart) {
//                UpgradeDownloadService.this.mStickyStart = false;
//                UpgradeDownloadService.this.startDownload();
//            }
//        }
//
//        public void onStartDecompress() {
//        }
//
//        public void onStart() {
//            C0789L.log.debug("onStart");
//            UpgradeDownloadService.this.mSettings.edit().putString(UpgradeDownloadService.PREF_UPGRADE_APP_MD5, UpgradeDownloadService.this.mAppMD5).putString(UpgradeDownloadService.PREF_UPGRADE_APP_PATH, UpgradeDownloadService.this.mAppPath).putInt(UpgradeDownloadService.PREF_UPGRADE_STATUS, 1).apply();
//            C0789L.log.debug("set upgrade status 1");
//            UpgradeDownloadService.this.mStatusline.setTextViewText(R.id.title, "正在下载百词斩");
//            UpgradeDownloadService.this.mStatusline.setTextViewText(R.id.info, "已下载  0%");
//            UpgradeDownloadService.this.mStatusline.setOnClickPendingIntent(R.id.close, PendingIntent.getService(UpgradeDownloadService.this, 0, new Intent(UpgradeDownloadService.this, UpgradeDownloadService.class).setAction(UpgradeDownloadService.ACTION_UPGRADE_STOP), 134217728));
//            UpgradeDownloadService.this.mNotification.contentView = UpgradeDownloadService.this.mStatusline;
//            UpgradeDownloadService.this.mNotification.tickerText = "正在下载百词斩";
//            UpgradeDownloadService.this.mNotification.icon = VERSION.SDK_INT >= 21 ? R.drawable.ic_baicizhan_white : R.drawable.ic_baicizhan;
//            Notification access$700 = UpgradeDownloadService.this.mNotification;
//            access$700.flags |= 16;
//            UpgradeDownloadService.this.mNotification.defaults = 4;
//            UpgradeDownloadService.this.mNotification.when = System.currentTimeMillis();
//            UpgradeDownloadService.this.mNotification.contentIntent = PendingIntent.getActivity(UpgradeDownloadService.this, 0, new Intent(UpgradeDownloadService.this, MainTabActivity.class), 134217728);
//            UpgradeDownloadService.this.mNotificationManager.notify(1, UpgradeDownloadService.this.mNotification);
//        }
//
//        public void onResume() {
//        }
//
//        public void onProgress(int i) {
//            C0789L.log.debug("onProgress " + i);
//            if (UpgradeDownloadService.this.mStatusline != null) {
//                UpgradeDownloadService.this.mStatusline.setProgressBar(R.id.progress, 100, i, false);
//                UpgradeDownloadService.this.mStatusline.setTextViewText(R.id.info, String.format(Locale.US, "已下载 %2d%%", new Object[]{Integer.valueOf(i)}));
//                UpgradeDownloadService.this.mNotificationManager.notify(1, UpgradeDownloadService.this.mNotification);
//            }
//        }
//
//        public void onPause() {
//            C0789L.log.debug("onPause");
//        }
//
//        public void onGroupComplete(boolean z, List<String> list, int i) {
//        }
//
//        public void onComplete(boolean z, String str, int i) {
//            C0789L.log.debug("onComplete");
//            if (z) {
//                if (UpgradeDownloadService.this.mStatusline != null) {
//                    UpgradeDownloadService.this.mStatusline.setProgressBar(R.id.progress, 100, 100, false);
//                    UpgradeDownloadService.this.mStatusline.setTextViewText(R.id.info, "下载完成，请点击安装");
//                    UpgradeDownloadService.this.mNotification.contentIntent = PendingIntent.getService(UpgradeDownloadService.this, 0, new Intent(UpgradeDownloadService.this, UpgradeDownloadService.class).setAction(UpgradeDownloadService.ACTION_UPGRADE_INSTALL), 134217728);
//                    UpgradeDownloadService.this.mNotificationManager.notify(1, UpgradeDownloadService.this.mNotification);
//                }
//                UpgradeDownloadService.this.mSettings.edit().putInt(UpgradeDownloadService.PREF_UPGRADE_STATUS, 2).apply();
//                C0789L.log.debug("set upgrade status 2");
//                UpgradeDownloadService.this.installApp();
//                return;
//            }
//            Toast.makeText(UpgradeDownloadService.this, "下载失败，请稍后重试", 0).show();
//            UpgradeDownloadService.this.mSettings.edit().putString(UpgradeDownloadService.PREF_UPGRADE_APP_MD5, "").putString(UpgradeDownloadService.PREF_UPGRADE_APP_PATH, "").putInt(UpgradeDownloadService.PREF_UPGRADE_STATUS, 0).apply();
//            C0789L.log.debug("set upgrade status 0");
//        }
//    }
//
//    public class ServiceStatus {
//        public static final int DOWNLOADING = 1;
//        public static final int IDLE = 0;
//        public static final int SUCCESS = 2;
//    }
//
//    public static SharedPreferences openPreference(Context context) {
//        if (VERSION.SDK_INT >= 11) {
//            return openPreferenceHoneyComb(context);
//        }
//        return context.getSharedPreferences(PREFS_NAME, 0);
//    }
//
//    @TargetApi(11)
//    private static SharedPreferences openPreferenceHoneyComb(Context context) {
//        return context.getSharedPreferences(PREFS_NAME, 4);
//    }
//
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        C0789L.log.info("onCreate");
//        this.mSettings = openPreference(this);
//        this.mNotificationManager = (NotificationManager) getSystemService("notification");
//        this.mDownloadManager.setCallback(this.mDownloadCallback);
//        this.mStatusline = new RemoteViews(getPackageName(), R.layout.notification_upgrade_download);
//        this.mNotification = new Notification();
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        C0789L.log.info("onDestroy");
//        this.mDownloadManager.stop();
//        this.mDownloadManager.setCallback(null);
//        resetPrefs();
//    }
//
//    private void resetPrefs() {
//        this.mSettings.edit().putString(PREF_UPGRADE_APP_MD5, "").putString(PREF_UPGRADE_APP_PATH, "").putInt(PREF_UPGRADE_STATUS, 0).apply();
//    }
//
//    public int onStartCommand(Intent intent, int i, int i2) {
//        String action = intent.getAction();
//        C0789L.log.info("onStartCommand " + action);
//        if (action.equals(ACTION_UPGRADE_DOWNLOAD)) {
//            this.mAppURL = intent.getStringExtra(EXTRA_UPGRADE_APP_URL);
//            this.mAppMD5 = intent.getStringExtra(EXTRA_UPGRADE_APP_MD5);
//            this.mAppPath = intent.getStringExtra(EXTRA_UPGRADE_APP_PATH);
//            if (canContinueLastDownload()) {
//                startDownload();
//            } else if (this.mDownloadManager.currentState() == State.Downloading) {
//                resetPrefs();
//                this.mStickyStart = true;
//                this.mDownloadManager.stop();
//            } else {
//                removeLocalAPK();
//                startDownload();
//            }
//        } else {
//            if (action.equals(ACTION_UPGRADE_STOP)) {
//                resetPrefs();
//                this.mDownloadManager.stop();
//            } else if (action.equals(ACTION_UPGRADE_INSTALL)) {
//                this.mAppPath = this.mSettings.getString(PREF_UPGRADE_APP_PATH, "");
//                Log.d(TAG, "try install " + this.mAppPath);
//                if (!new File(this.mAppPath).exists()) {
//                    Toast.makeText(this, "找不到安装包", 0).show();
//                } else {
//                    installApp();
//                }
//            }
//            this.mNotificationManager.cancel(1);
//            stopSelf();
//        }
//        return 2;
//    }
//
//    private boolean canContinueLastDownload() {
//        return this.mSettings.getString(PREF_UPGRADE_APP_PATH, "").equals(this.mAppPath) && this.mSettings.getString(PREF_UPGRADE_APP_MD5, "").equals(this.mAppMD5);
//    }
//
//    /* access modifiers changed from: private */
//    public void startDownload() {
//        this.mDownloadManager.setUrl(this.mAppURL).setDestPath(this.mAppPath).setBackoffPolicy(new ExponentialBackoffPolicy(3000, 2.0f)).setCallback(this.mDownloadCallback).start();
//        C0789L.log.debug("set upgrade status 0");
//    }
//
//    public void removeLocalAPK() {
//        this.mDownloadManager.stop();
//        C0789L.log.debug("remove apk " + this.mAppPath);
//        try {
//            File file = new File(this.mAppPath);
//            if (file.exists()) {
//                file.delete();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void installApp() {
//        Intent intent = new Intent();
//        intent.setFlags(268435456);
//        intent.setAction("android.intent.action.VIEW");
//        intent.setDataAndType(Uri.fromFile(new File(this.mAppPath)), "application/vnd.android.package-archive");
//        startActivity(intent);
//    }
//}
