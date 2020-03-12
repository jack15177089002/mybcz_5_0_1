package com.p047d.p048a;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

/* renamed from: com.d.a.as */
/* compiled from: ValueAnimator */
final class C1547as extends Handler {
    private C1547as() {
    }

    /* synthetic */ C1547as(byte b) {
        this();
    }

    public final void handleMessage(Message message) {
        boolean z;
        ArrayList arrayList = (ArrayList) ValueAnimator.f3463o.get();
        ArrayList arrayList2 = (ArrayList) ValueAnimator.f3465q.get();
        switch (message.what) {
            case 0:
                ArrayList arrayList3 = (ArrayList) ValueAnimator.f3464p.get();
                if (arrayList.size() > 0 || arrayList2.size() > 0) {
                    z = false;
                } else {
                    z = true;
                }
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i = 0; i < size; i++) {
                        ValueAnimator amVar = (ValueAnimator) arrayList4.get(i);
                        if (amVar.f3480h == 0) {
                            amVar.m3307o();
                        } else {
                            arrayList2.add(amVar);
                        }
                    }
                }
                break;
            case 1:
                z = true;
                break;
            default:
                return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        ArrayList arrayList5 = (ArrayList) ValueAnimator.f3467s.get();
        ArrayList arrayList6 = (ArrayList) ValueAnimator.f3466r.get();
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ValueAnimator amVar2 = (ValueAnimator) arrayList2.get(i2);
            if (ValueAnimator.m3294a(amVar2, currentAnimationTimeMillis)) {
                arrayList5.add(amVar2);
            }
        }
        int size3 = arrayList5.size();
        if (size3 > 0) {
            for (int i3 = 0; i3 < size3; i3++) {
                ValueAnimator amVar3 = (ValueAnimator) arrayList5.get(i3);
                amVar3.m3307o();
                amVar3.f3478f = true;
                arrayList2.remove(amVar3);
            }
            arrayList5.clear();
        }
        int i4 = 0;
        int size4 = arrayList.size();
        while (i4 < size4) {
            ValueAnimator amVar4 = (ValueAnimator) arrayList.get(i4);
            if (amVar4.mo16189c(currentAnimationTimeMillis)) {
                arrayList6.add(amVar4);
            }
            if (arrayList.size() == size4) {
                i4++;
            } else {
                size4--;
                arrayList6.remove(amVar4);
            }
        }
        if (arrayList6.size() > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= arrayList6.size()) {
                    arrayList6.clear();
                } else {
                    ((ValueAnimator) arrayList6.get(i6)).m3306n();
                    i5 = i6 + 1;
                }
            }
        }
        if (!z) {
            return;
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            sendEmptyMessageDelayed(1, Math.max(0, ValueAnimator.f3461C - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
        }
    }
}
