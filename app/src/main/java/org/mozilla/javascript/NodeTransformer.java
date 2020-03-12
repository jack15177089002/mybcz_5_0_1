package org.mozilla.javascript;

import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.p110b.AstRoot;
import org.mozilla.javascript.p110b.FunctionNode;
import org.mozilla.javascript.p110b.Name;
import org.mozilla.javascript.p110b.Scope;
import org.mozilla.javascript.p110b.ScriptNode;

/* renamed from: org.mozilla.javascript.cp */
public class NodeTransformer {

    /* renamed from: a */
    private ObjArray f6404a;

    /* renamed from: b */
    private ObjArray f6405b;

    /* renamed from: c */
    private boolean f6406c;

    /* renamed from: a */
    public final void mo18956a(ScriptNode auVar) {
        boolean z;
        this.f6404a = new ObjArray();
        this.f6405b = new ObjArray();
        this.f6406c = false;
        if (auVar.f6389a != 109 || ((FunctionNode) auVar).f6261r) {
            z = true;
        } else {
            z = false;
        }
        auVar.mo18758a(!z);
        m6155a(auVar, auVar, auVar, z, (auVar instanceof AstRoot) && ((AstRoot) auVar).f6213g);
        for (int i = 0; i != auVar.mo18726o(); i++) {
            mo18956a(auVar.mo18764k(i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x023a A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x019e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6155a(ScriptNode r10, Node r11, Scope r12, boolean r13, boolean r14) {
        /*
            r9 = this;
            r0 = 0
        L_0x0001:
            r5 = 0
            if (r0 != 0) goto L_0x005e
            org.mozilla.javascript.cm r1 = r11.mo18930b()
        L_0x0008:
            if (r1 == 0) goto L_0x0385
            int r2 = r1.f6389a
            if (r13 == 0) goto L_0x0395
            r0 = 129(0x81, float:1.81E-43)
            if (r2 == r0) goto L_0x001a
            r0 = 132(0x84, float:1.85E-43)
            if (r2 == r0) goto L_0x001a
            r0 = 157(0x9d, float:2.2E-43)
            if (r2 != r0) goto L_0x0395
        L_0x001a:
            boolean r0 = r1 instanceof org.mozilla.javascript.p110b.Scope
            if (r0 == 0) goto L_0x0395
            r0 = r1
            org.mozilla.javascript.b.at r0 = (org.mozilla.javascript.p110b.Scope) r0
            java.util.Map r3 = r0.mo18754z()
            if (r3 == 0) goto L_0x0395
            org.mozilla.javascript.cm r3 = new org.mozilla.javascript.cm
            r4 = 157(0x9d, float:2.2E-43)
            if (r2 != r4) goto L_0x0064
            r2 = 158(0x9e, float:2.21E-43)
        L_0x002f:
            r3.<init>(r2)
            org.mozilla.javascript.cm r4 = new org.mozilla.javascript.cm
            r2 = 153(0x99, float:2.14E-43)
            r4.<init>(r2)
            r3.mo18935b(r4)
            java.util.Map r2 = r0.mo18754z()
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r6 = r2.iterator()
        L_0x0048:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0067
            java.lang.Object r2 = r6.next()
            java.lang.String r2 = (java.lang.String) r2
            r7 = 39
            org.mozilla.javascript.cm r2 = org.mozilla.javascript.Node.m6111a(r7, r2)
            r4.mo18935b(r2)
            goto L_0x0048
        L_0x005e:
            org.mozilla.javascript.cm r1 = r0.mo18942d()
            r5 = r0
            goto L_0x0008
        L_0x0064:
            r2 = 153(0x99, float:2.14E-43)
            goto L_0x002f
        L_0x0067:
            r0.mo18746A()
            org.mozilla.javascript.cm r2 = m6156b(r11, r5, r1, r3)
            int r0 = r2.f6389a
            r3.mo18935b(r1)
            r6 = r0
            r1 = r2
        L_0x0075:
            switch(r6) {
                case 3: goto L_0x00cc;
                case 4: goto L_0x0101;
                case 7: goto L_0x02a5;
                case 8: goto L_0x0304;
                case 30: goto L_0x0213;
                case 31: goto L_0x030b;
                case 32: goto L_0x02a5;
                case 38: goto L_0x020d;
                case 39: goto L_0x030b;
                case 72: goto L_0x00eb;
                case 81: goto L_0x00b4;
                case 114: goto L_0x008b;
                case 120: goto L_0x019e;
                case 121: goto L_0x019e;
                case 122: goto L_0x023a;
                case 123: goto L_0x009c;
                case 130: goto L_0x008b;
                case 131: goto L_0x00cc;
                case 132: goto L_0x008b;
                case 137: goto L_0x0294;
                case 153: goto L_0x0219;
                case 154: goto L_0x023a;
                case 155: goto L_0x030b;
                case 158: goto L_0x0219;
                default: goto L_0x0078;
            }
        L_0x0078:
            r2 = r1
        L_0x0079:
            boolean r0 = r2 instanceof org.mozilla.javascript.p110b.Scope
            if (r0 == 0) goto L_0x0382
            r0 = r2
            org.mozilla.javascript.b.at r0 = (org.mozilla.javascript.p110b.Scope) r0
            r3 = r0
        L_0x0081:
            r0 = r9
            r1 = r10
            r4 = r13
            r5 = r14
            r0.m6155a(r1, r2, r3, r4, r5)
            r0 = r2
            goto L_0x0001
        L_0x008b:
            org.mozilla.javascript.cq r0 = r9.f6404a
            r0.mo18961a(r1)
            org.mozilla.javascript.cq r2 = r9.f6405b
            r0 = r1
            org.mozilla.javascript.b.ae r0 = (org.mozilla.javascript.p110b.Jump) r0
            org.mozilla.javascript.cm r0 = r0.f6117w
            r2.mo18961a(r0)
            r2 = r1
            goto L_0x0079
        L_0x009c:
            org.mozilla.javascript.cq r0 = r9.f6404a
            r0.mo18961a(r1)
            org.mozilla.javascript.cm r0 = r1.mo18942d()
            int r2 = r0.f6389a
            r3 = 3
            if (r2 == r3) goto L_0x00ad
            org.mozilla.javascript.Kit.m5810a()
        L_0x00ad:
            org.mozilla.javascript.cq r2 = r9.f6405b
            r2.mo18961a(r0)
            r2 = r1
            goto L_0x0079
        L_0x00b4:
            r0 = r1
            org.mozilla.javascript.b.ae r0 = (org.mozilla.javascript.p110b.Jump) r0
            org.mozilla.javascript.cm r0 = r0.mo18729x()
            if (r0 == 0) goto L_0x0078
            r2 = 1
            r9.f6406c = r2
            org.mozilla.javascript.cq r2 = r9.f6404a
            r2.mo18961a(r1)
            org.mozilla.javascript.cq r2 = r9.f6405b
            r2.mo18961a(r0)
            r2 = r1
            goto L_0x0079
        L_0x00cc:
            org.mozilla.javascript.cq r0 = r9.f6405b
            int r0 = r0.f6407a
            if (r0 != 0) goto L_0x00e9
            r0 = 1
        L_0x00d3:
            if (r0 != 0) goto L_0x0078
            org.mozilla.javascript.cq r0 = r9.f6405b
            java.lang.Object r0 = r0.mo18959a()
            if (r0 != r1) goto L_0x0078
            org.mozilla.javascript.cq r0 = r9.f6405b
            r0.mo18963b()
            org.mozilla.javascript.cq r0 = r9.f6404a
            r0.mo18963b()
            r2 = r1
            goto L_0x0079
        L_0x00e9:
            r0 = 0
            goto L_0x00d3
        L_0x00eb:
            r0 = r10
            org.mozilla.javascript.b.x r0 = (org.mozilla.javascript.p110b.FunctionNode) r0
            java.util.List<org.mozilla.javascript.cm> r2 = r0.f6263t
            if (r2 != 0) goto L_0x00f9
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r0.f6263t = r2
        L_0x00f9:
            java.util.List<org.mozilla.javascript.cm> r0 = r0.f6263t
            r0.add(r1)
            r2 = r1
            goto L_0x0079
        L_0x0101:
            int r0 = r10.f6389a
            r2 = 109(0x6d, float:1.53E-43)
            if (r0 != r2) goto L_0x0160
            r0 = r10
            org.mozilla.javascript.b.x r0 = (org.mozilla.javascript.p110b.FunctionNode) r0
            boolean r0 = r0.f6262s
            if (r0 == 0) goto L_0x0160
            r0 = 1
            r6 = r0
        L_0x0110:
            if (r6 == 0) goto L_0x0118
            r0 = 20
            r2 = 1
            r1.mo18933b(r0, r2)
        L_0x0118:
            boolean r0 = r9.f6406c
            if (r0 == 0) goto L_0x0078
            r3 = 0
            org.mozilla.javascript.cq r0 = r9.f6404a
            int r0 = r0.f6407a
            int r0 = r0 + -1
            r4 = r0
        L_0x0124:
            if (r4 < 0) goto L_0x016b
            org.mozilla.javascript.cq r0 = r9.f6404a
            java.lang.Object r0 = r0.mo18960a(r4)
            org.mozilla.javascript.cm r0 = (org.mozilla.javascript.Node) r0
            int r2 = r0.f6389a
            r7 = 81
            if (r2 == r7) goto L_0x0138
            r7 = 123(0x7b, float:1.72E-43)
            if (r2 != r7) goto L_0x015c
        L_0x0138:
            r7 = 81
            if (r2 != r7) goto L_0x0163
            org.mozilla.javascript.b.ae r2 = new org.mozilla.javascript.b.ae
            r7 = 135(0x87, float:1.89E-43)
            r2.<init>(r7)
            org.mozilla.javascript.b.ae r0 = (org.mozilla.javascript.p110b.Jump) r0
            org.mozilla.javascript.cm r0 = r0.mo18729x()
            r2.f6117w = r0
        L_0x014b:
            if (r3 != 0) goto L_0x0392
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            r3 = 129(0x81, float:1.81E-43)
            int r7 = r1.mo18794f()
            r0.<init>(r3, r7)
        L_0x0158:
            r0.mo18935b(r2)
            r3 = r0
        L_0x015c:
            int r0 = r4 + -1
            r4 = r0
            goto L_0x0124
        L_0x0160:
            r0 = 0
            r6 = r0
            goto L_0x0110
        L_0x0163:
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            r2 = 3
            r0.<init>(r2)
            r2 = r0
            goto L_0x014b
        L_0x016b:
            if (r3 == 0) goto L_0x0078
            org.mozilla.javascript.cm r0 = r1.mo18930b()
            org.mozilla.javascript.cm r7 = m6156b(r11, r5, r1, r3)
            if (r0 == 0) goto L_0x0179
            if (r6 == 0) goto L_0x017f
        L_0x0179:
            r3.mo18935b(r1)
            r0 = r7
            goto L_0x0001
        L_0x017f:
            org.mozilla.javascript.cm r2 = new org.mozilla.javascript.cm
            r1 = 134(0x86, float:1.88E-43)
            r2.<init>(r1, r0)
            r3.mo18927a(r2)
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            r1 = 64
            r0.<init>(r1)
            r3.mo18935b(r0)
            r0 = r9
            r1 = r10
            r3 = r12
            r4 = r13
            r5 = r14
            r0.m6155a(r1, r2, r3, r4, r5)
            r0 = r7
            goto L_0x0001
        L_0x019e:
            r0 = r1
            org.mozilla.javascript.b.ae r0 = (org.mozilla.javascript.p110b.Jump) r0
            org.mozilla.javascript.b.ae r7 = r0.mo18728w()
            if (r7 != 0) goto L_0x01aa
            org.mozilla.javascript.Kit.m5810a()
        L_0x01aa:
            org.mozilla.javascript.cq r2 = r9.f6404a
            int r2 = r2.f6407a
            r3 = r5
        L_0x01af:
            if (r2 != 0) goto L_0x01b6
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.m5810a()
            throw r0
        L_0x01b6:
            int r4 = r2 + -1
            org.mozilla.javascript.cq r2 = r9.f6404a
            java.lang.Object r2 = r2.mo18960a(r4)
            org.mozilla.javascript.cm r2 = (org.mozilla.javascript.Node) r2
            if (r2 == r7) goto L_0x01ee
            int r5 = r2.f6389a
            r8 = 123(0x7b, float:1.72E-43)
            if (r5 != r8) goto L_0x01d4
            org.mozilla.javascript.cm r2 = new org.mozilla.javascript.cm
            r5 = 3
            r2.<init>(r5)
            org.mozilla.javascript.cm r3 = m6153a(r11, r3, r1, r2)
            r2 = r4
            goto L_0x01af
        L_0x01d4:
            r8 = 81
            if (r5 != r8) goto L_0x038f
            org.mozilla.javascript.b.ae r2 = (org.mozilla.javascript.p110b.Jump) r2
            org.mozilla.javascript.b.ae r5 = new org.mozilla.javascript.b.ae
            r8 = 135(0x87, float:1.89E-43)
            r5.<init>(r8)
            org.mozilla.javascript.cm r2 = r2.mo18729x()
            r5.f6117w = r2
            org.mozilla.javascript.cm r2 = m6153a(r11, r3, r1, r5)
        L_0x01eb:
            r3 = r2
            r2 = r4
            goto L_0x01af
        L_0x01ee:
            r2 = 120(0x78, float:1.68E-43)
            if (r6 != r2) goto L_0x01fd
            org.mozilla.javascript.cm r2 = r7.f6117w
            r0.f6117w = r2
        L_0x01f6:
            r2 = 5
            r0.mo18730a(r2)
            r2 = r1
            goto L_0x0079
        L_0x01fd:
            int r2 = r7.f6389a
            r3 = 132(0x84, float:1.85E-43)
            if (r2 == r3) goto L_0x0208
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.m5810a()
            throw r0
        L_0x0208:
            org.mozilla.javascript.cm r2 = r7.f6118x
            r0.f6117w = r2
            goto L_0x01f6
        L_0x020d:
            r9.mo18958b(r1, r10)
            r2 = r1
            goto L_0x0079
        L_0x0213:
            r9.mo18957a(r1, r10)
            r2 = r1
            goto L_0x0079
        L_0x0219:
            org.mozilla.javascript.cm r0 = r1.mo18930b()
            int r0 = r0.f6389a
            r2 = 153(0x99, float:2.14E-43)
            if (r0 != r2) goto L_0x023a
            int r0 = r10.f6389a
            r2 = 109(0x6d, float:1.53E-43)
            if (r0 != r2) goto L_0x0230
            r0 = r10
            org.mozilla.javascript.b.x r0 = (org.mozilla.javascript.p110b.FunctionNode) r0
            boolean r0 = r0.f6261r
            if (r0 == 0) goto L_0x0238
        L_0x0230:
            r0 = 1
        L_0x0231:
            org.mozilla.javascript.cm r1 = m6154a(r0, r11, r5, r1)
            r2 = r1
            goto L_0x0079
        L_0x0238:
            r0 = 0
            goto L_0x0231
        L_0x023a:
            org.mozilla.javascript.cm r7 = new org.mozilla.javascript.cm
            r0 = 129(0x81, float:1.81E-43)
            r7.<init>(r0)
            org.mozilla.javascript.cm r3 = r1.mo18930b()
        L_0x0245:
            if (r3 == 0) goto L_0x028d
            org.mozilla.javascript.cm r4 = r3.mo18942d()
            int r0 = r3.f6389a
            r2 = 39
            if (r0 != r2) goto L_0x0282
            boolean r0 = r3.mo18929a()
            if (r0 == 0) goto L_0x038c
            org.mozilla.javascript.cm r8 = r3.mo18930b()
            r3.mo18947e(r8)
            r0 = 49
            r3.mo18730a(r0)
            org.mozilla.javascript.cm r2 = new org.mozilla.javascript.cm
            r0 = 154(0x9a, float:2.16E-43)
            if (r6 != r0) goto L_0x027f
            r0 = 155(0x9b, float:2.17E-43)
        L_0x026b:
            r2.<init>(r0, r3, r8)
            r0 = r2
        L_0x026f:
            org.mozilla.javascript.cm r2 = new org.mozilla.javascript.cm
            r3 = 133(0x85, float:1.86E-43)
            int r8 = r1.mo18794f()
            r2.<init>(r3, r0, r8)
            r7.mo18935b(r2)
            r3 = r4
            goto L_0x0245
        L_0x027f:
            r0 = 8
            goto L_0x026b
        L_0x0282:
            int r0 = r3.f6389a
            r2 = 158(0x9e, float:2.21E-43)
            if (r0 == r2) goto L_0x0389
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.m5810a()
            throw r0
        L_0x028d:
            org.mozilla.javascript.cm r1 = m6156b(r11, r5, r1, r7)
            r2 = r1
            goto L_0x0079
        L_0x0294:
            r0 = r1
            org.mozilla.javascript.b.ak r0 = (org.mozilla.javascript.p110b.Name) r0
            java.lang.String r0 = r0.f6130g
            org.mozilla.javascript.b.at r0 = r12.mo18749c(r0)
            if (r0 == 0) goto L_0x02a2
            r1.mo18738a(r0)
        L_0x02a2:
            r2 = r1
            goto L_0x0079
        L_0x02a5:
            org.mozilla.javascript.cm r0 = r1.mo18930b()
            r2 = 7
            if (r6 != r2) goto L_0x0386
            r4 = r0
        L_0x02ad:
            int r0 = r4.f6389a
            r2 = 26
            if (r0 != r2) goto L_0x02b9
            org.mozilla.javascript.cm r0 = r4.mo18930b()
            r4 = r0
            goto L_0x02ad
        L_0x02b9:
            int r0 = r4.f6389a
            r2 = 12
            if (r0 == r2) goto L_0x02c5
            int r0 = r4.f6389a
            r2 = 13
            if (r0 != r2) goto L_0x02e1
        L_0x02c5:
            org.mozilla.javascript.cm r2 = r4.mo18930b()
            org.mozilla.javascript.cm r3 = r4.mo18938c()
            int r0 = r2.f6389a
            r5 = 39
            if (r0 != r5) goto L_0x02ef
            r0 = r2
            org.mozilla.javascript.b.ak r0 = (org.mozilla.javascript.p110b.Name) r0
            java.lang.String r0 = r0.f6130g
            java.lang.String r5 = "undefined"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x02ef
            r4 = r3
        L_0x02e1:
            int r0 = r4.f6389a
            r2 = 33
            if (r0 != r2) goto L_0x0078
            r0 = 34
            r4.mo18730a(r0)
            r2 = r1
            goto L_0x0079
        L_0x02ef:
            int r0 = r3.f6389a
            r5 = 39
            if (r0 != r5) goto L_0x02e1
            r0 = r3
            org.mozilla.javascript.b.ak r0 = (org.mozilla.javascript.p110b.Name) r0
            java.lang.String r0 = r0.f6130g
            java.lang.String r3 = "undefined"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x02e1
            r4 = r2
            goto L_0x02e1
        L_0x0304:
            if (r14 == 0) goto L_0x030b
            r0 = 73
            r1.mo18730a(r0)
        L_0x030b:
            if (r13 != 0) goto L_0x0078
            r0 = 39
            if (r6 != r0) goto L_0x0332
            r2 = r1
        L_0x0312:
            org.mozilla.javascript.b.at r0 = r2.mo18740g()
            if (r0 != 0) goto L_0x0078
            r0 = r2
            org.mozilla.javascript.b.ak r0 = (org.mozilla.javascript.p110b.Name) r0
            java.lang.String r0 = r0.f6130g
            org.mozilla.javascript.b.at r0 = r12.mo18749c(r0)
            if (r0 == 0) goto L_0x0078
            r2.mo18738a(r0)
            r0 = 39
            if (r6 != r0) goto L_0x0345
            r0 = 55
            r1.mo18730a(r0)
            r2 = r1
            goto L_0x0079
        L_0x0332:
            org.mozilla.javascript.cm r2 = r1.mo18930b()
            int r0 = r2.f6389a
            r3 = 49
            if (r0 == r3) goto L_0x0312
            r0 = 31
            if (r6 == r0) goto L_0x0078
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.m5810a()
            throw r0
        L_0x0345:
            r0 = 8
            if (r6 == r0) goto L_0x034d
            r0 = 73
            if (r6 != r0) goto L_0x035a
        L_0x034d:
            r0 = 56
            r1.mo18730a(r0)
            r0 = 41
            r2.mo18730a(r0)
            r2 = r1
            goto L_0x0079
        L_0x035a:
            r0 = 155(0x9b, float:2.17E-43)
            if (r6 != r0) goto L_0x036b
            r0 = 156(0x9c, float:2.19E-43)
            r1.mo18730a(r0)
            r0 = 41
            r2.mo18730a(r0)
            r2 = r1
            goto L_0x0079
        L_0x036b:
            r0 = 31
            if (r6 != r0) goto L_0x037d
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            r2 = 44
            r0.<init>(r2)
            org.mozilla.javascript.cm r1 = m6156b(r11, r5, r1, r0)
            r2 = r1
            goto L_0x0079
        L_0x037d:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.m5810a()
            throw r0
        L_0x0382:
            r3 = r12
            goto L_0x0081
        L_0x0385:
            return
        L_0x0386:
            r4 = r0
            goto L_0x02e1
        L_0x0389:
            r0 = r3
            goto L_0x026f
        L_0x038c:
            r3 = r4
            goto L_0x0245
        L_0x038f:
            r2 = r3
            goto L_0x01eb
        L_0x0392:
            r0 = r3
            goto L_0x0158
        L_0x0395:
            r6 = r2
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NodeTransformer.m6155a(org.mozilla.javascript.b.au, org.mozilla.javascript.cm, org.mozilla.javascript.b.at, boolean, boolean):void");
    }

    /* renamed from: a */
    public void mo18957a(Node cmVar, ScriptNode auVar) {
    }

    /* renamed from: b */
    public void mo18958b(Node cmVar, ScriptNode auVar) {
    }

    /* renamed from: a */
    private static Node m6154a(boolean z, Node cmVar, Node cmVar2, Node cmVar3) {
        Node cmVar4;
        Node cmVar5;
        Node cmVar6;
        Node cmVar7;
        Node b = cmVar3.mo18930b();
        Node d = b.mo18942d();
        cmVar3.mo18947e(b);
        cmVar3.mo18947e(d);
        boolean z2 = cmVar3.f6389a == 158;
        if (z) {
            Node b2 = m6156b(cmVar, cmVar2, cmVar3, new Node(z2 ? 159 : 129));
            ArrayList arrayList = new ArrayList();
            Node cmVar8 = new Node(66);
            Node b3 = b.mo18930b();
            Node cmVar9 = d;
            Node cmVar10 = b3;
            while (cmVar10 != null) {
                if (cmVar10.f6389a == 158) {
                    List list = (List) cmVar10.mo18937c(22);
                    Node b4 = cmVar10.mo18930b();
                    if (b4.f6389a != 153) {
                        throw Kit.m5810a();
                    }
                    if (z2) {
                        cmVar6 = new Node(89, b4.mo18942d(), cmVar9);
                    } else {
                        cmVar6 = new Node(129, new Node(133, b4.mo18942d()), cmVar9);
                    }
                    if (list != null) {
                        arrayList.addAll(list);
                        for (int i = 0; i < list.size(); i++) {
                            cmVar8.mo18935b(new Node(126, Node.m6110a(0.0d)));
                        }
                    }
                    cmVar7 = b4.mo18930b();
                } else {
                    cmVar6 = cmVar9;
                    cmVar7 = cmVar10;
                }
                if (cmVar7.f6389a != 39) {
                    throw Kit.m5810a();
                }
                arrayList.add(ScriptRuntime.m6435d(((Name) cmVar7).f6130g));
                Node b5 = cmVar7.mo18930b();
                if (b5 == null) {
                    b5 = new Node(126, Node.m6110a(0.0d));
                }
                cmVar8.mo18935b(b5);
                cmVar10 = cmVar10.mo18942d();
                cmVar9 = cmVar6;
            }
            cmVar8.mo18925a(12, (Object) arrayList.toArray());
            b2.mo18935b(new Node(2, cmVar8));
            b2.mo18935b(new Node(123, cmVar9));
            b2.mo18935b(new Node(3));
            return b2;
        }
        Node b6 = m6156b(cmVar, cmVar2, cmVar3, new Node(z2 ? 89 : 129));
        Node cmVar11 = new Node(89);
        Node b7 = b.mo18930b();
        while (b7 != null) {
            if (b7.f6389a == 158) {
                Node b8 = b7.mo18930b();
                if (b8.f6389a != 153) {
                    throw Kit.m5810a();
                }
                if (z2) {
                    cmVar4 = new Node(89, b8.mo18942d(), d);
                } else {
                    cmVar4 = new Node(129, new Node(133, b8.mo18942d()), d);
                }
                Scope.m5858a((Scope) b7, (Scope) cmVar3);
                cmVar5 = b8.mo18930b();
            } else {
                cmVar4 = d;
                cmVar5 = b7;
            }
            if (cmVar5.f6389a != 39) {
                throw Kit.m5810a();
            }
            Node a = Node.m6112a(((Name) cmVar5).f6130g);
            a.mo18738a((Scope) cmVar3);
            Node b9 = cmVar5.mo18930b();
            if (b9 == null) {
                b9 = new Node(126, Node.m6110a(0.0d));
            }
            cmVar11.mo18935b(new Node(56, a, b9));
            b7 = b7.mo18942d();
            d = cmVar4;
        }
        if (z2) {
            b6.mo18935b(cmVar11);
            cmVar3.mo18730a(89);
            b6.mo18935b(cmVar3);
            cmVar3.mo18935b(d);
            if (d instanceof Scope) {
                Scope y = ((Scope) d).mo18753y();
                ((Scope) d).mo18748b((Scope) cmVar3);
                ((Scope) cmVar3).mo18748b(y);
                return b6;
            }
        } else {
            b6.mo18935b(new Node(133, cmVar11));
            cmVar3.mo18730a(129);
            b6.mo18935b(cmVar3);
            cmVar3.mo18943d(d);
            if (d instanceof Scope) {
                Scope y2 = ((Scope) d).mo18753y();
                ((Scope) d).mo18748b((Scope) cmVar3);
                ((Scope) cmVar3).mo18748b(y2);
            }
        }
        return b6;
    }

    /* renamed from: a */
    private static Node m6153a(Node cmVar, Node cmVar2, Node cmVar3, Node cmVar4) {
        if (cmVar2 == null) {
            if (cmVar3 != cmVar.mo18930b()) {
                Kit.m5810a();
            }
            cmVar.mo18927a(cmVar4);
        } else {
            if (cmVar3 != cmVar2.mo18942d()) {
                Kit.m5810a();
            }
            cmVar.mo18936b(cmVar4, cmVar2);
        }
        return cmVar4;
    }

    /* renamed from: b */
    private static Node m6156b(Node cmVar, Node cmVar2, Node cmVar3, Node cmVar4) {
        if (cmVar2 == null) {
            if (cmVar3 != cmVar.mo18930b()) {
                Kit.m5810a();
            }
            cmVar.mo18940c(cmVar3, cmVar4);
        } else if (cmVar2.f6390b == cmVar3) {
            cmVar.mo18944d(cmVar2, cmVar4);
        } else {
            cmVar.mo18940c(cmVar3, cmVar4);
        }
        return cmVar4;
    }
}
