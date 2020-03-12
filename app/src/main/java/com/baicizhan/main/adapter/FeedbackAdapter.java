//package com.baicizhan.main.adapter;
//
//import android.content.Context;
//import android.content.res.Resources;
//import android.graphics.drawable.BitmapDrawable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.RelativeLayout.LayoutParams;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.business.view.RotatingImageView;
//import com.baicizhan.client.business.widget.CircleImageView;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Picasso;
//import com.umeng.p094b.p095a.Reply;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//import p000a.p001a.p002a.EventBus;
//
//public class FeedbackAdapter extends BaseAdapter {
//    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA);
//    private Context mContext;
//    private BitmapDrawable mDevAvatar;
//    private LayoutInflater mInflater;
//    private OnClickListener mListener = new OnClickListener() {
//        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.feedback_status_icon /*2131296438*/:
//                    ((Reply) view.getTag()).f5492g = "will_sent";
//                    EventBus.m0a().mo9c((Object) new RetryEvent());
//                    return;
//                default:
//                    return;
//            }
//        }
//    };
//    private List<Reply> mMsgList = new ArrayList();
//    private String mUserAvatar;
//
//    public class RetryEvent {
//        public RetryEvent() {
//        }
//    }
//
//    class ViewHolder {
//        CircleImageView avatar;
//        TextView date;
//        TextView msgContent;
//        RotatingImageView statusIcon;
//
//        ViewHolder() {
//        }
//    }
//
//    public FeedbackAdapter(Context context, String str) {
//        this.mContext = context;
//        this.mInflater = LayoutInflater.from(context);
//        this.mUserAvatar = str;
//    }
//
//    public void setMsgList(List<Reply> list) {
//        this.mMsgList.clear();
//        if (list != null) {
//            this.mMsgList.addAll(list);
//        }
//    }
//
//    public int getCount() {
//        return this.mMsgList.size();
//    }
//
//    public Object getItem(int i) {
//        return this.mMsgList.get(i);
//    }
//
//    public long getItemId(int i) {
//        return (long) i;
//    }
//
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        if (view == null) {
//            view = generateItemView();
//        }
//        Reply iVar = (Reply) this.mMsgList.get(i);
//        setItemLayout(view, "dev_reply".endsWith(iVar.f5488c));
//        ViewHolder viewHolder = (ViewHolder) view.getTag();
//        viewHolder.date.setText(DATE_FORMAT.format(new Date(iVar.f5491f)));
//        viewHolder.msgContent.setText(iVar.f5486a);
//        if ("sent".equals(iVar.f5492g)) {
//            viewHolder.statusIcon.setVisibility(4);
//        } else {
//            viewHolder.statusIcon.setVisibility(0);
//            if ("not_sent".equals(iVar.f5492g)) {
//                viewHolder.statusIcon.clearAnimation();
//                viewHolder.statusIcon.setSelected(true);
//                viewHolder.statusIcon.setOnClickListener(this.mListener);
//                viewHolder.statusIcon.setIsRotate(false);
//                viewHolder.statusIcon.setTag(iVar);
//            } else {
//                viewHolder.statusIcon.setSelected(false);
//                viewHolder.statusIcon.setOnClickListener(null);
//                viewHolder.statusIcon.setIsRotate(true);
//                viewHolder.statusIcon.setTag(null);
//            }
//        }
//        return view;
//    }
//
//    private void setItemLayout(View view, boolean z) {
//        ViewHolder viewHolder = (ViewHolder) view.getTag();
//        LayoutParams layoutParams = (LayoutParams) viewHolder.avatar.getLayoutParams();
//        LayoutParams layoutParams2 = (LayoutParams) viewHolder.msgContent.getLayoutParams();
//        LayoutParams layoutParams3 = (LayoutParams) viewHolder.statusIcon.getLayoutParams();
//        Resources resources = this.mContext.getResources();
//        if (z) {
//            layoutParams.leftMargin = DisplayUtils.dpToPx(this.mContext, 20.0f);
//            layoutParams.rightMargin = 0;
//            layoutParams.addRule(11, 0);
//            layoutParams.addRule(9);
//            layoutParams2.leftMargin = DisplayUtils.dpToPx(this.mContext, 10.0f);
//            layoutParams2.rightMargin = DisplayUtils.dpToPx(this.mContext, 20.0f);
//            layoutParams2.addRule(0, 0);
//            layoutParams2.addRule(1, R.id.feedback_item_avatar);
//            layoutParams3.addRule(0, 0);
//            layoutParams3.addRule(1, R.id.feedback_item_textcontent);
//            Picasso.with(this.mContext).mo16306a((Object) viewHolder.avatar);
//            viewHolder.avatar.setImageDrawable(getDevAvatar(resources));
//            viewHolder.msgContent.setBackgroundResource(R.drawable.chat_blue_normal_default);
//            return;
//        }
//        layoutParams.leftMargin = 0;
//        layoutParams.rightMargin = DisplayUtils.dpToPx(this.mContext, 20.0f);
//        layoutParams.addRule(9, 0);
//        layoutParams.addRule(11);
//        layoutParams2.leftMargin = DisplayUtils.dpToPx(this.mContext, 20.0f);
//        layoutParams2.rightMargin = DisplayUtils.dpToPx(this.mContext, 10.0f);
//        layoutParams2.addRule(1, 0);
//        layoutParams2.addRule(0, R.id.feedback_item_avatar);
//        layoutParams3.addRule(0, R.id.feedback_item_textcontent);
//        layoutParams3.addRule(1, 0);
//        PicassoUtil.loadUserImage(this.mContext, viewHolder.avatar, this.mUserAvatar);
//        viewHolder.msgContent.setBackgroundResource(R.drawable.chat_green_normal_default);
//    }
//
//    private View generateItemView() {
//        View inflate = this.mInflater.inflate(R.layout.feedback_list_item, null);
//        ViewHolder viewHolder = new ViewHolder();
//        viewHolder.date = (TextView) inflate.findViewById(R.id.feedback_item_date);
//        viewHolder.avatar = (CircleImageView) inflate.findViewById(R.id.feedback_item_avatar);
//        viewHolder.msgContent = (TextView) inflate.findViewById(R.id.feedback_item_textcontent);
//        viewHolder.statusIcon = (RotatingImageView) inflate.findViewById(R.id.feedback_status_icon);
//        inflate.setTag(viewHolder);
//        return inflate;
//    }
//
//    private BitmapDrawable getDevAvatar(Resources resources) {
//        if (this.mDevAvatar == null) {
//            this.mDevAvatar = PicassoUtil.flip(resources, (BitmapDrawable) resources.getDrawable(R.drawable.guo_normal_default));
//        }
//        return this.mDevAvatar;
//    }
//}
