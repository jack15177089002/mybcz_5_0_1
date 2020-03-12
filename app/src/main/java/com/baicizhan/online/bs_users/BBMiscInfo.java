//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
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
//import org.p100a.p101a.p104c.C2103i;
//import org.p100a.p101a.p104c.C2105k;
//import org.p100a.p101a.p104c.C2106l;
//import org.p100a.p101a.p105d.C2108a;
//import org.p100a.p101a.p105d.C2109b;
//import org.p100a.p101a.p105d.C2110c;
//import org.p100a.p101a.p105d.C2111d;
//import org.p100a.p101a.p107f.C2117b;
//
//public class BBMiscInfo implements Serializable, Cloneable, Comparable<BBMiscInfo>, C2116f<BBMiscInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b ID_FIELD_DESC = new C2097b(Columns.f2234ID, 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b LINK_FIELD_DESC = new C2097b("link", JceStruct.STRUCT_END, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b NAME_FIELD_DESC = new C2097b("name", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBMiscInfo");
//    private static final int __ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//
//    /* renamed from: id */
//    public int f2412id;
//    public String link;
//    public String name;
//
//    class BBMiscInfoStandardScheme extends C2110c<BBMiscInfo> {
//        private BBMiscInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBMiscInfo bBMiscInfo) {
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
//                                bBMiscInfo.f2412id = fVar.mo18513n();
//                                bBMiscInfo.setIdIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBMiscInfo.name = fVar.mo18516q();
//                                bBMiscInfo.setNameIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBMiscInfo.link = fVar.mo18516q();
//                                bBMiscInfo.setLinkIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBMiscInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBMiscInfo bBMiscInfo) {
//            bBMiscInfo.validate();
//            BBMiscInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBMiscInfo.ID_FIELD_DESC);
//            fVar.mo18493a(bBMiscInfo.f2412id);
//            if (bBMiscInfo.name != null) {
//                fVar.mo18496a(BBMiscInfo.NAME_FIELD_DESC);
//                fVar.mo18495a(bBMiscInfo.name);
//            }
//            if (bBMiscInfo.link != null) {
//                fVar.mo18496a(BBMiscInfo.LINK_FIELD_DESC);
//                fVar.mo18495a(bBMiscInfo.link);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBMiscInfoStandardSchemeFactory implements C2109b {
//        private BBMiscInfoStandardSchemeFactory() {
//        }
//
//        public BBMiscInfoStandardScheme getScheme() {
//            return new BBMiscInfoStandardScheme();
//        }
//    }
//
//    class BBMiscInfoTupleScheme extends C2111d<BBMiscInfo> {
//        private BBMiscInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBMiscInfo bBMiscInfo) {
//            C2106l lVar = (C2106l) fVar;
//            BitSet bitSet = new BitSet();
//            if (bBMiscInfo.isSetId()) {
//                bitSet.set(0);
//            }
//            if (bBMiscInfo.isSetName()) {
//                bitSet.set(1);
//            }
//            if (bBMiscInfo.isSetLink()) {
//                bitSet.set(2);
//            }
//            lVar.mo18527a(bitSet, 3);
//            if (bBMiscInfo.isSetId()) {
//                lVar.mo18493a(bBMiscInfo.f2412id);
//            }
//            if (bBMiscInfo.isSetName()) {
//                lVar.mo18495a(bBMiscInfo.name);
//            }
//            if (bBMiscInfo.isSetLink()) {
//                lVar.mo18495a(bBMiscInfo.link);
//            }
//        }
//
//        public void read(C2100f fVar, BBMiscInfo bBMiscInfo) {
//            C2106l lVar = (C2106l) fVar;
//            BitSet b = lVar.mo18528b(3);
//            if (b.get(0)) {
//                bBMiscInfo.f2412id = lVar.mo18513n();
//                bBMiscInfo.setIdIsSet(true);
//            }
//            if (b.get(1)) {
//                bBMiscInfo.name = lVar.mo18516q();
//                bBMiscInfo.setNameIsSet(true);
//            }
//            if (b.get(2)) {
//                bBMiscInfo.link = lVar.mo18516q();
//                bBMiscInfo.setLinkIsSet(true);
//            }
//        }
//    }
//
//    class BBMiscInfoTupleSchemeFactory implements C2109b {
//        private BBMiscInfoTupleSchemeFactory() {
//        }
//
//        public BBMiscInfoTupleScheme getScheme() {
//            return new BBMiscInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        ID(1, Columns.f2234ID),
//        NAME(2, "name"),
//        LINK(3, "link");
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
//                    return ID;
//                case 2:
//                    return NAME;
//                case 3:
//                    return LINK;
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
//        hashMap.put(C2110c.class, new BBMiscInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBMiscInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.ID, new C2091a(Columns.f2234ID, 3, new C2092b(8, 0)));
//        enumMap.put(_Fields.NAME, new C2091a("name", 3, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.LINK, new C2091a("link", 3, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBMiscInfo.class, metaDataMap);
//    }
//
//    public BBMiscInfo() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBMiscInfo(int i, String str, String str2) {
//        this();
//        this.f2412id = i;
//        setIdIsSet(true);
//        this.name = str;
//        this.link = str2;
//    }
//
//    public BBMiscInfo(BBMiscInfo bBMiscInfo) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBMiscInfo.__isset_bitfield;
//        this.f2412id = bBMiscInfo.f2412id;
//        if (bBMiscInfo.isSetName()) {
//            this.name = bBMiscInfo.name;
//        }
//        if (bBMiscInfo.isSetLink()) {
//            this.link = bBMiscInfo.link;
//        }
//    }
//
//    public BBMiscInfo deepCopy() {
//        return new BBMiscInfo(this);
//    }
//
//    public void clear() {
//        setIdIsSet(false);
//        this.f2412id = 0;
//        this.name = null;
//        this.link = null;
//    }
//
//    public int getId() {
//        return this.f2412id;
//    }
//
//    public BBMiscInfo setId(int i) {
//        this.f2412id = i;
//        setIdIsSet(true);
//        return this;
//    }
//
//    public void unsetId() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetId() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setIdIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public BBMiscInfo setName(String str) {
//        this.name = str;
//        return this;
//    }
//
//    public void unsetName() {
//        this.name = null;
//    }
//
//    public boolean isSetName() {
//        return this.name != null;
//    }
//
//    public void setNameIsSet(boolean z) {
//        if (!z) {
//            this.name = null;
//        }
//    }
//
//    public String getLink() {
//        return this.link;
//    }
//
//    public BBMiscInfo setLink(String str) {
//        this.link = str;
//        return this;
//    }
//
//    public void unsetLink() {
//        this.link = null;
//    }
//
//    public boolean isSetLink() {
//        return this.link != null;
//    }
//
//    public void setLinkIsSet(boolean z) {
//        if (!z) {
//            this.link = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case ID:
//                if (obj == null) {
//                    unsetId();
//                    return;
//                } else {
//                    setId(((Integer) obj).intValue());
//                    return;
//                }
//            case NAME:
//                if (obj == null) {
//                    unsetName();
//                    return;
//                } else {
//                    setName((String) obj);
//                    return;
//                }
//            case LINK:
//                if (obj == null) {
//                    unsetLink();
//                    return;
//                } else {
//                    setLink((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case ID:
//                return Integer.valueOf(getId());
//            case NAME:
//                return getName();
//            case LINK:
//                return getLink();
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
//            case ID:
//                return isSetId();
//            case NAME:
//                return isSetName();
//            case LINK:
//                return isSetLink();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBMiscInfo)) {
//            return equals((BBMiscInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBMiscInfo bBMiscInfo) {
//        if (bBMiscInfo == null || this.f2412id != bBMiscInfo.f2412id) {
//            return false;
//        }
//        boolean isSetName = isSetName();
//        boolean isSetName2 = bBMiscInfo.isSetName();
//        if ((isSetName || isSetName2) && (!isSetName || !isSetName2 || !this.name.equals(bBMiscInfo.name))) {
//            return false;
//        }
//        boolean isSetLink = isSetLink();
//        boolean isSetLink2 = bBMiscInfo.isSetLink();
//        if ((isSetLink || isSetLink2) && (!isSetLink || !isSetLink2 || !this.link.equals(bBMiscInfo.link))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBMiscInfo bBMiscInfo) {
//        if (!getClass().equals(bBMiscInfo.getClass())) {
//            return getClass().getName().compareTo(bBMiscInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetId()).compareTo(Boolean.valueOf(bBMiscInfo.isSetId()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetId()) {
//            int a = C2121h.m5522a(this.f2412id, bBMiscInfo.f2412id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetName()).compareTo(Boolean.valueOf(bBMiscInfo.isSetName()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetName()) {
//            int a2 = C2121h.m5525a(this.name, bBMiscInfo.name);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetLink()).compareTo(Boolean.valueOf(bBMiscInfo.isSetLink()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetLink()) {
//            int a3 = C2121h.m5525a(this.link, bBMiscInfo.link);
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
//        StringBuilder sb = new StringBuilder("BBMiscInfo(");
//        sb.append("id:");
//        sb.append(this.f2412id);
//        sb.append(", ");
//        sb.append("name:");
//        if (this.name == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.name);
//        }
//        sb.append(", ");
//        sb.append("link:");
//        if (this.link == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.link);
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
