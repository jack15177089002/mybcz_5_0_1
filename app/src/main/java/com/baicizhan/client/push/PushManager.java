package com.baicizhan.client.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baicizhan.client.framework.log.C0789L;
//import com.tencent.android.tpush.XGIOperateCallback;
//import com.tencent.android.tpush.XGPushManager;
import java.util.HashMap;
import org.json.JSONObject;

public class PushManager {
    private static final int MAX_RETRY = 3;
    public static final String MSGTYPE_ACCEPT_FRIEND = "ACCEPT_FRIEND";
    public static final String MSGTYPE_APPLY_FRIEND = "APPLY_FRIEND";
    public static final String MSGTYPE_IGNORE_FRIEND = "IGNORE_FRIEND";
    private static final long RETRY_BACKOFF_TIME = 1000;
    static final String TAG = PushManager.class.getSimpleName();
    private static PushManager sInstance = null;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private PushListener mUnhandledListener = new PushListener() {
        public void onPush(String str, String str2, JSONObject jSONObject) {
            C0789L.log.debug("unhandled push [msgType=" + str + ", msg=" + str2 + ", extra=" + jSONObject + "]");
        }
    };
    private HashMap<String, PushListener> sListenerMap = new HashMap<>();

    public interface PushListener {
        void onPush(String str, String str2, JSONObject jSONObject);
    }

    public static PushManager getInstance() {
        if (sInstance == null) {
            synchronized (PushManager.class) {
                if (sInstance == null) {
                    sInstance = new PushManager();
                }
            }
        }
        return sInstance;
    }

    public void login(Context context, String str) {
        C0789L.log.info("login " + str);
        impLogin(context.getApplicationContext(), str, 0);
    }

    /* access modifiers changed from: private */
    public void impLogin(final Context context, final String str, final int i) {
        if (i == 3) {
            C0789L.log.error("+++ register fail, retry timeout");
            return;
        }
        C0789L.log.info("+++ try register, retry index " + i);
//        XGPushManager.registerPush(context, str, new XGIOperateCallback() {
//            public void onSuccess(Object obj, int i) {
//                C0789L.log.info("+++ register push sucess. token:" + obj);
//            }
//
//            public void onFail(Object obj, int i, String str) {
//                C0789L.log.error("+++ register push fail, errCode:" + i + ",msg:" + str);
//                PushManager.this.mHandler.postDelayed(new Runnable() {
//                    public void run() {
//                        PushManager.this.impLogin(context, str, i + 1);
//                    }
//                }, 1000);
//            }
//        });
    }

    public void logout(Context context) {
        C0789L.log.info("logout");
//        XGPushManager.unregisterPush(context.getApplicationContext());
    }

    public void registerPushListener(String str, PushListener pushListener) {
        this.sListenerMap.put(str, pushListener);
    }

    public void unregisterPushListener(String str, PushListener pushListener) {
        this.sListenerMap.remove(str);
    }

    public PushListener findPushListener(String str) {
        PushListener pushListener = (PushListener) this.sListenerMap.get(str);
        if (pushListener == null) {
            return this.mUnhandledListener;
        }
        return pushListener;
    }
}
