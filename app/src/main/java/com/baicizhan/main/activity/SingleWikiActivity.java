//package com.baicizhan.main.activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.p004v4.app.FragmentActivity;
//import android.support.p004v4.app.FragmentTransaction;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.main.fragment.WikiFragment;
//import com.baicizhan.main.fragment.WikiFragment.WikiListener;
//import com.jiongji.andriod.card.R;
//
//public class SingleWikiActivity extends FragmentActivity implements WikiListener {
//    public static final String EXTRA_IS_KILLED = "extra_is_killed";
//    public static final String EXTRA_TOPIC_RECORD = "extra_topic_record";
//    public static final String EXTRA_WIKI_STYLE = "extra_wiki_style";
//    private TopicRecord mRecord;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_single_wiki);
//            Intent intent = getIntent();
//            this.mRecord = (TopicRecord) intent.getParcelableExtra(EXTRA_TOPIC_RECORD);
//            int intExtra = intent.getIntExtra(EXTRA_WIKI_STYLE, 0) | 4;
//            if (this.mRecord == null) {
//                throw new IllegalArgumentException("必须传入一个 非空 TopicRecord对象以显示.");
//            }
//            FragmentTransaction a = getSupportFragmentManager().mo313a();
//            WikiFragment instance = WikiFragment.getInstance(this.mRecord, intExtra);
//            instance.setWikiListener(this);
//            a.mo180a(R.id.frame, instance, null);
//            a.mo183b();
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
//    public void onWikiExit() {
//        Intent intent = new Intent();
//        intent.putExtra(EXTRA_IS_KILLED, LearnRecordManager.getInstance().isKilled(this.mRecord.topicId));
//        setResult(-1, intent);
//        finish();
//    }
//}
