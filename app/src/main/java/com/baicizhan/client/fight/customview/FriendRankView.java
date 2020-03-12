//package com.baicizhan.client.fight.customview;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.res.Resources;
////import android.support.p004v4.app.FragmentActivity;
//import android.text.format.DateUtils;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.fragment.app.FragmentActivity;
//
//import com.android.volley.Request.Priority;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
////import com.baicizhan.client.fight.R;
//import com.baicizhan.client.fight.VSManager;
//import com.baicizhan.client.fight.jsonbean.FriendInfo;
//import com.baicizhan.client.fight.util.Constants;
//import com.baicizhan.client.fight.util.GsonRequest;
//import com.baicizhan.client.fight.util.VSRequest;
//import com.baicizhan.client.fight.util.VSRequest.OnResponseListener;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.handmark.pulltorefresh.library.C1624r;
//import com.handmark.pulltorefresh.library.PullToRefreshBase;
//import com.handmark.pulltorefresh.library.PullToRefreshListView;
//import com.jiongji.andriod.card.R;
//import com.p013a.p014a.p015a.BaseSwipeAdapter;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.LinkedList;
//
//public class FriendRankView extends LinearLayout {
//    /* access modifiers changed from: private */
//    public static final int[] RANKING_ALPHA_CYCLE = {153, 127, 102, 76, 51, 25};
//    private static final String TAG = "FriendRankView";
//    View mEmptyView;
//    FriendRankAdapter mFriendRankAdapter;
//    LinkedList<FriendInfo> mFriendRankList = null;
//    PullToRefreshListView mFriendRankListView;
//
//    class FriendRankAdapter extends BaseSwipeAdapter {
//        Context mContext;
//        LayoutInflater mInflater;
//
//        public FriendRankAdapter(Context context) {
//            this.mContext = context;
//            this.mInflater = LayoutInflater.from(context);
//        }
//
//        public int getCount() {
//            if (FriendRankView.this.mFriendRankList == null) {
//                return 0;
//            }
//            return FriendRankView.this.mFriendRankList.size();
//        }
//
//        public Object getItem(int i) {
//            return FriendRankView.this.mFriendRankList.get(i);
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public void fillValues(int i, View view) {
//            int i2;
//            FriendItemView friendItemView = (FriendItemView) view;
//            int i3 = FriendRankView.RANKING_ALPHA_CYCLE[FriendRankView.RANKING_ALPHA_CYCLE.length - 1];
//            if (i < FriendRankView.RANKING_ALPHA_CYCLE.length) {
//                i2 = FriendRankView.RANKING_ALPHA_CYCLE[i];
//            } else {
//                i2 = i3;
//            }
//            final FriendInfo friendInfo = (FriendInfo) getItem(i);
//            friendItemView.updateData(i, i2, friendInfo);
//            friendItemView.deleteFriend.setOnClickListener(new OnClickListener() {
//                public void onClick(View view) {
//                    FriendRankView.this.deleteFriend(friendInfo);
//                }
//            });
//        }
//
//        public View generateView(int i, ViewGroup viewGroup) {
//            return (FriendItemView) this.mInflater.inflate(R.layout.fight_friend_rank_item, viewGroup, false);
//        }
//
//        public int getSwipeLayoutResourceId(int i) {
//            return R.id.friend_item;
//        }
//    }
//
//    public FriendRankView(Context context) {
//        super(context);
//    }
//
//    public FriendRankView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mFriendRankListView = (PullToRefreshListView) findViewById(R.id.friend_rank_list);
//        this.mEmptyView = findViewById(R.id.friend_rank_empty);
//        this.mFriendRankListView.setEmptyView(this.mEmptyView);
//        this.mFriendRankAdapter = new FriendRankAdapter(getContext());
//        this.mFriendRankListView.setAdapter(this.mFriendRankAdapter);
////        this.mFriendRankListView.setOnRefreshListener((C1624r<T>) new C1624r<ListView>() {
////            public void onRefresh(PullToRefreshBase<ListView> gVar) {
////                gVar.getLoadingLayoutProxy().setLastUpdatedLabel(DateUtils.formatDateTime(FriendRankView.this.getContext(), System.currentTimeMillis(), 524305));
////                FriendRankView.this.refreshFriendRank();
////            }
////        });
//    }
//
//    public void refreshFriendRank() {
//        String friendRankUrl = Constants.getFriendRankUrl(VSManager.getInstance().getAvatar());
//        C0789L.log.debug("query friend rank, url:" + friendRankUrl);
//        GsonRequest gsonRequest = new GsonRequest(0, friendRankUrl, new TypeToken<Response<LinkedList<FriendInfo>>>() {
//        }.getType(), null, new Listener<Response<LinkedList<FriendInfo>>>() {
//            public void onResponse(Response<LinkedList<FriendInfo>> response) {
//                FriendRankView.this.mFriendRankList = (LinkedList) response.getData();
//                FriendRankView.this.mFriendRankAdapter.notifyDataSetChanged();
//                FriendRankView.this.mFriendRankListView.onRefreshComplete();
//            }
//        }, new ErrorListener() {
//            public void onErrorResponse(VolleyError volleyError) {
//                C0789L.log.debug("volley error " + volleyError.getMessage());
//                Toast.makeText(FriendRankView.this.getContext(), "网络不给力，请稍后重试", 0).show();
//                FriendRankView.this.mFriendRankListView.onRefreshComplete();
//                VSManager.getInstance().isInfoPanelSynced = false;
//            }
//        });
//        gsonRequest.setTag(TAG);
//        gsonRequest.setPriority(Priority.LOW);
//        VolleyUtils.send(gsonRequest);
//    }
//
//    /* access modifiers changed from: private */
//    public void deleteFriend(final FriendInfo friendInfo) {
////        if (((FragmentActivity) getContext()).getSupportFragmentManager().mo312a("DeleteFriend") == null) {
////            Resources resources = getContext().getResources();
////            BczDialog create = new Builder(getContext()).setMessage((CharSequence) resources.getString(R.string.fight_confirm_delete_friend)).setPositiveButton((CharSequence) resources.getString(R.string.fight_alert_dialog_ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
////                public void onClick(DialogInterface dialogInterface, int i) {
////                    FriendRankView.this.requestDeleteFriend(friendInfo);
////                }
////            }).setNegativeButton((CharSequence) resources.getString(R.string.fight_alert_dialog_cancel), (DialogInterface.OnClickListener) null).create();
////            create.setTag("DeleteFriend");
////            create.show();
////        }
//    }
//
//    /* access modifiers changed from: private */
//    public void requestDeleteFriend(final FriendInfo friendInfo) {
//        int i;
//        int i2 = 0;
//        while (true) {
//            i = i2;
//            if (i >= this.mFriendRankList.size()) {
//                i = -1;
//                break;
//            } else if (((FriendInfo) this.mFriendRankList.get(i)).getNickname().equals(friendInfo.getNickname())) {
//                break;
//            } else {
//                i2 = i + 1;
//            }
//        }
//        if (i != -1) {
//            this.mFriendRankList.remove(i);
//            for (Integer intValue : this.mFriendRankAdapter.getOpenItems()) {
//                this.mFriendRankAdapter.closeItem(intValue.intValue());
//            }
//            this.mFriendRankAdapter.closeAllExcept(null);
//            this.mFriendRankAdapter.notifyDataSetChanged();
//        }
////        new VSRequest(TAG, Constants.getRemoveFriendUrl(VSManager.getInstance().getAvatar(), friendInfo), new TypeToken<Response<String>>() {
////        }.getType(), (OnResponseListener<T>) new OnResponseListener<Object>() {
////            public boolean onResponse(ErrorInfo errorInfo, Object obj) {
////                C0789L.log.error("delete friend failed: " + friendInfo.toString() + "," + errorInfo.getMsg());
////                return true;
////            }
////        }, (ErrorListener) new ErrorListener() {
////            public void onErrorResponse(VolleyError volleyError) {
////                C0789L.log.error("delete friend failed: " + volleyError);
////            }
////        }).start();
//    }
//
//    public void onDestroy() {
//        VolleyUtils.cancelAllTagRequest(TAG);
//    }
//}
