package com.baicizhan.client.business.auth;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.baicizhan.client.business.util.DeviceUtil;
import java.lang.ref.WeakReference;

public class WXShareProxy {
    /* access modifiers changed from: private */
    public WeakReference<Activity> mActivity;
    /* access modifiers changed from: private */
    public WeixinShare mWeixinShare;
    private WeixinShareHandler mWeixinShareHandler = new WeixinShareHandler(this);
    /* access modifiers changed from: private */
    public boolean mWeixinSharing;

    class WeixinShareHandler extends Handler {
        final WeakReference<WXShareProxy> mShare;

        WeixinShareHandler(WXShareProxy wXShareProxy) {
            this.mShare = new WeakReference<>(wXShareProxy);
        }

        public void handleMessage(Message message) {
            WXShareProxy wXShareProxy = (WXShareProxy) this.mShare.get();
            if (wXShareProxy != null) {
                if (1 == ((Activity) wXShareProxy.mActivity.get()).getResources().getConfiguration().orientation) {
                    wXShareProxy.mWeixinSharing = true;
                    wXShareProxy.mWeixinShare.share();
                    return;
                }
                wXShareProxy.doPostWeixinShare();
            }
        }
    }

    private WXShareProxy(Activity activity) {
        this.mActivity = new WeakReference<>(activity);
    }

    public static WXShareProxy born(Activity activity) {
        return new WXShareProxy(activity);
    }

    public void resume() {
        Activity activity = (Activity) this.mActivity.get();
        if (this.mWeixinSharing && activity != null) {
            this.mWeixinSharing = false;
            activity.setRequestedOrientation(0);
        }
    }

    public void cancel() {
        if (this.mWeixinShareHandler != null) {
            this.mWeixinShareHandler.removeMessages(0);
        }
    }

    public void share(WeixinShare weixinShare, boolean z) {
        Activity activity = (Activity) this.mActivity.get();
        if (activity != null) {
            this.mWeixinShare = weixinShare;
            if (!needPost() || z) {
                this.mWeixinShare.share();
                return;
            }
            activity.setRequestedOrientation(1);
            doPostWeixinShare();
        }
    }

    private static boolean needPost() {
        return DeviceUtil.isMeizu();
    }

    /* access modifiers changed from: private */
    public void doPostWeixinShare() {
        this.mWeixinShareHandler.sendEmptyMessageDelayed(0, 300);
    }
}
