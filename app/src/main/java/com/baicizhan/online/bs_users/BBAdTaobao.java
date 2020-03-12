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
//public class BBAdTaobao implements Serializable, Cloneable, Comparable<BBAdTaobao>, C2116f<BBAdTaobao, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b AD_ID_FIELD_DESC = new C2097b("ad_id", JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b AD_LINK_FIELD_DESC = new C2097b("ad_link", JceStruct.STRUCT_END, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b IOS_APP_LINK_FIELD_DESC = new C2097b("ios_app_link", JceStruct.STRUCT_END, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b SHOW_AD_FIELD_DESC = new C2097b("show_ad", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBAdTaobao");
//    /* access modifiers changed from: private */
//    public static final C2097b TAOBAO_ITEM_ID_FIELD_DESC = new C2097b("taobao_item_id", JceStruct.STRUCT_END, 4);
//    private static final int __SHOW_AD_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String ad_id;
//    public String ad_link;
//    public String ios_app_link;
//    private _Fields[] optionals;
//    public int show_ad;
//    public String taobao_item_id;
//
//    class BBAdTaobaoStandardScheme extends C2110c<BBAdTaobao> {
//        private BBAdTaobaoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBAdTaobao bBAdTaobao) {
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
//                                bBAdTaobao.ad_id = fVar.mo18516q();
//                                bBAdTaobao.setAd_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdTaobao.show_ad = fVar.mo18513n();
//                                bBAdTaobao.setShow_adIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdTaobao.ad_link = fVar.mo18516q();
//                                bBAdTaobao.setAd_linkIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdTaobao.taobao_item_id = fVar.mo18516q();
//                                bBAdTaobao.setTaobao_item_idIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBAdTaobao.ios_app_link = fVar.mo18516q();
//                                bBAdTaobao.setIos_app_linkIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBAdTaobao.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBAdTaobao bBAdTaobao) {
//            bBAdTaobao.validate();
//            BBAdTaobao.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBAdTaobao.ad_id != null) {
//                fVar.mo18496a(BBAdTaobao.AD_ID_FIELD_DESC);
//                fVar.mo18495a(bBAdTaobao.ad_id);
//            }
//            if (bBAdTaobao.isSetShow_ad()) {
//                fVar.mo18496a(BBAdTaobao.SHOW_AD_FIELD_DESC);
//                fVar.mo18493a(bBAdTaobao.show_ad);
//            }
//            if (bBAdTaobao.ad_link != null && bBAdTaobao.isSetAd_link()) {
//                fVar.mo18496a(BBAdTaobao.AD_LINK_FIELD_DESC);
//                fVar.mo18495a(bBAdTaobao.ad_link);
//            }
//            if (bBAdTaobao.taobao_item_id != null && bBAdTaobao.isSetTaobao_item_id()) {
//                fVar.mo18496a(BBAdTaobao.TAOBAO_ITEM_ID_FIELD_DESC);
//                fVar.mo18495a(bBAdTaobao.taobao_item_id);
//            }
//            if (bBAdTaobao.ios_app_link != null && bBAdTaobao.isSetIos_app_link()) {
//                fVar.mo18496a(BBAdTaobao.IOS_APP_LINK_FIELD_DESC);
//                fVar.mo18495a(bBAdTaobao.ios_app_link);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBAdTaobaoStandardSchemeFactory implements C2109b {
//        private BBAdTaobaoStandardSchemeFactory() {
//        }
//
//        public BBAdTaobaoStandardScheme getScheme() {
//            return new BBAdTaobaoStandardScheme();
//        }
//    }
//
//    class BBAdTaobaoTupleScheme extends C2111d<BBAdTaobao> {
//        private BBAdTaobaoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBAdTaobao bBAdTaobao) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBAdTaobao.ad_id);
//            BitSet bitSet = new BitSet();
//            if (bBAdTaobao.isSetShow_ad()) {
//                bitSet.set(0);
//            }
//            if (bBAdTaobao.isSetAd_link()) {
//                bitSet.set(1);
//            }
//            if (bBAdTaobao.isSetTaobao_item_id()) {
//                bitSet.set(2);
//            }
//            if (bBAdTaobao.isSetIos_app_link()) {
//                bitSet.set(3);
//            }
//            lVar.mo18527a(bitSet, 4);
//            if (bBAdTaobao.isSetShow_ad()) {
//                lVar.mo18493a(bBAdTaobao.show_ad);
//            }
//            if (bBAdTaobao.isSetAd_link()) {
//                lVar.mo18495a(bBAdTaobao.ad_link);
//            }
//            if (bBAdTaobao.isSetTaobao_item_id()) {
//                lVar.mo18495a(bBAdTaobao.taobao_item_id);
//            }
//            if (bBAdTaobao.isSetIos_app_link()) {
//                lVar.mo18495a(bBAdTaobao.ios_app_link);
//            }
//        }
//
//        public void read(C2100f fVar, BBAdTaobao bBAdTaobao) {
//            C2106l lVar = (C2106l) fVar;
//            bBAdTaobao.ad_id = lVar.mo18516q();
//            bBAdTaobao.setAd_idIsSet(true);
//            BitSet b = lVar.mo18528b(4);
//            if (b.get(0)) {
//                bBAdTaobao.show_ad = lVar.mo18513n();
//                bBAdTaobao.setShow_adIsSet(true);
//            }
//            if (b.get(1)) {
//                bBAdTaobao.ad_link = lVar.mo18516q();
//                bBAdTaobao.setAd_linkIsSet(true);
//            }
//            if (b.get(2)) {
//                bBAdTaobao.taobao_item_id = lVar.mo18516q();
//                bBAdTaobao.setTaobao_item_idIsSet(true);
//            }
//            if (b.get(3)) {
//                bBAdTaobao.ios_app_link = lVar.mo18516q();
//                bBAdTaobao.setIos_app_linkIsSet(true);
//            }
//        }
//    }
//
//    class BBAdTaobaoTupleSchemeFactory implements C2109b {
//        private BBAdTaobaoTupleSchemeFactory() {
//        }
//
//        public BBAdTaobaoTupleScheme getScheme() {
//            return new BBAdTaobaoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        AD_ID(1, "ad_id"),
//        SHOW_AD(2, "show_ad"),
//        AD_LINK(3, "ad_link"),
//        TAOBAO_ITEM_ID(4, "taobao_item_id"),
//        IOS_APP_LINK(5, "ios_app_link");
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
//                    return SHOW_AD;
//                case 3:
//                    return AD_LINK;
//                case 4:
//                    return TAOBAO_ITEM_ID;
//                case 5:
//                    return IOS_APP_LINK;
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
//        hashMap.put(C2110c.class, new BBAdTaobaoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBAdTaobaoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.AD_ID, new C2091a("ad_id", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.SHOW_AD, new C2091a("show_ad", 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.AD_LINK, new C2091a("ad_link", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.TAOBAO_ITEM_ID, new C2091a("taobao_item_id", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.IOS_APP_LINK, new C2091a("ios_app_link", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBAdTaobao.class, metaDataMap);
//    }
//
//    public BBAdTaobao() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.SHOW_AD, _Fields.AD_LINK, _Fields.TAOBAO_ITEM_ID, _Fields.IOS_APP_LINK};
//    }
//
//    public BBAdTaobao(String str) {
//        this();
//        this.ad_id = str;
//    }
//
//    public BBAdTaobao(BBAdTaobao bBAdTaobao) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.SHOW_AD, _Fields.AD_LINK, _Fields.TAOBAO_ITEM_ID, _Fields.IOS_APP_LINK};
//        this.__isset_bitfield = bBAdTaobao.__isset_bitfield;
//        if (bBAdTaobao.isSetAd_id()) {
//            this.ad_id = bBAdTaobao.ad_id;
//        }
//        this.show_ad = bBAdTaobao.show_ad;
//        if (bBAdTaobao.isSetAd_link()) {
//            this.ad_link = bBAdTaobao.ad_link;
//        }
//        if (bBAdTaobao.isSetTaobao_item_id()) {
//            this.taobao_item_id = bBAdTaobao.taobao_item_id;
//        }
//        if (bBAdTaobao.isSetIos_app_link()) {
//            this.ios_app_link = bBAdTaobao.ios_app_link;
//        }
//    }
//
//    public BBAdTaobao deepCopy() {
//        return new BBAdTaobao(this);
//    }
//
//    public void clear() {
//        this.ad_id = null;
//        setShow_adIsSet(false);
//        this.show_ad = 0;
//        this.ad_link = null;
//        this.taobao_item_id = null;
//        this.ios_app_link = null;
//    }
//
//    public String getAd_id() {
//        return this.ad_id;
//    }
//
//    public BBAdTaobao setAd_id(String str) {
//        this.ad_id = str;
//        return this;
//    }
//
//    public void unsetAd_id() {
//        this.ad_id = null;
//    }
//
//    public boolean isSetAd_id() {
//        return this.ad_id != null;
//    }
//
//    public void setAd_idIsSet(boolean z) {
//        if (!z) {
//            this.ad_id = null;
//        }
//    }
//
//    public int getShow_ad() {
//        return this.show_ad;
//    }
//
//    public BBAdTaobao setShow_ad(int i) {
//        this.show_ad = i;
//        setShow_adIsSet(true);
//        return this;
//    }
//
//    public void unsetShow_ad() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetShow_ad() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setShow_adIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getAd_link() {
//        return this.ad_link;
//    }
//
//    public BBAdTaobao setAd_link(String str) {
//        this.ad_link = str;
//        return this;
//    }
//
//    public void unsetAd_link() {
//        this.ad_link = null;
//    }
//
//    public boolean isSetAd_link() {
//        return this.ad_link != null;
//    }
//
//    public void setAd_linkIsSet(boolean z) {
//        if (!z) {
//            this.ad_link = null;
//        }
//    }
//
//    public String getTaobao_item_id() {
//        return this.taobao_item_id;
//    }
//
//    public BBAdTaobao setTaobao_item_id(String str) {
//        this.taobao_item_id = str;
//        return this;
//    }
//
//    public void unsetTaobao_item_id() {
//        this.taobao_item_id = null;
//    }
//
//    public boolean isSetTaobao_item_id() {
//        return this.taobao_item_id != null;
//    }
//
//    public void setTaobao_item_idIsSet(boolean z) {
//        if (!z) {
//            this.taobao_item_id = null;
//        }
//    }
//
//    public String getIos_app_link() {
//        return this.ios_app_link;
//    }
//
//    public BBAdTaobao setIos_app_link(String str) {
//        this.ios_app_link = str;
//        return this;
//    }
//
//    public void unsetIos_app_link() {
//        this.ios_app_link = null;
//    }
//
//    public boolean isSetIos_app_link() {
//        return this.ios_app_link != null;
//    }
//
//    public void setIos_app_linkIsSet(boolean z) {
//        if (!z) {
//            this.ios_app_link = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case AD_ID:
//                if (obj == null) {
//                    unsetAd_id();
//                    return;
//                } else {
//                    setAd_id((String) obj);
//                    return;
//                }
//            case SHOW_AD:
//                if (obj == null) {
//                    unsetShow_ad();
//                    return;
//                } else {
//                    setShow_ad(((Integer) obj).intValue());
//                    return;
//                }
//            case AD_LINK:
//                if (obj == null) {
//                    unsetAd_link();
//                    return;
//                } else {
//                    setAd_link((String) obj);
//                    return;
//                }
//            case TAOBAO_ITEM_ID:
//                if (obj == null) {
//                    unsetTaobao_item_id();
//                    return;
//                } else {
//                    setTaobao_item_id((String) obj);
//                    return;
//                }
//            case IOS_APP_LINK:
//                if (obj == null) {
//                    unsetIos_app_link();
//                    return;
//                } else {
//                    setIos_app_link((String) obj);
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
//                return getAd_id();
//            case SHOW_AD:
//                return Integer.valueOf(getShow_ad());
//            case AD_LINK:
//                return getAd_link();
//            case TAOBAO_ITEM_ID:
//                return getTaobao_item_id();
//            case IOS_APP_LINK:
//                return getIos_app_link();
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
//            case SHOW_AD:
//                return isSetShow_ad();
//            case AD_LINK:
//                return isSetAd_link();
//            case TAOBAO_ITEM_ID:
//                return isSetTaobao_item_id();
//            case IOS_APP_LINK:
//                return isSetIos_app_link();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBAdTaobao)) {
//            return equals((BBAdTaobao) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBAdTaobao bBAdTaobao) {
//        if (bBAdTaobao == null) {
//            return false;
//        }
//        boolean isSetAd_id = isSetAd_id();
//        boolean isSetAd_id2 = bBAdTaobao.isSetAd_id();
//        if ((isSetAd_id || isSetAd_id2) && (!isSetAd_id || !isSetAd_id2 || !this.ad_id.equals(bBAdTaobao.ad_id))) {
//            return false;
//        }
//        boolean isSetShow_ad = isSetShow_ad();
//        boolean isSetShow_ad2 = bBAdTaobao.isSetShow_ad();
//        if ((isSetShow_ad || isSetShow_ad2) && (!isSetShow_ad || !isSetShow_ad2 || this.show_ad != bBAdTaobao.show_ad)) {
//            return false;
//        }
//        boolean isSetAd_link = isSetAd_link();
//        boolean isSetAd_link2 = bBAdTaobao.isSetAd_link();
//        if ((isSetAd_link || isSetAd_link2) && (!isSetAd_link || !isSetAd_link2 || !this.ad_link.equals(bBAdTaobao.ad_link))) {
//            return false;
//        }
//        boolean isSetTaobao_item_id = isSetTaobao_item_id();
//        boolean isSetTaobao_item_id2 = bBAdTaobao.isSetTaobao_item_id();
//        if ((isSetTaobao_item_id || isSetTaobao_item_id2) && (!isSetTaobao_item_id || !isSetTaobao_item_id2 || !this.taobao_item_id.equals(bBAdTaobao.taobao_item_id))) {
//            return false;
//        }
//        boolean isSetIos_app_link = isSetIos_app_link();
//        boolean isSetIos_app_link2 = bBAdTaobao.isSetIos_app_link();
//        if ((isSetIos_app_link || isSetIos_app_link2) && (!isSetIos_app_link || !isSetIos_app_link2 || !this.ios_app_link.equals(bBAdTaobao.ios_app_link))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBAdTaobao bBAdTaobao) {
//        if (!getClass().equals(bBAdTaobao.getClass())) {
//            return getClass().getName().compareTo(bBAdTaobao.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetAd_id()).compareTo(Boolean.valueOf(bBAdTaobao.isSetAd_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetAd_id()) {
//            int a = C2121h.m5525a(this.ad_id, bBAdTaobao.ad_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetShow_ad()).compareTo(Boolean.valueOf(bBAdTaobao.isSetShow_ad()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetShow_ad()) {
//            int a2 = C2121h.m5522a(this.show_ad, bBAdTaobao.show_ad);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetAd_link()).compareTo(Boolean.valueOf(bBAdTaobao.isSetAd_link()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetAd_link()) {
//            int a3 = C2121h.m5525a(this.ad_link, bBAdTaobao.ad_link);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetTaobao_item_id()).compareTo(Boolean.valueOf(bBAdTaobao.isSetTaobao_item_id()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetTaobao_item_id()) {
//            int a4 = C2121h.m5525a(this.taobao_item_id, bBAdTaobao.taobao_item_id);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetIos_app_link()).compareTo(Boolean.valueOf(bBAdTaobao.isSetIos_app_link()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetIos_app_link()) {
//            int a5 = C2121h.m5525a(this.ios_app_link, bBAdTaobao.ios_app_link);
//            if (a5 != 0) {
//                return a5;
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
//        StringBuilder sb = new StringBuilder("BBAdTaobao(");
//        sb.append("ad_id:");
//        if (this.ad_id == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.ad_id);
//        }
//        if (isSetShow_ad()) {
//            sb.append(", ");
//            sb.append("show_ad:");
//            sb.append(this.show_ad);
//        }
//        if (isSetAd_link()) {
//            sb.append(", ");
//            sb.append("ad_link:");
//            if (this.ad_link == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.ad_link);
//            }
//        }
//        if (isSetTaobao_item_id()) {
//            sb.append(", ");
//            sb.append("taobao_item_id:");
//            if (this.taobao_item_id == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.taobao_item_id);
//            }
//        }
//        if (isSetIos_app_link()) {
//            sb.append(", ");
//            sb.append("ios_app_link:");
//            if (this.ios_app_link == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.ios_app_link);
//            }
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.ad_id == null) {
//            throw new C2101g("Required field 'ad_id' was not present! Struct: " + toString());
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
