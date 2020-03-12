package p116pl.droidsonroids.gif;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.io.IOException;

/* renamed from: pl.droidsonroids.gif.GifImageView */
public class GifImageView extends ImageView {
    public GifImageView(Context context) {
        super(context);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6838a(attributeSet, getResources());
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6838a(attributeSet, getResources());
    }

    public void setImageResource(int i) {
        m6839a(true, i, getResources());
    }

    public void setBackgroundResource(int i) {
        m6839a(false, i, getResources());
    }

    /* renamed from: a */
    private void m6838a(AttributeSet attributeSet, Resources resources) {
        if (attributeSet != null && resources != null && !isInEditMode()) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", -1);
            if (attributeResourceValue > 0 && "drawable".equals(resources.getResourceTypeName(attributeResourceValue))) {
                m6839a(true, attributeResourceValue, resources);
            }
            int attributeResourceValue2 = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
            if (attributeResourceValue2 > 0 && "drawable".equals(resources.getResourceTypeName(attributeResourceValue2))) {
                m6839a(false, attributeResourceValue2, resources);
            }
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private void m6839a(boolean z, int i, Resources resources) {
        try {
            GifDrawable gifDrawable = new GifDrawable(resources, i);
            if (z) {
                setImageDrawable(gifDrawable);
            } else if (VERSION.SDK_INT >= 16) {
                setBackground(gifDrawable);
            } else {
                setBackgroundDrawable(gifDrawable);
            }
        } catch (NotFoundException | IOException e) {
            if (z) {
                super.setImageResource(i);
            } else {
                super.setBackgroundResource(i);
            }
        }
    }

    public void setImageURI(Uri uri) {
        if (uri != null) {
            try {
                setImageDrawable(new GifDrawable(getContext().getContentResolver(), uri));
                return;
            } catch (IOException e) {
            }
        }
        super.setImageURI(uri);
    }
}
