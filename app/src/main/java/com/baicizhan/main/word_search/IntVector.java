//package com.baicizhan.main.word_search;
//
//public class IntVector {
//    private static final int BLOCK_COUNT = 1024;
//    private static final int BLOCK_COUNT_SHIFT = 10;
//    private static final int BLOCK_SUB_IDX_MASK = 1023;
//    private int[][] mBlocks;
//    private int mCapacity = 0;
//    private int mSize = 0;
//
//    /* renamed from: at */
//    public int mo7767at(int i) {
//        if (i < 0 || i >= this.mSize) {
//            throw new IndexOutOfBoundsException();
//        }
//        return this.mBlocks[i >> 10][i & BLOCK_SUB_IDX_MASK];
//    }
//
//    public void pushBack(int i) {
//        reserve(this.mSize + 1);
//        int i2 = this.mSize >> 10;
//        int i3 = this.mSize & BLOCK_SUB_IDX_MASK;
//        this.mSize++;
//        this.mBlocks[i2][i3] = i;
//    }
//
//    public void reserve(int i) {
//        if (i > this.mCapacity) {
//            System.out.print("reserve " + i + ", 1023");
//            int i2 = (i & BLOCK_SUB_IDX_MASK) > 0 ? (i >> 10) + 1 : i >> 10;
//            System.out.println(" blockCount " + i2);
//            int[][] iArr = new int[i2][];
//            System.out.println("newBlocks " + iArr.length);
//            for (int i3 = 0; i3 <= ((this.mSize - 1) >> 10); i3++) {
//                iArr[i3] = this.mBlocks[i3];
//                System.out.println("copy old " + i3);
//            }
//            for (int i4 = this.mSize >> 10; i4 < i2; i4++) {
//                iArr[i4] = new int[1024];
//                System.out.println("create new " + i4);
//            }
//            this.mBlocks = iArr;
//            this.mCapacity = i2 << 10;
//            System.out.println("mCapacity " + this.mCapacity);
//        }
//    }
//
//    public int size() {
//        return this.mSize;
//    }
//
//    public int capacity() {
//        return this.mCapacity;
//    }
//
//    public int memoryUsage() {
//        return (this.mCapacity * 4) + (this.mBlocks.length * 12);
//    }
//}
