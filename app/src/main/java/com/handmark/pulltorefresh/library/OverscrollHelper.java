package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;

@TargetApi(9)
/* renamed from: com.handmark.pulltorefresh.library.c */
public final class OverscrollHelper {
    /* renamed from: a */
    public static void m3633a(PullToRefreshBase<?> gVar, int i, int i2, int i3, int i4, boolean z) {
        int scrollX;
        switch (C1612d.f3848a[gVar.getPullToRefreshScrollDirection$2ae02adb() - 1]) {
            case 1:
                scrollX = gVar.getScrollX();
                break;
            default:
                scrollX = gVar.getScrollY();
                i2 = i4;
                i = i3;
                break;
        }
        if (gVar.isPullToRefreshOverScrollEnabled() && !gVar.isRefreshing()) {
            C1620n mode = gVar.getMode();
            if (mode.mo16492b() && !z && i != 0) {
                int i5 = i + i2;
                if (i5 < 0) {
                    if (mode.mo16493c()) {
                        if (scrollX == 0) {
                            gVar.setState(C1629w.OVERSCROLLING, new boolean[0]);
                        }
                        gVar.setHeaderScroll((int) (((float) (scrollX + i5)) * 1.0f));
                    }
                } else if (i5 > 0) {
                    if (mode.mo16494d()) {
                        if (scrollX == 0) {
                            gVar.setState(C1629w.OVERSCROLLING, new boolean[0]);
                        }
                        gVar.setHeaderScroll((int) (((float) (scrollX + i5 + 0)) * 1.0f));
                    }
                } else if (Math.abs(i5) <= 0 || Math.abs(i5 + 0) <= 0) {
                    gVar.setState(C1629w.RESET, new boolean[0]);
                }
            } else if (z && C1629w.OVERSCROLLING == gVar.getState()) {
                gVar.setState(C1629w.RESET, new boolean[0]);
            }
        }
    }
}
