//package com.baicizhan.client.wordlock.view;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
////import android.support.p004v4.app.Fragment;
////import android.support.p004v4.app.FragmentStatePagerAdapter;
////import android.support.p004v4.view.C0156bm;
//import androidx.fragment.app.FragmentStatePagerAdapter;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.ViewConfiguration;
//import android.view.ViewGroup;
//import android.view.ViewParent;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.view.animation.OvershootInterpolator;
//import com.baicizhan.client.business.search.Word;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.activity.WordLockClient;
//import com.baicizhan.client.wordlock.data.WordReviewing;
//import com.baicizhan.client.wordlock.data.WordToReviewCache;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.DispCnmeanEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.KillWordEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.RefreshTopNEvent;
//import com.baicizhan.client.wordlock.fragment.WordFragment;
//import com.baicizhan.client.wordlock.service.WordLockService;
//import com.baicizhan.client.wordlock.setting.Settings;
//import com.baicizhan.client.wordlock.stat.OperationUtil;
//import com.baicizhan.client.wordlock.view.drag.IDragObserver;
//import com.jiongji.andriod.card.R;
//
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
////import p000a.p001a.p002a.EventBus;
//
//public class WordLine extends ViewPager implements IDragObserver {
//    private boolean mActivate = true;
//    /* access modifiers changed from: private */
//    public WordChangeAdapter mAdapter;
//    /* access modifiers changed from: private */
//    public WordLockClient mClient;
//    private DelayResetRun mDelayResetRun = new DelayResetRun(this);
//    private boolean mIsPullWord = false;
//    private float mLastX;
//    private float mLastY;
//    /* access modifiers changed from: private */
//    public DotsNavigation mNav;
//    /* access modifiers changed from: private */
//    public int mPagerState = 0;
//    private int mPullWordSlop;
//    /* access modifiers changed from: private */
//    public ArrayList<String> mRevdWords = new ArrayList<>(1);
//    private SlashBlastPopup mSlashBlastPopup;
//
//    final class DelayResetRun implements Runnable {
//        final WeakReference<WordLine> mWordLine;
//
//        DelayResetRun(WordLine wordLine) {
//            this.mWordLine = new WeakReference<>(wordLine);
//        }
//
//        public final void run() {
//            if (!Settings.doesWordlockHasWord()) {
//                WordLine wordLine = (WordLine) this.mWordLine.get();
//                if (wordLine != null && wordLine.mClient != null) {
//                    wordLine.mClient.finish();
//                }
//            } else if (WordToReviewCache.isEmpty()) {
//                WordLine wordLine2 = (WordLine) this.mWordLine.get();
//                if (wordLine2 != null) {
//                    wordLine2.refreshTopN();
//                    wordLine2.delayReset();
//                }
//            } else if (!WordToReviewCache.isEmpty()) {
//                WordLine wordLine3 = (WordLine) this.mWordLine.get();
//                if (wordLine3 != null) {
//                    wordLine3.reset(true, false);
//                }
//            }
//        }
//    }
//
//    class WordChangeAdapter extends FragmentStatePagerAdapter {
//        /* access modifiers changed from: private */
//        public WordFragment mCurFragment;
//        private boolean mToMore = false;
//        /* access modifiers changed from: private */
//        public List<WordReviewing> mWords;
//
//        public WordChangeAdapter(FragmentManager vVar, boolean z) {
//            super(vVar);
//            reset(z);
//        }
//
//        public void reset(boolean z) {
//            this.mWords = WordToReviewCache.copyFragment();
//            notifyDataSetChanged();
//            WordLine.this.mRevdWords.clear();
//            if (this.mWords == null || this.mWords.isEmpty() || z) {
//                WordLine.this.delayReset();
//            } else {
//                WordLine.this.mRevdWords.add(((WordReviewing) this.mWords.get(0)).getWord().getId());
//                WordLine.this.getTodayRevdCount();
//                ((WordReviewing) this.mWords.get(0)).setReviewed(true);
//                WordLine.this.mNav.setCount(this.mWords.size(), 0);
//            }
//            if (this.mCurFragment != null) {
//                this.mCurFragment.resetWord();
//            }
//        }
//
//        public WordChangeAdapter(FragmentManager vVar, List<WordReviewing> list) {
//            super(vVar);
//            if (list != null) {
//                this.mWords = list;
//                WordLine.this.mRevdWords.clear();
//                WordLine.this.mRevdWords.add(((WordReviewing) this.mWords.get(0)).getWord().getId());
//                WordLine.this.getTodayRevdCount();
//                ((WordReviewing) this.mWords.get(0)).setReviewed(true);
//                WordLine.this.mNav.setCount(this.mWords.size(), 0);
//                this.mToMore = true;
//            }
//        }
//
//        public Fragment getItem(int i) {
////            if (this.mWords == null || i >= this.mWords.size() || i < 0) {
////                return null;
////            }
////            WordFragment newInstance = WordFragment.newInstance(((WordReviewing) this.mWords.get(i)).getWord(), i == 0, this.mToMore);
////            this.mToMore = false;
////            return newInstance;
//
//            return null;
//        }
//
//        public int getCount() {
//            if (this.mWords != null) {
//                return this.mWords.size();
//            }
//            return 0;
//        }
//
//        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
//            if (this.mCurFragment != obj) {
//                if (this.mCurFragment != null) {
//                    this.mCurFragment.dispCnmean(false);
//                }
//                this.mCurFragment = (WordFragment) obj;
//            }
//            super.setPrimaryItem(viewGroup, i, obj);
//        }
//    }
//
//    public WordLine(Context context) {
//        super(context);
//        this.mPullWordSlop = ViewConfiguration.get(context).getScaledTouchSlop();
//    }
//
//    public WordLine(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        this.mPullWordSlop = ViewConfiguration.get(context).getScaledTouchSlop();
//    }
//
//    public void setEnabled(boolean z) {
//        super.setEnabled(z);
//        this.mActivate = z;
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//    }
//
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
////        EventBus.m0a().mo5a((Object) this);
//        if (this.mSlashBlastPopup == null) {
//            this.mSlashBlastPopup = new SlashBlastPopup(getContext());
//        }
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
////        EventBus.m0a().mo8b((Object) this);
//        removeCallbacks(this.mDelayResetRun);
//    }
//
//    public void onEventMainThread(RefreshTopNEvent refreshTopNEvent) {
//        refreshTopN();
//    }
//
//    public void onEventMainThread(KillWordEvent killWordEvent) {
//        long animdur = killWordEvent.getAnimdur();
//        Word currentWord = getCurrentWord();
//        if (currentWord != null) {
//            WordToReviewCache.removeReviewed(currentWord.getId());
//            WordLockService.startForKillWord(getContext(), currentWord.getId());
//            refreshTopN();
//            delayFromRight(animdur);
//        }
//    }
//
//    public void onEventMainThread(DispCnmeanEvent dispCnmeanEvent) {
//        dispCnmean(dispCnmeanEvent.isDisplay());
//    }
//
//    private void delayFromRight(long j) {
//        postDelayed(new Runnable() {
//            public void run() {
//                WordLine.this.fromRight();
//            }
//        }, j);
//    }
//
//    /* access modifiers changed from: private */
//    public void fromRight() {
//        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.wordlock_fade_out_short);
//        startAnimation(loadAnimation);
//        postDelayed(new Runnable() {
//            public void run() {
//                WordLine.this.mNav.setVisibility(0);
//                WordLine.this.mNav.startAnimation(AnimationUtils.loadAnimation(WordLine.this.getContext(), R.anim.wordlock_fade_in_short));
//                WordLine.this.reset(true, false);
//                WordLine.this.doFromRight();
//            }
//        }, loadAnimation.getDuration());
//    }
//
//    /* access modifiers changed from: private */
//    public void doFromRight() {
//        clearAnimation();
//        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.wordlock_translate_from_right);
//        loadAnimation.setInterpolator(new OvershootInterpolator(1.0f));
//        startAnimation(loadAnimation);
//    }
//
//    public void init(WordLockClient wordLockClient, DotsNavigation dotsNavigation) {
//        if (wordLockClient != null) {
//            this.mNav = dotsNavigation;
//            this.mAdapter = new WordChangeAdapter(wordLockClient.getSupportFragmentManager(), false);
//            setAdapter(this.mAdapter);
//            wordLockClient.getDragObservers().addObserver(this);
//            this.mClient = wordLockClient;
////            setOnPageChangeListener(new C0156bm() {
////                public void onPageScrollStateChanged(int i) {
////                    WordLine.this.mPagerState = i;
////                    if (i == 0 && WordLine.this.mAdapter != null && !WordLine.this.mAdapter.mWords.isEmpty()) {
////                        WordReviewing wordReviewing = (WordReviewing) WordLine.this.mAdapter.mWords.get(WordLine.this.getCurrentItem());
////                        if (!wordReviewing.isReviewed()) {
////                            wordReviewing.setReviewed(true);
////                            WordLine.this.mRevdWords.add(wordReviewing.getWord().getId());
////                            WordLine.this.getTodayRevdCount();
////                            OperationUtil.getInstance().accumRevdCount();
////                        }
////                    }
////                    if (2 == i) {
////                        WordLine.this.mNav.setCur(WordLine.this.getCurrentItem());
////                    }
////                }
////
////                public void onPageScrolled(int i, float f, int i2) {
////                }
////
////                public void onPageSelected(int i) {
////                }
////            });
//        }
//    }
//
//    public void reset(boolean z, boolean z2) {
//        if (z) {
//            this.mAdapter = null;
//        }
//        if (this.mAdapter == null && this.mClient != null) {
//            this.mAdapter = new WordChangeAdapter(this.mClient.getSupportFragmentManager(), z2);
//            setAdapter(this.mAdapter);
//        } else if (this.mClient != null) {
//            this.mAdapter.reset(z2);
//        } else {
//            return;
//        }
//        setEnabled(true);
//    }
//
//    public void fillSearchResult(Word word) {
//        ArrayList arrayList = new ArrayList();
//        WordReviewing wordReviewing = new WordReviewing();
//        wordReviewing.setWord(word);
//        arrayList.add(0, wordReviewing);
//        if (this.mAdapter != null) {
//            arrayList.addAll(this.mAdapter.mWords);
//        }
//        int i = 1;
//        while (true) {
//            if (i >= arrayList.size()) {
//                i = -1;
//                break;
//            } else if (TextUtils.equals(word.getWord(), ((WordReviewing) arrayList.get(i)).getWord().getWord())) {
//                break;
//            } else {
//                i++;
//            }
//        }
//        if (i > 0) {
//            arrayList.remove(i);
//        }
//        this.mAdapter = new WordChangeAdapter(this.mClient.getSupportFragmentManager(), arrayList.subList(0, Math.min(10, arrayList.size())));
//        setAdapter(this.mAdapter);
//        setEnabled(true);
//    }
//
//    public void back() {
//        if (this.mAdapter != null && this.mAdapter.mCurFragment != null) {
//            this.mAdapter.mCurFragment.back();
//        }
//    }
//
//    public Word getCurrentWord() {
//        if (this.mAdapter == null) {
//            return null;
//        }
//        int currentItem = getCurrentItem();
//        if (this.mAdapter.mWords == null || currentItem < 0 || currentItem >= this.mAdapter.mWords.size()) {
//            return null;
//        }
//        return ((WordReviewing) this.mAdapter.mWords.get(currentItem)).getWord();
//    }
//
//    /* access modifiers changed from: private */
//    public void refreshTopN() {
//        if (!Settings.isLockScreenFirstSet() || this.mAdapter == null || this.mAdapter.getCount() <= 0) {
//            WordLockService.startForRefreshTopN(getContext(), this.mRevdWords);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void getTodayRevdCount() {
//        WordLockService.startForGetTodayRevdCount(getContext(), this.mRevdWords);
//    }
//
//    public void onDragStart() {
//        this.mActivate = false;
//    }
//
//    public void onDragEnd() {
//        this.mActivate = true;
//    }
//
//    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
//        if (!this.mActivate) {
//            return false;
//        }
//        if (this.mPagerState != 0) {
//            return super.onInterceptTouchEvent(motionEvent);
//        }
//        switch (motionEvent.getAction()) {
//            case 0:
//                if (!this.mIsPullWord) {
//                    this.mLastY = motionEvent.getY();
//                    this.mLastX = motionEvent.getX();
//                    this.mIsPullWord = false;
//                    break;
//                } else {
//                    return true;
//                }
//            case 1:
//            case 3:
//                this.mIsPullWord = false;
//                break;
//            case 2:
//                float y = motionEvent.getY() - this.mLastY;
//                float abs = Math.abs(y);
//                float abs2 = Math.abs(motionEvent.getX() - this.mLastX);
//                if (!this.mIsPullWord && y > 0.0f && abs > ((float) this.mPullWordSlop) && 0.5f * abs > abs2) {
//                    this.mIsPullWord = true;
//                    requestParentDisallowInterceptTouchEvent(true);
//                    break;
//                }
//        }
//        if (this.mIsPullWord) {
//            return true;
//        }
//        return super.onInterceptTouchEvent(motionEvent);
//    }
//
//    @SuppressLint({"ClickableViewAccessibility"})
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        boolean z;
//        if (!this.mActivate) {
//            return false;
//        }
//        int action = motionEvent.getAction();
//        switch (action) {
//            case 0:
//                dispCnmean(true);
//                break;
//            case 1:
//                dispCnmean(false);
//                break;
//        }
//        if (this.mPagerState != 0) {
//            return super.onTouchEvent(motionEvent);
//        }
//        switch (action) {
//            case 0:
//                this.mLastY = motionEvent.getY();
//                break;
//            case 1:
//            case 3:
//                if (this.mIsPullWord) {
//                    WordFragment access$800 = this.mAdapter.mCurFragment;
//                    if (action == 3) {
//                        z = true;
//                    } else {
//                        z = false;
//                    }
//                    access$800.releaseWord(z);
//                    this.mIsPullWord = false;
//                    break;
//                }
//                break;
//            case 2:
//                float y = motionEvent.getY();
//                float f = y - this.mLastY;
//                float abs = Math.abs(f);
//                float abs2 = Math.abs(motionEvent.getX() - this.mLastX);
//                if (this.mIsPullWord) {
//                    if (this.mIsPullWord) {
//                        this.mAdapter.mCurFragment.pullWord((int) (f * 0.7f));
//                        this.mLastY = y;
//                        break;
//                    }
//                } else if (f > 0.0f && abs > ((float) this.mPullWordSlop) && 0.5f * abs > abs2) {
//                    this.mIsPullWord = true;
//                    requestParentDisallowInterceptTouchEvent(true);
//                    this.mLastY = y;
//                    break;
//                }
//                break;
//        }
//        if (this.mIsPullWord) {
//            return true;
//        }
//        return super.onTouchEvent(motionEvent);
//    }
//
//    private void requestParentDisallowInterceptTouchEvent(boolean z) {
//        ViewParent parent = getParent();
//        if (parent != null) {
//            parent.requestDisallowInterceptTouchEvent(z);
//        }
//        requestDisallowInterceptTouchEvent(z);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void dispCnmean(boolean z) {
//        if (this.mAdapter != null && this.mAdapter.mCurFragment != null) {
//            this.mAdapter.mCurFragment.dispCnmean(z);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void delayReset() {
//        postDelayed(this.mDelayResetRun, 300);
//    }
//}
