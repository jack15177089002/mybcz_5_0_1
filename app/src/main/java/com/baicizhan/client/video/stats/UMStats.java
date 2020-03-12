//package com.baicizhan.client.video.stats;
//
//import android.content.Context;
//import com.umeng.p092a.MobclickAgent;
//import java.util.HashMap;
//
//public class UMStats {
//    private static final String EVENT_TV_WORD_SKIPPED = "TV_WORD_SKIPPED";
//    private static final String KEY_SKIPPED_WORD = "skipped_word";
//    private Context mContext;
//
//    public UMStats(Context context) {
//        if (context == null) {
//            throw new RuntimeException("UMeng stats cannot be initialized for null context param.");
//        }
//        this.mContext = context;
//    }
//
//    public void statSkippedWord(String str) {
//        if (str != null) {
//            HashMap hashMap = new HashMap(1);
//            hashMap.put("skipped_word", str);
//            MobclickAgent.m5134a(this.mContext, "TV_WORD_SKIPPED", hashMap);
//        }
//    }
//
//    public void resume() {
//        MobclickAgent.m5136b(this.mContext);
//    }
//
//    public void pause() {
//        MobclickAgent.m5132a(this.mContext);
//    }
//}
