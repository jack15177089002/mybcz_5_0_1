package org.mozilla.javascript;

import java.io.CharArrayWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.dh */
public abstract class RhinoException extends RuntimeException {

    /* renamed from: c */
    static boolean f6486c = false;

    /* renamed from: a */
    private int f6487a;

    /* renamed from: d */
    String f6488d;

    /* renamed from: e */
    int f6489e;

    /* renamed from: f */
    String f6490f;

    /* renamed from: g */
    Object f6491g;

    /* renamed from: h */
    int[] f6492h;

    RhinoException() {
        Evaluator l = Context.m6770l();
        if (l != null) {
            l.mo18690a(this);
        }
    }

    RhinoException(String str) {
        super(str);
        Evaluator l = Context.m6770l();
        if (l != null) {
            l.mo18690a(this);
        }
    }

    public final String getMessage() {
        String a = mo18703a();
        if (this.f6488d == null || this.f6489e <= 0) {
            return a;
        }
        StringBuffer stringBuffer = new StringBuffer(a);
        stringBuffer.append(" (");
        if (this.f6488d != null) {
            stringBuffer.append(this.f6488d);
        }
        if (this.f6489e > 0) {
            stringBuffer.append('#');
            stringBuffer.append(this.f6489e);
        }
        stringBuffer.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public String mo18703a() {
        return super.getMessage();
    }

    /* renamed from: a */
    public final void mo19012a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        } else if (this.f6488d != null) {
            throw new IllegalStateException();
        } else {
            this.f6488d = str;
        }
    }

    /* renamed from: a */
    public final void mo19011a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else if (this.f6489e > 0) {
            throw new IllegalStateException();
        } else {
            this.f6489e = i;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19013a(String str, int i, String str2, int i2) {
        if (i == -1) {
            i = 0;
        }
        if (str != null) {
            mo19012a(str);
        }
        if (i != 0) {
            mo19011a(i);
        }
        if (str2 != null) {
            if (str2 == null) {
                throw new IllegalArgumentException();
            } else if (this.f6490f != null) {
                throw new IllegalStateException();
            } else {
                this.f6490f = str2;
            }
        }
        if (i2 == 0) {
            return;
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException(String.valueOf(i2));
        } else if (this.f6487a > 0) {
            throw new IllegalStateException();
        } else {
            this.f6487a = i2;
        }
    }

    /* renamed from: c */
    private String m6301c() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        super.printStackTrace(new PrintWriter(charArrayWriter));
        String charArrayWriter2 = charArrayWriter.toString();
        Evaluator l = Context.m6770l();
        if (l != null) {
            return l.mo18686a(this, charArrayWriter2);
        }
        return null;
    }

    /* renamed from: b */
    public final ScriptStackElement[] mo19014b() {
        ScriptStackElement[][] dqVarArr;
        int i;
        String str;
        ArrayList arrayList = new ArrayList();
        if (this.f6491g == null || !(Context.m6770l() instanceof Interpreter)) {
            dqVarArr = null;
        } else {
            dqVarArr = Interpreter.m5758b(this);
        }
        StackTraceElement[] stackTrace = getStackTrace();
        Pattern compile = Pattern.compile("_c_(.*)_\\d+");
        int length = stackTrace.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            String fileName = stackTraceElement.getFileName();
            if (stackTraceElement.getMethodName().startsWith("_c_") && stackTraceElement.getLineNumber() >= 0 && fileName != null && !fileName.endsWith(".java")) {
                String methodName = stackTraceElement.getMethodName();
                Matcher matcher = compile.matcher(methodName);
                if ("_c_script_0".equals(methodName) || !matcher.find()) {
                    str = null;
                } else {
                    str = matcher.group(1);
                }
                arrayList.add(new ScriptStackElement(fileName, str, stackTraceElement.getLineNumber()));
                i = i3;
            } else if (!"org.mozilla.javascript.Interpreter".equals(stackTraceElement.getClassName()) || !"interpretLoop".equals(stackTraceElement.getMethodName()) || dqVarArr == null || dqVarArr.length <= i3) {
                i = i3;
            } else {
                i = i3 + 1;
                for (ScriptStackElement add : dqVarArr[i3]) {
                    arrayList.add(add);
                }
            }
            i2++;
            i3 = i;
        }
        return (ScriptStackElement[]) arrayList.toArray(new ScriptStackElement[arrayList.size()]);
    }

    public void printStackTrace(PrintWriter printWriter) {
        if (this.f6491g == null) {
            super.printStackTrace(printWriter);
        } else {
            printWriter.print(m6301c());
        }
    }

    public void printStackTrace(PrintStream printStream) {
        if (this.f6491g == null) {
            super.printStackTrace(printStream);
        } else {
            printStream.print(m6301c());
        }
    }
}
