package p012ch.qos.logback.core.pattern.parser;

import com.baicizhan.client.p029fm.service.proxy.FmPlayState;
import java.util.ArrayList;
import java.util.List;
import p012ch.qos.logback.core.pattern.util.IEscapeUtil;
import p012ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import p012ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;
import p012ch.qos.logback.core.spi.ScanException;

/* renamed from: ch.qos.logback.core.pattern.parser.TokenStream */
class TokenStream {

    /* renamed from: $SWITCH_TABLE$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState */
    private static /* synthetic */ int[] f1665x9c28f9bb;
    final IEscapeUtil escapeUtil;
    final IEscapeUtil optionEscapeUtil;
    final String pattern;
    final int patternLength;
    int pointer;
    TokenizerState state;

    /* renamed from: ch.qos.logback.core.pattern.parser.TokenStream$TokenizerState */
    enum TokenizerState {
        LITERAL_STATE,
        FORMAT_MODIFIER_STATE,
        KEYWORD_STATE,
        OPTION_STATE,
        RIGHT_PARENTHESIS_STATE
    }

    /* renamed from: $SWITCH_TABLE$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState */
    static /* synthetic */ int[] m2315x9c28f9bb() {
        int[] iArr = f1665x9c28f9bb;
        if (iArr == null) {
            iArr = new int[TokenizerState.values().length];
            try {
                iArr[TokenizerState.FORMAT_MODIFIER_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TokenizerState.KEYWORD_STATE.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TokenizerState.LITERAL_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TokenizerState.OPTION_STATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[TokenizerState.RIGHT_PARENTHESIS_STATE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            f1665x9c28f9bb = iArr;
        }
        return iArr;
    }

    TokenStream(String str) {
        this(str, new RegularEscapeUtil());
    }

    TokenStream(String str, IEscapeUtil iEscapeUtil) {
        this.optionEscapeUtil = new RestrictedEscapeUtil();
        this.state = TokenizerState.LITERAL_STATE;
        this.pointer = 0;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("null or empty pattern string not allowed");
        }
        this.pattern = str;
        this.patternLength = str.length();
        this.escapeUtil = iEscapeUtil;
    }

    /* access modifiers changed from: 0000 */
    public List tokenize() {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (this.pointer < this.patternLength) {
            char charAt = this.pattern.charAt(this.pointer);
            this.pointer++;
            switch (m2315x9c28f9bb()[this.state.ordinal()]) {
                case 1:
                    handleLiteralState(charAt, arrayList, stringBuffer);
                    break;
                case 2:
                    handleFormatModifierState(charAt, arrayList, stringBuffer);
                    break;
                case 3:
                    handleKeywordState(charAt, arrayList, stringBuffer);
                    break;
                case 4:
                    processOption(charAt, arrayList, stringBuffer);
                    break;
                case 5:
                    handleRightParenthesisState(charAt, arrayList, stringBuffer);
                    break;
            }
        }
        switch (m2315x9c28f9bb()[this.state.ordinal()]) {
            case 1:
                addValuedToken(1000, stringBuffer, arrayList);
                break;
            case 2:
            case 4:
                throw new ScanException("Unexpected end of pattern string");
            case 3:
                arrayList.add(new Token(1004, stringBuffer.toString()));
                break;
            case 5:
                arrayList.add(Token.RIGHT_PARENTHESIS_TOKEN);
                break;
        }
        return arrayList;
    }

    private void handleRightParenthesisState(char c, List<Token> list, StringBuffer stringBuffer) {
        list.add(Token.RIGHT_PARENTHESIS_TOKEN);
        switch (c) {
            case ')':
                return;
            case '\\':
                escape("%{}", stringBuffer);
                this.state = TokenizerState.LITERAL_STATE;
                return;
            case '{':
                this.state = TokenizerState.OPTION_STATE;
                return;
            default:
                stringBuffer.append(c);
                this.state = TokenizerState.LITERAL_STATE;
                return;
        }
    }

    private void processOption(char c, List<Token> list, StringBuffer stringBuffer) {
        new OptionTokenizer(this).tokenize(c, list);
    }

    private void handleFormatModifierState(char c, List<Token> list, StringBuffer stringBuffer) {
        if (c == '(') {
            addValuedToken(FmPlayState.TYPE_MID_FM, stringBuffer, list);
            list.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
            this.state = TokenizerState.LITERAL_STATE;
        } else if (Character.isJavaIdentifierStart(c)) {
            addValuedToken(FmPlayState.TYPE_MID_FM, stringBuffer, list);
            this.state = TokenizerState.KEYWORD_STATE;
            stringBuffer.append(c);
        } else {
            stringBuffer.append(c);
        }
    }

    private void handleLiteralState(char c, List<Token> list, StringBuffer stringBuffer) {
        switch (c) {
            case '%':
                addValuedToken(1000, stringBuffer, list);
                list.add(Token.PERCENT_TOKEN);
                this.state = TokenizerState.FORMAT_MODIFIER_STATE;
                return;
            case ')':
                addValuedToken(1000, stringBuffer, list);
                this.state = TokenizerState.RIGHT_PARENTHESIS_STATE;
                return;
            case '\\':
                escape("%()", stringBuffer);
                return;
            default:
                stringBuffer.append(c);
                return;
        }
    }

    private void handleKeywordState(char c, List<Token> list, StringBuffer stringBuffer) {
        if (Character.isJavaIdentifierPart(c)) {
            stringBuffer.append(c);
        } else if (c == '{') {
            addValuedToken(1004, stringBuffer, list);
            this.state = TokenizerState.OPTION_STATE;
        } else {
            if (c == '(') {
                addValuedToken(1005, stringBuffer, list);
            } else if (c == '%') {
                addValuedToken(1004, stringBuffer, list);
                list.add(Token.PERCENT_TOKEN);
                this.state = TokenizerState.FORMAT_MODIFIER_STATE;
                return;
            } else if (c == ')') {
                addValuedToken(1004, stringBuffer, list);
                this.state = TokenizerState.RIGHT_PARENTHESIS_STATE;
                return;
            } else {
                addValuedToken(1004, stringBuffer, list);
                if (c != '\\') {
                    stringBuffer.append(c);
                } else if (this.pointer < this.patternLength) {
                    String str = this.pattern;
                    int i = this.pointer;
                    this.pointer = i + 1;
                    this.escapeUtil.escape("%()", stringBuffer, str.charAt(i), this.pointer);
                }
            }
            this.state = TokenizerState.LITERAL_STATE;
        }
    }

    /* access modifiers changed from: 0000 */
    public void escape(String str, StringBuffer stringBuffer) {
        if (this.pointer < this.patternLength) {
            String str2 = this.pattern;
            int i = this.pointer;
            this.pointer = i + 1;
            this.escapeUtil.escape(str, stringBuffer, str2.charAt(i), this.pointer);
        }
    }

    /* access modifiers changed from: 0000 */
    public void optionEscape(String str, StringBuffer stringBuffer) {
        if (this.pointer < this.patternLength) {
            String str2 = this.pattern;
            int i = this.pointer;
            this.pointer = i + 1;
            this.optionEscapeUtil.escape(str, stringBuffer, str2.charAt(i), this.pointer);
        }
    }

    private void addValuedToken(int i, StringBuffer stringBuffer, List<Token> list) {
        if (stringBuffer.length() > 0) {
            list.add(new Token(i, stringBuffer.toString()));
            stringBuffer.setLength(0);
        }
    }
}
