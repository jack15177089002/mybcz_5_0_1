//package com.baicizhan.main.wordlist.view;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.widget.AbsListView;
//import android.widget.AbsListView.OnScrollListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.main.wordlist.activity.WordListWikiActivity;
//import com.baicizhan.main.wordlist.eventbus.WordListEvents.WordListEditEvent;
//import com.baicizhan.main.wordlist.eventbus.WordListEvents.WordListHeaderEvent;
//import com.baicizhan.main.wordlist.eventbus.WordListEvents.WordListNavChangeEvent;
//import com.baicizhan.main.wordlist.view.WordListDataManager.OnWordBulkLoadListener;
//import com.baicizhan.main.wordlist.view.WordListDataManager.OrderedWord;
//import com.baicizhan.main.wordlist.view.WordListHeader.OnHeaderActionListener;
//import com.baicizhan.main.wordlist.view.WordListNav.OnWordListNavigation;
//import com.handmark.pulltorefresh.library.C1624r;
//import com.handmark.pulltorefresh.library.PullToRefreshBase;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import p000a.p001a.p002a.EventBus;
//
//public class WLLineFragment extends Fragment implements OnHeaderActionListener, OnWordListNavigation {
//    private static final String CUR_NAV = "cur_nav";
//    private static final int LOAD_TOKEN_NORMAL = 0;
//    private static final int LOAD_TOKEN_RESET = 1;
//    private static final String NAV_TYPE = "nav_type";
//    /* access modifiers changed from: private */
//    public WordListAdapter mAdapter;
//    /* access modifiers changed from: private */
//    public List<OrderedWord> mAllWords;
//    private int mCurNav;
//    /* access modifiers changed from: private */
//    public WordListDataManager mDataManager;
//    /* access modifiers changed from: private */
//    public boolean mEditMode;
//    /* access modifiers changed from: private */
//    public List<Word> mLoadedWords;
//    /* access modifiers changed from: private */
//    public boolean mLoadingBulk = false;
//    /* access modifiers changed from: private */
//    public int mNavType;
//    private boolean mNeedTryToast = false;
//    /* access modifiers changed from: private */
//    public AudioPlayer mPlayer;
//    /* access modifiers changed from: private */
//    public PullableWordList mPullableWordList;
//    private View mRootView;
//
//    class ViewHolder {
//        /* access modifiers changed from: private */
//        public TextView mCnmean;
//        /* access modifiers changed from: private */
//        public FrameLayout mCnmeanFrame;
//        /* access modifiers changed from: private */
//        public Button mKillOrCancel;
//        /* access modifiers changed from: private */
//        public TextView mWord;
//        /* access modifiers changed from: private */
//        public TextView mWrongCount;
//
//        private ViewHolder() {
//        }
//    }
//
//    class WordListAdapter extends BaseAdapter {
//        private WordListAdapter() {
//            WLLineFragment.sendHeaderEvent(WLLineFragment.this.mNavType, WLLineFragment.this.mEditMode, WLLineFragment.this.mAllWords != null ? WLLineFragment.this.mAllWords.size() : 0);
//        }
//
//        public int getCount() {
//            if (WLLineFragment.this.mLoadedWords != null) {
//                return WLLineFragment.this.mLoadedWords.size();
//            }
//            return 0;
//        }
//
//        public Word getItem(int i) {
//            if (WLLineFragment.this.mLoadedWords != null) {
//                return (Word) WLLineFragment.this.mLoadedWords.get(i);
//            }
//            return null;
//        }
//
//        public long getItemId(int i) {
//            Word item = getItem(i);
//            if (item != null) {
//                return (long) item.baseInfo.topicId;
//            }
//            return (long) i;
//        }
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            ViewHolder viewHolder;
//            if (view == null) {
//                view = WLLineFragment.this.getActivity().getLayoutInflater().inflate(R.layout.wordlist_item, null);
//                ViewHolder viewHolder2 = new ViewHolder();
//                viewHolder2.mWord = (TextView) view.findViewById(R.id.wordlist_item_word);
//                viewHolder2.mWrongCount = (TextView) view.findViewById(R.id.wordlist_item_wrong_count);
//                viewHolder2.mKillOrCancel = (Button) view.findViewById(R.id.wordlist_item_kill);
//                viewHolder2.mCnmean = (TextView) view.findViewById(R.id.wordlist_item_cnmean);
//                viewHolder2.mCnmeanFrame = (FrameLayout) view.findViewById(R.id.wordlist_item_cnmean_frame);
//                viewHolder2.mCnmeanFrame.setForeground(ThemeResUtil.getSelectStateDrawable((Context) WLLineFragment.this.getActivity(), ThemeUtil.getThemeDrawableWithAttr(WLLineFragment.this.getActivity(), R.attr.drawable_mask_wordlist), -1));
//                view.setTag(viewHolder2);
//                viewHolder = viewHolder2;
//            } else {
//                viewHolder = (ViewHolder) view.getTag();
//            }
//            bindItem(viewHolder, i);
//            return view;
//        }
//
//        private void bindItem(ViewHolder viewHolder, final int i) {
//            final Word item = getItem(i);
//            viewHolder.mWord.setText(item.baseInfo.word);
//            viewHolder.mWrongCount.setText(item.errCount);
//            viewHolder.mCnmean.setText(item.baseInfo.meanCn != null ? item.baseInfo.meanCn.trim() : "");
//            viewHolder.mKillOrCancel.setOnClickListener(new OnClickListener() {
//                public void onClick(View view) {
//                    WordListEditEvent wordListEditEvent = new WordListEditEvent();
//                    if (2 == WLLineFragment.this.mNavType) {
//                        WordListDataManager.cancelKillWord(item.baseInfo.topicId);
//                        wordListEditEvent.setEventCode(1);
//                    } else {
//                        WordListDataManager.killWord(item.baseInfo.topicId);
//                        wordListEditEvent.setEventCode(0);
//                        WLLineFragment.this.mPlayer.newPlayRaw(R.raw.chop);
//                    }
//                    OrderedWord orderedWord = new OrderedWord();
//                    orderedWord.topicId = item.baseInfo.topicId;
//                    orderedWord.errCount = item.errCount;
//                    wordListEditEvent.setWord(orderedWord);
//                    EventBus.m0a().mo9c((Object) wordListEditEvent);
//                    WLLineFragment.this.mLoadedWords.remove(i);
//                    WLLineFragment.this.mAllWords.remove(i);
//                    if (WLLineFragment.this.mLoadedWords.size() < 10 && WLLineFragment.this.mAllWords.size() > WLLineFragment.this.mLoadedWords.size() && !WLLineFragment.this.mDataManager.isLoading()) {
//                        WLLineFragment.this.loadNextBulk(0, WLLineFragment.this.mLoadedWords.size(), WLLineFragment.this.mAllWords);
//                    }
//                    WLLineFragment.sendHeaderEvent(WLLineFragment.this.mNavType, WLLineFragment.this.mEditMode, WLLineFragment.this.mAllWords.size());
//                    WordListAdapter.this.notifyDataSetChanged();
//                }
//            });
//            if (2 == WLLineFragment.this.mNavType) {
//                viewHolder.mKillOrCancel.setText(R.string.wordlist_item_cancel_kill);
//            }
//            viewHolder.mCnmeanFrame.setOnClickListener(new OnClickListener() {
//                public void onClick(View view) {
//                    boolean z;
//                    boolean z2 = true;
//                    if (!((Word) WLLineFragment.this.mLoadedWords.get(i)).visible) {
//                        z = true;
//                    } else {
//                        z = false;
//                    }
//                    view.setSelected(z);
//                    Word word = (Word) WLLineFragment.this.mLoadedWords.get(i);
//                    if (((Word) WLLineFragment.this.mLoadedWords.get(i)).visible) {
//                        z2 = false;
//                    }
//                    word.visible = z2;
//                }
//            });
//            viewHolder.mCnmeanFrame.setSelected(((Word) WLLineFragment.this.mLoadedWords.get(i)).visible);
//            if (WLLineFragment.this.mEditMode) {
//                viewHolder.mKillOrCancel.setVisibility(0);
//                viewHolder.mWrongCount.setVisibility(8);
//                return;
//            }
//            viewHolder.mKillOrCancel.setVisibility(8);
//            viewHolder.mWrongCount.setVisibility(0);
//        }
//    }
//
//    public void navigateTo(int i) {
//        this.mCurNav = i;
//    }
//
//    public void setEditMode(boolean z) {
//        this.mEditMode = z;
//        if (this.mAdapter != null) {
//            this.mAdapter.notifyDataSetChanged();
//        }
//    }
//
//    public boolean isEditMode() {
//        return this.mEditMode;
//    }
//
//    public int getWordCount() {
//        if (this.mAllWords != null) {
//            return this.mAllWords.size();
//        }
//        return 0;
//    }
//
//    public void refresh(OrderedWord orderedWord) {
//        if (this.mAllWords == null || this.mAllWords.isEmpty()) {
//            this.mAdapter = new WordListAdapter();
//            this.mPullableWordList.setAdapter(this.mAdapter);
//            initDatas();
//            return;
//        }
//        this.mAllWords.add(orderedWord);
//        if (this.mNavType != 1) {
//            Collections.sort(this.mAllWords);
//        }
//        this.mLoadedWords = new ArrayList();
//        this.mAdapter = new WordListAdapter();
//        this.mPullableWordList.setAdapter(this.mAdapter);
//        loadNextBulk(1, 0, this.mAllWords);
//    }
//
//    public void tryToastNoWord() {
//        if (this.mAllWords == null || this.mAllWords.isEmpty()) {
//            int i = R.string.wordlist_no_learned;
//            switch (this.mNavType) {
//                case 1:
//                    i = R.string.wordlist_no_unlearned;
//                    break;
//                case 2:
//                    i = R.string.wordlist_no_killed;
//                    break;
//            }
//            Toast.makeText(getActivity(), i, 0).show();
//        }
//    }
//
//    public static WLLineFragment newInstance(int i, int i2) {
//        WLLineFragment wLLineFragment = new WLLineFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(NAV_TYPE, i);
//        bundle.putInt(CUR_NAV, i2);
//        wLLineFragment.setArguments(bundle);
//        return wLLineFragment;
//    }
//
//    public void onCreate(Bundle bundle) {
//        int i = 0;
//        super.onCreate(bundle);
//        this.mNavType = getArguments() != null ? getArguments().getInt(NAV_TYPE) : 0;
//        if (getArguments() != null) {
//            i = getArguments().getInt(CUR_NAV);
//        }
//        this.mCurNav = i;
//        if (this.mNavType == 0) {
//            this.mNeedTryToast = true;
//        }
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        this.mPlayer = new AudioPlayer(getActivity());
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.wordlist_recycler_list, viewGroup, false);
//        initViews(viewGroup2);
//        this.mRootView = viewGroup2;
//        this.mRootView.setVisibility(8);
//        return viewGroup2;
//    }
//
//    public void onActivityCreated(Bundle bundle) {
//        super.onActivityCreated(bundle);
//        setupViews();
//        initDatas();
//    }
//
//    public void onDestroyView() {
//        super.onDestroyView();
//        this.mPlayer.destroy();
//    }
//
//    private void initDatas() {
//        this.mLoadedWords = new ArrayList();
//        this.mDataManager = WordListDataManager.createInstance(getActivity(), this.mNavType, new OnWordBulkLoadListener() {
//            public void onStartInit() {
//            }
//
//            public void onDataInited(List<OrderedWord> list) {
//                WLLineFragment.this.mAllWords = list;
//                WLLineFragment.this.loadNextBulk(0, 0, WLLineFragment.this.mAllWords);
//            }
//
//            public void onStartLoad() {
//            }
//
//            public void onLoadComplete(int i, List<Word> list, List<OrderedWord> list2) {
//                WLLineFragment.this.feedDatas(i, list, list2);
//                WLLineFragment.this.boomContent();
//                WLLineFragment.this.mLoadingBulk = false;
//            }
//        });
//        this.mDataManager.initData();
//    }
//
//    /* access modifiers changed from: private */
//    public void loadNextBulk(int i, int i2, List<OrderedWord> list) {
//        if (1 == i) {
//            this.mLoadingBulk = true;
//            this.mDataManager.loadNextBulk(i, i2, list);
//        } else if (!this.mLoadingBulk) {
//            this.mLoadingBulk = true;
//            this.mDataManager.loadNextBulk(i, i2, list);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void boomContent() {
//        if (this.mRootView != null && this.mRootView.getVisibility() != 0) {
//            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), 17432576);
//            loadAnimation.setAnimationListener(new AnimationListener() {
//                public void onAnimationStart(Animation animation) {
//                }
//
//                public void onAnimationEnd(Animation animation) {
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//            });
//            this.mRootView.startAnimation(loadAnimation);
//            this.mRootView.setVisibility(0);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void feedDatas(int i, List<Word> list, List<OrderedWord> list2) {
//        if (list2 == null || list2.isEmpty()) {
//            if (this.mNeedTryToast) {
//                this.mNeedTryToast = false;
//                tryToastNoWord();
//            }
//            if (this.mPullableWordList != null) {
//                this.mAllWords = new ArrayList(0);
//                this.mAdapter = new WordListAdapter();
//                this.mPullableWordList.setAdapter(this.mAdapter);
//                if (this.mPullableWordList != null) {
//                    this.mPullableWordList.onRefreshComplete();
//                }
//            } else if (this.mPullableWordList != null) {
//                this.mPullableWordList.onRefreshComplete();
//            }
//        } else {
//            this.mAllWords = list2;
//            sendHeaderEvent(this.mNavType, this.mEditMode, this.mAllWords.size());
//            if (this.mAdapter != null && list != null && list.size() > 0) {
//                if (1 == i) {
//                    this.mLoadedWords = list;
//                } else {
//                    this.mLoadedWords.addAll(list);
//                }
//                this.mAdapter.notifyDataSetChanged();
//            } else if (list == null || list.size() <= 0) {
//                Toast.makeText(getActivity(), R.string.wordlist_no_more_word, 0).show();
//            }
//            if (this.mPullableWordList != null) {
//                this.mPullableWordList.post(new Runnable() {
//                    public void run() {
//                        WLLineFragment.this.mPullableWordList.onRefreshComplete();
//                    }
//                });
//                if (this.mLoadedWords.size() == this.mAllWords.size()) {
//                    this.mPullableWordList.setPullable(true);
//                }
//            }
//        }
//    }
//
//    private void initViews(ViewGroup viewGroup) {
//        this.mPullableWordList = (PullableWordList) viewGroup.findViewById(R.id.wordlist_pullable_recycler_list);
//        this.mPullableWordList.setPullable(false);
//    }
//
//    private void setupViews() {
//        this.mPullableWordList.setOnRefreshListener((C1624r<T>) new C1624r<ListView>() {
//            public void onRefresh(PullToRefreshBase<ListView> gVar) {
//                if (WLLineFragment.this.mDataManager != null && WLLineFragment.this.mLoadedWords.size() == WLLineFragment.this.mAllWords.size()) {
//                    WLLineFragment.this.loadNextBulk(0, WLLineFragment.this.mLoadedWords.size(), WLLineFragment.this.mAllWords);
//                }
//            }
//        });
//        this.mAdapter = new WordListAdapter();
//        this.mPullableWordList.setAdapter(this.mAdapter);
//        this.mPullableWordList.setOnScrollListener(new OnScrollListener() {
//            public void onScrollStateChanged(AbsListView absListView, int i) {
//                if (i == 0 && ((ListView) WLLineFragment.this.mPullableWordList.getRefreshableView()).getLastVisiblePosition() >= ((ListView) WLLineFragment.this.mPullableWordList.getRefreshableView()).getCount() - 2 && WLLineFragment.this.mDataManager != null && WLLineFragment.this.mLoadedWords.size() != WLLineFragment.this.mAllWords.size()) {
//                    WLLineFragment.this.loadNextBulk(0, WLLineFragment.this.mLoadedWords.size(), WLLineFragment.this.mAllWords);
//                }
//            }
//
//            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
//            }
//        });
//        this.mPullableWordList.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
//                WordListWikiActivity.start(WLLineFragment.this.getActivity(), WLLineFragment.this.mAdapter.getItem(i - 1).baseInfo.topicId);
//            }
//        });
//    }
//
//    public void onEditModeChanged(boolean z) {
//        this.mEditMode = z;
//        if (this.mAdapter != null) {
//            this.mAdapter.notifyDataSetChanged();
//        }
//        sendHeaderEvent(this.mNavType, this.mEditMode, this.mAllWords != null ? this.mAllWords.size() : 0);
//    }
//
//    public void OnWordListNavChanged(int i) {
//        this.mCurNav = i;
//        WordListNavChangeEvent wordListNavChangeEvent = new WordListNavChangeEvent();
//        wordListNavChangeEvent.setPosition(i);
//        EventBus.m0a().mo9c((Object) wordListNavChangeEvent);
//    }
//
//    /* access modifiers changed from: private */
//    public static void sendHeaderEvent(int i, boolean z, int i2) {
//        WordListHeaderEvent wordListHeaderEvent = new WordListHeaderEvent();
//        wordListHeaderEvent.setCurNav(i);
//        wordListHeaderEvent.setEditMode(z);
//        wordListHeaderEvent.setWordCount(i2);
//        EventBus.m0a().mo9c((Object) wordListHeaderEvent);
//    }
//}
