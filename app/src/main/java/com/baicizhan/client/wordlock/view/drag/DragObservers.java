package com.baicizhan.client.wordlock.view.drag;

import java.util.ArrayList;
import java.util.List;

public class DragObservers {
    private List<IDragObserver> mObservers = new ArrayList(2);

    public void addObserver(IDragObserver iDragObserver) {
        this.mObservers.add(iDragObserver);
    }

    public void removeObserver(IDragObserver iDragObserver) {
        this.mObservers.remove(iDragObserver);
    }

    public void notifyStart() {
        for (IDragObserver onDragStart : this.mObservers) {
            onDragStart.onDragStart();
        }
    }

    public void notifyEnd() {
        for (IDragObserver onDragEnd : this.mObservers) {
            onDragEnd.onDragEnd();
        }
    }
}
