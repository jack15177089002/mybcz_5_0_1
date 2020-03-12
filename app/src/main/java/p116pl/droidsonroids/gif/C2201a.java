package p116pl.droidsonroids.gif;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: pl.droidsonroids.gif.a */
/* compiled from: GifAnimationMetaData */
final class C2201a implements Creator<GifAnimationMetaData> {
    C2201a() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GifAnimationMetaData(parcel, 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GifAnimationMetaData[i];
    }
}
