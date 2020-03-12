//package com.baicizhan.main.wordlist.view;
//
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.os.Build.VERSION;
//import android.support.p004v4.view.PagerAdapter;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
//import android.util.AttributeSet;
//import com.handmark.pulltorefresh.library.C1627u;
//import com.handmark.pulltorefresh.library.PullToRefreshBase;
//import com.jiongji.andriod.card.R;
//import java.lang.reflect.InvocationTargetException;
//
//public class PullableWordListLine extends PullToRefreshBase<ViewPager> {
//    public PullableWordListLine(Context context) {
//        super(context);
//        setOverPullFriction(1.36f);
//        setHideLoadingLayout(true);
//        setIgnoreTouchSlop(true);
//        disableOverScroll();
//    }
//
//    public PullableWordListLine(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        setOverPullFriction(1.36f);
//        setHideLoadingLayout(true);
//        setIgnoreTouchSlop(true);
//        disableOverScroll();
//    }
//
//    @TargetApi(9)
//    private void disableOverScroll() {
//        setOverScrollMode(2);
//    }
//
//    public int getPullToRefreshScrollDirection$2ae02adb() {
//        return C1627u.f3871b;
//    }
//
//    /* access modifiers changed from: protected */
//    public ViewPager createRefreshableView(Context context, AttributeSet attributeSet) {
//        ViewPager viewPager = new ViewPager(context, attributeSet);
//        viewPager.setId(R.id.wordlist_line);
//        if (VERSION.SDK_INT >= 9) {
//            try {
//                Class.forName("android.support.v4.view.ViewPager").getMethod("setOverScrollMode", new Class[]{Integer.TYPE}).invoke(viewPager, new Object[]{Integer.valueOf(2)});
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (IllegalArgumentException e2) {
//                e2.printStackTrace();
//            } catch (InvocationTargetException e3) {
//                e3.printStackTrace();
//            } catch (NoSuchMethodException e4) {
//                e4.printStackTrace();
//            } catch (ClassNotFoundException e5) {
//                e5.printStackTrace();
//            }
//        }
//        return viewPager;
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
//}
