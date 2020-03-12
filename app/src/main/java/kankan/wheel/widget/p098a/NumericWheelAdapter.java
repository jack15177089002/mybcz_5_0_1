package kankan.wheel.widget.p098a;

import android.content.Context;

/* renamed from: kankan.wheel.widget.a.c */
public final class NumericWheelAdapter extends AbstractWheelTextAdapter {

    /* renamed from: a */
    private int f5754a = 0;

    /* renamed from: b */
    private int f5755b;

    /* renamed from: c */
    private String f5756c;

    public NumericWheelAdapter(Context context, int i, String str) {
        super(context);
        this.f5755b = i;
        this.f5756c = str;
    }

    public final CharSequence getItemText(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return null;
        }
        int i2 = this.f5754a + i;
        if (this.f5756c == null) {
            return Integer.toString(i2);
        }
        return String.format(this.f5756c, new Object[]{Integer.valueOf(i2)});
    }

    public final int getItemsCount() {
        return (this.f5755b - this.f5754a) + 1;
    }
}
