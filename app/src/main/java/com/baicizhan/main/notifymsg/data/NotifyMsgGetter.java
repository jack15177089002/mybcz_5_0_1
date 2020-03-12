//package com.baicizhan.main.notifymsg.data;
//
//import android.content.Context;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.online.bs_users.BBSysNotification;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
//public class NotifyMsgGetter {
//    public static final int ERR_NO_NETWORKS = -1;
//    public static final int ERR_NO_NEW = -3;
//    public static final int ERR_SERVER = -2;
//    private static final int LOAD_COUNT_PER_LOOP = 10;
//    public static final int NO_ERR = 0;
//    public static final int TYPE_NORMAL = 0;
//    public static final int TYPE_PULL = 2;
//    public static final int TYPE_REFRESH = 1;
//    public static final int TYPE_UPDATE = 3;
//    /* access modifiers changed from: private */
//    public WeakReference<Context> mContext;
//    /* access modifiers changed from: private */
//    public OnNotifyMsgGetListener mListener;
//
//    public interface OnNotifyMsgGetListener {
//        void onGetNotifyMsg(List<NotifyMsgRecord> list, int i, boolean z, int i2);
//    }
//
//    class Params {
//        /* access modifiers changed from: private */
//        public int errCode;
//        /* access modifiers changed from: private */
//        public boolean online;
//        /* access modifiers changed from: private */
//        public List<NotifyMsgRecord> records;
//        /* access modifiers changed from: private */
//        public int type;
//
//        private Params() {
//            this.type = -1;
//            this.online = false;
//            this.errCode = 0;
//        }
//    }
//
//    private NotifyMsgGetter(Context context) {
//        this.mContext = new WeakReference<>(context);
//    }
//
//    public static NotifyMsgGetter born(Context context) {
//        return new NotifyMsgGetter(context);
//    }
//
//    public NotifyMsgGetter setListener(OnNotifyMsgGetListener onNotifyMsgGetListener) {
//        this.mListener = onNotifyMsgGetListener;
//        return this;
//    }
//
//    public void getNotifyMsg(final int i, final int i2) {
//        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Params>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Params doInBackground(Client client) {
//                Context context = (Context) NotifyMsgGetter.this.mContext.get();
//                if (context == null) {
//                    return null;
//                }
//                Params params = new Params();
//                params.type = i;
//                if (3 == i) {
//                    NotifyMsgGetter.update(context, params, client);
//                    params.records = NotifyMsgGetter.getFromLocal(context, i2);
//                } else if (1 == i || 2 == i) {
//                    NotifyMsgGetter.refresh(context, params, i, client);
//                    if (i != 2) {
//                        params.records = NotifyMsgGetter.getFromLocal(context, i2);
//                    }
//                } else {
//                    params.records = NotifyMsgGetter.getFromLocal(context, i2);
//                    if (params.records == null || params.records.isEmpty()) {
//                        NotifyMsgGetter.refresh(context, params, i, client);
//                        params.records = NotifyMsgGetter.getFromLocal(context, i2);
//                    }
//                }
//                return params;
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                if (NotifyMsgGetter.this.mListener != null) {
//                    NotifyMsgGetter.this.mListener.onGetNotifyMsg(null, -1, false, -2);
//                }
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Params params) {
//                if (params == null) {
//                    if (NotifyMsgGetter.this.mListener != null) {
//                        NotifyMsgGetter.this.mListener.onGetNotifyMsg(null, -1, false, 0);
//                    }
//                } else if (NotifyMsgGetter.this.mListener != null) {
//                    NotifyMsgGetter.this.mListener.onGetNotifyMsg(params.records, params.type, params.online, params.errCode);
//                }
//            }
//        });
//    }
//
//    /* access modifiers changed from: private */
//    public static boolean refresh(Context context, Params params, int i, Client client) {
//        if (!NetworkUtils.isNetworkAvailable(context)) {
//            params.errCode = -1;
//            return false;
//        }
//        List fromOnline = getFromOnline(context, params, client);
//        if (fromOnline == null || fromOnline.isEmpty()) {
//            params.errCode = -3;
//        } else if (i != 2) {
//            saveToLocal(context, fromOnline);
//        }
//        return true;
//    }
//
//    /* access modifiers changed from: private */
//    public static void update(Context context, Params params, Client client) {
//        if (NetworkUtils.isSmoothNetwork(context)) {
//            NotifyMsgRecordHelper.updateNotifyMsgsContent(context, adaptFrom(client.get_sys_notifications(0)));
//            params.online = true;
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public static List<NotifyMsgRecord> getFromLocal(Context context, int i) {
//        return NotifyMsgRecordHelper.getNotifyMsgs(context, i + 10);
//    }
//
//    private static List<NotifyMsgRecord> getFromOnline(Context context, Params params, Client client) {
//        params.online = true;
//        return adaptFrom(client.get_sys_notifications(NotifyMsgRecordHelper.getMaxTime(context)));
//    }
//
//    private static List<NotifyMsgRecord> adaptFrom(List<BBSysNotification> list) {
//        if (list == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList(list.size());
//        for (BBSysNotification bBSysNotification : list) {
//            NotifyMsgRecord notifyMsgRecord = new NotifyMsgRecord();
//            notifyMsgRecord.setId(bBSysNotification.f2419id);
//            notifyMsgRecord.setType(bBSysNotification.notification_type);
//            notifyMsgRecord.setTitle(bBSysNotification.title);
//            notifyMsgRecord.setTitleDesc(bBSysNotification.title_desc);
//            notifyMsgRecord.setImgUrl(bBSysNotification.img_url);
//            notifyMsgRecord.setContentUrl(bBSysNotification.content);
//            notifyMsgRecord.setIsHidden(bBSysNotification.is_hidden);
//            notifyMsgRecord.setTime(bBSysNotification.time);
//            arrayList.add(notifyMsgRecord);
//        }
//        return arrayList;
//    }
//
//    private static void saveToLocal(Context context, List<NotifyMsgRecord> list) {
//        NotifyMsgRecordHelper.saveNotifyMsgs(context, list);
//    }
//}
