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
//public class BBBasicInfo implements Serializable, Cloneable, Comparable<BBBasicInfo>, C2116f<BBBasicInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b LEARN_INFO_FIELD_DESC = new C2097b("learn_info", JceStruct.ZERO_TAG, 3);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBBasicInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b USER_INFO_FIELD_DESC = new C2097b("user_info", JceStruct.ZERO_TAG, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b USER_LIMIT_FIELD_DESC = new C2097b("user_limit", JceStruct.ZERO_TAG, 2);
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public BBLearnInfo learn_info;
//    public BBUserBasicInfo user_info;
//    public BBUserLimit user_limit;
//
//    class BBBasicInfoStandardScheme extends C2110c<BBBasicInfo> {
//        private BBBasicInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBBasicInfo bBBasicInfo) {
//            fVar.mo18504e();
//            while (true) {
//                C2097b g = fVar.mo18506g();
//                if (g.f5835b != 0) {
//                    switch (g.f5836c) {
//                        case 1:
//                            if (g.f5835b != 12) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBasicInfo.user_info = new BBUserBasicInfo();
//                                bBBasicInfo.user_info.read(fVar);
//                                bBBasicInfo.setUser_infoIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 12) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBasicInfo.user_limit = new BBUserLimit();
//                                bBBasicInfo.user_limit.read(fVar);
//                                bBBasicInfo.setUser_limitIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 12) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBBasicInfo.learn_info = new BBLearnInfo();
//                                bBBasicInfo.learn_info.read(fVar);
//                                bBBasicInfo.setLearn_infoIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBBasicInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBBasicInfo bBBasicInfo) {
//            bBBasicInfo.validate();
//            BBBasicInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBBasicInfo.user_info != null) {
//                fVar.mo18496a(BBBasicInfo.USER_INFO_FIELD_DESC);
//                bBBasicInfo.user_info.write(fVar);
//            }
//            if (bBBasicInfo.user_limit != null) {
//                fVar.mo18496a(BBBasicInfo.USER_LIMIT_FIELD_DESC);
//                bBBasicInfo.user_limit.write(fVar);
//            }
//            if (bBBasicInfo.learn_info != null) {
//                fVar.mo18496a(BBBasicInfo.LEARN_INFO_FIELD_DESC);
//                bBBasicInfo.learn_info.write(fVar);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBBasicInfoStandardSchemeFactory implements C2109b {
//        private BBBasicInfoStandardSchemeFactory() {
//        }
//
//        public BBBasicInfoStandardScheme getScheme() {
//            return new BBBasicInfoStandardScheme();
//        }
//    }
//
//    class BBBasicInfoTupleScheme extends C2111d<BBBasicInfo> {
//        private BBBasicInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBBasicInfo bBBasicInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBBasicInfo.user_info.write(lVar);
//            bBBasicInfo.user_limit.write(lVar);
//            bBBasicInfo.learn_info.write(lVar);
//        }
//
//        public void read(C2100f fVar, BBBasicInfo bBBasicInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBBasicInfo.user_info = new BBUserBasicInfo();
//            bBBasicInfo.user_info.read(lVar);
//            bBBasicInfo.setUser_infoIsSet(true);
//            bBBasicInfo.user_limit = new BBUserLimit();
//            bBBasicInfo.user_limit.read(lVar);
//            bBBasicInfo.setUser_limitIsSet(true);
//            bBBasicInfo.learn_info = new BBLearnInfo();
//            bBBasicInfo.learn_info.read(lVar);
//            bBBasicInfo.setLearn_infoIsSet(true);
//        }
//    }
//
//    class BBBasicInfoTupleSchemeFactory implements C2109b {
//        private BBBasicInfoTupleSchemeFactory() {
//        }
//
//        public BBBasicInfoTupleScheme getScheme() {
//            return new BBBasicInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        USER_INFO(1, "user_info"),
//        USER_LIMIT(2, "user_limit"),
//        LEARN_INFO(3, "learn_info");
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
//                    return USER_INFO;
//                case 2:
//                    return USER_LIMIT;
//                case 3:
//                    return LEARN_INFO;
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
//        hashMap.put(C2110c.class, new BBBasicInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBBasicInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.USER_INFO, new C2091a("user_info", 1, new C2095e(BBUserBasicInfo.class)));
//        enumMap.put(_Fields.USER_LIMIT, new C2091a("user_limit", 1, new C2095e(BBUserLimit.class)));
//        enumMap.put(_Fields.LEARN_INFO, new C2091a("learn_info", 1, new C2095e(BBLearnInfo.class)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBBasicInfo.class, metaDataMap);
//    }
//
//    public BBBasicInfo() {
//    }
//
//    public BBBasicInfo(BBUserBasicInfo bBUserBasicInfo, BBUserLimit bBUserLimit, BBLearnInfo bBLearnInfo) {
//        this();
//        this.user_info = bBUserBasicInfo;
//        this.user_limit = bBUserLimit;
//        this.learn_info = bBLearnInfo;
//    }
//
//    public BBBasicInfo(BBBasicInfo bBBasicInfo) {
//        if (bBBasicInfo.isSetUser_info()) {
//            this.user_info = new BBUserBasicInfo(bBBasicInfo.user_info);
//        }
//        if (bBBasicInfo.isSetUser_limit()) {
//            this.user_limit = new BBUserLimit(bBBasicInfo.user_limit);
//        }
//        if (bBBasicInfo.isSetLearn_info()) {
//            this.learn_info = new BBLearnInfo(bBBasicInfo.learn_info);
//        }
//    }
//
//    public BBBasicInfo deepCopy() {
//        return new BBBasicInfo(this);
//    }
//
//    public void clear() {
//        this.user_info = null;
//        this.user_limit = null;
//        this.learn_info = null;
//    }
//
//    public BBUserBasicInfo getUser_info() {
//        return this.user_info;
//    }
//
//    public BBBasicInfo setUser_info(BBUserBasicInfo bBUserBasicInfo) {
//        this.user_info = bBUserBasicInfo;
//        return this;
//    }
//
//    public void unsetUser_info() {
//        this.user_info = null;
//    }
//
//    public boolean isSetUser_info() {
//        return this.user_info != null;
//    }
//
//    public void setUser_infoIsSet(boolean z) {
//        if (!z) {
//            this.user_info = null;
//        }
//    }
//
//    public BBUserLimit getUser_limit() {
//        return this.user_limit;
//    }
//
//    public BBBasicInfo setUser_limit(BBUserLimit bBUserLimit) {
//        this.user_limit = bBUserLimit;
//        return this;
//    }
//
//    public void unsetUser_limit() {
//        this.user_limit = null;
//    }
//
//    public boolean isSetUser_limit() {
//        return this.user_limit != null;
//    }
//
//    public void setUser_limitIsSet(boolean z) {
//        if (!z) {
//            this.user_limit = null;
//        }
//    }
//
//    public BBLearnInfo getLearn_info() {
//        return this.learn_info;
//    }
//
//    public BBBasicInfo setLearn_info(BBLearnInfo bBLearnInfo) {
//        this.learn_info = bBLearnInfo;
//        return this;
//    }
//
//    public void unsetLearn_info() {
//        this.learn_info = null;
//    }
//
//    public boolean isSetLearn_info() {
//        return this.learn_info != null;
//    }
//
//    public void setLearn_infoIsSet(boolean z) {
//        if (!z) {
//            this.learn_info = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case USER_INFO:
//                if (obj == null) {
//                    unsetUser_info();
//                    return;
//                } else {
//                    setUser_info((BBUserBasicInfo) obj);
//                    return;
//                }
//            case USER_LIMIT:
//                if (obj == null) {
//                    unsetUser_limit();
//                    return;
//                } else {
//                    setUser_limit((BBUserLimit) obj);
//                    return;
//                }
//            case LEARN_INFO:
//                if (obj == null) {
//                    unsetLearn_info();
//                    return;
//                } else {
//                    setLearn_info((BBLearnInfo) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case USER_INFO:
//                return getUser_info();
//            case USER_LIMIT:
//                return getUser_limit();
//            case LEARN_INFO:
//                return getLearn_info();
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
//            case USER_INFO:
//                return isSetUser_info();
//            case USER_LIMIT:
//                return isSetUser_limit();
//            case LEARN_INFO:
//                return isSetLearn_info();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBBasicInfo)) {
//            return equals((BBBasicInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBBasicInfo bBBasicInfo) {
//        if (bBBasicInfo == null) {
//            return false;
//        }
//        boolean isSetUser_info = isSetUser_info();
//        boolean isSetUser_info2 = bBBasicInfo.isSetUser_info();
//        if ((isSetUser_info || isSetUser_info2) && (!isSetUser_info || !isSetUser_info2 || !this.user_info.equals(bBBasicInfo.user_info))) {
//            return false;
//        }
//        boolean isSetUser_limit = isSetUser_limit();
//        boolean isSetUser_limit2 = bBBasicInfo.isSetUser_limit();
//        if ((isSetUser_limit || isSetUser_limit2) && (!isSetUser_limit || !isSetUser_limit2 || !this.user_limit.equals(bBBasicInfo.user_limit))) {
//            return false;
//        }
//        boolean isSetLearn_info = isSetLearn_info();
//        boolean isSetLearn_info2 = bBBasicInfo.isSetLearn_info();
//        if ((isSetLearn_info || isSetLearn_info2) && (!isSetLearn_info || !isSetLearn_info2 || !this.learn_info.equals(bBBasicInfo.learn_info))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBBasicInfo bBBasicInfo) {
//        if (!getClass().equals(bBBasicInfo.getClass())) {
//            return getClass().getName().compareTo(bBBasicInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetUser_info()).compareTo(Boolean.valueOf(bBBasicInfo.isSetUser_info()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetUser_info()) {
//            int a = C2121h.m5524a((Comparable) this.user_info, (Comparable) bBBasicInfo.user_info);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetUser_limit()).compareTo(Boolean.valueOf(bBBasicInfo.isSetUser_limit()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetUser_limit()) {
//            int a2 = C2121h.m5524a((Comparable) this.user_limit, (Comparable) bBBasicInfo.user_limit);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetLearn_info()).compareTo(Boolean.valueOf(bBBasicInfo.isSetLearn_info()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetLearn_info()) {
//            int a3 = C2121h.m5524a((Comparable) this.learn_info, (Comparable) bBBasicInfo.learn_info);
//            if (a3 != 0) {
//                return a3;
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
//        StringBuilder sb = new StringBuilder("BBBasicInfo(");
//        sb.append("user_info:");
//        if (this.user_info == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.user_info);
//        }
//        sb.append(", ");
//        sb.append("user_limit:");
//        if (this.user_limit == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.user_limit);
//        }
//        sb.append(", ");
//        sb.append("learn_info:");
//        if (this.learn_info == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.learn_info);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.user_info == null) {
//            throw new C2101g("Required field 'user_info' was not present! Struct: " + toString());
//        } else if (this.user_limit == null) {
//            throw new C2101g("Required field 'user_limit' was not present! Struct: " + toString());
//        } else if (this.learn_info == null) {
//            throw new C2101g("Required field 'learn_info' was not present! Struct: " + toString());
//        } else {
//            if (this.user_info != null) {
//                this.user_info.validate();
//            }
//            if (this.user_limit != null) {
//                this.user_limit.validate();
//            }
//            if (this.learn_info != null) {
//                this.learn_info.validate();
//            }
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
