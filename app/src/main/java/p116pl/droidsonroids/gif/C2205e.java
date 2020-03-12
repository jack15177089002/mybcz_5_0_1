package p116pl.droidsonroids.gif;

/* renamed from: pl.droidsonroids.gif.e */
/* compiled from: GifDrawable */
final class C2205e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GifDrawable f6852a;

    C2205e(GifDrawable gifDrawable) {
        this.f6852a = gifDrawable;
    }

    public final void run() {
        this.f6852a.invalidateSelf();
    }
}
