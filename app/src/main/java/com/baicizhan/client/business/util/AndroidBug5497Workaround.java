package com.baicizhan.client.business.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class AndroidBug5497Workaround {
    private View mChildOfContent;
    private LayoutParams mFrameLayoutParams;
    private int mUsableHeightPrevious;

    public static void assistActivity(Activity activity) {
        new AndroidBug5497Workaround(activity);
    }

    public static void assistWindow(Window window) {
        new AndroidBug5497Workaround(window);
    }

    private AndroidBug5497Workaround(Activity activity) {
        this(activity.getWindow());
    }

    private AndroidBug5497Workaround(Window window) {
        this.mChildOfContent = ((FrameLayout) window.findViewById(16908290)).getChildAt(0);
        this.mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                AndroidBug5497Workaround.this.possiblyResizeChildOfContent();
            }
        });
        this.mFrameLayoutParams = (LayoutParams) this.mChildOfContent.getLayoutParams();
    }

    /* access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        int computeUsableHeight = computeUsableHeight();
        if (computeUsableHeight != this.mUsableHeightPrevious) {
            int height = this.mChildOfContent.getRootView().getHeight();
            int i = height - computeUsableHeight;
            if (i > height / 4) {
                this.mFrameLayoutParams.height = height - i;
            } else {
                this.mFrameLayoutParams.height = height;
            }
            this.mChildOfContent.requestLayout();
            this.mUsableHeightPrevious = computeUsableHeight;
        }
    }

    private int computeUsableHeight() {
        Rect rect = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }
}
