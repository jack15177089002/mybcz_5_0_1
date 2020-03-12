package p116pl.droidsonroids.gif;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.Locale;

/* renamed from: pl.droidsonroids.gif.GifAnimationMetaData */
public class GifAnimationMetaData implements Parcelable, Serializable {
    public static final Creator<GifAnimationMetaData> CREATOR = new C2201a();

    /* renamed from: a */
    private final int[] f6832a;

    /* synthetic */ GifAnimationMetaData(Parcel parcel, byte b) {
        this(parcel);
    }

    public String toString() {
        boolean z = true;
        String format = String.format(Locale.US, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", new Object[]{Integer.valueOf(this.f6832a[0]), Integer.valueOf(this.f6832a[1]), Integer.valueOf(this.f6832a[2]), this.f6832a[3] == 0 ? "Infinity" : Integer.toString(this.f6832a[3]), Integer.valueOf(this.f6832a[4])});
        if (this.f6832a[2] <= 1 || this.f6832a[4] <= 0) {
            z = false;
        }
        return z ? "Animated " + format : format;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        for (int writeInt : this.f6832a) {
            parcel.writeInt(writeInt);
        }
    }

    private GifAnimationMetaData(Parcel parcel) {
        this.f6832a = new int[5];
        for (int i = 0; i < this.f6832a.length; i++) {
            this.f6832a[i] = parcel.readInt();
        }
    }
}
