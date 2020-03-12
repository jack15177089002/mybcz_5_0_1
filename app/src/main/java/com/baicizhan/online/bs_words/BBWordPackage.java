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
//public class BBWordPackage implements Serializable, Cloneable, Comparable<BBWordPackage>, C2116f<BBWordPackage, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordPackage");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b ZPK_MD5_FIELD_DESC = new C2097b("zpk_md5", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b ZPK_PATH_FIELD_DESC = new C2097b("zpk_path", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b ZPK_SIZE_FIELD_DESC = new C2097b("zpk_size", 10, 3);
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    private static final int __ZPK_SIZE_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int topic_id;
//    public String zpk_md5;
//    public String zpk_path;
//    public long zpk_size;
//
//    class BBWordPackageStandardScheme extends C2110c<BBWordPackage> {
//        private BBWordPackageStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordPackage bBWordPackage) {
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
//                                bBWordPackage.topic_id = fVar.mo18513n();
//                                bBWordPackage.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordPackage.zpk_path = fVar.mo18516q();
//                                bBWordPackage.setZpk_pathIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordPackage.zpk_size = fVar.mo18514o();
//                                bBWordPackage.setZpk_sizeIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordPackage.zpk_md5 = fVar.mo18516q();
//                                bBWordPackage.setZpk_md5IsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBWordPackage.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBWordPackage.isSetZpk_size()) {
//                        throw new C2101g("Required field 'zpk_size' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBWordPackage.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordPackage bBWordPackage) {
//            bBWordPackage.validate();
//            BBWordPackage.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBWordPackage.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordPackage.topic_id);
//            if (bBWordPackage.zpk_path != null) {
//                fVar.mo18496a(BBWordPackage.ZPK_PATH_FIELD_DESC);
//                fVar.mo18495a(bBWordPackage.zpk_path);
//            }
//            fVar.mo18496a(BBWordPackage.ZPK_SIZE_FIELD_DESC);
//            fVar.mo18494a(bBWordPackage.zpk_size);
//            if (bBWordPackage.zpk_md5 != null) {
//                fVar.mo18496a(BBWordPackage.ZPK_MD5_FIELD_DESC);
//                fVar.mo18495a(bBWordPackage.zpk_md5);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordPackageStandardSchemeFactory implements C2109b {
//        private BBWordPackageStandardSchemeFactory() {
//        }
//
//        public BBWordPackageStandardScheme getScheme() {
//            return new BBWordPackageStandardScheme();
//        }
//    }
//
//    class BBWordPackageTupleScheme extends C2111d<BBWordPackage> {
//        private BBWordPackageTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordPackage bBWordPackage) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBWordPackage.topic_id);
//            lVar.mo18495a(bBWordPackage.zpk_path);
//            lVar.mo18494a(bBWordPackage.zpk_size);
//            lVar.mo18495a(bBWordPackage.zpk_md5);
//        }
//
//        public void read(C2100f fVar, BBWordPackage bBWordPackage) {
//            C2106l lVar = (C2106l) fVar;
//            bBWordPackage.topic_id = lVar.mo18513n();
//            bBWordPackage.setTopic_idIsSet(true);
//            bBWordPackage.zpk_path = lVar.mo18516q();
//            bBWordPackage.setZpk_pathIsSet(true);
//            bBWordPackage.zpk_size = lVar.mo18514o();
//            bBWordPackage.setZpk_sizeIsSet(true);
//            bBWordPackage.zpk_md5 = lVar.mo18516q();
//            bBWordPackage.setZpk_md5IsSet(true);
//        }
//    }
//
//    class BBWordPackageTupleSchemeFactory implements C2109b {
//        private BBWordPackageTupleSchemeFactory() {
//        }
//
//        public BBWordPackageTupleScheme getScheme() {
//            return new BBWordPackageTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        ZPK_PATH(2, "zpk_path"),
//        ZPK_SIZE(3, "zpk_size"),
//        ZPK_MD5(4, "zpk_md5");
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
//                    return ZPK_PATH;
//                case 3:
//                    return ZPK_SIZE;
//                case 4:
//                    return ZPK_MD5;
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
//        hashMap.put(C2110c.class, new BBWordPackageStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordPackageTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.ZPK_PATH, new C2091a("zpk_path", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.ZPK_SIZE, new C2091a("zpk_size", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.ZPK_MD5, new C2091a("zpk_md5", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordPackage.class, metaDataMap);
//    }
//
//    public BBWordPackage() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBWordPackage(int i, String str, long j, String str2) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.zpk_path = str;
//        this.zpk_size = j;
//        setZpk_sizeIsSet(true);
//        this.zpk_md5 = str2;
//    }
//
//    public BBWordPackage(BBWordPackage bBWordPackage) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBWordPackage.__isset_bitfield;
//        this.topic_id = bBWordPackage.topic_id;
//        if (bBWordPackage.isSetZpk_path()) {
//            this.zpk_path = bBWordPackage.zpk_path;
//        }
//        this.zpk_size = bBWordPackage.zpk_size;
//        if (bBWordPackage.isSetZpk_md5()) {
//            this.zpk_md5 = bBWordPackage.zpk_md5;
//        }
//    }
//
//    public BBWordPackage deepCopy() {
//        return new BBWordPackage(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        this.zpk_path = null;
//        setZpk_sizeIsSet(false);
//        this.zpk_size = 0;
//        this.zpk_md5 = null;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBWordPackage setTopic_id(int i) {
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
//    public String getZpk_path() {
//        return this.zpk_path;
//    }
//
//    public BBWordPackage setZpk_path(String str) {
//        this.zpk_path = str;
//        return this;
//    }
//
//    public void unsetZpk_path() {
//        this.zpk_path = null;
//    }
//
//    public boolean isSetZpk_path() {
//        return this.zpk_path != null;
//    }
//
//    public void setZpk_pathIsSet(boolean z) {
//        if (!z) {
//            this.zpk_path = null;
//        }
//    }
//
//    public long getZpk_size() {
//        return this.zpk_size;
//    }
//
//    public BBWordPackage setZpk_size(long j) {
//        this.zpk_size = j;
//        setZpk_sizeIsSet(true);
//        return this;
//    }
//
//    public void unsetZpk_size() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetZpk_size() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setZpk_sizeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public String getZpk_md5() {
//        return this.zpk_md5;
//    }
//
//    public BBWordPackage setZpk_md5(String str) {
//        this.zpk_md5 = str;
//        return this;
//    }
//
//    public void unsetZpk_md5() {
//        this.zpk_md5 = null;
//    }
//
//    public boolean isSetZpk_md5() {
//        return this.zpk_md5 != null;
//    }
//
//    public void setZpk_md5IsSet(boolean z) {
//        if (!z) {
//            this.zpk_md5 = null;
//        }
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
//            case ZPK_PATH:
//                if (obj == null) {
//                    unsetZpk_path();
//                    return;
//                } else {
//                    setZpk_path((String) obj);
//                    return;
//                }
//            case ZPK_SIZE:
//                if (obj == null) {
//                    unsetZpk_size();
//                    return;
//                } else {
//                    setZpk_size(((Long) obj).longValue());
//                    return;
//                }
//            case ZPK_MD5:
//                if (obj == null) {
//                    unsetZpk_md5();
//                    return;
//                } else {
//                    setZpk_md5((String) obj);
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
//            case ZPK_PATH:
//                return getZpk_path();
//            case ZPK_SIZE:
//                return Long.valueOf(getZpk_size());
//            case ZPK_MD5:
//                return getZpk_md5();
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
//            case ZPK_PATH:
//                return isSetZpk_path();
//            case ZPK_SIZE:
//                return isSetZpk_size();
//            case ZPK_MD5:
//                return isSetZpk_md5();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordPackage)) {
//            return equals((BBWordPackage) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordPackage bBWordPackage) {
//        if (bBWordPackage == null || this.topic_id != bBWordPackage.topic_id) {
//            return false;
//        }
//        boolean isSetZpk_path = isSetZpk_path();
//        boolean isSetZpk_path2 = bBWordPackage.isSetZpk_path();
//        if (((isSetZpk_path || isSetZpk_path2) && (!isSetZpk_path || !isSetZpk_path2 || !this.zpk_path.equals(bBWordPackage.zpk_path))) || this.zpk_size != bBWordPackage.zpk_size) {
//            return false;
//        }
//        boolean isSetZpk_md5 = isSetZpk_md5();
//        boolean isSetZpk_md52 = bBWordPackage.isSetZpk_md5();
//        if ((isSetZpk_md5 || isSetZpk_md52) && (!isSetZpk_md5 || !isSetZpk_md52 || !this.zpk_md5.equals(bBWordPackage.zpk_md5))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordPackage bBWordPackage) {
//        if (!getClass().equals(bBWordPackage.getClass())) {
//            return getClass().getName().compareTo(bBWordPackage.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBWordPackage.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBWordPackage.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetZpk_path()).compareTo(Boolean.valueOf(bBWordPackage.isSetZpk_path()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetZpk_path()) {
//            int a2 = C2121h.m5525a(this.zpk_path, bBWordPackage.zpk_path);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetZpk_size()).compareTo(Boolean.valueOf(bBWordPackage.isSetZpk_size()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetZpk_size()) {
//            int a3 = C2121h.m5523a(this.zpk_size, bBWordPackage.zpk_size);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetZpk_md5()).compareTo(Boolean.valueOf(bBWordPackage.isSetZpk_md5()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetZpk_md5()) {
//            int a4 = C2121h.m5525a(this.zpk_md5, bBWordPackage.zpk_md5);
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
//        StringBuilder sb = new StringBuilder("BBWordPackage(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("zpk_path:");
//        if (this.zpk_path == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.zpk_path);
//        }
//        sb.append(", ");
//        sb.append("zpk_size:");
//        sb.append(this.zpk_size);
//        sb.append(", ");
//        sb.append("zpk_md5:");
//        if (this.zpk_md5 == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.zpk_md5);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.zpk_path == null) {
//            throw new C2101g("Required field 'zpk_path' was not present! Struct: " + toString());
//        } else if (this.zpk_md5 == null) {
//            throw new C2101g("Required field 'zpk_md5' was not present! Struct: " + toString());
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
