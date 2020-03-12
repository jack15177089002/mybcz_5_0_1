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
//public class BBBookList implements Serializable, Cloneable, Comparable<BBBookList>, C2116f<BBBookList, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b ALL_BOOKS_FIELD_DESC = new C2097b("all_books", 15, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b CATEGORIES_FIELD_DESC = new C2097b("categories", 15, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBBookList");
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public List<BBBookInfo> all_books;
//    public List<BBBookCategory> categories;
//
//    class BBBookListStandardScheme extends C2110c<BBBookList> {
//        private BBBookListStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBBookList bBBookList) {
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
//                                bBBookList.all_books = new ArrayList(i.f5838b);
//                                for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                    BBBookInfo bBBookInfo = new BBBookInfo();
//                                    bBBookInfo.read(fVar);
//                                    bBBookList.all_books.add(bBBookInfo);
//                                }
//                                bBBookList.setAll_booksIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i3 = fVar.mo18508i();
//                                bBBookList.categories = new ArrayList(i3.f5838b);
//                                for (int i4 = 0; i4 < i3.f5838b; i4++) {
//                                    BBBookCategory bBBookCategory = new BBBookCategory();
//                                    bBBookCategory.read(fVar);
//                                    bBBookList.categories.add(bBBookCategory);
//                                }
//                                bBBookList.setCategoriesIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBBookList.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBBookList bBBookList) {
//            bBBookList.validate();
//            BBBookList.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBBookList.all_books != null) {
//                fVar.mo18496a(BBBookList.ALL_BOOKS_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, bBBookList.all_books.size()));
//                for (BBBookInfo write : bBBookList.all_books) {
//                    write.write(fVar);
//                }
//            }
//            if (bBBookList.categories != null) {
//                fVar.mo18496a(BBBookList.CATEGORIES_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, bBBookList.categories.size()));
//                for (BBBookCategory write2 : bBBookList.categories) {
//                    write2.write(fVar);
//                }
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBBookListStandardSchemeFactory implements C2109b {
//        private BBBookListStandardSchemeFactory() {
//        }
//
//        public BBBookListStandardScheme getScheme() {
//            return new BBBookListStandardScheme();
//        }
//    }
//
//    class BBBookListTupleScheme extends C2111d<BBBookList> {
//        private BBBookListTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBBookList bBBookList) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBBookList.all_books.size());
//            for (BBBookInfo write : bBBookList.all_books) {
//                write.write(lVar);
//            }
//            lVar.mo18493a(bBBookList.categories.size());
//            for (BBBookCategory write2 : bBBookList.categories) {
//                write2.write(lVar);
//            }
//        }
//
//        public void read(C2100f fVar, BBBookList bBBookList) {
//            C2106l lVar = (C2106l) fVar;
//            C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//            bBBookList.all_books = new ArrayList(cVar.f5838b);
//            for (int i = 0; i < cVar.f5838b; i++) {
//                BBBookInfo bBBookInfo = new BBBookInfo();
//                bBBookInfo.read(lVar);
//                bBBookList.all_books.add(bBBookInfo);
//            }
//            bBBookList.setAll_booksIsSet(true);
//            C2098c cVar2 = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//            bBBookList.categories = new ArrayList(cVar2.f5838b);
//            for (int i2 = 0; i2 < cVar2.f5838b; i2++) {
//                BBBookCategory bBBookCategory = new BBBookCategory();
//                bBBookCategory.read(lVar);
//                bBBookList.categories.add(bBBookCategory);
//            }
//            bBBookList.setCategoriesIsSet(true);
//        }
//    }
//
//    class BBBookListTupleSchemeFactory implements C2109b {
//        private BBBookListTupleSchemeFactory() {
//        }
//
//        public BBBookListTupleScheme getScheme() {
//            return new BBBookListTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        ALL_BOOKS(1, "all_books"),
//        CATEGORIES(2, "categories");
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
//                    return ALL_BOOKS;
//                case 2:
//                    return CATEGORIES;
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
//        hashMap.put(C2110c.class, new BBBookListStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBBookListTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.ALL_BOOKS, new C2091a("all_books", 1, new C2093c(new C2095e(BBBookInfo.class))));
//        enumMap.put(_Fields.CATEGORIES, new C2091a("categories", 1, new C2093c(new C2095e(BBBookCategory.class))));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBBookList.class, metaDataMap);
//    }
//
//    public BBBookList() {
//    }
//
//    public BBBookList(List<BBBookInfo> list, List<BBBookCategory> list2) {
//        this();
//        this.all_books = list;
//        this.categories = list2;
//    }
//
//    public BBBookList(BBBookList bBBookList) {
//        if (bBBookList.isSetAll_books()) {
//            ArrayList arrayList = new ArrayList(bBBookList.all_books.size());
//            for (BBBookInfo bBBookInfo : bBBookList.all_books) {
//                arrayList.add(new BBBookInfo(bBBookInfo));
//            }
//            this.all_books = arrayList;
//        }
//        if (bBBookList.isSetCategories()) {
//            ArrayList arrayList2 = new ArrayList(bBBookList.categories.size());
//            for (BBBookCategory bBBookCategory : bBBookList.categories) {
//                arrayList2.add(new BBBookCategory(bBBookCategory));
//            }
//            this.categories = arrayList2;
//        }
//    }
//
//    public BBBookList deepCopy() {
//        return new BBBookList(this);
//    }
//
//    public void clear() {
//        this.all_books = null;
//        this.categories = null;
//    }
//
//    public int getAll_booksSize() {
//        if (this.all_books == null) {
//            return 0;
//        }
//        return this.all_books.size();
//    }
//
//    public Iterator<BBBookInfo> getAll_booksIterator() {
//        if (this.all_books == null) {
//            return null;
//        }
//        return this.all_books.iterator();
//    }
//
//    public void addToAll_books(BBBookInfo bBBookInfo) {
//        if (this.all_books == null) {
//            this.all_books = new ArrayList();
//        }
//        this.all_books.add(bBBookInfo);
//    }
//
//    public List<BBBookInfo> getAll_books() {
//        return this.all_books;
//    }
//
//    public BBBookList setAll_books(List<BBBookInfo> list) {
//        this.all_books = list;
//        return this;
//    }
//
//    public void unsetAll_books() {
//        this.all_books = null;
//    }
//
//    public boolean isSetAll_books() {
//        return this.all_books != null;
//    }
//
//    public void setAll_booksIsSet(boolean z) {
//        if (!z) {
//            this.all_books = null;
//        }
//    }
//
//    public int getCategoriesSize() {
//        if (this.categories == null) {
//            return 0;
//        }
//        return this.categories.size();
//    }
//
//    public Iterator<BBBookCategory> getCategoriesIterator() {
//        if (this.categories == null) {
//            return null;
//        }
//        return this.categories.iterator();
//    }
//
//    public void addToCategories(BBBookCategory bBBookCategory) {
//        if (this.categories == null) {
//            this.categories = new ArrayList();
//        }
//        this.categories.add(bBBookCategory);
//    }
//
//    public List<BBBookCategory> getCategories() {
//        return this.categories;
//    }
//
//    public BBBookList setCategories(List<BBBookCategory> list) {
//        this.categories = list;
//        return this;
//    }
//
//    public void unsetCategories() {
//        this.categories = null;
//    }
//
//    public boolean isSetCategories() {
//        return this.categories != null;
//    }
//
//    public void setCategoriesIsSet(boolean z) {
//        if (!z) {
//            this.categories = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case ALL_BOOKS:
//                if (obj == null) {
//                    unsetAll_books();
//                    return;
//                } else {
//                    setAll_books((List) obj);
//                    return;
//                }
//            case CATEGORIES:
//                if (obj == null) {
//                    unsetCategories();
//                    return;
//                } else {
//                    setCategories((List) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case ALL_BOOKS:
//                return getAll_books();
//            case CATEGORIES:
//                return getCategories();
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
//            case ALL_BOOKS:
//                return isSetAll_books();
//            case CATEGORIES:
//                return isSetCategories();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBBookList)) {
//            return equals((BBBookList) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBBookList bBBookList) {
//        if (bBBookList == null) {
//            return false;
//        }
//        boolean isSetAll_books = isSetAll_books();
//        boolean isSetAll_books2 = bBBookList.isSetAll_books();
//        if ((isSetAll_books || isSetAll_books2) && (!isSetAll_books || !isSetAll_books2 || !this.all_books.equals(bBBookList.all_books))) {
//            return false;
//        }
//        boolean isSetCategories = isSetCategories();
//        boolean isSetCategories2 = bBBookList.isSetCategories();
//        if ((isSetCategories || isSetCategories2) && (!isSetCategories || !isSetCategories2 || !this.categories.equals(bBBookList.categories))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBBookList bBBookList) {
//        if (!getClass().equals(bBBookList.getClass())) {
//            return getClass().getName().compareTo(bBBookList.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetAll_books()).compareTo(Boolean.valueOf(bBBookList.isSetAll_books()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetAll_books()) {
//            int a = C2121h.m5526a((List) this.all_books, (List) bBBookList.all_books);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetCategories()).compareTo(Boolean.valueOf(bBBookList.isSetCategories()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetCategories()) {
//            int a2 = C2121h.m5526a((List) this.categories, (List) bBBookList.categories);
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
//        StringBuilder sb = new StringBuilder("BBBookList(");
//        sb.append("all_books:");
//        if (this.all_books == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.all_books);
//        }
//        sb.append(", ");
//        sb.append("categories:");
//        if (this.categories == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.categories);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.all_books == null) {
//            throw new C2101g("Required field 'all_books' was not present! Struct: " + toString());
//        } else if (this.categories == null) {
//            throw new C2101g("Required field 'categories' was not present! Struct: " + toString());
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
