//package com.baicizhan.main.utils;
//
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.ResolveInfo;
//import android.net.Uri;
//import android.util.Log;
//import android.widget.Toast;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.main.activity.StoreActivity;
//import com.baicizhan.online.bs_users.BBShoppingAd;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.baicizhan.store.InternalStoreActivity;
//import com.jiongji.andriod.card.R;
//
//public class GoStoreUtil {
//    public static final int FROM_CART = 2;
//    public static final int FROM_SHOP = 1;
//    private static final int GO_TYPE_SHOOT = 0;
//    private static final int GO_TYPE_WV = 1;
//    private static final String TAG = GoStoreUtil.class.getSimpleName();
//    private static GoStoreUtil sInstance = null;
//    /* access modifiers changed from: private */
//    public boolean mLoading = false;
//    /* access modifiers changed from: private */
//    public BBShoppingAd mShoppingAd = null;
//
//    public static GoStoreUtil getInstance() {
//        if (sInstance == null) {
//            synchronized (GoStoreUtil.class) {
//                if (sInstance == null) {
//                    sInstance = new GoStoreUtil();
//                }
//            }
//        }
//        return sInstance;
//    }
//
//    private GoStoreUtil() {
//    }
//
//    private void jum2SingleApp(Context context, String str) {
//        if (!tryOpenTaobao(context, new Intent("android.intent.action.VIEW", Uri.parse(str)))) {
//            context.startActivity(new Intent(context, InternalStoreActivity.class));
//        }
//    }
//
//    private boolean tryOpenTaobao(Context context, Intent intent) {
//        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
//            if (resolveInfo.activityInfo.packageName.startsWith("com.taobao")) {
//                intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
//                Log.d("whiz", "jump to taobao");
//                context.startActivity(intent);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void fetch(final AuthCallback<BBShoppingAd> authCallback) {
//        if (this.mShoppingAd != null) {
//            authCallback.postSuccess(this.mShoppingAd);
//            return;
//        }
//        C12341 r0 = new ThriftRequest<Client, BBShoppingAd>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public BBShoppingAd doInBackground(Client client) {
//                return client.get_shopping_ad();
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                authCallback.postError(exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(BBShoppingAd bBShoppingAd) {
//                GoStoreUtil.this.mShoppingAd = bBShoppingAd;
//                authCallback.postSuccess(bBShoppingAd);
//            }
//        };
//        r0.setTag(TAG);
//        BaicizhanThrifts.getProxy().add(r0);
//    }
//
//    public void load(final Context context, final int i) {
//        if (this.mShoppingAd != null) {
//            jump(context, this.mShoppingAd, i);
//            return;
//        }
//        Toast.makeText(context, context.getString(R.string.main_store_loading, new Object[]{StudyManager.getInstance().getCurrentUser().getVerboseSex()}), 0).show();
//        if (!this.mLoading) {
//            this.mLoading = true;
//            C12352 r0 = new ThriftRequest<Client, BBShoppingAd>(BaicizhanThrifts.USERS) {
//                /* access modifiers changed from: protected */
//                public BBShoppingAd doInBackground(Client client) {
//                    return client.get_shopping_ad();
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                    Toast.makeText(context, R.string.main_store_load_failed, 0).show();
//                    GoStoreUtil.this.mLoading = false;
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(BBShoppingAd bBShoppingAd) {
//                    GoStoreUtil.this.mLoading = false;
//                    GoStoreUtil.this.mShoppingAd = bBShoppingAd;
//                    GoStoreUtil.this.jump(context, bBShoppingAd, i);
//                }
//            };
//            r0.setTag(TAG);
//            BaicizhanThrifts.getProxy().add(r0);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void jump(Context context, BBShoppingAd bBShoppingAd, int i) {
//        doJump(context, bBShoppingAd, i);
//    }
//
//    private void doJump(Context context, BBShoppingAd bBShoppingAd, int i) {
//        String ad_url = i == 1 ? bBShoppingAd.getLeft_menu_ad_url() : bBShoppingAd.getAd_url();
//        switch (bBShoppingAd.getClick_type()) {
//            case 0:
//                jum2SingleApp(context, ad_url);
//                return;
//            case 1:
//                StoreActivity.start(context, ad_url);
//                return;
//            default:
//                return;
//        }
//    }
//
//    public void destroy() {
//        BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
//    }
//}
