//package com.baicizhan.client.friend.fragment;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
////import android.support.p004v4.app.Fragment;
////import android.support.p004v4.app.FragmentActivity;
////import android.support.p004v4.app.FragmentPagerAdapter;
////import android.support.p004v4.view.C0156bm;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.view.ViewGroup.MarginLayoutParams;
//import android.widget.ListView;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.ColorStateListUtils;
//import com.baicizhan.client.business.widget.DotIndicator;
//import com.baicizhan.client.business.widget.RoundedButton;
//import com.baicizhan.client.framework.util.DisplayUtils;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.activity.FriendSearchActivity;
//import com.baicizhan.client.friend.adapter.FriendWeekAdapter;
//import com.baicizhan.client.friend.utils.FriendEvents.FoldTitleBarEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.FriendWeekUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.FriendsUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.utils.FriendManager.SyncState;
//import com.baicizhan.client.friend.utils.FriendRequests;
//import com.baicizhan.client.friend.widget.DragWrapperLayout;
//import com.baicizhan.client.friend.widget.DragWrapperLayout.OnDetectDragListener;
//import com.jiongji.andriod.card.R;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Locale;
////import p000a.p001a.p002a.EventBus;
//
//public class FriendWeekFragment extends Fragment implements OnClickListener {
//    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM月dd日", Locale.CHINA);
//    public static final String TAG = FriendWeekFragment.class.getSimpleName();
//    private RoundedButton mAddFriendButton;
//    private DotIndicator mIndicator;
////    private C0156bm mPageChangeListener = new C0156bm() {
////        public void onPageSelected(int i) {
////            FriendWeekFragment.this.fixNavigator(i);
////        }
////
////        public void onPageScrolled(int i, float f, int i2) {
////        }
////
////        public void onPageScrollStateChanged(int i) {
////        }
////    };
//    private ViewPager mPager;
//    private View mSingleTip;
//    private TextView mWeek;
//    private TextView mWeekDate;
//
//    public class WeekPageAdapter extends FragmentPagerAdapter {
//        private static final int WEEK_COUNT = 2;
//
//        public WeekPageAdapter(FragmentManager vVar) {
//            super(vVar);
//        }
//
//        public Fragment getItem(int i) {
////            return WeekPageFragment.newInstance(i);
//            return null;
//        }
//
//        public int getCount() {
//            return 2;
//        }
//    }
//
//    public class WeekPageFragment extends Fragment {
//        public static final String EXTRA_PAGE_INDEX = "PAGE_INDEX";
//        private FriendWeekAdapter mAdapter;
//        private ListView mListView;
//        private int mPageIndex;
//        private DragWrapperLayout mWrapperLayout;
//
//        public  WeekPageFragment newInstance(int i) {
//            WeekPageFragment weekPageFragment = new WeekPageFragment();
//            Bundle bundle = new Bundle();
//            bundle.putInt(EXTRA_PAGE_INDEX, i);
//            weekPageFragment.setArguments(bundle);
//            return weekPageFragment;
//        }
//
//        public void onCreate(Bundle bundle) {
//            super.onCreate(bundle);
//            this.mPageIndex = getArguments() != null ? getArguments().getInt(EXTRA_PAGE_INDEX) : 0;
//        }
//
//        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//            Context context = layoutInflater.getContext();
//            this.mWrapperLayout = new DragWrapperLayout(context);
//            this.mListView = new ListView(context);
//            this.mWrapperLayout.addView(this.mListView);
//            this.mAdapter = new FriendWeekAdapter(context, this.mPageIndex);
//            this.mListView.setAdapter(this.mAdapter);
//            this.mAdapter.update();
//            this.mListView.setSelector(17170445);
//            this.mListView.setCacheColorHint(0);
//            this.mListView.setDivider(new ColorDrawable(getResources().getColor(R.color.business_dc3)));
//            this.mListView.setDividerHeight(1);
//            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mListView.getLayoutParams();
//            int dpToPx = DisplayUtils.dpToPx(context, 37.0f);
//            marginLayoutParams.setMargins(dpToPx, 0, dpToPx, 0);
//            this.mListView.setLayoutParams(marginLayoutParams);
//            this.mWrapperLayout.setOnDectectDragListener(new OnDetectDragListener() {
//                public void onDragUp() {
////                    EventBus.m0a().mo9c((Object) new FoldTitleBarEvent(true));
//                }
//
//                public void onDragDown() {
////                    EventBus.m0a().mo9c((Object) new FoldTitleBarEvent(false));
//                }
//            });
//            return this.mWrapperLayout;
//        }
//
//        public void onDestroyView() {
//            super.onDestroyView();
//        }
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putInt("page_index", 0);
//    }
//
//    private CharSequence getDisplayWeek(int i) {
//        Calendar instance = Calendar.getInstance();
//        instance.setFirstDayOfWeek(2);
//        instance.add(5, i * 7);
//        int i2 = instance.get(7);
//        if (i2 >= 2) {
//            instance.add(5, 2 - i2);
//        } else {
//            instance.add(5, -6);
//        }
//        String format = DATE_FORMAT.format(instance.getTime());
//        instance.add(5, 6);
//        return String.format(Locale.CHINA, "%s - %s", new Object[]{format, DATE_FORMAT.format(instance.getTime())});
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(R.layout.friend_week_fragment, viewGroup, false);
//        this.mWeek = (TextView) inflate.findViewById(R.id.week);
//        this.mWeekDate = (TextView) inflate.findViewById(R.id.week_date);
//        this.mIndicator = (DotIndicator) inflate.findViewById(R.id.indicator);
//        this.mPager = (ViewPager) inflate.findViewById(R.id.rank_list_pager);
////        this.mPager.setOnPageChangeListener(this.mPageChangeListener);
//        this.mSingleTip = inflate.findViewById(R.id.single_tip);
//        this.mAddFriendButton = (RoundedButton) inflate.findViewById(R.id.add_friend);
//        this.mAddFriendButton.setOnClickListener(this);
//        this.mAddFriendButton.setFillColor(ColorStateListUtils.getSimpleColorStateList(0, 342781550));
////        EventBus.m0a().mo5a((Object) this);
//        FriendManager instance = FriendManager.getInstance();
//        if (instance.getFriendNumber() == 0 || instance.getFriendSyncState() == SyncState.UNSYNC) {
//            FriendRequests.fetchFriends(getActivity());
//            FriendRequests.fetchInvitedList(getActivity());
//        } else {
//            update();
//            FriendRequests.refreshWeekLearnedInfo(getActivity());
//        }
//        return inflate;
//    }
//
//    private void update() {
//        if (FriendManager.getInstance().getFriendNumber() == 0) {
//            changeLayoutParams(this.mPager, -1, DisplayUtils.dpToPx(getActivity(), 48.0f));
//            this.mSingleTip.setVisibility(0);
//            this.mAddFriendButton.setVisibility(0);
//        } else {
//            changeLayoutParams(this.mPager, -1, -1);
//            this.mSingleTip.setVisibility(8);
//            this.mAddFriendButton.setVisibility(8);
//        }
//        this.mPager.setAdapter(new WeekPageAdapter(getChildFragmentManager()));
//        int count = this.mPager.getAdapter().getCount() - 1;
//        this.mPager.setCurrentItem(count);
//        fixNavigator(count);
//    }
//
//    private void changeLayoutParams(View view, int i, int i2) {
//        LayoutParams layoutParams = view.getLayoutParams();
//        if (layoutParams.width != i || layoutParams.height != i2) {
//            layoutParams.width = i;
//            layoutParams.height = i2;
//            view.setLayoutParams(layoutParams);
//        }
//    }
//
//    public void onDestroyView() {
//        super.onDestroyView();
////        EventBus.m0a().mo8b((Object) this);
//    }
//
//    /* access modifiers changed from: private */
//    public void fixNavigator(int i) {
//        this.mIndicator.setSelectedItem(i);
//        this.mWeek.setText(i == 0 ? R.string.friend_last_week : R.string.friend_this_week);
//        this.mWeek.setTextColor(getActivity().getResources().getColor(i == 0 ? R.color.business_dt2 : R.color.business_dc8));
//        this.mWeekDate.setText(getDisplayWeek((i - this.mPager.getAdapter().getCount()) + 1));
//    }
//
//    public void onEventMainThread(FriendsUpdateEvent friendsUpdateEvent) {
//        update();
//    }
//
//    public void onEventMainThread(FriendWeekUpdateEvent friendWeekUpdateEvent) {
//        update();
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.add_friend) {
//            FragmentActivity activity = getActivity();
//            activity.startActivity(new Intent(activity, FriendSearchActivity.class));
//        }
//    }
//}
