//package com.baicizhan.main.wordlist.view;
//
//import android.content.Context;
//import android.content.res.Resources;
//import android.os.AsyncTask;
//import android.os.Handler;
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentActivity;
//import android.support.p004v4.app.FragmentStatePagerAdapter;
//import android.support.p004v4.view.C0156bm;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.util.SparseArray;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.widget.FrameLayout;
//import com.baicizhan.client.business.view.RotatingImageView;
//import com.baicizhan.main.utils.ApkUtils;
//import com.baicizhan.main.wordlist.eventbus.WordListEvents.WordListEditEvent;
//import com.baicizhan.main.wordlist.eventbus.WordListEvents.WordListHeaderEvent;
//import com.baicizhan.main.wordlist.eventbus.WordListEvents.WordListNavChangeEvent;
//import com.baicizhan.main.wordlist.view.WordListHeader.OnHeaderActionListener;
//import com.baicizhan.main.wordlist.view.WordListNav.OnWordListNavigation;
//import com.handmark.pulltorefresh.library.C1620n;
//import com.handmark.pulltorefresh.library.C1622p;
//import com.handmark.pulltorefresh.library.C1629w;
//import com.handmark.pulltorefresh.library.PullToRefreshBase;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import p000a.p001a.p002a.EventBus;
//
//public class WordListLineMain extends FrameLayout implements C0156bm, OnHeaderActionListener, OnWordListNavigation, C1622p<ViewPager> {
//    private WordListLineAdapter mAdapter;
//    /* access modifiers changed from: private */
//    public int mCurNav = 0;
//    /* access modifiers changed from: private */
//    public SparseArray<WeakReference<WLLineFragment>> mFragmentCache = new SparseArray<>(3);
//    private Handler mHandler = new Handler();
//    private WordListHeader mHeader;
//    /* access modifiers changed from: private */
//    public RotatingImageView mProgress;
//    private ProgressRun mProgressRun;
//    private PullableWordListLine mPullableWordLine;
//    private ViewPager mWordLine;
//
//    class DataCheckTask extends AsyncTask<Resources, Void, Void> {
//        final WeakReference<WordListLineMain> mMain;
//
//        DataCheckTask(WordListLineMain wordListLineMain) {
//            this.mMain = new WeakReference<>(wordListLineMain);
//        }
//
//        /* access modifiers changed from: protected */
//        public Void doInBackground(Resources... resourcesArr) {
//            try {
//                ApkUtils.unzipDictionaryIfNeed(resourcesArr[0]);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        /* access modifiers changed from: protected */
//        public void onPostExecute(Void voidR) {
//            WordListLineMain wordListLineMain = (WordListLineMain) this.mMain.get();
//            if (wordListLineMain != null) {
//                wordListLineMain.loadWordList();
//            }
//        }
//    }
//
//    class ProgressRun implements Runnable {
//        final WeakReference<WordListLineMain> mMain;
//
//        ProgressRun(WordListLineMain wordListLineMain) {
//            this.mMain = new WeakReference<>(wordListLineMain);
//        }
//
//        public void run() {
//            WordListLineMain wordListLineMain = (WordListLineMain) this.mMain.get();
//            if (wordListLineMain != null) {
//                wordListLineMain.mProgress.setVisibility(0);
//            }
//        }
//    }
//
//    class WordListLineAdapter extends FragmentStatePagerAdapter {
//        private WLLineFragment mCurFragment;
//
//        public WordListLineAdapter(C0066v vVar) {
//            super(vVar);
//        }
//
//        public Fragment getItem(int i) {
//            WLLineFragment newInstance = WLLineFragment.newInstance(i, WordListLineMain.this.mCurNav);
//            WordListLineMain.this.mFragmentCache.put(i, new WeakReference(newInstance));
//            return newInstance;
//        }
//
//        public int getCount() {
//            return 3;
//        }
//
//        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
//            if (this.mCurFragment != obj) {
//                this.mCurFragment = (WLLineFragment) obj;
//            }
//            super.setPrimaryItem(viewGroup, i, obj);
//        }
//    }
//
//    public WordListLineMain(Context context) {
//        super(context);
//    }
//
//    public WordListLineMain(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        EventBus.m0a().mo5a((Object) this);
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        EventBus.m0a().mo8b((Object) this);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mProgress = (RotatingImageView) findViewById(R.id.wordlist_data_progress);
//        this.mProgressRun = new ProgressRun(this);
//        this.mPullableWordLine = (PullableWordListLine) findViewById(R.id.wordlist_pullable_line);
//        this.mPullableWordLine.setOnPullEventListener(this);
//        this.mWordLine = (ViewPager) findViewById(R.id.wordlist_line);
//        this.mHeader = (WordListHeader) findViewById(R.id.wordlist_header_outter);
//        this.mHeader.navigateTo(this.mCurNav, null);
//        this.mHeader.setMode(0, false);
//        loadWordList();
//    }
//
//    /* access modifiers changed from: private */
//    public void loadWordList() {
//        this.mHandler.removeCallbacks(this.mProgressRun);
//        if (this.mProgress.getVisibility() == 0) {
//            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//            alphaAnimation.setDuration(200);
//            this.mProgress.startAnimation(alphaAnimation);
//            this.mProgress.setVisibility(8);
//        }
//        this.mAdapter = new WordListLineAdapter(((FragmentActivity) getContext()).getSupportFragmentManager());
//        this.mWordLine.setOffscreenPageLimit(3);
//        this.mWordLine.setAdapter(this.mAdapter);
//        this.mWordLine.setOnPageChangeListener(this);
//        this.mHeader.setHeaderActionListener(this);
//        this.mHeader.navigateTo(this.mCurNav, this);
//    }
//
//    public void onPageScrollStateChanged(int i) {
//        if (1 == i) {
//            if (1 == this.mHeader.getMode()) {
//                this.mHeader.setMode(0, false);
//            } else {
//                this.mHeader.setMode(0, false);
//            }
//        } else if (i == 0) {
//            WLLineFragment wLLineFragment = (WLLineFragment) ((WeakReference) this.mFragmentCache.get(this.mCurNav)).get();
//            if (wLLineFragment != null) {
//                wLLineFragment.tryToastNoWord();
//            }
//        } else if (2 == i) {
//            this.mHeader.navigateTo(this.mWordLine.getCurrentItem(), this);
//            this.mCurNav = this.mWordLine.getCurrentItem();
//            WLLineFragment wLLineFragment2 = (WLLineFragment) ((WeakReference) this.mFragmentCache.get(this.mCurNav)).get();
//            if (wLLineFragment2 != null) {
//                wLLineFragment2.navigateTo(this.mCurNav);
//                this.mHeader.setEditMode(wLLineFragment2.isEditMode());
//                this.mHeader.setWordCount(wLLineFragment2.getWordCount());
//            }
//            Log.d("whiz", "on page scroll state changed, state: " + i + "; to nav: " + this.mCurNav);
//        }
//    }
//
//    public void onPageScrolled(int i, float f, int i2) {
//        Log.d("whiz", "on page scrolled: " + i);
//    }
//
//    public void onPageSelected(int i) {
//        Log.d("whiz", "on page scroll selected: " + i);
//    }
//
//    public void OnWordListNavChanged(int i) {
//        Log.d("whiz", "on word list nav changed, pos: " + i + "; cur pos: " + this.mCurNav);
//        if (i != this.mCurNav) {
//            this.mWordLine.setCurrentItem(i, true);
//            this.mCurNav = i;
//        }
//    }
//
//    public void onEventMainThread(WordListHeaderEvent wordListHeaderEvent) {
//        if (this.mCurNav == wordListHeaderEvent.getCurNav()) {
//            this.mHeader.setEditMode(wordListHeaderEvent.isEditMode(), false);
//            this.mHeader.setWordCount(wordListHeaderEvent.getWordCount());
//        }
//    }
//
//    public void onEventMainThread(WordListNavChangeEvent wordListNavChangeEvent) {
//        int position = wordListNavChangeEvent.getPosition();
//        if (position != this.mCurNav) {
//            this.mHeader.setMode(0, false);
//            this.mWordLine.setCurrentItem(position, true);
//            this.mCurNav = position;
//        }
//    }
//
//    public void onEventMainThread(WordListEditEvent wordListEditEvent) {
//        int eventCode = wordListEditEvent.getEventCode();
//        int i = -1;
//        if (eventCode == 0) {
//            i = 2;
//        } else if (1 == eventCode) {
//            i = 0;
//        }
//        if (i >= 0) {
//            WLLineFragment wLLineFragment = (WLLineFragment) ((WeakReference) this.mFragmentCache.get(i)).get();
//            if (wLLineFragment != null) {
//                wLLineFragment.refresh(wordListEditEvent.getWord());
//            }
//        }
//    }
//
//    public void onEditModeChanged(boolean z) {
//        WLLineFragment wLLineFragment = (WLLineFragment) ((WeakReference) this.mFragmentCache.get(this.mCurNav)).get();
//        if (wLLineFragment != null) {
//            wLLineFragment.setEditMode(z);
//        }
//    }
//
//    public void onPullEvent(PullToRefreshBase<ViewPager> gVar, C1629w wVar, C1620n nVar) {
//        if (C1629w.PULL_TO_REFRESH == wVar) {
//            if (3 == this.mHeader.getMode()) {
//                this.mHeader.setMode(0, false);
//            }
//        } else if (C1629w.IDLE == wVar) {
//            ((WeakReference) this.mFragmentCache.get(this.mCurNav)).get();
//        }
//    }
//}
