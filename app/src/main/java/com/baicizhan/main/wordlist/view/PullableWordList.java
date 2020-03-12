//package com.baicizhan.main.wordlist.view;
//
//import android.annotation.TargetApi;
//import android.content.Context;
//import android.util.AttributeSet;
//import android.widget.ListView;
//import com.handmark.pulltorefresh.library.PullToRefreshListView;
//import com.jiongji.andriod.card.R;
//
//public class PullableWordList extends PullToRefreshListView {
//    private boolean mPullable = true;
//
//    public PullableWordList(Context context) {
//        super(context);
//        init();
//    }
//
//    public PullableWordList(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        init();
//    }
//
//    private void init() {
//        setOverPullFriction(1.36f);
//        setIgnoreTouchSlop(true);
//        disableOverScroll();
//        getLoadingLayoutProxy().setPullLabel(getContext().getString(R.string.wordlist_pull_label));
//        getLoadingLayoutProxy().setReleaseLabel(getContext().getString(R.string.wordlist_release_label));
//        getLoadingLayoutProxy().setRefreshingLabel(getContext().getString(R.string.wordlist_refreshing_label));
//    }
//
//    @TargetApi(9)
//    private void disableOverScroll() {
//        setOverScrollMode(2);
//    }
//
//    public void setPullable(boolean z) {
//        this.mPullable = z;
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean isReadyForPullEnd() {
//        if (!this.mPullable) {
//            return false;
//        }
//        ListView listView = (ListView) getRefreshableView();
//        return listView.getLastVisiblePosition() == listView.getCount() + -1;
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean isReadyForPullStart() {
//        return false;
//    }
//}
