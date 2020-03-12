package com.baicizhan.client.video.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import com.jiongji.andriod.card.R;
//import com.baicizhan.client.video.R;

public class NavigationBar extends RelativeLayout implements OnClickListener {
    private OnSelectToggleListener mListener;
    private View mSelectToggle;
    private View mToMain;

    public interface OnSelectToggleListener {
        void onSelectToggle(boolean z);
    }

    public void setOnSelectToggleListener(OnSelectToggleListener onSelectToggleListener) {
        this.mListener = onSelectToggleListener;
    }

    public NavigationBar(Context context) {
        super(context);
    }

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mToMain = findViewById(R.id.video_to_main);
        this.mSelectToggle = findViewById(R.id.video_list_select);
        this.mToMain.setOnClickListener(this);
        this.mSelectToggle.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == this.mToMain) {
            Context context = getContext();
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        } else if (view == this.mSelectToggle) {
            this.mSelectToggle.setSelected(false);
            if (this.mListener != null) {
                this.mListener.onSelectToggle(this.mSelectToggle.isSelected());
            }
        }
    }

    public void setSelected(boolean z) {
        if (this.mSelectToggle != null) {
            this.mSelectToggle.setSelected(z);
        }
    }

    public boolean isSelected() {
        if (this.mSelectToggle != null) {
            return this.mSelectToggle.isSelected();
        }
        return false;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mToMain.setEnabled(z);
        this.mSelectToggle.setEnabled(z);
    }
}
