//package com.baicizhan.main.phrasetraining.data.bean;
//
//import java.util.List;
//
//public class PhraseGroup {
//    private static final String PHRASE_GROUPS_PATH = "phrasetraining/get_all_short_phrase_groups.json";
//    private List<Phrase> arr_short_phrase;
//    private int group_id;
//    private int group_num;
//
//    public class Phrase {
//        private int topic_id;
//        private String word;
//
//        public int getTopicId() {
//            return this.topic_id;
//        }
//
//        public String getWord() {
//            return this.word;
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder("Phrase {");
//            sb.append("topic_id: ").append(this.topic_id).append("; word: ").append(this.word).append("}");
//            return sb.toString();
//        }
//    }
//
//    public int getGroupId() {
//        return this.group_id;
//    }
//
//    public int getGroupNum() {
//        return this.group_num;
//    }
//
//    public List<Phrase> getPhrases() {
//        return this.arr_short_phrase;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("PhraseGroup {");
//        sb.append("group_id: ").append(this.group_id).append("; group_num: ").append(this.group_num).append("; arr_short_phrase: ").append(this.arr_short_phrase).append("}");
//        return sb.toString();
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[SYNTHETIC, Splitter:B:16:0x002c] */
//    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
//    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[SYNTHETIC, Splitter:B:33:0x005e] */
//    /* JADX WARNING: Removed duplicated region for block: B:36:0x0063 A[SYNTHETIC, Splitter:B:36:0x0063] */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static List<PhraseGroup> getPhraseGroups(android.content.res.AssetManager r6) {
//        /*
//            r1 = 0
//            if (r6 != 0) goto L_0x0005
//            r0 = r1
//        L_0x0004:
//            return r0
//        L_0x0005:
//            java.lang.StringBuilder r0 = new java.lang.StringBuilder
//            r0.<init>()
//            java.lang.String r2 = "phrasetraining/get_all_short_phrase_groups.json"
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
//            com.baicizhan.main.phrasetraining.data.bean.PhraseGroup$1 r5 = new com.baicizhan.main.phrasetraining.data.bean.PhraseGroup$1     // Catch:{ IOException -> 0x0026 }
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
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.main.phrasetraining.data.bean.PhraseGroup.getPhraseGroups(android.content.res.AssetManager):java.util.List");
//    }
//}
