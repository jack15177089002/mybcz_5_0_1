package com.baicizhan.client.business.stats;

import android.util.Log;
import com.baicizhan.client.business.usr.User;
import com.baicizhan.client.business.usr.UserLoadHandler;
import com.baicizhan.client.framework.device.DeviceInfo;
import com.baicizhan.client.framework.network.http.upload.IUploadManager.UploadCallback;
import com.baicizhan.client.framework.network.http.upload.UploadManager;
import com.baicizhan.client.framework.stat.AbstractCrashManager;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CrashManager extends AbstractCrashManager implements UserLoadHandler {
    private static final CrashManager sInstance = new CrashManager();
    /* access modifiers changed from: private */
    public File mCrash;
    private UpCallback mUpCallback = new UpCallback();
    private UploadManager mUploader = new UploadManager();

    class UpCallback implements UploadCallback {
        private UpCallback() {
        }

        public void onProgress(int i) {
            Log.d("whiz", "crash upload onProgress: " + i);
        }

        public void onComplete(boolean z, int i) {
            Log.d("whiz", "crash upload onComplete: " + z + "; code: " + i);
            if (z && CrashManager.this.mCrash != null) {
                try {
                    PrintWriter printWriter = new PrintWriter(CrashManager.this.mCrash);
                    printWriter.print("");
                    printWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void onStart() {
            Log.d("whiz", "crash upload onStart");
        }

        public void onStop() {
            Log.d("whiz", "crash upload onStop");
        }
    }

    private CrashManager() {
        this.mUploader.setUrl("http://www.baicizhan.com/sentences/test/postfile").addPart("android_version", DeviceInfo.ANDROID_VERSION).addPart("phone_model", DeviceInfo.PHONE_MODEL).addPart("baicizhan_version", DeviceInfo.getBaicizhanVersion()).setCallback(this.mUpCallback);
    }

    public static CrashManager getInstance() {
        return sInstance;
    }

    /* access modifiers changed from: protected */
    public void upload(File file) {
        this.mCrash = file;
        if (file != null) {
            this.mUploader.setSrcPath(file.getAbsolutePath());
        }
        doUpload();
    }

    private void doUpload() {
    }

    public void onError(Void voidR) {
        Log.d("whiz", "crash user err");
    }

    public void onProgress(int i) {
    }

    public void onSuccess(User user) {
        if (user != null) {
            this.mUploader.addPart("usr_name", user.getName()).addPart("usr_token", user.getToken());
        }
        Log.d("whiz", "crash upload start..");
        this.mUploader.start();
    }
}
