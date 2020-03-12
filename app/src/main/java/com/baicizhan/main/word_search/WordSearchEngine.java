//package com.baicizhan.main.word_search;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public class WordSearchEngine {
//    Map<Integer, IntVector> mInvertTable = new HashMap();
//
//    public void add(int i, String str) {
//        int i2 = 0;
//        while (true) {
//            int i3 = i2;
//            if (i3 < str.length()) {
//                int numericValue = Character.getNumericValue(str.charAt(i3));
//                IntVector intVector = (IntVector) this.mInvertTable.get(Integer.valueOf(numericValue));
//                if (intVector == null) {
//                    intVector = new IntVector();
//                }
//                this.mInvertTable.put(Integer.valueOf(numericValue), intVector);
//                intVector.pushBack(i);
//                i2 = i3 + 1;
//            } else {
//                return;
//            }
//        }
//    }
//
//    public List<Integer> search(String str) {
//        ArrayList arrayList = new ArrayList();
//        int i = 0;
//        while (true) {
//            int i2 = i;
//            if (i2 >= str.length()) {
//                return merge(arrayList);
//            }
//            IntVector intVector = (IntVector) this.mInvertTable.get(Integer.valueOf(Character.getNumericValue(str.charAt(i2))));
//            if (intVector != null && intVector.size() > 0) {
//                arrayList.add(intVector);
//            }
//            i = i2 + 1;
//        }
//    }
//
//    public List<Integer> merge(List<IntVector> list) {
//        int i = 0;
//        LoserTree loserTree = new LoserTree(list.size());
//        ArrayList arrayList = new ArrayList();
//        int[] iArr = new int[list.size()];
//        for (int i2 = 0; i2 < list.size(); i2++) {
//            loserTree.offer(i2, ((IntVector) list.get(i2)).mo7767at(0));
//            iArr[i2] = 0;
//        }
//        int min = loserTree.getMin();
//        while (true) {
//            int min2 = loserTree.getMin();
//            int minChannel = loserTree.getMinChannel();
//            if (min2 == Integer.MAX_VALUE) {
//                return arrayList;
//            }
//            System.out.println("get " + min2);
//            if (min2 == min) {
//                i++;
//                min2 = min;
//            } else {
//                System.out.println(" ====> " + min + ", " + i);
//                if (i >= 2) {
//                    arrayList.add(Integer.valueOf(min));
//                }
//                i = 1;
//            }
//            iArr[minChannel] = iArr[minChannel] + 1;
//            if (iArr[minChannel] >= ((IntVector) list.get(minChannel)).size()) {
//                loserTree.offer(minChannel, Integer.MAX_VALUE);
//                min = min2;
//            } else {
//                loserTree.offer(minChannel, ((IntVector) list.get(minChannel)).mo7767at(iArr[minChannel]));
//                min = min2;
//            }
//        }
//    }
//
//    public void build() {
//        add(1, "hello");
//        add(2, "word");
//        add(3, "this");
//        add(4, "is");
//        add(5, "a");
//        add(6, "test");
//    }
//
//    public void memoryUsage() {
//        int i = 0;
//        Iterator it = this.mInvertTable.values().iterator();
//        while (true) {
//            int i2 = i;
//            if (it.hasNext()) {
//                i = ((IntVector) it.next()).memoryUsage() + i2;
//            } else {
//                System.out.println("total mem size " + i2);
//                return;
//            }
//        }
//    }
//
//    public static void main(String[] strArr) {
//        WordSearchEngine wordSearchEngine = new WordSearchEngine();
//        wordSearchEngine.build();
//        wordSearchEngine.memoryUsage();
//        for (Integer intValue : wordSearchEngine.search("is")) {
//            System.out.println(intValue.intValue() + ", ");
//        }
//    }
//}
