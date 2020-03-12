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
//public class BBSelectTip implements Serializable, Cloneable, Comparable<BBSelectTip>, C2116f<BBSelectTip, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b MSG_TIP_FIELD_DESC = new C2097b("msg_tip", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b SHOULD_SELECT_DATE_FIELD_DESC = new C2097b("should_select_date", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBSelectTip");
//    private static final int __SHOULD_SELECT_DATE_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String msg_tip;
//    public int should_select_date;
//
//    class BBSelectTipStandardScheme extends C2110c<BBSelectTip> {
//        private BBSelectTipStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBSelectTip bBSelectTip) {
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
//                                bBSelectTip.should_select_date = fVar.mo18513n();
//                                bBSelectTip.setShould_select_dateIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSelectTip.msg_tip = fVar.mo18516q();
//                                bBSelectTip.setMsg_tipIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBSelectTip.isSetShould_select_date()) {
//                        throw new C2101g("Required field 'should_select_date' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBSelectTip.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBSelectTip bBSelectTip) {
//            bBSelectTip.validate();
//            BBSelectTip.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBSelectTip.SHOULD_SELECT_DATE_FIELD_DESC);
//            fVar.mo18493a(bBSelectTip.should_select_date);
//            if (bBSelectTip.msg_tip != null) {
//                fVar.mo18496a(BBSelectTip.MSG_TIP_FIELD_DESC);
//                fVar.mo18495a(bBSelectTip.msg_tip);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBSelectTipStandardSchemeFactory implements C2109b {
//        private BBSelectTipStandardSchemeFactory() {
//        }
//
//        public BBSelectTipStandardScheme getScheme() {
//            return new BBSelectTipStandardScheme();
//        }
//    }
//
//    class BBSelectTipTupleScheme extends C2111d<BBSelectTip> {
//        private BBSelectTipTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBSelectTip bBSelectTip) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBSelectTip.should_select_date);
//            lVar.mo18495a(bBSelectTip.msg_tip);
//        }
//
//        public void read(C2100f fVar, BBSelectTip bBSelectTip) {
//            C2106l lVar = (C2106l) fVar;
//            bBSelectTip.should_select_date = lVar.mo18513n();
//            bBSelectTip.setShould_select_dateIsSet(true);
//            bBSelectTip.msg_tip = lVar.mo18516q();
//            bBSelectTip.setMsg_tipIsSet(true);
//        }
//    }
//
//    class BBSelectTipTupleSchemeFactory implements C2109b {
//        private BBSelectTipTupleSchemeFactory() {
//        }
//
//        public BBSelectTipTupleScheme getScheme() {
//            return new BBSelectTipTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        SHOULD_SELECT_DATE(1, "should_select_date"),
//        MSG_TIP(2, "msg_tip");
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
//                    return SHOULD_SELECT_DATE;
//                case 2:
//                    return MSG_TIP;
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
//        hashMap.put(C2110c.class, new BBSelectTipStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBSelectTipTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.SHOULD_SELECT_DATE, new C2091a("should_select_date", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.MSG_TIP, new C2091a("msg_tip", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBSelectTip.class, metaDataMap);
//    }
//
//    public BBSelectTip() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBSelectTip(int i, String str) {
//        this();
//        this.should_select_date = i;
//        setShould_select_dateIsSet(true);
//        this.msg_tip = str;
//    }
//
//    public BBSelectTip(BBSelectTip bBSelectTip) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBSelectTip.__isset_bitfield;
//        this.should_select_date = bBSelectTip.should_select_date;
//        if (bBSelectTip.isSetMsg_tip()) {
//            this.msg_tip = bBSelectTip.msg_tip;
//        }
//    }
//
//    public BBSelectTip deepCopy() {
//        return new BBSelectTip(this);
//    }
//
//    public void clear() {
//        setShould_select_dateIsSet(false);
//        this.should_select_date = 0;
//        this.msg_tip = null;
//    }
//
//    public int getShould_select_date() {
//        return this.should_select_date;
//    }
//
//    public BBSelectTip setShould_select_date(int i) {
//        this.should_select_date = i;
//        setShould_select_dateIsSet(true);
//        return this;
//    }
//
//    public void unsetShould_select_date() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetShould_select_date() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setShould_select_dateIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getMsg_tip() {
//        return this.msg_tip;
//    }
//
//    public BBSelectTip setMsg_tip(String str) {
//        this.msg_tip = str;
//        return this;
//    }
//
//    public void unsetMsg_tip() {
//        this.msg_tip = null;
//    }
//
//    public boolean isSetMsg_tip() {
//        return this.msg_tip != null;
//    }
//
//    public void setMsg_tipIsSet(boolean z) {
//        if (!z) {
//            this.msg_tip = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case SHOULD_SELECT_DATE:
//                if (obj == null) {
//                    unsetShould_select_date();
//                    return;
//                } else {
//                    setShould_select_date(((Integer) obj).intValue());
//                    return;
//                }
//            case MSG_TIP:
//                if (obj == null) {
//                    unsetMsg_tip();
//                    return;
//                } else {
//                    setMsg_tip((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case SHOULD_SELECT_DATE:
//                return Integer.valueOf(getShould_select_date());
//            case MSG_TIP:
//                return getMsg_tip();
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
//            case SHOULD_SELECT_DATE:
//                return isSetShould_select_date();
//            case MSG_TIP:
//                return isSetMsg_tip();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBSelectTip)) {
//            return equals((BBSelectTip) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBSelectTip bBSelectTip) {
//        if (bBSelectTip == null || this.should_select_date != bBSelectTip.should_select_date) {
//            return false;
//        }
//        boolean isSetMsg_tip = isSetMsg_tip();
//        boolean isSetMsg_tip2 = bBSelectTip.isSetMsg_tip();
//        if ((isSetMsg_tip || isSetMsg_tip2) && (!isSetMsg_tip || !isSetMsg_tip2 || !this.msg_tip.equals(bBSelectTip.msg_tip))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBSelectTip bBSelectTip) {
//        if (!getClass().equals(bBSelectTip.getClass())) {
//            return getClass().getName().compareTo(bBSelectTip.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetShould_select_date()).compareTo(Boolean.valueOf(bBSelectTip.isSetShould_select_date()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetShould_select_date()) {
//            int a = C2121h.m5522a(this.should_select_date, bBSelectTip.should_select_date);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetMsg_tip()).compareTo(Boolean.valueOf(bBSelectTip.isSetMsg_tip()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetMsg_tip()) {
//            int a2 = C2121h.m5525a(this.msg_tip, bBSelectTip.msg_tip);
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
//        StringBuilder sb = new StringBuilder("BBSelectTip(");
//        sb.append("should_select_date:");
//        sb.append(this.should_select_date);
//        sb.append(", ");
//        sb.append("msg_tip:");
//        if (this.msg_tip == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.msg_tip);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.msg_tip == null) {
//            throw new C2101g("Required field 'msg_tip' was not present! Struct: " + toString());
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
