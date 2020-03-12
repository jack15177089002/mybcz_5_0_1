//package com.baicizhan.main.upgrade;
//
//import android.annotation.TargetApi;
//import android.app.Activity;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Build;
//import android.os.Build.VERSION;
//import android.support.p004v4.content.ContextCompat;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.Toast;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.usr.User;
//import com.baicizhan.client.business.usr.UserAsyncTask;
//import com.baicizhan.client.business.usr.UserLoadHandler;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.framework.network.GsonRequest;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.io.File;
//import java.lang.ref.WeakReference;
//import java.lang.reflect.Type;
//import java.util.Locale;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class UpgradeManager {
//    private static final String ANDROID = "android";
//    private static final String POST_APP_CHANNEL = "app_channel";
//    private static final String POST_APP_NAME = "app_name";
//    private static final String POST_DEVICE_ID = "device_id";
//    private static final String POST_DEVICE_MANUFACTURER = "device_manufacturer";
//    private static final String POST_DEVICE_MODEL = "device_model";
//    private static final String POST_OS_NAME = "os_name";
//    private static final String POST_OS_SDK = "os_sdk";
//    private static final String POST_USER_POSITION = "user_position";
//    private static final String POST_USER_TOKEN = "token";
//    public static String TAG = UpgradeManager.class.getSimpleName();
//    private static final String UPGRADE_APP_NAME = "baicizhan.apk";
//    private static final String UPGRADE_CHECK_URL = "http://www.baicizhan.com/api/check_newversion.gz";
//    private WeakReference<Activity> mActivity;
//    private String mAppMD5;
//    private String mAppPath;
//    private String mAppURL;
//    private SharedPreferences mSettings;
//
//    public UpgradeManager(Activity activity) {
//        this.mActivity = new WeakReference<>(activity);
//        File[] a = ContextCompat.m313a(activity);
//        for (int length = a.length - 1; length >= 0; length--) {
//            if (a[length] != null) {
//                this.mAppPath = new File(a[length], UPGRADE_APP_NAME).getAbsolutePath();
//            }
//        }
//        this.mSettings = UpgradeDownloadService.openPreference(activity);
//    }
//
//    public void destroy() {
//        LogWrapper.m2793d(TAG, "destroy");
//        this.mActivity.clear();
//        VolleyUtils.cancelAllTagRequest(TAG);
//    }
//
//    public Context getContext() {
//        Activity activity = (Activity) this.mActivity.get();
//        if (activityAlive(activity)) {
//            return activity;
//        }
//        LogWrapper.m2793d(TAG, "getContext null");
//        return null;
//    }
//
//    private static boolean activityAlive(Activity activity) {
//        if (VERSION.SDK_INT >= 17) {
//            return activityAlive_API17(activity);
//        }
//        return activity != null && !activity.isFinishing();
//    }
//
//    @TargetApi(17)
//    private static boolean activityAlive_API17(Activity activity) {
//        return activity != null && !activity.isFinishing() && !activity.isDestroyed();
//    }
//
//    private String getPostBody(Context context, User user) {
//        JSONObject jSONObject = new JSONObject();
//        try {
//            jSONObject.put("device_id", PackageUtils.getDeviceId(context));
//            jSONObject.put(POST_DEVICE_MANUFACTURER, Build.MANUFACTURER);
//            jSONObject.put(POST_DEVICE_MODEL, Build.MODEL);
//            jSONObject.put(POST_OS_NAME, ANDROID);
//            jSONObject.put(POST_OS_SDK, VERSION.SDK_INT);
//            jSONObject.put("app_name", PackageUtils.getPackageVersion(context));
//            jSONObject.put(POST_APP_CHANNEL, PackageUtils.getChannel(context));
//            jSONObject.put("token", user.getToken());
//            JSONObject jSONObject2 = new JSONObject();
//            jSONObject2.put("longtitude", 0);
//            jSONObject2.put("latitude", 0);
//            jSONObject.put(POST_USER_POSITION, jSONObject2);
//            return jSONObject.toString();
//        } catch (JSONException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void tryUpgrade(final boolean z) {
//        LogWrapper.m2793d(TAG, "tryUpgrade status " + this.mSettings.getInt(UpgradeDownloadService.PREF_UPGRADE_STATUS, 0));
//        if (this.mSettings.getInt(UpgradeDownloadService.PREF_UPGRADE_STATUS, 0) != 1) {
//            UserAsyncTask.getTask(new UserLoadHandler() {
//                public void onSuccess(User user) {
//                    UpgradeManager.this.checkNewVersion(user, z);
//                }
//
//                public void onProgress(int i) {
//                }
//
//                public void onError(Void voidR) {
//                    LogWrapper.m2793d(UpgradeManager.TAG, "tryUpgrade error!!!");
//                }
//            }).execute(new Void[0]);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void checkNewVersion(User user, final boolean z) {
//        Context context = getContext();
//        if (context != null) {
//            LogWrapper.m2793d(TAG, "checkNewVersion");
//            Type type = new TypeToken<UpgradeInfo>() {
//            }.getType();
//            String postBody = getPostBody(context, user);
//            if (postBody != null) {
//                LogWrapper.m2793d(TAG, "Post body: " + postBody.toString());
//                GsonRequest gsonRequest = new GsonRequest(1, UPGRADE_CHECK_URL, type, postBody.toString(), new Listener<UpgradeInfo>() {
//                    public void onResponse(UpgradeInfo upgradeInfo) {
//                        LogWrapper.m2793d(UpgradeManager.TAG, "upgradeInfo " + upgradeInfo.toString());
//                        UpgradeManager.this.onCheckNewVersion(upgradeInfo, z);
//                    }
//                }, new ErrorListener() {
//                    public void onErrorResponse(VolleyError volleyError) {
//                        LogWrapper.m2793d(UpgradeManager.TAG, "onErrorResponse " + volleyError);
//                    }
//                });
//                gsonRequest.setTag(TAG);
//                VolleyUtils.send(gsonRequest);
//            }
//        }
//    }
//
//    public void onCheckNewVersion(final UpgradeInfo upgradeInfo, boolean z) {
//        LogWrapper.m2793d(TAG, "onCheckNewVersion");
//        Context context = getContext();
//        if (context != null) {
//            if (!TextUtils.isEmpty(upgradeInfo.getVersionURL())) {
//                try {
//                    new Builder(context).setTitle((CharSequence) String.format(Locale.CHINA, "发现新版本%s", new Object[]{upgradeInfo.getNewVersion()})).setMessage((CharSequence) upgradeInfo.getVersionDescription()).setPositiveButton((CharSequence) "下载", (OnClickListener) new OnClickListener() {
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            UpgradeManager.this.startUpgradeDownloadService(upgradeInfo);
//                        }
//                    }).setNegativeButton((CharSequence) "取消", (OnClickListener) null).create().show();
//                } catch (Exception e) {
//                    LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//                }
//            } else if (!z) {
//                Toast.makeText(context, "没有可用的更新", 1).show();
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void startUpgradeDownloadService(UpgradeInfo upgradeInfo) {
//        Context context = getContext();
//        if (context != null) {
//            LogWrapper.m2793d(TAG, "startUpgradeDownloadService");
//            this.mAppMD5 = upgradeInfo.getVersionMD5();
//            this.mAppURL = upgradeInfo.getVersionURL();
//            Intent intent = new Intent(context, UpgradeDownloadService.class);
//            intent.setAction(UpgradeDownloadService.ACTION_UPGRADE_DOWNLOAD);
//            intent.putExtra(UpgradeDownloadService.EXTRA_UPGRADE_APP_MD5, this.mAppMD5);
//            intent.putExtra(UpgradeDownloadService.EXTRA_UPGRADE_APP_URL, this.mAppURL);
//            intent.putExtra(UpgradeDownloadService.EXTRA_UPGRADE_APP_PATH, this.mAppPath);
//            context.startService(intent);
//        }
//    }
//}
