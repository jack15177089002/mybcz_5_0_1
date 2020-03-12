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
//public class BBBookListInfo implements Serializable, Cloneable, Comparable<BBBookListInfo>, C2116f<BBBookListInfo, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b BOOKS_INFO_FIELD_DESC = new C2097b("books_info", 15, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b CATEGORIES_INFO_FIELD_DESC = new C2097b("categories_info", 15, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBBookListInfo");
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public List<BBBookBasicInfo> books_info;
//    public List<BBBookCategory> categories_info;
//
//    class BBBookListInfoStandardScheme extends C2110c<BBBookListInfo> {
//        private BBBookListInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBBookListInfo bBBookListInfo) {
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
//                                bBBookListInfo.books_info = new ArrayList(i.f5838b);
//                                for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                    BBBookBasicInfo bBBookBasicInfo = new BBBookBasicInfo();
//                                    bBBookBasicInfo.read(fVar);
//                                    bBBookListInfo.books_info.add(bBBookBasicInfo);
//                                }
//                                bBBookListInfo.setBooks_infoIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i3 = fVar.mo18508i();
//                                bBBookListInfo.categories_info = new ArrayList(i3.f5838b);
//                                for (int i4 = 0; i4 < i3.f5838b; i4++) {
//                                    BBBookCategory bBBookCategory = new BBBookCategory();
//                                    bBBookCategory.read(fVar);
//                                    bBBookListInfo.categories_info.add(bBBookCategory);
//                                }
//                                bBBookListInfo.setCategories_infoIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBBookListInfo.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBBookListInfo bBBookListInfo) {
//            bBBookListInfo.validate();
//            BBBookListInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBBookListInfo.books_info != null) {
//                fVar.mo18496a(BBBookListInfo.BOOKS_INFO_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, bBBookListInfo.books_info.size()));
//                for (BBBookBasicInfo write : bBBookListInfo.books_info) {
//                    write.write(fVar);
//                }
//            }
//            if (bBBookListInfo.categories_info != null) {
//                fVar.mo18496a(BBBookListInfo.CATEGORIES_INFO_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, bBBookListInfo.categories_info.size()));
//                for (BBBookCategory write2 : bBBookListInfo.categories_info) {
//                    write2.write(fVar);
//                }
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBBookListInfoStandardSchemeFactory implements C2109b {
//        private BBBookListInfoStandardSchemeFactory() {
//        }
//
//        public BBBookListInfoStandardScheme getScheme() {
//            return new BBBookListInfoStandardScheme();
//        }
//    }
//
//    class BBBookListInfoTupleScheme extends C2111d<BBBookListInfo> {
//        private BBBookListInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBBookListInfo bBBookListInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBBookListInfo.books_info.size());
//            for (BBBookBasicInfo write : bBBookListInfo.books_info) {
//                write.write(lVar);
//            }
//            lVar.mo18493a(bBBookListInfo.categories_info.size());
//            for (BBBookCategory write2 : bBBookListInfo.categories_info) {
//                write2.write(lVar);
//            }
//        }
//
//        public void read(C2100f fVar, BBBookListInfo bBBookListInfo) {
//            C2106l lVar = (C2106l) fVar;
//            C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//            bBBookListInfo.books_info = new ArrayList(cVar.f5838b);
//            for (int i = 0; i < cVar.f5838b; i++) {
//                BBBookBasicInfo bBBookBasicInfo = new BBBookBasicInfo();
//                bBBookBasicInfo.read(lVar);
//                bBBookListInfo.books_info.add(bBBookBasicInfo);
//            }
//            bBBookListInfo.setBooks_infoIsSet(true);
//            C2098c cVar2 = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//            bBBookListInfo.categories_info = new ArrayList(cVar2.f5838b);
//            for (int i2 = 0; i2 < cVar2.f5838b; i2++) {
//                BBBookCategory bBBookCategory = new BBBookCategory();
//                bBBookCategory.read(lVar);
//                bBBookListInfo.categories_info.add(bBBookCategory);
//            }
//            bBBookListInfo.setCategories_infoIsSet(true);
//        }
//    }
//
//    class BBBookListInfoTupleSchemeFactory implements C2109b {
//        private BBBookListInfoTupleSchemeFactory() {
//        }
//
//        public BBBookListInfoTupleScheme getScheme() {
//            return new BBBookListInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        BOOKS_INFO(1, "books_info"),
//        CATEGORIES_INFO(2, "categories_info");
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
//                    return BOOKS_INFO;
//                case 2:
//                    return CATEGORIES_INFO;
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
//        hashMap.put(C2110c.class, new BBBookListInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBBookListInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.BOOKS_INFO, new C2091a("books_info", 1, new C2093c(new C2095e(BBBookBasicInfo.class))));
//        enumMap.put(_Fields.CATEGORIES_INFO, new C2091a("categories_info", 1, new C2093c(new C2095e(BBBookCategory.class))));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBBookListInfo.class, metaDataMap);
//    }
//
//    public BBBookListInfo() {
//    }
//
//    public BBBookListInfo(List<BBBookBasicInfo> list, List<BBBookCategory> list2) {
//        this();
//        this.books_info = list;
//        this.categories_info = list2;
//    }
//
//    public BBBookListInfo(BBBookListInfo bBBookListInfo) {
//        if (bBBookListInfo.isSetBooks_info()) {
//            ArrayList arrayList = new ArrayList(bBBookListInfo.books_info.size());
//            for (BBBookBasicInfo bBBookBasicInfo : bBBookListInfo.books_info) {
//                arrayList.add(new BBBookBasicInfo(bBBookBasicInfo));
//            }
//            this.books_info = arrayList;
//        }
//        if (bBBookListInfo.isSetCategories_info()) {
//            ArrayList arrayList2 = new ArrayList(bBBookListInfo.categories_info.size());
//            for (BBBookCategory bBBookCategory : bBBookListInfo.categories_info) {
//                arrayList2.add(new BBBookCategory(bBBookCategory));
//            }
//            this.categories_info = arrayList2;
//        }
//    }
//
//    public BBBookListInfo deepCopy() {
//        return new BBBookListInfo(this);
//    }
//
//    public void clear() {
//        this.books_info = null;
//        this.categories_info = null;
//    }
//
//    public int getBooks_infoSize() {
//        if (this.books_info == null) {
//            return 0;
//        }
//        return this.books_info.size();
//    }
//
//    public Iterator<BBBookBasicInfo> getBooks_infoIterator() {
//        if (this.books_info == null) {
//            return null;
//        }
//        return this.books_info.iterator();
//    }
//
//    public void addToBooks_info(BBBookBasicInfo bBBookBasicInfo) {
//        if (this.books_info == null) {
//            this.books_info = new ArrayList();
//        }
//        this.books_info.add(bBBookBasicInfo);
//    }
//
//    public List<BBBookBasicInfo> getBooks_info() {
//        return this.books_info;
//    }
//
//    public BBBookListInfo setBooks_info(List<BBBookBasicInfo> list) {
//        this.books_info = list;
//        return this;
//    }
//
//    public void unsetBooks_info() {
//        this.books_info = null;
//    }
//
//    public boolean isSetBooks_info() {
//        return this.books_info != null;
//    }
//
//    public void setBooks_infoIsSet(boolean z) {
//        if (!z) {
//            this.books_info = null;
//        }
//    }
//
//    public int getCategories_infoSize() {
//        if (this.categories_info == null) {
//            return 0;
//        }
//        return this.categories_info.size();
//    }
//
//    public Iterator<BBBookCategory> getCategories_infoIterator() {
//        if (this.categories_info == null) {
//            return null;
//        }
//        return this.categories_info.iterator();
//    }
//
//    public void addToCategories_info(BBBookCategory bBBookCategory) {
//        if (this.categories_info == null) {
//            this.categories_info = new ArrayList();
//        }
//        this.categories_info.add(bBBookCategory);
//    }
//
//    public List<BBBookCategory> getCategories_info() {
//        return this.categories_info;
//    }
//
//    public BBBookListInfo setCategories_info(List<BBBookCategory> list) {
//        this.categories_info = list;
//        return this;
//    }
//
//    public void unsetCategories_info() {
//        this.categories_info = null;
//    }
//
//    public boolean isSetCategories_info() {
//        return this.categories_info != null;
//    }
//
//    public void setCategories_infoIsSet(boolean z) {
//        if (!z) {
//            this.categories_info = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case BOOKS_INFO:
//                if (obj == null) {
//                    unsetBooks_info();
//                    return;
//                } else {
//                    setBooks_info((List) obj);
//                    return;
//                }
//            case CATEGORIES_INFO:
//                if (obj == null) {
//                    unsetCategories_info();
//                    return;
//                } else {
//                    setCategories_info((List) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case BOOKS_INFO:
//                return getBooks_info();
//            case CATEGORIES_INFO:
//                return getCategories_info();
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
//            case BOOKS_INFO:
//                return isSetBooks_info();
//            case CATEGORIES_INFO:
//                return isSetCategories_info();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBBookListInfo)) {
//            return equals((BBBookListInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBBookListInfo bBBookListInfo) {
//        if (bBBookListInfo == null) {
//            return false;
//        }
//        boolean isSetBooks_info = isSetBooks_info();
//        boolean isSetBooks_info2 = bBBookListInfo.isSetBooks_info();
//        if ((isSetBooks_info || isSetBooks_info2) && (!isSetBooks_info || !isSetBooks_info2 || !this.books_info.equals(bBBookListInfo.books_info))) {
//            return false;
//        }
//        boolean isSetCategories_info = isSetCategories_info();
//        boolean isSetCategories_info2 = bBBookListInfo.isSetCategories_info();
//        if ((isSetCategories_info || isSetCategories_info2) && (!isSetCategories_info || !isSetCategories_info2 || !this.categories_info.equals(bBBookListInfo.categories_info))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBBookListInfo bBBookListInfo) {
//        if (!getClass().equals(bBBookListInfo.getClass())) {
//            return getClass().getName().compareTo(bBBookListInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetBooks_info()).compareTo(Boolean.valueOf(bBBookListInfo.isSetBooks_info()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetBooks_info()) {
//            int a = C2121h.m5526a((List) this.books_info, (List) bBBookListInfo.books_info);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetCategories_info()).compareTo(Boolean.valueOf(bBBookListInfo.isSetCategories_info()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetCategories_info()) {
//            int a2 = C2121h.m5526a((List) this.categories_info, (List) bBBookListInfo.categories_info);
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
//        StringBuilder sb = new StringBuilder("BBBookListInfo(");
//        sb.append("books_info:");
//        if (this.books_info == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.books_info);
//        }
//        sb.append(", ");
//        sb.append("categories_info:");
//        if (this.categories_info == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.categories_info);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.books_info == null) {
//            throw new C2101g("Required field 'books_info' was not present! Struct: " + toString());
//        } else if (this.categories_info == null) {
//            throw new C2101g("Required field 'categories_info' was not present! Struct: " + toString());
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
