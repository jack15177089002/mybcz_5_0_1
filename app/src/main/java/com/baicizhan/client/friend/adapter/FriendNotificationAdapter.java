//package com.baicizhan.client.friend.adapter;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.GsonRequest;
//import com.baicizhan.client.framework.network.VolleyUtils;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.model.FriendNotification;
//import com.baicizhan.client.friend.model.FriendRecord;
//import com.baicizhan.client.friend.utils.FriendEvents.FriendsUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.utils.FriendURL;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import org.json.JSONException;
//import org.json.JSONObject;
////import p000a.p001a.p002a.EventBus;
//
//public class FriendNotificationAdapter extends BaseAdapter {
//    public static final String TAG = FriendNotificationAdapter.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public Context mContext;
//    private LayoutInflater mInflater;
//    private List<FriendNotification> mItems = new ArrayList();
//    private HashSet<String> mTempInvited = new HashSet<>();
//    private HashSet<String> mTempRefused = new HashSet<>();
//
//    class ViewHolder {
//        View accept;
//        TextView name;
//        TextView placeholder;
//        View refuse;
//        TextView text1;
//        ImageView thumb;
//
//        ViewHolder() {
//        }
//    }
//
//    public FriendNotificationAdapter(Context context) {
//        this.mContext = context;
//        this.mInflater = LayoutInflater.from(context);
//    }
//
//    public void updateNotifications(List<FriendNotification> list) {
//        this.mItems.clear();
//        this.mItems.addAll(list);
//        notifyDataSetChanged();
//    }
//
//    public int getCount() {
//        return this.mItems.size();
//    }
//
//    public Object getItem(int i) {
//        return this.mItems.get(i);
//    }
//
//    public long getItemId(int i) {
//        return (long) i;
//    }
//
//    public View getView(final int i, View view, ViewGroup viewGroup) {
//        final ViewHolder viewHolder;
//        if (view == null) {
//            viewHolder = new ViewHolder();
//            view = this.mInflater.inflate(R.layout.friend_notification_item, viewGroup, false);
//            view.setTag(viewHolder);
//            viewHolder.thumb = (ImageView) view.findViewById(R.id.thumb);
//            viewHolder.name = (TextView) view.findViewById(R.id.name);
//            viewHolder.text1 = (TextView) view.findViewById(R.id.text1);
//            viewHolder.refuse = view.findViewById(R.id.refuse);
//            viewHolder.accept = view.findViewById(R.id.accept);
//            viewHolder.placeholder = (TextView) view.findViewById(R.id.placeholder);
//        } else {
//            viewHolder = (ViewHolder) view.getTag();
//        }
//        FriendNotification friendNotification = (FriendNotification) getItem(i);
//        PicassoUtil.loadUserImage(this.mContext, viewHolder.thumb, friendNotification.getSource().getImage());
//        viewHolder.name.setText(friendNotification.getSource().getLocalName());
//        if (this.mTempInvited.contains(friendNotification.getSource().getPublicKey())) {
//            finishOperation(viewHolder, R.string.friend_has_added);
//        } else if (this.mTempRefused.contains(friendNotification.getSource().getPublicKey())) {
//            finishOperation(viewHolder, R.string.friend_has_refused);
//        } else if (friendNotification.getMsgType() == FriendNotification.APPLY) {
//            enableOperations(viewHolder);
//            viewHolder.text1.setText(R.string.friend_peer_apply);
//            viewHolder.refuse.setOnClickListener(new OnClickListener() {
//                public void onClick(View view) {
//                    view.setSelected(true);
//                    view.setEnabled(false);
//                    FriendNotificationAdapter.this.refuse(viewHolder, i);
//                }
//            });
//            viewHolder.accept.setOnClickListener(new OnClickListener() {
//                public void onClick(View view) {
//                    view.setSelected(true);
//                    view.setEnabled(false);
//                    FriendNotificationAdapter.this.accept(viewHolder, i);
//                }
//            });
//        } else if (friendNotification.getMsgType() == FriendNotification.ACCEPT) {
//            disableOperations(viewHolder);
//            viewHolder.text1.setText(R.string.friend_peer_accept);
//        }
//        return view;
//    }
//
//    /* access modifiers changed from: private */
//    public void refuse(final ViewHolder viewHolder, int i) {
//        FriendNotification friendNotification = (FriendNotification) getItem(i);
//        if (friendNotification != null) {
//            String url = FriendURL.getURL(FriendURL.ACTION_IGNORE_FRIEND);
//            Type type = new TypeToken<Response<Object>>() {
//            }.getType();
//            String str = null;
//            try {
//                str = new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).put("from", friendNotification.getSource().getPublicKey()).toString();
//            } catch (JSONException e) {
//                C0789L.log.error(Log.getStackTraceString(e));
//            }
//            GsonRequest gsonRequest = new GsonRequest(1, url, type, str, new Listener<Response<Object>>() {
//                public void onResponse(Response<Object> response) {
//                    ErrorInfo errorInfo = response.getErrorInfo();
//                    if (errorInfo.getCode() < 0) {
//                        C0789L.log.error(errorInfo.getMsg());
//                    }
//                    FriendNotificationAdapter.this.finishOperation(viewHolder, R.string.friend_has_refused);
//                }
//            }, new ErrorListener() {
//                public void onErrorResponse(VolleyError volleyError) {
//                    FriendManager.reportError(FriendNotificationAdapter.this.mContext, volleyError);
//                    FriendNotificationAdapter.this.finishOperation(viewHolder, R.string.friend_has_refused);
//                }
//            });
//            gsonRequest.setTag(FriendURL.ACTION_IGNORE_FRIEND);
//            VolleyUtils.send(gsonRequest);
//            FriendManager.getInstance().getNotifications().remove(friendNotification);
//            this.mTempRefused.add(friendNotification.getSource().getPublicKey());
//            notifyDataSetChanged();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void accept(final ViewHolder viewHolder, int i) {
//        FriendNotification friendNotification = (FriendNotification) getItem(i);
//        String url = FriendURL.getURL(FriendURL.ACTION_ACCEPT_FRIEND);
//        Type type = new TypeToken<Response<FriendRecord>>() {
//        }.getType();
//        String str = null;
//        try {
//            str = new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).put("from", friendNotification.getSource().getPublicKey()).toString();
//        } catch (JSONException e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//        GsonRequest gsonRequest = new GsonRequest(1, url, type, str, new Listener<Response<FriendRecord>>() {
//            public void onResponse(Response<FriendRecord> response) {
//                ErrorInfo errorInfo = response.getErrorInfo();
//                if (errorInfo.getCode() == 0) {
//                    FriendNotificationAdapter.this.onAcceptFriend((FriendRecord) response.getTypedData());
//                    FriendNotificationAdapter.this.finishOperation(viewHolder, R.string.friend_has_added);
//                }
//                Toast.makeText(FriendNotificationAdapter.this.mContext, errorInfo.getMsg(), 0).show();
//            }
//        }, new ErrorListener() {
//            public void onErrorResponse(VolleyError volleyError) {
//                FriendManager.reportError(FriendNotificationAdapter.this.mContext, volleyError);
//                FriendNotificationAdapter.this.finishOperation(viewHolder, R.string.friend_has_added);
//            }
//        });
//        gsonRequest.setTag(FriendURL.ACTION_ACCEPT_FRIEND);
//        VolleyUtils.send(gsonRequest);
//        FriendManager.getInstance().getNotifications().remove(friendNotification);
//        this.mTempInvited.add(friendNotification.getSource().getPublicKey());
//    }
//
//    private void enableOperations(ViewHolder viewHolder) {
//        viewHolder.placeholder.setVisibility(4);
//        viewHolder.refuse.setVisibility(0);
//        viewHolder.accept.setVisibility(0);
//        viewHolder.refuse.setSelected(false);
//        viewHolder.accept.setSelected(false);
//        viewHolder.refuse.setEnabled(true);
//        viewHolder.accept.setEnabled(true);
//    }
//
//    private void disableOperations(ViewHolder viewHolder) {
//        viewHolder.placeholder.setVisibility(4);
//        viewHolder.refuse.setVisibility(4);
//        viewHolder.accept.setVisibility(4);
//    }
//
//    /* access modifiers changed from: private */
//    public void finishOperation(ViewHolder viewHolder, int i) {
//        viewHolder.placeholder.setVisibility(0);
//        viewHolder.placeholder.setText(i);
//        viewHolder.refuse.setVisibility(4);
//        viewHolder.accept.setVisibility(4);
//    }
//
//    /* access modifiers changed from: private */
//    public void onAcceptFriend(FriendRecord friendRecord) {
//        if (FriendManager.getInstance().addFriend(friendRecord)) {
////            EventBus.m0a().mo9c((Object) FriendsUpdateEvent.newInstance());
//        }
//    }
//}
