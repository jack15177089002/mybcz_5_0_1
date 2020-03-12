//package com.baicizhan.client.wordlock.view;
//
//import android.content.Context;
//import android.graphics.Rect;
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.AccelerateInterpolator;
//import android.view.animation.AlphaAnimation;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationSet;
//import android.view.animation.AnimationUtils;
//import android.view.animation.DecelerateInterpolator;
//import android.view.animation.RotateAnimation;
//import android.view.animation.ScaleAnimation;
//import android.view.animation.TranslateAnimation;
//import android.widget.ImageView;
//import com.baicizhan.client.framework.audio.AudioPlayer;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.DropBackEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.KillTipEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.KillWordEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.RefreshKilledWordCountEvent;
//import com.baicizhan.client.wordlock.view.drag.DragSource;
//import com.baicizhan.client.wordlock.view.drag.DragView;
//import com.baicizhan.client.wordlock.view.drag.DropSpot;
//import com.jiongji.andriod.card.R;
////import p000a.p001a.p002a.EventBus;
//
//public class KillWordSpot extends DropSpot {
//    private Handler mAudioHandler = null;
//    /* access modifiers changed from: private */
//    public AudioPlayer mAudioPlayer = null;
//    private HandlerThread mHandlerThread = new HandlerThread("lock_thread");
//    private View mKillTip;
//    /* access modifiers changed from: private */
//    public View mSwordBG;
//    /* access modifiers changed from: private */
//    public ImageView mSwordLine;
//
//    public KillWordSpot(Context context) {
//        super(context);
//    }
//
//    public KillWordSpot(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public KillWordSpot(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//    }
//
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
////        EventBus.m0a().mo5a((Object) this);
//        this.mAudioPlayer = new AudioPlayer(getContext());
//        this.mHandlerThread.start();
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
////        EventBus.m0a().mo8b((Object) this);
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.destroy();
//            this.mAudioPlayer = null;
//        }
//        this.mHandlerThread.quit();
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mSwordLine = (ImageView) findViewById(R.id.wordlock_sword_line);
//        this.mKillTip = findViewById(R.id.wordlock_kill_tag);
//    }
//
//    /* access modifiers changed from: protected */
//    public int getEnteredBackgroundRes() {
//        return R.color.wordlock_drag_enter_kill_word_color;
//    }
//
//    /* access modifiers changed from: protected */
//    public void doDrop(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
//        if (dragSource != null && (dragSource instanceof ViewGroup)) {
//            this.mSwordBG = ((ViewGroup) dragSource).findViewById(R.id.wordlock_sword_bg);
//        }
//        float popScale = dragView.getPopScale();
//        View view = (View) obj;
//        TranslateAnimation translateAnimation = new TranslateAnimation(0, ((float) ((i - i3) - view.getLeft())) / popScale, 0, 0.0f, 0, (float) ((int) (((float) (((Math.min(i2, getHeight() - ((int) (((float) (view.getHeight() - i4)) * popScale))) - i4) - view.getTop()) + getTop())) / popScale)), 0, (float) (((getTop() - view.getTop()) + (getHeight() / 2)) - (view.getHeight() / 2)));
//        ScaleAnimation scaleAnimation = new ScaleAnimation(popScale, 1.0f, popScale, 1.0f, (float) (view.getWidth() / 2), (float) (view.getHeight() / 2));
//        scaleAnimation.setDuration(200);
//        translateAnimation.setDuration(200);
//        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.addAnimation(translateAnimation);
//        animationSet.addAnimation(scaleAnimation);
//        animationSet.setFillAfter(true);
//        view.startAnimation(animationSet);
//        killAnim(view);
////        KillWordEvent killWordEvent = new KillWordEvent();
////        killWordEvent.setAnimdur(500);
////        Rect rect = new Rect();
////        getGlobalVisibleRect(rect);
////        killWordEvent.setBlastPoint(rect.centerX(), rect.centerY());
////        EventBus.m0a().mo9c((Object) killWordEvent);
////        DropBackEvent dropBackEvent = new DropBackEvent();
////        dropBackEvent.setFrom(2);
////        dropBackEvent.setAnimdur(200);
////        EventBus.m0a().mo9c((Object) dropBackEvent);
////        RefreshKilledWordCountEvent refreshKilledWordCountEvent = new RefreshKilledWordCountEvent();
////        refreshKilledWordCountEvent.setDeltaCount(1);
////        EventBus.m0a().mo9c((Object) refreshKilledWordCountEvent);
//    }
//
//    private void killAnim(final View view) {
//        if (this.mSwordBG != null) {
//            this.mSwordBG.setVisibility(0);
//            this.mSwordBG.setBackgroundResource(R.color.wordlock_drag_enter_kill_word_color);
//        }
//        postDelayed(new Runnable() {
//            public void run() {
//                KillWordSpot.this.dokillAnim(view);
//            }
//        }, 200);
//    }
//
//    private void playKillSound() {
//        if (this.mAudioHandler == null) {
//            this.mAudioHandler = new Handler(this.mHandlerThread.getLooper());
//        }
//        this.mAudioHandler.post(new Runnable() {
//            public void run() {
//                if (KillWordSpot.this.mAudioPlayer != null) {
//                    KillWordSpot.this.mAudioPlayer.stop();
//                    KillWordSpot.this.mAudioPlayer.newPlayRaw(R.raw.chop);
//                }
//            }
//        });
//    }
//
//    /* access modifiers changed from: private */
//    public void dokillAnim(final View view) {
//        double degrees = Math.toDegrees(Math.atan(((double) view.getHeight()) / ((double) view.getWidth())));
//        RotateAnimation rotateAnimation = new RotateAnimation(-((float) degrees), -((float) degrees), (float) (this.mSwordLine.getWidth() / 2), (float) (this.mSwordLine.getHeight() / 2));
//        rotateAnimation.setDuration(100);
//        int width = (this.mSwordLine.getWidth() / 2) + ((view.getWidth() - this.mSwordLine.getWidth()) / 2);
//        int height = (this.mSwordLine.getHeight() / 2) + ((view.getHeight() - this.mSwordLine.getHeight()) / 2);
//        TranslateAnimation translateAnimation = new TranslateAnimation((float) (-width), (float) width, (float) height, (float) (-height));
//        translateAnimation.setDuration(100);
//        translateAnimation.setInterpolator(new AccelerateInterpolator());
//        translateAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//                KillWordSpot.this.mSwordLine.setVisibility(4);
//                view.setVisibility(4);
//                KillWordSpot.this.splash();
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            public void onAnimationStart(Animation animation) {
//                KillWordSpot.this.mSwordLine.setVisibility(0);
//            }
//        });
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.4f, 1.0f);
//        alphaAnimation.setDuration(100);
//        AnimationSet animationSet = new AnimationSet(false);
//        animationSet.addAnimation(rotateAnimation);
//        animationSet.addAnimation(translateAnimation);
//        animationSet.addAnimation(alphaAnimation);
//        this.mSwordLine.startAnimation(animationSet);
//        playKillSound();
//    }
//
//    /* access modifiers changed from: private */
//    public void splash() {
//        if (this.mSwordBG != null) {
//            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.wordlock_fade_out);
//            loadAnimation.setStartOffset(50);
//            loadAnimation.setAnimationListener(new AnimationListener() {
//                public void onAnimationEnd(Animation animation) {
//                    KillWordSpot.this.mSwordBG.setVisibility(4);
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//
//                public void onAnimationStart(Animation animation) {
//                    KillWordSpot.this.mSwordBG.setVisibility(0);
//                    KillWordSpot.this.mSwordBG.setBackgroundResource(17170443);
//                }
//            });
//            this.mSwordBG.startAnimation(loadAnimation);
//        }
//    }
//
//    public void onDragEnter(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
//        super.onDragEnter(dragSource, i, i2, i3, i4, dragView, obj);
//        hideKillTip();
//    }
//
//    public void onDragExit(DragSource dragSource, int i, int i2, int i3, int i4, DragView dragView, Object obj) {
//        super.onDragExit(dragSource, i, i2, i3, i4, dragView, obj);
//        if (!intersects(dragView)) {
//            showKillTip();
//        }
//    }
//
//    public void onEventMainThread(KillTipEvent killTipEvent) {
//        if (killTipEvent.isShowtip()) {
//            showKillTip();
//        } else {
//            hideKillTip();
//        }
//    }
//
//    private void showKillTip() {
//        if (this.mKillTip.getVisibility() != 0) {
//            this.mKillTip.setVisibility(0);
//            this.mKillTip.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.wordlock_fade_in_short));
//        }
//    }
//
//    private void hideKillTip() {
//        if (this.mKillTip.getVisibility() == 0) {
//            this.mKillTip.setVisibility(4);
//            this.mKillTip.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.wordlock_fade_out_short));
//        }
//    }
//}
