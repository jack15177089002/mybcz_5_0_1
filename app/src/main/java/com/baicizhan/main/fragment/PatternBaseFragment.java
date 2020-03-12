//package com.baicizhan.main.fragment;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Parcelable;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import java.util.List;
//
//public abstract class PatternBaseFragment extends FrameLayout {
//    protected static final int OPTION_COUNT = 4;
//    private static final long SOUND_DELAY = 500;
//    private static final String TAG = PatternBaseFragment.class.getSimpleName();
//    protected AudioPlayer mAudioPlayer;
//    protected ExamplePatternListener mListener;
//    private int mPatternType;
//    protected int mRightIndex;
//    public TopicRecord mRightOption;
//    public List<TopicRecord> mTopicOptions;
//
//    public interface ExamplePatternListener {
//        boolean onAnswer(int i);
//
//        void onHinted();
//    }
//
//    public abstract void clearOptionMask(boolean z);
//
//    public abstract boolean hint();
//
//    public abstract View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup);
//
//    public abstract void sound();
//
//    public PatternBaseFragment(Context context) {
//        this(context, null, 0);
//    }
//
//    public PatternBaseFragment(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//    }
//
//    public void onAttach(Activity activity) {
//        this.mListener = (ExamplePatternListener) activity;
//    }
//
//    public void onDetach() {
//    }
//
//    public void setTopicOptions(int i, List<TopicRecord> list, AudioPlayer audioPlayer) {
//        try {
//            this.mRightIndex = i;
//            this.mTopicOptions = list;
//            this.mRightOption = (TopicRecord) this.mTopicOptions.get(this.mRightIndex);
//            this.mAudioPlayer = audioPlayer;
//            onUpdateViews();
//            postDelayed(new Runnable() {
//                public void run() {
//                    PatternBaseFragment.this.sound();
//                }
//            }, SOUND_DELAY);
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public Parcelable onSaveInstanceState() {
//        return super.onSaveInstanceState();
//    }
//
//    public boolean isRight(int i) {
//        return this.mRightOption.topicId == i;
//    }
//
//    public void answer(final int i) {
//        if (this.mListener != null) {
//            post(new Runnable() {
//                public void run() {
//                    PatternBaseFragment.this.mListener.onAnswer(i);
//                }
//            });
//        }
//    }
//
//    public void onUpdateViews() {
//    }
//
//    public void setPatternType(int i) {
//        this.mPatternType = i;
//    }
//
//    public int getPatternType() {
//        return this.mPatternType;
//    }
//}
