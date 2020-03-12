//package com.baicizhan.client.fight.customview;
//
//import android.content.Context;
////import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
////import android.support.p004v4.app.FragmentActivity;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//import com.baicizhan.client.business.stats.operation.OperationStats;
////import com.baicizhan.client.fight.R;
//import com.baicizhan.client.fight.ShareTotalScoreDialog;
//import com.baicizhan.client.fight.VSManager;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.jiongji.andriod.card.R;
//
//public class InformationTabs extends RelativeLayout {
//    public static final String TAG = "InformationTabs";
//    Animation mAnimLeftIn;
//    Animation mAnimLeftOut;
//    Animation mAnimRightIn;
//    Animation mAnimRightOut;
//    int mCurrentChild;
//    FriendRankView mFriendRank;
//    View[] mPages;
//    View mShareTotalScore;
//    ViewGroup mTabContentView;
//    View[] mTabs;
//    TotalScoreView mTodayScore;
//
//    public InformationTabs(Context context) {
//        super(context);
//    }
//
//    public InformationTabs(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mTabContentView = (ViewGroup) findViewById(R.id.tab_content);
//        this.mTabs = new View[]{findViewById(R.id.switch_today_score), findViewById(R.id.switch_friend_rank)};
//        this.mPages = new View[]{this.mTabContentView.getChildAt(0), this.mTabContentView.getChildAt(1)};
//        this.mShareTotalScore = findViewById(R.id.share_total_score);
//        this.mTodayScore = (TotalScoreView) findViewById(R.id.total_score_view);
//        this.mFriendRank = (FriendRankView) findViewById(R.id.friend_rank_tab);
//        int displayPixelWidth = (((DisplayUtils.getDisplayPixelWidth(getContext()) / 2) - DisplayUtils.dpToPx(getContext(), 50.0f)) - getContext().getResources().getDimensionPixelSize(R.dimen.fight_back_width)) / 2;
////        for (final int i = 0; i < this.mTabs.length; i++) {
////            View view = this.mTabs[i];
////            LayoutParams layoutParams = view.getLayoutParams();
////            layoutParams.width = displayPixelWidth;
////            view.setLayoutParams(layoutParams);
////            view.setOnClickListener(new OnClickListener() {
////                public void onClick(View view) {
////                    if (!view.isSelected()) {
////                        InformationTabs.this.setChild(i);
////                    }
////                }
////            });
////        }
//        setChild(0);
//        this.mShareTotalScore.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                InformationTabs.this.shareTotalScoreDialog();
//                OperationStats.statPKShare();
//            }
//        });
//        this.mAnimLeftIn = AnimationUtils.loadAnimation(getContext(), R.anim.business_push_left_in);
//        this.mAnimLeftOut = AnimationUtils.loadAnimation(getContext(), R.anim.business_push_left_out);
//        this.mAnimRightIn = AnimationUtils.loadAnimation(getContext(), R.anim.business_push_right_in);
//        this.mAnimRightOut = AnimationUtils.loadAnimation(getContext(), R.anim.business_push_right_out);
//    }
//
//    public void refreshInformation() {
//        if (VSManager.getInstance().getAvatar() != null) {
//            VSManager.getInstance().isInfoPanelSynced = true;
//            this.mTodayScore.refreshTotalScore();
//            this.mFriendRank.refreshFriendRank();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void setChild(int i) {
//        if (i < this.mCurrentChild) {
//            setChild(i, this.mAnimRightIn, this.mAnimRightOut);
//        } else {
//            setChild(i, this.mAnimLeftIn, this.mAnimLeftOut);
//        }
//    }
//
//    private void setChild(int i, Animation animation, Animation animation2) {
//        for (View visibility : this.mPages) {
//            visibility.setVisibility(8);
//        }
//        View view = this.mPages[this.mCurrentChild];
//        if (animation2 != null) {
//            view.startAnimation(animation2);
//        }
//        for (View selected : this.mTabs) {
//            selected.setSelected(false);
//        }
//        this.mTabs[i].setSelected(true);
//        View view2 = this.mPages[i];
//        if (animation != null) {
//            view2.startAnimation(animation);
//        }
//        view2.setVisibility(0);
//        this.mCurrentChild = i;
//    }
//
//    public void setAvatar(UserInfo userInfo) {
//        this.mTodayScore.setUserInfo(userInfo);
//    }
//
//    public void onDestroy() {
//        this.mTodayScore.onDestroy();
//        this.mFriendRank.onDestroy();
//    }
//
//    public void shareTotalScoreDialog() {
//        if (VSManager.getInstance().getTotalScore() == null) {
//            Toast.makeText(getContext(), getContext().getString(R.string.fight_cannot_share), 0).show();
//            return;
//        }
////        C0066v supportFragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
////        if (supportFragmentManager.mo312a(ShareTotalScoreDialog.TAG) == null) {
////            new ShareTotalScoreDialog().show(supportFragmentManager.mo313a(), ShareTotalScoreDialog.TAG);
////        }
//    }
//}
