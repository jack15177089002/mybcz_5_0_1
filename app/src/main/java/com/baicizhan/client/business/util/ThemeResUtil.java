package com.baicizhan.client.business.util;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.jiongji.andriod.card.R;//import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
import com.baicizhan.client.business.util.PicassoUtil.Corners;
import com.baicizhan.client.framework.util.DisplayUtils;
import com.handmark.pulltorefresh.library.p057a.C1604j;

public class ThemeResUtil {

    public static class ShapeDrawableBuilder {
        private float mBLCorner;
        private float mBRCorner;
        private int mColor = 0;
        private int mColorAttr = -1;
        private Context mContext;
        private int mCorner = -1;
        private int mStrokeColor = -1;
        private int mStrokeWidth;
        private float mTLCorner;
        private float mTRCorner;

        public boolean isAlive() {
            return this.mContext != null;
        }

        public ShapeDrawableBuilder with(Context context) {
            this.mContext = context;
            return this;
        }

        public ShapeDrawableBuilder setColor(int i) {
            this.mColor = i;
            return this;
        }

        public ShapeDrawableBuilder setColorAttr(int i) {
            this.mColorAttr = i;
            return this;
        }

        public ShapeDrawableBuilder setStroke(int i, int i2) {
            this.mStrokeWidth = i;
            this.mStrokeColor = i2;
            return this;
        }

        public ShapeDrawableBuilder setTLCorner(int i) {
            this.mTLCorner = (float) i;
            return this;
        }

        public ShapeDrawableBuilder setTRCorner(int i) {
            this.mTRCorner = (float) i;
            return this;
        }

        public ShapeDrawableBuilder setBRCorner(int i) {
            this.mBRCorner = (float) i;
            return this;
        }

        public ShapeDrawableBuilder setBLCorner(int i) {
            this.mBLCorner = (float) i;
            return this;
        }

        public ShapeDrawableBuilder setCorner(int i) {
            this.mCorner = i;
            return this;
        }

        public ShapeDrawableBuilder setCorners(float f, Corners corners) {
            boolean z;
            boolean z2;
            float f2;
            float f3;
            float f4;
            boolean z3 = true;
            int code = corners.getCode();
            boolean z4 = code == Corners.BOTTOM.getCode() || code == Corners.BOTTOM_LEFT.getCode();
            if (code == Corners.BOTTOM.getCode() || code == Corners.BOTTOM_RIGHT.getCode()) {
                z = true;
            } else {
                z = false;
            }
            if (code == Corners.TOP.getCode() || code == Corners.TOP_LEFT.getCode()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!(code == Corners.TOP.getCode() || code == Corners.TOP_RIGHT.getCode())) {
                z3 = false;
            }
            if (z2) {
                f2 = f;
            } else {
                f2 = 0.0f;
            }
            this.mTLCorner = f2;
            if (z3) {
                f3 = f;
            } else {
                f3 = 0.0f;
            }
            this.mTRCorner = f3;
            if (z4) {
                f4 = f;
            } else {
                f4 = 0.0f;
            }
            this.mBLCorner = f4;
            if (!z) {
                f = 0.0f;
            }
            this.mBRCorner = f;
            return this;
        }

