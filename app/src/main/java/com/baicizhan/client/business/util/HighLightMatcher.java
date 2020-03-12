package com.baicizhan.client.business.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighLightMatcher {
    public static Pattern ENGLISH_WORD_PATTERN = Pattern.compile("([a-zA-Z']+(-[a-zA-Z]+)*)");

    public class Segment {
        private int end;
        private int start;
        private String word;

        public Segment(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }

        public String getWord() {
            return this.word;
        }

        public void setWord(String str) {
            this.word = str;
        }
    }

    public static List<Segment> splitEnglishWords(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = ENGLISH_WORD_PATTERN.matcher(charSequence);
//        while (matcher.find()) {
//            Segment segment = new Segment(matcher.start(), matcher.end());
//            segment.setWord(matcher.group());
//            arrayList.add(segment);
//        }
        return arrayList;
    }
}
