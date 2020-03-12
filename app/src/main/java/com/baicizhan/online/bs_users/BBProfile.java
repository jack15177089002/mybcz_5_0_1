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
//public class BBProfile implements Serializable, Cloneable, Comparable<BBProfile>, C2116f<BBProfile, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b GENDER_FIELD_DESC = new C2097b("gender", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b NICK_NAME_FIELD_DESC = new C2097b("nick_name", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBProfile");
//    private static final int __GENDER_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int gender;
//    public String nick_name;
//
//    class BBProfileStandardScheme extends C2110c<BBProfile> {
//        private BBProfileStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBProfile bBProfile) {
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
//                                bBProfile.gender = fVar.mo18513n();
//                                bBProfile.setGenderIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBProfile.nick_name = fVar.mo18516q();
//                                bBProfile.setNick_nameIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBProfile.isSetGender()) {
//                        throw new C2101g("Required field 'gender' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBProfile.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBProfile bBProfile) {
//            bBProfile.validate();
//            BBProfile.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBProfile.GENDER_FIELD_DESC);
//            fVar.mo18493a(bBProfile.gender);
//            if (bBProfile.nick_name != null) {
//                fVar.mo18496a(BBProfile.NICK_NAME_FIELD_DESC);
//                fVar.mo18495a(bBProfile.nick_name);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBProfileStandardSchemeFactory implements C2109b {
//        private BBProfileStandardSchemeFactory() {
//        }
//
//        public BBProfileStandardScheme getScheme() {
//            return new BBProfileStandardScheme();
//        }
//    }
//
//    class BBProfileTupleScheme extends C2111d<BBProfile> {
//        private BBProfileTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBProfile bBProfile) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBProfile.gender);
//            lVar.mo18495a(bBProfile.nick_name);
//        }
//
//        public void read(C2100f fVar, BBProfile bBProfile) {
//            C2106l lVar = (C2106l) fVar;
//            bBProfile.gender = lVar.mo18513n();
//            bBProfile.setGenderIsSet(true);
//            bBProfile.nick_name = lVar.mo18516q();
//            bBProfile.setNick_nameIsSet(true);
//        }
//    }
//
//    class BBProfileTupleSchemeFactory implements C2109b {
//        private BBProfileTupleSchemeFactory() {
//        }
//
//        public BBProfileTupleScheme getScheme() {
//            return new BBProfileTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        GENDER(1, "gender"),
//        NICK_NAME(2, "nick_name");
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
//                    return GENDER;
//                case 2:
//                    return NICK_NAME;
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
//        hashMap.put(C2110c.class, new BBProfileStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBProfileTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.GENDER, new C2091a("gender", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.NICK_NAME, new C2091a("nick_name", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBProfile.class, metaDataMap);
//    }
//
//    public BBProfile() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBProfile(int i, String str) {
//        this();
//        this.gender = i;
//        setGenderIsSet(true);
//        this.nick_name = str;
//    }
//
//    public BBProfile(BBProfile bBProfile) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBProfile.__isset_bitfield;
//        this.gender = bBProfile.gender;
//        if (bBProfile.isSetNick_name()) {
//            this.nick_name = bBProfile.nick_name;
//        }
//    }
//
//    public BBProfile deepCopy() {
//        return new BBProfile(this);
//    }
//
//    public void clear() {
//        setGenderIsSet(false);
//        this.gender = 0;
//        this.nick_name = null;
//    }
//
//    public int getGender() {
//        return this.gender;
//    }
//
//    public BBProfile setGender(int i) {
//        this.gender = i;
//        setGenderIsSet(true);
//        return this;
//    }
//
//    public void unsetGender() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetGender() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setGenderIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getNick_name() {
//        return this.nick_name;
//    }
//
//    public BBProfile setNick_name(String str) {
//        this.nick_name = str;
//        return this;
//    }
//
//    public void unsetNick_name() {
//        this.nick_name = null;
//    }
//
//    public boolean isSetNick_name() {
//        return this.nick_name != null;
//    }
//
//    public void setNick_nameIsSet(boolean z) {
//        if (!z) {
//            this.nick_name = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case GENDER:
//                if (obj == null) {
//                    unsetGender();
//                    return;
//                } else {
//                    setGender(((Integer) obj).intValue());
//                    return;
//                }
//            case NICK_NAME:
//                if (obj == null) {
//                    unsetNick_name();
//                    return;
//                } else {
//                    setNick_name((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case GENDER:
//                return Integer.valueOf(getGender());
//            case NICK_NAME:
//                return getNick_name();
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
//            case GENDER:
//                return isSetGender();
//            case NICK_NAME:
//                return isSetNick_name();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBProfile)) {
//            return equals((BBProfile) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBProfile bBProfile) {
//        if (bBProfile == null || this.gender != bBProfile.gender) {
//            return false;
//        }
//        boolean isSetNick_name = isSetNick_name();
//        boolean isSetNick_name2 = bBProfile.isSetNick_name();
//        if ((isSetNick_name || isSetNick_name2) && (!isSetNick_name || !isSetNick_name2 || !this.nick_name.equals(bBProfile.nick_name))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBProfile bBProfile) {
//        if (!getClass().equals(bBProfile.getClass())) {
//            return getClass().getName().compareTo(bBProfile.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetGender()).compareTo(Boolean.valueOf(bBProfile.isSetGender()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetGender()) {
//            int a = C2121h.m5522a(this.gender, bBProfile.gender);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetNick_name()).compareTo(Boolean.valueOf(bBProfile.isSetNick_name()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetNick_name()) {
//            int a2 = C2121h.m5525a(this.nick_name, bBProfile.nick_name);
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
//        StringBuilder sb = new StringBuilder("BBProfile(");
//        sb.append("gender:");
//        sb.append(this.gender);
//        sb.append(", ");
//        sb.append("nick_name:");
//        if (this.nick_name == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.nick_name);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.nick_name == null) {
//            throw new C2101g("Required field 'nick_name' was not present! Struct: " + toString());
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
