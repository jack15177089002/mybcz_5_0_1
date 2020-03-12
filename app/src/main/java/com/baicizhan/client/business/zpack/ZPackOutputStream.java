package com.baicizhan.client.business.zpack;

import com.baicizhan.client.business.zpack.ZPackage.FileEntry;
import java.io.IOException;
import java.io.OutputStream;

public class ZPackOutputStream extends OutputStream {
    private FileEntry mEntry;
    private long mOffset;
    final ZPackage mPackage;
    private int mSize;
    private int mWritePos = 0;

    public ZPackOutputStream(ZPackage zPackage, FileEntry fileEntry) {
        this.mPackage = zPackage;
        this.mOffset = fileEntry.byteOffset;
        this.mSize = fileEntry.packSize;
        this.mEntry = fileEntry;
    }

    public void write(int i) {
        if (this.mWritePos >= this.mSize) {
            throw new IOException("Cannt write anymore");
        }
        this.mPackage.write(this.mOffset + ((long) this.mWritePos), i);
        this.mWritePos++;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.mWritePos + i2 > this.mSize) {
            throw new IOException("Cannt write anymore");
        }
        this.mPackage.write(this.mOffset + ((long) this.mWritePos), bArr, i, i2);
        this.mWritePos += i2;
        if (!this.mPackage.setFileAvailableSize(this.mEntry, this.mWritePos)) {
            this.mSize = 0;
        }
    }
}
