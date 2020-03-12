package com.baicizhan.client.framework.network;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RequestQueue.RequestFilter;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class VolleyUtils {
    private static final float REQUEST_BACKOFF_MULT = 1.0f;
    private static final int REQUEST_RETRIES_GET = 2;
    private static final int REQUEST_TIMEOUT = 10000;
    public static RequestQueue sRequestQueue;

    public static synchronized void initialize(Context context) {
        synchronized (VolleyUtils.class) {
            if (sRequestQueue == null) {
                sRequestQueue = Volley.newRequestQueue(context);
            }
        }
    }

    public static int statusCodeFromVolleyError(VolleyError volleyError) {
        if (volleyError == null || volleyError.networkResponse == null) {
            return 0;
        }
        return volleyError.networkResponse.statusCode;
    }

    public static void cancelAllRequest() {
        sRequestQueue.cancelAll((RequestFilter) new RequestFilter() {
            public final boolean apply(Request<?> request) {
                return true;
            }
        });
    }

    public static void cancelAllTagRequest(Object obj) {
        sRequestQueue.cancelAll(obj);
    }

    public static void send(Request<?> request) {
        send(request, new DefaultRetryPolicy(10000, 2, 1.0f));
    }

    public static void send(Request<?> request, RetryPolicy retryPolicy) {
        request.setRetryPolicy(retryPolicy);
        sRequestQueue.add(request);
    }
}
