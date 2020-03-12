//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_EVERY_NOTICE_INFO.Columns;
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
//public class BBUserNotifyMsg implements Serializable, Cloneable, Comparable<BBUserNotifyMsg>, C2116f<BBUserNotifyMsg, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b NTF_CONTENT_FIELD_DESC = new C2097b("ntf_content", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b NTF_DAY_FIELD_DESC = new C2097b(Columns.NTF_DAY, 8, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b NTF_ID_FIELD_DESC = new C2097b("ntf_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b NTF_PERSON_FIELD_DESC = new C2097b("ntf_person", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b NTF_TIME_FIELD_DESC = new C2097b("ntf_time", 10, 5);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserNotifyMsg");
//    private static final int __NTF_DAY_ISSET_ID = 2;
//    private static final int __NTF_ID_ISSET_ID = 0;
//    private static final int __NTF_PERSON_ISSET_ID = 1;
//    private static final int __NTF_TIME_ISSET_ID = 3;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String ntf_content;
//    public int ntf_day;
//    public int ntf_id;
//    public int ntf_person;
//    public long ntf_time;
//    private _Fields[] optionals;
//
//    class BBUserNotifyMsgStandardScheme extends C2110c<BBUserNotifyMsg> {
//        private BBUserNotifyMsgStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserNotifyMsg bBUserNotifyMsg) {
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
//                                bBUserNotifyMsg.ntf_id = fVar.mo18513n();
//                                bBUserNotifyMsg.setNtf_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserNotifyMsg.ntf_content = fVar.mo18516q();
//                                bBUserNotifyMsg.setNtf_contentIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserNotifyMsg.ntf_person = fVar.mo18513n();
//                                bBUserNotifyMsg.setNtf_personIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserNotifyMsg.ntf_day = fVar.mo18513n();
//                                bBUserNotifyMsg.setNtf_dayIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserNotifyMsg.ntf_time = fVar.mo18514o();
//                                bBUserNotifyMsg.setNtf_timeIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBUserNotifyMsg.isSetNtf_id()) {
//                        throw new C2101g("Required field 'ntf_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBUserNotifyMsg.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserNotifyMsg bBUserNotifyMsg) {
//            bBUserNotifyMsg.validate();
//            BBUserNotifyMsg.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBUserNotifyMsg.NTF_ID_FIELD_DESC);
//            fVar.mo18493a(bBUserNotifyMsg.ntf_id);
//            if (bBUserNotifyMsg.ntf_content != null && bBUserNotifyMsg.isSetNtf_content()) {
//                fVar.mo18496a(BBUserNotifyMsg.NTF_CONTENT_FIELD_DESC);
//                fVar.mo18495a(bBUserNotifyMsg.ntf_content);
//            }
//            if (bBUserNotifyMsg.isSetNtf_person()) {
//                fVar.mo18496a(BBUserNotifyMsg.NTF_PERSON_FIELD_DESC);
//                fVar.mo18493a(bBUserNotifyMsg.ntf_person);
//            }
//            if (bBUserNotifyMsg.isSetNtf_day()) {
//                fVar.mo18496a(BBUserNotifyMsg.NTF_DAY_FIELD_DESC);
//                fVar.mo18493a(bBUserNotifyMsg.ntf_day);
//            }
//            if (bBUserNotifyMsg.isSetNtf_time()) {
//                fVar.mo18496a(BBUserNotifyMsg.NTF_TIME_FIELD_DESC);
//                fVar.mo18494a(bBUserNotifyMsg.ntf_time);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserNotifyMsgStandardSchemeFactory implements C2109b {
//        private BBUserNotifyMsgStandardSchemeFactory() {
//        }
//
//        public BBUserNotifyMsgStandardScheme getScheme() {
//            return new BBUserNotifyMsgStandardScheme();
//        }
//    }
//
//    class BBUserNotifyMsgTupleScheme extends C2111d<BBUserNotifyMsg> {
//        private BBUserNotifyMsgTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserNotifyMsg bBUserNotifyMsg) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBUserNotifyMsg.ntf_id);
//            BitSet bitSet = new BitSet();
//            if (bBUserNotifyMsg.isSetNtf_content()) {
//                bitSet.set(0);
//            }
//            if (bBUserNotifyMsg.isSetNtf_person()) {
//                bitSet.set(1);
//            }
//            if (bBUserNotifyMsg.isSetNtf_day()) {
//                bitSet.set(2);
//            }
//            if (bBUserNotifyMsg.isSetNtf_time()) {
//                bitSet.set(3);
//            }
//            lVar.mo18527a(bitSet, 4);
//            if (bBUserNotifyMsg.isSetNtf_content()) {
//                lVar.mo18495a(bBUserNotifyMsg.ntf_content);
//            }
//            if (bBUserNotifyMsg.isSetNtf_person()) {
//                lVar.mo18493a(bBUserNotifyMsg.ntf_person);
//            }
//            if (bBUserNotifyMsg.isSetNtf_day()) {
//                lVar.mo18493a(bBUserNotifyMsg.ntf_day);
//            }
//            if (bBUserNotifyMsg.isSetNtf_time()) {
//                lVar.mo18494a(bBUserNotifyMsg.ntf_time);
//            }
//        }
//
//        public void read(C2100f fVar, BBUserNotifyMsg bBUserNotifyMsg) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserNotifyMsg.ntf_id = lVar.mo18513n();
//            bBUserNotifyMsg.setNtf_idIsSet(true);
//            BitSet b = lVar.mo18528b(4);
//            if (b.get(0)) {
//                bBUserNotifyMsg.ntf_content = lVar.mo18516q();
//                bBUserNotifyMsg.setNtf_contentIsSet(true);
//            }
//            if (b.get(1)) {
//                bBUserNotifyMsg.ntf_person = lVar.mo18513n();
//                bBUserNotifyMsg.setNtf_personIsSet(true);
//            }
//            if (b.get(2)) {
//                bBUserNotifyMsg.ntf_day = lVar.mo18513n();
//                bBUserNotifyMsg.setNtf_dayIsSet(true);
//            }
//            if (b.get(3)) {
//                bBUserNotifyMsg.ntf_time = lVar.mo18514o();
//                bBUserNotifyMsg.setNtf_timeIsSet(true);
//            }
//        }
//    }
//
//    class BBUserNotifyMsgTupleSchemeFactory implements C2109b {
//        private BBUserNotifyMsgTupleSchemeFactory() {
//        }
//
//        public BBUserNotifyMsgTupleScheme getScheme() {
//            return new BBUserNotifyMsgTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        NTF_ID(1, "ntf_id"),
//        NTF_CONTENT(2, "ntf_content"),
//        NTF_PERSON(3, "ntf_person"),
//        NTF_DAY(4, Columns.NTF_DAY),
//        NTF_TIME(5, "ntf_time");
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
//                    return NTF_ID;
//                case 2:
//                    return NTF_CONTENT;
//                case 3:
//                    return NTF_PERSON;
//                case 4:
//                    return NTF_DAY;
//                case 5:
//                    return NTF_TIME;
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
//        hashMap.put(C2110c.class, new BBUserNotifyMsgStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserNotifyMsgTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.NTF_ID, new C2091a("ntf_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.NTF_CONTENT, new C2091a("ntf_content", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.NTF_PERSON, new C2091a("ntf_person", 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.NTF_DAY, new C2091a(Columns.NTF_DAY, 2, new C2092b(8, 0)));
//        enumMap.put(_Fields.NTF_TIME, new C2091a("ntf_time", 2, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserNotifyMsg.class, metaDataMap);
//    }
//
//    public BBUserNotifyMsg() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.NTF_CONTENT, _Fields.NTF_PERSON, _Fields.NTF_DAY, _Fields.NTF_TIME};
//    }
//
//    public BBUserNotifyMsg(int i) {
//        this();
//        this.ntf_id = i;
//        setNtf_idIsSet(true);
//    }
//
//    public BBUserNotifyMsg(BBUserNotifyMsg bBUserNotifyMsg) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.NTF_CONTENT, _Fields.NTF_PERSON, _Fields.NTF_DAY, _Fields.NTF_TIME};
//        this.__isset_bitfield = bBUserNotifyMsg.__isset_bitfield;
//        this.ntf_id = bBUserNotifyMsg.ntf_id;
//        if (bBUserNotifyMsg.isSetNtf_content()) {
//            this.ntf_content = bBUserNotifyMsg.ntf_content;
//        }
//        this.ntf_person = bBUserNotifyMsg.ntf_person;
//        this.ntf_day = bBUserNotifyMsg.ntf_day;
//        this.ntf_time = bBUserNotifyMsg.ntf_time;
//    }
//
//    public BBUserNotifyMsg deepCopy() {
//        return new BBUserNotifyMsg(this);
//    }
//
//    public void clear() {
//        setNtf_idIsSet(false);
//        this.ntf_id = 0;
//        this.ntf_content = null;
//        setNtf_personIsSet(false);
//        this.ntf_person = 0;
//        setNtf_dayIsSet(false);
//        this.ntf_day = 0;
//        setNtf_timeIsSet(false);
//        this.ntf_time = 0;
//    }
//
//    public int getNtf_id() {
//        return this.ntf_id;
//    }
//
//    public BBUserNotifyMsg setNtf_id(int i) {
//        this.ntf_id = i;
//        setNtf_idIsSet(true);
//        return this;
//    }
//
//    public void unsetNtf_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetNtf_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setNtf_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getNtf_content() {
//        return this.ntf_content;
//    }
//
//    public BBUserNotifyMsg setNtf_content(String str) {
//        this.ntf_content = str;
//        return this;
//    }
//
//    public void unsetNtf_content() {
//        this.ntf_content = null;
//    }
//
//    public boolean isSetNtf_content() {
//        return this.ntf_content != null;
//    }
//
//    public void setNtf_contentIsSet(boolean z) {
//        if (!z) {
//            this.ntf_content = null;
//        }
//    }
//
//    public int getNtf_person() {
//        return this.ntf_person;
//    }
//
//    public BBUserNotifyMsg setNtf_person(int i) {
//        this.ntf_person = i;
//        setNtf_personIsSet(true);
//        return this;
//    }
//
//    public void unsetNtf_person() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetNtf_person() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setNtf_personIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getNtf_day() {
//        return this.ntf_day;
//    }
//
//    public BBUserNotifyMsg setNtf_day(int i) {
//        this.ntf_day = i;
//        setNtf_dayIsSet(true);
//        return this;
//    }
//
//    public void unsetNtf_day() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetNtf_day() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setNtf_dayIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public long getNtf_time() {
//        return this.ntf_time;
//    }
//
//    public BBUserNotifyMsg setNtf_time(long j) {
//        this.ntf_time = j;
//        setNtf_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetNtf_time() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetNtf_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setNtf_timeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case NTF_ID:
//                if (obj == null) {
//                    unsetNtf_id();
//                    return;
//                } else {
//                    setNtf_id(((Integer) obj).intValue());
//                    return;
//                }
//            case NTF_CONTENT:
//                if (obj == null) {
//                    unsetNtf_content();
//                    return;
//                } else {
//                    setNtf_content((String) obj);
//                    return;
//                }
//            case NTF_PERSON:
//                if (obj == null) {
//                    unsetNtf_person();
//                    return;
//                } else {
//                    setNtf_person(((Integer) obj).intValue());
//                    return;
//                }
//            case NTF_DAY:
//                if (obj == null) {
//                    unsetNtf_day();
//                    return;
//                } else {
//                    setNtf_day(((Integer) obj).intValue());
//                    return;
//                }
//            case NTF_TIME:
//                if (obj == null) {
//                    unsetNtf_time();
//                    return;
//                } else {
//                    setNtf_time(((Long) obj).longValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case NTF_ID:
//                return Integer.valueOf(getNtf_id());
//            case NTF_CONTENT:
//                return getNtf_content();
//            case NTF_PERSON:
//                return Integer.valueOf(getNtf_person());
//            case NTF_DAY:
//                return Integer.valueOf(getNtf_day());
//            case NTF_TIME:
//                return Long.valueOf(getNtf_time());
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
//            case NTF_ID:
//                return isSetNtf_id();
//            case NTF_CONTENT:
//                return isSetNtf_content();
//            case NTF_PERSON:
//                return isSetNtf_person();
//            case NTF_DAY:
//                return isSetNtf_day();
//            case NTF_TIME:
//                return isSetNtf_time();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBUserNotifyMsg)) {
//            return equals((BBUserNotifyMsg) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserNotifyMsg bBUserNotifyMsg) {
//        if (bBUserNotifyMsg == null || this.ntf_id != bBUserNotifyMsg.ntf_id) {
//            return false;
//        }
//        boolean isSetNtf_content = isSetNtf_content();
//        boolean isSetNtf_content2 = bBUserNotifyMsg.isSetNtf_content();
//        if ((isSetNtf_content || isSetNtf_content2) && (!isSetNtf_content || !isSetNtf_content2 || !this.ntf_content.equals(bBUserNotifyMsg.ntf_content))) {
//            return false;
//        }
//        boolean isSetNtf_person = isSetNtf_person();
//        boolean isSetNtf_person2 = bBUserNotifyMsg.isSetNtf_person();
//        if ((isSetNtf_person || isSetNtf_person2) && (!isSetNtf_person || !isSetNtf_person2 || this.ntf_person != bBUserNotifyMsg.ntf_person)) {
//            return false;
//        }
//        boolean isSetNtf_day = isSetNtf_day();
//        boolean isSetNtf_day2 = bBUserNotifyMsg.isSetNtf_day();
//        if ((isSetNtf_day || isSetNtf_day2) && (!isSetNtf_day || !isSetNtf_day2 || this.ntf_day != bBUserNotifyMsg.ntf_day)) {
//            return false;
//        }
//        boolean isSetNtf_time = isSetNtf_time();
//        boolean isSetNtf_time2 = bBUserNotifyMsg.isSetNtf_time();
//        if ((isSetNtf_time || isSetNtf_time2) && (!isSetNtf_time || !isSetNtf_time2 || this.ntf_time != bBUserNotifyMsg.ntf_time)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserNotifyMsg bBUserNotifyMsg) {
//        if (!getClass().equals(bBUserNotifyMsg.getClass())) {
//            return getClass().getName().compareTo(bBUserNotifyMsg.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetNtf_id()).compareTo(Boolean.valueOf(bBUserNotifyMsg.isSetNtf_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetNtf_id()) {
//            int a = C2121h.m5522a(this.ntf_id, bBUserNotifyMsg.ntf_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetNtf_content()).compareTo(Boolean.valueOf(bBUserNotifyMsg.isSetNtf_content()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetNtf_content()) {
//            int a2 = C2121h.m5525a(this.ntf_content, bBUserNotifyMsg.ntf_content);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetNtf_person()).compareTo(Boolean.valueOf(bBUserNotifyMsg.isSetNtf_person()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetNtf_person()) {
//            int a3 = C2121h.m5522a(this.ntf_person, bBUserNotifyMsg.ntf_person);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetNtf_day()).compareTo(Boolean.valueOf(bBUserNotifyMsg.isSetNtf_day()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetNtf_day()) {
//            int a4 = C2121h.m5522a(this.ntf_day, bBUserNotifyMsg.ntf_day);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetNtf_time()).compareTo(Boolean.valueOf(bBUserNotifyMsg.isSetNtf_time()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetNtf_time()) {
//            int a5 = C2121h.m5523a(this.ntf_time, bBUserNotifyMsg.ntf_time);
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
//        StringBuilder sb = new StringBuilder("BBUserNotifyMsg(");
//        sb.append("ntf_id:");
//        sb.append(this.ntf_id);
//        if (isSetNtf_content()) {
//            sb.append(", ");
//            sb.append("ntf_content:");
//            if (this.ntf_content == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.ntf_content);
//            }
//        }
//        if (isSetNtf_person()) {
//            sb.append(", ");
//            sb.append("ntf_person:");
//            sb.append(this.ntf_person);
//        }
//        if (isSetNtf_day()) {
//            sb.append(", ");
//            sb.append("ntf_day:");
//            sb.append(this.ntf_day);
//        }
//        if (isSetNtf_time()) {
//            sb.append(", ");
//            sb.append("ntf_time:");
//            sb.append(this.ntf_time);
//        }
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
