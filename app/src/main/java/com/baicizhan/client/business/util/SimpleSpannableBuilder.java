package com.baicizhan.client.business.util;

import android.text.SpannableStringBuilder;

public class SimpleSpannableBuilder {
    private SpannableStringBuilder builder = new SpannableStringBuilder();

    public SimpleSpannableBuilder append(String str) {
        this.builder.append(str);
        return this;
    }

    public SimpleSpannableBuilder append(String str, Object... objArr) {
        int length = this.builder.length();
        this.builder.append(str);
        int length2 = this.builder.length();
        for (Object span : objArr) {
            this.builder.setSpan(span, length, length2, 33);
        }
        return this;
    }

    public CharSequence build() {
        return this.builder;
    }
}
