//package com.baicizhan.client.business.widget;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.DialogInterface.OnCancelListener;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//
//public class BczLoadingDialog extends Dialog {
//    private RelativeLayout mBaseView;
//    private Context mContext;
//    private ImageView mLoadingImg = ((ImageView) this.mBaseView.findViewById(R.id.loading_circle));
//    private TextView mMessageText = ((TextView) this.mBaseView.findViewById(R.id.bcz_dialog_messageText));
//
//    public BczLoadingDialog(Context context) {
//        super(context, R.style.bczDialogStyle);
//        Context ensureThemeContext = ThemeUtil.ensureThemeContext(context);
//        this.mContext = ensureThemeContext;
//        this.mBaseView = (RelativeLayout) LayoutInflater.from(ensureThemeContext).inflate(R.layout.bcz_loading_dialog, null);
//        ThemeResUtil.setBackgroundShape(ensureThemeContext, this.mBaseView, R.attr.color_common_white, 4.0f);
//        super.setContentView(this.mBaseView);
//    }
//
//    public void show() {
//        if (TextUtils.isEmpty(this.mMessageText.getText().toString())) {
//            this.mMessageText.setVisibility(8);
//        } else {
//            this.mMessageText.setVisibility(0);
//        }
//        super.show();
//    }
//
//    public void setMessage(CharSequence charSequence) {
//        if (charSequence != null) {
//            this.mMessageText.setText(charSequence);
//        } else {
//            this.mMessageText.setText("");
//        }
//    }
//
//    public void setMessage(int i) {
//        setMessage(this.mContext.getText(i));
//    }
//
//    public Context getDialogContext() {
//        return this.mContext;
//    }
//
//    public void setContentView(View view) {
//        throw new UnsupportedOperationException("this method is not support");
//    }
//
//    public void setContentView(int i) {
//        throw new UnsupportedOperationException("this method is not support");
//    }
//
//    public void setTitle(int i) {
//        throw new UnsupportedOperationException("this method is not support");
//    }
//
//    public void setTitle(CharSequence charSequence) {
//        throw new UnsupportedOperationException("this method is not support");
//    }
//
//    public static BczLoadingDialog show(Context context, CharSequence charSequence) {
//        return show(context, charSequence, false, null);
//    }
//
//    public static BczLoadingDialog show(Context context, CharSequence charSequence, boolean z) {
//        return show(context, charSequence, z, null);
//    }
//
//    public static BczLoadingDialog show(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener) {
//        BczLoadingDialog bczLoadingDialog = new BczLoadingDialog(context);
//        bczLoadingDialog.setMessage(charSequence);
//        bczLoadingDialog.setCancelable(z);
//        bczLoadingDialog.setOnCancelListener(onCancelListener);
//        bczLoadingDialog.show();
//        return bczLoadingDialog;
//    }
//}
