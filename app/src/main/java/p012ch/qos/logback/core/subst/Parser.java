package p012ch.qos.logback.core.subst;

import java.util.List;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.spi.ScanException;
import p012ch.qos.logback.core.subst.Token.Type;

/* renamed from: ch.qos.logback.core.subst.Parser */
public class Parser {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$subst$Token$Type;
    int pointer = 0;
    final List<Token> tokenList;

    static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$subst$Token$Type() {
        int[] iArr = $SWITCH_TABLE$ch$qos$logback$core$subst$Token$Type;
        if (iArr == null) {
            iArr = new int[Type.values().length];
            try {
                iArr[Type.CURLY_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Type.CURLY_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Type.DEFAULT.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Type.LITERAL.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Type.START.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            $SWITCH_TABLE$ch$qos$logback$core$subst$Token$Type = iArr;
        }
        return iArr;
    }

    public Parser(List<Token> list) {
        this.tokenList = list;
    }

    public Node parse() {
        return m2317E();
    }

    /* renamed from: E */
    private Node m2317E() {
        Node T = m2318T();
        if (T == null) {
            return null;
        }
        Node Eopt = Eopt();
        if (Eopt == null) {
            return T;
        }
        T.append(Eopt);
        return T;
    }

    private Node Eopt() {
        if (peekAtCurentToken() == null) {
            return null;
        }
        return m2317E();
    }

    /* renamed from: T */
    private Node m2318T() {
        Token peekAtCurentToken = peekAtCurentToken();
        if (peekAtCurentToken == null) {
            return null;
        }
        switch ($SWITCH_TABLE$ch$qos$logback$core$subst$Token$Type()[peekAtCurentToken.type.ordinal()]) {
            case 1:
                advanceTokenPointer();
                return makeNewLiteralNode(peekAtCurentToken.payload);
            case 2:
                advanceTokenPointer();
                Node V = m2319V();
                expectCurlyRight(peekAtCurentToken());
                advanceTokenPointer();
                return V;
            case 3:
                advanceTokenPointer();
                Node C = m2316C();
                expectCurlyRight(peekAtCurentToken());
                advanceTokenPointer();
                Node makeNewLiteralNode = makeNewLiteralNode(CoreConstants.LEFT_ACCOLADE);
                makeNewLiteralNode.append(C);
                makeNewLiteralNode.append(makeNewLiteralNode(CoreConstants.RIGHT_ACCOLADE));
                return makeNewLiteralNode;
            default:
                return null;
        }
    }

    private Node makeNewLiteralNode(String str) {
        return new Node(Type.LITERAL, str);
    }

    /* renamed from: V */
    private Node m2319V() {
        Node node = new Node(Type.VARIABLE, m2317E());
        if (isDefaultToken(peekAtCurentToken())) {
            advanceTokenPointer();
            node.defaultPart = m2317E();
        }
        return node;
    }

    /* renamed from: C */
    private Node m2316C() {
        Node E = m2317E();
        if (isDefaultToken(peekAtCurentToken())) {
            advanceTokenPointer();
            E.append(makeNewLiteralNode(CoreConstants.DEFAULT_VALUE_SEPARATOR));
            E.append(m2317E());
        }
        return E;
    }

    private boolean isDefaultToken(Token token) {
        return token != null && token.type == Type.DEFAULT;
    }

    /* access modifiers changed from: 0000 */
    public void advanceTokenPointer() {
        this.pointer++;
    }

    /* access modifiers changed from: 0000 */
    public void expectNotNull(Token token, String str) {
        if (token == null) {
            throw new IllegalArgumentException("All tokens consumed but was expecting \"" + str + "\"");
        }
    }

    /* access modifiers changed from: 0000 */
    public void expectCurlyRight(Token token) {
        expectNotNull(token, "}");
        if (token.type != Type.CURLY_RIGHT) {
            throw new ScanException("Expecting }");
        }
    }

    /* access modifiers changed from: 0000 */
    public Token peekAtCurentToken() {
        if (this.pointer < this.tokenList.size()) {
            return (Token) this.tokenList.get(this.pointer);
        }
        return null;
    }
}
