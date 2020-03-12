package p012ch.qos.logback.core.subst;

import java.util.ArrayList;
import java.util.List;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.spi.ScanException;
import p012ch.qos.logback.core.subst.Token.Type;

/* renamed from: ch.qos.logback.core.subst.Tokenizer */
public class Tokenizer {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$subst$Tokenizer$TokenizerState;
    final String pattern;
    final int patternLength;
    int pointer = 0;
    TokenizerState state = TokenizerState.LITERAL_STATE;

    /* renamed from: ch.qos.logback.core.subst.Tokenizer$TokenizerState */
    enum TokenizerState {
        LITERAL_STATE,
        START_STATE,
        DEFAULT_VAL_STATE
    }

    static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$subst$Tokenizer$TokenizerState() {
        int[] iArr = $SWITCH_TABLE$ch$qos$logback$core$subst$Tokenizer$TokenizerState;
        if (iArr == null) {
            iArr = new int[TokenizerState.values().length];
            try {
                iArr[TokenizerState.DEFAULT_VAL_STATE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TokenizerState.LITERAL_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TokenizerState.START_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$ch$qos$logback$core$subst$Tokenizer$TokenizerState = iArr;
        }
        return iArr;
    }

    public Tokenizer(String str) {
        this.pattern = str;
        this.patternLength = str.length();
    }

    /* access modifiers changed from: 0000 */
    public List<Token> tokenize() {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        while (this.pointer < this.patternLength) {
            char charAt = this.pattern.charAt(this.pointer);
            this.pointer++;
            switch ($SWITCH_TABLE$ch$qos$logback$core$subst$Tokenizer$TokenizerState()[this.state.ordinal()]) {
                case 1:
                    handleLiteralState(charAt, arrayList, sb);
                    break;
                case 2:
                    handleStartState(charAt, arrayList, sb);
                    break;
                case 3:
                    handleDefaultValueState(charAt, arrayList, sb);
                    break;
            }
        }
        switch ($SWITCH_TABLE$ch$qos$logback$core$subst$Tokenizer$TokenizerState()[this.state.ordinal()]) {
            case 1:
                addLiteralToken(arrayList, sb);
                break;
            case 2:
                throw new ScanException("Unexpected end of pattern string");
        }
        return arrayList;
    }

    private void handleDefaultValueState(char c, List<Token> list, StringBuilder sb) {
        switch (c) {
            case '$':
                sb.append(CoreConstants.COLON_CHAR);
                addLiteralToken(list, sb);
                sb.setLength(0);
                this.state = TokenizerState.START_STATE;
                return;
            case '-':
                list.add(Token.DEFAULT_SEP_TOKEN);
                this.state = TokenizerState.LITERAL_STATE;
                return;
            default:
                sb.append(CoreConstants.COLON_CHAR).append(c);
                this.state = TokenizerState.LITERAL_STATE;
                return;
        }
    }

    private void handleStartState(char c, List<Token> list, StringBuilder sb) {
        if (c == '{') {
            list.add(Token.START_TOKEN);
        } else {
            sb.append(CoreConstants.DOLLAR).append(c);
        }
        this.state = TokenizerState.LITERAL_STATE;
    }

    private void handleLiteralState(char c, List<Token> list, StringBuilder sb) {
        if (c == '$') {
            addLiteralToken(list, sb);
            sb.setLength(0);
            this.state = TokenizerState.START_STATE;
        } else if (c == ':') {
            addLiteralToken(list, sb);
            sb.setLength(0);
            this.state = TokenizerState.DEFAULT_VAL_STATE;
        } else if (c == '{') {
            addLiteralToken(list, sb);
            list.add(Token.CURLY_LEFT_TOKEN);
            sb.setLength(0);
        } else if (c == '}') {
            addLiteralToken(list, sb);
            list.add(Token.CURLY_RIGHT_TOKEN);
            sb.setLength(0);
        } else {
            sb.append(c);
        }
    }

    private void addLiteralToken(List<Token> list, StringBuilder sb) {
        if (sb.length() != 0) {
            list.add(new Token(Type.LITERAL, sb.toString()));
        }
    }
}
