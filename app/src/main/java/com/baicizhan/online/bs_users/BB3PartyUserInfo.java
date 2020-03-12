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
//public class BB3PartyUserInfo implements Serializable, Cloneable, Comparable<BB3PartyUserInfo>, C2116f<BB3PartyUserInfo, BB3PartyUserInfo._Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b ASECRET_FIELD_DESC = new C2097b("asecret", JceStruct.STRUCT_END, (short) 4);
//    /* access modifiers changed from: private */
//    public static final C2097b ATOKEN_FIELD_DESC = new C2097b("atoken", JceStruct.STRUCT_END, (short) 3);
//    /* access modifiers changed from: private */
//    public static final C2097b EXPIRES_AT_FIELD_DESC = new C2097b("expires_at", JceStruct.STRUCT_END, (short) 5);
//    /* access modifiers changed from: private */
//    public static final C2097b GENDER_FIELD_DESC = new C2097b("gender", JceStruct.STRUCT_END, (short) 6);
//    /* access modifiers changed from: private */
//    public static final C2097b IMAGE_URL_FIELD_DESC = new C2097b("image_url", JceStruct.STRUCT_END, (short) 7);
//    /* access modifiers changed from: private */
//    public static final C2097b NICKNAME_FIELD_DESC = new C2097b("nickname", JceStruct.STRUCT_END, (short) 2);
//    /* access modifiers changed from: private */
//    public static final C2097b OPENID_FIELD_DESC = new C2097b("openid", JceStruct.STRUCT_END, (short) 8);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BB3PartyUserInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b UID_FIELD_DESC = new C2097b("uid", JceStruct.STRUCT_END, (short) 1);
//    /* access modifiers changed from: private */
//    public static final C2097b UNIONID_FIELD_DESC = new C2097b("unionid", JceStruct.STRUCT_END, (short) 9);
//    public static final Map<_Fields, C2091a> metaDataMap = null;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes = null;
//    public String asecret;
//    public String atoken;
//    public String expires_at;
//    public String gender;
//    public String image_url;
//    public String nickname;
//    public String openid;
//    private _Fields[] optionals;
//    public String uid;
//    public String unionid;
//
//    class BB3PartyUserInfoStandardScheme extends C2110c<BB3PartyUserInfo> {
//        private BB3PartyUserInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BB3PartyUserInfo bB3PartyUserInfo) {
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
//                                bB3PartyUserInfo.uid = fVar.mo18516q();
//                                bB3PartyUserInfo.setUidIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bB3PartyUserInfo.nickname = fVar.mo18516q();
//                                bB3PartyUserInfo.setNicknameIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bB3PartyUserInfo.atoken = fVar.mo18516q();
//                                bB3PartyUserInfo.setAtokenIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bB3PartyUserInfo.asecret = fVar.mo18516q();
//                                bB3PartyUserInfo.setAsecretIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bB3PartyUserInfo.expires_at = fVar.mo18516q();
//                                bB3PartyUserInfo.setExpires_atIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bB3PartyUserInfo.gender = fVar.mo18516q();
//                                bB3PartyUserInfo.setGenderIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bB3PartyUserInfo.image_url = fVar.mo18516q();
//                                bB3PartyUserInfo.setImage_urlIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bB3PartyUserInfo.openid = fVar.mo18516q();
//                                bB3PartyUserInfo.setOpenidIsSet(true);
//                                break;
//                            }
//                        case 9:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bB3PartyUserInfo.unionid = fVar.mo18516q();
//                                bB3PartyUserInfo.setUnionidIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bB3PartyUserInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BB3PartyUserInfo bB3PartyUserInfo) {
//            bB3PartyUserInfo.validate();
////            BB3PartyUserInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bB3PartyUserInfo.uid != null) {
//                fVar.mo18496a(BB3PartyUserInfo.UID_FIELD_DESC);
//                fVar.mo18495a(bB3PartyUserInfo.uid);
//            }
//            if (bB3PartyUserInfo.nickname != null) {
//                fVar.mo18496a(BB3PartyUserInfo.NICKNAME_FIELD_DESC);
//                fVar.mo18495a(bB3PartyUserInfo.nickname);
//            }
//            if (bB3PartyUserInfo.atoken != null && bB3PartyUserInfo.isSetAtoken()) {
//                fVar.mo18496a(BB3PartyUserInfo.ATOKEN_FIELD_DESC);
//                fVar.mo18495a(bB3PartyUserInfo.atoken);
//            }
//            if (bB3PartyUserInfo.asecret != null && bB3PartyUserInfo.isSetAsecret()) {
//                fVar.mo18496a(BB3PartyUserInfo.ASECRET_FIELD_DESC);
//                fVar.mo18495a(bB3PartyUserInfo.asecret);
//            }
//            if (bB3PartyUserInfo.expires_at != null && bB3PartyUserInfo.isSetExpires_at()) {
//                fVar.mo18496a(BB3PartyUserInfo.EXPIRES_AT_FIELD_DESC);
//                fVar.mo18495a(bB3PartyUserInfo.expires_at);
//            }
//            if (bB3PartyUserInfo.gender != null && bB3PartyUserInfo.isSetGender()) {
//                fVar.mo18496a(BB3PartyUserInfo.GENDER_FIELD_DESC);
//                fVar.mo18495a(bB3PartyUserInfo.gender);
//            }
//            if (bB3PartyUserInfo.image_url != null && bB3PartyUserInfo.isSetImage_url()) {
//                fVar.mo18496a(BB3PartyUserInfo.IMAGE_URL_FIELD_DESC);
//                fVar.mo18495a(bB3PartyUserInfo.image_url);
//            }
//            if (bB3PartyUserInfo.openid != null && bB3PartyUserInfo.isSetOpenid()) {
//                fVar.mo18496a(BB3PartyUserInfo.OPENID_FIELD_DESC);
//                fVar.mo18495a(bB3PartyUserInfo.openid);
//            }
//            if (bB3PartyUserInfo.unionid != null && bB3PartyUserInfo.isSetUnionid()) {
//                fVar.mo18496a(BB3PartyUserInfo.UNIONID_FIELD_DESC);
//                fVar.mo18495a(bB3PartyUserInfo.unionid);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BB3PartyUserInfoStandardSchemeFactory implements C2109b {
//        private BB3PartyUserInfoStandardSchemeFactory() {
//        }
//
//        public BB3PartyUserInfoStandardScheme getScheme() {
//            return new BB3PartyUserInfoStandardScheme();
//        }
//    }
//
//    class BB3PartyUserInfoTupleScheme extends C2111d<BB3PartyUserInfo> {
//        private BB3PartyUserInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BB3PartyUserInfo bB3PartyUserInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bB3PartyUserInfo.uid);
//            lVar.mo18495a(bB3PartyUserInfo.nickname);
//            BitSet bitSet = new BitSet();
//            if (bB3PartyUserInfo.isSetAtoken()) {
//                bitSet.set(0);
//            }
//            if (bB3PartyUserInfo.isSetAsecret()) {
//                bitSet.set(1);
//            }
//            if (bB3PartyUserInfo.isSetExpires_at()) {
//                bitSet.set(2);
//            }
//            if (bB3PartyUserInfo.isSetGender()) {
//                bitSet.set(3);
//            }
//            if (bB3PartyUserInfo.isSetImage_url()) {
//                bitSet.set(4);
//            }
//            if (bB3PartyUserInfo.isSetOpenid()) {
//                bitSet.set(5);
//            }
//            if (bB3PartyUserInfo.isSetUnionid()) {
//                bitSet.set(6);
//            }
//            lVar.mo18527a(bitSet, 7);
//            if (bB3PartyUserInfo.isSetAtoken()) {
//                lVar.mo18495a(bB3PartyUserInfo.atoken);
//            }
//            if (bB3PartyUserInfo.isSetAsecret()) {
//                lVar.mo18495a(bB3PartyUserInfo.asecret);
//            }
//            if (bB3PartyUserInfo.isSetExpires_at()) {
//                lVar.mo18495a(bB3PartyUserInfo.expires_at);
//            }
//            if (bB3PartyUserInfo.isSetGender()) {
//                lVar.mo18495a(bB3PartyUserInfo.gender);
//            }
//            if (bB3PartyUserInfo.isSetImage_url()) {
//                lVar.mo18495a(bB3PartyUserInfo.image_url);
//            }
//            if (bB3PartyUserInfo.isSetOpenid()) {
//                lVar.mo18495a(bB3PartyUserInfo.openid);
//            }
//            if (bB3PartyUserInfo.isSetUnionid()) {
//                lVar.mo18495a(bB3PartyUserInfo.unionid);
//            }
//        }
//
//        public void read(C2100f fVar, BB3PartyUserInfo bB3PartyUserInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bB3PartyUserInfo.uid = lVar.mo18516q();
//            bB3PartyUserInfo.setUidIsSet(true);
//            bB3PartyUserInfo.nickname = lVar.mo18516q();
//            bB3PartyUserInfo.setNicknameIsSet(true);
//            BitSet b = lVar.mo18528b(7);
//            if (b.get(0)) {
//                bB3PartyUserInfo.atoken = lVar.mo18516q();
//                bB3PartyUserInfo.setAtokenIsSet(true);
//            }
//            if (b.get(1)) {
//                bB3PartyUserInfo.asecret = lVar.mo18516q();
//                bB3PartyUserInfo.setAsecretIsSet(true);
//            }
//            if (b.get(2)) {
//                bB3PartyUserInfo.expires_at = lVar.mo18516q();
//                bB3PartyUserInfo.setExpires_atIsSet(true);
//            }
//            if (b.get(3)) {
//                bB3PartyUserInfo.gender = lVar.mo18516q();
//                bB3PartyUserInfo.setGenderIsSet(true);
//            }
//            if (b.get(4)) {
//                bB3PartyUserInfo.image_url = lVar.mo18516q();
//                bB3PartyUserInfo.setImage_urlIsSet(true);
//            }
//            if (b.get(5)) {
//                bB3PartyUserInfo.openid = lVar.mo18516q();
//                bB3PartyUserInfo.setOpenidIsSet(true);
//            }
//            if (b.get(6)) {
//                bB3PartyUserInfo.unionid = lVar.mo18516q();
//                bB3PartyUserInfo.setUnionidIsSet(true);
//            }
//        }
//    }
//
//    class BB3PartyUserInfoTupleSchemeFactory implements C2109b {
//        private BB3PartyUserInfoTupleSchemeFactory() {
//        }
//
//        public BB3PartyUserInfoTupleScheme getScheme() {
//            return new BB3PartyUserInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        UID((short)1, "uid"),
//        NICKNAME((short)2, "nickname"),
//        ATOKEN((short)3, "atoken"),
//        ASECRET((short)4, "asecret"),
//        EXPIRES_AT((short)5, "expires_at"),
//        GENDER((short)6, "gender"),
//        IMAGE_URL((short)7, "image_url"),
//        OPENID((short)8, "openid"),
//        UNIONID((short)9, "unionid");
//
//        private static final Map<String, _Fields> byName = null;
//        private final String _fieldName;
//        private final short _thriftId;
//
//        static {
//            HashMap byName = new HashMap();
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
//                    return UID;
//                case 2:
//                    return NICKNAME;
//                case 3:
//                    return ATOKEN;
//                case 4:
//                    return ASECRET;
//                case 5:
//                    return EXPIRES_AT;
//                case 6:
//                    return GENDER;
//                case 7:
//                    return IMAGE_URL;
//                case 8:
//                    return OPENID;
//                case 9:
//                    return UNIONID;
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
////        HashMap hashMap = new HashMap();
////        schemes = hashMap;
////        hashMap.put(C2110c.class, new BB3PartyUserInfoStandardSchemeFactory());
////        schemes.put(C2111d.class, new BB3PartyUserInfoTupleSchemeFactory());
////        EnumMap enumMap = new EnumMap(_Fields.class);
////        enumMap.put(_Fields.UID, new C2091a("uid", 1, new C2092b(JceStruct.STRUCT_END, 0)));
////        enumMap.put(_Fields.NICKNAME, new C2091a("nickname", 1, new C2092b(JceStruct.STRUCT_END, 0)));
////        enumMap.put(_Fields.ATOKEN, new C2091a("atoken", 2, new C2092b(JceStruct.STRUCT_END, 0)));
////        enumMap.put(_Fields.ASECRET, new C2091a("asecret", 2, new C2092b(JceStruct.STRUCT_END, 0)));
////        enumMap.put(_Fields.EXPIRES_AT, new C2091a("expires_at", 2, new C2092b(JceStruct.STRUCT_END, 0)));
////        enumMap.put(_Fields.GENDER, new C2091a("gender", 2, new C2092b(JceStruct.STRUCT_END, 0)));
////        enumMap.put(_Fields.IMAGE_URL, new C2091a("image_url", 2, new C2092b(JceStruct.STRUCT_END, 0)));
////        enumMap.put(_Fields.OPENID, new C2091a("openid", 2, new C2092b(JceStruct.STRUCT_END, 0)));
////        enumMap.put(_Fields.UNIONID, new C2091a("unionid", 2, new C2092b(JceStruct.STRUCT_END, 0)));
////        metaDataMap = Collections.unmodifiableMap(enumMap);
////        C2091a.m5430a(BB3PartyUserInfo.class, metaDataMap);
//    }
//
//    public BB3PartyUserInfo() {
//        this.optionals = new _Fields[]{_Fields.ATOKEN, _Fields.ASECRET, _Fields.EXPIRES_AT, _Fields.GENDER, _Fields.IMAGE_URL, _Fields.OPENID, _Fields.UNIONID};
//    }
//
//    public BB3PartyUserInfo(String str, String str2) {
//        this();
//        this.uid = str;
//        this.nickname = str2;
//    }
//
//    public BB3PartyUserInfo(BB3PartyUserInfo bB3PartyUserInfo) {
//        this.optionals = new _Fields[]{_Fields.ATOKEN, _Fields.ASECRET, _Fields.EXPIRES_AT, _Fields.GENDER, _Fields.IMAGE_URL, _Fields.OPENID, _Fields.UNIONID};
//        if (bB3PartyUserInfo.isSetUid()) {
//            this.uid = bB3PartyUserInfo.uid;
//        }
//        if (bB3PartyUserInfo.isSetNickname()) {
//            this.nickname = bB3PartyUserInfo.nickname;
//        }
//        if (bB3PartyUserInfo.isSetAtoken()) {
//            this.atoken = bB3PartyUserInfo.atoken;
//        }
//        if (bB3PartyUserInfo.isSetAsecret()) {
//            this.asecret = bB3PartyUserInfo.asecret;
//        }
//        if (bB3PartyUserInfo.isSetExpires_at()) {
//            this.expires_at = bB3PartyUserInfo.expires_at;
//        }
//        if (bB3PartyUserInfo.isSetGender()) {
//            this.gender = bB3PartyUserInfo.gender;
//        }
//        if (bB3PartyUserInfo.isSetImage_url()) {
//            this.image_url = bB3PartyUserInfo.image_url;
//        }
//        if (bB3PartyUserInfo.isSetOpenid()) {
//            this.openid = bB3PartyUserInfo.openid;
//        }
//        if (bB3PartyUserInfo.isSetUnionid()) {
//            this.unionid = bB3PartyUserInfo.unionid;
//        }
//    }
//
//    public BB3PartyUserInfo deepCopy() {
//        return new BB3PartyUserInfo(this);
//    }
//
//    public void clear() {
//        this.uid = null;
//        this.nickname = null;
//        this.atoken = null;
//        this.asecret = null;
//        this.expires_at = null;
//        this.gender = null;
//        this.image_url = null;
//        this.openid = null;
//        this.unionid = null;
//    }
//
//    public String getUid() {
//        return this.uid;
//    }
//
//    public BB3PartyUserInfo setUid(String str) {
//        this.uid = str;
//        return this;
//    }
//
//    public void unsetUid() {
//        this.uid = null;
//    }
//
//    public boolean isSetUid() {
//        return this.uid != null;
//    }
//
//    public void setUidIsSet(boolean z) {
//        if (!z) {
//            this.uid = null;
//        }
//    }
//
//    public String getNickname() {
//        return this.nickname;
//    }
//
//    public BB3PartyUserInfo setNickname(String str) {
//        this.nickname = str;
//        return this;
//    }
//
//    public void unsetNickname() {
//        this.nickname = null;
//    }
//
//    public boolean isSetNickname() {
//        return this.nickname != null;
//    }
//
//    public void setNicknameIsSet(boolean z) {
//        if (!z) {
//            this.nickname = null;
//        }
//    }
//
//    public String getAtoken() {
//        return this.atoken;
//    }
//
//    public BB3PartyUserInfo setAtoken(String str) {
//        this.atoken = str;
//        return this;
//    }
//
//    public void unsetAtoken() {
//        this.atoken = null;
//    }
//
//    public boolean isSetAtoken() {
//        return this.atoken != null;
//    }
//
//    public void setAtokenIsSet(boolean z) {
//        if (!z) {
//            this.atoken = null;
//        }
//    }
//
//    public String getAsecret() {
//        return this.asecret;
//    }
//
//    public BB3PartyUserInfo setAsecret(String str) {
//        this.asecret = str;
//        return this;
//    }
//
//    public void unsetAsecret() {
//        this.asecret = null;
//    }
//
//    public boolean isSetAsecret() {
//        return this.asecret != null;
//    }
//
//    public void setAsecretIsSet(boolean z) {
//        if (!z) {
//            this.asecret = null;
//        }
//    }
//
//    public String getExpires_at() {
//        return this.expires_at;
//    }
//
//    public BB3PartyUserInfo setExpires_at(String str) {
//        this.expires_at = str;
//        return this;
//    }
//
//    public void unsetExpires_at() {
//        this.expires_at = null;
//    }
//
//    public boolean isSetExpires_at() {
//        return this.expires_at != null;
//    }
//
//    public void setExpires_atIsSet(boolean z) {
//        if (!z) {
//            this.expires_at = null;
//        }
//    }
//
//    public String getGender() {
//        return this.gender;
//    }
//
//    public BB3PartyUserInfo setGender(String str) {
//        this.gender = str;
//        return this;
//    }
//
//    public void unsetGender() {
//        this.gender = null;
//    }
//
//    public boolean isSetGender() {
//        return this.gender != null;
//    }
//
//    public void setGenderIsSet(boolean z) {
//        if (!z) {
//            this.gender = null;
//        }
//    }
//
//    public String getImage_url() {
//        return this.image_url;
//    }
//
//    public BB3PartyUserInfo setImage_url(String str) {
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
//    public String getOpenid() {
//        return this.openid;
//    }
//
//    public BB3PartyUserInfo setOpenid(String str) {
//        this.openid = str;
//        return this;
//    }
//
//    public void unsetOpenid() {
//        this.openid = null;
//    }
//
//    public boolean isSetOpenid() {
//        return this.openid != null;
//    }
//
//    public void setOpenidIsSet(boolean z) {
//        if (!z) {
//            this.openid = null;
//        }
//    }
//
//    public String getUnionid() {
//        return this.unionid;
//    }
//
//    public BB3PartyUserInfo setUnionid(String str) {
//        this.unionid = str;
//        return this;
//    }
//
//    public void unsetUnionid() {
//        this.unionid = null;
//    }
//
//    public boolean isSetUnionid() {
//        return this.unionid != null;
//    }
//
//    public void setUnionidIsSet(boolean z) {
//        if (!z) {
//            this.unionid = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case UID:
//                if (obj == null) {
//                    unsetUid();
//                    return;
//                } else {
//                    setUid((String) obj);
//                    return;
//                }
//            case NICKNAME:
//                if (obj == null) {
//                    unsetNickname();
//                    return;
//                } else {
//                    setNickname((String) obj);
//                    return;
//                }
//            case ATOKEN:
//                if (obj == null) {
//                    unsetAtoken();
//                    return;
//                } else {
//                    setAtoken((String) obj);
//                    return;
//                }
//            case ASECRET:
//                if (obj == null) {
//                    unsetAsecret();
//                    return;
//                } else {
//                    setAsecret((String) obj);
//                    return;
//                }
//            case EXPIRES_AT:
//                if (obj == null) {
//                    unsetExpires_at();
//                    return;
//                } else {
//                    setExpires_at((String) obj);
//                    return;
//                }
//            case GENDER:
//                if (obj == null) {
//                    unsetGender();
//                    return;
//                } else {
//                    setGender((String) obj);
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
//            case OPENID:
//                if (obj == null) {
//                    unsetOpenid();
//                    return;
//                } else {
//                    setOpenid((String) obj);
//                    return;
//                }
//            case UNIONID:
//                if (obj == null) {
//                    unsetUnionid();
//                    return;
//                } else {
//                    setUnionid((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case UID:
//                return getUid();
//            case NICKNAME:
//                return getNickname();
//            case ATOKEN:
//                return getAtoken();
//            case ASECRET:
//                return getAsecret();
//            case EXPIRES_AT:
//                return getExpires_at();
//            case GENDER:
//                return getGender();
//            case IMAGE_URL:
//                return getImage_url();
//            case OPENID:
//                return getOpenid();
//            case UNIONID:
//                return getUnionid();
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
//            case UID:
//                return isSetUid();
//            case NICKNAME:
//                return isSetNickname();
//            case ATOKEN:
//                return isSetAtoken();
//            case ASECRET:
//                return isSetAsecret();
//            case EXPIRES_AT:
//                return isSetExpires_at();
//            case GENDER:
//                return isSetGender();
//            case IMAGE_URL:
//                return isSetImage_url();
//            case OPENID:
//                return isSetOpenid();
//            case UNIONID:
//                return isSetUnionid();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BB3PartyUserInfo)) {
//            return equals((BB3PartyUserInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BB3PartyUserInfo bB3PartyUserInfo) {
//        if (bB3PartyUserInfo == null) {
//            return false;
//        }
//        boolean isSetUid = isSetUid();
//        boolean isSetUid2 = bB3PartyUserInfo.isSetUid();
//        if ((isSetUid || isSetUid2) && (!isSetUid || !isSetUid2 || !this.uid.equals(bB3PartyUserInfo.uid))) {
//            return false;
//        }
//        boolean isSetNickname = isSetNickname();
//        boolean isSetNickname2 = bB3PartyUserInfo.isSetNickname();
//        if ((isSetNickname || isSetNickname2) && (!isSetNickname || !isSetNickname2 || !this.nickname.equals(bB3PartyUserInfo.nickname))) {
//            return false;
//        }
//        boolean isSetAtoken = isSetAtoken();
//        boolean isSetAtoken2 = bB3PartyUserInfo.isSetAtoken();
//        if ((isSetAtoken || isSetAtoken2) && (!isSetAtoken || !isSetAtoken2 || !this.atoken.equals(bB3PartyUserInfo.atoken))) {
//            return false;
//        }
//        boolean isSetAsecret = isSetAsecret();
//        boolean isSetAsecret2 = bB3PartyUserInfo.isSetAsecret();
//        if ((isSetAsecret || isSetAsecret2) && (!isSetAsecret || !isSetAsecret2 || !this.asecret.equals(bB3PartyUserInfo.asecret))) {
//            return false;
//        }
//        boolean isSetExpires_at = isSetExpires_at();
//        boolean isSetExpires_at2 = bB3PartyUserInfo.isSetExpires_at();
//        if ((isSetExpires_at || isSetExpires_at2) && (!isSetExpires_at || !isSetExpires_at2 || !this.expires_at.equals(bB3PartyUserInfo.expires_at))) {
//            return false;
//        }
//        boolean isSetGender = isSetGender();
//        boolean isSetGender2 = bB3PartyUserInfo.isSetGender();
//        if ((isSetGender || isSetGender2) && (!isSetGender || !isSetGender2 || !this.gender.equals(bB3PartyUserInfo.gender))) {
//            return false;
//        }
//        boolean isSetImage_url = isSetImage_url();
//        boolean isSetImage_url2 = bB3PartyUserInfo.isSetImage_url();
//        if ((isSetImage_url || isSetImage_url2) && (!isSetImage_url || !isSetImage_url2 || !this.image_url.equals(bB3PartyUserInfo.image_url))) {
//            return false;
//        }
//        boolean isSetOpenid = isSetOpenid();
//        boolean isSetOpenid2 = bB3PartyUserInfo.isSetOpenid();
//        if ((isSetOpenid || isSetOpenid2) && (!isSetOpenid || !isSetOpenid2 || !this.openid.equals(bB3PartyUserInfo.openid))) {
//            return false;
//        }
//        boolean isSetUnionid = isSetUnionid();
//        boolean isSetUnionid2 = bB3PartyUserInfo.isSetUnionid();
//        if ((isSetUnionid || isSetUnionid2) && (!isSetUnionid || !isSetUnionid2 || !this.unionid.equals(bB3PartyUserInfo.unionid))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BB3PartyUserInfo bB3PartyUserInfo) {
//        if (!getClass().equals(bB3PartyUserInfo.getClass())) {
//            return getClass().getName().compareTo(bB3PartyUserInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetUid()).compareTo(Boolean.valueOf(bB3PartyUserInfo.isSetUid()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetUid()) {
//            int a = C2121h.m5525a(this.uid, bB3PartyUserInfo.uid);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetNickname()).compareTo(Boolean.valueOf(bB3PartyUserInfo.isSetNickname()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetNickname()) {
//            int a2 = C2121h.m5525a(this.nickname, bB3PartyUserInfo.nickname);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetAtoken()).compareTo(Boolean.valueOf(bB3PartyUserInfo.isSetAtoken()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetAtoken()) {
//            int a3 = C2121h.m5525a(this.atoken, bB3PartyUserInfo.atoken);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetAsecret()).compareTo(Boolean.valueOf(bB3PartyUserInfo.isSetAsecret()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetAsecret()) {
//            int a4 = C2121h.m5525a(this.asecret, bB3PartyUserInfo.asecret);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetExpires_at()).compareTo(Boolean.valueOf(bB3PartyUserInfo.isSetExpires_at()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetExpires_at()) {
//            int a5 = C2121h.m5525a(this.expires_at, bB3PartyUserInfo.expires_at);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetGender()).compareTo(Boolean.valueOf(bB3PartyUserInfo.isSetGender()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetGender()) {
//            int a6 = C2121h.m5525a(this.gender, bB3PartyUserInfo.gender);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetImage_url()).compareTo(Boolean.valueOf(bB3PartyUserInfo.isSetImage_url()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetImage_url()) {
//            int a7 = C2121h.m5525a(this.image_url, bB3PartyUserInfo.image_url);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetOpenid()).compareTo(Boolean.valueOf(bB3PartyUserInfo.isSetOpenid()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetOpenid()) {
//            int a8 = C2121h.m5525a(this.openid, bB3PartyUserInfo.openid);
//            if (a8 != 0) {
//                return a8;
//            }
//        }
//        int compareTo9 = Boolean.valueOf(isSetUnionid()).compareTo(Boolean.valueOf(bB3PartyUserInfo.isSetUnionid()));
//        if (compareTo9 != 0) {
//            return compareTo9;
//        }
//        if (isSetUnionid()) {
//            int a9 = C2121h.m5525a(this.unionid, bB3PartyUserInfo.unionid);
//            if (a9 != 0) {
//                return a9;
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
//        StringBuilder sb = new StringBuilder("BB3PartyUserInfo(");
//        sb.append("uid:");
//        if (this.uid == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.uid);
//        }
//        sb.append(", ");
//        sb.append("nickname:");
//        if (this.nickname == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.nickname);
//        }
//        if (isSetAtoken()) {
//            sb.append(", ");
//            sb.append("atoken:");
//            if (this.atoken == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.atoken);
//            }
//        }
//        if (isSetAsecret()) {
//            sb.append(", ");
//            sb.append("asecret:");
//            if (this.asecret == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.asecret);
//            }
//        }
//        if (isSetExpires_at()) {
//            sb.append(", ");
//            sb.append("expires_at:");
//            if (this.expires_at == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.expires_at);
//            }
//        }
//        if (isSetGender()) {
//            sb.append(", ");
//            sb.append("gender:");
//            if (this.gender == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.gender);
//            }
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
//        if (isSetOpenid()) {
//            sb.append(", ");
//            sb.append("openid:");
//            if (this.openid == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.openid);
//            }
//        }
//        if (isSetUnionid()) {
//            sb.append(", ");
//            sb.append("unionid:");
//            if (this.unionid == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.unionid);
//            }
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.uid == null) {
//            try {
//                throw new C2101g("Required field 'uid' was not present! Struct: " + toString());
//            } catch (C2101g c2101g) {
//                c2101g.printStackTrace();
//            }
//        } else if (this.nickname == null) {
//            try {
//                throw new C2101g("Required field 'nickname' was not present! Struct: " + toString());
//            } catch (C2101g c2101g) {
//                c2101g.printStackTrace();
//            }
//        }
//    }
//
//    private void writeObject(ObjectOutputStream objectOutputStream) {
//        try {
//            write(new C2096a(new C2117b((OutputStream) objectOutputStream), (byte) 0));
//        } catch (Exception e) {
////            throw new IOException(e);
//        }
//    }
//
//    private void readObject(ObjectInputStream objectInputStream) {
//        try {
//            read(new C2096a(new C2117b((InputStream) objectInputStream), (byte) 0));
//        } catch (Exception e) {
////            throw new IOException(e);
//        }
//    }
//}
