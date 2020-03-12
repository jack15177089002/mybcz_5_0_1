//package com.baicizhan.client.business.search;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.support.p004v4.app.C0018ar;
//import android.support.p004v4.content.AsyncTaskLoader;
//import android.support.p004v4.content.Loader;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.MiscRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.models.TopicSearchSuggestion;
//import com.baicizhan.client.business.search.p028db.SearchHelper;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.util.ErrCodes;
//import com.baicizhan.online.bs_words.BBWordSearchResult;
//import com.baicizhan.online.bs_words.BSWords.Client;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.List;
//import org.p100a.p101a.C2123l;
//
//public class WordSearchEngine implements C0018ar<Params> {
//    private static final int MSG_SEARCHED = 1;
//    private static final int MSG_SEARCHING = 0;
//    private static final int SEARCH_LIMIT = 5;
//    public static final int TOKEN_SEARCH_EXACT = 1;
//    public static final int TOKEN_SEARCH_NORMAL = 0;
//    private Context mContext;
//    private UIHandler mHandler;
//    private String mKeyword;
//    /* access modifiers changed from: private */
//    public OnSearchListener mListener;
//    private SearchLoader mSearchLoader;
//    private int mToken = 0;
//
//    public interface OnSearchListener {
//        void onSearched(String str, List<Word> list, int i, String str2);
//
//        void onSearching();
//    }
//
//    class Params {
//        /* access modifiers changed from: private */
//        public int errcode = 0;
//        /* access modifiers changed from: private */
//        public String errmsg;
//        /* access modifiers changed from: private */
//        public String keyword;
//        /* access modifiers changed from: private */
//        public List<Word> results;
//        /* access modifiers changed from: private */
//        public int token;
//
//        Params() {
//        }
//    }
//
//    class SearchLoader extends AsyncTaskLoader<Params> {
//        private final WeakReference<WordSearchEngine> mEngine;
//        /* access modifiers changed from: private */
//        public String mKeyword;
//        /* access modifiers changed from: private */
//        public int mToken;
//
//        public SearchLoader(Context context, WordSearchEngine wordSearchEngine) {
//            super(context);
//            this.mEngine = new WeakReference<>(wordSearchEngine);
//        }
//
//        public Params loadInBackground() {
//            List loadOnline;
//            WordSearchEngine wordSearchEngine = (WordSearchEngine) this.mEngine.get();
//            if (wordSearchEngine == null) {
//                return null;
//            }
//            Params params = new Params();
//            params.token = this.mToken;
//            params.keyword = this.mKeyword;
//            if (TextUtils.isEmpty(params.keyword)) {
//                params.results = SearchHelper.getSearchHistories(getContext());
//                return params;
//            }
//            List<Word> loadFromTotal = loadFromTotal(getContext(), PropertyHelper.getInt(PropertyHelper.CURRENT_BOOK_ID), this.mKeyword, 5);
//            if (loadFromTotal != null && loadFromTotal.size() > 0 && loadFromTotal.size() < 5 && params.token != 1) {
//                WordSearchEngine.sort(params.keyword, loadFromTotal);
//                params.results = new ArrayList(loadFromTotal);
//                wordSearchEngine.notifySearched(params);
//                HashSet hashSet = new HashSet();
//                for (Word word : loadFromTotal) {
//                    hashSet.add(word.getWord());
//                }
//                List<Word> loadOnline2 = loadOnline(getContext(), params);
//                if (loadOnline2 != null && !loadOnline2.isEmpty()) {
//                    for (Word word2 : loadOnline2) {
//                        if (!hashSet.contains(word2.getWord())) {
//                            loadFromTotal.add(word2);
//                        }
//                    }
//                }
//                loadOnline = loadFromTotal;
//            } else if (loadFromTotal == null || loadFromTotal.isEmpty()) {
//                wordSearchEngine.notifySearching();
//                loadOnline = loadOnline(getContext(), params);
//                wordSearchEngine.cancelNotifySearching();
//            } else {
//                WordSearchEngine.sort(params.keyword, loadFromTotal);
//                loadOnline = loadFromTotal;
//            }
//            params.results = loadOnline;
//            filterResults(getContext(), wordSearchEngine, params);
//            return params;
//        }
//
//        private static List<Word> loadFromTotal(Context context, int i, String str, int i2) {
//            return WordSearchEngine.adaptFromLocal(MiscRecordHelper.getTopicSearchSuggestion(context, i, str, i2));
//        }
//
//        private static List<Word> loadFromDictionary(Context context, String str, int i) {
//            return WordSearchEngine.adaptFromLocal(MiscRecordHelper.getDictionarySearchSuggestion(context, str, i));
//        }
//
//        private static List<Word> loadOnline(Context context, Params params) {
//            try {
//                if (ThriftManager.setToken(context)) {
//                    return WordSearchEngine.adaptFromOnline(((Client) BaicizhanThrifts.getProxy().createClient(BaicizhanThrifts.WORDS)).word_search(params.keyword));
//                }
//                Log.d("whiz", "search online, set token failed");
//                return null;
//            } catch (Exception e) {
//                e.printStackTrace();
//                if (e instanceof C2123l) {
//                    params.errcode = ErrCodes.parseNetRelatedErrCode((C2123l) e);
//                    params.errmsg = ErrCodes.buildErrMessage(params.errcode, e.getMessage());
//                }
//                return null;
//            }
//        }
//
//        private static void filterResults(Context context, WordSearchEngine wordSearchEngine, Params params) {
//            filterResults(context, wordSearchEngine, params, true);
//        }
//
//        private static void filterResults(Context context, WordSearchEngine wordSearchEngine, Params params, boolean z) {
//            if (params != null && params.results != null && !TextUtils.isEmpty(params.keyword) && 1 == params.token) {
//                Word word = null;
//                for (Word word2 : params.results) {
//                    if (!TextUtils.equals(params.keyword.toLowerCase(), word2.getWord().toLowerCase())) {
//                        word2 = word;
//                    }
//                    word = word2;
//                }
//                if (word == null && z) {
//                    wordSearchEngine.notifySearching();
//                    params.results = loadOnline(context, params);
//                    filterResults(context, wordSearchEngine, params, false);
//                    wordSearchEngine.cancelNotifySearching();
//                }
//            }
//        }
//    }
//
//    class UIHandler extends Handler {
//        final WeakReference<WordSearchEngine> mEngine;
//
//        UIHandler(WordSearchEngine wordSearchEngine) {
//            super(Looper.getMainLooper());
//            this.mEngine = new WeakReference<>(wordSearchEngine);
//        }
//
//        public void handleMessage(Message message) {
//            WordSearchEngine wordSearchEngine = (WordSearchEngine) this.mEngine.get();
//            if (wordSearchEngine != null) {
//                int i = message.what;
//                if (i == 0) {
//                    if (wordSearchEngine.mListener != null) {
//                        wordSearchEngine.mListener.onSearching();
//                    }
//                } else if (1 == i) {
//                    Params params = (Params) message.obj;
//                    if (wordSearchEngine.mListener != null) {
//                        wordSearchEngine.mListener.onSearched(params.keyword, params.results, params.errcode, params.errmsg);
//                    }
//                }
//            }
//        }
//    }
//
//    class WordComparator implements Comparator<Word> {
//        final String keyword;
//
//        private WordComparator(String str) {
//            this.keyword = str;
//        }
//
//        public int compare(Word word, Word word2) {
//            String word3 = word.getWord();
//            String word4 = word2.getWord();
//            if (!TextUtils.isEmpty(word3) && !TextUtils.isEmpty(word4)) {
//                String lowerCase = word3.toLowerCase();
//                String lowerCase2 = word4.toLowerCase();
//                String str = this.keyword != null ? this.keyword.toLowerCase() : "";
//                if (TextUtils.equals(lowerCase, str)) {
//                    return -1;
//                }
//                if (TextUtils.equals(lowerCase2, str)) {
//                    return 1;
//                }
//                if (lowerCase.startsWith(str) && !lowerCase2.startsWith(str)) {
//                    return -1;
//                }
//                if (lowerCase.startsWith(str) || !lowerCase2.startsWith(str)) {
//                    return lowerCase.compareTo(lowerCase2);
//                }
//                return 1;
//            } else if (TextUtils.isEmpty(word3)) {
//                return 1;
//            } else {
//                return -1;
//            }
//        }
//    }
//
//    private WordSearchEngine(Context context) {
//        this.mContext = context;
//        this.mHandler = new UIHandler(this);
//    }
//
//    public static WordSearchEngine born(Context context) {
//        return new WordSearchEngine(context);
//    }
//
//    public WordSearchEngine setListener(OnSearchListener onSearchListener) {
//        this.mListener = onSearchListener;
//        return this;
//    }
//
//    public WordSearchEngine setToken(int i) {
//        this.mToken = i;
//        return this;
//    }
//
//    public WordSearchEngine setKeyword(String str) {
//        this.mKeyword = str;
//        return this;
//    }
//
//    public WordSearchEngine search() {
//        if (this.mSearchLoader != null) {
//            this.mSearchLoader.mToken = this.mToken;
//            this.mSearchLoader.mKeyword = this.mKeyword;
//            this.mSearchLoader.onContentChanged();
//        }
//        return this;
//    }
//
//    public Loader<Params> onCreateLoader(int i, Bundle bundle) {
//        this.mSearchLoader = new SearchLoader(this.mContext, this);
//        return this.mSearchLoader;
//    }
//
//    public void onLoadFinished(Loader<Params> dVar, Params params) {
//        if (this.mListener != null) {
//            this.mListener.onSearched(params.keyword, params.results, params.errcode, params.errmsg);
//        }
//    }
//
//    public void onLoaderReset(Loader<Params> dVar) {
//    }
//
//    /* access modifiers changed from: private */
//    public void notifySearching() {
//        this.mHandler.sendEmptyMessageDelayed(0, 1000);
//    }
//
//    /* access modifiers changed from: private */
//    public void cancelNotifySearching() {
//        this.mHandler.removeMessages(0);
//    }
//
//    /* access modifiers changed from: private */
//    public void notifySearched(Params params) {
//        if (params != null) {
//            Message obtainMessage = this.mHandler.obtainMessage();
//            obtainMessage.what = 1;
//            obtainMessage.obj = params;
//            this.mHandler.sendMessage(obtainMessage);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public static List<Word> adaptFromLocal(List<TopicSearchSuggestion> list) {
//        if (list == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList(list.size());
//        for (TopicSearchSuggestion topicSearchSuggestion : list) {
//            boolean z = topicSearchSuggestion.fullRecord == null;
//            Word word = new Word();
//            word.setBookId(topicSearchSuggestion.bookId);
//            word.setId(String.valueOf(topicSearchSuggestion.topicId));
//            word.setWord(topicSearchSuggestion.word);
//            word.setCnmean(topicSearchSuggestion.wordMean);
//            word.setAccent(topicSearchSuggestion.phonetic);
//            if (!z) {
//                word.setAudio(topicSearchSuggestion.fullRecord.wordAudio);
//                word.setExample(topicSearchSuggestion.fullRecord.sentence);
//                word.setCnexample(topicSearchSuggestion.fullRecord.sentenceTrans);
//                word.setImage(topicSearchSuggestion.fullRecord.imagePath);
//                word.setVivid(topicSearchSuggestion.fullRecord.deformationImagePath);
//                word.setEnmean(topicSearchSuggestion.fullRecord.wordMeanEn);
//                word.setRoot(topicSearchSuggestion.fullRecord.wordEtyma);
//                word.setVariants(topicSearchSuggestion.fullRecord.wordVariants);
//            }
//            word.setBase(z);
//            word.setSearch(true);
//            arrayList.add(word);
//        }
//        return arrayList;
//    }
//
//    /* access modifiers changed from: private */
//    public static List<Word> adaptFromOnline(List<BBWordSearchResult> list) {
//        if (list == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList(list.size());
//        for (BBWordSearchResult bBWordSearchResult : list) {
//            Word word = new Word();
//            word.setBookId(bBWordSearchResult.word_level_id);
//            word.setId(String.valueOf(bBWordSearchResult.topic_id));
//            word.setWord(bBWordSearchResult.word);
//            word.setCnmean(bBWordSearchResult.mean_cn);
//            word.setBase(true);
//            word.setSearch(true);
//            arrayList.add(word);
//        }
//        return arrayList;
//    }
//
//    /* access modifiers changed from: private */
//    public static void sort(String str, List<Word> list) {
//        if (list != null && !list.isEmpty()) {
//            Collections.sort(list, new WordComparator(str));
//        }
//    }
//}
