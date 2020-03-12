//package com.baicizhan.client.business.usr;
//
//import com.baicizhan.client.business.BusinessAppHandler;
//import com.baicizhan.client.business.dataset.helpers.UserRecordHelper;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.framework.log.C0789L;
//
//public class UserSyncTask {
//    private UserSyncTask() {
//    }
//
//    public static User getUser() {
//        try {
//            UserRecord currentUserRecord = UserRecordHelper.getCurrentUserRecord(BusinessAppHandler.getApp());
//            if (currentUserRecord == null) {
//                return null;
//            }
//            User user = new User();
//            user.setToken(currentUserRecord.getToken());
//            user.setName(currentUserRecord.getDisplayName());
//            user.setNickname(currentUserRecord.getNickName());
//            return user;
//        } catch (Exception e) {
//            C0789L.log.warn("get user token from db error", (Throwable) e);
//            return null;
//        }
//    }
//}
