package com.baicizhan.client.fight.customview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baicizhan.client.business.util.Aa.Callback;
import com.baicizhan.client.business.widget.CircleImageView;
//import com.baicizhan.client.fight.R;
import com.baicizhan.client.fight.VSManager;
import com.baicizhan.client.fight.jsonbean.UserInfo;
import com.baicizhan.client.fight.util.Events.OnSelectRival;
import com.baicizhan.client.fight.util.Events.OnSelectRival.Type;
import com.baicizhan.client.fight.util.VSUtils;
import com.jiongji.andriod.card.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import p000a.p001a.p002a.EventBus;

public class MatchOptsView extends ListView {
    public static final String TAG = "MatchOptsView";
    /* access modifiers changed from: private */
    public MatchOptionAdapter mAdapter;

    class MatchOptionAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflator;
        private List<UserInfo> mOptions = Collections.emptyList();
        private long mSelected;

        class ViewHolder {
            TextView mBook;
            TextView mChoose;
            TextView mDist;
            CircleImageView mImage;
            TextView mNickName;
            TextView mVocabulary;

            ViewHolder() {
            }
        }

        public MatchOptionAdapter(Context context) {
            this.mContext = context;
            this.mInflator = LayoutInflater.from(context);
        }

        private boolean isDataSetChanged(List<UserInfo> list) {
            if (this.mOptions.size() != list.size()) {
                return true;
            }
            for (int i = 0; i < this.mOptions.size(); i++) {
                if (!((UserInfo) this.mOptions.get(i)).equals(list.get(i))) {
                    return true;
                }
            }
            return false;
        }

        public void select(long j) {
            this.mSelected = j;
            if (j >= 0 && j < ((long) this.mOptions.size())) {
//                EventBus.m0a().mo9c((Object) new OnSelectRival(Type.TYPE_CHALLENGE, (UserInfo) this.mOptions.get((int) j)));
            }
            notifyDataSetChanged();
        }

        public void update(List<UserInfo> list) {
            if (isDataSetChanged(list)) {
                this.mSelected = -1;
                UserInfo rival = VSManager.getInstance().getRival();
                if (list != null && rival != null) {
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (rival.equals(list.get(i))) {
                            this.mSelected = (long) i;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (this.mSelected == -1) {
                    this.mOptions = list;
                } else {
                    this.mOptions = new ArrayList(list.size());
                    this.mOptions.add(list.get((int) this.mSelected));
                    for (int i2 = 0; ((long) i2) < this.mSelected; i2++) {
                        this.mOptions.add(list.get(i2));
                    }
                    int i3 = (int) this.mSelected;
                    while (true) {
                        i3++;
                        if (i3 >= list.size()) {
                            break;
                        }
                        this.mOptions.add(list.get(i3));
                    }
                    this.mSelected = 0;
                }
                notifyDataSetChanged();
            }
        }

        public int getCount() {
            return this.mOptions.size();
        }

        public Object getItem(int i) {
            return this.mOptions.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = this.mInflator.inflate(R.layout.fight_match_opt, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.mImage = (CircleImageView) view.findViewById(R.id.option_image);
                viewHolder.mChoose = (TextView) view.findViewById(R.id.option_choose);
                viewHolder.mNickName = (TextView) view.findViewById(R.id.option_nickname);
                viewHolder.mBook = (TextView) view.findViewById(R.id.option_book);
                viewHolder.mVocabulary = (TextView) view.findViewById(R.id.option_vocabulary);
                viewHolder.mDist = (TextView) view.findViewById(R.id.option_distance);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            UserInfo userInfo = (UserInfo) getItem(i);
            Context context = view.getContext();
//            Picasso.with(context).mo16306a((Object) viewHolder.mImage);
//            if (TextUtils.isEmpty(userInfo.getImage())) {
//                viewHolder.mImage.setImageResource(R.drawable.userinfo_photo_middle_normal_default);
//            } else {
//                Drawable drawable = viewHolder.mImage.getDrawable();
//                if (drawable != null) {
//                    RequestCreator b = Picasso.with(context).load(userInfo.getImage()).error(R.drawable.userinfo_photo_middle_normal_default);
//                    if (!b.f3710f) {
//                        throw new IllegalStateException("Already explicitly declared as no placeholder.");
//                    } else if (b.f3711g != 0) {
//                        throw new IllegalStateException("Placeholder image already set.");
//                    } else {
//                        b.f3712h = drawable;
//                        b.into((ImageView) viewHolder.mImage, (Callback) null);
//                    }
//                } else {
//                    Picasso.with(context).load(userInfo.getImage()).error(R.drawable.userinfo_photo_middle_normal_default).into((ImageView) viewHolder.mImage, (Callback) null);
//                }
//            }
            viewHolder.mDist.setText(VSUtils.getDisplayDistance(userInfo.getDistance()));
            viewHolder.mNickName.setText(userInfo.getDisplayName());
            String book = userInfo.getBook();
            if (!TextUtils.isEmpty(book)) {
                viewHolder.mBook.setVisibility(0);
                viewHolder.mBook.setText(book);
            } else {
                viewHolder.mBook.setVisibility(8);
            }
            int vocabulary = userInfo.getVocabulary();
            if (vocabulary > 0) {
                viewHolder.mVocabulary.setVisibility(0);
                viewHolder.mVocabulary.setText(String.valueOf(vocabulary));
            } else {
                viewHolder.mVocabulary.setVisibility(8);
            }
            if (this.mSelected == ((long) i)) {
                viewHolder.mImage.setBorderColor(this.mContext.getResources().getColor(R.color.fight_def_blue_color));
                viewHolder.mChoose.setSelected(true);
            } else {
                viewHolder.mImage.setBorderColor(this.mContext.getResources().getColor(R.color.fight_def_gray_color));
                viewHolder.mChoose.setSelected(false);
            }
            return view;
        }
    }

    public MatchOptsView(Context context) {
        this(context, null);
    }

    public MatchOptsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MatchOptsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAdapter = new MatchOptionAdapter(getContext());
        setAdapter(this.mAdapter);
        setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MatchOptsView.this.mAdapter.select((long) i);
            }
        });
    }

    public void update(List<UserInfo> list) {
        this.mAdapter.update(list);
    }

    public void clearSelection() {
        this.mAdapter.select(-1);
    }
}
