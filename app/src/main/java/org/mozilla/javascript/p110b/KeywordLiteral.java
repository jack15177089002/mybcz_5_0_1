package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.af */
public final class KeywordLiteral extends AstNode {
    public KeywordLiteral() {
    }

    public KeywordLiteral(int i, int i2, int i3) {
        super(i, i2);
        mo18730a(i3);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public KeywordLiteral mo18730a(int i) {
        if (i == 43 || i == 42 || i == 45 || i == 44 || i == 160) {
            this.f6389a = i;
            return this;
        }
        throw new IllegalArgumentException("Invalid node type: " + i);
    }
}
