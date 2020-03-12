//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_TB.Columns;
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
//public class BBOperationStatLog implements Serializable, Cloneable, Comparable<BBOperationStatLog>, C2116f<BBOperationStatLog, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b OP_NAME_FIELD_DESC = new C2097b(Columns.OP_NAME, JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b OP_TIME_FIELD_DESC = new C2097b("op_time", 10, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b OP_VALUE_FIELD_DESC = new C2097b("op_value", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBOperationStatLog");
//    private static final int __OP_TIME_ISSET_ID = 1;
//    private static final int __OP_VALUE_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String op_name;
//    public long op_time;
//    public int op_value;
//
//    class BBOperationStatLogStandardScheme extends C2110c<BBOperationStatLog> {
//        private BBOperationStatLogStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBOperationStatLog bBOperationStatLog) {
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
//                                bBOperationStatLog.op_name = fVar.mo18516q();
//                                bBOperationStatLog.setOp_nameIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBOperationStatLog.op_value = fVar.mo18513n();
//                                bBOperationStatLog.setOp_valueIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBOperationStatLog.op_time = fVar.mo18514o();
//                                bBOperationStatLog.setOp_timeIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBOperationStatLog.isSetOp_value()) {
//                        throw new C2101g("Required field 'op_value' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBOperationStatLog.isSetOp_time()) {
//                        throw new C2101g("Required field 'op_time' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBOperationStatLog.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBOperationStatLog bBOperationStatLog) {
//            bBOperationStatLog.validate();
//            BBOperationStatLog.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBOperationStatLog.op_name != null) {
//                fVar.mo18496a(BBOperationStatLog.OP_NAME_FIELD_DESC);
//                fVar.mo18495a(bBOperationStatLog.op_name);
//            }
//            fVar.mo18496a(BBOperationStatLog.OP_VALUE_FIELD_DESC);
//            fVar.mo18493a(bBOperationStatLog.op_value);
//            fVar.mo18496a(BBOperationStatLog.OP_TIME_FIELD_DESC);
//            fVar.mo18494a(bBOperationStatLog.op_time);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBOperationStatLogStandardSchemeFactory implements C2109b {
//        private BBOperationStatLogStandardSchemeFactory() {
//        }
//
//        public BBOperationStatLogStandardScheme getScheme() {
//            return new BBOperationStatLogStandardScheme();
//        }
//    }
//
//    class BBOperationStatLogTupleScheme extends C2111d<BBOperationStatLog> {
//        private BBOperationStatLogTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBOperationStatLog bBOperationStatLog) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBOperationStatLog.op_name);
//            lVar.mo18493a(bBOperationStatLog.op_value);
//            lVar.mo18494a(bBOperationStatLog.op_time);
//        }
//
//        public void read(C2100f fVar, BBOperationStatLog bBOperationStatLog) {
//            C2106l lVar = (C2106l) fVar;
//            bBOperationStatLog.op_name = lVar.mo18516q();
//            bBOperationStatLog.setOp_nameIsSet(true);
//            bBOperationStatLog.op_value = lVar.mo18513n();
//            bBOperationStatLog.setOp_valueIsSet(true);
//            bBOperationStatLog.op_time = lVar.mo18514o();
//            bBOperationStatLog.setOp_timeIsSet(true);
//        }
//    }
//
//    class BBOperationStatLogTupleSchemeFactory implements C2109b {
//        private BBOperationStatLogTupleSchemeFactory() {
//        }
//
//        public BBOperationStatLogTupleScheme getScheme() {
//            return new BBOperationStatLogTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        OP_NAME(1, Columns.OP_NAME),
//        OP_VALUE(2, "op_value"),
//        OP_TIME(3, "op_time");
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
//                    return OP_NAME;
//                case 2:
//                    return OP_VALUE;
//                case 3:
//                    return OP_TIME;
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
//        hashMap.put(C2110c.class, new BBOperationStatLogStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBOperationStatLogTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.OP_NAME, new C2091a(Columns.OP_NAME, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.OP_VALUE, new C2091a("op_value", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.OP_TIME, new C2091a("op_time", 1, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBOperationStatLog.class, metaDataMap);
//    }
//
//    public BBOperationStatLog() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBOperationStatLog(String str, int i, long j) {
//        this();
//        this.op_name = str;
//        this.op_value = i;
//        setOp_valueIsSet(true);
//        this.op_time = j;
//        setOp_timeIsSet(true);
//    }
//
//    public BBOperationStatLog(BBOperationStatLog bBOperationStatLog) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBOperationStatLog.__isset_bitfield;
//        if (bBOperationStatLog.isSetOp_name()) {
//            this.op_name = bBOperationStatLog.op_name;
//        }
//        this.op_value = bBOperationStatLog.op_value;
//        this.op_time = bBOperationStatLog.op_time;
//    }
//
//    public BBOperationStatLog deepCopy() {
//        return new BBOperationStatLog(this);
//    }
//
//    public void clear() {
//        this.op_name = null;
//        setOp_valueIsSet(false);
//        this.op_value = 0;
//        setOp_timeIsSet(false);
//        this.op_time = 0;
//    }
//
//    public String getOp_name() {
//        return this.op_name;
//    }
//
//    public BBOperationStatLog setOp_name(String str) {
//        this.op_name = str;
//        return this;
//    }
//
//    public void unsetOp_name() {
//        this.op_name = null;
//    }
//
//    public boolean isSetOp_name() {
//        return this.op_name != null;
//    }
//
//    public void setOp_nameIsSet(boolean z) {
//        if (!z) {
//            this.op_name = null;
//        }
//    }
//
//    public int getOp_value() {
//        return this.op_value;
//    }
//
//    public BBOperationStatLog setOp_value(int i) {
//        this.op_value = i;
//        setOp_valueIsSet(true);
//        return this;
//    }
//
//    public void unsetOp_value() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetOp_value() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setOp_valueIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public long getOp_time() {
//        return this.op_time;
//    }
//
//    public BBOperationStatLog setOp_time(long j) {
//        this.op_time = j;
//        setOp_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetOp_time() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetOp_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setOp_timeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case OP_NAME:
//                if (obj == null) {
//                    unsetOp_name();
//                    return;
//                } else {
//                    setOp_name((String) obj);
//                    return;
//                }
//            case OP_VALUE:
//                if (obj == null) {
//                    unsetOp_value();
//                    return;
//                } else {
//                    setOp_value(((Integer) obj).intValue());
//                    return;
//                }
//            case OP_TIME:
//                if (obj == null) {
//                    unsetOp_time();
//                    return;
//                } else {
//                    setOp_time(((Long) obj).longValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case OP_NAME:
//                return getOp_name();
//            case OP_VALUE:
//                return Integer.valueOf(getOp_value());
//            case OP_TIME:
//                return Long.valueOf(getOp_time());
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
//            case OP_NAME:
//                return isSetOp_name();
//            case OP_VALUE:
//                return isSetOp_value();
//            case OP_TIME:
//                return isSetOp_time();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBOperationStatLog)) {
//            return equals((BBOperationStatLog) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBOperationStatLog bBOperationStatLog) {
//        if (bBOperationStatLog == null) {
//            return false;
//        }
//        boolean isSetOp_name = isSetOp_name();
//        boolean isSetOp_name2 = bBOperationStatLog.isSetOp_name();
//        if (((!isSetOp_name && !isSetOp_name2) || (isSetOp_name && isSetOp_name2 && this.op_name.equals(bBOperationStatLog.op_name))) && this.op_value == bBOperationStatLog.op_value && this.op_time == bBOperationStatLog.op_time) {
//            return true;
//        }
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBOperationStatLog bBOperationStatLog) {
//        if (!getClass().equals(bBOperationStatLog.getClass())) {
//            return getClass().getName().compareTo(bBOperationStatLog.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetOp_name()).compareTo(Boolean.valueOf(bBOperationStatLog.isSetOp_name()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetOp_name()) {
//            int a = C2121h.m5525a(this.op_name, bBOperationStatLog.op_name);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetOp_value()).compareTo(Boolean.valueOf(bBOperationStatLog.isSetOp_value()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetOp_value()) {
//            int a2 = C2121h.m5522a(this.op_value, bBOperationStatLog.op_value);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetOp_time()).compareTo(Boolean.valueOf(bBOperationStatLog.isSetOp_time()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetOp_time()) {
//            int a3 = C2121h.m5523a(this.op_time, bBOperationStatLog.op_time);
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
//        StringBuilder sb = new StringBuilder("BBOperationStatLog(");
//        sb.append("op_name:");
//        if (this.op_name == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.op_name);
//        }
//        sb.append(", ");
//        sb.append("op_value:");
//        sb.append(this.op_value);
//        sb.append(", ");
//        sb.append("op_time:");
//        sb.append(this.op_time);
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.op_name == null) {
//            throw new C2101g("Required field 'op_name' was not present! Struct: " + toString());
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
