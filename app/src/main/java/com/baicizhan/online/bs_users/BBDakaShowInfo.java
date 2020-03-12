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
//public class BBDakaShowInfo implements Serializable, Cloneable, Comparable<BBDakaShowInfo>, C2116f<BBDakaShowInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b SHOW_IMAGE_FIELD_DESC = new C2097b("show_image", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBDakaShowInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TOTAL_DAKA_DAYS_FIELD_DESC = new C2097b("total_daka_days", 8, 1);
//    private static final int __TOTAL_DAKA_DAYS_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String show_image;
//    public int total_daka_days;
//
//    class BBDakaShowInfoStandardScheme extends C2110c<BBDakaShowInfo> {
//        private BBDakaShowInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBDakaShowInfo bBDakaShowInfo) {
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
//                                bBDakaShowInfo.total_daka_days = fVar.mo18513n();
//                                bBDakaShowInfo.setTotal_daka_daysIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBDakaShowInfo.show_image = fVar.mo18516q();
//                                bBDakaShowInfo.setShow_imageIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBDakaShowInfo.isSetTotal_daka_days()) {
//                        throw new C2101g("Required field 'total_daka_days' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBDakaShowInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBDakaShowInfo bBDakaShowInfo) {
//            bBDakaShowInfo.validate();
//            BBDakaShowInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBDakaShowInfo.TOTAL_DAKA_DAYS_FIELD_DESC);
//            fVar.mo18493a(bBDakaShowInfo.total_daka_days);
//            if (bBDakaShowInfo.show_image != null) {
//                fVar.mo18496a(BBDakaShowInfo.SHOW_IMAGE_FIELD_DESC);
//                fVar.mo18495a(bBDakaShowInfo.show_image);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBDakaShowInfoStandardSchemeFactory implements C2109b {
//        private BBDakaShowInfoStandardSchemeFactory() {
//        }
//
//        public BBDakaShowInfoStandardScheme getScheme() {
//            return new BBDakaShowInfoStandardScheme();
//        }
//    }
//
//    class BBDakaShowInfoTupleScheme extends C2111d<BBDakaShowInfo> {
//        private BBDakaShowInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBDakaShowInfo bBDakaShowInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBDakaShowInfo.total_daka_days);
//            lVar.mo18495a(bBDakaShowInfo.show_image);
//        }
//
//        public void read(C2100f fVar, BBDakaShowInfo bBDakaShowInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBDakaShowInfo.total_daka_days = lVar.mo18513n();
//            bBDakaShowInfo.setTotal_daka_daysIsSet(true);
//            bBDakaShowInfo.show_image = lVar.mo18516q();
//            bBDakaShowInfo.setShow_imageIsSet(true);
//        }
//    }
//
//    class BBDakaShowInfoTupleSchemeFactory implements C2109b {
//        private BBDakaShowInfoTupleSchemeFactory() {
//        }
//
//        public BBDakaShowInfoTupleScheme getScheme() {
//            return new BBDakaShowInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOTAL_DAKA_DAYS(1, "total_daka_days"),
//        SHOW_IMAGE(2, "show_image");
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
//                    return TOTAL_DAKA_DAYS;
//                case 2:
//                    return SHOW_IMAGE;
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
//        hashMap.put(C2110c.class, new BBDakaShowInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBDakaShowInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOTAL_DAKA_DAYS, new C2091a("total_daka_days", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SHOW_IMAGE, new C2091a("show_image", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBDakaShowInfo.class, metaDataMap);
//    }
//
//    public BBDakaShowInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBDakaShowInfo(int i, String str) {
//        this();
//        this.total_daka_days = i;
//        setTotal_daka_daysIsSet(true);
//        this.show_image = str;
//    }
//
//    public BBDakaShowInfo(BBDakaShowInfo bBDakaShowInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBDakaShowInfo.__isset_bitfield;
//        this.total_daka_days = bBDakaShowInfo.total_daka_days;
//        if (bBDakaShowInfo.isSetShow_image()) {
//            this.show_image = bBDakaShowInfo.show_image;
//        }
//    }
//
//    public BBDakaShowInfo deepCopy() {
//        return new BBDakaShowInfo(this);
//    }
//
//    public void clear() {
//        setTotal_daka_daysIsSet(false);
//        this.total_daka_days = 0;
//        this.show_image = null;
//    }
//
//    public int getTotal_daka_days() {
//        return this.total_daka_days;
//    }
//
//    public BBDakaShowInfo setTotal_daka_days(int i) {
//        this.total_daka_days = i;
//        setTotal_daka_daysIsSet(true);
//        return this;
//    }
//
//    public void unsetTotal_daka_days() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetTotal_daka_days() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setTotal_daka_daysIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getShow_image() {
//        return this.show_image;
//    }
//
//    public BBDakaShowInfo setShow_image(String str) {
//        this.show_image = str;
//        return this;
//    }
//
//    public void unsetShow_image() {
//        this.show_image = null;
//    }
//
//    public boolean isSetShow_image() {
//        return this.show_image != null;
//    }
//
//    public void setShow_imageIsSet(boolean z) {
//        if (!z) {
//            this.show_image = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case TOTAL_DAKA_DAYS:
//                if (obj == null) {
//                    unsetTotal_daka_days();
//                    return;
//                } else {
//                    setTotal_daka_days(((Integer) obj).intValue());
//                    return;
//                }
//            case SHOW_IMAGE:
//                if (obj == null) {
//                    unsetShow_image();
//                    return;
//                } else {
//                    setShow_image((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case TOTAL_DAKA_DAYS:
//                return Integer.valueOf(getTotal_daka_days());
//            case SHOW_IMAGE:
//                return getShow_image();
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
//            case TOTAL_DAKA_DAYS:
//                return isSetTotal_daka_days();
//            case SHOW_IMAGE:
//                return isSetShow_image();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBDakaShowInfo)) {
//            return equals((BBDakaShowInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBDakaShowInfo bBDakaShowInfo) {
//        if (bBDakaShowInfo == null || this.total_daka_days != bBDakaShowInfo.total_daka_days) {
//            return false;
//        }
//        boolean isSetShow_image = isSetShow_image();
//        boolean isSetShow_image2 = bBDakaShowInfo.isSetShow_image();
//        if ((isSetShow_image || isSetShow_image2) && (!isSetShow_image || !isSetShow_image2 || !this.show_image.equals(bBDakaShowInfo.show_image))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBDakaShowInfo bBDakaShowInfo) {
//        if (!getClass().equals(bBDakaShowInfo.getClass())) {
//            return getClass().getName().compareTo(bBDakaShowInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTotal_daka_days()).compareTo(Boolean.valueOf(bBDakaShowInfo.isSetTotal_daka_days()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTotal_daka_days()) {
//            int a = C2121h.m5522a(this.total_daka_days, bBDakaShowInfo.total_daka_days);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetShow_image()).compareTo(Boolean.valueOf(bBDakaShowInfo.isSetShow_image()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetShow_image()) {
//            int a2 = C2121h.m5525a(this.show_image, bBDakaShowInfo.show_image);
//            if (a2 != 0) {
//                return a2;
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
//        StringBuilder sb = new StringBuilder("BBDakaShowInfo(");
//        sb.append("total_daka_days:");
//        sb.append(this.total_daka_days);
//        sb.append(", ");
//        sb.append("show_image:");
//        if (this.show_image == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.show_image);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.show_image == null) {
//            throw new C2101g("Required field 'show_image' was not present! Struct: " + toString());
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
