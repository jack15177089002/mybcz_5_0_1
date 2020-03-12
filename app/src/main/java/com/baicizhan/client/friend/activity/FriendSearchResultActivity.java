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
//import com.baicizhan.client.friend.adapter.FriendSuggestionAdapter;
//import com.baicizhan.client.friend.adapter.FriendSuggestionAdapter.Mode;
//import com.baicizhan.client.friend.utils.FriendURL;
//import com.jiongji.andriod.card.R;
//import com.umeng.p092a.MobclickAgent;
//import java.util.ArrayList;
//
//public class FriendSearchResultActivity extends Activity implements OnClickListener {
//    public static final String EXTRA_SEARCH_RESULT = "search_result";
//    public static final String TAG = FriendSearchActivity.class.getSimpleName();
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.friend_search_result_activity);
//            ListView listView = (ListView) findViewById(R.id.suggestion_grid);
//            FriendSuggestionAdapter friendSuggestionAdapter = new FriendSuggestionAdapter(this, Mode.SEARCH);
//            listView.setAdapter(friendSuggestionAdapter);
//            friendSuggestionAdapter.update((ArrayList) getIntent().getSerializableExtra(EXTRA_SEARCH_RESULT));
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_APPLY_FRIEND);
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.back) {
//            finish();
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
//}
