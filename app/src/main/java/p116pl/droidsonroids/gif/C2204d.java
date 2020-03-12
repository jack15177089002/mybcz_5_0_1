package p116pl.droidsonroids.gif;

/* renamed from: pl.droidsonroids.gif.d */
/* compiled from: GifDrawable */
final class C2204d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GifDrawable f6851a;

    C2204d(GifDrawable gifDrawable) {
        this.f6851a = gifDrawable;
    }

    public final void run() {
        GifDrawable.saveRemainder(this.f6851a.f6834b);
    }
}
