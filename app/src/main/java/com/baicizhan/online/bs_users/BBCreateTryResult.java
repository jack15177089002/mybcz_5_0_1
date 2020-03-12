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
//public class BBCreateTryResult implements Serializable, Cloneable, Comparable<BBCreateTryResult>, C2116f<BBCreateTryResult, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b DIGEST_TOKEN_FIELD_DESC = new C2097b("digest_token", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b EMAIL_FIELD_DESC = new C2097b("email", JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBCreateTryResult");
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public String digest_token;
//    public String email;
//
//    class BBCreateTryResultStandardScheme extends C2110c<BBCreateTryResult> {
//        private BBCreateTryResultStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBCreateTryResult bBCreateTryResult) {
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
//                                bBCreateTryResult.email = fVar.mo18516q();
//                                bBCreateTryResult.setEmailIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBCreateTryResult.digest_token = fVar.mo18516q();
//                                bBCreateTryResult.setDigest_tokenIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBCreateTryResult.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBCreateTryResult bBCreateTryResult) {
//            bBCreateTryResult.validate();
//            BBCreateTryResult.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBCreateTryResult.email != null) {
//                fVar.mo18496a(BBCreateTryResult.EMAIL_FIELD_DESC);
//                fVar.mo18495a(bBCreateTryResult.email);
//            }
//            if (bBCreateTryResult.digest_token != null) {
//                fVar.mo18496a(BBCreateTryResult.DIGEST_TOKEN_FIELD_DESC);
//                fVar.mo18495a(bBCreateTryResult.digest_token);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBCreateTryResultStandardSchemeFactory implements C2109b {
//        private BBCreateTryResultStandardSchemeFactory() {
//        }
//
//        public BBCreateTryResultStandardScheme getScheme() {
//            return new BBCreateTryResultStandardScheme();
//        }
//    }
//
//    class BBCreateTryResultTupleScheme extends C2111d<BBCreateTryResult> {
//        private BBCreateTryResultTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBCreateTryResult bBCreateTryResult) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBCreateTryResult.email);
//            lVar.mo18495a(bBCreateTryResult.digest_token);
//        }
//
//        public void read(C2100f fVar, BBCreateTryResult bBCreateTryResult) {
//            C2106l lVar = (C2106l) fVar;
//            bBCreateTryResult.email = lVar.mo18516q();
//            bBCreateTryResult.setEmailIsSet(true);
//            bBCreateTryResult.digest_token = lVar.mo18516q();
//            bBCreateTryResult.setDigest_tokenIsSet(true);
//        }
//    }
//
//    class BBCreateTryResultTupleSchemeFactory implements C2109b {
//        private BBCreateTryResultTupleSchemeFactory() {
//        }
//
//        public BBCreateTryResultTupleScheme getScheme() {
//            return new BBCreateTryResultTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        EMAIL(1, "email"),
//        DIGEST_TOKEN(2, "digest_token");
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
//                    return EMAIL;
//                case 2:
//                    return DIGEST_TOKEN;
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
//        hashMap.put(C2110c.class, new BBCreateTryResultStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBCreateTryResultTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.EMAIL, new C2091a("email", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.DIGEST_TOKEN, new C2091a("digest_token", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBCreateTryResult.class, metaDataMap);
//    }
//
//    public BBCreateTryResult() {
//    }
//
//    public BBCreateTryResult(String str, String str2) {
//        this();
//        this.email = str;
//        this.digest_token = str2;
//    }
//
//    public BBCreateTryResult(BBCreateTryResult bBCreateTryResult) {
//        if (bBCreateTryResult.isSetEmail()) {
//            this.email = bBCreateTryResult.email;
//        }
//        if (bBCreateTryResult.isSetDigest_token()) {
//            this.digest_token = bBCreateTryResult.digest_token;
//        }
//    }
//
//    public BBCreateTryResult deepCopy() {
//        return new BBCreateTryResult(this);
//    }
//
//    public void clear() {
//        this.email = null;
//        this.digest_token = null;
//    }
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public BBCreateTryResult setEmail(String str) {
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
//    public String getDigest_token() {
//        return this.digest_token;
//    }
//
//    public BBCreateTryResult setDigest_token(String str) {
//        this.digest_token = str;
//        return this;
//    }
//
//    public void unsetDigest_token() {
//        this.digest_token = null;
//    }
//
//    public boolean isSetDigest_token() {
//        return this.digest_token != null;
//    }
//
//    public void setDigest_tokenIsSet(boolean z) {
//        if (!z) {
//            this.digest_token = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case EMAIL:
//                if (obj == null) {
//                    unsetEmail();
//                    return;
//                } else {
//                    setEmail((String) obj);
//                    return;
//                }
//            case DIGEST_TOKEN:
//                if (obj == null) {
//                    unsetDigest_token();
//                    return;
//                } else {
//                    setDigest_token((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case EMAIL:
//                return getEmail();
//            case DIGEST_TOKEN:
//                return getDigest_token();
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
//            case EMAIL:
//                return isSetEmail();
//            case DIGEST_TOKEN:
//                return isSetDigest_token();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBCreateTryResult)) {
//            return equals((BBCreateTryResult) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBCreateTryResult bBCreateTryResult) {
//        if (bBCreateTryResult == null) {
//            return false;
//        }
//        boolean isSetEmail = isSetEmail();
//        boolean isSetEmail2 = bBCreateTryResult.isSetEmail();
//        if ((isSetEmail || isSetEmail2) && (!isSetEmail || !isSetEmail2 || !this.email.equals(bBCreateTryResult.email))) {
//            return false;
//        }
//        boolean isSetDigest_token = isSetDigest_token();
//        boolean isSetDigest_token2 = bBCreateTryResult.isSetDigest_token();
//        if ((isSetDigest_token || isSetDigest_token2) && (!isSetDigest_token || !isSetDigest_token2 || !this.digest_token.equals(bBCreateTryResult.digest_token))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBCreateTryResult bBCreateTryResult) {
//        if (!getClass().equals(bBCreateTryResult.getClass())) {
//            return getClass().getName().compareTo(bBCreateTryResult.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetEmail()).compareTo(Boolean.valueOf(bBCreateTryResult.isSetEmail()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetEmail()) {
//            int a = C2121h.m5525a(this.email, bBCreateTryResult.email);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetDigest_token()).compareTo(Boolean.valueOf(bBCreateTryResult.isSetDigest_token()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetDigest_token()) {
//            int a2 = C2121h.m5525a(this.digest_token, bBCreateTryResult.digest_token);
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
//        StringBuilder sb = new StringBuilder("BBCreateTryResult(");
//        sb.append("email:");
//        if (this.email == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.email);
//        }
//        sb.append(", ");
//        sb.append("digest_token:");
//        if (this.digest_token == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.digest_token);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.email == null) {
//            throw new C2101g("Required field 'email' was not present! Struct: " + toString());
//        } else if (this.digest_token == null) {
//            throw new C2101g("Required field 'digest_token' was not present! Struct: " + toString());
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
//            read(new C2096a(new C2117b((InputStream) objectInputStream), 0));
//        } catch (C2123l e) {
//            throw new IOException(e);
//        }
//    }
//}
