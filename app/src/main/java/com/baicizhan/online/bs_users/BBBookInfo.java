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
//public class BBBookInfo implements Serializable, Cloneable, Comparable<BBBookInfo>, C2116f<BBBookInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b COUNT_OF_LEARNED_WORDS_FIELD_DESC = new C2097b("count_of_learned_words", 8, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b ID_FIELD_DESC = new C2097b(Columns.f2234ID, 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b LAST_TOUCH_AT_FIELD_DESC = new C2097b("last_touch_at", 10, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b NAME_CN_FIELD_DESC = new C2097b("name_cn", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b ROADMAP_VERSION_FIELD_DESC = new C2097b("roadmap_version", 10, 8);
//    /* access modifiers changed from: private */
//    public static final C2097b SELECTED_END_TIME_FIELD_DESC = new C2097b("selected_end_time", 10, 5);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBBookInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TOTAL_WORDS_FIELD_DESC = new C2097b("total_words", 8, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATED_AT_FIELD_DESC = new C2097b("updated_at", 10, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FM_UPDATED_AT_FIELD_DESC = new C2097b("word_fm_updated_at", 10, 9);
//    private static final int __COUNT_OF_LEARNED_WORDS_ISSET_ID = 2;
//    private static final int __ID_ISSET_ID = 0;
//    private static final int __LAST_TOUCH_AT_ISSET_ID = 4;
//    private static final int __ROADMAP_VERSION_ISSET_ID = 6;
//    private static final int __SELECTED_END_TIME_ISSET_ID = 3;
//    private static final int __TOTAL_WORDS_ISSET_ID = 5;
//    private static final int __UPDATED_AT_ISSET_ID = 1;
//    private static final int __WORD_FM_UPDATED_AT_ISSET_ID = 7;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int count_of_learned_words;
//
//    /* renamed from: id */
//    public int f2408id;
//    public long last_touch_at;
//    public String name_cn;
//    public long roadmap_version;
//    public long selected_end_time;
//    public int total_words;
//    public long updated_at;
//    public long word_fm_updated_at;
//
//    class BBBookInfoStandardScheme extends C2110c<BBBookInfo> {
//        private BBBookInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBBookInfo bBBookInfo) {
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
//                                bBBookInfo.f2408id = fVar.mo18513n();
//                                bBBookInfo.setIdIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookInfo.name_cn = fVar.mo18516q();
//                                bBBookInfo.setName_cnIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookInfo.updated_at = fVar.mo18514o();
//                                bBBookInfo.setUpdated_atIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookInfo.count_of_learned_words = fVar.mo18513n();
//                                bBBookInfo.setCount_of_learned_wordsIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookInfo.selected_end_time = fVar.mo18514o();
//                                bBBookInfo.setSelected_end_timeIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookInfo.last_touch_at = fVar.mo18514o();
//                                bBBookInfo.setLast_touch_atIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookInfo.total_words = fVar.mo18513n();
//                                bBBookInfo.setTotal_wordsIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookInfo.roadmap_version = fVar.mo18514o();
//                                bBBookInfo.setRoadmap_versionIsSet(true);
//                                break;
//                            }
//                        case 9:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBookInfo.word_fm_updated_at = fVar.mo18514o();
//                                bBBookInfo.setWord_fm_updated_atIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBBookInfo.isSetId()) {
//                        throw new C2101g("Required field 'id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBBookInfo.isSetUpdated_at()) {
//                        throw new C2101g("Required field 'updated_at' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBBookInfo.isSetCount_of_learned_words()) {
//                        throw new C2101g("Required field 'count_of_learned_words' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBBookInfo.isSetSelected_end_time()) {
//                        throw new C2101g("Required field 'selected_end_time' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBBookInfo.isSetLast_touch_at()) {
//                        throw new C2101g("Required field 'last_touch_at' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBBookInfo.isSetTotal_words()) {
//                        throw new C2101g("Required field 'total_words' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBBookInfo.isSetRoadmap_version()) {
//                        throw new C2101g("Required field 'roadmap_version' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBBookInfo.isSetWord_fm_updated_at()) {
//                        throw new C2101g("Required field 'word_fm_updated_at' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBBookInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBBookInfo bBBookInfo) {
//            bBBookInfo.validate();
//            BBBookInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBBookInfo.ID_FIELD_DESC);
//            fVar.mo18493a(bBBookInfo.f2408id);
//            if (bBBookInfo.name_cn != null) {
//                fVar.mo18496a(BBBookInfo.NAME_CN_FIELD_DESC);
//                fVar.mo18495a(bBBookInfo.name_cn);
//            }
//            fVar.mo18496a(BBBookInfo.UPDATED_AT_FIELD_DESC);
//            fVar.mo18494a(bBBookInfo.updated_at);
//            fVar.mo18496a(BBBookInfo.COUNT_OF_LEARNED_WORDS_FIELD_DESC);
//            fVar.mo18493a(bBBookInfo.count_of_learned_words);
//            fVar.mo18496a(BBBookInfo.SELECTED_END_TIME_FIELD_DESC);
//            fVar.mo18494a(bBBookInfo.selected_end_time);
//            fVar.mo18496a(BBBookInfo.LAST_TOUCH_AT_FIELD_DESC);
//            fVar.mo18494a(bBBookInfo.last_touch_at);
//            fVar.mo18496a(BBBookInfo.TOTAL_WORDS_FIELD_DESC);
//            fVar.mo18493a(bBBookInfo.total_words);
//            fVar.mo18496a(BBBookInfo.ROADMAP_VERSION_FIELD_DESC);
//            fVar.mo18494a(bBBookInfo.roadmap_version);
//            fVar.mo18496a(BBBookInfo.WORD_FM_UPDATED_AT_FIELD_DESC);
//            fVar.mo18494a(bBBookInfo.word_fm_updated_at);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBBookInfoStandardSchemeFactory implements C2109b {
//        private BBBookInfoStandardSchemeFactory() {
//        }
//
//        public BBBookInfoStandardScheme getScheme() {
//            return new BBBookInfoStandardScheme();
//        }
//    }
//
//    class BBBookInfoTupleScheme extends C2111d<BBBookInfo> {
//        private BBBookInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBBookInfo bBBookInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBBookInfo.f2408id);
//            lVar.mo18495a(bBBookInfo.name_cn);
//            lVar.mo18494a(bBBookInfo.updated_at);
//            lVar.mo18493a(bBBookInfo.count_of_learned_words);
//            lVar.mo18494a(bBBookInfo.selected_end_time);
//            lVar.mo18494a(bBBookInfo.last_touch_at);
//            lVar.mo18493a(bBBookInfo.total_words);
//            lVar.mo18494a(bBBookInfo.roadmap_version);
//            lVar.mo18494a(bBBookInfo.word_fm_updated_at);
//        }
//
//        public void read(C2100f fVar, BBBookInfo bBBookInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBBookInfo.f2408id = lVar.mo18513n();
//            bBBookInfo.setIdIsSet(true);
//            bBBookInfo.name_cn = lVar.mo18516q();
//            bBBookInfo.setName_cnIsSet(true);
//            bBBookInfo.updated_at = lVar.mo18514o();
//            bBBookInfo.setUpdated_atIsSet(true);
//            bBBookInfo.count_of_learned_words = lVar.mo18513n();
//            bBBookInfo.setCount_of_learned_wordsIsSet(true);
//            bBBookInfo.selected_end_time = lVar.mo18514o();
//            bBBookInfo.setSelected_end_timeIsSet(true);
//            bBBookInfo.last_touch_at = lVar.mo18514o();
//            bBBookInfo.setLast_touch_atIsSet(true);
//            bBBookInfo.total_words = lVar.mo18513n();
//            bBBookInfo.setTotal_wordsIsSet(true);
//            bBBookInfo.roadmap_version = lVar.mo18514o();
//            bBBookInfo.setRoadmap_versionIsSet(true);
//            bBBookInfo.word_fm_updated_at = lVar.mo18514o();
//            bBBookInfo.setWord_fm_updated_atIsSet(true);
//        }
//    }
//
//    class BBBookInfoTupleSchemeFactory implements C2109b {
//        private BBBookInfoTupleSchemeFactory() {
//        }
//
//        public BBBookInfoTupleScheme getScheme() {
//            return new BBBookInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        ID(1, Columns.f2234ID),
//        NAME_CN(2, "name_cn"),
//        UPDATED_AT(3, "updated_at"),
//        COUNT_OF_LEARNED_WORDS(4, "count_of_learned_words"),
//        SELECTED_END_TIME(5, "selected_end_time"),
//        LAST_TOUCH_AT(6, "last_touch_at"),
//        TOTAL_WORDS(7, "total_words"),
//        ROADMAP_VERSION(8, "roadmap_version"),
//        WORD_FM_UPDATED_AT(9, "word_fm_updated_at");
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
//                    return NAME_CN;
//                case 3:
//                    return UPDATED_AT;
//                case 4:
//                    return COUNT_OF_LEARNED_WORDS;
//                case 5:
//                    return SELECTED_END_TIME;
//                case 6:
//                    return LAST_TOUCH_AT;
//                case 7:
//                    return TOTAL_WORDS;
//                case 8:
//                    return ROADMAP_VERSION;
//                case 9:
//                    return WORD_FM_UPDATED_AT;
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
//        hashMap.put(C2110c.class, new BBBookInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBBookInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.ID, new C2091a(Columns.f2234ID, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.NAME_CN, new C2091a("name_cn", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.UPDATED_AT, new C2091a("updated_at", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.COUNT_OF_LEARNED_WORDS, new C2091a("count_of_learned_words", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SELECTED_END_TIME, new C2091a("selected_end_time", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.LAST_TOUCH_AT, new C2091a("last_touch_at", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.TOTAL_WORDS, new C2091a("total_words", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.ROADMAP_VERSION, new C2091a("roadmap_version", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.WORD_FM_UPDATED_AT, new C2091a("word_fm_updated_at", 1, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBBookInfo.class, metaDataMap);
//    }
//
//    public BBBookInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBBookInfo(int i, String str, long j, int i2, long j2, long j3, int i3, long j4, long j5) {
//        this();
//        this.f2408id = i;
//        setIdIsSet(true);
//        this.name_cn = str;
//        this.updated_at = j;
//        setUpdated_atIsSet(true);
//        this.count_of_learned_words = i2;
//        setCount_of_learned_wordsIsSet(true);
//        this.selected_end_time = j2;
//        setSelected_end_timeIsSet(true);
//        this.last_touch_at = j3;
//        setLast_touch_atIsSet(true);
//        this.total_words = i3;
//        setTotal_wordsIsSet(true);
//        this.roadmap_version = j4;
//        setRoadmap_versionIsSet(true);
//        this.word_fm_updated_at = j5;
//        setWord_fm_updated_atIsSet(true);
//    }
//
//    public BBBookInfo(BBBookInfo bBBookInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBBookInfo.__isset_bitfield;
//        this.f2408id = bBBookInfo.f2408id;
//        if (bBBookInfo.isSetName_cn()) {
//            this.name_cn = bBBookInfo.name_cn;
//        }
//        this.updated_at = bBBookInfo.updated_at;
//        this.count_of_learned_words = bBBookInfo.count_of_learned_words;
//        this.selected_end_time = bBBookInfo.selected_end_time;
//        this.last_touch_at = bBBookInfo.last_touch_at;
//        this.total_words = bBBookInfo.total_words;
//        this.roadmap_version = bBBookInfo.roadmap_version;
//        this.word_fm_updated_at = bBBookInfo.word_fm_updated_at;
//    }
//
//    public BBBookInfo deepCopy() {
//        return new BBBookInfo(this);
//    }
//
//    public void clear() {
//        setIdIsSet(false);
//        this.f2408id = 0;
//        this.name_cn = null;
//        setUpdated_atIsSet(false);
//        this.updated_at = 0;
//        setCount_of_learned_wordsIsSet(false);
//        this.count_of_learned_words = 0;
//        setSelected_end_timeIsSet(false);
//        this.selected_end_time = 0;
//        setLast_touch_atIsSet(false);
//        this.last_touch_at = 0;
//        setTotal_wordsIsSet(false);
//        this.total_words = 0;
//        setRoadmap_versionIsSet(false);
//        this.roadmap_version = 0;
//        setWord_fm_updated_atIsSet(false);
//        this.word_fm_updated_at = 0;
//    }
//
//    public int getId() {
//        return this.f2408id;
//    }
//
//    public BBBookInfo setId(int i) {
//        this.f2408id = i;
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
//    public String getName_cn() {
//        return this.name_cn;
//    }
//
//    public BBBookInfo setName_cn(String str) {
//        this.name_cn = str;
//        return this;
//    }
//
//    public void unsetName_cn() {
//        this.name_cn = null;
//    }
//
//    public boolean isSetName_cn() {
//        return this.name_cn != null;
//    }
//
//    public void setName_cnIsSet(boolean z) {
//        if (!z) {
//            this.name_cn = null;
//        }
//    }
//
//    public long getUpdated_at() {
//        return this.updated_at;
//    }
//
//    public BBBookInfo setUpdated_at(long j) {
//        this.updated_at = j;
//        setUpdated_atIsSet(true);
//        return this;
//    }
//
//    public void unsetUpdated_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetUpdated_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setUpdated_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getCount_of_learned_words() {
//        return this.count_of_learned_words;
//    }
//
//    public BBBookInfo setCount_of_learned_words(int i) {
//        this.count_of_learned_words = i;
//        setCount_of_learned_wordsIsSet(true);
//        return this;
//    }
//
//    public void unsetCount_of_learned_words() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetCount_of_learned_words() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setCount_of_learned_wordsIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public long getSelected_end_time() {
//        return this.selected_end_time;
//    }
//
//    public BBBookInfo setSelected_end_time(long j) {
//        this.selected_end_time = j;
//        setSelected_end_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetSelected_end_time() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetSelected_end_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setSelected_end_timeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public long getLast_touch_at() {
//        return this.last_touch_at;
//    }
//
//    public BBBookInfo setLast_touch_at(long j) {
//        this.last_touch_at = j;
//        setLast_touch_atIsSet(true);
//        return this;
//    }
//
//    public void unsetLast_touch_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetLast_touch_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setLast_touch_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 4, z);
//    }
//
//    public int getTotal_words() {
//        return this.total_words;
//    }
//
//    public BBBookInfo setTotal_words(int i) {
//        this.total_words = i;
//        setTotal_wordsIsSet(true);
//        return this;
//    }
//
//    public void unsetTotal_words() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -33);
//    }
//
//    public boolean isSetTotal_words() {
//        return C2090b.m5429a(this.__isset_bitfield, 5);
//    }
//
//    public void setTotal_wordsIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 5, z);
//    }
//
//    public long getRoadmap_version() {
//        return this.roadmap_version;
//    }
//
//    public BBBookInfo setRoadmap_version(long j) {
//        this.roadmap_version = j;
//        setRoadmap_versionIsSet(true);
//        return this;
//    }
//
//    public void unsetRoadmap_version() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -65);
//    }
//
//    public boolean isSetRoadmap_version() {
//        return C2090b.m5429a(this.__isset_bitfield, 6);
//    }
//
//    public void setRoadmap_versionIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 6, z);
//    }
//
//    public long getWord_fm_updated_at() {
//        return this.word_fm_updated_at;
//    }
//
//    public BBBookInfo setWord_fm_updated_at(long j) {
//        this.word_fm_updated_at = j;
//        setWord_fm_updated_atIsSet(true);
//        return this;
//    }
//
//    public void unsetWord_fm_updated_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -129);
//    }
//
//    public boolean isSetWord_fm_updated_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 7);
//    }
//
//    public void setWord_fm_updated_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 7, z);
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
//            case NAME_CN:
//                if (obj == null) {
//                    unsetName_cn();
//                    return;
//                } else {
//                    setName_cn((String) obj);
//                    return;
//                }
//            case UPDATED_AT:
//                if (obj == null) {
//                    unsetUpdated_at();
//                    return;
//                } else {
//                    setUpdated_at(((Long) obj).longValue());
//                    return;
//                }
//            case COUNT_OF_LEARNED_WORDS:
//                if (obj == null) {
//                    unsetCount_of_learned_words();
//                    return;
//                } else {
//                    setCount_of_learned_words(((Integer) obj).intValue());
//                    return;
//                }
//            case SELECTED_END_TIME:
//                if (obj == null) {
//                    unsetSelected_end_time();
//                    return;
//                } else {
//                    setSelected_end_time(((Long) obj).longValue());
//                    return;
//                }
//            case LAST_TOUCH_AT:
//                if (obj == null) {
//                    unsetLast_touch_at();
//                    return;
//                } else {
//                    setLast_touch_at(((Long) obj).longValue());
//                    return;
//                }
//            case TOTAL_WORDS:
//                if (obj == null) {
//                    unsetTotal_words();
//                    return;
//                } else {
//                    setTotal_words(((Integer) obj).intValue());
//                    return;
//                }
//            case ROADMAP_VERSION:
//                if (obj == null) {
//                    unsetRoadmap_version();
//                    return;
//                } else {
//                    setRoadmap_version(((Long) obj).longValue());
//                    return;
//                }
//            case WORD_FM_UPDATED_AT:
//                if (obj == null) {
//                    unsetWord_fm_updated_at();
//                    return;
//                } else {
//                    setWord_fm_updated_at(((Long) obj).longValue());
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
//            case NAME_CN:
//                return getName_cn();
//            case UPDATED_AT:
//                return Long.valueOf(getUpdated_at());
//            case COUNT_OF_LEARNED_WORDS:
//                return Integer.valueOf(getCount_of_learned_words());
//            case SELECTED_END_TIME:
//                return Long.valueOf(getSelected_end_time());
//            case LAST_TOUCH_AT:
//                return Long.valueOf(getLast_touch_at());
//            case TOTAL_WORDS:
//                return Integer.valueOf(getTotal_words());
//            case ROADMAP_VERSION:
//                return Long.valueOf(getRoadmap_version());
//            case WORD_FM_UPDATED_AT:
//                return Long.valueOf(getWord_fm_updated_at());
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
//            case NAME_CN:
//                return isSetName_cn();
//            case UPDATED_AT:
//                return isSetUpdated_at();
//            case COUNT_OF_LEARNED_WORDS:
//                return isSetCount_of_learned_words();
//            case SELECTED_END_TIME:
//                return isSetSelected_end_time();
//            case LAST_TOUCH_AT:
//                return isSetLast_touch_at();
//            case TOTAL_WORDS:
//                return isSetTotal_words();
//            case ROADMAP_VERSION:
//                return isSetRoadmap_version();
//            case WORD_FM_UPDATED_AT:
//                return isSetWord_fm_updated_at();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBBookInfo)) {
//            return equals((BBBookInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBBookInfo bBBookInfo) {
//        if (bBBookInfo == null || this.f2408id != bBBookInfo.f2408id) {
//            return false;
//        }
//        boolean isSetName_cn = isSetName_cn();
//        boolean isSetName_cn2 = bBBookInfo.isSetName_cn();
//        if (((!isSetName_cn && !isSetName_cn2) || (isSetName_cn && isSetName_cn2 && this.name_cn.equals(bBBookInfo.name_cn))) && this.updated_at == bBBookInfo.updated_at && this.count_of_learned_words == bBBookInfo.count_of_learned_words && this.selected_end_time == bBBookInfo.selected_end_time && this.last_touch_at == bBBookInfo.last_touch_at && this.total_words == bBBookInfo.total_words && this.roadmap_version == bBBookInfo.roadmap_version && this.word_fm_updated_at == bBBookInfo.word_fm_updated_at) {
//            return true;
//        }
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBBookInfo bBBookInfo) {
//        if (!getClass().equals(bBBookInfo.getClass())) {
//            return getClass().getName().compareTo(bBBookInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetId()).compareTo(Boolean.valueOf(bBBookInfo.isSetId()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetId()) {
//            int a = C2121h.m5522a(this.f2408id, bBBookInfo.f2408id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetName_cn()).compareTo(Boolean.valueOf(bBBookInfo.isSetName_cn()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetName_cn()) {
//            int a2 = C2121h.m5525a(this.name_cn, bBBookInfo.name_cn);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetUpdated_at()).compareTo(Boolean.valueOf(bBBookInfo.isSetUpdated_at()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetUpdated_at()) {
//            int a3 = C2121h.m5523a(this.updated_at, bBBookInfo.updated_at);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetCount_of_learned_words()).compareTo(Boolean.valueOf(bBBookInfo.isSetCount_of_learned_words()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetCount_of_learned_words()) {
//            int a4 = C2121h.m5522a(this.count_of_learned_words, bBBookInfo.count_of_learned_words);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetSelected_end_time()).compareTo(Boolean.valueOf(bBBookInfo.isSetSelected_end_time()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetSelected_end_time()) {
//            int a5 = C2121h.m5523a(this.selected_end_time, bBBookInfo.selected_end_time);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetLast_touch_at()).compareTo(Boolean.valueOf(bBBookInfo.isSetLast_touch_at()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetLast_touch_at()) {
//            int a6 = C2121h.m5523a(this.last_touch_at, bBBookInfo.last_touch_at);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetTotal_words()).compareTo(Boolean.valueOf(bBBookInfo.isSetTotal_words()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetTotal_words()) {
//            int a7 = C2121h.m5522a(this.total_words, bBBookInfo.total_words);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetRoadmap_version()).compareTo(Boolean.valueOf(bBBookInfo.isSetRoadmap_version()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetRoadmap_version()) {
//            int a8 = C2121h.m5523a(this.roadmap_version, bBBookInfo.roadmap_version);
//            if (a8 != 0) {
//                return a8;
//            }
//        }
//        int compareTo9 = Boolean.valueOf(isSetWord_fm_updated_at()).compareTo(Boolean.valueOf(bBBookInfo.isSetWord_fm_updated_at()));
//        if (compareTo9 != 0) {
//            return compareTo9;
//        }
//        if (isSetWord_fm_updated_at()) {
//            int a9 = C2121h.m5523a(this.word_fm_updated_at, bBBookInfo.word_fm_updated_at);
//            if (a9 != 0) {
//                return a9;
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
//        StringBuilder sb = new StringBuilder("BBBookInfo(");
//        sb.append("id:");
//        sb.append(this.f2408id);
//        sb.append(", ");
//        sb.append("name_cn:");
//        if (this.name_cn == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.name_cn);
//        }
//        sb.append(", ");
//        sb.append("updated_at:");
//        sb.append(this.updated_at);
//        sb.append(", ");
//        sb.append("count_of_learned_words:");
//        sb.append(this.count_of_learned_words);
//        sb.append(", ");
//        sb.append("selected_end_time:");
//        sb.append(this.selected_end_time);
//        sb.append(", ");
//        sb.append("last_touch_at:");
//        sb.append(this.last_touch_at);
//        sb.append(", ");
//        sb.append("total_words:");
//        sb.append(this.total_words);
//        sb.append(", ");
//        sb.append("roadmap_version:");
//        sb.append(this.roadmap_version);
//        sb.append(", ");
//        sb.append("word_fm_updated_at:");
//        sb.append(this.word_fm_updated_at);
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.name_cn == null) {
//            throw new C2101g("Required field 'name_cn' was not present! Struct: " + toString());
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
