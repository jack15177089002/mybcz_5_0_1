package com.baicizhan.client.business.zpack;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.zip.InflaterInputStream;

public class ZPackage {
    static final /* synthetic */ boolean $assertionsDisabled = (!ZPackage.class.desiredAssertionStatus());
    private static final int CURRENT_VERSION = 808465200;
    public static final Charset DEFAULT_CHARSET = Charset.forName("utf8");
    private static final int ENTRY_SIZE = 48;
    public static final int FILE_COMPRESS = 2;
    public static final int FILE_DELETE = 1;
    public static final int FILE_FLAG_USER0 = 1024;
    public static final int FILE_FLAG_USER1 = 2048;
    private static final int HASH_SEED = 131;
    private static final int HEADER_SIZE = 128;
    private static final int MIN_CHUNK_SIZE = 4096;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 4;
    private static final int PACKAGE_FILE_SIGN = 1262571610;
    private byte[] mChunkData;
    private boolean mDirty = false;
    private ArrayList<FileEntry> mFileEntries = new ArrayList<>();
    private Hashtable<String, FileEntry> mHashTable = new Hashtable<>();
    private PackageHeader mHeader = new PackageHeader();
    private int mMode = 1;
    private long mPackageEnd;
    private RandomAccessFile mPackageFile;
    private String mPackageFilename;

    public class FileEntry extends Struct {
        int availableSize;
        long byteOffset;
        int chunkSize;
        long contentHash;
        String filename;
        int flag;
        long nameHash;
        int originSize;
        int packSize;
        int reserved;

        public FileEntry() {
            super();
        }

        public String getFileName() {
            return this.filename;
        }

        public long getByteOffset() {
            return this.byteOffset;
        }

        public int getAvailableSize() {
            return this.availableSize;
        }

        /* access modifiers changed from: 0000 */
        public void read(InputStream inputStream) {
            this.byteOffset = StructHelper.readLong(inputStream);
            this.nameHash = StructHelper.readLong(inputStream);
            this.packSize = StructHelper.readInt(inputStream);
            this.originSize = StructHelper.readInt(inputStream);
            this.flag = StructHelper.readInt(inputStream);
            this.chunkSize = StructHelper.readInt(inputStream);
            this.contentHash = StructHelper.readLong(inputStream);
            this.availableSize = StructHelper.readInt(inputStream);
            this.reserved = StructHelper.readInt(inputStream);
        }

        /* access modifiers changed from: 0000 */
        public void write(OutputStream outputStream) {
            StructHelper.writeLong(outputStream, this.byteOffset);
            StructHelper.writeLong(outputStream, this.nameHash);
            StructHelper.writeInt(outputStream, this.packSize);
            StructHelper.writeInt(outputStream, this.originSize);
            StructHelper.writeInt(outputStream, this.flag);
            StructHelper.writeInt(outputStream, this.chunkSize);
            StructHelper.writeLong(outputStream, this.contentHash);
            StructHelper.writeInt(outputStream, this.availableSize);
            StructHelper.writeInt(outputStream, this.reserved);
        }

        public String toString() {
            return "FileEntry [filename=" + this.filename + ", byteOffset=" + this.byteOffset + ", nameHash=" + this.nameHash + ", packSize=" + this.packSize + ", originSize=" + this.originSize + ", flag=" + this.flag + ", chunkSize=" + this.chunkSize + ", contentHash=" + this.contentHash + ", availableSize=" + this.availableSize + ", reserved=" + this.reserved + "]";
        }
    }

    class PackageHeader extends Struct {
        static final int RESERVED_COUNT = 18;
        int allFileEntrySize;
        int allFilenameSize;
        int chunkSize;
        int fileCount;
        long fileEntryOffset;
        int fileEntrySize;
        long filenameOffset;
        int flag;
        int headerSize;
        int originFilenamesSize;
        int[] reserved;
        int sign;
        int version;

        private PackageHeader() {
            super();
            this.reserved = new int[18];
        }

