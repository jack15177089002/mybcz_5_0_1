package com.baicizhan.client.business.logoload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import com.baicizhan.client.business.BusinessAppHandler;
import com.baicizhan.client.business.logoload.LPDaos.Loading;
import com.baicizhan.client.business.util.PathUtil;
import com.baicizhan.client.framework.asynctask.LAsyncTask;
import com.baicizhan.client.framework.network.http.download.DownloadManager;
import com.baicizhan.client.framework.network.http.download.IDownloadManager.DownloadCallback;
import com.baicizhan.client.framework.resource.ResourceLibrary;
import com.baicizhan.client.framework.util.BitmapUtil;
import com.baicizhan.client.framework.util.Common;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

public class LogoLoader {
    /* access modifiers changed from: private */
//    public static final int LOGO_HEIGHT = Math.min(SCREEN_WIDTH, SCREEN_HEIGHT);
    /* access modifiers changed from: private */
//    public static final int LOGO_WIDTH = Math.max(SCREEN_WIDTH, SCREEN_HEIGHT);
    private static final int SCREEN_HEIGHT = Common.getScreenHeight(BusinessAppHandler.getApp());
    private static final int SCREEN_WIDTH = Common.getScreenWidth(BusinessAppHandler.getApp());
    private static final String TAG = "LogoLoader";
    /* access modifiers changed from: private */
    public Callback mCallback;
    private DownloadManager mDM;
    /* access modifiers changed from: private */
    public String mHome = PathUtil.getBaicizhanAppRoot();
    /* access modifiers changed from: private */
    public Loading mLding;

    public interface Callback {
        void onDownloaded(Loading loading, boolean z);
    }

    class SaveTask extends LAsyncTask<String, Void, Boolean> {
        final WeakReference<LogoLoader> mDownloader;

        SaveTask(LogoLoader logoLoader) {
            this.mDownloader = new WeakReference<>(logoLoader);
            setKey(LogoLoader.genKey(logoLoader));
            parallelTask(1);
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strArr) {
            LogoLoader logoLoader = (LogoLoader) this.mDownloader.get();
            if (logoLoader == null) {
                return Boolean.valueOf(false);
            }
            String str = strArr[0];
            ResourceLibrary resourceLibrary = new ResourceLibrary(logoLoader.mHome);
            try {
//                if (resourceLibrary.open(true)) {
//                    BitmapUtil.saveBitmapToFile(BitmapUtil.rotate(BitmapUtil.cropSameScale(BitmapFactory.decodeFile(str), LogoLoader.LOGO_WIDTH, LogoLoader.LOGO_HEIGHT), 90), str, true);
//                    return Boolean.valueOf(resourceLibrary.save(logoLoader.mLding.getUrl(), new File(str), true));
//                }
                resourceLibrary.close();
                return Boolean.valueOf(false);
            } catch (Exception e) {
                Log.e(LogoLoader.TAG, "error occured when save logo bitmap into disk.", e);
                e.printStackTrace();
            } finally {
                resourceLibrary.close();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            LogoLoader logoLoader = (LogoLoader) this.mDownloader.get();
            if (logoLoader != null) {
                if (bool == null || !bool.booleanValue()) {
                    if (logoLoader.mCallback != null) {
                        logoLoader.mCallback.onDownloaded(logoLoader.mLding, false);
                    }
                } else if (logoLoader.mCallback != null) {
                    logoLoader.mCallback.onDownloaded(logoLoader.mLding, true);
                }
            }
        }
    }

    public void download(final Loading loading, Callback callback) {
        this.mLding = loading;
        if (loading != null) {
            this.mCallback = callback;
            this.mDM = new DownloadManager();
            this.mDM.setUrl(loading.getUrl()).setCallback(new DownloadCallback() {
                public void onComplete(boolean z, String str, int i) {
                    if (z) {
                        LogoLoader.this.getTask(LogoLoader.this).execute(str);
                    } else if (LogoLoader.this.mCallback != null) {
                        LogoLoader.this.mCallback.onDownloaded(loading, false);
                    }
                }

                public void onGroupComplete(boolean z, List<String> list, int i) {
                }

                public void onPause() {
                }

                public void onProgress(int i) {
                }

                public void onResume() {
                }

                public void onStart() {
                }

                public void onStartDecompress() {
                }

                public void onStop() {
                }
            }).start();
        } else if (callback != null) {
            callback.onDownloaded(loading, false);
        }
    }

    /* access modifiers changed from: private */
    public static final String genKey(LogoLoader logoLoader) {
        return Common.md5(logoLoader.mLding.getUrl());
    }

    /* access modifiers changed from: private */
    public SaveTask getTask(LogoLoader logoLoader) {
        String genKey = genKey(logoLoader);
        LAsyncTask searchTask = SaveTask.searchTask(genKey);
        if (searchTask != null) {
            searchTask.cancel();
            SaveTask.removeAllTask(0, genKey);
        }
        return new SaveTask(this);
    }

    public void cancel() {
        if (this.mDM != null) {
            this.mDM.stop();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean localLoad(Context context, String str, ImageView imageView) {
        if (str == null || imageView == null) {
            return false;
        }
        ResourceLibrary resourceLibrary = new ResourceLibrary(this.mHome);
        try {
            if (resourceLibrary.open(true) && resourceLibrary.exists(str)) {
                Bitmap decodeFile = BitmapFactory.decodeFile(resourceLibrary.getFile(str).getAbsolutePath());
                if (decodeFile != null) {
                    imageView.setImageBitmap(decodeFile);
                    resourceLibrary.close();
                    return true;
                }
                Log.e(TAG, "the downloaded logo image is not valide, delete it and redownload.");
            }
            resourceLibrary.close();
            return false;
        } catch (Exception e) {
            Log.e(TAG, "error occured when local load logo.", e);
            resourceLibrary.close();
            return false;
        } catch (Throwable th) {
            resourceLibrary.close();
            throw th;
        }
    }
}
