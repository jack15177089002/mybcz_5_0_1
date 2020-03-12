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
//public class BBUserSelectedBookInfo implements Serializable, Cloneable, Comparable<BBUserSelectedBookInfo>, C2116f<BBUserSelectedBookInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b LAST_TOUCH_AT_FIELD_DESC = new C2097b("last_touch_at", 10, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b LEARNED_WORDS_COUNT_FIELD_DESC = new C2097b("learned_words_count", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b ROADMAP_VERSION_FIELD_DESC = new C2097b("roadmap_version", 10, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b SELECTED_END_TIME_FIELD_DESC = new C2097b("selected_end_time", 10, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserSelectedBookInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FM_UPDATED_AT_FIELD_DESC = new C2097b("word_fm_updated_at", 10, 6);
//    private static final int __BOOK_ID_ISSET_ID = 0;
//    private static final int __LAST_TOUCH_AT_ISSET_ID = 3;
//    private static final int __LEARNED_WORDS_COUNT_ISSET_ID = 2;
//    private static final int __ROADMAP_VERSION_ISSET_ID = 4;
//    private static final int __SELECTED_END_TIME_ISSET_ID = 1;
//    private static final int __WORD_FM_UPDATED_AT_ISSET_ID = 5;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int book_id;
//    public long last_touch_at;
//    public int learned_words_count;
//    public long roadmap_version;
//    public long selected_end_time;
//    public long word_fm_updated_at;
//
//    class BBUserSelectedBookInfoStandardScheme extends C2110c<BBUserSelectedBookInfo> {
//        private BBUserSelectedBookInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserSelectedBookInfo bBUserSelectedBookInfo) {
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
//                                bBUserSelectedBookInfo.book_id = fVar.mo18513n();
//                                bBUserSelectedBookInfo.setBook_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserSelectedBookInfo.selected_end_time = fVar.mo18514o();
//                                bBUserSelectedBookInfo.setSelected_end_timeIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserSelectedBookInfo.learned_words_count = fVar.mo18513n();
//                                bBUserSelectedBookInfo.setLearned_words_countIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserSelectedBookInfo.last_touch_at = fVar.mo18514o();
//                                bBUserSelectedBookInfo.setLast_touch_atIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserSelectedBookInfo.roadmap_version = fVar.mo18514o();
//                                bBUserSelectedBookInfo.setRoadmap_versionIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserSelectedBookInfo.word_fm_updated_at = fVar.mo18514o();
//                                bBUserSelectedBookInfo.setWord_fm_updated_atIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBUserSelectedBookInfo.isSetBook_id()) {
//                        throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserSelectedBookInfo.isSetSelected_end_time()) {
//                        throw new C2101g("Required field 'selected_end_time' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserSelectedBookInfo.isSetLearned_words_count()) {
//                        throw new C2101g("Required field 'learned_words_count' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserSelectedBookInfo.isSetLast_touch_at()) {
//                        throw new C2101g("Required field 'last_touch_at' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserSelectedBookInfo.isSetRoadmap_version()) {
//                        throw new C2101g("Required field 'roadmap_version' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserSelectedBookInfo.isSetWord_fm_updated_at()) {
//                        throw new C2101g("Required field 'word_fm_updated_at' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBUserSelectedBookInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserSelectedBookInfo bBUserSelectedBookInfo) {
//            bBUserSelectedBookInfo.validate();
//            BBUserSelectedBookInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBUserSelectedBookInfo.BOOK_ID_FIELD_DESC);
//            fVar.mo18493a(bBUserSelectedBookInfo.book_id);
//            fVar.mo18496a(BBUserSelectedBookInfo.SELECTED_END_TIME_FIELD_DESC);
//            fVar.mo18494a(bBUserSelectedBookInfo.selected_end_time);
//            fVar.mo18496a(BBUserSelectedBookInfo.LEARNED_WORDS_COUNT_FIELD_DESC);
//            fVar.mo18493a(bBUserSelectedBookInfo.learned_words_count);
//            fVar.mo18496a(BBUserSelectedBookInfo.LAST_TOUCH_AT_FIELD_DESC);
//            fVar.mo18494a(bBUserSelectedBookInfo.last_touch_at);
//            fVar.mo18496a(BBUserSelectedBookInfo.ROADMAP_VERSION_FIELD_DESC);
//            fVar.mo18494a(bBUserSelectedBookInfo.roadmap_version);
//            fVar.mo18496a(BBUserSelectedBookInfo.WORD_FM_UPDATED_AT_FIELD_DESC);
//            fVar.mo18494a(bBUserSelectedBookInfo.word_fm_updated_at);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserSelectedBookInfoStandardSchemeFactory implements C2109b {
//        private BBUserSelectedBookInfoStandardSchemeFactory() {
//        }
//
//        public BBUserSelectedBookInfoStandardScheme getScheme() {
//            return new BBUserSelectedBookInfoStandardScheme();
//        }
//    }
//
//    class BBUserSelectedBookInfoTupleScheme extends C2111d<BBUserSelectedBookInfo> {
//        private BBUserSelectedBookInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserSelectedBookInfo bBUserSelectedBookInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBUserSelectedBookInfo.book_id);
//            lVar.mo18494a(bBUserSelectedBookInfo.selected_end_time);
//            lVar.mo18493a(bBUserSelectedBookInfo.learned_words_count);
//            lVar.mo18494a(bBUserSelectedBookInfo.last_touch_at);
//            lVar.mo18494a(bBUserSelectedBookInfo.roadmap_version);
//            lVar.mo18494a(bBUserSelectedBookInfo.word_fm_updated_at);
//        }
//
//        public void read(C2100f fVar, BBUserSelectedBookInfo bBUserSelectedBookInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserSelectedBookInfo.book_id = lVar.mo18513n();
//            bBUserSelectedBookInfo.setBook_idIsSet(true);
//            bBUserSelectedBookInfo.selected_end_time = lVar.mo18514o();
//            bBUserSelectedBookInfo.setSelected_end_timeIsSet(true);
//            bBUserSelectedBookInfo.learned_words_count = lVar.mo18513n();
//            bBUserSelectedBookInfo.setLearned_words_countIsSet(true);
//            bBUserSelectedBookInfo.last_touch_at = lVar.mo18514o();
//            bBUserSelectedBookInfo.setLast_touch_atIsSet(true);
//            bBUserSelectedBookInfo.roadmap_version = lVar.mo18514o();
//            bBUserSelectedBookInfo.setRoadmap_versionIsSet(true);
//            bBUserSelectedBookInfo.word_fm_updated_at = lVar.mo18514o();
//            bBUserSelectedBookInfo.setWord_fm_updated_atIsSet(true);
//        }
//    }
//
//    class BBUserSelectedBookInfoTupleSchemeFactory implements C2109b {
//        private BBUserSelectedBookInfoTupleSchemeFactory() {
//        }
//
//        public BBUserSelectedBookInfoTupleScheme getScheme() {
//            return new BBUserSelectedBookInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        BOOK_ID(1, "book_id"),
//        SELECTED_END_TIME(2, "selected_end_time"),
//        LEARNED_WORDS_COUNT(3, "learned_words_count"),
//        LAST_TOUCH_AT(4, "last_touch_at"),
//        ROADMAP_VERSION(5, "roadmap_version"),
//        WORD_FM_UPDATED_AT(6, "word_fm_updated_at");
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
//                    return BOOK_ID;
//                case 2:
//                    return SELECTED_END_TIME;
//                case 3:
//                    return LEARNED_WORDS_COUNT;
//                case 4:
//                    return LAST_TOUCH_AT;
//                case 5:
//                    return ROADMAP_VERSION;
//                case 6:
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
//        hashMap.put(C2110c.class, new BBUserSelectedBookInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserSelectedBookInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SELECTED_END_TIME, new C2091a("selected_end_time", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.LEARNED_WORDS_COUNT, new C2091a("learned_words_count", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.LAST_TOUCH_AT, new C2091a("last_touch_at", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.ROADMAP_VERSION, new C2091a("roadmap_version", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.WORD_FM_UPDATED_AT, new C2091a("word_fm_updated_at", 1, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserSelectedBookInfo.class, metaDataMap);
//    }
//
//    public BBUserSelectedBookInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBUserSelectedBookInfo(int i, long j, int i2, long j2, long j3, long j4) {
//        this();
//        this.book_id = i;
//        setBook_idIsSet(true);
//        this.selected_end_time = j;
//        setSelected_end_timeIsSet(true);
//        this.learned_words_count = i2;
//        setLearned_words_countIsSet(true);
//        this.last_touch_at = j2;
//        setLast_touch_atIsSet(true);
//        this.roadmap_version = j3;
//        setRoadmap_versionIsSet(true);
//        this.word_fm_updated_at = j4;
//        setWord_fm_updated_atIsSet(true);
//    }
//
//    public BBUserSelectedBookInfo(BBUserSelectedBookInfo bBUserSelectedBookInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBUserSelectedBookInfo.__isset_bitfield;
//        this.book_id = bBUserSelectedBookInfo.book_id;
//        this.selected_end_time = bBUserSelectedBookInfo.selected_end_time;
//        this.learned_words_count = bBUserSelectedBookInfo.learned_words_count;
//        this.last_touch_at = bBUserSelectedBookInfo.last_touch_at;
//        this.roadmap_version = bBUserSelectedBookInfo.roadmap_version;
//        this.word_fm_updated_at = bBUserSelectedBookInfo.word_fm_updated_at;
//    }
//
//    public BBUserSelectedBookInfo deepCopy() {
//        return new BBUserSelectedBookInfo(this);
//    }
//
//    public void clear() {
//        setBook_idIsSet(false);
//        this.book_id = 0;
//        setSelected_end_timeIsSet(false);
//        this.selected_end_time = 0;
//        setLearned_words_countIsSet(false);
//        this.learned_words_count = 0;
//        setLast_touch_atIsSet(false);
//        this.last_touch_at = 0;
//        setRoadmap_versionIsSet(false);
//        this.roadmap_version = 0;
//        setWord_fm_updated_atIsSet(false);
//        this.word_fm_updated_at = 0;
//    }
//
//    public int getBook_id() {
//        return this.book_id;
//    }
//
//    public BBUserSelectedBookInfo setBook_id(int i) {
//        this.book_id = i;
//        setBook_idIsSet(true);
//        return this;
//    }
//
//    public void unsetBook_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetBook_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setBook_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public long getSelected_end_time() {
//        return this.selected_end_time;
//    }
//
//    public BBUserSelectedBookInfo setSelected_end_time(long j) {
//        this.selected_end_time = j;
//        setSelected_end_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetSelected_end_time() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetSelected_end_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setSelected_end_timeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getLearned_words_count() {
//        return this.learned_words_count;
//    }
//
//    public BBUserSelectedBookInfo setLearned_words_count(int i) {
//        this.learned_words_count = i;
//        setLearned_words_countIsSet(true);
//        return this;
//    }
//
//    public void unsetLearned_words_count() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetLearned_words_count() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setLearned_words_countIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public long getLast_touch_at() {
//        return this.last_touch_at;
//    }
//
//    public BBUserSelectedBookInfo setLast_touch_at(long j) {
//        this.last_touch_at = j;
//        setLast_touch_atIsSet(true);
//        return this;
//    }
//
//    public void unsetLast_touch_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetLast_touch_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setLast_touch_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public long getRoadmap_version() {
//        return this.roadmap_version;
//    }
//
//    public BBUserSelectedBookInfo setRoadmap_version(long j) {
//        this.roadmap_version = j;
//        setRoadmap_versionIsSet(true);
//        return this;
//    }
//
//    public void unsetRoadmap_version() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetRoadmap_version() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setRoadmap_versionIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 4, z);
//    }
//
//    public long getWord_fm_updated_at() {
//        return this.word_fm_updated_at;
//    }
//
//    public BBUserSelectedBookInfo setWord_fm_updated_at(long j) {
//        this.word_fm_updated_at = j;
//        setWord_fm_updated_atIsSet(true);
//        return this;
//    }
//
//    public void unsetWord_fm_updated_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -33);
//    }
//
//    public boolean isSetWord_fm_updated_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 5);
//    }
//
//    public void setWord_fm_updated_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 5, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case BOOK_ID:
//                if (obj == null) {
//                    unsetBook_id();
//                    return;
//                } else {
//                    setBook_id(((Integer) obj).intValue());
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
//            case LEARNED_WORDS_COUNT:
//                if (obj == null) {
//                    unsetLearned_words_count();
//                    return;
//                } else {
//                    setLearned_words_count(((Integer) obj).intValue());
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
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case BOOK_ID:
//                return Integer.valueOf(getBook_id());
//            case SELECTED_END_TIME:
//                return Long.valueOf(getSelected_end_time());
//            case LEARNED_WORDS_COUNT:
//                return Integer.valueOf(getLearned_words_count());
//            case LAST_TOUCH_AT:
//                return Long.valueOf(getLast_touch_at());
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
//            case BOOK_ID:
//                return isSetBook_id();
//            case SELECTED_END_TIME:
//                return isSetSelected_end_time();
//            case LEARNED_WORDS_COUNT:
//                return isSetLearned_words_count();
//            case LAST_TOUCH_AT:
//                return isSetLast_touch_at();
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
//        if (obj != null && (obj instanceof BBUserSelectedBookInfo)) {
//            return equals((BBUserSelectedBookInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserSelectedBookInfo bBUserSelectedBookInfo) {
//        if (bBUserSelectedBookInfo != null && this.book_id == bBUserSelectedBookInfo.book_id && this.selected_end_time == bBUserSelectedBookInfo.selected_end_time && this.learned_words_count == bBUserSelectedBookInfo.learned_words_count && this.last_touch_at == bBUserSelectedBookInfo.last_touch_at && this.roadmap_version == bBUserSelectedBookInfo.roadmap_version && this.word_fm_updated_at == bBUserSelectedBookInfo.word_fm_updated_at) {
//            return true;
//        }
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserSelectedBookInfo bBUserSelectedBookInfo) {
//        if (!getClass().equals(bBUserSelectedBookInfo.getClass())) {
//            return getClass().getName().compareTo(bBUserSelectedBookInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(bBUserSelectedBookInfo.isSetBook_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetBook_id()) {
//            int a = C2121h.m5522a(this.book_id, bBUserSelectedBookInfo.book_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetSelected_end_time()).compareTo(Boolean.valueOf(bBUserSelectedBookInfo.isSetSelected_end_time()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetSelected_end_time()) {
//            int a2 = C2121h.m5523a(this.selected_end_time, bBUserSelectedBookInfo.selected_end_time);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetLearned_words_count()).compareTo(Boolean.valueOf(bBUserSelectedBookInfo.isSetLearned_words_count()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetLearned_words_count()) {
//            int a3 = C2121h.m5522a(this.learned_words_count, bBUserSelectedBookInfo.learned_words_count);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetLast_touch_at()).compareTo(Boolean.valueOf(bBUserSelectedBookInfo.isSetLast_touch_at()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetLast_touch_at()) {
//            int a4 = C2121h.m5523a(this.last_touch_at, bBUserSelectedBookInfo.last_touch_at);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetRoadmap_version()).compareTo(Boolean.valueOf(bBUserSelectedBookInfo.isSetRoadmap_version()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetRoadmap_version()) {
//            int a5 = C2121h.m5523a(this.roadmap_version, bBUserSelectedBookInfo.roadmap_version);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetWord_fm_updated_at()).compareTo(Boolean.valueOf(bBUserSelectedBookInfo.isSetWord_fm_updated_at()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetWord_fm_updated_at()) {
//            int a6 = C2121h.m5523a(this.word_fm_updated_at, bBUserSelectedBookInfo.word_fm_updated_at);
//            if (a6 != 0) {
//                return a6;
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
//        StringBuilder sb = new StringBuilder("BBUserSelectedBookInfo(");
//        sb.append("book_id:");
//        sb.append(this.book_id);
//        sb.append(", ");
//        sb.append("selected_end_time:");
//        sb.append(this.selected_end_time);
//        sb.append(", ");
//        sb.append("learned_words_count:");
//        sb.append(this.learned_words_count);
//        sb.append(", ");
//        sb.append("last_touch_at:");
//        sb.append(this.last_touch_at);
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
