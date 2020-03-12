package kankan.wheel.widget;

import android.database.DataSetObserver;

/* renamed from: kankan.wheel.widget.i */
/* compiled from: WheelView */
final class C2083i extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ WheelView f5774a;

    C2083i(WheelView wheelView) {
        this.f5774a = wheelView;
    }

    public final void onChanged() {
        this.f5774a.mo18386a(false);
    }

    public final void onInvalidated() {
        this.f5774a.mo18386a(true);
    }
}
