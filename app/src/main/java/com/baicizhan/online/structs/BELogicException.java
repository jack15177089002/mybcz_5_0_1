//package com.baicizhan.online.structs;
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
//public class BELogicException extends C2123l implements Serializable, Cloneable, Comparable<BELogicException>, C2116f<BELogicException, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b CODE_FIELD_DESC = new C2097b("code", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b FROM_METHOD_FIELD_DESC = new C2097b("from_method", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b FROM_SERVICE_FIELD_DESC = new C2097b("from_service", JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b MESSAGE_FIELD_DESC = new C2097b("message", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BELogicException");
//    private static final int __CODE_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int code;
//    public String from_method;
//    public String from_service;
//    public String message;
//    private _Fields[] optionals;
//
//    class BELogicExceptionStandardScheme extends C2110c<BELogicException> {
//        private BELogicExceptionStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BELogicException bELogicException) {
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
//                                bELogicException.from_service = fVar.mo18516q();
//                                bELogicException.setFrom_serviceIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bELogicException.from_method = fVar.mo18516q();
//                                bELogicException.setFrom_methodIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bELogicException.code = fVar.mo18513n();
//                                bELogicException.setCodeIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bELogicException.message = fVar.mo18516q();
//                                bELogicException.setMessageIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bELogicException.isSetCode()) {
//                        throw new C2101g("Required field 'code' was not found in serialized data! Struct: " + toString());
//                    }
//                    bELogicException.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BELogicException bELogicException) {
//            bELogicException.validate();
//            BELogicException.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bELogicException.from_service != null) {
//                fVar.mo18496a(BELogicException.FROM_SERVICE_FIELD_DESC);
//                fVar.mo18495a(bELogicException.from_service);
//            }
//            if (bELogicException.from_method != null) {
//                fVar.mo18496a(BELogicException.FROM_METHOD_FIELD_DESC);
//                fVar.mo18495a(bELogicException.from_method);
//            }
//            fVar.mo18496a(BELogicException.CODE_FIELD_DESC);
//            fVar.mo18493a(bELogicException.code);
//            if (bELogicException.message != null && bELogicException.isSetMessage()) {
//                fVar.mo18496a(BELogicException.MESSAGE_FIELD_DESC);
//                fVar.mo18495a(bELogicException.message);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BELogicExceptionStandardSchemeFactory implements C2109b {
//        private BELogicExceptionStandardSchemeFactory() {
//        }
//
//        public BELogicExceptionStandardScheme getScheme() {
//            return new BELogicExceptionStandardScheme();
//        }
//    }
//
//    class BELogicExceptionTupleScheme extends C2111d<BELogicException> {
//        private BELogicExceptionTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BELogicException bELogicException) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bELogicException.from_service);
//            lVar.mo18495a(bELogicException.from_method);
//            lVar.mo18493a(bELogicException.code);
//            BitSet bitSet = new BitSet();
//            if (bELogicException.isSetMessage()) {
//                bitSet.set(0);
//            }
//            lVar.mo18527a(bitSet, 1);
//            if (bELogicException.isSetMessage()) {
//                lVar.mo18495a(bELogicException.message);
//            }
//        }
//
//        public void read(C2100f fVar, BELogicException bELogicException) {
//            C2106l lVar = (C2106l) fVar;
//            bELogicException.from_service = lVar.mo18516q();
//            bELogicException.setFrom_serviceIsSet(true);
//            bELogicException.from_method = lVar.mo18516q();
//            bELogicException.setFrom_methodIsSet(true);
//            bELogicException.code = lVar.mo18513n();
//            bELogicException.setCodeIsSet(true);
//            if (lVar.mo18528b(1).get(0)) {
//                bELogicException.message = lVar.mo18516q();
//                bELogicException.setMessageIsSet(true);
//            }
//        }
//    }
//
//    class BELogicExceptionTupleSchemeFactory implements C2109b {
//        private BELogicExceptionTupleSchemeFactory() {
//        }
//
//        public BELogicExceptionTupleScheme getScheme() {
//            return new BELogicExceptionTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        FROM_SERVICE(1, "from_service"),
//        FROM_METHOD(2, "from_method"),
//        CODE(3, "code"),
//        MESSAGE(4, "message");
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
//                    return FROM_SERVICE;
//                case 2:
//                    return FROM_METHOD;
//                case 3:
//                    return CODE;
//                case 4:
//                    return MESSAGE;
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
//        hashMap.put(C2110c.class, new BELogicExceptionStandardSchemeFactory());
//        schemes.put(C2111d.class, new BELogicExceptionTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.FROM_SERVICE, new C2091a("from_service", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.FROM_METHOD, new C2091a("from_method", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.CODE, new C2091a("code", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.MESSAGE, new C2091a("message", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BELogicException.class, metaDataMap);
//    }
//
//    public BELogicException() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.MESSAGE};
//    }
//
//    public BELogicException(String str, String str2, int i) {
//        this();
//        this.from_service = str;
//        this.from_method = str2;
//        this.code = i;
//        setCodeIsSet(true);
//    }
//
//    public BELogicException(BELogicException bELogicException) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.MESSAGE};
//        this.__isset_bitfield = bELogicException.__isset_bitfield;
//        if (bELogicException.isSetFrom_service()) {
//            this.from_service = bELogicException.from_service;
//        }
//        if (bELogicException.isSetFrom_method()) {
//            this.from_method = bELogicException.from_method;
//        }
//        this.code = bELogicException.code;
//        if (bELogicException.isSetMessage()) {
//            this.message = bELogicException.message;
//        }
//    }
//
//    public BELogicException deepCopy() {
//        return new BELogicException(this);
//    }
//
//    public void clear() {
//        this.from_service = null;
//        this.from_method = null;
//        setCodeIsSet(false);
//        this.code = 0;
//        this.message = null;
//    }
//
//    public String getFrom_service() {
//        return this.from_service;
//    }
//
//    public BELogicException setFrom_service(String str) {
//        this.from_service = str;
//        return this;
//    }
//
//    public void unsetFrom_service() {
//        this.from_service = null;
//    }
//
//    public boolean isSetFrom_service() {
//        return this.from_service != null;
//    }
//
//    public void setFrom_serviceIsSet(boolean z) {
//        if (!z) {
//            this.from_service = null;
//        }
//    }
//
//    public String getFrom_method() {
//        return this.from_method;
//    }
//
//    public BELogicException setFrom_method(String str) {
//        this.from_method = str;
//        return this;
//    }
//
//    public void unsetFrom_method() {
//        this.from_method = null;
//    }
//
//    public boolean isSetFrom_method() {
//        return this.from_method != null;
//    }
//
//    public void setFrom_methodIsSet(boolean z) {
//        if (!z) {
//            this.from_method = null;
//        }
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//
//    public BELogicException setCode(int i) {
//        this.code = i;
//        setCodeIsSet(true);
//        return this;
//    }
//
//    public void unsetCode() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetCode() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setCodeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getMessage() {
//        return this.message;
//    }
//
//    public BELogicException setMessage(String str) {
//        this.message = str;
//        return this;
//    }
//
//    public void unsetMessage() {
//        this.message = null;
//    }
//
//    public boolean isSetMessage() {
//        return this.message != null;
//    }
//
//    public void setMessageIsSet(boolean z) {
//        if (!z) {
//            this.message = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case FROM_SERVICE:
//                if (obj == null) {
//                    unsetFrom_service();
//                    return;
//                } else {
//                    setFrom_service((String) obj);
//                    return;
//                }
//            case FROM_METHOD:
//                if (obj == null) {
//                    unsetFrom_method();
//                    return;
//                } else {
//                    setFrom_method((String) obj);
//                    return;
//                }
//            case CODE:
//                if (obj == null) {
//                    unsetCode();
//                    return;
//                } else {
//                    setCode(((Integer) obj).intValue());
//                    return;
//                }
//            case MESSAGE:
//                if (obj == null) {
//                    unsetMessage();
//                    return;
//                } else {
//                    setMessage((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case FROM_SERVICE:
//                return getFrom_service();
//            case FROM_METHOD:
//                return getFrom_method();
//            case CODE:
//                return Integer.valueOf(getCode());
//            case MESSAGE:
//                return getMessage();
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
//            case FROM_SERVICE:
//                return isSetFrom_service();
//            case FROM_METHOD:
//                return isSetFrom_method();
//            case CODE:
//                return isSetCode();
//            case MESSAGE:
//                return isSetMessage();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BELogicException)) {
//            return equals((BELogicException) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BELogicException bELogicException) {
//        if (bELogicException == null) {
//            return false;
//        }
//        boolean isSetFrom_service = isSetFrom_service();
//        boolean isSetFrom_service2 = bELogicException.isSetFrom_service();
//        if ((isSetFrom_service || isSetFrom_service2) && (!isSetFrom_service || !isSetFrom_service2 || !this.from_service.equals(bELogicException.from_service))) {
//            return false;
//        }
//        boolean isSetFrom_method = isSetFrom_method();
//        boolean isSetFrom_method2 = bELogicException.isSetFrom_method();
//        if (((isSetFrom_method || isSetFrom_method2) && (!isSetFrom_method || !isSetFrom_method2 || !this.from_method.equals(bELogicException.from_method))) || this.code != bELogicException.code) {
//            return false;
//        }
//        boolean isSetMessage = isSetMessage();
//        boolean isSetMessage2 = bELogicException.isSetMessage();
//        if ((isSetMessage || isSetMessage2) && (!isSetMessage || !isSetMessage2 || !this.message.equals(bELogicException.message))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BELogicException bELogicException) {
//        if (!getClass().equals(bELogicException.getClass())) {
//            return getClass().getName().compareTo(bELogicException.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetFrom_service()).compareTo(Boolean.valueOf(bELogicException.isSetFrom_service()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetFrom_service()) {
//            int a = C2121h.m5525a(this.from_service, bELogicException.from_service);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetFrom_method()).compareTo(Boolean.valueOf(bELogicException.isSetFrom_method()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetFrom_method()) {
//            int a2 = C2121h.m5525a(this.from_method, bELogicException.from_method);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetCode()).compareTo(Boolean.valueOf(bELogicException.isSetCode()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetCode()) {
//            int a3 = C2121h.m5522a(this.code, bELogicException.code);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetMessage()).compareTo(Boolean.valueOf(bELogicException.isSetMessage()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetMessage()) {
//            int a4 = C2121h.m5525a(this.message, bELogicException.message);
//            if (a4 != 0) {
//                return a4;
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
//        StringBuilder sb = new StringBuilder("BELogicException(");
//        sb.append("from_service:");
//        if (this.from_service == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.from_service);
//        }
//        sb.append(", ");
//        sb.append("from_method:");
//        if (this.from_method == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.from_method);
//        }
//        sb.append(", ");
//        sb.append("code:");
//        sb.append(this.code);
//        if (isSetMessage()) {
//            sb.append(", ");
//            sb.append("message:");
//            if (this.message == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.message);
//            }
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.from_service == null) {
//            throw new C2101g("Required field 'from_service' was not present! Struct: " + toString());
//        } else if (this.from_method == null) {
//            throw new C2101g("Required field 'from_method' was not present! Struct: " + toString());
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
