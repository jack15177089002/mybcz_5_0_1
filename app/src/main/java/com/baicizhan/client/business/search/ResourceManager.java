//package com.baicizhan.client.business.search;
//
//import android.content.Context;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.ImageView;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.helpers.TopicRecordHelper;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.ErrCodes;
//import com.baicizhan.client.business.util.FileUtils;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.business.util.ZpkPicassoRequestHandler;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager;
//import com.baicizhan.client.framework.network.http.download.SyncDownloadManager.Builder;
//import com.baicizhan.client.framework.resource.ResourceLibrary;
////import com.baicizhan.online.bs_words.BBWordPackage;
////import com.baicizhan.online.bs_words.BSWords.Client;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
//import java.io.File;
//import org.p100a.p101a.C2123l;
//
//public class ResourceManager {
//    private static final String[] DEFAULT_DNS = {ConstantsUtil.DEFAULT_DNS, ConstantsUtil.DEFAULT_DNS_CAND};
//    public static final int ERR_FILE_SAVE = -1001;
//    /* access modifiers changed from: private */
//    public static final String HOME = PathUtil.getBaicizhanFile("res/wordlock").getAbsolutePath();
//    public static final int MODE_LIMIT = 0;
//    public static final int MODE_LOOSE_2G = 8;
//    public static final int MODE_LOOSE_3G = 4;
//    public static final int MODE_LOOSE_4G = 2;
//    public static final int MODE_LOOSE_ALL = 15;
//    public static final int MODE_LOOSE_WIFI = 1;
//    /* access modifiers changed from: private */
//    public OnResourceGetListener mListener;
//    /* access modifiers changed from: private */
//    public volatile int mMode = 0;
//
//    public interface OnResourceGetListener {
//        void onResourceGet(Word word, int i, String str);
//    }
//
//    class Params {
//        int errcode;
//        String errmsg;
//        Word word;
//
//        private Params() {
//            this.errcode = 0;
//        }
//    }
//
//    private ResourceManager() {
//    }
//
//    public static ResourceManager born() {
//        return new ResourceManager();
//    }
//
//    public ResourceManager setListener(OnResourceGetListener onResourceGetListener) {
//        this.mListener = onResourceGetListener;
//        return this;
//    }
//
//    public ResourceManager setMode(int i) {
//        this.mMode = i;
//        return this;
//    }
//
//    public ResourceManager addMode(int i) {
//        this.mMode |= i;
//        return this;
//    }
//
//    public ResourceManager get(Context context, Word word) {
//        if (word != null && (!isExistsLocal(word) || word.isBase())) {
//            doget(context, word, true);
//        }
//        return this;
//    }
//
//    /* access modifiers changed from: private */
//    public static boolean isExistsLocal(Word word) {
//        if (word == null || TextUtils.isEmpty(word.getAudio()) || TextUtils.isEmpty(word.getImage()) || TextUtils.isEmpty(word.getVivid())) {
//            return false;
//        }
//        if (!TextUtils.isEmpty(word.getZpkPath()) && isWrappedLocalZPK(word.getBookId(), word.getZpkPath())) {
//            return true;
//        }
//        if (word.isFromCache() && isWrappedCacheZPK(word.getId())) {
//            return true;
//        }
//        if (!TextUtils.isEmpty(word.getAudio()) && !PathUtil.isBaicizhanResourceFileExist(word.getAudio())) {
//            return false;
//        }
//        if (!TextUtils.isEmpty(word.getImage()) && !PathUtil.isBaicizhanResourceFileExist(word.getImage())) {
//            return false;
//        }
//        if (TextUtils.isEmpty(word.getVivid()) || PathUtil.isBaicizhanResourceFileExist(word.getVivid())) {
//            return true;
//        }
//        return false;
//    }
//
//    private static boolean isResuorceExists(Word word, String str) {
//        if (TextUtils.isEmpty(str)) {
//            return false;
//        }
//        if (!TextUtils.isEmpty(word.getZpkPath()) && isWrappedLocalZPK(word.getBookId(), word.getZpkPath())) {
//            return true;
//        }
//        if (word.isFromCache() && isWrappedCacheZPK(word.getId())) {
//            return true;
//        }
//        if (PathUtil.isBaicizhanResourceFileExist(str)) {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean isAudioExists(Word word) {
//        if (word == null) {
//            return false;
//        }
//        return isResuorceExists(word, word.getAudio());
//    }
//
//    public static void playAudio(AudioPlayer audioPlayer, Word word) {
//        if (audioPlayer != null && word != null && !playFromLocal(audioPlayer, word) && isWrappedCacheZPK(word.getId())) {
//            ResourceLibrary resourceLibrary = new ResourceLibrary(HOME);
//            try {
//                resourceLibrary.open(true);
//                ZPackUtils.playZpkAudio(audioPlayer, resourceLibrary.getFile(word.getId()).getAbsolutePath(), getAudioName(word));
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                resourceLibrary.close();
//            }
//        }
//    }
//
//    private static String getAudioName(Word word) {
//        if (word == null || TextUtils.isEmpty(word.getAudio())) {
//            return null;
//        }
//        int lastIndexOf = word.getAudio().lastIndexOf("/") + 1;
//        if (lastIndexOf < 0 || lastIndexOf >= word.getAudio().length()) {
//            return word.getAudio();
//        }
//        return word.getAudio().substring(lastIndexOf);
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
//    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    private static boolean playFromLocal(com.baicizhan.client.framework.audio.AudioPlayer r7, Word r8) {
//        /*
//            r0 = 0
//            java.lang.String r2 = getAudioName(r8)
//            int r1 = r8.getBookId()
//            java.lang.String r3 = r8.getZpkPath()
//            boolean r3 = android.text.TextUtils.isEmpty(r3)
//            if (r3 != 0) goto L_0x0047
//            java.lang.String r3 = r8.getZpkPath()
//            java.io.File r1 = com.baicizhan.client.business.util.ZPackUtils.getZpkFileByName(r1, r3)
//        L_0x001b:
//            if (r1 == 0) goto L_0x005a
//            boolean r3 = r1.exists()
//            if (r3 == 0) goto L_0x005a
//            com.baicizhan.client.business.zpack.ZPackage r6 = new com.baicizhan.client.business.zpack.ZPackage     // Catch:{ IOException -> 0x0049, all -> 0x0051 }
//            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x0049, all -> 0x0051 }
//            r3 = 1
//            r6.<init>(r1, r3)     // Catch:{ IOException -> 0x0049, all -> 0x0051 }
//            com.baicizhan.client.business.zpack.ZPackage$FileEntry r0 = r6.getFileEntry(r2)     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
//            java.io.FileDescriptor r1 = r6.getFD()     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
//            long r2 = r0.getByteOffset()     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
//            int r0 = r0.getAvailableSize()     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
//            long r4 = (long) r0     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
//            r0 = r7
//            boolean r0 = r0.newPlay(r1, r2, r4)     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
//            r6.close()
//        L_0x0046:
//            return r0
//        L_0x0047:
//            r1 = r0
//            goto L_0x001b
//        L_0x0049:
//            r1 = move-exception
//        L_0x004a:
//            if (r0 == 0) goto L_0x004f
//            r0.close()
//        L_0x004f:
//            r0 = 0
//            goto L_0x0046
//        L_0x0051:
//            r1 = move-exception
//            r6 = r0
//            r0 = r1
//        L_0x0054:
//            if (r6 == 0) goto L_0x0059
//            r6.close()
//        L_0x0059:
//            throw r0
//        L_0x005a:
//            java.lang.String r0 = r8.getAudio()
//            java.io.File r0 = com.baicizhan.client.business.util.PathUtil.getBaicizhanResourceFile(r0)
//            boolean r0 = r7.newPlay(r0)
//            goto L_0x0046
//        L_0x0067:
//            r0 = move-exception
//            goto L_0x0054
//        L_0x0069:
//            r0 = move-exception
//            r0 = r6
//            goto L_0x004a
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.search.ResourceManager.playFromLocal(com.baicizhan.client.framework.audio.AudioPlayer, com.baicizhan.client.business.search.Word):boolean");
//    }
//
//    public static boolean isImageExists(Word word) {
//        if (word == null) {
//            return false;
//        }
//        return isResuorceExists(word, word.getImage());
//    }
//
//    public static void displayImage(Context context, ImageView imageView, Word word) {
//        if (context != null && imageView != null && word != null) {
//            display(context, imageView, word.getBookId(), word.getId(), word.getZpkPath(), word.getImage());
//        }
//    }
//
//    public static boolean isVividExists(Word word) {
//        if (word == null) {
//            return false;
//        }
//        return isResuorceExists(word, word.getVivid());
//    }
//
//    public static void displayVivid(Context context, ImageView imageView, Word word) {
//        if (context != null && imageView != null && word != null) {
//            display(context, imageView, word.getBookId(), word.getId(), word.getZpkPath(), word.getVivid());
//        }
//    }
//
//    private static void display(Context context, final ImageView imageView, int i, String str, String str2, String str3) {
//        File file = !TextUtils.isEmpty(str2) ? ZPackUtils.getZpkFileByName(i, str2) : null;
//        if (file != null && file.exists()) {
//            RequestCreator a = Picasso.with(context).load(ZpkPicassoRequestHandler.getImageUri(file.getAbsolutePath(), FileUtils.getFileName(str3)));
//            a.f3707c = true;
//            a.into(imageView, (Callback) new Callback() {
//                public final void onError() {
//                    imageView.setVisibility(8);
//                }
//
//                public final void onSuccess() {
//                }
//            });
//        } else if (PathUtil.isBaicizhanResourceFileExist(str3)) {
//            RequestCreator a2 = Picasso.with(context).load(PathUtil.getBaicizhanResourceFile(str3));
//            a2.f3707c = true;
//            a2.into(imageView, (Callback) new Callback() {
//                public final void onError() {
//                    imageView.setVisibility(8);
//                }
//
//                public final void onSuccess() {
//                }
//            });
//        } else if (isWrappedCacheZPK(str)) {
//            ResourceLibrary resourceLibrary = new ResourceLibrary(HOME);
//            try {
//                resourceLibrary.open(true);
//                PicassoUtil.loadFromZpk(resourceLibrary.getFile(str).getAbsolutePath(), str3).into(imageView, (Callback) new Callback() {
//                    public final void onError() {
//                        imageView.setVisibility(8);
//                    }
//
//                    public final void onSuccess() {
//                    }
//                });
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                resourceLibrary.close();
//            }
//        } else {
//            imageView.setVisibility(8);
//        }
//    }
//
//    /* JADX INFO: finally extract failed */
//    private static boolean isWrappedCacheZPK(String str) {
//        ResourceLibrary resourceLibrary = new ResourceLibrary(HOME);
//        try {
//            resourceLibrary.open(true);
//            boolean exists = resourceLibrary.exists(str);
//            resourceLibrary.close();
//            return exists;
//        } catch (Exception e) {
//            e.printStackTrace();
//            resourceLibrary.close();
//            return false;
//        } catch (Throwable th) {
//            resourceLibrary.close();
//            throw th;
//        }
//    }
//
//    private static boolean isWrappedLocalZPK(int i, String str) {
//        File file = !TextUtils.isEmpty(str) ? ZPackUtils.getZpkFileByName(i, str) : null;
//        return file != null && file.exists();
//    }
//
//    /* access modifiers changed from: private */
//    public void doget(Context context, Word word, boolean z) {
//        final Word word2 = word;
//        final Context context2 = context;
//        final boolean z2 = z;
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Params>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            public Params doInBackground(Client client) {
////                Params resource;
////                synchronized (ResourceManager.class) {
////                    resource = getResource(client);
////                }
////                return resource;
////            }
////
////            private Params getResource(Client client) {
////                int i;
////                Params params = new Params();
////                params.word = word2;
////                if (!ThriftManager.setToken(context2)) {
////                    Log.d("whiz", "adapt word data, set token failed, audio: " + params.word.getAudio());
////                    C0789L.log.error("word lock get resource, set token failed, word [{}]", (Object) word2);
////                    params.errcode = ErrCodes.ERR_TOKEN_LOST;
////                    return params;
////                }
////                if (params.word.getBookId() > 0) {
////                    i = params.word.getBookId();
////                } else {
////                    i = PropertyHelper.getInt(PropertyHelper.CURRENT_BOOK_ID);
////                }
////                if (params.word.isBase()) {
////                    TopicRecord bookTopicRecord = TopicRecordHelper.getBookTopicRecord(context2, i, Integer.valueOf(word2.getId()).intValue());
////                    if (bookTopicRecord != null) {
////                        params.word = ResourceManager.adapt(i, bookTopicRecord);
////                        if (ResourceManager.isExistsLocal(params.word)) {
////                            Log.d("whiz", "adapt word data, from local, audio: " + params.word.getAudio());
////                            return params;
////                        }
////                    }
////                }
////                ResourceLibrary resourceLibrary = new ResourceLibrary(ResourceManager.HOME);
////                try {
////                    if (!resourceLibrary.open(true)) {
////                        Log.d("whiz", "adapt word data, open rl failed, audio: " + params.word.getAudio());
////                        C0789L.log.error("word lock get resource, open resource library failed, word [{}]", (Object) word2);
////                        params.errcode = ErrCodes.ERR_FILE;
////                        resourceLibrary.close();
////                        return params;
////                    }
////                    if (!resourceLibrary.exists(word2.getId())) {
////                        if (!ResourceManager.canDownload(context2, ResourceManager.this.mMode)) {
////                            resourceLibrary.close();
////                            return params;
////                        } else if (!download(resourceLibrary, params, i, client)) {
////                            resourceLibrary.close();
////                            return params;
////                        }
////                    }
////                    TopicRecord readMetaTopicRecord = ZPackUtils.readMetaTopicRecord(resourceLibrary.getFile(word2.getId()).getAbsolutePath());
////                    if (readMetaTopicRecord == null) {
////                        throw new RuntimeException("word zpk file in " + resourceLibrary.getFile(word2.getId()).getAbsolutePath() + " is damaged.");
////                    } else if (readMetaTopicRecord != null) {
////                        params.word = ResourceManager.adapt(word2.getBookId(), readMetaTopicRecord);
////                        params.word.setFromCache(true);
////                        Log.d("whiz", "adapt word data, from zpk cache, audio: " + params.word.getAudio());
////                        resourceLibrary.close();
////                        return params;
////                    } else {
////                        resourceLibrary.close();
////                        Log.d("whiz", "adapt word data, final, audio: " + params.word.getAudio());
////                        return params;
////                    }
////                } catch (Exception e) {
////                    Log.d("whiz", "adapt word data, exception occured when read zpk, zpk path: " + resourceLibrary.getFile(word2.getId()) + "; ex: " + e);
////                    C0789L.log.error("word lock get resource, exception occured when read zpk", (Throwable) e);
////                    C0789L.log.error("word lock get resource, exception occured when read zpk, zpk path [{}], word [{}]", (Object) resourceLibrary.getFile(word2.getId()), (Object) word2);
////                    resourceLibrary.delete(word2.getId());
////                    throw e;
////                } catch (Exception e2) {
////                    try {
////                        e2.printStackTrace();
////                        Log.d("whiz", "adapt word data, exception occured, audio: " + params.word.getAudio() + "; ex: " + e2);
////                        throw e2;
////                    } catch (Throwable th) {
////                        resourceLibrary.close();
////                        throw th;
////                    }
////                }
////            }
////
////            private boolean download(ResourceLibrary resourceLibrary, Params params, int i, Client client) {
////                BBWordPackage bBWordPackage = client.get_search_word_package(i, Integer.valueOf(params.word.getId()).intValue());
////                if (bBWordPackage == null) {
////                    Log.d("whiz", "adapt word data, zpk packages empty, audio: " + params.word.getAudio());
////                    C0789L.log.error("word lock get resource, zpk packages empty, word [{}]", (Object) word2);
////                    return false;
////                }
////                SyncDownloadManager build = new Builder().setUrl(ResourceManager.getResourceUrl(bBWordPackage.getZpk_path())).setConnTimeout(3000).setReadTimeout(5000).setMaxRetry(2).build();
////                if (!build.start()) {
////                    Log.d("whiz", "adapt word data, download failed, audio: " + params.word.getAudio());
////                    C0789L.log.error("word lock get resource, download failed, err code [{}], word [{}]", (Object) Integer.valueOf(build.getResCode()), (Object) word2);
////                    params.errcode = ErrCodes.parseNetRelatedErrCode(build.getResCode());
////                    params.errmsg = ErrCodes.buildErrMessage(params.errcode, String.valueOf(build.getResCode()));
////                    return false;
////                } else if (resourceLibrary.save(word2.getId(), new File(build.getResTargetPath()), true)) {
////                    return true;
////                } else {
////                    Log.d("whiz", "adapt word data, saved failed, audio: " + params.word.getAudio());
////                    C0789L.log.error("word lock get resource, save zpk failed, word [{}]", (Object) word2);
////                    params.errcode = -1001;
////                    params.errmsg = ErrCodes.buildErrMessage(params.errcode, "zpk saved failed.");
////                    return false;
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                if (z2) {
////                    ResourceManager.this.doget(context2, word2, false);
////                } else if (ResourceManager.this.mListener == null) {
////                } else {
////                    if (exc instanceof C2123l) {
////                        int parseNetRelatedErrCode = ErrCodes.parseNetRelatedErrCode((C2123l) exc);
////                        ResourceManager.this.mListener.onResourceGet(word2, parseNetRelatedErrCode, ErrCodes.buildErrMessage(parseNetRelatedErrCode, exc.getMessage()));
////                        return;
////                    }
////                    ResourceManager.this.mListener.onResourceGet(word2, -1000, null);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(Params params) {
////                if (ResourceManager.this.mListener != null) {
////                    ResourceManager.this.mListener.onResourceGet(params.word, params.errcode, params.errmsg);
////                }
////            }
////        });
//    }
//
//    /* access modifiers changed from: private */
//    public static String getResourceUrl(String str) {
//        String str2 = DEFAULT_DNS[(int) (Math.random() + 0.5d)];
//        if (TextUtils.isEmpty(str)) {
//            return null;
//        }
//        if (str.startsWith("http")) {
//            return str;
//        }
//        String replace = str.replace(" ", "%20");
//        if (replace.charAt(0) == '/') {
//            return str2 + replace;
//        }
//        return String.format("%s/%s", new Object[]{str2, replace});
//    }
//
//    /* access modifiers changed from: private */
//    public static Word adapt(int i, TopicRecord topicRecord) {
//        Word word = new Word();
//        word.setBookId(i);
//        word.setId(String.valueOf(topicRecord.topicId));
//        word.setWord(topicRecord.word);
//        word.setAccent(topicRecord.phonetic);
//        word.setCnmean(topicRecord.wordMean);
//        word.setAudio(topicRecord.wordAudio);
//        word.setExample(topicRecord.sentence);
//        word.setCnexample(topicRecord.sentenceTrans);
//        word.setImage(topicRecord.imagePath);
//        word.setVivid(topicRecord.deformationImagePath);
//        word.setEnmean(topicRecord.wordMeanEn);
//        word.setRoot(topicRecord.wordEtyma);
//        word.setZpkPath(topicRecord.zpkPath);
//        word.setVariants(topicRecord.wordVariants);
//        return word;
//    }
//
//    /* access modifiers changed from: private */
//    public static boolean canDownload(Context context, int i) {
//        if (!NetworkUtils.isNetworkAvailable(context) || i == 0) {
//            return false;
//        }
//        switch (NetworkUtils.getActiveNetworkType(context)) {
//            case 0:
//                return true;
//            case 1:
//                if (i < 2) {
//                    return false;
//                }
//                return true;
//            case 2:
//                if (i < 4) {
//                    return false;
//                }
//                return true;
//            case 3:
//                if (i < 8) {
//                    return false;
//                }
//                return true;
//            default:
//                return false;
//        }
//    }
//}
