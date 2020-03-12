package com.baicizhan.client.business.book;

public class BookMap {
    public static final int TO_ID_CET4 = 2;
    public static final int TO_ID_CET6 = 3;
    public static final int TO_ID_GSE = 4;
    public static final int TO_ID_IELTS = 5;
    public static final int TO_ID_NMET = 1;
    public static final int TO_ID_TOEFL = 6;

    public static int toId(int i) {
        switch (i) {
            case 2:
                return 3;
            case 4:
            case 9:
                return 6;
            case 11:
                return 5;
            case 13:
            case 21:
                return 4;
            case 16:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
                return 1;
            default:
                return 2;
        }
    }
}
