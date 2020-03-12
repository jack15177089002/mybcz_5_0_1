package com.baicizhan.client.business.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@SuppressLint("AppCompatCustomView")
public class EmailAutoCompleteEditText extends EditText {

    /* renamed from: AT */
    private static final String f2239AT = "@";
    private static final String DEF_EMAIL = "@qq.com";
    private static final String DEF_EMAIL_DOMAIN = "qq.com";
    /* access modifiers changed from: private */
    public static final Map<String, String> EMAIL_SUFFIX_MAP;
    private boolean mMatched = false;
    private Paint mPaint;
    /* access modifiers changed from: private */
    public String mSuffix = "";

    static {
        HashMap hashMap = new HashMap();
        EMAIL_SUFFIX_MAP = hashMap;
        hashMap.put(f2239AT, DEF_EMAIL_DOMAIN);
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, DEF_EMAIL);
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@163.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@126.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@sina.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@gmail.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@sohu.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@hotmail.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@google.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@googlemail.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@yahoo.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@yahoo.com.cn");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@yahoo.cn");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@aol.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@me.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@msn.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@live.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@ymail.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@mac.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@rocketmail.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@aim.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@mail.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@btinternet.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@naver.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@rogers.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@juno.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@walla.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@139.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@189.cn");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@roadrunner.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@embarqmail.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@sky.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@cfl.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@tampabay.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@gmx.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@insightbb.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@icloud.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@frontier.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@mindspring.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@ail.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@windowslive.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@netzero.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@mchsi.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@excite.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@ntlworld.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@nate.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@outlook.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@nc.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@wi.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@rochester.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@cs.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@proxymail.facebook.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@austin.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@sogou.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@nycap.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@bigpond.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@ca.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@inbox.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@hawaii.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@carolina.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@comcast.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@live.cn");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@san.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@rcn.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@tx.rr.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@wowway.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@hoteltonight.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@att.com");
        fillEmailSuffixMap(EMAIL_SUFFIX_MAP, "@cinci.rr.com");
    }

    private static void fillEmailSuffixMap(Map<String, String> map, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(f2239AT) && map != null) {
            int length = str.length();
            int i = 0;
            while (i < length - 1) {
                String substring = str.substring(0, i + 2);
                String substring2 = i >= length + -2 ? "" : str.substring(i + 2, length);
                if (!map.containsKey(substring)) {
                    map.put(substring, substring2);
                }
                i++;
            }
        }
    }

    public EmailAutoCompleteEditText(Context context) {
        super(context);
        init(null, 0);
    }

    public EmailAutoCompleteEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public EmailAutoCompleteEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, 0);
    }

    private void init(AttributeSet attributeSet, int i) {
//        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.EmailAutoCompleteEditText, 0, i);
//        int color = obtainStyledAttributes.getColor(R.styleable.EmailAutoCompleteEditText_autoCompleteColor, -7829368);
//        obtainStyledAttributes.recycle();
//        this.mPaint = new Paint();
//        this.mPaint.setColor(color);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setTextSize(getTextSize());
        addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                boolean z;
                String obj = editable.toString();
                Iterator it = EmailAutoCompleteEditText.EMAIL_SUFFIX_MAP.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    if (obj.endsWith((String) entry.getKey())) {
                        EmailAutoCompleteEditText.this.drawEmailSuffix((String) entry.getValue());
                        EmailAutoCompleteEditText.this.mSuffix = (String) entry.getValue();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return;
                }
                if (TextUtils.isEmpty(obj) || obj.contains(EmailAutoCompleteEditText.f2239AT)) {
                    EmailAutoCompleteEditText.this.drawEmailSuffix("");
                    EmailAutoCompleteEditText.this.mSuffix = "";
                    return;
                }
                EmailAutoCompleteEditText.this.drawEmailSuffix(EmailAutoCompleteEditText.DEF_EMAIL);
                EmailAutoCompleteEditText.this.mSuffix = EmailAutoCompleteEditText.DEF_EMAIL;
            }
        });
        setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    EmailAutoCompleteEditText.this.append(EmailAutoCompleteEditText.this.mSuffix);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void drawEmailSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            setCompoundDrawables(null, null, null, null);
            return;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = getHeight();
        if (width > 0 || height > 0) {
            Rect rect = new Rect();
            int height2 = ((height - rect.height()) / 2) + (getLineBounds(0, rect) - rect.top);
            int measureText = (int) (this.mPaint.measureText(str) + 1.0f);
            Bitmap createBitmap = Bitmap.createBitmap(measureText, height, Config.ARGB_8888);
            new Canvas(createBitmap).drawText(str, 0.0f, (float) height2, this.mPaint);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createBitmap);
            int min = width - Math.min((int) this.mPaint.measureText(getText().toString()), width);
            int i = min > measureText ? measureText - min : 0;
            bitmapDrawable.setBounds(i, 0, measureText + i, height + 0);
            setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }
}
