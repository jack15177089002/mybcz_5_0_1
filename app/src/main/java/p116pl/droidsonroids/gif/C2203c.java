package p116pl.droidsonroids.gif;

/* renamed from: pl.droidsonroids.gif.c */
/* compiled from: GifDrawable */
final class C2203c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GifDrawable f6850a;

    C2203c(GifDrawable gifDrawable) {
        this.f6850a = gifDrawable;
    }

    public final void run() {
        GifDrawable.restoreRemainder(this.f6850a.f6834b);
        this.f6850a.invalidateSelf();
    }
}
