package com.baicizhan.client.business.auth;

import android.content.Context;
import android.util.SparseArray;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
//import com.sina.weibo.sdk.p064a.Oauth2AccessToken;

public class UsersAPI extends AbsOpenAPI {
    private static final String API_BASE_URL = "https://api.weibo.com/2/users";
    private static final int READ_USER = 0;
    private static final int READ_USER_BY_DOMAIN = 1;
    private static final int READ_USER_COUNT = 2;
    private static final SparseArray<String> sAPIList;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        sAPIList = sparseArray;
        sparseArray.put(0, "https://api.weibo.com/2/users/show.json");
        sAPIList.put(1, "https://api.weibo.com/2/users/domain_show.json");
        sAPIList.put(2, "https://api.weibo.com/2/users/counts.json");
    }

//    public UsersAPI(Context context, String str, Oauth2AccessToken bVar) {
//        super(context, str, bVar);
//    }
//
//    public void show(long j, RequestListener gVar) {
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        jVar.mo16872a("uid", j);
//        requestAsync((String) sAPIList.get(0), jVar, "GET", gVar);
//    }
//
//    public void show(String str, RequestListener gVar) {
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        jVar.mo16874a("screen_name", str);
//        requestAsync((String) sAPIList.get(0), jVar, "GET", gVar);
//    }
//
//    public void domainShow(String str, RequestListener gVar) {
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        jVar.mo16874a("domain", str);
//        requestAsync((String) sAPIList.get(1), jVar, "GET", gVar);
//    }
//
//    public void counts(long[] jArr, RequestListener gVar) {
//        requestAsync((String) sAPIList.get(2), buildCountsParams(jArr), "GET", gVar);
//    }
//
//    public String showSync(long j) {
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        jVar.mo16872a("uid", j);
//        return requestSync((String) sAPIList.get(0), jVar, "GET");
//    }
//
//    public String showSync(String str) {
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        jVar.mo16874a("screen_name", str);
//        return requestSync((String) sAPIList.get(0), jVar, "GET");
//    }
//
//    public String domainShowSync(String str) {
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        jVar.mo16874a("domain", str);
//        return requestSync((String) sAPIList.get(1), jVar, "GET");
//    }
//
//    public String countsSync(long[] jArr) {
//        return requestSync((String) sAPIList.get(2), buildCountsParams(jArr), "GET");
//    }
//
//    private WeiboParameters buildCountsParams(long[] jArr) {
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        StringBuilder sb = new StringBuilder();
//        for (long append : jArr) {
//            sb.append(append).append(",");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        jVar.mo16874a("uids", sb.toString());
//        return jVar;
//    }
}
