package com.baicizhan.client.business.color_sentence;

public class StringLCS {

    /* renamed from: a */
    private char[] f2226a;

    /* renamed from: b */
    private char[] f2227b;
    private int[][] fromX;
    private int[][] fromY;
    private int maxLen;
    private int[] posA;
    private int[] posB;
    private int[][] table;

    public int[] getPosA() {
        return this.posA;
    }

    public int[] getPosB() {
        return this.posB;
    }

    public int lcs(char[] cArr, char[] cArr2) {
        this.table = null;
        this.posA = null;
        this.posB = null;
        this.maxLen = 0;
        if (cArr == null || cArr.length == 0 || cArr2 == null || cArr2.length == 0) {
            return 0;
        }
        this.f2226a = cArr;
        this.f2227b = cArr2;
        int length = cArr.length;
        int length2 = cArr2.length;
        this.table = new int[(length + 1)][];
        this.fromX = new int[(length + 1)][];
        this.fromY = new int[(length + 1)][];
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new int[(length2 + 1)];
            this.fromX[i] = new int[(length2 + 1)];
            this.fromY[i] = new int[(length2 + 1)];
        }
        for (int i2 = 0; i2 <= length; i2++) {
            this.table[i2][0] = 0;
            this.fromX[i2][0] = -1;
            this.fromY[i2][0] = -1;
        }
        for (int i3 = 0; i3 <= length2; i3++) {
            this.table[0][i3] = 0;
            this.fromX[0][i3] = -1;
            this.fromY[0][i3] = -1;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 <= length; i7++) {
            for (int i8 = 1; i8 <= length2; i8++) {
                if (cArr[i7 - 1] == cArr2[i8 - 1]) {
                    this.table[i7][i8] = this.table[i7 - 1][i8 - 1] + 1;
                    this.fromX[i7][i8] = i7 - 1;
                    this.fromY[i7][i8] = i8 - 1;
                } else if (this.table[i7 - 1][i8] >= this.table[i7][i8 - 1]) {
                    this.table[i7][i8] = this.table[i7 - 1][i8];
                    this.fromX[i7][i8] = this.fromX[i7 - 1][i8];
                    this.fromY[i7][i8] = this.fromY[i7 - 1][i8];
                } else {
                    this.table[i7][i8] = this.table[i7][i8 - 1];
                    this.fromX[i7][i8] = this.fromX[i7][i8 - 1];
                    this.fromY[i7][i8] = this.fromY[i7][i8 - 1];
                }
                if (this.table[i7][i8] > i6) {
                    i5 = i7;
                    i6 = this.table[i7][i8];
                    i4 = i8;
                }
            }
        }
        this.maxLen = i6;
        this.posA = new int[i6];
        this.posB = new int[i6];
        getPath(i5, i4, i6);
        return this.maxLen;
    }

    public int lcs(String str, String str2) {
        return lcs(str.toCharArray(), str2.toCharArray());
    }

    public void getPath(int i, int i2, int i3) {
        if (i > 0 && i2 > 0 && i3 > 0) {
            int i4 = this.fromX[i][i2];
            int i5 = this.fromY[i][i2];
            int i6 = i3 - 1;
            this.posA[i6] = i4;
            this.posB[i6] = i5;
            getPath(i4, i5, i6);
        }
    }

    public void printCommon() {
        for (int i = 0; i < this.f2226a.length; i++) {
            for (int i2 = 0; i2 < this.f2227b.length; i2++) {
                System.out.print(this.table[i][i2] + "(" + this.fromX[i][i2] + "," + this.fromY[i][i2] + ") ");
            }
            System.out.println();
        }
        for (int print : this.posA) {
            System.out.print(print);
        }
        System.out.println();
        for (int print2 : this.posB) {
            System.out.print(print2);
        }
        System.out.println();
    }

    public static void main(String[] strArr) {
        StringLCS stringLCS = new StringLCS();
        System.out.println(stringLCS.lcs("progress", "process"));
        stringLCS.printCommon();
    }
}
