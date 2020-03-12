//package com.baicizhan.client.wordlock.fragment;
//
//import android.os.Bundle;
////import android.support.p004v4.app.Fragment;
////import android.support.p004v4.view.C0156bm;
////import android.support.p004v4.view.PagerAdapter;
//
//import androidx.fragment.app.Fragment;
//import androidx.viewpager.widget.PagerAdapter;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
//import android.text.SpannableString;
//import android.text.TextUtils;
//import android.text.style.ForegroundColorSpan;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.search.ResourceManager;
//import com.baicizhan.client.business.search.ResourceManager.OnResourceGetListener;
//import com.baicizhan.client.business.search.Word;
//import com.baicizhan.client.business.util.TopicTextRenderHelper.TopicTextRender;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.WordLockApp;
//import com.baicizhan.client.wordlock.data.WordToReviewCache;
//import com.baicizhan.client.wordlock.util.CustomFont;
//import com.baicizhan.client.wordlock.view.DotsNavigation;
//import com.baicizhan.client.wordlock.view.PullToRefreshMorePager;
//import com.jiongji.andriod.card.R;
//
//import java.lang.ref.WeakReference;
////import p000a.p001a.p002a.EventBus;
//
//
////test
//interface C0156bm {
//    void onPageScrollStateChanged(int i);
//
//    void onPageScrolled(int i, float f, int i2);
//
//    void onPageSelected(int i);
//}
//
//
//public class MoreWordInfoFragment extends Fragment implements C0156bm, OnClickListener, OnTouchListener {
//    private static final String KEY_WORD = "word";
//    private MoreInfoAdapter mAdapter;
//    private DotsNavigation mDotsNav;
//    /* access modifiers changed from: private */
//    public boolean mExampleExists = false;
//    private boolean mExiting = false;
//    private boolean mLockBack = false;
//    private TextView mMiniAccent;
//    private TextView mMiniCnmean;
//    private TextView mMiniWord;
//    private ViewPager mMorePager;
//    /* access modifiers changed from: private */
//    public boolean mOtherExists = false;
//    /* access modifiers changed from: private */
//    public int mPageCount = 0;
//    private PullToRefreshMorePager mPullablePager;
//    private ResourceManager mResMng;
//    /* access modifiers changed from: private */
//    public boolean mVividExists = false;
//    /* access modifiers changed from: private */
//    public Word mWordData;
//    private WordRefreshCallback mWordRefreshCBK;
//
//    class MoreInfoAdapter extends PagerAdapter {
//        private MoreInfoAdapter() {
//        }
//
//        public int getCount() {
//            return MoreWordInfoFragment.this.mPageCount;
//        }
//
//        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
//            viewGroup.removeView((View) obj);
//        }
//
//        /* Code decompiled incorrectly, please refer to instructions dump. */
//        public View instantiateItem(ViewGroup r6, int r7) {
//            /*
//                r5 = this;
//                r4 = -1
//                r3 = 0
//                android.content.Context r0 = r6.getContext()
//                java.lang.String r1 = "layout_inflater"
//                java.lang.Object r0 = r0.getSystemService(r1)
//                android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
//                r1 = 0
//                switch(r7) {
//                    case 0: goto L_0x001e;
//                    case 1: goto L_0x005a;
//                    case 2: goto L_0x008a;
//                    default: goto L_0x0012;
//                }
//            L_0x0012:
//                r0 = r1
//            L_0x0013:
//                if (r0 == 0) goto L_0x001d
//                com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment r1 = com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment.this
//                r0.setOnClickListener(r1)
//                r6.addView(r0, r4, r4)
//            L_0x001d:
//                return r0
//            L_0x001e:
//                com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment r2 = com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment.this
//                boolean r2 = r2.mExampleExists
//                if (r2 == 0) goto L_0x0032
//                int r1 = com.baicizhan.client.wordlock.R.layout.wordlock_more_example_page
//                android.view.View r0 = r0.inflate(r1, r6, r3)
//                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
//                r5.initExamplePage(r0)
//                goto L_0x0013
//            L_0x0032:
//                com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment r2 = com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment.this
//                boolean r2 = r2.mVividExists
//                if (r2 == 0) goto L_0x0046
//                int r1 = com.baicizhan.client.wordlock.R.layout.wordlock_more_vivid_page
//                android.view.View r0 = r0.inflate(r1, r6, r3)
//                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
//                r5.initVividPage(r0)
//                goto L_0x0013
//            L_0x0046:
//                com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment r2 = com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment.this
//                boolean r2 = r2.mOtherExists
//                if (r2 == 0) goto L_0x0012
//                int r1 = com.baicizhan.client.wordlock.R.layout.wordlock_more_other_page
//                android.view.View r0 = r0.inflate(r1, r6, r3)
//                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
//                r5.initOtherPage(r0)
//                goto L_0x0013
//            L_0x005a:
//                com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment r2 = com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment.this
//                boolean r2 = r2.mVividExists
//                if (r2 == 0) goto L_0x0076
//                com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment r2 = com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment.this
//                boolean r2 = r2.mExampleExists
//                if (r2 == 0) goto L_0x0076
//                int r1 = com.baicizhan.client.wordlock.R.layout.wordlock_more_vivid_page
//                android.view.View r0 = r0.inflate(r1, r6, r3)
//                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
//                r5.initVividPage(r0)
//                goto L_0x0013
//            L_0x0076:
//                com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment r2 = com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment.this
//                boolean r2 = r2.mOtherExists
//                if (r2 == 0) goto L_0x0012
//                int r1 = com.baicizhan.client.wordlock.R.layout.wordlock_more_other_page
//                android.view.View r0 = r0.inflate(r1, r6, r3)
//                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
//                r5.initOtherPage(r0)
//                goto L_0x0013
//            L_0x008a:
//                com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment r2 = com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment.this
//                boolean r2 = r2.mOtherExists
//                if (r2 == 0) goto L_0x0012
//                int r1 = com.baicizhan.client.wordlock.R.layout.wordlock_more_other_page
//                android.view.View r0 = r0.inflate(r1, r6, r3)
//                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
//                r5.initOtherPage(r0)
//                goto L_0x0013
//            */
//            throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.wordlock.fragment.MoreWordInfoFragment.MoreInfoAdapter.instantiateItem(android.view.ViewGroup, int):android.view.View");
//        }
//
//        public boolean isViewFromObject(View view, Object obj) {
//            return view == obj;
//        }
//
//        private void initExamplePage(ViewGroup viewGroup) {
//            if (viewGroup != null) {
//                ResourceManager.displayImage(MoreWordInfoFragment.this.getActivity(), (ImageView) viewGroup.findViewById(R.id.wordlock_example_image), MoreWordInfoFragment.this.mWordData);
//                TextView textView = (TextView) viewGroup.findViewById(R.id.wordlock_example);
//                CustomFont.setFont(textView, 0);
//                String example = MoreWordInfoFragment.this.mWordData.getExample();
//                if (!TextUtils.isEmpty(example)) {
//                    TopicTextRender.with(example).highlightColor(-6440194).highlightKey(MoreWordInfoFragment.this.mWordData.getWord()).into(textView);
//                }
//                TextView textView2 = (TextView) viewGroup.findViewById(R.id.wordlock_example_cn);
//                CustomFont.setFont(textView2, 0);
//                textView2.setText(MoreWordInfoFragment.this.mWordData.getCnexample());
//            }
//        }
//
//        private void initVividPage(ViewGroup viewGroup) {
//            if (viewGroup != null) {
//                ResourceManager.displayVivid(MoreWordInfoFragment.this.getActivity(), (ImageView) viewGroup.findViewById(R.id.wordlock_vivid_image), MoreWordInfoFragment.this.mWordData);
//            }
//        }
//
//        private void initOtherPage(ViewGroup viewGroup) {
//            if (viewGroup != null) {
//                TextView textView = (TextView) viewGroup.findViewById(R.id.wordlock_word_root);
//                CustomFont.setFont(textView, 0);
//                if (TextUtils.isEmpty(MoreWordInfoFragment.this.mWordData.getRoot())) {
//                    View findViewById = viewGroup.findViewById(R.id.wordlock_word_root_title);
//                    View findViewById2 = viewGroup.findViewById(R.id.wordlock_root_divider);
//                    findViewById.setVisibility(8);
//                    findViewById2.setVisibility(8);
//                    textView.setVisibility(8);
//                } else {
//                    textView.setText(MoreWordInfoFragment.this.mWordData.getRoot());
//                }
//                TextView textView2 = (TextView) viewGroup.findViewById(R.id.wordlock_word_en_mean);
//                CustomFont.setFont(textView2, 0);
//                if (TextUtils.isEmpty(MoreWordInfoFragment.this.mWordData.getEnmean())) {
//                    View findViewById3 = viewGroup.findViewById(R.id.wordlock_word_en_mean_title);
//                    View findViewById4 = viewGroup.findViewById(R.id.wordlock_en_mean_divider);
//                    findViewById3.setVisibility(8);
//                    findViewById4.setVisibility(8);
//                    textView2.setVisibility(8);
//                    return;
//                }
//                SpannableString spannableString = new SpannableString(MoreWordInfoFragment.this.mWordData.getWord() + " = " + MoreWordInfoFragment.this.mWordData.getEnmean());
//                spannableString.setSpan(new ForegroundColorSpan(-6440194), 0, MoreWordInfoFragment.this.mWordData.getWord().length() + 3, 34);
//                textView2.setText(spannableString);
//            }
//        }
//    }
//
//    class WordRefreshCallback implements OnResourceGetListener {
//        final WeakReference<MoreWordInfoFragment> mFragment;
//
//        WordRefreshCallback(MoreWordInfoFragment moreWordInfoFragment) {
//            this.mFragment = new WeakReference<>(moreWordInfoFragment);
//        }
//
//        public void onResourceGet(Word word, int i, String str) {
//            MoreWordInfoFragment moreWordInfoFragment = (MoreWordInfoFragment) this.mFragment.get();
//            if (moreWordInfoFragment != null && moreWordInfoFragment.getActivity() != null && word != null) {
//                if (-300 == i) {
//                    WordLockApp.setKillOnDestroy(true);
//                }
//                if (moreWordInfoFragment.mWordData == null || moreWordInfoFragment.mWordData.getId().equals(word.getId())) {
//                    if (moreWordInfoFragment.mWordData != null) {
//                        word.setSearch(moreWordInfoFragment.mWordData.isSearch());
//                    }
//                    WordToReviewCache.refreshElement(word);
//                    moreWordInfoFragment.mWordData = word;
//                    moreWordInfoFragment.setupViews();
//                }
//            }
//        }
//    }
//
//    public static MoreWordInfoFragment newInstance(Word word) {
//        MoreWordInfoFragment moreWordInfoFragment = new MoreWordInfoFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("word", word);
//        moreWordInfoFragment.setArguments(bundle);
//        return moreWordInfoFragment;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mWordData = getArguments() != null ? (Word) getArguments().getParcelable("word") : null;
//        this.mWordRefreshCBK = new WordRefreshCallback(this);
//        this.mResMng = ResourceManager.born().setListener(this.mWordRefreshCBK).setMode(15);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.wordlock_client_more_info, viewGroup, false);
//        viewGroup2.setOnClickListener(this);
//        initViews(viewGroup2);
//        setupViews();
////        EventBus.m0a().mo5a((Object) this);
//        return viewGroup2;
//    }
//
//    private void initViews(ViewGroup viewGroup) {
//        this.mMiniWord = (TextView) viewGroup.findViewById(R.id.wordlock_miniword);
//        this.mMiniAccent = (TextView) viewGroup.findViewById(R.id.wordlock_miniaccent);
//        this.mMiniCnmean = (TextView) viewGroup.findViewById(R.id.wordlock_minicnmean);
//        this.mDotsNav = (DotsNavigation) viewGroup.findViewById(R.id.wordlock_more_info_dots_nav);
////        this.mMorePager = (ViewPager) viewGroup.findViewById(R.id.wordlock_more_pager);
//        this.mPullablePager = (PullToRefreshMorePager) viewGroup.findViewById(R.id.wordlock_pull2refresh_more_pager);
//    }
//
//    /* access modifiers changed from: private */
//    public void setupViews() {
//        CustomFont.setFont(this.mMiniWord, 0);
//        this.mMiniWord.setText(this.mWordData != null ? this.mWordData.getWord() : "");
//        CustomFont.setFont(this.mMiniAccent, 3);
//        if (this.mWordData == null || TextUtils.isEmpty(this.mWordData.getAccent())) {
//            this.mMiniAccent.setVisibility(8);
//        } else {
//            this.mMiniAccent.setVisibility(0);
//            this.mMiniAccent.setText(this.mWordData.getAccent());
//        }
//        CustomFont.setFont(this.mMiniCnmean, 0);
//        if (this.mWordData == null || TextUtils.isEmpty(this.mWordData.getCnmean())) {
//            this.mMiniCnmean.setVisibility(8);
//        } else {
//            this.mMiniCnmean.setVisibility(0);
//            this.mMiniCnmean.setText(this.mWordData.getCnmean());
//        }
//        adaptPointers();
//        this.mAdapter = new MoreInfoAdapter();
//        this.mMorePager.setAdapter(this.mAdapter);
////        this.mMorePager.setOnPageChangeListener(this);
//        this.mMorePager.setOnClickListener(this);
//        if (this.mPageCount <= 0) {
//            this.mPullablePager.setOnTouchListener(this);
//        } else {
//            this.mPullablePager.setOnTouchListener(null);
//        }
//    }
//
//    public void onStart() {
//        super.onStart();
//        this.mResMng.get(getActivity(), this.mWordData);
//    }
//
//    public void onDestroyView() {
////        EventBus.m0a().mo8b((Object) this);
//        super.onDestroyView();
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        NavigationManager.setNavingToMore(false);
//    }
//
//    private void adaptPointers() {
//        this.mPageCount = 0;
//        this.mExampleExists = examplePageExists();
//        this.mVividExists = vividPageExits();
//        this.mOtherExists = otherPageExits();
//        if (this.mExampleExists) {
//            this.mPageCount++;
//        }
//        if (this.mVividExists) {
//            this.mPageCount++;
//        }
//        if (this.mOtherExists) {
//            this.mPageCount++;
//        }
//        this.mDotsNav.setCount(this.mPageCount, 0);
//    }
//
//    private void jumpPointerTo(int i) {
//        this.mDotsNav.setCur(i);
//    }
//
//    public void onClick(View view) {
//        back();
//    }
//
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        if (1 == motionEvent.getAction()) {
//            back();
//        }
//        return false;
//    }
//
//    public void setLockBack(boolean z) {
//        this.mLockBack = z;
//    }
//
//    public void onEventMainThread(KeyEvent keyEvent) {
//        if (4 == keyEvent.getKeyCode() && !this.mLockBack) {
//            back();
//        }
//    }
//
//    private void back() {
//        if (!this.mExiting && NavigationManager.canNavToWord()) {
//            this.mExiting = true;
//            NavigationManager.setNavingToWord(true);
//            Fragment parentFragment = getParentFragment();
//            if (parentFragment != null && (parentFragment instanceof WordLockFragment)) {
//                ((WordLockFragment) parentFragment).back(this);
//            }
//        }
//    }
//
//    private boolean examplePageExists() {
//        if (this.mWordData == null) {
//            return false;
//        }
//        if (!TextUtils.isEmpty(this.mWordData.getExample()) || !TextUtils.isEmpty(this.mWordData.getCnexample())) {
//            return true;
//        }
//        if (ResourceManager.isImageExists(this.mWordData)) {
//            return true;
//        }
//        return false;
//    }
//
//    private boolean vividPageExits() {
//        if (this.mWordData != null && ResourceManager.isVividExists(this.mWordData)) {
//            return true;
//        }
//        return false;
//    }
//
//    private boolean otherPageExits() {
//        if (this.mWordData == null) {
//            return false;
//        }
//        if (!TextUtils.isEmpty(this.mWordData.getEnmean()) || !TextUtils.isEmpty(this.mWordData.getRoot())) {
//            return true;
//        }
//        return false;
//    }
//
//    public void onPageScrollStateChanged(int i) {
//        if (2 == i && this.mMorePager != null) {
//            jumpPointerTo(this.mMorePager.getCurrentItem());
//        }
//    }
//
//    public void onPageScrolled(int i, float f, int i2) {
//    }
//
//    public void onPageSelected(int i) {
//    }
//}
