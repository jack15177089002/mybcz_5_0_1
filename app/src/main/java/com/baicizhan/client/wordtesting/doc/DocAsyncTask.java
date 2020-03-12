package com.baicizhan.client.wordtesting.doc;

import android.util.Log;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.baicizhan.client.business.util.RandomStringCreator;
import com.baicizhan.client.framework.asynctask.LAsyncTask;
import com.baicizhan.client.framework.conf.Configure;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.network.NetworkUtils;
import com.baicizhan.client.framework.network.VolleyUtils;
import com.baicizhan.client.framework.p031db.ConnectionPool;
import com.baicizhan.client.framework.p031db.ConnectionPool.ConnectionMode;
import com.baicizhan.client.framework.p031db.ConnectionPool.OpenMode;
import com.baicizhan.client.framework.util.Common;
import com.baicizhan.client.wordtesting.application.WordTestingApplicationHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class DocAsyncTask extends LAsyncTask<List<Doc>, Void, List<Doc>> {
    /* access modifiers changed from: private */
    public DocLoadHandler mHandler;
    private boolean mTmpRetry = false;

    public DocAsyncTask(DocLoadHandler docLoadHandler, boolean z) {
        setKey(genKey(docLoadHandler.getClass()));
        parallelTask(1);
        this.mHandler = docLoadHandler;
        this.mTmpRetry = z;
    }

    /* access modifiers changed from: protected */
    public List<Doc> doInBackground(List<Doc>... listArr) {
        List<Doc> list;
        List<Doc> list2 = null;
        if (listArr != null) {
            try {
                list = listArr[0];
            } catch (Exception e) {
                C0789L.log.warn("get docs from db error", (Throwable) e);
                try {
                    ConnectionPool.getInstance().free();
                } catch (Exception e2) {
                }
                try {
                    ConnectionPool.getInstance().destroy();
                } catch (Exception e3) {
                }
            } catch (Throwable th) {
                try {
                    ConnectionPool.getInstance().free();
                } catch (Exception e4) {
                }
                try {
                    ConnectionPool.getInstance().destroy();
                } catch (Exception e5) {
                }
                throw th;
            }
        } else {
            list = list2;
        }
        C0789L.log.info("new docs to update [{}]", (Object) list);
        ConnectionPool.getInstance().init(ConnectionMode.ONE_PER_FETCH, OpenMode.READ_WRITE);
        DocDao docDao = new DocDao(new DocDBHelper(WordTestingApplicationHandler.getApp()));
        if (list == null || list.isEmpty()) {
            list2 = docDao.getDocsOrderByGrade();
            try {
                ConnectionPool.getInstance().free();
            } catch (Exception e6) {
            }
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e7) {
            }
            return list2;
        }
        docDao.updateDocs(list);
        try {
            ConnectionPool.getInstance().free();
        } catch (Exception e8) {
        }
        try {
            ConnectionPool.getInstance().destroy();
        } catch (Exception e9) {
        }
        return list2;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<Doc> list) {
        C0789L.log.info("get docs from db [{}]", (Object) list);
        if (list == null || list.isEmpty()) {
            if (!this.mTmpRetry) {
                getTask(this.mHandler, true).execute(true);
            }
        } else if (this.mHandler != null) {
            this.mHandler.onSuccess(list);
        }
    }

    public List<Doc> parseRawdocsFromJson(JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                Doc doc = new Doc();
                doc.setText(jSONArray.getString(i));
                doc.setGrade(i);
                arrayList.add(doc);
                C0789L.log.info("doc array doc [{}]", (Object) doc);
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void execute(boolean z) {
        if (NetworkUtils.isWiFiConnected(WordTestingApplicationHandler.getApp()) || z) {
            String value = Configure.getInstance().getValue("wordtesting_logic", "url.docs");
            String format = String.format(Locale.US, value, new Object[]{RandomStringCreator.bornNumCharString()});
            Log.d("whiz", "request for docs from: " + format);
            VolleyUtils.send(new JsonArrayRequest(format, new Listener<JSONArray>() {
                public void onResponse(JSONArray jSONArray) {
                    List parseRawdocsFromJson = DocAsyncTask.this.parseRawdocsFromJson(jSONArray);
                    if (!(parseRawdocsFromJson == null || parseRawdocsFromJson.isEmpty() || DocAsyncTask.this.mHandler == null)) {
                        DocAsyncTask.this.mHandler.onSuccess(parseRawdocsFromJson);
                    }
                    DocAsyncTask.this.execute(parseRawdocsFromJson);
                }
            }, new ErrorListener() {
                public void onErrorResponse(VolleyError volleyError) {
                }
            }));
            return;
        }
        execute(null);
    }

    private static final String genKey(Class<?> cls) {
        return Common.md5(DocAsyncTask.class.getName() + " : " + cls.getName());
    }

    public static final DocAsyncTask getTask(DocLoadHandler docLoadHandler, boolean z) {
        String genKey = genKey(docLoadHandler.getClass());
        LAsyncTask searchTask = searchTask(genKey);
        if (searchTask != null) {
            searchTask.cancel();
            removeAllTask(0, genKey);
        }
        return new DocAsyncTask(docLoadHandler, z);
    }
}
