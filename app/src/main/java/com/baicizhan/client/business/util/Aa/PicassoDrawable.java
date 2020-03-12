package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;

/* renamed from: com.f.a.ar */
final class PicassoDrawable extends BitmapDrawable {

    /* renamed from: e */
    private static final Paint f3663e = new Paint();

    /* renamed from: a */
    Drawable f3664a;

    /* renamed from: b */
    long f3665b;

    /* renamed from: c */
    boolean f3666c;

    /* renamed from: d */
    int f3667d = 255;

    /* renamed from: f */
    private final boolean f3668f;

    /* renamed from: g */
    private final float f3669g;

    /* renamed from: h */
    private final C1573an f3670h;

    /* renamed from: a */
    static void m3520a(ImageView imageView, Context context, Bitmap bitmap, C1573an anVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new PicassoDrawable(context, bitmap, drawable, anVar, z, z2));
    }

    /* renamed from: a */
    static void m3521a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    private PicassoDrawable(Context context, Bitmap bitmap, Drawable drawable, C1573an anVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f3668f = z2;
        this.f3669g = context.getResources().getDisplayMetrics().density;
        this.f3670h = anVar;
        if (anVar != C1573an.MEMORY && !z) {
            this.f3664a = drawable;
            this.f3666c = true;
            this.f3665b = SystemClock.uptimeMillis();
        }
    }

    public final void draw(Canvas canvas) {
        if (!this.f3666c) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f3665b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f3666c = false;
                this.f3664a = null;
                super.draw(canvas);
            } else {
                if (this.f3664a != null) {
                    this.f3664a.draw(canvas);
                }
                super.setAlpha((int) (uptimeMillis * ((float) this.f3667d)));
                super.draw(canvas);
                super.setAlpha(this.f3667d);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        }
        if (this.f3668f) {
            f3663e.setColor(-1);
            canvas.drawPath(m3519a(new Point(0, 0), (int) (16.0f * this.f3669g)), f3663e);
            f3663e.setColor(this.f3670h.f3657d);
            canvas.drawPath(m3519a(new Point(0, 0), (int) (15.0f * this.f3669g)), f3663e);
        }
    }

    public final void setAlpha(int i) {
        this.f3667d = i;
        if (this.f3664a != null) {
            this.f3664a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f3664a != null) {
            this.f3664a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        if (this.f3664a != null) {
            this.f3664a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    /* renamed from: a */
    private static Path m3519a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        return path;
    }
}
