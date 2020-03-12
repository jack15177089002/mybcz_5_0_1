//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
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
//public class BBLoginResult implements Serializable, Cloneable, Comparable<BBLoginResult>, C2116f<BBLoginResult, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b ACCESS_TOKEN_FIELD_DESC = new C2097b(BaicizhanCookieInflator.ACCESS_TOKEN, JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b EMAIL_FIELD_DESC = new C2097b("email", JceStruct.STRUCT_END, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_NEW_USER_FIELD_DESC = new C2097b("is_new_user", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b PUBLIC_KEY_FIELD_DESC = new C2097b("public_key", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBLoginResult");
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATE_AT_OF_BOOK_INFO_FIELD_DESC = new C2097b("update_at_of_book_info", 10, 5);
//    private static final int __IS_NEW_USER_ISSET_ID = 0;
//    private static final int __UPDATE_AT_OF_BOOK_INFO_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String access_token;
//    public String email;
//    public int is_new_user;
//    private _Fields[] optionals;
//    public String public_key;
//    public long update_at_of_book_info;
//
//    class BBLoginResultStandardScheme extends C2110c<BBLoginResult> {
//        private BBLoginResultStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBLoginResult bBLoginResult) {
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
//                                bBLoginResult.access_token = fVar.mo18516q();
//                                bBLoginResult.setAccess_tokenIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLoginResult.is_new_user = fVar.mo18513n();
//                                bBLoginResult.setIs_new_userIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLoginResult.email = fVar.mo18516q();
//                                bBLoginResult.setEmailIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLoginResult.public_key = fVar.mo18516q();
//                                bBLoginResult.setPublic_keyIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBLoginResult.update_at_of_book_info = fVar.mo18514o();
//                                bBLoginResult.setUpdate_at_of_book_infoIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBLoginResult.isSetIs_new_user()) {
//                        throw new C2101g("Required field 'is_new_user' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBLoginResult.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBLoginResult bBLoginResult) {
//            bBLoginResult.validate();
//            BBLoginResult.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBLoginResult.access_token != null) {
//                fVar.mo18496a(BBLoginResult.ACCESS_TOKEN_FIELD_DESC);
//                fVar.mo18495a(bBLoginResult.access_token);
//            }
//            fVar.mo18496a(BBLoginResult.IS_NEW_USER_FIELD_DESC);
//            fVar.mo18493a(bBLoginResult.is_new_user);
//            if (bBLoginResult.email != null) {
//                fVar.mo18496a(BBLoginResult.EMAIL_FIELD_DESC);
//                fVar.mo18495a(bBLoginResult.email);
//            }
//            if (bBLoginResult.public_key != null) {
//                fVar.mo18496a(BBLoginResult.PUBLIC_KEY_FIELD_DESC);
//                fVar.mo18495a(bBLoginResult.public_key);
//            }
//            if (bBLoginResult.isSetUpdate_at_of_book_info()) {
//                fVar.mo18496a(BBLoginResult.UPDATE_AT_OF_BOOK_INFO_FIELD_DESC);
//                fVar.mo18494a(bBLoginResult.update_at_of_book_info);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBLoginResultStandardSchemeFactory implements C2109b {
//        private BBLoginResultStandardSchemeFactory() {
//        }
//
//        public BBLoginResultStandardScheme getScheme() {
//            return new BBLoginResultStandardScheme();
//        }
//    }
//
//    class BBLoginResultTupleScheme extends C2111d<BBLoginResult> {
//        private BBLoginResultTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBLoginResult bBLoginResult) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBLoginResult.access_token);
//            lVar.mo18493a(bBLoginResult.is_new_user);
//            lVar.mo18495a(bBLoginResult.email);
//            lVar.mo18495a(bBLoginResult.public_key);
//            BitSet bitSet = new BitSet();
//            if (bBLoginResult.isSetUpdate_at_of_book_info()) {
//                bitSet.set(0);
//            }
//            lVar.mo18527a(bitSet, 1);
//            if (bBLoginResult.isSetUpdate_at_of_book_info()) {
//                lVar.mo18494a(bBLoginResult.update_at_of_book_info);
//            }
//        }
//
//        public void read(C2100f fVar, BBLoginResult bBLoginResult) {
//            C2106l lVar = (C2106l) fVar;
//            bBLoginResult.access_token = lVar.mo18516q();
//            bBLoginResult.setAccess_tokenIsSet(true);
//            bBLoginResult.is_new_user = lVar.mo18513n();
//            bBLoginResult.setIs_new_userIsSet(true);
//            bBLoginResult.email = lVar.mo18516q();
//            bBLoginResult.setEmailIsSet(true);
//            bBLoginResult.public_key = lVar.mo18516q();
//            bBLoginResult.setPublic_keyIsSet(true);
//            if (lVar.mo18528b(1).get(0)) {
//                bBLoginResult.update_at_of_book_info = lVar.mo18514o();
//                bBLoginResult.setUpdate_at_of_book_infoIsSet(true);
//            }
//        }
//    }
//
//    class BBLoginResultTupleSchemeFactory implements C2109b {
//        private BBLoginResultTupleSchemeFactory() {
//        }
//
//        public BBLoginResultTupleScheme getScheme() {
//            return new BBLoginResultTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        ACCESS_TOKEN(1, BaicizhanCookieInflator.ACCESS_TOKEN),
//        IS_NEW_USER(2, "is_new_user"),
//        EMAIL(3, "email"),
//        PUBLIC_KEY(4, "public_key"),
//        UPDATE_AT_OF_BOOK_INFO(5, "update_at_of_book_info");
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
//                    return ACCESS_TOKEN;
//                case 2:
//                    return IS_NEW_USER;
//                case 3:
//                    return EMAIL;
//                case 4:
//                    return PUBLIC_KEY;
//                case 5:
//                    return UPDATE_AT_OF_BOOK_INFO;
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
//        hashMap.put(C2110c.class, new BBLoginResultStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBLoginResultTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.ACCESS_TOKEN, new C2091a(BaicizhanCookieInflator.ACCESS_TOKEN, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.IS_NEW_USER, new C2091a("is_new_user", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.EMAIL, new C2091a("email", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.PUBLIC_KEY, new C2091a("public_key", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.UPDATE_AT_OF_BOOK_INFO, new C2091a("update_at_of_book_info", 2, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBLoginResult.class, metaDataMap);
//    }
//
//    public BBLoginResult() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.UPDATE_AT_OF_BOOK_INFO};
//    }
//
//    public BBLoginResult(String str, int i, String str2, String str3) {
//        this();
//        this.access_token = str;
//        this.is_new_user = i;
//        setIs_new_userIsSet(true);
//        this.email = str2;
//        this.public_key = str3;
//    }
//
//    public BBLoginResult(BBLoginResult bBLoginResult) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.UPDATE_AT_OF_BOOK_INFO};
//        this.__isset_bitfield = bBLoginResult.__isset_bitfield;
//        if (bBLoginResult.isSetAccess_token()) {
//            this.access_token = bBLoginResult.access_token;
//        }
//        this.is_new_user = bBLoginResult.is_new_user;
//        if (bBLoginResult.isSetEmail()) {
//            this.email = bBLoginResult.email;
//        }
//        if (bBLoginResult.isSetPublic_key()) {
//            this.public_key = bBLoginResult.public_key;
//        }
//        this.update_at_of_book_info = bBLoginResult.update_at_of_book_info;
//    }
//
//    public BBLoginResult deepCopy() {
//        return new BBLoginResult(this);
//    }
//
//    public void clear() {
//        this.access_token = null;
//        setIs_new_userIsSet(false);
//        this.is_new_user = 0;
//        this.email = null;
//        this.public_key = null;
//        setUpdate_at_of_book_infoIsSet(false);
//        this.update_at_of_book_info = 0;
//    }
//
//    public String getAccess_token() {
//        return this.access_token;
//    }
//
//    public BBLoginResult setAccess_token(String str) {
//        this.access_token = str;
//        return this;
//    }
//
//    public void unsetAccess_token() {
//        this.access_token = null;
//    }
//
//    public boolean isSetAccess_token() {
//        return this.access_token != null;
//    }
//
//    public void setAccess_tokenIsSet(boolean z) {
//        if (!z) {
//            this.access_token = null;
//        }
//    }
//
//    public int getIs_new_user() {
//        return this.is_new_user;
//    }
//
//    public BBLoginResult setIs_new_user(int i) {
//        this.is_new_user = i;
//        setIs_new_userIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_new_user() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetIs_new_user() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setIs_new_userIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public BBLoginResult setEmail(String str) {
//        this.email = str;
//        return this;
//    }
//
//    public void unsetEmail() {
//        this.email = null;
//    }
//
//    public boolean isSetEmail() {
//        return this.email != null;
//    }
//
//    public void setEmailIsSet(boolean z) {
//        if (!z) {
//            this.email = null;
//        }
//    }
//
//    public String getPublic_key() {
//        return this.public_key;
//    }
//
//    public BBLoginResult setPublic_key(String str) {
//        this.public_key = str;
//        return this;
//    }
//
//    public void unsetPublic_key() {
//        this.public_key = null;
//    }
//
//    public boolean isSetPublic_key() {
//        return this.public_key != null;
//    }
//
//    public void setPublic_keyIsSet(boolean z) {
//        if (!z) {
//            this.public_key = null;
//        }
//    }
//
//    public long getUpdate_at_of_book_info() {
//        return this.update_at_of_book_info;
//    }
//
//    public BBLoginResult setUpdate_at_of_book_info(long j) {
//        this.update_at_of_book_info = j;
//        setUpdate_at_of_book_infoIsSet(true);
//        return this;
//    }
//
//    public void unsetUpdate_at_of_book_info() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetUpdate_at_of_book_info() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setUpdate_at_of_book_infoIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case ACCESS_TOKEN:
//                if (obj == null) {
//                    unsetAccess_token();
//                    return;
//                } else {
//                    setAccess_token((String) obj);
//                    return;
//                }
//            case IS_NEW_USER:
//                if (obj == null) {
//                    unsetIs_new_user();
//                    return;
//                } else {
//                    setIs_new_user(((Integer) obj).intValue());
//                    return;
//                }
//            case EMAIL:
//                if (obj == null) {
//                    unsetEmail();
//                    return;
//                } else {
//                    setEmail((String) obj);
//                    return;
//                }
//            case PUBLIC_KEY:
//                if (obj == null) {
//                    unsetPublic_key();
//                    return;
//                } else {
//                    setPublic_key((String) obj);
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
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case ACCESS_TOKEN:
//                return getAccess_token();
//            case IS_NEW_USER:
//                return Integer.valueOf(getIs_new_user());
//            case EMAIL:
//                return getEmail();
//            case PUBLIC_KEY:
//                return getPublic_key();
//            case UPDATE_AT_OF_BOOK_INFO:
//                return Long.valueOf(getUpdate_at_of_book_info());
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
//            case ACCESS_TOKEN:
//                return isSetAccess_token();
//            case IS_NEW_USER:
//                return isSetIs_new_user();
//            case EMAIL:
//                return isSetEmail();
//            case PUBLIC_KEY:
//                return isSetPublic_key();
//            case UPDATE_AT_OF_BOOK_INFO:
//                return isSetUpdate_at_of_book_info();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBLoginResult)) {
//            return equals((BBLoginResult) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBLoginResult bBLoginResult) {
//        if (bBLoginResult == null) {
//            return false;
//        }
//        boolean isSetAccess_token = isSetAccess_token();
//        boolean isSetAccess_token2 = bBLoginResult.isSetAccess_token();
//        if (((isSetAccess_token || isSetAccess_token2) && (!isSetAccess_token || !isSetAccess_token2 || !this.access_token.equals(bBLoginResult.access_token))) || this.is_new_user != bBLoginResult.is_new_user) {
//            return false;
//        }
//        boolean isSetEmail = isSetEmail();
//        boolean isSetEmail2 = bBLoginResult.isSetEmail();
//        if ((isSetEmail || isSetEmail2) && (!isSetEmail || !isSetEmail2 || !this.email.equals(bBLoginResult.email))) {
//            return false;
//        }
//        boolean isSetPublic_key = isSetPublic_key();
//        boolean isSetPublic_key2 = bBLoginResult.isSetPublic_key();
//        if ((isSetPublic_key || isSetPublic_key2) && (!isSetPublic_key || !isSetPublic_key2 || !this.public_key.equals(bBLoginResult.public_key))) {
//            return false;
//        }
//        boolean isSetUpdate_at_of_book_info = isSetUpdate_at_of_book_info();
//        boolean isSetUpdate_at_of_book_info2 = bBLoginResult.isSetUpdate_at_of_book_info();
//        if ((isSetUpdate_at_of_book_info || isSetUpdate_at_of_book_info2) && (!isSetUpdate_at_of_book_info || !isSetUpdate_at_of_book_info2 || this.update_at_of_book_info != bBLoginResult.update_at_of_book_info)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBLoginResult bBLoginResult) {
//        if (!getClass().equals(bBLoginResult.getClass())) {
//            return getClass().getName().compareTo(bBLoginResult.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetAccess_token()).compareTo(Boolean.valueOf(bBLoginResult.isSetAccess_token()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetAccess_token()) {
//            int a = C2121h.m5525a(this.access_token, bBLoginResult.access_token);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetIs_new_user()).compareTo(Boolean.valueOf(bBLoginResult.isSetIs_new_user()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetIs_new_user()) {
//            int a2 = C2121h.m5522a(this.is_new_user, bBLoginResult.is_new_user);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetEmail()).compareTo(Boolean.valueOf(bBLoginResult.isSetEmail()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetEmail()) {
//            int a3 = C2121h.m5525a(this.email, bBLoginResult.email);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetPublic_key()).compareTo(Boolean.valueOf(bBLoginResult.isSetPublic_key()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetPublic_key()) {
//            int a4 = C2121h.m5525a(this.public_key, bBLoginResult.public_key);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetUpdate_at_of_book_info()).compareTo(Boolean.valueOf(bBLoginResult.isSetUpdate_at_of_book_info()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetUpdate_at_of_book_info()) {
//            int a5 = C2121h.m5523a(this.update_at_of_book_info, bBLoginResult.update_at_of_book_info);
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
//        StringBuilder sb = new StringBuilder("BBLoginResult(");
//        sb.append("access_token:");
//        if (this.access_token == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.access_token);
//        }
//        sb.append(", ");
//        sb.append("is_new_user:");
//        sb.append(this.is_new_user);
//        sb.append(", ");
//        sb.append("email:");
//        if (this.email == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.email);
//        }
//        sb.append(", ");
//        sb.append("public_key:");
//        if (this.public_key == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.public_key);
//        }
//        if (isSetUpdate_at_of_book_info()) {
//            sb.append(", ");
//            sb.append("update_at_of_book_info:");
//            sb.append(this.update_at_of_book_info);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.access_token == null) {
//            throw new C2101g("Required field 'access_token' was not present! Struct: " + toString());
//        } else if (this.email == null) {
//            throw new C2101g("Required field 'email' was not present! Struct: " + toString());
//        } else if (this.public_key == null) {
//            throw new C2101g("Required field 'public_key' was not present! Struct: " + toString());
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
