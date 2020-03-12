//package com.baicizhan.client.p029fm.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
////import android.support.p004v4.app.FragmentActivity;
//import androidx.fragment.app.FragmentActivity;
//
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.WordErrFeedbackFragment.OnFBFragmentInteractionListener;
////import com.baicizhan.client.p029fm.R;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.PopupEvent;
//import com.baicizhan.client.p029fm.view.FmView;
//import com.jiongji.andriod.card.R;
////import p000a.p001a.p002a.EventBus;
//
///* renamed from: com.baicizhan.client.fm.activity.FmActivity */
//public class FmActivity extends FragmentActivity implements OnFBFragmentInteractionListener {
//    private FmView mFmView;
//
//    public static void start(Context context) {
//        context.startActivity(new Intent(context, FmActivity.class));
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView(R.layout.fm_main_layout);
//        getWindow().addFlags(128);
//        setVolumeControlStream(3);
////        this.mFmView = (FmView) findViewById(R.C0750id.fm_view);
//        this.mFmView.start();
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
//        this.mFmView.close();
//    }
//
//    public void onFBDetach() {
////        PopupEvent popupEvent = new PopupEvent();
////        popupEvent.setState(1);
////        EventBus.m0a().mo9c((Object) popupEvent);
//    }
//}
