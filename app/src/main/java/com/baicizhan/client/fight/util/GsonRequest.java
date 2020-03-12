package com.baicizhan.client.fight.util;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.util.GzipUtils;
import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import com.google.gson.JsonSyntaxException;//import com.p020b.p021a.JsonSyntaxException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class GsonRequest<T> extends Request<T> {
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[]{PROTOCOL_CHARSET});
    public static final String TAG = "GsonRequest";
    private Map<String, String> headers;
    private Gson mGson;
    private final Listener<T> mListener;
    private Priority mPriority;
    private final String mRequestBody;
    private Type mType;

    public GsonRequest(int i, String str, Type type, String str2, Listener<T> listener, ErrorListener errorListener) {
        super(i, str, errorListener);
        this.headers = new HashMap();
        this.mGson = new Gson();
        this.mType = type;
        this.mListener = listener;
        this.mRequestBody = str2;
        this.mPriority = Priority.NORMAL;
        C0789L.log.debug(String.format("request url[[%s]]", new Object[]{getUrl()}));
    }

    public void setPriority(Priority priority) {
        this.mPriority = priority;
    }

    public Priority getPriority() {
        return this.mPriority;
    }

    public GsonRequest(String str, Type type, String str2, Listener<T> listener, ErrorListener errorListener) {
        this(0, str, type, str2, listener, errorListener);
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(T t) {
        this.mListener.onResponse(t);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    /* access modifiers changed from: protected */
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        try {
            String str2 = (String) networkResponse.headers.get("Content-Type");
            if (str2 == null || !str2.contains("api/gz")) {
                str = new String(networkResponse.data, PROTOCOL_CHARSET);
            } else {
                str = new String(GzipUtils.decompress(networkResponse.data), PROTOCOL_CHARSET);
            }
//            return Response.success(this.mGson.fromJson(str, this.mType), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError((Throwable) e));
        } catch (Exception e2) {
            return Response.error(new ParseError((Throwable) e2));
        }

        return null;
    }

    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    public byte[] getBody() {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException e) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, PROTOCOL_CHARSET);
            return null;
        }
    }
}
