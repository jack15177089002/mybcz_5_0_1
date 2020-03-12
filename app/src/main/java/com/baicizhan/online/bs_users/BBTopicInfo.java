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
//public class BBTopicInfo implements Serializable, Cloneable, Comparable<BBTopicInfo>, C2116f<BBTopicInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b DONE_TIMES_FIELD_DESC = new C2097b("done_times", 8, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b SCORE_FIELD_DESC = new C2097b("score", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b SPAN_DAYS_FIELD_DESC = new C2097b("span_days", 8, 6);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBTopicInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATE_DAYS_FIELD_DESC = new C2097b("update_days", 8, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b USED_TIME_FIELD_DESC = new C2097b("used_time", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b WRONG_TIMES_FIELD_DESC = new C2097b("wrong_times", 8, 4);
//    private static final int __DONE_TIMES_ISSET_ID = 4;
//    private static final int __SCORE_ISSET_ID = 1;
//    private static final int __SPAN_DAYS_ISSET_ID = 5;
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    private static final int __UPDATE_DAYS_ISSET_ID = 6;
//    private static final int __USED_TIME_ISSET_ID = 2;
//    private static final int __WRONG_TIMES_ISSET_ID = 3;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int done_times;
//    private _Fields[] optionals;
//    public int score;
//    public int span_days;
//    public int topic_id;
//    public int update_days;
//    public int used_time;
//    public int wrong_times;
//
//    class BBTopicInfoStandardScheme extends C2110c<BBTopicInfo> {
//        private BBTopicInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBTopicInfo bBTopicInfo) {
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
//                                bBTopicInfo.topic_id = fVar.mo18513n();
//                                bBTopicInfo.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicInfo.score = fVar.mo18513n();
//                                bBTopicInfo.setScoreIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicInfo.used_time = fVar.mo18513n();
//                                bBTopicInfo.setUsed_timeIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicInfo.wrong_times = fVar.mo18513n();
//                                bBTopicInfo.setWrong_timesIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicInfo.done_times = fVar.mo18513n();
//                                bBTopicInfo.setDone_timesIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicInfo.span_days = fVar.mo18513n();
//                                bBTopicInfo.setSpan_daysIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicInfo.update_days = fVar.mo18513n();
//                                bBTopicInfo.setUpdate_daysIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBTopicInfo.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBTopicInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBTopicInfo bBTopicInfo) {
//            bBTopicInfo.validate();
//            BBTopicInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBTopicInfo.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBTopicInfo.topic_id);
//            if (bBTopicInfo.isSetScore()) {
//                fVar.mo18496a(BBTopicInfo.SCORE_FIELD_DESC);
//                fVar.mo18493a(bBTopicInfo.score);
//            }
//            if (bBTopicInfo.isSetUsed_time()) {
//                fVar.mo18496a(BBTopicInfo.USED_TIME_FIELD_DESC);
//                fVar.mo18493a(bBTopicInfo.used_time);
//            }
//            if (bBTopicInfo.isSetWrong_times()) {
//                fVar.mo18496a(BBTopicInfo.WRONG_TIMES_FIELD_DESC);
//                fVar.mo18493a(bBTopicInfo.wrong_times);
//            }
//            if (bBTopicInfo.isSetDone_times()) {
//                fVar.mo18496a(BBTopicInfo.DONE_TIMES_FIELD_DESC);
//                fVar.mo18493a(bBTopicInfo.done_times);
//            }
//            if (bBTopicInfo.isSetSpan_days()) {
//                fVar.mo18496a(BBTopicInfo.SPAN_DAYS_FIELD_DESC);
//                fVar.mo18493a(bBTopicInfo.span_days);
//            }
//            if (bBTopicInfo.isSetUpdate_days()) {
//                fVar.mo18496a(BBTopicInfo.UPDATE_DAYS_FIELD_DESC);
//                fVar.mo18493a(bBTopicInfo.update_days);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBTopicInfoStandardSchemeFactory implements C2109b {
//        private BBTopicInfoStandardSchemeFactory() {
//        }
//
//        public BBTopicInfoStandardScheme getScheme() {
//            return new BBTopicInfoStandardScheme();
//        }
//    }
//
//    class BBTopicInfoTupleScheme extends C2111d<BBTopicInfo> {
//        private BBTopicInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBTopicInfo bBTopicInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBTopicInfo.topic_id);
//            BitSet bitSet = new BitSet();
//            if (bBTopicInfo.isSetScore()) {
//                bitSet.set(0);
//            }
//            if (bBTopicInfo.isSetUsed_time()) {
//                bitSet.set(1);
//            }
//            if (bBTopicInfo.isSetWrong_times()) {
//                bitSet.set(2);
//            }
//            if (bBTopicInfo.isSetDone_times()) {
//                bitSet.set(3);
//            }
//            if (bBTopicInfo.isSetSpan_days()) {
//                bitSet.set(4);
//            }
//            if (bBTopicInfo.isSetUpdate_days()) {
//                bitSet.set(5);
//            }
//            lVar.mo18527a(bitSet, 6);
//            if (bBTopicInfo.isSetScore()) {
//                lVar.mo18493a(bBTopicInfo.score);
//            }
//            if (bBTopicInfo.isSetUsed_time()) {
//                lVar.mo18493a(bBTopicInfo.used_time);
//            }
//            if (bBTopicInfo.isSetWrong_times()) {
//                lVar.mo18493a(bBTopicInfo.wrong_times);
//            }
//            if (bBTopicInfo.isSetDone_times()) {
//                lVar.mo18493a(bBTopicInfo.done_times);
//            }
//            if (bBTopicInfo.isSetSpan_days()) {
//                lVar.mo18493a(bBTopicInfo.span_days);
//            }
//            if (bBTopicInfo.isSetUpdate_days()) {
//                lVar.mo18493a(bBTopicInfo.update_days);
//            }
//        }
//
//        public void read(C2100f fVar, BBTopicInfo bBTopicInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBTopicInfo.topic_id = lVar.mo18513n();
//            bBTopicInfo.setTopic_idIsSet(true);
//            BitSet b = lVar.mo18528b(6);
//            if (b.get(0)) {
//                bBTopicInfo.score = lVar.mo18513n();
//                bBTopicInfo.setScoreIsSet(true);
//            }
//            if (b.get(1)) {
//                bBTopicInfo.used_time = lVar.mo18513n();
//                bBTopicInfo.setUsed_timeIsSet(true);
//            }
//            if (b.get(2)) {
//                bBTopicInfo.wrong_times = lVar.mo18513n();
//                bBTopicInfo.setWrong_timesIsSet(true);
//            }
//            if (b.get(3)) {
//                bBTopicInfo.done_times = lVar.mo18513n();
//                bBTopicInfo.setDone_timesIsSet(true);
//            }
//            if (b.get(4)) {
//                bBTopicInfo.span_days = lVar.mo18513n();
//                bBTopicInfo.setSpan_daysIsSet(true);
//            }
//            if (b.get(5)) {
//                bBTopicInfo.update_days = lVar.mo18513n();
//                bBTopicInfo.setUpdate_daysIsSet(true);
//            }
//        }
//    }
//
//    class BBTopicInfoTupleSchemeFactory implements C2109b {
//        private BBTopicInfoTupleSchemeFactory() {
//        }
//
//        public BBTopicInfoTupleScheme getScheme() {
//            return new BBTopicInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        SCORE(2, "score"),
//        USED_TIME(3, "used_time"),
//        WRONG_TIMES(4, "wrong_times"),
//        DONE_TIMES(5, "done_times"),
//        SPAN_DAYS(6, "span_days"),
//        UPDATE_DAYS(7, "update_days");
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
//                    return SCORE;
//                case 3:
//                    return USED_TIME;
//                case 4:
//                    return WRONG_TIMES;
//                case 5:
//                    return DONE_TIMES;
//                case 6:
//                    return SPAN_DAYS;
//                case 7:
//                    return UPDATE_DAYS;
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
//        hashMap.put(C2110c.class, new BBTopicInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBTopicInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SCORE, new C2091a("score", 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.USED_TIME, new C2091a("used_time", 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.WRONG_TIMES, new C2091a("wrong_times", 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.DONE_TIMES, new C2091a("done_times", 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.SPAN_DAYS, new C2091a("span_days", 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.UPDATE_DAYS, new C2091a("update_days", 2, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBTopicInfo.class, metaDataMap);
//    }
//
//    public BBTopicInfo() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.SCORE, _Fields.USED_TIME, _Fields.WRONG_TIMES, _Fields.DONE_TIMES, _Fields.SPAN_DAYS, _Fields.UPDATE_DAYS};
//    }
//
//    public BBTopicInfo(int i) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//    }
//
//    public BBTopicInfo(BBTopicInfo bBTopicInfo) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.SCORE, _Fields.USED_TIME, _Fields.WRONG_TIMES, _Fields.DONE_TIMES, _Fields.SPAN_DAYS, _Fields.UPDATE_DAYS};
//        this.__isset_bitfield = bBTopicInfo.__isset_bitfield;
//        this.topic_id = bBTopicInfo.topic_id;
//        this.score = bBTopicInfo.score;
//        this.used_time = bBTopicInfo.used_time;
//        this.wrong_times = bBTopicInfo.wrong_times;
//        this.done_times = bBTopicInfo.done_times;
//        this.span_days = bBTopicInfo.span_days;
//        this.update_days = bBTopicInfo.update_days;
//    }
//
//    public BBTopicInfo deepCopy() {
//        return new BBTopicInfo(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        setScoreIsSet(false);
//        this.score = 0;
//        setUsed_timeIsSet(false);
//        this.used_time = 0;
//        setWrong_timesIsSet(false);
//        this.wrong_times = 0;
//        setDone_timesIsSet(false);
//        this.done_times = 0;
//        setSpan_daysIsSet(false);
//        this.span_days = 0;
//        setUpdate_daysIsSet(false);
//        this.update_days = 0;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBTopicInfo setTopic_id(int i) {
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
//    public int getScore() {
//        return this.score;
//    }
//
//    public BBTopicInfo setScore(int i) {
//        this.score = i;
//        setScoreIsSet(true);
//        return this;
//    }
//
//    public void unsetScore() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetScore() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setScoreIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getUsed_time() {
//        return this.used_time;
//    }
//
//    public BBTopicInfo setUsed_time(int i) {
//        this.used_time = i;
//        setUsed_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetUsed_time() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetUsed_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setUsed_timeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public int getWrong_times() {
//        return this.wrong_times;
//    }
//
//    public BBTopicInfo setWrong_times(int i) {
//        this.wrong_times = i;
//        setWrong_timesIsSet(true);
//        return this;
//    }
//
//    public void unsetWrong_times() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetWrong_times() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setWrong_timesIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public int getDone_times() {
//        return this.done_times;
//    }
//
//    public BBTopicInfo setDone_times(int i) {
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
//    public int getSpan_days() {
//        return this.span_days;
//    }
//
//    public BBTopicInfo setSpan_days(int i) {
//        this.span_days = i;
//        setSpan_daysIsSet(true);
//        return this;
//    }
//
//    public void unsetSpan_days() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -33);
//    }
//
//    public boolean isSetSpan_days() {
//        return C2090b.m5429a(this.__isset_bitfield, 5);
//    }
//
//    public void setSpan_daysIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 5, z);
//    }
//
//    public int getUpdate_days() {
//        return this.update_days;
//    }
//
//    public BBTopicInfo setUpdate_days(int i) {
//        this.update_days = i;
//        setUpdate_daysIsSet(true);
//        return this;
//    }
//
//    public void unsetUpdate_days() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -65);
//    }
//
//    public boolean isSetUpdate_days() {
//        return C2090b.m5429a(this.__isset_bitfield, 6);
//    }
//
//    public void setUpdate_daysIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 6, z);
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
//            case SCORE:
//                if (obj == null) {
//                    unsetScore();
//                    return;
//                } else {
//                    setScore(((Integer) obj).intValue());
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
//            case WRONG_TIMES:
//                if (obj == null) {
//                    unsetWrong_times();
//                    return;
//                } else {
//                    setWrong_times(((Integer) obj).intValue());
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
//            case SPAN_DAYS:
//                if (obj == null) {
//                    unsetSpan_days();
//                    return;
//                } else {
//                    setSpan_days(((Integer) obj).intValue());
//                    return;
//                }
//            case UPDATE_DAYS:
//                if (obj == null) {
//                    unsetUpdate_days();
//                    return;
//                } else {
//                    setUpdate_days(((Integer) obj).intValue());
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
//            case SCORE:
//                return Integer.valueOf(getScore());
//            case USED_TIME:
//                return Integer.valueOf(getUsed_time());
//            case WRONG_TIMES:
//                return Integer.valueOf(getWrong_times());
//            case DONE_TIMES:
//                return Integer.valueOf(getDone_times());
//            case SPAN_DAYS:
//                return Integer.valueOf(getSpan_days());
//            case UPDATE_DAYS:
//                return Integer.valueOf(getUpdate_days());
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
//            case SCORE:
//                return isSetScore();
//            case USED_TIME:
//                return isSetUsed_time();
//            case WRONG_TIMES:
//                return isSetWrong_times();
//            case DONE_TIMES:
//                return isSetDone_times();
//            case SPAN_DAYS:
//                return isSetSpan_days();
//            case UPDATE_DAYS:
//                return isSetUpdate_days();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBTopicInfo)) {
//            return equals((BBTopicInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBTopicInfo bBTopicInfo) {
//        if (bBTopicInfo == null || this.topic_id != bBTopicInfo.topic_id) {
//            return false;
//        }
//        boolean isSetScore = isSetScore();
//        boolean isSetScore2 = bBTopicInfo.isSetScore();
//        if ((isSetScore || isSetScore2) && (!isSetScore || !isSetScore2 || this.score != bBTopicInfo.score)) {
//            return false;
//        }
//        boolean isSetUsed_time = isSetUsed_time();
//        boolean isSetUsed_time2 = bBTopicInfo.isSetUsed_time();
//        if ((isSetUsed_time || isSetUsed_time2) && (!isSetUsed_time || !isSetUsed_time2 || this.used_time != bBTopicInfo.used_time)) {
//            return false;
//        }
//        boolean isSetWrong_times = isSetWrong_times();
//        boolean isSetWrong_times2 = bBTopicInfo.isSetWrong_times();
//        if ((isSetWrong_times || isSetWrong_times2) && (!isSetWrong_times || !isSetWrong_times2 || this.wrong_times != bBTopicInfo.wrong_times)) {
//            return false;
//        }
//        boolean isSetDone_times = isSetDone_times();
//        boolean isSetDone_times2 = bBTopicInfo.isSetDone_times();
//        if ((isSetDone_times || isSetDone_times2) && (!isSetDone_times || !isSetDone_times2 || this.done_times != bBTopicInfo.done_times)) {
//            return false;
//        }
//        boolean isSetSpan_days = isSetSpan_days();
//        boolean isSetSpan_days2 = bBTopicInfo.isSetSpan_days();
//        if ((isSetSpan_days || isSetSpan_days2) && (!isSetSpan_days || !isSetSpan_days2 || this.span_days != bBTopicInfo.span_days)) {
//            return false;
//        }
//        boolean isSetUpdate_days = isSetUpdate_days();
//        boolean isSetUpdate_days2 = bBTopicInfo.isSetUpdate_days();
//        if ((isSetUpdate_days || isSetUpdate_days2) && (!isSetUpdate_days || !isSetUpdate_days2 || this.update_days != bBTopicInfo.update_days)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBTopicInfo bBTopicInfo) {
//        if (!getClass().equals(bBTopicInfo.getClass())) {
//            return getClass().getName().compareTo(bBTopicInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBTopicInfo.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBTopicInfo.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetScore()).compareTo(Boolean.valueOf(bBTopicInfo.isSetScore()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetScore()) {
//            int a2 = C2121h.m5522a(this.score, bBTopicInfo.score);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetUsed_time()).compareTo(Boolean.valueOf(bBTopicInfo.isSetUsed_time()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetUsed_time()) {
//            int a3 = C2121h.m5522a(this.used_time, bBTopicInfo.used_time);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetWrong_times()).compareTo(Boolean.valueOf(bBTopicInfo.isSetWrong_times()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetWrong_times()) {
//            int a4 = C2121h.m5522a(this.wrong_times, bBTopicInfo.wrong_times);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetDone_times()).compareTo(Boolean.valueOf(bBTopicInfo.isSetDone_times()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetDone_times()) {
//            int a5 = C2121h.m5522a(this.done_times, bBTopicInfo.done_times);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetSpan_days()).compareTo(Boolean.valueOf(bBTopicInfo.isSetSpan_days()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetSpan_days()) {
//            int a6 = C2121h.m5522a(this.span_days, bBTopicInfo.span_days);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetUpdate_days()).compareTo(Boolean.valueOf(bBTopicInfo.isSetUpdate_days()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetUpdate_days()) {
//            int a7 = C2121h.m5522a(this.update_days, bBTopicInfo.update_days);
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
//        StringBuilder sb = new StringBuilder("BBTopicInfo(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        if (isSetScore()) {
//            sb.append(", ");
//            sb.append("score:");
//            sb.append(this.score);
//        }
//        if (isSetUsed_time()) {
//            sb.append(", ");
//            sb.append("used_time:");
//            sb.append(this.used_time);
//        }
//        if (isSetWrong_times()) {
//            sb.append(", ");
//            sb.append("wrong_times:");
//            sb.append(this.wrong_times);
//        }
//        if (isSetDone_times()) {
//            sb.append(", ");
//            sb.append("done_times:");
//            sb.append(this.done_times);
//        }
//        if (isSetSpan_days()) {
//            sb.append(", ");
//            sb.append("span_days:");
//            sb.append(this.span_days);
//        }
//        if (isSetUpdate_days()) {
//            sb.append(", ");
//            sb.append("update_days:");
//            sb.append(this.update_days);
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
