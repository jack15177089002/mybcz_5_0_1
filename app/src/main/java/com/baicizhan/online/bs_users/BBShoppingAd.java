//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.wordtesting.doc.DocDBHelper;
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
//public class BBShoppingAd implements Serializable, Cloneable, Comparable<BBShoppingAd>, C2116f<BBShoppingAd, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b AD_URL_FIELD_DESC = new C2097b("ad_url", JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b CLICK_TYPE_FIELD_DESC = new C2097b("click_type", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b COLOR_FIELD_DESC = new C2097b("color", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b LEFT_MENU_AD_URL_FIELD_DESC = new C2097b("left_menu_ad_url", JceStruct.STRUCT_END, 5);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBShoppingAd");
//    /* access modifiers changed from: private */
//    public static final C2097b TEXT_FIELD_DESC = new C2097b(DocDBHelper.COL_TEXT, JceStruct.STRUCT_END, 3);
//    private static final int __CLICK_TYPE_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String ad_url;
//    public int click_type;
//    public String color;
//    public String left_menu_ad_url;
//    private _Fields[] optionals;
//    public String text;
//
//    class BBShoppingAdStandardScheme extends C2110c<BBShoppingAd> {
//        private BBShoppingAdStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBShoppingAd bBShoppingAd) {
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
//                                bBShoppingAd.ad_url = fVar.mo18516q();
//                                bBShoppingAd.setAd_urlIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBShoppingAd.click_type = fVar.mo18513n();
//                                bBShoppingAd.setClick_typeIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBShoppingAd.text = fVar.mo18516q();
//                                bBShoppingAd.setTextIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBShoppingAd.color = fVar.mo18516q();
//                                bBShoppingAd.setColorIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBShoppingAd.left_menu_ad_url = fVar.mo18516q();
//                                bBShoppingAd.setLeft_menu_ad_urlIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBShoppingAd.isSetClick_type()) {
//                        throw new C2101g("Required field 'click_type' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBShoppingAd.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBShoppingAd bBShoppingAd) {
//            bBShoppingAd.validate();
//            BBShoppingAd.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBShoppingAd.ad_url != null) {
//                fVar.mo18496a(BBShoppingAd.AD_URL_FIELD_DESC);
//                fVar.mo18495a(bBShoppingAd.ad_url);
//            }
//            fVar.mo18496a(BBShoppingAd.CLICK_TYPE_FIELD_DESC);
//            fVar.mo18493a(bBShoppingAd.click_type);
//            if (bBShoppingAd.text != null) {
//                fVar.mo18496a(BBShoppingAd.TEXT_FIELD_DESC);
//                fVar.mo18495a(bBShoppingAd.text);
//            }
//            if (bBShoppingAd.color != null) {
//                fVar.mo18496a(BBShoppingAd.COLOR_FIELD_DESC);
//                fVar.mo18495a(bBShoppingAd.color);
//            }
//            if (bBShoppingAd.left_menu_ad_url != null && bBShoppingAd.isSetLeft_menu_ad_url()) {
//                fVar.mo18496a(BBShoppingAd.LEFT_MENU_AD_URL_FIELD_DESC);
//                fVar.mo18495a(bBShoppingAd.left_menu_ad_url);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBShoppingAdStandardSchemeFactory implements C2109b {
//        private BBShoppingAdStandardSchemeFactory() {
//        }
//
//        public BBShoppingAdStandardScheme getScheme() {
//            return new BBShoppingAdStandardScheme();
//        }
//    }
//
//    class BBShoppingAdTupleScheme extends C2111d<BBShoppingAd> {
//        private BBShoppingAdTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBShoppingAd bBShoppingAd) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBShoppingAd.ad_url);
//            lVar.mo18493a(bBShoppingAd.click_type);
//            lVar.mo18495a(bBShoppingAd.text);
//            lVar.mo18495a(bBShoppingAd.color);
//            BitSet bitSet = new BitSet();
//            if (bBShoppingAd.isSetLeft_menu_ad_url()) {
//                bitSet.set(0);
//            }
//            lVar.mo18527a(bitSet, 1);
//            if (bBShoppingAd.isSetLeft_menu_ad_url()) {
//                lVar.mo18495a(bBShoppingAd.left_menu_ad_url);
//            }
//        }
//
//        public void read(C2100f fVar, BBShoppingAd bBShoppingAd) {
//            C2106l lVar = (C2106l) fVar;
//            bBShoppingAd.ad_url = lVar.mo18516q();
//            bBShoppingAd.setAd_urlIsSet(true);
//            bBShoppingAd.click_type = lVar.mo18513n();
//            bBShoppingAd.setClick_typeIsSet(true);
//            bBShoppingAd.text = lVar.mo18516q();
//            bBShoppingAd.setTextIsSet(true);
//            bBShoppingAd.color = lVar.mo18516q();
//            bBShoppingAd.setColorIsSet(true);
//            if (lVar.mo18528b(1).get(0)) {
//                bBShoppingAd.left_menu_ad_url = lVar.mo18516q();
//                bBShoppingAd.setLeft_menu_ad_urlIsSet(true);
//            }
//        }
//    }
//
//    class BBShoppingAdTupleSchemeFactory implements C2109b {
//        private BBShoppingAdTupleSchemeFactory() {
//        }
//
//        public BBShoppingAdTupleScheme getScheme() {
//            return new BBShoppingAdTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        AD_URL(1, "ad_url"),
//        CLICK_TYPE(2, "click_type"),
//        TEXT(3, DocDBHelper.COL_TEXT),
//        COLOR(4, "color"),
//        LEFT_MENU_AD_URL(5, "left_menu_ad_url");
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
//                    return AD_URL;
//                case 2:
//                    return CLICK_TYPE;
//                case 3:
//                    return TEXT;
//                case 4:
//                    return COLOR;
//                case 5:
//                    return LEFT_MENU_AD_URL;
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
//        hashMap.put(C2110c.class, new BBShoppingAdStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBShoppingAdTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.AD_URL, new C2091a("ad_url", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.CLICK_TYPE, new C2091a("click_type", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.TEXT, new C2091a(DocDBHelper.COL_TEXT, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.COLOR, new C2091a("color", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.LEFT_MENU_AD_URL, new C2091a("left_menu_ad_url", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBShoppingAd.class, metaDataMap);
//    }
//
//    public BBShoppingAd() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.LEFT_MENU_AD_URL};
//    }
//
//    public BBShoppingAd(String str, int i, String str2, String str3) {
//        this();
//        this.ad_url = str;
//        this.click_type = i;
//        setClick_typeIsSet(true);
//        this.text = str2;
//        this.color = str3;
//    }
//
//    public BBShoppingAd(BBShoppingAd bBShoppingAd) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.LEFT_MENU_AD_URL};
//        this.__isset_bitfield = bBShoppingAd.__isset_bitfield;
//        if (bBShoppingAd.isSetAd_url()) {
//            this.ad_url = bBShoppingAd.ad_url;
//        }
//        this.click_type = bBShoppingAd.click_type;
//        if (bBShoppingAd.isSetText()) {
//            this.text = bBShoppingAd.text;
//        }
//        if (bBShoppingAd.isSetColor()) {
//            this.color = bBShoppingAd.color;
//        }
//        if (bBShoppingAd.isSetLeft_menu_ad_url()) {
//            this.left_menu_ad_url = bBShoppingAd.left_menu_ad_url;
//        }
//    }
//
//    public BBShoppingAd deepCopy() {
//        return new BBShoppingAd(this);
//    }
//
//    public void clear() {
//        this.ad_url = null;
//        setClick_typeIsSet(false);
//        this.click_type = 0;
//        this.text = null;
//        this.color = null;
//        this.left_menu_ad_url = null;
//    }
//
//    public String getAd_url() {
//        return this.ad_url;
//    }
//
//    public BBShoppingAd setAd_url(String str) {
//        this.ad_url = str;
//        return this;
//    }
//
//    public void unsetAd_url() {
//        this.ad_url = null;
//    }
//
//    public boolean isSetAd_url() {
//        return this.ad_url != null;
//    }
//
//    public void setAd_urlIsSet(boolean z) {
//        if (!z) {
//            this.ad_url = null;
//        }
//    }
//
//    public int getClick_type() {
//        return this.click_type;
//    }
//
//    public BBShoppingAd setClick_type(int i) {
//        this.click_type = i;
//        setClick_typeIsSet(true);
//        return this;
//    }
//
//    public void unsetClick_type() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetClick_type() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setClick_typeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getText() {
//        return this.text;
//    }
//
//    public BBShoppingAd setText(String str) {
//        this.text = str;
//        return this;
//    }
//
//    public void unsetText() {
//        this.text = null;
//    }
//
//    public boolean isSetText() {
//        return this.text != null;
//    }
//
//    public void setTextIsSet(boolean z) {
//        if (!z) {
//            this.text = null;
//        }
//    }
//
//    public String getColor() {
//        return this.color;
//    }
//
//    public BBShoppingAd setColor(String str) {
//        this.color = str;
//        return this;
//    }
//
//    public void unsetColor() {
//        this.color = null;
//    }
//
//    public boolean isSetColor() {
//        return this.color != null;
//    }
//
//    public void setColorIsSet(boolean z) {
//        if (!z) {
//            this.color = null;
//        }
//    }
//
//    public String getLeft_menu_ad_url() {
//        return this.left_menu_ad_url;
//    }
//
//    public BBShoppingAd setLeft_menu_ad_url(String str) {
//        this.left_menu_ad_url = str;
//        return this;
//    }
//
//    public void unsetLeft_menu_ad_url() {
//        this.left_menu_ad_url = null;
//    }
//
//    public boolean isSetLeft_menu_ad_url() {
//        return this.left_menu_ad_url != null;
//    }
//
//    public void setLeft_menu_ad_urlIsSet(boolean z) {
//        if (!z) {
//            this.left_menu_ad_url = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case AD_URL:
//                if (obj == null) {
//                    unsetAd_url();
//                    return;
//                } else {
//                    setAd_url((String) obj);
//                    return;
//                }
//            case CLICK_TYPE:
//                if (obj == null) {
//                    unsetClick_type();
//                    return;
//                } else {
//                    setClick_type(((Integer) obj).intValue());
//                    return;
//                }
//            case TEXT:
//                if (obj == null) {
//                    unsetText();
//                    return;
//                } else {
//                    setText((String) obj);
//                    return;
//                }
//            case COLOR:
//                if (obj == null) {
//                    unsetColor();
//                    return;
//                } else {
//                    setColor((String) obj);
//                    return;
//                }
//            case LEFT_MENU_AD_URL:
//                if (obj == null) {
//                    unsetLeft_menu_ad_url();
//                    return;
//                } else {
//                    setLeft_menu_ad_url((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case AD_URL:
//                return getAd_url();
//            case CLICK_TYPE:
//                return Integer.valueOf(getClick_type());
//            case TEXT:
//                return getText();
//            case COLOR:
//                return getColor();
//            case LEFT_MENU_AD_URL:
//                return getLeft_menu_ad_url();
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
//            case AD_URL:
//                return isSetAd_url();
//            case CLICK_TYPE:
//                return isSetClick_type();
//            case TEXT:
//                return isSetText();
//            case COLOR:
//                return isSetColor();
//            case LEFT_MENU_AD_URL:
//                return isSetLeft_menu_ad_url();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBShoppingAd)) {
//            return equals((BBShoppingAd) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBShoppingAd bBShoppingAd) {
//        if (bBShoppingAd == null) {
//            return false;
//        }
//        boolean isSetAd_url = isSetAd_url();
//        boolean isSetAd_url2 = bBShoppingAd.isSetAd_url();
//        if (((isSetAd_url || isSetAd_url2) && (!isSetAd_url || !isSetAd_url2 || !this.ad_url.equals(bBShoppingAd.ad_url))) || this.click_type != bBShoppingAd.click_type) {
//            return false;
//        }
//        boolean isSetText = isSetText();
//        boolean isSetText2 = bBShoppingAd.isSetText();
//        if ((isSetText || isSetText2) && (!isSetText || !isSetText2 || !this.text.equals(bBShoppingAd.text))) {
//            return false;
//        }
//        boolean isSetColor = isSetColor();
//        boolean isSetColor2 = bBShoppingAd.isSetColor();
//        if ((isSetColor || isSetColor2) && (!isSetColor || !isSetColor2 || !this.color.equals(bBShoppingAd.color))) {
//            return false;
//        }
//        boolean isSetLeft_menu_ad_url = isSetLeft_menu_ad_url();
//        boolean isSetLeft_menu_ad_url2 = bBShoppingAd.isSetLeft_menu_ad_url();
//        if ((isSetLeft_menu_ad_url || isSetLeft_menu_ad_url2) && (!isSetLeft_menu_ad_url || !isSetLeft_menu_ad_url2 || !this.left_menu_ad_url.equals(bBShoppingAd.left_menu_ad_url))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBShoppingAd bBShoppingAd) {
//        if (!getClass().equals(bBShoppingAd.getClass())) {
//            return getClass().getName().compareTo(bBShoppingAd.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetAd_url()).compareTo(Boolean.valueOf(bBShoppingAd.isSetAd_url()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetAd_url()) {
//            int a = C2121h.m5525a(this.ad_url, bBShoppingAd.ad_url);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetClick_type()).compareTo(Boolean.valueOf(bBShoppingAd.isSetClick_type()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetClick_type()) {
//            int a2 = C2121h.m5522a(this.click_type, bBShoppingAd.click_type);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetText()).compareTo(Boolean.valueOf(bBShoppingAd.isSetText()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetText()) {
//            int a3 = C2121h.m5525a(this.text, bBShoppingAd.text);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetColor()).compareTo(Boolean.valueOf(bBShoppingAd.isSetColor()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetColor()) {
//            int a4 = C2121h.m5525a(this.color, bBShoppingAd.color);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetLeft_menu_ad_url()).compareTo(Boolean.valueOf(bBShoppingAd.isSetLeft_menu_ad_url()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetLeft_menu_ad_url()) {
//            int a5 = C2121h.m5525a(this.left_menu_ad_url, bBShoppingAd.left_menu_ad_url);
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
//        StringBuilder sb = new StringBuilder("BBShoppingAd(");
//        sb.append("ad_url:");
//        if (this.ad_url == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.ad_url);
//        }
//        sb.append(", ");
//        sb.append("click_type:");
//        sb.append(this.click_type);
//        sb.append(", ");
//        sb.append("text:");
//        if (this.text == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.text);
//        }
//        sb.append(", ");
//        sb.append("color:");
//        if (this.color == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.color);
//        }
//        if (isSetLeft_menu_ad_url()) {
//            sb.append(", ");
//            sb.append("left_menu_ad_url:");
//            if (this.left_menu_ad_url == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.left_menu_ad_url);
//            }
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.ad_url == null) {
//            throw new C2101g("Required field 'ad_url' was not present! Struct: " + toString());
//        } else if (this.text == null) {
//            throw new C2101g("Required field 'text' was not present! Struct: " + toString());
//        } else if (this.color == null) {
//            throw new C2101g("Required field 'color' was not present! Struct: " + toString());
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
