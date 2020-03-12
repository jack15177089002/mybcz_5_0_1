//package com.baicizhan.main.utils;
//
//import android.text.TextUtils;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class EtymaExtractor {
//    private static Pattern sWordPattern = null;
//
//    public static List<String> extractEtymaTokens(String str, String str2) {
//        if (TextUtils.isEmpty(str2)) {
//            return Collections.emptyList();
//        }
//        if (sWordPattern == null) {
//            sWordPattern = Pattern.compile("(-?[a-zA-Z]+-?)");
//        }
//        Matcher matcher = sWordPattern.matcher(str2);
//        ArrayList arrayList = new ArrayList(6);
//        int i = 0;
//        while (matcher.find()) {
//            String group = matcher.group();
//            if (str.startsWith(group, i)) {
//                arrayList.add(group);
//                i += group.length();
//                if (i == str.length()) {
//                    return arrayList;
//                }
//            }
//        }
//        return Collections.singletonList(str);
//    }
//}
