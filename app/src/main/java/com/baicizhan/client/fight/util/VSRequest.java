package com.baicizhan.client.fight.util;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Request.Priority;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.baicizhan.client.business.jsonbean.ErrorInfo;
import com.baicizhan.client.business.jsonbean.Response;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.network.VolleyUtils;
import java.lang.reflect.Type;
import p012ch.qos.logback.core.CoreConstants;

public class VSRequest<T> {
    /* access modifiers changed from: private */
    public static final Handler HANDLER = new Handler(Looper.getMainLooper());
    public static final String TAG = "VSRequest";
    public static final int TIMEOUT_INFINITY = 0;
    private boolean mCanceled = false;
    private ErrorListener mErrorListener;
    /* access modifiers changed from: private */
    public OnResponseListener<T> mListener;
    private int mMethod;
    private OnPollingTimeoutListener mOnPollingTimeoutListener;
    /* access modifiers changed from: private */
    public int mPollingInterval;
    /* access modifiers changed from: private */
    public Runnable mPollingRunnable = new Runnable() {
        public void run() {
            VSRequest.this.request();
        }
    };
    private long mPollingStartTime = 0;
    private int mPollingTimeout = CoreConstants.MILLIS_IN_ONE_MINUTE;
    private Priority mPriority;
    private String mRequestBody = null;
    private Type mResponseType;
    private String mTag;
    private String mURL;
    private URLFactory mURLFactory;

    public interface OnPollingTimeoutListener {
        void onPollingTimeout();
    }

    public interface OnResponseListener<T> {
        boolean onResponse(ErrorInfo errorInfo, T t);
    }

    public interface URLFactory {
        String get();
    }

    public VSRequest(String str, String str2, Type type, OnResponseListener<T> onResponseListener, ErrorListener errorListener) {
        this.mTag = str;
        this.mURL = str2;
        this.mResponseType = type;
        this.mListener = onResponseListener;
        this.mErrorListener = errorListener;
        this.mPriority = Priority.NORMAL;
    }

    public VSRequest(String str, URLFactory uRLFactory, Type type, OnResponseListener<T> onResponseListener, ErrorListener errorListener) {
        this.mTag = str;
        this.mURLFactory = uRLFactory;
        this.mResponseType = type;
        this.mListener = onResponseListener;
        this.mErrorListener = errorListener;
        this.mPriority = Priority.NORMAL;
    }

    public void setMethod(int i) {
        this.mMethod = i;
    }

    public void setRequestBody(String str) {
        this.mRequestBody = str;
    }

    public void start() {
        this.mCanceled = false;
        this.mPollingStartTime = System.currentTimeMillis();
        request();
    }

    public void cancel() {
        HANDLER.removeCallbacks(this.mPollingRunnable);
        VolleyUtils.cancelAllTagRequest(this.mTag);
        this.mCanceled = true;
    }

    public void setPollingInterval(int i) {
        this.mPollingInterval = i;
    }

    public void setPollingTimeout(int i) {
        this.mPollingTimeout = i;
    }

    public void setOnPollingTimeoutListener(OnPollingTimeoutListener onPollingTimeoutListener) {
        this.mOnPollingTimeoutListener = onPollingTimeoutListener;
    }

    public void request() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mPollingTimeout != 0 && currentTimeMillis - this.mPollingStartTime > ((long) this.mPollingTimeout) && this.mOnPollingTimeoutListener != null) {
            this.mOnPollingTimeoutListener.onPollingTimeout();
            cancel();
        } else if (this.mCanceled) {
            C0789L.log.debug("request isCanceled");
        } else {
            GsonRequest gsonRequest = new GsonRequest(this.mMethod, this.mURLFactory == null ? this.mURL : this.mURLFactory.get(), this.mResponseType, this.mRequestBody, new Listener<Response<T>>() {
                public void onResponse(Response<T> response) {
//                    if (VSRequest.this.mListener.onResponse(response.getErrorInfo(), response.getData())) {
//                        return;
//                    }
//                    if (VSRequest.this.mPollingInterval > 0) {
//                        VSRequest.HANDLER.postDelayed(VSRequest.this.mPollingRunnable, (long) VSRequest.this.mPollingInterval);
//                    } else {
//                        VSRequest.this.cancel();
//                    }
                }
            }, this.mErrorListener);
            gsonRequest.setTag(this.mTag);
            gsonRequest.setShouldCache(false);
            gsonRequest.setPriority(this.mPriority);
            VolleyUtils.send(gsonRequest);
        }
    }
}
