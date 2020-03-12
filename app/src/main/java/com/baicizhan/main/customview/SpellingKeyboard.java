//package com.baicizhan.main.customview;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;
//import com.baicizhan.main.auth.ThirdPartyUserInfo;
//import com.baicizhan.store.api.KdtApiProtocol;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import p012ch.qos.logback.core.rolling.helper.DateTokenConverter;
//import p012ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
//
//public class SpellingKeyboard extends LinearLayout {
//    private static final List<Integer> CHAR_VIEW_IDS = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(R.id.spelling_key_1), Integer.valueOf(R.id.spelling_key_2), Integer.valueOf(R.id.spelling_key_3), Integer.valueOf(R.id.spelling_key_4), Integer.valueOf(R.id.spelling_key_5), Integer.valueOf(R.id.spelling_key_6), Integer.valueOf(R.id.spelling_key_7), Integer.valueOf(R.id.spelling_key_8), Integer.valueOf(R.id.spelling_key_9), Integer.valueOf(R.id.spelling_key_10), Integer.valueOf(R.id.spelling_key_11), Integer.valueOf(R.id.spelling_key_12), Integer.valueOf(R.id.spelling_key_13), Integer.valueOf(R.id.spelling_key_14), Integer.valueOf(R.id.spelling_key_15), Integer.valueOf(R.id.spelling_key_16), Integer.valueOf(R.id.spelling_key_17), Integer.valueOf(R.id.spelling_key_18), Integer.valueOf(R.id.spelling_key_19), Integer.valueOf(R.id.spelling_key_20), Integer.valueOf(R.id.spelling_key_21), Integer.valueOf(R.id.spelling_key_22), Integer.valueOf(R.id.spelling_key_23), Integer.valueOf(R.id.spelling_key_24), Integer.valueOf(R.id.spelling_key_25), Integer.valueOf(R.id.spelling_key_26)}));
//    private String[] QWERTY = {"q", "w", "e", "r", "t", "y", "u", IntegerTokenConverter.CONVERTER_KEY, "o", "p", "a", "s", DateTokenConverter.CONVERTER_KEY, ThirdPartyUserInfo.GENDER_FEMALE, "g", "h", "j", "k", "l", "z", "x", "c", KdtApiProtocol.VERSION_KEY, "b", "n", ThirdPartyUserInfo.GENDER_MALE};
//    private OnClickListener mClickListener = new OnClickListener() {
//        public void onClick(View view) {
//            int id = view.getId();
//            switch (id) {
//                case R.id.spelling_key_pass /*2131297031*/:
//                    if (SpellingKeyboard.this.mListener != null) {
//                        SpellingKeyboard.this.mListener.onPassClick(view);
//                        return;
//                    }
//                    return;
//                case R.id.spelling_key_slash /*2131297039*/:
//                    if (SpellingKeyboard.this.mListener != null) {
//                        SpellingKeyboard.this.mListener.onSlashClick(view);
//                        return;
//                    }
//                    return;
//                default:
//                    SpellingKeyboard.this.handleLetterClick(view, id);
//                    return;
//            }
//        }
//    };
//    /* access modifiers changed from: private */
//    public SpellingKeyListener mListener = null;
//    private Button mPassBtn;
//    private Button mSlashBtn;
//
//    public interface SpellingKeyListener {
//        boolean onLetterClick(View view, String str);
//
//        void onPassClick(View view);
//
//        void onSlashClick(View view);
//    }
//
//    public SpellingKeyboard(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        init();
//    }
//
//    private void init() {
//        int size = CHAR_VIEW_IDS.size();
//        for (int i = 0; i < size; i++) {
//            Button button = (Button) findViewById(((Integer) CHAR_VIEW_IDS.get(i)).intValue());
//            button.setText(this.QWERTY[i].toUpperCase());
//            button.setOnClickListener(this.mClickListener);
//        }
//        this.mPassBtn = (Button) findViewById(R.id.spelling_key_pass);
//        this.mPassBtn.setText(R.string.pass);
//        this.mPassBtn.setOnClickListener(this.mClickListener);
//        this.mSlashBtn = (Button) findViewById(R.id.spelling_key_slash);
//        this.mSlashBtn.setText(R.string.kill);
//        this.mSlashBtn.setOnClickListener(this.mClickListener);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onMeasure(int i, int i2) {
//        super.onMeasure(i, i2);
//        int measuredWidth = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) / 10;
//        for (Integer intValue : CHAR_VIEW_IDS) {
//            LayoutParams layoutParams = (LayoutParams) findViewById(intValue.intValue()).getLayoutParams();
//            layoutParams.width = (measuredWidth - layoutParams.leftMargin) - layoutParams.rightMargin;
//        }
//        int i3 = measuredWidth + (measuredWidth / 2);
//        LayoutParams layoutParams2 = (LayoutParams) this.mPassBtn.getLayoutParams();
//        layoutParams2.width = (i3 - layoutParams2.leftMargin) - layoutParams2.rightMargin;
//        LayoutParams layoutParams3 = (LayoutParams) this.mSlashBtn.getLayoutParams();
//        layoutParams3.width = (i3 - layoutParams3.leftMargin) - layoutParams3.rightMargin;
//    }
//
//    /* access modifiers changed from: private */
//    public void handleLetterClick(View view, int i) {
//        if (this.mListener != null) {
//            int indexOf = CHAR_VIEW_IDS.indexOf(Integer.valueOf(i));
//            if (indexOf >= 0 && indexOf <= this.QWERTY.length - 1) {
//                view.setVisibility(this.mListener.onLetterClick(view, this.QWERTY[indexOf]) ? 0 : 4);
//            }
//        }
//    }
//
//    public SpellingKeyListener getListener() {
//        return this.mListener;
//    }
//
//    public void setListener(SpellingKeyListener spellingKeyListener) {
//        this.mListener = spellingKeyListener;
//    }
//
//    public void resetKeyboard() {
//        int size = CHAR_VIEW_IDS.size();
//        for (int i = 0; i < size; i++) {
//            ((Button) findViewById(((Integer) CHAR_VIEW_IDS.get(i)).intValue())).setVisibility(0);
//        }
//    }
//}
