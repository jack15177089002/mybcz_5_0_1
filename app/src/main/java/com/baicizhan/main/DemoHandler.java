//package com.baicizhan.main;
//
//import android.content.Context;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.KVHelper;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.helpers.UserRecordHelper;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.dataset.provider.BaicizhanContentProvider;
//import com.baicizhan.client.business.dataset.provider.Contracts;
//import com.baicizhan.client.business.debug.DebugConfig;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.util.FileUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.business.util.Profiler;
//import com.baicizhan.client.business.util.StoragePathDetector;
//import com.baicizhan.client.business.util.StringUtil;
//import com.baicizhan.client.framework.handler.AbstractAppHandler;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.learning_strategy.core.JsRuntime;
//import com.baicizhan.main.upgrade.PackageUtils;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import java.io.File;
//
//public class DemoHandler extends AbstractAppHandler {
//    private static final String TAG = DemoHandler.class.getSimpleName();
//
//    public void onCreate() {
//        Profiler profiler = new Profiler();
//        LogWrapper.setMode(3);
//        profiler.openFunc(TAG, "PropertyHelper.init");
//        PropertyHelper.init();
//        profiler.closeAndPrintFunc(TAG, "PropertyHelper.init");
//        String processName = Common.getProcessName(getApp());
//        if (TextUtils.equals(processName, StoragePathDetector.PACKAGE_NAME)) {
//            LogWrapper.m2793d(TAG, processName);
//            profiler.openFunc(TAG, "onCreate");
//            BaicizhanThrifts.initialize(getApp());
//            profiler.closeAndPrintFunc(TAG, "BaicizhanThrift.init");
//            profiler.openFunc(TAG, "PicassoUtil.init");
//            PicassoUtil.initPicasso(getApp());
//            profiler.closeAndPrintFunc(TAG, "PicassoUtil.init");
//            profiler.openFunc(TAG, "JsRuntime.init");
//            JsRuntime.getInstance().init(-1);
//            profiler.closeAndPrintFunc(TAG, "JsRuntime.init");
//            profiler.openFunc(TAG, "detectAppPath");
//            detectAppPath();
//            profiler.closeAndPrintFunc(TAG, "detectAppPath");
//            profiler.openFunc(TAG, "loadUser");
//            checkDatabaseVersion();
//            loadUser();
//            profiler.closeAndPrintFunc(TAG, "loadUser");
//            readDebugOption();
//            profiler.closeAndPrintFunc(TAG, "onCreate");
//        }
//    }
//
//    private void detectAppPath() {
//        Context applicationContext = getApp().getApplicationContext();
//        String absolutePath = new File(StoragePathDetector.detect(applicationContext)).getAbsolutePath();
//        LogWrapper.m2795i(TAG, "detect app root: " + absolutePath);
//        Settings.putString(Settings.PREF_BAICIZHAN_PATH, absolutePath);
//        applicationContext.getContentResolver().getType(Contracts.getCallMethodUri(BaicizhanContentProvider.METHOD_SET_ROOT, absolutePath));
//        PropertyHelper.put(PropertyHelper.APP_ROOT, absolutePath);
//        PathUtil.init();
//        if (TextUtils.isEmpty(absolutePath)) {
//            throw new RuntimeException("路径检查错误");
//        }
//    }
//
//    private void loadUser() {
//        Context applicationContext = getApp().getApplicationContext();
//        UserRecord currentUserRecord = UserRecordHelper.getCurrentUserRecord(applicationContext);
//        if (currentUserRecord != null) {
//            if (!TextUtils.isEmpty(currentUserRecord.getPassword())) {
//                if (currentUserRecord.getLoginType() == 3) {
//                    currentUserRecord.setPasswordMD5(currentUserRecord.getPassword());
//                } else {
//                    currentUserRecord.setPasswordMD5(StringUtil.md5Hex(currentUserRecord.getPassword(), true));
//                    currentUserRecord.setPassword("");
//                }
//                UserRecordHelper.saveUserRecord(applicationContext, currentUserRecord);
//            }
//            StudyManager.getInstance().setCurrentUser(currentUserRecord);
//        }
//        LogWrapper.m2793d(TAG, "load user in database: " + currentUserRecord);
//    }
//
//    private void checkDatabaseVersion() {
//        Context applicationContext = getApp().getApplicationContext();
//        KVHelper.getLong(applicationContext, KVHelper.KEY_DATABASE_VERSION);
//        KVHelper.setLong(applicationContext, KVHelper.KEY_DATABASE_VERSION, (long) PackageUtils.getPackageVersionCode(applicationContext));
//    }
//
//    private void readDebugOption() {
//        Context applicationContext = getApp().getApplicationContext();
//        if (PackageUtils.isDebug(applicationContext)) {
//            File baicizhanFile = PathUtil.getBaicizhanFile("debug.config");
//            Log.d(TAG, "debug.config path " + baicizhanFile.getAbsolutePath());
//            if (baicizhanFile.exists()) {
//                try {
//                    DebugConfig.setInstance((DebugConfig) new Gson().mo3210a(FileUtils.readTextFile(baicizhanFile, 0, null), DebugConfig.class));
//                    Log.d(TAG, "debug.config " + DebugConfig.getsIntance().toString());
//                } catch (Exception e) {
//                    Toast.makeText(applicationContext, "读取调试配置失败", 0).show();
//                }
//            } else {
//                Log.d(TAG, "debug.config not exists");
//            }
//        }
//    }
//}
