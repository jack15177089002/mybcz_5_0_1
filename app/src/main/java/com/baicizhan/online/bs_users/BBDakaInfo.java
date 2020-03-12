//package com.baicizhan.online.bs_users;
//
//import com.p052e.p053a.p054a.JceStruct;
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
//public class BBDakaInfo implements Serializable, Cloneable, Comparable<BBDakaInfo>, C2116f<BBDakaInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b DAKA_ID_FIELD_DESC = new C2097b("daka_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b DAKA_SHOW_IMG_FIELD_DESC = new C2097b("daka_show_img", JceStruct.STRUCT_END, 8);
//    /* access modifiers changed from: private */
//    public static final C2097b FINISHED_PLAN_DATE_FIELD_DESC = new C2097b("finished_plan_date", 15, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b SHARE_IMG_URL_FIELD_DESC = new C2097b("share_img_url", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBDakaInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TOTAL_DAKA_DAYS_FIELD_DESC = new C2097b("total_daka_days", 8, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b WEIBO_SHARE_TXT_FIELD_DESC = new C2097b("weibo_share_txt", JceStruct.STRUCT_END, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b WEIXIN_SHARE_TITLE_FIELD_DESC = new C2097b("weixin_share_title", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b WEIXIN_SHARE_URL_FIELD_DESC = new C2097b("weixin_share_url", JceStruct.STRUCT_END, 5);
//    private static final int __DAKA_ID_ISSET_ID = 0;
//    private static final int __TOTAL_DAKA_DAYS_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int daka_id;
//    public String daka_show_img;
//    public List<Integer> finished_plan_date;
//    private _Fields[] optionals;
//    public String share_img_url;
//    public int total_daka_days;
//    public String weibo_share_txt;
//    public String weixin_share_title;
//    public String weixin_share_url;
//
//    class BBDakaInfoStandardScheme extends C2110c<BBDakaInfo> {
//        private BBDakaInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBDakaInfo bBDakaInfo) {
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
//                                bBDakaInfo.daka_id = fVar.mo18513n();
//                                bBDakaInfo.setDaka_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDakaInfo.share_img_url = fVar.mo18516q();
//                                bBDakaInfo.setShare_img_urlIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDakaInfo.weibo_share_txt = fVar.mo18516q();
//                                bBDakaInfo.setWeibo_share_txtIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDakaInfo.weixin_share_title = fVar.mo18516q();
//                                bBDakaInfo.setWeixin_share_titleIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDakaInfo.weixin_share_url = fVar.mo18516q();
//                                bBDakaInfo.setWeixin_share_urlIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i = fVar.mo18508i();
//                                bBDakaInfo.finished_plan_date = new ArrayList(i.f5838b);
//                                for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                    bBDakaInfo.finished_plan_date.add(Integer.valueOf(fVar.mo18513n()));
//                                }
//                                bBDakaInfo.setFinished_plan_dateIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDakaInfo.total_daka_days = fVar.mo18513n();
//                                bBDakaInfo.setTotal_daka_daysIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDakaInfo.daka_show_img = fVar.mo18516q();
//                                bBDakaInfo.setDaka_show_imgIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBDakaInfo.isSetDaka_id()) {
//                        throw new C2101g("Required field 'daka_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBDakaInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBDakaInfo bBDakaInfo) {
//            bBDakaInfo.validate();
//            BBDakaInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBDakaInfo.DAKA_ID_FIELD_DESC);
//            fVar.mo18493a(bBDakaInfo.daka_id);
//            if (bBDakaInfo.share_img_url != null) {
//                fVar.mo18496a(BBDakaInfo.SHARE_IMG_URL_FIELD_DESC);
//                fVar.mo18495a(bBDakaInfo.share_img_url);
//            }
//            if (bBDakaInfo.weibo_share_txt != null) {
//                fVar.mo18496a(BBDakaInfo.WEIBO_SHARE_TXT_FIELD_DESC);
//                fVar.mo18495a(bBDakaInfo.weibo_share_txt);
//            }
//            if (bBDakaInfo.weixin_share_title != null) {
//                fVar.mo18496a(BBDakaInfo.WEIXIN_SHARE_TITLE_FIELD_DESC);
//                fVar.mo18495a(bBDakaInfo.weixin_share_title);
//            }
//            if (bBDakaInfo.weixin_share_url != null) {
//                fVar.mo18496a(BBDakaInfo.WEIXIN_SHARE_URL_FIELD_DESC);
//                fVar.mo18495a(bBDakaInfo.weixin_share_url);
//            }
//            if (bBDakaInfo.finished_plan_date != null && bBDakaInfo.isSetFinished_plan_date()) {
//                fVar.mo18496a(BBDakaInfo.FINISHED_PLAN_DATE_FIELD_DESC);
//                fVar.mo18497a(new C2098c(8, bBDakaInfo.finished_plan_date.size()));
//                for (Integer intValue : bBDakaInfo.finished_plan_date) {
//                    fVar.mo18493a(intValue.intValue());
//                }
//            }
//            if (bBDakaInfo.isSetTotal_daka_days()) {
//                fVar.mo18496a(BBDakaInfo.TOTAL_DAKA_DAYS_FIELD_DESC);
//                fVar.mo18493a(bBDakaInfo.total_daka_days);
//            }
//            if (bBDakaInfo.daka_show_img != null && bBDakaInfo.isSetDaka_show_img()) {
//                fVar.mo18496a(BBDakaInfo.DAKA_SHOW_IMG_FIELD_DESC);
//                fVar.mo18495a(bBDakaInfo.daka_show_img);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBDakaInfoStandardSchemeFactory implements C2109b {
//        private BBDakaInfoStandardSchemeFactory() {
//        }
//
//        public BBDakaInfoStandardScheme getScheme() {
//            return new BBDakaInfoStandardScheme();
//        }
//    }
//
//    class BBDakaInfoTupleScheme extends C2111d<BBDakaInfo> {
//        private BBDakaInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBDakaInfo bBDakaInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBDakaInfo.daka_id);
//            lVar.mo18495a(bBDakaInfo.share_img_url);
//            lVar.mo18495a(bBDakaInfo.weibo_share_txt);
//            lVar.mo18495a(bBDakaInfo.weixin_share_title);
//            lVar.mo18495a(bBDakaInfo.weixin_share_url);
//            BitSet bitSet = new BitSet();
//            if (bBDakaInfo.isSetFinished_plan_date()) {
//                bitSet.set(0);
//            }
//            if (bBDakaInfo.isSetTotal_daka_days()) {
//                bitSet.set(1);
//            }
//            if (bBDakaInfo.isSetDaka_show_img()) {
//                bitSet.set(2);
//            }
//            lVar.mo18527a(bitSet, 3);
//            if (bBDakaInfo.isSetFinished_plan_date()) {
//                lVar.mo18493a(bBDakaInfo.finished_plan_date.size());
//                for (Integer intValue : bBDakaInfo.finished_plan_date) {
//                    lVar.mo18493a(intValue.intValue());
//                }
//            }
//            if (bBDakaInfo.isSetTotal_daka_days()) {
//                lVar.mo18493a(bBDakaInfo.total_daka_days);
//            }
//            if (bBDakaInfo.isSetDaka_show_img()) {
//                lVar.mo18495a(bBDakaInfo.daka_show_img);
//            }
//        }
//
//        public void read(C2100f fVar, BBDakaInfo bBDakaInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBDakaInfo.daka_id = lVar.mo18513n();
//            bBDakaInfo.setDaka_idIsSet(true);
//            bBDakaInfo.share_img_url = lVar.mo18516q();
//            bBDakaInfo.setShare_img_urlIsSet(true);
//            bBDakaInfo.weibo_share_txt = lVar.mo18516q();
//            bBDakaInfo.setWeibo_share_txtIsSet(true);
//            bBDakaInfo.weixin_share_title = lVar.mo18516q();
//            bBDakaInfo.setWeixin_share_titleIsSet(true);
//            bBDakaInfo.weixin_share_url = lVar.mo18516q();
//            bBDakaInfo.setWeixin_share_urlIsSet(true);
//            BitSet b = lVar.mo18528b(3);
//            if (b.get(0)) {
//                C2098c cVar = new C2098c(8, lVar.mo18513n());
//                bBDakaInfo.finished_plan_date = new ArrayList(cVar.f5838b);
//                for (int i = 0; i < cVar.f5838b; i++) {
//                    bBDakaInfo.finished_plan_date.add(Integer.valueOf(lVar.mo18513n()));
//                }
//                bBDakaInfo.setFinished_plan_dateIsSet(true);
//            }
//            if (b.get(1)) {
//                bBDakaInfo.total_daka_days = lVar.mo18513n();
//                bBDakaInfo.setTotal_daka_daysIsSet(true);
//            }
//            if (b.get(2)) {
//                bBDakaInfo.daka_show_img = lVar.mo18516q();
//                bBDakaInfo.setDaka_show_imgIsSet(true);
//            }
//        }
//    }
//
//    class BBDakaInfoTupleSchemeFactory implements C2109b {
//        private BBDakaInfoTupleSchemeFactory() {
//        }
//
//        public BBDakaInfoTupleScheme getScheme() {
//            return new BBDakaInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        DAKA_ID(1, "daka_id"),
//        SHARE_IMG_URL(2, "share_img_url"),
//        WEIBO_SHARE_TXT(3, "weibo_share_txt"),
//        WEIXIN_SHARE_TITLE(4, "weixin_share_title"),
//        WEIXIN_SHARE_URL(5, "weixin_share_url"),
//        FINISHED_PLAN_DATE(6, "finished_plan_date"),
//        TOTAL_DAKA_DAYS(7, "total_daka_days"),
//        DAKA_SHOW_IMG(8, "daka_show_img");
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
//                    return DAKA_ID;
//                case 2:
//                    return SHARE_IMG_URL;
//                case 3:
//                    return WEIBO_SHARE_TXT;
//                case 4:
//                    return WEIXIN_SHARE_TITLE;
//                case 5:
//                    return WEIXIN_SHARE_URL;
//                case 6:
//                    return FINISHED_PLAN_DATE;
//                case 7:
//                    return TOTAL_DAKA_DAYS;
//                case 8:
//                    return DAKA_SHOW_IMG;
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
//        hashMap.put(C2110c.class, new BBDakaInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBDakaInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.DAKA_ID, new C2091a("daka_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SHARE_IMG_URL, new C2091a("share_img_url", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WEIBO_SHARE_TXT, new C2091a("weibo_share_txt", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WEIXIN_SHARE_TITLE, new C2091a("weixin_share_title", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WEIXIN_SHARE_URL, new C2091a("weixin_share_url", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.FINISHED_PLAN_DATE, new C2091a("finished_plan_date", 2, new C2093c(new C2092b(8, 0))));
//        enumMap.put(_Fields.TOTAL_DAKA_DAYS, new C2091a("total_daka_days", 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.DAKA_SHOW_IMG, new C2091a("daka_show_img", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBDakaInfo.class, metaDataMap);
//    }
//
//    public BBDakaInfo() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.FINISHED_PLAN_DATE, _Fields.TOTAL_DAKA_DAYS, _Fields.DAKA_SHOW_IMG};
//    }
//
//    public BBDakaInfo(int i, String str, String str2, String str3, String str4) {
//        this();
//        this.daka_id = i;
//        setDaka_idIsSet(true);
//        this.share_img_url = str;
//        this.weibo_share_txt = str2;
//        this.weixin_share_title = str3;
//        this.weixin_share_url = str4;
//    }
//
//    public BBDakaInfo(BBDakaInfo bBDakaInfo) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.FINISHED_PLAN_DATE, _Fields.TOTAL_DAKA_DAYS, _Fields.DAKA_SHOW_IMG};
//        this.__isset_bitfield = bBDakaInfo.__isset_bitfield;
//        this.daka_id = bBDakaInfo.daka_id;
//        if (bBDakaInfo.isSetShare_img_url()) {
//            this.share_img_url = bBDakaInfo.share_img_url;
//        }
//        if (bBDakaInfo.isSetWeibo_share_txt()) {
//            this.weibo_share_txt = bBDakaInfo.weibo_share_txt;
//        }
//        if (bBDakaInfo.isSetWeixin_share_title()) {
//            this.weixin_share_title = bBDakaInfo.weixin_share_title;
//        }
//        if (bBDakaInfo.isSetWeixin_share_url()) {
//            this.weixin_share_url = bBDakaInfo.weixin_share_url;
//        }
//        if (bBDakaInfo.isSetFinished_plan_date()) {
//            this.finished_plan_date = new ArrayList(bBDakaInfo.finished_plan_date);
//        }
//        this.total_daka_days = bBDakaInfo.total_daka_days;
//        if (bBDakaInfo.isSetDaka_show_img()) {
//            this.daka_show_img = bBDakaInfo.daka_show_img;
//        }
//    }
//
//    public BBDakaInfo deepCopy() {
//        return new BBDakaInfo(this);
//    }
//
//    public void clear() {
//        setDaka_idIsSet(false);
//        this.daka_id = 0;
//        this.share_img_url = null;
//        this.weibo_share_txt = null;
//        this.weixin_share_title = null;
//        this.weixin_share_url = null;
//        this.finished_plan_date = null;
//        setTotal_daka_daysIsSet(false);
//        this.total_daka_days = 0;
//        this.daka_show_img = null;
//    }
//
//    public int getDaka_id() {
//        return this.daka_id;
//    }
//
//    public BBDakaInfo setDaka_id(int i) {
//        this.daka_id = i;
//        setDaka_idIsSet(true);
//        return this;
//    }
//
//    public void unsetDaka_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetDaka_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setDaka_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getShare_img_url() {
//        return this.share_img_url;
//    }
//
//    public BBDakaInfo setShare_img_url(String str) {
//        this.share_img_url = str;
//        return this;
//    }
//
//    public void unsetShare_img_url() {
//        this.share_img_url = null;
//    }
//
//    public boolean isSetShare_img_url() {
//        return this.share_img_url != null;
//    }
//
//    public void setShare_img_urlIsSet(boolean z) {
//        if (!z) {
//            this.share_img_url = null;
//        }
//    }
//
//    public String getWeibo_share_txt() {
//        return this.weibo_share_txt;
//    }
//
//    public BBDakaInfo setWeibo_share_txt(String str) {
//        this.weibo_share_txt = str;
//        return this;
//    }
//
//    public void unsetWeibo_share_txt() {
//        this.weibo_share_txt = null;
//    }
//
//    public boolean isSetWeibo_share_txt() {
//        return this.weibo_share_txt != null;
//    }
//
//    public void setWeibo_share_txtIsSet(boolean z) {
//        if (!z) {
//            this.weibo_share_txt = null;
//        }
//    }
//
//    public String getWeixin_share_title() {
//        return this.weixin_share_title;
//    }
//
//    public BBDakaInfo setWeixin_share_title(String str) {
//        this.weixin_share_title = str;
//        return this;
//    }
//
//    public void unsetWeixin_share_title() {
//        this.weixin_share_title = null;
//    }
//
//    public boolean isSetWeixin_share_title() {
//        return this.weixin_share_title != null;
//    }
//
//    public void setWeixin_share_titleIsSet(boolean z) {
//        if (!z) {
//            this.weixin_share_title = null;
//        }
//    }
//
//    public String getWeixin_share_url() {
//        return this.weixin_share_url;
//    }
//
//    public BBDakaInfo setWeixin_share_url(String str) {
//        this.weixin_share_url = str;
//        return this;
//    }
//
//    public void unsetWeixin_share_url() {
//        this.weixin_share_url = null;
//    }
//
//    public boolean isSetWeixin_share_url() {
//        return this.weixin_share_url != null;
//    }
//
//    public void setWeixin_share_urlIsSet(boolean z) {
//        if (!z) {
//            this.weixin_share_url = null;
//        }
//    }
//
//    public int getFinished_plan_dateSize() {
//        if (this.finished_plan_date == null) {
//            return 0;
//        }
//        return this.finished_plan_date.size();
//    }
//
//    public Iterator<Integer> getFinished_plan_dateIterator() {
//        if (this.finished_plan_date == null) {
//            return null;
//        }
//        return this.finished_plan_date.iterator();
//    }
//
//    public void addToFinished_plan_date(int i) {
//        if (this.finished_plan_date == null) {
//            this.finished_plan_date = new ArrayList();
//        }
//        this.finished_plan_date.add(Integer.valueOf(i));
//    }
//
//    public List<Integer> getFinished_plan_date() {
//        return this.finished_plan_date;
//    }
//
//    public BBDakaInfo setFinished_plan_date(List<Integer> list) {
//        this.finished_plan_date = list;
//        return this;
//    }
//
//    public void unsetFinished_plan_date() {
//        this.finished_plan_date = null;
//    }
//
//    public boolean isSetFinished_plan_date() {
//        return this.finished_plan_date != null;
//    }
//
//    public void setFinished_plan_dateIsSet(boolean z) {
//        if (!z) {
//            this.finished_plan_date = null;
//        }
//    }
//
//    public int getTotal_daka_days() {
//        return this.total_daka_days;
//    }
//
//    public BBDakaInfo setTotal_daka_days(int i) {
//        this.total_daka_days = i;
//        setTotal_daka_daysIsSet(true);
//        return this;
//    }
//
//    public void unsetTotal_daka_days() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetTotal_daka_days() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setTotal_daka_daysIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public String getDaka_show_img() {
//        return this.daka_show_img;
//    }
//
//    public BBDakaInfo setDaka_show_img(String str) {
//        this.daka_show_img = str;
//        return this;
//    }
//
//    public void unsetDaka_show_img() {
//        this.daka_show_img = null;
//    }
//
//    public boolean isSetDaka_show_img() {
//        return this.daka_show_img != null;
//    }
//
//    public void setDaka_show_imgIsSet(boolean z) {
//        if (!z) {
//            this.daka_show_img = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case DAKA_ID:
//                if (obj == null) {
//                    unsetDaka_id();
//                    return;
//                } else {
//                    setDaka_id(((Integer) obj).intValue());
//                    return;
//                }
//            case SHARE_IMG_URL:
//                if (obj == null) {
//                    unsetShare_img_url();
//                    return;
//                } else {
//                    setShare_img_url((String) obj);
//                    return;
//                }
//            case WEIBO_SHARE_TXT:
//                if (obj == null) {
//                    unsetWeibo_share_txt();
//                    return;
//                } else {
//                    setWeibo_share_txt((String) obj);
//                    return;
//                }
//            case WEIXIN_SHARE_TITLE:
//                if (obj == null) {
//                    unsetWeixin_share_title();
//                    return;
//                } else {
//                    setWeixin_share_title((String) obj);
//                    return;
//                }
//            case WEIXIN_SHARE_URL:
//                if (obj == null) {
//                    unsetWeixin_share_url();
//                    return;
//                } else {
//                    setWeixin_share_url((String) obj);
//                    return;
//                }
//            case FINISHED_PLAN_DATE:
//                if (obj == null) {
//                    unsetFinished_plan_date();
//                    return;
//                } else {
//                    setFinished_plan_date((List) obj);
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
//            case DAKA_SHOW_IMG:
//                if (obj == null) {
//                    unsetDaka_show_img();
//                    return;
//                } else {
//                    setDaka_show_img((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case DAKA_ID:
//                return Integer.valueOf(getDaka_id());
//            case SHARE_IMG_URL:
//                return getShare_img_url();
//            case WEIBO_SHARE_TXT:
//                return getWeibo_share_txt();
//            case WEIXIN_SHARE_TITLE:
//                return getWeixin_share_title();
//            case WEIXIN_SHARE_URL:
//                return getWeixin_share_url();
//            case FINISHED_PLAN_DATE:
//                return getFinished_plan_date();
//            case TOTAL_DAKA_DAYS:
//                return Integer.valueOf(getTotal_daka_days());
//            case DAKA_SHOW_IMG:
//                return getDaka_show_img();
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
//            case DAKA_ID:
//                return isSetDaka_id();
//            case SHARE_IMG_URL:
//                return isSetShare_img_url();
//            case WEIBO_SHARE_TXT:
//                return isSetWeibo_share_txt();
//            case WEIXIN_SHARE_TITLE:
//                return isSetWeixin_share_title();
//            case WEIXIN_SHARE_URL:
//                return isSetWeixin_share_url();
//            case FINISHED_PLAN_DATE:
//                return isSetFinished_plan_date();
//            case TOTAL_DAKA_DAYS:
//                return isSetTotal_daka_days();
//            case DAKA_SHOW_IMG:
//                return isSetDaka_show_img();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBDakaInfo)) {
//            return equals((BBDakaInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBDakaInfo bBDakaInfo) {
//        if (bBDakaInfo == null || this.daka_id != bBDakaInfo.daka_id) {
//            return false;
//        }
//        boolean isSetShare_img_url = isSetShare_img_url();
//        boolean isSetShare_img_url2 = bBDakaInfo.isSetShare_img_url();
//        if ((isSetShare_img_url || isSetShare_img_url2) && (!isSetShare_img_url || !isSetShare_img_url2 || !this.share_img_url.equals(bBDakaInfo.share_img_url))) {
//            return false;
//        }
//        boolean isSetWeibo_share_txt = isSetWeibo_share_txt();
//        boolean isSetWeibo_share_txt2 = bBDakaInfo.isSetWeibo_share_txt();
//        if ((isSetWeibo_share_txt || isSetWeibo_share_txt2) && (!isSetWeibo_share_txt || !isSetWeibo_share_txt2 || !this.weibo_share_txt.equals(bBDakaInfo.weibo_share_txt))) {
//            return false;
//        }
//        boolean isSetWeixin_share_title = isSetWeixin_share_title();
//        boolean isSetWeixin_share_title2 = bBDakaInfo.isSetWeixin_share_title();
//        if ((isSetWeixin_share_title || isSetWeixin_share_title2) && (!isSetWeixin_share_title || !isSetWeixin_share_title2 || !this.weixin_share_title.equals(bBDakaInfo.weixin_share_title))) {
//            return false;
//        }
//        boolean isSetWeixin_share_url = isSetWeixin_share_url();
//        boolean isSetWeixin_share_url2 = bBDakaInfo.isSetWeixin_share_url();
//        if ((isSetWeixin_share_url || isSetWeixin_share_url2) && (!isSetWeixin_share_url || !isSetWeixin_share_url2 || !this.weixin_share_url.equals(bBDakaInfo.weixin_share_url))) {
//            return false;
//        }
//        boolean isSetFinished_plan_date = isSetFinished_plan_date();
//        boolean isSetFinished_plan_date2 = bBDakaInfo.isSetFinished_plan_date();
//        if ((isSetFinished_plan_date || isSetFinished_plan_date2) && (!isSetFinished_plan_date || !isSetFinished_plan_date2 || !this.finished_plan_date.equals(bBDakaInfo.finished_plan_date))) {
//            return false;
//        }
//        boolean isSetTotal_daka_days = isSetTotal_daka_days();
//        boolean isSetTotal_daka_days2 = bBDakaInfo.isSetTotal_daka_days();
//        if ((isSetTotal_daka_days || isSetTotal_daka_days2) && (!isSetTotal_daka_days || !isSetTotal_daka_days2 || this.total_daka_days != bBDakaInfo.total_daka_days)) {
//            return false;
//        }
//        boolean isSetDaka_show_img = isSetDaka_show_img();
//        boolean isSetDaka_show_img2 = bBDakaInfo.isSetDaka_show_img();
//        if ((isSetDaka_show_img || isSetDaka_show_img2) && (!isSetDaka_show_img || !isSetDaka_show_img2 || !this.daka_show_img.equals(bBDakaInfo.daka_show_img))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBDakaInfo bBDakaInfo) {
//        if (!getClass().equals(bBDakaInfo.getClass())) {
//            return getClass().getName().compareTo(bBDakaInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetDaka_id()).compareTo(Boolean.valueOf(bBDakaInfo.isSetDaka_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetDaka_id()) {
//            int a = C2121h.m5522a(this.daka_id, bBDakaInfo.daka_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetShare_img_url()).compareTo(Boolean.valueOf(bBDakaInfo.isSetShare_img_url()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetShare_img_url()) {
//            int a2 = C2121h.m5525a(this.share_img_url, bBDakaInfo.share_img_url);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetWeibo_share_txt()).compareTo(Boolean.valueOf(bBDakaInfo.isSetWeibo_share_txt()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetWeibo_share_txt()) {
//            int a3 = C2121h.m5525a(this.weibo_share_txt, bBDakaInfo.weibo_share_txt);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetWeixin_share_title()).compareTo(Boolean.valueOf(bBDakaInfo.isSetWeixin_share_title()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetWeixin_share_title()) {
//            int a4 = C2121h.m5525a(this.weixin_share_title, bBDakaInfo.weixin_share_title);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetWeixin_share_url()).compareTo(Boolean.valueOf(bBDakaInfo.isSetWeixin_share_url()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetWeixin_share_url()) {
//            int a5 = C2121h.m5525a(this.weixin_share_url, bBDakaInfo.weixin_share_url);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetFinished_plan_date()).compareTo(Boolean.valueOf(bBDakaInfo.isSetFinished_plan_date()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetFinished_plan_date()) {
//            int a6 = C2121h.m5526a((List) this.finished_plan_date, (List) bBDakaInfo.finished_plan_date);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetTotal_daka_days()).compareTo(Boolean.valueOf(bBDakaInfo.isSetTotal_daka_days()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetTotal_daka_days()) {
//            int a7 = C2121h.m5522a(this.total_daka_days, bBDakaInfo.total_daka_days);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetDaka_show_img()).compareTo(Boolean.valueOf(bBDakaInfo.isSetDaka_show_img()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetDaka_show_img()) {
//            int a8 = C2121h.m5525a(this.daka_show_img, bBDakaInfo.daka_show_img);
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
//        StringBuilder sb = new StringBuilder("BBDakaInfo(");
//        sb.append("daka_id:");
//        sb.append(this.daka_id);
//        sb.append(", ");
//        sb.append("share_img_url:");
//        if (this.share_img_url == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.share_img_url);
//        }
//        sb.append(", ");
//        sb.append("weibo_share_txt:");
//        if (this.weibo_share_txt == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.weibo_share_txt);
//        }
//        sb.append(", ");
//        sb.append("weixin_share_title:");
//        if (this.weixin_share_title == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.weixin_share_title);
//        }
//        sb.append(", ");
//        sb.append("weixin_share_url:");
//        if (this.weixin_share_url == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.weixin_share_url);
//        }
//        if (isSetFinished_plan_date()) {
//            sb.append(", ");
//            sb.append("finished_plan_date:");
//            if (this.finished_plan_date == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.finished_plan_date);
//            }
//        }
//        if (isSetTotal_daka_days()) {
//            sb.append(", ");
//            sb.append("total_daka_days:");
//            sb.append(this.total_daka_days);
//        }
//        if (isSetDaka_show_img()) {
//            sb.append(", ");
//            sb.append("daka_show_img:");
//            if (this.daka_show_img == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.daka_show_img);
//            }
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.share_img_url == null) {
//            throw new C2101g("Required field 'share_img_url' was not present! Struct: " + toString());
//        } else if (this.weibo_share_txt == null) {
//            throw new C2101g("Required field 'weibo_share_txt' was not present! Struct: " + toString());
//        } else if (this.weixin_share_title == null) {
//            throw new C2101g("Required field 'weixin_share_title' was not present! Struct: " + toString());
//        } else if (this.weixin_share_url == null) {
//            throw new C2101g("Required field 'weixin_share_url' was not present! Struct: " + toString());
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