        /* access modifiers changed from: 0000 */
        public void read(InputStream inputStream) {
            this.sign = StructHelper.readInt(inputStream);
            this.version = StructHelper.readInt(inputStream);
            this.headerSize = StructHelper.readInt(inputStream);
            this.fileCount = StructHelper.readInt(inputStream);
            this.fileEntryOffset = StructHelper.readLong(inputStream);
            this.filenameOffset = StructHelper.readLong(inputStream);
            this.allFileEntrySize = StructHelper.readInt(inputStream);
            this.allFilenameSize = StructHelper.readInt(inputStream);
            this.originFilenamesSize = StructHelper.readInt(inputStream);
            this.chunkSize = StructHelper.readInt(inputStream);
            this.flag = StructHelper.readInt(inputStream);
            this.fileEntrySize = StructHelper.readInt(inputStream);
            for (int i = 0; i < 18; i++) {
                this.reserved[i] = StructHelper.readInt(inputStream);
            }
        }

        /* access modifiers changed from: 0000 */
        public void write(OutputStream outputStream) {
            StructHelper.writeInt(outputStream, this.sign);
            StructHelper.writeInt(outputStream, this.version);
            StructHelper.writeInt(outputStream, this.headerSize);
            StructHelper.writeInt(outputStream, this.fileCount);
            StructHelper.writeLong(outputStream, this.fileEntryOffset);
            StructHelper.writeLong(outputStream, this.filenameOffset);
            StructHelper.writeInt(outputStream, this.allFileEntrySize);
            StructHelper.writeInt(outputStream, this.allFilenameSize);
            StructHelper.writeInt(outputStream, this.originFilenamesSize);
            StructHelper.writeInt(outputStream, this.chunkSize);
            StructHelper.writeInt(outputStream, this.flag);
            StructHelper.writeInt(outputStream, this.fileEntrySize);
            for (int i = 0; i < 18; i++) {
                StructHelper.writeInt(outputStream, this.reserved[i]);
            }
        }

        public String toString() {
            return "PackageHeader [sign=" + this.sign + ", version=" + this.version + ", headerSize=" + this.headerSize + ", fileCount=" + this.fileCount + ", fileEntryOffset=" + this.fileEntryOffset + ", filenameOffset=" + this.filenameOffset + ", allFileEntrySize=" + this.allFileEntrySize + ", allFilenameSize=" + this.allFilenameSize + ", originFilenamesSize=" + this.originFilenamesSize + ", chunkSize=" + this.chunkSize + ", flag=" + this.flag + ", fileEntrySize=" + this.fileEntrySize + ", reserved=" + Arrays.toString(this.reserved) + "]";
        }
    }

    abstract class Struct {
        /* access modifiers changed from: 0000 */
        public abstract void read(InputStream inputStream);

        /* access modifiers changed from: 0000 */
        public abstract void write(OutputStream outputStream);

        private Struct() {
        }

        /* access modifiers changed from: 0000 */
        public void read(byte[] bArr) {
            read((InputStream) new ByteArrayInputStream(bArr));
        }

        /* access modifiers changed from: 0000 */
        public byte[] write() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(48);
            write(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }

    public ZPackage(String str, int i) {
        this.mPackageFilename = str;
        this.mMode = i;
        if ((i & 1) > 0) {
            try {
                this.mPackageFile = new RandomAccessFile(str, "r");
            } catch (IOException e) {
                this.mPackageFile = null;
//                throw e;
            }
        } else if ((i & 4) > 0) {
//            this.mPackageFile = new RandomAccessFile(str, "rw");
//            if (this.mPackageFile.length() == 0) {
//                this.mHeader.sign = PACKAGE_FILE_SIGN;
//                this.mHeader.version = CURRENT_VERSION;
//                this.mHeader.headerSize = 128;
//                this.mHeader.fileCount = 0;
//                this.mHeader.fileEntrySize = 48;
//                this.mHeader.fileEntryOffset = 128;
//                this.mHeader.allFileEntrySize = 0;
//                this.mHeader.filenameOffset = 128;
//                this.mHeader.allFilenameSize = 0;
//                this.mHeader.chunkSize = MIN_CHUNK_SIZE;
//                this.mChunkData = new byte[MIN_CHUNK_SIZE];
//                return;
//            }
        }
        readHeader();
        readFileEntries();
        readFilenames();
        checkFileEntries();
        this.mPackageEnd = this.mHeader.filenameOffset + ((long) this.mHeader.allFilenameSize);
        if ((i & 4) > 0) {
            this.mChunkData = new byte[this.mHeader.chunkSize];
        }
    }

