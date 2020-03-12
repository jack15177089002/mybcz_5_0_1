//package com.baicizhan.online.bs_words;
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
//public class BBGetWordAssetInfoArg implements Serializable, Cloneable, Comparable<BBGetWordAssetInfoArg>, C2116f<BBGetWordAssetInfoArg, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBGetWordAssetInfoArg");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    private static final int __BOOK_ID_ISSET_ID = 1;
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int book_id;
//    public int topic_id;
//
//    class BBGetWordAssetInfoArgStandardScheme extends C2110c<BBGetWordAssetInfoArg> {
//        private BBGetWordAssetInfoArgStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBGetWordAssetInfoArg bBGetWordAssetInfoArg) {
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
//                                bBGetWordAssetInfoArg.topic_id = fVar.mo18513n();
//                                bBGetWordAssetInfoArg.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBGetWordAssetInfoArg.book_id = fVar.mo18513n();
//                                bBGetWordAssetInfoArg.setBook_idIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBGetWordAssetInfoArg.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBGetWordAssetInfoArg.isSetBook_id()) {
//                        throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBGetWordAssetInfoArg.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBGetWordAssetInfoArg bBGetWordAssetInfoArg) {
//            bBGetWordAssetInfoArg.validate();
//            BBGetWordAssetInfoArg.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBGetWordAssetInfoArg.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBGetWordAssetInfoArg.topic_id);
//            fVar.mo18496a(BBGetWordAssetInfoArg.BOOK_ID_FIELD_DESC);
//            fVar.mo18493a(bBGetWordAssetInfoArg.book_id);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBGetWordAssetInfoArgStandardSchemeFactory implements C2109b {
//        private BBGetWordAssetInfoArgStandardSchemeFactory() {
//        }
//
//        public BBGetWordAssetInfoArgStandardScheme getScheme() {
//            return new BBGetWordAssetInfoArgStandardScheme();
//        }
//    }
//
//    class BBGetWordAssetInfoArgTupleScheme extends C2111d<BBGetWordAssetInfoArg> {
//        private BBGetWordAssetInfoArgTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBGetWordAssetInfoArg bBGetWordAssetInfoArg) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBGetWordAssetInfoArg.topic_id);
//            lVar.mo18493a(bBGetWordAssetInfoArg.book_id);
//        }
//
//        public void read(C2100f fVar, BBGetWordAssetInfoArg bBGetWordAssetInfoArg) {
//            C2106l lVar = (C2106l) fVar;
//            bBGetWordAssetInfoArg.topic_id = lVar.mo18513n();
//            bBGetWordAssetInfoArg.setTopic_idIsSet(true);
//            bBGetWordAssetInfoArg.book_id = lVar.mo18513n();
//            bBGetWordAssetInfoArg.setBook_idIsSet(true);
//        }
//    }
//
//    class BBGetWordAssetInfoArgTupleSchemeFactory implements C2109b {
//        private BBGetWordAssetInfoArgTupleSchemeFactory() {
//        }
//
//        public BBGetWordAssetInfoArgTupleScheme getScheme() {
//            return new BBGetWordAssetInfoArgTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        BOOK_ID(2, "book_id");
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
//                    return TOPIC_ID;
//                case 2:
//                    return BOOK_ID;
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
//        hashMap.put(C2110c.class, new BBGetWordAssetInfoArgStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBGetWordAssetInfoArgTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBGetWordAssetInfoArg.class, metaDataMap);
//    }
//
//    public BBGetWordAssetInfoArg() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBGetWordAssetInfoArg(int i, int i2) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.book_id = i2;
//        setBook_idIsSet(true);
//    }
//
//    public BBGetWordAssetInfoArg(BBGetWordAssetInfoArg bBGetWordAssetInfoArg) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBGetWordAssetInfoArg.__isset_bitfield;
//        this.topic_id = bBGetWordAssetInfoArg.topic_id;
//        this.book_id = bBGetWordAssetInfoArg.book_id;
//    }
//
//    public BBGetWordAssetInfoArg deepCopy() {
//        return new BBGetWordAssetInfoArg(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        setBook_idIsSet(false);
//        this.book_id = 0;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBGetWordAssetInfoArg setTopic_id(int i) {
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        return this;
//    }
//
//    public void unsetTopic_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetTopic_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setTopic_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public int getBook_id() {
//        return this.book_id;
//    }
//
//    public BBGetWordAssetInfoArg setBook_id(int i) {
//        this.book_id = i;
//        setBook_idIsSet(true);
//        return this;
//    }
//
//    public void unsetBook_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetBook_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setBook_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case TOPIC_ID:
//                if (obj == null) {
//                    unsetTopic_id();
//                    return;
//                } else {
//                    setTopic_id(((Integer) obj).intValue());
//                    return;
//                }
//            case BOOK_ID:
//                if (obj == null) {
//                    unsetBook_id();
//                    return;
//                } else {
//                    setBook_id(((Integer) obj).intValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case TOPIC_ID:
//                return Integer.valueOf(getTopic_id());
//            case BOOK_ID:
//                return Integer.valueOf(getBook_id());
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
//            case TOPIC_ID:
//                return isSetTopic_id();
//            case BOOK_ID:
//                return isSetBook_id();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBGetWordAssetInfoArg)) {
//            return equals((BBGetWordAssetInfoArg) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBGetWordAssetInfoArg bBGetWordAssetInfoArg) {
//        if (bBGetWordAssetInfoArg != null && this.topic_id == bBGetWordAssetInfoArg.topic_id && this.book_id == bBGetWordAssetInfoArg.book_id) {
//            return true;
//        }
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBGetWordAssetInfoArg bBGetWordAssetInfoArg) {
//        if (!getClass().equals(bBGetWordAssetInfoArg.getClass())) {
//            return getClass().getName().compareTo(bBGetWordAssetInfoArg.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBGetWordAssetInfoArg.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBGetWordAssetInfoArg.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(bBGetWordAssetInfoArg.isSetBook_id()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetBook_id()) {
//            int a2 = C2121h.m5522a(this.book_id, bBGetWordAssetInfoArg.book_id);
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
//        StringBuilder sb = new StringBuilder("BBGetWordAssetInfoArg(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("book_id:");
//        sb.append(this.book_id);
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
