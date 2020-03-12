//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Rect;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.RedDotImageView;
//import com.baicizhan.client.fight.MainActivity;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.client.friend.activity.FriendFacetActivity;
//import com.baicizhan.main.activity.MainTabActivity;
//import com.baicizhan.main.popup.ReviewPopupWindow;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.main.utils.GoStoreUtil;
//import com.baicizhan.main.utils.MainEvents.UploadClickEvent;
//import com.baicizhan.main.utils.MainEvents.UploadStatusEvent;
//import com.jiongji.andriod.card.R;
//import p000a.p001a.p002a.EventBus;
//
//public class MainBottomTab extends LinearLayout implements OnClickListener {
//    private RedDotImageView mFriend;
//    private MainTabActivity mMainTab;
//    private ImageView mPK;
//    private ImageView mReview;
//    private boolean mRightTabVisible = true;
//    private RedDotImageView mSettings;
//    private ImageView mStore;
//    private ImageView mUpdate;
//    private TextView mUpdateText;
//
//    public MainBottomTab(Context context) {
//        super(context);
//    }
//
//    public MainBottomTab(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void init(MainTabActivity mainTabActivity) {
//        this.mMainTab = mainTabActivity;
//    }
//
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        EventBus.m0a().mo5a((Object) this);
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        EventBus.m0a().mo8b((Object) this);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mSettings = (RedDotImageView) findViewById(R.id.main_tab_settings);
//        this.mFriend = (RedDotImageView) findViewById(R.id.main_tab_friend);
//        this.mUpdate = (ImageView) findViewById(R.id.main_tab_update);
//        this.mUpdateText = (TextView) findViewById(R.id.main_tab_update_text);
//        this.mPK = (ImageView) findViewById(R.id.main_tab_pk);
//        this.mStore = (ImageView) findViewById(R.id.main_tab_store);
//        this.mReview = (ImageView) findViewById(R.id.main_tab_review);
//        this.mSettings.setOnClickListener(this);
//        this.mFriend.setOnClickListener(this);
//        this.mUpdate.setOnClickListener(this);
//        this.mPK.setOnClickListener(this);
//        this.mStore.setOnClickListener(this);
//        this.mReview.setOnClickListener(this);
//    }
//
//    public void onClick(View view) {
//        if (this.mMainTab != null) {
//            switch (view.getId()) {
//                case R.id.main_tab_settings /*2131296759*/:
//                    this.mMainTab.toggleDrawer();
//                    return;
//                case R.id.main_tab_update /*2131296760*/:
//                    EventBus.m0a().mo9c((Object) new UploadClickEvent());
//                    return;
//                case R.id.main_tab_friend /*2131296762*/:
//                    if (CommonUtils.ensureNetworkAvailable(getContext())) {
//                        this.mFriend.setShowRedDot(false);
//                        this.mMainTab.startActivity(new Intent(this.mMainTab, FriendFacetActivity.class));
//                        UMStats.statFriendClick(this.mMainTab);
//                        return;
//                    }
//                    return;
//                case R.id.main_tab_pk /*2131296763*/:
//                    if (CommonUtils.ensureNetworkAvailable(getContext())) {
//                        this.mMainTab.startActivity(new Intent(this.mMainTab, MainActivity.class));
//                        UMStats.statPKClick(this.mMainTab);
//                        OperationStats.statPK();
//                        return;
//                    }
//                    return;
//                case R.id.main_tab_store /*2131296764*/:
//                    GoStoreUtil.getInstance().load(getContext(), 2);
//                    UMStats.statStoreClick(this.mMainTab);
//                    OperationStats.statCart();
//                    return;
//                case R.id.main_tab_review /*2131296765*/:
//                    showReviewPopupWindow();
//                    OperationStats.statMenu();
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    private void showReviewPopupWindow() {
//        ReviewPopupWindow reviewPopupWindow = new ReviewPopupWindow(getContext());
//        Rect rect = new Rect();
//        this.mReview.getGlobalVisibleRect(rect);
//        reviewPopupWindow.showAtLocation(this, 53, (getMeasuredWidth() - rect.centerX()) - DisplayUtils.dpToPx(getContext(), 15.5f), rect.top - reviewPopupWindow.getHeight());
//    }
//
//    public void onEventMainThread(UploadStatusEvent uploadStatusEvent) {
//        switch (uploadStatusEvent.getStatus()) {
//            case 1:
//                this.mUpdate.clearAnimation();
//                this.mUpdate.setVisibility(8);
//                this.mUpdateText.setVisibility(8);
//                return;
//            case 2:
//                this.mUpdateText.setVisibility(8);
//                this.mUpdate.setVisibility(0);
//                this.mUpdate.clearAnimation();
//                this.mUpdate.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(getContext(), R.attr.drawable_syncview_error));
//                return;
//            case 3:
//                this.mUpdateText.setVisibility(0);
//                this.mUpdate.setVisibility(0);
//                this.mUpdate.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(getContext(), R.attr.drawable_syncview_update));
//                this.mUpdate.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.main_infinite_rotate));
//                return;
//            default:
//                return;
//        }
//    }
//
//    public void setRightTabsVisible(boolean z) {
//        if (z) {
//            if (!this.mRightTabVisible) {
//                this.mFriend.setVisibility(0);
//                this.mPK.setVisibility(0);
//                this.mStore.setVisibility(0);
//                this.mReview.setVisibility(0);
//                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.main_scale_fadein);
//                this.mFriend.startAnimation(loadAnimation);
//                this.mPK.startAnimation(loadAnimation);
//                this.mStore.startAnimation(loadAnimation);
//                this.mReview.startAnimation(loadAnimation);
//            }
//            this.mRightTabVisible = true;
//            return;
//        }
//        if (this.mRightTabVisible) {
//            this.mFriend.setVisibility(8);
//            this.mPK.setVisibility(8);
//            this.mStore.setVisibility(8);
//            this.mReview.setVisibility(8);
//            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.main_scale_fadeout);
//            this.mFriend.startAnimation(loadAnimation2);
//            this.mPK.startAnimation(loadAnimation2);
//            this.mStore.startAnimation(loadAnimation2);
//            this.mReview.startAnimation(loadAnimation2);
//        }
//        this.mRightTabVisible = false;
//    }
//
//    public void showFriendRedDot() {
//        this.mFriend.setShowRedDot(true);
//    }
//
//    public void showSettingRedDot(boolean z) {
//        this.mSettings.setShowRedDot(z);
//    }
//
//    public void setSettingSelected(boolean z) {
//        this.mSettings.setSelected(z);
//    }
//}
