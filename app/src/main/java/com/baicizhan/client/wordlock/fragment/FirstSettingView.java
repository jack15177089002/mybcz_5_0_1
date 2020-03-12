//package com.baicizhan.client.wordlock.fragment;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.AnimationUtils;
//import android.widget.Button;
//import android.widget.RelativeLayout;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.activity.WordLockClient;
//import com.baicizhan.client.wordlock.service.WordLockDaemon;
//import com.baicizhan.client.wordlock.setting.Settings;
//import com.jiongji.andriod.card.R;
//
//public class FirstSettingView extends RelativeLayout implements OnClickListener {
//    private Button mCloseLock;
//    private OnWordLockToggleListener mListener;
//    private Button mOpenLock;
//
//    public interface OnWordLockToggleListener {
//        void onWordLockToggle(boolean z);
//    }
//
//    public void setOnWordLockToggleListener(OnWordLockToggleListener onWordLockToggleListener) {
//        this.mListener = onWordLockToggleListener;
//    }
//
//    public FirstSettingView(Context context) {
//        super(context);
//    }
//
//    public FirstSettingView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mOpenLock = (Button) findViewById(R.id.wordlock_settings_open_lock);
//        this.mCloseLock = (Button) findViewById(R.id.wordlock_settings_close_lock);
//        this.mOpenLock.setOnClickListener(this);
//        this.mCloseLock.setOnClickListener(this);
//        setOnClickListener(this);
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//    }
//
//    public void onClick(View view) {
//        if (view == this.mCloseLock) {
//            Settings.setFirstSetLockScreen(false);
//            Settings.setWordLockscreenEnabled(false);
//            Context context = getContext();
//            WordLockDaemon.stop(context);
//            if (context instanceof WordLockClient) {
//                ((WordLockClient) context).setWillRefreshWhenStop(false);
//            }
//            if (this.mListener != null) {
//                this.mListener.onWordLockToggle(false);
//            }
//            setVisibility(8);
//            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.wordlock_fade_out));
//        } else if (view == this.mOpenLock) {
//            Settings.setFirstSetLockScreen(false);
//            Settings.setWordLockscreenEnabled(true);
//            if (this.mListener != null) {
//                this.mListener.onWordLockToggle(true);
//            }
//            setVisibility(8);
//            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.wordlock_fade_out));
//        }
//    }
//}