    private void checkFileEntries() {
        if ((this.mMode & 1) <= 0) {
            Iterator it = this.mFileEntries.iterator();
            while (it.hasNext()) {
                if ((((FileEntry) it.next()).flag & 1) > 0) {
                    it.remove();
                    this.mDirty = true;
                }
            }
            this.mHeader.fileCount = this.mFileEntries.size();
        }
    }

    public void close() {
        if (this.mPackageFile != null) {
            try {
                flush();
                this.mPackageFile.close();
            } catch (IOException e) {
            } finally {
                this.mPackageFile = null;
            }
        }
    }

    public boolean isValid() {
        return this.mPackageFile != null;
    }

    public String getPackageFilename() {
        return this.mPackageFilename;
    }

    public int getFileCount() {
        return this.mHeader.fileCount;
    }

    public synchronized boolean hasFile(String str) {
        return getFileIndex(str) >= 0;
    }

    public synchronized InputStream openFile(String str) {
        ZPackInputStream zPackInputStream = null;
        int fileIndex = getFileIndex(str);
        if (fileIndex < 0) {
            zPackInputStream = null;
        } else {
            FileEntry fileEntry = getFileEntry(fileIndex);
            if ((fileEntry.flag & 2) == 0) {
                zPackInputStream = new ZPackInputStream(this, fileEntry.byteOffset, fileEntry.availableSize);
            } else {
//                throw new IOException("Compressed mode not supported");
            }
        }
        return zPackInputStream;
    }

    public synchronized FileDescriptor getFD() {
//        return this.mPackageFile.getFD();

        return null;
    }

    public synchronized void addFile(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        if ((this.mMode & 1) > 0) {
//            throw new IOException("add file to read-only package");
        }
        int i = this.mHeader.chunkSize;
        File file = new File(str2);
        if (!file.exists()) {
//            throw new IOException("file not exists: " + str);
        }
        int length = (int) file.length();
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str2));
            try {
                int fileIndex = getFileIndex(str);
                if (fileIndex >= 0) {
                    removeFileEntry(fileIndex);
                }
                FileEntry fileEntry = new FileEntry();
                fileEntry.filename = str;
                fileEntry.nameHash = stringHash(str, 131);
                fileEntry.packSize = length;
                fileEntry.originSize = length;
                fileEntry.flag = 0;
                fileEntry.chunkSize = i;
                fileEntry.contentHash = 0;
                fileEntry.availableSize = length;
                fileEntry.reserved = 0;
                this.mDirty = true;
                insertFileEntry(fileEntry);
                if (length == 0) {
                    fileEntry.flag &= -3;
                } else if ((fileEntry.flag & 2) == 0) {
                    writeRawFile(fileEntry, bufferedInputStream);
                } else {
                    throw new IOException("Compressed mode not supported");
                }
                bufferedInputStream.close();
            } catch (IOException e) {
                e = e;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (IOException e2) {
//            e = e2;
//            bufferedInputStream = null;
//            throw e;
//        } catch (Throwable th2) {
//            th = th2;
//            bufferedInputStream = null;
//            if (bufferedInputStream != null) {
//                bufferedInputStream.close();
//            }
//            throw th;
        }
    }

    public synchronized OutputStream createFile(String str, int i) {
        ZPackOutputStream zPackOutputStream = null;
        synchronized (this) {
            if ((this.mMode & 1) <= 0) {
                this.mDirty = true;
                int fileIndex = getFileIndex(str);
                if (fileIndex >= 0) {
                    removeFileEntry(fileIndex);
                }
                FileEntry fileEntry = new FileEntry();
                fileEntry.filename = str;
                fileEntry.nameHash = stringHash(str, 131);
                fileEntry.flag = 0;
                fileEntry.packSize = i;
                fileEntry.originSize = 0;
                fileEntry.contentHash = 0;
                fileEntry.availableSize = 0;
                fileEntry.reserved = 0;
                fileEntry.chunkSize = this.mHeader.chunkSize;
                if (insertFileEntry(fileEntry) >= 0) {
                    zPackOutputStream = new ZPackOutputStream(this, fileEntry);
                }
            }
        }
        return zPackOutputStream;
    }

