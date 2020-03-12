package com.baicizhan.client.business.zpack;

import java.io.IOException;
import java.io.InputStream;

public class ZPackInputStream extends InputStream {
    private long mOffset;
    final ZPackage mPackage;
    private int mReadPos = 0;
    private int mSize;

    public ZPackInputStream(ZPackage zPackage, long j, int i) {
        this.mPackage = zPackage;
        this.mOffset = j;
        this.mSize = i;
    }

    public int read() {
        if (this.mReadPos >= this.mSize || this.mSize == 0) {
            return -1;
        }
        int read = this.mPackage.read(this.mOffset + ((long) this.mReadPos));
        this.mReadPos++;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3;
        if ((i | i2) < 0 || i > bArr.length || bArr.length - i < i2) {
            throw new IOException("ArrayIndexOutOffBound");
        }
        if (this.mReadPos + i2 > this.mSize) {
            i3 = this.mSize - this.mReadPos;
        } else {
            i3 = i2;
        }
        if (i3 <= 0) {
            return -1;
        }
        int read = this.mPackage.read(this.mOffset + ((long) this.mReadPos), bArr, i, i3);
        if (read < 0) {
            return -1;
        }
        this.mReadPos += read;
        return read;
    }

    public void close() {
    }

    public int available() {
        return this.mSize;
    }
}
