package com.baicizhan.main.utils;

import com.baicizhan.client.business.settings.Settings;

public class GuideFlags {
    public static final int FLAG_CANCEL_KILL = 16;
    public static final int FLAG_DONE_WRONG = 64;
    public static final int FLAG_ENABLE = 1;
    public static final int FLAG_HINT = 32;
    public static final int FLAG_IMAGE_OPTION = 128;
    public static final int FLAG_KILL_FIRST_BLOOD = 4;
    public static final int FLAG_MAIN_TAB_REVIEW = 2048;
    public static final int FLAG_PATTERN_2 = 256;
    public static final int FLAG_PATTERN_3 = 512;
    public static final int FLAG_SIMILAR_WORD = 1024;
    public static final int FLAG_TRIPLE_KILL = 8;
    public static final int FLAG_WIKI_GESTURE = 2;

    public static int getGuideFlags() {
        return Settings.getInt(Settings.PREF_GUIDE_FLAGS);
    }

    public static void putGuideFlags(int i) {
        Settings.putInt(Settings.PREF_GUIDE_FLAGS, i);
    }

    public static boolean needCheckGuides() {
        return (getGuideFlags() & 1) > 0;
    }

    public static boolean guideEnabled(int i) {
        int guideFlags = getGuideFlags();
        return (guideFlags & 1) > 0 && (guideFlags & i) == 0;
    }

    public static void disableGuide(int i) {
        putGuideFlags(getGuideFlags() | i);
    }
}
