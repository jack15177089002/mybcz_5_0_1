//package com.baicizhan.main.utils;
//
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import java.util.List;
//import java.util.Locale;
//
//public class DebugUtil {
//    private static final String TAG = DebugUtil.class.getSimpleName();
//
//    public static void printProblemProxyList(List<ProblemProxy> list) {
//        for (ProblemProxy printProblemProxy : list) {
//            printProblemProxy(printProblemProxy);
//        }
//    }
//
//    public static void printProblemProxy(ProblemProxy problemProxy) {
//        LogWrapper.m2793d(TAG, String.format(Locale.CHINA, "[id=%d, time=%d, score=%d, new=%s, killed=%s]", new Object[]{Integer.valueOf(problemProxy.getId()), Long.valueOf(problemProxy.getLastLearnedTime()), Integer.valueOf(problemProxy.getScore()), Boolean.valueOf(problemProxy.isTodayNewLearned()), Boolean.valueOf(problemProxy.isKilled())}));
//    }
//}
