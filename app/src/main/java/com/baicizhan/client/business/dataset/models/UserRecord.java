//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import android.text.TextUtils;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZLOGINUSER.Columns;
////import com.baicizhan.client.wordtesting.activity.VocabStatsActivity;
//import java.util.Map;
//
//public class UserRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    public static final int LOGIN_EMAIL = 0;
//    public static final int LOGIN_RENREN = 2;
//    public static final int LOGIN_TRY = 3;
//    public static final int LOGIN_WEIBO = 1;
//    public static final int LOGIN_WEIXIN = 4;
//    public static final int SAVE_STATUS_CURRENT = 1;
//    public static final int SAVE_STATUS_NULL = 0;
//    public static final int SAVE_STATUS_TRY_BIND = 2;
//    public static final int SEX_FEMALE = 2;
//    public static final int SEX_MALE = 1;
//    public static final int SEX_UNKNOWN = 3;
//    public static final String[] VERBOSE_LOGIN_TYPES = {"邮箱", "微博", "人人", "试用", "微信"};
//    private transient String email;
//    private String image;
//    private transient int isNewUser;
//    private int loginType;
//    private String nickName = "";
//    private transient int oauthAccountId;
//    private String password;
//    private String passwordMD5;
//    private transient String publicKey;
//    private int saveStatus;
//    private int sex = 3;
//    private String token;
//    private String user;
//    private transient int vocabulary;
//
//    static {
//        ArrayMap aVar = new ArrayMap();
//        COLUMN_MAP = aVar;
////        aVar.put(VocabStatsActivity.EXTRA_USER, Columns.USER);
//        COLUMN_MAP.put("token", Columns.ZSESSION);
//        COLUMN_MAP.put("loginType", Columns.ZLOGINTYPE);
//        COLUMN_MAP.put("password", Columns.ZPASSWORD);
//        COLUMN_MAP.put("passwordMD5", Columns.ZPASSWORDMD5);
//        COLUMN_MAP.put("image", Columns.ZPROFILEIMAGE);
//        COLUMN_MAP.put("sex", Columns.ZSEX);
//        COLUMN_MAP.put("nickName", Columns.ZUSERNICKNAME);
//        COLUMN_MAP.put("saveStatus", Columns.ZSAVESTATUS);
//    }
//
//    public String getUser() {
//        return this.user;
//    }
//
//    public void setUser(String str) {
//        this.user = str;
//    }
//
//    public String getToken() {
//        return this.token;
//    }
//
//    public void setToken(String str) {
//        this.token = str;
//    }
//
//    public int getLoginType() {
//        return this.loginType;
//    }
//
//    public String getVerboseLoginType() {
//        return VERBOSE_LOGIN_TYPES[this.loginType];
//    }
//
//    public void setLoginType(int i) {
//        this.loginType = i;
//    }
//
//    public String getPassword() {
//        return this.password;
//    }
//
//    public void setPassword(String str) {
//        this.password = str;
//    }
//
//    public String getPasswordMD5() {
//        return this.passwordMD5;
//    }
//
//    public void setPasswordMD5(String str) {
//        this.passwordMD5 = str;
//    }
//
//    public String getImage() {
//        if (this.image == null) {
//            return "";
//        }
//        return this.image;
//    }
//
//    public void setImage(String str) {
//        this.image = str;
//    }
//
//    public int getSex() {
//        return this.sex;
//    }
//
//    public String getVerboseSex() {
//        if (this.sex == 1) {
//            return "少侠";
//        }
//        if (this.sex == 2) {
//            return "女侠";
//        }
//        return "蒙面侠";
//    }
//
//    public void setSex(int i) {
//        this.sex = i;
//    }
//
//    public String getNickName() {
//        return this.nickName;
//    }
//
//    public void setNickName(String str) {
//        this.nickName = str;
//    }
//
//    public String getDisplayName() {
//        if (TextUtils.isEmpty(this.nickName)) {
//            return this.user;
//        }
//        return this.nickName;
//    }
//
//    public int getSaveStatus() {
//        return this.saveStatus;
//    }
//
//    public void setSaveStatus(int i) {
//        this.saveStatus = i;
//    }
//
//    public int getVocabulary() {
//        return this.vocabulary;
//    }
//
//    public void setVocabulary(int i) {
//        this.vocabulary = i;
//    }
//
//    public int getIsNewUser() {
//        return this.isNewUser;
//    }
//
//    public void setIsNewUser(int i) {
//        this.isNewUser = i;
//    }
//
//    public String getPublicKey() {
//        return this.publicKey;
//    }
//
//    public void setPublicKey(String str) {
//        this.publicKey = str;
//    }
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public void setEmail(String str) {
//        this.email = str;
//    }
//
//    public int getOauthAccountId() {
//        return this.oauthAccountId;
//    }
//
//    public void setOauthAccountId(int i) {
//        this.oauthAccountId = i;
//    }
//
//    public String toString() {
//        return "UserRecord [user=" + this.user + ", token=" + this.token + ", loginType=" + this.loginType + ", password=" + this.password + ", passwordMD5=" + this.passwordMD5 + ", image=" + this.image + ", sex=" + this.sex + ", nickName=" + this.nickName + ", saveStatus=" + this.saveStatus + ", isNewUser=" + this.isNewUser + ", publicKey=" + this.publicKey + ", email=" + this.email + ", oauthAccountId=" + this.oauthAccountId + "]";
//    }
//}
