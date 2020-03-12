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
//public class BBWordTopicAsset implements Serializable, Cloneable, Comparable<BBWordTopicAsset>, C2116f<BBWordTopicAsset, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b ASSET_ZPK_PATH_FIELD_DESC = new C2097b("asset_zpk_path", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordTopicAsset");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String asset_zpk_path;
//    public int topic_id;
//
//    class BBWordTopicAssetStandardScheme extends C2110c<BBWordTopicAsset> {
//        private BBWordTopicAssetStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordTopicAsset bBWordTopicAsset) {
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
//                                bBWordTopicAsset.topic_id = fVar.mo18513n();
//                                bBWordTopicAsset.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordTopicAsset.asset_zpk_path = fVar.mo18516q();
//                                bBWordTopicAsset.setAsset_zpk_pathIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBWordTopicAsset.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBWordTopicAsset.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordTopicAsset bBWordTopicAsset) {
//            bBWordTopicAsset.validate();
//            BBWordTopicAsset.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBWordTopicAsset.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordTopicAsset.topic_id);
//            if (bBWordTopicAsset.asset_zpk_path != null) {
//                fVar.mo18496a(BBWordTopicAsset.ASSET_ZPK_PATH_FIELD_DESC);
//                fVar.mo18495a(bBWordTopicAsset.asset_zpk_path);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordTopicAssetStandardSchemeFactory implements C2109b {
//        private BBWordTopicAssetStandardSchemeFactory() {
//        }
//
//        public BBWordTopicAssetStandardScheme getScheme() {
//            return new BBWordTopicAssetStandardScheme();
//        }
//    }
//
//    class BBWordTopicAssetTupleScheme extends C2111d<BBWordTopicAsset> {
//        private BBWordTopicAssetTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordTopicAsset bBWordTopicAsset) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBWordTopicAsset.topic_id);
//            lVar.mo18495a(bBWordTopicAsset.asset_zpk_path);
//        }
//
//        public void read(C2100f fVar, BBWordTopicAsset bBWordTopicAsset) {
//            C2106l lVar = (C2106l) fVar;
//            bBWordTopicAsset.topic_id = lVar.mo18513n();
//            bBWordTopicAsset.setTopic_idIsSet(true);
//            bBWordTopicAsset.asset_zpk_path = lVar.mo18516q();
//            bBWordTopicAsset.setAsset_zpk_pathIsSet(true);
//        }
//    }
//
//    class BBWordTopicAssetTupleSchemeFactory implements C2109b {
//        private BBWordTopicAssetTupleSchemeFactory() {
//        }
//
//        public BBWordTopicAssetTupleScheme getScheme() {
//            return new BBWordTopicAssetTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        ASSET_ZPK_PATH(2, "asset_zpk_path");
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
//                    return ASSET_ZPK_PATH;
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
//        hashMap.put(C2110c.class, new BBWordTopicAssetStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordTopicAssetTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.ASSET_ZPK_PATH, new C2091a("asset_zpk_path", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordTopicAsset.class, metaDataMap);
//    }
//
//    public BBWordTopicAsset() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBWordTopicAsset(int i, String str) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.asset_zpk_path = str;
//    }
//
//    public BBWordTopicAsset(BBWordTopicAsset bBWordTopicAsset) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBWordTopicAsset.__isset_bitfield;
//        this.topic_id = bBWordTopicAsset.topic_id;
//        if (bBWordTopicAsset.isSetAsset_zpk_path()) {
//            this.asset_zpk_path = bBWordTopicAsset.asset_zpk_path;
//        }
//    }
//
//    public BBWordTopicAsset deepCopy() {
//        return new BBWordTopicAsset(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        this.asset_zpk_path = null;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBWordTopicAsset setTopic_id(int i) {
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
//    public String getAsset_zpk_path() {
//        return this.asset_zpk_path;
//    }
//
//    public BBWordTopicAsset setAsset_zpk_path(String str) {
//        this.asset_zpk_path = str;
//        return this;
//    }
//
//    public void unsetAsset_zpk_path() {
//        this.asset_zpk_path = null;
//    }
//
//    public boolean isSetAsset_zpk_path() {
//        return this.asset_zpk_path != null;
//    }
//
//    public void setAsset_zpk_pathIsSet(boolean z) {
//        if (!z) {
//            this.asset_zpk_path = null;
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
//            case ASSET_ZPK_PATH:
//                if (obj == null) {
//                    unsetAsset_zpk_path();
//                    return;
//                } else {
//                    setAsset_zpk_path((String) obj);
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
//            case ASSET_ZPK_PATH:
//                return getAsset_zpk_path();
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
//            case ASSET_ZPK_PATH:
//                return isSetAsset_zpk_path();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordTopicAsset)) {
//            return equals((BBWordTopicAsset) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordTopicAsset bBWordTopicAsset) {
//        if (bBWordTopicAsset == null || this.topic_id != bBWordTopicAsset.topic_id) {
//            return false;
//        }
//        boolean isSetAsset_zpk_path = isSetAsset_zpk_path();
//        boolean isSetAsset_zpk_path2 = bBWordTopicAsset.isSetAsset_zpk_path();
//        if ((isSetAsset_zpk_path || isSetAsset_zpk_path2) && (!isSetAsset_zpk_path || !isSetAsset_zpk_path2 || !this.asset_zpk_path.equals(bBWordTopicAsset.asset_zpk_path))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordTopicAsset bBWordTopicAsset) {
//        if (!getClass().equals(bBWordTopicAsset.getClass())) {
//            return getClass().getName().compareTo(bBWordTopicAsset.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBWordTopicAsset.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBWordTopicAsset.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetAsset_zpk_path()).compareTo(Boolean.valueOf(bBWordTopicAsset.isSetAsset_zpk_path()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetAsset_zpk_path()) {
//            int a2 = C2121h.m5525a(this.asset_zpk_path, bBWordTopicAsset.asset_zpk_path);
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
//        StringBuilder sb = new StringBuilder("BBWordTopicAsset(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("asset_zpk_path:");
//        if (this.asset_zpk_path == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.asset_zpk_path);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.asset_zpk_path == null) {
//            throw new C2101g("Required field 'asset_zpk_path' was not present! Struct: " + toString());
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
