package p012ch.qos.logback.core.pattern.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p012ch.qos.logback.core.pattern.Converter;
import p012ch.qos.logback.core.pattern.FormatInfo;
import p012ch.qos.logback.core.pattern.IdentityCompositeConverter;
import p012ch.qos.logback.core.pattern.ReplacingCompositeConverter;
import p012ch.qos.logback.core.pattern.util.IEscapeUtil;
import p012ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.spi.ScanException;

/* renamed from: ch.qos.logback.core.pattern.parser.Parser */
public class Parser<E> extends ContextAwareBase {
    public static final Map<String, String> DEFAULT_COMPOSITE_CONVERTER_MAP;
    public static final String MISSING_RIGHT_PARENTHESIS = "http://logback.qos.ch/codes.html#missingRightParenthesis";
    public static final String REPLACE_CONVERTER_WORD = "replace";
    int pointer;
    final List tokenList;

    static {
        HashMap hashMap = new HashMap();
        DEFAULT_COMPOSITE_CONVERTER_MAP = hashMap;
        hashMap.put(Token.BARE_COMPOSITE_KEYWORD_TOKEN.getValue().toString(), IdentityCompositeConverter.class.getName());
        DEFAULT_COMPOSITE_CONVERTER_MAP.put(REPLACE_CONVERTER_WORD, ReplacingCompositeConverter.class.getName());
    }

    Parser(TokenStream tokenStream) {
        this.pointer = 0;
        this.tokenList = tokenStream.tokenize();
    }

    public Parser(String str) {
        this(str, new RegularEscapeUtil());
    }

    public Parser(String str, IEscapeUtil iEscapeUtil) {
        this.pointer = 0;
        try {
            this.tokenList = new TokenStream(str, iEscapeUtil).tokenize();
        } catch (IllegalArgumentException e) {
            throw new ScanException("Failed to initialize Parser", e);
        }
    }

    public Converter<E> compile(Node node, Map map) {
        Compiler compiler = new Compiler(node, map);
        compiler.setContext(this.context);
        return compiler.compile();
    }

    public Node parse() {
        return mo2525E();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: E */
    public Node mo2525E() {
        Node T = mo2528T();
        if (T == null) {
            return null;
        }
        Node Eopt = Eopt();
        if (Eopt == null) {
            return T;
        }
        T.setNext(Eopt);
        return T;
    }

    /* access modifiers changed from: 0000 */
    public Node Eopt() {
        if (getCurentToken() == null) {
            return null;
        }
        return mo2525E();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: T */
    public Node mo2528T() {
        Token curentToken = getCurentToken();
        expectNotNull(curentToken, "a LITERAL or '%'");
        switch (curentToken.getType()) {
            case 37:
                advanceTokenPointer();
                Token curentToken2 = getCurentToken();
                expectNotNull(curentToken2, "a FORMAT_MODIFIER, SIMPLE_KEYWORD or COMPOUND_KEYWORD");
                if (curentToken2.getType() != 1002) {
                    return mo2523C();
                }
                FormatInfo valueOf = FormatInfo.valueOf((String) curentToken2.getValue());
                advanceTokenPointer();
                FormattingNode C = mo2523C();
                C.setFormatInfo(valueOf);
                return C;
            case 1000:
                advanceTokenPointer();
                return new Node(0, curentToken.getValue());
            default:
                return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: C */
    public FormattingNode mo2523C() {
        Token curentToken = getCurentToken();
        expectNotNull(curentToken, "a LEFT_PARENTHESIS or KEYWORD");
        switch (curentToken.getType()) {
            case 1004:
                return SINGLE();
            case 1005:
                advanceTokenPointer();
                return COMPOSITE(curentToken.getValue().toString());
            default:
                throw new IllegalStateException("Unexpected token " + curentToken);
        }
    }

    /* access modifiers changed from: 0000 */
    public FormattingNode SINGLE() {
        SimpleKeywordNode simpleKeywordNode = new SimpleKeywordNode(getNextToken().getValue());
        Token curentToken = getCurentToken();
        if (curentToken != null && curentToken.getType() == 1006) {
            simpleKeywordNode.setOptions((List) curentToken.getValue());
            advanceTokenPointer();
        }
        return simpleKeywordNode;
    }

    /* access modifiers changed from: 0000 */
    public FormattingNode COMPOSITE(String str) {
        CompositeNode compositeNode = new CompositeNode(str);
        compositeNode.setChildNode(mo2525E());
        Token nextToken = getNextToken();
        if (nextToken == null || nextToken.getType() != 41) {
            String str2 = "Expecting RIGHT_PARENTHESIS token but got " + nextToken;
            addError(str2);
            addError("See also http://logback.qos.ch/codes.html#missingRightParenthesis");
            throw new ScanException(str2);
        }
        Token curentToken = getCurentToken();
        if (curentToken != null && curentToken.getType() == 1006) {
            compositeNode.setOptions((List) curentToken.getValue());
            advanceTokenPointer();
        }
        return compositeNode;
    }

    /* access modifiers changed from: 0000 */
    public Token getNextToken() {
        if (this.pointer >= this.tokenList.size()) {
            return null;
        }
        List list = this.tokenList;
        int i = this.pointer;
        this.pointer = i + 1;
        return (Token) list.get(i);
    }

    /* access modifiers changed from: 0000 */
    public Token getCurentToken() {
        if (this.pointer < this.tokenList.size()) {
            return (Token) this.tokenList.get(this.pointer);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void advanceTokenPointer() {
        this.pointer++;
    }

    /* access modifiers changed from: 0000 */
    public void expectNotNull(Token token, String str) {
        if (token == null) {
            throw new IllegalStateException("All tokens consumed but was expecting " + str);
        }
    }
}
