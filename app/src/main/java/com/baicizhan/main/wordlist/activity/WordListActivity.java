//package com.baicizhan.main.wordlist.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.p004v4.app.FragmentActivity;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.jiongji.andriod.card.R;
//
//public class WordListActivity extends FragmentActivity {
//    private static final String TAG = WordListActivity.class.getName();
//
//    public static final void start(Context context) {
//        context.startActivity(new Intent(context, WordListActivity.class));
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, true);
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        tryKillSelf(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView(R.layout.wordlist_main);
//    }
//
//    private void tryKillSelf(Bundle bundle) {
//        if (bundle != null && bundle.getBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, false)) {
//            LogWrapper.m2794e(TAG, TAG + " is recreated and data is lost, exit!");
//            System.exit(0);
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//    }
//
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//    }
//}
