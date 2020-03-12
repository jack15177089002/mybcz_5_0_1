//package com.baicizhan.client.wordlock.view;
//
//import android.annotation.SuppressLint;
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.os.Build.VERSION;
////import android.support.p004v4.view.PagerAdapter;
//import androidx.viewpager.widget.PagerAdapter;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.activity.WordLockClient;
//import com.baicizhan.client.wordlock.view.drag.IDragObserver;
//import com.handmark.pulltorefresh.library.C1620n;
//import com.handmark.pulltorefresh.library.C1622p;
//import com.handmark.pulltorefresh.library.C1627u;
//import com.handmark.pulltorefresh.library.C1629w;
//import com.handmark.pulltorefresh.library.PullToRefreshBase;
//import com.jiongji.andriod.card.R;
//
//import java.lang.reflect.InvocationTargetException;
//
//public class PullToRefreshWordLine extends PullToRefreshBase<WordLine> implements IDragObserver, C1622p<WordLine> {
//    private boolean mActivate = true;
//
//    public PullToRefreshWordLine(Context context) {
//        super(context);
//        setOverPullFriction(1.36f);
//        setHideLoadingLayout(true);
//        setIgnoreTouchSlop(true);
//        setOnPullEventListener(this);
//        disableOverScroll();
//    }
//
//    public PullToRefreshWordLine(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        setOverPullFriction(1.36f);
//        setHideLoadingLayout(true);
//        setIgnoreTouchSlop(true);
//        setOnPullEventListener(this);
//        disableOverScroll();
//    }
//
//    @TargetApi(9)
//    private void disableOverScroll() {
//        setOverScrollMode(2);
//    }
//
//    public final int getPullToRefreshScrollDirection$2ae02adb() {
//        return C1627u.f3871b;
//    }
//
//    /* access modifiers changed from: protected */
//    public WordLine createRefreshableView(Context context, AttributeSet attributeSet) {
//        WordLine wordLine = new WordLine(context, attributeSet);
////        wordLine.setId(R.id.wordlock_wordline);
////        if (VERSION.SDK_INT >= 9) {
////            try {
////                Class.forName("android.support.v4.view.ViewPager").getMethod("setOverScrollMode", new Class[]{Integer.TYPE}).invoke(wordLine, new Object[]{Integer.valueOf(2)});
////            } catch (IllegalAccessException e) {
////                e.printStackTrace();
////            } catch (IllegalArgumentException e2) {
////                e2.printStackTrace();
////            } catch (InvocationTargetException e3) {
////                e3.printStackTrace();
////            } catch (NoSuchMethodException e4) {
////                e4.printStackTrace();
////            } catch (ClassNotFoundException e5) {
////                e5.printStackTrace();
////            }
////        }
//        return wordLine;
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean isReadyForPullStart() {
//        ViewPager viewPager = (ViewPager) getRefreshableView();
//        if (viewPager.getAdapter() == null) {
//            return false;
//        }
//        if (viewPager.getCurrentItem() == 0) {
//            return true;
//        }
//        return false;
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean isReadyForPullEnd() {
//        ViewPager viewPager = (ViewPager) getRefreshableView();
//        PagerAdapter adapter = viewPager.getAdapter();
//        if (adapter == null) {
//            return false;
//        }
//        if (viewPager.getCurrentItem() == adapter.getCount() - 1) {
//            return true;
//        }
//        return false;
//    }
//
//    public void onRefreshing(boolean z) {
//        callRefreshListener();
//    }
//
//    public void onPullEvent(PullToRefreshBase<WordLine> gVar, C1629w wVar, C1620n nVar) {
//        if (C1629w.RESET == wVar) {
//            WordLine wordLine = (WordLine) getRefreshableView();
//            if (wordLine != null) {
//                wordLine.dispCnmean(false);
//            }
//        }
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
//        return super.onInterceptTouchEvent(motionEvent);
//    }
//
//    @SuppressLint({"ClickableViewAccessibility"})
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        if (!this.mActivate) {
//            return false;
//        }
//        return super.onTouchEvent(motionEvent);
//    }
//
//    public void init(WordLockClient wordLockClient) {
//        if (wordLockClient != null) {
//            wordLockClient.getDragObservers().addObserver(this);
//        }
//    }
//}
