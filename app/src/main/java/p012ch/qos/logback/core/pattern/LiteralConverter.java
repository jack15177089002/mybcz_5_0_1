package p012ch.qos.logback.core.pattern;

/* renamed from: ch.qos.logback.core.pattern.LiteralConverter */
public final class LiteralConverter<E> extends Converter<E> {
    String literal;

    public LiteralConverter(String str) {
        this.literal = str;
    }

    public final String convert(E e) {
        return this.literal;
    }
}
