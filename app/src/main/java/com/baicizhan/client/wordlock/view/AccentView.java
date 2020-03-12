//package com.baicizhan.client.wordlock.view;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.graphics.drawable.Drawable;
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import com.baicizhan.client.business.search.ResourceManager;
//import com.baicizhan.client.business.search.Word;
//import com.baicizhan.client.framework.audio.AudioPlayer;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.util.CustomFont;
//import com.baicizhan.client.wordlock.util.Utils;
//import com.jiongji.andriod.card.R;
//
//public class AccentView extends RelativeLayout {
//    private TextView mAccent;
//    private Handler mAudioHandler;
//    /* access modifiers changed from: private */
//    public AudioPlayer mAudioPlayer;
//    private HandlerThread mHandlerThread;
//    /* access modifiers changed from: private */
//    public Word mWordData;
//
//    public AccentView(Context context) {
//        super(context);
//    }
//
//    public AccentView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        this.mAudioPlayer = new AudioPlayer(getContext());
//        if (this.mHandlerThread != null && this.mHandlerThread.isAlive()) {
//            this.mHandlerThread.quit();
//        }
//        this.mHandlerThread = new HandlerThread("AccentView");
//        this.mHandlerThread.start();
//        this.mAudioHandler = new Handler(this.mHandlerThread.getLooper());
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        this.mAudioPlayer.destroy();
//        this.mHandlerThread.quit();
//        this.mAudioHandler = null;
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mAccent = (TextView) findViewById(R.id.wordlock_accent);
//        CustomFont.setFont(this.mAccent, 3);
//    }
//
//    @SuppressLint({"ClickableViewAccessibility"})
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        switch (motionEvent.getAction()) {
//            case 0:
//                this.mAccent.setPressed(true);
//                break;
//            case 1:
//            case 3:
//                this.mAccent.setPressed(false);
//                break;
//        }
//        return super.onTouchEvent(motionEvent);
//    }
//
//    public void setAccent(String str, Word word, boolean z) {
//        this.mWordData = word;
//        String str2 = word != null ? word.getAudio() : null;
//        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
//            setVisibility(4);
//        } else if (TextUtils.isEmpty(str2)) {
//            if (!TextUtils.equals(str, this.mAccent.getText())) {
//                if (z) {
//                    Utils.setStressedAccentColor(this.mAccent, str);
//                } else {
//                    this.mAccent.setText(str);
//                }
//            }
//            this.mAccent.setCompoundDrawables(null, null, null, null);
//            setOnClickListener(null);
//        } else {
//            if (!TextUtils.equals(str, this.mAccent.getText())) {
//                if (z) {
//                    Utils.setStressedAccentColor(this.mAccent, str);
//                } else {
//                    this.mAccent.setText(str);
//                }
//            }
//            if (!ResourceManager.isAudioExists(word)) {
//                this.mAccent.setCompoundDrawables(null, null, null, null);
//                setOnClickListener(null);
//                if (TextUtils.isEmpty(str)) {
//                    setVisibility(4);
//                    return;
//                }
//                return;
//            }
//            Drawable drawable = getResources().getDrawable(R.drawable.wordlock_speaker_selector);
//            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//            this.mAccent.setCompoundDrawables(null, null, drawable, null);
//            setOnClickListener(new OnClickListener() {
//                public void onClick(View view) {
//                    AccentView.this.pronounceWord();
//                }
//            });
//        }
//    }
//
//    public void pronounceWord() {
//        if (this.mAudioHandler != null) {
//            this.mAudioHandler.post(new Runnable() {
//                public void run() {
//                    ResourceManager.playAudio(AccentView.this.mAudioPlayer, AccentView.this.mWordData);
//                }
//            });
//        }
//    }
//}
