//package com.baicizhan.online.bs_users;
//
//import com.p052e.p053a.p054a.JceStruct;
//import com.tencent.android.tpush.common.MessageKey;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.BitSet;
//import java.util.Collections;
//import java.util.EnumMap;
//import java.util.EnumSet;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import org.p100a.p101a.C2090b;
//import org.p100a.p101a.C2116f;
//import org.p100a.p101a.C2121h;
//import org.p100a.p101a.C2123l;
//import org.p100a.p101a.C2124m;
//import org.p100a.p101a.p103b.C2091a;
//import org.p100a.p101a.p103b.C2092b;
//import org.p100a.p101a.p103b.C2093c;
//import org.p100a.p101a.p104c.C2096a;
//import org.p100a.p101a.p104c.C2097b;
//import org.p100a.p101a.p104c.C2098c;
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
//public class BBCheckInfo implements Serializable, Cloneable, Comparable<BBCheckInfo>, C2116f<BBCheckInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b DATA_DNS_FIELD_DESC = new C2097b("data_dns", JceStruct.STRUCT_END, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b LOG_BLACKLIST_FIELD_DESC = new C2097b("log_blacklist", 15, 8);
//    /* access modifiers changed from: private */
//    public static final C2097b LOG_REQUEST_FIELD_DESC = new C2097b("log_request", 8, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b OTHER_DATA_DNS_FIELD_DESC = new C2097b("other_data_dns", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b OTHER_RES_DNS_FIELD_DESC = new C2097b("other_res_dns", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b RES_DNS_FIELD_DESC = new C2097b("res_dns", JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b SERVER_TIME_FIELD_DESC = new C2097b(MessageKey.MSG_SERVER_TIME, 10, 11);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBCheckInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATE_AT_OF_BOOK_INFO_FIELD_DESC = new C2097b("update_at_of_book_info", 10, 9);
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATE_AT_OF_NOTIFY_INFO_FIELD_DESC = new C2097b("update_at_of_notify_info", 10, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATE_AT_OF_WORD_FM_HALFTIME_AUDIO_FIELD_DESC = new C2097b("update_at_of_word_fm_halftime_audio", 10, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b USE_NEW_LEARNING_MOD_FIELD_DESC = new C2097b("use_new_learning_mod", 8, 10);
//    private static final int __LOG_REQUEST_ISSET_ID = 2;
//    private static final int __SERVER_TIME_ISSET_ID = 5;
//    private static final int __UPDATE_AT_OF_BOOK_INFO_ISSET_ID = 3;
//    private static final int __UPDATE_AT_OF_NOTIFY_INFO_ISSET_ID = 0;
//    private static final int __UPDATE_AT_OF_WORD_FM_HALFTIME_AUDIO_ISSET_ID = 1;
//    private static final int __USE_NEW_LEARNING_MOD_ISSET_ID = 4;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String data_dns;
//    public List<String> log_blacklist;
//    public int log_request;
//    private _Fields[] optionals;
//    public String other_data_dns;
//    public String other_res_dns;
//    public String res_dns;
//    public long server_time;
//    public long update_at_of_book_info;
//    public long update_at_of_notify_info;
//    public long update_at_of_word_fm_halftime_audio;
//    public int use_new_learning_mod;
//
//    class BBCheckInfoStandardScheme extends C2110c<BBCheckInfo> {
//        private BBCheckInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBCheckInfo bBCheckInfo) {
//            fVar.mo18504e();
//            while (true) {
//                C2097b g = fVar.mo18506g();
//                if (g.f5835b != 0) {
//                    switch (g.f5836c) {
//                        case 1:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.res_dns = fVar.mo18516q();
//                                bBCheckInfo.setRes_dnsIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.other_res_dns = fVar.mo18516q();
//                                bBCheckInfo.setOther_res_dnsIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.data_dns = fVar.mo18516q();
//                                bBCheckInfo.setData_dnsIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.other_data_dns = fVar.mo18516q();
//                                bBCheckInfo.setOther_data_dnsIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.update_at_of_notify_info = fVar.mo18514o();
//                                bBCheckInfo.setUpdate_at_of_notify_infoIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.update_at_of_word_fm_halftime_audio = fVar.mo18514o();
//                                bBCheckInfo.setUpdate_at_of_word_fm_halftime_audioIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.log_request = fVar.mo18513n();
//                                bBCheckInfo.setLog_requestIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i = fVar.mo18508i();
//                                bBCheckInfo.log_blacklist = new ArrayList(i.f5838b);
//                                for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                    bBCheckInfo.log_blacklist.add(fVar.mo18516q());
//                                }
//                                bBCheckInfo.setLog_blacklistIsSet(true);
//                                break;
//                            }
//                        case 9:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.update_at_of_book_info = fVar.mo18514o();
//                                bBCheckInfo.setUpdate_at_of_book_infoIsSet(true);
//                                break;
//                            }
//                        case 10:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.use_new_learning_mod = fVar.mo18513n();
//                                bBCheckInfo.setUse_new_learning_modIsSet(true);
//                                break;
//                            }
//                        case 11:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCheckInfo.server_time = fVar.mo18514o();
//                                bBCheckInfo.setServer_timeIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBCheckInfo.isSetUpdate_at_of_notify_info()) {
//                        throw new C2101g("Required field 'update_at_of_notify_info' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBCheckInfo.isSetUpdate_at_of_word_fm_halftime_audio()) {
//                        throw new C2101g("Required field 'update_at_of_word_fm_halftime_audio' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBCheckInfo.isSetLog_request()) {
//                        throw new C2101g("Required field 'log_request' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBCheckInfo.isSetUpdate_at_of_book_info()) {
//                        throw new C2101g("Required field 'update_at_of_book_info' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBCheckInfo.isSetUse_new_learning_mod()) {
//                        throw new C2101g("Required field 'use_new_learning_mod' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBCheckInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBCheckInfo bBCheckInfo) {
//            bBCheckInfo.validate();
//            BBCheckInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBCheckInfo.res_dns != null) {
//                fVar.mo18496a(BBCheckInfo.RES_DNS_FIELD_DESC);
//                fVar.mo18495a(bBCheckInfo.res_dns);
//            }
//            if (bBCheckInfo.other_res_dns != null) {
//                fVar.mo18496a(BBCheckInfo.OTHER_RES_DNS_FIELD_DESC);
//                fVar.mo18495a(bBCheckInfo.other_res_dns);
//            }
//            if (bBCheckInfo.data_dns != null) {
//                fVar.mo18496a(BBCheckInfo.DATA_DNS_FIELD_DESC);
//                fVar.mo18495a(bBCheckInfo.data_dns);
//            }
//            if (bBCheckInfo.other_data_dns != null) {
//                fVar.mo18496a(BBCheckInfo.OTHER_DATA_DNS_FIELD_DESC);
//                fVar.mo18495a(bBCheckInfo.other_data_dns);
//            }
//            fVar.mo18496a(BBCheckInfo.UPDATE_AT_OF_NOTIFY_INFO_FIELD_DESC);
//            fVar.mo18494a(bBCheckInfo.update_at_of_notify_info);
//            fVar.mo18496a(BBCheckInfo.UPDATE_AT_OF_WORD_FM_HALFTIME_AUDIO_FIELD_DESC);
//            fVar.mo18494a(bBCheckInfo.update_at_of_word_fm_halftime_audio);
//            fVar.mo18496a(BBCheckInfo.LOG_REQUEST_FIELD_DESC);
//            fVar.mo18493a(bBCheckInfo.log_request);
//            if (bBCheckInfo.log_blacklist != null) {
//                fVar.mo18496a(BBCheckInfo.LOG_BLACKLIST_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.STRUCT_END, bBCheckInfo.log_blacklist.size()));
//                for (String a : bBCheckInfo.log_blacklist) {
//                    fVar.mo18495a(a);
//                }
//            }
//            fVar.mo18496a(BBCheckInfo.UPDATE_AT_OF_BOOK_INFO_FIELD_DESC);
//            fVar.mo18494a(bBCheckInfo.update_at_of_book_info);
//            fVar.mo18496a(BBCheckInfo.USE_NEW_LEARNING_MOD_FIELD_DESC);
//            fVar.mo18493a(bBCheckInfo.use_new_learning_mod);
//            if (bBCheckInfo.isSetServer_time()) {
//                fVar.mo18496a(BBCheckInfo.SERVER_TIME_FIELD_DESC);
//                fVar.mo18494a(bBCheckInfo.server_time);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBCheckInfoStandardSchemeFactory implements C2109b {
//        private BBCheckInfoStandardSchemeFactory() {
//        }
//
//        public BBCheckInfoStandardScheme getScheme() {
//            return new BBCheckInfoStandardScheme();
//        }
//    }
//
//    class BBCheckInfoTupleScheme extends C2111d<BBCheckInfo> {
//        private BBCheckInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBCheckInfo bBCheckInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBCheckInfo.res_dns);
//            lVar.mo18495a(bBCheckInfo.other_res_dns);
//            lVar.mo18495a(bBCheckInfo.data_dns);
//            lVar.mo18495a(bBCheckInfo.other_data_dns);
//            lVar.mo18494a(bBCheckInfo.update_at_of_notify_info);
//            lVar.mo18494a(bBCheckInfo.update_at_of_word_fm_halftime_audio);
//            lVar.mo18493a(bBCheckInfo.log_request);
//            lVar.mo18493a(bBCheckInfo.log_blacklist.size());
//            for (String a : bBCheckInfo.log_blacklist) {
//                lVar.mo18495a(a);
//            }
//            lVar.mo18494a(bBCheckInfo.update_at_of_book_info);
//            lVar.mo18493a(bBCheckInfo.use_new_learning_mod);
//            BitSet bitSet = new BitSet();
//            if (bBCheckInfo.isSetServer_time()) {
//                bitSet.set(0);
//            }
//            lVar.mo18527a(bitSet, 1);
//            if (bBCheckInfo.isSetServer_time()) {
//                lVar.mo18494a(bBCheckInfo.server_time);
//            }
//        }
//
//        public void read(C2100f fVar, BBCheckInfo bBCheckInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBCheckInfo.res_dns = lVar.mo18516q();
//            bBCheckInfo.setRes_dnsIsSet(true);
//            bBCheckInfo.other_res_dns = lVar.mo18516q();
//            bBCheckInfo.setOther_res_dnsIsSet(true);
//            bBCheckInfo.data_dns = lVar.mo18516q();
//            bBCheckInfo.setData_dnsIsSet(true);
//            bBCheckInfo.other_data_dns = lVar.mo18516q();
//            bBCheckInfo.setOther_data_dnsIsSet(true);
//            bBCheckInfo.update_at_of_notify_info = lVar.mo18514o();
//            bBCheckInfo.setUpdate_at_of_notify_infoIsSet(true);
//            bBCheckInfo.update_at_of_word_fm_halftime_audio = lVar.mo18514o();
//            bBCheckInfo.setUpdate_at_of_word_fm_halftime_audioIsSet(true);
//            bBCheckInfo.log_request = lVar.mo18513n();
//            bBCheckInfo.setLog_requestIsSet(true);
//            C2098c cVar = new C2098c(JceStruct.STRUCT_END, lVar.mo18513n());
//            bBCheckInfo.log_blacklist = new ArrayList(cVar.f5838b);
//            for (int i = 0; i < cVar.f5838b; i++) {
//                bBCheckInfo.log_blacklist.add(lVar.mo18516q());
//            }
//            bBCheckInfo.setLog_blacklistIsSet(true);
//            bBCheckInfo.update_at_of_book_info = lVar.mo18514o();
//            bBCheckInfo.setUpdate_at_of_book_infoIsSet(true);
//            bBCheckInfo.use_new_learning_mod = lVar.mo18513n();
//            bBCheckInfo.setUse_new_learning_modIsSet(true);
//            if (lVar.mo18528b(1).get(0)) {
//                bBCheckInfo.server_time = lVar.mo18514o();
//                bBCheckInfo.setServer_timeIsSet(true);
//            }
//        }
//    }
//
//    class BBCheckInfoTupleSchemeFactory implements C2109b {
//        private BBCheckInfoTupleSchemeFactory() {
//        }
//
//        public BBCheckInfoTupleScheme getScheme() {
//            return new BBCheckInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        RES_DNS(1, "res_dns"),
//        OTHER_RES_DNS(2, "other_res_dns"),
//        DATA_DNS(3, "data_dns"),
//        OTHER_DATA_DNS(4, "other_data_dns"),
//        UPDATE_AT_OF_NOTIFY_INFO(5, "update_at_of_notify_info"),
//        UPDATE_AT_OF_WORD_FM_HALFTIME_AUDIO(6, "update_at_of_word_fm_halftime_audio"),
//        LOG_REQUEST(7, "log_request"),
//        LOG_BLACKLIST(8, "log_blacklist"),
//        UPDATE_AT_OF_BOOK_INFO(9, "update_at_of_book_info"),
//        USE_NEW_LEARNING_MOD(10, "use_new_learning_mod"),
//        SERVER_TIME(11, MessageKey.MSG_SERVER_TIME);
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
//                    return RES_DNS;
//                case 2:
//                    return OTHER_RES_DNS;
//                case 3:
//                    return DATA_DNS;
//                case 4:
//                    return OTHER_DATA_DNS;
//                case 5:
//                    return UPDATE_AT_OF_NOTIFY_INFO;
//                case 6:
//                    return UPDATE_AT_OF_WORD_FM_HALFTIME_AUDIO;
//                case 7:
//                    return LOG_REQUEST;
//                case 8:
//                    return LOG_BLACKLIST;
//                case 9:
//                    return UPDATE_AT_OF_BOOK_INFO;
//                case 10:
//                    return USE_NEW_LEARNING_MOD;
//                case 11:
//                    return SERVER_TIME;
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
//        hashMap.put(C2110c.class, new BBCheckInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBCheckInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.RES_DNS, new C2091a("res_dns", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.OTHER_RES_DNS, new C2091a("other_res_dns", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.DATA_DNS, new C2091a("data_dns", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.OTHER_DATA_DNS, new C2091a("other_data_dns", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.UPDATE_AT_OF_NOTIFY_INFO, new C2091a("update_at_of_notify_info", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.UPDATE_AT_OF_WORD_FM_HALFTIME_AUDIO, new C2091a("update_at_of_word_fm_halftime_audio", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.LOG_REQUEST, new C2091a("log_request", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.LOG_BLACKLIST, new C2091a("log_blacklist", 1, new C2093c(new C2092b(JceStruct.STRUCT_END, 0))));
//        enumMap.put(_Fields.UPDATE_AT_OF_BOOK_INFO, new C2091a("update_at_of_book_info", 1, new C2092b(10, 0)));
//        enumMap.put(_Fields.USE_NEW_LEARNING_MOD, new C2091a("use_new_learning_mod", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SERVER_TIME, new C2091a(MessageKey.MSG_SERVER_TIME, 2, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBCheckInfo.class, metaDataMap);
//    }
//
//    public BBCheckInfo() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.SERVER_TIME};
//    }
//
//    public BBCheckInfo(String str, String str2, String str3, String str4, long j, long j2, int i, List<String> list, long j3, int i2) {
//        this();
//        this.res_dns = str;
//        this.other_res_dns = str2;
//        this.data_dns = str3;
//        this.other_data_dns = str4;
//        this.update_at_of_notify_info = j;
//        setUpdate_at_of_notify_infoIsSet(true);
//        this.update_at_of_word_fm_halftime_audio = j2;
//        setUpdate_at_of_word_fm_halftime_audioIsSet(true);
//        this.log_request = i;
//        setLog_requestIsSet(true);
//        this.log_blacklist = list;
//        this.update_at_of_book_info = j3;
//        setUpdate_at_of_book_infoIsSet(true);
//        this.use_new_learning_mod = i2;
//        setUse_new_learning_modIsSet(true);
//    }
//
//    public BBCheckInfo(BBCheckInfo bBCheckInfo) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.SERVER_TIME};
//        this.__isset_bitfield = bBCheckInfo.__isset_bitfield;
//        if (bBCheckInfo.isSetRes_dns()) {
//            this.res_dns = bBCheckInfo.res_dns;
//        }
//        if (bBCheckInfo.isSetOther_res_dns()) {
//            this.other_res_dns = bBCheckInfo.other_res_dns;
//        }
//        if (bBCheckInfo.isSetData_dns()) {
//            this.data_dns = bBCheckInfo.data_dns;
//        }
//        if (bBCheckInfo.isSetOther_data_dns()) {
//            this.other_data_dns = bBCheckInfo.other_data_dns;
//        }
//        this.update_at_of_notify_info = bBCheckInfo.update_at_of_notify_info;
//        this.update_at_of_word_fm_halftime_audio = bBCheckInfo.update_at_of_word_fm_halftime_audio;
//        this.log_request = bBCheckInfo.log_request;
//        if (bBCheckInfo.isSetLog_blacklist()) {
//            this.log_blacklist = new ArrayList(bBCheckInfo.log_blacklist);
//        }
//        this.update_at_of_book_info = bBCheckInfo.update_at_of_book_info;
//        this.use_new_learning_mod = bBCheckInfo.use_new_learning_mod;
//        this.server_time = bBCheckInfo.server_time;
//    }
//
//    public BBCheckInfo deepCopy() {
//        return new BBCheckInfo(this);
//    }
//
//    public void clear() {
//        this.res_dns = null;
//        this.other_res_dns = null;
//        this.data_dns = null;
//        this.other_data_dns = null;
//        setUpdate_at_of_notify_infoIsSet(false);
//        this.update_at_of_notify_info = 0;
//        setUpdate_at_of_word_fm_halftime_audioIsSet(false);
//        this.update_at_of_word_fm_halftime_audio = 0;
//        setLog_requestIsSet(false);
//        this.log_request = 0;
//        this.log_blacklist = null;
//        setUpdate_at_of_book_infoIsSet(false);
//        this.update_at_of_book_info = 0;
//        setUse_new_learning_modIsSet(false);
//        this.use_new_learning_mod = 0;
//        setServer_timeIsSet(false);
//        this.server_time = 0;
//    }
//
//    public String getRes_dns() {
//        return this.res_dns;
//    }
//
//    public BBCheckInfo setRes_dns(String str) {
//        this.res_dns = str;
//        return this;
//    }
//
//    public void unsetRes_dns() {
//        this.res_dns = null;
//    }
//
//    public boolean isSetRes_dns() {
//        return this.res_dns != null;
//    }
//
//    public void setRes_dnsIsSet(boolean z) {
//        if (!z) {
//            this.res_dns = null;
//        }
//    }
//
//    public String getOther_res_dns() {
//        return this.other_res_dns;
//    }
//
//    public BBCheckInfo setOther_res_dns(String str) {
//        this.other_res_dns = str;
//        return this;
//    }
//
//    public void unsetOther_res_dns() {
//        this.other_res_dns = null;
//    }
//
//    public boolean isSetOther_res_dns() {
//        return this.other_res_dns != null;
//    }
//
//    public void setOther_res_dnsIsSet(boolean z) {
//        if (!z) {
//            this.other_res_dns = null;
//        }
//    }
//
//    public String getData_dns() {
//        return this.data_dns;
//    }
//
//    public BBCheckInfo setData_dns(String str) {
//        this.data_dns = str;
//        return this;
//    }
//
//    public void unsetData_dns() {
//        this.data_dns = null;
//    }
//
//    public boolean isSetData_dns() {
//        return this.data_dns != null;
//    }
//
//    public void setData_dnsIsSet(boolean z) {
//        if (!z) {
//            this.data_dns = null;
//        }
//    }
//
//    public String getOther_data_dns() {
//        return this.other_data_dns;
//    }
//
//    public BBCheckInfo setOther_data_dns(String str) {
//        this.other_data_dns = str;
//        return this;
//    }
//
//    public void unsetOther_data_dns() {
//        this.other_data_dns = null;
//    }
//
//    public boolean isSetOther_data_dns() {
//        return this.other_data_dns != null;
//    }
//
//    public void setOther_data_dnsIsSet(boolean z) {
//        if (!z) {
//            this.other_data_dns = null;
//        }
//    }
//
//    public long getUpdate_at_of_notify_info() {
//        return this.update_at_of_notify_info;
//    }
//
//    public BBCheckInfo setUpdate_at_of_notify_info(long j) {
//        this.update_at_of_notify_info = j;
//        setUpdate_at_of_notify_infoIsSet(true);
//        return this;
//    }
//
//    public void unsetUpdate_at_of_notify_info() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetUpdate_at_of_notify_info() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setUpdate_at_of_notify_infoIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public long getUpdate_at_of_word_fm_halftime_audio() {
//        return this.update_at_of_word_fm_halftime_audio;
//    }
//
//    public BBCheckInfo setUpdate_at_of_word_fm_halftime_audio(long j) {
//        this.update_at_of_word_fm_halftime_audio = j;
//        setUpdate_at_of_word_fm_halftime_audioIsSet(true);
//        return this;
//    }
//
//    public void unsetUpdate_at_of_word_fm_halftime_audio() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetUpdate_at_of_word_fm_halftime_audio() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setUpdate_at_of_word_fm_halftime_audioIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getLog_request() {
//        return this.log_request;
//    }
//
//    public BBCheckInfo setLog_request(int i) {
//        this.log_request = i;
//        setLog_requestIsSet(true);
//        return this;
//    }
//
//    public void unsetLog_request() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetLog_request() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setLog_requestIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public int getLog_blacklistSize() {
//        if (this.log_blacklist == null) {
//            return 0;
//        }
//        return this.log_blacklist.size();
//    }
//
//    public Iterator<String> getLog_blacklistIterator() {
//        if (this.log_blacklist == null) {
//            return null;
//        }
//        return this.log_blacklist.iterator();
//    }
//
//    public void addToLog_blacklist(String str) {
//        if (this.log_blacklist == null) {
//            this.log_blacklist = new ArrayList();
//        }
//        this.log_blacklist.add(str);
//    }
//
//    public List<String> getLog_blacklist() {
//        return this.log_blacklist;
//    }
//
//    public BBCheckInfo setLog_blacklist(List<String> list) {
//        this.log_blacklist = list;
//        return this;
//    }
//
//    public void unsetLog_blacklist() {
//        this.log_blacklist = null;
//    }
//
//    public boolean isSetLog_blacklist() {
//        return this.log_blacklist != null;
//    }
//
//    public void setLog_blacklistIsSet(boolean z) {
//        if (!z) {
//            this.log_blacklist = null;
//        }
//    }
//
//    public long getUpdate_at_of_book_info() {
//        return this.update_at_of_book_info;
//    }
//
//    public BBCheckInfo setUpdate_at_of_book_info(long j) {
//        this.update_at_of_book_info = j;
//        setUpdate_at_of_book_infoIsSet(true);
//        return this;
//    }
//
//    public void unsetUpdate_at_of_book_info() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetUpdate_at_of_book_info() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setUpdate_at_of_book_infoIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public int getUse_new_learning_mod() {
//        return this.use_new_learning_mod;
//    }
//
//    public BBCheckInfo setUse_new_learning_mod(int i) {
//        this.use_new_learning_mod = i;
//        setUse_new_learning_modIsSet(true);
//        return this;
//    }
//
//    public void unsetUse_new_learning_mod() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetUse_new_learning_mod() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setUse_new_learning_modIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 4, z);
//    }
//
//    public long getServer_time() {
//        return this.server_time;
//    }
//
//    public BBCheckInfo setServer_time(long j) {
//        this.server_time = j;
//        setServer_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetServer_time() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -33);
//    }
//
//    public boolean isSetServer_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 5);
//    }
//
//    public void setServer_timeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 5, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case RES_DNS:
//                if (obj == null) {
//                    unsetRes_dns();
//                    return;
//                } else {
//                    setRes_dns((String) obj);
//                    return;
//                }
//            case OTHER_RES_DNS:
//                if (obj == null) {
//                    unsetOther_res_dns();
//                    return;
//                } else {
//                    setOther_res_dns((String) obj);
//                    return;
//                }
//            case DATA_DNS:
//                if (obj == null) {
//                    unsetData_dns();
//                    return;
//                } else {
//                    setData_dns((String) obj);
//                    return;
//                }
//            case OTHER_DATA_DNS:
//                if (obj == null) {
//                    unsetOther_data_dns();
//                    return;
//                } else {
//                    setOther_data_dns((String) obj);
//                    return;
//                }
//            case UPDATE_AT_OF_NOTIFY_INFO:
//                if (obj == null) {
//                    unsetUpdate_at_of_notify_info();
//                    return;
//                } else {
//                    setUpdate_at_of_notify_info(((Long) obj).longValue());
//                    return;
//                }
//            case UPDATE_AT_OF_WORD_FM_HALFTIME_AUDIO:
//                if (obj == null) {
//                    unsetUpdate_at_of_word_fm_halftime_audio();
//                    return;
//                } else {
//                    setUpdate_at_of_word_fm_halftime_audio(((Long) obj).longValue());
//                    return;
//                }
//            case LOG_REQUEST:
//                if (obj == null) {
//                    unsetLog_request();
//                    return;
//                } else {
//                    setLog_request(((Integer) obj).intValue());
//                    return;
//                }
//            case LOG_BLACKLIST:
//                if (obj == null) {
//                    unsetLog_blacklist();
//                    return;
//                } else {
//                    setLog_blacklist((List) obj);
//                    return;
//                }
//            case UPDATE_AT_OF_BOOK_INFO:
//                if (obj == null) {
//                    unsetUpdate_at_of_book_info();
//                    return;
//                } else {
//                    setUpdate_at_of_book_info(((Long) obj).longValue());
//                    return;
//                }
//            case USE_NEW_LEARNING_MOD:
//                if (obj == null) {
//                    unsetUse_new_learning_mod();
//                    return;
//                } else {
//                    setUse_new_learning_mod(((Integer) obj).intValue());
//                    return;
//                }
//            case SERVER_TIME:
//                if (obj == null) {
//                    unsetServer_time();
//                    return;
//                } else {
//                    setServer_time(((Long) obj).longValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case RES_DNS:
//                return getRes_dns();
//            case OTHER_RES_DNS:
//                return getOther_res_dns();
//            case DATA_DNS:
//                return getData_dns();
//            case OTHER_DATA_DNS:
//                return getOther_data_dns();
//            case UPDATE_AT_OF_NOTIFY_INFO:
//                return Long.valueOf(getUpdate_at_of_notify_info());
//            case UPDATE_AT_OF_WORD_FM_HALFTIME_AUDIO:
//                return Long.valueOf(getUpdate_at_of_word_fm_halftime_audio());
//            case LOG_REQUEST:
//                return Integer.valueOf(getLog_request());
//            case LOG_BLACKLIST:
//                return getLog_blacklist();
//            case UPDATE_AT_OF_BOOK_INFO:
//                return Long.valueOf(getUpdate_at_of_book_info());
//            case USE_NEW_LEARNING_MOD:
//                return Integer.valueOf(getUse_new_learning_mod());
//            case SERVER_TIME:
//                return Long.valueOf(getServer_time());
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
//            case RES_DNS:
//                return isSetRes_dns();
//            case OTHER_RES_DNS:
//                return isSetOther_res_dns();
//            case DATA_DNS:
//                return isSetData_dns();
//            case OTHER_DATA_DNS:
//                return isSetOther_data_dns();
//            case UPDATE_AT_OF_NOTIFY_INFO:
//                return isSetUpdate_at_of_notify_info();
//            case UPDATE_AT_OF_WORD_FM_HALFTIME_AUDIO:
//                return isSetUpdate_at_of_word_fm_halftime_audio();
//            case LOG_REQUEST:
//                return isSetLog_request();
//            case LOG_BLACKLIST:
//                return isSetLog_blacklist();
//            case UPDATE_AT_OF_BOOK_INFO:
//                return isSetUpdate_at_of_book_info();
//            case USE_NEW_LEARNING_MOD:
//                return isSetUse_new_learning_mod();
//            case SERVER_TIME:
//                return isSetServer_time();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBCheckInfo)) {
//            return equals((BBCheckInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBCheckInfo bBCheckInfo) {
//        if (bBCheckInfo == null) {
//            return false;
//        }
//        boolean isSetRes_dns = isSetRes_dns();
//        boolean isSetRes_dns2 = bBCheckInfo.isSetRes_dns();
//        if ((isSetRes_dns || isSetRes_dns2) && (!isSetRes_dns || !isSetRes_dns2 || !this.res_dns.equals(bBCheckInfo.res_dns))) {
//            return false;
//        }
//        boolean isSetOther_res_dns = isSetOther_res_dns();
//        boolean isSetOther_res_dns2 = bBCheckInfo.isSetOther_res_dns();
//        if ((isSetOther_res_dns || isSetOther_res_dns2) && (!isSetOther_res_dns || !isSetOther_res_dns2 || !this.other_res_dns.equals(bBCheckInfo.other_res_dns))) {
//            return false;
//        }
//        boolean isSetData_dns = isSetData_dns();
//        boolean isSetData_dns2 = bBCheckInfo.isSetData_dns();
//        if ((isSetData_dns || isSetData_dns2) && (!isSetData_dns || !isSetData_dns2 || !this.data_dns.equals(bBCheckInfo.data_dns))) {
//            return false;
//        }
//        boolean isSetOther_data_dns = isSetOther_data_dns();
//        boolean isSetOther_data_dns2 = bBCheckInfo.isSetOther_data_dns();
//        if (((isSetOther_data_dns || isSetOther_data_dns2) && (!isSetOther_data_dns || !isSetOther_data_dns2 || !this.other_data_dns.equals(bBCheckInfo.other_data_dns))) || this.update_at_of_notify_info != bBCheckInfo.update_at_of_notify_info || this.update_at_of_word_fm_halftime_audio != bBCheckInfo.update_at_of_word_fm_halftime_audio || this.log_request != bBCheckInfo.log_request) {
//            return false;
//        }
//        boolean isSetLog_blacklist = isSetLog_blacklist();
//        boolean isSetLog_blacklist2 = bBCheckInfo.isSetLog_blacklist();
//        if (((isSetLog_blacklist || isSetLog_blacklist2) && (!isSetLog_blacklist || !isSetLog_blacklist2 || !this.log_blacklist.equals(bBCheckInfo.log_blacklist))) || this.update_at_of_book_info != bBCheckInfo.update_at_of_book_info || this.use_new_learning_mod != bBCheckInfo.use_new_learning_mod) {
//            return false;
//        }
//        boolean isSetServer_time = isSetServer_time();
//        boolean isSetServer_time2 = bBCheckInfo.isSetServer_time();
//        if ((isSetServer_time || isSetServer_time2) && (!isSetServer_time || !isSetServer_time2 || this.server_time != bBCheckInfo.server_time)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBCheckInfo bBCheckInfo) {
//        if (!getClass().equals(bBCheckInfo.getClass())) {
//            return getClass().getName().compareTo(bBCheckInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetRes_dns()).compareTo(Boolean.valueOf(bBCheckInfo.isSetRes_dns()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetRes_dns()) {
//            int a = C2121h.m5525a(this.res_dns, bBCheckInfo.res_dns);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetOther_res_dns()).compareTo(Boolean.valueOf(bBCheckInfo.isSetOther_res_dns()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetOther_res_dns()) {
//            int a2 = C2121h.m5525a(this.other_res_dns, bBCheckInfo.other_res_dns);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetData_dns()).compareTo(Boolean.valueOf(bBCheckInfo.isSetData_dns()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetData_dns()) {
//            int a3 = C2121h.m5525a(this.data_dns, bBCheckInfo.data_dns);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetOther_data_dns()).compareTo(Boolean.valueOf(bBCheckInfo.isSetOther_data_dns()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetOther_data_dns()) {
//            int a4 = C2121h.m5525a(this.other_data_dns, bBCheckInfo.other_data_dns);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetUpdate_at_of_notify_info()).compareTo(Boolean.valueOf(bBCheckInfo.isSetUpdate_at_of_notify_info()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetUpdate_at_of_notify_info()) {
//            int a5 = C2121h.m5523a(this.update_at_of_notify_info, bBCheckInfo.update_at_of_notify_info);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetUpdate_at_of_word_fm_halftime_audio()).compareTo(Boolean.valueOf(bBCheckInfo.isSetUpdate_at_of_word_fm_halftime_audio()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetUpdate_at_of_word_fm_halftime_audio()) {
//            int a6 = C2121h.m5523a(this.update_at_of_word_fm_halftime_audio, bBCheckInfo.update_at_of_word_fm_halftime_audio);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetLog_request()).compareTo(Boolean.valueOf(bBCheckInfo.isSetLog_request()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetLog_request()) {
//            int a7 = C2121h.m5522a(this.log_request, bBCheckInfo.log_request);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetLog_blacklist()).compareTo(Boolean.valueOf(bBCheckInfo.isSetLog_blacklist()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetLog_blacklist()) {
//            int a8 = C2121h.m5526a((List) this.log_blacklist, (List) bBCheckInfo.log_blacklist);
//            if (a8 != 0) {
//                return a8;
//            }
//        }
//        int compareTo9 = Boolean.valueOf(isSetUpdate_at_of_book_info()).compareTo(Boolean.valueOf(bBCheckInfo.isSetUpdate_at_of_book_info()));
//        if (compareTo9 != 0) {
//            return compareTo9;
//        }
//        if (isSetUpdate_at_of_book_info()) {
//            int a9 = C2121h.m5523a(this.update_at_of_book_info, bBCheckInfo.update_at_of_book_info);
//            if (a9 != 0) {
//                return a9;
//            }
//        }
//        int compareTo10 = Boolean.valueOf(isSetUse_new_learning_mod()).compareTo(Boolean.valueOf(bBCheckInfo.isSetUse_new_learning_mod()));
//        if (compareTo10 != 0) {
//            return compareTo10;
//        }
//        if (isSetUse_new_learning_mod()) {
//            int a10 = C2121h.m5522a(this.use_new_learning_mod, bBCheckInfo.use_new_learning_mod);
//            if (a10 != 0) {
//                return a10;
//            }
//        }
//        int compareTo11 = Boolean.valueOf(isSetServer_time()).compareTo(Boolean.valueOf(bBCheckInfo.isSetServer_time()));
//        if (compareTo11 != 0) {
//            return compareTo11;
//        }
//        if (isSetServer_time()) {
//            int a11 = C2121h.m5523a(this.server_time, bBCheckInfo.server_time);
//            if (a11 != 0) {
//                return a11;
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
//        StringBuilder sb = new StringBuilder("BBCheckInfo(");
//        sb.append("res_dns:");
//        if (this.res_dns == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.res_dns);
//        }
//        sb.append(", ");
//        sb.append("other_res_dns:");
//        if (this.other_res_dns == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.other_res_dns);
//        }
//        sb.append(", ");
//        sb.append("data_dns:");
//        if (this.data_dns == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.data_dns);
//        }
//        sb.append(", ");
//        sb.append("other_data_dns:");
//        if (this.other_data_dns == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.other_data_dns);
//        }
//        sb.append(", ");
//        sb.append("update_at_of_notify_info:");
//        sb.append(this.update_at_of_notify_info);
//        sb.append(", ");
//        sb.append("update_at_of_word_fm_halftime_audio:");
//        sb.append(this.update_at_of_word_fm_halftime_audio);
//        sb.append(", ");
//        sb.append("log_request:");
//        sb.append(this.log_request);
//        sb.append(", ");
//        sb.append("log_blacklist:");
//        if (this.log_blacklist == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.log_blacklist);
//        }
//        sb.append(", ");
//        sb.append("update_at_of_book_info:");
//        sb.append(this.update_at_of_book_info);
//        sb.append(", ");
//        sb.append("use_new_learning_mod:");
//        sb.append(this.use_new_learning_mod);
//        if (isSetServer_time()) {
//            sb.append(", ");
//            sb.append("server_time:");
//            sb.append(this.server_time);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.res_dns == null) {
//            throw new C2101g("Required field 'res_dns' was not present! Struct: " + toString());
//        } else if (this.other_res_dns == null) {
//            throw new C2101g("Required field 'other_res_dns' was not present! Struct: " + toString());
//        } else if (this.data_dns == null) {
//            throw new C2101g("Required field 'data_dns' was not present! Struct: " + toString());
//        } else if (this.other_data_dns == null) {
//            throw new C2101g("Required field 'other_data_dns' was not present! Struct: " + toString());
//        } else if (this.log_blacklist == null) {
//            throw new C2101g("Required field 'log_blacklist' was not present! Struct: " + toString());
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
