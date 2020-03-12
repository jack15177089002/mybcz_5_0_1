//package com.baicizhan.client.business.search;
//
//import android.content.Context;
//import android.text.TextUtils;
//import com.baicizhan.client.business.dataset.helpers.UserRecordHelper;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//
//public class ThriftManager {
//    private ThriftManager() {
//    }
//
//    public static boolean setToken(Context context) {
//        if (BaicizhanThrifts.getProxy().hasCookie(BaicizhanCookieInflator.ACCESS_TOKEN)) {
//            return true;
//        }
//        UserRecord currentUserRecord = UserRecordHelper.getCurrentUserRecord(context);
//        if (TextUtils.isEmpty(currentUserRecord.getToken())) {
//            return false;
//        }
//        BaicizhanThrifts.getProxy().putCookie(BaicizhanCookieInflator.ACCESS_TOKEN, currentUserRecord.getToken());
//        return true;
//    }
//}
