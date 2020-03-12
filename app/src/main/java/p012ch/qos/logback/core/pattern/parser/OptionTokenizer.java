package p012ch.qos.logback.core.pattern.parser;

import java.util.ArrayList;
import java.util.List;
import p012ch.qos.logback.core.pattern.util.AsIsEscapeUtil;
import p012ch.qos.logback.core.pattern.util.IEscapeUtil;
import p012ch.qos.logback.core.spi.ScanException;

/* renamed from: ch.qos.logback.core.pattern.parser.OptionTokenizer */
public class OptionTokenizer {
    private static final int EXPECTING_STATE = 0;
    private static final int QUOTED_COLLECTING_STATE = 2;
    private static final int RAW_COLLECTING_STATE = 1;
    final IEscapeUtil escapeUtil;
    final String pattern;
    final int patternLength;
    char quoteChar;
    int state;
    final TokenStream tokenStream;

    OptionTokenizer(TokenStream tokenStream2) {
        this(tokenStream2, new AsIsEscapeUtil());
    }

    OptionTokenizer(TokenStream tokenStream2, IEscapeUtil iEscapeUtil) {
        this.state = 0;
        this.tokenStream = tokenStream2;
        this.pattern = tokenStream2.pattern;
        this.patternLength = tokenStream2.patternLength;
        this.escapeUtil = iEscapeUtil;
    }

    /* access modifiers changed from: 0000 */
    public void tokenize(char c, List<Token> list) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (this.tokenStream.pointer < this.patternLength) {
            switch (this.state) {
                case 0:
                    switch (c) {
                        case 9:
                        case 10:
                        case 13:
                        case ' ':
                        case ',':
                            break;
                        case '\"':
                        case '\'':
                            this.state = 2;
                            this.quoteChar = c;
                            break;
                        case '}':
                            emitOptionToken(list, arrayList);
                            return;
                        default:
                            stringBuffer.append(c);
                            this.state = 1;
                            break;
                    }
                case 1:
                    switch (c) {
                        case ',':
                            arrayList.add(stringBuffer.toString().trim());
                            stringBuffer.setLength(0);
                            this.state = 0;
                            break;
                        case '}':
                            arrayList.add(stringBuffer.toString().trim());
                            emitOptionToken(list, arrayList);
                            return;
                        default:
                            stringBuffer.append(c);
                            break;
                    }
                case 2:
                    if (c != this.quoteChar) {
                        if (c != '\\') {
                            stringBuffer.append(c);
                            break;
                        } else {
                            escape(String.valueOf(this.quoteChar), stringBuffer);
                            break;
                        }
                    } else {
                        arrayList.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        this.state = 0;
                        break;
                    }
            }
            c = this.pattern.charAt(this.tokenStream.pointer);
            this.tokenStream.pointer++;
        }
        if (c != '}') {
            throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
        } else if (this.state == 0) {
            emitOptionToken(list, arrayList);
        } else if (this.state == 1) {
            arrayList.add(stringBuffer.toString().trim());
            emitOptionToken(list, arrayList);
        } else {
            throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
        }
    }

    /* access modifiers changed from: 0000 */
    public void emitOptionToken(List<Token> list, List<String> list2) {
        list.add(new Token(1006, list2));
        this.tokenStream.state = TokenizerState.LITERAL_STATE;
    }

    /* access modifiers changed from: 0000 */
    public void escape(String str, StringBuffer stringBuffer) {
        if (this.tokenStream.pointer < this.patternLength) {
            String str2 = this.pattern;
            TokenStream tokenStream2 = this.tokenStream;
            int i = tokenStream2.pointer;
            tokenStream2.pointer = i + 1;
            this.escapeUtil.escape(str, stringBuffer, str2.charAt(i), this.tokenStream.pointer);
        }
    }
}
