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
//public class BBSubCategory implements Serializable, Cloneable, Comparable<BBSubCategory>, C2116f<BBSubCategory, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b BOOK_IDS_FIELD_DESC = new C2097b("book_ids", 15, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBSubCategory");
//    /* access modifiers changed from: private */
//    public static final C2097b SUB_NAME_FIELD_DESC = new C2097b("sub_name", JceStruct.STRUCT_END, 1);
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public List<Integer> book_ids;
//    public String sub_name;
//
//    class BBSubCategoryStandardScheme extends C2110c<BBSubCategory> {
//        private BBSubCategoryStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBSubCategory bBSubCategory) {
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
//                                bBSubCategory.sub_name = fVar.mo18516q();
//                                bBSubCategory.setSub_nameIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i = fVar.mo18508i();
//                                bBSubCategory.book_ids = new ArrayList(i.f5838b);
//                                for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                    bBSubCategory.book_ids.add(Integer.valueOf(fVar.mo18513n()));
//                                }
//                                bBSubCategory.setBook_idsIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBSubCategory.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBSubCategory bBSubCategory) {
//            bBSubCategory.validate();
//            BBSubCategory.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBSubCategory.sub_name != null) {
//                fVar.mo18496a(BBSubCategory.SUB_NAME_FIELD_DESC);
//                fVar.mo18495a(bBSubCategory.sub_name);
//            }
//            if (bBSubCategory.book_ids != null) {
//                fVar.mo18496a(BBSubCategory.BOOK_IDS_FIELD_DESC);
//                fVar.mo18497a(new C2098c(8, bBSubCategory.book_ids.size()));
//                for (Integer intValue : bBSubCategory.book_ids) {
//                    fVar.mo18493a(intValue.intValue());
//                }
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBSubCategoryStandardSchemeFactory implements C2109b {
//        private BBSubCategoryStandardSchemeFactory() {
//        }
//
//        public BBSubCategoryStandardScheme getScheme() {
//            return new BBSubCategoryStandardScheme();
//        }
//    }
//
//    class BBSubCategoryTupleScheme extends C2111d<BBSubCategory> {
//        private BBSubCategoryTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBSubCategory bBSubCategory) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBSubCategory.sub_name);
//            lVar.mo18493a(bBSubCategory.book_ids.size());
//            for (Integer intValue : bBSubCategory.book_ids) {
//                lVar.mo18493a(intValue.intValue());
//            }
//        }
//
//        public void read(C2100f fVar, BBSubCategory bBSubCategory) {
//            C2106l lVar = (C2106l) fVar;
//            bBSubCategory.sub_name = lVar.mo18516q();
//            bBSubCategory.setSub_nameIsSet(true);
//            C2098c cVar = new C2098c(8, lVar.mo18513n());
//            bBSubCategory.book_ids = new ArrayList(cVar.f5838b);
//            for (int i = 0; i < cVar.f5838b; i++) {
//                bBSubCategory.book_ids.add(Integer.valueOf(lVar.mo18513n()));
//            }
//            bBSubCategory.setBook_idsIsSet(true);
//        }
//    }
//
//    class BBSubCategoryTupleSchemeFactory implements C2109b {
//        private BBSubCategoryTupleSchemeFactory() {
//        }
//
//        public BBSubCategoryTupleScheme getScheme() {
//            return new BBSubCategoryTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        SUB_NAME(1, "sub_name"),
//        BOOK_IDS(2, "book_ids");
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
//                    return SUB_NAME;
//                case 2:
//                    return BOOK_IDS;
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
//        hashMap.put(C2110c.class, new BBSubCategoryStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBSubCategoryTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.SUB_NAME, new C2091a("sub_name", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.BOOK_IDS, new C2091a("book_ids", 1, new C2093c(new C2092b(8, 0))));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBSubCategory.class, metaDataMap);
//    }
//
//    public BBSubCategory() {
//    }
//
//    public BBSubCategory(String str, List<Integer> list) {
//        this();
//        this.sub_name = str;
//        this.book_ids = list;
//    }
//
//    public BBSubCategory(BBSubCategory bBSubCategory) {
//        if (bBSubCategory.isSetSub_name()) {
//            this.sub_name = bBSubCategory.sub_name;
//        }
//        if (bBSubCategory.isSetBook_ids()) {
//            this.book_ids = new ArrayList(bBSubCategory.book_ids);
//        }
//    }
//
//    public BBSubCategory deepCopy() {
//        return new BBSubCategory(this);
//    }
//
//    public void clear() {
//        this.sub_name = null;
//        this.book_ids = null;
//    }
//
//    public String getSub_name() {
//        return this.sub_name;
//    }
//
//    public BBSubCategory setSub_name(String str) {
//        this.sub_name = str;
//        return this;
//    }
//
//    public void unsetSub_name() {
//        this.sub_name = null;
//    }
//
//    public boolean isSetSub_name() {
//        return this.sub_name != null;
//    }
//
//    public void setSub_nameIsSet(boolean z) {
//        if (!z) {
//            this.sub_name = null;
//        }
//    }
//
//    public int getBook_idsSize() {
//        if (this.book_ids == null) {
//            return 0;
//        }
//        return this.book_ids.size();
//    }
//
//    public Iterator<Integer> getBook_idsIterator() {
//        if (this.book_ids == null) {
//            return null;
//        }
//        return this.book_ids.iterator();
//    }
//
//    public void addToBook_ids(int i) {
//        if (this.book_ids == null) {
//            this.book_ids = new ArrayList();
//        }
//        this.book_ids.add(Integer.valueOf(i));
//    }
//
//    public List<Integer> getBook_ids() {
//        return this.book_ids;
//    }
//
//    public BBSubCategory setBook_ids(List<Integer> list) {
//        this.book_ids = list;
//        return this;
//    }
//
//    public void unsetBook_ids() {
//        this.book_ids = null;
//    }
//
//    public boolean isSetBook_ids() {
//        return this.book_ids != null;
//    }
//
//    public void setBook_idsIsSet(boolean z) {
//        if (!z) {
//            this.book_ids = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case SUB_NAME:
//                if (obj == null) {
//                    unsetSub_name();
//                    return;
//                } else {
//                    setSub_name((String) obj);
//                    return;
//                }
//            case BOOK_IDS:
//                if (obj == null) {
//                    unsetBook_ids();
//                    return;
//                } else {
//                    setBook_ids((List) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case SUB_NAME:
//                return getSub_name();
//            case BOOK_IDS:
//                return getBook_ids();
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
//            case SUB_NAME:
//                return isSetSub_name();
//            case BOOK_IDS:
//                return isSetBook_ids();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBSubCategory)) {
//            return equals((BBSubCategory) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBSubCategory bBSubCategory) {
//        if (bBSubCategory == null) {
//            return false;
//        }
//        boolean isSetSub_name = isSetSub_name();
//        boolean isSetSub_name2 = bBSubCategory.isSetSub_name();
//        if ((isSetSub_name || isSetSub_name2) && (!isSetSub_name || !isSetSub_name2 || !this.sub_name.equals(bBSubCategory.sub_name))) {
//            return false;
//        }
//        boolean isSetBook_ids = isSetBook_ids();
//        boolean isSetBook_ids2 = bBSubCategory.isSetBook_ids();
//        if ((isSetBook_ids || isSetBook_ids2) && (!isSetBook_ids || !isSetBook_ids2 || !this.book_ids.equals(bBSubCategory.book_ids))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBSubCategory bBSubCategory) {
//        if (!getClass().equals(bBSubCategory.getClass())) {
//            return getClass().getName().compareTo(bBSubCategory.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetSub_name()).compareTo(Boolean.valueOf(bBSubCategory.isSetSub_name()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetSub_name()) {
//            int a = C2121h.m5525a(this.sub_name, bBSubCategory.sub_name);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetBook_ids()).compareTo(Boolean.valueOf(bBSubCategory.isSetBook_ids()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetBook_ids()) {
//            int a2 = C2121h.m5526a((List) this.book_ids, (List) bBSubCategory.book_ids);
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
//        StringBuilder sb = new StringBuilder("BBSubCategory(");
//        sb.append("sub_name:");
//        if (this.sub_name == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.sub_name);
//        }
//        sb.append(", ");
//        sb.append("book_ids:");
//        if (this.book_ids == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.book_ids);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.sub_name == null) {
//            throw new C2101g("Required field 'sub_name' was not present! Struct: " + toString());
//        } else if (this.book_ids == null) {
//            throw new C2101g("Required field 'book_ids' was not present! Struct: " + toString());
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
