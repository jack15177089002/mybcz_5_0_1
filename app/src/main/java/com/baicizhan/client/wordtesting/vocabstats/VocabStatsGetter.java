package com.baicizhan.client.wordtesting.vocabstats;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.baicizhan.client.business.usr.User;
import com.baicizhan.client.business.usr.UserAsyncTask;
import com.baicizhan.client.business.usr.UserLoadHandler;
import com.baicizhan.client.business.util.RandomStringCreator;
import com.baicizhan.client.framework.conf.Configure;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.network.VolleyUtils;
import com.baicizhan.client.wordtesting.bean.VocabStats;
import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
import java.util.Locale;

public class VocabStatsGetter implements UserLoadHandler {
    /* access modifiers changed from: private */
    public OnGetVocabStatsListener mListener;

    public interface OnGetVocabStatsListener {
        void onGetVocabStats(VocabStats vocabStats);
    }

    public void asyncGet(OnGetVocabStatsListener onGetVocabStatsListener) {
        this.mListener = onGetVocabStatsListener;
        UserAsyncTask.getTask(this).execute(new Void[0]);
    }

    public void onError(Void voidR) {
    }

    public void onProgress(int i) {
    }

    public void onSuccess(User user) {
        String value = Configure.getInstance().getValue("wordtesting_logic", "url.vocabstats");
        VolleyUtils.send(new StringRequest(String.format(Locale.US, value, new Object[]{RandomStringCreator.bornNumCharString(), user.getToken()}), new Listener<String>() {
            public void onResponse(String str) {
                try {
                    C0789L.log.info("vocabulary curve data from server is [{}]", (Object) str);
                    VocabStats vocabStats = (VocabStats) new Gson().fromJson(str, new TypeToken<VocabStats>() {
                    }.getType());
                    C0789L.log.info("formatted vocabulary curve data from server is [{}]", (Object) vocabStats);
                    if (VocabStatsGetter.this.mListener != null) {
                        VocabStatsGetter.this.mListener.onGetVocabStats(vocabStats);
                    }
                } catch (Exception e) {
                    C0789L.log.error("vocabulary curve data from server cannot be got for exception.", (Throwable) e);
                    if (VocabStatsGetter.this.mListener != null) {
                        VocabStatsGetter.this.mListener.onGetVocabStats(null);
                    }
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                C0789L.log.error("vocabulary curve data from server cannot be got for net error [{}]", (Throwable) volleyError);
                if (VocabStatsGetter.this.mListener != null) {
                    VocabStatsGetter.this.mListener.onGetVocabStats(null);
                }
            }
        }));
    }
}
