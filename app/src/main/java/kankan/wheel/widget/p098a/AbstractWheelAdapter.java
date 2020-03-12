package kankan.wheel.widget.p098a;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

/* renamed from: kankan.wheel.widget.a.a */
public abstract class AbstractWheelAdapter implements WheelViewAdapter {
    private List<DataSetObserver> datasetObservers;

    public View getEmptyItem(View view, ViewGroup viewGroup) {
        return null;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.datasetObservers == null) {
            this.datasetObservers = new LinkedList();
        }
        this.datasetObservers.add(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.datasetObservers != null) {
            this.datasetObservers.remove(dataSetObserver);
        }
    }

    public void notifyDataChangedEvent() {
        if (this.datasetObservers != null) {
            for (DataSetObserver onChanged : this.datasetObservers) {
                onChanged.onChanged();
            }
        }
    }

    public void notifyDataInvalidatedEvent() {
        if (this.datasetObservers != null) {
            for (DataSetObserver onInvalidated : this.datasetObservers) {
                onInvalidated.onInvalidated();
            }
        }
    }
}
