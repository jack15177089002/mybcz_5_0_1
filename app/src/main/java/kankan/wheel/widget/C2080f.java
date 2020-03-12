package kankan.wheel.widget;

import android.os.Handler;
import android.os.Message;

/* renamed from: kankan.wheel.widget.f */
/* compiled from: WheelScroller */
final class C2080f extends Handler {

    /* renamed from: a */
    final /* synthetic */ WheelScroller f5772a;

    C2080f(WheelScroller dVar) {
        this.f5772a = dVar;
    }

    public final void handleMessage(Message message) {
        this.f5772a.f5763d.computeScrollOffset();
        int currY = this.f5772a.f5763d.getCurrY();
        int i = this.f5772a.f5764e - currY;
        this.f5772a.f5764e = currY;
        if (i != 0) {
            this.f5772a.f5760a.mo18432a(i);
        }
        if (Math.abs(currY - this.f5772a.f5763d.getFinalY()) <= 0) {
            this.f5772a.f5763d.getFinalY();
            this.f5772a.f5763d.forceFinished(true);
        }
        if (!this.f5772a.f5763d.isFinished()) {
            this.f5772a.f5767h.sendEmptyMessage(message.what);
        } else if (message.what == 0) {
            this.f5772a.mo18426c();
        } else {
            WheelScroller dVar = this.f5772a;
            if (dVar.f5766g) {
                dVar.f5760a.mo18433b();
                dVar.f5766g = false;
            }
        }
    }
}
