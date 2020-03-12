//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.graphics.drawable.GradientDrawable;
//import android.text.style.ForegroundColorSpan;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.widget.FrameLayout;
//import android.widget.FrameLayout.LayoutParams;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.SimpleSpannableBuilder;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.ResidentBitmapCache;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import java.io.File;
//import java.util.List;
//
//public class SenToPicGuider extends FrameLayout implements OnClickListener {
//    private static final int OPTION_COUNT = 4;
//    private View mGuideTip;
//    private TextView mGuideTipText;
//    public OnGuideSelectListener mListener;
//    private ImageView[] mOptionImages = new ImageView[4];
//    private ImageView[] mOptionMasks = new ImageView[4];
//    private ViewGroup mOptions;
//    private List<TopicRecord> mTopicOptions;
//
//    class ExitListener implements OnClickListener {
//        private ExitListener() {
//        }
//
//        public void onClick(View view) {
//            SenToPicGuider.this.gone();
//        }
//    }
//
//    public interface OnGuideSelectListener {
//        void onGuidSelect(int i);
//    }
//
//    public SenToPicGuider(Context context) {
//        super(context);
//    }
//
//    public SenToPicGuider(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public SenToPicGuider(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        int dpToPx = DisplayUtils.dpToPx(getContext(), 4.0f);
//        int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_card_bg);
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(0);
//        gradientDrawable.setCornerRadius((float) dpToPx);
//        gradientDrawable.setColor(themeColorWithAttr);
//        this.mOptions = (ViewGroup) findViewById(R.id.option_container);
//        for (int i = 0; i < 4; i++) {
//            ViewGroup viewGroup = (ViewGroup) this.mOptions.getChildAt(i);
//            C1604j.m3631a(viewGroup, gradientDrawable);
//            this.mOptionImages[i] = (ImageView) viewGroup.getChildAt(0);
//            this.mOptionImages[i].setSoundEffectsEnabled(false);
//            this.mOptionMasks[i] = (ImageView) viewGroup.getChildAt(2);
//            viewGroup.getChildAt(1).setVisibility(8);
//        }
//        this.mGuideTip = findViewById(R.id.guide_tip);
//        this.mGuideTip.setOnClickListener(new ExitListener());
//        this.mGuideTipText = (TextView) findViewById(R.id.guide_tip_text);
//        ThemeResUtil.setShape(getContext(), this.mGuideTipText, getResources().getColor(R.color.C32), 4);
//        int themeColorWithAttr2 = ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_progress);
//        SimpleSpannableBuilder simpleSpannableBuilder = new SimpleSpannableBuilder();
//        simpleSpannableBuilder.append("请选择一个").append("最符合例句意思的图片。", new ForegroundColorSpan(themeColorWithAttr2));
//        this.mGuideTipText.setText(simpleSpannableBuilder.build());
//        setOnClickListener(new ExitListener());
//    }
//
//    public void gone() {
//        if (getVisibility() != 8) {
//            setVisibility(8);
//            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//            alphaAnimation.setDuration(200);
//            startAnimation(alphaAnimation);
//        }
//    }
//
//    public void onClick(View view) {
//        int intValue = ((Integer) view.getTag()).intValue();
//        this.mOptionMasks[intValue].setVisibility(0);
//        for (ImageView onClickListener : this.mOptionImages) {
//            onClickListener.setOnClickListener(null);
//        }
//        int i = ((TopicRecord) this.mTopicOptions.get(intValue)).topicId;
//        if (this.mListener != null) {
//            this.mListener.onGuidSelect(i);
//        }
//        gone();
//    }
//
//    public SenToPicGuider setOptionsRect(int i, int i2, int i3, int i4) {
//        if (this.mOptions != null) {
//            LayoutParams layoutParams = (LayoutParams) this.mOptions.getLayoutParams();
//            layoutParams.width = i3;
//            layoutParams.height = i4;
//            this.mOptions.setLayoutParams(layoutParams);
//            this.mOptions.setX((float) i);
//            this.mOptions.setY((float) i2);
//        }
//        return this;
//    }
//
//    public SenToPicGuider fillOptionContents(List<TopicRecord> list, List<Boolean> list2) {
//        if (!(this.mOptions == null || list == null || list.size() != 4 || list2 == null || list2.size() != 4)) {
//            this.mTopicOptions = list;
//            for (int i = 0; i < 4; i++) {
//                TopicRecord topicRecord = (TopicRecord) list.get(i);
//                boolean booleanValue = ((Boolean) list2.get(i)).booleanValue();
//                File baicizhanResourceFile = PathUtil.getBaicizhanResourceFile(topicRecord.imagePath);
//                this.mOptionImages[i].setImageDrawable(null);
//                Picasso.with(getContext()).load(baicizhanResourceFile).error(R.drawable.image_broke_normal_default).into(this.mOptionImages[i], (Callback) null);
//                this.mOptionImages[i].setTag(Integer.valueOf(i));
//                this.mOptionImages[i].setOnClickListener(this);
//                this.mOptionMasks[i].setVisibility(8);
//                ResidentBitmapCache.setImageResource(this.mOptionMasks[i], booleanValue ? R.drawable.right_big_normal_default : R.drawable.wrong_big_normal_default);
//            }
//        }
//        return this;
//    }
//
//    public SenToPicGuider setCallback(OnGuideSelectListener onGuideSelectListener) {
//        this.mListener = onGuideSelectListener;
//        return this;
//    }
//}
