//package com.baicizhan.main.phrasetraining.data.load;
//
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.text.TextUtils;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.framework.asynctask.LAsyncTask;
//import com.baicizhan.client.framework.asynctask.LAsyncTask.LAsyncTaskStatus;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager.Builder;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.main.DemoHandler;
//import com.baicizhan.main.phrasetraining.data.bean.Phrase;
//import com.baicizhan.main.phrasetraining.data.bean.TopicPatterns;
//import com.baicizhan.main.phrasetraining.data.bean.TopicPatterns.Topic;
//import com.jiongji.andriod.card.R;
//import java.io.File;
//import java.lang.ref.WeakReference;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//public class PhraseDownloader {
//    private static final int MSG_ASK_MOBILE_CAPABLE = 0;
//    private static final int MSG_SEND_CANCELLED = 4;
//    private static final int MSG_SEND_INITED = 1;
//    private static final int MSG_SEND_LOADED = 3;
//    private static final int MSG_SEND_PROGRESS = 2;
//    /* access modifiers changed from: private */
//    public static int TASK_TYPE_DOWNLOAD = 1;
//    /* access modifiers changed from: private */
//    public static int TASK_TYPE_INIT = 0;
//    boolean mAsked = false;
//    /* access modifiers changed from: private */
//    public PLContext mContext;
//    private UIHandler mHandler;
//    boolean mMobileCapable = false;
//    volatile boolean mNewDownload = true;
//    private DownLoaderTask mTask;
//
//    class DownLoaderTask extends LAsyncTask<Integer, Integer, Result> {
//        DownLoaderTask() {
//            setKey(Common.md5(PhraseDownloader.this.mContext.mCallback != null ? PhraseDownloader.this.mContext.mCallback.getClass().getName() : PhraseDownloader.class.getName()));
//            parallelTask(1);
//        }
//
//        /* access modifiers changed from: protected */
//        public Result doInBackground(Integer... numArr) {
//            boolean z;
//            Result result = new Result();
//            result.type = numArr[0].intValue();
//            result.code = 0;
//            result.success = true;
//            result.callback = true;
//            result.suspend = false;
//            ArrayList arrayList = new ArrayList();
//            if ((PhraseDownloader.this.mNewDownload || PhraseDownloader.this.mContext.mPatternsList.isEmpty() || PhraseDownloader.this.mContext.mPhrasesList.isEmpty() || PhraseDownloader.this.mContext.mPatternsList.size() != PhraseDownloader.this.mContext.mPhrasesList.size()) && !PhraseDownloader.this.mContext.fillPhrases()) {
//                C0789L.log.error("load phrase failed from json load error.");
//                PhraseDownloader.this.mContext.mPatternsList.clear();
//                PhraseDownloader.this.mContext.mPhrasesList.clear();
//                result.success = false;
//                result.code = -1;
//                return result;
//            }
//            int size = PhraseDownloader.this.mContext.mPatternsList.size();
//            int i = 0;
//            int i2 = 0;
//            while (i < size) {
//                Map map = (Map) PhraseDownloader.this.mContext.mPhrasesList.get(i);
//                List access$300 = PhraseDownloader.this.getUrls(result, (TopicPatterns) PhraseDownloader.this.mContext.mPatternsList.get(i), map);
//                if (result.suspend) {
//                    PhraseDownloader.this.mContext.mPatternsList.clear();
//                    PhraseDownloader.this.mContext.mPhrasesList.clear();
//                    result.success = false;
//                    return result;
//                }
//                arrayList.addAll(access$300);
//                i++;
//                i2 += map.size();
//            }
//            float f = 0.15f * ((float) i2);
//            int size2 = arrayList.size();
//            float f2 = (((float) i2) * 0.15f) / ((float) size2);
//            SyncDownloadManager build = new Builder().build();
//            Iterator it = arrayList.iterator();
//            int i3 = 0;
//            while (true) {
//                if (!it.hasNext()) {
//                    break;
//                }
//                URL url = (URL) it.next();
//                File file = new File(url.saved);
//                if (file.exists() && file.length() > 0) {
//                    i3++;
//                } else if (PhraseDownloader.TASK_TYPE_INIT == result.type) {
//                    result.progress = (i3 * 100) / size2;
//                    result.completed = ((float) i3) * f2;
//                    result.total = f;
//                    return result;
//                } else if (isCancelled()) {
//                    result.success = false;
//                    result.callback = false;
//                    break;
//                } else {
//                    build.setUrl(url.url);
//                    build.setDestPath(url.saved);
//                    boolean start = build.start();
//                    if (!start) {
//                        build.setUrl(url.next.url);
//                        z = build.start();
//                    } else {
//                        z = start;
//                    }
//                    if (!z) {
//                        result.success = false;
//                        result.code = -2;
//                        return result;
//                    }
//                    result.progress = ((i3 + 1) * 100) / size2;
//                    result.completed = ((float) (i3 + 1)) * f2;
//                    result.total = f;
//                    PhraseDownloader.this.sendProgress(result);
//                    i3++;
//                }
//            }
//            result.progress = (i3 * 100) / size2;
//            result.completed = ((float) i3) * f2;
//            result.total = f;
//            return result;
//        }
//
//        public void onPostExecute(Result result) {
//            if (result.callback) {
//                if (PhraseDownloader.TASK_TYPE_INIT == result.type) {
//                    PhraseDownloader.this.sendInited(result);
//                    cancel();
//                } else if (PhraseDownloader.TASK_TYPE_DOWNLOAD == result.type) {
//                    PhraseDownloader.this.sendLoaded(result);
//                }
//            }
//        }
//
//        public void onCancelled() {
//            super.onCancelled();
//            PhraseDownloader.this.sendCancelled();
//        }
//    }
//
//    class Result {
//        boolean callback;
//        int code;
//        float completed;
//        int progress;
//        boolean success;
//        boolean suspend;
//        float total;
//        int type;
//
//        private Result() {
//        }
//    }
//
//    class UIHandler extends Handler {
//        final WeakReference<PhraseDownloader> mLoader;
//
//        UIHandler(PhraseDownloader phraseDownloader) {
//            super(Looper.getMainLooper());
//            this.mLoader = new WeakReference<>(phraseDownloader);
//        }
//
//        public void handleMessage(Message message) {
//            final PhraseDownloader phraseDownloader = (PhraseDownloader) this.mLoader.get();
//            if (phraseDownloader != null) {
//                switch (message.what) {
//                    case 0:
//                        BczDialog.Builder builder = new BczDialog.Builder(DemoHandler.getApp());
//                        builder.setTitle((int) R.string.phrase_download_warn_title).setMessage((int) R.string.phrase_download_warn_msg).setNegativeButton(17039360, (OnClickListener) new OnClickListener() {
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                phraseDownloader.mMobileCapable = false;
//                                phraseDownloader.download();
//                            }
//                        }).setPositiveButton(17039370, (OnClickListener) new OnClickListener() {
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                phraseDownloader.mMobileCapable = true;
//                                phraseDownloader.download();
//                            }
//                        });
//                        BczDialog create = builder.create();
//                        create.setCanceledOnTouchOutside(false);
//                        create.setCancelable(false);
//                        create.getWindow().setType(2003);
//                        create.show();
//                        return;
//                    case 1:
//                        if (phraseDownloader.mContext.mCallback != null) {
//                            Result result = (Result) message.obj;
//                            phraseDownloader.mContext.mCallback.onLoadInited(result.progress, result.completed, result.total);
//                            return;
//                        }
//                        return;
//                    case 2:
//                        if (phraseDownloader.mContext.mCallback != null) {
//                            Result result2 = (Result) message.obj;
//                            phraseDownloader.mContext.mCallback.onLoadProgress(result2.progress, result2.completed, result2.total);
//                            return;
//                        }
//                        return;
//                    case 3:
//                        if (phraseDownloader.mContext.mCallback != null) {
//                            Result result3 = (Result) message.obj;
//                            phraseDownloader.mContext.mCallback.onLoaded(result3.success, result3.code);
//                            return;
//                        }
//                        return;
//                    case 4:
//                        if (phraseDownloader.mContext.mCallback != null) {
//                            phraseDownloader.mContext.mCallback.onCancelled();
//                            return;
//                        }
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    class URL {
//        URL next;
//        String saved;
//        String url;
//
//        private URL() {
//        }
//    }
//
//    PhraseDownloader(PLContext pLContext) {
//        this.mContext = pLContext;
//        this.mHandler = new UIHandler(this);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void init() {
//        this.mTask = getTask();
//        this.mTask.execute(Integer.valueOf(TASK_TYPE_INIT));
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void download() {
//        this.mTask = getTask();
//        this.mTask.execute(Integer.valueOf(TASK_TYPE_DOWNLOAD));
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void cancel() {
//        if (this.mTask != null) {
//            this.mTask.cancel();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public boolean isCancelled() {
//        if (this.mTask == null || this.mTask.isCancelled() || LAsyncTaskStatus.FINISHED == this.mTask.getStatus()) {
//            return true;
//        }
//        return false;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void reset() {
//        this.mMobileCapable = false;
//        this.mAsked = false;
//        this.mNewDownload = true;
//    }
//
//    /* access modifiers changed from: private */
//    public List<URL> getUrls(Result result, TopicPatterns topicPatterns, Map<Integer, Phrase> map) {
//        boolean isNetworkAvailable = NetworkUtils.isNetworkAvailable(DemoHandler.getApp());
//        boolean isMobileNet = isMobileNet();
//        if (!isMobileNet || !this.mAsked || this.mMobileCapable) {
//            ArrayList arrayList = new ArrayList();
//            List<Topic> arrTopics = topicPatterns.getArrTopics();
//            HashSet hashSet = new HashSet();
//            for (Topic topic : arrTopics) {
//                if (59 == topic.getTypeHint() && !TextUtils.isEmpty(topic.getGroupedOptions())) {
//                    String groupedOptions = topic.getGroupedOptions();
//                    if (!hashSet.contains(groupedOptions)) {
//                        if (!fillURL(arrayList, groupedOptions, PathUtil.reformSuffix(PathUtil.BCZ_HOME + topic.getGroupedOptions(), ".jpg"), result, isMobileNet, isNetworkAvailable)) {
//                            return null;
//                        }
//                        hashSet.add(groupedOptions);
//                    } else {
//                        continue;
//                    }
//                }
//            }
//            for (Entry value : map.entrySet()) {
//                Phrase phrase = (Phrase) value.getValue();
//                if (!TextUtils.isEmpty(phrase.getWordImage())) {
//                    String wordImage = phrase.getWordImage();
//                    if (!hashSet.contains(wordImage)) {
//                        if (!fillURL(arrayList, wordImage, PathUtil.reformSuffix(PathUtil.BCZ_HOME + wordImage, ".jpg"), result, isMobileNet, isNetworkAvailable)) {
//                            return null;
//                        }
//                        hashSet.add(wordImage);
//                    }
//                }
//                if (!TextUtils.isEmpty(phrase.getWordAudio())) {
//                    String wordAudio = phrase.getWordAudio();
//                    if (!hashSet.contains(wordAudio)) {
//                        if (!fillURL(arrayList, wordAudio, PathUtil.reformSuffix(PathUtil.BCZ_HOME + wordAudio, ".dat"), result, isMobileNet, isNetworkAvailable)) {
//                            return null;
//                        }
//                        hashSet.add(wordAudio);
//                    }
//                }
//                if (!TextUtils.isEmpty(phrase.getExplainAudio())) {
//                    String explainAudio = phrase.getExplainAudio();
//                    if (!hashSet.contains(explainAudio)) {
//                        if (!fillURL(arrayList, explainAudio, PathUtil.reformSuffix(PathUtil.BCZ_HOME + explainAudio, ".dat"), result, isMobileNet, isNetworkAvailable)) {
//                            return null;
//                        }
//                        hashSet.add(explainAudio);
//                    }
//                }
//                if (!TextUtils.isEmpty(phrase.getSentenceAudio())) {
//                    String sentenceAudio = phrase.getSentenceAudio();
//                    if (!hashSet.contains(sentenceAudio)) {
//                        if (!fillURL(arrayList, sentenceAudio, PathUtil.reformSuffix(PathUtil.BCZ_HOME + sentenceAudio, ".mp3"), result, isMobileNet, isNetworkAvailable)) {
//                            return null;
//                        }
//                        hashSet.add(sentenceAudio);
//                    }
//                }
//                if (!TextUtils.isEmpty(phrase.getSentence2Audio())) {
//                    String sentence2Audio = phrase.getSentence2Audio();
//                    if (!hashSet.contains(sentence2Audio)) {
//                        if (!fillURL(arrayList, sentence2Audio, PathUtil.reformSuffix(PathUtil.BCZ_HOME + sentence2Audio, ".mp3"), result, isMobileNet, isNetworkAvailable)) {
//                            return null;
//                        }
//                        hashSet.add(sentence2Audio);
//                    } else {
//                        continue;
//                    }
//                }
//            }
//            return arrayList;
//        }
//        result.suspend = true;
//        result.code = -4;
//        result.success = false;
//        return null;
//    }
//
//    private boolean fillURL(List<URL> list, String str, String str2, Result result, boolean z, boolean z2) {
//        if (!new File(str2).exists() && TASK_TYPE_DOWNLOAD == result.type) {
//            if (z && !this.mAsked) {
//                askMobileCapable();
//                this.mAsked = true;
//                result.success = false;
//                result.callback = false;
//                result.suspend = true;
//                return false;
//            } else if (!z2) {
//                result.success = false;
//                result.suspend = true;
//                result.code = -3;
//                return false;
//            }
//        }
//        try {
//            URL url = new URL();
//            url.next = new URL();
//            url.url = new URI("http", PathUtil.getResDns().replace("http://", ""), str, null).toASCIIString();
//            url.next.url = new URI("http", PathUtil.getCandResDns().replace("http://", ""), str, null).toASCIIString();
//            url.saved = str2;
//            list.add(url);
//            return true;
//        } catch (URISyntaxException e) {
//            C0789L.log.error("phrase url sync error.", (Throwable) e);
//            return false;
//        }
//    }
//
//    private static boolean isMobileNet() {
//        int activeNetworkType = NetworkUtils.getActiveNetworkType(DemoHandler.getApp());
//        if (3 == activeNetworkType || 2 == activeNetworkType || 1 == activeNetworkType) {
//            return true;
//        }
//        return false;
//    }
//
//    private DownLoaderTask getTask() {
//        String md5 = Common.md5(this.mContext.mCallback != null ? this.mContext.mCallback.getClass().getName() : PhraseDownloader.class.getName());
//        LAsyncTask searchTask = DownLoaderTask.searchTask(md5);
//        if (searchTask != null) {
//            searchTask.cancel();
//            DownLoaderTask.removeAllTask(0, md5);
//        }
//        return new DownLoaderTask();
//    }
//
//    private void askMobileCapable() {
//        this.mHandler.sendEmptyMessage(0);
//    }
//
//    /* access modifiers changed from: private */
//    public void sendInited(Result result) {
//        Message obtainMessage = this.mHandler.obtainMessage(1);
//        obtainMessage.obj = result;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void sendProgress(Result result) {
//        Message obtainMessage = this.mHandler.obtainMessage(2);
//        obtainMessage.obj = result;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void sendLoaded(Result result) {
//        Message obtainMessage = this.mHandler.obtainMessage(3);
//        obtainMessage.obj = result;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: private */
//    public void sendCancelled() {
//        this.mHandler.sendEmptyMessage(4);
//    }
//}
