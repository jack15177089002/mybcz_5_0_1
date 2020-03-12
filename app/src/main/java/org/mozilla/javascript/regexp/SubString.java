package org.mozilla.javascript.regexp;

public class SubString {
    public static final SubString emptySubString = new SubString();
    int index;
    int length;
    String str;

    public SubString() {
    }

    public SubString(String str2) {
        this.str = str2;
        this.index = 0;
        this.length = str2.length();
    }

    public SubString(String str2, int i, int i2) {
        this.str = str2;
        this.index = i;
        this.length = i2;
    }

    public String toString() {
        return this.str == null ? "" : this.str.substring(this.index, this.index + this.length);
    }
}
