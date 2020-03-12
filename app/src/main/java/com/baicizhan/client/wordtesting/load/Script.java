package com.baicizhan.client.wordtesting.load;

import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.util.Timer;
import com.baicizhan.client.wordtesting.bean.Result;
import com.baicizhan.client.wordtesting.bean.Testing;
import com.baicizhan.client.wordtesting.bean.Word;
import com.baicizhan.main.auth.ThirdPartyUserInfo;
import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.Scriptable;

public class Script {
    private static final Script instance = new Script();
    private volatile Testing currentTesting = null;
    private volatile boolean finished = false;
    private ProgressHandler handler = null;
    private volatile Scriptable scriptable = null;

    public interface ProgressHandler {
        void handle(int i);
    }

    public static final Script getInstance() {
        return instance;
    }

    private Script() {
    }

    public void setProgressHandler(ProgressHandler progressHandler) {
        this.handler = progressHandler;
    }

    private void doHandle(int i) {
        if (this.handler != null) {
            this.handler.handle(i);
        }
    }

    public synchronized boolean isLoaded() {
        return this.scriptable != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0189 A[SYNTHETIC, Splitter:B:79:0x0189] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018e A[SYNTHETIC, Splitter:B:82:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01aa A[SYNTHETIC, Splitter:B:94:0x01aa] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01af A[SYNTHETIC, Splitter:B:97:0x01af] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean load(int r13, java.io.InputStream r14, java.io.InputStream r15) {
        /*
            r12 = this;
            r0 = 1
            r3 = 0
            r1 = 0
            monitor-enter(r12)
            r2 = 5
            r12.doHandle(r2)     // Catch:{ all -> 0x0070 }
            org.mozilla.javascript.dr r2 = r12.scriptable     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x001a
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "context and scriptable is already loaded"
            r1.debug(r2)     // Catch:{ all -> 0x0070 }
            r1 = 100
            r12.doHandle(r1)     // Catch:{ all -> 0x0070 }
        L_0x0018:
            monitor-exit(r12)
            return r0
        L_0x001a:
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            java.lang.String r4 = "begin loading js data..."
            r2.info(r4)     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            com.baicizhan.client.framework.util.Timer r5 = new com.baicizhan.client.framework.util.Timer     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            r5.<init>()     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            r5.start()     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            com.baicizhan.client.framework.util.Timer r6 = new com.baicizhan.client.framework.util.Timer     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            r6.<init>()     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            r6.start()     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            r2.<init>(r15)     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            r4.<init>(r2)     // Catch:{ Throwable -> 0x0176, all -> 0x019d }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x01da, all -> 0x01d2 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x01da, all -> 0x01d2 }
            r7.<init>(r14)     // Catch:{ Throwable -> 0x01da, all -> 0x01d2 }
            r2.<init>(r7)     // Catch:{ Throwable -> 0x01da, all -> 0x01d2 }
            r3 = 10
            r12.doHandle(r3)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r3 = r12.loadData(r4)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            if (r3 != 0) goto L_0x0073
            org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r3 = "load data error"
            r0.error(r3)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r0 = 100
            r12.doHandle(r0)     // Catch:{ all -> 0x0070 }
            org.mozilla.javascript.Context.m6766c()     // Catch:{ Exception -> 0x0067 }
        L_0x005f:
            r2.close()     // Catch:{ IOException -> 0x01bc }
        L_0x0062:
            r4.close()     // Catch:{ IOException -> 0x01bf }
        L_0x0065:
            r0 = r1
            goto L_0x0018
        L_0x0067:
            r0 = move-exception
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0070 }
            java.lang.String r5 = "context exit error"
            r3.warn(r5, r0)     // Catch:{ all -> 0x0070 }
            goto L_0x005f
        L_0x0070:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        L_0x0073:
            r7 = 30
            r12.doHandle(r7)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            org.mozilla.javascript.bc r3 = r12.getDataArray(r3)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            if (r3 == 0) goto L_0x0084
            boolean r7 = r3.isEmpty()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            if (r7 == 0) goto L_0x00a5
        L_0x0084:
            org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r3 = "get data array error"
            r0.error(r3)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r0 = 100
            r12.doHandle(r0)     // Catch:{ all -> 0x0070 }
            org.mozilla.javascript.Context.m6766c()     // Catch:{ Exception -> 0x009c }
        L_0x0093:
            r2.close()     // Catch:{ IOException -> 0x01c2 }
        L_0x0096:
            r4.close()     // Catch:{ IOException -> 0x01c5 }
        L_0x0099:
            r0 = r1
            goto L_0x0018
        L_0x009c:
            r0 = move-exception
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0070 }
            java.lang.String r5 = "context exit error"
            r3.warn(r5, r0)     // Catch:{ all -> 0x0070 }
            goto L_0x0093
        L_0x00a5:
            org.slf4j.Logger r7 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r8 = "total load [{}] words, use time [{}]"
            int r9 = r3.size()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            long r10 = r6.stop()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r7.info(r8, r9, r10)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r7 = 50
            r12.doHandle(r7)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r6.start()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            org.mozilla.javascript.l r7 = org.mozilla.javascript.Context.m6762b()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            org.slf4j.Logger r8 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r9 = "context enter {}"
            r8.debug(r9, r7)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r8 = -1
            r7.mo19137a(r8)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            org.mozilla.javascript.ds r8 = org.mozilla.javascript.ScriptRuntime.m6372a(r7)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r9 = 60
            r12.doHandle(r9)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            int r9 = com.baicizhan.client.business.book.BookMap.toId(r13)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r10 = "booklevel"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r8.put(r10, r8, r11)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r10 = "word_list"
            r8.put(r10, r8, r3)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r10 = "current book id in script [{}]"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3.debug(r10, r9)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r9 = "add data to js done, use time [{}]"
            long r10 = r6.stop()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3.info(r9, r10)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3 = 70
            r12.doHandle(r3)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r6.start()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r7.mo19133a(r8, r2)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3 = 80
            r12.doHandle(r3)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r9 = "add script to js done, use time [{}]"
            long r10 = r6.stop()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3.info(r9, r10)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r6.start()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r3 = "Vocabtest.init(word_list, booklevel)"
            r7.mo19134a(r8, r3)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r7 = "invoke js init done, use time [{}]"
            long r10 = r6.stop()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3.info(r7, r6)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3 = 90
            r12.doHandle(r3)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r12.scriptable = r8     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3 = 0
            r12.finished = r3     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3 = 0
            r12.currentTesting = r3     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.String r6 = "load js data done, total use time [{}]"
            long r8 = r5.stop()     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r8)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r3.info(r6, r5)     // Catch:{ Throwable -> 0x01de, all -> 0x01d5 }
            r1 = 100
            r12.doHandle(r1)     // Catch:{ all -> 0x0070 }
            org.mozilla.javascript.Context.m6766c()     // Catch:{ Exception -> 0x016d }
        L_0x0162:
            r2.close()     // Catch:{ IOException -> 0x01c8 }
        L_0x0165:
            r4.close()     // Catch:{ IOException -> 0x016a }
            goto L_0x0018
        L_0x016a:
            r1 = move-exception
            goto L_0x0018
        L_0x016d:
            r1 = move-exception
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0070 }
            java.lang.String r5 = "context exit error"
            r3.warn(r5, r1)     // Catch:{ all -> 0x0070 }
            goto L_0x0162
        L_0x0176:
            r0 = move-exception
            r2 = r3
        L_0x0178:
            org.slf4j.Logger r4 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = "load script error"
            r4.error(r5, r0)     // Catch:{ all -> 0x01d7 }
            r0 = 100
            r12.doHandle(r0)     // Catch:{ all -> 0x0070 }
            org.mozilla.javascript.Context.m6766c()     // Catch:{ Exception -> 0x0194 }
        L_0x0187:
            if (r2 == 0) goto L_0x018c
            r2.close()     // Catch:{ IOException -> 0x01ca }
        L_0x018c:
            if (r3 == 0) goto L_0x0191
            r3.close()     // Catch:{ IOException -> 0x01cc }
        L_0x0191:
            r0 = r1
            goto L_0x0018
        L_0x0194:
            r0 = move-exception
            org.slf4j.Logger r4 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0070 }
            java.lang.String r5 = "context exit error"
            r4.warn(r5, r0)     // Catch:{ all -> 0x0070 }
            goto L_0x0187
        L_0x019d:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L_0x01a0:
            r1 = 100
            r12.doHandle(r1)     // Catch:{ all -> 0x0070 }
            org.mozilla.javascript.Context.m6766c()     // Catch:{ Exception -> 0x01b3 }
        L_0x01a8:
            if (r2 == 0) goto L_0x01ad
            r2.close()     // Catch:{ IOException -> 0x01ce }
        L_0x01ad:
            if (r4 == 0) goto L_0x01b2
            r4.close()     // Catch:{ IOException -> 0x01d0 }
        L_0x01b2:
            throw r0     // Catch:{ all -> 0x0070 }
        L_0x01b3:
            r1 = move-exception
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0070 }
            java.lang.String r5 = "context exit error"
            r3.warn(r5, r1)     // Catch:{ all -> 0x0070 }
            goto L_0x01a8
        L_0x01bc:
            r0 = move-exception
            goto L_0x0062
        L_0x01bf:
            r0 = move-exception
            goto L_0x0065
        L_0x01c2:
            r0 = move-exception
            goto L_0x0096
        L_0x01c5:
            r0 = move-exception
            goto L_0x0099
        L_0x01c8:
            r1 = move-exception
            goto L_0x0165
        L_0x01ca:
            r0 = move-exception
            goto L_0x018c
        L_0x01cc:
            r0 = move-exception
            goto L_0x0191
        L_0x01ce:
            r1 = move-exception
            goto L_0x01ad
        L_0x01d0:
            r1 = move-exception
            goto L_0x01b2
        L_0x01d2:
            r0 = move-exception
            r2 = r3
            goto L_0x01a0
        L_0x01d5:
            r0 = move-exception
            goto L_0x01a0
        L_0x01d7:
            r0 = move-exception
            r4 = r3
            goto L_0x01a0
        L_0x01da:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L_0x0178
        L_0x01de:
            r0 = move-exception
            r3 = r4
            goto L_0x0178
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.wordtesting.load.Script.load(int, java.io.InputStream, java.io.InputStream):boolean");
    }

    private String loadData(BufferedReader bufferedReader) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = null;
            try {
                readLine = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (readLine == null) {
                break;
            }
            stringBuffer.append(readLine);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || "".equals(stringBuffer2)) {
            C0789L.log.error("load data error");
            return null;
        }
        int indexOf = stringBuffer2.indexOf(91);
        if (indexOf < 0 || indexOf >= stringBuffer2.length()) {
            C0789L.log.error("load data error, find [ at [{}]", (Object) Integer.valueOf(indexOf));
            return null;
        } else if (indexOf != 0) {
            return stringBuffer2.substring(indexOf);
        } else {
            return stringBuffer2;
        }
    }

    private NativeArray getDataArray(String str) {
//        List<Word> list = (List) new Gson().fromJson(str, new TypeToken<List<Word>>() {
//        }.getType());
//        if (list == null || list.isEmpty()) {
//            C0789L.log.warn("load words error");
//            return null;
//        }
//        NativeArray bcVar = new NativeArray((long) list.size());
//        int i = 0;
//        for (Word word : list) {
//            NativeObject cbVar = new NativeObject();
//            cbVar.put("w", cbVar, word.getW());
//            cbVar.put(ThirdPartyUserInfo.GENDER_MALE, cbVar, word.getM());
//            cbVar.put("s", cbVar, Integer.valueOf(word.getS()));
//            cbVar.put("r", cbVar, Integer.valueOf(word.getR()));
//            cbVar.put("p", cbVar, word.getP());
//            int i2 = i + 1;
//            bcVar.put(i, (Scriptable) bcVar, (Object) cbVar);
//            i = i2;
//        }
//        return bcVar;

        return null;
    }

    public synchronized void destroy() {
        this.finished = true;
        this.scriptable = null;
        this.currentTesting = null;
    }

    public synchronized boolean init() {
        boolean z = false;
        synchronized (this) {
            if (this.scriptable == null) {
                C0789L.log.warn("context or scriptable is null");
            } else {
                try {
                    C0789L.log.info("init");
                    Timer timer = new Timer();
                    timer.start();
                    Context b = Context.m6762b();
                    b.mo19137a(-1);
                    b.mo19134a(this.scriptable, "Vocabtest.reset(booklevel)");
                    this.finished = false;
                    this.currentTesting = null;
                    C0789L.log.info("init done, use time [{}]", (Object) Long.valueOf(timer.stop()));
                    try {
                    } catch (Exception e) {
                        C0789L.log.warn("context exit error", (Throwable) e);
                    }
                    z = true;
                } catch (Throwable th) {
                    C0789L.log.error("init error", th);
                    try {
                    } catch (Exception e2) {
                        C0789L.log.warn("context exit error", (Throwable) e2);
                    }
                } finally {
                    try {
                        Context.m6766c();
                    } catch (Exception e3) {
                        C0789L.log.warn("context exit error", (Throwable) e3);
                    }
                }
            }
        }
        return z;
    }

    public synchronized Testing getNext() {
        Testing testing = null;
        Throwable th;
        Testing testing2;
        if (this.finished) {
            C0789L.log.warn("testing finished");
            testing = null;
        } else {
            C0789L.log.info("get next, current [{}]", (Object) this.currentTesting);
            try {
                Timer timer = new Timer();
                timer.start();
                Context b = Context.m6762b();
                b.mo19137a(-1);
                NativeObject cbVar = (NativeObject) b.mo19134a(this.scriptable, "Vocabtest.samplingWord()");
                testing2 = new Testing();
                try {
                    testing2.setCorrect(new Word((NativeObject) cbVar.get("c")));
                    NativeArray bcVar = (NativeArray) cbVar.get("o");
                    if (bcVar != null) {
                        Iterator it = bcVar.iterator();
                        while (it.hasNext()) {
                            testing2.addOption(new Word((NativeObject) it.next()));
                        }
                    }
                    C0789L.log.info("get next [{}] time [{}]", (Object) testing2, (Object) Long.valueOf(timer.stop()));
                    this.currentTesting = testing2;
                    try {
                        Context.m6766c();
                        testing = testing2;
                    } catch (Exception e) {
                        C0789L.log.warn("context exit error", (Throwable) e);
                        testing = testing2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.currentTesting = testing2;
                    Context.m6766c();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                testing2 = null;
                this.currentTesting = testing2;
                Context.m6766c();
                try {
                    throw th;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
        return testing;
    }

    public synchronized Result submit(boolean z) {
        Result result = null;
        if (this.finished || this.currentTesting == null) {
            C0789L.log.warn("finished [{}] or currentTesting [{}] is null", (Object) Boolean.valueOf(this.finished), (Object) this.currentTesting);
            result = null;
        } else {
            C0789L.log.info("submit [{}] [{}]", (Object) this.currentTesting, (Object) Boolean.valueOf(z));
            try {
                Context b = Context.m6762b();
                b.mo19137a(-1);
                Timer timer = new Timer();
                timer.start();
                NativeObject cbVar = (NativeObject) b.mo19134a(this.scriptable, String.format(Locale.CHINA, "Vocabtest.userFeedback(%d, %b)", new Object[]{Integer.valueOf(this.currentTesting.getCorrect().getR()), Boolean.valueOf(z)}));
                if (cbVar == null || cbVar.get("finished") == null) {
                    C0789L.log.warn("submit error");
                    this.finished = true;
                    try {
                    } catch (Exception e) {
                        C0789L.log.warn("context exit error", (Throwable) e);
                    }
                    result = null;
                } else {
//                    Result result2 = new Result(cbVar);
//                    this.finished = result2.isFinished();
//                    C0789L.log.info("submit [{}] to status [{}] success, res [{}]", this.currentTesting, Boolean.valueOf(z), result2);
//                    C0789L.log.info("submit time [{}]", (Object) Long.valueOf(timer.stop()));
//                    try {
//                        Context.m6766c();
//                    } catch (Exception e2) {
//                        C0789L.log.warn("context exit error", (Throwable) e2);
//                    }
//                    result = result2;
                }
            } catch (Throwable th) {
                this.finished = true;
                C0789L.log.error("submit error", th);
                try {
                } catch (Exception e3) {
                    C0789L.log.warn("context exit error", (Throwable) e3);
                }
                result = null;
            } finally {
                try {
                    Context.m6766c();
                } catch (Exception e4) {
                    C0789L.log.warn("context exit error", (Throwable) e4);
                }
            }
        }
        return result;
    }
}
