package com.baicizhan.client.wordlock.util;

import android.view.animation.Interpolator;
import com.baicizhan.client.wordlock.util.EasingType.Type;

public class ElasticInterpolator implements Interpolator {
    private float amplitude;
    private float period;
    private Type type;

    public ElasticInterpolator(Type type2, float f, float f2) {
        this.type = type2;
        this.amplitude = f;
        this.period = f2;
    }

    public float getInterpolation(float f) {
        if (this.type == Type.IN) {
            return m2798in(f, this.amplitude, this.period);
        }
        if (this.type == Type.OUT) {
            return out(f, this.amplitude, this.period);
        }
        if (this.type == Type.INOUT) {
            return inout(f, this.amplitude, this.period);
        }
        return 0.0f;
    }

    /* renamed from: in */
    private float m2798in(float f, float f2, float f3) {
        float f4;
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f3 == 0.0f) {
            f3 = 0.3f;
        }
        if (f2 == 0.0f || f2 < 1.0f) {
            f4 = f3 / 4.0f;
            f2 = 1.0f;
        } else {
            f4 = (float) ((((double) f3) / 6.283185307179586d) * Math.asin((double) (1.0f / f2)));
        }
        float f5 = f - 1.0f;
        return (float) (-(Math.sin((((double) (f5 - f4)) * 6.283185307179586d) / ((double) f3)) * ((double) f2) * Math.pow(2.0d, (double) (10.0f * f5))));
    }

    private float out(float f, float f2, float f3) {
        float f4;
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f3 == 0.0f) {
            f3 = 0.3f;
        }
        if (f2 == 0.0f || f2 < 1.0f) {
            f4 = f3 / 4.0f;
            f2 = 1.0f;
        } else {
            f4 = (float) (Math.asin((double) (1.0f / f2)) * (((double) f3) / 6.283185307179586d));
        }
        return (float) ((Math.sin((((double) (f - f4)) * 6.283185307179586d) / ((double) f3)) * ((double) f2) * Math.pow(2.0d, (double) (-10.0f * f))) + 1.0d);
    }

    private float inout(float f, float f2, float f3) {
        float f4;
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f3 == 0.0f) {
            f3 = 0.45000002f;
        }
        if (f2 == 0.0f || f2 < 1.0f) {
            f4 = f3 / 4.0f;
            f2 = 1.0f;
        } else {
            f4 = (float) ((((double) f3) / 6.283185307179586d) * Math.asin((double) (1.0f / f2)));
        }
        float f5 = 2.0f * f;
        if (f5 < 1.0f) {
            float f6 = f5 - 1.0f;
            return (float) (Math.sin((((double) (f6 - f4)) * 6.283185307179586d) / ((double) f3)) * Math.pow(2.0d, (double) (10.0f * f6)) * ((double) f2) * -0.5d);
        }
        float f7 = f5 - 1.0f;
        return (float) ((Math.sin((((double) (f7 - f4)) * 6.283185307179586d) / ((double) f3)) * Math.pow(2.0d, (double) (-10.0f * f7)) * ((double) f2) * 0.5d) + 1.0d);
    }
}
