package kankan.wheel.widget.p098a;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: kankan.wheel.widget.a.d */
public interface WheelViewAdapter {
    View getEmptyItem(View view, ViewGroup viewGroup);

    View getItem(int i, View view, ViewGroup viewGroup);

    int getItemsCount();

    void registerDataSetObserver(DataSetObserver dataSetObserver);

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);
}
