//package com.baicizhan.main.plusreview.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.p004v4.app.FragmentActivity;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.helpers.KVHelper;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.RecycleableImageView;
//import com.jiongji.andriod.card.R;
//
//public class PlusReviewEnter extends FragmentActivity implements OnClickListener {
//    private static final String TAG = PlusReviewEnter.class.getName();
//    private TextView mHeadMsg;
//    private View mHome;
//    private RecycleableImageView mToListen;
//    private RecycleableImageView mToMatch;
//    private View mToMatchInfo;
//    private RecycleableImageView mToRead;
//    private RecycleableImageView mToWrite;
//
//    public static void start(Context context) {
//        context.startActivity(new Intent(context, PlusReviewEnter.class));
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            tryKillSelf(bundle);
//            setContentView(R.layout.plusreview_entrance_layout);
//            initViews();
//        }
//    }
//
//    private void tryKillSelf(Bundle bundle) {
//        if (bundle != null && bundle.getBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, false)) {
//            LogWrapper.m2794e(TAG, TAG + " is recreated and data is lost, exit!");
//            System.exit(0);
//        }
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putBoolean(ConstantsUtil.STATE_EXIT_FOR_RECREATE, true);
//    }
//
//    private void initViews() {
//        this.mHome = findViewById(R.id.plusreview_home);
//        this.mHome.setOnClickListener(this);
//        this.mHeadMsg = (TextView) findViewById(R.id.plusreview_entrance_head_msg);
//        this.mHeadMsg.setText(getString(R.string.plusreview_entrance_head_msg, new Object[]{StudyManager.getInstance().getCurrentUser().getVerboseSex()}));
//        this.mToListen = (RecycleableImageView) findViewById(R.id.plusreview_to_listen);
//        this.mToListen.setOnClickListener(this);
//        this.mToRead = (RecycleableImageView) findViewById(R.id.plusreview_to_read);
//        this.mToRead.setOnClickListener(this);
//        this.mToWrite = (RecycleableImageView) findViewById(R.id.plusreview_to_write);
//        this.mToWrite.setOnClickListener(this);
//        this.mToMatch = (RecycleableImageView) findViewById(R.id.plusreview_to_match);
//        this.mToMatch.setOnClickListener(this);
//        this.mToMatchInfo = findViewById(R.id.plusreview_to_match_info);
//        this.mToMatchInfo.setOnClickListener(this);
//        View findViewById = findViewById(R.id.plusreview_to_match_container);
//        if (0 == KVHelper.getLong(this, KVHelper.KEY_USER_HAS_WORD_FRIENDS)) {
//            findViewById.setVisibility(8);
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
//
//    public void onDestroy() {
//        super.onDestroy();
//        this.mToListen.recycleOnDestroy();
//        this.mToRead.recycleOnDestroy();
//        this.mToWrite.recycleOnDestroy();
//        this.mToMatch.recycleOnDestroy();
//        System.gc();
//    }
//
//    public void onClick(View view) {
//        if (view == this.mHome) {
//            finish();
//        } else if (view == this.mToListen) {
//            toListen();
//        } else if (view == this.mToRead) {
//            toRead();
//        } else if (view == this.mToWrite) {
//            toWrite();
//        } else if (view == this.mToMatch) {
//            toMatch();
//        } else if (view == this.mToMatchInfo) {
//            toMatchInfo();
//        }
//    }
//
//    private void toListen() {
//        DefaultPreloadActivity.startListen(this);
//        UMStats.statPlusreviewListenClick(this);
//        OperationStats.statReviewListen();
//    }
//
//    private void toRead() {
//        DefaultPreloadActivity.startRead(this);
//        UMStats.statPlusreviewReadClick(this);
//        OperationStats.statReviewRead();
//    }
//
//    private void toWrite() {
//        DefaultPreloadActivity.startWrite(this);
//        UMStats.statPlusreviewWriteClick(this);
//        OperationStats.statReviewSpell();
//    }
//
//    private void toMatch() {
//        DefaultPreloadActivity.startMatch(this);
//        UMStats.statPlusreviewMatchClick(this);
//        OperationStats.statReviewMatch();
//    }
//
//    private void toMatchInfo() {
//        ToMatchInfoFragment.newInstance().show(getSupportFragmentManager(), "matchInfo");
//    }
//}
