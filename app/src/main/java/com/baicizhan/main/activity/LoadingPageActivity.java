package com.baicizhan.main.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.models.UserRecord;
import com.baicizhan.client.business.logoload.LogoPageLoading;
import com.baicizhan.client.business.logoload.LogoPageLoading.OnLoadCallback;
import com.baicizhan.client.business.managers.StudyManager;
import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.UMStats;
import com.baicizhan.client.business.stats.operation.OperationStats;
import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.TEnhancedHttpClient;
//import com.baicizhan.client.business.thrift.ThriftRequest;
import com.baicizhan.client.business.util.FileUtils;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.business.util.Profiler;
import com.baicizhan.client.business.util.StorageUtils;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
import com.baicizhan.main.resource.AssetTopicRecordManager;
//import com.baicizhan.main.utils.ApkUtils;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_users.BBCheckInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.baicizhan.online.structs.BELogicException;
import com.jiongji.andriod.card.R;
import java.lang.ref.WeakReference;
//import org.p100a.p101a.p107f.C2120g;

public class LoadingPageActivity extends Activity implements OnLoadCallback {
    public static final String EXTRA_FROM_NOTICE = "from_notice";
    private static final int RESULT_AUTO_LOGIN = 1;
    private static final int RESULT_RELOGIN = 2;
    /* access modifiers changed from: private */
    public static final String TAG = LoadingPageActivity.class.getSimpleName();
    /* access modifiers changed from: private */
    public boolean mDataInited = false;
    /* access modifiers changed from: private */
    public int mDelayedResult = 0;
    private Handler mHandler = new Handler();
    /* access modifiers changed from: private */
    public boolean mLogoLoaded = false;
    private LogoLoadedRun mLogoLoadedRun;
    private LogoPageLoading mLogoLoader = new LogoPageLoading();
    private ImageView mLogoTarget;

    class LogoLoadedRun implements Runnable {
        final WeakReference<LoadingPageActivity> mActivity;

        LogoLoadedRun(LoadingPageActivity loadingPageActivity) {
            this.mActivity = new WeakReference<>(loadingPageActivity);
        }

        public void run() {
            LoadingPageActivity loadingPageActivity = (LoadingPageActivity) this.mActivity.get();
            if (loadingPageActivity != null) {
                loadingPageActivity.mLogoLoaded = true;
                if (loadingPageActivity.mDelayedResult > 0) {
                    loadingPageActivity.tryGoOn(loadingPageActivity.mDelayedResult);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setVolumeControlStream(3);
        statNotice();
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && action != null && action.equals("android.intent.action.MAIN")) {
                LogWrapper.m2797w(TAG, "Main Activity is not the root. Finishing Main Activity instead of launching.");
                finish();
                return;
            }
        }
        setContentView(R.layout.activity_loading_page);
        initViews();
        this.mHandler.post(new Runnable() {
            public void run() {
                LoadingPageActivity.this.loadLogo();
                LoadingPageActivity.this.initData();
                LoadingPageActivity.this.checkInfo();
            }
        });
    }

    private void statNotice() {
        if (getIntent().getBooleanExtra(EXTRA_FROM_NOTICE, false)) {
            OperationStats.statNotify();
        }
    }

    private void initViews() {
        this.mLogoTarget = (ImageView) findViewById(R.id.loading_background);
    }

    /* access modifiers changed from: private */
    public void loadLogo() {
        this.mLogoLoadedRun = new LogoLoadedRun(this);
        this.mLogoLoader.with(this).setTarget(this.mLogoTarget).setCallback(this).load();
    }

