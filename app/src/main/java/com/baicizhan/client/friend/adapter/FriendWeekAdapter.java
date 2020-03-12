//package com.baicizhan.client.friend.adapter;
//
//import android.content.Context;
//import android.content.res.Resources;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.PicassoUtil;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.model.FriendRecord;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.jiongji.andriod.card.R;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Locale;
//
//public class FriendWeekAdapter extends BaseAdapter {
//    private static final int INDEX_LAST_WEEK = 0;
//    private static final int INDEX_THIS_WEEK = 1;
//    private static final int[] TROPHIES = {R.drawable.friend_trophy_gold, R.drawable.friend_trophy_silver, R.drawable.friend_trophy_bronze};
//    private static final int[] TROPHY_COLORS = new int[3];
//    private int mColorDT0;
//    private int mColorDT5;
//    private Comparator<FriendRecord> mComparator = new Comparator<FriendRecord>() {
//        public int compare(FriendRecord friendRecord, FriendRecord friendRecord2) {
//            return FriendWeekAdapter.this.getLearned(friendRecord2) - FriendWeekAdapter.this.getLearned(friendRecord);
//        }
//    };
//    private Context mContext;
//    private LayoutInflater mInflator;
//    private ArrayList<FriendRecord> mItems = new ArrayList<>();
//    private int mPageIndex;
//
//    class ViewHolder {
//        TextView learned;
//        TextView learnedLabel;
//        TextView name;
//        TextView number;
//        View parent;
//        ImageView thumb;
//        ImageView trophy;
//
//        ViewHolder() {
//        }
//    }
//
//    public FriendWeekAdapter(Context context, int i) {
//        this.mContext = context;
//        this.mInflator = LayoutInflater.from(context);
//        this.mPageIndex = i;
//        Resources resources = context.getResources();
//        this.mColorDT0 = resources.getColor(R.color.business_dt0);
//        this.mColorDT5 = resources.getColor(R.color.business_dt5);
//        TROPHY_COLORS[0] = resources.getColor(R.color.business_dt6);
//        TROPHY_COLORS[1] = resources.getColor(R.color.business_dt7);
//        TROPHY_COLORS[2] = resources.getColor(R.color.business_dt8);
//    }
//
//    public void update() {
//        this.mItems.clear();
//        FriendManager instance = FriendManager.getInstance();
//        this.mItems.addAll(instance.getFriends().values());
//        if (instance.getSelf() != null) {
//            this.mItems.add(instance.getSelf());
//        }
//        Collections.sort(this.mItems, this.mComparator);
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
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder viewHolder;
//        int i2;
//        if (view == null) {
//            view = this.mInflator.inflate(R.layout.friend_week_item, viewGroup, false);
//            viewHolder = new ViewHolder();
//            view.setTag(viewHolder);
//            viewHolder.parent = view;
//            viewHolder.trophy = (ImageView) view.findViewById(R.id.rank_trophy);
//            viewHolder.number = (TextView) view.findViewById(R.id.rank_number);
//            viewHolder.thumb = (ImageView) view.findViewById(R.id.thumb);
//            viewHolder.name = (TextView) view.findViewById(R.id.name);
//            viewHolder.learned = (TextView) view.findViewById(R.id.learned);
//            viewHolder.learnedLabel = (TextView) view.findViewById(R.id.learned_label);
//        } else {
//            viewHolder = (ViewHolder) view.getTag();
//        }
//        FriendRecord friendRecord = (FriendRecord) this.mItems.get(i);
//        if (i < TROPHIES.length) {
//            i2 = TROPHY_COLORS[i];
//            viewHolder.number.setVisibility(4);
//            viewHolder.trophy.setVisibility(0);
//            viewHolder.trophy.setImageDrawable(this.mContext.getResources().getDrawable(TROPHIES[i]));
//        } else {
//            i2 = this.mColorDT5;
//            viewHolder.number.setVisibility(0);
//            viewHolder.number.setText(Integer.toString(i + 1));
//            viewHolder.trophy.setImageDrawable(null);
//            viewHolder.trophy.setVisibility(4);
//        }
//        PicassoUtil.loadUserImage(this.mContext, viewHolder.thumb, friendRecord.getImage());
//        viewHolder.name.setText(friendRecord.getLocalName());
//        viewHolder.learned.setText(String.format(Locale.CHINA, "%d", new Object[]{Integer.valueOf(getLearned(friendRecord))}));
//        if (friendRecord.getPublicKey().equals(Settings.getString(Settings.PREF_USER_PUBLIC_KEY))) {
//            i2 = this.mColorDT0;
//            viewHolder.number.setTextColor(this.mColorDT0);
//            viewHolder.learned.setTextColor(this.mColorDT0);
//            viewHolder.learnedLabel.setTextColor(this.mColorDT0);
//            viewHolder.parent.setBackgroundColor(this.mColorDT5);
//        } else {
//            viewHolder.parent.setBackgroundColor(0);
//        }
//        viewHolder.name.setTextColor(i2);
//        viewHolder.number.setTextColor(i2);
//        viewHolder.learned.setTextColor(i2);
//        viewHolder.learnedLabel.setTextColor(i2);
//        return view;
//    }
//
//    public int getLearned(FriendRecord friendRecord) {
//        switch (this.mPageIndex) {
//            case 0:
//                return friendRecord.getLearnedLastWeek();
//            case 1:
//                return friendRecord.getLearned();
//            default:
//                return 0;
//        }
//    }
//}
