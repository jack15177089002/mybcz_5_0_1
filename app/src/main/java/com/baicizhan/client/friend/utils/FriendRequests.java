//package com.baicizhan.client.friend.utils;
//
//import android.content.Context;
//import android.util.Log;
//import com.android.volley.DefaultRetryPolicy;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.event.BEvents.FriendTabRedDotEvent;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.GsonRequest;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.baicizhan.client.friend.model.FriendNotification;
//import com.baicizhan.client.friend.model.FriendRecord;
//import com.baicizhan.client.friend.model.FriendWeekLearnedInfo;
//import com.baicizhan.client.friend.model.GetLatestFeedTimeResult;
//import com.baicizhan.client.friend.utils.FriendEvents.FeedUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.FriendWeekUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.FriendsUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.NotificationUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendManager.SyncState;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.LinkedList;
//import org.json.JSONException;
//import org.json.JSONObject;
////import p000a.p001a.p002a.EventBus;
//
//public class FriendRequests {
//    public static void fetchFriends(final Context context) {
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_GET_FRIENDS);
//        try {
//            GsonRequest gsonRequest = new GsonRequest(1, FriendURL.getURL(FriendURL.ACTION_GET_FRIENDS), new TypeToken<Response<LinkedList<FriendRecord>>>() {
//            }.getType(), new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).toString(), new Listener<Response<LinkedList<FriendRecord>>>() {
//                public final void onResponse(Response<LinkedList<FriendRecord>> response) {
//                    if (response.getErrorInfo().getCode() == 0) {
//                        FriendManager.getInstance().setFriends((LinkedList) response.getTypedData());
//                        FriendManager.getInstance().setFriendSyncState(SyncState.SYNCED);
////                        EventBus.m0a().mo9c((Object) FriendsUpdateEvent.newInstance());
//                        return;
//                    }
//                    FriendManager.getInstance().setFriendSyncState(SyncState.UNSYNC);
//                }
//            }, new ErrorListener() {
//                public final void onErrorResponse(VolleyError volleyError) {
//                    FriendManager.reportError(context, volleyError);
//                    FriendManager.getInstance().setFriendSyncState(SyncState.UNSYNC);
//                }
//            });
//            gsonRequest.setTag(FriendURL.ACTION_GET_FRIENDS);
//            VolleyUtils.send(gsonRequest, new DefaultRetryPolicy(30000, 0, 0.0f));
//            FriendManager.getInstance().setFriendSyncState(SyncState.SYNCING);
//        } catch (JSONException e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//    }
//
//    public static void fetchNotifications(final Context context) {
//        try {
//            GsonRequest gsonRequest = new GsonRequest(1, FriendURL.getURL(FriendURL.ACTION_GET_NOTIFICATIONS), new TypeToken<Response<LinkedList<FriendNotification>>>() {
//            }.getType(), new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).toString(), new Listener<Response<LinkedList<FriendNotification>>>() {
//                public final void onResponse(Response<LinkedList<FriendNotification>> response) {
//                    if (response.getErrorInfo().getCode() == 0) {
//                        LinkedList linkedList = (LinkedList) response.getTypedData();
//                        if (linkedList.size() > 0 && FriendManager.getInstance().setNotifications(linkedList)) {
////                            EventBus.m0a().mo10d(NotificationUpdateEvent.newInstance());
//                            if (!FriendManager.getInstance().isInFriendTask()) {
////                                EventBus.m0a().mo9c((Object) new FriendTabRedDotEvent());
//                            }
//                        }
//                    }
//                }
//            }, new ErrorListener() {
//                public final void onErrorResponse(VolleyError volleyError) {
//                    FriendManager.reportError(context, volleyError);
//                }
//            });
//            gsonRequest.setTag(FriendURL.ACTION_GET_NOTIFICATIONS);
//            VolleyUtils.send(gsonRequest);
//        } catch (JSONException e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//    }
//
//    public static void checkHasNewFeeds() {
//        try {
//            GsonRequest gsonRequest = new GsonRequest(1, FriendURL.getURL(FriendURL.ACTION_GET_LATEST_FEED_TIME), new TypeToken<Response<GetLatestFeedTimeResult>>() {
//            }.getType(), new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).toString(), new Listener<Response<GetLatestFeedTimeResult>>() {
//                public final void onResponse(Response<GetLatestFeedTimeResult> response) {
//                    if (response.getErrorInfo().getCode() == 0) {
//                        GetLatestFeedTimeResult getLatestFeedTimeResult = (GetLatestFeedTimeResult) response.getTypedData();
//                        if (getLatestFeedTimeResult != null) {
//                            FriendManager instance = FriendManager.getInstance();
//                            int size = instance.getFeeds().size();
//                            if (!getLatestFeedTimeResult.hasNewFeeds()) {
//                                return;
//                            }
//                            if ((size == 0 && getLatestFeedTimeResult.getUpdateTime() > 0) || (size > 0 && getLatestFeedTimeResult.getUpdateTime() > instance.getLatestFeedTime())) {
////                                EventBus.m0a().mo10d(FeedUpdateEvent.newInstance());
////                                if (!FriendManager.getInstance().isInFriendTask()) {
////                                    EventBus.m0a().mo9c((Object) new FriendTabRedDotEvent());
////                                }
//                            }
//                        }
//                    }
//                }
//            }, new ErrorListener() {
//                public final void onErrorResponse(VolleyError volleyError) {
//                }
//            });
//            gsonRequest.setTag(FriendURL.ACTION_GET_NOTIFICATIONS);
//            VolleyUtils.send(gsonRequest);
//        } catch (JSONException e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//    }
//
//    public static void refreshWeekLearnedInfo(final Context context) {
//        try {
//            GsonRequest gsonRequest = new GsonRequest(1, FriendURL.getURL(FriendURL.ACTION_REFRESH_FRIENDS_LEARNED), new TypeToken<Response<LinkedList<FriendWeekLearnedInfo>>>() {
//            }.getType(), new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).toString(), new Listener<Response<LinkedList<FriendWeekLearnedInfo>>>() {
//                public final void onResponse(Response<LinkedList<FriendWeekLearnedInfo>> response) {
//                    if (response.getErrorInfo().getCode() == 0) {
//                        FriendManager.getInstance().refreshLearnedInfo((LinkedList) response.getTypedData());
////                        EventBus.m0a().mo9c((Object) FriendWeekUpdateEvent.newInstance());
//                    }
//                }
//            }, new ErrorListener() {
//                public final void onErrorResponse(VolleyError volleyError) {
//                    FriendManager.reportError(context, volleyError);
//                }
//            });
//            gsonRequest.setTag(FriendURL.ACTION_REFRESH_FRIENDS_LEARNED);
//            VolleyUtils.send(gsonRequest, new DefaultRetryPolicy(10000, 0, 0.0f));
//        } catch (JSONException e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//    }
//
//    public static void fetchInvitedList(final Context context) {
//        try {
//            GsonRequest gsonRequest = new GsonRequest(1, FriendURL.getURL(FriendURL.ACTION_GET_INVITED_FRIENDS), new TypeToken<Response<LinkedList<String>>>() {
//            }.getType(), new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).toString(), new Listener<Response<LinkedList<String>>>() {
//                public final void onResponse(Response<LinkedList<String>> response) {
//                    if (response.getErrorInfo().getCode() == 0) {
//                        FriendManager.getInstance().setInvitedList((LinkedList) response.getTypedData());
//                    }
//                }
//            }, new ErrorListener() {
//                public final void onErrorResponse(VolleyError volleyError) {
//                    FriendManager.reportError(context, volleyError);
//                }
//            });
//            gsonRequest.setTag(FriendURL.ACTION_GET_INVITED_FRIENDS);
//            VolleyUtils.send(gsonRequest, new DefaultRetryPolicy(10000, 0, 0.0f));
//        } catch (JSONException e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//    }
//}
