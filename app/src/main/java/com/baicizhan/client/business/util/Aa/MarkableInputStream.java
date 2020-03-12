package com.baicizhan.client.business.util.Aa;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.f.a.ac */
final class MarkableInputStream extends InputStream {

    /* renamed from: a */
    private final InputStream f3608a;

    /* renamed from: b */
    private long f3609b;

    /* renamed from: c */
    private long f3610c;

    /* renamed from: d */
    private long f3611d;

    /* renamed from: e */
    private long f3612e;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, (byte) 0);
    }

    private MarkableInputStream(InputStream inputStream, byte b) {
        this.f3612e = -1;
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, 4096);
        }
        this.f3608a = inputStream;
    }

    public final void mark(int i) {
        this.f3612e = mo16285a(i);
    }

    /* renamed from: a */
    public final long mo16285a(int i) {
        long j = this.f3609b + ((long) i);
        if (this.f3611d < j) {
            try {
                if (this.f3610c >= this.f3609b || this.f3609b > this.f3611d) {
                    this.f3610c = this.f3609b;
                    this.f3608a.mark((int) (j - this.f3609b));
                } else {
                    this.f3608a.reset();
                    this.f3608a.mark((int) (j - this.f3610c));
                    m3499a(this.f3610c, this.f3609b);
                }
                this.f3611d = j;
            } catch (IOException e) {
                throw new IllegalStateException("Unable to mark: " + e);
            }
        }
        return this.f3609b;
    }

    public final void reset() {
        mo16286a(this.f3612e);
    }

    /* renamed from: a */
    public final void mo16286a(long j) {
        if (this.f3609b > this.f3611d || j < this.f3610c) {
            try {
                throw new IOException("Cannot reset");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        this.f3608a.reset();
        m3499a(this.f3610c, j);
        this.f3609b = j;
    }

    /* renamed from: a */
    private void m3499a(long j, long j2) {
        while (j < j2) {
//            long skip = this.f3608a.skip(j2 - j);
//            if (skip == 0) {
//                if (read() != -1) {
//                    skip = 1;
//                } else {
//                    return;
//                }
//            }
//            j += skip;
        }
    }

    public final int read() {
        int read = 0;
        try {
            read = this.f3608a.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (read != -1) {
            this.f3609b++;
        }
        return read;
    }

    public final int read(byte[] bArr) {
        int read = 0;
        try {
            read = this.f3608a.read(bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (read != -1) {
            this.f3609b += (long) read;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = 0;
        try {
            read = this.f3608a.read(bArr, i, i2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (read != -1) {
            this.f3609b += (long) read;
        }
        return read;
    }

    public final long skip(long j) {
        long skip = 0;
        try {
            skip = this.f3608a.skip(j);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f3609b += skip;
        return skip;
    }

    public final int available() {
        try {
            return this.f3608a.available();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public final void close() {
        try {
            this.f3608a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final boolean markSupported() {
        return this.f3608a.markSupported();
    }
}
