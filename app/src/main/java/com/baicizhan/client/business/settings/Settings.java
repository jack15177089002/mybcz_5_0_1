package com.baicizhan.client.business.settings;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
import com.baicizhan.client.framework.BaseAppHandler;

public class Settings {
    public static final String PREF_AD_SHOW_INDEX = "pref_ad_show_index";
    public static final String PREF_BAICIZHAN_PATH = "BAICIZHAN_PATH";
    public static final String PREF_COMPLETE_REVIEW_COUNT = "pref_complete_review_count";
    public static final String PREF_DAKA_TITLE_IMAGE = "pref_daka_title_image";
    public static final String PREF_FEEDBACK_COUNT = "pref_feedback_count";
    private static final String PREF_FILE = "baicizhan.pref";
    private static final String PREF_FIRST_PAGE_LOADING_DUR = "pref_first_page_loading_dur";
    private static final String PREF_FIRST_PAGE_LOADING_URL = "pref_first_page_loading_url";
    public static final String PREF_FRIENDS_NUM = "FRIENDS_NUM";
    public static final String PREF_GUIDE_FLAGS = "pref_guide_flags";
    public static final String PREF_LAST_EMAIL = "pref_last_email";
    public static final String PREF_LAST_REMIND_TIME = "pref_last_remind_time";
    public static final String PREF_LAST_USER_INFO_TIME = "pref_last_user_info_time";
    public static final String PREF_MAIN_STORE_ASKED = "pref_main_store_asked";
    public static final String PREF_NOTICE_RESOURCE_VERSION = "pref_notice_resource_version";
    public static final String PREF_NOTICE_SETTING_TIME = "pref_notice_setting_time";
    private static final String PREF_THEME = "pref_theme";
    public static final String PREF_TOTAL_RES_DB_ENABLED = "pref_total_res_db_enabled";
    public static final String PREF_USER_EMAIL = "USER_EMAIL";
    public static final String PREF_USER_IMAGE = "USER_IMAGE";
    public static final String PREF_USER_IMAGE_URL = "USER_IMAGE_URL";
    public static final String PREF_USER_NAME = "USER_NAME";
    public static final String PREF_USER_NICKNAME = "USER_NICKNAME";
    public static final String PREF_USER_PUBLIC_KEY = "USER_PUBLIC_KEY";
    public static final String PREF_USER_TOKEN = "USER_TOKEN";
    public static final String PREF_VOICE_RECOG_ENABLED = "pref_voice_recog_enabled";
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_NIGHT = 1;

    private Settings() {
    }

    public static final void setTotalResDBEnabled(boolean z) {
//        PropertyHelper.put(PREF_TOTAL_RES_DB_ENABLED, z);
    }

    public static final boolean isTotalResDBEnabled() {
//        return PropertyHelper.getBoolean(PREF_TOTAL_RES_DB_ENABLED, false);

        return false;
    }

    public static final void setTheme(int i) {
        Editor edit = getSharedPreferences().edit();
        edit.putInt(PREF_THEME, i);
        edit.commit();
    }

    public static final int getTheme() {
        return getSharedPreferences().getInt(PREF_THEME, 0);
    }

    public static final void setFirstPageLoadingUrl(String str) {
        Editor edit = getSharedPreferences().edit();
        edit.putString(PREF_FIRST_PAGE_LOADING_URL, str);
        edit.commit();
    }

    public static final String getFirstPageLoadingUrl() {
        return getSharedPreferences().getString(PREF_FIRST_PAGE_LOADING_URL, null);
    }

    public static final void setFirstPageLoadingDur(long j) {
        Editor edit = getSharedPreferences().edit();
        edit.putLong(PREF_FIRST_PAGE_LOADING_DUR, j);
        edit.commit();
    }

    public static final long getFirstPageLoadingDur() {
        return getSharedPreferences().getLong(PREF_FIRST_PAGE_LOADING_DUR, 0);
    }

    public static String getDisplayNickName() {
        String string = getString(PREF_USER_NICKNAME);
        return !TextUtils.isEmpty(string) ? string : getString(PREF_USER_NAME);
    }

    public static final void setLastEmail(String str) {
        Editor edit = getSharedPreferences().edit();
        edit.putString(PREF_LAST_EMAIL, str);
        edit.commit();
    }

    public static final String getLastEmail() {
        return getSharedPreferences().getString(PREF_LAST_EMAIL, null);
    }

    public static void setMainStoreAsked(boolean z) {
        Editor edit = getSharedPreferences().edit();
        edit.putBoolean(PREF_MAIN_STORE_ASKED, z);
        edit.commit();
    }

    public static boolean isMainStoreAsked() {
        return getSharedPreferences().getBoolean(PREF_MAIN_STORE_ASKED, false);
    }

    public static SharedPreferences getSharedPreferences() {
        return BaseAppHandler.getApp().getSharedPreferences(PREF_FILE, 0);
    }

    public static void putString(String str, String str2) {
        getSharedPreferences().edit().putString(str, str2).commit();
    }

    public static String getString(String str) {
        return getSharedPreferences().getString(str, null);
    }

    public static void putInt(String str, int i) {
        getSharedPreferences().edit().putInt(str, i).commit();
    }

    public static int getInt(String str) {
        return getSharedPreferences().getInt(str, 0);
    }

    public static void putLong(String str, long j) {
        getSharedPreferences().edit().putLong(str, j).commit();
    }

    public static long getLong(String str) {
        return getSharedPreferences().getLong(str, 0);
    }

    public static void putFloat(String str, float f) {
        getSharedPreferences().edit().putFloat(str, f).commit();
    }

    public static float getFloat(String str) {
        return getSharedPreferences().getFloat(str, 0.0f);
    }

    public static void putBoolean(String str, boolean z) {
        getSharedPreferences().edit().putBoolean(str, z).commit();
    }

    public static boolean getBoolean(String str, boolean z) {
        return getSharedPreferences().getBoolean(str, z);
    }
}
