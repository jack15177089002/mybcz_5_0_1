//package com.baicizhan.client.wordlock.fragment;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.os.MessageQueue.IdleHandler;
////import android.support.p004v4.app.Fragment;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnLongClickListener;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationSet;
//import android.view.animation.AnimationUtils;
//import android.view.animation.DecelerateInterpolator;
//import android.view.animation.OvershootInterpolator;
//import android.view.animation.ScaleAnimation;
//import android.view.animation.TranslateAnimation;
//import android.widget.ImageView;
//import android.widget.RelativeLayout.LayoutParams;
//import android.widget.Scroller;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//
//import com.baicizhan.client.business.search.ResourceManager;
//import com.baicizhan.client.business.search.ResourceManager.OnResourceGetListener;
//import com.baicizhan.client.business.search.Word;
//import com.baicizhan.client.framework.util.Common;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.WordLockApp;
//import com.baicizhan.client.wordlock.activity.WordLockClient;
//import com.baicizhan.client.wordlock.data.WordToReviewCache;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.DispMoreInfoEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.DropBackEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.HelpGuideEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.ToggleControllerEvent;
//import com.baicizhan.client.wordlock.setting.Settings;
//import com.baicizhan.client.wordlock.util.CustomFont;
//import com.baicizhan.client.wordlock.util.EasingType.Type;
//import com.baicizhan.client.wordlock.util.ElasticInterpolator;
//import com.baicizhan.client.wordlock.util.Utils;
//import com.baicizhan.client.wordlock.view.AccentView;
//import com.baicizhan.client.wordlock.view.CustomTextView;
//import com.baicizhan.client.wordlock.view.drag.DragController;
//import com.baicizhan.client.wordlock.view.drag.DragLayer;
//import com.baicizhan.client.wordlock.view.drag.DragObservers;
//import com.baicizhan.client.wordlock.view.drag.DropSpot;
//import com.jiongji.andriod.card.R;
//import com.p047d.p050c.ViewHelper;
//import java.lang.ref.WeakReference;
////import p000a.p001a.p002a.EventBus;
//
//public class WordFragment extends Fragment implements OnClickListener, OnLongClickListener {
//    public static final int ANIM_PUSH_WORD_BACK = 1;
//    private static final int GUIDE_ACTION_CLICK = 0;
//    private static final int GUIDE_ACTION_LONG_CLICK = 1;
//    private static final int GUIDE_ACTION_NOT_CARE = 2;
//    private static final String KEY_FIRST = "first";
//    private static final String KEY_FORCE_TOMORE = "force_tomore";
//    private static final String KEY_WORD = "word";
//    /* access modifiers changed from: private */
//    public AccentView mAccent;
//    private Handler mAnimationHandler = new Handler() {
//        public void handleMessage(Message message) {
//            int i = message.what;
//            switch (i) {
//                case 1:
//                    WordFragment.this.mScroller.computeScrollOffset();
//                    int currY = WordFragment.this.mScroller.getCurrY();
//                    WordFragment.this.offsetWord(currY - WordFragment.this.mLastOffset);
//                    WordFragment.this.mLastOffset = currY;
//                    if (WordFragment.this.mScroller.isFinished()) {
//                        WordFragment.this.offsetWord(-WordFragment.this.mTotalOffset);
//                        return;
//                    } else {
//                        sendEmptyMessage(i);
//                        return;
//                    }
//                default:
//                    return;
//            }
//        }
//    };
//    /* access modifiers changed from: private */
//    public TextView mCnmean;
//    private DragController mDragController;
//    private DragLayer mDragLayer;
//    private DragObservers mDragObservers;
//    private boolean mFirstPage = false;
//    private boolean mForceTomore = false;
//    private ImageView mGuide;
//    private Handler mHandler = new Handler();
//    private boolean mInmoreState = false;
//    private DropSpot mKillWordSpot;
//    /* access modifiers changed from: private */
//    public int mLastOffset = 0;
//    private DropSpot mMoreInfoSpot;
//    private int mPullWordDistance = 30;
//    private int mPullWordMaxDistance = 300;
//    /* access modifiers changed from: private */
//    public ResourceManager mResMng;
//    /* access modifiers changed from: private */
//    public Scroller mScroller;
//    private float mToMoreInfoScale;
//    /* access modifiers changed from: private */
//    public int mTotalOffset = 0;
//    /* access modifiers changed from: private */
//    public CustomTextView mWord;
//    /* access modifiers changed from: private */
//    public Word mWordData;
//    private WordRefreshCallback mWordRefreshCBK;
//
//    class WordRefreshCallback implements OnResourceGetListener {
//        final WeakReference<WordFragment> mFragment;
//
//        WordRefreshCallback(WordFragment wordFragment) {
//            this.mFragment = new WeakReference<>(wordFragment);
//        }
//
//        public void onResourceGet(Word word, int i, String str) {
//            WordFragment wordFragment = (WordFragment) this.mFragment.get();
//            if (wordFragment != null && wordFragment.getActivity() != null && word != null) {
//                if (-300 == i) {
//                    WordLockApp.setKillOnDestroy(true);
//                }
//                if (wordFragment.mWordData == null || wordFragment.mWordData.getId().equals(word.getId())) {
//                    if (wordFragment.mWordData != null) {
//                        word.setSearch(wordFragment.mWordData.isSearch());
//                    }
//                    WordToReviewCache.refreshElement(word);
//                    wordFragment.mWordData = word;
//                    wordFragment.setupViews();
//                }
//            }
//        }
//    }
//
//    public static WordFragment newInstance(Word word, boolean z, boolean z2) {
//        WordFragment wordFragment = new WordFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("word", word);
//        bundle.putBoolean(KEY_FIRST, z);
//        bundle.putBoolean(KEY_FORCE_TOMORE, z2);
//        wordFragment.setArguments(bundle);
//        return wordFragment;
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        this.mDragObservers = ((WordLockClient) activity).getDragObservers();
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        float f = displayMetrics.density;
//        this.mPullWordDistance = (int) (((float) this.mPullWordDistance) * f);
//        this.mPullWordMaxDistance = (int) (f * ((float) this.mPullWordMaxDistance));
//        this.mScroller = new Scroller(activity, new DecelerateInterpolator(1.2f));
//    }
//
//    public void onCreate(Bundle bundle) {
//        boolean z;
//        boolean z2 = false;
//        super.onCreate(bundle);
//        this.mWordData = getArguments() != null ? (Word) getArguments().getParcelable("word") : null;
//        if (getArguments() == null || !getArguments().getBoolean(KEY_FIRST)) {
//            z = false;
//        } else {
//            z = true;
//        }
//        this.mFirstPage = z;
//        if (getArguments() != null && getArguments().getBoolean(KEY_FORCE_TOMORE)) {
//            z2 = true;
//        }
//        this.mForceTomore = z2;
//        this.mWordRefreshCBK = new WordRefreshCallback(this);
//        this.mResMng = ResourceManager.born().setListener(this.mWordRefreshCBK).setMode(1);
////        EventBus.m0a().mo5a((Object) this);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.wordlock_client_drag, viewGroup, false);
//        this.mDragController = new DragController(getActivity());
//        initViews(viewGroup2);
//        setupViews();
//        if (Utils.shouldFullScreen()) {
//            LayoutParams layoutParams = (LayoutParams) this.mWord.getLayoutParams();
//            layoutParams.topMargin += Common.getStatusBarHeight(getActivity());
//            this.mWord.setLayoutParams(layoutParams);
//            LayoutParams layoutParams2 = (LayoutParams) this.mGuide.getLayoutParams();
//            layoutParams2.bottomMargin -= Common.getStatusBarHeight(getActivity());
//            this.mGuide.setLayoutParams(layoutParams2);
//        }
//        Looper.myQueue().addIdleHandler(new IdleHandler() {
//            public boolean queueIdle() {
//                int top = WordFragment.this.mAccent.getTop();
//                LayoutParams layoutParams = (LayoutParams) WordFragment.this.mAccent.getLayoutParams();
//                layoutParams.addRule(3, 0);
//                layoutParams.topMargin = top;
//                WordFragment.this.mAccent.requestLayout();
//                return false;
//            }
//        });
//        if (this.mForceTomore && this.mFirstPage) {
//            this.mWord.post(new Runnable() {
//                public void run() {
//                    WordFragment.this.toMoreInfo();
//                }
//            });
//        }
//        return viewGroup2;
//    }
//
//    /* access modifiers changed from: private */
//    public void setupViews() {
//        this.mDragLayer.setOnLongClickListener(this);
//        this.mDragLayer.setDragController(this.mDragController);
//        this.mDragController.addDropTarget(this.mDragLayer);
//        this.mDragLayer.setDragObservers(this.mDragObservers);
//        String str = this.mWordData != null ? this.mWordData.getWord() : "";
//        String str2 = this.mWordData != null ? this.mWordData.getAccent() : "";
//        CustomFont.setFont(this.mWord, 0);
//        this.mWord.setCustomLongClickListener(this);
//        this.mWord.setOnClickListener(this);
//        Utils.reSizeText(getActivity(), this.mWord, str, R.dimen.wordlock_word_size, 0.8f);
//        Utils.setStressedWordColor(this.mWord, str, str2);
//        this.mToMoreInfoScale = Math.min(((float) getActivity().getResources().getDimensionPixelSize(R.dimen.wordlock_mini_word_size)) / this.mWord.getTextSize(), 1.0f);
//        if (!this.mInmoreState) {
//            this.mAccent.setVisibility(0);
//        }
//        this.mAccent.setAccent(str2, this.mWordData, false);
//        CustomFont.setFont(this.mCnmean, 0);
//        this.mCnmean.setText(this.mWordData != null ? this.mWordData.getCnmean() : "");
//        if (this.mWordData.isSearch()) {
//            this.mKillWordSpot.setup(null, null);
//            this.mKillWordSpot.setDragObservers(null);
//            this.mKillWordSpot.setVisibility(8);
//        } else {
//            this.mKillWordSpot.setup(this.mDragLayer, this.mDragController);
//            this.mKillWordSpot.setDragObservers(this.mDragObservers);
//        }
//        this.mGuide.setOnClickListener(this);
//        if (!Settings.isLockScreenFirstSet()) {
//            nextGuide(false);
//        }
//    }
//
//    private void initViews(View view) {
//        this.mDragLayer = (DragLayer) view.findViewById(R.id.wordlock_draglayer);
//        this.mWord = (CustomTextView) view.findViewById(R.id.wordlock_word);
//        this.mAccent = (AccentView) view.findViewById(R.id.wordlock_accent_wrapper);
//        this.mCnmean = (TextView) view.findViewById(R.id.wordlock_cnmean);
//        this.mMoreInfoSpot = (DropSpot) view.findViewById(R.id.wordlock_to_more_info);
//        this.mKillWordSpot = (DropSpot) view.findViewById(R.id.wordlock_to_kill_word);
//        this.mGuide = (ImageView) view.findViewById(R.id.wordlock_guide);
//    }
//
//    public void onStart() {
//        super.onStart();
//        this.mResMng.get(getActivity(), this.mWordData);
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
////        EventBus.m0a().mo8b((Object) this);
//    }
//
//    public void onClick(View view) {
//        if (view == this.mWord) {
//            view.setSelected(true);
//            toMoreInfo();
//        } else if (view == this.mGuide) {
//            processedGuide(2);
//        }
//    }
//
//    public void toMoreInfo() {
//        int playWordAnim;
//        if (NavigationManager.canNavToMore()) {
//            NavigationManager.setNavingToMore(true);
//            processedGuide(2);
//            if (!this.mInmoreState) {
//                this.mInmoreState = true;
//                if (this.mTotalOffset > 0) {
//                    playWordAnim = playWordAnimElastic();
//                } else {
//                    playWordAnim = playWordAnim();
//                }
//                fadeAccentAndMean(false);
//                displayController(false);
//                this.mAccent.pronounceWord();
////                DispMoreInfoEvent dispMoreInfoEvent = new DispMoreInfoEvent();
////                dispMoreInfoEvent.setDelayed((long) playWordAnim);
////                EventBus.m0a().mo9c((Object) dispMoreInfoEvent);
//            }
//        }
//    }
//
//    private int playWordAnim() {
//        float dip2px = ((float) Common.dip2px(getActivity(), 26.0f)) - (((float) this.mWord.getPaddingLeft()) * this.mToMoreInfoScale);
//        float dip2px2 = ((float) Common.dip2px(getActivity(), 28.0f)) - (((float) this.mWord.getPaddingTop()) * this.mToMoreInfoScale);
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.setInterpolator(new OvershootInterpolator(1.2f));
//        animationSet.setFillAfter(true);
//        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.mToMoreInfoScale, 1.0f, this.mToMoreInfoScale, 0.0f, 0.0f);
//        scaleAnimation.setDuration(400);
//        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (((float) (-this.mWord.getLeft())) + dip2px) / this.mToMoreInfoScale, 0.0f, (((float) (-this.mWord.getTop())) + dip2px2) / this.mToMoreInfoScale);
//        translateAnimation.setDuration(400);
//        animationSet.addAnimation(translateAnimation);
//        animationSet.addAnimation(scaleAnimation);
//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.6f);
//        alphaAnimation.setDuration(400);
//        animationSet.addAnimation(alphaAnimation);
//        scaleAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
//                WordFragment.this.mWord.setSelected(false);
//                ViewHelper.m3389a(WordFragment.this.mAccent, 1.0f);
//                ViewHelper.m3389a(WordFragment.this.mCnmean, 1.0f);
//            }
//        });
//        this.mWord.setEnabled(false);
//        this.mWord.startAnimation(animationSet);
//        return 400;
//    }
//
//    private int playWordAnimElastic() {
//        ViewHelper.m3390b(this.mWord, 0.0f);
//        ViewHelper.m3391c(this.mWord, 0.0f);
//        float dip2px = ((float) Common.dip2px(getActivity(), 26.0f)) - (((float) this.mWord.getPaddingLeft()) * this.mToMoreInfoScale);
//        float dip2px2 = ((float) Common.dip2px(getActivity(), 28.0f)) - (((float) this.mWord.getPaddingTop()) * this.mToMoreInfoScale);
//        AnimationSet animationSet = new AnimationSet(false);
//        animationSet.setFillAfter(true);
//        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, this.mToMoreInfoScale, 1.0f, this.mToMoreInfoScale, 0.0f, 0.0f);
//        scaleAnimation.setInterpolator(new DecelerateInterpolator(2.0f));
//        scaleAnimation.setDuration(300);
//        float f = (((float) (-this.mWord.getLeft())) + dip2px) / this.mToMoreInfoScale;
//        float f2 = f / 2.0f;
//        float f3 = f - f2;
//        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, f2, 0.0f, 0.0f);
//        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
//        translateAnimation.setDuration(300);
//        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, f3, 0.0f, (((float) (-this.mWord.getTop())) + dip2px2) / this.mToMoreInfoScale);
//        translateAnimation2.setInterpolator(new ElasticInterpolator(Type.OUT, 0.0f, 0.95f));
//        translateAnimation2.setDuration(600);
//        translateAnimation2.setStartOffset(100);
//        animationSet.addAnimation(translateAnimation);
//        animationSet.addAnimation(translateAnimation2);
//        animationSet.addAnimation(scaleAnimation);
//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.6f);
//        alphaAnimation.setDuration(400);
//        animationSet.addAnimation(alphaAnimation);
//        scaleAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
//                WordFragment.this.mWord.setSelected(false);
//                ViewHelper.m3389a(WordFragment.this.mAccent, 1.0f);
//                ViewHelper.m3389a(WordFragment.this.mCnmean, 1.0f);
//            }
//        });
//        this.mWord.setEnabled(false);
//        this.mWord.startAnimation(animationSet);
//        return 500;
//    }
//
//    private void nextGuide(boolean z) {
//        if (this.mFirstPage) {
//            int wordlockGuideNum = Settings.getWordlockGuideNum();
//            if (2 != wordlockGuideNum) {
//                if (1 == wordlockGuideNum) {
//                    if (!this.mWordData.isSearch()) {
//                        this.mGuide.setImageResource(R.drawable.wordlock_guide_long_click_word);
//                    } else {
//                        return;
//                    }
//                }
//                if (this.mGuide.getVisibility() != 0) {
//                    this.mGuide.setVisibility(0);
//                    Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_float);
//                    if (z) {
//                        Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_in);
//                        loadAnimation.setStartOffset(300);
//                        loadAnimation2.setStartOffset(300);
//                        AnimationSet animationSet = new AnimationSet(false);
//                        animationSet.addAnimation(loadAnimation);
//                        animationSet.addAnimation(loadAnimation2);
//                        this.mGuide.startAnimation(animationSet);
//                        return;
//                    }
//                    this.mGuide.startAnimation(loadAnimation);
//                }
//            }
//        }
//    }
//
//    private void processedGuide(int i) {
//        if (this.mFirstPage && this.mGuide.getVisibility() == 0) {
//            int wordlockGuideNum = Settings.getWordlockGuideNum();
//            if (wordlockGuideNum == 0 && (i == 0 || 2 == i)) {
//                Settings.setWordlockGuideNum(1);
//            } else if (1 == wordlockGuideNum && (1 == i || 2 == i)) {
//                Settings.setWordlockGuideNum(2);
//            } else if (i != 0) {
//                return;
//            }
//            this.mGuide.setVisibility(8);
//            this.mGuide.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_out_short));
//        }
//    }
//
//    private void hideGuide() {
//        if (this.mFirstPage && this.mGuide.getVisibility() == 0) {
//            this.mGuide.setVisibility(8);
//        }
//    }
//
//    private void displayGuide() {
//        if (this.mFirstPage && this.mGuide.getVisibility() != 0) {
//            this.mGuide.setVisibility(0);
//            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_float);
//            Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_in);
//            AnimationSet animationSet = new AnimationSet(false);
//            animationSet.addAnimation(loadAnimation);
//            animationSet.addAnimation(loadAnimation2);
//            this.mGuide.startAnimation(animationSet);
//        }
//    }
//
//    private void fadeAccentAndMean(boolean z) {
//        if (8 != this.mAccent.getVisibility()) {
//            this.mAccent.startAnimation(AnimationUtils.loadAnimation(getActivity(), z ? R.anim.wordlock_fade_in : R.anim.wordlock_fade_out));
//            this.mAccent.setVisibility(z ? 0 : 4);
//        }
//    }
//
//    private void displayController(boolean z) {
//        ToggleControllerEvent toggleControllerEvent = new ToggleControllerEvent();
//        toggleControllerEvent.setDisplay(z);
////        EventBus.m0a().mo9c((Object) toggleControllerEvent);
//    }
//
//    public void dispCnmean(boolean z) {
//        if (z && this.mCnmean != null && this.mCnmean.getVisibility() != 0) {
//            this.mCnmean.setVisibility(0);
//        } else if (!z && this.mCnmean != null && this.mCnmean.getVisibility() == 0) {
//            this.mCnmean.setVisibility(4);
//        }
//    }
//
//    public void pullWord(int i) {
//        this.mAnimationHandler.removeMessages(1);
//        this.mScroller.forceFinished(true);
//        if (this.mTotalOffset < (-i)) {
//            i = -this.mTotalOffset;
//        }
//        offsetWord((int) ((1.0f - (((float) this.mTotalOffset) / ((float) this.mPullWordMaxDistance))) * ((float) i)));
//    }
//
//    /* access modifiers changed from: private */
//    public void offsetWord(int i) {
//        if (this.mWord.getAnimation() != null) {
//            if (this.mWord.getAnimation().hasEnded()) {
//                this.mWord.clearAnimation();
//            } else {
//                return;
//            }
//        }
//        this.mWord.offsetTopAndBottom(i);
//        LayoutParams layoutParams = (LayoutParams) this.mWord.getLayoutParams();
//        layoutParams.topMargin += i;
//        this.mTotalOffset += i;
//        if (this.mTotalOffset > this.mPullWordDistance) {
//            ViewHelper.m3389a(this.mAccent, 0.0f);
//            ViewHelper.m3389a(this.mCnmean, 0.0f);
//            return;
//        }
//        float f = 1.0f - (((float) this.mTotalOffset) / ((float) this.mPullWordDistance));
//        ViewHelper.m3389a(this.mAccent, f);
//        ViewHelper.m3389a(this.mCnmean, f);
//    }
//
//    public void onPause() {
//        super.onPause();
//    }
//
//    public void releaseWord(boolean z) {
//        if (!z && this.mTotalOffset > this.mPullWordDistance) {
//            toMoreInfo();
//        } else if (this.mScroller.isFinished()) {
//            this.mAnimationHandler.removeMessages(1);
//            this.mScroller.startScroll(0, 0, 0, -this.mTotalOffset);
//            this.mLastOffset = 0;
//            this.mAnimationHandler.sendEmptyMessage(1);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void resetPullWord() {
//        LayoutParams layoutParams = (LayoutParams) this.mWord.getLayoutParams();
//        layoutParams.topMargin -= this.mTotalOffset;
//        this.mTotalOffset = 0;
//        this.mWord.requestLayout();
//    }
//
//    public boolean onLongClick(View view) {
//        if (this.mWord != view || this.mMoreInfoSpot.intersects(view)) {
//            return false;
//        }
//        processedGuide(1);
//        fadeAccentAndMean(false);
//        displayController(false);
//        this.mWord.setSelected(true);
//        return startDrag(view);
//    }
//
//    private boolean startDrag(View view) {
//        this.mDragController.startDrag(view, this.mDragLayer, view, DragController.DRAG_ACTION_MOVE);
//        if (this.mDragObservers != null) {
//            this.mDragObservers.notifyStart();
//        }
//        return true;
//    }
//
//    public void back() {
//        this.mInmoreState = false;
//        float dip2px = ((float) Common.dip2px(getActivity(), 26.0f)) - (((float) this.mWord.getPaddingLeft()) * this.mToMoreInfoScale);
//        float dip2px2 = ((float) Common.dip2px(getActivity(), 28.0f)) - (((float) this.mWord.getPaddingTop()) * this.mToMoreInfoScale);
//        this.mWord.clearAnimation();
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.setInterpolator(new OvershootInterpolator(1.0f));
//        TranslateAnimation translateAnimation = new TranslateAnimation((dip2px + ((float) (-this.mWord.getLeft()))) / this.mToMoreInfoScale, 0.0f, (dip2px2 + ((float) (-this.mWord.getTop()))) / this.mToMoreInfoScale, (float) (-this.mTotalOffset));
//        animationSet.setDuration(400);
//        animationSet.setFillAfter(true);
//        animationSet.addAnimation(translateAnimation);
//        animationSet.addAnimation(new ScaleAnimation(this.mToMoreInfoScale, 1.0f, this.mToMoreInfoScale, 1.0f, 1.0f, 1.0f));
//        animationSet.addAnimation(new AlphaAnimation(0.6f, 1.0f));
//        animationSet.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
//                WordFragment.this.mWord.clearAnimation();
//                WordFragment.this.mWord.setEnabled(true);
//                WordFragment.this.resetPullWord();
//                WordFragment.this.mResMng.get(WordFragment.this.getActivity(), WordFragment.this.mWordData);
//            }
//        });
//        this.mWord.startAnimation(animationSet);
//        fadeAccentAndMean(true);
//        displayController(true);
//        nextGuide(true);
//    }
//
//    public void resetWord() {
//        this.mWord.clearAnimation();
//        this.mWord.setEnabled(true);
//        resetPullWord();
//    }
//
//    public void onEventMainThread(DropBackEvent dropBackEvent) {
//        Log.d("drop", "DropBackEvent");
//        if (dropBackEvent.getFrom() == 0) {
//            fadeAccentAndMean(true);
//            displayController(true);
//        }
//        this.mWord.postDelayed(new Runnable() {
//            public void run() {
//                WordFragment.this.mWord.setSelected(false);
//            }
//        }, dropBackEvent.getAnimdur());
//    }
//
//    public void onEventMainThread(HelpGuideEvent helpGuideEvent) {
//        switch (helpGuideEvent.getEventId()) {
//            case 0:
//                processedGuide(2);
//                return;
//            case 1:
//                nextGuide(false);
//                return;
//            case 2:
//                hideGuide();
//                return;
//            case 3:
//                displayGuide();
//                return;
//            default:
//                return;
//        }
//    }
//}