    /* access modifiers changed from: private */
    public void initData() {
//        String string = PropertyHelper.getString(PropertyHelper.APP_ROOT);
//        if (TextUtils.isEmpty(string)) {
//            Toast.makeText(this, "路径检测错误", 0).show();
//            finish();
//            return;
//        }
        try {
//            if (StorageUtils.getAvailableBytes(string) < 10485760) {
//                new Builder(this).setTitle((int) R.string.attention).setMessage((CharSequence) getString(R.string.main_insufficient_storage_space, new Object[]{Long.valueOf(10)})).setPositiveButton((int) R.string.main_alert_positive_confirm, (OnClickListener) new OnClickListener() {
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        CommonUtils.killAllProcess(LoadingPageActivity.this);
//                        LoadingPageActivity.this.finish();
//                    }
//                }).setCancelable(false).create().show();
//                return;
//            }
            new AsyncTask<Void, Void, Integer>() {
                /* access modifiers changed from: protected */
                public Integer doInBackground(Void... voidArr) {
                    Profiler profiler = new Profiler();
                    profiler.openFunc(LoadingPageActivity.TAG, "initData");
                    String string = Settings.getString(Settings.PREF_BAICIZHAN_PATH);
                    int i = 0;
//                    while (i < ApkUtils.UNZIP_RAW_FILE_MAP.mo468a()) {
//                        try {
//                            int b = ApkUtils.UNZIP_RAW_FILE_MAP.mo471b(i);
//                            String str = (String) ApkUtils.UNZIP_RAW_FILE_MAP.mo473c(i);
//                            if (str != null) {
//                                if (R.raw.baicizhantotal == b && FileUtils.needUnzipRawFileToSDCard(LoadingPageActivity.this.getResources(), b, string, str)) {
//                                    Settings.setTotalResDBEnabled(false);
//                                }
//                                FileUtils.unzipRawFileToSDCard(LoadingPageActivity.this.getResources(), b, string, str);
//                                if (R.raw.baicizhantotal == b) {
//                                    Settings.setTotalResDBEnabled(true);
//                                }
//                            }
//                            i++;
//                        } catch (Exception e) {
//                            LogWrapper.m2794e(LoadingPageActivity.TAG, Log.getStackTraceString(e));
//                            return Integer.valueOf(-1);
//                        }
//                    }
                    AssetTopicRecordManager.getInstance().init(LoadingPageActivity.this);
                    profiler.openFunc(LoadingPageActivity.TAG, "readScript");
                    String readTextStringFromRaw = FileUtils.readTextStringFromRaw(LoadingPageActivity.this.getResources(), R.raw.learning_strategy);
                    profiler.closeAndPrintFunc(LoadingPageActivity.TAG, "readScript");
                    profiler.openFunc(LoadingPageActivity.TAG, "loadLearningManager");
//                    boolean loadLearningManager = StudyManager.getInstance().loadLearningManager(readTextStringFromRaw);
//                    profiler.closeAndPrintFunc(LoadingPageActivity.TAG, "loadLearningManager");
//                    profiler.closeAndPrintFunc(LoadingPageActivity.TAG, "initData");
//                    if (loadLearningManager) {
//                        return Integer.valueOf(0);
//                    }
                    try {
                        throw new Exception("loadLearningManager failed");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return i;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Integer num) {
                    super.onPostExecute(num);
                    if (num.intValue() == 0) {
                        LoadingPageActivity.this.mDataInited = true;
                        if (LoadingPageActivity.this.mDelayedResult > 0) {
                            LoadingPageActivity.this.tryGoOn(LoadingPageActivity.this.mDelayedResult);
                            return;
                        }
                        return;
                    }
                    Toast.makeText(LoadingPageActivity.this, "初始化数据失败", 0).show();
                    LoadingPageActivity.this.finish();
                }
            }.execute(new Void[0]);
        } catch (Exception e) {
            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
            Toast.makeText(this, "磁盘读写异常,请检查您的sd卡", 0).show();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
//        BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
        this.mHandler.removeCallbacks(this.mLogoLoadedRun);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
//        UMStats.traceOnActivityResume(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
//        UMStats.traceOnActivityPause(this);
    }

    /* access modifiers changed from: private */
    public void checkInfo() {
//        C10294 r0 = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                Profiler profiler = new Profiler();
//                profiler.openFunc(LoadingPageActivity.TAG, "checkInfo");
//                TEnhancedHttpClient httpClient = getHttpClient();
//                httpClient.setConnectTimeout(3000);
//                httpClient.setReadTimeout(3000);
//                httpClient.setMaxRetryCount(1);
//                profiler.openFunc(LoadingPageActivity.TAG, "check_infos");
//                BBCheckInfo check_infos = client.check_infos();
//                profiler.closeAndPrintFunc(LoadingPageActivity.TAG, "check_infos");
//                LogWrapper.m2793d(LoadingPageActivity.TAG, "thrift check_infos " + check_infos);
//                StudyManager.getInstance().setCheckInfo(check_infos);
//                UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//                if (currentUser == null) {
//                    return Integer.valueOf(2);
//                }
////                CommonUtils.login((Context) LoadingPageActivity.this, client, currentUser, 0);
//                profiler.closeAndPrintFunc(LoadingPageActivity.TAG, "login");
//                profiler.closeAndPrintFunc(LoadingPageActivity.TAG, "checkInfo");
//                return Integer.valueOf(1);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                if (exc instanceof BELogicException) {
//                    LogWrapper.m2797w(LoadingPageActivity.TAG, "try relogin, reason " + exc.toString());
//                    Toast.makeText(LoadingPageActivity.this, ((BELogicException) exc).getMessage(), 0).show();
//                } else if (exc instanceof C2120g) {
//                    Log.d(LoadingPageActivity.TAG, Log.getStackTraceString(exc));
//                    if (StudyManager.getInstance().getCurrentUser() != null) {
//                        Toast.makeText(LoadingPageActivity.this, "网络不可用，进入离线模式", 0).show();
//                        StudyManager.getInstance().setIsOfflined(true);
//                        LoadingPageActivity.this.tryGoOn(1);
//                        return;
//                    }
//                    LoadingPageActivity.this.tryGoOn(2);
//                    return;
//                }
//                LoadingPageActivity.this.tryGoOn(2);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                LoadingPageActivity.this.tryGoOn(num.intValue());
//            }
//        };
//        r0.setTag(TAG);
//        BaicizhanThrifts.getProxy().add(r0);
    }

    /* access modifiers changed from: private */
    public void tryGoOn(int i) {
        if (!this.mDataInited || !this.mLogoLoaded) {
            this.mDelayedResult = i;
            return;
        }
//        overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
//        if (i == 1) {
//            startActivity(new Intent(this, MainTabActivity.class));
//        } else {
//            startActivity(new Intent(this, IntroductionPageActivity.class));
//        }
        finish();
    }

    public void onLoaded(boolean z, long j) {
        this.mHandler.postDelayed(this.mLogoLoadedRun, j);
    }

    public void onPreLoaded(boolean z) {
    }

    public void onUpgraded(boolean z) {
    }
}
