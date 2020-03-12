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
//public class BBUserFinishPlanInfo implements Serializable, Cloneable, Comparable<BBUserFinishPlanInfo>, C2116f<BBUserFinishPlanInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_BOOK_FINISHED_FIELD_DESC = new C2097b("is_book_finished", 2, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b NEW_WORDS_COUNT_FIELD_DESC = new C2097b("new_words_count", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserFinishPlanInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TOTAL_WORDS_COUNT_FIELD_DESC = new C2097b("total_words_count", 8, 2);
//    private static final int __BOOK_ID_ISSET_ID = 0;
//    private static final int __IS_BOOK_FINISHED_ISSET_ID = 3;
//    private static final int __NEW_WORDS_COUNT_ISSET_ID = 2;
//    private static final int __TOTAL_WORDS_COUNT_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int book_id;
//    public boolean is_book_finished;
//    public int new_words_count;
//    public int total_words_count;
//
//    class BBUserFinishPlanInfoStandardScheme extends C2110c<BBUserFinishPlanInfo> {
//        private BBUserFinishPlanInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserFinishPlanInfo bBUserFinishPlanInfo) {
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
//                                bBUserFinishPlanInfo.book_id = fVar.mo18513n();
//                                bBUserFinishPlanInfo.setBook_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserFinishPlanInfo.total_words_count = fVar.mo18513n();
//                                bBUserFinishPlanInfo.setTotal_words_countIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserFinishPlanInfo.new_words_count = fVar.mo18513n();
//                                bBUserFinishPlanInfo.setNew_words_countIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 2) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserFinishPlanInfo.is_book_finished = fVar.mo18510k();
//                                bBUserFinishPlanInfo.setIs_book_finishedIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBUserFinishPlanInfo.isSetBook_id()) {
//                        throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserFinishPlanInfo.isSetTotal_words_count()) {
//                        throw new C2101g("Required field 'total_words_count' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserFinishPlanInfo.isSetNew_words_count()) {
//                        throw new C2101g("Required field 'new_words_count' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserFinishPlanInfo.isSetIs_book_finished()) {
//                        throw new C2101g("Required field 'is_book_finished' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBUserFinishPlanInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserFinishPlanInfo bBUserFinishPlanInfo) {
//            bBUserFinishPlanInfo.validate();
//            BBUserFinishPlanInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBUserFinishPlanInfo.BOOK_ID_FIELD_DESC);
//            fVar.mo18493a(bBUserFinishPlanInfo.book_id);
//            fVar.mo18496a(BBUserFinishPlanInfo.TOTAL_WORDS_COUNT_FIELD_DESC);
//            fVar.mo18493a(bBUserFinishPlanInfo.total_words_count);
//            fVar.mo18496a(BBUserFinishPlanInfo.NEW_WORDS_COUNT_FIELD_DESC);
//            fVar.mo18493a(bBUserFinishPlanInfo.new_words_count);
//            fVar.mo18496a(BBUserFinishPlanInfo.IS_BOOK_FINISHED_FIELD_DESC);
//            fVar.mo18500a(bBUserFinishPlanInfo.is_book_finished);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserFinishPlanInfoStandardSchemeFactory implements C2109b {
//        private BBUserFinishPlanInfoStandardSchemeFactory() {
//        }
//
//        public BBUserFinishPlanInfoStandardScheme getScheme() {
//            return new BBUserFinishPlanInfoStandardScheme();
//        }
//    }
//
//    class BBUserFinishPlanInfoTupleScheme extends C2111d<BBUserFinishPlanInfo> {
//        private BBUserFinishPlanInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserFinishPlanInfo bBUserFinishPlanInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBUserFinishPlanInfo.book_id);
//            lVar.mo18493a(bBUserFinishPlanInfo.total_words_count);
//            lVar.mo18493a(bBUserFinishPlanInfo.new_words_count);
//            lVar.mo18500a(bBUserFinishPlanInfo.is_book_finished);
//        }
//
//        public void read(C2100f fVar, BBUserFinishPlanInfo bBUserFinishPlanInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserFinishPlanInfo.book_id = lVar.mo18513n();
//            bBUserFinishPlanInfo.setBook_idIsSet(true);
//            bBUserFinishPlanInfo.total_words_count = lVar.mo18513n();
//            bBUserFinishPlanInfo.setTotal_words_countIsSet(true);
//            bBUserFinishPlanInfo.new_words_count = lVar.mo18513n();
//            bBUserFinishPlanInfo.setNew_words_countIsSet(true);
//            bBUserFinishPlanInfo.is_book_finished = lVar.mo18510k();
//            bBUserFinishPlanInfo.setIs_book_finishedIsSet(true);
//        }
//    }
//
//    class BBUserFinishPlanInfoTupleSchemeFactory implements C2109b {
//        private BBUserFinishPlanInfoTupleSchemeFactory() {
//        }
//
//        public BBUserFinishPlanInfoTupleScheme getScheme() {
//            return new BBUserFinishPlanInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        BOOK_ID(1, "book_id"),
//        TOTAL_WORDS_COUNT(2, "total_words_count"),
//        NEW_WORDS_COUNT(3, "new_words_count"),
//        IS_BOOK_FINISHED(4, "is_book_finished");
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
//                    return TOTAL_WORDS_COUNT;
//                case 3:
//                    return NEW_WORDS_COUNT;
//                case 4:
//                    return IS_BOOK_FINISHED;
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
//        hashMap.put(C2110c.class, new BBUserFinishPlanInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserFinishPlanInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.TOTAL_WORDS_COUNT, new C2091a("total_words_count", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.NEW_WORDS_COUNT, new C2091a("new_words_count", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.IS_BOOK_FINISHED, new C2091a("is_book_finished", 1, new C2092b(2, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserFinishPlanInfo.class, metaDataMap);
//    }
//
//    public BBUserFinishPlanInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBUserFinishPlanInfo(int i, int i2, int i3, boolean z) {
//        this();
//        this.book_id = i;
//        setBook_idIsSet(true);
//        this.total_words_count = i2;
//        setTotal_words_countIsSet(true);
//        this.new_words_count = i3;
//        setNew_words_countIsSet(true);
//        this.is_book_finished = z;
//        setIs_book_finishedIsSet(true);
//    }
//
//    public BBUserFinishPlanInfo(BBUserFinishPlanInfo bBUserFinishPlanInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBUserFinishPlanInfo.__isset_bitfield;
//        this.book_id = bBUserFinishPlanInfo.book_id;
//        this.total_words_count = bBUserFinishPlanInfo.total_words_count;
//        this.new_words_count = bBUserFinishPlanInfo.new_words_count;
//        this.is_book_finished = bBUserFinishPlanInfo.is_book_finished;
//    }
//
//    public BBUserFinishPlanInfo deepCopy() {
//        return new BBUserFinishPlanInfo(this);
//    }
//
//    public void clear() {
//        setBook_idIsSet(false);
//        this.book_id = 0;
//        setTotal_words_countIsSet(false);
//        this.total_words_count = 0;
//        setNew_words_countIsSet(false);
//        this.new_words_count = 0;
//        setIs_book_finishedIsSet(false);
//        this.is_book_finished = false;
//    }
//
//    public int getBook_id() {
//        return this.book_id;
//    }
//
//    public BBUserFinishPlanInfo setBook_id(int i) {
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
//    public int getTotal_words_count() {
//        return this.total_words_count;
//    }
//
//    public BBUserFinishPlanInfo setTotal_words_count(int i) {
//        this.total_words_count = i;
//        setTotal_words_countIsSet(true);
//        return this;
//    }
//
//    public void unsetTotal_words_count() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetTotal_words_count() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setTotal_words_countIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getNew_words_count() {
//        return this.new_words_count;
//    }
//
//    public BBUserFinishPlanInfo setNew_words_count(int i) {
//        this.new_words_count = i;
//        setNew_words_countIsSet(true);
//        return this;
//    }
//
//    public void unsetNew_words_count() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetNew_words_count() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setNew_words_countIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public boolean isIs_book_finished() {
//        return this.is_book_finished;
//    }
//
//    public BBUserFinishPlanInfo setIs_book_finished(boolean z) {
//        this.is_book_finished = z;
//        setIs_book_finishedIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_book_finished() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetIs_book_finished() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setIs_book_finishedIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
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
//            case TOTAL_WORDS_COUNT:
//                if (obj == null) {
//                    unsetTotal_words_count();
//                    return;
//                } else {
//                    setTotal_words_count(((Integer) obj).intValue());
//                    return;
//                }
//            case NEW_WORDS_COUNT:
//                if (obj == null) {
//                    unsetNew_words_count();
//                    return;
//                } else {
//                    setNew_words_count(((Integer) obj).intValue());
//                    return;
//                }
//            case IS_BOOK_FINISHED:
//                if (obj == null) {
//                    unsetIs_book_finished();
//                    return;
//                } else {
//                    setIs_book_finished(((Boolean) obj).booleanValue());
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
//            case TOTAL_WORDS_COUNT:
//                return Integer.valueOf(getTotal_words_count());
//            case NEW_WORDS_COUNT:
//                return Integer.valueOf(getNew_words_count());
//            case IS_BOOK_FINISHED:
//                return Boolean.valueOf(isIs_book_finished());
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
//            case TOTAL_WORDS_COUNT:
//                return isSetTotal_words_count();
//            case NEW_WORDS_COUNT:
//                return isSetNew_words_count();
//            case IS_BOOK_FINISHED:
//                return isSetIs_book_finished();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBUserFinishPlanInfo)) {
//            return equals((BBUserFinishPlanInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserFinishPlanInfo bBUserFinishPlanInfo) {
//        if (bBUserFinishPlanInfo != null && this.book_id == bBUserFinishPlanInfo.book_id && this.total_words_count == bBUserFinishPlanInfo.total_words_count && this.new_words_count == bBUserFinishPlanInfo.new_words_count && this.is_book_finished == bBUserFinishPlanInfo.is_book_finished) {
//            return true;
//        }
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserFinishPlanInfo bBUserFinishPlanInfo) {
//        if (!getClass().equals(bBUserFinishPlanInfo.getClass())) {
//            return getClass().getName().compareTo(bBUserFinishPlanInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(bBUserFinishPlanInfo.isSetBook_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetBook_id()) {
//            int a = C2121h.m5522a(this.book_id, bBUserFinishPlanInfo.book_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetTotal_words_count()).compareTo(Boolean.valueOf(bBUserFinishPlanInfo.isSetTotal_words_count()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetTotal_words_count()) {
//            int a2 = C2121h.m5522a(this.total_words_count, bBUserFinishPlanInfo.total_words_count);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetNew_words_count()).compareTo(Boolean.valueOf(bBUserFinishPlanInfo.isSetNew_words_count()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetNew_words_count()) {
//            int a3 = C2121h.m5522a(this.new_words_count, bBUserFinishPlanInfo.new_words_count);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetIs_book_finished()).compareTo(Boolean.valueOf(bBUserFinishPlanInfo.isSetIs_book_finished()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetIs_book_finished()) {
//            int a4 = C2121h.m5529a(this.is_book_finished, bBUserFinishPlanInfo.is_book_finished);
//            if (a4 != 0) {
//                return a4;
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
//        StringBuilder sb = new StringBuilder("BBUserFinishPlanInfo(");
//        sb.append("book_id:");
//        sb.append(this.book_id);
//        sb.append(", ");
//        sb.append("total_words_count:");
//        sb.append(this.total_words_count);
//        sb.append(", ");
//        sb.append("new_words_count:");
//        sb.append(this.new_words_count);
//        sb.append(", ");
//        sb.append("is_book_finished:");
//        sb.append(this.is_book_finished);
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
