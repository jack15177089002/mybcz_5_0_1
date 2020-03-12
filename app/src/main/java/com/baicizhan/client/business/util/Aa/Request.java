package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: com.f.a.au */
public final class Request {

    /* renamed from: r */
    private static final long f3672r = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a */
    int f3673a;

    /* renamed from: b */
    long f3674b;

    /* renamed from: c */
    boolean f3675c;

    /* renamed from: d */
    public final Uri f3676d;

    /* renamed from: e */
    public final int f3677e;

    /* renamed from: f */
    public final String f3678f;

    /* renamed from: g */
    public final List<Transformation> f3679g;

    /* renamed from: h */
    public final int f3680h;

    /* renamed from: i */
    public final int f3681i;

    /* renamed from: j */
    public final boolean f3682j;

    /* renamed from: k */
    public final boolean f3683k;

    /* renamed from: l */
    public final float f3684l;

    /* renamed from: m */
    public final float f3685m;

    /* renamed from: n */
    public final float f3686n;

    /* renamed from: o */
    public final boolean f3687o;

    /* renamed from: p */
    public final Config f3688p;

    /* renamed from: q */
    public final int f3689q;

    /* synthetic */ Request(Uri uri, int i, String str, List list, int i2, int i3, boolean z, boolean z2, float f, float f2, float f3, boolean z3, Config config, int i4, byte b) {
        this(uri, i, str, list, i2, i3, z, z2, f, f2, f3, z3, config, i4);
    }

    private Request(Uri uri, int i, String str, List<Transformation> list, int i2, int i3, boolean z, boolean z2, float f, float f2, float f3, boolean z3, Config config, int i4) {
        this.f3676d = uri;
        this.f3677e = i;
        this.f3678f = str;
        if (list == null) {
            this.f3679g = null;
        } else {
            this.f3679g = Collections.unmodifiableList(list);
        }
        this.f3680h = i2;
        this.f3681i = i3;
        this.f3682j = z;
        this.f3683k = z2;
        this.f3684l = f;
        this.f3685m = f2;
        this.f3686n = f3;
        this.f3687o = z3;
        this.f3688p = config;
        this.f3689q = i4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        if (this.f3677e > 0) {
            sb.append(this.f3677e);
        } else {
            sb.append(this.f3676d);
        }
        if (this.f3679g != null && !this.f3679g.isEmpty()) {
            for (Transformation key : this.f3679g) {
                sb.append(' ').append(key.key());
            }
        }
        if (this.f3678f != null) {
            sb.append(" stableKey(").append(this.f3678f).append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        if (this.f3680h > 0) {
            sb.append(" resize(").append(this.f3680h).append(CoreConstants.COMMA_CHAR).append(this.f3681i).append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        if (this.f3682j) {
            sb.append(" centerCrop");
        }
        if (this.f3683k) {
            sb.append(" centerInside");
        }
        if (this.f3684l != 0.0f) {
            sb.append(" rotation(").append(this.f3684l);
            if (this.f3687o) {
                sb.append(" @ ").append(this.f3685m).append(CoreConstants.COMMA_CHAR).append(this.f3686n);
            }
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        if (this.f3688p != null) {
            sb.append(' ').append(this.f3688p);
        }
        sb.append(CoreConstants.CURLY_RIGHT);
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo16321a() {
        long nanoTime = System.nanoTime() - this.f3674b;
        if (nanoTime > f3672r) {
            return mo16322b() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return mo16322b() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final String mo16322b() {
        return "[R" + this.f3673a + ']';
    }

    /* renamed from: c */
    public final boolean mo16323c() {
        return (this.f3680h == 0 && this.f3681i == 0) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final boolean mo16324d() {
        return mo16323c() || this.f3684l != 0.0f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final boolean mo16325e() {
        return this.f3679g != null;
    }
}
