//package com.baicizhan.client.business.widget;
//
//import android.annotation.SuppressLint;
//import android.app.Dialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import android.content.DialogInterface.OnDismissListener;
//import android.content.DialogInterface.OnKeyListener;
//import android.content.res.Resources;
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import android.text.TextUtils;
//import android.text.method.LinkMovementMethod;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.R;
//import com.baicizhan.client.business.util.PicassoUtil.Corners;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import java.util.ArrayList;
//import java.util.Map;
//
//public class BczDialog extends Dialog {
//    public static final int BUTTON0_ID = 10000;
//    public static final int BUTTON1_ID = 10001;
//    public static final int BUTTON2_ID = 10002;
//    private OnClickListener dismissListener = new OnClickListener() {
//        public void onClick(DialogInterface dialogInterface, int i) {
//            dialogInterface.dismiss();
//        }
//    };
//    private View.OnClickListener handleBtnClickListener = new View.OnClickListener() {
//        public void onClick(View view) {
//            if (BczDialog.this.mButtonsListener != null) {
//                BczDialog.this.mButtonsListener.onClick(BczDialog.this, view.getId());
//            }
//        }
//    };
//    protected boolean isShow = false;
//    private LinearLayout mBaseView;
//    private LinearLayout mButtonArea = null;
//    /* access modifiers changed from: private */
//    public OnClickListener mButtonsListener = null;
//    private RelativeLayout mContentContainer;
//    private Context mContext;
//    private LayoutInflater mInflater;
//    private Resources mResources;
//    private Object mTag = null;
//    private View mTitleLayout;
//    private TextView mTitleText;
//
//    public static class Builder {
//        private OnClickListener btnsListener = null;
//        private CharSequence[] buttonsText = null;
//        private boolean cancellable = true;
//        private View contentView = null;
//        private OnClickListener legacyButtonProxyListener = new OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                switch (i) {
//                    case 10000:
//                        if (!Builder.this.legacyButtonsListener.containsKey(Integer.valueOf(-2))) {
//                            if (!Builder.this.legacyButtonsListener.containsKey(Integer.valueOf(-3))) {
//                                if (Builder.this.legacyButtonsListener.containsKey(Integer.valueOf(-1))) {
//                                    OnClickListener onClickListener = (OnClickListener) Builder.this.legacyButtonsListener.get(Integer.valueOf(-1));
//                                    if (onClickListener != null) {
//                                        onClickListener.onClick(dialogInterface, -1);
//                                        break;
//                                    }
//                                }
//                            } else {
//                                OnClickListener onClickListener2 = (OnClickListener) Builder.this.legacyButtonsListener.get(Integer.valueOf(-3));
//                                if (onClickListener2 != null) {
//                                    onClickListener2.onClick(dialogInterface, -3);
//                                    break;
//                                }
//                            }
//                        } else {
//                            OnClickListener onClickListener3 = (OnClickListener) Builder.this.legacyButtonsListener.get(Integer.valueOf(-2));
//                            if (onClickListener3 != null) {
//                                onClickListener3.onClick(dialogInterface, -2);
//                                break;
//                            }
//                        }
//                        break;
//                    case 10001:
//                        if (!Builder.this.legacyButtonsListener.containsKey(Integer.valueOf(-3))) {
//                            if (Builder.this.legacyButtonsListener.containsKey(Integer.valueOf(-1))) {
//                                OnClickListener onClickListener4 = (OnClickListener) Builder.this.legacyButtonsListener.get(Integer.valueOf(-1));
//                                if (onClickListener4 != null) {
//                                    onClickListener4.onClick(dialogInterface, -1);
//                                    break;
//                                }
//                            }
//                        } else {
//                            OnClickListener onClickListener5 = (OnClickListener) Builder.this.legacyButtonsListener.get(Integer.valueOf(-3));
//                            if (onClickListener5 != null) {
//                                onClickListener5.onClick(dialogInterface, -3);
//                                break;
//                            }
//                        }
//                        break;
//                    case 10002:
//                        if (Builder.this.legacyButtonsListener.containsKey(Integer.valueOf(-1))) {
//                            OnClickListener onClickListener6 = (OnClickListener) Builder.this.legacyButtonsListener.get(Integer.valueOf(-1));
//                            if (onClickListener6 != null) {
//                                onClickListener6.onClick(dialogInterface, -1);
//                                break;
//                            }
//                        }
//                        break;
//                }
//                dialogInterface.dismiss();
//            }
//        };
//        /* access modifiers changed from: private */
//        public Map<Integer, OnClickListener> legacyButtonsListener = new ArrayMap();
//        private Map<Integer, CharSequence> legacyButtonsText = new ArrayMap();
//        private Context mContext = null;
//        private LayoutInflater mInflater;
//        private Resources mResources;
//        private CharSequence message = null;
//        private OnDismissListener onDismissListener = null;
//        private LayoutParams params = null;
//        private boolean singleDismissButton = false;
//        private CharSequence title = null;
//
//        public Builder(Context context) {
//            this.mContext = context;
//            this.mInflater = LayoutInflater.from(context);
//            this.mResources = context.getResources();
//        }
//
//        public Builder setTitle(CharSequence charSequence) {
//            this.title = charSequence;
//            return this;
//        }
//
//        public void setOnDissmissListener(OnDismissListener onDismissListener2) {
//            this.onDismissListener = onDismissListener2;
//        }
//
//        public Builder setTitle(int i) {
//            return setTitle((CharSequence) this.mResources.getString(i));
//        }
//
//        public Builder setMessage(CharSequence charSequence) {
//            this.contentView = null;
//            this.message = charSequence;
//            return this;
//        }
//
//        public Builder setMessage(int i) {
//            return setMessage((CharSequence) this.mResources.getString(i));
//        }
//
//        public Builder setContentView(View view, LayoutParams layoutParams) {
//            this.message = null;
//            this.contentView = view;
//            this.params = layoutParams;
//            return this;
//        }
//
//        public Builder setContentView(int i, LayoutParams layoutParams) {
//            return setContentView(this.mInflater.inflate(i, null), layoutParams);
//        }
//
//        public Builder setDialogButtons(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
//            clearLegacyButtons();
//            this.singleDismissButton = false;
//            this.buttonsText = charSequenceArr;
//            this.btnsListener = onClickListener;
//            return this;
//        }
//
//        public Builder setDialogButtons(int[] iArr, OnClickListener onClickListener) {
//            int length = iArr.length;
//            String[] strArr = new String[length];
//            for (int i = 0; i < length; i++) {
//                strArr[i] = this.mResources.getString(iArr[i]);
//            }
//            return setDialogButtons((CharSequence[]) strArr, onClickListener);
//        }
//
//        public Builder setSingleDismissButton(CharSequence charSequence) {
//            this.buttonsText = new CharSequence[]{charSequence};
//            this.singleDismissButton = true;
//            clearLegacyButtons();
//            return this;
//        }
//
//        public Builder setSingleDismissButton(int i) {
//            return setSingleDismissButton((CharSequence) this.mResources.getString(i));
//        }
//
//        public Builder setCancelable(boolean z) {
//            this.cancellable = z;
//            return this;
//        }
//
//        @SuppressLint({"Override"})
//        public BczDialog create() {
//            BczDialog bczDialog = new BczDialog(this.mContext);
//            bczDialog.setDialogTitle(this.title);
//            bczDialog.setCancelable(this.cancellable);
//            if (!this.cancellable) {
//                bczDialog.setOnKeyListener(new OnKeyListener() {
//                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
//                        switch (i) {
//                            case 4:
//                            case 84:
//                                return true;
//                            default:
//                                return false;
//                        }
//                    }
//                });
//            }
//            if (this.singleDismissButton) {
//                bczDialog.setSingleDismissButton(this.buttonsText[0]);
//            } else {
//                if (this.legacyButtonsText.size() > 0) {
//                    ArrayList arrayList = new ArrayList();
//                    if (this.legacyButtonsText.containsKey(Integer.valueOf(-2))) {
//                        arrayList.add(this.legacyButtonsText.get(Integer.valueOf(-2)));
//                    }
//                    if (this.legacyButtonsText.containsKey(Integer.valueOf(-3))) {
//                        arrayList.add(this.legacyButtonsText.get(Integer.valueOf(-3)));
//                    }
//                    if (this.legacyButtonsText.containsKey(Integer.valueOf(-1))) {
//                        arrayList.add(this.legacyButtonsText.get(Integer.valueOf(-1)));
//                    }
//                    this.buttonsText = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
//                    this.btnsListener = this.legacyButtonProxyListener;
//                }
//                bczDialog.setDialogButtons(this.buttonsText, this.btnsListener);
//            }
//            if (this.message != null) {
//                bczDialog.setDialogMessage(this.message);
//            } else {
//                bczDialog.setDialogContentView(this.contentView, this.params);
//            }
//            if (this.onDismissListener != null) {
//                bczDialog.setOnDismissListener(this.onDismissListener);
//            }
//            return bczDialog;
//        }
//
//        public void show() {
//            create().show();
//        }
//
//        private void clearLegacyButtons() {
//            this.legacyButtonsText.clear();
//            this.legacyButtonsListener.clear();
//        }
//
//        private void clearButtons() {
//            this.buttonsText = null;
//            this.btnsListener = null;
//            this.singleDismissButton = false;
//        }
//
//        public Builder setNegativeButton(int i, OnClickListener onClickListener) {
//            setNegativeButton(this.mResources.getText(i), onClickListener);
//            return this;
//        }
//
//        public Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
//            clearButtons();
//            this.legacyButtonsText.put(Integer.valueOf(-2), charSequence);
//            this.legacyButtonsListener.put(Integer.valueOf(-2), onClickListener);
//            return this;
//        }
//
//        public Builder setNeutralButton(int i, OnClickListener onClickListener) {
//            setNeutralButton(this.mResources.getText(i), onClickListener);
//            return this;
//        }
//
//        public Builder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
//            clearButtons();
//            this.legacyButtonsText.put(Integer.valueOf(-3), charSequence);
//            this.legacyButtonsListener.put(Integer.valueOf(-3), onClickListener);
//            return this;
//        }
//
//        public Builder setPositiveButton(int i, OnClickListener onClickListener) {
//            setPositiveButton(this.mResources.getText(i), onClickListener);
//            return this;
//        }
//
//        public Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
//            clearButtons();
//            this.legacyButtonsText.put(Integer.valueOf(-1), charSequence);
//            this.legacyButtonsListener.put(Integer.valueOf(-1), onClickListener);
//            return this;
//        }
//    }
//
//    public boolean isShow() {
//        return this.isShow;
//    }
//
//    public void dismiss() {
//        super.dismiss();
//        this.isShow = false;
//    }
//
//    public void show() {
//        super.show();
//        this.isShow = true;
//    }
//
//    protected BczDialog(Context context) {
//        super(context, R.style.bczDialogStyle);
//        Context ensureThemeContext = ThemeUtil.ensureThemeContext(context);
//        this.mContext = ensureThemeContext;
//        this.mInflater = LayoutInflater.from(ensureThemeContext);
//        this.mResources = ensureThemeContext.getResources();
//        this.mBaseView = (LinearLayout) this.mInflater.inflate(R.layout.bcz_dialog_base, null);
//        ThemeResUtil.setBackgroundShape(ensureThemeContext, this.mBaseView, R.attr.color_common_white, 4.0f);
//        this.mTitleLayout = this.mBaseView.findViewById(R.id.bczDialog_titleContainer);
//        ThemeResUtil.setBackgroundShape(ensureThemeContext, this.mTitleLayout, R.attr.color_progress_text, 4.0f, Corners.TOP);
//        this.mTitleText = (TextView) this.mBaseView.findViewById(R.id.bczDialog_titleText);
//        this.mContentContainer = (RelativeLayout) this.mBaseView.findViewById(R.id.bczDialog_contentView);
//        super.setContentView(this.mBaseView);
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
//    public void setDialogTitle(CharSequence charSequence) {
//        if (!TextUtils.isEmpty(charSequence)) {
//            this.mTitleLayout.setVisibility(0);
//            this.mTitleText.setText(charSequence);
//            return;
//        }
//        this.mTitleLayout.setVisibility(8);
//        this.mTitleText.setText("");
//    }
//
//    public void setDialogMessage(CharSequence charSequence) {
//        if (charSequence != null) {
//            View findViewById = this.mContentContainer.findViewById(R.id.bcz_dialog_messageText);
//            if (findViewById == null) {
//                View inflate = this.mInflater.inflate(R.layout.bcz_dialog_message, null);
//                ((TextView) inflate).setAutoLinkMask(1);
//                ((TextView) inflate).setMovementMethod(LinkMovementMethod.getInstance());
//                setDialogContentView(inflate, null);
//                findViewById = inflate;
//            }
//            ((TextView) findViewById).setText(charSequence);
//        }
//    }
//
//    public void setDialogContentView(View view, LayoutParams layoutParams) {
//        if (view != null) {
//            this.mContentContainer.removeAllViews();
//            if (layoutParams != null) {
//                this.mContentContainer.addView(view, new LayoutParams(-1, -1));
//            } else {
//                this.mContentContainer.addView(view);
//            }
//        }
//    }
//
//    public void setSingleDismissButton(CharSequence charSequence) {
//        setDialogButtons(new CharSequence[]{charSequence}, this.dismissListener);
//    }
//
//    public void setDialogButtons(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
//        if (charSequenceArr != null) {
//            int length = charSequenceArr.length;
//            if (length > 0) {
//                LinearLayout linearLayout = (LinearLayout) this.mInflater.inflate(R.layout.bcz_dialog_button_area, null);
//                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.button_layout);
//                this.mButtonsListener = onClickListener;
//                int i = 0;
//                while (i < 3 && i < length) {
//                    if (i > 0) {
//                        linearLayout2.addView(this.mInflater.inflate(R.layout.bcz_dialog_button_divider, null), new LayoutParams(DisplayUtils.dpToPx(this.mContext, 0.5f), -1));
//                    }
//                    Button button = (Button) this.mInflater.inflate(R.layout.bcz_dialog_button, null);
//                    LayoutParams layoutParams = new LayoutParams(0, -1);
//                    layoutParams.weight = 1.0f;
//                    linearLayout2.addView(button, layoutParams);
//                    button.setId(i + 10000);
//                    button.setText(charSequenceArr[i]);
//                    button.setOnClickListener(this.handleBtnClickListener);
//                    i++;
//                }
//                switch (length) {
//                    case 1:
//                        Button button2 = (Button) linearLayout.findViewById(10000);
//                        if (button2 != null) {
//                            ThemeResUtil.setBackgroundShape(this.mContext, button2, R.attr.color_progress_text, R.attr.color_button_mail_login, 4.0f, Corners.BOTTOM);
//                            break;
//                        }
//                        break;
//                    case 2:
//                        Button button3 = (Button) linearLayout.findViewById(10000);
//                        Button button4 = (Button) linearLayout.findViewById(10001);
//                        if (button3 != null) {
//                            ThemeResUtil.setBackgroundShape(this.mContext, button3, R.attr.color_progress_text, R.attr.color_button_mail_login, 4.0f, Corners.BOTTOM_LEFT);
//                        }
//                        if (button4 != null) {
//                            ThemeResUtil.setBackgroundShape(this.mContext, button4, R.attr.color_progress_text, R.attr.color_button_mail_login, 4.0f, Corners.BOTTOM_RIGHT);
//                            break;
//                        }
//                        break;
//                    case 3:
//                        Button button5 = (Button) linearLayout.findViewById(10000);
//                        Button button6 = (Button) linearLayout.findViewById(10001);
//                        Button button7 = (Button) linearLayout.findViewById(10002);
//                        if (button5 != null) {
//                            ThemeResUtil.setBackgroundShape(this.mContext, button5, R.attr.color_progress_text, R.attr.color_button_mail_login, 4.0f, Corners.BOTTOM_LEFT);
//                        }
//                        if (button6 != null) {
//                            ThemeResUtil.setBackgroundShape(this.mContext, button6, R.attr.color_progress_text, R.attr.color_button_mail_login, 4.0f, Corners.NONE);
//                        }
//                        if (button7 != null) {
//                            ThemeResUtil.setBackgroundShape(this.mContext, button7, R.attr.color_progress_text, R.attr.color_button_mail_login, 4.0f, Corners.BOTTOM_RIGHT);
//                            break;
//                        }
//                        break;
//                }
//                if (this.mButtonArea != null) {
//                    this.mBaseView.removeView(this.mButtonArea);
//                }
//                this.mButtonArea = linearLayout;
//                this.mBaseView.addView(linearLayout, new LayoutParams(-1, DisplayUtils.dpToPx(this.mContext, 40.0f)));
//                return;
//            }
//            return;
//        }
//        if (this.mButtonArea != null) {
//            this.mBaseView.removeView(this.mButtonArea);
//        }
//        this.mButtonArea = null;
//    }
//
//    public void setTag(Object obj) {
//        this.mTag = obj;
//    }
//
//    public Object getTag() {
//        return this.mTag;
//    }
//}
