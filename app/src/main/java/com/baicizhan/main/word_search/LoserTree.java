//package com.baicizhan.main.word_search;
//
//import java.util.Arrays;
//
//public class LoserTree {
//    private int[] mLeaves;
//    private int[] mLosers;
//    private int mSize;
//
//    public LoserTree(int i) {
//        this.mSize = i;
//        this.mLosers = new int[i];
//        for (int i2 = 0; i2 < i; i2++) {
//            this.mLosers[i2] = 0;
//        }
//        this.mLeaves = new int[(i + 1)];
//        this.mLeaves[0] = Integer.MIN_VALUE;
//        Arrays.fill(this.mLeaves, 1, i + 1, Integer.MAX_VALUE);
//    }
//
//    public void adjust(int i) {
//        int i2;
//        int i3 = ((this.mSize + i) - 1) / 2;
//        int i4 = i;
//        while (i3 > 0) {
//            if (this.mLeaves[i4] > this.mLeaves[this.mLosers[i3]]) {
//                i2 = this.mLosers[i3];
//                this.mLosers[i3] = i4;
//            } else {
//                i2 = i4;
//            }
//            i3 >>= 1;
//            i4 = i2;
//        }
//        this.mLosers[0] = i4;
//    }
//
//    public int getMin() {
//        return this.mLeaves[this.mLosers[0]];
//    }
//
//    public int getMinChannel() {
//        return this.mLosers[0] - 1;
//    }
//
//    public void offer(int i, int i2) {
//        this.mLeaves[i + 1] = i2;
//        adjust(i + 1);
//    }
//
//    public void inspect() {
//        System.out.println("leaves " + Arrays.toString(this.mLeaves));
//        System.out.println("losers " + Arrays.toString(this.mLosers));
//    }
//
//    public static void main(String[] strArr) {
//        int[][] iArr = {new int[]{1, 3, 4, 5, 7, 10}, new int[]{2, 5, 8, 9}, new int[]{3, 6, 9}};
//        LoserTree loserTree = new LoserTree(3);
//        int[] iArr2 = {1, 1, 1};
//        for (int i = 0; i < 3; i++) {
//            loserTree.offer(i, iArr[i][0]);
//        }
//        while (loserTree.getMin() != Integer.MAX_VALUE) {
//            int minChannel = loserTree.getMinChannel();
//            System.out.println(minChannel + " => " + loserTree.getMin());
//            System.out.println("cursor " + iArr2[minChannel] + ", " + iArr[minChannel].length);
//            if (iArr2[minChannel] < iArr[minChannel].length) {
//                loserTree.offer(minChannel, iArr[minChannel][iArr2[minChannel]]);
//                iArr2[minChannel] = iArr2[minChannel] + 1;
//            } else {
//                loserTree.offer(minChannel, Integer.MAX_VALUE);
//            }
//        }
//    }
//}
