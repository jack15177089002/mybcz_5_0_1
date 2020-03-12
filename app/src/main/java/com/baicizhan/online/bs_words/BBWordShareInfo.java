//package com.baicizhan.online.bs_words;
//
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
//public class BBWordShareInfo implements Serializable, Cloneable, Comparable<BBWordShareInfo>, C2116f<BBWordShareInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b DESC_FIELD_DESC = new C2097b("desc", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordShareInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TITLE_FIELD_DESC = new C2097b("title", JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b URL_FIELD_DESC = new C2097b("url", JceStruct.STRUCT_END, 3);
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public String desc;
//    public String title;
//    public String url;
//
//    class BBWordShareInfoStandardScheme extends C2110c<BBWordShareInfo> {
//        private BBWordShareInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordShareInfo bBWordShareInfo) {
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
//                                bBWordShareInfo.title = fVar.mo18516q();
//                                bBWordShareInfo.setTitleIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordShareInfo.desc = fVar.mo18516q();
//                                bBWordShareInfo.setDescIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordShareInfo.url = fVar.mo18516q();
//                                bBWordShareInfo.setUrlIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBWordShareInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordShareInfo bBWordShareInfo) {
//            bBWordShareInfo.validate();
//            BBWordShareInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBWordShareInfo.title != null) {
//                fVar.mo18496a(BBWordShareInfo.TITLE_FIELD_DESC);
//                fVar.mo18495a(bBWordShareInfo.title);
//            }
//            if (bBWordShareInfo.desc != null) {
//                fVar.mo18496a(BBWordShareInfo.DESC_FIELD_DESC);
//                fVar.mo18495a(bBWordShareInfo.desc);
//            }
//            if (bBWordShareInfo.url != null) {
//                fVar.mo18496a(BBWordShareInfo.URL_FIELD_DESC);
//                fVar.mo18495a(bBWordShareInfo.url);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordShareInfoStandardSchemeFactory implements C2109b {
//        private BBWordShareInfoStandardSchemeFactory() {
//        }
//
//        public BBWordShareInfoStandardScheme getScheme() {
//            return new BBWordShareInfoStandardScheme();
//        }
//    }
//
//    class BBWordShareInfoTupleScheme extends C2111d<BBWordShareInfo> {
//        private BBWordShareInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordShareInfo bBWordShareInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBWordShareInfo.title);
//            lVar.mo18495a(bBWordShareInfo.desc);
//            lVar.mo18495a(bBWordShareInfo.url);
//        }
//
//        public void read(C2100f fVar, BBWordShareInfo bBWordShareInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBWordShareInfo.title = lVar.mo18516q();
//            bBWordShareInfo.setTitleIsSet(true);
//            bBWordShareInfo.desc = lVar.mo18516q();
//            bBWordShareInfo.setDescIsSet(true);
//            bBWordShareInfo.url = lVar.mo18516q();
//            bBWordShareInfo.setUrlIsSet(true);
//        }
//    }
//
//    class BBWordShareInfoTupleSchemeFactory implements C2109b {
//        private BBWordShareInfoTupleSchemeFactory() {
//        }
//
//        public BBWordShareInfoTupleScheme getScheme() {
//            return new BBWordShareInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TITLE(1, "title"),
//        DESC(2, "desc"),
//        URL(3, "url");
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
//                    return TITLE;
//                case 2:
//                    return DESC;
//                case 3:
//                    return URL;
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
//        hashMap.put(C2110c.class, new BBWordShareInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordShareInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TITLE, new C2091a("title", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.DESC, new C2091a("desc", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.URL, new C2091a("url", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordShareInfo.class, metaDataMap);
//    }
//
//    public BBWordShareInfo() {
//    }
//
//    public BBWordShareInfo(String str, String str2, String str3) {
//        this();
//        this.title = str;
//        this.desc = str2;
//        this.url = str3;
//    }
//
//    public BBWordShareInfo(BBWordShareInfo bBWordShareInfo) {
//        if (bBWordShareInfo.isSetTitle()) {
//            this.title = bBWordShareInfo.title;
//        }
//        if (bBWordShareInfo.isSetDesc()) {
//            this.desc = bBWordShareInfo.desc;
//        }
//        if (bBWordShareInfo.isSetUrl()) {
//            this.url = bBWordShareInfo.url;
//        }
//    }
//
//    public BBWordShareInfo deepCopy() {
//        return new BBWordShareInfo(this);
//    }
//
//    public void clear() {
//        this.title = null;
//        this.desc = null;
//        this.url = null;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public BBWordShareInfo setTitle(String str) {
//        this.title = str;
//        return this;
//    }
//
//    public void unsetTitle() {
//        this.title = null;
//    }
//
//    public boolean isSetTitle() {
//        return this.title != null;
//    }
//
//    public void setTitleIsSet(boolean z) {
//        if (!z) {
//            this.title = null;
//        }
//    }
//
//    public String getDesc() {
//        return this.desc;
//    }
//
//    public BBWordShareInfo setDesc(String str) {
//        this.desc = str;
//        return this;
//    }
//
//    public void unsetDesc() {
//        this.desc = null;
//    }
//
//    public boolean isSetDesc() {
//        return this.desc != null;
//    }
//
//    public void setDescIsSet(boolean z) {
//        if (!z) {
//            this.desc = null;
//        }
//    }
//
//    public String getUrl() {
//        return this.url;
//    }
//
//    public BBWordShareInfo setUrl(String str) {
//        this.url = str;
//        return this;
//    }
//
//    public void unsetUrl() {
//        this.url = null;
//    }
//
//    public boolean isSetUrl() {
//        return this.url != null;
//    }
//
//    public void setUrlIsSet(boolean z) {
//        if (!z) {
//            this.url = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case TITLE:
//                if (obj == null) {
//                    unsetTitle();
//                    return;
//                } else {
//                    setTitle((String) obj);
//                    return;
//                }
//            case DESC:
//                if (obj == null) {
//                    unsetDesc();
//                    return;
//                } else {
//                    setDesc((String) obj);
//                    return;
//                }
//            case URL:
//                if (obj == null) {
//                    unsetUrl();
//                    return;
//                } else {
//                    setUrl((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case TITLE:
//                return getTitle();
//            case DESC:
//                return getDesc();
//            case URL:
//                return getUrl();
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
//            case TITLE:
//                return isSetTitle();
//            case DESC:
//                return isSetDesc();
//            case URL:
//                return isSetUrl();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordShareInfo)) {
//            return equals((BBWordShareInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordShareInfo bBWordShareInfo) {
//        if (bBWordShareInfo == null) {
//            return false;
//        }
//        boolean isSetTitle = isSetTitle();
//        boolean isSetTitle2 = bBWordShareInfo.isSetTitle();
//        if ((isSetTitle || isSetTitle2) && (!isSetTitle || !isSetTitle2 || !this.title.equals(bBWordShareInfo.title))) {
//            return false;
//        }
//        boolean isSetDesc = isSetDesc();
//        boolean isSetDesc2 = bBWordShareInfo.isSetDesc();
//        if ((isSetDesc || isSetDesc2) && (!isSetDesc || !isSetDesc2 || !this.desc.equals(bBWordShareInfo.desc))) {
//            return false;
//        }
//        boolean isSetUrl = isSetUrl();
//        boolean isSetUrl2 = bBWordShareInfo.isSetUrl();
//        if ((isSetUrl || isSetUrl2) && (!isSetUrl || !isSetUrl2 || !this.url.equals(bBWordShareInfo.url))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordShareInfo bBWordShareInfo) {
//        if (!getClass().equals(bBWordShareInfo.getClass())) {
//            return getClass().getName().compareTo(bBWordShareInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTitle()).compareTo(Boolean.valueOf(bBWordShareInfo.isSetTitle()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTitle()) {
//            int a = C2121h.m5525a(this.title, bBWordShareInfo.title);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetDesc()).compareTo(Boolean.valueOf(bBWordShareInfo.isSetDesc()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetDesc()) {
//            int a2 = C2121h.m5525a(this.desc, bBWordShareInfo.desc);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetUrl()).compareTo(Boolean.valueOf(bBWordShareInfo.isSetUrl()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetUrl()) {
//            int a3 = C2121h.m5525a(this.url, bBWordShareInfo.url);
//            if (a3 != 0) {
//                return a3;
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
//        StringBuilder sb = new StringBuilder("BBWordShareInfo(");
//        sb.append("title:");
//        if (this.title == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.title);
//        }
//        sb.append(", ");
//        sb.append("desc:");
//        if (this.desc == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.desc);
//        }
//        sb.append(", ");
//        sb.append("url:");
//        if (this.url == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.url);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.title == null) {
//            throw new C2101g("Required field 'title' was not present! Struct: " + toString());
//        } else if (this.desc == null) {
//            throw new C2101g("Required field 'desc' was not present! Struct: " + toString());
//        } else if (this.url == null) {
//            throw new C2101g("Required field 'url' was not present! Struct: " + toString());
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
