//package com.baicizhan.learning_strategy.test;
//
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.bean.TypeProxy;
//import com.baicizhan.learning_strategy.core.DirLoader;
//import com.baicizhan.learning_strategy.core.JsRuntime;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.learning_strategy.iface.SequenceStrategy;
//import com.baicizhan.learning_strategy.iface.TypeStrategy;
//import com.baicizhan.learning_strategy.impl.ObjectCreatorProxy;
//import com.baicizhan.learning_strategy.util.C0975L;
//import com.baicizhan.learning_strategy.util.Pair;
//import com.baicizhan.learning_strategy.util.Timer;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import p012ch.qos.logback.core.CoreConstants;
//
//public class TestJava {
//    private static final int MULTI_MEDIA_PLAN_COUNT = 10;
//    private static final int PLAN_COUNT = 1;
//    private static final int REVIEW_MORE_PLAN_COUNT = 30;
//    private static final int ROAD_MAP_SIZE = 6000;
//    private static final int SLIDE_WINDOW_SIZE = 0;
//    private static int TEST_SEQUENCE_MODE = 2;
//
//    public static void main(String[] strArr) {
//        JsRuntime.getInstance().init(0);
//        try {
//            DirLoader dirLoader = new DirLoader(System.getProperty("user.dir") + "/js");
//            Timer timer = new Timer();
//            timer.start();
//            LearningManager load = dirLoader.load();
//            if (load == null) {
//                C0975L.log.error("load error");
//                return;
//            }
//            System.out.println(timer.stop());
//            ObjectCreatorProxy objectCreatorProxy = new ObjectCreatorProxy();
//            objectCreatorProxy.createProblem();
//            long currentTimeMillis = System.currentTimeMillis();
//            objectCreatorProxy.createProblems(1000);
//            System.out.println(System.currentTimeMillis() - currentTimeMillis);
//            long currentTimeMillis2 = System.currentTimeMillis();
//            objectCreatorProxy.createProblems(CoreConstants.MILLIS_IN_ONE_MINUTE);
//            System.out.println(System.currentTimeMillis() - currentTimeMillis2);
//            ArrayList arrayList = new ArrayList();
//            long currentTimeMillis3 = System.currentTimeMillis();
//            for (int i = 0; i < 3000; i++) {
//                arrayList.add(objectCreatorProxy.createProblem());
//            }
//            System.out.println("1 use time : " + (System.currentTimeMillis() - currentTimeMillis3) + " count: " + arrayList.size());
//            long currentTimeMillis4 = System.currentTimeMillis();
//            List createProblems = objectCreatorProxy.createProblems(3000);
//            System.out.println("2 use time : " + (System.currentTimeMillis() - currentTimeMillis4) + " count: " + createProblems.size());
//            List buildRoadMap = buildRoadMap();
//            Map buildDoneProblems = buildDoneProblems();
//            long currentTimeMillis5 = System.currentTimeMillis();
//            load.init(buildRoadMap, buildDoneProblems);
//            System.out.println("init use time : " + (System.currentTimeMillis() - currentTimeMillis5));
//            long currentTimeMillis6 = System.currentTimeMillis();
//            HashMap hashMap = new HashMap();
//            hashMap.put("slideWindowSize", Integer.valueOf(0));
//            if (1 == TEST_SEQUENCE_MODE) {
//                load.setSequenceModeNewAndReview(1, hashMap);
//            } else if (2 == TEST_SEQUENCE_MODE) {
//                load.setSequenceModeReviewMore(30, hashMap);
//            } else if (3 != TEST_SEQUENCE_MODE && 4 == TEST_SEQUENCE_MODE) {
//                HashMap hashMap2 = new HashMap();
//                hashMap2.put(Integer.valueOf(1), Integer.valueOf(100));
//                HashSet hashSet = new HashSet();
//                hashSet.add(Integer.valueOf(100));
//                hashMap.put("learnedList", hashMap2);
//                hashMap.put("skippedList", hashSet);
//                load.setSequenceModeMultiMedia(10, hashMap);
//            }
//            System.out.println("setSequenceMode : " + (System.currentTimeMillis() - currentTimeMillis6));
//            load.setTypeModeLearning(null);
//            SequenceStrategy sequenceStrategy = load.getSequenceStrategy();
//            TypeStrategy typeStrategy = load.getTypeStrategy();
//            System.out.println(sequenceStrategy);
//            System.out.println(typeStrategy);
//            ProblemProxy create = ProblemProxy.create();
//            create.setScore(TopicLearnRecord.SCORE_UNTOUCH);
//            sequenceStrategy.cancelKill(create);
//            for (int i2 = 0; i2 < 12; i2++) {
//                ProblemProxy create2 = ProblemProxy.create();
//                create2.setScore(-i2);
//                sequenceStrategy.cancelKill(create2);
//            }
//            int newLearningCount = sequenceStrategy.getNewLearningCount();
//            int reviewCount = sequenceStrategy.getReviewCount();
//            System.out.println("new-count:" + newLearningCount + " review-count:" + reviewCount);
//            Pair newLearningAndReviewCount = sequenceStrategy.getNewLearningAndReviewCount();
//            System.out.println("new-count:" + newLearningAndReviewCount.getFirst() + " review-count:" + newLearningAndReviewCount.getSecond());
//            while (true) {
//                ProblemProxy nextOne = sequenceStrategy.getNextOne();
//                if (nextOne == null) {
//                    break;
//                }
//                sequenceStrategy.doneCorrect(nextOne, 1, null);
//                Pair newLearningAndReviewCount2 = sequenceStrategy.getNewLearningAndReviewCount();
//                System.out.println("new-count:" + newLearningAndReviewCount2.getFirst() + " review-count:" + newLearningAndReviewCount2.getSecond());
//            }
//            load.setSequenceModeReviewMore(30, hashMap);
//            SequenceStrategy sequenceStrategy2 = load.getSequenceStrategy();
//            Pair newLearningAndReviewCount3 = sequenceStrategy2.getNewLearningAndReviewCount();
//            System.out.println("new-count:" + newLearningAndReviewCount3.getFirst() + " review-count:" + newLearningAndReviewCount3.getSecond());
//            System.exit(0);
//            List<ProblemProxy> next = sequenceStrategy2.getNext(0, 20);
//            for (ProblemProxy id : next) {
//                System.out.println("p1: " + id.getId());
//            }
//            System.out.println("============");
//            sequenceStrategy2.kill((ProblemProxy) next.get(0));
//            for (ProblemProxy id2 : sequenceStrategy2.getNext(0, 20)) {
//                System.out.println("p1: " + id2.getId());
//            }
//            for (ProblemProxy id3 : sequenceStrategy2.getNext(1, 19)) {
//                System.out.println("p1: " + id3.getId());
//            }
//            for (ProblemProxy id4 : sequenceStrategy2.getNext(1, 3)) {
//                System.out.println("p2: " + id4.getId());
//            }
//            C0975L.log.info(String.format("new:%d review:%d", new Object[]{Integer.valueOf(newLearningCount), Integer.valueOf(reviewCount)}));
//            for (int i3 = 0; i3 < 1000; i3++) {
//                ProblemProxy nextOne2 = sequenceStrategy2.getNextOne();
//                if (nextOne2 == null) {
//                    break;
//                }
//                int score = nextOne2.getScore();
//                boolean isKilled = nextOne2.isKilled();
//                TypeProxy type = typeStrategy.getType(nextOne2);
//                ProblemProxy doneCorrect = sequenceStrategy2.doneCorrect(nextOne2, 100, null);
//                C0975L.log.info("pp : word:{} score:[{}->{}] killed:[{}->{} type:{}]", nextOne2.getWord(), Integer.valueOf(score), Integer.valueOf(doneCorrect.getScore()), Boolean.valueOf(isKilled), Boolean.valueOf(doneCorrect.isKilled()), Integer.valueOf(type.getValue()));
//            }
//            JsRuntime.getInstance().destory();
//        } finally {
//            JsRuntime.getInstance().destory();
//        }
//    }
//
//    private static List<ProblemProxy> buildRoadMap() {
//        ObjectCreatorProxy objectCreatorProxy = new ObjectCreatorProxy();
//        ArrayList arrayList = new ArrayList();
//        for (int i = 0; i < ROAD_MAP_SIZE; i++) {
//            ProblemProxy createProblem = objectCreatorProxy.createProblem();
//            createProblem.setId(i + 1);
//            createProblem.setWord("word_" + createProblem.getId());
//            createProblem.setGroupId(0);
//            arrayList.add(createProblem);
//        }
//        return arrayList;
//    }
//
//    private static Map<Integer, ProblemProxy> buildDoneProblems() {
//        ObjectCreatorProxy objectCreatorProxy = new ObjectCreatorProxy();
//        HashMap hashMap = new HashMap();
//        for (int i = 0; i < 2000; i++) {
//            ProblemProxy createProblem = objectCreatorProxy.createProblem();
//            createProblem.setId(i + 1);
//            createProblem.setWord("word_" + createProblem.getId());
//            createProblem.setScore(2);
//            createProblem.setLastLearnedTime(System.currentTimeMillis());
//            createProblem.setReviewMoreCount(0);
//            createProblem.setGroupId(0);
//            hashMap.put(Integer.valueOf(createProblem.getId()), createProblem);
//        }
//        return hashMap;
//    }
//}
