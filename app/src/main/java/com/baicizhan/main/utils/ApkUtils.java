//package com.baicizhan.main.utils;
//
//import android.content.res.Resources;
//import android.support.p004v4.p006b.SparseArrayCompat;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.FileUtils;
//import com.jiongji.andriod.card.R;
//
//public class ApkUtils {
//    public static final SparseArrayCompat<String> UNZIP_RAW_FILE_MAP;
//
//    private ApkUtils() {
//    }
//
//    static {
//        SparseArrayCompat<String> qVar = new SparseArrayCompat<>();
//        UNZIP_RAW_FILE_MAP = qVar;
//        qVar.mo470a(R.raw.dictionary, Databases.DICTIONARY);
//        UNZIP_RAW_FILE_MAP.mo470a(R.raw.baicizhantotal, Databases.TOTAL_RESOURCES);
//    }
//
//    public static void unzipDictionaryIfNeed(Resources resources) {
//        unzipRawFileIfNeed(resources, R.raw.dictionary);
//    }
//
//    public static void unzipBaicizhanTotalIfNeed(Resources resources) {
//        unzipRawFileIfNeed(resources, R.raw.baicizhantotal);
//    }
//
//    private static void unzipRawFileIfNeed(Resources resources, int i) {
//        FileUtils.unzipRawFileToSDCard(resources, i, Settings.getString(Settings.PREF_BAICIZHAN_PATH), (String) UNZIP_RAW_FILE_MAP.mo469a(i));
//    }
//}
