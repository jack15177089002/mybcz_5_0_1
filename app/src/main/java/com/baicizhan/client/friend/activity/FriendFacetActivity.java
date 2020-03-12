//package com.baicizhan.client.friend.activity;
//
//import android.content.Context;
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
////import android.support.p004v4.app.Fragment;
////import android.support.p004v4.app.FragmentActivity;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.VolleyUtils;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.fragment.FriendFeedFragment;
//import com.baicizhan.client.friend.fragment.FriendGridFragment;
//import com.baicizhan.client.friend.fragment.FriendWeekFragment;
//import com.baicizhan.client.friend.model.FriendRecord;
//import com.baicizhan.client.friend.utils.FriendEvents.FeedUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.FoldTitleBarEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.NotificationUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.utils.FriendRequests;
//import com.baicizhan.client.friend.utils.FriendURL;
//import com.baicizhan.client.friend.widget.FoldableContainer;
//import com.baicizhan.client.friend.widget.FriendFacetTab;
//import com.jiongji.andriod.card.R;
//import com.umeng.p092a.MobclickAgent;
//import java.util.ArrayList;
//import java.util.List;
////import p000a.p001a.p002a.EventBus;
//
//public class FriendFacetActivity extends FragmentActivity implements OnClickListener {
//    static final int TAB_INDEX_FEEDS = 2;
//    static final int TAB_INDEX_FRIENDS = 0;
//    static final int TAB_INDEX_WEEK = 1;
//    public static final String TAG = FriendFacetActivity.class.getSimpleName();
//    private FoldableContainer mContainerView;
//    private int mCurrentTabIndex = -1;
//    private FragmentManager mFragmentManager;
//    private List<Fragment> mFragments = new ArrayList();
//    private List<FriendFacetTab> mTabs = new ArrayList();
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            overridePendingTransition(R.anim.business_push_up_in, R.anim.business_push_up_out);
//            setContentView(R.layout.friend_facet_activity);
//            resetIfNeeded();
//            initViews();
////            EventBus.m0a().mo6a((Object) this, "onEvent", true);
//            FriendManager.getInstance().setIsInFriendTask(true);
//        }
//    }
//
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.business_push_down_in, R.anim.business_push_down_out);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onResume() {
//        super.onResume();
//        if (FriendManager.getInstance().getNotifications().size() == 0) {
//            FriendRequests.fetchNotifications(this);
//        }
//        try {
//            MobclickAgent.m5136b((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onPause() {
//        super.onPause();
//        try {
//            MobclickAgent.m5132a((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_GET_FRIENDS);
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_GET_USER_INFO);
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_GET_NOTIFICATIONS);
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_GET_INVITED_FRIENDS);
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_REFRESH_FRIENDS_LEARNED);
////        EventBus.m0a().mo8b((Object) this);
//        FriendManager.getInstance().setIsInFriendTask(false);
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.home) {
//            finish();
//        }
//    }
//
//    private void resetIfNeeded() {
//        FriendManager instance = FriendManager.getInstance();
//        FriendRecord self = instance.getSelf();
//        if (self == null) {
//            return;
//        }
//        if (!self.getPublicKey().equals(Settings.getString(Settings.PREF_USER_PUBLIC_KEY))) {
//            C0789L.log.info("++++++++++++ reset FriendManager");
//            instance.reset();
//            return;
//        }
//        String string = Settings.getString(Settings.PREF_USER_NICKNAME);
//        if (!TextUtils.isEmpty(string)) {
//            self.setLocalName(string);
//        }
//    }
//
//    private void initViews() {
//        this.mContainerView = (FoldableContainer) findViewById(R.id.facet_container);
//        this.mFragmentManager = getSupportFragmentManager();
////        addTab(R.id.friend_tab, new FriendGridFragment());
////        addTab(R.id.week_tab, new FriendWeekFragment());
////        addTab(R.id.feed_tab, new FriendFeedFragment());
//        showTab(getInitialTabIndex());
//    }
//
//    private int getInitialTabIndex() {
//        if (Settings.getInt(Settings.PREF_FRIENDS_NUM) == 0) {
//            return 0;
//        }
//        return 1;
//    }
//
//    private void addTab(int i, Fragment fragment) {
//        FriendFacetTab friendFacetTab = (FriendFacetTab) findViewById(i);
//        friendFacetTab.setTag(Integer.valueOf(this.mTabs.size()));
//        this.mTabs.add(friendFacetTab);
//        this.mFragments.add(fragment);
//        friendFacetTab.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                FriendFacetActivity.this.showTab(((Integer) view.getTag()).intValue());
//            }
//        });
//    }
//
//    /* access modifiers changed from: private */
//    public void showTab(int i) {
//        if (i >= 0 && i < this.mTabs.size()) {
//            if (this.mCurrentTabIndex >= 0 && this.mCurrentTabIndex < this.mTabs.size()) {
//                ((FriendFacetTab) this.mTabs.get(this.mCurrentTabIndex)).setSelected(false);
//            }
//            ((FriendFacetTab) this.mTabs.get(i)).setSelected(true);
//            if (!((Fragment) this.mFragments.get(i)).isAdded()) {
////                this.mFragmentManager.mo313a().mo184b(R.id.fragment_holder, (Fragment) this.mFragments.get(i)).mo183b();
//            }
//            this.mCurrentTabIndex = i;
//        }
//    }
//
//    public void onEventMainThread(FoldTitleBarEvent foldTitleBarEvent) {
//        if (foldTitleBarEvent.isFold) {
//            this.mContainerView.fold();
//        } else {
//            this.mContainerView.unfold();
//        }
//    }
//
//    public void onEventMainThread(FeedUpdateEvent feedUpdateEvent) {
//        C0789L.log.info("onEventMainThread FeedUpdateEvent");
//        if (this.mCurrentTabIndex != 2) {
//            ((FriendFacetTab) this.mTabs.get(2)).setNeedCheck(true);
//        }
//    }
//
//    public void onEventMainThread(NotificationUpdateEvent notificationUpdateEvent) {
//        C0789L.log.info("onEventMainThread NotificationUpdateEvent");
//        if (this.mCurrentTabIndex != 0) {
//            ((FriendFacetTab) this.mTabs.get(0)).setNeedCheck(true);
//        }
////        EventBus.m0a().mo7b(NotificationUpdateEvent.class);
//    }
//}
