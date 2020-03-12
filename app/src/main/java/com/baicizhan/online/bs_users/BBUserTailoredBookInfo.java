//package com.baicizhan.online.bs_users;
//
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
//import org.p100a.p101a.C2090b;
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
//public class BBUserTailoredBookInfo implements Serializable, Cloneable, Comparable<BBUserTailoredBookInfo>, C2116f<BBUserTailoredBookInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b LAST_TOUCH_AT_FIELD_DESC = new C2097b("last_touch_at", 10, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserTailoredBookInfo");
//    private static final int __BOOK_ID_ISSET_ID = 0;
//    private static final int __LAST_TOUCH_AT_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int book_id;
//    public long last_touch_at;
//
//    class BBUserTailoredBookInfoStandardScheme extends C2110c<BBUserTailoredBookInfo> {
//        private BBUserTailoredBookInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserTailoredBookInfo bBUserTailoredBookInfo) {
//            fVar.mo18504e();
//            while (true) {
//                C2097b g = fVar.mo18506g();
//                if (g.f5835b != 0) {
//                    switch (g.f5836c) {
//                        case 1:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserTailoredBookInfo.book_id = fVar.mo18513n();
//                                bBUserTailoredBookInfo.setBook_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserTailoredBookInfo.last_touch_at = fVar.mo18514o();
//                                bBUserTailoredBookInfo.setLast_touch_atIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBUserTailoredBookInfo.isSetBook_id()) {
//                        throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserTailoredBookInfo.isSetLast_touch_at()) {
//                        throw new C2101g("Required field 'last_touch_at' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBUserTailoredBookInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserTailoredBookInfo bBUserTailoredBookInfo) {
//            bBUserTailoredBookInfo.validate();
//            BBUserTailoredBookInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBUserTailoredBookInfo.BOOK_ID_FIELD_DESC);
//            fVar.mo18493a(bBUserTailoredBookInfo.book_id);
//            fVar.mo18496a(BBUserTailoredBookInfo.LAST_TOUCH_AT_FIELD_DESC);
//            fVar.mo18494a(bBUserTailoredBookInfo.last_touch_at);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserTailoredBookInfoStandardSchemeFactory implements C2109b {
//        private BBUserTailoredBookInfoStandardSchemeFactory() {
//        }
//
//        public BBUserTailoredBookInfoStandardScheme getScheme() {
//            return new BBUserTailoredBookInfoStandardScheme();
//        }
//    }
//
//    class BBUserTailoredBookInfoTupleScheme extends C2111d<BBUserTailoredBookInfo> {
//        private BBUserTailoredBookInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserTailoredBookInfo bBUserTailoredBookInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBUserTailoredBookInfo.book_id);
//            lVar.mo18494a(bBUserTailoredBookInfo.last_touch_at);
//        }
//
//        public void read(C2100f fVar, BBUserTailoredBookInfo bBUserTailoredBookInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserTailoredBookInfo.book_id = lVar.mo18513n();
//            bBUserTailoredBookInfo.setBook_idIsSet(true);
//            bBUserTailoredBookInfo.last_touch_at = lVar.mo18514o();
//            bBUserTailoredBookInfo.setLast_touch_atIsSet(true);
//        }
//    }
//
//    class BBUserTailoredBookInfoTupleSchemeFactory implements C2109b {
//        private BBUserTailoredBookInfoTupleSchemeFactory() {
//        }
//
//        public BBUserTailoredBookInfoTupleScheme getScheme() {
//            return new BBUserTailoredBookInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        BOOK_ID(1, "book_id"),
//        LAST_TOUCH_AT(2, "last_touch_at");
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
//                    return BOOK_ID;
//                case 2:
//                    return LAST_TOUCH_AT;
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
//        hashMap.put(C2110c.class, new BBUserTailoredBookInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserTailoredBookInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.LAST_TOUCH_AT, new C2091a("last_touch_at", 1, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserTailoredBookInfo.class, metaDataMap);
//    }
//
//    public BBUserTailoredBookInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBUserTailoredBookInfo(int i, long j) {
//        this();
//        this.book_id = i;
//        setBook_idIsSet(true);
//        this.last_touch_at = j;
//        setLast_touch_atIsSet(true);
//    }
//
//    public BBUserTailoredBookInfo(BBUserTailoredBookInfo bBUserTailoredBookInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBUserTailoredBookInfo.__isset_bitfield;
//        this.book_id = bBUserTailoredBookInfo.book_id;
//        this.last_touch_at = bBUserTailoredBookInfo.last_touch_at;
//    }
//
//    public BBUserTailoredBookInfo deepCopy() {
//        return new BBUserTailoredBookInfo(this);
//    }
//
//    public void clear() {
//        setBook_idIsSet(false);
//        this.book_id = 0;
//        setLast_touch_atIsSet(false);
//        this.last_touch_at = 0;
//    }
//
//    public int getBook_id() {
//        return this.book_id;
//    }
//
//    public BBUserTailoredBookInfo setBook_id(int i) {
//        this.book_id = i;
//        setBook_idIsSet(true);
//        return this;
//    }
//
//    public void unsetBook_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetBook_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setBook_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public long getLast_touch_at() {
//        return this.last_touch_at;
//    }
//
//    public BBUserTailoredBookInfo setLast_touch_at(long j) {
//        this.last_touch_at = j;
//        setLast_touch_atIsSet(true);
//        return this;
//    }
//
//    public void unsetLast_touch_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetLast_touch_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setLast_touch_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case BOOK_ID:
//                if (obj == null) {
//                    unsetBook_id();
//                    return;
//                } else {
//                    setBook_id(((Integer) obj).intValue());
//                    return;
//                }
//            case LAST_TOUCH_AT:
//                if (obj == null) {
//                    unsetLast_touch_at();
//                    return;
//                } else {
//                    setLast_touch_at(((Long) obj).longValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case BOOK_ID:
//                return Integer.valueOf(getBook_id());
//            case LAST_TOUCH_AT:
//                return Long.valueOf(getLast_touch_at());
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
//            case BOOK_ID:
//                return isSetBook_id();
//            case LAST_TOUCH_AT:
//                return isSetLast_touch_at();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBUserTailoredBookInfo)) {
//            return equals((BBUserTailoredBookInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserTailoredBookInfo bBUserTailoredBookInfo) {
//        if (bBUserTailoredBookInfo != null && this.book_id == bBUserTailoredBookInfo.book_id && this.last_touch_at == bBUserTailoredBookInfo.last_touch_at) {
//            return true;
//        }
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserTailoredBookInfo bBUserTailoredBookInfo) {
//        if (!getClass().equals(bBUserTailoredBookInfo.getClass())) {
//            return getClass().getName().compareTo(bBUserTailoredBookInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(bBUserTailoredBookInfo.isSetBook_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetBook_id()) {
//            int a = C2121h.m5522a(this.book_id, bBUserTailoredBookInfo.book_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetLast_touch_at()).compareTo(Boolean.valueOf(bBUserTailoredBookInfo.isSetLast_touch_at()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetLast_touch_at()) {
//            int a2 = C2121h.m5523a(this.last_touch_at, bBUserTailoredBookInfo.last_touch_at);
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
//        StringBuilder sb = new StringBuilder("BBUserTailoredBookInfo(");
//        sb.append("book_id:");
//        sb.append(this.book_id);
//        sb.append(", ");
//        sb.append("last_touch_at:");
//        sb.append(this.last_touch_at);
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
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
//            this.__isset_bitfield = 0;
//            read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//        } catch (C2123l e) {
//            throw new IOException(e);
//        }
//    }
//}
