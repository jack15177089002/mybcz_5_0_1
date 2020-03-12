//package com.baicizhan.client.wordtesting.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnTouchListener;
//import android.widget.Button;
//import com.baicizhan.client.wordtesting.C0933R;
//
//public class CommonButton extends Button {
//    /* access modifiers changed from: private */
//    public OnTouchListener real;
//    /* access modifiers changed from: private */
//    public ButtonTouchListener touchListener = new ButtonTouchListener();
//
//    class ButtonTouchListener implements OnTouchListener {
//        private ButtonTouchListener() {
//        }
//
//        public boolean onTouch(View view, MotionEvent motionEvent) {
//            if (motionEvent.getAction() == 0) {
//                CommonButton.this.setTextColor(CommonButton.this.getResources().getColor(C0933R.color.wordtesting_common_blue_dark));
//                CommonButton.this.setBackgroundResource(C0933R.drawable.wordtesting_shape_btn_common_hover);
//            }
//            if (motionEvent.getAction() == 1) {
//                CommonButton.this.setTextColor(CommonButton.this.getResources().getColor(C0933R.color.wordtesting_common_blue));
//                CommonButton.this.setBackgroundResource(C0933R.drawable.wordtesting_shape_btn_common);
//            }
//            return false;
//        }
//    }
//
//    public CommonButton(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        setOnTouchListener(this.touchListener);
//    }
//
//    public void setOnTouchListener(OnTouchListener onTouchListener) {
//        if (onTouchListener != this.touchListener) {
//            this.real = onTouchListener;
//            super.setOnTouchListener(new OnTouchListener() {
//                public boolean onTouch(View view, MotionEvent motionEvent) {
//                    CommonButton.this.touchListener.onTouch(view, motionEvent);
//                    if (CommonButton.this.real != null) {
//                        return CommonButton.this.real.onTouch(view, motionEvent);
//                    }
//                    return false;
//                }
//            });
//            return;
//        }
//        super.setOnTouchListener(this.touchListener);
//    }
//}