    public synchronized OutputStream openFileToWrite(String str) {
        ZPackOutputStream zPackOutputStream = null;
        synchronized (this) {
            if ((this.mMode & 1) <= 0) {
                int fileIndex = getFileIndex(str);
                if (fileIndex >= 0) {
                    zPackOutputStream = new ZPackOutputStream(this, getFileEntry(fileIndex));
                }
            }
        }
        return zPackOutputStream;
    }

    public synchronized void removeFile(String str) {
        if ((this.mMode & 1) <= 0) {
            int fileIndex = getFileIndex(str);
            if (fileIndex >= 0) {
                removeFileEntry(fileIndex);
                this.mDirty = true;
            }
        }
    }

    public synchronized void flush() {
        if ((this.mMode & 1) <= 0 && this.mDirty) {
            writeTables(false);
            if (this.mHeader.filenameOffset + ((long) this.mHeader.allFilenameSize) > this.mPackageEnd) {
                this.mPackageEnd = this.mHeader.filenameOffset + ((long) this.mHeader.allFilenameSize);
            }
            this.mDirty = false;
        }
    }

    public synchronized void defrag() {
        if ((this.mMode & 1) <= 0 && !this.mDirty) {
            long j = (long) this.mHeader.headerSize;
            long j2 = (long) this.mHeader.headerSize;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.mFileEntries.size(); i3++) {
                FileEntry fileEntry = getFileEntry(i3);
                if (fileEntry.packSize == 0) {
                    fileEntry.byteOffset = j2;
                } else if ($assertionsDisabled || ((long) i) + j == ((long) i2) + j2) {
                    if (fileEntry.byteOffset != ((long) i) + j) {
                        inplaceMoveAhead(j, i, i2);
                        i2 = (int) (fileEntry.byteOffset - j2);
                        j = fileEntry.byteOffset;
                        i = 0;
                    }
                    fileEntry.byteOffset = j2;
                    j2 += (long) fileEntry.packSize;
                    i += fileEntry.packSize;
                } else {
                    throw new AssertionError();
                }
            }
            if (i2 > 0) {
                inplaceMoveAhead(j, i, i2);
            }
            writeTables(false);
//            this.mPackageFile.setLength(this.mPackageEnd);
        }
    }

    private synchronized void inplaceMoveAhead(long j, int i, int i2) {
        if (i > 0 && i2 > 0) {
            long j2 = j - ((long) i2);
            int i3 = i;
            long j3 = j;
            while (i3 > 0) {
                int i4 = i3 > this.mHeader.chunkSize ? this.mHeader.chunkSize : i3;
                read(j3, this.mChunkData, 0, i4);
                write(j2, this.mChunkData, 0, i4);
                j3 += (long) i4;
                j2 += (long) i4;
                i3 -= i4;
            }
        }
    }

    private int getFileIndex(String str) {
        FileEntry fileEntry = (FileEntry) this.mHashTable.get(str);
        if (fileEntry == null) {
            return -1;
        }
        return this.mFileEntries.indexOf(fileEntry);
    }

    private synchronized void readHeader() {
//        long length = this.mPackageFile.length();
//        byte[] bArr = new byte[128];
//        read(0, bArr, 0, 128);
//        this.mHeader.read(bArr);
//        if (this.mHeader.sign != PACKAGE_FILE_SIGN || this.mHeader.fileEntryOffset < ((long) this.mHeader.headerSize) || this.mHeader.fileEntryOffset + ((long) this.mHeader.allFileEntrySize) > length || this.mHeader.filenameOffset < this.mHeader.fileEntryOffset + ((long) this.mHeader.allFileEntrySize) || this.mHeader.filenameOffset + ((long) this.mHeader.allFilenameSize) > length) {
//            throw new IOException("Package Header Error");
//        }
    }

    private synchronized void writeHeader() {
        write(0, this.mHeader.write());
    }

    private synchronized void readFileEntries() {
        ByteArrayInputStream byteArrayInputStream;
        this.mFileEntries.clear();
        if (this.mHeader.fileCount != 0) {
            byte[] bArr = new byte[this.mHeader.allFileEntrySize];
            read(this.mHeader.fileEntryOffset, bArr);
            if (this.mHeader.allFileEntrySize == this.mHeader.fileEntrySize * this.mHeader.fileCount) {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
            } else {
                byteArrayInputStream = new ByteArrayInputStream(decompress(bArr));
            }
            for (int i = 0; i < this.mHeader.fileCount; i++) {
                FileEntry fileEntry = new FileEntry();
                fileEntry.read(byteArrayInputStream);
                this.mFileEntries.add(fileEntry);
            }
//            byteArrayInputStream.close();
        }
    }

    private byte[] decompress(byte[] bArr) {
        return decompress((InputStream) new ByteArrayInputStream(bArr));
    }

    private byte[] decompress(InputStream inputStream) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
