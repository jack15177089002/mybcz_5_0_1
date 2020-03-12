package p116pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController.MediaPlayerControl;
import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
import com.baicizhan.client.framework.log.C0789L;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: pl.droidsonroids.gif.GifDrawable */
public class GifDrawable extends Drawable implements Animatable, MediaPlayerControl {

    /* renamed from: a */
    protected final Paint f6833a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile long f6834b;

    /* renamed from: c */
    private volatile boolean f6835c;

    /* renamed from: d */
    private final int[] f6836d;

    /* renamed from: e */
    private final long f6837e;

    /* renamed from: f */
    private float f6838f;

    /* renamed from: g */
    private float f6839g;

    /* renamed from: h */
    private boolean f6840h;

    /* renamed from: i */
    private final Rect f6841i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int[] f6842j;

    /* renamed from: k */
    private final ConcurrentLinkedQueue<Object> f6843k;

    /* renamed from: l */
    private final Runnable f6844l;

    /* renamed from: m */
    private final Runnable f6845m;

    /* renamed from: n */
    private final Runnable f6846n;

    /* renamed from: o */
    private final Runnable f6847o;

    static native void free(long j);

    private static native int getCurrentPosition(long j);

    static native int getDuration(long j);

    static native long openFd(int[] iArr, FileDescriptor fileDescriptor, long j, boolean z);

    private static native boolean renderFrame(int[] iArr, long j, int[] iArr2);

    /* access modifiers changed from: private */
    public static native void reset(long j);

    /* access modifiers changed from: private */
    public static native void restoreRemainder(long j);

    /* access modifiers changed from: private */
    public static native void saveRemainder(long j);

    /* access modifiers changed from: private */
    public static native void seekToTime(long j, int i, int[] iArr);

    static {
        try {
            System.loadLibrary("gif");
            PropertyHelper.put("key_giflib_enabled", true);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            PropertyHelper.put("key_giflib_enabled", false);
            C0789L.log.error("gif library load failed.", (Throwable) e);
        } catch (Throwable th) {
            th.printStackTrace();
            C0789L.log.error("gif library load failed.", th);
        }
    }

    /* renamed from: a */
    private void m6834a(Runnable runnable) {
        scheduleSelf(runnable, SystemClock.uptimeMillis());
    }

    public GifDrawable(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
    }

    private GifDrawable(AssetFileDescriptor assetFileDescriptor) {
        this.f6835c = true;
        this.f6836d = new int[5];
        this.f6838f = 1.0f;
        this.f6839g = 1.0f;
        this.f6841i = new Rect();
        this.f6833a = new Paint(6);
        this.f6843k = new ConcurrentLinkedQueue<>();
        this.f6844l = new C2202b(this);
        this.f6845m = new C2203c(this);
        this.f6846n = new C2204d(this);
        this.f6847o = new C2205e(this);
        if (assetFileDescriptor == null) {
            throw new NullPointerException("Source is null");
        }
        try {
            this.f6834b = openFd(this.f6836d, assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
            this.f6842j = new int[(this.f6836d[0] * this.f6836d[1])];
            this.f6837e = assetFileDescriptor.getLength();
        } catch (IOException e) {
            assetFileDescriptor.close();
            throw e;
        }
    }

    public GifDrawable(ContentResolver contentResolver, Uri uri) {
        this(contentResolver.openAssetFileDescriptor(uri, "r"));
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            this.f6835c = false;
            long j = this.f6834b;
            this.f6834b = 0;
            this.f6842j = null;
            free(j);
        } finally {
            super.finalize();
        }
    }

    public int getIntrinsicHeight() {
        return this.f6836d[1];
    }

    public int getIntrinsicWidth() {
        return this.f6836d[0];
    }

    public void setAlpha(int i) {
        this.f6833a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6833a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -2;
    }

    public void start() {
        this.f6835c = true;
        m6834a(this.f6845m);
    }

    public void stop() {
        this.f6835c = false;
        m6834a(this.f6846n);
    }

    public boolean isRunning() {
        return this.f6835c;
    }

    public String toString() {
        return String.format(Locale.US, "GIF: size: %dx%d, frames: %d, error: %d", new Object[]{Integer.valueOf(this.f6836d[0]), Integer.valueOf(this.f6836d[1]), Integer.valueOf(this.f6836d[2]), Integer.valueOf(this.f6836d[3])});
    }

    public void pause() {
        stop();
    }

    public int getDuration() {
        return getDuration(this.f6834b);
    }

    public int getCurrentPosition() {
        return getCurrentPosition(this.f6834b);
    }

    public void seekTo(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        m6834a((Runnable) new C2206f(this, i));
    }

    public boolean isPlaying() {
        return this.f6835c;
    }

    public int getBufferPercentage() {
        return 100;
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return false;
    }

    public boolean canSeekForward() {
        return this.f6836d[2] > 1;
    }

    public int getAudioSessionId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f6840h = true;
    }

    public void draw(Canvas canvas) {
        if (this.f6840h) {
            this.f6841i.set(getBounds());
            this.f6838f = ((float) this.f6841i.width()) / ((float) this.f6836d[0]);
            this.f6839g = ((float) this.f6841i.height()) / ((float) this.f6836d[1]);
            this.f6840h = false;
        }
        if (this.f6833a.getShader() == null) {
            if (!this.f6835c) {
                this.f6836d[4] = -1;
            } else if (renderFrame(this.f6842j, this.f6834b, this.f6836d)) {
                Iterator it = this.f6843k.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            canvas.scale(this.f6838f, this.f6839g);
            int[] iArr = this.f6842j;
            if (iArr != null) {
                canvas.drawBitmap(iArr, 0, this.f6836d[0], 0.0f, 0.0f, this.f6836d[0], this.f6836d[1], true, this.f6833a);
            }
            if (this.f6836d[4] >= 0 && this.f6836d[2] > 1) {
                unscheduleSelf(this.f6847o);
                scheduleSelf(this.f6847o, SystemClock.uptimeMillis() + ((long) this.f6836d[4]));
                return;
            }
            return;
        }
        canvas.drawRect(this.f6841i, this.f6833a);
    }

    public int getAlpha() {
        return this.f6833a.getAlpha();
    }

    public void setFilterBitmap(boolean z) {
        this.f6833a.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f6833a.setDither(z);
        invalidateSelf();
    }

    public int getMinimumHeight() {
        return this.f6836d[1];
    }

    public int getMinimumWidth() {
        return this.f6836d[0];
    }
}
