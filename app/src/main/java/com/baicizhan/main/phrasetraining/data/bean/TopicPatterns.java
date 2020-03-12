//package com.baicizhan.main.phrasetraining.data.bean;
//
//import java.util.List;
//
//public class TopicPatterns {
//    private static final String TOPIC_PATTERNS_PATH = "phrasetraining/get_short_phrase_topics_by_group.json";
//    private List<Topic> arr_topics;
//    private int group_id;
//
//    public class Topic {
//        private String grouped_options;
//        private String grouped_topic_ids;
//        private int is_do_example;
//        private String tips;
//        private int topic_id;
//        private int type_hint;
//
//        public int getTypeHint() {
//            return this.type_hint;
//        }
//
//        public String getTips() {
//            return this.tips;
//        }
//
//        public String getGroupedTopicIds() {
//            return this.grouped_topic_ids;
//        }
//
//        public int getIsDoExample() {
//            return this.is_do_example;
//        }
//
//        public int getTopicId() {
//            return this.topic_id;
//        }
//
//        public String getGroupedOptions() {
//            return this.grouped_options;
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("Topic {");
//            sb.append("type_hint: ").append(this.type_hint).append("; tips: ").append(this.tips).append("; grouped_topic_ids: ").append(this.grouped_topic_ids).append("; is_do_example: ").append(this.is_do_example).append("; topic_id: ").append(this.topic_id).append("; grouped_options: ").append(this.grouped_options).append("}");
//            return sb.toString();
//        }
//    }
//
//    public int getGroupId() {
//        return this.group_id;
//    }
//
//    public List<Topic> getArrTopics() {
//        return this.arr_topics;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("TopicPatterns {");
//        sb.append("group_id: ").append(this.group_id).append("; attr_topics: ").append(this.arr_topics).append("}");
//        return sb.toString();
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[SYNTHETIC, Splitter:B:16:0x002c] */
//    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
//    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[SYNTHETIC, Splitter:B:33:0x005e] */
//    /* JADX WARNING: Removed duplicated region for block: B:36:0x0063 A[SYNTHETIC, Splitter:B:36:0x0063] */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static List<TopicPatterns> getTopicPatterns(android.content.res.AssetManager r6) {
//        /*
//            r1 = 0
//            if (r6 != 0) goto L_0x0005
//            r0 = r1
//        L_0x0004:
//            return r0
//        L_0x0005:
//            java.lang.StringBuilder r0 = new java.lang.StringBuilder
//            r0.<init>()
//            java.lang.String r2 = "phrasetraining/get_short_phrase_topics_by_group.json"
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
//            com.baicizhan.main.phrasetraining.data.bean.TopicPatterns$1 r5 = new com.baicizhan.main.phrasetraining.data.bean.TopicPatterns$1     // Catch:{ IOException -> 0x0026 }
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
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.main.phrasetraining.data.bean.TopicPatterns.getTopicPatterns(android.content.res.AssetManager):java.util.List");
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[SYNTHETIC, Splitter:B:16:0x002c] */
//    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
//    /* JADX WARNING: Removed duplicated region for block: B:49:0x0094 A[SYNTHETIC, Splitter:B:49:0x0094] */
//    /* JADX WARNING: Removed duplicated region for block: B:52:0x0099 A[SYNTHETIC, Splitter:B:52:0x0099] */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static TopicPatterns getTopicPatternsOfGroup(int r7, android.content.res.AssetManager r8) {
//        /*
//            r1 = 0
//            if (r8 != 0) goto L_0x0005
//            r0 = r1
//        L_0x0004:
//            return r0
//        L_0x0005:
//            java.lang.StringBuilder r0 = new java.lang.StringBuilder
//            r0.<init>()
//            java.lang.String r2 = "phrasetraining/get_short_phrase_topics_by_group.json"
//            java.io.InputStream r3 = r8.open(r2)     // Catch:{ IOException -> 0x00b0, all -> 0x008f }
//            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b5, all -> 0x00ab }
//            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b5, all -> 0x00ab }
//            java.lang.String r5 = "UTF-8"
//            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x00b5, all -> 0x00ab }
//            r2.<init>(r4)     // Catch:{ IOException -> 0x00b5, all -> 0x00ab }
//        L_0x001c:
//            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0026 }
//            if (r4 == 0) goto L_0x0036
//            r0.append(r4)     // Catch:{ IOException -> 0x0026 }
//            goto L_0x001c
//        L_0x0026:
//            r0 = move-exception
//        L_0x0027:
//            r0.printStackTrace()     // Catch:{ all -> 0x00ae }
//            if (r2 == 0) goto L_0x002f
//            r2.close()     // Catch:{ Throwable -> 0x00a3 }
//        L_0x002f:
//            if (r3 == 0) goto L_0x0034
//            r3.close()     // Catch:{ Throwable -> 0x00a5 }
//        L_0x0034:
//            r0 = r1
//            goto L_0x0004
//        L_0x0036:
//            com.b.a.k r4 = new com.b.a.k     // Catch:{ IOException -> 0x0026 }
//            r4.<init>()     // Catch:{ IOException -> 0x0026 }
//            com.baicizhan.main.phrasetraining.data.bean.TopicPatterns$2 r5 = new com.baicizhan.main.phrasetraining.data.bean.TopicPatterns$2     // Catch:{ IOException -> 0x0026 }
//            r5.<init>()     // Catch:{ IOException -> 0x0026 }
//            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ IOException -> 0x0026 }
//            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0026 }
//            java.lang.Object r0 = r4.fromJson(r0, r5)     // Catch:{ IOException -> 0x0026 }
//            java.util.List r0 = (java.util.List) r0     // Catch:{ IOException -> 0x0026 }
//            if (r0 != 0) goto L_0x0061
//            org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x0026 }
//            java.lang.String r4 = "topic patterns json parse unknown error."
//            r0.error(r4)     // Catch:{ IOException -> 0x0026 }
//            r2.close()     // Catch:{ Throwable -> 0x009d }
//        L_0x005a:
//            if (r3 == 0) goto L_0x005f
//            r3.close()     // Catch:{ Throwable -> 0x009f }
//        L_0x005f:
//            r0 = r1
//            goto L_0x0004
//        L_0x0061:
//            java.util.Iterator r4 = r0.iterator()     // Catch:{ IOException -> 0x0026 }
//        L_0x0065:
//            boolean r0 = r4.hasNext()     // Catch:{ IOException -> 0x0026 }
//            if (r0 == 0) goto L_0x00b9
//            java.lang.Object r0 = r4.next()     // Catch:{ IOException -> 0x0026 }
//            com.baicizhan.main.phrasetraining.data.bean.TopicPatterns r0 = (com.baicizhan.main.phrasetraining.data.bean.TopicPatterns) r0     // Catch:{ IOException -> 0x0026 }
//            int r5 = r0.group_id     // Catch:{ IOException -> 0x0026 }
//            if (r7 != r5) goto L_0x0065
//        L_0x0075:
//            if (r0 != 0) goto L_0x0082
//            org.slf4j.Logger r4 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ IOException -> 0x0026 }
//            java.lang.String r5 = "topic patterns json parse error, group id is not exists [{}]"
//            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x0026 }
//            r4.error(r5, r6)     // Catch:{ IOException -> 0x0026 }
//        L_0x0082:
//            r2.close()     // Catch:{ Throwable -> 0x00a1 }
//        L_0x0085:
//            if (r3 == 0) goto L_0x0004
//            r3.close()     // Catch:{ Throwable -> 0x008c }
//            goto L_0x0004
//        L_0x008c:
//            r1 = move-exception
//            goto L_0x0004
//        L_0x008f:
//            r0 = move-exception
//            r2 = r1
//            r3 = r1
//        L_0x0092:
//            if (r2 == 0) goto L_0x0097
//            r2.close()     // Catch:{ Throwable -> 0x00a7 }
//        L_0x0097:
//            if (r3 == 0) goto L_0x009c
//            r3.close()     // Catch:{ Throwable -> 0x00a9 }
//        L_0x009c:
//            throw r0
//        L_0x009d:
//            r0 = move-exception
//            goto L_0x005a
//        L_0x009f:
//            r0 = move-exception
//            goto L_0x005f
//        L_0x00a1:
//            r1 = move-exception
//            goto L_0x0085
//        L_0x00a3:
//            r0 = move-exception
//            goto L_0x002f
//        L_0x00a5:
//            r0 = move-exception
//            goto L_0x0034
//        L_0x00a7:
//            r1 = move-exception
//            goto L_0x0097
//        L_0x00a9:
//            r1 = move-exception
//            goto L_0x009c
//        L_0x00ab:
//            r0 = move-exception
//            r2 = r1
//            goto L_0x0092
//        L_0x00ae:
//            r0 = move-exception
//            goto L_0x0092
//        L_0x00b0:
//            r0 = move-exception
//            r2 = r1
//            r3 = r1
//            goto L_0x0027
//        L_0x00b5:
//            r0 = move-exception
//            r2 = r1
//            goto L_0x0027
//        L_0x00b9:
//            r0 = r1
//            goto L_0x0075
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.main.phrasetraining.data.bean.TopicPatterns.getTopicPatternsOfGroup(int, android.content.res.AssetManager):com.baicizhan.main.phrasetraining.data.bean.TopicPatterns");
//    }
//}
