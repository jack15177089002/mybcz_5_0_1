//package com.baicizhan.client.p029fm.view;
//
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.os.Build.VERSION;
////import android.support.p004v4.view.PagerAdapter;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
////import com.baicizhan.client.p029fm.R;
//import androidx.viewpager.widget.PagerAdapter;
//
//import com.handmark.pulltorefresh.library.C1627u;
//import com.handmark.pulltorefresh.library.PullToRefreshBase;
//import com.jiongji.andriod.card.R;
//
//import java.lang.reflect.InvocationTargetException;
//
///* renamed from: com.baicizhan.client.fm.view.PullableFmLine */
//public class PullableFmLine extends PullToRefreshBase<FmLineWrapper> {
//    private FmLineWrapper mFmLineWrapper;
//
//    public PullableFmLine(Context context) {
//        super(context);
//        setOverPullFriction(1.36f);
//        setHideLoadingLayout(true);
//        setIgnoreTouchSlop(true);
//        disableOverScroll();
//        setClipChildren(false);
//    }
//
//    public PullableFmLine(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        setOverPullFriction(1.36f);
//        setHideLoadingLayout(true);
//        setIgnoreTouchSlop(true);
//        disableOverScroll();
//        setClipChildren(false);
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
//    public FmLineWrapper createRefreshableView(Context context, AttributeSet attributeSet) {
//        this.mFmLineWrapper = (FmLineWrapper) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.fm_line_wrapper, null);
//        if (VERSION.SDK_INT >= 9) {
//            try {
//                Class.forName("android.support.v4.view.ViewPager").getMethod("setOverScrollMode", new Class[]{Integer.TYPE}).invoke(this.mFmLineWrapper, new Object[]{Integer.valueOf(2)});
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
//        return this.mFmLineWrapper;
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean isReadyForPullEnd() {
//        FmLineWrapper fmLineWrapper = (FmLineWrapper) getRefreshableView();
//        PagerAdapter adapter = fmLineWrapper.getViewPager().getAdapter();
//        if (adapter == null) {
//            return false;
//        }
//        if (fmLineWrapper.getViewPager().getCurrentItem() == adapter.getCount() - 1) {
//            return true;
//        }
//        return false;
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean isReadyForPullStart() {
//        FmLineWrapper fmLineWrapper = (FmLineWrapper) getRefreshableView();
//        if (fmLineWrapper.getViewPager().getAdapter() == null) {
//            return false;
//        }
//        if (fmLineWrapper.getViewPager().getCurrentItem() == 0) {
//            return true;
//        }
//        return false;
//    }
//}
