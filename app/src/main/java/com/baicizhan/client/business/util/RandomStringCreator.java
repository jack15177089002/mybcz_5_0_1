package com.baicizhan.client.business.util;

import com.baicizhan.client.friend.model.FriendRecord;

public class RandomStringCreator {
    private RandomStringCreator() {
    }

    public static String bornDomain() {
        return new String[]{"daka", "show", "dk", "fx", "prize", "card", "kapian", "share", "xueba", FriendRecord.ACCOUNT_QQ}[(int) (Math.random() * 10.0d)];
    }

    public static String bornNumCharString() {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//        StringBuilder sb = new StringBuilder(System.currentTimeMillis());
//        for (int i = 0; i < 10; i++) {
//            sb.append(cArr[(int) (Math.random() * 62.0d)]);
//        }
//        return sb.toString();

        return null;
    }
}
