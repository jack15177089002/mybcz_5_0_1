package com.baicizhan.main.resource;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.SparseArray;
//import com.baicizhan.client.business.dataset.helpers.TopicRecordHelper;
import com.baicizhan.client.business.dataset.models.TopicRecord;
import com.baicizhan.client.business.util.FileUtils;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.business.util.ZPackUtils;
import com.baicizhan.client.business.util.ZPackUtils.ZpkNameInfo;
import com.baicizhan.client.framework.BaseAppHandler;
import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Map;

public class AssetTopicRecordManager {
    private static final String TAG = AssetTopicRecordManager.class.getSimpleName();
    private static final String TOPIC_ASSET_ROOT = "topics";
    private static AssetTopicRecordManager sInstance = null;
    private SparseArray<SparseArray<String>> mAssetBooks = new SparseArray<>();
    private AssetManager mAssetManager;
    private Map<String, String> mAssetZpkMD5;

    public static AssetTopicRecordManager getInstance() {
        if (sInstance == null) {
            synchronized (AssetTopicRecordManager.class) {
                if (sInstance == null) {
                    sInstance = new AssetTopicRecordManager();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context) {
        String[] list;
        this.mAssetManager = context.getAssets();
        try {
            for (String str : this.mAssetManager.list(TOPIC_ASSET_ROOT)) {
                try {
                    ZpkNameInfo extractZpkNameInfo = ZPackUtils.extractZpkNameInfo(str);
                    if (extractZpkNameInfo != null) {
                        SparseArray sparseArray = (SparseArray) this.mAssetBooks.get(extractZpkNameInfo.bookId);
                        if (sparseArray == null) {
                            sparseArray = new SparseArray(32);
                            this.mAssetBooks.put(extractZpkNameInfo.bookId, sparseArray);
                        }
                        sparseArray.put(extractZpkNameInfo.topicId, str);
                    }
                } catch (Exception e) {
                    LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
                }
            }
//            this.mAssetZpkMD5 = (Map) new Gson().fromJson(FileUtils.readAll(this.mAssetManager.open("zpk_file_md5")), new TypeToken<Map<String, String>>() {
//            }.getType());
        } catch (Exception e2) {
            LogWrapper.m2794e(TAG, Log.getStackTraceString(e2));
        }
    }

    public boolean contains(int i, int i2) {
        SparseArray sparseArray = (SparseArray) this.mAssetBooks.get(i);
        return (sparseArray == null || sparseArray.get(i2) == null) ? false : true;
    }

    public TopicRecord unpackTopicRecord(int i, int i2) {
        LogWrapper.m2793d(TAG, "try unpackTopicRecord " + i2);
        SparseArray sparseArray = (SparseArray) this.mAssetBooks.get(i);
        if (sparseArray == null) {
            return null;
        }
        String str = (String) sparseArray.get(i2);
        if (str == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.mAssetManager.open(new File(TOPIC_ASSET_ROOT, str).getPath()));
            File zpkFileByName = ZPackUtils.getZpkFileByName(i, str);
            if (zpkFileByName == null) {
                throw new Exception("localFile invalid " + str);
            }
            boolean copyToFile = FileUtils.copyToFile(bufferedInputStream, zpkFileByName);
            bufferedInputStream.close();
            if (copyToFile) {
                TopicRecord readMetaTopicRecord = ZPackUtils.readMetaTopicRecord(zpkFileByName.getAbsolutePath());
                if (readMetaTopicRecord != null) {
                    readMetaTopicRecord.zpkPath = str;
                    readMetaTopicRecord.updateFlagMD5 = (String) this.mAssetZpkMD5.get(str);
//                    TopicRecordHelper.saveBookTopicRecord(BaseAppHandler.getApp(), i, readMetaTopicRecord);
                    return readMetaTopicRecord;
                }
            }
            return null;
        } catch (Exception e) {
            LogWrapper.m2793d(TAG, Log.getStackTraceString(e));
        }

        return null;
    }
}
