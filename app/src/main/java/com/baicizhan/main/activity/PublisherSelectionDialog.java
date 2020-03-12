//package com.baicizhan.main.activity;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.graphics.drawable.GradientDrawable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.AdapterView.OnItemSelectedListener;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.ColorStateListUtils;
//import com.baicizhan.client.business.util.PicassoUtil.Corners;
//import com.baicizhan.client.business.util.ThemeResUtil.ShapeDrawableBuilder;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import java.util.Collections;
//import java.util.List;
//import kankan.wheel.widget.OnWheelChangedListener;
//import kankan.wheel.widget.WheelView;
//import kankan.wheel.widget.p098a.AbstractWheelAdapter;
//
//public class PublisherSelectionDialog extends Dialog implements OnClickListener {
//    private static final String TAG = PublisherSelectionDialog.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public ArrayPickerAdapter mAdapter = new ArrayPickerAdapter(getContext());
//    private OnItemSelectedListener mOnItemSelectedListener;
//    /* access modifiers changed from: private */
//    public WheelView mWheel;
//
//    class ArrayPickerAdapter extends AbstractWheelAdapter {
//        private Context mContext;
//        private List<String> mItems = Collections.emptyList();
//        private int mNormalColor;
//        private int mSelected = -1;
//        private int mSelectedColor;
//
//        public ArrayPickerAdapter(Context context) {
//            this.mContext = context;
//            this.mSelectedColor = ThemeUtil.getThemeColorWithAttr(context, R.attr.color_progress);
//            this.mNormalColor = ThemeUtil.getThemeColorWithAttr(context, R.attr.color_type_box);
//        }
//
//        public void update(List<String> list) {
//            this.mItems = list;
//            notifyDataInvalidatedEvent();
//        }
//
//        public void notifySelected(int i) {
//            this.mSelected = i;
//            notifyDataChangedEvent();
//        }
//
//        public View getItem(int i, View view, ViewGroup viewGroup) {
//            TextView textView;
//            if (view == null) {
//                textView = new TextView(this.mContext);
//                textView.setLayoutParams(new LayoutParams(-1, DisplayUtils.dpToPx(this.mContext, 30.0f)));
//                textView.setGravity(17);
//                textView.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.T3));
//            } else {
//                textView = (TextView) view;
//            }
//            textView.setText((CharSequence) this.mItems.get(i));
//            if (i == this.mSelected) {
//                textView.setTextColor(this.mSelectedColor);
//            } else {
//                textView.setTextColor(this.mNormalColor);
//            }
//            return textView;
//        }
//
//        public int getItemsCount() {
//            return this.mItems.size();
//        }
//    }
//
//    public PublisherSelectionDialog(Context context) {
//        super(context, R.style.bczDialogStyle);
//        View inflate = LayoutInflater.from(context).inflate(R.layout.publisher_selection_dialog, null, false);
//        C1604j.m3631a(inflate.findViewById(R.id.title), getHeaderFooterBackground(context, Corners.TOP));
//        this.mWheel = (WheelView) inflate.findViewById(R.id.wheel);
//        this.mWheel.setVisibleItems(5);
//        this.mWheel.setWheelForeground(R.drawable.wheel_val_holo);
//        this.mWheel.setDrawShadows(false);
//        this.mWheel.setViewAdapter(this.mAdapter);
//        inflate.findViewById(R.id.placeholder).setBackgroundColor(context.getResources().getColor(R.color.C3));
//        TextView textView = (TextView) inflate.findViewById(R.id.ok);
//        textView.setTextColor(ColorStateListUtils.getSimpleThemeColorStateListWithAttr(context, R.attr.color_blue_btn, R.attr.color_blue_btn_pressed));
//        textView.setOnClickListener(this);
//        C1604j.m3631a(textView, getHeaderFooterBackground(context, Corners.BOTTOM));
//        setContentView(inflate);
//    }
//
//    private GradientDrawable getHeaderFooterBackground(Context context, Corners corners) {
//        return new ShapeDrawableBuilder().with(context).setColor(getContext().getResources().getColor(R.color.C33)).setCorners(4.0f, corners).build();
//    }
//
//    public void setPublishers(final int i, List<String> list) {
//        this.mAdapter.update(list);
//        this.mWheel.post(new Runnable() {
//            public void run() {
//                PublisherSelectionDialog.this.mWheel.setCurrentItem(i);
//                PublisherSelectionDialog.this.mAdapter.notifySelected(i);
//            }
//        });
//        this.mWheel.mo18385a((OnWheelChangedListener) new OnWheelChangedListener() {
//            public void onChanged(WheelView wheelView, int i, int i2) {
//                PublisherSelectionDialog.this.mAdapter.notifySelected(i2);
//            }
//        });
//    }
//
//    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
//        this.mOnItemSelectedListener = onItemSelectedListener;
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.ok) {
//            int currentItem = this.mWheel.getCurrentItem();
//            if (this.mOnItemSelectedListener != null) {
//                this.mOnItemSelectedListener.onItemSelected(null, null, currentItem, (long) currentItem);
//            }
//            dismiss();
//        }
//    }
//}
