package com.baicizhan.client.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.video.R;
import com.baicizhan.client.video.load.VideoPlayer.State;
import com.jiongji.andriod.card.R;

public class PlayController extends RelativeLayout implements OnClickListener {
    private TextView mCur;
    private View mInfoTag;
    private OnPlayerControlListener mListener;
    private TextView mMax;
    private View mNext;
    private View mPrev;
    private ProgressBar mProgress;
    private ImageButton mToggle;

    public interface OnPlayerControlListener {
        void onNext();

        void onPrev();

        void onToggle();

        void onToggleInfo();
    }

    public void setOnPlayerControlListener(OnPlayerControlListener onPlayerControlListener) {
        this.mListener = onPlayerControlListener;
    }

    public PlayController(Context context) {
        super(context);
    }

    public PlayController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setProgress(int i, int i2) {
        if (i >= 0 && i2 > 0 && i <= i2) {
            int i3 = (i * 100) / i2;
            if (this.mProgress != null) {
                this.mProgress.setProgress(i3);
            }
            if (this.mCur != null) {
                this.mCur.setText(String.valueOf(i));
            }
            if (this.mMax != null) {
                this.mMax.setText(String.valueOf(i2));
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mPrev = findViewById(R.id.video_pre);
        this.mToggle = (ImageButton) findViewById(R.id.video_toggle);
        this.mNext = findViewById(R.id.video_next);
        this.mCur = (TextView) findViewById(R.id.video_cur_progress);
        this.mMax = (TextView) findViewById(R.id.video_max_progress);
        this.mProgress = (ProgressBar) findViewById(R.id.video_play_progress);
        ThemeResUtil.setBaicizhanProgress(getContext(), this.mProgress);
        this.mPrev.setOnClickListener(this);
        this.mToggle.setOnClickListener(this);
        this.mNext.setOnClickListener(this);
        this.mInfoTag = findViewById(R.id.video_info_tag);
        this.mInfoTag.setOnClickListener(this);
    }

    public void onPlayStateChanged(State state) {
        Log.d("whiz", "play state: " + state);
        switch (state) {
            case Playing:
                this.mPrev.setEnabled(true);
                this.mNext.setEnabled(true);
                this.mToggle.setEnabled(true);
                this.mToggle.setImageResource(R.drawable.video_pause_selector);
                return;
            case Paused:
                this.mPrev.setEnabled(true);
                this.mNext.setEnabled(true);
                this.mToggle.setEnabled(true);
                this.mToggle.setImageResource(R.drawable.video_play_selector);
                return;
            default:
                this.mPrev.setEnabled(false);
                this.mNext.setEnabled(false);
                this.mToggle.setEnabled(false);
                return;
        }
    }

    public void onClick(View view) {
        if (this.mListener == null) {
            return;
        }
        if (view == this.mPrev) {
            this.mListener.onPrev();
        } else if (view == this.mNext) {
            this.mListener.onNext();
        } else if (view == this.mToggle) {
            this.mListener.onToggle();
        } else if (view == this.mInfoTag) {
            this.mListener.onToggleInfo();
        }
    }
}
