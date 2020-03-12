//package com.baicizhan.main.stats.appscan;
//
//import android.content.Context;
//import android.content.pm.ApplicationInfo;
//import android.text.TextUtils;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.online.bs_users.BBMiscInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
//public class APPScaner {
//    private static final String ANDROID_PKG = "com.android";
//    private static final String MTK_PKG = "com.mediatek";
//    private static final String QUALCOMM_PKG = "com.qualcomm";
//    private WeakReference<Context> mContext;
//
//    private APPScaner(Context context) {
//        this.mContext = new WeakReference<>(context);
//    }
//
//    public static APPScaner born(Context context) {
//        return new APPScaner(context);
//    }
//
//    public void scan() {
//        if (Settings.needScan()) {
//            BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Void>(BaicizhanThrifts.USERS) {
//                /* access modifiers changed from: protected */
//                public Void doInBackground(Client client) {
//                    List access$000 = APPScaner.this.getScanResults();
//                    if (access$000 == null || access$000.isEmpty()) {
//                        throw new Exception("No app need to upload.");
//                    }
//                    client.update_miscs(access$000);
//                    return null;
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(Void voidR) {
//                    Settings.setLastTimeScanApp(System.currentTimeMillis());
//                }
//            });
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public List<BBMiscInfo> getScanResults() {
//        Context context = (Context) this.mContext.get();
//        if (context == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList();
//        for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(Integer.MAX_VALUE)) {
//            if (needed(applicationInfo.packageName)) {
//                BBMiscInfo bBMiscInfo = new BBMiscInfo();
//                bBMiscInfo.setName(applicationInfo.packageName);
//                arrayList.add(bBMiscInfo);
//            }
//        }
//        return arrayList;
//    }
//
//    private static boolean needed(String str) {
//        if (!TextUtils.isEmpty(str) && !str.startsWith(ANDROID_PKG) && !str.startsWith(QUALCOMM_PKG) && !str.startsWith(MTK_PKG)) {
//            return true;
//        }
//        return false;
//    }
//}
