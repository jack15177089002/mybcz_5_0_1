//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_WORD_DONE_TB.Columns;
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
//public class BBDoneWordStatLog implements Serializable, Cloneable, Comparable<BBDoneWordStatLog>, C2116f<BBDoneWordStatLog, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b DONE_TYPE_FIELD_DESC = new C2097b(Columns.DONE_TYPE, 8, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b DURATION_FIELD_DESC = new C2097b(Columns.DURATION, 8, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_DONE_RIGHT_FIELD_DESC = new C2097b(Columns.IS_DONE_RIGHT, 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_TODAY_NEW_FIELD_DESC = new C2097b("is_today_new", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b OPTION_FIELD_DESC = new C2097b(Columns.OPTION, 8, 4);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBDoneWordStatLog");
//    /* access modifiers changed from: private */
//    public static final C2097b TAG_ID_FIELD_DESC = new C2097b("tag_id", 8, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    private static final int __DONE_TYPE_ISSET_ID = 4;
//    private static final int __DURATION_ISSET_ID = 5;
//    private static final int __IS_DONE_RIGHT_ISSET_ID = 2;
//    private static final int __IS_TODAY_NEW_ISSET_ID = 1;
//    private static final int __OPTION_ISSET_ID = 3;
//    private static final int __TAG_ID_ISSET_ID = 6;
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int done_type;
//    public int duration;
//    public int is_done_right;
//    public int is_today_new;
//    public int option;
//    private _Fields[] optionals;
//    public int tag_id;
//    public int topic_id;
//
//    class BBDoneWordStatLogStandardScheme extends C2110c<BBDoneWordStatLog> {
//        private BBDoneWordStatLogStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBDoneWordStatLog bBDoneWordStatLog) {
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
//                                bBDoneWordStatLog.topic_id = fVar.mo18513n();
//                                bBDoneWordStatLog.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneWordStatLog.is_today_new = fVar.mo18513n();
//                                bBDoneWordStatLog.setIs_today_newIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneWordStatLog.is_done_right = fVar.mo18513n();
//                                bBDoneWordStatLog.setIs_done_rightIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneWordStatLog.option = fVar.mo18513n();
//                                bBDoneWordStatLog.setOptionIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneWordStatLog.done_type = fVar.mo18513n();
//                                bBDoneWordStatLog.setDone_typeIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneWordStatLog.duration = fVar.mo18513n();
//                                bBDoneWordStatLog.setDurationIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDoneWordStatLog.tag_id = fVar.mo18513n();
//                                bBDoneWordStatLog.setTag_idIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBDoneWordStatLog.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneWordStatLog.isSetIs_today_new()) {
//                        throw new C2101g("Required field 'is_today_new' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneWordStatLog.isSetIs_done_right()) {
//                        throw new C2101g("Required field 'is_done_right' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneWordStatLog.isSetOption()) {
//                        throw new C2101g("Required field 'option' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneWordStatLog.isSetDone_type()) {
//                        throw new C2101g("Required field 'done_type' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBDoneWordStatLog.isSetDuration()) {
//                        throw new C2101g("Required field 'duration' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBDoneWordStatLog.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBDoneWordStatLog bBDoneWordStatLog) {
//            bBDoneWordStatLog.validate();
//            BBDoneWordStatLog.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBDoneWordStatLog.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBDoneWordStatLog.topic_id);
//            fVar.mo18496a(BBDoneWordStatLog.IS_TODAY_NEW_FIELD_DESC);
//            fVar.mo18493a(bBDoneWordStatLog.is_today_new);
//            fVar.mo18496a(BBDoneWordStatLog.IS_DONE_RIGHT_FIELD_DESC);
//            fVar.mo18493a(bBDoneWordStatLog.is_done_right);
//            fVar.mo18496a(BBDoneWordStatLog.OPTION_FIELD_DESC);
//            fVar.mo18493a(bBDoneWordStatLog.option);
//            fVar.mo18496a(BBDoneWordStatLog.DONE_TYPE_FIELD_DESC);
//            fVar.mo18493a(bBDoneWordStatLog.done_type);
//            fVar.mo18496a(BBDoneWordStatLog.DURATION_FIELD_DESC);
//            fVar.mo18493a(bBDoneWordStatLog.duration);
//            if (bBDoneWordStatLog.isSetTag_id()) {
//                fVar.mo18496a(BBDoneWordStatLog.TAG_ID_FIELD_DESC);
//                fVar.mo18493a(bBDoneWordStatLog.tag_id);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBDoneWordStatLogStandardSchemeFactory implements C2109b {
//        private BBDoneWordStatLogStandardSchemeFactory() {
//        }
//
//        public BBDoneWordStatLogStandardScheme getScheme() {
//            return new BBDoneWordStatLogStandardScheme();
//        }
//    }
//
//    class BBDoneWordStatLogTupleScheme extends C2111d<BBDoneWordStatLog> {
//        private BBDoneWordStatLogTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBDoneWordStatLog bBDoneWordStatLog) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBDoneWordStatLog.topic_id);
//            lVar.mo18493a(bBDoneWordStatLog.is_today_new);
//            lVar.mo18493a(bBDoneWordStatLog.is_done_right);
//            lVar.mo18493a(bBDoneWordStatLog.option);
//            lVar.mo18493a(bBDoneWordStatLog.done_type);
//            lVar.mo18493a(bBDoneWordStatLog.duration);
//            BitSet bitSet = new BitSet();
//            if (bBDoneWordStatLog.isSetTag_id()) {
//                bitSet.set(0);
//            }
//            lVar.mo18527a(bitSet, 1);
//            if (bBDoneWordStatLog.isSetTag_id()) {
//                lVar.mo18493a(bBDoneWordStatLog.tag_id);
//            }
//        }
//
//        public void read(C2100f fVar, BBDoneWordStatLog bBDoneWordStatLog) {
//            C2106l lVar = (C2106l) fVar;
//            bBDoneWordStatLog.topic_id = lVar.mo18513n();
//            bBDoneWordStatLog.setTopic_idIsSet(true);
//            bBDoneWordStatLog.is_today_new = lVar.mo18513n();
//            bBDoneWordStatLog.setIs_today_newIsSet(true);
//            bBDoneWordStatLog.is_done_right = lVar.mo18513n();
//            bBDoneWordStatLog.setIs_done_rightIsSet(true);
//            bBDoneWordStatLog.option = lVar.mo18513n();
//            bBDoneWordStatLog.setOptionIsSet(true);
//            bBDoneWordStatLog.done_type = lVar.mo18513n();
//            bBDoneWordStatLog.setDone_typeIsSet(true);
//            bBDoneWordStatLog.duration = lVar.mo18513n();
//            bBDoneWordStatLog.setDurationIsSet(true);
//            if (lVar.mo18528b(1).get(0)) {
//                bBDoneWordStatLog.tag_id = lVar.mo18513n();
//                bBDoneWordStatLog.setTag_idIsSet(true);
//            }
//        }
//    }
//
//    class BBDoneWordStatLogTupleSchemeFactory implements C2109b {
//        private BBDoneWordStatLogTupleSchemeFactory() {
//        }
//
//        public BBDoneWordStatLogTupleScheme getScheme() {
//            return new BBDoneWordStatLogTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        IS_TODAY_NEW(2, "is_today_new"),
//        IS_DONE_RIGHT(3, Columns.IS_DONE_RIGHT),
//        OPTION(4, Columns.OPTION),
//        DONE_TYPE(5, Columns.DONE_TYPE),
//        DURATION(6, Columns.DURATION),
//        TAG_ID(7, "tag_id");
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
//                    return IS_TODAY_NEW;
//                case 3:
//                    return IS_DONE_RIGHT;
//                case 4:
//                    return OPTION;
//                case 5:
//                    return DONE_TYPE;
//                case 6:
//                    return DURATION;
//                case 7:
//                    return TAG_ID;
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
//        hashMap.put(C2110c.class, new BBDoneWordStatLogStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBDoneWordStatLogTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.IS_TODAY_NEW, new C2091a("is_today_new", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.IS_DONE_RIGHT, new C2091a(Columns.IS_DONE_RIGHT, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.OPTION, new C2091a(Columns.OPTION, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.DONE_TYPE, new C2091a(Columns.DONE_TYPE, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.DURATION, new C2091a(Columns.DURATION, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.TAG_ID, new C2091a("tag_id", 2, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBDoneWordStatLog.class, metaDataMap);
//    }
//
//    public BBDoneWordStatLog() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.TAG_ID};
//    }
//
//    public BBDoneWordStatLog(int i, int i2, int i3, int i4, int i5, int i6) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.is_today_new = i2;
//        setIs_today_newIsSet(true);
//        this.is_done_right = i3;
//        setIs_done_rightIsSet(true);
//        this.option = i4;
//        setOptionIsSet(true);
//        this.done_type = i5;
//        setDone_typeIsSet(true);
//        this.duration = i6;
//        setDurationIsSet(true);
//    }
//
//    public BBDoneWordStatLog(BBDoneWordStatLog bBDoneWordStatLog) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.TAG_ID};
//        this.__isset_bitfield = bBDoneWordStatLog.__isset_bitfield;
//        this.topic_id = bBDoneWordStatLog.topic_id;
//        this.is_today_new = bBDoneWordStatLog.is_today_new;
//        this.is_done_right = bBDoneWordStatLog.is_done_right;
//        this.option = bBDoneWordStatLog.option;
//        this.done_type = bBDoneWordStatLog.done_type;
//        this.duration = bBDoneWordStatLog.duration;
//        this.tag_id = bBDoneWordStatLog.tag_id;
//    }
//
//    public BBDoneWordStatLog deepCopy() {
//        return new BBDoneWordStatLog(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        setIs_today_newIsSet(false);
//        this.is_today_new = 0;
//        setIs_done_rightIsSet(false);
//        this.is_done_right = 0;
//        setOptionIsSet(false);
//        this.option = 0;
//        setDone_typeIsSet(false);
//        this.done_type = 0;
//        setDurationIsSet(false);
//        this.duration = 0;
//        setTag_idIsSet(false);
//        this.tag_id = 0;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBDoneWordStatLog setTopic_id(int i) {
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
//    public int getIs_today_new() {
//        return this.is_today_new;
//    }
//
//    public BBDoneWordStatLog setIs_today_new(int i) {
//        this.is_today_new = i;
//        setIs_today_newIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_today_new() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetIs_today_new() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setIs_today_newIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getIs_done_right() {
//        return this.is_done_right;
//    }
//
//    public BBDoneWordStatLog setIs_done_right(int i) {
//        this.is_done_right = i;
//        setIs_done_rightIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_done_right() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetIs_done_right() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setIs_done_rightIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public int getOption() {
//        return this.option;
//    }
//
//    public BBDoneWordStatLog setOption(int i) {
//        this.option = i;
//        setOptionIsSet(true);
//        return this;
//    }
//
//    public void unsetOption() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetOption() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setOptionIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public int getDone_type() {
//        return this.done_type;
//    }
//
//    public BBDoneWordStatLog setDone_type(int i) {
//        this.done_type = i;
//        setDone_typeIsSet(true);
//        return this;
//    }
//
//    public void unsetDone_type() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetDone_type() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setDone_typeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 4, z);
//    }
//
//    public int getDuration() {
//        return this.duration;
//    }
//
//    public BBDoneWordStatLog setDuration(int i) {
//        this.duration = i;
//        setDurationIsSet(true);
//        return this;
//    }
//
//    public void unsetDuration() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -33);
//    }
//
//    public boolean isSetDuration() {
//        return C2090b.m5429a(this.__isset_bitfield, 5);
//    }
//
//    public void setDurationIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 5, z);
//    }
//
//    public int getTag_id() {
//        return this.tag_id;
//    }
//
//    public BBDoneWordStatLog setTag_id(int i) {
//        this.tag_id = i;
//        setTag_idIsSet(true);
//        return this;
//    }
//
//    public void unsetTag_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -65);
//    }
//
//    public boolean isSetTag_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 6);
//    }
//
//    public void setTag_idIsSet(boolean z) {
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
//            case IS_TODAY_NEW:
//                if (obj == null) {
//                    unsetIs_today_new();
//                    return;
//                } else {
//                    setIs_today_new(((Integer) obj).intValue());
//                    return;
//                }
//            case IS_DONE_RIGHT:
//                if (obj == null) {
//                    unsetIs_done_right();
//                    return;
//                } else {
//                    setIs_done_right(((Integer) obj).intValue());
//                    return;
//                }
//            case OPTION:
//                if (obj == null) {
//                    unsetOption();
//                    return;
//                } else {
//                    setOption(((Integer) obj).intValue());
//                    return;
//                }
//            case DONE_TYPE:
//                if (obj == null) {
//                    unsetDone_type();
//                    return;
//                } else {
//                    setDone_type(((Integer) obj).intValue());
//                    return;
//                }
//            case DURATION:
//                if (obj == null) {
//                    unsetDuration();
//                    return;
//                } else {
//                    setDuration(((Integer) obj).intValue());
//                    return;
//                }
//            case TAG_ID:
//                if (obj == null) {
//                    unsetTag_id();
//                    return;
//                } else {
//                    setTag_id(((Integer) obj).intValue());
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
//            case IS_TODAY_NEW:
//                return Integer.valueOf(getIs_today_new());
//            case IS_DONE_RIGHT:
//                return Integer.valueOf(getIs_done_right());
//            case OPTION:
//                return Integer.valueOf(getOption());
//            case DONE_TYPE:
//                return Integer.valueOf(getDone_type());
//            case DURATION:
//                return Integer.valueOf(getDuration());
//            case TAG_ID:
//                return Integer.valueOf(getTag_id());
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
//            case IS_TODAY_NEW:
//                return isSetIs_today_new();
//            case IS_DONE_RIGHT:
//                return isSetIs_done_right();
//            case OPTION:
//                return isSetOption();
//            case DONE_TYPE:
//                return isSetDone_type();
//            case DURATION:
//                return isSetDuration();
//            case TAG_ID:
//                return isSetTag_id();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBDoneWordStatLog)) {
//            return equals((BBDoneWordStatLog) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBDoneWordStatLog bBDoneWordStatLog) {
//        if (bBDoneWordStatLog == null || this.topic_id != bBDoneWordStatLog.topic_id || this.is_today_new != bBDoneWordStatLog.is_today_new || this.is_done_right != bBDoneWordStatLog.is_done_right || this.option != bBDoneWordStatLog.option || this.done_type != bBDoneWordStatLog.done_type || this.duration != bBDoneWordStatLog.duration) {
//            return false;
//        }
//        boolean isSetTag_id = isSetTag_id();
//        boolean isSetTag_id2 = bBDoneWordStatLog.isSetTag_id();
//        if ((isSetTag_id || isSetTag_id2) && (!isSetTag_id || !isSetTag_id2 || this.tag_id != bBDoneWordStatLog.tag_id)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBDoneWordStatLog bBDoneWordStatLog) {
//        if (!getClass().equals(bBDoneWordStatLog.getClass())) {
//            return getClass().getName().compareTo(bBDoneWordStatLog.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBDoneWordStatLog.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBDoneWordStatLog.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetIs_today_new()).compareTo(Boolean.valueOf(bBDoneWordStatLog.isSetIs_today_new()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetIs_today_new()) {
//            int a2 = C2121h.m5522a(this.is_today_new, bBDoneWordStatLog.is_today_new);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetIs_done_right()).compareTo(Boolean.valueOf(bBDoneWordStatLog.isSetIs_done_right()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetIs_done_right()) {
//            int a3 = C2121h.m5522a(this.is_done_right, bBDoneWordStatLog.is_done_right);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetOption()).compareTo(Boolean.valueOf(bBDoneWordStatLog.isSetOption()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetOption()) {
//            int a4 = C2121h.m5522a(this.option, bBDoneWordStatLog.option);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetDone_type()).compareTo(Boolean.valueOf(bBDoneWordStatLog.isSetDone_type()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetDone_type()) {
//            int a5 = C2121h.m5522a(this.done_type, bBDoneWordStatLog.done_type);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetDuration()).compareTo(Boolean.valueOf(bBDoneWordStatLog.isSetDuration()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetDuration()) {
//            int a6 = C2121h.m5522a(this.duration, bBDoneWordStatLog.duration);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetTag_id()).compareTo(Boolean.valueOf(bBDoneWordStatLog.isSetTag_id()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetTag_id()) {
//            int a7 = C2121h.m5522a(this.tag_id, bBDoneWordStatLog.tag_id);
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
//        StringBuilder sb = new StringBuilder("BBDoneWordStatLog(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("is_today_new:");
//        sb.append(this.is_today_new);
//        sb.append(", ");
//        sb.append("is_done_right:");
//        sb.append(this.is_done_right);
//        sb.append(", ");
//        sb.append("option:");
//        sb.append(this.option);
//        sb.append(", ");
//        sb.append("done_type:");
//        sb.append(this.done_type);
//        sb.append(", ");
//        sb.append("duration:");
//        sb.append(this.duration);
//        if (isSetTag_id()) {
//            sb.append(", ");
//            sb.append("tag_id:");
//            sb.append(this.tag_id);
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