//        while (true) {
//            int read = inflaterInputStream.read(bArr);
//            if (read <= 0) {
//                return byteArrayOutputStream.toByteArray();
//            }
//            byteArrayOutputStream.write(bArr, 0, read);
//        }

        return null;
    }

    private synchronized void readFilenames() {
        BufferedReader bufferedReader;
        if (this.mHeader.fileCount != 0) {
            byte[] bArr = new byte[this.mHeader.allFilenameSize];
            read(this.mHeader.filenameOffset, bArr);
            if (this.mHeader.allFilenameSize == this.mHeader.originFilenamesSize) {
                bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), DEFAULT_CHARSET));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(decompress(bArr)), DEFAULT_CHARSET));
            }
//            for (int i = 0; i < this.mHeader.fileCount; i++) {
//                String readLine = bufferedReader.readLine();
//                long stringHash = stringHash(readLine, 131);
//                FileEntry fileEntry = (FileEntry) this.mFileEntries.get(i);
//                fileEntry.filename = readLine;
//                fileEntry.nameHash = stringHash;
//                this.mHashTable.put(readLine, fileEntry);
//            }
        }
    }

    public synchronized FileEntry getFileEntry(String str) {
        FileEntry fileEntry;
        int fileIndex = getFileIndex(str);
        if (fileIndex < 0) {
            fileEntry = null;
        } else {
            fileEntry = getFileEntry(fileIndex);
        }
        return fileEntry;
    }

    public synchronized FileEntry getFileEntry(int i) {
        return (FileEntry) this.mFileEntries.get(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        r11.byteOffset = r2;
        r0 = addFileEntry(r1, r11);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int insertFileEntry(FileEntry r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.util.ArrayList<com.baicizhan.client.business.zpack.ZPackage$FileEntry> r0 = r10.mFileEntries     // Catch:{ all -> 0x008a }
            int r4 = r0.size()     // Catch:{ all -> 0x008a }
            com.baicizhan.client.business.zpack.ZPackage$PackageHeader r0 = r10.mHeader     // Catch:{ all -> 0x008a }
            int r0 = r0.headerSize     // Catch:{ all -> 0x008a }
            long r2 = (long) r0     // Catch:{ all -> 0x008a }
            r0 = 0
            r1 = r0
        L_0x000e:
            if (r1 >= r4) goto L_0x004e
            java.util.ArrayList<com.baicizhan.client.business.zpack.ZPackage$FileEntry> r0 = r10.mFileEntries     // Catch:{ all -> 0x008a }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x008a }
            com.baicizhan.client.business.zpack.ZPackage$FileEntry r0 = (com.baicizhan.client.business.zpack.ZPackage.FileEntry) r0     // Catch:{ all -> 0x008a }
            long r6 = r0.byteOffset     // Catch:{ all -> 0x008a }
            int r5 = r11.packSize     // Catch:{ all -> 0x008a }
            long r8 = (long) r5     // Catch:{ all -> 0x008a }
            long r8 = r8 + r2
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x0044
            int r5 = r11.packSize     // Catch:{ all -> 0x008a }
            long r6 = (long) r5     // Catch:{ all -> 0x008a }
            long r6 = r6 + r2
            com.baicizhan.client.business.zpack.ZPackage$PackageHeader r5 = r10.mHeader     // Catch:{ all -> 0x008a }
            long r8 = r5.fileEntryOffset     // Catch:{ all -> 0x008a }
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x003c
            com.baicizhan.client.business.zpack.ZPackage$PackageHeader r5 = r10.mHeader     // Catch:{ all -> 0x008a }
            long r6 = r5.filenameOffset     // Catch:{ all -> 0x008a }
            com.baicizhan.client.business.zpack.ZPackage$PackageHeader r5 = r10.mHeader     // Catch:{ all -> 0x008a }
            int r5 = r5.allFilenameSize     // Catch:{ all -> 0x008a }
            long r8 = (long) r5     // Catch:{ all -> 0x008a }
            long r6 = r6 + r8
            int r5 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0044
        L_0x003c:
            r11.byteOffset = r2     // Catch:{ all -> 0x008a }
            int r0 = r10.addFileEntry(r1, r11)     // Catch:{ all -> 0x008a }
        L_0x0042:
            monitor-exit(r10)
            return r0
        L_0x0044:
            long r2 = r0.byteOffset     // Catch:{ all -> 0x008a }
            int r0 = r0.packSize     // Catch:{ all -> 0x008a }
            long r6 = (long) r0     // Catch:{ all -> 0x008a }
            long r2 = r2 + r6
            int r0 = r1 + 1
            r1 = r0
            goto L_0x000e
        L_0x004e:
            if (r4 == 0) goto L_0x005c
            com.baicizhan.client.business.zpack.ZPackage$PackageHeader r0 = r10.mHeader     // Catch:{ all -> 0x008a }
            long r0 = r0.fileEntryOffset     // Catch:{ all -> 0x008a }
            int r4 = r11.packSize     // Catch:{ all -> 0x008a }
            long r4 = (long) r4     // Catch:{ all -> 0x008a }
            long r4 = r4 + r2
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x007d
        L_0x005c:
            r11.byteOffset = r2     // Catch:{ all -> 0x008a }
            long r0 = r11.byteOffset     // Catch:{ all -> 0x008a }
            int r2 = r11.packSize     // Catch:{ all -> 0x008a }
            long r2 = (long) r2     // Catch:{ all -> 0x008a }
            long r0 = r0 + r2
            long r2 = r10.mPackageEnd     // Catch:{ all -> 0x008a }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0072
            long r0 = r11.byteOffset     // Catch:{ all -> 0x008a }
            int r2 = r11.packSize     // Catch:{ all -> 0x008a }
            long r2 = (long) r2     // Catch:{ all -> 0x008a }
            long r0 = r0 + r2
            r10.mPackageEnd = r0     // Catch:{ all -> 0x008a }
        L_0x0072:
            java.util.ArrayList<com.baicizhan.client.business.zpack.ZPackage$FileEntry> r0 = r10.mFileEntries     // Catch:{ all -> 0x008a }
            int r0 = r0.size()     // Catch:{ all -> 0x008a }
            int r0 = r10.addFileEntry(r0, r11)     // Catch:{ all -> 0x008a }
            goto L_0x0042
        L_0x007d:
            long r0 = r10.mPackageEnd     // Catch:{ all -> 0x008a }
            r11.byteOffset = r0     // Catch:{ all -> 0x008a }
            long r0 = r10.mPackageEnd     // Catch:{ all -> 0x008a }
            int r2 = r11.packSize     // Catch:{ all -> 0x008a }
            long r2 = (long) r2     // Catch:{ all -> 0x008a }
            long r0 = r0 + r2
            r10.mPackageEnd = r0     // Catch:{ all -> 0x008a }
            goto L_0x0072
        L_0x008a:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.zpack.ZPackage.insertFileEntry(com.baicizhan.client.business.zpack.ZPackage$FileEntry):int");
    }

    private synchronized int addFileEntry(int i, FileEntry fileEntry) {
        this.mDirty = true;
        this.mFileEntries.add(i, fileEntry);
        this.mHeader.fileCount++;
        this.mHashTable.put(fileEntry.filename, fileEntry);
        return i;
    }

    private synchronized void removeFileEntry(int i) {
        this.mDirty = true;
        FileEntry fileEntry = (FileEntry) this.mFileEntries.remove(i);
        this.mHeader.fileCount--;
        this.mHashTable.remove(Long.valueOf(fileEntry.nameHash));
    }

    private static long stringHash(String str, int i) {
        long j = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\\') {
                charAt = '/';
            }
            j = (j * ((long) i)) + ((long) Character.toLowerCase(charAt));
        }
        return j;
    }

    private synchronized void writeRawFile(FileEntry fileEntry, InputStream inputStream) {
        int i;
//        this.mPackageFile.seek(fileEntry.byteOffset);
        int i2 = fileEntry.originSize;
        while (i2 > 0) {
            if (i2 > this.mHeader.chunkSize) {
                i = this.mHeader.chunkSize;
            } else {
                i = i2;
            }
//            inputStream.read(this.mChunkData, 0, i);
//            this.mPackageFile.write(this.mChunkData, 0, i);
            i2 -= i;
        }
    }

    public synchronized boolean setFileAvailableSize(FileEntry fileEntry, int i) {
        fileEntry.availableSize = i;
        this.mDirty = true;
        return true;
    }

    private synchronized void writeTables(boolean z) {
        synchronized (this) {
            if (!$assertionsDisabled && this.mHeader.fileCount != this.mFileEntries.size()) {
                throw new AssertionError();
            } else if (this.mFileEntries.isEmpty()) {
                this.mHeader.fileCount = 0;
                this.mHeader.allFileEntrySize = 0;
                this.mHeader.allFilenameSize = 0;
                this.mHeader.fileEntryOffset = 128;
                this.mHeader.filenameOffset = this.mHeader.fileEntryOffset;
                this.mHeader.originFilenamesSize = 0;
            } else {
                int size = this.mFileEntries.size() * 48;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                for (int i = 0; i < this.mFileEntries.size(); i++) {
                    ((FileEntry) this.mFileEntries.get(i)).write(byteArrayOutputStream);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < this.mFileEntries.size(); i2++) {
                    sb.append(((FileEntry) this.mFileEntries.get(i2)).filename).append("\n");
                }
                byte[] bytes = sb.toString().getBytes(DEFAULT_CHARSET);
                int length = bytes.length;
                FileEntry fileEntry = getFileEntry(this.mFileEntries.size() - 1);
                long j = ((long) fileEntry.packSize) + fileEntry.byteOffset;
                if (!z) {
                    this.mHeader.fileEntryOffset = j;
                } else if (j >= this.mHeader.filenameOffset + ((long) this.mHeader.allFilenameSize) || ((long) size) + j + ((long) length) <= this.mHeader.fileEntryOffset) {
                    this.mHeader.fileEntryOffset = j;
                } else {
                    this.mHeader.fileEntryOffset = this.mHeader.filenameOffset + ((long) this.mHeader.allFilenameSize);
                }
//                this.mPackageFile.seek(this.mHeader.fileEntryOffset);
//                this.mPackageFile.write(byteArray);
//                this.mPackageFile.write(bytes);
                this.mHeader.allFileEntrySize = size;
                this.mHeader.filenameOffset = this.mHeader.fileEntryOffset + ((long) this.mHeader.allFileEntrySize);
                this.mHeader.allFilenameSize = length;
                this.mHeader.originFilenamesSize = length;
                this.mPackageEnd = this.mHeader.filenameOffset + ((long) this.mHeader.allFilenameSize);
                writeHeader();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized int read(long j) {
//        if (this.mPackageFile.getFilePointer() != j) {
//            this.mPackageFile.seek(j);
//        }
//        return this.mPackageFile.read();

        return -1;
    }

    /* access modifiers changed from: 0000 */
    public synchronized int read(long j, byte[] bArr) {
        return read(j, bArr, 0, bArr.length);
    }

    /* access modifiers changed from: 0000 */
    public synchronized int read(long j, byte[] bArr, int i, int i2) {
//        if (this.mPackageFile.getFilePointer() != j) {
//            this.mPackageFile.seek(j);
//        }
//        return this.mPackageFile.read(bArr, i, i2);

        return -1;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void write(long j, int i) {
//        if (this.mPackageFile.getFilePointer() != j) {
//            this.mPackageFile.seek(j);
//        }
//        this.mPackageFile.write(i);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void write(long j, byte[] bArr) {
        write(j, bArr, 0, bArr.length);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void write(long j, byte[] bArr, int i, int i2) {
//        if (this.mPackageFile.getFilePointer() != j) {
//            this.mPackageFile.seek(j);
//        }
//        this.mPackageFile.write(bArr, i, i2);
    }
}
