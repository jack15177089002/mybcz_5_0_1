//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE.Columns;
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
//public class BBWordUpdateMD5 implements Serializable, Cloneable, Comparable<BBWordUpdateMD5>, C2116f<BBWordUpdateMD5, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordUpdateMD5");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATE_FLAG_MD5_FIELD_DESC = new C2097b(Columns.UPDATE_FLAG_MD5, JceStruct.STRUCT_END, 2);
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int topic_id;
//    public String update_flag_md5;
//
//    class BBWordUpdateMD5StandardScheme extends C2110c<BBWordUpdateMD5> {
//        private BBWordUpdateMD5StandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordUpdateMD5 bBWordUpdateMD5) {
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
//                                bBWordUpdateMD5.topic_id = fVar.mo18513n();
//                                bBWordUpdateMD5.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordUpdateMD5.update_flag_md5 = fVar.mo18516q();
//                                bBWordUpdateMD5.setUpdate_flag_md5IsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBWordUpdateMD5.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBWordUpdateMD5.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordUpdateMD5 bBWordUpdateMD5) {
//            bBWordUpdateMD5.validate();
//            BBWordUpdateMD5.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBWordUpdateMD5.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordUpdateMD5.topic_id);
//            if (bBWordUpdateMD5.update_flag_md5 != null) {
//                fVar.mo18496a(BBWordUpdateMD5.UPDATE_FLAG_MD5_FIELD_DESC);
//                fVar.mo18495a(bBWordUpdateMD5.update_flag_md5);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordUpdateMD5StandardSchemeFactory implements C2109b {
//        private BBWordUpdateMD5StandardSchemeFactory() {
//        }
//
//        public BBWordUpdateMD5StandardScheme getScheme() {
//            return new BBWordUpdateMD5StandardScheme();
//        }
//    }
//
//    class BBWordUpdateMD5TupleScheme extends C2111d<BBWordUpdateMD5> {
//        private BBWordUpdateMD5TupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordUpdateMD5 bBWordUpdateMD5) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBWordUpdateMD5.topic_id);
//            lVar.mo18495a(bBWordUpdateMD5.update_flag_md5);
//        }
//
//        public void read(C2100f fVar, BBWordUpdateMD5 bBWordUpdateMD5) {
//            C2106l lVar = (C2106l) fVar;
//            bBWordUpdateMD5.topic_id = lVar.mo18513n();
//            bBWordUpdateMD5.setTopic_idIsSet(true);
//            bBWordUpdateMD5.update_flag_md5 = lVar.mo18516q();
//            bBWordUpdateMD5.setUpdate_flag_md5IsSet(true);
//        }
//    }
//
//    class BBWordUpdateMD5TupleSchemeFactory implements C2109b {
//        private BBWordUpdateMD5TupleSchemeFactory() {
//        }
//
//        public BBWordUpdateMD5TupleScheme getScheme() {
//            return new BBWordUpdateMD5TupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        UPDATE_FLAG_MD5(2, Columns.UPDATE_FLAG_MD5);
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
//                    return TOPIC_ID;
//                case 2:
//                    return UPDATE_FLAG_MD5;
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
//        hashMap.put(C2110c.class, new BBWordUpdateMD5StandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordUpdateMD5TupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.UPDATE_FLAG_MD5, new C2091a(Columns.UPDATE_FLAG_MD5, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordUpdateMD5.class, metaDataMap);
//    }
//
//    public BBWordUpdateMD5() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBWordUpdateMD5(int i, String str) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.update_flag_md5 = str;
//    }
//
//    public BBWordUpdateMD5(BBWordUpdateMD5 bBWordUpdateMD5) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBWordUpdateMD5.__isset_bitfield;
//        this.topic_id = bBWordUpdateMD5.topic_id;
//        if (bBWordUpdateMD5.isSetUpdate_flag_md5()) {
//            this.update_flag_md5 = bBWordUpdateMD5.update_flag_md5;
//        }
//    }
//
//    public BBWordUpdateMD5 deepCopy() {
//        return new BBWordUpdateMD5(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        this.update_flag_md5 = null;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBWordUpdateMD5 setTopic_id(int i) {
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        return this;
//    }
//
//    public void unsetTopic_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetTopic_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setTopic_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getUpdate_flag_md5() {
//        return this.update_flag_md5;
//    }
//
//    public BBWordUpdateMD5 setUpdate_flag_md5(String str) {
//        this.update_flag_md5 = str;
//        return this;
//    }
//
//    public void unsetUpdate_flag_md5() {
//        this.update_flag_md5 = null;
//    }
//
//    public boolean isSetUpdate_flag_md5() {
//        return this.update_flag_md5 != null;
//    }
//
//    public void setUpdate_flag_md5IsSet(boolean z) {
//        if (!z) {
//            this.update_flag_md5 = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case TOPIC_ID:
//                if (obj == null) {
//                    unsetTopic_id();
//                    return;
//                } else {
//                    setTopic_id(((Integer) obj).intValue());
//                    return;
//                }
//            case UPDATE_FLAG_MD5:
//                if (obj == null) {
//                    unsetUpdate_flag_md5();
//                    return;
//                } else {
//                    setUpdate_flag_md5((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case TOPIC_ID:
//                return Integer.valueOf(getTopic_id());
//            case UPDATE_FLAG_MD5:
//                return getUpdate_flag_md5();
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
//            case TOPIC_ID:
//                return isSetTopic_id();
//            case UPDATE_FLAG_MD5:
//                return isSetUpdate_flag_md5();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordUpdateMD5)) {
//            return equals((BBWordUpdateMD5) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordUpdateMD5 bBWordUpdateMD5) {
//        if (bBWordUpdateMD5 == null || this.topic_id != bBWordUpdateMD5.topic_id) {
//            return false;
//        }
//        boolean isSetUpdate_flag_md5 = isSetUpdate_flag_md5();
//        boolean isSetUpdate_flag_md52 = bBWordUpdateMD5.isSetUpdate_flag_md5();
//        if ((isSetUpdate_flag_md5 || isSetUpdate_flag_md52) && (!isSetUpdate_flag_md5 || !isSetUpdate_flag_md52 || !this.update_flag_md5.equals(bBWordUpdateMD5.update_flag_md5))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordUpdateMD5 bBWordUpdateMD5) {
//        if (!getClass().equals(bBWordUpdateMD5.getClass())) {
//            return getClass().getName().compareTo(bBWordUpdateMD5.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBWordUpdateMD5.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBWordUpdateMD5.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetUpdate_flag_md5()).compareTo(Boolean.valueOf(bBWordUpdateMD5.isSetUpdate_flag_md5()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetUpdate_flag_md5()) {
//            int a2 = C2121h.m5525a(this.update_flag_md5, bBWordUpdateMD5.update_flag_md5);
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
//        StringBuilder sb = new StringBuilder("BBWordUpdateMD5(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("update_flag_md5:");
//        if (this.update_flag_md5 == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.update_flag_md5);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.update_flag_md5 == null) {
//            throw new C2101g("Required field 'update_flag_md5' was not present! Struct: " + toString());
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
