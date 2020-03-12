//package com.baicizhan.learning_strategy.iface;
//
//import com.baicizhan.learning_strategy.bean.ProblemList;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.util.Pair;
//import java.util.List;
//import java.util.Map;
//
//public interface SequenceStrategy {
//    void cancelKill(ProblemProxy problemProxy);
//
//    void cancelSkip(ProblemProxy problemProxy);
//
//    ProblemProxy doneCorrect(ProblemProxy problemProxy, long j, Map<String, Object> map);
//
//    ProblemProxy doneWrong(ProblemProxy problemProxy, long j, Map<String, Object> map);
//
//    Pair<Integer, Integer> getNewLearningAndReviewCount();
//
//    int getNewLearningCount();
//
//    List<ProblemProxy> getNext(int i, int i2);
//
//    ProblemProxy getNextOne();
//
//    int getReviewCount();
//
//    ProblemList getTodayRoadMap();
//
//    boolean hasNext();
//
//    void kill(ProblemProxy problemProxy);
//
//    void skip(ProblemProxy problemProxy);
//
//    void userActionHint(ProblemProxy problemProxy);
//}
