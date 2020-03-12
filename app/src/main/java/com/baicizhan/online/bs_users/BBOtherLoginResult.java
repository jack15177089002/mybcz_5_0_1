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
//import org.p100a.p101a.p103b.C2095e;
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
//public class BBOtherLoginResult implements Serializable, Cloneable, Comparable<BBOtherLoginResult>, C2116f<BBOtherLoginResult, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b OAUTH_ACCOUNT_ID_FIELD_DESC = new C2097b("oauth_account_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBOtherLoginResult");
//    /* access modifiers changed from: private */
//    public static final C2097b USER_LOGIN_INFO_FIELD_DESC = new C2097b("user_login_info", JceStruct.ZERO_TAG, 2);
//    private static final int __OAUTH_ACCOUNT_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int oauth_account_id;
//    public BBLoginResult user_login_info;
//
//    class BBOtherLoginResultStandardScheme extends C2110c<BBOtherLoginResult> {
//        private BBOtherLoginResultStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBOtherLoginResult bBOtherLoginResult) {
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
//                                bBOtherLoginResult.oauth_account_id = fVar.mo18513n();
//                                bBOtherLoginResult.setOauth_account_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 12) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBOtherLoginResult.user_login_info = new BBLoginResult();
//                                bBOtherLoginResult.user_login_info.read(fVar);
//                                bBOtherLoginResult.setUser_login_infoIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBOtherLoginResult.isSetOauth_account_id()) {
//                        throw new C2101g("Required field 'oauth_account_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBOtherLoginResult.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBOtherLoginResult bBOtherLoginResult) {
//            bBOtherLoginResult.validate();
//            BBOtherLoginResult.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBOtherLoginResult.OAUTH_ACCOUNT_ID_FIELD_DESC);
//            fVar.mo18493a(bBOtherLoginResult.oauth_account_id);
//            if (bBOtherLoginResult.user_login_info != null) {
//                fVar.mo18496a(BBOtherLoginResult.USER_LOGIN_INFO_FIELD_DESC);
//                bBOtherLoginResult.user_login_info.write(fVar);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBOtherLoginResultStandardSchemeFactory implements C2109b {
//        private BBOtherLoginResultStandardSchemeFactory() {
//        }
//
//        public BBOtherLoginResultStandardScheme getScheme() {
//            return new BBOtherLoginResultStandardScheme();
//        }
//    }
//
//    class BBOtherLoginResultTupleScheme extends C2111d<BBOtherLoginResult> {
//        private BBOtherLoginResultTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBOtherLoginResult bBOtherLoginResult) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBOtherLoginResult.oauth_account_id);
//            bBOtherLoginResult.user_login_info.write(lVar);
//        }
//
//        public void read(C2100f fVar, BBOtherLoginResult bBOtherLoginResult) {
//            C2106l lVar = (C2106l) fVar;
//            bBOtherLoginResult.oauth_account_id = lVar.mo18513n();
//            bBOtherLoginResult.setOauth_account_idIsSet(true);
//            bBOtherLoginResult.user_login_info = new BBLoginResult();
//            bBOtherLoginResult.user_login_info.read(lVar);
//            bBOtherLoginResult.setUser_login_infoIsSet(true);
//        }
//    }
//
//    class BBOtherLoginResultTupleSchemeFactory implements C2109b {
//        private BBOtherLoginResultTupleSchemeFactory() {
//        }
//
//        public BBOtherLoginResultTupleScheme getScheme() {
//            return new BBOtherLoginResultTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        OAUTH_ACCOUNT_ID(1, "oauth_account_id"),
//        USER_LOGIN_INFO(2, "user_login_info");
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
//                    return OAUTH_ACCOUNT_ID;
//                case 2:
//                    return USER_LOGIN_INFO;
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
//        hashMap.put(C2110c.class, new BBOtherLoginResultStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBOtherLoginResultTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.OAUTH_ACCOUNT_ID, new C2091a("oauth_account_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.USER_LOGIN_INFO, new C2091a("user_login_info", 1, new C2095e(BBLoginResult.class)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBOtherLoginResult.class, metaDataMap);
//    }
//
//    public BBOtherLoginResult() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBOtherLoginResult(int i, BBLoginResult bBLoginResult) {
//        this();
//        this.oauth_account_id = i;
//        setOauth_account_idIsSet(true);
//        this.user_login_info = bBLoginResult;
//    }
//
//    public BBOtherLoginResult(BBOtherLoginResult bBOtherLoginResult) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBOtherLoginResult.__isset_bitfield;
//        this.oauth_account_id = bBOtherLoginResult.oauth_account_id;
//        if (bBOtherLoginResult.isSetUser_login_info()) {
//            this.user_login_info = new BBLoginResult(bBOtherLoginResult.user_login_info);
//        }
//    }
//
//    public BBOtherLoginResult deepCopy() {
//        return new BBOtherLoginResult(this);
//    }
//
//    public void clear() {
//        setOauth_account_idIsSet(false);
//        this.oauth_account_id = 0;
//        this.user_login_info = null;
//    }
//
//    public int getOauth_account_id() {
//        return this.oauth_account_id;
//    }
//
//    public BBOtherLoginResult setOauth_account_id(int i) {
//        this.oauth_account_id = i;
//        setOauth_account_idIsSet(true);
//        return this;
//    }
//
//    public void unsetOauth_account_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetOauth_account_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setOauth_account_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public BBLoginResult getUser_login_info() {
//        return this.user_login_info;
//    }
//
//    public BBOtherLoginResult setUser_login_info(BBLoginResult bBLoginResult) {
//        this.user_login_info = bBLoginResult;
//        return this;
//    }
//
//    public void unsetUser_login_info() {
//        this.user_login_info = null;
//    }
//
//    public boolean isSetUser_login_info() {
//        return this.user_login_info != null;
//    }
//
//    public void setUser_login_infoIsSet(boolean z) {
//        if (!z) {
//            this.user_login_info = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case OAUTH_ACCOUNT_ID:
//                if (obj == null) {
//                    unsetOauth_account_id();
//                    return;
//                } else {
//                    setOauth_account_id(((Integer) obj).intValue());
//                    return;
//                }
//            case USER_LOGIN_INFO:
//                if (obj == null) {
//                    unsetUser_login_info();
//                    return;
//                } else {
//                    setUser_login_info((BBLoginResult) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case OAUTH_ACCOUNT_ID:
//                return Integer.valueOf(getOauth_account_id());
//            case USER_LOGIN_INFO:
//                return getUser_login_info();
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
//            case OAUTH_ACCOUNT_ID:
//                return isSetOauth_account_id();
//            case USER_LOGIN_INFO:
//                return isSetUser_login_info();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBOtherLoginResult)) {
//            return equals((BBOtherLoginResult) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBOtherLoginResult bBOtherLoginResult) {
//        if (bBOtherLoginResult == null || this.oauth_account_id != bBOtherLoginResult.oauth_account_id) {
//            return false;
//        }
//        boolean isSetUser_login_info = isSetUser_login_info();
//        boolean isSetUser_login_info2 = bBOtherLoginResult.isSetUser_login_info();
//        if ((isSetUser_login_info || isSetUser_login_info2) && (!isSetUser_login_info || !isSetUser_login_info2 || !this.user_login_info.equals(bBOtherLoginResult.user_login_info))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBOtherLoginResult bBOtherLoginResult) {
//        if (!getClass().equals(bBOtherLoginResult.getClass())) {
//            return getClass().getName().compareTo(bBOtherLoginResult.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetOauth_account_id()).compareTo(Boolean.valueOf(bBOtherLoginResult.isSetOauth_account_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetOauth_account_id()) {
//            int a = C2121h.m5522a(this.oauth_account_id, bBOtherLoginResult.oauth_account_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetUser_login_info()).compareTo(Boolean.valueOf(bBOtherLoginResult.isSetUser_login_info()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetUser_login_info()) {
//            int a2 = C2121h.m5524a((Comparable) this.user_login_info, (Comparable) bBOtherLoginResult.user_login_info);
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
//        StringBuilder sb = new StringBuilder("BBOtherLoginResult(");
//        sb.append("oauth_account_id:");
//        sb.append(this.oauth_account_id);
//        sb.append(", ");
//        sb.append("user_login_info:");
//        if (this.user_login_info == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.user_login_info);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.user_login_info == null) {
//            throw new C2101g("Required field 'user_login_info' was not present! Struct: " + toString());
//        } else if (this.user_login_info != null) {
//            this.user_login_info.validate();
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
