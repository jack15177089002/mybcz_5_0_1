package kankan.wheel.widget;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;

/* renamed from: kankan.wheel.widget.c */
public final class WheelRecycle {

    /* renamed from: a */
    List<View> f5757a;

    /* renamed from: b */
    List<View> f5758b;

    /* renamed from: c */
    private WheelView f5759c;

    public WheelRecycle(WheelView wheelView) {
        this.f5759c = wheelView;
    }

    /* renamed from: a */
    public final int mo18422a(LinearLayout linearLayout, int i, ItemsRange aVar) {
        int i2 = 0;
        int i3 = i;
        while (i2 < linearLayout.getChildCount()) {
            if (!(i >= aVar.f5752a && i <= aVar.mo18405a())) {
                View childAt = linearLayout.getChildAt(i2);
                int itemsCount = this.f5759c.getViewAdapter().getItemsCount();
                if ((i < 0 || i >= itemsCount) && !this.f5759c.f5729a) {
                    this.f5758b = m5399a(childAt, this.f5758b);
                } else {
                    this.f5757a = m5399a(childAt, this.f5757a);
                }
                linearLayout.removeViewAt(i2);
                if (i2 == 0) {
                    i3++;
                }
            } else {
                i2++;
            }
            i++;
        }
        return i3;
    }

    /* renamed from: a */
    private static List<View> m5399a(View view, List<View> list) {
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(view);
        return list;
    }

    /* renamed from: a */
    static View m5398a(List<View> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        View view = (View) list.get(0);
        list.remove(0);
        return view;
    }
}
