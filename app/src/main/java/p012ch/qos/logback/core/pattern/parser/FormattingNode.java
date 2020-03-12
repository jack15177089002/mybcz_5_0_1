package p012ch.qos.logback.core.pattern.parser;

import p012ch.qos.logback.core.pattern.FormatInfo;

/* renamed from: ch.qos.logback.core.pattern.parser.FormattingNode */
public class FormattingNode extends Node {
    FormatInfo formatInfo;

    FormattingNode(int i) {
        super(i);
    }

    FormattingNode(int i, Object obj) {
        super(i, obj);
    }

    public FormatInfo getFormatInfo() {
        return this.formatInfo;
    }

    public void setFormatInfo(FormatInfo formatInfo2) {
        this.formatInfo = formatInfo2;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof FormattingNode)) {
            return false;
        }
        FormattingNode formattingNode = (FormattingNode) obj;
        if (this.formatInfo != null) {
            return this.formatInfo.equals(formattingNode.formatInfo);
        }
        if (formattingNode.formatInfo == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.formatInfo != null ? this.formatInfo.hashCode() : 0) + (super.hashCode() * 31);
    }
}
