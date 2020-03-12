//package com.baicizhan.online.bs_users;
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
//public class BBUserWordMedia implements Serializable, Cloneable, Comparable<BBUserWordMedia>, C2116f<BBUserWordMedia, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b FM_VIEW_TIMES_FIELD_DESC = new C2097b("fm_view_times", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_FM_SKIP_FIELD_DESC = new C2097b("is_fm_skip", 2, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_TV_SKIP_FIELD_DESC = new C2097b("is_tv_skip", 2, 4);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserWordMedia");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b TV_VIEW_TIMES_FIELD_DESC = new C2097b("tv_view_times", 8, 2);
//    private static final int __FM_VIEW_TIMES_ISSET_ID = 2;
//    private static final int __IS_FM_SKIP_ISSET_ID = 4;
//    private static final int __IS_TV_SKIP_ISSET_ID = 3;
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    private static final int __TV_VIEW_TIMES_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int fm_view_times;
//    public boolean is_fm_skip;
//    public boolean is_tv_skip;
//    private _Fields[] optionals;
//    public int topic_id;
//    public int tv_view_times;
//
//    class BBUserWordMediaStandardScheme extends C2110c<BBUserWordMedia> {
//        private BBUserWordMediaStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserWordMedia bBUserWordMedia) {
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
//                                bBUserWordMedia.topic_id = fVar.mo18513n();
//                                bBUserWordMedia.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserWordMedia.tv_view_times = fVar.mo18513n();
//                                bBUserWordMedia.setTv_view_timesIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserWordMedia.fm_view_times = fVar.mo18513n();
//                                bBUserWordMedia.setFm_view_timesIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 2) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserWordMedia.is_tv_skip = fVar.mo18510k();
//                                bBUserWordMedia.setIs_tv_skipIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 2) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserWordMedia.is_fm_skip = fVar.mo18510k();
//                                bBUserWordMedia.setIs_fm_skipIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBUserWordMedia.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserWordMedia.isSetTv_view_times()) {
//                        throw new C2101g("Required field 'tv_view_times' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserWordMedia.isSetFm_view_times()) {
//                        throw new C2101g("Required field 'fm_view_times' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBUserWordMedia.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserWordMedia bBUserWordMedia) {
//            bBUserWordMedia.validate();
//            BBUserWordMedia.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBUserWordMedia.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBUserWordMedia.topic_id);
//            fVar.mo18496a(BBUserWordMedia.TV_VIEW_TIMES_FIELD_DESC);
//            fVar.mo18493a(bBUserWordMedia.tv_view_times);
//            fVar.mo18496a(BBUserWordMedia.FM_VIEW_TIMES_FIELD_DESC);
//            fVar.mo18493a(bBUserWordMedia.fm_view_times);
//            if (bBUserWordMedia.isSetIs_tv_skip()) {
//                fVar.mo18496a(BBUserWordMedia.IS_TV_SKIP_FIELD_DESC);
//                fVar.mo18500a(bBUserWordMedia.is_tv_skip);
//            }
//            if (bBUserWordMedia.isSetIs_fm_skip()) {
//                fVar.mo18496a(BBUserWordMedia.IS_FM_SKIP_FIELD_DESC);
//                fVar.mo18500a(bBUserWordMedia.is_fm_skip);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserWordMediaStandardSchemeFactory implements C2109b {
//        private BBUserWordMediaStandardSchemeFactory() {
//        }
//
//        public BBUserWordMediaStandardScheme getScheme() {
//            return new BBUserWordMediaStandardScheme();
//        }
//    }
//
//    class BBUserWordMediaTupleScheme extends C2111d<BBUserWordMedia> {
//        private BBUserWordMediaTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserWordMedia bBUserWordMedia) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBUserWordMedia.topic_id);
//            lVar.mo18493a(bBUserWordMedia.tv_view_times);
//            lVar.mo18493a(bBUserWordMedia.fm_view_times);
//            BitSet bitSet = new BitSet();
//            if (bBUserWordMedia.isSetIs_tv_skip()) {
//                bitSet.set(0);
//            }
//            if (bBUserWordMedia.isSetIs_fm_skip()) {
//                bitSet.set(1);
//            }
//            lVar.mo18527a(bitSet, 2);
//            if (bBUserWordMedia.isSetIs_tv_skip()) {
//                lVar.mo18500a(bBUserWordMedia.is_tv_skip);
//            }
//            if (bBUserWordMedia.isSetIs_fm_skip()) {
//                lVar.mo18500a(bBUserWordMedia.is_fm_skip);
//            }
//        }
//
//        public void read(C2100f fVar, BBUserWordMedia bBUserWordMedia) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserWordMedia.topic_id = lVar.mo18513n();
//            bBUserWordMedia.setTopic_idIsSet(true);
//            bBUserWordMedia.tv_view_times = lVar.mo18513n();
//            bBUserWordMedia.setTv_view_timesIsSet(true);
//            bBUserWordMedia.fm_view_times = lVar.mo18513n();
//            bBUserWordMedia.setFm_view_timesIsSet(true);
//            BitSet b = lVar.mo18528b(2);
//            if (b.get(0)) {
//                bBUserWordMedia.is_tv_skip = lVar.mo18510k();
//                bBUserWordMedia.setIs_tv_skipIsSet(true);
//            }
//            if (b.get(1)) {
//                bBUserWordMedia.is_fm_skip = lVar.mo18510k();
//                bBUserWordMedia.setIs_fm_skipIsSet(true);
//            }
//        }
//    }
//
//    class BBUserWordMediaTupleSchemeFactory implements C2109b {
//        private BBUserWordMediaTupleSchemeFactory() {
//        }
//
//        public BBUserWordMediaTupleScheme getScheme() {
//            return new BBUserWordMediaTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        TV_VIEW_TIMES(2, "tv_view_times"),
//        FM_VIEW_TIMES(3, "fm_view_times"),
//        IS_TV_SKIP(4, "is_tv_skip"),
//        IS_FM_SKIP(5, "is_fm_skip");
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
//                    return TV_VIEW_TIMES;
//                case 3:
//                    return FM_VIEW_TIMES;
//                case 4:
//                    return IS_TV_SKIP;
//                case 5:
//                    return IS_FM_SKIP;
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
//        hashMap.put(C2110c.class, new BBUserWordMediaStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserWordMediaTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.TV_VIEW_TIMES, new C2091a("tv_view_times", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.FM_VIEW_TIMES, new C2091a("fm_view_times", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.IS_TV_SKIP, new C2091a("is_tv_skip", 2, new C2092b(2, 0)));
//        enumMap.put(_Fields.IS_FM_SKIP, new C2091a("is_fm_skip", 2, new C2092b(2, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserWordMedia.class, metaDataMap);
//    }
//
//    public BBUserWordMedia() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.IS_TV_SKIP, _Fields.IS_FM_SKIP};
//    }
//
//    public BBUserWordMedia(int i, int i2, int i3) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.tv_view_times = i2;
//        setTv_view_timesIsSet(true);
//        this.fm_view_times = i3;
//        setFm_view_timesIsSet(true);
//    }
//
//    public BBUserWordMedia(BBUserWordMedia bBUserWordMedia) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.IS_TV_SKIP, _Fields.IS_FM_SKIP};
//        this.__isset_bitfield = bBUserWordMedia.__isset_bitfield;
//        this.topic_id = bBUserWordMedia.topic_id;
//        this.tv_view_times = bBUserWordMedia.tv_view_times;
//        this.fm_view_times = bBUserWordMedia.fm_view_times;
//        this.is_tv_skip = bBUserWordMedia.is_tv_skip;
//        this.is_fm_skip = bBUserWordMedia.is_fm_skip;
//    }
//
//    public BBUserWordMedia deepCopy() {
//        return new BBUserWordMedia(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        setTv_view_timesIsSet(false);
//        this.tv_view_times = 0;
//        setFm_view_timesIsSet(false);
//        this.fm_view_times = 0;
//        setIs_tv_skipIsSet(false);
//        this.is_tv_skip = false;
//        setIs_fm_skipIsSet(false);
//        this.is_fm_skip = false;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBUserWordMedia setTopic_id(int i) {
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
//    public int getTv_view_times() {
//        return this.tv_view_times;
//    }
//
//    public BBUserWordMedia setTv_view_times(int i) {
//        this.tv_view_times = i;
//        setTv_view_timesIsSet(true);
//        return this;
//    }
//
//    public void unsetTv_view_times() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetTv_view_times() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setTv_view_timesIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getFm_view_times() {
//        return this.fm_view_times;
//    }
//
//    public BBUserWordMedia setFm_view_times(int i) {
//        this.fm_view_times = i;
//        setFm_view_timesIsSet(true);
//        return this;
//    }
//
//    public void unsetFm_view_times() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetFm_view_times() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setFm_view_timesIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public boolean isIs_tv_skip() {
//        return this.is_tv_skip;
//    }
//
//    public BBUserWordMedia setIs_tv_skip(boolean z) {
//        this.is_tv_skip = z;
//        setIs_tv_skipIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_tv_skip() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetIs_tv_skip() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setIs_tv_skipIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public boolean isIs_fm_skip() {
//        return this.is_fm_skip;
//    }
//
//    public BBUserWordMedia setIs_fm_skip(boolean z) {
//        this.is_fm_skip = z;
//        setIs_fm_skipIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_fm_skip() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetIs_fm_skip() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setIs_fm_skipIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 4, z);
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
//            case TV_VIEW_TIMES:
//                if (obj == null) {
//                    unsetTv_view_times();
//                    return;
//                } else {
//                    setTv_view_times(((Integer) obj).intValue());
//                    return;
//                }
//            case FM_VIEW_TIMES:
//                if (obj == null) {
//                    unsetFm_view_times();
//                    return;
//                } else {
//                    setFm_view_times(((Integer) obj).intValue());
//                    return;
//                }
//            case IS_TV_SKIP:
//                if (obj == null) {
//                    unsetIs_tv_skip();
//                    return;
//                } else {
//                    setIs_tv_skip(((Boolean) obj).booleanValue());
//                    return;
//                }
//            case IS_FM_SKIP:
//                if (obj == null) {
//                    unsetIs_fm_skip();
//                    return;
//                } else {
//                    setIs_fm_skip(((Boolean) obj).booleanValue());
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
//            case TV_VIEW_TIMES:
//                return Integer.valueOf(getTv_view_times());
//            case FM_VIEW_TIMES:
//                return Integer.valueOf(getFm_view_times());
//            case IS_TV_SKIP:
//                return Boolean.valueOf(isIs_tv_skip());
//            case IS_FM_SKIP:
//                return Boolean.valueOf(isIs_fm_skip());
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
//            case TV_VIEW_TIMES:
//                return isSetTv_view_times();
//            case FM_VIEW_TIMES:
//                return isSetFm_view_times();
//            case IS_TV_SKIP:
//                return isSetIs_tv_skip();
//            case IS_FM_SKIP:
//                return isSetIs_fm_skip();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBUserWordMedia)) {
//            return equals((BBUserWordMedia) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserWordMedia bBUserWordMedia) {
//        if (bBUserWordMedia == null || this.topic_id != bBUserWordMedia.topic_id || this.tv_view_times != bBUserWordMedia.tv_view_times || this.fm_view_times != bBUserWordMedia.fm_view_times) {
//            return false;
//        }
//        boolean isSetIs_tv_skip = isSetIs_tv_skip();
//        boolean isSetIs_tv_skip2 = bBUserWordMedia.isSetIs_tv_skip();
//        if ((isSetIs_tv_skip || isSetIs_tv_skip2) && (!isSetIs_tv_skip || !isSetIs_tv_skip2 || this.is_tv_skip != bBUserWordMedia.is_tv_skip)) {
//            return false;
//        }
//        boolean isSetIs_fm_skip = isSetIs_fm_skip();
//        boolean isSetIs_fm_skip2 = bBUserWordMedia.isSetIs_fm_skip();
//        if ((isSetIs_fm_skip || isSetIs_fm_skip2) && (!isSetIs_fm_skip || !isSetIs_fm_skip2 || this.is_fm_skip != bBUserWordMedia.is_fm_skip)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserWordMedia bBUserWordMedia) {
//        if (!getClass().equals(bBUserWordMedia.getClass())) {
//            return getClass().getName().compareTo(bBUserWordMedia.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBUserWordMedia.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBUserWordMedia.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetTv_view_times()).compareTo(Boolean.valueOf(bBUserWordMedia.isSetTv_view_times()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetTv_view_times()) {
//            int a2 = C2121h.m5522a(this.tv_view_times, bBUserWordMedia.tv_view_times);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetFm_view_times()).compareTo(Boolean.valueOf(bBUserWordMedia.isSetFm_view_times()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetFm_view_times()) {
//            int a3 = C2121h.m5522a(this.fm_view_times, bBUserWordMedia.fm_view_times);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetIs_tv_skip()).compareTo(Boolean.valueOf(bBUserWordMedia.isSetIs_tv_skip()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetIs_tv_skip()) {
//            int a4 = C2121h.m5529a(this.is_tv_skip, bBUserWordMedia.is_tv_skip);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetIs_fm_skip()).compareTo(Boolean.valueOf(bBUserWordMedia.isSetIs_fm_skip()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetIs_fm_skip()) {
//            int a5 = C2121h.m5529a(this.is_fm_skip, bBUserWordMedia.is_fm_skip);
//            if (a5 != 0) {
//                return a5;
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
//        StringBuilder sb = new StringBuilder("BBUserWordMedia(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("tv_view_times:");
//        sb.append(this.tv_view_times);
//        sb.append(", ");
//        sb.append("fm_view_times:");
//        sb.append(this.fm_view_times);
//        if (isSetIs_tv_skip()) {
//            sb.append(", ");
//            sb.append("is_tv_skip:");
//            sb.append(this.is_tv_skip);
//        }
//        if (isSetIs_fm_skip()) {
//            sb.append(", ");
//            sb.append("is_fm_skip:");
//            sb.append(this.is_fm_skip);
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
