package p012ch.qos.logback.core.subst;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.core.subst.Token */
public class Token {
    public static final Token CURLY_LEFT_TOKEN = new Token(Type.CURLY_LEFT, null);
    public static final Token CURLY_RIGHT_TOKEN = new Token(Type.CURLY_RIGHT, null);
    public static final Token DEFAULT_SEP_TOKEN = new Token(Type.DEFAULT, null);
    public static final Token START_TOKEN = new Token(Type.START, null);
    String payload;
    Type type;

    /* renamed from: ch.qos.logback.core.subst.Token$Type */
    public enum Type {
        LITERAL,
        START,
        CURLY_LEFT,
        CURLY_RIGHT,
        DEFAULT
    }

    public Token(Type type2, String str) {
        this.type = type2;
        this.payload = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Token token = (Token) obj;
        if (this.type != token.type) {
            return false;
        }
        if (this.payload != null) {
            if (this.payload.equals(token.payload)) {
                return true;
            }
        } else if (token.payload == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (this.type != null) {
            i = this.type.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * 31;
        if (this.payload != null) {
            i2 = this.payload.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        String str = "Token{type=" + this.type;
        if (this.payload != null) {
            str = new StringBuilder(String.valueOf(str)).append(", payload='").append(this.payload).append(CoreConstants.SINGLE_QUOTE_CHAR).toString();
        }
        return new StringBuilder(String.valueOf(str)).append(CoreConstants.CURLY_RIGHT).toString();
    }
}
