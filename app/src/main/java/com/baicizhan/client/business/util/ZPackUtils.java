package com.baicizhan.client.business.util;

import android.content.Context;
import android.text.TextUtils;
import com.baicizhan.client.business.dataset.models.TopicRecord;
import com.baicizhan.client.business.managers.StudyManager;
import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import com.google.gson.GsonBuilder;//import com.p020b.p021a.GsonBuilder;
import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
import com.squareup.picasso.RequestCreator;

import java.io.File;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZPackUtils {
    public static final String LEGACY_DEFORMATION_IMAGE_DIR = "df_transparent/";
    public static final String LEGACY_IMAGE_DIR = "cropped_images/";
    public static final String LEGACY_SENTENCE_AUDIO_DIR = "sentence_audios_dat/";
    public static final String LEGACY_WORD_AUDIO_DIR = "word_audios_dat/";
//    public static Gson META_GSON = new GsonBuilder().mo3215a();
    public static final String META_JSON = "meta.json";
    private static String TAG = ZPackUtils.class.getSimpleName();
    public static final Type TOPIC_TYPE = new TypeToken<TopicRecord>() {
    }.getType();
    public static final String ZPACK_DOWNLOAD_DIR = "zpack/";
    public static final Pattern ZPK_NAME_PATTERN = Pattern.compile("zp_(\\d+)_(\\d+)_(\\d+)_(\\d+)_(\\d+)\\.zpk");
    private static final String ZPK_ROOT = "zpack";
    private static final int ZPK_SCATTER_FACTOR = 32;
    private static final int ZPK_SCATTER_MASK = 31;

    public class ZpkNameInfo {
        public int bookId;
        public int tagId;
        public String timestamp;
        public int topicId;
        public int version;
    }

    public static ZpkNameInfo extractZpkNameInfo(String str) {
        try {
            Matcher matcher = ZPK_NAME_PATTERN.matcher(FileUtils.getFileName(str));
//            if (matcher.matches()) {
//                ZpkNameInfo zpkNameInfo = new ZpkNameInfo();
//                zpkNameInfo.topicId = Integer.valueOf(matcher.group(1)).intValue();
//                zpkNameInfo.bookId = Integer.valueOf(matcher.group(2)).intValue();
//                zpkNameInfo.tagId = Integer.valueOf(matcher.group(3)).intValue();
//                zpkNameInfo.version = Integer.valueOf(matcher.group(4)).intValue();
//                zpkNameInfo.timestamp = matcher.group(5);
//                return zpkNameInfo;
//            }
        } catch (Exception e) {
            LogWrapper.m2794e(TAG, e.toString());
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baicizhan.client.business.dataset.models.TopicRecord readMetaTopicRecord(String r6) {
        /*
            r1 = 0
            com.baicizhan.client.business.zpack.ZPackage r2 = new com.baicizhan.client.business.zpack.ZPackage     // Catch:{ IOException -> 0x002b, all -> 0x0034 }
            r0 = 1
            r2.<init>(r6, r0)     // Catch:{ IOException -> 0x002b, all -> 0x0034 }
            java.lang.String r0 = "meta.json"
            java.io.InputStream r3 = r2.openFile(r0)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r0.<init>(r3)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.<init>(r0)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            com.b.a.k r0 = META_GSON     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.reflect.Type r5 = TOPIC_TYPE     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            java.lang.Object r0 = r0.mo3209a(r4, r5)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            com.baicizhan.client.business.dataset.models.TopicRecord r0 = (com.baicizhan.client.business.dataset.models.TopicRecord) r0     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r3.close()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.close()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r2.close()
        L_0x002a:
            return r0
        L_0x002b:
            r0 = move-exception
            r0 = r1
        L_0x002d:
            if (r0 == 0) goto L_0x0032
            r0.close()
        L_0x0032:
            r0 = r1
            goto L_0x002a
        L_0x0034:
            r0 = move-exception
            r2 = r1
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r2.close()
        L_0x003b:
            throw r0
        L_0x003c:
            r0 = move-exception
            goto L_0x0036
        L_0x003e:
            r0 = move-exception
            r0 = r2
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.ZPackUtils.readMetaTopicRecord(java.lang.String):com.baicizhan.client.business.dataset.models.TopicRecord");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static boolean playZpkAudio(com.baicizhan.client.framework.audio.AudioPlayer r7, String r8, String r9) {
//        /*
//            r0 = 0
//            com.baicizhan.client.business.zpack.ZPackage r6 = new com.baicizhan.client.business.zpack.ZPackage     // Catch:{ IOException -> 0x0021, all -> 0x0029 }
//            r1 = 1
//            r6.<init>(r8, r1)     // Catch:{ IOException -> 0x0021, all -> 0x0029 }
//            com.baicizhan.client.business.zpack.ZPackage$FileEntry r0 = r6.getFileEntry(r9)     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
//            java.io.FileDescriptor r1 = r6.getFD()     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
//            long r2 = r0.getByteOffset()     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
//            int r0 = r0.getAvailableSize()     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
//            long r4 = (long) r0     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
//            r0 = r7
//            boolean r0 = r0.newPlay(r1, r2, r4)     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
//            r6.close()
//        L_0x0020:
//            return r0
//        L_0x0021:
//            r1 = move-exception
//        L_0x0022:
//            if (r0 == 0) goto L_0x0027
//            r0.close()
//        L_0x0027:
//            r0 = 0
//            goto L_0x0020
//        L_0x0029:
//            r1 = move-exception
//            r6 = r0
//            r0 = r1
//        L_0x002c:
//            if (r6 == 0) goto L_0x0031
//            r6.close()
//        L_0x0031:
//            throw r0
//        L_0x0032:
//            r0 = move-exception
//            goto L_0x002c
//        L_0x0034:
//            r0 = move-exception
//            r0 = r6
//            goto L_0x0022
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.ZPackUtils.playZpkAudio(com.baicizhan.client.framework.audio.AudioPlayer, java.lang.String, java.lang.String):boolean");
//    }

    public static File getZpkFileByName(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String name = new File(str).getName();
        return PathUtil.getBaicizhanFile(String.format("%s/%d/%d/%s", new Object[]{ZPK_ROOT, Integer.valueOf(i), Integer.valueOf(name.hashCode() & 31), name}));
    }

    public static boolean isZpkExists(int i, String str) {
        if (i <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        File zpkFileByName = getZpkFileByName(i, str);
        if (zpkFileByName == null || !zpkFileByName.exists() || zpkFileByName.length() <= 0) {
            return false;
        }
        return true;
    }

    public static File getZpkFile(TopicRecord topicRecord) {
//        int currentBookId = topicRecord.bookId > 0 ? topicRecord.bookId : StudyManager.getInstance().getCurrentBookId();
//        if (currentBookId == 0 || TextUtils.isEmpty(topicRecord.zpkPath)) {
//            return null;
//        }
//        return getZpkFileByName(currentBookId, topicRecord.zpkPath);

        return null;
    }

    public static boolean isZpkExists(TopicRecord topicRecord) {
//        return isZpkExists(topicRecord.bookId > 0 ? topicRecord.bookId : StudyManager.getInstance().getCurrentBookId(), topicRecord.zpkPath);

        return false;
    }

    public static int getZpkTagIdCompat(TopicRecord topicRecord) {
        if (TextUtils.isEmpty(topicRecord.zpkPath)) {
            return 0;
        }
        ZpkNameInfo extractZpkNameInfo = extractZpkNameInfo(topicRecord.zpkPath);
        if (extractZpkNameInfo != null) {
            return extractZpkNameInfo.tagId;
        }
        return 0;
    }

    public static RequestCreator loadImageCompat(TopicRecord topicRecord, String str) {
//        File zpkFile = getZpkFile(topicRecord);
//        if (zpkFile == null || !zpkFile.exists()) {
//            return Picasso.with((Context) null).load(PathUtil.getBaicizhanResourceFile(str));
//        }
//        return Picasso.with((Context) null).load(ZpkPicassoRequestHandler.getImageUri(zpkFile.getAbsolutePath(), FileUtils.getFileName(str)));
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Point calcBitmapSizeCompat(com.baicizhan.client.business.dataset.models.TopicRecord r5, String r6) {
        /*
            r1 = 0
            java.io.File r0 = getZpkFile(r5)
            if (r0 == 0) goto L_0x004d
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x004d
            com.baicizhan.client.business.zpack.ZPackage r2 = new com.baicizhan.client.business.zpack.ZPackage     // Catch:{ IOException -> 0x003c, all -> 0x0045 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ IOException -> 0x003c, all -> 0x0045 }
            r3 = 1
            r2.<init>(r0, r3)     // Catch:{ IOException -> 0x003c, all -> 0x0045 }
            java.lang.String r0 = com.baicizhan.client.business.util.FileUtils.getFileName(r6)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.io.InputStream r0 = r2.openFile(r0)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r3.<init>()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r4 = 1
            r3.inJustDecodeBounds = r4     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r4 = 0
            android.graphics.BitmapFactory.decodeStream(r0, r4, r3)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            android.graphics.Point r0 = new android.graphics.Point     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r0.<init>()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            int r4 = r3.outWidth     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r0.x = r4     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            int r3 = r3.outHeight     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r0.y = r3     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r2.close()
        L_0x003b:
            return r0
        L_0x003c:
            r0 = move-exception
            r0 = r1
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.close()
        L_0x0043:
            r0 = r1
            goto L_0x003b
        L_0x0045:
            r0 = move-exception
            r2 = r1
        L_0x0047:
            if (r2 == 0) goto L_0x004c
            r2.close()
        L_0x004c:
            throw r0
        L_0x004d:
            java.lang.String r0 = r5.deformationImagePath
            java.io.File r0 = com.baicizhan.client.business.util.PathUtil.getBaicizhanResourceFile(r0)
            android.graphics.Point r0 = com.baicizhan.client.business.util.PicassoUtil.getBitmapSize(r0)
            goto L_0x003b
        L_0x0058:
            r0 = move-exception
            goto L_0x0047
        L_0x005a:
            r0 = move-exception
            r0 = r2
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.ZPackUtils.calcBitmapSizeCompat(com.baicizhan.client.business.dataset.models.TopicRecord, java.lang.String):android.graphics.Point");
    }

    public static boolean resourceFileExistsCompat(TopicRecord topicRecord, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File zpkFile = getZpkFile(topicRecord);
        if (zpkFile == null || !zpkFile.exists()) {
            return PathUtil.isBaicizhanResourceFileExist(str);
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static boolean loadAudioCompat(com.baicizhan.client.framework.audio.AudioPlayer r7, com.baicizhan.client.business.dataset.models.TopicRecord r8, String r9) {
//        /*
//            java.io.File r1 = getZpkFile(r8)
//            if (r1 == 0) goto L_0x0042
//            boolean r0 = r1.exists()
//            if (r0 == 0) goto L_0x0042
//            r0 = 0
//            com.baicizhan.client.business.zpack.ZPackage r6 = new com.baicizhan.client.business.zpack.ZPackage     // Catch:{ IOException -> 0x0031, all -> 0x0039 }
//            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x0031, all -> 0x0039 }
//            r2 = 1
//            r6.<init>(r1, r2)     // Catch:{ IOException -> 0x0031, all -> 0x0039 }
//            com.baicizhan.client.business.zpack.ZPackage$FileEntry r0 = r6.getFileEntry(r9)     // Catch:{ IOException -> 0x004d, all -> 0x004b }
//            java.io.FileDescriptor r1 = r6.getFD()     // Catch:{ IOException -> 0x004d, all -> 0x004b }
//            long r2 = r0.getByteOffset()     // Catch:{ IOException -> 0x004d, all -> 0x004b }
//            int r0 = r0.getAvailableSize()     // Catch:{ IOException -> 0x004d, all -> 0x004b }
//            long r4 = (long) r0     // Catch:{ IOException -> 0x004d, all -> 0x004b }
//            r0 = r7
//            boolean r0 = r0.newPlay(r1, r2, r4)     // Catch:{ IOException -> 0x004d, all -> 0x004b }
//            r6.close()
//        L_0x0030:
//            return r0
//        L_0x0031:
//            r1 = move-exception
//        L_0x0032:
//            if (r0 == 0) goto L_0x0037
//            r0.close()
//        L_0x0037:
//            r0 = 0
//            goto L_0x0030
//        L_0x0039:
//            r1 = move-exception
//            r6 = r0
//            r0 = r1
//        L_0x003c:
//            if (r6 == 0) goto L_0x0041
//            r6.close()
//        L_0x0041:
//            throw r0
//        L_0x0042:
//            java.io.File r0 = com.baicizhan.client.business.util.PathUtil.getBaicizhanResourceFile(r9)
//            boolean r0 = r7.newPlay(r0)
//            goto L_0x0030
//        L_0x004b:
//            r0 = move-exception
//            goto L_0x003c
//        L_0x004d:
//            r0 = move-exception
//            r0 = r6
//            goto L_0x0032
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.util.ZPackUtils.loadAudioCompat(com.baicizhan.client.framework.audio.AudioPlayer, com.baicizhan.client.business.dataset.models.TopicRecord, java.lang.String):boolean");
//    }
}
