//package com.baicizhan.client.wordlock.fragment;
//
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
////import android.support.p004v4.app.Fragment;
//import android.text.Editable;
//import android.text.Html;
//import android.text.TextUtils;
//import android.text.TextWatcher;
//import android.text.style.ForegroundColorSpan;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.view.animation.TranslateAnimation;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.TextView.OnEditorActionListener;
//
//import androidx.fragment.app.Fragment;
//
//import com.baicizhan.client.business.search.Word;
////import com.baicizhan.client.business.search.WordSearchEngine;
////import com.baicizhan.client.business.search.WordSearchEngine.OnSearchListener;
//import com.baicizhan.client.business.util.SimpleSpannableBuilder;
//import com.baicizhan.client.business.util.SystemUtil;
//import com.baicizhan.client.framework.util.Common;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.util.EasingType.Type;
//import com.baicizhan.client.wordlock.util.ElasticInterpolator;
//import com.baicizhan.client.wordlock.view.CometProgressView;
//import com.jiongji.andriod.card.R;
//
//import java.lang.ref.WeakReference;
//import java.util.List;
////import p000a.p001a.p002a.EventBus;
//
//public class WordSearchFragment extends Fragment implements OnClickListener {
//    private static final String ARG_HAS_HISTORY = "has_history";
//    private View mCancel;
//    /* access modifiers changed from: private */
//    public View mClear;
//    /* access modifiers changed from: private */
//    public boolean mExiting = false;
//    private boolean mHasHistory = false;
//    /* access modifiers changed from: private */
//    public String mKeyword;
//    /* access modifiers changed from: private */
//    public CometProgressView mProgress;
//    private ListView mResultList;
//    /* access modifiers changed from: private */
//    public List<Word> mResults;
//    private View mRootView;
//    /* access modifiers changed from: private */
//    public SearchResultAdapter mRsultAdapter;
//    private View mSearchBar;
////    private OnSearchCallback mSearchCallback;
//    private EditText mSearchEdit;
//    /* access modifiers changed from: private */
////    public WordSearchEngine mSearchEngine;
//    private TextView mTip;
//
//    class HideIMEListener implements OnTouchListener {
//        private HideIMEListener() {
//        }
//
//        public boolean onTouch(View view, MotionEvent motionEvent) {
//            WordSearchFragment.this.hideIME();
//            return false;
//        }
//    }
//
////    class OnSearchCallback implements OnSearchListener {
////        final WeakReference<WordSearchFragment> mFragment;
////
////        OnSearchCallback(WordSearchFragment wordSearchFragment) {
////            this.mFragment = new WeakReference<>(wordSearchFragment);
////        }
////
////        public void onSearched(String str, List<Word> list, int i, String str2) {
////            WordSearchFragment wordSearchFragment = (WordSearchFragment) this.mFragment.get();
////            if (wordSearchFragment != null) {
////                if (wordSearchFragment.mProgress.getVisibility() == 0) {
////                    wordSearchFragment.mProgress.setVisibility(8);
////                }
////                if (!TextUtils.isEmpty(str) && (list == null || list.isEmpty())) {
////                    if (-100 == i) {
////                        wordSearchFragment.toggleTip(R.string.wordlock_search_neterr, true);
////                    } else {
////                        wordSearchFragment.toggleTip(R.string.wordlock_search_none, true);
////                    }
////                }
////                wordSearchFragment.mKeyword = str;
////                wordSearchFragment.mResults = list;
////                wordSearchFragment.mRsultAdapter.notifyDataSetChanged();
////            }
////        }
////
////        public void onSearching() {
////            WordSearchFragment wordSearchFragment = (WordSearchFragment) this.mFragment.get();
////            if (wordSearchFragment != null) {
////                wordSearchFragment.mProgress.setVisibility(0);
////            }
////        }
////    }
//
//    class SearchResultAdapter extends BaseAdapter {
//        private SearchResultAdapter() {
//        }
//
//        public int getCount() {
//            if (WordSearchFragment.this.mResults == null || WordSearchFragment.this.mResults.isEmpty()) {
//                return 0;
//            }
//            return WordSearchFragment.this.mResults.size();
//        }
//
//        public Word getItem(int i) {
//            if (WordSearchFragment.this.mResults != null) {
//                return (Word) WordSearchFragment.this.mResults.get(i);
//            }
//            return null;
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            ViewHolder viewHolder;
//            if (view == null) {
//                view = WordSearchFragment.this.getActivity().getLayoutInflater().inflate(R.layout.wordlock_search_result_item, null);
//                ViewHolder viewHolder2 = new ViewHolder();
//                viewHolder2.word = (TextView) view.findViewById(R.id.wordlock_search_result_word);
//                viewHolder2.cnmean = (TextView) view.findViewById(R.id.wordlock_search_result_cnmean);
//                view.setTag(viewHolder2);
//                viewHolder = viewHolder2;
//            } else {
//                viewHolder = (ViewHolder) view.getTag();
//            }
//            bindItem(viewHolder, getItem(i));
//            return view;
//        }
//
//        private void bindItem(ViewHolder viewHolder, Word word) {
//            String word2 = word.getWord();
//            if (TextUtils.isEmpty(word2) || TextUtils.isEmpty(WordSearchFragment.this.mKeyword)) {
//                viewHolder.word.setText(word.getWord());
//            } else {
//                int indexOf = word2.toLowerCase().indexOf(WordSearchFragment.this.mKeyword.toLowerCase());
//                if (indexOf >= 0) {
//                    String str = indexOf > 0 ? word2.substring(0, indexOf) : "";
//                    String substring = word2.substring(indexOf, WordSearchFragment.this.mKeyword.length() + indexOf);
//                    String substring2 = word2.substring(indexOf + WordSearchFragment.this.mKeyword.length());
//                    SimpleSpannableBuilder simpleSpannableBuilder = new SimpleSpannableBuilder();
//                    simpleSpannableBuilder.append(str).append(substring, new ForegroundColorSpan(WordSearchFragment.this.getResources().getColor(R.color.C32))).append(substring2);
//                    viewHolder.word.setText(simpleSpannableBuilder.build());
//                } else {
//                    SimpleSpannableBuilder simpleSpannableBuilder2 = new SimpleSpannableBuilder();
//                    simpleSpannableBuilder2.append(word.getWord(), new ForegroundColorSpan(WordSearchFragment.this.getResources().getColor(R.color.C32)));
//                    viewHolder.word.setText(simpleSpannableBuilder2.build());
//                }
//            }
//            viewHolder.cnmean.setText(word.getCnmean());
//        }
//    }
//
//    class ViewHolder {
//        /* access modifiers changed from: private */
//        public TextView cnmean;
//        /* access modifiers changed from: private */
//        public TextView word;
//
//        private ViewHolder() {
//        }
//    }
//
//    public static WordSearchFragment newInstance(boolean z) {
//        WordSearchFragment wordSearchFragment = new WordSearchFragment();
//        Bundle bundle = new Bundle();
//        bundle.putBoolean(ARG_HAS_HISTORY, z);
//        wordSearchFragment.setArguments(bundle);
//        return wordSearchFragment;
//    }
//
//    public void onActivityCreated(Bundle bundle) {
//        super.onActivityCreated(bundle);
////        this.mSearchCallback = new OnSearchCallback(this);
////        this.mSearchEngine = WordSearchEngine.born(getActivity()).setListener(this.mSearchCallback);
////        getLoaderManager().mo191a(this.mSearchEngine);
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mHasHistory = getArguments() != null ? getArguments().getBoolean(ARG_HAS_HISTORY) : this.mHasHistory;
////        EventBus.m0a().mo5a((Object) this);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        this.mRootView = layoutInflater.inflate(R.layout.wordlock_search_list, viewGroup, false);
//        setupViews();
//        dropDownSearch();
//        return this.mRootView;
//    }
//
//    private void setupViews() {
//        this.mRootView.setOnTouchListener(new HideIMEListener());
//        this.mRootView.setOnClickListener(this);
//        this.mClear = this.mRootView.findViewById(R.id.wordlock_search_clear);
//        this.mClear.setOnClickListener(this);
//        this.mSearchBar = this.mRootView.findViewById(R.id.wordlock_search_bar);
//        this.mSearchEdit = (EditText) this.mRootView.findViewById(R.id.wordlock_search_edit);
//        Drawable drawable = getResources().getDrawable(R.drawable.dict_search_white_normal_default);
//        drawable.setBounds(0, 0, (drawable.getMinimumWidth() * 3) / 4, (drawable.getMinimumHeight() * 3) / 4);
//        this.mSearchEdit.setCompoundDrawables(drawable, null, null, null);
//        if (this.mHasHistory) {
//            this.mSearchEdit.setHint(Html.fromHtml("<small>" + getString(R.string.wordlock_search_hint_long) + "</small>"));
//        }
//        this.mSearchEdit.addTextChangedListener(new TextWatcher() {
//            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//            }
//
//            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//            }
//
//            public void afterTextChanged(Editable editable) {
//                WordSearchFragment.this.toggleTip(0, false);
//                String obj = editable.toString();
//                if (TextUtils.isEmpty(obj)) {
//                    WordSearchFragment.this.mClear.setVisibility(8);
//                } else {
//                    WordSearchFragment.this.mClear.setVisibility(0);
//                }
////                WordSearchFragment.this.mSearchEngine.setToken(0).setKeyword(obj).search();
//            }
//        });
//        this.mSearchEdit.setOnEditorActionListener(new OnEditorActionListener() {
//            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                if (i == 3) {
//                    WordSearchFragment.this.searchExact();
//                }
//                return true;
//            }
//        });
//        this.mCancel = this.mRootView.findViewById(R.id.wordlock_cancel_search);
//        this.mCancel.setOnClickListener(this);
//        this.mResultList = (ListView) this.mRootView.findViewById(R.id.wordlock_search_result_list);
//        this.mResultList.setOnTouchListener(new HideIMEListener());
//        this.mRsultAdapter = new SearchResultAdapter();
//        this.mResultList.setAdapter(this.mRsultAdapter);
//        this.mResultList.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
//                WordSearchFragment.this.selectResult(WordSearchFragment.this.mRsultAdapter.getItem(i));
//            }
//        });
//        this.mProgress = (CometProgressView) this.mRootView.findViewById(R.id.wordlock_search_progress);
//        this.mTip = (TextView) this.mRootView.findViewById(R.id.wordlock_search_tip);
//    }
//
//    private void dropDownSearch() {
//        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-Common.dip2px(getActivity(), 75.0f)), 0.0f);
//        translateAnimation.setDuration(400);
//        translateAnimation.setInterpolator(new ElasticInterpolator(Type.OUT, 0.0f, 0.65f));
//        translateAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
//                if (!WordSearchFragment.this.mExiting) {
//                    WordSearchFragment.this.showIME();
////                    WordSearchFragment.this.mSearchEngine.setKeyword("").search();
//                }
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//        this.mSearchBar.startAnimation(translateAnimation);
//        this.mCancel.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_in_short));
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
////        EventBus.m0a().mo8b((Object) this);
//        hideIME();
//        NavigationManager.setNavingToSearch(false);
//    }
//
//    /* access modifiers changed from: private */
//    public void toggleTip(int i, boolean z) {
//        if (i > 0) {
//            this.mTip.setText(i);
//        }
//        if (this.mTip.getVisibility() == 0 && !z) {
//            this.mTip.setVisibility(4);
//            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//            alphaAnimation.setDuration(200);
//            this.mTip.startAnimation(alphaAnimation);
//        } else if (this.mTip.getVisibility() != 0 && z) {
//            this.mTip.setVisibility(0);
//            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
//            alphaAnimation2.setDuration(200);
//            this.mTip.startAnimation(alphaAnimation2);
//        }
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.wordlock_cancel_search || id == R.id.wordlock_search_list) {
//            cancelSearch();
//        } else if (id == R.id.wordlock_search_clear) {
//            this.mSearchEdit.setText(null);
//            showIME();
//        }
//    }
//
//    public void onEventMainThread(KeyEvent keyEvent) {
//        if (4 == keyEvent.getKeyCode()) {
//            cancelSearch();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void searchExact() {
//        String obj = this.mSearchEdit.getText().toString();
//        if (!TextUtils.isEmpty(obj)) {
////            this.mSearchEngine.setToken(1).setKeyword(obj).search();
//            hideIME();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void selectResult(Word word) {
//        hideIME();
//        Fragment parentFragment = getParentFragment();
//        if (parentFragment != null && (parentFragment instanceof WordLockFragment)) {
//            ((WordLockFragment) parentFragment).selectSearchResult(this, word);
//        }
//    }
//
//    private void cancelSearch() {
//        if (!this.mExiting) {
//            this.mExiting = true;
//            this.mSearchEdit.clearAnimation();
//            hideIME();
//            Fragment parentFragment = getParentFragment();
//            if (parentFragment != null && (parentFragment instanceof WordLockFragment)) {
//                ((WordLockFragment) parentFragment).cancelSearch(this);
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void showIME() {
//        if (getActivity() != null) {
//            this.mSearchEdit.requestFocus();
//            SystemUtil.showIME(this.mSearchEdit);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void hideIME() {
//        if (getActivity() != null) {
//            SystemUtil.hideIME(this.mSearchEdit);
//        }
//    }
//}
