//package com.baicizhan.online.bs_users;
//
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
//public class BBResetLearnRecordResult implements Serializable, Cloneable, Comparable<BBResetLearnRecordResult>, C2116f<BBResetLearnRecordResult, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBResetLearnRecordResult");
//    /* access modifiers changed from: private */
//    public static final C2097b SUCCESS_FIELD_DESC = new C2097b("success", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_LEVEL_ID_FIELD_DESC = new C2097b("word_level_id", 8, 2);
//    private static final int __SUCCESS_ISSET_ID = 0;
//    private static final int __WORD_LEVEL_ID_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int success;
//    public int word_level_id;
//
//    class BBResetLearnRecordResultStandardScheme extends C2110c<BBResetLearnRecordResult> {
//        private BBResetLearnRecordResultStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBResetLearnRecordResult bBResetLearnRecordResult) {
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
//                                bBResetLearnRecordResult.success = fVar.mo18513n();
//                                bBResetLearnRecordResult.setSuccessIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBResetLearnRecordResult.word_level_id = fVar.mo18513n();
//                                bBResetLearnRecordResult.setWord_level_idIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBResetLearnRecordResult.isSetSuccess()) {
//                        throw new C2101g("Required field 'success' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBResetLearnRecordResult.isSetWord_level_id()) {
//                        throw new C2101g("Required field 'word_level_id' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBResetLearnRecordResult.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBResetLearnRecordResult bBResetLearnRecordResult) {
//            bBResetLearnRecordResult.validate();
//            BBResetLearnRecordResult.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBResetLearnRecordResult.SUCCESS_FIELD_DESC);
//            fVar.mo18493a(bBResetLearnRecordResult.success);
//            fVar.mo18496a(BBResetLearnRecordResult.WORD_LEVEL_ID_FIELD_DESC);
//            fVar.mo18493a(bBResetLearnRecordResult.word_level_id);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBResetLearnRecordResultStandardSchemeFactory implements C2109b {
//        private BBResetLearnRecordResultStandardSchemeFactory() {
//        }
//
//        public BBResetLearnRecordResultStandardScheme getScheme() {
//            return new BBResetLearnRecordResultStandardScheme();
//        }
//    }
//
//    class BBResetLearnRecordResultTupleScheme extends C2111d<BBResetLearnRecordResult> {
//        private BBResetLearnRecordResultTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBResetLearnRecordResult bBResetLearnRecordResult) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBResetLearnRecordResult.success);
//            lVar.mo18493a(bBResetLearnRecordResult.word_level_id);
//        }
//
//        public void read(C2100f fVar, BBResetLearnRecordResult bBResetLearnRecordResult) {
//            C2106l lVar = (C2106l) fVar;
//            bBResetLearnRecordResult.success = lVar.mo18513n();
//            bBResetLearnRecordResult.setSuccessIsSet(true);
//            bBResetLearnRecordResult.word_level_id = lVar.mo18513n();
//            bBResetLearnRecordResult.setWord_level_idIsSet(true);
//        }
//    }
//
//    class BBResetLearnRecordResultTupleSchemeFactory implements C2109b {
//        private BBResetLearnRecordResultTupleSchemeFactory() {
//        }
//
//        public BBResetLearnRecordResultTupleScheme getScheme() {
//            return new BBResetLearnRecordResultTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        SUCCESS(1, "success"),
//        WORD_LEVEL_ID(2, "word_level_id");
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
//                    return SUCCESS;
//                case 2:
//                    return WORD_LEVEL_ID;
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
//        hashMap.put(C2110c.class, new BBResetLearnRecordResultStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBResetLearnRecordResultTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.SUCCESS, new C2091a("success", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.WORD_LEVEL_ID, new C2091a("word_level_id", 1, new C2092b(8, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBResetLearnRecordResult.class, metaDataMap);
//    }
//
//    public BBResetLearnRecordResult() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBResetLearnRecordResult(int i, int i2) {
//        this();
//        this.success = i;
//        setSuccessIsSet(true);
//        this.word_level_id = i2;
//        setWord_level_idIsSet(true);
//    }
//
//    public BBResetLearnRecordResult(BBResetLearnRecordResult bBResetLearnRecordResult) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBResetLearnRecordResult.__isset_bitfield;
//        this.success = bBResetLearnRecordResult.success;
//        this.word_level_id = bBResetLearnRecordResult.word_level_id;
//    }
//
//    public BBResetLearnRecordResult deepCopy() {
//        return new BBResetLearnRecordResult(this);
//    }
//
//    public void clear() {
//        setSuccessIsSet(false);
//        this.success = 0;
//        setWord_level_idIsSet(false);
//        this.word_level_id = 0;
//    }
//
//    public int getSuccess() {
//        return this.success;
//    }
//
//    public BBResetLearnRecordResult setSuccess(int i) {
//        this.success = i;
//        setSuccessIsSet(true);
//        return this;
//    }
//
//    public void unsetSuccess() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetSuccess() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setSuccessIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public int getWord_level_id() {
//        return this.word_level_id;
//    }
//
//    public BBResetLearnRecordResult setWord_level_id(int i) {
//        this.word_level_id = i;
//        setWord_level_idIsSet(true);
//        return this;
//    }
//
//    public void unsetWord_level_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetWord_level_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setWord_level_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case SUCCESS:
//                if (obj == null) {
//                    unsetSuccess();
//                    return;
//                } else {
//                    setSuccess(((Integer) obj).intValue());
//                    return;
//                }
//            case WORD_LEVEL_ID:
//                if (obj == null) {
//                    unsetWord_level_id();
//                    return;
//                } else {
//                    setWord_level_id(((Integer) obj).intValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case SUCCESS:
//                return Integer.valueOf(getSuccess());
//            case WORD_LEVEL_ID:
//                return Integer.valueOf(getWord_level_id());
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
//            case SUCCESS:
//                return isSetSuccess();
//            case WORD_LEVEL_ID:
//                return isSetWord_level_id();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBResetLearnRecordResult)) {
//            return equals((BBResetLearnRecordResult) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBResetLearnRecordResult bBResetLearnRecordResult) {
//        if (bBResetLearnRecordResult != null && this.success == bBResetLearnRecordResult.success && this.word_level_id == bBResetLearnRecordResult.word_level_id) {
//            return true;
//        }
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBResetLearnRecordResult bBResetLearnRecordResult) {
//        if (!getClass().equals(bBResetLearnRecordResult.getClass())) {
//            return getClass().getName().compareTo(bBResetLearnRecordResult.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetSuccess()).compareTo(Boolean.valueOf(bBResetLearnRecordResult.isSetSuccess()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetSuccess()) {
//            int a = C2121h.m5522a(this.success, bBResetLearnRecordResult.success);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetWord_level_id()).compareTo(Boolean.valueOf(bBResetLearnRecordResult.isSetWord_level_id()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetWord_level_id()) {
//            int a2 = C2121h.m5522a(this.word_level_id, bBResetLearnRecordResult.word_level_id);
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
//        StringBuilder sb = new StringBuilder("BBResetLearnRecordResult(");
//        sb.append("success:");
//        sb.append(this.success);
//        sb.append(", ");
//        sb.append("word_level_id:");
//        sb.append(this.word_level_id);
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
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
