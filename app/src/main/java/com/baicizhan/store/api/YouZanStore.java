//package com.baicizhan.store.api;
//
//import com.baicizhan.store.bean.KdtItem;
//import com.baicizhan.store.bean.KdtResult;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import org.apache.http.HttpResponse;
//import org.apache.http.util.EntityUtils;
//
//public class YouZanStore {
//    private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";
//    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
//    public static final String METHOD_GET_ALL_ITEMS = "kdt.items.onsale.get";
//    public static final String METHOD_GET_ITEM = "kdt.items.custom.get";
//    public static final String PARAM_OUTER_ID = "outer_id";
//
//    public static List<KdtItem> getAllSoldItems() {
//        return ((KdtResult) new Gson().mo3210a(getHttpResponseBody(KdtApiClient.getInstance().get(METHOD_GET_ALL_ITEMS, new HashMap())), KdtResult.class)).getResponse().getItems();
//    }
//
//    public static KdtItem getSoldItem(String str) {
//        HashMap hashMap = new HashMap();
//        hashMap.put(PARAM_OUTER_ID, str);
//        List items = ((KdtResult) new Gson().mo3210a(getHttpResponseBody(KdtApiClient.getInstance().get(METHOD_GET_ITEM, hashMap)), KdtResult.class)).getResponse().getItems();
//        if (items == null || items.isEmpty()) {
//            return null;
//        }
//        return (KdtItem) items.get(0);
//    }
//
//    public static List<String> parseDescImageList(String str) {
//        return getImageSrc(str);
//    }
//
//    private static String getHttpResponseBody(HttpResponse httpResponse) {
//        return EntityUtils.toString(httpResponse.getEntity());
//    }
//
//    private static List<String> getImageSrc(String str) {
//        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(str);
//        ArrayList arrayList = new ArrayList();
//        while (matcher.find()) {
//            Matcher matcher2 = Pattern.compile(IMGSRC_REG).matcher(matcher.group());
//            while (matcher2.find()) {
//                String group = matcher2.group();
//                arrayList.add(group.substring(0, group.length() - 1));
//            }
//        }
//        return arrayList;
//    }
//}
