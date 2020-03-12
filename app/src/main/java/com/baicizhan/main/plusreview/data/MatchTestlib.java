//package com.baicizhan.main.plusreview.data;
//
//import com.baicizhan.main.plusreview.data.p034db.MatchResultRecord;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public class MatchTestlib {
//    private Map<Integer, MatchResultRecord> result_records;
//    private int review_count;
//    private List<Word> review_words;
//
//    public class BingSentence {
//        private String digest_sentence;
//        private String sentence;
//        private String sentence_trans;
//
//        public String getSentence() {
//            return this.sentence;
//        }
//
//        public void setSentence(String str) {
//            this.sentence = str;
//        }
//
//        public String getSentence_trans() {
//            return this.sentence_trans;
//        }
//
//        public void setSentence_trans(String str) {
//            this.sentence_trans = str;
//        }
//
//        public String getDigest_sentence() {
//            return this.digest_sentence;
//        }
//
//        public void setDigest_sentence(String str) {
//            this.digest_sentence = str;
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("RightOptSentence {");
//            sb.append("[sentence: ").append(this.sentence).append("]; [sentence_trans: ").append(this.sentence_trans).append("]; [digest_sentence: ").append(this.digest_sentence).append("]}");
//            return sb.toString();
//        }
//    }
//
//    public class Other {
//        private int en_word_id;
//        private String mean_cn;
//        private String word;
//
//        public int getEn_word_id() {
//            return this.en_word_id;
//        }
//
//        public void setEn_word_id(int i) {
//            this.en_word_id = i;
//        }
//
//        public String getWord() {
//            return this.word;
//        }
//
//        public void setWord(String str) {
//            this.word = str;
//        }
//
//        public String getMean_cn() {
//            return this.mean_cn;
//        }
//
//        public void setMean_cn(String str) {
//            this.mean_cn = str;
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("Other {");
//            sb.append("[en_word_id: ").append(this.en_word_id).append("]; [word: ").append(this.word).append("]; [mean_cn: ").append(this.mean_cn).append("]}");
//            return sb.toString();
//        }
//    }
//
//    public class RightOption {
//        private List<BingSentence> arr_bing_sentences;
//        private int en_word_id;
//        private String mean_cn;
//        private String word;
//
//        public int getEn_word_id() {
//            return this.en_word_id;
//        }
//
//        public void setEn_word_id(int i) {
//            this.en_word_id = i;
//        }
//
//        public String getWord() {
//            return this.word;
//        }
//
//        public void setWord(String str) {
//            this.word = str;
//        }
//
//        public String getMean_cn() {
//            return this.mean_cn;
//        }
//
//        public void setMean_cn(String str) {
//            this.mean_cn = str;
//        }
//
//        public List<BingSentence> getArr_bing_sentences() {
//            return this.arr_bing_sentences;
//        }
//
//        public void setArr_bing_sentences(List<BingSentence> list) {
//            this.arr_bing_sentences = list;
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("RightOption {");
//            sb.append("[en_word_id: ").append(this.en_word_id).append("]; [word: ").append(this.word).append("]; [mean_cn: ").append(this.mean_cn).append("]; [arr_bing_sentences: ").append(this.arr_bing_sentences).append("]}");
//            return sb.toString();
//        }
//    }
//
//    public class Word {
//        private List<Other> arr_other_options;
//        private List<RightOption> arr_right_options;
//        private int type_hint;
//        /* access modifiers changed from: private */
//        public int word_topic_id;
//
//        public int getWord_topic_id() {
//            return this.word_topic_id;
//        }
//
//        public void setWord_topic_id(int i) {
//            this.word_topic_id = i;
//        }
//
//        public int getType_hint() {
//            return this.type_hint;
//        }
//
//        public void setType_hint(int i) {
//            this.type_hint = i;
//        }
//
//        public List<RightOption> getArr_right_options() {
//            return this.arr_right_options;
//        }
//
//        public void setArr_right_options(List<RightOption> list) {
//            this.arr_right_options = list;
//        }
//
//        public List<Other> getArr_other_options() {
//            return this.arr_other_options;
//        }
//
//        public void setArr_other_options(List<Other> list) {
//            this.arr_other_options = list;
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("Word {");
//            sb.append("[word_topic_id: ").append(this.word_topic_id).append("]; [type_hint: ").append(this.type_hint).append("]; [arr_right_options: ").append(this.arr_right_options).append("]; [arr_other_options: ").append(this.arr_other_options).append("]}");
//            return sb.toString();
//        }
//    }
//
//    public List<Word> getReview_words() {
//        return this.review_words;
//    }
//
//    public void setReview_words(List<Word> list) {
//        this.review_words = list;
//    }
//
//    public int getReview_count() {
//        return this.review_count;
//    }
//
//    public void setReview_count(int i) {
//        this.review_count = i;
//    }
//
//    public Map<Integer, MatchResultRecord> getResult_records() {
//        return this.result_records;
//    }
//
//    public void setResult_records(Map<Integer, MatchResultRecord> map) {
//        this.result_records = map;
//    }
//
//    public String toString() {
//        return "MatchTestlib {review_words [" + this.review_words + "]}";
//    }
//
//    public List<Integer> getTopicIds(int i, int i2) {
//        if (this.review_words == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList();
//        int size = this.review_words.size();
//        int i3 = 0;
//        while (i < size) {
//            arrayList.add(Integer.valueOf(((Word) this.review_words.get(i)).word_topic_id));
//            int i4 = i3 + 1;
//            if (i4 == i2) {
//                break;
//            }
//            i++;
//            i3 = i4;
//        }
//        return arrayList;
//    }
//
//    public List<Integer> getTopicIds(int i) {
//        if (this.review_words == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList();
//        int i2 = 0;
//        Iterator it = this.review_words.iterator();
//        while (true) {
//            int i3 = i2;
//            if (!it.hasNext()) {
//                break;
//            }
//            arrayList.add(Integer.valueOf(((Word) it.next()).word_topic_id));
//            i2 = i3 + 1;
//            if (i2 == i) {
//                break;
//            }
//        }
//        return arrayList;
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e A[LOOP:0: B:4:0x0013->B:15:0x004e, LOOP_END] */
//    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[EDGE_INSN: B:18:0x004c->B:14:0x004c ?: BREAK  , SYNTHETIC] */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public List<Integer> getUnfinishedTopicIds(int r7) {
//        /*
//            r6 = this;
//            java.util.List<com.baicizhan.main.plusreview.data.MatchTestlib$Word> r0 = r6.review_words
//            if (r0 != 0) goto L_0x0006
//            r0 = 0
//        L_0x0005:
//            return r0
//        L_0x0006:
//            java.util.ArrayList r3 = new java.util.ArrayList
//            r3.<init>()
//            r0 = 0
//            java.util.List<com.baicizhan.main.plusreview.data.MatchTestlib$Word> r1 = r6.review_words
//            java.util.Iterator r4 = r1.iterator()
//            r2 = r0
//        L_0x0013:
//            boolean r0 = r4.hasNext()
//            if (r0 == 0) goto L_0x004c
//            java.lang.Object r0 = r4.next()
//            com.baicizhan.main.plusreview.data.MatchTestlib$Word r0 = (com.baicizhan.main.plusreview.data.MatchTestlib.Word) r0
//            java.util.Map<java.lang.Integer, com.baicizhan.main.plusreview.data.db.MatchResultRecord> r1 = r6.result_records
//            if (r1 == 0) goto L_0x0050
//            java.util.Map<java.lang.Integer, com.baicizhan.main.plusreview.data.db.MatchResultRecord> r1 = r6.result_records
//            int r5 = r0.word_topic_id
//            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
//            java.lang.Object r1 = r1.get(r5)
//            com.baicizhan.main.plusreview.data.db.MatchResultRecord r1 = (com.baicizhan.main.plusreview.data.p034db.MatchResultRecord) r1
//            if (r1 == 0) goto L_0x0050
//            int r1 = r1.getResult()
//            r5 = 1
//            if (r1 == r5) goto L_0x0050
//            int r0 = r0.word_topic_id
//            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
//            r3.add(r0)
//            int r2 = r2 + 1
//            r0 = r2
//        L_0x004a:
//            if (r0 != r7) goto L_0x004e
//        L_0x004c:
//            r0 = r3
//            goto L_0x0005
//        L_0x004e:
//            r2 = r0
//            goto L_0x0013
//        L_0x0050:
//            r0 = r2
//            goto L_0x004a
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.main.plusreview.data.MatchTestlib.getUnfinishedTopicIds(int):java.util.List");
//    }
//
//    public boolean isEmpty() {
//        return this.review_count <= 0 || this.review_words == null || this.review_words.isEmpty();
//    }
//
//    public static MatchTestlib parse(String str) {
//        return (MatchTestlib) new Gson().fromJson(str, new TypeToken<MatchTestlib>() {
//        }.getType());
//    }
//}
