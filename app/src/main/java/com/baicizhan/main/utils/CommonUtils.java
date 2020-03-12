//package com.baicizhan.main.utils;
//
//import android.app.ActivityManager;
//import android.app.ActivityManager.RunningTaskInfo;
//import android.content.Context;
//import android.content.Intent;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.KVHelper;
//import com.baicizhan.client.business.dataset.helpers.UserRecordHelper;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.BookListManager;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlayErrorListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlaySateListener;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.main.DemoApp;
//import com.baicizhan.main.auth.ThirdPartyUserInfo;
//import com.baicizhan.main.auth.WeixinLogin;
//import com.baicizhan.online.bs_users.BB3PartyUserInfo;
////import com.baicizhan.online.bs_users.BBLoginResult;
////import com.baicizhan.online.bs_users.BBOtherLoginResult;
////import com.baicizhan.online.bs_users.BSUsers.Client;
////import com.baicizhan.online.structs.BELogicException;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import com.tencent.android.tpush.common.Constants;
//import java.io.File;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Locale;
//import java.util.Set;
//import org.p100a.p101a.TApplicationException;
//import org.p100a.p101a.p107f.C2120g;
//
//public class CommonUtils {
//    private static final String BOOK_WORD_FORMAT = "%d单词";
//    private static final int MD5_SUBSTRACT_LEN = 9;
//    private static final int MD5_SUBSTRACT_POS = 12;
//    public static final long MINIMAL_AVAILABLE_BYTES = 10485760;
//    public static final long MINIMAL_AVAILABLE_MEGABYTES = 10;
//    private static final String TAG = CommonUtils.class.getSimpleName();
//    public static final long WARNING_AVAILABLE_BYTES = 31457280;
//    public static final long WARNING_AVAILABLE_MEGABYTES = 30;
////    private static ThriftRequest<Client, UserRecord> mLoginRequest;
//
//    public static boolean isApplicationRunningForeground(Context context) {
//        String packageName = context.getPackageName();
//        try {
//            for (RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningTasks(1)) {
//                LogWrapper.m2793d(TAG, "info.topActivity " + runningTaskInfo.topActivity.toString());
//                if (runningTaskInfo.topActivity.getPackageName().equals(packageName) && !runningTaskInfo.topActivity.getClassName().contains("wordlock")) {
//                    return true;
//                }
//            }
//            return false;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
////    public static void login(Context context, Client client, UserRecord userRecord, int i) {
////        try {
////            int loginType = userRecord.getLoginType();
////            switch (loginType) {
////                case 0:
////                case 3:
////                    String upperCase = userRecord.getPasswordMD5().substring(12, 21).toUpperCase(Locale.US);
////                    LogWrapper.m2793d(TAG, "email login " + userRecord.getUser() + ", digest " + upperCase);
////                    BBLoginResult login = client.login(userRecord.getUser(), upperCase);
////                    userRecord.setToken(login.getAccess_token());
////                    userRecord.setIsNewUser(login.getIs_new_user());
////                    userRecord.setPublicKey(login.getPublic_key());
////                    userRecord.setEmail(login.getEmail());
////                    BookListManager.getInstance().setRemoteBookListVersion(login.getUpdate_at_of_book_info());
////                    break;
////                case 1:
////                case 2:
////                case 4:
////                    ThirdPartyUserInfo thirdPartyLoginCache = getThirdPartyLoginCache(context);
////                    LogWrapper.m2793d(TAG, "third party login " + thirdPartyLoginCache);
////                    if (thirdPartyLoginCache != null && thirdPartyLoginCache.loginType == loginType) {
////                        if (thirdPartyLoginCache.loginType == 4 && thirdPartyLoginCache.isExpired()) {
////                            LogWrapper.m2793d(TAG, "try refresh weixin token ");
////                            if (WeixinLogin.waitRefreshAccessToken(thirdPartyLoginCache)) {
////                                saveThirdPartyLoginCache(context, thirdPartyLoginCache);
////                            }
////                        }
////                        BB3PartyUserInfo bB3PartyUserInfo = new BB3PartyUserInfo();
////                        bB3PartyUserInfo.setUid(thirdPartyLoginCache.uid);
////                        bB3PartyUserInfo.setOpenid(thirdPartyLoginCache.openid);
////                        bB3PartyUserInfo.setUnionid(thirdPartyLoginCache.unionid);
////                        bB3PartyUserInfo.setNickname(thirdPartyLoginCache.nickName);
////                        bB3PartyUserInfo.setAtoken(thirdPartyLoginCache.atoken);
////                        bB3PartyUserInfo.setGender(thirdPartyLoginCache.gender);
////                        bB3PartyUserInfo.setImage_url(thirdPartyLoginCache.imageUrl);
////                        bB3PartyUserInfo.setExpires_at(Long.toString(thirdPartyLoginCache.expireAt));
////                        BBOtherLoginResult other_login = client.other_login(thirdPartyLoginCache.provider, bB3PartyUserInfo, i);
////                        userRecord.setOauthAccountId(other_login.getOauth_account_id());
////                        userRecord.setToken(other_login.getUser_login_info().getAccess_token());
////                        userRecord.setIsNewUser(other_login.getUser_login_info().getIs_new_user());
////                        userRecord.setPublicKey(other_login.getUser_login_info().getPublic_key());
////                        userRecord.setEmail(other_login.getUser_login_info().getEmail());
////                        userRecord.setNickName(thirdPartyLoginCache.nickName);
////                        BookListManager.getInstance().setRemoteBookListVersion(other_login.getUser_login_info().getUpdate_at_of_book_info());
////                        break;
////                    } else {
////                        throw new Exception("Unavailable third-party info " + thirdPartyLoginCache);
////                    }
////                    break;
////                default:
////                    throw new Exception("Invalid login type");
////            }
////            UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
////            if (currentUser == null || !TextUtils.equals(currentUser.getToken(), userRecord.getToken())) {
////                BookRecordHelper.clearPersonalData(context);
////            } else {
////                UserRecordHelper.clearAllSaveStatus(context);
////            }
////            userRecord.setSaveStatus(1);
////            UserRecordHelper.saveUserRecord(context, userRecord);
////            LogWrapper.m2795i(TAG, "login success: " + userRecord);
////            if (userRecord.getIsNewUser() > 0) {
////                Log.i(TAG, "isNewUser open guide flags");
////                Settings.putInt(Settings.PREF_GUIDE_FLAGS, 1);
////            }
////            StudyManager.getInstance().setCurrentUser(userRecord);
////        } catch (Exception e) {
////            LogWrapper.m2793d(TAG, "login exception" + e.getMessage());
////            if (!(e instanceof C2120g)) {
////                LogWrapper.m2794e(TAG, "clearThirdPartyLoginCache");
////                clearThirdPartyLoginCache(context);
////            }
////            throw e;
////        }
////    }
//
////    public static void login(Context context, UserRecord userRecord, AuthCallback<UserRecord> authCallback, int i) {
////        if (mLoginRequest != null) {
////            mLoginRequest.cancel();
////        }
////        final Context context2 = context;
////        final UserRecord userRecord2 = userRecord;
////        final int i2 = i;
////        final AuthCallback<UserRecord> authCallback2 = authCallback;
////        mLoginRequest = new ThriftRequest<Client, UserRecord>(BaicizhanThrifts.USERS) {
////            /* access modifiers changed from: protected */
////            public final UserRecord doInBackground(Client client) {
//////                CommonUtils.login(context2, client, userRecord2, i2);
////                return userRecord2;
////            }
////
////            /* access modifiers changed from: protected */
////            public final void onError(Exception exc) {
////                authCallback2.postError(exc);
////            }
////
////            /* access modifiers changed from: protected */
////            public final void onResult(UserRecord userRecord) {
////                authCallback2.postSuccess(userRecord);
////            }
////        };
////        BaicizhanThrifts.getProxy().add(mLoginRequest);
////    }
//
//    public static void logout(Context context) {
//        StudyManager.getInstance().clearPersonalData();
//        FriendManager.getInstance().reset();
//        FriendManager.getInstance().stopFriendBackgroundJobs();
//        BaicizhanThrifts.getProxy().removeCookie(BaicizhanCookieInflator.ACCESS_TOKEN);
//        clearThirdPartyLoginCache(context);
//        BookRecordHelper.clearPersonalData(context);
//    }
//
//    public static ThirdPartyUserInfo getThirdPartyLoginCache(Context context) {
//        return (ThirdPartyUserInfo) KVHelper.getJsonBean(context, KVHelper.KEY_USER_THIRD_PARTY_INFO, new TypeToken<ThirdPartyUserInfo>() {
//        }.getType(), false);
//    }
//
//    public static UserRecord thirdPartyInfoToUserRecord(ThirdPartyUserInfo thirdPartyUserInfo) {
//        UserRecord userRecord = new UserRecord();
//        userRecord.setUser(thirdPartyUserInfo.nickName);
//        userRecord.setNickName(thirdPartyUserInfo.nickName);
//        userRecord.setImage(thirdPartyUserInfo.imageUrl);
//        if (TextUtils.equals(thirdPartyUserInfo.gender, ThirdPartyUserInfo.GENDER_MALE)) {
//            userRecord.setSex(1);
//        } else if (TextUtils.equals(thirdPartyUserInfo.gender, ThirdPartyUserInfo.GENDER_FEMALE)) {
//            userRecord.setSex(2);
//        } else {
//            userRecord.setSex(3);
//        }
//        userRecord.setLoginType(thirdPartyUserInfo.loginType);
//        userRecord.setPassword("");
//        userRecord.setPasswordMD5("");
//        return userRecord;
//    }
//
//    public static void saveThirdPartyLoginCache(Context context, ThirdPartyUserInfo thirdPartyUserInfo) {
//        KVHelper.setJsonBean(context, KVHelper.KEY_USER_THIRD_PARTY_INFO, thirdPartyUserInfo, new TypeToken<ThirdPartyUserInfo>() {
//        }.getType(), false);
//    }
//
//    public static void clearThirdPartyLoginCache(Context context) {
//        WeixinLogin.clearLastLoginInfo();
//        KVHelper.deleteKey(context, KVHelper.KEY_USER_THIRD_PARTY_INFO);
//    }
//
//    public static int getBookRemainCount(BookRecord bookRecord) {
//        LearnRecordManager instance = LearnRecordManager.getInstance();
//        StudyManager instance2 = StudyManager.getInstance();
//        if (bookRecord.bookId == instance.getBookId() && bookRecord.bookId == instance2.getCurrentBookId() && instance2.getRoadmapSize() > 0) {
//            return instance.getRemainCountIncludeToday();
//        }
//        return bookRecord.wordCount - bookRecord.finishCount;
//    }
//
//    public static BczLoadingDialog createProgressDialog(Context context) {
//        BczLoadingDialog bczLoadingDialog = new BczLoadingDialog(context);
//        bczLoadingDialog.setCancelable(true);
//        return bczLoadingDialog;
//    }
//
//    public static boolean playBaicizhanAudio(AudioPlayer audioPlayer, String str, OnPlaySateListener onPlaySateListener) {
//        return playBaicizhanAudio(audioPlayer, str, onPlaySateListener, null);
//    }
//
//    public static boolean playBaicizhanAudio(AudioPlayer audioPlayer, String str, OnPlaySateListener onPlaySateListener, OnPlayErrorListener onPlayErrorListener) {
//        if (audioPlayer == null) {
//            return false;
//        }
//        File baicizhanResourceFile = PathUtil.getBaicizhanResourceFile(str);
//        if (baicizhanResourceFile == null || !baicizhanResourceFile.exists()) {
//            return false;
//        }
//        audioPlayer.newPlay(baicizhanResourceFile.getAbsolutePath());
//        audioPlayer.setOnPlaySateListener(onPlaySateListener);
//        audioPlayer.setOnPlayErrorListener(onPlayErrorListener);
//        return true;
//    }
//
//    public static Set<Integer> computeRelatedTopics(Collection<Integer> collection) {
//        HashSet hashSet = new HashSet();
//        for (Integer intValue : collection) {
//            int intValue2 = intValue.intValue();
//            hashSet.add(Integer.valueOf(intValue2));
//            for (int valueOf : StudyManager.getInstance().getTopicOptionsById(intValue2)) {
//                hashSet.add(Integer.valueOf(valueOf));
//            }
//        }
//        return hashSet;
//    }
//
//    public static String getThriftErrorMsg(Context context, Throwable th) {
////        if (th instanceof BELogicException) {
////            return th.getMessage();
////        }
////        if (th instanceof C2120g) {
////            return context.getString(R.string.network_error_retry_later);
////        }
//        if (th instanceof TApplicationException) {
//            return th.getMessage();
//        }
//        LogWrapper.m2794e(TAG, th.getClass() + ", " + Log.getStackTraceString(th));
//        return th.getMessage();
//    }
//
//    public static void toastThriftErrorMsg(Context context, Throwable th) {
//        Toast.makeText(context, getThriftErrorMsg(context, th), 0).show();
//    }
//
//    public static void toastStudyDataError(Context context) {
//        Toast.makeText(context, R.string.study_data_error, 0).show();
//    }
//
//    public static String getBookWordDesc(int i) {
//        return String.format(Locale.CHINA, BOOK_WORD_FORMAT, new Object[]{Integer.valueOf(i)});
//    }
//
//    public static boolean ensureNetworkAvailable(Context context) {
//        if (NetworkUtils.isNetworkAvailable(context)) {
//            return true;
//        }
//        Toast.makeText(context, "离线不支持该功能，请联网后再使用", 0).show();
//        return false;
//    }
//
//    public static void killAllProcess(Context context) {
//        LogWrapper.m2793d(TAG, "killAllProcess " + context);
//        context.sendBroadcast(new Intent(DemoApp.BROADCAST_ACTION_EXIT_APP));
//    }
//}
