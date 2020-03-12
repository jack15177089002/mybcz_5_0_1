package com.baicizhan.client.wordlock.view.drag;

import android.view.View;

public interface DragSource {
    boolean allowDrag();

    void onDropCompleted(View view, boolean z);

    void setDragController(DragController dragController);
}
