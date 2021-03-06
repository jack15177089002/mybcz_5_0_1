package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = new Comparator<byte[]>() {
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private List<byte[]> mBuffersByLastUse = new LinkedList();
    private List<byte[]> mBuffersBySize = new ArrayList(64);
    private int mCurrentSize = 0;
    private final int mSizeLimit;

    public ByteArrayPool(int i) {
        this.mSizeLimit = i;
    }

    public synchronized byte[] getBuf(int i) {
        byte[] bArr;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mBuffersBySize.size()) {
                bArr = new byte[i];
                break;
            }
            bArr = (byte[]) this.mBuffersBySize.get(i3);
            if (bArr.length >= i) {
                this.mCurrentSize -= bArr.length;
                this.mBuffersBySize.remove(i3);
                this.mBuffersByLastUse.remove(bArr);
                break;
            }
            i2 = i3 + 1;
        }
        return bArr;
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.mSizeLimit) {
                this.mBuffersByLastUse.add(bArr);
                int binarySearch = Collections.binarySearch(this.mBuffersBySize, bArr, BUF_COMPARATOR);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.mBuffersBySize.add(binarySearch, bArr);
                this.mCurrentSize += bArr.length;
                trim();
            }
        }
    }

    private synchronized void trim() {
        while (this.mCurrentSize > this.mSizeLimit) {
            byte[] bArr = (byte[]) this.mBuffersByLastUse.remove(0);
            this.mBuffersBySize.remove(bArr);
            this.mCurrentSize -= bArr.length;
        }
    }
}
