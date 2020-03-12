//package com.baicizhan.online.bs_words;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_OPEN_EARS_MATCH_INFO.Columns;
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
//public class BBWordAssetPackInfo implements Serializable, Cloneable, Comparable<BBWordAssetPackInfo>, C2116f<BBWordAssetPackInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b ASSET_ZPACK_PATH_FIELD_DESC = new C2097b("asset_zpack_path", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b MAX_ID_FIELD_DESC = new C2097b(Columns.MAX_ID, 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b MIN_ID_FIELD_DESC = new C2097b(Columns.MIN_ID, 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordAssetPackInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_INFO_GZ_PATH_FIELD_DESC = new C2097b("word_info_gz_path", JceStruct.STRUCT_END, 3);
//    private static final int __MAX_ID_ISSET_ID = 1;
//    private static final int __MIN_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String asset_zpack_path;
//    public int max_id;
//    public int min_id;
//    public String word_info_gz_path;
//
//    class BBWordAssetPackInfoStandardScheme extends C2110c<BBWordAssetPackInfo> {
//        private BBWordAssetPackInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordAssetPackInfo bBWordAssetPackInfo) {
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
//                                bBWordAssetPackInfo.min_id = fVar.mo18513n();
//                                bBWordAssetPackInfo.setMin_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordAssetPackInfo.max_id = fVar.mo18513n();
//                                bBWordAssetPackInfo.setMax_idIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordAssetPackInfo.word_info_gz_path = fVar.mo18516q();
//                                bBWordAssetPackInfo.setWord_info_gz_pathIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordAssetPackInfo.asset_zpack_path = fVar.mo18516q();
//                                bBWordAssetPackInfo.setAsset_zpack_pathIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBWordAssetPackInfo.isSetMin_id()) {
//                        throw new C2101g("Required field 'min_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBWordAssetPackInfo.isSetMax_id()) {
//                        throw new C2101g("Required field 'max_id' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBWordAssetPackInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordAssetPackInfo bBWordAssetPackInfo) {
//            bBWordAssetPackInfo.validate();
//            BBWordAssetPackInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBWordAssetPackInfo.MIN_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordAssetPackInfo.min_id);
//            fVar.mo18496a(BBWordAssetPackInfo.MAX_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordAssetPackInfo.max_id);
//            if (bBWordAssetPackInfo.word_info_gz_path != null) {
//                fVar.mo18496a(BBWordAssetPackInfo.WORD_INFO_GZ_PATH_FIELD_DESC);
//                fVar.mo18495a(bBWordAssetPackInfo.word_info_gz_path);
//            }
//            if (bBWordAssetPackInfo.asset_zpack_path != null) {
//                fVar.mo18496a(BBWordAssetPackInfo.ASSET_ZPACK_PATH_FIELD_DESC);
//                fVar.mo18495a(bBWordAssetPackInfo.asset_zpack_path);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordAssetPackInfoStandardSchemeFactory implements C2109b {
//        private BBWordAssetPackInfoStandardSchemeFactory() {
//        }
//
//        public BBWordAssetPackInfoStandardScheme getScheme() {
//            return new BBWordAssetPackInfoStandardScheme();
//        }
//    }
//
//    class BBWordAssetPackInfoTupleScheme extends C2111d<BBWordAssetPackInfo> {
//        private BBWordAssetPackInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordAssetPackInfo bBWordAssetPackInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBWordAssetPackInfo.min_id);
//            lVar.mo18493a(bBWordAssetPackInfo.max_id);
//            lVar.mo18495a(bBWordAssetPackInfo.word_info_gz_path);
//            lVar.mo18495a(bBWordAssetPackInfo.asset_zpack_path);
//        }
//
//        public void read(C2100f fVar, BBWordAssetPackInfo bBWordAssetPackInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBWordAssetPackInfo.min_id = lVar.mo18513n();
//            bBWordAssetPackInfo.setMin_idIsSet(true);
//            bBWordAssetPackInfo.max_id = lVar.mo18513n();
//            bBWordAssetPackInfo.setMax_idIsSet(true);
//            bBWordAssetPackInfo.word_info_gz_path = lVar.mo18516q();
//            bBWordAssetPackInfo.setWord_info_gz_pathIsSet(true);
//            bBWordAssetPackInfo.asset_zpack_path = lVar.mo18516q();
//            bBWordAssetPackInfo.setAsset_zpack_pathIsSet(true);
//        }
//    }
//
//    class BBWordAssetPackInfoTupleSchemeFactory implements C2109b {
//        private BBWordAssetPackInfoTupleSchemeFactory() {
//        }
//
//        public BBWordAssetPackInfoTupleScheme getScheme() {
//            return new BBWordAssetPackInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        MIN_ID(1, Columns.MIN_ID),
//        MAX_ID(2, Columns.MAX_ID),
//        WORD_INFO_GZ_PATH(3, "word_info_gz_path"),
//        ASSET_ZPACK_PATH(4, "asset_zpack_path");
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
//                    return MIN_ID;
//                case 2:
//                    return MAX_ID;
//                case 3:
//                    return WORD_INFO_GZ_PATH;
//                case 4:
//                    return ASSET_ZPACK_PATH;
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
//        hashMap.put(C2110c.class, new BBWordAssetPackInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordAssetPackInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.MIN_ID, new C2091a(Columns.MIN_ID, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.MAX_ID, new C2091a(Columns.MAX_ID, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.WORD_INFO_GZ_PATH, new C2091a("word_info_gz_path", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.ASSET_ZPACK_PATH, new C2091a("asset_zpack_path", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordAssetPackInfo.class, metaDataMap);
//    }
//
//    public BBWordAssetPackInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBWordAssetPackInfo(int i, int i2, String str, String str2) {
//        this();
//        this.min_id = i;
//        setMin_idIsSet(true);
//        this.max_id = i2;
//        setMax_idIsSet(true);
//        this.word_info_gz_path = str;
//        this.asset_zpack_path = str2;
//    }
//
//    public BBWordAssetPackInfo(BBWordAssetPackInfo bBWordAssetPackInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBWordAssetPackInfo.__isset_bitfield;
//        this.min_id = bBWordAssetPackInfo.min_id;
//        this.max_id = bBWordAssetPackInfo.max_id;
//        if (bBWordAssetPackInfo.isSetWord_info_gz_path()) {
//            this.word_info_gz_path = bBWordAssetPackInfo.word_info_gz_path;
//        }
//        if (bBWordAssetPackInfo.isSetAsset_zpack_path()) {
//            this.asset_zpack_path = bBWordAssetPackInfo.asset_zpack_path;
//        }
//    }
//
//    public BBWordAssetPackInfo deepCopy() {
//        return new BBWordAssetPackInfo(this);
//    }
//
//    public void clear() {
//        setMin_idIsSet(false);
//        this.min_id = 0;
//        setMax_idIsSet(false);
//        this.max_id = 0;
//        this.word_info_gz_path = null;
//        this.asset_zpack_path = null;
//    }
//
//    public int getMin_id() {
//        return this.min_id;
//    }
//
//    public BBWordAssetPackInfo setMin_id(int i) {
//        this.min_id = i;
//        setMin_idIsSet(true);
//        return this;
//    }
//
//    public void unsetMin_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetMin_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setMin_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public int getMax_id() {
//        return this.max_id;
//    }
//
//    public BBWordAssetPackInfo setMax_id(int i) {
//        this.max_id = i;
//        setMax_idIsSet(true);
//        return this;
//    }
//
//    public void unsetMax_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetMax_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setMax_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public String getWord_info_gz_path() {
//        return this.word_info_gz_path;
//    }
//
//    public BBWordAssetPackInfo setWord_info_gz_path(String str) {
//        this.word_info_gz_path = str;
//        return this;
//    }
//
//    public void unsetWord_info_gz_path() {
//        this.word_info_gz_path = null;
//    }
//
//    public boolean isSetWord_info_gz_path() {
//        return this.word_info_gz_path != null;
//    }
//
//    public void setWord_info_gz_pathIsSet(boolean z) {
//        if (!z) {
//            this.word_info_gz_path = null;
//        }
//    }
//
//    public String getAsset_zpack_path() {
//        return this.asset_zpack_path;
//    }
//
//    public BBWordAssetPackInfo setAsset_zpack_path(String str) {
//        this.asset_zpack_path = str;
//        return this;
//    }
//
//    public void unsetAsset_zpack_path() {
//        this.asset_zpack_path = null;
//    }
//
//    public boolean isSetAsset_zpack_path() {
//        return this.asset_zpack_path != null;
//    }
//
//    public void setAsset_zpack_pathIsSet(boolean z) {
//        if (!z) {
//            this.asset_zpack_path = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case MIN_ID:
//                if (obj == null) {
//                    unsetMin_id();
//                    return;
//                } else {
//                    setMin_id(((Integer) obj).intValue());
//                    return;
//                }
//            case MAX_ID:
//                if (obj == null) {
//                    unsetMax_id();
//                    return;
//                } else {
//                    setMax_id(((Integer) obj).intValue());
//                    return;
//                }
//            case WORD_INFO_GZ_PATH:
//                if (obj == null) {
//                    unsetWord_info_gz_path();
//                    return;
//                } else {
//                    setWord_info_gz_path((String) obj);
//                    return;
//                }
//            case ASSET_ZPACK_PATH:
//                if (obj == null) {
//                    unsetAsset_zpack_path();
//                    return;
//                } else {
//                    setAsset_zpack_path((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case MIN_ID:
//                return Integer.valueOf(getMin_id());
//            case MAX_ID:
//                return Integer.valueOf(getMax_id());
//            case WORD_INFO_GZ_PATH:
//                return getWord_info_gz_path();
//            case ASSET_ZPACK_PATH:
//                return getAsset_zpack_path();
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
//            case MIN_ID:
//                return isSetMin_id();
//            case MAX_ID:
//                return isSetMax_id();
//            case WORD_INFO_GZ_PATH:
//                return isSetWord_info_gz_path();
//            case ASSET_ZPACK_PATH:
//                return isSetAsset_zpack_path();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordAssetPackInfo)) {
//            return equals((BBWordAssetPackInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordAssetPackInfo bBWordAssetPackInfo) {
//        if (bBWordAssetPackInfo == null || this.min_id != bBWordAssetPackInfo.min_id || this.max_id != bBWordAssetPackInfo.max_id) {
//            return false;
//        }
//        boolean isSetWord_info_gz_path = isSetWord_info_gz_path();
//        boolean isSetWord_info_gz_path2 = bBWordAssetPackInfo.isSetWord_info_gz_path();
//        if ((isSetWord_info_gz_path || isSetWord_info_gz_path2) && (!isSetWord_info_gz_path || !isSetWord_info_gz_path2 || !this.word_info_gz_path.equals(bBWordAssetPackInfo.word_info_gz_path))) {
//            return false;
//        }
//        boolean isSetAsset_zpack_path = isSetAsset_zpack_path();
//        boolean isSetAsset_zpack_path2 = bBWordAssetPackInfo.isSetAsset_zpack_path();
//        if ((isSetAsset_zpack_path || isSetAsset_zpack_path2) && (!isSetAsset_zpack_path || !isSetAsset_zpack_path2 || !this.asset_zpack_path.equals(bBWordAssetPackInfo.asset_zpack_path))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordAssetPackInfo bBWordAssetPackInfo) {
//        if (!getClass().equals(bBWordAssetPackInfo.getClass())) {
//            return getClass().getName().compareTo(bBWordAssetPackInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetMin_id()).compareTo(Boolean.valueOf(bBWordAssetPackInfo.isSetMin_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetMin_id()) {
//            int a = C2121h.m5522a(this.min_id, bBWordAssetPackInfo.min_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetMax_id()).compareTo(Boolean.valueOf(bBWordAssetPackInfo.isSetMax_id()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetMax_id()) {
//            int a2 = C2121h.m5522a(this.max_id, bBWordAssetPackInfo.max_id);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetWord_info_gz_path()).compareTo(Boolean.valueOf(bBWordAssetPackInfo.isSetWord_info_gz_path()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetWord_info_gz_path()) {
//            int a3 = C2121h.m5525a(this.word_info_gz_path, bBWordAssetPackInfo.word_info_gz_path);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetAsset_zpack_path()).compareTo(Boolean.valueOf(bBWordAssetPackInfo.isSetAsset_zpack_path()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetAsset_zpack_path()) {
//            int a4 = C2121h.m5525a(this.asset_zpack_path, bBWordAssetPackInfo.asset_zpack_path);
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
//        StringBuilder sb = new StringBuilder("BBWordAssetPackInfo(");
//        sb.append("min_id:");
//        sb.append(this.min_id);
//        sb.append(", ");
//        sb.append("max_id:");
//        sb.append(this.max_id);
//        sb.append(", ");
//        sb.append("word_info_gz_path:");
//        if (this.word_info_gz_path == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word_info_gz_path);
//        }
//        sb.append(", ");
//        sb.append("asset_zpack_path:");
//        if (this.asset_zpack_path == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.asset_zpack_path);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.word_info_gz_path == null) {
//            throw new C2101g("Required field 'word_info_gz_path' was not present! Struct: " + toString());
//        } else if (this.asset_zpack_path == null) {
//            throw new C2101g("Required field 'asset_zpack_path' was not present! Struct: " + toString());
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
