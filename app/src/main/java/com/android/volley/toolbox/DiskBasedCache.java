package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.VolleyLog;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538183203;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    private static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    class CacheHeader {
        public String etag;
        public String key;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        private CacheHeader() {
        }

        public CacheHeader(String str, Entry entry) {
            this.key = str;
            this.size = (long) entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
        }

        public  CacheHeader readHeader(InputStream inputStream) throws EOFException, UnsupportedEncodingException {
            CacheHeader cacheHeader = new CacheHeader();
            if (DiskBasedCache.readInt(inputStream) != DiskBasedCache.CACHE_MAGIC) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            cacheHeader.key = DiskBasedCache.readString(inputStream);
            cacheHeader.etag = DiskBasedCache.readString(inputStream);
            if (cacheHeader.etag.equals("")) {
                cacheHeader.etag = null;
            }
            cacheHeader.serverDate = DiskBasedCache.readLong(inputStream);
            cacheHeader.ttl = DiskBasedCache.readLong(inputStream);
            cacheHeader.softTtl = DiskBasedCache.readLong(inputStream);
            cacheHeader.responseHeaders = DiskBasedCache.readStringStringMap(inputStream);
            return cacheHeader;
        }

        public Entry toCacheEntry(byte[] bArr) {
            Entry entry = new Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            return entry;
        }

        public boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, DiskBasedCache.CACHE_MAGIC);
                DiskBasedCache.writeString(outputStream, this.key);
                DiskBasedCache.writeString(outputStream, this.etag == null ? "" : this.etag);
                DiskBasedCache.writeLong(outputStream, this.serverDate);
                DiskBasedCache.writeLong(outputStream, this.ttl);
                DiskBasedCache.writeLong(outputStream, this.softTtl);
                DiskBasedCache.writeStringStringMap(this.responseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (Exception e) {
                VolleyLog.m2461d("%s", e.toString());
                return false;
            }
        }
    }

    class CountingInputStream extends FilterInputStream {
        /* access modifiers changed from: private */
        public int bytesRead;

        /* synthetic */ CountingInputStream(InputStream inputStream, CountingInputStream countingInputStream) {
            this(inputStream);
        }

        private CountingInputStream(InputStream inputStream) {
            super(inputStream);
            this.bytesRead = 0;
        }

        public int read() {
            int read = 0;
            try {
                read = super.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (read != -1) {
                this.bytesRead++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = 0;
            try {
                read = super.read(bArr, i, i2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (read != -1) {
                this.bytesRead += read;
            }
            return read;
        }
    }

    public DiskBasedCache(File file, int i) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0;
        this.mRootDirectory = file;
        this.mMaxCacheSizeInBytes = i;
    }

    public DiskBasedCache(File file) {
        this(file, DEFAULT_DISK_USAGE_BYTES);
    }

    public synchronized void clear() {
        synchronized (this) {
            File[] listFiles = this.mRootDirectory.listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
            this.mEntries.clear();
            this.mTotalSize = 0;
            VolleyLog.m2461d("Cache cleared.", new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC, Splitter:B:32:0x0064] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.android.volley.Cache.Entry get(String r9) {
        /*
            r8 = this;
            r1 = 0
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.android.volley.toolbox.DiskBasedCache$CacheHeader> r0 = r8.mEntries     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0068 }
            com.android.volley.toolbox.DiskBasedCache$CacheHeader r0 = (com.android.volley.toolbox.DiskBasedCache.CacheHeader) r0     // Catch:{ all -> 0x0068 }
            if (r0 != 0) goto L_0x000f
            r0 = r1
        L_0x000d:
            monitor-exit(r8)
            return r0
        L_0x000f:
            java.io.File r3 = r8.getFileForKey(r9)     // Catch:{ all -> 0x0068 }
            com.android.volley.toolbox.DiskBasedCache$CountingInputStream r2 = new com.android.volley.toolbox.DiskBasedCache$CountingInputStream     // Catch:{ IOException -> 0x003b, all -> 0x0060 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003b, all -> 0x0060 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x003b, all -> 0x0060 }
            r5 = 0
            r2.<init>(r4, r5)     // Catch:{ IOException -> 0x003b, all -> 0x0060 }
            com.android.volley.toolbox.DiskBasedCache.CacheHeader.readHeader(r2)     // Catch:{ IOException -> 0x0070 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x0070 }
            int r6 = r2.bytesRead     // Catch:{ IOException -> 0x0070 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x0070 }
            long r4 = r4 - r6
            int r4 = (int) r4     // Catch:{ IOException -> 0x0070 }
            byte[] r4 = streamToBytes(r2, r4)     // Catch:{ IOException -> 0x0070 }
            com.android.volley.Cache$Entry r0 = r0.toCacheEntry(r4)     // Catch:{ IOException -> 0x0070 }
            r2.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x000d
        L_0x0038:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x003b:
            r0 = move-exception
            r2 = r1
        L_0x003d:
            java.lang.String r4 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x006e }
            r6 = 0
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006e }
            r5[r6] = r3     // Catch:{ all -> 0x006e }
            r3 = 1
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006e }
            r5[r3] = r0     // Catch:{ all -> 0x006e }
            com.android.volley.VolleyLog.m2461d(r4, r5)     // Catch:{ all -> 0x006e }
            r8.remove(r9)     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ IOException -> 0x005d }
        L_0x005b:
            r0 = r1
            goto L_0x000d
        L_0x005d:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x0060:
            r0 = move-exception
            r2 = r1
        L_0x0062:
            if (r2 == 0) goto L_0x0067
            r2.close()     // Catch:{ IOException -> 0x006b }
        L_0x0067:
            throw r0     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x006b:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x006e:
            r0 = move-exception
            goto L_0x0062
        L_0x0070:
            r0 = move-exception
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.get(java.lang.String):com.android.volley.Cache$Entry");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058 A[SYNTHETIC, Splitter:B:27:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[SYNTHETIC, Splitter:B:30:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066 A[SYNTHETIC, Splitter:B:35:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0050 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize() {
        /*
            r9 = this;
            r0 = 0
            monitor-enter(r9)
            java.io.File r1 = r9.mRootDirectory     // Catch:{ all -> 0x006a }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x0025
            java.io.File r0 = r9.mRootDirectory     // Catch:{ all -> 0x006a }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "Unable to create cache dir %s"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x006a }
            r2 = 0
            java.io.File r3 = r9.mRootDirectory     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006a }
            r1[r2] = r3     // Catch:{ all -> 0x006a }
            com.android.volley.VolleyLog.m2462e(r0, r1)     // Catch:{ all -> 0x006a }
        L_0x0023:
            monitor-exit(r9)
            return
        L_0x0025:
            java.io.File r1 = r9.mRootDirectory     // Catch:{ all -> 0x006a }
            java.io.File[] r3 = r1.listFiles()     // Catch:{ all -> 0x006a }
            if (r3 == 0) goto L_0x0023
            int r4 = r3.length     // Catch:{ all -> 0x006a }
            r2 = r0
        L_0x002f:
            if (r2 >= r4) goto L_0x0023
            r5 = r3[r2]     // Catch:{ all -> 0x006a }
            r1 = 0
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0054, all -> 0x0063 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0054, all -> 0x0063 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0054, all -> 0x0063 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0054, all -> 0x0063 }
            com.android.volley.toolbox.DiskBasedCache$CacheHeader r1 = com.android.volley.toolbox.DiskBasedCache.CacheHeader.readHeader(r0)     // Catch:{ IOException -> 0x0076 }
            long r6 = r5.length()     // Catch:{ IOException -> 0x0076 }
            r1.size = r6     // Catch:{ IOException -> 0x0076 }
            java.lang.String r6 = r1.key     // Catch:{ IOException -> 0x0076 }
            r9.putEntry(r6, r1)     // Catch:{ IOException -> 0x0076 }
            r0.close()     // Catch:{ IOException -> 0x006f }
        L_0x0050:
            int r0 = r2 + 1
            r2 = r0
            goto L_0x002f
        L_0x0054:
            r0 = move-exception
            r0 = r1
        L_0x0056:
            if (r5 == 0) goto L_0x005b
            r5.delete()     // Catch:{ all -> 0x0071 }
        L_0x005b:
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0050
        L_0x0061:
            r0 = move-exception
            goto L_0x0050
        L_0x0063:
            r0 = move-exception
        L_0x0064:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ IOException -> 0x006d }
        L_0x0069:
            throw r0     // Catch:{ all -> 0x006a }
        L_0x006a:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L_0x006d:
            r1 = move-exception
            goto L_0x0069
        L_0x006f:
            r0 = move-exception
            goto L_0x0050
        L_0x0071:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x0064
        L_0x0076:
            r1 = move-exception
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.initialize():void");
    }

    public synchronized void invalidate(String str, boolean z) {
        Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0;
            if (z) {
                entry.ttl = 0;
            }
            put(str, entry);
        }
    }

    public synchronized void put(String str, Entry entry) {
        pruneIfNeeded(entry.data.length);
        File fileForKey = getFileForKey(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileForKey);
            CacheHeader cacheHeader = new CacheHeader(str, entry);
            if (!cacheHeader.writeHeader(fileOutputStream)) {
                fileOutputStream.close();
                VolleyLog.m2461d("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(entry.data);
            fileOutputStream.close();
            putEntry(str, cacheHeader);
        } catch (IOException e) {
            if (!fileForKey.delete()) {
                VolleyLog.m2461d("Could not clean up file %s", fileForKey.getAbsolutePath());
            }
        }
    }

    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        removeEntry(str);
        if (!delete) {
            VolleyLog.m2461d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }

    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        return new StringBuilder(String.valueOf(String.valueOf(str.substring(0, length).hashCode()))).append(String.valueOf(str.substring(length).hashCode())).toString();
    }

    public File getFileForKey(String str) {
        return new File(this.mRootDirectory, getFilenameForKey(str));
    }

    private void pruneIfNeeded(int i) {
        int i2;
        if (this.mTotalSize + ((long) i) >= ((long) this.mMaxCacheSizeInBytes)) {
            if (VolleyLog.DEBUG) {
                VolleyLog.m2464v("Pruning old cache entries.", new Object[0]);
            }
            long j = this.mTotalSize;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.mEntries.entrySet().iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    CacheHeader cacheHeader = (CacheHeader) ((Map.Entry) it.next()).getValue();
                    if (getFileForKey(cacheHeader.key).delete()) {
                        this.mTotalSize -= cacheHeader.size;
                    } else {
                        VolleyLog.m2461d("Could not delete cache entry for key=%s, filename=%s", cacheHeader.key, getFilenameForKey(cacheHeader.key));
                    }
                    it.remove();
                    i2 = i3 + 1;
                    if (((float) (this.mTotalSize + ((long) i))) < ((float) this.mMaxCacheSizeInBytes) * HYSTERESIS_FACTOR) {
                        break;
                    }
                    i3 = i2;
                } else {
                    i2 = i3;
                    break;
                }
            }
            if (VolleyLog.DEBUG) {
                VolleyLog.m2464v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.mTotalSize - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void putEntry(String str, CacheHeader cacheHeader) {
        if (!this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.size;
        } else {
            CacheHeader cacheHeader2 = (CacheHeader) this.mEntries.get(str);
            this.mTotalSize = (cacheHeader.size - cacheHeader2.size) + this.mTotalSize;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private void removeEntry(String str) {
        CacheHeader cacheHeader = (CacheHeader) this.mEntries.get(str);
        if (cacheHeader != null) {
            this.mTotalSize -= cacheHeader.size;
            this.mEntries.remove(str);
        }
    }

    private static byte[] streamToBytes(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = 0;
            try {
                read = inputStream.read(bArr, i2, i - i2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        try {
            throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static int read(InputStream inputStream) throws EOFException {
        int read = 0;
        try {
            read = inputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int readInt(InputStream inputStream) throws EOFException {
        return (read(inputStream) << 0) | 0 | (read(inputStream) << 8) | (read(inputStream) << 16) | (read(inputStream) << 24);
    }

    static void writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long readLong(InputStream inputStream) throws EOFException {
        return 0 | ((((long) read(inputStream)) & 255) << 0) | ((((long) read(inputStream)) & 255) << 8) | ((((long) read(inputStream)) & 255) << 16) | ((((long) read(inputStream)) & 255) << 24) | ((((long) read(inputStream)) & 255) << 32) | ((((long) read(inputStream)) & 255) << 40) | ((((long) read(inputStream)) & 255) << 48) | ((((long) read(inputStream)) & 255) << 56);
    }

    static void writeString(OutputStream outputStream, String str) throws Exception {
        byte[] bytes = str.getBytes("UTF-8");
        writeLong(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String readString(InputStream inputStream) throws EOFException, UnsupportedEncodingException {
        return new String(streamToBytes(inputStream, (int) readLong(inputStream)), "UTF-8");
    }

    static void writeStringStringMap(Map<String, String> map, OutputStream outputStream) throws Exception {
        if (map != null) {
            writeInt(outputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                writeString(outputStream, (String) entry.getKey());
                writeString(outputStream, (String) entry.getValue());
            }
            return;
        }
        writeInt(outputStream, 0);
    }

    static Map<String, String> readStringStringMap(InputStream inputStream) throws EOFException, UnsupportedEncodingException {
        Map<String, String> hashMap;
        int readInt = readInt(inputStream);
        if (readInt == 0) {
            hashMap = Collections.emptyMap();
        } else {
            hashMap = new HashMap<>(readInt);
        }
        for (int i = 0; i < readInt; i++) {
            hashMap.put(readString(inputStream).intern(), readString(inputStream).intern());
        }
        return hashMap;
    }
}
