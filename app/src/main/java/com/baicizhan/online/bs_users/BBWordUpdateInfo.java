//package com.baicizhan.online.bs_users;
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
//public class BBWordUpdateInfo implements Serializable, Cloneable, Comparable<BBWordUpdateInfo>, C2116f<BBWordUpdateInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b ASSET_VERSION_FIELD_DESC = new C2097b("asset_version", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordUpdateInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATE_FLAG_FIELD_DESC = new C2097b("update_flag", JceStruct.STRUCT_END, 2);
//    private static final int __ASSET_VERSION_ISSET_ID = 1;
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int asset_version;
//    public int topic_id;
//    public String update_flag;
//
//    class BBWordUpdateInfoStandardScheme extends C2110c<BBWordUpdateInfo> {
//        private BBWordUpdateInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordUpdateInfo bBWordUpdateInfo) {
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
//                                bBWordUpdateInfo.topic_id = fVar.mo18513n();
//                                bBWordUpdateInfo.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordUpdateInfo.update_flag = fVar.mo18516q();
//                                bBWordUpdateInfo.setUpdate_flagIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordUpdateInfo.asset_version = fVar.mo18513n();
//                                bBWordUpdateInfo.setAsset_versionIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBWordUpdateInfo.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBWordUpdateInfo.isSetAsset_version()) {
//                        throw new C2101g("Required field 'asset_version' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBWordUpdateInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordUpdateInfo bBWordUpdateInfo) {
//            bBWordUpdateInfo.validate();
//            BBWordUpdateInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBWordUpdateInfo.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordUpdateInfo.topic_id);
//            if (bBWordUpdateInfo.update_flag != null) {
//                fVar.mo18496a(BBWordUpdateInfo.UPDATE_FLAG_FIELD_DESC);
//                fVar.mo18495a(bBWordUpdateInfo.update_flag);
//            }
//            fVar.mo18496a(BBWordUpdateInfo.ASSET_VERSION_FIELD_DESC);
//            fVar.mo18493a(bBWordUpdateInfo.asset_version);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordUpdateInfoStandardSchemeFactory implements C2109b {
//        private BBWordUpdateInfoStandardSchemeFactory() {
//        }
//
//        public BBWordUpdateInfoStandardScheme getScheme() {
//            return new BBWordUpdateInfoStandardScheme();
//        }
//    }
//
//    class BBWordUpdateInfoTupleScheme extends C2111d<BBWordUpdateInfo> {
//        private BBWordUpdateInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordUpdateInfo bBWordUpdateInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBWordUpdateInfo.topic_id);
//            lVar.mo18495a(bBWordUpdateInfo.update_flag);
//            lVar.mo18493a(bBWordUpdateInfo.asset_version);
//        }
//
//        public void read(C2100f fVar, BBWordUpdateInfo bBWordUpdateInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBWordUpdateInfo.topic_id = lVar.mo18513n();
//            bBWordUpdateInfo.setTopic_idIsSet(true);
//            bBWordUpdateInfo.update_flag = lVar.mo18516q();
//            bBWordUpdateInfo.setUpdate_flagIsSet(true);
//            bBWordUpdateInfo.asset_version = lVar.mo18513n();
//            bBWordUpdateInfo.setAsset_versionIsSet(true);
//        }
//    }
//
//    class BBWordUpdateInfoTupleSchemeFactory implements C2109b {
//        private BBWordUpdateInfoTupleSchemeFactory() {
//        }
//
//        public BBWordUpdateInfoTupleScheme getScheme() {
//            return new BBWordUpdateInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        UPDATE_FLAG(2, "update_flag"),
//        ASSET_VERSION(3, "asset_version");
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
//                    return UPDATE_FLAG;
//                case 3:
//                    return ASSET_VERSION;
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
//        hashMap.put(C2110c.class, new BBWordUpdateInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordUpdateInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.UPDATE_FLAG, new C2091a("update_flag", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.ASSET_VERSION, new C2091a("asset_version", 1, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordUpdateInfo.class, metaDataMap);
//    }
//
//    public BBWordUpdateInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBWordUpdateInfo(int i, String str, int i2) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.update_flag = str;
//        this.asset_version = i2;
//        setAsset_versionIsSet(true);
//    }
//
//    public BBWordUpdateInfo(BBWordUpdateInfo bBWordUpdateInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBWordUpdateInfo.__isset_bitfield;
//        this.topic_id = bBWordUpdateInfo.topic_id;
//        if (bBWordUpdateInfo.isSetUpdate_flag()) {
//            this.update_flag = bBWordUpdateInfo.update_flag;
//        }
//        this.asset_version = bBWordUpdateInfo.asset_version;
//    }
//
//    public BBWordUpdateInfo deepCopy() {
//        return new BBWordUpdateInfo(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        this.update_flag = null;
//        setAsset_versionIsSet(false);
//        this.asset_version = 0;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBWordUpdateInfo setTopic_id(int i) {
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
//    public String getUpdate_flag() {
//        return this.update_flag;
//    }
//
//    public BBWordUpdateInfo setUpdate_flag(String str) {
//        this.update_flag = str;
//        return this;
//    }
//
//    public void unsetUpdate_flag() {
//        this.update_flag = null;
//    }
//
//    public boolean isSetUpdate_flag() {
//        return this.update_flag != null;
//    }
//
//    public void setUpdate_flagIsSet(boolean z) {
//        if (!z) {
//            this.update_flag = null;
//        }
//    }
//
//    public int getAsset_version() {
//        return this.asset_version;
//    }
//
//    public BBWordUpdateInfo setAsset_version(int i) {
//        this.asset_version = i;
//        setAsset_versionIsSet(true);
//        return this;
//    }
//
//    public void unsetAsset_version() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetAsset_version() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setAsset_versionIsSet(boolean z) {
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
//            case UPDATE_FLAG:
//                if (obj == null) {
//                    unsetUpdate_flag();
//                    return;
//                } else {
//                    setUpdate_flag((String) obj);
//                    return;
//                }
//            case ASSET_VERSION:
//                if (obj == null) {
//                    unsetAsset_version();
//                    return;
//                } else {
//                    setAsset_version(((Integer) obj).intValue());
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
//            case UPDATE_FLAG:
//                return getUpdate_flag();
//            case ASSET_VERSION:
//                return Integer.valueOf(getAsset_version());
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
//            case UPDATE_FLAG:
//                return isSetUpdate_flag();
//            case ASSET_VERSION:
//                return isSetAsset_version();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordUpdateInfo)) {
//            return equals((BBWordUpdateInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordUpdateInfo bBWordUpdateInfo) {
//        if (bBWordUpdateInfo == null || this.topic_id != bBWordUpdateInfo.topic_id) {
//            return false;
//        }
//        boolean isSetUpdate_flag = isSetUpdate_flag();
//        boolean isSetUpdate_flag2 = bBWordUpdateInfo.isSetUpdate_flag();
//        if (((isSetUpdate_flag || isSetUpdate_flag2) && (!isSetUpdate_flag || !isSetUpdate_flag2 || !this.update_flag.equals(bBWordUpdateInfo.update_flag))) || this.asset_version != bBWordUpdateInfo.asset_version) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordUpdateInfo bBWordUpdateInfo) {
//        if (!getClass().equals(bBWordUpdateInfo.getClass())) {
//            return getClass().getName().compareTo(bBWordUpdateInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBWordUpdateInfo.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBWordUpdateInfo.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetUpdate_flag()).compareTo(Boolean.valueOf(bBWordUpdateInfo.isSetUpdate_flag()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetUpdate_flag()) {
//            int a2 = C2121h.m5525a(this.update_flag, bBWordUpdateInfo.update_flag);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetAsset_version()).compareTo(Boolean.valueOf(bBWordUpdateInfo.isSetAsset_version()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetAsset_version()) {
//            int a3 = C2121h.m5522a(this.asset_version, bBWordUpdateInfo.asset_version);
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
//        StringBuilder sb = new StringBuilder("BBWordUpdateInfo(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("update_flag:");
//        if (this.update_flag == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.update_flag);
//        }
//        sb.append(", ");
//        sb.append("asset_version:");
//        sb.append(this.asset_version);
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.update_flag == null) {
//            throw new C2101g("Required field 'update_flag' was not present! Struct: " + toString());
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
