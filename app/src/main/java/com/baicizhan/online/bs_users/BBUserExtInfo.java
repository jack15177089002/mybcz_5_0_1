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
//public class BBUserExtInfo implements Serializable, Cloneable, Comparable<BBUserExtInfo>, C2116f<BBUserExtInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b AVATAR_FIELD_DESC = new C2097b("avatar", JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b CITY_FIELD_DESC = new C2097b("city", JceStruct.STRUCT_END, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b DISTRICT_FIELD_DESC = new C2097b("district", JceStruct.STRUCT_END, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b LATITUDE_FIELD_DESC = new C2097b("latitude", 4, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b LONGITUDE_FIELD_DESC = new C2097b("longitude", 4, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b PROVINCE_FIELD_DESC = new C2097b("province", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b SCREEN_MOD_FIELD_DESC = new C2097b("screen_mod", 8, 7);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserExtInfo");
//    private static final int __LATITUDE_ISSET_ID = 1;
//    private static final int __LONGITUDE_ISSET_ID = 0;
//    private static final int __SCREEN_MOD_ISSET_ID = 2;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String avatar;
//    public String city;
//    public String district;
//    public double latitude;
//    public double longitude;
//    private _Fields[] optionals;
//    public String province;
//    public int screen_mod;
//
//    class BBUserExtInfoStandardScheme extends C2110c<BBUserExtInfo> {
//        private BBUserExtInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserExtInfo bBUserExtInfo) {
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
//                                bBUserExtInfo.avatar = fVar.mo18516q();
//                                bBUserExtInfo.setAvatarIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 4) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserExtInfo.longitude = fVar.mo18515p();
//                                bBUserExtInfo.setLongitudeIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 4) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserExtInfo.latitude = fVar.mo18515p();
//                                bBUserExtInfo.setLatitudeIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserExtInfo.province = fVar.mo18516q();
//                                bBUserExtInfo.setProvinceIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserExtInfo.city = fVar.mo18516q();
//                                bBUserExtInfo.setCityIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserExtInfo.district = fVar.mo18516q();
//                                bBUserExtInfo.setDistrictIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserExtInfo.screen_mod = fVar.mo18513n();
//                                bBUserExtInfo.setScreen_modIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBUserExtInfo.isSetLongitude()) {
//                        throw new C2101g("Required field 'longitude' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserExtInfo.isSetLatitude()) {
//                        throw new C2101g("Required field 'latitude' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBUserExtInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserExtInfo bBUserExtInfo) {
//            bBUserExtInfo.validate();
//            BBUserExtInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBUserExtInfo.avatar != null) {
//                fVar.mo18496a(BBUserExtInfo.AVATAR_FIELD_DESC);
//                fVar.mo18495a(bBUserExtInfo.avatar);
//            }
//            fVar.mo18496a(BBUserExtInfo.LONGITUDE_FIELD_DESC);
//            fVar.mo18492a(bBUserExtInfo.longitude);
//            fVar.mo18496a(BBUserExtInfo.LATITUDE_FIELD_DESC);
//            fVar.mo18492a(bBUserExtInfo.latitude);
//            if (bBUserExtInfo.province != null) {
//                fVar.mo18496a(BBUserExtInfo.PROVINCE_FIELD_DESC);
//                fVar.mo18495a(bBUserExtInfo.province);
//            }
//            if (bBUserExtInfo.city != null) {
//                fVar.mo18496a(BBUserExtInfo.CITY_FIELD_DESC);
//                fVar.mo18495a(bBUserExtInfo.city);
//            }
//            if (bBUserExtInfo.district != null) {
//                fVar.mo18496a(BBUserExtInfo.DISTRICT_FIELD_DESC);
//                fVar.mo18495a(bBUserExtInfo.district);
//            }
//            if (bBUserExtInfo.isSetScreen_mod()) {
//                fVar.mo18496a(BBUserExtInfo.SCREEN_MOD_FIELD_DESC);
//                fVar.mo18493a(bBUserExtInfo.screen_mod);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserExtInfoStandardSchemeFactory implements C2109b {
//        private BBUserExtInfoStandardSchemeFactory() {
//        }
//
//        public BBUserExtInfoStandardScheme getScheme() {
//            return new BBUserExtInfoStandardScheme();
//        }
//    }
//
//    class BBUserExtInfoTupleScheme extends C2111d<BBUserExtInfo> {
//        private BBUserExtInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserExtInfo bBUserExtInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBUserExtInfo.avatar);
//            lVar.mo18492a(bBUserExtInfo.longitude);
//            lVar.mo18492a(bBUserExtInfo.latitude);
//            lVar.mo18495a(bBUserExtInfo.province);
//            lVar.mo18495a(bBUserExtInfo.city);
//            lVar.mo18495a(bBUserExtInfo.district);
//            BitSet bitSet = new BitSet();
//            if (bBUserExtInfo.isSetScreen_mod()) {
//                bitSet.set(0);
//            }
//            lVar.mo18527a(bitSet, 1);
//            if (bBUserExtInfo.isSetScreen_mod()) {
//                lVar.mo18493a(bBUserExtInfo.screen_mod);
//            }
//        }
//
//        public void read(C2100f fVar, BBUserExtInfo bBUserExtInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserExtInfo.avatar = lVar.mo18516q();
//            bBUserExtInfo.setAvatarIsSet(true);
//            bBUserExtInfo.longitude = lVar.mo18515p();
//            bBUserExtInfo.setLongitudeIsSet(true);
//            bBUserExtInfo.latitude = lVar.mo18515p();
//            bBUserExtInfo.setLatitudeIsSet(true);
//            bBUserExtInfo.province = lVar.mo18516q();
//            bBUserExtInfo.setProvinceIsSet(true);
//            bBUserExtInfo.city = lVar.mo18516q();
//            bBUserExtInfo.setCityIsSet(true);
//            bBUserExtInfo.district = lVar.mo18516q();
//            bBUserExtInfo.setDistrictIsSet(true);
//            if (lVar.mo18528b(1).get(0)) {
//                bBUserExtInfo.screen_mod = lVar.mo18513n();
//                bBUserExtInfo.setScreen_modIsSet(true);
//            }
//        }
//    }
//
//    class BBUserExtInfoTupleSchemeFactory implements C2109b {
//        private BBUserExtInfoTupleSchemeFactory() {
//        }
//
//        public BBUserExtInfoTupleScheme getScheme() {
//            return new BBUserExtInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        AVATAR(1, "avatar"),
//        LONGITUDE(2, "longitude"),
//        LATITUDE(3, "latitude"),
//        PROVINCE(4, "province"),
//        CITY(5, "city"),
//        DISTRICT(6, "district"),
//        SCREEN_MOD(7, "screen_mod");
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
//                    return AVATAR;
//                case 2:
//                    return LONGITUDE;
//                case 3:
//                    return LATITUDE;
//                case 4:
//                    return PROVINCE;
//                case 5:
//                    return CITY;
//                case 6:
//                    return DISTRICT;
//                case 7:
//                    return SCREEN_MOD;
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
//        hashMap.put(C2110c.class, new BBUserExtInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserExtInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.AVATAR, new C2091a("avatar", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.LONGITUDE, new C2091a("longitude", 1, new C2092b(4, 0)));
//        enumMap.put(_Fields.LATITUDE, new C2091a("latitude", 1, new C2092b(4, 0)));
//        enumMap.put(_Fields.PROVINCE, new C2091a("province", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.CITY, new C2091a("city", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.DISTRICT, new C2091a("district", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.SCREEN_MOD, new C2091a("screen_mod", 2, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserExtInfo.class, metaDataMap);
//    }
//
//    public BBUserExtInfo() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.SCREEN_MOD};
//    }
//
//    public BBUserExtInfo(String str, double d, double d2, String str2, String str3, String str4) {
//        this();
//        this.avatar = str;
//        this.longitude = d;
//        setLongitudeIsSet(true);
//        this.latitude = d2;
//        setLatitudeIsSet(true);
//        this.province = str2;
//        this.city = str3;
//        this.district = str4;
//    }
//
//    public BBUserExtInfo(BBUserExtInfo bBUserExtInfo) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.SCREEN_MOD};
//        this.__isset_bitfield = bBUserExtInfo.__isset_bitfield;
//        if (bBUserExtInfo.isSetAvatar()) {
//            this.avatar = bBUserExtInfo.avatar;
//        }
//        this.longitude = bBUserExtInfo.longitude;
//        this.latitude = bBUserExtInfo.latitude;
//        if (bBUserExtInfo.isSetProvince()) {
//            this.province = bBUserExtInfo.province;
//        }
//        if (bBUserExtInfo.isSetCity()) {
//            this.city = bBUserExtInfo.city;
//        }
//        if (bBUserExtInfo.isSetDistrict()) {
//            this.district = bBUserExtInfo.district;
//        }
//        this.screen_mod = bBUserExtInfo.screen_mod;
//    }
//
//    public BBUserExtInfo deepCopy() {
//        return new BBUserExtInfo(this);
//    }
//
//    public void clear() {
//        this.avatar = null;
//        setLongitudeIsSet(false);
//        this.longitude = 0.0d;
//        setLatitudeIsSet(false);
//        this.latitude = 0.0d;
//        this.province = null;
//        this.city = null;
//        this.district = null;
//        setScreen_modIsSet(false);
//        this.screen_mod = 0;
//    }
//
//    public String getAvatar() {
//        return this.avatar;
//    }
//
//    public BBUserExtInfo setAvatar(String str) {
//        this.avatar = str;
//        return this;
//    }
//
//    public void unsetAvatar() {
//        this.avatar = null;
//    }
//
//    public boolean isSetAvatar() {
//        return this.avatar != null;
//    }
//
//    public void setAvatarIsSet(boolean z) {
//        if (!z) {
//            this.avatar = null;
//        }
//    }
//
//    public double getLongitude() {
//        return this.longitude;
//    }
//
//    public BBUserExtInfo setLongitude(double d) {
//        this.longitude = d;
//        setLongitudeIsSet(true);
//        return this;
//    }
//
//    public void unsetLongitude() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetLongitude() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setLongitudeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public double getLatitude() {
//        return this.latitude;
//    }
//
//    public BBUserExtInfo setLatitude(double d) {
//        this.latitude = d;
//        setLatitudeIsSet(true);
//        return this;
//    }
//
//    public void unsetLatitude() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetLatitude() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setLatitudeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public String getProvince() {
//        return this.province;
//    }
//
//    public BBUserExtInfo setProvince(String str) {
//        this.province = str;
//        return this;
//    }
//
//    public void unsetProvince() {
//        this.province = null;
//    }
//
//    public boolean isSetProvince() {
//        return this.province != null;
//    }
//
//    public void setProvinceIsSet(boolean z) {
//        if (!z) {
//            this.province = null;
//        }
//    }
//
//    public String getCity() {
//        return this.city;
//    }
//
//    public BBUserExtInfo setCity(String str) {
//        this.city = str;
//        return this;
//    }
//
//    public void unsetCity() {
//        this.city = null;
//    }
//
//    public boolean isSetCity() {
//        return this.city != null;
//    }
//
//    public void setCityIsSet(boolean z) {
//        if (!z) {
//            this.city = null;
//        }
//    }
//
//    public String getDistrict() {
//        return this.district;
//    }
//
//    public BBUserExtInfo setDistrict(String str) {
//        this.district = str;
//        return this;
//    }
//
//    public void unsetDistrict() {
//        this.district = null;
//    }
//
//    public boolean isSetDistrict() {
//        return this.district != null;
//    }
//
//    public void setDistrictIsSet(boolean z) {
//        if (!z) {
//            this.district = null;
//        }
//    }
//
//    public int getScreen_mod() {
//        return this.screen_mod;
//    }
//
//    public BBUserExtInfo setScreen_mod(int i) {
//        this.screen_mod = i;
//        setScreen_modIsSet(true);
//        return this;
//    }
//
//    public void unsetScreen_mod() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetScreen_mod() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setScreen_modIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case AVATAR:
//                if (obj == null) {
//                    unsetAvatar();
//                    return;
//                } else {
//                    setAvatar((String) obj);
//                    return;
//                }
//            case LONGITUDE:
//                if (obj == null) {
//                    unsetLongitude();
//                    return;
//                } else {
//                    setLongitude(((Double) obj).doubleValue());
//                    return;
//                }
//            case LATITUDE:
//                if (obj == null) {
//                    unsetLatitude();
//                    return;
//                } else {
//                    setLatitude(((Double) obj).doubleValue());
//                    return;
//                }
//            case PROVINCE:
//                if (obj == null) {
//                    unsetProvince();
//                    return;
//                } else {
//                    setProvince((String) obj);
//                    return;
//                }
//            case CITY:
//                if (obj == null) {
//                    unsetCity();
//                    return;
//                } else {
//                    setCity((String) obj);
//                    return;
//                }
//            case DISTRICT:
//                if (obj == null) {
//                    unsetDistrict();
//                    return;
//                } else {
//                    setDistrict((String) obj);
//                    return;
//                }
//            case SCREEN_MOD:
//                if (obj == null) {
//                    unsetScreen_mod();
//                    return;
//                } else {
//                    setScreen_mod(((Integer) obj).intValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case AVATAR:
//                return getAvatar();
//            case LONGITUDE:
//                return Double.valueOf(getLongitude());
//            case LATITUDE:
//                return Double.valueOf(getLatitude());
//            case PROVINCE:
//                return getProvince();
//            case CITY:
//                return getCity();
//            case DISTRICT:
//                return getDistrict();
//            case SCREEN_MOD:
//                return Integer.valueOf(getScreen_mod());
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
//            case AVATAR:
//                return isSetAvatar();
//            case LONGITUDE:
//                return isSetLongitude();
//            case LATITUDE:
//                return isSetLatitude();
//            case PROVINCE:
//                return isSetProvince();
//            case CITY:
//                return isSetCity();
//            case DISTRICT:
//                return isSetDistrict();
//            case SCREEN_MOD:
//                return isSetScreen_mod();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBUserExtInfo)) {
//            return equals((BBUserExtInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserExtInfo bBUserExtInfo) {
//        if (bBUserExtInfo == null) {
//            return false;
//        }
//        boolean isSetAvatar = isSetAvatar();
//        boolean isSetAvatar2 = bBUserExtInfo.isSetAvatar();
//        if (((isSetAvatar || isSetAvatar2) && (!isSetAvatar || !isSetAvatar2 || !this.avatar.equals(bBUserExtInfo.avatar))) || this.longitude != bBUserExtInfo.longitude || this.latitude != bBUserExtInfo.latitude) {
//            return false;
//        }
//        boolean isSetProvince = isSetProvince();
//        boolean isSetProvince2 = bBUserExtInfo.isSetProvince();
//        if ((isSetProvince || isSetProvince2) && (!isSetProvince || !isSetProvince2 || !this.province.equals(bBUserExtInfo.province))) {
//            return false;
//        }
//        boolean isSetCity = isSetCity();
//        boolean isSetCity2 = bBUserExtInfo.isSetCity();
//        if ((isSetCity || isSetCity2) && (!isSetCity || !isSetCity2 || !this.city.equals(bBUserExtInfo.city))) {
//            return false;
//        }
//        boolean isSetDistrict = isSetDistrict();
//        boolean isSetDistrict2 = bBUserExtInfo.isSetDistrict();
//        if ((isSetDistrict || isSetDistrict2) && (!isSetDistrict || !isSetDistrict2 || !this.district.equals(bBUserExtInfo.district))) {
//            return false;
//        }
//        boolean isSetScreen_mod = isSetScreen_mod();
//        boolean isSetScreen_mod2 = bBUserExtInfo.isSetScreen_mod();
//        if ((isSetScreen_mod || isSetScreen_mod2) && (!isSetScreen_mod || !isSetScreen_mod2 || this.screen_mod != bBUserExtInfo.screen_mod)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserExtInfo bBUserExtInfo) {
//        if (!getClass().equals(bBUserExtInfo.getClass())) {
//            return getClass().getName().compareTo(bBUserExtInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetAvatar()).compareTo(Boolean.valueOf(bBUserExtInfo.isSetAvatar()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetAvatar()) {
//            int a = C2121h.m5525a(this.avatar, bBUserExtInfo.avatar);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetLongitude()).compareTo(Boolean.valueOf(bBUserExtInfo.isSetLongitude()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetLongitude()) {
//            int a2 = C2121h.m5521a(this.longitude, bBUserExtInfo.longitude);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetLatitude()).compareTo(Boolean.valueOf(bBUserExtInfo.isSetLatitude()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetLatitude()) {
//            int a3 = C2121h.m5521a(this.latitude, bBUserExtInfo.latitude);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetProvince()).compareTo(Boolean.valueOf(bBUserExtInfo.isSetProvince()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetProvince()) {
//            int a4 = C2121h.m5525a(this.province, bBUserExtInfo.province);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetCity()).compareTo(Boolean.valueOf(bBUserExtInfo.isSetCity()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetCity()) {
//            int a5 = C2121h.m5525a(this.city, bBUserExtInfo.city);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetDistrict()).compareTo(Boolean.valueOf(bBUserExtInfo.isSetDistrict()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetDistrict()) {
//            int a6 = C2121h.m5525a(this.district, bBUserExtInfo.district);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetScreen_mod()).compareTo(Boolean.valueOf(bBUserExtInfo.isSetScreen_mod()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetScreen_mod()) {
//            int a7 = C2121h.m5522a(this.screen_mod, bBUserExtInfo.screen_mod);
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
//        StringBuilder sb = new StringBuilder("BBUserExtInfo(");
//        sb.append("avatar:");
//        if (this.avatar == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.avatar);
//        }
//        sb.append(", ");
//        sb.append("longitude:");
//        sb.append(this.longitude);
//        sb.append(", ");
//        sb.append("latitude:");
//        sb.append(this.latitude);
//        sb.append(", ");
//        sb.append("province:");
//        if (this.province == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.province);
//        }
//        sb.append(", ");
//        sb.append("city:");
//        if (this.city == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.city);
//        }
//        sb.append(", ");
//        sb.append("district:");
//        if (this.district == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.district);
//        }
//        if (isSetScreen_mod()) {
//            sb.append(", ");
//            sb.append("screen_mod:");
//            sb.append(this.screen_mod);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.avatar == null) {
//            throw new C2101g("Required field 'avatar' was not present! Struct: " + toString());
//        } else if (this.province == null) {
//            throw new C2101g("Required field 'province' was not present! Struct: " + toString());
//        } else if (this.city == null) {
//            throw new C2101g("Required field 'city' was not present! Struct: " + toString());
//        } else if (this.district == null) {
//            throw new C2101g("Required field 'district' was not present! Struct: " + toString());
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
