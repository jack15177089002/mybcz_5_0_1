package com.baicizhan.client.framework.resource;

import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import com.baicizhan.client.framework.util.Common;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ResourceLibrary {
    private static final int FILE_COUNT_PER_DIR = 151;
    private static final String LOCK_FILE = "lock";
    private static final long MAX_CAPACITY = 100000000;
    private static final int MAX_FILE_COUNT = 3020;
    private static final long MIN_FILE_SIZE_PER_DIR = 1000;
    private static final int MIN_SUB_DIR_COUNT = 1;
    private static final String TMP_DIR = "tmp";
    private volatile long capacity;
    private File dir;
    private volatile int fileCountPerDir;
    private volatile long fileSizePerDir;
    private File lock;
    private volatile int maxFileCount;
    private boolean opened;
    private volatile String path;
    private volatile int subDirCount;

    class FileModifySorter implements Comparator<File> {
        private FileModifySorter() {
        }

        public int compare(File file, File file2) {
            if (file == null && file2 == null) {
                return 0;
            }
            if (file == null) {
                return -1;
            }
            if (file2 == null) {
                return 1;
            }
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified < 0) {
                return -1;
            }
            if (lastModified != 0) {
                return 1;
            }
            return 0;
        }
    }

    public ResourceLibrary(String str) {
        this(str, MAX_CAPACITY, MAX_FILE_COUNT);
    }

    public ResourceLibrary(String str, int i) {
        this(str, Long.MAX_VALUE, i);
    }

    public ResourceLibrary(String str, long j, int i) {
        this.opened = false;
        this.dir = null;
        this.lock = null;
        if (str == null || "".equals(str.trim()) || j <= 0 || i <= 0) {
            throw new IllegalArgumentException();
        }
        this.path = str;
        this.capacity = j;
        this.maxFileCount = i;
        this.fileCountPerDir = 151;
        this.subDirCount = i / this.fileCountPerDir;
        if (this.subDirCount <= 0) {
            this.subDirCount = 1;
        }
        this.fileSizePerDir = j / ((long) this.subDirCount);
        if (this.fileSizePerDir < 1000) {
            this.fileSizePerDir = 1000;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0138 A[SYNTHETIC, Splitter:B:89:0x0138] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:42:0x0090=Splitter:B:42:0x0090, B:18:0x0041=Splitter:B:18:0x0041, B:68:0x0104=Splitter:B:68:0x0104, B:55:0x00c5=Splitter:B:55:0x00c5, B:32:0x0068=Splitter:B:32:0x0068} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean open(boolean r8) {
        /*
            r7 = this;
            r1 = 1
            r0 = 0
            r3 = 0
            monitor-enter(r7)
            boolean r2 = r7.opened     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0019
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0017
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x004c }
            java.lang.String r2 = "rcl [{}] has been opened"
            java.lang.String r3 = r7.path     // Catch:{ all -> 0x004c }
            r1.warn(r2, r3)     // Catch:{ all -> 0x004c }
        L_0x0017:
            monitor-exit(r7)
            return r0
        L_0x0019:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x013f }
            java.lang.String r4 = r7.path     // Catch:{ all -> 0x013f }
            r2.<init>(r4)     // Catch:{ all -> 0x013f }
            r7.dir = r2     // Catch:{ all -> 0x013f }
            java.io.File r2 = r7.dir     // Catch:{ all -> 0x013f }
            boolean r2 = r2.exists()     // Catch:{ all -> 0x013f }
            if (r2 == 0) goto L_0x004f
            java.io.File r2 = r7.dir     // Catch:{ all -> 0x013f }
            boolean r2 = r2.isDirectory()     // Catch:{ all -> 0x013f }
            if (r2 != 0) goto L_0x004f
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x013f }
            if (r1 == 0) goto L_0x0041
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x013f }
            java.lang.String r2 = "rcl [{}] is not a dir"
            java.lang.String r3 = r7.path     // Catch:{ all -> 0x013f }
            r1.warn(r2, r3)     // Catch:{ all -> 0x013f }
        L_0x0041:
            boolean r1 = r7.opened     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0017
            r1 = 0
            r7.dir = r1     // Catch:{ all -> 0x004c }
            r1 = 0
            r7.lock = r1     // Catch:{ all -> 0x004c }
            goto L_0x0017
        L_0x004c:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        L_0x004f:
            java.io.File r2 = r7.dir     // Catch:{ all -> 0x013f }
            boolean r2 = r2.exists()     // Catch:{ all -> 0x013f }
            if (r2 != 0) goto L_0x00d4
            if (r8 != 0) goto L_0x0073
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x013f }
            if (r1 == 0) goto L_0x0068
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x013f }
            java.lang.String r2 = "rcl [{}] dir does not exist, and not auto create"
            java.lang.String r3 = r7.path     // Catch:{ all -> 0x013f }
            r1.warn(r2, r3)     // Catch:{ all -> 0x013f }
        L_0x0068:
            boolean r1 = r7.opened     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0017
            r1 = 0
            r7.dir = r1     // Catch:{ all -> 0x004c }
            r1 = 0
            r7.lock = r1     // Catch:{ all -> 0x004c }
            goto L_0x0017
        L_0x0073:
            java.io.File r2 = r7.dir     // Catch:{ all -> 0x013f }
            boolean r2 = r2.mkdirs()     // Catch:{ all -> 0x013f }
            if (r2 != 0) goto L_0x009c
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x013f }
            if (r1 == 0) goto L_0x0090
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x013f }
            java.lang.String r2 = "rcl [{}] mkdirs [{}] error"
            java.lang.String r3 = r7.path     // Catch:{ all -> 0x013f }
            java.io.File r4 = r7.dir     // Catch:{ all -> 0x013f }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x013f }
            r1.warn(r2, r3, r4)     // Catch:{ all -> 0x013f }
        L_0x0090:
            boolean r1 = r7.opened     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0017
            r1 = 0
            r7.dir = r1     // Catch:{ all -> 0x004c }
            r1 = 0
            r7.lock = r1     // Catch:{ all -> 0x004c }
            goto L_0x0017
        L_0x009c:
            r2 = r0
        L_0x009d:
            int r4 = r7.subDirCount     // Catch:{ all -> 0x013f }
            if (r2 >= r4) goto L_0x00d4
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x013f }
            java.io.File r5 = r7.dir     // Catch:{ all -> 0x013f }
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x013f }
            r4.<init>(r5, r6)     // Catch:{ all -> 0x013f }
            boolean r5 = r4.mkdir()     // Catch:{ all -> 0x013f }
            if (r5 != 0) goto L_0x00d1
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x013f }
            if (r1 == 0) goto L_0x00c5
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x013f }
            java.lang.String r2 = "rcl [{}] mkdir [{}] error"
            java.lang.String r3 = r7.path     // Catch:{ all -> 0x013f }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x013f }
            r1.warn(r2, r3, r4)     // Catch:{ all -> 0x013f }
        L_0x00c5:
            boolean r1 = r7.opened     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0017
            r1 = 0
            r7.dir = r1     // Catch:{ all -> 0x004c }
            r1 = 0
            r7.lock = r1     // Catch:{ all -> 0x004c }
            goto L_0x0017
        L_0x00d1:
            int r2 = r2 + 1
            goto L_0x009d
        L_0x00d4:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x013f }
            java.io.File r4 = r7.dir     // Catch:{ all -> 0x013f }
            java.lang.String r5 = "lock"
            r2.<init>(r4, r5)     // Catch:{ all -> 0x013f }
            r7.lock = r2     // Catch:{ all -> 0x013f }
            java.io.File r2 = r7.lock     // Catch:{ all -> 0x013f }
            boolean r2 = r2.exists()     // Catch:{ all -> 0x013f }
            if (r2 != 0) goto L_0x0124
            java.io.File r2 = r7.lock     // Catch:{ all -> 0x013f }
            boolean r2 = r2.createNewFile()     // Catch:{ all -> 0x013f }
            if (r2 != 0) goto L_0x0110
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x013f }
            if (r1 == 0) goto L_0x0104
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x013f }
            java.lang.String r2 = "rcl [{}] create lock file [{}] error"
            java.lang.String r3 = r7.path     // Catch:{ all -> 0x013f }
            java.io.File r4 = r7.lock     // Catch:{ all -> 0x013f }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x013f }
            r1.warn(r2, r3, r4)     // Catch:{ all -> 0x013f }
        L_0x0104:
            boolean r1 = r7.opened     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0017
            r1 = 0
            r7.dir = r1     // Catch:{ all -> 0x004c }
            r1 = 0
            r7.lock = r1     // Catch:{ all -> 0x004c }
            goto L_0x0017
        L_0x0110:
            int r0 = android.os.Process.myPid()     // Catch:{ all -> 0x013f }
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ all -> 0x0134 }
            java.io.File r4 = r7.lock     // Catch:{ all -> 0x0134 }
            r2.<init>(r4)     // Catch:{ all -> 0x0134 }
            r2.println(r0)     // Catch:{ all -> 0x014b }
            r2.flush()     // Catch:{ all -> 0x013f }
            r2.close()     // Catch:{ all -> 0x013f }
        L_0x0124:
            r0 = 1
            r7.opened = r0     // Catch:{ all -> 0x013f }
            boolean r0 = r7.opened     // Catch:{ all -> 0x004c }
            if (r0 != 0) goto L_0x0131
            r0 = 0
            r7.dir = r0     // Catch:{ all -> 0x004c }
            r0 = 0
            r7.lock = r0     // Catch:{ all -> 0x004c }
        L_0x0131:
            r0 = r1
            goto L_0x0017
        L_0x0134:
            r0 = move-exception
            r1 = r3
        L_0x0136:
            if (r1 == 0) goto L_0x013e
            r1.flush()     // Catch:{ all -> 0x013f }
            r1.close()     // Catch:{ all -> 0x013f }
        L_0x013e:
            throw r0     // Catch:{ all -> 0x013f }
        L_0x013f:
            r0 = move-exception
            boolean r1 = r7.opened     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x014a
            r1 = 0
            r7.dir = r1     // Catch:{ all -> 0x004c }
            r1 = 0
            r7.lock = r1     // Catch:{ all -> 0x004c }
        L_0x014a:
            throw r0     // Catch:{ all -> 0x004c }
        L_0x014b:
            r0 = move-exception
            r1 = r2
            goto L_0x0136
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.resource.ResourceLibrary.open(boolean):boolean");
    }

    public synchronized void close() {
        try {
            if (this.opened && this.lock != null) {
                this.lock.delete();
            }
            this.opened = false;
            this.dir = null;
            this.lock = null;
        } catch (Throwable th) {
            this.opened = false;
            this.dir = null;
            this.lock = null;
            throw th;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v3, types: [int] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5, types: [int] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], int, ?[boolean, int, float, short, byte, char]]
  uses: [boolean, ?[int, byte, short, char], ?[int, short, byte, char], int]
  mth insns count: 23
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean clear() {
        /*
            r5 = this;
            r0 = 0
            monitor-enter(r5)
            boolean r1 = r5.opened     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x000a
            java.io.File r1 = r5.dir     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x000c
        L_0x000a:
            monitor-exit(r5)
            return r0
        L_0x000c:
            java.io.File r1 = r5.dir     // Catch:{ all -> 0x0027 }
            java.io.File[] r1 = r1.listFiles()     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x000a
            int r2 = r1.length     // Catch:{ all -> 0x0027 }
        L_0x0015:
            if (r0 >= r2) goto L_0x0025
            r3 = r1[r0]     // Catch:{ all -> 0x0027 }
            boolean r4 = r3.isDirectory()     // Catch:{ all -> 0x0027 }
            if (r4 == 0) goto L_0x0022
            r5.deleteDir(r3)     // Catch:{ all -> 0x0027 }
        L_0x0022:
            int r0 = r0 + 1
            goto L_0x0015
        L_0x0025:
            r0 = 1
            goto L_0x000a
        L_0x0027:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.resource.ResourceLibrary.clear():boolean");
    }

    private boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!deleteDir(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public synchronized boolean destroy() {
        boolean z;
        if (!this.opened || this.dir == null || deleteDir(this.dir)) {
            close();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public String getPath() {
        return this.path;
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x01e7 A[SYNTHETIC, Splitter:B:119:0x01e7] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01ec A[SYNTHETIC, Splitter:B:122:0x01ec] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0173 A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018b A[SYNTHETIC, Splitter:B:90:0x018b] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0190 A[SYNTHETIC, Splitter:B:93:0x0190] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean save(String r14, File r15, boolean r16) {
        /*
            r13 = this;
            monitor-enter(r13)
            java.lang.String r4 = r13.encodeName(r14)     // Catch:{ all -> 0x01f0 }
            if (r4 == 0) goto L_0x001b
            java.lang.String r0 = ""
            java.lang.String r1 = r4.trim()     // Catch:{ all -> 0x01f0 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x01f0 }
            if (r0 != 0) goto L_0x001b
            if (r15 == 0) goto L_0x001b
            boolean r0 = r15.exists()     // Catch:{ all -> 0x01f0 }
            if (r0 != 0) goto L_0x001e
        L_0x001b:
            r0 = 0
        L_0x001c:
            monitor-exit(r13)
            return r0
        L_0x001e:
            int r0 = r13.getFileDirId(r4)     // Catch:{ all -> 0x01f0 }
            if (r0 < 0) goto L_0x0028
            int r1 = r13.subDirCount     // Catch:{ all -> 0x01f0 }
            if (r0 < r1) goto L_0x002a
        L_0x0028:
            r0 = 0
            goto L_0x001c
        L_0x002a:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x01f0 }
            java.io.File r1 = r13.dir     // Catch:{ all -> 0x01f0 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01f0 }
            r5.<init>(r1, r0)     // Catch:{ all -> 0x01f0 }
            boolean r0 = r5.exists()     // Catch:{ all -> 0x01f0 }
            if (r0 == 0) goto L_0x0043
            boolean r0 = r5.isDirectory()     // Catch:{ all -> 0x01f0 }
            if (r0 != 0) goto L_0x0043
            r0 = 0
            goto L_0x001c
        L_0x0043:
            boolean r0 = r5.exists()     // Catch:{ all -> 0x01f0 }
            if (r0 != 0) goto L_0x0064
            boolean r0 = r5.mkdirs()     // Catch:{ all -> 0x01f0 }
            if (r0 != 0) goto L_0x0064
            boolean r0 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x01f0 }
            if (r0 == 0) goto L_0x0062
            org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x01f0 }
            java.lang.String r1 = "rcl [{}] mkdirs [{}] error"
            java.lang.String r2 = r13.path     // Catch:{ all -> 0x01f0 }
            java.lang.String r3 = r5.getAbsolutePath()     // Catch:{ all -> 0x01f0 }
            r0.warn(r1, r2, r3)     // Catch:{ all -> 0x01f0 }
        L_0x0062:
            r0 = 0
            goto L_0x001c
        L_0x0064:
            java.util.LinkedList r6 = r13.getSortedFiles(r5)     // Catch:{ all -> 0x01f0 }
            if (r6 == 0) goto L_0x013e
            boolean r0 = r6.isEmpty()     // Catch:{ all -> 0x01f0 }
            if (r0 != 0) goto L_0x013e
        L_0x0070:
            boolean r0 = r6.isEmpty()     // Catch:{ all -> 0x01f0 }
            if (r0 != 0) goto L_0x00a2
            int r0 = r6.size()     // Catch:{ all -> 0x01f0 }
            int r1 = r13.fileCountPerDir     // Catch:{ all -> 0x01f0 }
            int r1 = r1 + -1
            if (r0 < r1) goto L_0x00a2
            java.lang.Object r0 = r6.removeFirst()     // Catch:{ all -> 0x01f0 }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x01f0 }
            boolean r1 = r0.delete()     // Catch:{ all -> 0x01f0 }
            if (r1 != 0) goto L_0x0070
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x01f0 }
            if (r1 == 0) goto L_0x009f
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x01f0 }
            java.lang.String r2 = "rcl [{}] delete file [{}] error"
            java.lang.String r3 = r13.path     // Catch:{ all -> 0x01f0 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x01f0 }
            r1.warn(r2, r3, r0)     // Catch:{ all -> 0x01f0 }
        L_0x009f:
            r0 = 0
            goto L_0x001c
        L_0x00a2:
            r2 = 0
            java.util.Iterator r1 = r6.iterator()     // Catch:{ all -> 0x01f0 }
        L_0x00a8:
            boolean r0 = r1.hasNext()     // Catch:{ all -> 0x01f0 }
            if (r0 == 0) goto L_0x00ba
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x01f0 }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x01f0 }
            long r8 = r0.length()     // Catch:{ all -> 0x01f0 }
            long r2 = r2 + r8
            goto L_0x00a8
        L_0x00ba:
            long r8 = r15.length()     // Catch:{ all -> 0x01f0 }
            long r0 = r5.getFreeSpace()     // Catch:{ all -> 0x01f0 }
            long r0 = r0 - r2
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00cd
            long r0 = r13.fileSizePerDir     // Catch:{ all -> 0x01f0 }
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x010a
        L_0x00cd:
            boolean r0 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x01f0 }
            if (r0 == 0) goto L_0x0104
            org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x01f0 }
            java.lang.String r1 = "rcl [{}] size [{}] too large. disk free[{}] total[{}] size_per_dir[{}]"
            r4 = 5
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x01f0 }
            r6 = 0
            java.lang.String r7 = r13.path     // Catch:{ all -> 0x01f0 }
            r4[r6] = r7     // Catch:{ all -> 0x01f0 }
            r6 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x01f0 }
            r4[r6] = r7     // Catch:{ all -> 0x01f0 }
            r6 = 2
            long r8 = r5.getFreeSpace()     // Catch:{ all -> 0x01f0 }
            java.lang.Long r5 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x01f0 }
            r4[r6] = r5     // Catch:{ all -> 0x01f0 }
            r5 = 3
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01f0 }
            r4[r5] = r2     // Catch:{ all -> 0x01f0 }
            r2 = 4
            long r6 = r13.fileSizePerDir     // Catch:{ all -> 0x01f0 }
            java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01f0 }
            r4[r2] = r3     // Catch:{ all -> 0x01f0 }
            r0.warn(r1, r4)     // Catch:{ all -> 0x01f0 }
        L_0x0104:
            r0 = 0
            goto L_0x001c
        L_0x0107:
            long r0 = r2 - r10
            r2 = r0
        L_0x010a:
            boolean r0 = r6.isEmpty()     // Catch:{ all -> 0x01f0 }
            if (r0 != 0) goto L_0x013e
            long r0 = r2 + r8
            long r10 = r13.fileSizePerDir     // Catch:{ all -> 0x01f0 }
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x013e
            java.lang.Object r0 = r6.removeFirst()     // Catch:{ all -> 0x01f0 }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x01f0 }
            long r10 = r0.length()     // Catch:{ all -> 0x01f0 }
            boolean r1 = r0.delete()     // Catch:{ all -> 0x01f0 }
            if (r1 != 0) goto L_0x0107
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x01f0 }
            if (r1 == 0) goto L_0x013b
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x01f0 }
            java.lang.String r2 = "rcl [{}] delete file [{}] error"
            java.lang.String r3 = r13.path     // Catch:{ all -> 0x01f0 }
            java.io.File r0 = r0.getAbsoluteFile()     // Catch:{ all -> 0x01f0 }
            r1.warn(r2, r3, r0)     // Catch:{ all -> 0x01f0 }
        L_0x013b:
            r0 = 0
            goto L_0x001c
        L_0x013e:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x01f0 }
            r6.<init>(r5, r4)     // Catch:{ all -> 0x01f0 }
            boolean r0 = r6.exists()     // Catch:{ all -> 0x01f0 }
            if (r0 == 0) goto L_0x014c
            r6.delete()     // Catch:{ all -> 0x01f0 }
        L_0x014c:
            r1 = 0
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x020b, all -> 0x01e2 }
            r3.<init>(r15)     // Catch:{ Exception -> 0x020b, all -> 0x01e2 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0211, all -> 0x0203 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0211, all -> 0x0203 }
            r0 = 4194304(0x400000, float:5.877472E-39)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            r4 = 0
        L_0x015e:
            int r2 = r3.read(r0)     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            if (r2 <= 0) goto L_0x0196
            long r8 = (long) r2     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            long r4 = r4 + r8
            r7 = 0
            r1.write(r0, r7, r2)     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            goto L_0x015e
        L_0x016b:
            r0 = move-exception
            r2 = r3
        L_0x016d:
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x0208 }
            if (r3 == 0) goto L_0x0186
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0208 }
            java.lang.String r4 = "rcl [%s] save error"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0208 }
            r7 = 0
            java.lang.String r8 = r13.path     // Catch:{ all -> 0x0208 }
            r5[r7] = r8     // Catch:{ all -> 0x0208 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x0208 }
            r3.warn(r4, r0)     // Catch:{ all -> 0x0208 }
        L_0x0186:
            r6.delete()     // Catch:{ all -> 0x0208 }
            if (r2 == 0) goto L_0x018e
            r2.close()     // Catch:{ IOException -> 0x01fb }
        L_0x018e:
            if (r1 == 0) goto L_0x0193
            r1.close()     // Catch:{ IOException -> 0x01fd }
        L_0x0193:
            r0 = 0
            goto L_0x001c
        L_0x0196:
            r1.flush()     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            long r8 = r15.length()     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x01d4
            boolean r0 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            if (r0 == 0) goto L_0x01c8
            org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            java.lang.String r2 = "rcl [{}] write error. write [{}] origin [{}]"
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            r8 = 0
            java.lang.String r9 = r13.path     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            r7[r8] = r9     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            r8 = 1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            r7[r8] = r4     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            r4 = 2
            long r8 = r15.length()     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            java.lang.Long r5 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            r7[r4] = r5     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            r0.warn(r2, r7)     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
        L_0x01c8:
            r6.delete()     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
            r3.close()     // Catch:{ IOException -> 0x01f3 }
        L_0x01ce:
            r1.close()     // Catch:{ IOException -> 0x01f5 }
        L_0x01d1:
            r0 = 0
            goto L_0x001c
        L_0x01d4:
            if (r16 == 0) goto L_0x01d9
            r15.delete()     // Catch:{ Exception -> 0x016b, all -> 0x0206 }
        L_0x01d9:
            r3.close()     // Catch:{ IOException -> 0x01f7 }
        L_0x01dc:
            r1.close()     // Catch:{ IOException -> 0x01f9 }
        L_0x01df:
            r0 = 1
            goto L_0x001c
        L_0x01e2:
            r0 = move-exception
            r3 = r1
            r1 = r2
        L_0x01e5:
            if (r3 == 0) goto L_0x01ea
            r3.close()     // Catch:{ IOException -> 0x01ff }
        L_0x01ea:
            if (r1 == 0) goto L_0x01ef
            r1.close()     // Catch:{ IOException -> 0x0201 }
        L_0x01ef:
            throw r0     // Catch:{ all -> 0x01f0 }
        L_0x01f0:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        L_0x01f3:
            r0 = move-exception
            goto L_0x01ce
        L_0x01f5:
            r0 = move-exception
            goto L_0x01d1
        L_0x01f7:
            r0 = move-exception
            goto L_0x01dc
        L_0x01f9:
            r0 = move-exception
            goto L_0x01df
        L_0x01fb:
            r0 = move-exception
            goto L_0x018e
        L_0x01fd:
            r0 = move-exception
            goto L_0x0193
        L_0x01ff:
            r2 = move-exception
            goto L_0x01ea
        L_0x0201:
            r1 = move-exception
            goto L_0x01ef
        L_0x0203:
            r0 = move-exception
            r1 = r2
            goto L_0x01e5
        L_0x0206:
            r0 = move-exception
            goto L_0x01e5
        L_0x0208:
            r0 = move-exception
            r3 = r2
            goto L_0x01e5
        L_0x020b:
            r0 = move-exception
            r12 = r2
            r2 = r1
            r1 = r12
            goto L_0x016d
        L_0x0211:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x016d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.resource.ResourceLibrary.save(java.lang.String, java.io.File, boolean):boolean");
    }

    private LinkedList<File> getSortedFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        LinkedList<File> linkedList = new LinkedList<>();
        for (File add : listFiles) {
            linkedList.add(add);
        }
        Collections.sort(linkedList, new FileModifySorter());
        return linkedList;
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getFileDirId(String r8) {
        /*
            r7 = this;
            r1 = 0
            r0 = -1
            if (r8 == 0) goto L_0x0010
            java.lang.String r2 = ""
            java.lang.String r3 = r8.trim()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0011
        L_0x0010:
            return r0
        L_0x0011:
            byte[] r4 = r8.getBytes()
            if (r4 == 0) goto L_0x001a
            int r2 = r4.length
            if (r2 != 0) goto L_0x002a
        L_0x001a:
            boolean r1 = com.baicizhan.client.framework.log.LSwitcher.isOpened()
            if (r1 == 0) goto L_0x0010
            org.slf4j.Logger r1 = com.baicizhan.client.framework.log.C0789L.log
            java.lang.String r2 = "rcl [{}] get dir id [{}] sign md5 error"
            java.lang.String r3 = r7.path
            r1.warn(r2, r3, r8)
            goto L_0x0010
        L_0x002a:
            r0 = 1
            int r5 = r4.length
            r2 = r0
            r0 = r1
        L_0x002e:
            if (r1 >= r5) goto L_0x0040
            byte r6 = r4[r1]
            int r3 = r2 + 1
            int r2 = r2 * r6
            int r0 = r0 + r2
            int r2 = r7.subDirCount
            int r2 = r0 % r2
            int r0 = r1 + 1
            r1 = r0
            r0 = r2
            r2 = r3
            goto L_0x002e
        L_0x0040:
            if (r0 >= 0) goto L_0x0046
            int r1 = r7.subDirCount
            int r0 = r0 + r1
            goto L_0x0040
        L_0x0046:
            int r1 = r7.subDirCount
            int r0 = r0 % r1
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.resource.ResourceLibrary.getFileDirId(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d1 A[SYNTHETIC, Splitter:B:60:0x00d1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean save(String r10, InputStream r11) {
        /*
            r9 = this;
            r0 = 0
            monitor-enter(r9)
            if (r10 == 0) goto L_0x0012
            java.lang.String r1 = ""
            java.lang.String r2 = r10.trim()     // Catch:{ all -> 0x0049 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0049 }
            if (r1 != 0) goto L_0x0012
            if (r11 != 0) goto L_0x0014
        L_0x0012:
            monitor-exit(r9)
            return r0
        L_0x0014:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0049 }
            java.io.File r2 = r9.dir     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "tmp"
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0049 }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0029
            boolean r2 = r1.isDirectory()     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0012
        L_0x0029:
            boolean r2 = r1.exists()     // Catch:{ all -> 0x0049 }
            if (r2 != 0) goto L_0x004c
            boolean r2 = r1.mkdirs()     // Catch:{ all -> 0x0049 }
            if (r2 != 0) goto L_0x004c
            boolean r2 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0012
            org.slf4j.Logger r2 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "rcl [{}] mkdirs [{}] error"
            java.lang.String r4 = r9.path     // Catch:{ all -> 0x0049 }
            java.io.File r1 = r1.getAbsoluteFile()     // Catch:{ all -> 0x0049 }
            r2.warn(r3, r4, r1)     // Catch:{ all -> 0x0049 }
            goto L_0x0012
        L_0x0049:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L_0x004c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r2.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r2 = r2.append(r10)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "."
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0049 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = r9.encodeName(r2)     // Catch:{ all -> 0x0049 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0049 }
            r4.<init>(r1, r2)     // Catch:{ all -> 0x0049 }
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x007c
            boolean r1 = r4.delete()     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0012
        L_0x007c:
            r3 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00e0, all -> 0x00cd }
            r2.<init>(r4)     // Catch:{ Exception -> 0x00e0, all -> 0x00cd }
            r1 = 4194304(0x400000, float:5.877472E-39)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0091 }
        L_0x0086:
            int r3 = r11.read(r1)     // Catch:{ Exception -> 0x0091 }
            if (r3 <= 0) goto L_0x00bb
            r5 = 0
            r2.write(r1, r5, r3)     // Catch:{ Exception -> 0x0091 }
            goto L_0x0086
        L_0x0091:
            r1 = move-exception
        L_0x0092:
            boolean r3 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x00de }
            if (r3 == 0) goto L_0x00ae
            org.slf4j.Logger r3 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x00de }
            java.lang.String r5 = "rcl [%s] save [%s] error"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00de }
            r7 = 0
            java.lang.String r8 = r9.path     // Catch:{ all -> 0x00de }
            r6[r7] = r8     // Catch:{ all -> 0x00de }
            r7 = 1
            r6[r7] = r10     // Catch:{ all -> 0x00de }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ all -> 0x00de }
            r3.warn(r5, r1)     // Catch:{ all -> 0x00de }
        L_0x00ae:
            r4.delete()     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x00b6
            r2.close()     // Catch:{ IOException -> 0x00da }
        L_0x00b6:
            r4.delete()     // Catch:{ all -> 0x0049 }
            goto L_0x0012
        L_0x00bb:
            r2.flush()     // Catch:{ Exception -> 0x0091 }
            r1 = 1
            boolean r0 = r9.save(r10, r4, r1)     // Catch:{ Exception -> 0x0091 }
            r2.close()     // Catch:{ IOException -> 0x00d8 }
        L_0x00c6:
            if (r0 != 0) goto L_0x0012
            r4.delete()     // Catch:{ all -> 0x0049 }
            goto L_0x0012
        L_0x00cd:
            r0 = move-exception
            r2 = r3
        L_0x00cf:
            if (r2 == 0) goto L_0x00d4
            r2.close()     // Catch:{ IOException -> 0x00dc }
        L_0x00d4:
            r4.delete()     // Catch:{ all -> 0x0049 }
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x00d8:
            r1 = move-exception
            goto L_0x00c6
        L_0x00da:
            r1 = move-exception
            goto L_0x00b6
        L_0x00dc:
            r1 = move-exception
            goto L_0x00d4
        L_0x00de:
            r0 = move-exception
            goto L_0x00cf
        L_0x00e0:
            r1 = move-exception
            r2 = r3
            goto L_0x0092
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.resource.ResourceLibrary.save(java.lang.String, java.io.InputStream):boolean");
    }

    public boolean save(String str, String str2, String str3) {
        boolean z = false;
        if (str2 == null || "".equals(str2)) {
            return z;
        }
        try {
            byte[] bytes = str2.getBytes(str3);
            return save(str, bytes, bytes.length);
        } catch (UnsupportedEncodingException e) {
            if (!LSwitcher.isOpened()) {
                return z;
            }
            C0789L.log.warn("rcl [{}] save [{}] content [{}] encoding [{}] error", this.path, str, str2, str3);
            return z;
        }
    }

    public boolean save(String str, byte[] bArr, int i) {
        InputStream inputStream;
        boolean z = false;
        if (str != null && !"".equals(str.trim()) && bArr != null && bArr.length >= i) {
            try {
                inputStream = new ByteArrayInputStream(bArr, 0, i);
                try {
                    z = save(str, inputStream);
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
//                th = th2;
//                inputStream = null;
//                if (inputStream != null) {
//                    try {
//                        inputStream.close();
//                    } catch (IOException e2) {
//                    }
//                }
//                throw th;
            }
        }
        return z;
    }

    private String encodeName(String str) {
        if (str == null || "".equals(str.trim())) {
            return null;
        }
        return new String(Common.md5(str));
    }

    public synchronized File getFile(String str) {
        File file;
        String encodeName = encodeName(str);
        if (encodeName == null || "".equals(encodeName.trim())) {
            file = null;
        } else {
            int fileDirId = getFileDirId(encodeName);
            if (fileDirId < 0 || fileDirId >= this.subDirCount) {
                file = null;
            } else {
                File file2 = new File(this.dir, String.valueOf(fileDirId));
                if (!file2.exists() || !file2.isDirectory()) {
                    file = null;
                } else {
                    file = new File(file2, encodeName);
                    if (!file.exists() || !file.isFile()) {
                        file = null;
                    }
                }
            }
        }
        return file;
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027 A[Catch:{ all -> 0x0075 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[SYNTHETIC, Splitter:B:18:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC, Splitter:B:21:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005e A[SYNTHETIC, Splitter:B:34:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0063 A[SYNTHETIC, Splitter:B:37:0x0063] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getBytes(String r10) {
        /*
            r9 = this;
            r0 = 0
            java.io.File r1 = r9.getFile(r10)
            if (r1 == 0) goto L_0x0047
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0077, all -> 0x0058 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0077, all -> 0x0058 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x007b, all -> 0x0071 }
            r2.<init>()     // Catch:{ Exception -> 0x007b, all -> 0x0071 }
            r1 = 4194304(0x400000, float:5.877472E-39)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0020 }
        L_0x0015:
            int r4 = r3.read(r1)     // Catch:{ Exception -> 0x0020 }
            if (r4 <= 0) goto L_0x0048
            r5 = 0
            r2.write(r1, r5, r4)     // Catch:{ Exception -> 0x0020 }
            goto L_0x0015
        L_0x0020:
            r1 = move-exception
        L_0x0021:
            boolean r4 = com.baicizhan.client.framework.log.LSwitcher.isOpened()     // Catch:{ all -> 0x0075 }
            if (r4 == 0) goto L_0x003d
            org.slf4j.Logger r4 = com.baicizhan.client.framework.log.C0789L.log     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = "rcl [%s] get bytes [%s] error"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0075 }
            r7 = 0
            java.lang.String r8 = r9.path     // Catch:{ all -> 0x0075 }
            r6[r7] = r8     // Catch:{ all -> 0x0075 }
            r7 = 1
            r6[r7] = r10     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ all -> 0x0075 }
            r4.warn(r5, r1)     // Catch:{ all -> 0x0075 }
        L_0x003d:
            if (r3 == 0) goto L_0x0042
            r3.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0042:
            if (r2 == 0) goto L_0x0047
            r2.close()     // Catch:{ IOException -> 0x006b }
        L_0x0047:
            return r0
        L_0x0048:
            r2.flush()     // Catch:{ Exception -> 0x0020 }
            byte[] r0 = r2.toByteArray()     // Catch:{ Exception -> 0x0020 }
            r3.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0052:
            r2.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0047
        L_0x0056:
            r1 = move-exception
            goto L_0x0047
        L_0x0058:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
        L_0x005c:
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ IOException -> 0x006d }
        L_0x0061:
            if (r2 == 0) goto L_0x0066
            r2.close()     // Catch:{ IOException -> 0x006f }
        L_0x0066:
            throw r0
        L_0x0067:
            r1 = move-exception
            goto L_0x0052
        L_0x0069:
            r1 = move-exception
            goto L_0x0042
        L_0x006b:
            r1 = move-exception
            goto L_0x0047
        L_0x006d:
            r1 = move-exception
            goto L_0x0061
        L_0x006f:
            r1 = move-exception
            goto L_0x0066
        L_0x0071:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x005c
        L_0x0075:
            r0 = move-exception
            goto L_0x005c
        L_0x0077:
            r1 = move-exception
            r2 = r0
            r3 = r0
            goto L_0x0021
        L_0x007b:
            r1 = move-exception
            r2 = r0
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.resource.ResourceLibrary.getBytes(java.lang.String):byte[]");
    }

    public String getString(String str) {
        return getString(str, "UTF-8");
    }

    public String getString(String str, String str2) {
        byte[] bytes = getBytes(str);
        if (bytes == null) {
            return null;
        }
        try {
            return new String(bytes, str2);
        } catch (Exception e) {
            if (LSwitcher.isOpened()) {
                C0789L.log.warn(String.format("rcl [%s] get string [%s] encoding [%s] error", new Object[]{this.path, str, str2}), (Throwable) e);
            }
            return null;
        }
    }

    public boolean exists(String str) {
        return getFile(str) != null;
    }

    public boolean delete(String str) {
        File file = getFile(str);
        if (file == null) {
            return true;
        }
        return file.delete();
    }

    public long getCapacity() {
        return this.capacity;
    }

    public int getMaxFileCount() {
        return this.maxFileCount;
    }
}