        public GradientDrawable build() {
            if (!isAlive()) {
                return null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.mStrokeWidth > 0 && this.mStrokeColor >= 0) {
                gradientDrawable.setStroke(DisplayUtils.dpToPx(this.mContext, (float) this.mStrokeWidth), ThemeUtil.getThemeColorWithAttr(this.mContext, this.mStrokeColor));
            }
            if (this.mColorAttr > 0) {
                gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this.mContext, this.mColorAttr));
            }
            if (this.mColor != 0) {
                gradientDrawable.setColor(this.mColor);
            }
            if (this.mCorner >= 0) {
                gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(this.mContext, (float) this.mCorner));
            } else {
                gradientDrawable.setCornerRadii(new float[]{(float) DisplayUtils.dpToPx(this.mContext, this.mTLCorner), (float) DisplayUtils.dpToPx(this.mContext, this.mTLCorner), (float) DisplayUtils.dpToPx(this.mContext, this.mTRCorner), (float) DisplayUtils.dpToPx(this.mContext, this.mTRCorner), (float) DisplayUtils.dpToPx(this.mContext, this.mBRCorner), (float) DisplayUtils.dpToPx(this.mContext, this.mBRCorner), (float) DisplayUtils.dpToPx(this.mContext, this.mBLCorner), (float) DisplayUtils.dpToPx(this.mContext, this.mBLCorner)});
            }
            this.mContext = null;
            return gradientDrawable;
        }
    }

    private ThemeResUtil() {
    }

    public  void setWindowOutline(Context context, View view) {
        C1604j.m3631a(view, new ShapeDrawableBuilder().with(context).setStroke(2, R.attr.color_window_outline).setCorner(6).build());
    }

    public  void setCommonBg(Context context, View view) {
        C1604j.m3631a(view, new ShapeDrawableBuilder().with(context).setColorAttr(R.attr.color_common_bg).setCorner(4).build());
    }

    public  void setCommonBgWideRound(Context context, View view) {
        C1604j.m3631a(view, new ShapeDrawableBuilder().with(context).setColorAttr(R.attr.color_common_bg).setCorner(10).build());
    }

    public  void setMessageShareBg(Context context, View view) {
        C1604j.m3631a(view, new ShapeDrawableBuilder().with(context).setColorAttr(R.attr.color_message_sharebg).setCorner(4).build());
    }

    public  void setCardBg(Context context, View view) {
        C1604j.m3631a(view, new ShapeDrawableBuilder().with(context).setColorAttr(R.attr.color_card_bg).setCorner(4).build());
    }

    public  void setProgress(Context context, View view) {
        C1604j.m3631a(view, new ShapeDrawableBuilder().with(context).setColorAttr(R.attr.color_progress).setTLCorner(4).setTRCorner(4).build());
    }

    public  void setVoiceBg(Context context, View view) {
        C1604j.m3631a(view, new ShapeDrawableBuilder().with(context).setColorAttr(R.attr.color_voice_bg).setCorner(4).build());
    }

    public  Drawable getScrollerHandleBg(Context context) {
        return new ShapeDrawableBuilder().with(context).setColorAttr(R.attr.color_button_oval).setCorner(5).build();
    }

    public static void setShape(Context context, View view, int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(context, (float) i2));
        C1604j.m3631a(view, gradientDrawable);
    }

    public  void setFmTvGoBtnShape(Context context, View view) {
        setBackgroundShape(context, view, R.attr.color_button_tvfm, R.attr.color_text_blue, 4.0f);
    }

    public static void setSubmitBtnShape(Context context, View view) {
        setBackgroundShape(context, view, R.attr.color_progress, R.attr.color_button_mail_login, 4.0f);
    }

    public static void setWordListNavBg(Context context, View view) {
        C1604j.m3631a(view, getSelectStateDrawable(context, -1, R.attr.color_window_outline));
    }

    public static Drawable getSelectStateDrawable(Context context, int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i < 0 ? 0 : ThemeUtil.getThemeColorWithAttr(context, i));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(i2 < 0 ? 0 : ThemeUtil.getThemeColorWithAttr(context, i2));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913, 16842910}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public static Drawable getSelectStateDrawable(Context context, Drawable drawable, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i < 0 ? 0 : ThemeUtil.getThemeColorWithAttr(context, i));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913, 16842910}, gradientDrawable);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static void setCheckPlayButton(Context context, CheckBox checkBox) {
        checkBox.setButtonDrawable(getCheckStateDrawable(context, ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_checkplay), ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_checkplay_checked)));
    }

    public static Drawable getCheckStateDrawable(Context context, Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912, 16842910}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static void setSpeakWordBg(Context context, View view) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_word), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_word1), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_word2), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_word1), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_word2), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_word), 150);
        C1604j.m3631a(view, animationDrawable);
    }

    public static void setSpeakSeBg(Context context, View view) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_se), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_se1), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_se2), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_se1), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_se2), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_speak_se), 150);
        C1604j.m3631a(view, animationDrawable);
    }

    public static void setSoundBg(Context context, View view) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_sound), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_sound1), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_sound2), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_sound1), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_sound2), 150);
        animationDrawable.addFrame(ThemeUtil.getThemeDrawableWithAttr(context, R.attr.drawable_sound), 150);
        C1604j.m3631a(view, animationDrawable);
    }

    public static void setBackgroundColorShape(Context context, View view, int i, int i2, float f) {
        GradientDrawable corneredRectShape = getCorneredRectShape(i, (float) DisplayUtils.dpToPx(context, f));
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = {16842919};
        stateListDrawable.addState(iArr, getCorneredRectShape(i2, (float) DisplayUtils.dpToPx(context, f)));
        stateListDrawable.addState(new int[0], corneredRectShape);
        C1604j.m3631a(view, stateListDrawable);
    }

    public static void setBackgroundShape(Context context, View view, int i, int i2, float f) {
        GradientDrawable corneredRectShape = getCorneredRectShape(ThemeUtil.getThemeColorWithAttr(context, i), (float) DisplayUtils.dpToPx(context, f));
        if (i2 > 0) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919, 16842910}, getCorneredRectShape(ThemeUtil.getThemeColorWithAttr(context, i2), (float) DisplayUtils.dpToPx(context, f)));
            stateListDrawable.addState(new int[0], corneredRectShape);
            C1604j.m3631a(view, stateListDrawable);
            return;
        }
        C1604j.m3631a(view, corneredRectShape);
    }

    public static void setBackgroundShape(Context context, View view, int i, int i2, float f, Corners corners) {
        GradientDrawable build = new ShapeDrawableBuilder().with(context).setColorAttr(i).setCorners(f, corners).build();
        if (i2 > 0) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919, 16842910}, new ShapeDrawableBuilder().with(context).setColorAttr(i2).setCorners(f, corners).build());
            stateListDrawable.addState(new int[0], build);
            C1604j.m3631a(view, stateListDrawable);
            return;
        }
        C1604j.m3631a(view, build);
    }

    public static void setBackgroundShape(Context context, View view, int i, float f, Corners corners) {
        setBackgroundShape(context, view, i, -1, f, corners);
    }

    public static void setBackgroundShape(Context context, View view, int i, float f) {
        setBackgroundShape(context, view, i, -1, f);
    }

    public static GradientDrawable getCorneredRectShape(int i, float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    public  void setBacizhanProgress2(Context context, ProgressBar progressBar) {
        setBaicizhanProgress(context, progressBar, R.attr.color_progress_bg2, R.attr.color_progress);
    }

    public static void setBaicizhanProgress(Context context, ProgressBar progressBar) {
//        setBaicizhanProgress(context, progressBar, R.attr.color_progress_bg, R.attr.color_progress);
    }

    public  void setBaicizhanProgress(Context context, ProgressBar progressBar, int i, int i2) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ShapeDrawableBuilder().with(context).setColorAttr(i).setCorner(90).build(), new ClipDrawable(new ShapeDrawableBuilder().with(context).setColorAttr(i2).setCorner(90).build(), 3, 1)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        progressBar.setProgressDrawable(layerDrawable);
    }
}
