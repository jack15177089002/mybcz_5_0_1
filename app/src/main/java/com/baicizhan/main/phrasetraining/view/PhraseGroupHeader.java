//package com.baicizhan.main.phrasetraining.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.widget.CommentCircleProgressView;
//import com.baicizhan.main.phrasetraining.data.IDownloadController;
//import com.baicizhan.main.phrasetraining.data.load.MultiPhraseLoader;
//import com.baicizhan.main.phrasetraining.data.load.MultiPhraseLoader.Builder;
//import com.baicizhan.main.phrasetraining.data.load.MultiPhraseLoader.OnMultiPhraseLoadListener;
//import com.jiongji.andriod.card.R;
//import java.util.List;
//
//public class PhraseGroupHeader extends RelativeLayout implements OnClickListener, IDownloadController, OnMultiPhraseLoadListener {
//    /* access modifiers changed from: private */
//    public TextView mDLDView;
//    /* access modifiers changed from: private */
//    public CommentCircleProgressView mDLDingView;
//    private boolean mDownloaded = false;
//    /* access modifiers changed from: private */
//    public MultiPhraseLoader mDownloader;
//    /* access modifiers changed from: private */
//    public List<Integer> mGroups;
//
//    public PhraseGroupHeader(Context context) {
//        super(context);
//    }
//
//    public PhraseGroupHeader(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mDLDView = (TextView) findViewById(R.id.phrase_group_download);
//        this.mDLDView.setVisibility(8);
//        this.mDLDView.setOnClickListener(this);
//        this.mDLDingView = (CommentCircleProgressView) findViewById(R.id.phrase_group_downloading);
//        this.mDLDingView.setOnClickListener(this);
//        this.mDLDingView.setVisibility(8);
//        this.mDLDingView.setComment((int) R.string.phrase_group_download);
//        this.mDownloader = new Builder().setAssetManager(getContext().getAssets()).setCallback(this).build();
//    }
//
//    public void init(List<Integer> list) {
//        this.mGroups = list;
//        this.mDownloader.setGroupIds(this.mGroups);
//        this.mDownloader.init();
//    }
//
//    public void onMultiLoadInited(int i, float f, float f2) {
//        if (i < 100 || f != f2) {
//            String format = String.format("%.2fM/%.2fM", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
//            this.mDLDView.setText(format);
//            this.mDLDingView.setProgress(i);
//            this.mDLDingView.setComment((CharSequence) format);
//            this.mDLDView.setVisibility(0);
//            this.mDLDView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadein));
//            return;
//        }
//        this.mDownloaded = true;
//    }
//
//    public void onMultiLoadProgress(int i, float f, float f2) {
//        String format = String.format("%.2fM/%.2fM", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
//        this.mDLDView.setText(format);
//        this.mDLDingView.setProgress(i);
//        this.mDLDingView.setComment((CharSequence) format);
//    }
//
//    public void onMultiLoaded(boolean z, int i) {
//        if (z) {
//            this.mDownloaded = true;
//            this.mDLDView.setText(R.string.phrase_group_download_finished);
//            this.mDLDingView.setComment((int) R.string.phrase_group_download_finished);
//        } else {
//            int i2 = R.string.phrase_training_load_failed;
//            switch (i) {
//                case -4:
//                    i2 = R.string.phrase_training_load_failed_for_net_usr_reject;
//                    break;
//                case -3:
//                    i2 = R.string.phrase_training_load_failed_for_net_offline;
//                    break;
//                case -2:
//                    i2 = R.string.phrase_training_load_failed_for_net;
//                    break;
//                case -1:
//                    i2 = R.string.phrase_training_load_failed_for_data;
//                    break;
//            }
//            Toast.makeText(getContext(), i2, 0).show();
//            this.mDownloader.reset();
//        }
//        if (this.mDLDingView.getVisibility() == 0) {
//            this.mDLDingView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadeout));
//            this.mDLDingView.setVisibility(8);
//            if (!z) {
//                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadein);
//                loadAnimation.setStartOffset(400);
//                this.mDLDView.startAnimation(loadAnimation);
//                this.mDLDView.setVisibility(0);
//            }
//        }
//    }
//
//    public void onMultiCancelled() {
//    }
//
//    public void onClick(View view) {
//        if ((view == this.mDLDView || view == this.mDLDingView) && this.mGroups != null && !this.mGroups.isEmpty() && this.mDownloader != null && !this.mDownloaded) {
//            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadeout);
//            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.business_scale_fadein);
//            loadAnimation2.setStartOffset(400);
//            if (view == this.mDLDView) {
//                this.mDLDView.startAnimation(loadAnimation);
//                this.mDLDView.setVisibility(8);
//                this.mDLDingView.startAnimation(loadAnimation2);
//                this.mDLDingView.setVisibility(0);
//            } else {
//                this.mDLDingView.startAnimation(loadAnimation);
//                this.mDLDingView.setVisibility(8);
//                this.mDLDView.startAnimation(loadAnimation2);
//                this.mDLDView.setVisibility(0);
//            }
//            loadAnimation2.setAnimationListener(new AnimationListener() {
//                public void onAnimationStart(Animation animation) {
//                }
//
//                public void onAnimationEnd(Animation animation) {
//                    if (PhraseGroupHeader.this.mDownloader.isCancelled() && PhraseGroupHeader.this.mDLDingView.getVisibility() == 0) {
//                        Log.d("whiz", "phrase download start..");
//                        PhraseGroupHeader.this.mDownloader.setGroupIds(PhraseGroupHeader.this.mGroups);
//                        PhraseGroupHeader.this.mDownloader.load();
//                    } else if (!PhraseGroupHeader.this.mDownloader.isCancelled() && PhraseGroupHeader.this.mDLDView.getVisibility() == 0) {
//                        Log.d("whiz", "phrase download cancel..");
//                        PhraseGroupHeader.this.mDownloader.cancel();
//                    }
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//            });
//        }
//    }
//
//    public void download() {
//    }
//
//    public void cancel() {
//        if (this.mDownloader != null) {
//            this.mDownloader.cancel();
//        }
//    }
//}
