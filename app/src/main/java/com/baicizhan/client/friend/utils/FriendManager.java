//package com.baicizhan.client.friend.utils;
//
//import android.content.Context;
//import android.os.Handler;
//import android.os.Looper;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.Toast;
//import com.android.volley.TimeoutError;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.event.BEvents.FriendTabRedDotEvent;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.framework.BaseAppHandler;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.baicizhan.client.friend.model.FriendFeed;
//import com.baicizhan.client.friend.model.FriendNotification;
//import com.baicizhan.client.friend.model.FriendRecord;
//import com.baicizhan.client.friend.model.FriendWeekLearnedInfo;
//import com.baicizhan.client.friend.utils.FriendEvents.FeedUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.FriendsUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.NotificationUpdateEvent;
//import com.baicizhan.client.push.PushManager;
//import com.baicizhan.client.push.PushManager.PushListener;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import org.json.JSONException;
//import org.json.JSONObject;
////import p000a.p001a.p002a.EventBus;
//
//public class FriendManager {
//    private static final long POLLING_SYNC_INTERVAL = 600000;
//    /* access modifiers changed from: private */
//    public static final Gson sGson = new Gson();
//    /* access modifiers changed from: private */
//    public static Handler sHandler = new Handler(Looper.getMainLooper());
//    private static FriendManager sInstance = null;
//    private List<FriendFeed> mFeeds = new LinkedList();
//    private LinkedHashMap<String, FriendRecord> mFriendMap = new LinkedHashMap<>();
//    private SyncState mFriendSyncState = SyncState.UNSYNC;
//    private HashSet<String> mInvitedFriends = new HashSet<>();
//    private boolean mIsBackgroundJobsRunning = false;
//    private boolean mIsInFriendTask = false;
//    private PushListener mNotificationListener = new PushListener() {
//        public void onPush(String str, String str2, JSONObject jSONObject) {
//            try {
////                if (str.equals(PushManager.MSGTYPE_IGNORE_FRIEND)) {
////                    FriendManager.getInstance().removeInvited(jSONObject.getString("publicKey"));
////                    return;
////                }
////                FriendRecord friendRecord = (FriendRecord) FriendManager.sGson.fromJson(jSONObject.toString(), new TypeToken<FriendRecord>() {
////                }.getType());
////                FriendNotification friendNotification = new FriendNotification();
////                if (str.equals(PushManager.MSGTYPE_APPLY_FRIEND)) {
////                    friendNotification.setMsgType(FriendNotification.APPLY);
////                } else if (str.equals(PushManager.MSGTYPE_ACCEPT_FRIEND)) {
////                    friendNotification.setMsgType(FriendNotification.ACCEPT);
////                    if (FriendManager.this.addFriend(friendRecord)) {
////                        EventBus.m0a().mo9c((Object) FriendsUpdateEvent.newInstance());
////                    }
////                    FriendManager.this.removeInvited(friendRecord.getPublicKey());
////                }
////                friendNotification.setSource(friendRecord);
////                if (FriendManager.this.addNotification(friendNotification)) {
////                    EventBus.m0a().mo10d(NotificationUpdateEvent.newInstance());
////                    if (!FriendManager.this.isInFriendTask()) {
////                        EventBus.m0a().mo9c((Object) new FriendTabRedDotEvent());
////                    }
////                    C0789L.log.info("post NotificationUpdateEvent on push");
////                }
//            } catch (Exception e) {
//                C0789L.log.error(Log.getStackTraceString(e));
//            }
//        }
//    };
//    private LinkedList<FriendNotification> mNotifications = new LinkedList<>();
//    private Runnable mPollingSyncRunnable = new Runnable() {
//        public void run() {
//            VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_HAS_NEW_FEEDS);
//            FriendRequests.checkHasNewFeeds();
//            FriendManager.sHandler.postDelayed(this, FriendManager.POLLING_SYNC_INTERVAL);
//        }
//    };
//    private FriendRecord mSelf;
//    private List<FriendRecord> mSuggestFriends = new LinkedList();
//
//    public enum SyncState {
//        UNSYNC,
//        SYNCING,
//        SYNCED
//    }
//
//    public static FriendManager getInstance() {
//        if (sInstance == null) {
//            synchronized (FriendManager.class) {
//                if (sInstance == null) {
//                    sInstance = new FriendManager();
//                }
//            }
//        }
//        return sInstance;
//    }
//
//    public static void reportError(Context context, VolleyError volleyError) {
//        C0789L.log.error(volleyError.toString() + VolleyUtils.statusCodeFromVolleyError(volleyError));
//        if (volleyError instanceof TimeoutError) {
//            Toast.makeText(context, "请求超时，请检查网络", 0).show();
//        } else {
//            Toast.makeText(context, "网络不给力", 0).show();
//        }
//    }
//
//    public synchronized void reset() {
//        this.mFriendSyncState = SyncState.UNSYNC;
//        this.mFriendMap.clear();
//        this.mSuggestFriends.clear();
//        this.mFeeds.clear();
//        this.mNotifications.clear();
//        this.mInvitedFriends.clear();
////        EventBus.m0a().mo7b(FeedUpdateEvent.class);
////        EventBus.m0a().mo7b(NotificationUpdateEvent.class);
//    }
//
//    public synchronized void startFriendBackgroundJobs() {
//        if (!this.mIsBackgroundJobsRunning) {
//            C0789L.log.info("startFriendBackgroundJobs");
//            this.mIsBackgroundJobsRunning = true;
//            registerFriendPushListeners();
//            sHandler.post(this.mPollingSyncRunnable);
//            PushManager.getInstance().login(BaseAppHandler.getApp(), Settings.getString(Settings.PREF_USER_EMAIL));
//        }
//    }
//
//    public synchronized void stopFriendBackgroundJobs() {
//        if (this.mIsBackgroundJobsRunning) {
//            this.mIsBackgroundJobsRunning = false;
//            C0789L.log.info("stopFriendBackgroundJobs");
//            unregisterFriendPushListeners();
//            sHandler.removeCallbacksAndMessages(null);
//            PushManager.getInstance().logout(BaseAppHandler.getApp());
//        }
//    }
//
//    public boolean isInFriendTask() {
//        return this.mIsInFriendTask;
//    }
//
//    public synchronized void setIsInFriendTask(boolean z) {
//        this.mIsInFriendTask = z;
//    }
//
//    public SyncState getFriendSyncState() {
//        return this.mFriendSyncState;
//    }
//
//    public synchronized void setFriendSyncState(SyncState syncState) {
//        this.mFriendSyncState = syncState;
//    }
//
//    public FriendRecord getSelf() {
//        return this.mSelf;
//    }
//
//    public synchronized void setSelf(FriendRecord friendRecord) {
//        this.mSelf = friendRecord;
//    }
//
//    public Map<String, FriendRecord> getFriends() {
//        return this.mFriendMap;
//    }
//
//    public int getFriendNumber() {
//        return this.mFriendMap.size();
//    }
//
//    public synchronized void setFriends(List<FriendRecord> list) {
//        this.mFriendMap.clear();
//        this.mSelf = null;
//        String string = Settings.getString(Settings.PREF_USER_PUBLIC_KEY);
//        for (FriendRecord friendRecord : list) {
//            if (friendRecord.getPublicKey().equals(string)) {
//                setSelf(friendRecord);
//            } else {
//                this.mFriendMap.put(friendRecord.getPublicKey(), friendRecord);
//            }
//        }
//        Settings.putInt(Settings.PREF_FRIENDS_NUM, getFriendNumber());
//    }
//
//    public synchronized boolean addFriend(FriendRecord friendRecord) {
//        boolean z;
//        if (friendRecord != null) {
//            if (this.mFriendMap.get(friendRecord.getPublicKey()) == null) {
//                this.mFriendMap.put(friendRecord.getPublicKey(), friendRecord);
//                Settings.putInt(Settings.PREF_FRIENDS_NUM, getFriendNumber());
//                z = true;
//            }
//        }
//        z = false;
//        return z;
//    }
//
//    public synchronized boolean removeFriend(FriendRecord friendRecord) {
//        boolean z;
//        if (((FriendRecord) this.mFriendMap.remove(friendRecord.getPublicKey())) == null) {
//            z = false;
//        } else {
//            Settings.putInt(Settings.PREF_FRIENDS_NUM, getFriendNumber());
//            z = true;
//        }
//        return z;
//    }
//
//    public FriendRecord findFriend(String str) {
//        return (FriendRecord) this.mFriendMap.get(str);
//    }
//
//    public FriendRecord findFriendOrSelf(String str) {
//        if (this.mSelf == null || !TextUtils.equals(this.mSelf.getPublicKey(), str)) {
//            return (FriendRecord) this.mFriendMap.get(str);
//        }
//        return this.mSelf;
//    }
//
//    public synchronized void refreshLearnedInfo(LinkedList<FriendWeekLearnedInfo> linkedList) {
//        Iterator it = linkedList.iterator();
//        while (it.hasNext()) {
//            FriendWeekLearnedInfo friendWeekLearnedInfo = (FriendWeekLearnedInfo) it.next();
//            if (friendWeekLearnedInfo != null) {
//                if (this.mSelf == null || !friendWeekLearnedInfo.getPublicKey().equals(this.mSelf.getPublicKey())) {
//                    FriendRecord findFriend = findFriend(friendWeekLearnedInfo.getPublicKey());
//                    if (findFriend != null) {
//                        findFriend.setLearned(friendWeekLearnedInfo.getLearned());
//                        findFriend.setLearnedLastWeek(friendWeekLearnedInfo.getLearnedLastWeek());
//                    }
//                } else {
//                    this.mSelf.setLearned(friendWeekLearnedInfo.getLearned());
//                    this.mSelf.setLearnedLastWeek(friendWeekLearnedInfo.getLearnedLastWeek());
//                }
//            }
//        }
//    }
//
//    public List<FriendRecord> getSuggestFriends() {
//        return this.mSuggestFriends;
//    }
//
//    public synchronized void setSuggestFriends(List<FriendRecord> list) {
//        this.mSuggestFriends = list;
//    }
//
//    public List<FriendFeed> getFeeds() {
//        return this.mFeeds;
//    }
//
//    public synchronized void setFeeds(List<FriendFeed> list) {
//        this.mFeeds = list;
//    }
//
//    public synchronized void appendFeeds(List<FriendFeed> list) {
//        this.mFeeds.addAll(list);
//    }
//
//    public long getLatestFeedTime() {
//        if (this.mFeeds.size() == 0) {
//            return 0;
//        }
//        return ((FriendFeed) this.mFeeds.get(0)).getUpdateTime();
//    }
//
//    public long getOldestFeedTime() {
//        if (this.mFeeds.size() == 0) {
//            return System.currentTimeMillis();
//        }
//        return ((FriendFeed) this.mFeeds.get(this.mFeeds.size() - 1)).getUpdateTime();
//    }
//
//    public LinkedList<FriendNotification> getNotifications() {
//        return this.mNotifications;
//    }
//
//    public synchronized boolean setNotifications(LinkedList<FriendNotification> linkedList) {
//        boolean z;
//        boolean z2;
//        z = false;
//        Iterator it = linkedList.iterator();
//        while (it.hasNext()) {
//            if (isNewNotification((FriendNotification) it.next())) {
//                z2 = true;
//            } else {
//                z2 = z;
//            }
//            z = z2;
//        }
//        this.mNotifications = linkedList;
//        return z;
//    }
//
//    public boolean isNewNotification(FriendNotification friendNotification) {
//        if (this.mNotifications.contains(friendNotification)) {
//            return false;
//        }
//        if (friendNotification.getMsgType() != FriendNotification.APPLY || findFriend(friendNotification.getSource().getPublicKey()) == null) {
//            return true;
//        }
//        return false;
//    }
//
//    public synchronized boolean addNotification(FriendNotification friendNotification) {
//        boolean z;
//        if (isNewNotification(friendNotification)) {
//            this.mNotifications.addFirst(friendNotification);
//            z = true;
//        } else {
//            z = false;
//        }
//        return z;
//    }
//
//    public synchronized void setInvitedList(List<String> list) {
//        this.mInvitedFriends.clear();
//        this.mInvitedFriends.addAll(list);
//    }
//
//    public synchronized void addInvited(String str) {
//        this.mInvitedFriends.add(str);
//    }
//
//    public boolean hasInvited(String str) {
//        return this.mInvitedFriends.contains(str);
//    }
//
//    public synchronized void removeInvited(String str) {
//        this.mInvitedFriends.remove(str);
//    }
//
//    public synchronized void registerFriendPushListeners() {
//        PushManager instance = PushManager.getInstance();
//        instance.registerPushListener(PushManager.MSGTYPE_APPLY_FRIEND, this.mNotificationListener);
//        instance.registerPushListener(PushManager.MSGTYPE_ACCEPT_FRIEND, this.mNotificationListener);
//        instance.registerPushListener(PushManager.MSGTYPE_IGNORE_FRIEND, this.mNotificationListener);
//    }
//
//    public synchronized void unregisterFriendPushListeners() {
//        PushManager instance = PushManager.getInstance();
//        instance.unregisterPushListener(PushManager.MSGTYPE_APPLY_FRIEND, this.mNotificationListener);
//        instance.unregisterPushListener(PushManager.MSGTYPE_ACCEPT_FRIEND, this.mNotificationListener);
//        instance.unregisterPushListener(PushManager.MSGTYPE_IGNORE_FRIEND, this.mNotificationListener);
//    }
//}
