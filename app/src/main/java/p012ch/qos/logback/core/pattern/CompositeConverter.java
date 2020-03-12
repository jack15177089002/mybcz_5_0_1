package p012ch.qos.logback.core.pattern;

/* renamed from: ch.qos.logback.core.pattern.CompositeConverter */
public abstract class CompositeConverter<E> extends DynamicConverter<E> {
    Converter<E> childConverter;

    /* access modifiers changed from: protected */
    public abstract String transform(E e, String str);

    public String convert(E e) {
        StringBuilder sb = new StringBuilder();
        for (Converter<E> converter = this.childConverter; converter != null; converter = converter.next) {
            converter.write(sb, e);
        }
        return transform(e, sb.toString());
    }

    public Converter<E> getChildConverter() {
        return this.childConverter;
    }

    public void setChildConverter(Converter<E> converter) {
        this.childConverter = converter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompositeConverter<");
        if (this.formattingInfo != null) {
            sb.append(this.formattingInfo);
        }
        if (this.childConverter != null) {
            sb.append(", children: ").append(this.childConverter);
        }
        sb.append(">");
        return sb.toString();
    }
}
