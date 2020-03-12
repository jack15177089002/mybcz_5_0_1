//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.wordtesting.doc.DocDBHelper;
//import com.p052e.p053a.p054a.JceStruct;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.io.Serializable;
//import java.util.Collections;
//import java.util.EnumMap;
//import java.util.EnumSet;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import org.p100a.p101a.C2116f;
//import org.p100a.p101a.C2121h;
//import org.p100a.p101a.C2123l;
//import org.p100a.p101a.C2124m;
//import org.p100a.p101a.p103b.C2091a;
//import org.p100a.p101a.p103b.C2092b;
//import org.p100a.p101a.p104c.C2096a;
//import org.p100a.p101a.p104c.C2097b;
//import org.p100a.p101a.p104c.C2100f;
//import org.p100a.p101a.p104c.C2101g;
//import org.p100a.p101a.p104c.C2103i;
//import org.p100a.p101a.p104c.C2105k;
//import org.p100a.p101a.p104c.C2106l;
//import org.p100a.p101a.p105d.C2108a;
//import org.p100a.p101a.p105d.C2109b;
//import org.p100a.p101a.p105d.C2110c;
//import org.p100a.p101a.p105d.C2111d;
//import org.p100a.p101a.p107f.C2117b;
//
//public class BBAdCustomMenu implements Serializable, Cloneable, Comparable<BBAdCustomMenu>, C2116f<BBAdCustomMenu, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b COLOR_FIELD_DESC = new C2097b("color", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBAdCustomMenu");
//    /* access modifiers changed from: private */
//    public static final C2097b TEXT_FIELD_DESC = new C2097b(DocDBHelper.COL_TEXT, JceStruct.STRUCT_END, 1);
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public String color;
//    public String text;
//
//    class BBAdCustomMenuStandardScheme extends C2110c<BBAdCustomMenu> {
//        private BBAdCustomMenuStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBAdCustomMenu bBAdCustomMenu) {
//            fVar.mo18504e();
//            while (true) {
//                C2097b g = fVar.mo18506g();
//                if (g.f5835b != 0) {
//                    switch (g.f5836c) {
//                        case 1:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdCustomMenu.text = fVar.mo18516q();
//                                bBAdCustomMenu.setTextIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdCustomMenu.color = fVar.mo18516q();
//                                bBAdCustomMenu.setColorIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBAdCustomMenu.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBAdCustomMenu bBAdCustomMenu) {
//            bBAdCustomMenu.validate();
//            BBAdCustomMenu.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBAdCustomMenu.text != null) {
//                fVar.mo18496a(BBAdCustomMenu.TEXT_FIELD_DESC);
//                fVar.mo18495a(bBAdCustomMenu.text);
//            }
//            if (bBAdCustomMenu.color != null) {
//                fVar.mo18496a(BBAdCustomMenu.COLOR_FIELD_DESC);
//                fVar.mo18495a(bBAdCustomMenu.color);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBAdCustomMenuStandardSchemeFactory implements C2109b {
//        private BBAdCustomMenuStandardSchemeFactory() {
//        }
//
//        public BBAdCustomMenuStandardScheme getScheme() {
//            return new BBAdCustomMenuStandardScheme();
//        }
//    }
//
//    class BBAdCustomMenuTupleScheme extends C2111d<BBAdCustomMenu> {
//        private BBAdCustomMenuTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBAdCustomMenu bBAdCustomMenu) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBAdCustomMenu.text);
//            lVar.mo18495a(bBAdCustomMenu.color);
//        }
//
//        public void read(C2100f fVar, BBAdCustomMenu bBAdCustomMenu) {
//            C2106l lVar = (C2106l) fVar;
//            bBAdCustomMenu.text = lVar.mo18516q();
//            bBAdCustomMenu.setTextIsSet(true);
//            bBAdCustomMenu.color = lVar.mo18516q();
//            bBAdCustomMenu.setColorIsSet(true);
//        }
//    }
//
//    class BBAdCustomMenuTupleSchemeFactory implements C2109b {
//        private BBAdCustomMenuTupleSchemeFactory() {
//        }
//
//        public BBAdCustomMenuTupleScheme getScheme() {
//            return new BBAdCustomMenuTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TEXT(1, DocDBHelper.COL_TEXT),
//        COLOR(2, "color");
//
//        private static final Map<String, _Fields> byName = null;
//        private final String _fieldName;
//        private final short _thriftId;
//
//        static {
//            byName = new HashMap();
//            Iterator it = EnumSet.allOf(_Fields.class).iterator();
//            while (it.hasNext()) {
//                _Fields _fields = (_Fields) it.next();
//                byName.put(_fields.getFieldName(), _fields);
//            }
//        }
//
//        public static _Fields findByThriftId(int i) {
//            switch (i) {
//                case 1:
//                    return TEXT;
//                case 2:
//                    return COLOR;
//                default:
//                    return null;
//            }
//        }
//
//        public static _Fields findByThriftIdOrThrow(int i) {
//            _Fields findByThriftId = findByThriftId(i);
//            if (findByThriftId != null) {
//                return findByThriftId;
//            }
//            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
//        }
//
//        public static _Fields findByName(String str) {
//            return (_Fields) byName.get(str);
//        }
//
//        private _Fields(short s, String str) {
//            this._thriftId = s;
//            this._fieldName = str;
//        }
//
//        public final short getThriftFieldId() {
//            return this._thriftId;
//        }
//
//        public final String getFieldName() {
//            return this._fieldName;
//        }
//    }
//
//    static {
//        HashMap hashMap = new HashMap();
//        schemes = hashMap;
//        hashMap.put(C2110c.class, new BBAdCustomMenuStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBAdCustomMenuTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TEXT, new C2091a(DocDBHelper.COL_TEXT, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.COLOR, new C2091a("color", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBAdCustomMenu.class, metaDataMap);
//    }
//
//    public BBAdCustomMenu() {
//    }
//
//    public BBAdCustomMenu(String str, String str2) {
//        this();
//        this.text = str;
//        this.color = str2;
//    }
//
//    public BBAdCustomMenu(BBAdCustomMenu bBAdCustomMenu) {
//        if (bBAdCustomMenu.isSetText()) {
//            this.text = bBAdCustomMenu.text;
//        }
//        if (bBAdCustomMenu.isSetColor()) {
//            this.color = bBAdCustomMenu.color;
//        }
//    }
//
//    public BBAdCustomMenu deepCopy() {
//        return new BBAdCustomMenu(this);
//    }
//
//    public void clear() {
//        this.text = null;
//        this.color = null;
//    }
//
//    public String getText() {
//        return this.text;
//    }
//
//    public BBAdCustomMenu setText(String str) {
//        this.text = str;
//        return this;
//    }
//
//    public void unsetText() {
//        this.text = null;
//    }
//
//    public boolean isSetText() {
//        return this.text != null;
//    }
//
//    public void setTextIsSet(boolean z) {
//        if (!z) {
//            this.text = null;
//        }
//    }
//
//    public String getColor() {
//        return this.color;
//    }
//
//    public BBAdCustomMenu setColor(String str) {
//        this.color = str;
//        return this;
//    }
//
//    public void unsetColor() {
//        this.color = null;
//    }
//
//    public boolean isSetColor() {
//        return this.color != null;
//    }
//
//    public void setColorIsSet(boolean z) {
//        if (!z) {
//            this.color = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case TEXT:
//                if (obj == null) {
//                    unsetText();
//                    return;
//                } else {
//                    setText((String) obj);
//                    return;
//                }
//            case COLOR:
//                if (obj == null) {
//                    unsetColor();
//                    return;
//                } else {
//                    setColor((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case TEXT:
//                return getText();
//            case COLOR:
//                return getColor();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean isSet(_Fields _fields) {
//        if (_fields == null) {
//            throw new IllegalArgumentException();
//        }
//        switch (_fields) {
//            case TEXT:
//                return isSetText();
//            case COLOR:
//                return isSetColor();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBAdCustomMenu)) {
//            return equals((BBAdCustomMenu) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBAdCustomMenu bBAdCustomMenu) {
//        if (bBAdCustomMenu == null) {
//            return false;
//        }
//        boolean isSetText = isSetText();
//        boolean isSetText2 = bBAdCustomMenu.isSetText();
//        if ((isSetText || isSetText2) && (!isSetText || !isSetText2 || !this.text.equals(bBAdCustomMenu.text))) {
//            return false;
//        }
//        boolean isSetColor = isSetColor();
//        boolean isSetColor2 = bBAdCustomMenu.isSetColor();
//        if ((isSetColor || isSetColor2) && (!isSetColor || !isSetColor2 || !this.color.equals(bBAdCustomMenu.color))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBAdCustomMenu bBAdCustomMenu) {
//        if (!getClass().equals(bBAdCustomMenu.getClass())) {
//            return getClass().getName().compareTo(bBAdCustomMenu.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetText()).compareTo(Boolean.valueOf(bBAdCustomMenu.isSetText()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetText()) {
//            int a = C2121h.m5525a(this.text, bBAdCustomMenu.text);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetColor()).compareTo(Boolean.valueOf(bBAdCustomMenu.isSetColor()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetColor()) {
//            int a2 = C2121h.m5525a(this.color, bBAdCustomMenu.color);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        return 0;
//    }
//
//    public _Fields fieldForId(int i) {
//        return _Fields.findByThriftId(i);
//    }
//
//    public void read(C2100f fVar) {
//        ((C2109b) schemes.get(fVar.mo18525t())).getScheme().read(fVar, this);
//    }
//
//    public void write(C2100f fVar) {
//        ((C2109b) schemes.get(fVar.mo18525t())).getScheme().write(fVar, this);
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("BBAdCustomMenu(");
//        sb.append("text:");
//        if (this.text == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.text);
//        }
//        sb.append(", ");
//        sb.append("color:");
//        if (this.color == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.color);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.text == null) {
//            throw new C2101g("Required field 'text' was not present! Struct: " + toString());
//        } else if (this.color == null) {
//            throw new C2101g("Required field 'color' was not present! Struct: " + toString());
//        }
//    }
//
//    private void writeObject(ObjectOutputStream objectOutputStream) {
//        try {
//            write(new C2096a(new C2117b((OutputStream) objectOutputStream), 0));
//        } catch (C2123l e) {
//            throw new IOException(e);
//        }
//    }
//
//    private void readObject(ObjectInputStream objectInputStream) {
//        try {
//            read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//        } catch (C2123l e) {
//            throw new IOException(e);
//        }
//    }
//}
