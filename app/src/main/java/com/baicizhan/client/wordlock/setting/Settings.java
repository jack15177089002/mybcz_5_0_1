//package com.baicizhan.client.wordlock.setting;
//
//import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.wordlock.WordLockAppHandler;
//
//public class Settings {
//    private static final String PREF_CACHED_LOCK_REVD_COUNT = "pref_cached_lock_revd_count";
//    private static final String PREF_FILE = "wordlock.pref";
//    private static final String PREF_FILE_DAEMON = "wordlock_daemon.pref";
//    private static final String PREF_FIRST_SET_WORD_LOCK_SCREEN = "pref_first_set_word_lock_screen";
//    public static final String PREF_IS_WORD_LOCK_SCREEN = "pref_is_word_lock_screen";
//    private static final String PREF_LAST_DATE_FOR_LOCK_REVD_COUNT = "pref_last_date_for_lock_revd_count";
//    private static final String PREF_LAST_STAT_DATE_LOCK = "pref_last_stat_date_lock";
//    private static final String PREF_OPEN_LOCK_COUNT = "pref_open_lock_count";
//    private static final String PREF_TODAY_MILLISECONDS = "pref_today_milliseconds";
//    private static final String PREF_TOTAL_REVD_COUNT = "pref_total_revd_count";
//    private static final String PREF_WORDLOCK_GUIDE_NUM = "pref_wordlock_guide_num";
//    private static final String PREF_WORDLOCK_HAS_WORD = "pref_wordlock_has_word";
//    private static final String PREF_WORD_SEARCH_USED = "pref_wordlock_search_used";
//
//    private Settings() {
//    }
//
//    public static final void setWordLockscreenEnabled(boolean z) {
//        PropertyHelper.put(PREF_IS_WORD_LOCK_SCREEN, z);
//    }
//
//    public static final boolean isWordLockscreenEnabled() {
//        return PropertyHelper.getBoolean(PREF_IS_WORD_LOCK_SCREEN, true);
//    }
//
//    public static final boolean hasBook() {
//        return PropertyHelper.getInt(PropertyHelper.CURRENT_BOOK_ID) > 0;
//    }
//
//    public static final int getBook() {
//        return PropertyHelper.getInt(PropertyHelper.CURRENT_BOOK_ID);
//    }
//
//    public static final void setLastStatDateLock(String str) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putString(PREF_LAST_STAT_DATE_LOCK, str);
//        edit.commit();
//    }
//
//    public static final String getLastStatDateLock() {
//        return getSharedPreferences().getString(PREF_LAST_STAT_DATE_LOCK, null);
//    }
//
//    public static final void setFirstSetLockScreen(boolean z) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putBoolean(PREF_FIRST_SET_WORD_LOCK_SCREEN, z);
//        edit.commit();
//    }
//
//    public static final boolean isLockScreenFirstSet() {
//        return getSharedPreferences().getBoolean(PREF_FIRST_SET_WORD_LOCK_SCREEN, true);
//    }
//
//    public static final void setLastDateForLockRevdCount(String str) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putString(PREF_LAST_DATE_FOR_LOCK_REVD_COUNT, str);
//        edit.commit();
//    }
//
//    public static final String getLastDateForLockRevdCount() {
//        return getSharedPreferences().getString(PREF_LAST_DATE_FOR_LOCK_REVD_COUNT, null);
//    }
//
//    public static final void setCachedLockRevdCount(int i) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putInt(PREF_CACHED_LOCK_REVD_COUNT, i);
//        edit.commit();
//    }
//
//    public static final int getCachedLockRevdCount() {
//        return getSharedPreferences().getInt(PREF_CACHED_LOCK_REVD_COUNT, 0);
//    }
//
//    public static final void setWordlockGuideNum(int i) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putInt(PREF_WORDLOCK_GUIDE_NUM, i);
//        edit.commit();
//    }
//
//    public static final int getWordlockGuideNum() {
//        return getSharedPreferences().getInt(PREF_WORDLOCK_GUIDE_NUM, 0);
//    }
//
//    public static final void setWordlockHasWord(boolean z) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putBoolean(PREF_WORDLOCK_HAS_WORD, z);
//        edit.commit();
//    }
//
//    public static final boolean doesWordlockHasWord() {
//        return getSharedPreferences().getBoolean(PREF_WORDLOCK_HAS_WORD, true);
//    }
//
//    public static final void accumOpenLockCount() {
//        SharedPreferences sharedPreferences = getSharedPreferences();
//        Editor edit = sharedPreferences.edit();
//        edit.putInt(PREF_OPEN_LOCK_COUNT, sharedPreferences.getInt(PREF_OPEN_LOCK_COUNT, 0) + 1);
//        edit.commit();
//    }
//
//    public static final void setOpenLockCount(int i) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putInt(PREF_OPEN_LOCK_COUNT, i);
//        edit.commit();
//    }
//
//    public static final int getOpenLockCount() {
//        return getSharedPreferences().getInt(PREF_OPEN_LOCK_COUNT, 0);
//    }
//
//    public static final void increaseTotalRevdCount(int i) {
//        SharedPreferences sharedPreferences = getSharedPreferences();
//        Editor edit = sharedPreferences.edit();
//        edit.putInt(PREF_TOTAL_REVD_COUNT, sharedPreferences.getInt(PREF_TOTAL_REVD_COUNT, 0) + i);
//        edit.commit();
//    }
//
//    public static final void setTotalRevdCount(int i) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putInt(PREF_TOTAL_REVD_COUNT, i);
//        edit.commit();
//    }
//
//    public static final int getTotalRevdCount() {
//        return getSharedPreferences().getInt(PREF_TOTAL_REVD_COUNT, 0);
//    }
//
//    public static final void setTodayMilliseconds(long j) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putLong(PREF_TODAY_MILLISECONDS, j);
//        edit.commit();
//    }
//
//    public static final long getTodayMilliseconds() {
//        return getSharedPreferences().getLong(PREF_TODAY_MILLISECONDS, 0);
//    }
//
//    private static SharedPreferences getSharedPreferences() {
//        return WordLockAppHandler.getApp().getSharedPreferences(PREF_FILE, 0);
//    }
//
//    public static final void setWordSearchUsed(boolean z) {
//        Editor edit = getSharedPreferences().edit();
//        edit.putBoolean(PREF_WORD_SEARCH_USED, z);
//        edit.commit();
//    }
//
//    public static final boolean doesWordSearchUsed() {
//        return getSharedPreferences().getBoolean(PREF_WORD_SEARCH_USED, false);
//    }
//
//    public static final void setWordlockHasWord_daemon(boolean z) {
//        Editor edit = getSharedPreferences_daemon().edit();
//        edit.putBoolean(PREF_WORDLOCK_HAS_WORD, z);
//        edit.commit();
//    }
//
//    public static final boolean doesWordlockHasWord_daemon() {
//        return getSharedPreferences_daemon().getBoolean(PREF_WORDLOCK_HAS_WORD, true);
//    }
//
//    private static SharedPreferences getSharedPreferences_daemon() {
//        return WordLockAppHandler.getApp().getSharedPreferences(PREF_FILE_DAEMON, 0);
//    }
//}
