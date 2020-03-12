//package com.baicizhan.client.business.managers;
//
//import android.app.Activity;
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.ResolveInfo;
//import android.net.Uri;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.RelativeLayout.LayoutParams;
//import android.widget.TextView;
////import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.framework.util.Common;
////import com.baicizhan.online.bs_users.BBAdInfo;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
//import java.io.File;
//import java.lang.ref.WeakReference;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//import p116pl.droidsonroids.gif.GifImageView;
//
//public class AdLoader {
//    private static final long DEF_DURATION = 2000;
//    private static final boolean OPEN_JUMP_2_NATIVE_STORE = true;
//    private WeakReference<Activity> mActivity;
//    private ImageView mAdCard;
//    private AdLoadingRun mAdLoadingRun;
//    private TextView mAuthor;
//    private boolean mCanFadeout = false;
//    private View mClickRect;
//    private View mContentView;
//    /* access modifiers changed from: private */
//    public AdLoaderListener mListener;
//    private long mMinDuration = DEF_DURATION;
//    private GifImageView mProgressBar;
//    private View mQuotationCard;
//    private TextView mQuotationCn;
//    private TextView mQuotationEn;
//    private boolean mSkipAd = false;
//
//    public interface AdLoaderListener {
//        Intent getNativeStoreIntent(String str);
//
//        void onAdLoaded();
//    }
//
//    class AdLoadingRun implements Runnable {
//        private final WeakReference<AdLoader> mLoader;
//
//        private AdLoadingRun(AdLoader adLoader) {
//            this.mLoader = new WeakReference<>(adLoader);
//        }
//
//        public void run() {
//            AdLoader adLoader = (AdLoader) this.mLoader.get();
//            if (adLoader != null && adLoader.mListener != null) {
//                adLoader.mListener.onAdLoaded();
//            }
//        }
//    }
//
//    public static AdLoader createLoader(Activity activity, View view) {
//        return new AdLoader(activity, view);
//    }
//
//    private AdLoader(Activity activity, View view) {
////        this.mActivity = new WeakReference<>(activity);
////        if (view != null) {
////            this.mContentView = view.findViewById(R.id.ad_content);
////            this.mAdCard = (ImageView) view.findViewById(R.id.ad_card);
////            this.mClickRect = view.findViewById(R.id.ad_click_rect);
////            this.mQuotationCard = view.findViewById(R.id.ad_quotation_card);
////            this.mQuotationCn = (TextView) view.findViewById(R.id.ad_quotation_cn);
////            this.mQuotationEn = (TextView) view.findViewById(R.id.ad_quotaion_en);
////            this.mAuthor = (TextView) view.findViewById(R.id.ad_author);
////            this.mProgressBar = (GifImageView) view.findViewById(R.id.ad_loading_gif);
////            this.mProgressBar.setImageResource(R.drawable.loading_normal_default);
////        } else {
////            this.mContentView = activity.findViewById(R.id.ad_content);
////            this.mAdCard = (ImageView) activity.findViewById(R.id.ad_card);
////            this.mClickRect = activity.findViewById(R.id.ad_click_rect);
////            this.mQuotationCard = activity.findViewById(R.id.ad_quotation_card);
////            this.mQuotationCn = (TextView) activity.findViewById(R.id.ad_quotation_cn);
////            this.mQuotationEn = (TextView) activity.findViewById(R.id.ad_quotaion_en);
////            this.mAuthor = (TextView) activity.findViewById(R.id.ad_author);
////            this.mProgressBar = (GifImageView) activity.findViewById(R.id.ad_loading_gif);
////            this.mProgressBar.setImageResource(R.drawable.loading_normal_default);
////        }
////        this.mAdLoadingRun = new AdLoadingRun();
//    }
//
//    public AdLoader setListener(AdLoaderListener adLoaderListener) {
//        this.mListener = adLoaderListener;
//        return this;
//    }
//
//    public AdLoader skipAd(boolean z) {
//        this.mSkipAd = z;
//        return this;
//    }
//
//    public AdLoader enableFadeout(boolean z) {
//        this.mCanFadeout = z;
//        return this;
//    }
//
//    public AdLoader gone() {
//        if (this.mContentView.getVisibility() == 0) {
//            if (this.mCanFadeout) {
//                this.mContentView.startAnimation(AnimationUtils.loadAnimation(this.mContentView.getContext(), 17432577));
//            }
//            this.mContentView.setVisibility(8);
//        }
//        return this;
//    }
//
//    public AdLoader load() {
////        BBAdInfo fetchOneAd = this.mSkipAd ? null : AdManager.getInstance().fetchOneAd();
////        if (fetchOneAd == null || !showAd(fetchOneAd)) {
////            showQuotations();
////        }
////        if (this.mMinDuration <= 0) {
////            this.mMinDuration = DEF_DURATION;
////        }
////        this.mContentView.postDelayed(this.mAdLoadingRun, this.mMinDuration);
//        return this;
//    }
//
//    public void cancel() {
//        this.mContentView.removeCallbacks(this.mAdLoadingRun);
//    }
//
//    private void showQuotations() {
//        this.mQuotationCard.setVisibility(0);
//        this.mMinDuration = 0;
//        String[] strArr = ConstantsUtil.FAMOUSE_QUOTATIONS[new Random().nextInt(ConstantsUtil.FAMOUSE_QUOTATIONS.length)];
//        this.mAuthor.setText(strArr[0]);
//        this.mQuotationEn.setText(strArr[1]);
//        this.mQuotationCn.setText(strArr[2]);
//    }
//
////    private boolean showAd(final BBAdInfo bBAdInfo) {
////        Activity activity = (Activity) this.mActivity.get();
////        if (activity == null) {
////            return false;
////        }
////        this.mAdCard.setVisibility(0);
////        File adImageFile = AdManager.getAdImageFile(bBAdInfo.getImage_url());
////        if (adImageFile == null || !adImageFile.exists() || adImageFile.length() <= 0) {
////            return false;
////        }
////        RequestCreator a = Picasso.with((Context) activity).load(adImageFile);
////        a.f3707c = true;
////        a.into(this.mAdCard, (Callback) null);
////        this.mMinDuration = TimeUnit.MILLISECONDS.convert((long) bBAdInfo.getShow_time(), TimeUnit.SECONDS);
////        rescaleClickRect(bBAdInfo);
////        this.mClickRect.setOnClickListener(new OnClickListener() {
////            public void onClick(View view) {
////                String click_url = bBAdInfo.getClick_url();
////                if (click_url.contains("taobao.com")) {
////                    AdLoader.this.jumpToApp(bBAdInfo, "com.taobao");
////                } else if (click_url.contains("weixin.qq.com")) {
////                    AdLoader.this.jumpToApp(bBAdInfo, null);
////                }
////            }
////        });
////        UMStats.statTaobaoDisplayOnReview(activity, bBAdInfo.ad_name);
////        OperationStats.statLoad(String.valueOf(bBAdInfo.ad_id));
////        return true;
////    }
//
////    private void rescaleClickRect(BBAdInfo bBAdInfo) {
////        Activity activity = (Activity) this.mActivity.get();
////        if (activity != null) {
////            int screenWidth = Common.getScreenWidth(activity);
////            int screenHeight = Common.getScreenHeight(activity);
////            int i = (int) (bBAdInfo.btn_x * ((double) screenWidth));
////            int i2 = (int) (bBAdInfo.btn_y * ((double) screenHeight));
////            int i3 = (screenHeight - i2) - ((int) (bBAdInfo.btn_h * ((double) screenHeight)));
////            LayoutParams layoutParams = (LayoutParams) this.mClickRect.getLayoutParams();
////            layoutParams.setMargins(i, i2, (screenWidth - i) - ((int) (bBAdInfo.btn_w * ((double) screenWidth))), i3);
////            this.mClickRect.setLayoutParams(layoutParams);
////        }
////    }
//
//    /* access modifiers changed from: private */
////    public void jumpToApp(BBAdInfo bBAdInfo, String str) {
////        ResolveInfo resolveInfo;
////        boolean z;
////        ResolveInfo resolveInfo2;
////        boolean z2 = false;
////        Activity activity = (Activity) this.mActivity.get();
////        if (activity != null) {
////            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(bBAdInfo.getClick_url()));
////            List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
////            if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
////                ResolveInfo resolveInfo3 = (ResolveInfo) queryIntentActivities.get(0);
////                if (!TextUtils.isEmpty(str)) {
////                    resolveInfo = resolveInfo3;
////                    for (ResolveInfo resolveInfo4 : queryIntentActivities) {
////                        if (resolveInfo4.activityInfo.packageName.startsWith(str)) {
////                            resolveInfo2 = resolveInfo4;
////                            z = true;
////                        } else {
////                            z = z2;
////                            resolveInfo2 = resolveInfo;
////                        }
////                        resolveInfo = resolveInfo2;
////                        z2 = z;
////                    }
////                } else {
////                    resolveInfo = resolveInfo3;
////                }
////                long j = bBAdInfo.taobao_item_id;
////                if (j != 0 && !z2 && this.mListener != null) {
////                    Intent nativeStoreIntent = this.mListener.getNativeStoreIntent(String.valueOf(j));
////                    if (nativeStoreIntent != null) {
////                        activity.startActivity(nativeStoreIntent);
////                        activity.finish();
////                        this.mListener = null;
////                    }
////                } else if (resolveInfo != null) {
////                    UMStats.statTaobaoClickOnReview(activity, bBAdInfo.ad_name);
////                    intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
////                    activity.startActivity(intent);
////                    activity.finish();
////                    this.mListener = null;
////                }
////            }
////        }
////    }
//}
