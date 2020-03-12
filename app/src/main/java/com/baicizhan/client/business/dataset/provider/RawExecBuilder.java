package com.baicizhan.client.business.dataset.provider;

import android.content.Context;

public class RawExecBuilder {
    String[] mBindArgs = null;
    String mDatabase;
    String mSQL;

    /* renamed from: on */
    public static RawExecBuilder m2792on(String str) {
        return new RawExecBuilder(str);
    }

    private RawExecBuilder(String str) {
        this.mDatabase = str;
    }

    public RawExecBuilder exec(String str, String... strArr) {
        this.mSQL = str;
        this.mBindArgs = strArr;
        return this;
    }

    public void perform(Context context) {
        context.getContentResolver().delete(Contracts.getRawExecContentUri(this.mDatabase, this.mSQL), null, this.mBindArgs);
    }
}
