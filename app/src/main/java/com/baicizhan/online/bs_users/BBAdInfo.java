//package com.baicizhan.online.bs_users;
//
//import com.p052e.p053a.p054a.JceStruct;
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
//public class BBAdInfo implements Serializable, Cloneable, Comparable<BBAdInfo>, C2116f<BBAdInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b AD_ID_FIELD_DESC = new C2097b("ad_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b AD_NAME_FIELD_DESC = new C2097b("ad_name", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b BTN_H_FIELD_DESC = new C2097b("btn_h", 4, 9);
//    /* access modifiers changed from: private */
//    public static final C2097b BTN_W_FIELD_DESC = new C2097b("btn_w", 4, 8);
//    /* access modifiers changed from: private */
//    public static final C2097b BTN_X_FIELD_DESC = new C2097b("btn_x", 4, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b BTN_Y_FIELD_DESC = new C2097b("btn_y", 4, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b CLICK_URL_FIELD_DESC = new C2097b("click_url", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b IMAGE_URL_FIELD_DESC = new C2097b("image_url", JceStruct.STRUCT_END, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b SHOW_TIME_FIELD_DESC = new C2097b("show_time", 8, 5);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBAdInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TAOBAO_ITEM_ID_FIELD_DESC = new C2097b("taobao_item_id", 10, 10);
//    private static final int __AD_ID_ISSET_ID = 0;
//    private static final int __BTN_H_ISSET_ID = 5;
//    private static final int __BTN_W_ISSET_ID = 4;
//    private static final int __BTN_X_ISSET_ID = 2;
//    private static final int __BTN_Y_ISSET_ID = 3;
//    private static final int __SHOW_TIME_ISSET_ID = 1;
//    private static final int __TAOBAO_ITEM_ID_ISSET_ID = 6;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int ad_id;
//    public String ad_name;
//    public double btn_h;
//    public double btn_w;
//    public double btn_x;
//    public double btn_y;
//    public String click_url;
//    public String image_url;
//    private _Fields[] optionals;
//    public int show_time;
//    public long taobao_item_id;
//
//    class BBAdInfoStandardScheme extends C2110c<BBAdInfo> {
//        private BBAdInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBAdInfo bBAdInfo) {
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
//                                bBAdInfo.ad_id = fVar.mo18513n();
//                                bBAdInfo.setAd_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdInfo.ad_name = fVar.mo18516q();
//                                bBAdInfo.setAd_nameIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdInfo.image_url = fVar.mo18516q();
//                                bBAdInfo.setImage_urlIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdInfo.click_url = fVar.mo18516q();
//                                bBAdInfo.setClick_urlIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdInfo.show_time = fVar.mo18513n();
//                                bBAdInfo.setShow_timeIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 4) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdInfo.btn_x = fVar.mo18515p();
//                                bBAdInfo.setBtn_xIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 4) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdInfo.btn_y = fVar.mo18515p();
//                                bBAdInfo.setBtn_yIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 4) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdInfo.btn_w = fVar.mo18515p();
//                                bBAdInfo.setBtn_wIsSet(true);
//                                break;
//                            }
//                        case 9:
//                            if (g.f5835b != 4) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdInfo.btn_h = fVar.mo18515p();
//                                bBAdInfo.setBtn_hIsSet(true);
//                                break;
//                            }
//                        case 10:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdInfo.taobao_item_id = fVar.mo18514o();
//                                bBAdInfo.setTaobao_item_idIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBAdInfo.isSetAd_id()) {
//                        throw new C2101g("Required field 'ad_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBAdInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBAdInfo bBAdInfo) {
//            bBAdInfo.validate();
//            BBAdInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBAdInfo.AD_ID_FIELD_DESC);
//            fVar.mo18493a(bBAdInfo.ad_id);
//            if (bBAdInfo.ad_name != null) {
//                fVar.mo18496a(BBAdInfo.AD_NAME_FIELD_DESC);
//                fVar.mo18495a(bBAdInfo.ad_name);
//            }
//            if (bBAdInfo.image_url != null && bBAdInfo.isSetImage_url()) {
//                fVar.mo18496a(BBAdInfo.IMAGE_URL_FIELD_DESC);
//                fVar.mo18495a(bBAdInfo.image_url);
//            }
//            if (bBAdInfo.click_url != null && bBAdInfo.isSetClick_url()) {
//                fVar.mo18496a(BBAdInfo.CLICK_URL_FIELD_DESC);
//                fVar.mo18495a(bBAdInfo.click_url);
//            }
//            if (bBAdInfo.isSetShow_time()) {
//                fVar.mo18496a(BBAdInfo.SHOW_TIME_FIELD_DESC);
//                fVar.mo18493a(bBAdInfo.show_time);
//            }
//            if (bBAdInfo.isSetBtn_x()) {
//                fVar.mo18496a(BBAdInfo.BTN_X_FIELD_DESC);
//                fVar.mo18492a(bBAdInfo.btn_x);
//            }
//            if (bBAdInfo.isSetBtn_y()) {
//                fVar.mo18496a(BBAdInfo.BTN_Y_FIELD_DESC);
//                fVar.mo18492a(bBAdInfo.btn_y);
//            }
//            if (bBAdInfo.isSetBtn_w()) {
//                fVar.mo18496a(BBAdInfo.BTN_W_FIELD_DESC);
//                fVar.mo18492a(bBAdInfo.btn_w);
//            }
//            if (bBAdInfo.isSetBtn_h()) {
//                fVar.mo18496a(BBAdInfo.BTN_H_FIELD_DESC);
//                fVar.mo18492a(bBAdInfo.btn_h);
//            }
//            if (bBAdInfo.isSetTaobao_item_id()) {
//                fVar.mo18496a(BBAdInfo.TAOBAO_ITEM_ID_FIELD_DESC);
//                fVar.mo18494a(bBAdInfo.taobao_item_id);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBAdInfoStandardSchemeFactory implements C2109b {
//        private BBAdInfoStandardSchemeFactory() {
//        }
//
//        public BBAdInfoStandardScheme getScheme() {
//            return new BBAdInfoStandardScheme();
//        }
//    }
//
//    class BBAdInfoTupleScheme extends C2111d<BBAdInfo> {
//        private BBAdInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBAdInfo bBAdInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBAdInfo.ad_id);
//            lVar.mo18495a(bBAdInfo.ad_name);
//            BitSet bitSet = new BitSet();
//            if (bBAdInfo.isSetImage_url()) {
//                bitSet.set(0);
//            }
//            if (bBAdInfo.isSetClick_url()) {
//                bitSet.set(1);
//            }
//            if (bBAdInfo.isSetShow_time()) {
//                bitSet.set(2);
//            }
//            if (bBAdInfo.isSetBtn_x()) {
//                bitSet.set(3);
//            }
//            if (bBAdInfo.isSetBtn_y()) {
//                bitSet.set(4);
//            }
//            if (bBAdInfo.isSetBtn_w()) {
//                bitSet.set(5);
//            }
//            if (bBAdInfo.isSetBtn_h()) {
//                bitSet.set(6);
//            }
//            if (bBAdInfo.isSetTaobao_item_id()) {
//                bitSet.set(7);
//            }
//            lVar.mo18527a(bitSet, 8);
//            if (bBAdInfo.isSetImage_url()) {
//                lVar.mo18495a(bBAdInfo.image_url);
//            }
//            if (bBAdInfo.isSetClick_url()) {
//                lVar.mo18495a(bBAdInfo.click_url);
//            }
//            if (bBAdInfo.isSetShow_time()) {
//                lVar.mo18493a(bBAdInfo.show_time);
//            }
//            if (bBAdInfo.isSetBtn_x()) {
//                lVar.mo18492a(bBAdInfo.btn_x);
//            }
//            if (bBAdInfo.isSetBtn_y()) {
//                lVar.mo18492a(bBAdInfo.btn_y);
//            }
//            if (bBAdInfo.isSetBtn_w()) {
//                lVar.mo18492a(bBAdInfo.btn_w);
//            }
//            if (bBAdInfo.isSetBtn_h()) {
//                lVar.mo18492a(bBAdInfo.btn_h);
//            }
//            if (bBAdInfo.isSetTaobao_item_id()) {
//                lVar.mo18494a(bBAdInfo.taobao_item_id);
//            }
//        }
//
//        public void read(C2100f fVar, BBAdInfo bBAdInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBAdInfo.ad_id = lVar.mo18513n();
//            bBAdInfo.setAd_idIsSet(true);
//            bBAdInfo.ad_name = lVar.mo18516q();
//            bBAdInfo.setAd_nameIsSet(true);
//            BitSet b = lVar.mo18528b(8);
//            if (b.get(0)) {
//                bBAdInfo.image_url = lVar.mo18516q();
//                bBAdInfo.setImage_urlIsSet(true);
//            }
//            if (b.get(1)) {
//                bBAdInfo.click_url = lVar.mo18516q();
//                bBAdInfo.setClick_urlIsSet(true);
//            }
//            if (b.get(2)) {
//                bBAdInfo.show_time = lVar.mo18513n();
//                bBAdInfo.setShow_timeIsSet(true);
//            }
//            if (b.get(3)) {
//                bBAdInfo.btn_x = lVar.mo18515p();
//                bBAdInfo.setBtn_xIsSet(true);
//            }
//            if (b.get(4)) {
//                bBAdInfo.btn_y = lVar.mo18515p();
//                bBAdInfo.setBtn_yIsSet(true);
//            }
//            if (b.get(5)) {
//                bBAdInfo.btn_w = lVar.mo18515p();
//                bBAdInfo.setBtn_wIsSet(true);
//            }
//            if (b.get(6)) {
//                bBAdInfo.btn_h = lVar.mo18515p();
//                bBAdInfo.setBtn_hIsSet(true);
//            }
//            if (b.get(7)) {
//                bBAdInfo.taobao_item_id = lVar.mo18514o();
//                bBAdInfo.setTaobao_item_idIsSet(true);
//            }
//        }
//    }
//
//    class BBAdInfoTupleSchemeFactory implements C2109b {
//        private BBAdInfoTupleSchemeFactory() {
//        }
//
//        public BBAdInfoTupleScheme getScheme() {
//            return new BBAdInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        AD_ID(1, "ad_id"),
//        AD_NAME(2, "ad_name"),
//        IMAGE_URL(3, "image_url"),
//        CLICK_URL(4, "click_url"),
//        SHOW_TIME(5, "show_time"),
//        BTN_X(6, "btn_x"),
//        BTN_Y(7, "btn_y"),
//        BTN_W(8, "btn_w"),
//        BTN_H(9, "btn_h"),
//        TAOBAO_ITEM_ID(10, "taobao_item_id");
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
//                    return AD_ID;
//                case 2:
//                    return AD_NAME;
//                case 3:
//                    return IMAGE_URL;
//                case 4:
//                    return CLICK_URL;
//                case 5:
//                    return SHOW_TIME;
//                case 6:
//                    return BTN_X;
//                case 7:
//                    return BTN_Y;
//                case 8:
//                    return BTN_W;
//                case 9:
//                    return BTN_H;
//                case 10:
//                    return TAOBAO_ITEM_ID;
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
//        hashMap.put(C2110c.class, new BBAdInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBAdInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.AD_ID, new C2091a("ad_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.AD_NAME, new C2091a("ad_name", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.IMAGE_URL, new C2091a("image_url", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.CLICK_URL, new C2091a("click_url", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.SHOW_TIME, new C2091a("show_time", 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.BTN_X, new C2091a("btn_x", 2, new C2092b(4, 0)));
//        enumMap.put(_Fields.BTN_Y, new C2091a("btn_y", 2, new C2092b(4, 0)));
//        enumMap.put(_Fields.BTN_W, new C2091a("btn_w", 2, new C2092b(4, 0)));
//        enumMap.put(_Fields.BTN_H, new C2091a("btn_h", 2, new C2092b(4, 0)));
//        enumMap.put(_Fields.TAOBAO_ITEM_ID, new C2091a("taobao_item_id", 2, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBAdInfo.class, metaDataMap);
//    }
//
//    public BBAdInfo() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.IMAGE_URL, _Fields.CLICK_URL, _Fields.SHOW_TIME, _Fields.BTN_X, _Fields.BTN_Y, _Fields.BTN_W, _Fields.BTN_H, _Fields.TAOBAO_ITEM_ID};
//    }
//
//    public BBAdInfo(int i, String str) {
//        this();
//        this.ad_id = i;
//        setAd_idIsSet(true);
//        this.ad_name = str;
//    }
//
//    public BBAdInfo(BBAdInfo bBAdInfo) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.IMAGE_URL, _Fields.CLICK_URL, _Fields.SHOW_TIME, _Fields.BTN_X, _Fields.BTN_Y, _Fields.BTN_W, _Fields.BTN_H, _Fields.TAOBAO_ITEM_ID};
//        this.__isset_bitfield = bBAdInfo.__isset_bitfield;
//        this.ad_id = bBAdInfo.ad_id;
//        if (bBAdInfo.isSetAd_name()) {
//            this.ad_name = bBAdInfo.ad_name;
//        }
//        if (bBAdInfo.isSetImage_url()) {
//            this.image_url = bBAdInfo.image_url;
//        }
//        if (bBAdInfo.isSetClick_url()) {
//            this.click_url = bBAdInfo.click_url;
//        }
//        this.show_time = bBAdInfo.show_time;
//        this.btn_x = bBAdInfo.btn_x;
//        this.btn_y = bBAdInfo.btn_y;
//        this.btn_w = bBAdInfo.btn_w;
//        this.btn_h = bBAdInfo.btn_h;
//        this.taobao_item_id = bBAdInfo.taobao_item_id;
//    }
//
//    public BBAdInfo deepCopy() {
//        return new BBAdInfo(this);
//    }
//
//    public void clear() {
//        setAd_idIsSet(false);
//        this.ad_id = 0;
//        this.ad_name = null;
//        this.image_url = null;
//        this.click_url = null;
//        setShow_timeIsSet(false);
//        this.show_time = 0;
//        setBtn_xIsSet(false);
//        this.btn_x = 0.0d;
//        setBtn_yIsSet(false);
//        this.btn_y = 0.0d;
//        setBtn_wIsSet(false);
//        this.btn_w = 0.0d;
//        setBtn_hIsSet(false);
//        this.btn_h = 0.0d;
//        setTaobao_item_idIsSet(false);
//        this.taobao_item_id = 0;
//    }
//
//    public int getAd_id() {
//        return this.ad_id;
//    }
//
//    public BBAdInfo setAd_id(int i) {
//        this.ad_id = i;
//        setAd_idIsSet(true);
//        return this;
//    }
//
//    public void unsetAd_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetAd_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setAd_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getAd_name() {
//        return this.ad_name;
//    }
//
//    public BBAdInfo setAd_name(String str) {
//        this.ad_name = str;
//        return this;
//    }
//
//    public void unsetAd_name() {
//        this.ad_name = null;
//    }
//
//    public boolean isSetAd_name() {
//        return this.ad_name != null;
//    }
//
//    public void setAd_nameIsSet(boolean z) {
//        if (!z) {
//            this.ad_name = null;
//        }
//    }
//
//    public String getImage_url() {
//        return this.image_url;
//    }
//
//    public BBAdInfo setImage_url(String str) {
//        this.image_url = str;
//        return this;
//    }
//
//    public void unsetImage_url() {
//        this.image_url = null;
//    }
//
//    public boolean isSetImage_url() {
//        return this.image_url != null;
//    }
//
//    public void setImage_urlIsSet(boolean z) {
//        if (!z) {
//            this.image_url = null;
//        }
//    }
//
//    public String getClick_url() {
//        return this.click_url;
//    }
//
//    public BBAdInfo setClick_url(String str) {
//        this.click_url = str;
//        return this;
//    }
//
//    public void unsetClick_url() {
//        this.click_url = null;
//    }
//
//    public boolean isSetClick_url() {
//        return this.click_url != null;
//    }
//
//    public void setClick_urlIsSet(boolean z) {
//        if (!z) {
//            this.click_url = null;
//        }
//    }
//
//    public int getShow_time() {
//        return this.show_time;
//    }
//
//    public BBAdInfo setShow_time(int i) {
//        this.show_time = i;
//        setShow_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetShow_time() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetShow_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setShow_timeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public double getBtn_x() {
//        return this.btn_x;
//    }
//
//    public BBAdInfo setBtn_x(double d) {
//        this.btn_x = d;
//        setBtn_xIsSet(true);
//        return this;
//    }
//
//    public void unsetBtn_x() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetBtn_x() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setBtn_xIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public double getBtn_y() {
//        return this.btn_y;
//    }
//
//    public BBAdInfo setBtn_y(double d) {
//        this.btn_y = d;
//        setBtn_yIsSet(true);
//        return this;
//    }
//
//    public void unsetBtn_y() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetBtn_y() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setBtn_yIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public double getBtn_w() {
//        return this.btn_w;
//    }
//
//    public BBAdInfo setBtn_w(double d) {
//        this.btn_w = d;
//        setBtn_wIsSet(true);
//        return this;
//    }
//
//    public void unsetBtn_w() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetBtn_w() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setBtn_wIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 4, z);
//    }
//
//    public double getBtn_h() {
//        return this.btn_h;
//    }
//
//    public BBAdInfo setBtn_h(double d) {
//        this.btn_h = d;
//        setBtn_hIsSet(true);
//        return this;
//    }
//
//    public void unsetBtn_h() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -33);
//    }
//
//    public boolean isSetBtn_h() {
//        return C2090b.m5429a(this.__isset_bitfield, 5);
//    }
//
//    public void setBtn_hIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 5, z);
//    }
//
//    public long getTaobao_item_id() {
//        return this.taobao_item_id;
//    }
//
//    public BBAdInfo setTaobao_item_id(long j) {
//        this.taobao_item_id = j;
//        setTaobao_item_idIsSet(true);
//        return this;
//    }
//
//    public void unsetTaobao_item_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -65);
//    }
//
//    public boolean isSetTaobao_item_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 6);
//    }
//
//    public void setTaobao_item_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 6, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case AD_ID:
//                if (obj == null) {
//                    unsetAd_id();
//                    return;
//                } else {
//                    setAd_id(((Integer) obj).intValue());
//                    return;
//                }
//            case AD_NAME:
//                if (obj == null) {
//                    unsetAd_name();
//                    return;
//                } else {
//                    setAd_name((String) obj);
//                    return;
//                }
//            case IMAGE_URL:
//                if (obj == null) {
//                    unsetImage_url();
//                    return;
//                } else {
//                    setImage_url((String) obj);
//                    return;
//                }
//            case CLICK_URL:
//                if (obj == null) {
//                    unsetClick_url();
//                    return;
//                } else {
//                    setClick_url((String) obj);
//                    return;
//                }
//            case SHOW_TIME:
//                if (obj == null) {
//                    unsetShow_time();
//                    return;
//                } else {
//                    setShow_time(((Integer) obj).intValue());
//                    return;
//                }
//            case BTN_X:
//                if (obj == null) {
//                    unsetBtn_x();
//                    return;
//                } else {
//                    setBtn_x(((Double) obj).doubleValue());
//                    return;
//                }
//            case BTN_Y:
//                if (obj == null) {
//                    unsetBtn_y();
//                    return;
//                } else {
//                    setBtn_y(((Double) obj).doubleValue());
//                    return;
//                }
//            case BTN_W:
//                if (obj == null) {
//                    unsetBtn_w();
//                    return;
//                } else {
//                    setBtn_w(((Double) obj).doubleValue());
//                    return;
//                }
//            case BTN_H:
//                if (obj == null) {
//                    unsetBtn_h();
//                    return;
//                } else {
//                    setBtn_h(((Double) obj).doubleValue());
//                    return;
//                }
//            case TAOBAO_ITEM_ID:
//                if (obj == null) {
//                    unsetTaobao_item_id();
//                    return;
//                } else {
//                    setTaobao_item_id(((Long) obj).longValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case AD_ID:
//                return Integer.valueOf(getAd_id());
//            case AD_NAME:
//                return getAd_name();
//            case IMAGE_URL:
//                return getImage_url();
//            case CLICK_URL:
//                return getClick_url();
//            case SHOW_TIME:
//                return Integer.valueOf(getShow_time());
//            case BTN_X:
//                return Double.valueOf(getBtn_x());
//            case BTN_Y:
//                return Double.valueOf(getBtn_y());
//            case BTN_W:
//                return Double.valueOf(getBtn_w());
//            case BTN_H:
//                return Double.valueOf(getBtn_h());
//            case TAOBAO_ITEM_ID:
//                return Long.valueOf(getTaobao_item_id());
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
//            case AD_ID:
//                return isSetAd_id();
//            case AD_NAME:
//                return isSetAd_name();
//            case IMAGE_URL:
//                return isSetImage_url();
//            case CLICK_URL:
//                return isSetClick_url();
//            case SHOW_TIME:
//                return isSetShow_time();
//            case BTN_X:
//                return isSetBtn_x();
//            case BTN_Y:
//                return isSetBtn_y();
//            case BTN_W:
//                return isSetBtn_w();
//            case BTN_H:
//                return isSetBtn_h();
//            case TAOBAO_ITEM_ID:
//                return isSetTaobao_item_id();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBAdInfo)) {
//            return equals((BBAdInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBAdInfo bBAdInfo) {
//        if (bBAdInfo == null || this.ad_id != bBAdInfo.ad_id) {
//            return false;
//        }
//        boolean isSetAd_name = isSetAd_name();
//        boolean isSetAd_name2 = bBAdInfo.isSetAd_name();
//        if ((isSetAd_name || isSetAd_name2) && (!isSetAd_name || !isSetAd_name2 || !this.ad_name.equals(bBAdInfo.ad_name))) {
//            return false;
//        }
//        boolean isSetImage_url = isSetImage_url();
//        boolean isSetImage_url2 = bBAdInfo.isSetImage_url();
//        if ((isSetImage_url || isSetImage_url2) && (!isSetImage_url || !isSetImage_url2 || !this.image_url.equals(bBAdInfo.image_url))) {
//            return false;
//        }
//        boolean isSetClick_url = isSetClick_url();
//        boolean isSetClick_url2 = bBAdInfo.isSetClick_url();
//        if ((isSetClick_url || isSetClick_url2) && (!isSetClick_url || !isSetClick_url2 || !this.click_url.equals(bBAdInfo.click_url))) {
//            return false;
//        }
//        boolean isSetShow_time = isSetShow_time();
//        boolean isSetShow_time2 = bBAdInfo.isSetShow_time();
//        if ((isSetShow_time || isSetShow_time2) && (!isSetShow_time || !isSetShow_time2 || this.show_time != bBAdInfo.show_time)) {
//            return false;
//        }
//        boolean isSetBtn_x = isSetBtn_x();
//        boolean isSetBtn_x2 = bBAdInfo.isSetBtn_x();
//        if ((isSetBtn_x || isSetBtn_x2) && (!isSetBtn_x || !isSetBtn_x2 || this.btn_x != bBAdInfo.btn_x)) {
//            return false;
//        }
//        boolean isSetBtn_y = isSetBtn_y();
//        boolean isSetBtn_y2 = bBAdInfo.isSetBtn_y();
//        if ((isSetBtn_y || isSetBtn_y2) && (!isSetBtn_y || !isSetBtn_y2 || this.btn_y != bBAdInfo.btn_y)) {
//            return false;
//        }
//        boolean isSetBtn_w = isSetBtn_w();
//        boolean isSetBtn_w2 = bBAdInfo.isSetBtn_w();
//        if ((isSetBtn_w || isSetBtn_w2) && (!isSetBtn_w || !isSetBtn_w2 || this.btn_w != bBAdInfo.btn_w)) {
//            return false;
//        }
//        boolean isSetBtn_h = isSetBtn_h();
//        boolean isSetBtn_h2 = bBAdInfo.isSetBtn_h();
//        if ((isSetBtn_h || isSetBtn_h2) && (!isSetBtn_h || !isSetBtn_h2 || this.btn_h != bBAdInfo.btn_h)) {
//            return false;
//        }
//        boolean isSetTaobao_item_id = isSetTaobao_item_id();
//        boolean isSetTaobao_item_id2 = bBAdInfo.isSetTaobao_item_id();
//        if ((isSetTaobao_item_id || isSetTaobao_item_id2) && (!isSetTaobao_item_id || !isSetTaobao_item_id2 || this.taobao_item_id != bBAdInfo.taobao_item_id)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBAdInfo bBAdInfo) {
//        if (!getClass().equals(bBAdInfo.getClass())) {
//            return getClass().getName().compareTo(bBAdInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetAd_id()).compareTo(Boolean.valueOf(bBAdInfo.isSetAd_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetAd_id()) {
//            int a = C2121h.m5522a(this.ad_id, bBAdInfo.ad_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetAd_name()).compareTo(Boolean.valueOf(bBAdInfo.isSetAd_name()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetAd_name()) {
//            int a2 = C2121h.m5525a(this.ad_name, bBAdInfo.ad_name);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetImage_url()).compareTo(Boolean.valueOf(bBAdInfo.isSetImage_url()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetImage_url()) {
//            int a3 = C2121h.m5525a(this.image_url, bBAdInfo.image_url);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetClick_url()).compareTo(Boolean.valueOf(bBAdInfo.isSetClick_url()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetClick_url()) {
//            int a4 = C2121h.m5525a(this.click_url, bBAdInfo.click_url);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetShow_time()).compareTo(Boolean.valueOf(bBAdInfo.isSetShow_time()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetShow_time()) {
//            int a5 = C2121h.m5522a(this.show_time, bBAdInfo.show_time);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetBtn_x()).compareTo(Boolean.valueOf(bBAdInfo.isSetBtn_x()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetBtn_x()) {
//            int a6 = C2121h.m5521a(this.btn_x, bBAdInfo.btn_x);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetBtn_y()).compareTo(Boolean.valueOf(bBAdInfo.isSetBtn_y()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetBtn_y()) {
//            int a7 = C2121h.m5521a(this.btn_y, bBAdInfo.btn_y);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetBtn_w()).compareTo(Boolean.valueOf(bBAdInfo.isSetBtn_w()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetBtn_w()) {
//            int a8 = C2121h.m5521a(this.btn_w, bBAdInfo.btn_w);
//            if (a8 != 0) {
//                return a8;
//            }
//        }
//        int compareTo9 = Boolean.valueOf(isSetBtn_h()).compareTo(Boolean.valueOf(bBAdInfo.isSetBtn_h()));
//        if (compareTo9 != 0) {
//            return compareTo9;
//        }
//        if (isSetBtn_h()) {
//            int a9 = C2121h.m5521a(this.btn_h, bBAdInfo.btn_h);
//            if (a9 != 0) {
//                return a9;
//            }
//        }
//        int compareTo10 = Boolean.valueOf(isSetTaobao_item_id()).compareTo(Boolean.valueOf(bBAdInfo.isSetTaobao_item_id()));
//        if (compareTo10 != 0) {
//            return compareTo10;
//        }
//        if (isSetTaobao_item_id()) {
//            int a10 = C2121h.m5523a(this.taobao_item_id, bBAdInfo.taobao_item_id);
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
//        StringBuilder sb = new StringBuilder("BBAdInfo(");
//        sb.append("ad_id:");
//        sb.append(this.ad_id);
//        sb.append(", ");
//        sb.append("ad_name:");
//        if (this.ad_name == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.ad_name);
//        }
//        if (isSetImage_url()) {
//            sb.append(", ");
//            sb.append("image_url:");
//            if (this.image_url == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.image_url);
//            }
//        }
//        if (isSetClick_url()) {
//            sb.append(", ");
//            sb.append("click_url:");
//            if (this.click_url == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.click_url);
//            }
//        }
//        if (isSetShow_time()) {
//            sb.append(", ");
//            sb.append("show_time:");
//            sb.append(this.show_time);
//        }
//        if (isSetBtn_x()) {
//            sb.append(", ");
//            sb.append("btn_x:");
//            sb.append(this.btn_x);
//        }
//        if (isSetBtn_y()) {
//            sb.append(", ");
//            sb.append("btn_y:");
//            sb.append(this.btn_y);
//        }
//        if (isSetBtn_w()) {
//            sb.append(", ");
//            sb.append("btn_w:");
//            sb.append(this.btn_w);
//        }
//        if (isSetBtn_h()) {
//            sb.append(", ");
//            sb.append("btn_h:");
//            sb.append(this.btn_h);
//        }
//        if (isSetTaobao_item_id()) {
//            sb.append(", ");
//            sb.append("taobao_item_id:");
//            sb.append(this.taobao_item_id);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.ad_name == null) {
//            throw new C2101g("Required field 'ad_name' was not present! Struct: " + toString());
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
