package com.baicizhan.client.video.data;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.baicizhan.client.framework.device.DeviceInfo;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.network.VolleyUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoUrlHostGetter {
    private static final String URL = ("http://42.121.253.195/api/check_infos?log_device_name=android&log_app_version=" + getVersion());

    public interface OnGetHostListener {
        void onGet(String str, String str2);
    }

    private static String getVersion() {
        String baicizhanVersionName = DeviceInfo.getBaicizhanVersionName();
        int lastIndexOf = baicizhanVersionName.lastIndexOf(".");
        return baicizhanVersionName.substring(0, lastIndexOf) + baicizhanVersionName.substring(lastIndexOf + 1, baicizhanVersionName.length());
    }

    public void get(final OnGetHostListener onGetHostListener) {
        VolleyUtils.send(new JsonObjectRequest(URL, null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                try {
                    String string = jSONObject.getString("res_dns");
                    String string2 = jSONObject.getString("other_res_dns");
                    if (onGetHostListener != null) {
                        onGetHostListener.onGet(string, string2);
                    }
                } catch (JSONException e) {
                    C0789L.log.error("get video url host json error. ", (Throwable) e);
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (onGetHostListener != null) {
                    onGetHostListener.onGet(null, null);
                }
                C0789L.log.error("get video url host net error. ", (Throwable) volleyError);
            }
        }));
    }
}
