//package com.baicizhan.client.wordlock;
//
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.framework.handler.AbstractAppHandler;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.wordlock.service.WordLockDaemon;
//import com.baicizhan.client.wordlock.setting.Settings;
//
//public class WordLockAppHandler extends AbstractAppHandler {
//    public void onCreate() {
//        if (Settings.isWordLockscreenEnabled()) {
//            Log.d("whiz", "wordlock daemon start from app handle");
//            WordLockDaemon.start(getApp());
//        }
//        if (TextUtils.equals(Common.getProcessName(getApp()), "com.jiongji.andriod.card:wordlock")) {
//            PicassoUtil.initPicasso(getApp());
//            BaicizhanThrifts.initialize(getApp());
//        }
//    }
//}
