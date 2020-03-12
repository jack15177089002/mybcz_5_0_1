//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.BOOK_TS_OFFLINE_ROAD_MAP_IDS.Columns;
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
//import org.p100a.p101a.C2090b;
//import org.p100a.p101a.C2116f;
//import org.p100a.p101a.C2121h;
//import org.p100a.p101a.C2123l;
//import org.p100a.p101a.C2124m;
//import org.p100a.p101a.p103b.C2091a;
//import org.p100a.p101a.p103b.C2092b;
//import org.p100a.p101a.p103b.C2093c;
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
//public class BBRoadMapElement implements Serializable, Cloneable, Comparable<BBRoadMapElement>, C2116f<BBRoadMapElement, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b OPTIONS_FIELD_DESC = new C2097b(Columns.OPTIONS, 15, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBRoadMapElement");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public List<Integer> options;
//    public int topic_id;
//
//    class BBRoadMapElementStandardScheme extends C2110c<BBRoadMapElement> {
//        private BBRoadMapElementStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBRoadMapElement bBRoadMapElement) {
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
//                                bBRoadMapElement.topic_id = fVar.mo18513n();
//                                bBRoadMapElement.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i = fVar.mo18508i();
//                                bBRoadMapElement.options = new ArrayList(i.f5838b);
//                                for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                    bBRoadMapElement.options.add(Integer.valueOf(fVar.mo18513n()));
//                                }
//                                bBRoadMapElement.setOptionsIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBRoadMapElement.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBRoadMapElement.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBRoadMapElement bBRoadMapElement) {
//            bBRoadMapElement.validate();
//            BBRoadMapElement.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBRoadMapElement.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBRoadMapElement.topic_id);
//            if (bBRoadMapElement.options != null) {
//                fVar.mo18496a(BBRoadMapElement.OPTIONS_FIELD_DESC);
//                fVar.mo18497a(new C2098c(8, bBRoadMapElement.options.size()));
//                for (Integer intValue : bBRoadMapElement.options) {
//                    fVar.mo18493a(intValue.intValue());
//                }
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBRoadMapElementStandardSchemeFactory implements C2109b {
//        private BBRoadMapElementStandardSchemeFactory() {
//        }
//
//        public BBRoadMapElementStandardScheme getScheme() {
//            return new BBRoadMapElementStandardScheme();
//        }
//    }
//
//    class BBRoadMapElementTupleScheme extends C2111d<BBRoadMapElement> {
//        private BBRoadMapElementTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBRoadMapElement bBRoadMapElement) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBRoadMapElement.topic_id);
//            lVar.mo18493a(bBRoadMapElement.options.size());
//            for (Integer intValue : bBRoadMapElement.options) {
//                lVar.mo18493a(intValue.intValue());
//            }
//        }
//
//        public void read(C2100f fVar, BBRoadMapElement bBRoadMapElement) {
//            C2106l lVar = (C2106l) fVar;
//            bBRoadMapElement.topic_id = lVar.mo18513n();
//            bBRoadMapElement.setTopic_idIsSet(true);
//            C2098c cVar = new C2098c(8, lVar.mo18513n());
//            bBRoadMapElement.options = new ArrayList(cVar.f5838b);
//            for (int i = 0; i < cVar.f5838b; i++) {
//                bBRoadMapElement.options.add(Integer.valueOf(lVar.mo18513n()));
//            }
//            bBRoadMapElement.setOptionsIsSet(true);
//        }
//    }
//
//    class BBRoadMapElementTupleSchemeFactory implements C2109b {
//        private BBRoadMapElementTupleSchemeFactory() {
//        }
//
//        public BBRoadMapElementTupleScheme getScheme() {
//            return new BBRoadMapElementTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        OPTIONS(2, Columns.OPTIONS);
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
//                    return OPTIONS;
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
//        hashMap.put(C2110c.class, new BBRoadMapElementStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBRoadMapElementTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.OPTIONS, new C2091a(Columns.OPTIONS, 1, new C2093c(new C2092b(8, 0))));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBRoadMapElement.class, metaDataMap);
//    }
//
//    public BBRoadMapElement() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBRoadMapElement(int i, List<Integer> list) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.options = list;
//    }
//
//    public BBRoadMapElement(BBRoadMapElement bBRoadMapElement) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBRoadMapElement.__isset_bitfield;
//        this.topic_id = bBRoadMapElement.topic_id;
//        if (bBRoadMapElement.isSetOptions()) {
//            this.options = new ArrayList(bBRoadMapElement.options);
//        }
//    }
//
//    public BBRoadMapElement deepCopy() {
//        return new BBRoadMapElement(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        this.options = null;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBRoadMapElement setTopic_id(int i) {
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
//    public int getOptionsSize() {
//        if (this.options == null) {
//            return 0;
//        }
//        return this.options.size();
//    }
//
//    public Iterator<Integer> getOptionsIterator() {
//        if (this.options == null) {
//            return null;
//        }
//        return this.options.iterator();
//    }
//
//    public void addToOptions(int i) {
//        if (this.options == null) {
//            this.options = new ArrayList();
//        }
//        this.options.add(Integer.valueOf(i));
//    }
//
//    public List<Integer> getOptions() {
//        return this.options;
//    }
//
//    public BBRoadMapElement setOptions(List<Integer> list) {
//        this.options = list;
//        return this;
//    }
//
//    public void unsetOptions() {
//        this.options = null;
//    }
//
//    public boolean isSetOptions() {
//        return this.options != null;
//    }
//
//    public void setOptionsIsSet(boolean z) {
//        if (!z) {
//            this.options = null;
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
//            case OPTIONS:
//                if (obj == null) {
//                    unsetOptions();
//                    return;
//                } else {
//                    setOptions((List) obj);
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
//            case OPTIONS:
//                return getOptions();
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
//            case OPTIONS:
//                return isSetOptions();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBRoadMapElement)) {
//            return equals((BBRoadMapElement) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBRoadMapElement bBRoadMapElement) {
//        if (bBRoadMapElement == null || this.topic_id != bBRoadMapElement.topic_id) {
//            return false;
//        }
//        boolean isSetOptions = isSetOptions();
//        boolean isSetOptions2 = bBRoadMapElement.isSetOptions();
//        if ((isSetOptions || isSetOptions2) && (!isSetOptions || !isSetOptions2 || !this.options.equals(bBRoadMapElement.options))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBRoadMapElement bBRoadMapElement) {
//        if (!getClass().equals(bBRoadMapElement.getClass())) {
//            return getClass().getName().compareTo(bBRoadMapElement.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBRoadMapElement.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBRoadMapElement.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetOptions()).compareTo(Boolean.valueOf(bBRoadMapElement.isSetOptions()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetOptions()) {
//            int a2 = C2121h.m5526a((List) this.options, (List) bBRoadMapElement.options);
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
//        StringBuilder sb = new StringBuilder("BBRoadMapElement(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("options:");
//        if (this.options == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.options);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.options == null) {
//            throw new C2101g("Required field 'options' was not present! Struct: " + toString());
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
