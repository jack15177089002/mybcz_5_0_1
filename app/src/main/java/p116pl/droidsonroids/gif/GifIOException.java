package p116pl.droidsonroids.gif;

import java.io.IOException;
import java.util.Locale;

/* renamed from: pl.droidsonroids.gif.GifIOException */
public class GifIOException extends IOException {

    /* renamed from: a */
    public final GifError f6848a;

    private GifIOException(GifError gVar) {
        super(String.format(Locale.US, "GifError %d: %s", new Object[]{Integer.valueOf(gVar.f6877v), gVar.f6876u}));
        this.f6848a = gVar;
    }

    GifIOException(int i) {
        this(GifError.m6840a(i));
    }
}
