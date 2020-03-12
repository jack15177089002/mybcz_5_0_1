//package com.baicizhan.online.bs_users;
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
//import org.p100a.p101a.p103b.C2095e;
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
//public class BBUserLimit implements Serializable, Cloneable, Comparable<BBUserLimit>, C2116f<BBUserLimit, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b HAS_WORD_FRIENDS_FIELD_DESC = new C2097b("has_word_friends", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b MAX_ALLOW_LEARN_COUNT_FIELD_DESC = new C2097b("max_allow_learn_count", 8, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b MAX_ALLOW_LEARN_DAYS_FIELD_DESC = new C2097b("max_allow_learn_days", 8, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b SELECT_DATE_TIP_FIELD_DESC = new C2097b("select_date_tip", JceStruct.ZERO_TAG, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b SHOW_SENTENCE_TRANS_FIELD_DESC = new C2097b("show_sentence_trans", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserLimit");
//    /* access modifiers changed from: private */
//    public static final C2097b SUBMIT_USER_LOCAL_INFO_FIELD_DESC = new C2097b("submit_user_local_info", 8, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b UPLOAD_WORD_LOG_STAT_FIELD_DESC = new C2097b("upload_word_log_stat", 8, 8);
//    /* access modifiers changed from: private */
//    public static final C2097b VOCAB_TEST_FLAG_FIELD_DESC = new C2097b("vocab_test_flag", JceStruct.STRUCT_END, 7);
//    private static final int __HAS_WORD_FRIENDS_ISSET_ID = 1;
//    private static final int __MAX_ALLOW_LEARN_COUNT_ISSET_ID = 4;
//    private static final int __MAX_ALLOW_LEARN_DAYS_ISSET_ID = 3;
//    private static final int __SHOW_SENTENCE_TRANS_ISSET_ID = 0;
//    private static final int __SUBMIT_USER_LOCAL_INFO_ISSET_ID = 2;
//    private static final int __UPLOAD_WORD_LOG_STAT_ISSET_ID = 5;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int has_word_friends;
//    public int max_allow_learn_count;
//    public int max_allow_learn_days;
//    public BBSelectTip select_date_tip;
//    public int show_sentence_trans;
//    public int submit_user_local_info;
//    public int upload_word_log_stat;
//    public String vocab_test_flag;
//
//    class BBUserLimitStandardScheme extends C2110c<BBUserLimit> {
//        private BBUserLimitStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserLimit bBUserLimit) {
//            fVar.mo18504e();
//            while (true) {
//                C2097b g = fVar.mo18506g();
//                if (g.f5835b != 0) {
//                    switch (g.f5836c) {
//                        case 1:
//                            if (g.f5835b != 12) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserLimit.select_date_tip = new BBSelectTip();
//                                bBUserLimit.select_date_tip.read(fVar);
//                                bBUserLimit.setSelect_date_tipIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserLimit.show_sentence_trans = fVar.mo18513n();
//                                bBUserLimit.setShow_sentence_transIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserLimit.has_word_friends = fVar.mo18513n();
//                                bBUserLimit.setHas_word_friendsIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserLimit.submit_user_local_info = fVar.mo18513n();
//                                bBUserLimit.setSubmit_user_local_infoIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserLimit.max_allow_learn_days = fVar.mo18513n();
//                                bBUserLimit.setMax_allow_learn_daysIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserLimit.max_allow_learn_count = fVar.mo18513n();
//                                bBUserLimit.setMax_allow_learn_countIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserLimit.vocab_test_flag = fVar.mo18516q();
//                                bBUserLimit.setVocab_test_flagIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserLimit.upload_word_log_stat = fVar.mo18513n();
//                                bBUserLimit.setUpload_word_log_statIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBUserLimit.isSetShow_sentence_trans()) {
//                        throw new C2101g("Required field 'show_sentence_trans' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserLimit.isSetHas_word_friends()) {
//                        throw new C2101g("Required field 'has_word_friends' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserLimit.isSetSubmit_user_local_info()) {
//                        throw new C2101g("Required field 'submit_user_local_info' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserLimit.isSetMax_allow_learn_days()) {
//                        throw new C2101g("Required field 'max_allow_learn_days' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserLimit.isSetMax_allow_learn_count()) {
//                        throw new C2101g("Required field 'max_allow_learn_count' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserLimit.isSetUpload_word_log_stat()) {
//                        throw new C2101g("Required field 'upload_word_log_stat' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBUserLimit.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserLimit bBUserLimit) {
//            bBUserLimit.validate();
//            BBUserLimit.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBUserLimit.select_date_tip != null) {
//                fVar.mo18496a(BBUserLimit.SELECT_DATE_TIP_FIELD_DESC);
//                bBUserLimit.select_date_tip.write(fVar);
//            }
//            fVar.mo18496a(BBUserLimit.SHOW_SENTENCE_TRANS_FIELD_DESC);
//            fVar.mo18493a(bBUserLimit.show_sentence_trans);
//            fVar.mo18496a(BBUserLimit.HAS_WORD_FRIENDS_FIELD_DESC);
//            fVar.mo18493a(bBUserLimit.has_word_friends);
//            fVar.mo18496a(BBUserLimit.SUBMIT_USER_LOCAL_INFO_FIELD_DESC);
//            fVar.mo18493a(bBUserLimit.submit_user_local_info);
//            fVar.mo18496a(BBUserLimit.MAX_ALLOW_LEARN_DAYS_FIELD_DESC);
//            fVar.mo18493a(bBUserLimit.max_allow_learn_days);
//            fVar.mo18496a(BBUserLimit.MAX_ALLOW_LEARN_COUNT_FIELD_DESC);
//            fVar.mo18493a(bBUserLimit.max_allow_learn_count);
//            if (bBUserLimit.vocab_test_flag != null) {
//                fVar.mo18496a(BBUserLimit.VOCAB_TEST_FLAG_FIELD_DESC);
//                fVar.mo18495a(bBUserLimit.vocab_test_flag);
//            }
//            fVar.mo18496a(BBUserLimit.UPLOAD_WORD_LOG_STAT_FIELD_DESC);
//            fVar.mo18493a(bBUserLimit.upload_word_log_stat);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserLimitStandardSchemeFactory implements C2109b {
//        private BBUserLimitStandardSchemeFactory() {
//        }
//
//        public BBUserLimitStandardScheme getScheme() {
//            return new BBUserLimitStandardScheme();
//        }
//    }
//
//    class BBUserLimitTupleScheme extends C2111d<BBUserLimit> {
//        private BBUserLimitTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserLimit bBUserLimit) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserLimit.select_date_tip.write(lVar);
//            lVar.mo18493a(bBUserLimit.show_sentence_trans);
//            lVar.mo18493a(bBUserLimit.has_word_friends);
//            lVar.mo18493a(bBUserLimit.submit_user_local_info);
//            lVar.mo18493a(bBUserLimit.max_allow_learn_days);
//            lVar.mo18493a(bBUserLimit.max_allow_learn_count);
//            lVar.mo18495a(bBUserLimit.vocab_test_flag);
//            lVar.mo18493a(bBUserLimit.upload_word_log_stat);
//        }
//
//        public void read(C2100f fVar, BBUserLimit bBUserLimit) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserLimit.select_date_tip = new BBSelectTip();
//            bBUserLimit.select_date_tip.read(lVar);
//            bBUserLimit.setSelect_date_tipIsSet(true);
//            bBUserLimit.show_sentence_trans = lVar.mo18513n();
//            bBUserLimit.setShow_sentence_transIsSet(true);
//            bBUserLimit.has_word_friends = lVar.mo18513n();
//            bBUserLimit.setHas_word_friendsIsSet(true);
//            bBUserLimit.submit_user_local_info = lVar.mo18513n();
//            bBUserLimit.setSubmit_user_local_infoIsSet(true);
//            bBUserLimit.max_allow_learn_days = lVar.mo18513n();
//            bBUserLimit.setMax_allow_learn_daysIsSet(true);
//            bBUserLimit.max_allow_learn_count = lVar.mo18513n();
//            bBUserLimit.setMax_allow_learn_countIsSet(true);
//            bBUserLimit.vocab_test_flag = lVar.mo18516q();
//            bBUserLimit.setVocab_test_flagIsSet(true);
//            bBUserLimit.upload_word_log_stat = lVar.mo18513n();
//            bBUserLimit.setUpload_word_log_statIsSet(true);
//        }
//    }
//
//    class BBUserLimitTupleSchemeFactory implements C2109b {
//        private BBUserLimitTupleSchemeFactory() {
//        }
//
//        public BBUserLimitTupleScheme getScheme() {
//            return new BBUserLimitTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        SELECT_DATE_TIP(1, "select_date_tip"),
//        SHOW_SENTENCE_TRANS(2, "show_sentence_trans"),
//        HAS_WORD_FRIENDS(3, "has_word_friends"),
//        SUBMIT_USER_LOCAL_INFO(4, "submit_user_local_info"),
//        MAX_ALLOW_LEARN_DAYS(5, "max_allow_learn_days"),
//        MAX_ALLOW_LEARN_COUNT(6, "max_allow_learn_count"),
//        VOCAB_TEST_FLAG(7, "vocab_test_flag"),
//        UPLOAD_WORD_LOG_STAT(8, "upload_word_log_stat");
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
//                    return SELECT_DATE_TIP;
//                case 2:
//                    return SHOW_SENTENCE_TRANS;
//                case 3:
//                    return HAS_WORD_FRIENDS;
//                case 4:
//                    return SUBMIT_USER_LOCAL_INFO;
//                case 5:
//                    return MAX_ALLOW_LEARN_DAYS;
//                case 6:
//                    return MAX_ALLOW_LEARN_COUNT;
//                case 7:
//                    return VOCAB_TEST_FLAG;
//                case 8:
//                    return UPLOAD_WORD_LOG_STAT;
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
//        hashMap.put(C2110c.class, new BBUserLimitStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserLimitTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.SELECT_DATE_TIP, new C2091a("select_date_tip", 1, new C2095e(BBSelectTip.class)));
//        enumMap.put(_Fields.SHOW_SENTENCE_TRANS, new C2091a("show_sentence_trans", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.HAS_WORD_FRIENDS, new C2091a("has_word_friends", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SUBMIT_USER_LOCAL_INFO, new C2091a("submit_user_local_info", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.MAX_ALLOW_LEARN_DAYS, new C2091a("max_allow_learn_days", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.MAX_ALLOW_LEARN_COUNT, new C2091a("max_allow_learn_count", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.VOCAB_TEST_FLAG, new C2091a("vocab_test_flag", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.UPLOAD_WORD_LOG_STAT, new C2091a("upload_word_log_stat", 1, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserLimit.class, metaDataMap);
//    }
//
//    public BBUserLimit() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBUserLimit(BBSelectTip bBSelectTip, int i, int i2, int i3, int i4, int i5, String str, int i6) {
//        this();
//        this.select_date_tip = bBSelectTip;
//        this.show_sentence_trans = i;
//        setShow_sentence_transIsSet(true);
//        this.has_word_friends = i2;
//        setHas_word_friendsIsSet(true);
//        this.submit_user_local_info = i3;
//        setSubmit_user_local_infoIsSet(true);
//        this.max_allow_learn_days = i4;
//        setMax_allow_learn_daysIsSet(true);
//        this.max_allow_learn_count = i5;
//        setMax_allow_learn_countIsSet(true);
//        this.vocab_test_flag = str;
//        this.upload_word_log_stat = i6;
//        setUpload_word_log_statIsSet(true);
//    }
//
//    public BBUserLimit(BBUserLimit bBUserLimit) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBUserLimit.__isset_bitfield;
//        if (bBUserLimit.isSetSelect_date_tip()) {
//            this.select_date_tip = new BBSelectTip(bBUserLimit.select_date_tip);
//        }
//        this.show_sentence_trans = bBUserLimit.show_sentence_trans;
//        this.has_word_friends = bBUserLimit.has_word_friends;
//        this.submit_user_local_info = bBUserLimit.submit_user_local_info;
//        this.max_allow_learn_days = bBUserLimit.max_allow_learn_days;
//        this.max_allow_learn_count = bBUserLimit.max_allow_learn_count;
//        if (bBUserLimit.isSetVocab_test_flag()) {
//            this.vocab_test_flag = bBUserLimit.vocab_test_flag;
//        }
//        this.upload_word_log_stat = bBUserLimit.upload_word_log_stat;
//    }
//
//    public BBUserLimit deepCopy() {
//        return new BBUserLimit(this);
//    }
//
//    public void clear() {
//        this.select_date_tip = null;
//        setShow_sentence_transIsSet(false);
//        this.show_sentence_trans = 0;
//        setHas_word_friendsIsSet(false);
//        this.has_word_friends = 0;
//        setSubmit_user_local_infoIsSet(false);
//        this.submit_user_local_info = 0;
//        setMax_allow_learn_daysIsSet(false);
//        this.max_allow_learn_days = 0;
//        setMax_allow_learn_countIsSet(false);
//        this.max_allow_learn_count = 0;
//        this.vocab_test_flag = null;
//        setUpload_word_log_statIsSet(false);
//        this.upload_word_log_stat = 0;
//    }
//
//    public BBSelectTip getSelect_date_tip() {
//        return this.select_date_tip;
//    }
//
//    public BBUserLimit setSelect_date_tip(BBSelectTip bBSelectTip) {
//        this.select_date_tip = bBSelectTip;
//        return this;
//    }
//
//    public void unsetSelect_date_tip() {
//        this.select_date_tip = null;
//    }
//
//    public boolean isSetSelect_date_tip() {
//        return this.select_date_tip != null;
//    }
//
//    public void setSelect_date_tipIsSet(boolean z) {
//        if (!z) {
//            this.select_date_tip = null;
//        }
//    }
//
//    public int getShow_sentence_trans() {
//        return this.show_sentence_trans;
//    }
//
//    public BBUserLimit setShow_sentence_trans(int i) {
//        this.show_sentence_trans = i;
//        setShow_sentence_transIsSet(true);
//        return this;
//    }
//
//    public void unsetShow_sentence_trans() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetShow_sentence_trans() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setShow_sentence_transIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public int getHas_word_friends() {
//        return this.has_word_friends;
//    }
//
//    public BBUserLimit setHas_word_friends(int i) {
//        this.has_word_friends = i;
//        setHas_word_friendsIsSet(true);
//        return this;
//    }
//
//    public void unsetHas_word_friends() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetHas_word_friends() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setHas_word_friendsIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getSubmit_user_local_info() {
//        return this.submit_user_local_info;
//    }
//
//    public BBUserLimit setSubmit_user_local_info(int i) {
//        this.submit_user_local_info = i;
//        setSubmit_user_local_infoIsSet(true);
//        return this;
//    }
//
//    public void unsetSubmit_user_local_info() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetSubmit_user_local_info() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setSubmit_user_local_infoIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public int getMax_allow_learn_days() {
//        return this.max_allow_learn_days;
//    }
//
//    public BBUserLimit setMax_allow_learn_days(int i) {
//        this.max_allow_learn_days = i;
//        setMax_allow_learn_daysIsSet(true);
//        return this;
//    }
//
//    public void unsetMax_allow_learn_days() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetMax_allow_learn_days() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setMax_allow_learn_daysIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public int getMax_allow_learn_count() {
//        return this.max_allow_learn_count;
//    }
//
//    public BBUserLimit setMax_allow_learn_count(int i) {
//        this.max_allow_learn_count = i;
//        setMax_allow_learn_countIsSet(true);
//        return this;
//    }
//
//    public void unsetMax_allow_learn_count() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetMax_allow_learn_count() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setMax_allow_learn_countIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 4, z);
//    }
//
//    public String getVocab_test_flag() {
//        return this.vocab_test_flag;
//    }
//
//    public BBUserLimit setVocab_test_flag(String str) {
//        this.vocab_test_flag = str;
//        return this;
//    }
//
//    public void unsetVocab_test_flag() {
//        this.vocab_test_flag = null;
//    }
//
//    public boolean isSetVocab_test_flag() {
//        return this.vocab_test_flag != null;
//    }
//
//    public void setVocab_test_flagIsSet(boolean z) {
//        if (!z) {
//            this.vocab_test_flag = null;
//        }
//    }
//
//    public int getUpload_word_log_stat() {
//        return this.upload_word_log_stat;
//    }
//
//    public BBUserLimit setUpload_word_log_stat(int i) {
//        this.upload_word_log_stat = i;
//        setUpload_word_log_statIsSet(true);
//        return this;
//    }
//
//    public void unsetUpload_word_log_stat() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -33);
//    }
//
//    public boolean isSetUpload_word_log_stat() {
//        return C2090b.m5429a(this.__isset_bitfield, 5);
//    }
//
//    public void setUpload_word_log_statIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 5, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case SELECT_DATE_TIP:
//                if (obj == null) {
//                    unsetSelect_date_tip();
//                    return;
//                } else {
//                    setSelect_date_tip((BBSelectTip) obj);
//                    return;
//                }
//            case SHOW_SENTENCE_TRANS:
//                if (obj == null) {
//                    unsetShow_sentence_trans();
//                    return;
//                } else {
//                    setShow_sentence_trans(((Integer) obj).intValue());
//                    return;
//                }
//            case HAS_WORD_FRIENDS:
//                if (obj == null) {
//                    unsetHas_word_friends();
//                    return;
//                } else {
//                    setHas_word_friends(((Integer) obj).intValue());
//                    return;
//                }
//            case SUBMIT_USER_LOCAL_INFO:
//                if (obj == null) {
//                    unsetSubmit_user_local_info();
//                    return;
//                } else {
//                    setSubmit_user_local_info(((Integer) obj).intValue());
//                    return;
//                }
//            case MAX_ALLOW_LEARN_DAYS:
//                if (obj == null) {
//                    unsetMax_allow_learn_days();
//                    return;
//                } else {
//                    setMax_allow_learn_days(((Integer) obj).intValue());
//                    return;
//                }
//            case MAX_ALLOW_LEARN_COUNT:
//                if (obj == null) {
//                    unsetMax_allow_learn_count();
//                    return;
//                } else {
//                    setMax_allow_learn_count(((Integer) obj).intValue());
//                    return;
//                }
//            case VOCAB_TEST_FLAG:
//                if (obj == null) {
//                    unsetVocab_test_flag();
//                    return;
//                } else {
//                    setVocab_test_flag((String) obj);
//                    return;
//                }
//            case UPLOAD_WORD_LOG_STAT:
//                if (obj == null) {
//                    unsetUpload_word_log_stat();
//                    return;
//                } else {
//                    setUpload_word_log_stat(((Integer) obj).intValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case SELECT_DATE_TIP:
//                return getSelect_date_tip();
//            case SHOW_SENTENCE_TRANS:
//                return Integer.valueOf(getShow_sentence_trans());
//            case HAS_WORD_FRIENDS:
//                return Integer.valueOf(getHas_word_friends());
//            case SUBMIT_USER_LOCAL_INFO:
//                return Integer.valueOf(getSubmit_user_local_info());
//            case MAX_ALLOW_LEARN_DAYS:
//                return Integer.valueOf(getMax_allow_learn_days());
//            case MAX_ALLOW_LEARN_COUNT:
//                return Integer.valueOf(getMax_allow_learn_count());
//            case VOCAB_TEST_FLAG:
//                return getVocab_test_flag();
//            case UPLOAD_WORD_LOG_STAT:
//                return Integer.valueOf(getUpload_word_log_stat());
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
//            case SELECT_DATE_TIP:
//                return isSetSelect_date_tip();
//            case SHOW_SENTENCE_TRANS:
//                return isSetShow_sentence_trans();
//            case HAS_WORD_FRIENDS:
//                return isSetHas_word_friends();
//            case SUBMIT_USER_LOCAL_INFO:
//                return isSetSubmit_user_local_info();
//            case MAX_ALLOW_LEARN_DAYS:
//                return isSetMax_allow_learn_days();
//            case MAX_ALLOW_LEARN_COUNT:
//                return isSetMax_allow_learn_count();
//            case VOCAB_TEST_FLAG:
//                return isSetVocab_test_flag();
//            case UPLOAD_WORD_LOG_STAT:
//                return isSetUpload_word_log_stat();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBUserLimit)) {
//            return equals((BBUserLimit) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserLimit bBUserLimit) {
//        if (bBUserLimit == null) {
//            return false;
//        }
//        boolean isSetSelect_date_tip = isSetSelect_date_tip();
//        boolean isSetSelect_date_tip2 = bBUserLimit.isSetSelect_date_tip();
//        if (((isSetSelect_date_tip || isSetSelect_date_tip2) && (!isSetSelect_date_tip || !isSetSelect_date_tip2 || !this.select_date_tip.equals(bBUserLimit.select_date_tip))) || this.show_sentence_trans != bBUserLimit.show_sentence_trans || this.has_word_friends != bBUserLimit.has_word_friends || this.submit_user_local_info != bBUserLimit.submit_user_local_info || this.max_allow_learn_days != bBUserLimit.max_allow_learn_days || this.max_allow_learn_count != bBUserLimit.max_allow_learn_count) {
//            return false;
//        }
//        boolean isSetVocab_test_flag = isSetVocab_test_flag();
//        boolean isSetVocab_test_flag2 = bBUserLimit.isSetVocab_test_flag();
//        if (((isSetVocab_test_flag || isSetVocab_test_flag2) && (!isSetVocab_test_flag || !isSetVocab_test_flag2 || !this.vocab_test_flag.equals(bBUserLimit.vocab_test_flag))) || this.upload_word_log_stat != bBUserLimit.upload_word_log_stat) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserLimit bBUserLimit) {
//        if (!getClass().equals(bBUserLimit.getClass())) {
//            return getClass().getName().compareTo(bBUserLimit.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetSelect_date_tip()).compareTo(Boolean.valueOf(bBUserLimit.isSetSelect_date_tip()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetSelect_date_tip()) {
//            int a = C2121h.m5524a((Comparable) this.select_date_tip, (Comparable) bBUserLimit.select_date_tip);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetShow_sentence_trans()).compareTo(Boolean.valueOf(bBUserLimit.isSetShow_sentence_trans()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetShow_sentence_trans()) {
//            int a2 = C2121h.m5522a(this.show_sentence_trans, bBUserLimit.show_sentence_trans);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetHas_word_friends()).compareTo(Boolean.valueOf(bBUserLimit.isSetHas_word_friends()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetHas_word_friends()) {
//            int a3 = C2121h.m5522a(this.has_word_friends, bBUserLimit.has_word_friends);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetSubmit_user_local_info()).compareTo(Boolean.valueOf(bBUserLimit.isSetSubmit_user_local_info()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetSubmit_user_local_info()) {
//            int a4 = C2121h.m5522a(this.submit_user_local_info, bBUserLimit.submit_user_local_info);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetMax_allow_learn_days()).compareTo(Boolean.valueOf(bBUserLimit.isSetMax_allow_learn_days()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetMax_allow_learn_days()) {
//            int a5 = C2121h.m5522a(this.max_allow_learn_days, bBUserLimit.max_allow_learn_days);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetMax_allow_learn_count()).compareTo(Boolean.valueOf(bBUserLimit.isSetMax_allow_learn_count()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetMax_allow_learn_count()) {
//            int a6 = C2121h.m5522a(this.max_allow_learn_count, bBUserLimit.max_allow_learn_count);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetVocab_test_flag()).compareTo(Boolean.valueOf(bBUserLimit.isSetVocab_test_flag()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetVocab_test_flag()) {
//            int a7 = C2121h.m5525a(this.vocab_test_flag, bBUserLimit.vocab_test_flag);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetUpload_word_log_stat()).compareTo(Boolean.valueOf(bBUserLimit.isSetUpload_word_log_stat()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetUpload_word_log_stat()) {
//            int a8 = C2121h.m5522a(this.upload_word_log_stat, bBUserLimit.upload_word_log_stat);
//            if (a8 != 0) {
//                return a8;
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
//        StringBuilder sb = new StringBuilder("BBUserLimit(");
//        sb.append("select_date_tip:");
//        if (this.select_date_tip == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.select_date_tip);
//        }
//        sb.append(", ");
//        sb.append("show_sentence_trans:");
//        sb.append(this.show_sentence_trans);
//        sb.append(", ");
//        sb.append("has_word_friends:");
//        sb.append(this.has_word_friends);
//        sb.append(", ");
//        sb.append("submit_user_local_info:");
//        sb.append(this.submit_user_local_info);
//        sb.append(", ");
//        sb.append("max_allow_learn_days:");
//        sb.append(this.max_allow_learn_days);
//        sb.append(", ");
//        sb.append("max_allow_learn_count:");
//        sb.append(this.max_allow_learn_count);
//        sb.append(", ");
//        sb.append("vocab_test_flag:");
//        if (this.vocab_test_flag == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.vocab_test_flag);
//        }
//        sb.append(", ");
//        sb.append("upload_word_log_stat:");
//        sb.append(this.upload_word_log_stat);
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.select_date_tip == null) {
//            throw new C2101g("Required field 'select_date_tip' was not present! Struct: " + toString());
//        } else if (this.vocab_test_flag == null) {
//            throw new C2101g("Required field 'vocab_test_flag' was not present! Struct: " + toString());
//        } else if (this.select_date_tip != null) {
//            this.select_date_tip.validate();
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
