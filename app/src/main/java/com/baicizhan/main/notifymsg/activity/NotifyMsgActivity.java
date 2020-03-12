//package com.baicizhan.main.notifymsg.activity;
//
//import android.content.AsyncQueryHandler;
//import android.content.ContentResolver;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.p004v4.app.FragmentActivity;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.webkit.CookieManager;
//import android.webkit.CookieSyncManager;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.thrift.TEnhancedHttpClient;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.main.notifymsg.data.NotifyMsgRecord;
//import com.baicizhan.main.notifymsg.data.NotifyMsgRecordHelper;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.HashMap;
//
//public class NotifyMsgActivity extends FragmentActivity implements OnClickListener {
//    private static final String ARG_MESSAGE = "message";
//    private static final String ARG_TOKEN = "token";
//    private static final String BAICIZHAN_HOST_SUFFIX = ".baicizhan.com";
//    private static final String PARAM_SUFFIX = "?inbczapp=android";
//    /* access modifiers changed from: private */
//    public TextView mFailedTip;
//    private Handler mHandler = new Handler();
//    /* access modifiers changed from: private */
//    public NotifyMsgRecord mMessage;
//    private MessageClient mMessageClient;
//    /* access modifiers changed from: private */
//    public ProgressBar mProgress;
//    private ProgressRun mProgressRun;
//    /* access modifiers changed from: private */
//    public View mShare;
//    private String mToken;
//    /* access modifiers changed from: private */
//    public WebView mWebView;
//
//    class MessageClient extends WebViewClient {
//        final WeakReference<NotifyMsgActivity> mActivity;
//
//        private MessageClient(NotifyMsgActivity notifyMsgActivity) {
//            this.mActivity = new WeakReference<>(notifyMsgActivity);
//        }
//
//        public void onPageFinished(WebView webView, String str) {
//            NotifyMsgActivity notifyMsgActivity = (NotifyMsgActivity) this.mActivity.get();
//            if (notifyMsgActivity != null) {
//                notifyMsgActivity.progressToEnd();
//                notifyMsgActivity.mWebView.setVisibility(0);
//                notifyMsgActivity.mShare.setVisibility(0);
//                notifyMsgActivity.mMessage.setRead(1);
//                NotifyMsgRecordHelper.asyncUpdate(new UpdateReadHandler(notifyMsgActivity.getContentResolver()), notifyMsgActivity.mMessage);
//            }
//        }
//
//        public void onReceivedError(WebView webView, int i, String str, String str2) {
//            NotifyMsgActivity notifyMsgActivity = (NotifyMsgActivity) this.mActivity.get();
//            if (notifyMsgActivity != null) {
//                notifyMsgActivity.progressToEnd();
//                notifyMsgActivity.mFailedTip.setVisibility(0);
//                notifyMsgActivity.mWebView.setWebViewClient(null);
//            }
//        }
//    }
//
//    class ProgressRun implements Runnable {
//        final WeakReference<NotifyMsgActivity> mActivity;
//
//        ProgressRun(NotifyMsgActivity notifyMsgActivity) {
//            this.mActivity = new WeakReference<>(notifyMsgActivity);
//        }
//
//        public void run() {
//            NotifyMsgActivity notifyMsgActivity = (NotifyMsgActivity) this.mActivity.get();
//            if (notifyMsgActivity != null) {
//                int progress = notifyMsgActivity.mProgress.getProgress();
//                if (progress < 950) {
//                    notifyMsgActivity.mProgress.setProgress(progress + 2);
//                    notifyMsgActivity.mProgress.setVisibility(0);
//                    notifyMsgActivity.accumProgress();
//                }
//            }
//        }
//    }
//
//    class UpdateReadHandler extends AsyncQueryHandler {
//        public UpdateReadHandler(ContentResolver contentResolver) {
//            super(contentResolver);
//        }
//    }
//
//    public static void start(Context context, NotifyMsgRecord notifyMsgRecord, String str) {
//        Intent intent = new Intent(context, NotifyMsgActivity.class);
//        intent.putExtra(ARG_MESSAGE, notifyMsgRecord);
//        intent.putExtra("token", str);
//        context.startActivity(intent);
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView(R.layout.notify_message_content);
//        if (bundle != null) {
//            this.mMessage = (NotifyMsgRecord) bundle.getParcelable(ARG_MESSAGE);
//            this.mToken = bundle.getString("token");
//        } else {
//            this.mMessage = (NotifyMsgRecord) getIntent().getParcelableExtra(ARG_MESSAGE);
//            this.mToken = getIntent().getStringExtra("token");
//        }
//        initViews();
//        startLoad();
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putParcelable(ARG_MESSAGE, this.mMessage);
//        bundle.putString("token", this.mToken);
//    }
//
//    private void initViews() {
//        findViewById(R.id.notify_msg_back).setOnClickListener(this);
//        this.mShare = findViewById(R.id.notify_msg_share);
//        this.mShare.setOnClickListener(this);
//        this.mFailedTip = (TextView) findViewById(R.id.notify_msg_load_failed);
//        this.mFailedTip.setOnClickListener(this);
//        this.mWebView = (WebView) findViewById(R.id.notify_msg_webcontent);
//        this.mWebView.setVisibility(8);
//        this.mMessageClient = new MessageClient();
//        this.mProgress = (ProgressBar) findViewById(R.id.notify_msg_loading_progress);
//        this.mProgress.setMax(1000);
//        this.mProgressRun = new ProgressRun(this);
//        TextView textView = (TextView) findViewById(R.id.notify_msg_title);
//        switch (this.mMessage.getType()) {
//            case 1:
//                textView.setText(R.string.notify_msg_type_system);
//                return;
//            case 2:
//                textView.setText(R.string.notify_msg_type_activity);
//                return;
//            case 3:
//                textView.setText(R.string.notify_msg_type_baoguo);
//                return;
//            default:
//                return;
//        }
//    }
//
//    private void startLoad() {
//        this.mFailedTip.setVisibility(8);
//        this.mWebView.getSettings().setAppCacheMaxSize(8388608);
//        if (getCacheDir() != null) {
//            this.mWebView.getSettings().setAppCachePath(getCacheDir().getAbsolutePath());
//        }
//        this.mWebView.getSettings().setAppCacheEnabled(true);
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            this.mWebView.getSettings().setCacheMode(-1);
//        } else {
//            this.mWebView.getSettings().setCacheMode(1);
//        }
//        this.mWebView.getSettings().setJavaScriptEnabled(true);
//        this.mWebView.setWebViewClient(this.mMessageClient);
//        loadWithCookie(this, this.mWebView, this.mMessage.getContentUrl() + PARAM_SUFFIX, this.mToken);
//        this.mProgress.setProgress(0);
//        accumProgress();
//    }
//
//    private static void loadWithCookie(Context context, WebView webView, String str, String str2) {
//        if (TextUtils.isEmpty(str2)) {
//            webView.loadUrl(str);
//            return;
//        }
//        try {
//            String host = new URL(str).getHost();
//            if (TextUtils.isEmpty(host) || !host.endsWith(BAICIZHAN_HOST_SUFFIX)) {
//                webView.loadUrl(str);
//                return;
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        String str3 = "bcz_notify_token=" + str2;
//        CookieSyncManager.createInstance(context);
//        CookieManager instance = CookieManager.getInstance();
//        instance.setAcceptCookie(true);
//        instance.removeSessionCookie();
//        instance.setCookie(str, str3);
//        CookieSyncManager.getInstance().sync();
//        HashMap hashMap = new HashMap();
//        hashMap.put(TEnhancedHttpClient.COOKIE_HEADER_KEY, str3);
//        webView.loadUrl(str, hashMap);
//    }
//
//    private static void removeCookie(Context context) {
//        CookieSyncManager.createInstance(context);
//        CookieManager.getInstance().removeSessionCookie();
//        CookieSyncManager.getInstance().sync();
//    }
//
//    private void share() {
//        ShareDialogFragment.newInstance(this.mMessage).show(getSupportFragmentManager(), "message_share");
//        OperationStats.statNotificationShare(this.mMessage.getId());
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        removeCookie(this);
//        this.mHandler.removeCallbacks(this.mProgressRun);
//        System.gc();
//        OperationStats.getInstance().stat(this);
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.notify_msg_back /*2131296778*/:
//                finish();
//                return;
//            case R.id.notify_msg_share /*2131296780*/:
//                share();
//                return;
//            case R.id.notify_msg_load_failed /*2131296781*/:
//                startLoad();
//                return;
//            default:
//                return;
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void progressToEnd() {
//        this.mProgress.setProgress(1000);
//        this.mProgress.postDelayed(new Runnable() {
//            public void run() {
//                NotifyMsgActivity.this.mProgress.setVisibility(8);
//            }
//        }, 300);
//    }
//
//    /* access modifiers changed from: private */
//    public void accumProgress() {
//        int i = 25;
//        if (this.mProgress.getProgress() > 500) {
//            i = 100;
//        }
//        this.mHandler.postDelayed(this.mProgressRun, (long) i);
//    }
//}
