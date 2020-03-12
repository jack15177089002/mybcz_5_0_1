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
//public class BBUserBasicInfo implements Serializable, Cloneable, Comparable<BBUserBasicInfo>, C2116f<BBUserBasicInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b CURRENT_WORD_LEVEL_ID_FIELD_DESC = new C2097b("current_word_level_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b CURRENT_WORD_LEVEL_NAME_FIELD_DESC = new C2097b("current_word_level_name", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b GENDER_ID_FIELD_DESC = new C2097b("gender_id", 8, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_TRY_USER_FIELD_DESC = new C2097b("is_try_user", 8, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b NICKNAME_FIELD_DESC = new C2097b("nickname", JceStruct.STRUCT_END, 6);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserBasicInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_LEVEL_ALIAS_FIELD_DESC = new C2097b("word_level_alias", JceStruct.STRUCT_END, 3);
//    private static final int __CURRENT_WORD_LEVEL_ID_ISSET_ID = 0;
//    private static final int __GENDER_ID_ISSET_ID = 2;
//    private static final int __IS_TRY_USER_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int current_word_level_id;
//    public String current_word_level_name;
//    public int gender_id;
//    public int is_try_user;
//    public String nickname;
//    public String word_level_alias;
//
//    class BBUserBasicInfoStandardScheme extends C2110c<BBUserBasicInfo> {
//        private BBUserBasicInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserBasicInfo bBUserBasicInfo) {
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
//                                bBUserBasicInfo.current_word_level_id = fVar.mo18513n();
//                                bBUserBasicInfo.setCurrent_word_level_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserBasicInfo.current_word_level_name = fVar.mo18516q();
//                                bBUserBasicInfo.setCurrent_word_level_nameIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserBasicInfo.word_level_alias = fVar.mo18516q();
//                                bBUserBasicInfo.setWord_level_aliasIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserBasicInfo.is_try_user = fVar.mo18513n();
//                                bBUserBasicInfo.setIs_try_userIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserBasicInfo.gender_id = fVar.mo18513n();
//                                bBUserBasicInfo.setGender_idIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserBasicInfo.nickname = fVar.mo18516q();
//                                bBUserBasicInfo.setNicknameIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBUserBasicInfo.isSetCurrent_word_level_id()) {
//                        throw new C2101g("Required field 'current_word_level_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserBasicInfo.isSetIs_try_user()) {
//                        throw new C2101g("Required field 'is_try_user' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBUserBasicInfo.isSetGender_id()) {
//                        throw new C2101g("Required field 'gender_id' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBUserBasicInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserBasicInfo bBUserBasicInfo) {
//            bBUserBasicInfo.validate();
//            BBUserBasicInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBUserBasicInfo.CURRENT_WORD_LEVEL_ID_FIELD_DESC);
//            fVar.mo18493a(bBUserBasicInfo.current_word_level_id);
//            if (bBUserBasicInfo.current_word_level_name != null) {
//                fVar.mo18496a(BBUserBasicInfo.CURRENT_WORD_LEVEL_NAME_FIELD_DESC);
//                fVar.mo18495a(bBUserBasicInfo.current_word_level_name);
//            }
//            if (bBUserBasicInfo.word_level_alias != null) {
//                fVar.mo18496a(BBUserBasicInfo.WORD_LEVEL_ALIAS_FIELD_DESC);
//                fVar.mo18495a(bBUserBasicInfo.word_level_alias);
//            }
//            fVar.mo18496a(BBUserBasicInfo.IS_TRY_USER_FIELD_DESC);
//            fVar.mo18493a(bBUserBasicInfo.is_try_user);
//            fVar.mo18496a(BBUserBasicInfo.GENDER_ID_FIELD_DESC);
//            fVar.mo18493a(bBUserBasicInfo.gender_id);
//            if (bBUserBasicInfo.nickname != null) {
//                fVar.mo18496a(BBUserBasicInfo.NICKNAME_FIELD_DESC);
//                fVar.mo18495a(bBUserBasicInfo.nickname);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserBasicInfoStandardSchemeFactory implements C2109b {
//        private BBUserBasicInfoStandardSchemeFactory() {
//        }
//
//        public BBUserBasicInfoStandardScheme getScheme() {
//            return new BBUserBasicInfoStandardScheme();
//        }
//    }
//
//    class BBUserBasicInfoTupleScheme extends C2111d<BBUserBasicInfo> {
//        private BBUserBasicInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserBasicInfo bBUserBasicInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBUserBasicInfo.current_word_level_id);
//            lVar.mo18495a(bBUserBasicInfo.current_word_level_name);
//            lVar.mo18495a(bBUserBasicInfo.word_level_alias);
//            lVar.mo18493a(bBUserBasicInfo.is_try_user);
//            lVar.mo18493a(bBUserBasicInfo.gender_id);
//            lVar.mo18495a(bBUserBasicInfo.nickname);
//        }
//
//        public void read(C2100f fVar, BBUserBasicInfo bBUserBasicInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserBasicInfo.current_word_level_id = lVar.mo18513n();
//            bBUserBasicInfo.setCurrent_word_level_idIsSet(true);
//            bBUserBasicInfo.current_word_level_name = lVar.mo18516q();
//            bBUserBasicInfo.setCurrent_word_level_nameIsSet(true);
//            bBUserBasicInfo.word_level_alias = lVar.mo18516q();
//            bBUserBasicInfo.setWord_level_aliasIsSet(true);
//            bBUserBasicInfo.is_try_user = lVar.mo18513n();
//            bBUserBasicInfo.setIs_try_userIsSet(true);
//            bBUserBasicInfo.gender_id = lVar.mo18513n();
//            bBUserBasicInfo.setGender_idIsSet(true);
//            bBUserBasicInfo.nickname = lVar.mo18516q();
//            bBUserBasicInfo.setNicknameIsSet(true);
//        }
//    }
//
//    class BBUserBasicInfoTupleSchemeFactory implements C2109b {
//        private BBUserBasicInfoTupleSchemeFactory() {
//        }
//
//        public BBUserBasicInfoTupleScheme getScheme() {
//            return new BBUserBasicInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        CURRENT_WORD_LEVEL_ID(1, "current_word_level_id"),
//        CURRENT_WORD_LEVEL_NAME(2, "current_word_level_name"),
//        WORD_LEVEL_ALIAS(3, "word_level_alias"),
//        IS_TRY_USER(4, "is_try_user"),
//        GENDER_ID(5, "gender_id"),
//        NICKNAME(6, "nickname");
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
//                    return CURRENT_WORD_LEVEL_ID;
//                case 2:
//                    return CURRENT_WORD_LEVEL_NAME;
//                case 3:
//                    return WORD_LEVEL_ALIAS;
//                case 4:
//                    return IS_TRY_USER;
//                case 5:
//                    return GENDER_ID;
//                case 6:
//                    return NICKNAME;
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
//        hashMap.put(C2110c.class, new BBUserBasicInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserBasicInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.CURRENT_WORD_LEVEL_ID, new C2091a("current_word_level_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.CURRENT_WORD_LEVEL_NAME, new C2091a("current_word_level_name", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WORD_LEVEL_ALIAS, new C2091a("word_level_alias", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.IS_TRY_USER, new C2091a("is_try_user", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.GENDER_ID, new C2091a("gender_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.NICKNAME, new C2091a("nickname", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserBasicInfo.class, metaDataMap);
//    }
//
//    public BBUserBasicInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBUserBasicInfo(int i, String str, String str2, int i2, int i3, String str3) {
//        this();
//        this.current_word_level_id = i;
//        setCurrent_word_level_idIsSet(true);
//        this.current_word_level_name = str;
//        this.word_level_alias = str2;
//        this.is_try_user = i2;
//        setIs_try_userIsSet(true);
//        this.gender_id = i3;
//        setGender_idIsSet(true);
//        this.nickname = str3;
//    }
//
//    public BBUserBasicInfo(BBUserBasicInfo bBUserBasicInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBUserBasicInfo.__isset_bitfield;
//        this.current_word_level_id = bBUserBasicInfo.current_word_level_id;
//        if (bBUserBasicInfo.isSetCurrent_word_level_name()) {
//            this.current_word_level_name = bBUserBasicInfo.current_word_level_name;
//        }
//        if (bBUserBasicInfo.isSetWord_level_alias()) {
//            this.word_level_alias = bBUserBasicInfo.word_level_alias;
//        }
//        this.is_try_user = bBUserBasicInfo.is_try_user;
//        this.gender_id = bBUserBasicInfo.gender_id;
//        if (bBUserBasicInfo.isSetNickname()) {
//            this.nickname = bBUserBasicInfo.nickname;
//        }
//    }
//
//    public BBUserBasicInfo deepCopy() {
//        return new BBUserBasicInfo(this);
//    }
//
//    public void clear() {
//        setCurrent_word_level_idIsSet(false);
//        this.current_word_level_id = 0;
//        this.current_word_level_name = null;
//        this.word_level_alias = null;
//        setIs_try_userIsSet(false);
//        this.is_try_user = 0;
//        setGender_idIsSet(false);
//        this.gender_id = 0;
//        this.nickname = null;
//    }
//
//    public int getCurrent_word_level_id() {
//        return this.current_word_level_id;
//    }
//
//    public BBUserBasicInfo setCurrent_word_level_id(int i) {
//        this.current_word_level_id = i;
//        setCurrent_word_level_idIsSet(true);
//        return this;
//    }
//
//    public void unsetCurrent_word_level_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetCurrent_word_level_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setCurrent_word_level_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getCurrent_word_level_name() {
//        return this.current_word_level_name;
//    }
//
//    public BBUserBasicInfo setCurrent_word_level_name(String str) {
//        this.current_word_level_name = str;
//        return this;
//    }
//
//    public void unsetCurrent_word_level_name() {
//        this.current_word_level_name = null;
//    }
//
//    public boolean isSetCurrent_word_level_name() {
//        return this.current_word_level_name != null;
//    }
//
//    public void setCurrent_word_level_nameIsSet(boolean z) {
//        if (!z) {
//            this.current_word_level_name = null;
//        }
//    }
//
//    public String getWord_level_alias() {
//        return this.word_level_alias;
//    }
//
//    public BBUserBasicInfo setWord_level_alias(String str) {
//        this.word_level_alias = str;
//        return this;
//    }
//
//    public void unsetWord_level_alias() {
//        this.word_level_alias = null;
//    }
//
//    public boolean isSetWord_level_alias() {
//        return this.word_level_alias != null;
//    }
//
//    public void setWord_level_aliasIsSet(boolean z) {
//        if (!z) {
//            this.word_level_alias = null;
//        }
//    }
//
//    public int getIs_try_user() {
//        return this.is_try_user;
//    }
//
//    public BBUserBasicInfo setIs_try_user(int i) {
//        this.is_try_user = i;
//        setIs_try_userIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_try_user() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetIs_try_user() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setIs_try_userIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getGender_id() {
//        return this.gender_id;
//    }
//
//    public BBUserBasicInfo setGender_id(int i) {
//        this.gender_id = i;
//        setGender_idIsSet(true);
//        return this;
//    }
//
//    public void unsetGender_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetGender_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setGender_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public String getNickname() {
//        return this.nickname;
//    }
//
//    public BBUserBasicInfo setNickname(String str) {
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
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case CURRENT_WORD_LEVEL_ID:
//                if (obj == null) {
//                    unsetCurrent_word_level_id();
//                    return;
//                } else {
//                    setCurrent_word_level_id(((Integer) obj).intValue());
//                    return;
//                }
//            case CURRENT_WORD_LEVEL_NAME:
//                if (obj == null) {
//                    unsetCurrent_word_level_name();
//                    return;
//                } else {
//                    setCurrent_word_level_name((String) obj);
//                    return;
//                }
//            case WORD_LEVEL_ALIAS:
//                if (obj == null) {
//                    unsetWord_level_alias();
//                    return;
//                } else {
//                    setWord_level_alias((String) obj);
//                    return;
//                }
//            case IS_TRY_USER:
//                if (obj == null) {
//                    unsetIs_try_user();
//                    return;
//                } else {
//                    setIs_try_user(((Integer) obj).intValue());
//                    return;
//                }
//            case GENDER_ID:
//                if (obj == null) {
//                    unsetGender_id();
//                    return;
//                } else {
//                    setGender_id(((Integer) obj).intValue());
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
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case CURRENT_WORD_LEVEL_ID:
//                return Integer.valueOf(getCurrent_word_level_id());
//            case CURRENT_WORD_LEVEL_NAME:
//                return getCurrent_word_level_name();
//            case WORD_LEVEL_ALIAS:
//                return getWord_level_alias();
//            case IS_TRY_USER:
//                return Integer.valueOf(getIs_try_user());
//            case GENDER_ID:
//                return Integer.valueOf(getGender_id());
//            case NICKNAME:
//                return getNickname();
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
//            case CURRENT_WORD_LEVEL_ID:
//                return isSetCurrent_word_level_id();
//            case CURRENT_WORD_LEVEL_NAME:
//                return isSetCurrent_word_level_name();
//            case WORD_LEVEL_ALIAS:
//                return isSetWord_level_alias();
//            case IS_TRY_USER:
//                return isSetIs_try_user();
//            case GENDER_ID:
//                return isSetGender_id();
//            case NICKNAME:
//                return isSetNickname();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBUserBasicInfo)) {
//            return equals((BBUserBasicInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserBasicInfo bBUserBasicInfo) {
//        if (bBUserBasicInfo == null || this.current_word_level_id != bBUserBasicInfo.current_word_level_id) {
//            return false;
//        }
//        boolean isSetCurrent_word_level_name = isSetCurrent_word_level_name();
//        boolean isSetCurrent_word_level_name2 = bBUserBasicInfo.isSetCurrent_word_level_name();
//        if ((isSetCurrent_word_level_name || isSetCurrent_word_level_name2) && (!isSetCurrent_word_level_name || !isSetCurrent_word_level_name2 || !this.current_word_level_name.equals(bBUserBasicInfo.current_word_level_name))) {
//            return false;
//        }
//        boolean isSetWord_level_alias = isSetWord_level_alias();
//        boolean isSetWord_level_alias2 = bBUserBasicInfo.isSetWord_level_alias();
//        if (((isSetWord_level_alias || isSetWord_level_alias2) && (!isSetWord_level_alias || !isSetWord_level_alias2 || !this.word_level_alias.equals(bBUserBasicInfo.word_level_alias))) || this.is_try_user != bBUserBasicInfo.is_try_user || this.gender_id != bBUserBasicInfo.gender_id) {
//            return false;
//        }
//        boolean isSetNickname = isSetNickname();
//        boolean isSetNickname2 = bBUserBasicInfo.isSetNickname();
//        if ((isSetNickname || isSetNickname2) && (!isSetNickname || !isSetNickname2 || !this.nickname.equals(bBUserBasicInfo.nickname))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserBasicInfo bBUserBasicInfo) {
//        if (!getClass().equals(bBUserBasicInfo.getClass())) {
//            return getClass().getName().compareTo(bBUserBasicInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetCurrent_word_level_id()).compareTo(Boolean.valueOf(bBUserBasicInfo.isSetCurrent_word_level_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetCurrent_word_level_id()) {
//            int a = C2121h.m5522a(this.current_word_level_id, bBUserBasicInfo.current_word_level_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetCurrent_word_level_name()).compareTo(Boolean.valueOf(bBUserBasicInfo.isSetCurrent_word_level_name()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetCurrent_word_level_name()) {
//            int a2 = C2121h.m5525a(this.current_word_level_name, bBUserBasicInfo.current_word_level_name);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetWord_level_alias()).compareTo(Boolean.valueOf(bBUserBasicInfo.isSetWord_level_alias()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetWord_level_alias()) {
//            int a3 = C2121h.m5525a(this.word_level_alias, bBUserBasicInfo.word_level_alias);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetIs_try_user()).compareTo(Boolean.valueOf(bBUserBasicInfo.isSetIs_try_user()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetIs_try_user()) {
//            int a4 = C2121h.m5522a(this.is_try_user, bBUserBasicInfo.is_try_user);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetGender_id()).compareTo(Boolean.valueOf(bBUserBasicInfo.isSetGender_id()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetGender_id()) {
//            int a5 = C2121h.m5522a(this.gender_id, bBUserBasicInfo.gender_id);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetNickname()).compareTo(Boolean.valueOf(bBUserBasicInfo.isSetNickname()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetNickname()) {
//            int a6 = C2121h.m5525a(this.nickname, bBUserBasicInfo.nickname);
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
//        StringBuilder sb = new StringBuilder("BBUserBasicInfo(");
//        sb.append("current_word_level_id:");
//        sb.append(this.current_word_level_id);
//        sb.append(", ");
//        sb.append("current_word_level_name:");
//        if (this.current_word_level_name == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.current_word_level_name);
//        }
//        sb.append(", ");
//        sb.append("word_level_alias:");
//        if (this.word_level_alias == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word_level_alias);
//        }
//        sb.append(", ");
//        sb.append("is_try_user:");
//        sb.append(this.is_try_user);
//        sb.append(", ");
//        sb.append("gender_id:");
//        sb.append(this.gender_id);
//        sb.append(", ");
//        sb.append("nickname:");
//        if (this.nickname == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.nickname);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.current_word_level_name == null) {
//            throw new C2101g("Required field 'current_word_level_name' was not present! Struct: " + toString());
//        } else if (this.word_level_alias == null) {
//            throw new C2101g("Required field 'word_level_alias' was not present! Struct: " + toString());
//        } else if (this.nickname == null) {
//            throw new C2101g("Required field 'nickname' was not present! Struct: " + toString());
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
