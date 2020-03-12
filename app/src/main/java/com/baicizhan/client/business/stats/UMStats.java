//package com.baicizhan.client.business.stats;
//
//import android.app.Activity;
//import android.content.Context;
//import com.umeng.p092a.MobclickAgent;
//import java.util.HashMap;
//import java.util.Map;
//
//public class UMStats {
//    public static final String EVENT_FIGHT_MAIN_ACTIVITY_LOCATION = "FIGHT_MAIN_ACTIVITY_LOCATION";
//    public static final String EVENT_FM_TV_SELECT_FM = "FM_TV_SELECT_FM";
//    public static final String EVENT_FM_TV_SELECT_TV = "FM_TV_SELECT_TV";
//    public static final String EVENT_FRIEND_SELECT_DYNC = "FRIEND_SELECT_DYNC";
//    public static final String EVENT_FRIEND_SELECT_WEEK = "FRIEND_SELECT_WEEK";
//    public static final String EVENT_LOADING_PAGE_NO_INTERNET_USE = "LOADING_PAGE_NO_INTERNET_USE";
//    public static final String EVENT_MAININDEX_PAGE_SELECT_FM_TV = "MAININDEX_PAGE_SELECT_FM_TV";
//    public static final String EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIE = "MAININDEX_PAGE_SELECT_STUDY_REVIE";
//    public static final String EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_10 = "MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_10";
//    public static final String EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_11 = "MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_11";
//    public static final String EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_12 = "MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_12";
//    public static final String EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_ADD_FRIEND = "MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_ADD_FRIEND";
//    public static final String EVENT_MAININDEX_PAGE_SELECT_STUDY_WORD = "MAININDEX_PAGE_SELECT_STUDY_WORD";
//    public static final String EVENT_TAB_SELECT_FRIEND_PAGE = "TAB_SELECT_FRIEND_PAGE";
//    public static final String EVENT_TAB_SELECT_PK_PAGE = "TAB_SELECT_PK_PAGE";
//    public static final String EVENT_TAOBAO_MAININDEX_CLICK = "TAOBAO_MAININDEX_CLICK";
//    public static final String EVENT_TAOBAO_PLUSREVIEW_CLICK = "TAOBAO_PLUSREVIEW_CLICK";
//    public static final String EVENT_TAOBAO_PLUSREVIEW_DISPLAY = "TAOBAO_PLUSREVIEW_DISPLAY";
//    public static final String EVENT_TAOBAO_STUDY_LOADING_PAGE_CLICK = "TAOBAO_STUDY_LOADING_PAGE_CLICK";
//    public static final String EVENT_TAOBAO_STUDY_LOADING_PAGE_DISPLAY = "TAOBAO_STUDY_LOADING_PAGE_DISPLAY";
//    public static final String EVENT_TV_WORD_SKIPPED = "TV_WORD_SKIPPED";
//    public static final String KEY_SKIPPED_WORD = "skipped_word";
//    public static final String KEY_TAOBAO_PLUSREVIEW_CLICK = "TAOBAO_PLUSREVIEW_CLICK";
//    public static final String KEY_TAOBAO_PLUSREVIEW_DISPLAY = "TAOBAO_PLUSREVIEW_DISPLAY";
//    public static final String KEY_TAOBAO_STUDY_LOADING_PAGE_CLICK = "TAOBAO_STUDY_LOADING_PAGE_CLICK";
//    public static final String KEY_TAOBAO_STUDY_LOADING_PAGE_DISPLAY = "TAOBAO_STUDY_LOADING_PAGE_DISPLAY";
//
//    public class AttributeStats {
//        private final String event;
//        private Map<String, String> map;
//
//        private AttributeStats(String str) {
//            this.map = new HashMap();
//            this.event = str;
//        }
//
//        public AttributeStats put(String str, String str2) {
//            this.map.put(str, str2);
//            return this;
//        }
//
//        public void stat(Activity activity) {
//            MobclickAgent.m5134a(activity, this.event, this.map);
//        }
//    }
//
//    private UMStats() {
//    }
//
//    public static void closeDefaultStatsMode() {
//        MobclickAgent.m5131a();
//    }
//
//    public static void traceOnActivityResume(Activity activity) {
//        MobclickAgent.m5136b((Context) activity);
//    }
//
//    public static void traceOnActivityPause(Activity activity) {
//        MobclickAgent.m5132a((Context) activity);
//    }
//
//    public static void traceOnActivityResume(Activity activity, String str) {
//        MobclickAgent.m5135a(str);
//        MobclickAgent.m5136b((Context) activity);
//    }
//
//    public static void traceOnActivityPause(Activity activity, String str) {
//        MobclickAgent.m5137b(str);
//        MobclickAgent.m5132a((Context) activity);
//    }
//
//    public static void traceOnFragmentResume(String str) {
//        MobclickAgent.m5135a(str);
//    }
//
//    public static void traceOnFragmentPause(String str) {
//        MobclickAgent.m5137b(str);
//    }
//
//    public static void statEvent(Activity activity, String str) {
//        MobclickAgent.m5133a(activity, str);
//    }
//
//    public static void statSelectOffline(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_LOADING_PAGE_NO_INTERNET_USE);
//    }
//
//    public static void statStudyClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_MAININDEX_PAGE_SELECT_STUDY_WORD);
//    }
//
//    public static void statFriendClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_TAB_SELECT_FRIEND_PAGE);
//    }
//
//    public static void statFmTvClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_MAININDEX_PAGE_SELECT_FM_TV);
//    }
//
//    public static void statPKClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_TAB_SELECT_PK_PAGE);
//    }
//
//    public static void statStoreClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_TAOBAO_MAININDEX_CLICK);
//    }
//
//    public static void statPlusreviewClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIE);
//    }
//
//    public static void statFriendRankClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_FRIEND_SELECT_WEEK);
//    }
//
//    public static void statFriendDiscoverClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_FRIEND_SELECT_DYNC);
//    }
//
//    public static void statStartLocation(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_FIGHT_MAIN_ACTIVITY_LOCATION);
//    }
//
//    public static void statFmClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_FM_TV_SELECT_FM);
//    }
//
//    public static void statTvClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_FM_TV_SELECT_TV);
//    }
//
//    public static void statPlusreviewReadClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_10);
//    }
//
//    public static void statPlusreviewListenClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_11);
//    }
//
//    public static void statPlusreviewWriteClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_12);
//    }
//
//    public static void statPlusreviewMatchClick(Activity activity) {
//        MobclickAgent.m5133a(activity, EVENT_MAININDEX_PAGE_SELECT_STUDY_REVIEW_TYPE_ADD_FRIEND);
//    }
//
//    public static void statSkippedWord(Activity activity, String str) {
//        bornAttrStats(EVENT_TV_WORD_SKIPPED).put(KEY_SKIPPED_WORD, str).stat(activity);
//    }
//
//    public static void statTaobaoDisplayOnStudy(Activity activity, String str) {
//        bornAttrStats("TAOBAO_STUDY_LOADING_PAGE_DISPLAY").put("TAOBAO_STUDY_LOADING_PAGE_DISPLAY", str).stat(activity);
//    }
//
//    public static void statTaobaoClickOnStudy(Activity activity, String str) {
//        bornAttrStats("TAOBAO_STUDY_LOADING_PAGE_CLICK").put("TAOBAO_STUDY_LOADING_PAGE_CLICK", str).stat(activity);
//    }
//
//    public static void statTaobaoDisplayOnReview(Activity activity, String str) {
//        bornAttrStats("TAOBAO_PLUSREVIEW_DISPLAY").put("TAOBAO_PLUSREVIEW_DISPLAY", str).stat(activity);
//    }
//
//    public static void statTaobaoClickOnReview(Activity activity, String str) {
//        bornAttrStats("TAOBAO_PLUSREVIEW_CLICK").put("TAOBAO_PLUSREVIEW_CLICK", str).stat(activity);
//    }
//
//    public static AttributeStats bornAttrStats(String str) {
//        return new AttributeStats(str);
//    }
//}
