//package com.baicizhan.main.popup;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.graphics.Rect;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.PopupWindow;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.jiongji.andriod.card.R;
//import com.p047d.p050c.p051a.AnimatorProxy;
//
//public class ComboPopupWindow extends PopupWindow {
//    private static final int[] COMBO_NUMBER_RESOURCES = {R.drawable.combo_0_normal_default, R.drawable.combo_1_normal_default, R.drawable.combo_2_normal_default, R.drawable.combo_3_normal_default, R.drawable.combo_4_normal_default, R.drawable.combo_5_normal_default, R.drawable.combo_6_normal_default, R.drawable.combo_7_normal_default, R.drawable.combo_8_normal_default, R.drawable.combo_9_normal_default};
//    private Context mContext;
//    private ImageView[] mNumbers;
//
//    @SuppressLint({"InflateParams"})
//    public ComboPopupWindow(Context context) {
//        super(context);
//        this.mContext = context;
//        View inflate = LayoutInflater.from(context).inflate(R.layout.combo_popup_window, null, false);
//        setFocusable(true);
//        setTouchable(true);
//        setOutsideTouchable(false);
//        setBackgroundDrawable(context.getResources().getDrawable(17170445));
//        if (AnimatorProxy.f3559a) {
//            AnimatorProxy.m3396a(inflate).mo16224d(10.0f);
//        } else {
//            inflate.setRotation(10.0f);
//        }
//        setContentView(inflate);
//        setWindowLayoutMode(-2, -2);
//        this.mNumbers = new ImageView[]{(ImageView) inflate.findViewById(R.id.combo_number1), (ImageView) inflate.findViewById(R.id.combo_number2), (ImageView) inflate.findViewById(R.id.combo_number3)};
//    }
//
//    public void showCombo(View view, int i) {
//        String num = Integer.toString(i);
//        for (int i2 = 0; i2 < num.length(); i2++) {
//            this.mNumbers[i2].setImageResource(COMBO_NUMBER_RESOURCES[num.charAt(i2) - '0']);
//            this.mNumbers[i2].setVisibility(0);
//        }
//        for (int length = num.length(); length < this.mNumbers.length; length++) {
//            this.mNumbers[length].setVisibility(8);
//        }
//        update();
//        Rect rect = new Rect();
//        view.getGlobalVisibleRect(rect);
//        showAtLocation(view, 8388659, ((rect.right + rect.left) - DisplayUtils.dpToPx(this.mContext, 80.0f)) / 2, 0);
//    }
//}
