//package com.baicizhan.online.bs_users;
//
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
//public class BBUserNotifySetting implements Serializable, Cloneable, Comparable<BBUserNotifySetting>, C2116f<BBUserNotifySetting, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserNotifySetting");
//    /* access modifiers changed from: private */
//    public static final C2097b USE_NOTIFY_FIELD_DESC = new C2097b("use_notify", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b USE_TIME_FIELD_DESC = new C2097b("use_time", 10, 2);
//    private static final int __USE_NOTIFY_ISSET_ID = 0;
//    private static final int __USE_TIME_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    private _Fields[] optionals;
//    public int use_notify;
//    public long use_time;
//
//    class BBUserNotifySettingStandardScheme extends C2110c<BBUserNotifySetting> {
//        private BBUserNotifySettingStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserNotifySetting bBUserNotifySetting) {
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
//                                bBUserNotifySetting.use_notify = fVar.mo18513n();
//                                bBUserNotifySetting.setUse_notifyIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserNotifySetting.use_time = fVar.mo18514o();
//                                bBUserNotifySetting.setUse_timeIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBUserNotifySetting.isSetUse_notify()) {
//                        throw new C2101g("Required field 'use_notify' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBUserNotifySetting.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserNotifySetting bBUserNotifySetting) {
//            bBUserNotifySetting.validate();
//            BBUserNotifySetting.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBUserNotifySetting.USE_NOTIFY_FIELD_DESC);
//            fVar.mo18493a(bBUserNotifySetting.use_notify);
//            if (bBUserNotifySetting.isSetUse_time()) {
//                fVar.mo18496a(BBUserNotifySetting.USE_TIME_FIELD_DESC);
//                fVar.mo18494a(bBUserNotifySetting.use_time);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserNotifySettingStandardSchemeFactory implements C2109b {
//        private BBUserNotifySettingStandardSchemeFactory() {
//        }
//
//        public BBUserNotifySettingStandardScheme getScheme() {
//            return new BBUserNotifySettingStandardScheme();
//        }
//    }
//
//    class BBUserNotifySettingTupleScheme extends C2111d<BBUserNotifySetting> {
//        private BBUserNotifySettingTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserNotifySetting bBUserNotifySetting) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBUserNotifySetting.use_notify);
//            BitSet bitSet = new BitSet();
//            if (bBUserNotifySetting.isSetUse_time()) {
//                bitSet.set(0);
//            }
//            lVar.mo18527a(bitSet, 1);
//            if (bBUserNotifySetting.isSetUse_time()) {
//                lVar.mo18494a(bBUserNotifySetting.use_time);
//            }
//        }
//
//        public void read(C2100f fVar, BBUserNotifySetting bBUserNotifySetting) {
//            C2106l lVar = (C2106l) fVar;
//            bBUserNotifySetting.use_notify = lVar.mo18513n();
//            bBUserNotifySetting.setUse_notifyIsSet(true);
//            if (lVar.mo18528b(1).get(0)) {
//                bBUserNotifySetting.use_time = lVar.mo18514o();
//                bBUserNotifySetting.setUse_timeIsSet(true);
//            }
//        }
//    }
//
//    class BBUserNotifySettingTupleSchemeFactory implements C2109b {
//        private BBUserNotifySettingTupleSchemeFactory() {
//        }
//
//        public BBUserNotifySettingTupleScheme getScheme() {
//            return new BBUserNotifySettingTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        USE_NOTIFY(1, "use_notify"),
//        USE_TIME(2, "use_time");
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
//                    return USE_NOTIFY;
//                case 2:
//                    return USE_TIME;
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
//        hashMap.put(C2110c.class, new BBUserNotifySettingStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserNotifySettingTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.USE_NOTIFY, new C2091a("use_notify", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.USE_TIME, new C2091a("use_time", 2, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserNotifySetting.class, metaDataMap);
//    }
//
//    public BBUserNotifySetting() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.USE_TIME};
//    }
//
//    public BBUserNotifySetting(int i) {
//        this();
//        this.use_notify = i;
//        setUse_notifyIsSet(true);
//    }
//
//    public BBUserNotifySetting(BBUserNotifySetting bBUserNotifySetting) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.USE_TIME};
//        this.__isset_bitfield = bBUserNotifySetting.__isset_bitfield;
//        this.use_notify = bBUserNotifySetting.use_notify;
//        this.use_time = bBUserNotifySetting.use_time;
//    }
//
//    public BBUserNotifySetting deepCopy() {
//        return new BBUserNotifySetting(this);
//    }
//
//    public void clear() {
//        setUse_notifyIsSet(false);
//        this.use_notify = 0;
//        setUse_timeIsSet(false);
//        this.use_time = 0;
//    }
//
//    public int getUse_notify() {
//        return this.use_notify;
//    }
//
//    public BBUserNotifySetting setUse_notify(int i) {
//        this.use_notify = i;
//        setUse_notifyIsSet(true);
//        return this;
//    }
//
//    public void unsetUse_notify() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetUse_notify() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setUse_notifyIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public long getUse_time() {
//        return this.use_time;
//    }
//
//    public BBUserNotifySetting setUse_time(long j) {
//        this.use_time = j;
//        setUse_timeIsSet(true);
//        return this;
//    }
//
//    public void unsetUse_time() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetUse_time() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setUse_timeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case USE_NOTIFY:
//                if (obj == null) {
//                    unsetUse_notify();
//                    return;
//                } else {
//                    setUse_notify(((Integer) obj).intValue());
//                    return;
//                }
//            case USE_TIME:
//                if (obj == null) {
//                    unsetUse_time();
//                    return;
//                } else {
//                    setUse_time(((Long) obj).longValue());
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case USE_NOTIFY:
//                return Integer.valueOf(getUse_notify());
//            case USE_TIME:
//                return Long.valueOf(getUse_time());
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
//            case USE_NOTIFY:
//                return isSetUse_notify();
//            case USE_TIME:
//                return isSetUse_time();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBUserNotifySetting)) {
//            return equals((BBUserNotifySetting) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserNotifySetting bBUserNotifySetting) {
//        if (bBUserNotifySetting == null || this.use_notify != bBUserNotifySetting.use_notify) {
//            return false;
//        }
//        boolean isSetUse_time = isSetUse_time();
//        boolean isSetUse_time2 = bBUserNotifySetting.isSetUse_time();
//        if ((isSetUse_time || isSetUse_time2) && (!isSetUse_time || !isSetUse_time2 || this.use_time != bBUserNotifySetting.use_time)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserNotifySetting bBUserNotifySetting) {
//        if (!getClass().equals(bBUserNotifySetting.getClass())) {
//            return getClass().getName().compareTo(bBUserNotifySetting.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetUse_notify()).compareTo(Boolean.valueOf(bBUserNotifySetting.isSetUse_notify()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetUse_notify()) {
//            int a = C2121h.m5522a(this.use_notify, bBUserNotifySetting.use_notify);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetUse_time()).compareTo(Boolean.valueOf(bBUserNotifySetting.isSetUse_time()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetUse_time()) {
//            int a2 = C2121h.m5523a(this.use_time, bBUserNotifySetting.use_time);
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
//        StringBuilder sb = new StringBuilder("BBUserNotifySetting(");
//        sb.append("use_notify:");
//        sb.append(this.use_notify);
//        if (isSetUse_time()) {
//            sb.append(", ");
//            sb.append("use_time:");
//            sb.append(this.use_time);
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
