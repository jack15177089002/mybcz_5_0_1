package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Context;

/* compiled from: NativeRegExp */
class CompilerState {
    int classCount;

    /* renamed from: cp */
    int f6813cp = 0;
    char[] cpbegin;
    int cpend;

    /* renamed from: cx */
    Context f6814cx;
    int flags;
    int parenCount;
    int parenNesting;
    int progLength;
    RENode result;

    CompilerState(Context lVar, char[] cArr, int i, int i2) {
        this.f6814cx = lVar;
        this.cpbegin = cArr;
        this.cpend = i;
        this.flags = i2;
        this.parenCount = 0;
        this.classCount = 0;
        this.progLength = 0;
    }
}
