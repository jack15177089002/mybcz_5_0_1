//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
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
//public class BBBookBasicInfo implements Serializable, Cloneable, Comparable<BBBookBasicInfo>, C2116f<BBBookBasicInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b ID_FIELD_DESC = new C2097b(Columns.f2234ID, 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b NAME_FIELD_DESC = new C2097b("name", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBBookBasicInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TOTAL_WORDS_COUNT_FIELD_DESC = new C2097b("total_words_count", 8, 3);
//    private static final int __ID_ISSET_ID = 0;
//    private static final int __TOTAL_WORDS_COUNT_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//
//    /* renamed from: id */
//    public int f2406id;
//    public String name;
//    public int total_words_count;
//
//    class BBBookBasicInfoStandardScheme extends C2110c<BBBookBasicInfo> {
//        private BBBookBasicInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBBookBasicInfo bBBookBasicInfo) {
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
//                                bBBookBasicInfo.f2406id = fVar.mo18513n();
//                                bBBookBasicInfo.setIdIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookBasicInfo.name = fVar.mo18516q();
//                                bBBookBasicInfo.setNameIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookBasicInfo.total_words_count = fVar.mo18513n();
//                                bBBookBasicInfo.setTotal_words_countIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBBookBasicInfo.isSetId()) {
//                        throw new C2101g("Required field 'id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBBookBasicInfo.isSetTotal_words_count()) {
//                        throw new C2101g("Required field 'total_words_count' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBBookBasicInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBBookBasicInfo bBBookBasicInfo) {
//            bBBookBasicInfo.validate();
//            BBBookBasicInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBBookBasicInfo.ID_FIELD_DESC);
//            fVar.mo18493a(bBBookBasicInfo.f2406id);
//            if (bBBookBasicInfo.name != null) {
//                fVar.mo18496a(BBBookBasicInfo.NAME_FIELD_DESC);
//                fVar.mo18495a(bBBookBasicInfo.name);
//            }
//            fVar.mo18496a(BBBookBasicInfo.TOTAL_WORDS_COUNT_FIELD_DESC);
//            fVar.mo18493a(bBBookBasicInfo.total_words_count);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBBookBasicInfoStandardSchemeFactory implements C2109b {
//        private BBBookBasicInfoStandardSchemeFactory() {
//        }
//
//        public BBBookBasicInfoStandardScheme getScheme() {
//            return new BBBookBasicInfoStandardScheme();
//        }
//    }
//
//    class BBBookBasicInfoTupleScheme extends C2111d<BBBookBasicInfo> {
//        private BBBookBasicInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBBookBasicInfo bBBookBasicInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBBookBasicInfo.f2406id);
//            lVar.mo18495a(bBBookBasicInfo.name);
//            lVar.mo18493a(bBBookBasicInfo.total_words_count);
//        }
//
//        public void read(C2100f fVar, BBBookBasicInfo bBBookBasicInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBBookBasicInfo.f2406id = lVar.mo18513n();
//            bBBookBasicInfo.setIdIsSet(true);
//            bBBookBasicInfo.name = lVar.mo18516q();
//            bBBookBasicInfo.setNameIsSet(true);
//            bBBookBasicInfo.total_words_count = lVar.mo18513n();
//            bBBookBasicInfo.setTotal_words_countIsSet(true);
//        }
//    }
//
//    class BBBookBasicInfoTupleSchemeFactory implements C2109b {
//        private BBBookBasicInfoTupleSchemeFactory() {
//        }
//
//        public BBBookBasicInfoTupleScheme getScheme() {
//            return new BBBookBasicInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        ID(1, Columns.f2234ID),
//        NAME(2, "name"),
//        TOTAL_WORDS_COUNT(3, "total_words_count");
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
//                    return ID;
//                case 2:
//                    return NAME;
//                case 3:
//                    return TOTAL_WORDS_COUNT;
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
//        hashMap.put(C2110c.class, new BBBookBasicInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBBookBasicInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.ID, new C2091a(Columns.f2234ID, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.NAME, new C2091a("name", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.TOTAL_WORDS_COUNT, new C2091a("total_words_count", 1, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBBookBasicInfo.class, metaDataMap);
//    }
//
//    public BBBookBasicInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBBookBasicInfo(int i, String str, int i2) {
//        this();
//        this.f2406id = i;
//        setIdIsSet(true);
//        this.name = str;
//        this.total_words_count = i2;
//        setTotal_words_countIsSet(true);
//    }
//
//    public BBBookBasicInfo(BBBookBasicInfo bBBookBasicInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBBookBasicInfo.__isset_bitfield;
//        this.f2406id = bBBookBasicInfo.f2406id;
//        if (bBBookBasicInfo.isSetName()) {
//            this.name = bBBookBasicInfo.name;
//        }
//        this.total_words_count = bBBookBasicInfo.total_words_count;
//    }
//
//    public BBBookBasicInfo deepCopy() {
//        return new BBBookBasicInfo(this);
//    }
//
//    public void clear() {
//        setIdIsSet(false);
//        this.f2406id = 0;
//        this.name = null;
//        setTotal_words_countIsSet(false);
//        this.total_words_count = 0;
//    }
//
//    public int getId() {
//        return this.f2406id;
//    }
//
//    public BBBookBasicInfo setId(int i) {
//        this.f2406id = i;
//        setIdIsSet(true);
//        return this;
//    }
//
//    public void unsetId() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetId() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setIdIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public BBBookBasicInfo setName(String str) {
//        this.name = str;
//        return this;
//    }
//
//    public void unsetName() {
//        this.name = null;
//    }
//
//    public boolean isSetName() {
//        return this.name != null;
//    }
//
//    public void setNameIsSet(boolean z) {
//        if (!z) {
//            this.name = null;
//        }
//    }
//
//    public int getTotal_words_count() {
//        return this.total_words_count;
//    }
//
//    public BBBookBasicInfo setTotal_words_count(int i) {
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
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case ID:
//                if (obj == null) {
//                    unsetId();
//                    return;
//                } else {
//                    setId(((Integer) obj).intValue());
//                    return;
//                }
//            case NAME:
//                if (obj == null) {
//                    unsetName();
//                    return;
//                } else {
//                    setName((String) obj);
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
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case ID:
//                return Integer.valueOf(getId());
//            case NAME:
//                return getName();
//            case TOTAL_WORDS_COUNT:
//                return Integer.valueOf(getTotal_words_count());
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
//            case ID:
//                return isSetId();
//            case NAME:
//                return isSetName();
//            case TOTAL_WORDS_COUNT:
//                return isSetTotal_words_count();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBBookBasicInfo)) {
//            return equals((BBBookBasicInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBBookBasicInfo bBBookBasicInfo) {
//        if (bBBookBasicInfo == null || this.f2406id != bBBookBasicInfo.f2406id) {
//            return false;
//        }
//        boolean isSetName = isSetName();
//        boolean isSetName2 = bBBookBasicInfo.isSetName();
//        if (((isSetName || isSetName2) && (!isSetName || !isSetName2 || !this.name.equals(bBBookBasicInfo.name))) || this.total_words_count != bBBookBasicInfo.total_words_count) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBBookBasicInfo bBBookBasicInfo) {
//        if (!getClass().equals(bBBookBasicInfo.getClass())) {
//            return getClass().getName().compareTo(bBBookBasicInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetId()).compareTo(Boolean.valueOf(bBBookBasicInfo.isSetId()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetId()) {
//            int a = C2121h.m5522a(this.f2406id, bBBookBasicInfo.f2406id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetName()).compareTo(Boolean.valueOf(bBBookBasicInfo.isSetName()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetName()) {
//            int a2 = C2121h.m5525a(this.name, bBBookBasicInfo.name);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetTotal_words_count()).compareTo(Boolean.valueOf(bBBookBasicInfo.isSetTotal_words_count()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetTotal_words_count()) {
//            int a3 = C2121h.m5522a(this.total_words_count, bBBookBasicInfo.total_words_count);
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
//        StringBuilder sb = new StringBuilder("BBBookBasicInfo(");
//        sb.append("id:");
//        sb.append(this.f2406id);
//        sb.append(", ");
//        sb.append("name:");
//        if (this.name == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.name);
//        }
//        sb.append(", ");
//        sb.append("total_words_count:");
//        sb.append(this.total_words_count);
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.name == null) {
//            throw new C2101g("Required field 'name' was not present! Struct: " + toString());
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
