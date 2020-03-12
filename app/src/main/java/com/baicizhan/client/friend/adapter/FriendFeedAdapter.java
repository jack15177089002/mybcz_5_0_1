//package com.baicizhan.client.friend.adapter;
//
//import android.content.Context;
//import android.text.Html;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.model.FriendFeed;
//import com.baicizhan.client.friend.model.FriendRecord;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.widget.FriendFeedView;
//import com.jiongji.andriod.card.R;
////import com.p020b.p021a.JsonObject;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.List;
//import java.util.Locale;
//
//public class FriendFeedAdapter extends BaseAdapter {
//    private static DateFormat COARSE_FORMATTER = new SimpleDateFormat("MM月dd日", Locale.CHINA);
//    private static DateFormat FINE_FORMATTER = new SimpleDateFormat("HH:mm", Locale.CHINA);
//    private LayoutInflater mInflater;
//    private List<FriendFeed> mItems = Collections.emptyList();
//
//    public FriendFeedAdapter(Context context) {
//        this.mInflater = LayoutInflater.from(context);
//    }
//
//    public void update(List<FriendFeed> list) {
//        this.mItems = list;
//        notifyDataSetChanged();
//    }
//
//    private static String getMessageDateTime(FriendFeed friendFeed) {
//        Calendar instance = Calendar.getInstance();
//        instance.setTimeInMillis(System.currentTimeMillis());
//        Calendar instance2 = Calendar.getInstance();
//        instance2.setTimeInMillis(friendFeed.getUpdateTime());
//        int i = instance.get(6) - instance2.get(6);
//        if (instance.get(1) > instance2.get(1)) {
//            i += instance2.get(6);
//        }
//        if (i == 0) {
//            return FINE_FORMATTER.format(instance2.getTime());
//        }
//        if (i == 1) {
//            return "昨天";
//        }
//        if (i == 2) {
//            return "前天";
//        }
//        return COARSE_FORMATTER.format(instance2.getTime());
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
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View view2;
//        int i2;
//        if (view == null) {
//            view2 = this.mInflater.inflate(R.layout.friend_feed_item, viewGroup, false);
//        } else {
//            view2 = view;
//        }
//        FriendFeedView friendFeedView = (FriendFeedView) view2;
//        FriendFeed friendFeed = (FriendFeed) this.mItems.get(i);
////        JsonObject content = friendFeed.getContent();
////        if (content.mo3226a("body")) {
////            friendFeedView.setContent(Html.fromHtml(content.mo3227b("body").mo3081b()));
////        }
////        if (content.mo3226a("color")) {
////            friendFeedView.setMarkerColor(content.mo3227b("color").mo3084e());
////        }
////        if (content.mo3226a("publicKey")) {
////            String b = content.mo3227b("publicKey").mo3081b();
////            if (TextUtils.isEmpty(b)) {
////                friendFeedView.setThumb(R.drawable.friend_thumb_system);
////            } else {
////                FriendRecord findFriendOrSelf = FriendManager.getInstance().findFriendOrSelf(b);
////                friendFeedView.setThumb(findFriendOrSelf != null ? findFriendOrSelf.getImage() : "");
////            }
////        }
//        if (i == 0) {
//            i2 = 1;
//        } else {
//            i2 = 0;
//        }
//        if (i == getCount() - 1) {
//            i2 |= 2;
//        }
//        friendFeedView.setMarkerMode(i2);
//        friendFeedView.setDateTime(getMessageDateTime(friendFeed));
//        return view2;
//    }
//}
