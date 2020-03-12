//package com.baicizhan.main.phrasetraining.data.bean;
//
//public class Phrase {
//    private static final String PHRASE_PATH = "phrasetraining/packed_short_phrase.json";
//    private String exam_info;
//    private String explain_audio;
//    private String img_option;
//    private String mean_cn;
//    private String sentence;
//    private String sentence2;
//    private String sentence2_audio;
//    private String sentence2_word_highlight;
//    private String sentence_audio;
//    private String sentence_trans;
//    private String sentence_word_highlight;
//    private String sentencen2_trans;
//    private String similar_highlight;
//    private int topic_id;
//    private String word;
//    private String word_audio;
//    private String word_image;
//
//    public int getTopicId() {
//        return this.topic_id;
//    }
//
//    public String getWord() {
//        return this.word;
//    }
//
//    public String getWordImage() {
//        return this.word_image;
//    }
//
//    public String getWordAudio() {
//        return this.word_audio;
//    }
//
//    public String getSentence() {
//        return this.sentence;
//    }
//
//    public String getExplainAudio() {
//        return this.explain_audio;
//    }
//
//    public String getSentenceAudio() {
//        return this.sentence_audio;
//    }
//
//    public String getSentenceWordHighlight() {
//        return this.sentence_word_highlight;
//    }
//
//    public String getSentenceTrans() {
//        return this.sentence_trans;
//    }
//
//    public String getMeanCn() {
//        return this.mean_cn;
//    }
//
//    public String getSimilarHighlight() {
//        return this.similar_highlight;
//    }
//
//    public String getExamInfo() {
//        return this.exam_info;
//    }
//
//    public String getImgOption() {
//        return this.img_option;
//    }
//
//    public String getSentence2() {
//        return this.sentence2;
//    }
//
//    public String getSentencen2Trans() {
//        return this.sentencen2_trans;
//    }
//
//    public String getSentence2Audio() {
//        return this.sentence2_audio;
//    }
//
//    public String getSentence2WordHighlight() {
//        return this.sentence2_word_highlight;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("Phrase {");
//        sb.append("topic_id: ").append(this.topic_id).append("; word: ").append(this.word).append("; word_image: ").append(this.word_image).append("; word_audio: ").append(this.word_audio).append("; sentence: ").append(this.sentence).append("; explain_audio: ").append(this.explain_audio).append("; sentence_audio: ").append(this.sentence_audio).append("; sentence_trans: ").append(this.sentence_trans).append("; mean_cn: ").append(this.mean_cn).append("; exam_info: ").append(this.exam_info).append("; img_option: ").append(this.img_option).append("; sentence2: ").append(this.sentence2).append("; sentencen2_trans: ").append(this.sentencen2_trans).append("; sentence2_audio: ").append(this.sentence2_audio).append("}");
//        return sb.toString();
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[SYNTHETIC, Splitter:B:16:0x002c] */
//    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
//    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[SYNTHETIC, Splitter:B:33:0x005e] */
//    /* JADX WARNING: Removed duplicated region for block: B:36:0x0063 A[SYNTHETIC, Splitter:B:36:0x0063] */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static java.util.List<Phrase> getPrasesList(android.content.res.AssetManager r6) {
//        /*
//            r1 = 0
//            if (r6 != 0) goto L_0x0005
//            r0 = r1
//        L_0x0004:
//            return r0
//        L_0x0005:
//            java.lang.StringBuilder r0 = new java.lang.StringBuilder
//            r0.<init>()
//            java.lang.String r2 = "phrasetraining/packed_short_phrase.json"
//            java.io.InputStream r3 = r6.open(r2)     // Catch:{ IOException -> 0x0076, all -> 0x0059 }
//            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x007a, all -> 0x0071 }
//            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x007a, all -> 0x0071 }
//            java.lang.String r5 = "UTF-8"
//            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x007a, all -> 0x0071 }
//            r2.<init>(r4)     // Catch:{ IOException -> 0x007a, all -> 0x0071 }
//        L_0x001c:
//            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0026 }
//            if (r4 == 0) goto L_0x0036
//            r0.append(r4)     // Catch:{ IOException -> 0x0026 }
//            goto L_0x001c
//        L_0x0026:
//            r0 = move-exception
//        L_0x0027:
//            r0.printStackTrace()     // Catch:{ all -> 0x0074 }
//            if (r2 == 0) goto L_0x002f
//            r2.close()     // Catch:{ Throwable -> 0x0069 }
//        L_0x002f:
//            if (r3 == 0) goto L_0x0034
//            r3.close()     // Catch:{ Throwable -> 0x006b }
//        L_0x0034:
//            r0 = r1
//            goto L_0x0004
//        L_0x0036:
//            com.b.a.k r4 = new com.b.a.k     // Catch:{ IOException -> 0x0026 }
//            r4.<init>()     // Catch:{ IOException -> 0x0026 }
//            com.baicizhan.main.phrasetraining.data.bean.Phrase$1 r5 = new com.baicizhan.main.phrasetraining.data.bean.Phrase$1     // Catch:{ IOException -> 0x0026 }
//            r5.<init>()     // Catch:{ IOException -> 0x0026 }
//            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ IOException -> 0x0026 }
//            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0026 }
//            java.lang.Object r0 = r4.fromJson(r0, r5)     // Catch:{ IOException -> 0x0026 }
//            java.util.List r0 = (java.util.List) r0     // Catch:{ IOException -> 0x0026 }
//            r2.close()     // Catch:{ Throwable -> 0x0067 }
//        L_0x0051:
//            if (r3 == 0) goto L_0x0004
//            r3.close()     // Catch:{ Throwable -> 0x0057 }
//            goto L_0x0004
//        L_0x0057:
//            r1 = move-exception
//            goto L_0x0004
//        L_0x0059:
//            r0 = move-exception
//            r2 = r1
//            r3 = r1
//        L_0x005c:
//            if (r2 == 0) goto L_0x0061
//            r2.close()     // Catch:{ Throwable -> 0x006d }
//        L_0x0061:
//            if (r3 == 0) goto L_0x0066
//            r3.close()     // Catch:{ Throwable -> 0x006f }
//        L_0x0066:
//            throw r0
//        L_0x0067:
//            r1 = move-exception
//            goto L_0x0051
//        L_0x0069:
//            r0 = move-exception
//            goto L_0x002f
//        L_0x006b:
//            r0 = move-exception
//            goto L_0x0034
//        L_0x006d:
//            r1 = move-exception
//            goto L_0x0061
//        L_0x006f:
//            r1 = move-exception
//            goto L_0x0066
//        L_0x0071:
//            r0 = move-exception
//            r2 = r1
//            goto L_0x005c
//        L_0x0074:
//            r0 = move-exception
//            goto L_0x005c
//        L_0x0076:
//            r0 = move-exception
//            r2 = r1
//            r3 = r1
//            goto L_0x0027
//        L_0x007a:
//            r0 = move-exception
//            r2 = r1
//            goto L_0x0027
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.main.phrasetraining.data.bean.Phrase.getPrasesList(android.content.res.AssetManager):java.util.List");
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e A[SYNTHETIC, Splitter:B:17:0x002e] */
//    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033 A[SYNTHETIC, Splitter:B:20:0x0033] */
//    /* JADX WARNING: Removed duplicated region for block: B:40:0x0089 A[SYNTHETIC, Splitter:B:40:0x0089] */
//    /* JADX WARNING: Removed duplicated region for block: B:43:0x008e A[SYNTHETIC, Splitter:B:43:0x008e] */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static java.util.Map<Integer, Phrase> getPrases(android.content.res.AssetManager r7) {
//        /*
//            r1 = 0
//            if (r7 != 0) goto L_0x0005
//            r0 = r1
//        L_0x0004:
//            return r0
//        L_0x0005:
//            java.lang.StringBuilder r0 = new java.lang.StringBuilder
//            r0.<init>()
//            java.lang.String r2 = "phrasetraining/packed_short_phrase.json"
//            java.io.InputStream r4 = r7.open(r2)     // Catch:{ IOException -> 0x00b8, all -> 0x00ad }
//            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00bd, all -> 0x00b1 }
//            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00bd, all -> 0x00b1 }
//            java.lang.String r5 = "UTF-8"
//            r2.<init>(r4, r5)     // Catch:{ IOException -> 0x00bd, all -> 0x00b1 }
//            r3.<init>(r2)     // Catch:{ IOException -> 0x00bd, all -> 0x00b1 }
//        L_0x001c:
//            java.lang.String r2 = r3.readLine()     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            if (r2 == 0) goto L_0x0038
//            r0.append(r2)     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            goto L_0x001c
//        L_0x0026:
//            r0 = move-exception
//            r2 = r3
//            r3 = r4
//        L_0x0029:
//            r0.printStackTrace()     // Catch:{ all -> 0x00b4 }
//            if (r2 == 0) goto L_0x0031
//            r2.close()     // Catch:{ Throwable -> 0x00a5 }
//        L_0x0031:
//            if (r3 == 0) goto L_0x0036
//            r3.close()     // Catch:{ Throwable -> 0x00a7 }
//        L_0x0036:
//            r0 = r1
//            goto L_0x0004
//        L_0x0038:
//            com.b.a.k r2 = new com.b.a.k     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            r2.<init>()     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            com.baicizhan.main.phrasetraining.data.bean.Phrase$2 r5 = new com.baicizhan.main.phrasetraining.data.bean.Phrase$2     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            r5.<init>()     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            java.lang.Object r0 = r2.fromJson(r0, r5)     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            java.util.List r0 = (java.util.List) r0     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            if (r0 != 0) goto L_0x0063
//            org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            java.lang.String r2 = "phrases json parse unknown error."
//            r0.error(r2)     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            r3.close()     // Catch:{ Throwable -> 0x009d }
//        L_0x005c:
//            if (r4 == 0) goto L_0x0061
//            r4.close()     // Catch:{ Throwable -> 0x009f }
//        L_0x0061:
//            r0 = r1
//            goto L_0x0004
//        L_0x0063:
//            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            int r5 = r0.size()     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            r2.<init>(r5)     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            java.util.Iterator r5 = r0.iterator()     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//        L_0x0070:
//            boolean r0 = r5.hasNext()     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            if (r0 == 0) goto L_0x0092
//            java.lang.Object r0 = r5.next()     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            com.baicizhan.main.phrasetraining.data.bean.Phrase r0 = (com.baicizhan.main.phrasetraining.data.bean.Phrase) r0     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            int r6 = r0.topic_id     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            r2.put(r6, r0)     // Catch:{ IOException -> 0x0026, all -> 0x0086 }
//            goto L_0x0070
//        L_0x0086:
//            r0 = move-exception
//        L_0x0087:
//            if (r3 == 0) goto L_0x008c
//            r3.close()     // Catch:{ Throwable -> 0x00a9 }
//        L_0x008c:
//            if (r4 == 0) goto L_0x0091
//            r4.close()     // Catch:{ Throwable -> 0x00ab }
//        L_0x0091:
//            throw r0
//        L_0x0092:
//            r3.close()     // Catch:{ Throwable -> 0x00a1 }
//        L_0x0095:
//            if (r4 == 0) goto L_0x009a
//            r4.close()     // Catch:{ Throwable -> 0x00a3 }
//        L_0x009a:
//            r0 = r2
//            goto L_0x0004
//        L_0x009d:
//            r0 = move-exception
//            goto L_0x005c
//        L_0x009f:
//            r0 = move-exception
//            goto L_0x0061
//        L_0x00a1:
//            r0 = move-exception
//            goto L_0x0095
//        L_0x00a3:
//            r0 = move-exception
//            goto L_0x009a
//        L_0x00a5:
//            r0 = move-exception
//            goto L_0x0031
//        L_0x00a7:
//            r0 = move-exception
//            goto L_0x0036
//        L_0x00a9:
//            r1 = move-exception
//            goto L_0x008c
//        L_0x00ab:
//            r1 = move-exception
//            goto L_0x0091
//        L_0x00ad:
//            r0 = move-exception
//            r3 = r1
//            r4 = r1
//            goto L_0x0087
//        L_0x00b1:
//            r0 = move-exception
//            r3 = r1
//            goto L_0x0087
//        L_0x00b4:
//            r0 = move-exception
//            r4 = r3
//            r3 = r2
//            goto L_0x0087
//        L_0x00b8:
//            r0 = move-exception
//            r2 = r1
//            r3 = r1
//            goto L_0x0029
//        L_0x00bd:
//            r0 = move-exception
//            r2 = r1
//            r3 = r4
//            goto L_0x0029
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.main.phrasetraining.data.bean.Phrase.getPrases(android.content.res.AssetManager):java.util.Map");
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
//    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b A[SYNTHETIC, Splitter:B:23:0x003b] */
//    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e1 A[SYNTHETIC, Splitter:B:53:0x00e1] */
//    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e6 A[SYNTHETIC, Splitter:B:56:0x00e6] */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static java.util.Map<Integer, Phrase> getPrases(com.baicizhan.main.phrasetraining.data.bean.TopicPatterns r10, android.content.res.AssetManager r11) {
//        /*
//            r2 = 0
//            if (r11 == 0) goto L_0x000b
//            if (r10 == 0) goto L_0x000b
//            java.util.List r0 = r10.getArrTopics()
//            if (r0 != 0) goto L_0x000d
//        L_0x000b:
//            r0 = r2
//        L_0x000c:
//            return r0
//        L_0x000d:
//            java.lang.StringBuilder r0 = new java.lang.StringBuilder
//            r0.<init>()
//            java.lang.String r1 = "phrasetraining/packed_short_phrase.json"
//            java.io.InputStream r4 = r11.open(r1)     // Catch:{ IOException -> 0x0114, all -> 0x0109 }
//            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0119, all -> 0x010d }
//            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0119, all -> 0x010d }
//            java.lang.String r5 = "UTF-8"
//            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x0119, all -> 0x010d }
//            r3.<init>(r1)     // Catch:{ IOException -> 0x0119, all -> 0x010d }
//        L_0x0024:
//            java.lang.String r1 = r3.readLine()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            if (r1 == 0) goto L_0x0040
//            r0.append(r1)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            goto L_0x0024
//        L_0x002e:
//            r0 = move-exception
//            r1 = r3
//            r3 = r4
//        L_0x0031:
//            r0.printStackTrace()     // Catch:{ all -> 0x0110 }
//            if (r1 == 0) goto L_0x0039
//            r1.close()     // Catch:{ Throwable -> 0x00ff }
//        L_0x0039:
//            if (r3 == 0) goto L_0x003e
//            r3.close()     // Catch:{ Throwable -> 0x0102 }
//        L_0x003e:
//            r0 = r2
//            goto L_0x000c
//        L_0x0040:
//            com.b.a.k r1 = new com.b.a.k     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            r1.<init>()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            com.baicizhan.main.phrasetraining.data.bean.Phrase$3 r5 = new com.baicizhan.main.phrasetraining.data.bean.Phrase$3     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            r5.<init>()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.lang.Object r0 = r1.fromJson(r0, r5)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.util.List r0 = (java.util.List) r0     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            if (r0 != 0) goto L_0x006b
//            org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.lang.String r1 = "phrases json parse unknown error."
//            r0.error(r1)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            r3.close()     // Catch:{ Throwable -> 0x00f5 }
//        L_0x0064:
//            if (r4 == 0) goto L_0x0069
//            r4.close()     // Catch:{ Throwable -> 0x00f8 }
//        L_0x0069:
//            r0 = r2
//            goto L_0x000c
//        L_0x006b:
//            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            r5.<init>()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.util.List r1 = r10.getArrTopics()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.util.Iterator r6 = r1.iterator()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//        L_0x0078:
//            boolean r1 = r6.hasNext()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            if (r1 == 0) goto L_0x00af
//            java.lang.Object r1 = r6.next()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            com.baicizhan.main.phrasetraining.data.bean.TopicPatterns$Topic r1 = (com.baicizhan.main.phrasetraining.data.bean.TopicPatterns.Topic) r1     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            int r7 = r1.getTopicId()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            r5.add(r7)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.lang.String r1 = r1.getGroupedTopicIds()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            boolean r7 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            if (r7 != 0) goto L_0x0078
//            java.lang.String r7 = ","
//            java.lang.String[] r7 = r1.split(r7)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            int r8 = r7.length     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            r1 = 0
//        L_0x00a1:
//            if (r1 >= r8) goto L_0x0078
//            r9 = r7[r1]     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            r5.add(r9)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            int r1 = r1 + 1
//            goto L_0x00a1
//        L_0x00af:
//            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            int r6 = r0.size()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            r1.<init>(r6)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.util.Iterator r6 = r0.iterator()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//        L_0x00bc:
//            boolean r0 = r6.hasNext()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            if (r0 == 0) goto L_0x00ea
//            java.lang.Object r0 = r6.next()     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            com.baicizhan.main.phrasetraining.data.bean.Phrase r0 = (com.baicizhan.main.phrasetraining.data.bean.Phrase) r0     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            int r7 = r0.topic_id     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            boolean r7 = r5.contains(r7)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            if (r7 == 0) goto L_0x00bc
//            int r7 = r0.topic_id     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            r1.put(r7, r0)     // Catch:{ IOException -> 0x002e, all -> 0x00de }
//            goto L_0x00bc
//        L_0x00de:
//            r0 = move-exception
//        L_0x00df:
//            if (r3 == 0) goto L_0x00e4
//            r3.close()     // Catch:{ Throwable -> 0x0105 }
//        L_0x00e4:
//            if (r4 == 0) goto L_0x00e9
//            r4.close()     // Catch:{ Throwable -> 0x0107 }
//        L_0x00e9:
//            throw r0
//        L_0x00ea:
//            r3.close()     // Catch:{ Throwable -> 0x00fb }
//        L_0x00ed:
//            if (r4 == 0) goto L_0x00f2
//            r4.close()     // Catch:{ Throwable -> 0x00fd }
//        L_0x00f2:
//            r0 = r1
//            goto L_0x000c
//        L_0x00f5:
//            r0 = move-exception
//            goto L_0x0064
//        L_0x00f8:
//            r0 = move-exception
//            goto L_0x0069
//        L_0x00fb:
//            r0 = move-exception
//            goto L_0x00ed
//        L_0x00fd:
//            r0 = move-exception
//            goto L_0x00f2
//        L_0x00ff:
//            r0 = move-exception
//            goto L_0x0039
//        L_0x0102:
//            r0 = move-exception
//            goto L_0x003e
//        L_0x0105:
//            r1 = move-exception
//            goto L_0x00e4
//        L_0x0107:
//            r1 = move-exception
//            goto L_0x00e9
//        L_0x0109:
//            r0 = move-exception
//            r3 = r2
//            r4 = r2
//            goto L_0x00df
//        L_0x010d:
//            r0 = move-exception
//            r3 = r2
//            goto L_0x00df
//        L_0x0110:
//            r0 = move-exception
//            r4 = r3
//            r3 = r1
//            goto L_0x00df
//        L_0x0114:
//            r0 = move-exception
//            r1 = r2
//            r3 = r2
//            goto L_0x0031
//        L_0x0119:
//            r0 = move-exception
//            r1 = r2
//            r3 = r4
//            goto L_0x0031
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.main.phrasetraining.data.bean.Phrase.getPrases(com.baicizhan.main.phrasetraining.data.bean.TopicPatterns, android.content.res.AssetManager):java.util.Map");
//    }
//}
