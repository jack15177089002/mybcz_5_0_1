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
//public class BBLearnInfo implements Serializable, Cloneable, Comparable<BBLearnInfo>, C2116f<BBLearnInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b CURRENT_TARGET_END_TIME_FIELD_DESC = new C2097b("current_target_end_time", 10, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b LAST_DAKA_AT_FIELD_DESC = new C2097b("last_daka_at", 10, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b LAST_SYNC_DONE_SCORE_TIME_FIELD_DESC = new C2097b("last_sync_done_score_time", 10, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b LAST_TOUCH_AT_FIELD_DESC = new C2097b("last_touch_at", 10, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b LATEST_FINISHED_DATE_FIELD_DESC = new C2097b("latest_finished_date", 10, 10);
//    /* access modifiers changed from: private */
//    public static final C2097b NEW_TODAY_TARGET_COUNT_FIELD_DESC = new C2097b("new_today_target_count", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b ROADMAP_VERSION_FIELD_DESC = new C2097b("roadmap_version", 10, 8);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBLearnInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TOTAL_DAKA_DAYS_FIELD_DESC = new C2097b("total_daka_days", 8, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b VOCAB_COUNT_FIELD_DESC = new C2097b("vocab_count", 8, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FM_UPDATED_AT_FIELD_DESC = new C2097b("word_fm_updated_at", 10, 9);
//    private static final int __CURRENT_TARGET_END_TIME_ISSET_ID = 0;
//    private static final int __LAST_DAKA_AT_ISSET_ID = 4;
//    private static final int __LAST_SYNC_DONE_SCORE_TIME_ISSET_ID = 2;
//    private static final int __LAST_TOUCH_AT_ISSET_ID = 6;
//    private static final int __LATEST_FINISHED_DATE_ISSET_ID = 9;
//    private static final int __NEW_TODAY_TARGET_COUNT_ISSET_ID = 1;
//    private static final int __ROADMAP_VERSION_ISSET_ID = 7;
//    private static final int __TOTAL_DAKA_DAYS_ISSET_ID = 3;
//    private static final int __VOCAB_COUNT_ISSET_ID = 5;
//    private static final int __WORD_FM_UPDATED_AT_ISSET_ID = 8;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private short __isset_bitfield;
//    public long current_target_end_time;
//    public long last_daka_at;
//    public long last_sync_done_score_time;
//    public long last_touch_at;
//    public long latest_finished_date;
//    public int new_today_target_count;
//    private _Fields[] optionals;
//    public long roadmap_version;
//    public int total_daka_days;
//    public int vocab_count;
//    public long word_fm_updated_at;
//
//    class BBLearnInfoStandardScheme extends C2110c<BBLearnInfo> {
//        private BBLearnInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBLearnInfo bBLearnInfo) {
//            fVar.mo18504e();
//            while (true) {
//                C2097b g = fVar.mo18506g();
//                if (g.f5835b != 0) {
//                    switch (g.f5836c) {
//                        case 1:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.current_target_end_time = fVar.mo18514o();
//                                bBLearnInfo.setCurrent_target_end_timeIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.new_today_target_count = fVar.mo18513n();
//                                bBLearnInfo.setNew_today_target_countIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.last_sync_done_score_time = fVar.mo18514o();
//                                bBLearnInfo.setLast_sync_done_score_timeIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.total_daka_days = fVar.mo18513n();
//                                bBLearnInfo.setTotal_daka_daysIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.last_daka_at = fVar.mo18514o();
//                                bBLearnInfo.setLast_daka_atIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.vocab_count = fVar.mo18513n();
//                                bBLearnInfo.setVocab_countIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.last_touch_at = fVar.mo18514o();
//                                bBLearnInfo.setLast_touch_atIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.roadmap_version = fVar.mo18514o();
//                                bBLearnInfo.setRoadmap_versionIsSet(true);
//                                break;
//                            }
//                        case 9:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.word_fm_updated_at = fVar.mo18514o();
//                                bBLearnInfo.setWord_fm_updated_atIsSet(true);
//                                break;
//                            }
//                        case 10:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLearnInfo.latest_finished_date = fVar.mo18514o();
//                                bBLearnInfo.setLatest_finished_dateIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBLearnInfo.isSetCurrent_target_end_time()) {
//                        throw new C2101g("Required field 'current_target_end_time' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBLearnInfo.isSetNew_today_target_count()) {
//                        throw new C2101g("Required field 'new_today_target_count' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBLearnInfo.isSetLast_sync_done_score_time()) {
//                        throw new C2101g("Required field 'last_sync_done_score_time' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBLearnInfo.isSetTotal_daka_days()) {
//                        throw new C2101g("Required field 'total_daka_days' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBLearnInfo.isSetLast_daka_at()) {
//                        throw new C2101g("Required field 'last_daka_at' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBLearnInfo.isSetVocab_count()) {
//                        throw new C2101g("Required field 'vocab_count' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBLearnInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBLearnInfo bBLearnInfo) {
//            bBLearnInfo.validate();
//            BBLearnInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBLearnInfo.CURRENT_TARGET_END_TIME_FIELD_DESC);
//            fVar.mo18494a(bBLearnInfo.current_target_end_time);
//            fVar.mo18496a(BBLearnInfo.NEW_TODAY_TARGET_COUNT_FIELD_DESC);
//            fVar.mo18493a(bBLearnInfo.new_today_target_count);
//            fVar.mo18496a(BBLearnInfo.LAST_SYNC_DONE_SCORE_TIME_FIELD_DESC);
//            fVar.mo18494a(bBLearnInfo.last_sync_done_score_time);
//            fVar.mo18496a(BBLearnInfo.TOTAL_DAKA_DAYS_FIELD_DESC);
//            fVar.mo18493a(bBLearnInfo.total_daka_days);
//            fVar.mo18496a(BBLearnInfo.LAST_DAKA_AT_FIELD_DESC);
//            fVar.mo18494a(bBLearnInfo.last_daka_at);
//            fVar.mo18496a(BBLearnInfo.VOCAB_COUNT_FIELD_DESC);
//            fVar.mo18493a(bBLearnInfo.vocab_count);
//            if (bBLearnInfo.isSetLast_touch_at()) {
//                fVar.mo18496a(BBLearnInfo.LAST_TOUCH_AT_FIELD_DESC);
//                fVar.mo18494a(bBLearnInfo.last_touch_at);
//            }
//            if (bBLearnInfo.isSetRoadmap_version()) {
//                fVar.mo18496a(BBLearnInfo.ROADMAP_VERSION_FIELD_DESC);
//                fVar.mo18494a(bBLearnInfo.roadmap_version);
//            }
//            if (bBLearnInfo.isSetWord_fm_updated_at()) {
//                fVar.mo18496a(BBLearnInfo.WORD_FM_UPDATED_AT_FIELD_DESC);
//                fVar.mo18494a(bBLearnInfo.word_fm_updated_at);
//            }
//            if (bBLearnInfo.isSetLatest_finished_date()) {
//                fVar.mo18496a(BBLearnInfo.LATEST_FINISHED_DATE_FIELD_DESC);
//                fVar.mo18494a(bBLearnInfo.latest_finished_date);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBLearnInfoStandardSchemeFactory implements C2109b {
//        private BBLearnInfoStandardSchemeFactory() {
//        }
//
//        public BBLearnInfoStandardScheme getScheme() {
//            return new BBLearnInfoStandardScheme();
//        }
//    }
//
//    class BBLearnInfoTupleScheme extends C2111d<BBLearnInfo> {
//        private BBLearnInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBLearnInfo bBLearnInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18494a(bBLearnInfo.current_target_end_time);
//            lVar.mo18493a(bBLearnInfo.new_today_target_count);
//            lVar.mo18494a(bBLearnInfo.last_sync_done_score_time);
//            lVar.mo18493a(bBLearnInfo.total_daka_days);
//            lVar.mo18494a(bBLearnInfo.last_daka_at);
//            lVar.mo18493a(bBLearnInfo.vocab_count);
//            BitSet bitSet = new BitSet();
//            if (bBLearnInfo.isSetLast_touch_at()) {
//                bitSet.set(0);
//            }
//            if (bBLearnInfo.isSetRoadmap_version()) {
//                bitSet.set(1);
//            }
//            if (bBLearnInfo.isSetWord_fm_updated_at()) {
//                bitSet.set(2);
//            }
//            if (bBLearnInfo.isSetLatest_finished_date()) {
//                bitSet.set(3);
//            }
//            lVar.mo18527a(bitSet, 4);
//            if (bBLearnInfo.isSetLast_touch_at()) {
//                lVar.mo18494a(bBLearnInfo.last_touch_at);
//            }
//            if (bBLearnInfo.isSetRoadmap_version()) {
//                lVar.mo18494a(bBLearnInfo.roadmap_version);
//            }
//            if (bBLearnInfo.isSetWord_fm_updated_at()) {
//                lVar.mo18494a(bBLearnInfo.word_fm_updated_at);
//            }
//            if (bBLearnInfo.isSetLatest_finished_date()) {
//                lVar.mo18494a(bBLearnInfo.latest_finished_date);
//            }
//        }
//
//        public void read(C2100f fVar, BBLearnInfo bBLearnInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBLearnInfo.current_target_end_time = lVar.mo18514o();
//            bBLearnInfo.setCurrent_target_end_timeIsSet(true);
//            bBLearnInfo.new_today_target_count = lVar.mo18513n();
//            bBLearnInfo.setNew_today_target_countIsSet(true);
//            bBLearnInfo.last_sync_done_score_time = lVar.mo18514o();
//            bBLearnInfo.setLast_sync_done_score_timeIsSet(true);
//            bBLearnInfo.total_daka_days = lVar.mo18513n();
//            bBLearnInfo.setTotal_daka_daysIsSet(true);
//            bBLearnInfo.last_daka_at = lVar.mo18514o();
//            bBLearnInfo.setLast_daka_atIsSet(true);
//            bBLearnInfo.vocab_count = lVar.mo18513n();
//            bBLearnInfo.setVocab_countIsSet(true);
//            BitSet b = lVar.mo18528b(4);
//            if (b.get(0)) {
//                bBLearnInfo.last_touch_at = lVar.mo18514o();
//                bBLearnInfo.setLast_touch_atIsSet(true);
//            }
//            if (b.get(1)) {
//                bBLearnInfo.roadmap_version = lVar.mo18514o();
//                bBLearnInfo.setRoadmap_versionIsSet(true);
//            }
//            if (b.get(2)) {
//                bBLearnInfo.word_fm_updated_at = lVar.mo18514o();
//                bBLearnInfo.setWord_fm_updated_atIsSet(true);
//            }
//            if (b.get(3)) {
//                bBLearnInfo.latest_finished_date = lVar.mo18514o();
//                bBLearnInfo.setLatest_finished_dateIsSet(true);
//            }
//        }
//    }
//
//    class BBLearnInfoTupleSchemeFactory implements C2109b {
//        private BBLearnInfoTupleSchemeFactory() {
//        }
//
//        public BBLearnInfoTupleScheme getScheme() {
//            return new BBLearnInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        CURRENT_TARGET_END_TIME(1, "current_target_end_time"),
//        NEW_TODAY_TARGET_COUNT(2, "new_today_target_count"),
//        LAST_SYNC_DONE_SCORE_TIME(3, "last_sync_done_score_time"),
//        TOTAL_DAKA_DAYS(4, "total_daka_days"),
//        LAST_DAKA_AT(5, "last_daka_at"),
//        VOCAB_COUNT(6, "vocab_count"),
//        LAST_TOUCH_AT(7, "last_touch_at"),
//        ROADMAP_VERSION(8, "roadmap_version"),
//        WORD_FM_UPDATED_AT(9, "word_fm_updated_at"),
//        LATEST_FINISHED_DATE(10, "latest_finished_date");
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
//                    return CURRENT_TARGET_END_TIME;
//                case 2:
//                    return NEW_TODAY_TARGET_COUNT;
//                case 3:
//                    return LAST_SYNC_DONE_SCORE_TIME;
//                case 4:
//                    return TOTAL_DAKA_DAYS;
//                case 5:
//                    return LAST_DAKA_AT;
//                case 6:
//                    return VOCAB_COUNT;
//                case 7:
//                    return LAST_TOUCH_AT;
//                case 8:
//                    return ROADMAP_VERSION;
//                case 9:
//                    return WORD_FM_UPDATED_AT;
//                case 10:
//                    return LATEST_FINISHED_DATE;
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
//        hashMap.put(C2110c.class, new BBLearnInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBLearnInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.CURRENT_TARGET_END_TIME, new C2091a("current_target_end_time", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.NEW_TODAY_TARGET_COUNT, new C2091a("new_today_target_count", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.LAST_SYNC_DONE_SCORE_TIME, new C2091a("last_sync_done_score_time", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.TOTAL_DAKA_DAYS, new C2091a("total_daka_days", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.LAST_DAKA_AT, new C2091a("last_daka_at", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.VOCAB_COUNT, new C2091a("vocab_count", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.LAST_TOUCH_AT, new C2091a("last_touch_at", 2, new C2092b(10, 0)));
//        enumMap.put(_Fields.ROADMAP_VERSION, new C2091a("roadmap_version", 2, new C2092b(10, 0)));
//        enumMap.put(_Fields.WORD_FM_UPDATED_AT, new C2091a("word_fm_updated_at", 2, new C2092b(10, 0)));
//        enumMap.put(_Fields.LATEST_FINISHED_DATE, new C2091a("latest_finished_date", 2, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBLearnInfo.class, metaDataMap);
//    }
//
//    public BBLearnInfo() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.LAST_TOUCH_AT, _Fields.ROADMAP_VERSION, _Fields.WORD_FM_UPDATED_AT, _Fields.LATEST_FINISHED_DATE};
//    }
//
//    public BBLearnInfo(long j, int i, long j2, int i2, long j3, int i3) {
//        this();
//        this.current_target_end_time = j;
//        setCurrent_target_end_timeIsSet(true);
//        this.new_today_target_count = i;
//        setNew_today_target_countIsSet(true);
//        this.last_sync_done_score_time = j2;
//        setLast_sync_done_score_timeIsSet(true);
//        this.total_daka_days = i2;
//        setTotal_daka_daysIsSet(true);
//        this.last_daka_at = j3;
//        setLast_daka_atIsSet(true);
//        this.vocab_count = i3;
//        setVocab_countIsSet(true);
//    }
//
//    public BBLearnInfo(BBLearnInfo bBLearnInfo) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.LAST_TOUCH_AT, _Fields.ROADMAP_VERSION, _Fields.WORD_FM_UPDATED_AT, _Fields.LATEST_FINISHED_DATE};
//        this.__isset_bitfield = bBLearnInfo.__isset_bitfield;
//        this.current_target_end_time = bBLearnInfo.current_target_end_time;
//        this.new_today_target_count = bBLearnInfo.new_today_target_count;
//        this.last_sync_done_score_time = bBLearnInfo.last_sync_done_score_time;
//        this.total_daka_days = bBLearnInfo.total_daka_days;
//        this.last_daka_at = bBLearnInfo.last_daka_at;
//        this.vocab_count = bBLearnInfo.vocab_count;
//        this.last_touch_at = bBLearnInfo.last_touch_at;
//        this.roadmap_version = bBLearnInfo.roadmap_version;
//        this.word_fm_updated_at = bBLearnInfo.word_fm_updated_at;
//        this.latest_finished_date = bBLearnInfo.latest_finished_date;
//    }
//
//    public BBLearnInfo deepCopy() {
//        return new BBLearnInfo(this);
//    }
//
//    public void clear() {
//        setCurrent_target_end_timeIsSet(false);
//        this.current_target_end_time = 0;
//        setNew_today_target_countIsSet(false);
//        this.new_today_target_count = 0;
//        setLast_sync_done_score_timeIsSet(false);
//        this.last_sync_done_score_time = 0;
//        setTotal_daka_daysIsSet(false);
//        this.total_daka_days = 0;
//        setLast_daka_atIsSet(false);
//        this.last_daka_at = 0;
//        setVocab_countIsSet(false);
//        this.vocab_count = 0;
//        setLast_touch_atIsSet(false);
//        this.last_touch_at = 0;
//        setRoadmap_versionIsSet(false);
//        this.roadmap_version = 0;
//        setWord_fm_updated_atIsSet(false);
//        this.word_fm_updated_at = 0;
//        setLatest_finished_dateIsSet(false);
//        this.latest_finished_date = 0;
//    }
//
//    public long getCurrent_target_end_time() {
//        return this.current_target_end_time;
//    }
//
//    public BBLearnInfo setCurrent_target_end_time(long j) {
//        this.current_target_end_time = j;
//        setCurrent_target_end_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetCurrent_target_end_time() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetCurrent_target_end_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setCurrent_target_end_timeIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public int getNew_today_target_count() {
//        return this.new_today_target_count;
//    }
//
//    public BBLearnInfo setNew_today_target_count(int i) {
//        this.new_today_target_count = i;
//        setNew_today_target_countIsSet(true);
//        return this;
//    }
//
//    public void unsetNew_today_target_count() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetNew_today_target_count() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setNew_today_target_countIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public long getLast_sync_done_score_time() {
//        return this.last_sync_done_score_time;
//    }
//
//    public BBLearnInfo setLast_sync_done_score_time(long j) {
//        this.last_sync_done_score_time = j;
//        setLast_sync_done_score_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetLast_sync_done_score_time() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetLast_sync_done_score_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setLast_sync_done_score_timeIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public int getTotal_daka_days() {
//        return this.total_daka_days;
//    }
//
//    public BBLearnInfo setTotal_daka_days(int i) {
//        this.total_daka_days = i;
//        setTotal_daka_daysIsSet(true);
//        return this;
//    }
//
//    public void unsetTotal_daka_days() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetTotal_daka_days() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setTotal_daka_daysIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public long getLast_daka_at() {
//        return this.last_daka_at;
//    }
//
//    public BBLearnInfo setLast_daka_at(long j) {
//        this.last_daka_at = j;
//        setLast_daka_atIsSet(true);
//        return this;
//    }
//
//    public void unsetLast_daka_at() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetLast_daka_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setLast_daka_atIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 4, z);
//    }
//
//    public int getVocab_count() {
//        return this.vocab_count;
//    }
//
//    public BBLearnInfo setVocab_count(int i) {
//        this.vocab_count = i;
//        setVocab_countIsSet(true);
//        return this;
//    }
//
//    public void unsetVocab_count() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -33);
//    }
//
//    public boolean isSetVocab_count() {
//        return C2090b.m5429a(this.__isset_bitfield, 5);
//    }
//
//    public void setVocab_countIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 5, z);
//    }
//
//    public long getLast_touch_at() {
//        return this.last_touch_at;
//    }
//
//    public BBLearnInfo setLast_touch_at(long j) {
//        this.last_touch_at = j;
//        setLast_touch_atIsSet(true);
//        return this;
//    }
//
//    public void unsetLast_touch_at() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -65);
//    }
//
//    public boolean isSetLast_touch_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 6);
//    }
//
//    public void setLast_touch_atIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 6, z);
//    }
//
//    public long getRoadmap_version() {
//        return this.roadmap_version;
//    }
//
//    public BBLearnInfo setRoadmap_version(long j) {
//        this.roadmap_version = j;
//        setRoadmap_versionIsSet(true);
//        return this;
//    }
//
//    public void unsetRoadmap_version() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -129);
//    }
//
//    public boolean isSetRoadmap_version() {
//        return C2090b.m5429a(this.__isset_bitfield, 7);
//    }
//
//    public void setRoadmap_versionIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 7, z);
//    }
//
//    public long getWord_fm_updated_at() {
//        return this.word_fm_updated_at;
//    }
//
//    public BBLearnInfo setWord_fm_updated_at(long j) {
//        this.word_fm_updated_at = j;
//        setWord_fm_updated_atIsSet(true);
//        return this;
//    }
//
//    public void unsetWord_fm_updated_at() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -257);
//    }
//
//    public boolean isSetWord_fm_updated_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 8);
//    }
//
//    public void setWord_fm_updated_atIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 8, z);
//    }
//
//    public long getLatest_finished_date() {
//        return this.latest_finished_date;
//    }
//
//    public BBLearnInfo setLatest_finished_date(long j) {
//        this.latest_finished_date = j;
//        setLatest_finished_dateIsSet(true);
//        return this;
//    }
//
//    public void unsetLatest_finished_date() {
//        this.__isset_bitfield = (short) (this.__isset_bitfield & -513);
//    }
//
//    public boolean isSetLatest_finished_date() {
//        return C2090b.m5429a(this.__isset_bitfield, 9);
//    }
//
//    public void setLatest_finished_dateIsSet(boolean z) {
//        this.__isset_bitfield = (short) C2090b.m5428a(this.__isset_bitfield, 9, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case CURRENT_TARGET_END_TIME:
//                if (obj == null) {
//                    unsetCurrent_target_end_time();
//                    return;
//                } else {
//                    setCurrent_target_end_time(((Long) obj).longValue());
//                    return;
//                }
//            case NEW_TODAY_TARGET_COUNT:
//                if (obj == null) {
//                    unsetNew_today_target_count();
//                    return;
//                } else {
//                    setNew_today_target_count(((Integer) obj).intValue());
//                    return;
//                }
//            case LAST_SYNC_DONE_SCORE_TIME:
//                if (obj == null) {
//                    unsetLast_sync_done_score_time();
//                    return;
//                } else {
//                    setLast_sync_done_score_time(((Long) obj).longValue());
//                    return;
//                }
//            case TOTAL_DAKA_DAYS:
//                if (obj == null) {
//                    unsetTotal_daka_days();
//                    return;
//                } else {
//                    setTotal_daka_days(((Integer) obj).intValue());
//                    return;
//                }
//            case LAST_DAKA_AT:
//                if (obj == null) {
//                    unsetLast_daka_at();
//                    return;
//                } else {
//                    setLast_daka_at(((Long) obj).longValue());
//                    return;
//                }
//            case VOCAB_COUNT:
//                if (obj == null) {
//                    unsetVocab_count();
//                    return;
//                } else {
//                    setVocab_count(((Integer) obj).intValue());
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
//            case LATEST_FINISHED_DATE:
//                if (obj == null) {
//                    unsetLatest_finished_date();
//                    return;
//                } else {
//                    setLatest_finished_date(((Long) obj).longValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case CURRENT_TARGET_END_TIME:
//                return Long.valueOf(getCurrent_target_end_time());
//            case NEW_TODAY_TARGET_COUNT:
//                return Integer.valueOf(getNew_today_target_count());
//            case LAST_SYNC_DONE_SCORE_TIME:
//                return Long.valueOf(getLast_sync_done_score_time());
//            case TOTAL_DAKA_DAYS:
//                return Integer.valueOf(getTotal_daka_days());
//            case LAST_DAKA_AT:
//                return Long.valueOf(getLast_daka_at());
//            case VOCAB_COUNT:
//                return Integer.valueOf(getVocab_count());
//            case LAST_TOUCH_AT:
//                return Long.valueOf(getLast_touch_at());
//            case ROADMAP_VERSION:
//                return Long.valueOf(getRoadmap_version());
//            case WORD_FM_UPDATED_AT:
//                return Long.valueOf(getWord_fm_updated_at());
//            case LATEST_FINISHED_DATE:
//                return Long.valueOf(getLatest_finished_date());
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
//            case CURRENT_TARGET_END_TIME:
//                return isSetCurrent_target_end_time();
//            case NEW_TODAY_TARGET_COUNT:
//                return isSetNew_today_target_count();
//            case LAST_SYNC_DONE_SCORE_TIME:
//                return isSetLast_sync_done_score_time();
//            case TOTAL_DAKA_DAYS:
//                return isSetTotal_daka_days();
//            case LAST_DAKA_AT:
//                return isSetLast_daka_at();
//            case VOCAB_COUNT:
//                return isSetVocab_count();
//            case LAST_TOUCH_AT:
//                return isSetLast_touch_at();
//            case ROADMAP_VERSION:
//                return isSetRoadmap_version();
//            case WORD_FM_UPDATED_AT:
//                return isSetWord_fm_updated_at();
//            case LATEST_FINISHED_DATE:
//                return isSetLatest_finished_date();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBLearnInfo)) {
//            return equals((BBLearnInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBLearnInfo bBLearnInfo) {
//        if (bBLearnInfo == null || this.current_target_end_time != bBLearnInfo.current_target_end_time || this.new_today_target_count != bBLearnInfo.new_today_target_count || this.last_sync_done_score_time != bBLearnInfo.last_sync_done_score_time || this.total_daka_days != bBLearnInfo.total_daka_days || this.last_daka_at != bBLearnInfo.last_daka_at || this.vocab_count != bBLearnInfo.vocab_count) {
//            return false;
//        }
//        boolean isSetLast_touch_at = isSetLast_touch_at();
//        boolean isSetLast_touch_at2 = bBLearnInfo.isSetLast_touch_at();
//        if ((isSetLast_touch_at || isSetLast_touch_at2) && (!isSetLast_touch_at || !isSetLast_touch_at2 || this.last_touch_at != bBLearnInfo.last_touch_at)) {
//            return false;
//        }
//        boolean isSetRoadmap_version = isSetRoadmap_version();
//        boolean isSetRoadmap_version2 = bBLearnInfo.isSetRoadmap_version();
//        if ((isSetRoadmap_version || isSetRoadmap_version2) && (!isSetRoadmap_version || !isSetRoadmap_version2 || this.roadmap_version != bBLearnInfo.roadmap_version)) {
//            return false;
//        }
//        boolean isSetWord_fm_updated_at = isSetWord_fm_updated_at();
//        boolean isSetWord_fm_updated_at2 = bBLearnInfo.isSetWord_fm_updated_at();
//        if ((isSetWord_fm_updated_at || isSetWord_fm_updated_at2) && (!isSetWord_fm_updated_at || !isSetWord_fm_updated_at2 || this.word_fm_updated_at != bBLearnInfo.word_fm_updated_at)) {
//            return false;
//        }
//        boolean isSetLatest_finished_date = isSetLatest_finished_date();
//        boolean isSetLatest_finished_date2 = bBLearnInfo.isSetLatest_finished_date();
//        if ((isSetLatest_finished_date || isSetLatest_finished_date2) && (!isSetLatest_finished_date || !isSetLatest_finished_date2 || this.latest_finished_date != bBLearnInfo.latest_finished_date)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBLearnInfo bBLearnInfo) {
//        if (!getClass().equals(bBLearnInfo.getClass())) {
//            return getClass().getName().compareTo(bBLearnInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetCurrent_target_end_time()).compareTo(Boolean.valueOf(bBLearnInfo.isSetCurrent_target_end_time()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetCurrent_target_end_time()) {
//            int a = C2121h.m5523a(this.current_target_end_time, bBLearnInfo.current_target_end_time);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetNew_today_target_count()).compareTo(Boolean.valueOf(bBLearnInfo.isSetNew_today_target_count()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetNew_today_target_count()) {
//            int a2 = C2121h.m5522a(this.new_today_target_count, bBLearnInfo.new_today_target_count);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetLast_sync_done_score_time()).compareTo(Boolean.valueOf(bBLearnInfo.isSetLast_sync_done_score_time()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetLast_sync_done_score_time()) {
//            int a3 = C2121h.m5523a(this.last_sync_done_score_time, bBLearnInfo.last_sync_done_score_time);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetTotal_daka_days()).compareTo(Boolean.valueOf(bBLearnInfo.isSetTotal_daka_days()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetTotal_daka_days()) {
//            int a4 = C2121h.m5522a(this.total_daka_days, bBLearnInfo.total_daka_days);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetLast_daka_at()).compareTo(Boolean.valueOf(bBLearnInfo.isSetLast_daka_at()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetLast_daka_at()) {
//            int a5 = C2121h.m5523a(this.last_daka_at, bBLearnInfo.last_daka_at);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetVocab_count()).compareTo(Boolean.valueOf(bBLearnInfo.isSetVocab_count()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetVocab_count()) {
//            int a6 = C2121h.m5522a(this.vocab_count, bBLearnInfo.vocab_count);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetLast_touch_at()).compareTo(Boolean.valueOf(bBLearnInfo.isSetLast_touch_at()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetLast_touch_at()) {
//            int a7 = C2121h.m5523a(this.last_touch_at, bBLearnInfo.last_touch_at);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetRoadmap_version()).compareTo(Boolean.valueOf(bBLearnInfo.isSetRoadmap_version()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetRoadmap_version()) {
//            int a8 = C2121h.m5523a(this.roadmap_version, bBLearnInfo.roadmap_version);
//            if (a8 != 0) {
//                return a8;
//            }
//        }
//        int compareTo9 = Boolean.valueOf(isSetWord_fm_updated_at()).compareTo(Boolean.valueOf(bBLearnInfo.isSetWord_fm_updated_at()));
//        if (compareTo9 != 0) {
//            return compareTo9;
//        }
//        if (isSetWord_fm_updated_at()) {
//            int a9 = C2121h.m5523a(this.word_fm_updated_at, bBLearnInfo.word_fm_updated_at);
//            if (a9 != 0) {
//                return a9;
//            }
//        }
//        int compareTo10 = Boolean.valueOf(isSetLatest_finished_date()).compareTo(Boolean.valueOf(bBLearnInfo.isSetLatest_finished_date()));
//        if (compareTo10 != 0) {
//            return compareTo10;
//        }
//        if (isSetLatest_finished_date()) {
//            int a10 = C2121h.m5523a(this.latest_finished_date, bBLearnInfo.latest_finished_date);
//            if (a10 != 0) {
//                return a10;
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
//        StringBuilder sb = new StringBuilder("BBLearnInfo(");
//        sb.append("current_target_end_time:");
//        sb.append(this.current_target_end_time);
//        sb.append(", ");
//        sb.append("new_today_target_count:");
//        sb.append(this.new_today_target_count);
//        sb.append(", ");
//        sb.append("last_sync_done_score_time:");
//        sb.append(this.last_sync_done_score_time);
//        sb.append(", ");
//        sb.append("total_daka_days:");
//        sb.append(this.total_daka_days);
//        sb.append(", ");
//        sb.append("last_daka_at:");
//        sb.append(this.last_daka_at);
//        sb.append(", ");
//        sb.append("vocab_count:");
//        sb.append(this.vocab_count);
//        if (isSetLast_touch_at()) {
//            sb.append(", ");
//            sb.append("last_touch_at:");
//            sb.append(this.last_touch_at);
//        }
//        if (isSetRoadmap_version()) {
//            sb.append(", ");
//            sb.append("roadmap_version:");
//            sb.append(this.roadmap_version);
//        }
//        if (isSetWord_fm_updated_at()) {
//            sb.append(", ");
//            sb.append("word_fm_updated_at:");
//            sb.append(this.word_fm_updated_at);
//        }
//        if (isSetLatest_finished_date()) {
//            sb.append(", ");
//            sb.append("latest_finished_date:");
//            sb.append(this.latest_finished_date);
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
