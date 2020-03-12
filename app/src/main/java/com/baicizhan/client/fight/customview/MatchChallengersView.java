//package com.baicizhan.client.fight.customview;
//
//import android.content.Context;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.PicassoUtil;
////import com.baicizhan.client.fight.R;
//import com.baicizhan.client.fight.VSManager;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.fight.util.Events.OnSelectRival;
//import com.baicizhan.client.fight.util.Events.OnSelectRival.Type;
//import com.baicizhan.client.fight.util.VSUtils;
//import com.jiongji.andriod.card.R;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Locale;
////import p000a.p001a.p002a.EventBus;
//
//public class MatchChallengersView extends LinearLayout {
//    private static final int MAX_SHOW_COUNT = 3;
//    /* access modifiers changed from: private */
//    public MatchChallengerAdapter mAdapter;
//    private ImageView mAvatarImage;
//    private TextView mAvatarNickname;
//    private View mBar;
//    private TextView mBook;
//    private ListView mList;
//    private int mListMaxHeight;
//    private View mTitle;
//    private TextView mVocabulary;
//
//    class MatchChallengerAdapter extends BaseAdapter {
//        private List<UserInfo> mChallengers = new LinkedList();
//        private Context mContext;
//        private LayoutInflater mInflater;
//        private long mSelected = -1;
//
//        class ViewHolder {
//            TextView accept;
//            TextView bookVocabulary;
//            TextView distance;
//            ImageView image;
//            TextView nickname;
//
//            ViewHolder() {
//            }
//        }
//
//        public MatchChallengerAdapter(Context context) {
//            this.mContext = context;
//            this.mInflater = LayoutInflater.from(context);
//        }
//
//        public void update(List<UserInfo> list) {
//            this.mChallengers = list;
//            this.mSelected = -1;
//            UserInfo rival = VSManager.getInstance().getRival();
//            if (list != null && rival != null) {
//                int i = 0;
//                while (true) {
//                    if (i >= list.size()) {
//                        break;
//                    } else if (rival.equals(list.get(i))) {
//                        this.mSelected = (long) i;
//                        break;
//                    } else {
//                        i++;
//                    }
//                }
//            }
//            notifyDataSetInvalidated();
//        }
//
//        public void select(long j) {
//            this.mSelected = j;
//            if (j >= 0 && j < ((long) this.mChallengers.size())) {
////                EventBus.m0a().mo9c((Object) new OnSelectRival(Type.TYPE_ACCEPT, (UserInfo) this.mChallengers.get((int) j)));
//            }
//            notifyDataSetChanged();
//        }
//
//        public int getCount() {
//            return this.mChallengers.size();
//        }
//
//        public Object getItem(int i) {
//            return this.mChallengers.get(i);
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            ViewHolder viewHolder;
//            if (view == null) {
//                view = this.mInflater.inflate(R.layout.fight_match_challenger_item, viewGroup, false);
//                viewHolder = new ViewHolder();
//                viewHolder.image = (ImageView) view.findViewById(R.id.challenger_image);
//                viewHolder.nickname = (TextView) view.findViewById(R.id.challenger_nickname);
//                viewHolder.bookVocabulary = (TextView) view.findViewById(R.id.challenger_book_vocab);
//                viewHolder.distance = (TextView) view.findViewById(R.id.challenger_distance);
//                viewHolder.accept = (TextView) view.findViewById(R.id.challenger_accept);
//                view.setTag(viewHolder);
//            } else {
//                viewHolder = (ViewHolder) view.getTag();
//            }
//            UserInfo userInfo = (UserInfo) this.mChallengers.get(i);
//            PicassoUtil.loadUserImage(this.mContext, viewHolder.image, userInfo.getImage());
//            viewHolder.nickname.setText(userInfo.getDisplayName());
//            viewHolder.bookVocabulary.setText(String.format(Locale.CHINA, "%s\n%s", new Object[]{userInfo.getBook(), VSUtils.getDisplayVocabulary(userInfo.getVocabulary())}));
//            viewHolder.distance.setText(VSUtils.getDisplayDistance(userInfo.getDistance()));
//            viewHolder.accept.setSelected(((long) i) == this.mSelected);
//            return view;
//        }
//    }
//
//    public MatchChallengersView(Context context) {
//        this(context, null);
//    }
//
//    public MatchChallengersView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        this.mListMaxHeight = 0;
//    }
//
//    /* access modifiers changed from: protected */
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        Context context = getContext();
//        this.mBook = (TextView) findViewById(R.id.book);
//        this.mVocabulary = (TextView) findViewById(R.id.vocabulary);
//        this.mAvatarImage = (ImageView) findViewById(R.id.me_image);
//        this.mAvatarNickname = (TextView) findViewById(R.id.me_nickname);
//        this.mTitle = findViewById(R.id.challenger_title);
//        this.mBar = findViewById(R.id.challenger_bar);
//        this.mList = (ListView) findViewById(R.id.challenger_list);
//        this.mAdapter = new MatchChallengerAdapter(context);
//        this.mList.setAdapter(this.mAdapter);
//        this.mList.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
//                MatchChallengersView.this.mAdapter.select((long) i);
//            }
//        });
//        this.mListMaxHeight = (context.getResources().getDimensionPixelSize(R.dimen.fight_friend_match_challenger_height) + this.mList.getDividerHeight()) * 3;
//    }
//
//    public void update(List<UserInfo> list) {
//        this.mAdapter.update(list);
//        if (list.size() == 0) {
//            this.mTitle.setVisibility(8);
//            this.mBar.setVisibility(8);
//            this.mList.setVisibility(8);
//            return;
//        }
//        this.mTitle.setVisibility(0);
//        this.mBar.setVisibility(0);
//        this.mList.setVisibility(0);
////        LayoutParams layoutParams = this.mList.getLayoutParams();
////        layoutParams.height = this.mListMaxHeight;
////        this.mList.setLayoutParams(layoutParams);
//    }
//
//    public void setAvatar(UserInfo userInfo) {
//        PicassoUtil.loadAccountUserImage(getContext(), Settings.getString(Settings.PREF_BAICIZHAN_PATH), userInfo.getImage(), this.mAvatarImage, R.drawable.userinfo_photo_normal_default);
//        this.mAvatarNickname.setText(userInfo.getDisplayName());
//    }
//
//    public void setBook(String str) {
//        if (!TextUtils.isEmpty(str)) {
//            this.mBook.setText(str);
//        } else {
//            this.mBook.setVisibility(8);
//        }
//    }
//
//    public void setVocabulary(int i) {
//        this.mVocabulary.setText(VSUtils.getDisplayVocabulary(i));
//    }
//
//    public void clearSelection() {
//        this.mAdapter.select(-1);
//    }
//}
