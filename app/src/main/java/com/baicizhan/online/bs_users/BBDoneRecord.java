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
//public class BBDoneRecord implements Serializable, Cloneable, Comparable<BBDoneRecord>, C2116f<BBDoneRecord, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b CURRENT_SCORE_FIELD_DESC = new C2097b("current_score", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b DONE_TIMES_FIELD_DESC = new C2097b("done_times", 8, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_FIRST_DO_AT_TODAY_FIELD_DESC = new C2097b("is_first_do_at_today", 8, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b SPAN_DAYS_FIELD_DESC = new C2097b("span_days", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBDoneRecord");
//    /* access modifiers changed from: private */
//    public static final C2097b USED_TIME_FIELD_DESC = new C2097b("used_time", 8, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_TOPIC_ID_FIELD_DESC = new C2097b("word_topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b WRONG_TIMES_FIELD_DESC = new C2097b("wrong_times", 8, 6);
//    private static final int __CURRENT_SCORE_ISSET_ID = 1;
//    private static final int __DONE_TIMES_ISSET_ID = 4;
//    private static final int __IS_FIRST_DO_AT_TODAY_ISSET_ID = 6;
//    private static final int __SPAN_DAYS_ISSET_ID = 2;
//    private static final int __USED_TIME_ISSET_ID = 3;
//    private static final int __WORD_TOPIC_ID_ISSET_ID = 0;
//    private static final int __WRONG_TIMES_ISSET_ID = 5;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int current_score;
//    public int done_times;
//    public int is_first_do_at_today;
//    public int span_days;
//    public int used_time;
//    public int word_topic_id;
//    public int wrong_times;
//
//    class BBDoneRecordStandardScheme extends C2110c<BBDoneRecord> {
//        private BBDoneRecordStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBDoneRecord bBDoneRecord) {
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
//                                bBDoneRecord.word_topic_id = fVar.mo18513n();
//                                bBDoneRecord.setWord_topic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneRecord.current_score = fVar.mo18513n();
//                                bBDoneRecord.setCurrent_scoreIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneRecord.span_days = fVar.mo18513n();
//                                bBDoneRecord.setSpan_daysIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneRecord.used_time = fVar.mo18513n();
//                                bBDoneRecord.setUsed_timeIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneRecord.done_times = fVar.mo18513n();
//                                bBDoneRecord.setDone_timesIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneRecord.wrong_times = fVar.mo18513n();
//                                bBDoneRecord.setWrong_timesIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneRecord.is_first_do_at_today = fVar.mo18513n();
//                                bBDoneRecord.setIs_first_do_at_todayIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBDoneRecord.isSetWord_topic_id()) {
//                        throw new C2101g("Required field 'word_topic_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneRecord.isSetCurrent_score()) {
//                        throw new C2101g("Required field 'current_score' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneRecord.isSetSpan_days()) {
//                        throw new C2101g("Required field 'span_days' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneRecord.isSetUsed_time()) {
//                        throw new C2101g("Required field 'used_time' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneRecord.isSetDone_times()) {
//                        throw new C2101g("Required field 'done_times' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneRecord.isSetWrong_times()) {
//                        throw new C2101g("Required field 'wrong_times' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneRecord.isSetIs_first_do_at_today()) {
//                        throw new C2101g("Required field 'is_first_do_at_today' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBDoneRecord.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBDoneRecord bBDoneRecord) {
//            bBDoneRecord.validate();
//            BBDoneRecord.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBDoneRecord.WORD_TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBDoneRecord.word_topic_id);
//            fVar.mo18496a(BBDoneRecord.CURRENT_SCORE_FIELD_DESC);
//            fVar.mo18493a(bBDoneRecord.current_score);
//            fVar.mo18496a(BBDoneRecord.SPAN_DAYS_FIELD_DESC);
//            fVar.mo18493a(bBDoneRecord.span_days);
//            fVar.mo18496a(BBDoneRecord.USED_TIME_FIELD_DESC);
//            fVar.mo18493a(bBDoneRecord.used_time);
//            fVar.mo18496a(BBDoneRecord.DONE_TIMES_FIELD_DESC);
//            fVar.mo18493a(bBDoneRecord.done_times);
//            fVar.mo18496a(BBDoneRecord.WRONG_TIMES_FIELD_DESC);
//            fVar.mo18493a(bBDoneRecord.wrong_times);
//            fVar.mo18496a(BBDoneRecord.IS_FIRST_DO_AT_TODAY_FIELD_DESC);
//            fVar.mo18493a(bBDoneRecord.is_first_do_at_today);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBDoneRecordStandardSchemeFactory implements C2109b {
//        private BBDoneRecordStandardSchemeFactory() {
//        }
//
//        public BBDoneRecordStandardScheme getScheme() {
//            return new BBDoneRecordStandardScheme();
//        }
//    }
//
//    class BBDoneRecordTupleScheme extends C2111d<BBDoneRecord> {
//        private BBDoneRecordTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBDoneRecord bBDoneRecord) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBDoneRecord.word_topic_id);
//            lVar.mo18493a(bBDoneRecord.current_score);
//            lVar.mo18493a(bBDoneRecord.span_days);
//            lVar.mo18493a(bBDoneRecord.used_time);
//            lVar.mo18493a(bBDoneRecord.done_times);
//            lVar.mo18493a(bBDoneRecord.wrong_times);
//            lVar.mo18493a(bBDoneRecord.is_first_do_at_today);
//        }
//
//        public void read(C2100f fVar, BBDoneRecord bBDoneRecord) {
//            C2106l lVar = (C2106l) fVar;
//            bBDoneRecord.word_topic_id = lVar.mo18513n();
//            bBDoneRecord.setWord_topic_idIsSet(true);
//            bBDoneRecord.current_score = lVar.mo18513n();
//            bBDoneRecord.setCurrent_scoreIsSet(true);
//            bBDoneRecord.span_days = lVar.mo18513n();
//            bBDoneRecord.setSpan_daysIsSet(true);
//            bBDoneRecord.used_time = lVar.mo18513n();
//            bBDoneRecord.setUsed_timeIsSet(true);
//            bBDoneRecord.done_times = lVar.mo18513n();
//            bBDoneRecord.setDone_timesIsSet(true);
//            bBDoneRecord.wrong_times = lVar.mo18513n();
//            bBDoneRecord.setWrong_timesIsSet(true);
//            bBDoneRecord.is_first_do_at_today = lVar.mo18513n();
//            bBDoneRecord.setIs_first_do_at_todayIsSet(true);
//        }
//    }
//
//    class BBDoneRecordTupleSchemeFactory implements C2109b {
//        private BBDoneRecordTupleSchemeFactory() {
//        }
//
//        public BBDoneRecordTupleScheme getScheme() {
//            return new BBDoneRecordTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        WORD_TOPIC_ID(1, "word_topic_id"),
//        CURRENT_SCORE(2, "current_score"),
//        SPAN_DAYS(3, "span_days"),
//        USED_TIME(4, "used_time"),
//        DONE_TIMES(5, "done_times"),
//        WRONG_TIMES(6, "wrong_times"),
//        IS_FIRST_DO_AT_TODAY(7, "is_first_do_at_today");
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
//                    return WORD_TOPIC_ID;
//                case 2:
//                    return CURRENT_SCORE;
//                case 3:
//                    return SPAN_DAYS;
//                case 4:
//                    return USED_TIME;
//                case 5:
//                    return DONE_TIMES;
//                case 6:
//                    return WRONG_TIMES;
//                case 7:
//                    return IS_FIRST_DO_AT_TODAY;
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
//        hashMap.put(C2110c.class, new BBDoneRecordStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBDoneRecordTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.WORD_TOPIC_ID, new C2091a("word_topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.CURRENT_SCORE, new C2091a("current_score", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SPAN_DAYS, new C2091a("span_days", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.USED_TIME, new C2091a("used_time", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.DONE_TIMES, new C2091a("done_times", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.WRONG_TIMES, new C2091a("wrong_times", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.IS_FIRST_DO_AT_TODAY, new C2091a("is_first_do_at_today", 1, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBDoneRecord.class, metaDataMap);
//    }
//
//    public BBDoneRecord() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBDoneRecord(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
//        this();
//        this.word_topic_id = i;
//        setWord_topic_idIsSet(true);
//        this.current_score = i2;
//        setCurrent_scoreIsSet(true);
//        this.span_days = i3;
//        setSpan_daysIsSet(true);
//        this.used_time = i4;
//        setUsed_timeIsSet(true);
//        this.done_times = i5;
//        setDone_timesIsSet(true);
//        this.wrong_times = i6;
//        setWrong_timesIsSet(true);
//        this.is_first_do_at_today = i7;
//        setIs_first_do_at_todayIsSet(true);
//    }
//
//    public BBDoneRecord(BBDoneRecord bBDoneRecord) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBDoneRecord.__isset_bitfield;
//        this.word_topic_id = bBDoneRecord.word_topic_id;
//        this.current_score = bBDoneRecord.current_score;
//        this.span_days = bBDoneRecord.span_days;
//        this.used_time = bBDoneRecord.used_time;
//        this.done_times = bBDoneRecord.done_times;
//        this.wrong_times = bBDoneRecord.wrong_times;
//        this.is_first_do_at_today = bBDoneRecord.is_first_do_at_today;
//    }
//
//    public BBDoneRecord deepCopy() {
//        return new BBDoneRecord(this);
//    }
//
//    public void clear() {
//        setWord_topic_idIsSet(false);
//        this.word_topic_id = 0;
//        setCurrent_scoreIsSet(false);
//        this.current_score = 0;
//        setSpan_daysIsSet(false);
//        this.span_days = 0;
//        setUsed_timeIsSet(false);
//        this.used_time = 0;
//        setDone_timesIsSet(false);
//        this.done_times = 0;
//        setWrong_timesIsSet(false);
//        this.wrong_times = 0;
//        setIs_first_do_at_todayIsSet(false);
//        this.is_first_do_at_today = 0;
//    }
//
//    public int getWord_topic_id() {
//        return this.word_topic_id;
//    }
//
//    public BBDoneRecord setWord_topic_id(int i) {
//        this.word_topic_id = i;
//        setWord_topic_idIsSet(true);
//        return this;
//    }
//
//    public void unsetWord_topic_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetWord_topic_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setWord_topic_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public int getCurrent_score() {
//        return this.current_score;
//    }
//
//    public BBDoneRecord setCurrent_score(int i) {
//        this.current_score = i;
//        setCurrent_scoreIsSet(true);
//        return this;
//    }
//
//    public void unsetCurrent_score() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetCurrent_score() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setCurrent_scoreIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getSpan_days() {
//        return this.span_days;
//    }
//
//    public BBDoneRecord setSpan_days(int i) {
//        this.span_days = i;
//        setSpan_daysIsSet(true);
//        return this;
//    }
//
//    public void unsetSpan_days() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetSpan_days() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setSpan_daysIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public int getUsed_time() {
//        return this.used_time;
//    }
//
//    public BBDoneRecord setUsed_time(int i) {
//        this.used_time = i;
//        setUsed_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetUsed_time() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetUsed_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setUsed_timeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public int getDone_times() {
//        return this.done_times;
//    }
//
//    public BBDoneRecord setDone_times(int i) {
//        this.done_times = i;
//        setDone_timesIsSet(true);
//        return this;
//    }
//
//    public void unsetDone_times() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetDone_times() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setDone_timesIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 4, z);
//    }
//
//    public int getWrong_times() {
//        return this.wrong_times;
//    }
//
//    public BBDoneRecord setWrong_times(int i) {
//        this.wrong_times = i;
//        setWrong_timesIsSet(true);
//        return this;
//    }
//
//    public void unsetWrong_times() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -33);
//    }
//
//    public boolean isSetWrong_times() {
//        return C2090b.m5429a(this.__isset_bitfield, 5);
//    }
//
//    public void setWrong_timesIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 5, z);
//    }
//
//    public int getIs_first_do_at_today() {
//        return this.is_first_do_at_today;
//    }
//
//    public BBDoneRecord setIs_first_do_at_today(int i) {
//        this.is_first_do_at_today = i;
//        setIs_first_do_at_todayIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_first_do_at_today() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -65);
//    }
//
//    public boolean isSetIs_first_do_at_today() {
//        return C2090b.m5429a(this.__isset_bitfield, 6);
//    }
//
//    public void setIs_first_do_at_todayIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 6, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case WORD_TOPIC_ID:
//                if (obj == null) {
//                    unsetWord_topic_id();
//                    return;
//                } else {
//                    setWord_topic_id(((Integer) obj).intValue());
//                    return;
//                }
//            case CURRENT_SCORE:
//                if (obj == null) {
//                    unsetCurrent_score();
//                    return;
//                } else {
//                    setCurrent_score(((Integer) obj).intValue());
//                    return;
//                }
//            case SPAN_DAYS:
//                if (obj == null) {
//                    unsetSpan_days();
//                    return;
//                } else {
//                    setSpan_days(((Integer) obj).intValue());
//                    return;
//                }
//            case USED_TIME:
//                if (obj == null) {
//                    unsetUsed_time();
//                    return;
//                } else {
//                    setUsed_time(((Integer) obj).intValue());
//                    return;
//                }
//            case DONE_TIMES:
//                if (obj == null) {
//                    unsetDone_times();
//                    return;
//                } else {
//                    setDone_times(((Integer) obj).intValue());
//                    return;
//                }
//            case WRONG_TIMES:
//                if (obj == null) {
//                    unsetWrong_times();
//                    return;
//                } else {
//                    setWrong_times(((Integer) obj).intValue());
//                    return;
//                }
//            case IS_FIRST_DO_AT_TODAY:
//                if (obj == null) {
//                    unsetIs_first_do_at_today();
//                    return;
//                } else {
//                    setIs_first_do_at_today(((Integer) obj).intValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case WORD_TOPIC_ID:
//                return Integer.valueOf(getWord_topic_id());
//            case CURRENT_SCORE:
//                return Integer.valueOf(getCurrent_score());
//            case SPAN_DAYS:
//                return Integer.valueOf(getSpan_days());
//            case USED_TIME:
//                return Integer.valueOf(getUsed_time());
//            case DONE_TIMES:
//                return Integer.valueOf(getDone_times());
//            case WRONG_TIMES:
//                return Integer.valueOf(getWrong_times());
//            case IS_FIRST_DO_AT_TODAY:
//                return Integer.valueOf(getIs_first_do_at_today());
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
//            case WORD_TOPIC_ID:
//                return isSetWord_topic_id();
//            case CURRENT_SCORE:
//                return isSetCurrent_score();
//            case SPAN_DAYS:
//                return isSetSpan_days();
//            case USED_TIME:
//                return isSetUsed_time();
//            case DONE_TIMES:
//                return isSetDone_times();
//            case WRONG_TIMES:
//                return isSetWrong_times();
//            case IS_FIRST_DO_AT_TODAY:
//                return isSetIs_first_do_at_today();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBDoneRecord)) {
//            return equals((BBDoneRecord) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBDoneRecord bBDoneRecord) {
//        if (bBDoneRecord != null && this.word_topic_id == bBDoneRecord.word_topic_id && this.current_score == bBDoneRecord.current_score && this.span_days == bBDoneRecord.span_days && this.used_time == bBDoneRecord.used_time && this.done_times == bBDoneRecord.done_times && this.wrong_times == bBDoneRecord.wrong_times && this.is_first_do_at_today == bBDoneRecord.is_first_do_at_today) {
//            return true;
//        }
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBDoneRecord bBDoneRecord) {
//        if (!getClass().equals(bBDoneRecord.getClass())) {
//            return getClass().getName().compareTo(bBDoneRecord.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetWord_topic_id()).compareTo(Boolean.valueOf(bBDoneRecord.isSetWord_topic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetWord_topic_id()) {
//            int a = C2121h.m5522a(this.word_topic_id, bBDoneRecord.word_topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetCurrent_score()).compareTo(Boolean.valueOf(bBDoneRecord.isSetCurrent_score()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetCurrent_score()) {
//            int a2 = C2121h.m5522a(this.current_score, bBDoneRecord.current_score);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetSpan_days()).compareTo(Boolean.valueOf(bBDoneRecord.isSetSpan_days()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetSpan_days()) {
//            int a3 = C2121h.m5522a(this.span_days, bBDoneRecord.span_days);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetUsed_time()).compareTo(Boolean.valueOf(bBDoneRecord.isSetUsed_time()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetUsed_time()) {
//            int a4 = C2121h.m5522a(this.used_time, bBDoneRecord.used_time);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetDone_times()).compareTo(Boolean.valueOf(bBDoneRecord.isSetDone_times()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetDone_times()) {
//            int a5 = C2121h.m5522a(this.done_times, bBDoneRecord.done_times);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetWrong_times()).compareTo(Boolean.valueOf(bBDoneRecord.isSetWrong_times()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetWrong_times()) {
//            int a6 = C2121h.m5522a(this.wrong_times, bBDoneRecord.wrong_times);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetIs_first_do_at_today()).compareTo(Boolean.valueOf(bBDoneRecord.isSetIs_first_do_at_today()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetIs_first_do_at_today()) {
//            int a7 = C2121h.m5522a(this.is_first_do_at_today, bBDoneRecord.is_first_do_at_today);
//            if (a7 != 0) {
//                return a7;
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
//        StringBuilder sb = new StringBuilder("BBDoneRecord(");
//        sb.append("word_topic_id:");
//        sb.append(this.word_topic_id);
//        sb.append(", ");
//        sb.append("current_score:");
//        sb.append(this.current_score);
//        sb.append(", ");
//        sb.append("span_days:");
//        sb.append(this.span_days);
//        sb.append(", ");
//        sb.append("used_time:");
//        sb.append(this.used_time);
//        sb.append(", ");
//        sb.append("done_times:");
//        sb.append(this.done_times);
//        sb.append(", ");
//        sb.append("wrong_times:");
//        sb.append(this.wrong_times);
//        sb.append(", ");
//        sb.append("is_first_do_at_today:");
//        sb.append(this.is_first_do_at_today);
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
