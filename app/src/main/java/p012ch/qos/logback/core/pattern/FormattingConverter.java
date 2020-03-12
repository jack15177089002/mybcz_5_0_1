package p012ch.qos.logback.core.pattern;

/* renamed from: ch.qos.logback.core.pattern.FormattingConverter */
public abstract class FormattingConverter<E> extends Converter<E> {
    static final int INITIAL_BUF_SIZE = 256;
    static final int MAX_CAPACITY = 1024;
    FormatInfo formattingInfo;

    public final FormatInfo getFormattingInfo() {
        return this.formattingInfo;
    }

    public final void setFormattingInfo(FormatInfo formatInfo) {
        if (this.formattingInfo != null) {
            throw new IllegalStateException("FormattingInfo has been already set");
        }
        this.formattingInfo = formatInfo;
    }

    public final void write(StringBuilder sb, E e) {
        String convert = convert(e);
        if (this.formattingInfo == null) {
            sb.append(convert);
            return;
        }
        int min = this.formattingInfo.getMin();
        int max = this.formattingInfo.getMax();
        if (convert != null) {
            int length = convert.length();
            if (length > max) {
                if (this.formattingInfo.isLeftTruncate()) {
                    sb.append(convert.substring(length - max));
                } else {
                    sb.append(convert.substring(0, max));
                }
            } else if (length >= min) {
                sb.append(convert);
            } else if (this.formattingInfo.isLeftPad()) {
                SpacePadder.leftPad(sb, convert, min);
            } else {
                SpacePadder.rightPad(sb, convert, min);
            }
        } else if (min > 0) {
            SpacePadder.spacePad(sb, min);
        }
    }
}
