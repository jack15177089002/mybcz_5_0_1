package com.baicizhan.client.wordlock.fragment;

import android.os.Looper;

public class NavigationManager {
    private static final int NAVING_TO_MORE = 2;
    private static final int NAVING_TO_SEARCH = 4;
    private static final int NAVING_TO_WORD = 1;
    private static int sNavingFlag = 0;

    private NavigationManager() {
    }

    public static void reset() {
        disableWorkerThread();
        sNavingFlag = 0;
    }

    public static void setNavingToWord(boolean z) {
        setNavingFlag(z, 1);
    }

    public static boolean isNavingToWord() {
        return isNavingFlag(1);
    }

    public static boolean canNavToWord() {
        return !isNavingToWord() && !isNavingToSearch() && !isNavingToMore();
    }

    public static void setNavingToMore(boolean z) {
        setNavingFlag(z, 2);
    }

    public static boolean isNavingToMore() {
        return isNavingFlag(2);
    }

    public static boolean canNavToMore() {
        return !isNavingToMore() && !isNavingToSearch() && !isNavingToWord();
    }

    public static void setNavingToSearch(boolean z) {
        setNavingFlag(z, 4);
    }

    public static boolean isNavingToSearch() {
        return isNavingFlag(4);
    }

    public static boolean canNavToSearch() {
        return !isNavingToSearch() && !isNavingToWord() && !isNavingToMore();
    }

    private static void setNavingFlag(boolean z, int i) {
        disableWorkerThread();
        if (z) {
            sNavingFlag |= i;
        } else {
            sNavingFlag &= i ^ -1;
        }
    }

    private static boolean isNavingFlag(int i) {
        return (sNavingFlag & i) == i;
    }

    private static final void disableWorkerThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new RuntimeException("fatal error: navigation manager can only be used in main thread.");
        }
    }
}
