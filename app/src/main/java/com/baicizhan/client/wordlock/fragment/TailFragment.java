package com.baicizhan.client.wordlock.fragment;

import android.graphics.Color;
import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.jiongji.andriod.card.R;
//import com.baicizhan.client.wordlock.R;

public class TailFragment extends Fragment {
    private View mFadeMask;
    private FrameLayout mFrame;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.wordlock_tail_fragment, viewGroup, false);
        this.mFrame = (FrameLayout) viewGroup2.findViewById(R.id.wordlock_tail_frame);
        this.mFadeMask = this.mFrame.findViewById(R.id.wordlock_fade_mask);
        return viewGroup2;
    }

    public void fade(int i) {
        if (this.mFadeMask != null) {
            this.mFadeMask.setBackgroundColor(Color.argb(i, 0, 0, 0));
        }
    }

    public void exit() {
        this.mFrame.removeView(this.mFadeMask);
    }
}
