//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.jiongji.andriod.card.R;
//import p116pl.droidsonroids.gif.GifImageView;
//
//public class DanceActivity extends Activity implements OnClickListener {
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_dance);
//            GifImageView gifImageView = (GifImageView) findViewById(R.id.dance_gif);
//            gifImageView.setImageResource(R.drawable.congratulate_normal_default);
//            gifImageView.setOnClickListener(this);
//            findViewById(R.id.back).setOnClickListener(this);
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
//    public void onClick(View view) {
//        overridePendingTransition(17432576, 17432577);
//        finish();
//    }
//}
