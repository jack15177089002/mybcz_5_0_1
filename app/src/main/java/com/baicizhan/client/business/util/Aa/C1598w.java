package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;
import java.io.InputStream;

/* renamed from: com.f.a.w */
/* compiled from: Downloader */
public final class C1598w {

    /* renamed from: a */
    final InputStream f3814a;

    /* renamed from: b */
    final Bitmap f3815b;

    /* renamed from: c */
    final boolean f3816c;

    /* renamed from: d */
    final long f3817d;

    public C1598w(InputStream inputStream, boolean z, long j) {
        if (inputStream == null) {
            throw new IllegalArgumentException("Stream may not be null.");
        }
        this.f3814a = inputStream;
        this.f3815b = null;
        this.f3816c = z;
        this.f3817d = j;
    }
}
