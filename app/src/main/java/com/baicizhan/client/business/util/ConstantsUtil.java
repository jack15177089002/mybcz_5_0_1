package com.baicizhan.client.business.util;

import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
import java.util.Map;

public class ConstantsUtil {
    public static final int DEFAULT_COMPLETE_REVIEW_COUNT = 100;
    public static final String DEFAULT_DNS = "http://baicizhan.qiniucdn.com";
    public static final String DEFAULT_DNS_CAND = "http://baicizhan.cdn.bj.xs3cnc.com";
    public static final String[][] FAMOUSE_QUOTATIONS = {new String[]{"--赫歇尔", "When I was young, I admired clever people. Now that I am old, I admire kind people.", "少时喜欢聪明人，老来喜欢仁厚人。"}, new String[]{"--梭罗", "All good things are cheap, all bad things are very dear.", "一切好的东西都是便宜的，所有坏的东西都是非常贵的。"}, new String[]{"--斯克利维斯", "Patience! The windmill never strays in search of the wind.", "耐心等待!风车从不跑去找风。"}, new String[]{"--布鲁斯", "Morality may consist solely in the courage of making a choice.", "品德可能仅仅在于有勇气作出抉择。"}, new String[]{"--霍姆斯", "Fame usually comes to those who are thinking something else.", "通常是没想到成名的人反而成了名。"}, new String[]{"--佩恩", "The jealous are troublesome to others, but a torment to themselves.", "妒忌者对别人是烦恼，对他们自己却是折磨。"}, new String[]{"--王尔德", "If there were less sympathy in the world, there would be less trouble in the world.", "如果世界上少一些同情，世界上也就会少一些麻烦。"}, new String[]{"--爱默生", "Don't waste life in doubts and fears.", "不要把生命浪费于怀疑与恐惧中。"}, new String[]{"--林德伯格", "The most exhausting thing in life is being insincere.", "生活中最使人筋疲力尽的事是弄虚作假。"}, new String[]{"--科沃德", "It is discouraging to think how many people are shocked by honesty and how few by deceit.", "令人沮丧的是，有那么多人对诚实感到吃惊，而对欺骗感到吃惊的人却那么的少。"}, new String[]{"--居里夫人", "Nothing in life is to be feared. It is only to be understood.", "生活中没有什么可怕的东西，只有需要理解的东西。"}, new String[]{"--施瓦布", "A man can succeed at almost anything for which he has unlimited enthusiasm.", "只要有无限的热情，一个人几乎可以在任何事情上取得成功。"}};
    public static final Map<String, Object> NEW_AND_REVIEW_EXTRA_ARGS = new ArrayMap();
    public static final int PLUS_REVIEW_COUNT = 50;
    public static final Map<String, Object> REVIEW_MORE_EXTRA_ARGS = new ArrayMap();
    public static final int SLIDE_WINDOW_SIZE = 10;
    public static final String STATE_EXIT_FOR_RECREATE = "exit";
    public static final int WANT_MORE_COUNT = 25;

    static {
        NEW_AND_REVIEW_EXTRA_ARGS.put("slideWindowSize", Integer.valueOf(10));
        REVIEW_MORE_EXTRA_ARGS.put("slideWindowSize", Integer.valueOf(10));
    }
}
