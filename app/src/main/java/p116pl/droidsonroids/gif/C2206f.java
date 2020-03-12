package p116pl.droidsonroids.gif;

/* renamed from: pl.droidsonroids.gif.f */
/* compiled from: GifDrawable */
final class C2206f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f6853a;

    /* renamed from: b */
    final /* synthetic */ GifDrawable f6854b;

    C2206f(GifDrawable gifDrawable, int i) {
        this.f6854b = gifDrawable;
        this.f6853a = i;
    }

    public final void run() {
        GifDrawable.seekToTime(this.f6854b.f6834b, this.f6853a, this.f6854b.f6842j);
        this.f6854b.invalidateSelf();
    }
}
