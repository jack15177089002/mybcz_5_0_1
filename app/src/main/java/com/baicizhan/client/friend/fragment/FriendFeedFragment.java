//package com.baicizhan.client.friend.fragment;
//
//import android.content.Intent;
//import android.content.res.Resources;
//import android.os.Bundle;
////import android.support.p004v4.app.Fragment;
////import android.support.p004v4.app.FragmentActivity;
//import android.text.Html;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.business.util.ColorStateListUtils;
//import com.baicizhan.client.business.widget.RoundedButton;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.GsonRequest;
//import com.baicizhan.client.framework.network.VolleyUtils;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.activity.FriendSearchActivity;
//import com.baicizhan.client.friend.adapter.FriendFeedAdapter;
//import com.baicizhan.client.friend.model.FriendFeed;
//import com.baicizhan.client.friend.utils.FriendEvents.FeedUpdateEvent;
//import com.baicizhan.client.friend.utils.FriendEvents.FoldTitleBarEvent;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.utils.FriendURL;
//import com.baicizhan.client.friend.widget.DragWrapperLayout;
//import com.baicizhan.client.friend.widget.DragWrapperLayout.OnDetectDragListener;
//import com.baicizhan.client.friend.widget.FriendFeedView;
//import com.handmark.pulltorefresh.library.C1620n;
//import com.handmark.pulltorefresh.library.C1625s;
//import com.handmark.pulltorefresh.library.PullToRefreshBase;
//import com.handmark.pulltorefresh.library.PullToRefreshListView;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.ArrayList;
//import java.util.List;
//import org.json.JSONObject;
////import p000a.p001a.p002a.EventBus;
//
//public class FriendFeedFragment extends Fragment implements OnClickListener {
//    public static final String REQUEST_TAG;
//    public static final String TAG;
//    /* access modifiers changed from: private */
//    public FriendFeedAdapter mAdapter;
//    private List<String> mDefaultFeeds = null;
//    private ViewGroup mEmptyView;
//    /* access modifiers changed from: private */
//    public PullToRefreshListView mFeedView;
//
//    static {
//        String simpleName = FriendFeedFragment.class.getSimpleName();
//        TAG = simpleName;
//        REQUEST_TAG = simpleName;
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        int i;
//        DragWrapperLayout dragWrapperLayout = (DragWrapperLayout) layoutInflater.inflate(R.layout.friend_feed_fragment, viewGroup, false);
//        dragWrapperLayout.setOnDectectDragListener(new OnDetectDragListener() {
//            public void onDragUp() {
////                EventBus.m0a().mo9c((Object) new FoldTitleBarEvent(true));
//            }
//
//            public void onDragDown() {
////                EventBus.m0a().mo9c((Object) new FoldTitleBarEvent(false));
//            }
//        });
//        this.mFeedView = (PullToRefreshListView) dragWrapperLayout.findViewById(R.id.feeds);
//        this.mFeedView.setMode(C1620n.BOTH);
////        this.mFeedView.setOnRefreshListener((C1625s<T>) new C1625s<ListView>() {
////            public void onPullDownToRefresh(PullToRefreshBase<ListView> gVar) {
////                FriendFeedFragment.this.fetchFeeds(0);
////            }
////
////            public void onPullUpToRefresh(PullToRefreshBase<ListView> gVar) {
////                FriendFeedFragment.this.fetchFeeds(FriendManager.getInstance().getOldestFeedTime());
////            }
////        });
//        this.mAdapter = new FriendFeedAdapter(getActivity());
//        this.mFeedView.setAdapter(this.mAdapter);
//        this.mAdapter.update(FriendManager.getInstance().getFeeds());
//        this.mEmptyView = (ViewGroup) dragWrapperLayout.findViewById(R.id.empty_view);
//        RoundedButton roundedButton = (RoundedButton) this.mEmptyView.findViewById(R.id.add_friend);
//        initDefaultFeeds();
//        for (int i2 = 0; i2 < 2; i2++) {
//            FriendFeedView friendFeedView = (FriendFeedView) this.mEmptyView.getChildAt(i2);
//            friendFeedView.setContent(Html.fromHtml((String) this.mDefaultFeeds.get(i2)));
//            friendFeedView.setMarkerColor(-9780770);
//            if (i2 == 0) {
//                i = 1;
//            } else {
//                i = 2;
//            }
//            friendFeedView.setMarkerMode(i);
//            friendFeedView.setThumb(R.drawable.friend_thumb_system);
//        }
//        roundedButton.setOnClickListener(this);
//        roundedButton.setFillColor(ColorStateListUtils.getSimpleColorStateList(0, 342781550));
//        this.mEmptyView.setVisibility(8);
//        return dragWrapperLayout;
//    }
//
//    public void onDestroyView() {
//        super.onDestroyView();
//        VolleyUtils.cancelAllTagRequest(REQUEST_TAG);
//    }
//
//    public void onResume() {
//        boolean z = true;
//        super.onResume();
//        boolean z2 = false;
//        if (FriendManager.getInstance().getFeeds().size() == 0) {
//            z2 = true;
//        }
////        if (EventBus.m0a().mo3a(FeedUpdateEvent.class) != null) {
////            EventBus.m0a().mo7b(FeedUpdateEvent.class);
////        } else {
////            z = z2;
////        }
//        if (z) {
//            this.mFeedView.postDelayed(new Runnable() {
//                public void run() {
//                    FriendFeedFragment.this.mFeedView.setRefreshing(true);
//                    FriendFeedFragment.this.fetchFeeds(0);
//                }
//            }, 1000);
//        }
//    }
//
//    private void initDefaultFeeds() {
//        if (this.mDefaultFeeds == null) {
//            Resources resources = getActivity().getResources();
//            this.mDefaultFeeds = new ArrayList(2);
//            this.mDefaultFeeds.add(resources.getString(R.string.friend_default_empty_feed1));
//            this.mDefaultFeeds.add(resources.getString(R.string.friend_default_empty_feed2));
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void showEmtpyFeeds() {
//        this.mEmptyView.setVisibility(0);
//        this.mFeedView.setVisibility(8);
//    }
//
//    /* access modifiers changed from: private */
//    public void hideEmptyFeeds() {
//        this.mEmptyView.setVisibility(8);
//        this.mFeedView.setVisibility(0);
//    }
//
//    /* access modifiers changed from: private */
//    public void fetchFeeds(final long j) {
//        String jSONObject;
//        try {
//            String string = Settings.getString(Settings.PREF_USER_TOKEN);
//            if (j == 0) {
//                jSONObject = new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, string).put("offset", 0).toString();
//            } else {
//                jSONObject = new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, string).put("time", j).toString();
//            }
//            GsonRequest gsonRequest = new GsonRequest(1, j == 0 ? FriendURL.getURL(FriendURL.ACTION_GET_FEEDS) : FriendURL.getURL(FriendURL.ACTION_GET_FEEDS_BEFORE_TIME), new TypeToken<Response<List<FriendFeed>>>() {
//            }.getType(), jSONObject, new Listener<Response<List<FriendFeed>>>() {
//                public void onResponse(Response<List<FriendFeed>> response) {
//                    ErrorInfo errorInfo = response.getErrorInfo();
//                    if (errorInfo.getCode() == 0) {
//                        List list = (List) response.getTypedData();
//                        if (j == 0) {
//                            if ((list == null || list.size() == 0) && FriendManager.getInstance().getFriendNumber() == 0) {
//                                FriendFeedFragment.this.showEmtpyFeeds();
//                            } else {
//                                FriendManager.getInstance().setFeeds(list);
//                                FriendFeedFragment.this.hideEmptyFeeds();
//                                FriendFeedFragment.this.mAdapter.update(FriendManager.getInstance().getFeeds());
//                            }
//                        } else if (list.size() == 0) {
//                            Toast.makeText(FriendFeedFragment.this.getActivity(), R.string.friend_empty_older_feed, 0).show();
//                        } else {
//                            FriendManager.getInstance().appendFeeds(list);
//                            FriendFeedFragment.this.hideEmptyFeeds();
//                            FriendFeedFragment.this.mAdapter.update(FriendManager.getInstance().getFeeds());
//                        }
//                    } else {
//                        Toast.makeText(FriendFeedFragment.this.getActivity(), "获取动态失败:" + errorInfo.getMsg(), 0).show();
//                    }
//                    FriendFeedFragment.this.mFeedView.onRefreshComplete();
//                }
//            }, new ErrorListener() {
//                public void onErrorResponse(VolleyError volleyError) {
//                    if (FriendFeedFragment.this.getActivity() != null) {
//                        FriendManager.reportError(FriendFeedFragment.this.getActivity(), volleyError);
//                        FriendFeedFragment.this.mFeedView.onRefreshComplete();
//                    }
//                }
//            });
//            gsonRequest.setTag(REQUEST_TAG);
//            VolleyUtils.send(gsonRequest);
//        } catch (Exception e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.add_friend) {
//            FragmentActivity activity = getActivity();
//            activity.startActivity(new Intent(activity, FriendSearchActivity.class));
//        }
//    }
//}
