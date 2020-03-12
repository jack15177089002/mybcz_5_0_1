//package com.baicizhan.client.business.auth;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.text.TextUtils;
//import android.util.SparseArray;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_OPEN_EARS_MATCH_INFO.Columns;
//import com.sina.weibo.sdk.net.RequestListener;
//import com.sina.weibo.sdk.net.WeiboParameters;
//import com.sina.weibo.sdk.p064a.Oauth2AccessToken;
//
//public class StatusesAPI extends AbsOpenAPI {
//    private static final String API_BASE_URL = "https://api.weibo.com/2/statuses";
//    public static final int AUTHOR_FILTER_ALL = 0;
//    public static final int AUTHOR_FILTER_ATTENTIONS = 1;
//    public static final int AUTHOR_FILTER_STRANGER = 2;
//    public static final int FEATURE_ALL = 0;
//    public static final int FEATURE_MUSICE = 4;
//    public static final int FEATURE_ORIGINAL = 1;
//    public static final int FEATURE_PICTURE = 2;
//    public static final int FEATURE_VIDEO = 3;
//    private static final int READ_API_FRIENDS_TIMELINE = 0;
//    private static final int READ_API_MENTIONS = 1;
//    public static final int SRC_FILTER_ALL = 0;
//    public static final int SRC_FILTER_WEIBO = 1;
//    public static final int SRC_FILTER_WEIQUN = 2;
//    public static final int TYPE_FILTER_ALL = 0;
//    public static final int TYPE_FILTER_ORIGAL = 1;
//    private static final int WRITE_API_REPOST = 3;
//    private static final int WRITE_API_UPDATE = 2;
//    private static final int WRITE_API_UPLOAD = 4;
//    private static final int WRITE_API_UPLOAD_URL_TEXT = 5;
//    private static final SparseArray<String> sAPIList;
//
//    static {
//        SparseArray<String> sparseArray = new SparseArray<>();
//        sAPIList = sparseArray;
//        sparseArray.put(0, "https://api.weibo.com/2/statuses/friends_timeline.json");
//        sAPIList.put(1, "https://api.weibo.com/2/statuses/mentions.json");
//        sAPIList.put(3, "https://api.weibo.com/2/statuses/repost.json");
//        sAPIList.put(2, "https://api.weibo.com/2/statuses/update.json");
//        sAPIList.put(4, "https://api.weibo.com/2/statuses/upload.json");
//        sAPIList.put(5, "https://api.weibo.com/2/statuses/upload_url_text.json");
//    }
//
//    public StatusesAPI(Context context, String str, Oauth2AccessToken bVar) {
//        super(context, str, bVar);
//    }
//
//    public void friendsTimeline(long j, long j2, int i, int i2, boolean z, int i3, boolean z2, RequestListener gVar) {
//        requestAsync((String) sAPIList.get(0), buildTimeLineParamsBase(j, j2, i, i2, z, z2, i3), "GET", gVar);
//    }
//
//    public void mentions(long j, long j2, int i, int i2, int i3, int i4, int i5, boolean z, RequestListener gVar) {
//        requestAsync((String) sAPIList.get(1), buildMentionsParams(j, j2, i, i2, i3, i4, i5, z), "GET", gVar);
//    }
//
//    public void update(String str, String str2, String str3, RequestListener gVar) {
//        requestAsync((String) sAPIList.get(2), buildUpdateParams(str, str2, str3), "POST", gVar);
//    }
//
//    public void upload(String str, Bitmap bitmap, String str2, String str3, RequestListener gVar) {
//        WeiboParameters buildUpdateParams = buildUpdateParams(str, str2, str3);
//        buildUpdateParams.mo16873a("pic", bitmap);
//        requestAsync((String) sAPIList.get(4), buildUpdateParams, "POST", gVar);
//    }
//
//    public void uploadUrlText(String str, String str2, String str3, String str4, String str5, RequestListener gVar) {
//        WeiboParameters buildUpdateParams = buildUpdateParams(str, str4, str5);
//        buildUpdateParams.mo16874a("url", str2);
//        buildUpdateParams.mo16874a("pic_id", str3);
//        requestAsync((String) sAPIList.get(5), buildUpdateParams, "POST", gVar);
//    }
//
//    public String friendsTimelineSync(long j, long j2, int i, int i2, boolean z, int i3, boolean z2) {
//        return requestSync((String) sAPIList.get(0), buildTimeLineParamsBase(j, j2, i, i2, z, z2, i3), "GET");
//    }
//
//    public String mentionsSync(long j, long j2, int i, int i2, int i3, int i4, int i5, boolean z) {
//        return requestSync((String) sAPIList.get(1), buildMentionsParams(j, j2, i, i2, i3, i4, i5, z), "GET");
//    }
//
//    public String updateSync(String str, String str2, String str3) {
//        return requestSync((String) sAPIList.get(2), buildUpdateParams(str, str2, str3), "POST");
//    }
//
//    public String uploadSync(String str, Bitmap bitmap, String str2, String str3) {
//        WeiboParameters buildUpdateParams = buildUpdateParams(str, str2, str3);
//        buildUpdateParams.mo16873a("pic", bitmap);
//        return requestSync((String) sAPIList.get(4), buildUpdateParams, "POST");
//    }
//
//    public String uploadUrlTextSync(String str, String str2, String str3, String str4, String str5) {
//        WeiboParameters buildUpdateParams = buildUpdateParams(str, str4, str5);
//        buildUpdateParams.mo16874a("url", str2);
//        buildUpdateParams.mo16874a("pic_id", str3);
//        return requestSync((String) sAPIList.get(5), buildUpdateParams, "POST");
//    }
//
//    private WeiboParameters buildTimeLineParamsBase(long j, long j2, int i, int i2, boolean z, boolean z2, int i3) {
//        int i4;
//        int i5 = 1;
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        jVar.mo16872a("since_id", j);
//        jVar.mo16872a(Columns.MAX_ID, j2);
//        jVar.mo16871a("count", i);
//        jVar.mo16871a("page", i2);
//        String str = "base_app";
//        if (z) {
//            i4 = 1;
//        } else {
//            i4 = 0;
//        }
//        jVar.mo16871a(str, i4);
//        String str2 = "trim_user";
//        if (!z2) {
//            i5 = 0;
//        }
//        jVar.mo16871a(str2, i5);
//        jVar.mo16871a("feature", i3);
//        return jVar;
//    }
//
//    private WeiboParameters buildUpdateParams(String str, String str2, String str3) {
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        jVar.mo16874a("status", str);
//        if (!TextUtils.isEmpty(str3)) {
//            jVar.mo16874a("long", str3);
//        }
//        if (!TextUtils.isEmpty(str2)) {
//            jVar.mo16874a("lat", str2);
//        }
//        return jVar;
//    }
//
//    private WeiboParameters buildMentionsParams(long j, long j2, int i, int i2, int i3, int i4, int i5, boolean z) {
//        WeiboParameters jVar = new WeiboParameters(this.mAppKey);
//        jVar.mo16872a("since_id", j);
//        jVar.mo16872a(Columns.MAX_ID, j2);
//        jVar.mo16871a("count", i);
//        jVar.mo16871a("page", i2);
//        jVar.mo16871a("filter_by_author", i3);
//        jVar.mo16871a("filter_by_source", i4);
//        jVar.mo16871a("filter_by_type", i5);
//        jVar.mo16871a("trim_user", z ? 1 : 0);
//        return jVar;
//    }
//}
