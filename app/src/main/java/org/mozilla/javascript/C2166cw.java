package org.mozilla.javascript;

import java.util.List;
import java.util.Map;
import org.mozilla.javascript.p110b.FunctionNode;
import org.mozilla.javascript.p110b.Jump;
import org.mozilla.javascript.p110b.LabeledStatement;
import org.mozilla.javascript.p110b.Loop;
import org.mozilla.javascript.p110b.Scope;
import org.mozilla.javascript.p110b.ScriptNode;

/* renamed from: org.mozilla.javascript.cw */
/* compiled from: Parser */
public final class C2166cw {

    /* renamed from: a */
    final /* synthetic */ Parser f6456a;

    /* renamed from: b */
    private ScriptNode f6457b;

    /* renamed from: c */
    private Scope f6458c;

    /* renamed from: d */
    private int f6459d;

    /* renamed from: e */
    private boolean f6460e;

    /* renamed from: f */
    private Map<String, LabeledStatement> f6461f;

    /* renamed from: g */
    private List<Loop> f6462g;

    /* renamed from: h */
    private List<Jump> f6463h;

    C2166cw(Parser ctVar, FunctionNode xVar) {
        this.f6456a = ctVar;
        this.f6457b = ctVar.f6431e;
        ctVar.f6431e = xVar;
        this.f6458c = ctVar.f6432f;
        ctVar.f6432f = xVar;
        this.f6461f = ctVar.f6435i;
        this.f6462g = ctVar.f6436j;
        ctVar.f6436j = null;
        this.f6463h = ctVar.f6437k;
        ctVar.f6437k = null;
        this.f6459d = ctVar.f6433g;
        ctVar.f6433g = 0;
        this.f6460e = ctVar.f6434h;
        ctVar.f6434h = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18989a() {
        this.f6456a.f6431e = this.f6457b;
        this.f6456a.f6432f = this.f6458c;
        this.f6456a.f6435i = this.f6461f;
        this.f6456a.f6436j = this.f6462g;
        this.f6456a.f6437k = this.f6463h;
        this.f6456a.f6433g = this.f6459d;
        this.f6456a.f6434h = this.f6460e;
    }
}
