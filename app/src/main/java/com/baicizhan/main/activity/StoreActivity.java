//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.content.pm.ResolveInfo;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import java.util.Locale;
//
//public class StoreActivity extends Activity {
//    private static final String ARGS_URL = "url";
//    public static final String EXTRA_FROM = "extra_from";
//    public static final String FROM_CART = "cart";
//    private static final int TYPE_LOADING = 0;
//    private static final int TYPE_SHOW_CONTENT = 1;
//    /* access modifiers changed from: private */
//    public LoadingHandler mHandler;
//    /* access modifiers changed from: private */
//    public Jump2SingleAppRun mJump2SingleAppRun;
//    /* access modifiers changed from: private */
//    public Handler mJumpHandler = new Handler();
//    private NetworkStateReceiver mNetworkStateReceiver = new NetworkStateReceiver();
//    /* access modifiers changed from: private */
//    public ProgressBar mProgress;
//    private ProgressRun mProgressRun = new ProgressRun();
//    /* access modifiers changed from: private */
//    public WebView mStorePage;
//    /* access modifiers changed from: private */
//    public TextView mStoreTip;
//
//    class Jump2SingleAppRun implements Runnable {
//        private final String url;
//
//        Jump2SingleAppRun(String str) {
//            this.url = str;
//        }
//
//        public void run() {
//            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.url));
//            if (!StoreActivity.this.try2JumpSingleApp(intent, true) && !StoreActivity.this.try2JumpSingleApp(intent, false)) {
//                StoreActivity.this.startActivity(intent);
//            }
//        }
//    }
//
//    class LoadingHandler extends Handler {
//        final WeakReference<StoreActivity> mActivity;
//
//        LoadingHandler(StoreActivity storeActivity) {
//            this.mActivity = new WeakReference<>(storeActivity);
//        }
//
//        public void handleMessage(Message message) {
//            StoreActivity storeActivity = (StoreActivity) this.mActivity.get();
//            if (storeActivity != null) {
//                switch (message.what) {
//                    case 0:
//                        storeActivity.cancelShowLoading();
//                        storeActivity.mStorePage.setVisibility(8);
//                        storeActivity.mStoreTip.setText(R.string.main_store_loading);
//                        return;
//                    case 1:
//                        storeActivity.mStorePage.setVisibility(0);
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    class NetworkStateReceiver extends BroadcastReceiver {
//        private NetworkStateReceiver() {
//        }
//
//        public void onReceive(Context context, Intent intent) {
//            if (!intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
//                return;
//            }
//            if (NetworkUtils.isNetworkAvailable(StoreActivity.this)) {
//                StoreActivity.this.mStorePage.getSettings().setCacheMode(-1);
//            } else {
//                StoreActivity.this.mStorePage.getSettings().setCacheMode(1);
//            }
//        }
//    }
//
//    class ProgressRun implements Runnable {
//        private ProgressRun() {
//        }
//
//        public void run() {
//            int progress = StoreActivity.this.mProgress.getProgress();
//            if (progress < 90) {
//                StoreActivity.this.mProgress.setProgress(progress + 5);
//                StoreActivity.this.mHandler.postDelayed(this, 100);
//            }
//        }
//    }
//
//    class StorePageClient extends WebViewClient {
//        private boolean mErr;
//        private String mErrUrl;
//
//        private StorePageClient() {
//            this.mErr = false;
//            this.mErrUrl = "";
//        }
//
//        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
//            StoreActivity.this.notifyLoading(300);
//            if (!str.equals(this.mErrUrl)) {
//                this.mErr = false;
//                this.mErrUrl = "";
//            }
//        }
//
//        public void onPageFinished(WebView webView, String str) {
//            StoreActivity.this.cancelLoading();
//            if (!this.mErr) {
//                StoreActivity.this.notifyShowLoading(200);
//            }
//        }
//
//        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
//            Log.d("whiz", "override url：" + str);
//            if (!str.startsWith("http://item.taobao.com") && !str.startsWith("http://h5.m.taobao.com/") && !str.startsWith("http://ai.taobao.com") && !str.startsWith("http://ai.m.taobao.com") && !str.startsWith("http://shop.m.taobao.com")) {
//                return false;
//            }
//            StoreActivity.this.progressToEnd();
//            StoreActivity.this.mJump2SingleAppRun = new Jump2SingleAppRun(str);
//            StoreActivity.this.mJumpHandler.post(StoreActivity.this.mJump2SingleAppRun);
//            return true;
//        }
//
//        public void onReceivedError(WebView webView, int i, String str, String str2) {
//            StoreActivity.this.cancelShowLoading();
//            StoreActivity.this.mStorePage.setVisibility(8);
//            StoreActivity.this.mProgress.setVisibility(4);
//            StoreActivity.this.mStoreTip.setText(R.string.main_store_not_found);
//            this.mErr = true;
//            this.mErrUrl = str2;
//        }
//    }
//
//    public static void start(Context context, String str) {
//        Intent intent = new Intent(context, StoreActivity.class);
//        intent.putExtra(ARGS_URL, str);
//        context.startActivity(intent);
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.main_store);
//            String stringExtra = getIntent().getStringExtra(ARGS_URL);
//            this.mHandler = new LoadingHandler(this);
//            this.mStoreTip = (TextView) findViewById(R.id.main_store_tip);
//            this.mStorePage = (WebView) findViewById(R.id.main_store_webpage);
//            this.mStorePage.setVisibility(8);
//            this.mStorePage.getSettings().setAppCacheMaxSize(8388608);
//            this.mStorePage.getSettings().setAppCachePath(getCacheDir().getAbsolutePath());
//            this.mStorePage.getSettings().setAppCacheEnabled(true);
//            if (NetworkUtils.isNetworkAvailable(this)) {
//                this.mStorePage.getSettings().setCacheMode(-1);
//            } else {
//                this.mStorePage.getSettings().setCacheMode(1);
//            }
//            this.mStorePage.setWebViewClient(new StorePageClient());
//            this.mStorePage.loadUrl(stringExtra);
//            this.mProgress = (ProgressBar) findViewById(R.id.main_store_load_prog);
//            this.mHandler.postDelayed(this.mProgressRun, 100);
//        }
//    }
//
//    private static String getFrom(Intent intent, Bundle bundle) {
//        if (bundle != null) {
//            return bundle.getString(EXTRA_FROM);
//        }
//        if (intent != null) {
//            return intent.getStringExtra(EXTRA_FROM);
//        }
//        return null;
//    }
//
//    private static String getUrl(String str) {
//        String format = String.format(Locale.CHINA, "http://www.baicizhan.com/api/shop_ad?access_token=%s&word_level_id=%d&from=%s", new Object[]{StudyManager.getInstance().getCurrentUser().getToken(), Integer.valueOf(StudyManager.getInstance().getCurrentBookId()), str});
//        C0789L.log.info("baicizhan store url [{}]", (Object) format);
//        return format;
//    }
//
//    /* access modifiers changed from: private */
//    public void progressToEnd() {
//        this.mHandler.removeCallbacks(this.mProgressRun);
//        this.mHandler = new LoadingHandler(this);
//        this.mProgress.setProgress(100);
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putString(EXTRA_FROM, FROM_CART);
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//        registerReceiver(this.mNetworkStateReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
//    }
//
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//        unregisterReceiver(this.mNetworkStateReceiver);
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        cancelLoading();
//        cancelShowLoading();
//        cancelProgressRun();
//        cancelJump2SingleAppRun();
//    }
//
//    /* access modifiers changed from: private */
//    public boolean try2JumpSingleApp(Intent intent, boolean z) {
//        for (ResolveInfo resolveInfo : getPackageManager().queryIntentActivities(intent, 0)) {
//            if (!resolveInfo.activityInfo.packageName.startsWith("com.taobao")) {
//                if (!z) {
//                }
//            }
//            intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
//            Log.d("whiz", "jump to taobao");
//            startActivity(intent);
//            finish();
//            return true;
//        }
//        return false;
//    }
//
//    public boolean onKeyDown(int i, KeyEvent keyEvent) {
//        if (!this.mStorePage.canGoBack()) {
//            return super.onKeyDown(i, keyEvent);
//        }
//        if (this.mStorePage.getVisibility() != 0) {
//            notifyShowLoading(300);
//        }
//        this.mStorePage.goBack();
//        return false;
//    }
//
//    /* access modifiers changed from: private */
//    public void notifyLoading(long j) {
//        this.mHandler.sendEmptyMessageDelayed(0, j);
//    }
//
//    /* access modifiers changed from: private */
//    public void cancelLoading() {
//        this.mHandler.removeMessages(0);
//    }
//
//    /* access modifiers changed from: private */
//    public void notifyShowLoading(long j) {
//        this.mHandler.sendEmptyMessageDelayed(1, j);
//    }
//
//    /* access modifiers changed from: private */
//    public void cancelShowLoading() {
//        this.mHandler.removeMessages(1);
//    }
//
//    private void cancelProgressRun() {
//        this.mHandler.removeCallbacks(this.mProgressRun);
//    }
//
//    private void cancelJump2SingleAppRun() {
//        if (this.mJump2SingleAppRun != null) {
//            this.mJumpHandler.removeCallbacks(this.mJump2SingleAppRun);
//        }
//    }
//}
