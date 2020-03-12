//package com.baicizhan.learning_strategy.core;
//
//import java.io.File;
//
//public class FileLoader implements Loader {
//    File file;
//
//    public FileLoader(File file2) {
//        this.file = file2;
//    }
//
//    /* JADX WARNING: type inference failed for: r0v0 */
//    /* JADX WARNING: type inference failed for: r2v0 */
//    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.BufferedReader] */
//    /* JADX WARNING: type inference failed for: r2v2 */
//    /* JADX WARNING: type inference failed for: r0v3, types: [com.baicizhan.learning_strategy.iface.LearningManager] */
//    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.BufferedReader] */
//    /* JADX WARNING: type inference failed for: r0v7, types: [com.baicizhan.learning_strategy.iface.LearningManager] */
//    /* JADX WARNING: type inference failed for: r0v8 */
//    /* JADX WARNING: type inference failed for: r0v9 */
//    /* JADX WARNING: type inference failed for: r2v5 */
//    /* JADX WARNING: type inference failed for: r2v6 */
//    /* JADX WARNING: type inference failed for: r0v10 */
//    /* JADX WARNING: type inference failed for: r0v11 */
//    /* JADX WARNING: Multi-variable type inference failed */
//    /* JADX WARNING: Unknown variable types count: 5 */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public com.baicizhan.learning_strategy.iface.LearningManager load() {
//        /*
//            r5 = this;
//            r0 = 0
//            java.lang.StringBuffer r1 = new java.lang.StringBuffer
//            r1.<init>()
//            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x004d, all -> 0x0040 }
//            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x004d, all -> 0x0040 }
//            java.io.File r4 = r5.file     // Catch:{ Exception -> 0x004d, all -> 0x0040 }
//            r3.<init>(r4)     // Catch:{ Exception -> 0x004d, all -> 0x0040 }
//            r2.<init>(r3)     // Catch:{ Exception -> 0x004d, all -> 0x0040 }
//        L_0x0012:
//            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0021 }
//            if (r3 == 0) goto L_0x002d
//            r1.append(r3)     // Catch:{ Exception -> 0x0021 }
//            java.lang.String r3 = "\n"
//            r1.append(r3)     // Catch:{ Exception -> 0x0021 }
//            goto L_0x0012
//        L_0x0021:
//            r1 = move-exception
//        L_0x0022:
//            org.slf4j.Logger r3 = com.baicizhan.learning_strategy.util.C0975L.log     // Catch:{ all -> 0x004b }
//            java.lang.String r4 = "load error"
//            r3.error(r4, r1)     // Catch:{ all -> 0x004b }
//            r2.close()     // Catch:{ Exception -> 0x0047 }
//        L_0x002c:
//            return r0
//        L_0x002d:
//            com.baicizhan.learning_strategy.core.StringLoader r3 = new com.baicizhan.learning_strategy.core.StringLoader     // Catch:{ Exception -> 0x0021 }
//            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0021 }
//            r3.<init>(r1)     // Catch:{ Exception -> 0x0021 }
//            com.baicizhan.learning_strategy.iface.LearningManager r0 = r3.load()     // Catch:{ Exception -> 0x0021 }
//            r2.close()     // Catch:{ Exception -> 0x003e }
//            goto L_0x002c
//        L_0x003e:
//            r1 = move-exception
//            goto L_0x002c
//        L_0x0040:
//            r1 = move-exception
//            r2 = r0
//            r0 = r1
//        L_0x0043:
//            r2.close()     // Catch:{ Exception -> 0x0049 }
//        L_0x0046:
//            throw r0
//        L_0x0047:
//            r1 = move-exception
//            goto L_0x002c
//        L_0x0049:
//            r1 = move-exception
//            goto L_0x0046
//        L_0x004b:
//            r0 = move-exception
//            goto L_0x0043
//        L_0x004d:
//            r1 = move-exception
//            r2 = r0
//            goto L_0x0022
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.learning_strategy.core.FileLoader.load():com.baicizhan.learning_strategy.iface.LearningManager");
//    }
//}
