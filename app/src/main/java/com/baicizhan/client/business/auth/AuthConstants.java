package com.baicizhan.client.business.auth;

import android.app.Activity;
import android.content.ComponentName;

public class AuthConstants {
    public static final String CONSUMER_KEY = "630102789";
    public static final String CONSUMER_SECRET = "2fcefe3e80820c6ad53dff428970e2a4";
    public static final String EXTRA_WEIXIN_ERRMSG = "weixin_errmsg";
    public static final String EXTRA_WEIXIN_RESULT = "weixin_result";
    public static final String EXTRA_WEIXIN_USER_INFO = "weixin_user_info";
    public static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    public static final String SCOPE = "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog,invitation_write,upload_url_text";
    public static final String WEIXIN_APP_ID = "wxce5d9e837051d623";
    public static final String WEIXIN_APP_SECRET = "25a18bdaf8119c58c11b3c8fc1a6b6af";
    public static final String WEIXIN_REQ_TYPE_AUTH = "wxauth";
    public static final String WEIXIN_REQ_TYPE_SHARE = "wxshare";
    public static final int WEIXIN_TIMELINE_SUPPORTED_VERSION = 553779201;

    public static String genWeixinTransaction(String str, Activity activity) {
        ComponentName componentName = activity.getComponentName();
        return str + "-" + componentName.getPackageName() + "/" + componentName.getClassName();
    }
}
