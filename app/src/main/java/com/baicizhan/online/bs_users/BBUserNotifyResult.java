//package com.baicizhan.online.bs_users;
//
//import com.p052e.p053a.p054a.JceStruct;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.EnumMap;
//import java.util.EnumSet;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import org.p100a.p101a.C2116f;
//import org.p100a.p101a.C2121h;
//import org.p100a.p101a.C2123l;
//import org.p100a.p101a.C2124m;
//import org.p100a.p101a.p103b.C2091a;
//import org.p100a.p101a.p103b.C2093c;
//import org.p100a.p101a.p103b.C2095e;
//import org.p100a.p101a.p104c.C2096a;
//import org.p100a.p101a.p104c.C2097b;
//import org.p100a.p101a.p104c.C2098c;
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
//public class BBUserNotifyResult implements Serializable, Cloneable, Comparable<BBUserNotifyResult>, C2116f<BBUserNotifyResult, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b NOTIFY_MSG_FIELD_DESC = new C2097b("notify_msg", 15, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b NOTIFY_SETTING_FIELD_DESC = new C2097b("notify_setting", JceStruct.ZERO_TAG, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBUserNotifyResult");
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public List<BBUserNotifyMsg> notify_msg;
//    public BBUserNotifySetting notify_setting;
//
//    class BBUserNotifyResultStandardScheme extends C2110c<BBUserNotifyResult> {
//        private BBUserNotifyResultStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBUserNotifyResult bBUserNotifyResult) {
//            fVar.mo18504e();
//            while (true) {
//                C2097b g = fVar.mo18506g();
//                if (g.f5835b != 0) {
//                    switch (g.f5836c) {
//                        case 1:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i = fVar.mo18508i();
//                                bBUserNotifyResult.notify_msg = new ArrayList(i.f5838b);
//                                for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                    BBUserNotifyMsg bBUserNotifyMsg = new BBUserNotifyMsg();
//                                    bBUserNotifyMsg.read(fVar);
//                                    bBUserNotifyResult.notify_msg.add(bBUserNotifyMsg);
//                                }
//                                bBUserNotifyResult.setNotify_msgIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 12) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBUserNotifyResult.notify_setting = new BBUserNotifySetting();
//                                bBUserNotifyResult.notify_setting.read(fVar);
//                                bBUserNotifyResult.setNotify_settingIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBUserNotifyResult.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBUserNotifyResult bBUserNotifyResult) {
//            bBUserNotifyResult.validate();
//            BBUserNotifyResult.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBUserNotifyResult.notify_msg != null) {
//                fVar.mo18496a(BBUserNotifyResult.NOTIFY_MSG_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, bBUserNotifyResult.notify_msg.size()));
//                for (BBUserNotifyMsg write : bBUserNotifyResult.notify_msg) {
//                    write.write(fVar);
//                }
//            }
//            if (bBUserNotifyResult.notify_setting != null) {
//                fVar.mo18496a(BBUserNotifyResult.NOTIFY_SETTING_FIELD_DESC);
//                bBUserNotifyResult.notify_setting.write(fVar);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBUserNotifyResultStandardSchemeFactory implements C2109b {
//        private BBUserNotifyResultStandardSchemeFactory() {
//        }
//
//        public BBUserNotifyResultStandardScheme getScheme() {
//            return new BBUserNotifyResultStandardScheme();
//        }
//    }
//
//    class BBUserNotifyResultTupleScheme extends C2111d<BBUserNotifyResult> {
//        private BBUserNotifyResultTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBUserNotifyResult bBUserNotifyResult) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBUserNotifyResult.notify_msg.size());
//            for (BBUserNotifyMsg write : bBUserNotifyResult.notify_msg) {
//                write.write(lVar);
//            }
//            bBUserNotifyResult.notify_setting.write(lVar);
//        }
//
//        public void read(C2100f fVar, BBUserNotifyResult bBUserNotifyResult) {
//            C2106l lVar = (C2106l) fVar;
//            C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//            bBUserNotifyResult.notify_msg = new ArrayList(cVar.f5838b);
//            for (int i = 0; i < cVar.f5838b; i++) {
//                BBUserNotifyMsg bBUserNotifyMsg = new BBUserNotifyMsg();
//                bBUserNotifyMsg.read(lVar);
//                bBUserNotifyResult.notify_msg.add(bBUserNotifyMsg);
//            }
//            bBUserNotifyResult.setNotify_msgIsSet(true);
//            bBUserNotifyResult.notify_setting = new BBUserNotifySetting();
//            bBUserNotifyResult.notify_setting.read(lVar);
//            bBUserNotifyResult.setNotify_settingIsSet(true);
//        }
//    }
//
//    class BBUserNotifyResultTupleSchemeFactory implements C2109b {
//        private BBUserNotifyResultTupleSchemeFactory() {
//        }
//
//        public BBUserNotifyResultTupleScheme getScheme() {
//            return new BBUserNotifyResultTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        NOTIFY_MSG(1, "notify_msg"),
//        NOTIFY_SETTING(2, "notify_setting");
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
//                    return NOTIFY_MSG;
//                case 2:
//                    return NOTIFY_SETTING;
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
//        hashMap.put(C2110c.class, new BBUserNotifyResultStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBUserNotifyResultTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.NOTIFY_MSG, new C2091a("notify_msg", 1, new C2093c(new C2095e(BBUserNotifyMsg.class))));
//        enumMap.put(_Fields.NOTIFY_SETTING, new C2091a("notify_setting", 1, new C2095e(BBUserNotifySetting.class)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBUserNotifyResult.class, metaDataMap);
//    }
//
//    public BBUserNotifyResult() {
//    }
//
//    public BBUserNotifyResult(List<BBUserNotifyMsg> list, BBUserNotifySetting bBUserNotifySetting) {
//        this();
//        this.notify_msg = list;
//        this.notify_setting = bBUserNotifySetting;
//    }
//
//    public BBUserNotifyResult(BBUserNotifyResult bBUserNotifyResult) {
//        if (bBUserNotifyResult.isSetNotify_msg()) {
//            ArrayList arrayList = new ArrayList(bBUserNotifyResult.notify_msg.size());
//            for (BBUserNotifyMsg bBUserNotifyMsg : bBUserNotifyResult.notify_msg) {
//                arrayList.add(new BBUserNotifyMsg(bBUserNotifyMsg));
//            }
//            this.notify_msg = arrayList;
//        }
//        if (bBUserNotifyResult.isSetNotify_setting()) {
//            this.notify_setting = new BBUserNotifySetting(bBUserNotifyResult.notify_setting);
//        }
//    }
//
//    public BBUserNotifyResult deepCopy() {
//        return new BBUserNotifyResult(this);
//    }
//
//    public void clear() {
//        this.notify_msg = null;
//        this.notify_setting = null;
//    }
//
//    public int getNotify_msgSize() {
//        if (this.notify_msg == null) {
//            return 0;
//        }
//        return this.notify_msg.size();
//    }
//
//    public Iterator<BBUserNotifyMsg> getNotify_msgIterator() {
//        if (this.notify_msg == null) {
//            return null;
//        }
//        return this.notify_msg.iterator();
//    }
//
//    public void addToNotify_msg(BBUserNotifyMsg bBUserNotifyMsg) {
//        if (this.notify_msg == null) {
//            this.notify_msg = new ArrayList();
//        }
//        this.notify_msg.add(bBUserNotifyMsg);
//    }
//
//    public List<BBUserNotifyMsg> getNotify_msg() {
//        return this.notify_msg;
//    }
//
//    public BBUserNotifyResult setNotify_msg(List<BBUserNotifyMsg> list) {
//        this.notify_msg = list;
//        return this;
//    }
//
//    public void unsetNotify_msg() {
//        this.notify_msg = null;
//    }
//
//    public boolean isSetNotify_msg() {
//        return this.notify_msg != null;
//    }
//
//    public void setNotify_msgIsSet(boolean z) {
//        if (!z) {
//            this.notify_msg = null;
//        }
//    }
//
//    public BBUserNotifySetting getNotify_setting() {
//        return this.notify_setting;
//    }
//
//    public BBUserNotifyResult setNotify_setting(BBUserNotifySetting bBUserNotifySetting) {
//        this.notify_setting = bBUserNotifySetting;
//        return this;
//    }
//
//    public void unsetNotify_setting() {
//        this.notify_setting = null;
//    }
//
//    public boolean isSetNotify_setting() {
//        return this.notify_setting != null;
//    }
//
//    public void setNotify_settingIsSet(boolean z) {
//        if (!z) {
//            this.notify_setting = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case NOTIFY_MSG:
//                if (obj == null) {
//                    unsetNotify_msg();
//                    return;
//                } else {
//                    setNotify_msg((List) obj);
//                    return;
//                }
//            case NOTIFY_SETTING:
//                if (obj == null) {
//                    unsetNotify_setting();
//                    return;
//                } else {
//                    setNotify_setting((BBUserNotifySetting) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case NOTIFY_MSG:
//                return getNotify_msg();
//            case NOTIFY_SETTING:
//                return getNotify_setting();
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
//            case NOTIFY_MSG:
//                return isSetNotify_msg();
//            case NOTIFY_SETTING:
//                return isSetNotify_setting();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBUserNotifyResult)) {
//            return equals((BBUserNotifyResult) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBUserNotifyResult bBUserNotifyResult) {
//        if (bBUserNotifyResult == null) {
//            return false;
//        }
//        boolean isSetNotify_msg = isSetNotify_msg();
//        boolean isSetNotify_msg2 = bBUserNotifyResult.isSetNotify_msg();
//        if ((isSetNotify_msg || isSetNotify_msg2) && (!isSetNotify_msg || !isSetNotify_msg2 || !this.notify_msg.equals(bBUserNotifyResult.notify_msg))) {
//            return false;
//        }
//        boolean isSetNotify_setting = isSetNotify_setting();
//        boolean isSetNotify_setting2 = bBUserNotifyResult.isSetNotify_setting();
//        if ((isSetNotify_setting || isSetNotify_setting2) && (!isSetNotify_setting || !isSetNotify_setting2 || !this.notify_setting.equals(bBUserNotifyResult.notify_setting))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBUserNotifyResult bBUserNotifyResult) {
//        if (!getClass().equals(bBUserNotifyResult.getClass())) {
//            return getClass().getName().compareTo(bBUserNotifyResult.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetNotify_msg()).compareTo(Boolean.valueOf(bBUserNotifyResult.isSetNotify_msg()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetNotify_msg()) {
//            int a = C2121h.m5526a((List) this.notify_msg, (List) bBUserNotifyResult.notify_msg);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetNotify_setting()).compareTo(Boolean.valueOf(bBUserNotifyResult.isSetNotify_setting()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetNotify_setting()) {
//            int a2 = C2121h.m5524a((Comparable) this.notify_setting, (Comparable) bBUserNotifyResult.notify_setting);
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
//        StringBuilder sb = new StringBuilder("BBUserNotifyResult(");
//        sb.append("notify_msg:");
//        if (this.notify_msg == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.notify_msg);
//        }
//        sb.append(", ");
//        sb.append("notify_setting:");
//        if (this.notify_setting == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.notify_setting);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.notify_msg == null) {
//            throw new C2101g("Required field 'notify_msg' was not present! Struct: " + toString());
//        } else if (this.notify_setting == null) {
//            throw new C2101g("Required field 'notify_setting' was not present! Struct: " + toString());
//        } else if (this.notify_setting != null) {
//            this.notify_setting.validate();
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
