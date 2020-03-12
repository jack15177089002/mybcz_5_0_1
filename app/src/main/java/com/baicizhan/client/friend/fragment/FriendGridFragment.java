//package com.baicizhan.client.friend.fragment;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
////import android.support.p004v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.GridView;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.VolleyUtils;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.activity.FriendNotificationActivity;
//import com.baicizhan.client.friend.activity.FriendSearchActivity;
//import com.baicizhan.client.friend.adapter.FriendGridAdapter;
//import com.baicizhan.client.friend.utils.FriendEvents.FoldTitleBarEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.FriendsUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.NotificationUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.utils.FriendManager.SyncState;
//import com.baicizhan.client.friend.utils.FriendRequests;
//import com.baicizhan.client.friend.utils.FriendURL;
//import com.baicizhan.client.friend.widget.DragWrapperLayout;
//import com.baicizhan.client.friend.widget.DragWrapperLayout.OnDetectDragListener;
//import com.jiongji.andriod.card.R;
//
//import java.util.Locale;
////import p000a.p001a.p002a.EventBus;
//
//public class FriendGridFragment extends Fragment {
//    public static final String TAG = FriendGridFragment.class.getSimpleName();
//    View mAddFriend;
//    OnClickListener mAddFriendListener = new OnClickListener() {
//        public void onClick(View view) {
//            Context context = view.getContext();
//            context.startActivity(new Intent(context, FriendSearchActivity.class));
//        }
//    };
//    TextView mEmptyView;
//    GridView mFriendGrid;
//    FriendGridAdapter mGridAdapter;
//    View mNotificationLine;
//    OnClickListener mNotificationListener = new OnClickListener() {
//        public void onClick(View view) {
//            Context context = view.getContext();
//            context.startActivity(new Intent(context, FriendNotificationActivity.class));
//        }
//    };
//    TextView mNotifications;
//    DragWrapperLayout mWrapperLayout;
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        FriendManager instance = FriendManager.getInstance();
//        if (instance.getFriendNumber() == 0 || instance.getFriendSyncState() == SyncState.UNSYNC) {
//            FriendRequests.fetchFriends(activity);
//            FriendRequests.fetchInvitedList(activity);
//        }
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(R.layout.friend_grid_fragment, viewGroup, false);
//        this.mNotificationLine = inflate.findViewById(R.id.notification_line);
//        this.mNotifications = (TextView) this.mNotificationLine.findViewById(R.id.notifications);
//        this.mAddFriend = inflate.findViewById(R.id.add_friend);
//        this.mWrapperLayout = (DragWrapperLayout) inflate.findViewById(R.id.wrapper);
//        this.mFriendGrid = (GridView) inflate.findViewById(R.id.friend_grid);
//        this.mEmptyView = (TextView) inflate.findViewById(R.id.empty_view);
//        if (FriendManager.getInstance().getFriendSyncState() == SyncState.SYNCING) {
//            this.mEmptyView.setText(R.string.friend_loading_friends_prompt);
//        }
//        this.mFriendGrid.setEmptyView(this.mEmptyView);
//        this.mGridAdapter = new FriendGridAdapter(getActivity());
//        this.mFriendGrid.setAdapter(this.mGridAdapter);
//        this.mGridAdapter.update();
//        this.mNotificationLine.setOnClickListener(this.mNotificationListener);
//        this.mAddFriend.setOnClickListener(this.mAddFriendListener);
//        this.mWrapperLayout.setOnDectectDragListener(new OnDetectDragListener() {
//            public void onDragUp() {
////                EventBus.m0a().mo9c((Object) new FoldTitleBarEvent(true));
//            }
//
//            public void onDragDown() {
////                EventBus.m0a().mo9c((Object) new FoldTitleBarEvent(false));
//            }
//        });
////        EventBus.m0a().mo5a((Object) this);
//        return inflate;
//    }
//
//    public void onDestroyView() {
//        super.onDestroyView();
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_DELETE_FRIEND);
////        EventBus.m0a().mo8b((Object) this);
//    }
//
//    public void onResume() {
//        super.onResume();
//        updateNotifications();
//    }
//
//    private void updateNotifications() {
//        int size = FriendManager.getInstance().getNotifications().size();
//        C0789L.log.info("updateNotifications " + size);
//        if (size > 0) {
//            this.mNotifications.setText(String.format(Locale.CHINA, "你有%d条好友请求", new Object[]{Integer.valueOf(size)}));
//            if (this.mNotificationLine.getVisibility() == 8) {
//                this.mNotificationLine.setVisibility(0);
//                return;
//            }
//            return;
//        }
//        this.mNotificationLine.setVisibility(8);
//    }
//
//    public void onEventMainThread(NotificationUpdateEvent notificationUpdateEvent) {
//        updateNotifications();
////        EventBus.m0a().mo7b(NotificationUpdateEvent.class);
//    }
//
//    public void onEventMainThread(FriendsUpdateEvent friendsUpdateEvent) {
//        if (FriendManager.getInstance().getFriendNumber() == 0) {
//            this.mEmptyView.setText(R.string.friend_empty_friends_prompt);
//        }
//        this.mGridAdapter.update();
//    }
//}
