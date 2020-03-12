//package com.baicizhan.client.friend.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ListView;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.framework.network.VolleyUtils;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.adapter.FriendNotificationAdapter;
//import com.baicizhan.client.friend.model.FriendNotification;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.utils.FriendURL;
//import com.jiongji.andriod.card.R;
//import com.umeng.p092a.MobclickAgent;
//import java.util.Iterator;
//import java.util.LinkedList;
//
//public class FriendNotificationActivity extends Activity implements OnClickListener {
//    FriendNotificationAdapter mAdapter;
//    ListView mListView;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.friend_notification_activity);
//            this.mListView = (ListView) findViewById(R.id.notifications);
//            this.mAdapter = new FriendNotificationAdapter(this);
//            this.mListView.setEmptyView(findViewById(R.id.empty_view));
//            this.mListView.setAdapter(this.mAdapter);
//            LinkedList notifications = FriendManager.getInstance().getNotifications();
//            this.mAdapter.updateNotifications(notifications);
//            Iterator it = notifications.iterator();
//            while (it.hasNext()) {
//                if (((FriendNotification) it.next()).getMsgType() == FriendNotification.ACCEPT) {
//                    it.remove();
//                }
//            }
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
//    public void onResume() {
//        super.onResume();
//        try {
//            MobclickAgent.m5136b((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_IGNORE_FRIEND);
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_ACCEPT_FRIEND);
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.back) {
//            finish();
//        }
//    }
//}
