//package com.baicizhan.online.bs_users;
//
//import com.p052e.p053a.p054a.JceStruct;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.io.Serializable;
//import java.util.BitSet;
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
//import org.p100a.p101a.p103b.C2095e;
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
//public class BBSelectedBookInfo implements Serializable, Cloneable, Comparable<BBSelectedBookInfo>, C2116f<BBSelectedBookInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b BOOK_INFO_FIELD_DESC = new C2097b("book_info", JceStruct.ZERO_TAG, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b NEED_MERGE_COUNT_FIELD_DESC = new C2097b("need_merge_count", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBSelectedBookInfo");
//    private static final int __NEED_MERGE_COUNT_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public BBUserSelectedBookInfo book_info;
//    public int need_merge_count;
//    private _Fields[] optionals;
//
//    class BBSelectedBookInfoStandardScheme extends C2110c<BBSelectedBookInfo> {
//        private BBSelectedBookInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBSelectedBookInfo bBSelectedBookInfo) {
//            fVar.mo18504e();
//            while (true) {
//                C2097b g = fVar.mo18506g();
//                if (g.f5835b != 0) {
//                    switch (g.f5836c) {
//                        case 1:
//                            if (g.f5835b != 12) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSelectedBookInfo.book_info = new BBUserSelectedBookInfo();
//                                bBSelectedBookInfo.book_info.read(fVar);
//                                bBSelectedBookInfo.setBook_infoIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSelectedBookInfo.need_merge_count = fVar.mo18513n();
//                                bBSelectedBookInfo.setNeed_merge_countIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBSelectedBookInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBSelectedBookInfo bBSelectedBookInfo) {
//            bBSelectedBookInfo.validate();
//            BBSelectedBookInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBSelectedBookInfo.book_info != null) {
//                fVar.mo18496a(BBSelectedBookInfo.BOOK_INFO_FIELD_DESC);
//                bBSelectedBookInfo.book_info.write(fVar);
//            }
//            if (bBSelectedBookInfo.isSetNeed_merge_count()) {
//                fVar.mo18496a(BBSelectedBookInfo.NEED_MERGE_COUNT_FIELD_DESC);
//                fVar.mo18493a(bBSelectedBookInfo.need_merge_count);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBSelectedBookInfoStandardSchemeFactory implements C2109b {
//        private BBSelectedBookInfoStandardSchemeFactory() {
//        }
//
//        public BBSelectedBookInfoStandardScheme getScheme() {
//            return new BBSelectedBookInfoStandardScheme();
//        }
//    }
//
//    class BBSelectedBookInfoTupleScheme extends C2111d<BBSelectedBookInfo> {
//        private BBSelectedBookInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBSelectedBookInfo bBSelectedBookInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBSelectedBookInfo.book_info.write(lVar);
//            BitSet bitSet = new BitSet();
//            if (bBSelectedBookInfo.isSetNeed_merge_count()) {
//                bitSet.set(0);
//            }
//            lVar.mo18527a(bitSet, 1);
//            if (bBSelectedBookInfo.isSetNeed_merge_count()) {
//                lVar.mo18493a(bBSelectedBookInfo.need_merge_count);
//            }
//        }
//
//        public void read(C2100f fVar, BBSelectedBookInfo bBSelectedBookInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBSelectedBookInfo.book_info = new BBUserSelectedBookInfo();
//            bBSelectedBookInfo.book_info.read(lVar);
//            bBSelectedBookInfo.setBook_infoIsSet(true);
//            if (lVar.mo18528b(1).get(0)) {
//                bBSelectedBookInfo.need_merge_count = lVar.mo18513n();
//                bBSelectedBookInfo.setNeed_merge_countIsSet(true);
//            }
//        }
//    }
//
//    class BBSelectedBookInfoTupleSchemeFactory implements C2109b {
//        private BBSelectedBookInfoTupleSchemeFactory() {
//        }
//
//        public BBSelectedBookInfoTupleScheme getScheme() {
//            return new BBSelectedBookInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        BOOK_INFO(1, "book_info"),
//        NEED_MERGE_COUNT(2, "need_merge_count");
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
//                    return BOOK_INFO;
//                case 2:
//                    return NEED_MERGE_COUNT;
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
//        hashMap.put(C2110c.class, new BBSelectedBookInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBSelectedBookInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.BOOK_INFO, new C2091a("book_info", 1, new C2095e(BBUserSelectedBookInfo.class)));
//        enumMap.put(_Fields.NEED_MERGE_COUNT, new C2091a("need_merge_count", 2, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBSelectedBookInfo.class, metaDataMap);
//    }
//
//    public BBSelectedBookInfo() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.NEED_MERGE_COUNT};
//    }
//
//    public BBSelectedBookInfo(BBUserSelectedBookInfo bBUserSelectedBookInfo) {
//        this();
//        this.book_info = bBUserSelectedBookInfo;
//    }
//
//    public BBSelectedBookInfo(BBSelectedBookInfo bBSelectedBookInfo) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.NEED_MERGE_COUNT};
//        this.__isset_bitfield = bBSelectedBookInfo.__isset_bitfield;
//        if (bBSelectedBookInfo.isSetBook_info()) {
//            this.book_info = new BBUserSelectedBookInfo(bBSelectedBookInfo.book_info);
//        }
//        this.need_merge_count = bBSelectedBookInfo.need_merge_count;
//    }
//
//    public BBSelectedBookInfo deepCopy() {
//        return new BBSelectedBookInfo(this);
//    }
//
//    public void clear() {
//        this.book_info = null;
//        setNeed_merge_countIsSet(false);
//        this.need_merge_count = 0;
//    }
//
//    public BBUserSelectedBookInfo getBook_info() {
//        return this.book_info;
//    }
//
//    public BBSelectedBookInfo setBook_info(BBUserSelectedBookInfo bBUserSelectedBookInfo) {
//        this.book_info = bBUserSelectedBookInfo;
//        return this;
//    }
//
//    public void unsetBook_info() {
//        this.book_info = null;
//    }
//
//    public boolean isSetBook_info() {
//        return this.book_info != null;
//    }
//
//    public void setBook_infoIsSet(boolean z) {
//        if (!z) {
//            this.book_info = null;
//        }
//    }
//
//    public int getNeed_merge_count() {
//        return this.need_merge_count;
//    }
//
//    public BBSelectedBookInfo setNeed_merge_count(int i) {
//        this.need_merge_count = i;
//        setNeed_merge_countIsSet(true);
//        return this;
//    }
//
//    public void unsetNeed_merge_count() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetNeed_merge_count() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setNeed_merge_countIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case BOOK_INFO:
//                if (obj == null) {
//                    unsetBook_info();
//                    return;
//                } else {
//                    setBook_info((BBUserSelectedBookInfo) obj);
//                    return;
//                }
//            case NEED_MERGE_COUNT:
//                if (obj == null) {
//                    unsetNeed_merge_count();
//                    return;
//                } else {
//                    setNeed_merge_count(((Integer) obj).intValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case BOOK_INFO:
//                return getBook_info();
//            case NEED_MERGE_COUNT:
//                return Integer.valueOf(getNeed_merge_count());
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
//            case BOOK_INFO:
//                return isSetBook_info();
//            case NEED_MERGE_COUNT:
//                return isSetNeed_merge_count();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBSelectedBookInfo)) {
//            return equals((BBSelectedBookInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBSelectedBookInfo bBSelectedBookInfo) {
//        if (bBSelectedBookInfo == null) {
//            return false;
//        }
//        boolean isSetBook_info = isSetBook_info();
//        boolean isSetBook_info2 = bBSelectedBookInfo.isSetBook_info();
//        if ((isSetBook_info || isSetBook_info2) && (!isSetBook_info || !isSetBook_info2 || !this.book_info.equals(bBSelectedBookInfo.book_info))) {
//            return false;
//        }
//        boolean isSetNeed_merge_count = isSetNeed_merge_count();
//        boolean isSetNeed_merge_count2 = bBSelectedBookInfo.isSetNeed_merge_count();
//        if ((isSetNeed_merge_count || isSetNeed_merge_count2) && (!isSetNeed_merge_count || !isSetNeed_merge_count2 || this.need_merge_count != bBSelectedBookInfo.need_merge_count)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBSelectedBookInfo bBSelectedBookInfo) {
//        if (!getClass().equals(bBSelectedBookInfo.getClass())) {
//            return getClass().getName().compareTo(bBSelectedBookInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetBook_info()).compareTo(Boolean.valueOf(bBSelectedBookInfo.isSetBook_info()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetBook_info()) {
//            int a = C2121h.m5524a((Comparable) this.book_info, (Comparable) bBSelectedBookInfo.book_info);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetNeed_merge_count()).compareTo(Boolean.valueOf(bBSelectedBookInfo.isSetNeed_merge_count()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetNeed_merge_count()) {
//            int a2 = C2121h.m5522a(this.need_merge_count, bBSelectedBookInfo.need_merge_count);
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
//        StringBuilder sb = new StringBuilder("BBSelectedBookInfo(");
//        sb.append("book_info:");
//        if (this.book_info == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.book_info);
//        }
//        if (isSetNeed_merge_count()) {
//            sb.append(", ");
//            sb.append("need_merge_count:");
//            sb.append(this.need_merge_count);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.book_info == null) {
//            throw new C2101g("Required field 'book_info' was not present! Struct: " + toString());
//        } else if (this.book_info != null) {
//            this.book_info.validate();
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
//            this.__isset_bitfield = 0;
//            read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//        } catch (C2123l e) {
//            throw new IOException(e);
//        }
//    }
//}
