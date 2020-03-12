//package com.baicizhan.online.bs_words;
//
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
//public class BBWordMediaUpdateInfo implements Serializable, Cloneable, Comparable<BBWordMediaUpdateInfo>, C2116f<BBWordMediaUpdateInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b FM_UPDATED_AT_FIELD_DESC = new C2097b("fm_updated_at", 10, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordMediaUpdateInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b TV_UPDATED_AT_FIELD_DESC = new C2097b("tv_updated_at", 10, 3);
//    private static final int __FM_UPDATED_AT_ISSET_ID = 1;
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    private static final int __TV_UPDATED_AT_ISSET_ID = 2;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public long fm_updated_at;
//    private _Fields[] optionals;
//    public int topic_id;
//    public long tv_updated_at;
//
//    class BBWordMediaUpdateInfoStandardScheme extends C2110c<BBWordMediaUpdateInfo> {
//        private BBWordMediaUpdateInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordMediaUpdateInfo bBWordMediaUpdateInfo) {
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
//                                bBWordMediaUpdateInfo.topic_id = fVar.mo18513n();
//                                bBWordMediaUpdateInfo.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMediaUpdateInfo.fm_updated_at = fVar.mo18514o();
//                                bBWordMediaUpdateInfo.setFm_updated_atIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMediaUpdateInfo.tv_updated_at = fVar.mo18514o();
//                                bBWordMediaUpdateInfo.setTv_updated_atIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBWordMediaUpdateInfo.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBWordMediaUpdateInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordMediaUpdateInfo bBWordMediaUpdateInfo) {
//            bBWordMediaUpdateInfo.validate();
//            BBWordMediaUpdateInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBWordMediaUpdateInfo.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordMediaUpdateInfo.topic_id);
//            if (bBWordMediaUpdateInfo.isSetFm_updated_at()) {
//                fVar.mo18496a(BBWordMediaUpdateInfo.FM_UPDATED_AT_FIELD_DESC);
//                fVar.mo18494a(bBWordMediaUpdateInfo.fm_updated_at);
//            }
//            if (bBWordMediaUpdateInfo.isSetTv_updated_at()) {
//                fVar.mo18496a(BBWordMediaUpdateInfo.TV_UPDATED_AT_FIELD_DESC);
//                fVar.mo18494a(bBWordMediaUpdateInfo.tv_updated_at);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordMediaUpdateInfoStandardSchemeFactory implements C2109b {
//        private BBWordMediaUpdateInfoStandardSchemeFactory() {
//        }
//
//        public BBWordMediaUpdateInfoStandardScheme getScheme() {
//            return new BBWordMediaUpdateInfoStandardScheme();
//        }
//    }
//
//    class BBWordMediaUpdateInfoTupleScheme extends C2111d<BBWordMediaUpdateInfo> {
//        private BBWordMediaUpdateInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordMediaUpdateInfo bBWordMediaUpdateInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBWordMediaUpdateInfo.topic_id);
//            BitSet bitSet = new BitSet();
//            if (bBWordMediaUpdateInfo.isSetFm_updated_at()) {
//                bitSet.set(0);
//            }
//            if (bBWordMediaUpdateInfo.isSetTv_updated_at()) {
//                bitSet.set(1);
//            }
//            lVar.mo18527a(bitSet, 2);
//            if (bBWordMediaUpdateInfo.isSetFm_updated_at()) {
//                lVar.mo18494a(bBWordMediaUpdateInfo.fm_updated_at);
//            }
//            if (bBWordMediaUpdateInfo.isSetTv_updated_at()) {
//                lVar.mo18494a(bBWordMediaUpdateInfo.tv_updated_at);
//            }
//        }
//
//        public void read(C2100f fVar, BBWordMediaUpdateInfo bBWordMediaUpdateInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBWordMediaUpdateInfo.topic_id = lVar.mo18513n();
//            bBWordMediaUpdateInfo.setTopic_idIsSet(true);
//            BitSet b = lVar.mo18528b(2);
//            if (b.get(0)) {
//                bBWordMediaUpdateInfo.fm_updated_at = lVar.mo18514o();
//                bBWordMediaUpdateInfo.setFm_updated_atIsSet(true);
//            }
//            if (b.get(1)) {
//                bBWordMediaUpdateInfo.tv_updated_at = lVar.mo18514o();
//                bBWordMediaUpdateInfo.setTv_updated_atIsSet(true);
//            }
//        }
//    }
//
//    class BBWordMediaUpdateInfoTupleSchemeFactory implements C2109b {
//        private BBWordMediaUpdateInfoTupleSchemeFactory() {
//        }
//
//        public BBWordMediaUpdateInfoTupleScheme getScheme() {
//            return new BBWordMediaUpdateInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        FM_UPDATED_AT(2, "fm_updated_at"),
//        TV_UPDATED_AT(3, "tv_updated_at");
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
//                    return FM_UPDATED_AT;
//                case 3:
//                    return TV_UPDATED_AT;
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
//        hashMap.put(C2110c.class, new BBWordMediaUpdateInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordMediaUpdateInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.FM_UPDATED_AT, new C2091a("fm_updated_at", 2, new C2092b(10, 0)));
//        enumMap.put(_Fields.TV_UPDATED_AT, new C2091a("tv_updated_at", 2, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordMediaUpdateInfo.class, metaDataMap);
//    }
//
//    public BBWordMediaUpdateInfo() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.FM_UPDATED_AT, _Fields.TV_UPDATED_AT};
//    }
//
//    public BBWordMediaUpdateInfo(int i) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//    }
//
//    public BBWordMediaUpdateInfo(BBWordMediaUpdateInfo bBWordMediaUpdateInfo) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.FM_UPDATED_AT, _Fields.TV_UPDATED_AT};
//        this.__isset_bitfield = bBWordMediaUpdateInfo.__isset_bitfield;
//        this.topic_id = bBWordMediaUpdateInfo.topic_id;
//        this.fm_updated_at = bBWordMediaUpdateInfo.fm_updated_at;
//        this.tv_updated_at = bBWordMediaUpdateInfo.tv_updated_at;
//    }
//
//    public BBWordMediaUpdateInfo deepCopy() {
//        return new BBWordMediaUpdateInfo(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        setFm_updated_atIsSet(false);
//        this.fm_updated_at = 0;
//        setTv_updated_atIsSet(false);
//        this.tv_updated_at = 0;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBWordMediaUpdateInfo setTopic_id(int i) {
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
//    public long getFm_updated_at() {
//        return this.fm_updated_at;
//    }
//
//    public BBWordMediaUpdateInfo setFm_updated_at(long j) {
//        this.fm_updated_at = j;
//        setFm_updated_atIsSet(true);
//        return this;
//    }
//
//    public void unsetFm_updated_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetFm_updated_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setFm_updated_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public long getTv_updated_at() {
//        return this.tv_updated_at;
//    }
//
//    public BBWordMediaUpdateInfo setTv_updated_at(long j) {
//        this.tv_updated_at = j;
//        setTv_updated_atIsSet(true);
//        return this;
//    }
//
//    public void unsetTv_updated_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetTv_updated_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setTv_updated_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
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
//            case FM_UPDATED_AT:
//                if (obj == null) {
//                    unsetFm_updated_at();
//                    return;
//                } else {
//                    setFm_updated_at(((Long) obj).longValue());
//                    return;
//                }
//            case TV_UPDATED_AT:
//                if (obj == null) {
//                    unsetTv_updated_at();
//                    return;
//                } else {
//                    setTv_updated_at(((Long) obj).longValue());
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
//            case FM_UPDATED_AT:
//                return Long.valueOf(getFm_updated_at());
//            case TV_UPDATED_AT:
//                return Long.valueOf(getTv_updated_at());
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
//            case FM_UPDATED_AT:
//                return isSetFm_updated_at();
//            case TV_UPDATED_AT:
//                return isSetTv_updated_at();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordMediaUpdateInfo)) {
//            return equals((BBWordMediaUpdateInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordMediaUpdateInfo bBWordMediaUpdateInfo) {
//        if (bBWordMediaUpdateInfo == null || this.topic_id != bBWordMediaUpdateInfo.topic_id) {
//            return false;
//        }
//        boolean isSetFm_updated_at = isSetFm_updated_at();
//        boolean isSetFm_updated_at2 = bBWordMediaUpdateInfo.isSetFm_updated_at();
//        if ((isSetFm_updated_at || isSetFm_updated_at2) && (!isSetFm_updated_at || !isSetFm_updated_at2 || this.fm_updated_at != bBWordMediaUpdateInfo.fm_updated_at)) {
//            return false;
//        }
//        boolean isSetTv_updated_at = isSetTv_updated_at();
//        boolean isSetTv_updated_at2 = bBWordMediaUpdateInfo.isSetTv_updated_at();
//        if ((isSetTv_updated_at || isSetTv_updated_at2) && (!isSetTv_updated_at || !isSetTv_updated_at2 || this.tv_updated_at != bBWordMediaUpdateInfo.tv_updated_at)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordMediaUpdateInfo bBWordMediaUpdateInfo) {
//        if (!getClass().equals(bBWordMediaUpdateInfo.getClass())) {
//            return getClass().getName().compareTo(bBWordMediaUpdateInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBWordMediaUpdateInfo.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBWordMediaUpdateInfo.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetFm_updated_at()).compareTo(Boolean.valueOf(bBWordMediaUpdateInfo.isSetFm_updated_at()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetFm_updated_at()) {
//            int a2 = C2121h.m5523a(this.fm_updated_at, bBWordMediaUpdateInfo.fm_updated_at);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetTv_updated_at()).compareTo(Boolean.valueOf(bBWordMediaUpdateInfo.isSetTv_updated_at()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetTv_updated_at()) {
//            int a3 = C2121h.m5523a(this.tv_updated_at, bBWordMediaUpdateInfo.tv_updated_at);
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
//        StringBuilder sb = new StringBuilder("BBWordMediaUpdateInfo(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        if (isSetFm_updated_at()) {
//            sb.append(", ");
//            sb.append("fm_updated_at:");
//            sb.append(this.fm_updated_at);
//        }
//        if (isSetTv_updated_at()) {
//            sb.append(", ");
//            sb.append("tv_updated_at:");
//            sb.append(this.tv_updated_at);
//        }
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
