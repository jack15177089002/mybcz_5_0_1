//package com.baicizhan.client.wordlock.stat;
//
//import android.util.Log;
//import com.android.volley.Response.Listener;
//import com.android.volley.toolbox.StringRequest;
//import com.baicizhan.client.business.usr.User;
//import com.baicizhan.client.business.usr.UserAsyncTask;
//import com.baicizhan.client.business.usr.UserLoadHandler;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.baicizhan.client.wordlock.setting.Settings;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Locale;
//
//public class UseStat implements UserLoadHandler {
//    private static final boolean STAT_ENABLED = true;
//
//    public static UseStat born() {
//        return new UseStat();
//    }
//
//    private UseStat() {
//    }
//
//    public void onError(Void voidR) {
//    }
//
//    public void onProgress(int i) {
//    }
//
//    public void onSuccess(User user) {
//        if (user != null) {
//            UserToken userToken = new UserToken();
//            userToken.setToken(user.getToken());
//            VolleyUtils.send(new StringRequest("http://www.baicizhan.com/api/screen_lock?json=" + new Gson().toJson((Object) userToken), new Listener<String>() {
//                public void onResponse(String str) {
//                    Log.d("whiz", "wordlock stat response: " + str);
//                    Settings.setLastStatDateLock(UseStat.today());
//                }
//            }, null));
//        }
//    }
//
//    private boolean needStat() {
//        String lastStatDateLock = Settings.getLastStatDateLock();
//        if (lastStatDateLock != null && lastStatDateLock.equals(today())) {
//            return false;
//        }
//        return true;
//    }
//
//    /* access modifiers changed from: private */
//    public static final String today() {
//        return new SimpleDateFormat("dd-MMM-yyyy", Locale.CHINA).format(Calendar.getInstance().getTime());
//    }
//
//    public void stat() {
//        if (needStat()) {
//            doStat();
//        }
//    }
//
//    private void doStat() {
//        UserAsyncTask.getTask(this).execute(new Void[0]);
//    }
//}
