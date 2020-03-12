package com.baicizhan.client.friend.utils;

public class FriendURL {
    public static final String ACTION_ACCEPT_FRIEND = "/user/accept_global_friend";
    public static final String ACTION_APPLY_FRIEND = "/user/apply_global_friend";
    public static final String ACTION_DELETE_FRIEND = "/user/delete_global_friend";
    public static final String ACTION_GET_FEEDS = "/user/get_feeds";
    public static final String ACTION_GET_FEEDS_BEFORE_TIME = "/user/get_feeds_before_time";
    public static final String ACTION_GET_FRIENDS = "/user/get_friends_info";
    public static final String ACTION_GET_INVITED_FRIENDS = "/user/get_invited";
    public static final String ACTION_GET_LATEST_FEED_TIME = "/user/get_latest_feed_time";
    public static final String ACTION_GET_NOTIFICATIONS = "/user/get_notifications";
    public static final String ACTION_GET_SUGGEST_FRIENDS = "/user/get_suggest_friends";
    public static final String ACTION_GET_USER_INFO = "/user/get_user_info";
    public static final String ACTION_HAS_NEW_FEEDS = "/user/has_new_feeds";
    public static final String ACTION_IGNORE_FRIEND = "/user/ignore_global_friend";
    public static final String ACTION_REFRESH_FRIENDS_LEARNED = "/user/refresh_learned";
    public static final String ACTION_SEARCH_USER = "/search_user";
    private static final String BASE_URL = "http://www.baicizhan.com/api/";

    public static String getURL(String str) {
        return new StringBuilder(BASE_URL).append(System.currentTimeMillis()).append(str).append(".gz").toString();
    }
}
