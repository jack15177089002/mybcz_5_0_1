//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.CircleProgressView;
//import com.jiongji.andriod.card.R;
//
//public class OfflineDownloadView extends LinearLayout {
//    private CircleProgressView mProgressView;
//    private ImageView mStateImage;
//    private TextView mTextView;
//
//    public OfflineDownloadView(Context context) {
//        this(context, null, 0);
//    }
//
//    public OfflineDownloadView(Context context, AttributeSet attributeSet) {
//        this(context, attributeSet, 0);
//    }
//
//    public OfflineDownloadView(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        LayoutInflater.from(context).inflate(R.layout.offline_download_view, this, true);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mStateImage = (ImageView) findViewById(R.id.state_image);
//        this.mProgressView = (CircleProgressView) findViewById(R.id.progress);
//        this.mTextView = (TextView) findViewById(R.id.text);
//    }
//
//    public void init() {
//        this.mStateImage.setVisibility(0);
//        this.mStateImage.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(getContext(), R.attr.drawable_download));
//        this.mProgressView.setVisibility(4);
//        this.mProgressView.setProgress(0);
//    }
//
//    public void pause() {
//        this.mStateImage.setVisibility(0);
//        this.mProgressView.setVisibility(4);
//        this.mStateImage.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(getContext(), R.attr.drawable_download_resume));
//    }
//
//    public void complete() {
//        this.mStateImage.setVisibility(0);
//        this.mProgressView.setVisibility(4);
//        this.mStateImage.setImageResource(ThemeUtil.getThemeResourceIdWithAttr(getContext(), R.attr.drawable_download_complete));
//    }
//
//    public void setProgress(int i) {
//        this.mStateImage.setVisibility(4);
//        this.mProgressView.setVisibility(0);
//        this.mProgressView.setProgress(i);
//    }
//
//    public void setText(CharSequence charSequence) {
//        this.mTextView.setText(charSequence);
//    }
//
//    public void setText(int i) {
//        this.mTextView.setText(i);
//    }
//}
