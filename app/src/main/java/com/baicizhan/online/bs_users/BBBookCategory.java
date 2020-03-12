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
//public class BBBookCategory implements Serializable, Cloneable, Comparable<BBBookCategory>, C2116f<BBBookCategory, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b CATEGORY_NAME_FIELD_DESC = new C2097b("category_name", JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBBookCategory");
//    /* access modifiers changed from: private */
//    public static final C2097b SUB_CATEGORIES_FIELD_DESC = new C2097b("sub_categories", 15, 2);
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public String category_name;
//    public List<BBSubCategory> sub_categories;
//
//    class BBBookCategoryStandardScheme extends C2110c<BBBookCategory> {
//        private BBBookCategoryStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBBookCategory bBBookCategory) {
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
//                                bBBookCategory.category_name = fVar.mo18516q();
//                                bBBookCategory.setCategory_nameIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i = fVar.mo18508i();
//                                bBBookCategory.sub_categories = new ArrayList(i.f5838b);
//                                for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                    BBSubCategory bBSubCategory = new BBSubCategory();
//                                    bBSubCategory.read(fVar);
//                                    bBBookCategory.sub_categories.add(bBSubCategory);
//                                }
//                                bBBookCategory.setSub_categoriesIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBBookCategory.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBBookCategory bBBookCategory) {
//            bBBookCategory.validate();
//            BBBookCategory.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBBookCategory.category_name != null) {
//                fVar.mo18496a(BBBookCategory.CATEGORY_NAME_FIELD_DESC);
//                fVar.mo18495a(bBBookCategory.category_name);
//            }
//            if (bBBookCategory.sub_categories != null) {
//                fVar.mo18496a(BBBookCategory.SUB_CATEGORIES_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.ZERO_TAG, bBBookCategory.sub_categories.size()));
//                for (BBSubCategory write : bBBookCategory.sub_categories) {
//                    write.write(fVar);
//                }
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBBookCategoryStandardSchemeFactory implements C2109b {
//        private BBBookCategoryStandardSchemeFactory() {
//        }
//
//        public BBBookCategoryStandardScheme getScheme() {
//            return new BBBookCategoryStandardScheme();
//        }
//    }
//
//    class BBBookCategoryTupleScheme extends C2111d<BBBookCategory> {
//        private BBBookCategoryTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBBookCategory bBBookCategory) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBBookCategory.category_name);
//            lVar.mo18493a(bBBookCategory.sub_categories.size());
//            for (BBSubCategory write : bBBookCategory.sub_categories) {
//                write.write(lVar);
//            }
//        }
//
//        public void read(C2100f fVar, BBBookCategory bBBookCategory) {
//            C2106l lVar = (C2106l) fVar;
//            bBBookCategory.category_name = lVar.mo18516q();
//            bBBookCategory.setCategory_nameIsSet(true);
//            C2098c cVar = new C2098c(JceStruct.ZERO_TAG, lVar.mo18513n());
//            bBBookCategory.sub_categories = new ArrayList(cVar.f5838b);
//            for (int i = 0; i < cVar.f5838b; i++) {
//                BBSubCategory bBSubCategory = new BBSubCategory();
//                bBSubCategory.read(lVar);
//                bBBookCategory.sub_categories.add(bBSubCategory);
//            }
//            bBBookCategory.setSub_categoriesIsSet(true);
//        }
//    }
//
//    class BBBookCategoryTupleSchemeFactory implements C2109b {
//        private BBBookCategoryTupleSchemeFactory() {
//        }
//
//        public BBBookCategoryTupleScheme getScheme() {
//            return new BBBookCategoryTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        CATEGORY_NAME(1, "category_name"),
//        SUB_CATEGORIES(2, "sub_categories");
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
//                    return CATEGORY_NAME;
//                case 2:
//                    return SUB_CATEGORIES;
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
//        hashMap.put(C2110c.class, new BBBookCategoryStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBBookCategoryTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.CATEGORY_NAME, new C2091a("category_name", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.SUB_CATEGORIES, new C2091a("sub_categories", 1, new C2093c(new C2095e(BBSubCategory.class))));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBBookCategory.class, metaDataMap);
//    }
//
//    public BBBookCategory() {
//    }
//
//    public BBBookCategory(String str, List<BBSubCategory> list) {
//        this();
//        this.category_name = str;
//        this.sub_categories = list;
//    }
//
//    public BBBookCategory(BBBookCategory bBBookCategory) {
//        if (bBBookCategory.isSetCategory_name()) {
//            this.category_name = bBBookCategory.category_name;
//        }
//        if (bBBookCategory.isSetSub_categories()) {
//            ArrayList arrayList = new ArrayList(bBBookCategory.sub_categories.size());
//            for (BBSubCategory bBSubCategory : bBBookCategory.sub_categories) {
//                arrayList.add(new BBSubCategory(bBSubCategory));
//            }
//            this.sub_categories = arrayList;
//        }
//    }
//
//    public BBBookCategory deepCopy() {
//        return new BBBookCategory(this);
//    }
//
//    public void clear() {
//        this.category_name = null;
//        this.sub_categories = null;
//    }
//
//    public String getCategory_name() {
//        return this.category_name;
//    }
//
//    public BBBookCategory setCategory_name(String str) {
//        this.category_name = str;
//        return this;
//    }
//
//    public void unsetCategory_name() {
//        this.category_name = null;
//    }
//
//    public boolean isSetCategory_name() {
//        return this.category_name != null;
//    }
//
//    public void setCategory_nameIsSet(boolean z) {
//        if (!z) {
//            this.category_name = null;
//        }
//    }
//
//    public int getSub_categoriesSize() {
//        if (this.sub_categories == null) {
//            return 0;
//        }
//        return this.sub_categories.size();
//    }
//
//    public Iterator<BBSubCategory> getSub_categoriesIterator() {
//        if (this.sub_categories == null) {
//            return null;
//        }
//        return this.sub_categories.iterator();
//    }
//
//    public void addToSub_categories(BBSubCategory bBSubCategory) {
//        if (this.sub_categories == null) {
//            this.sub_categories = new ArrayList();
//        }
//        this.sub_categories.add(bBSubCategory);
//    }
//
//    public List<BBSubCategory> getSub_categories() {
//        return this.sub_categories;
//    }
//
//    public BBBookCategory setSub_categories(List<BBSubCategory> list) {
//        this.sub_categories = list;
//        return this;
//    }
//
//    public void unsetSub_categories() {
//        this.sub_categories = null;
//    }
//
//    public boolean isSetSub_categories() {
//        return this.sub_categories != null;
//    }
//
//    public void setSub_categoriesIsSet(boolean z) {
//        if (!z) {
//            this.sub_categories = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case CATEGORY_NAME:
//                if (obj == null) {
//                    unsetCategory_name();
//                    return;
//                } else {
//                    setCategory_name((String) obj);
//                    return;
//                }
//            case SUB_CATEGORIES:
//                if (obj == null) {
//                    unsetSub_categories();
//                    return;
//                } else {
//                    setSub_categories((List) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case CATEGORY_NAME:
//                return getCategory_name();
//            case SUB_CATEGORIES:
//                return getSub_categories();
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
//            case CATEGORY_NAME:
//                return isSetCategory_name();
//            case SUB_CATEGORIES:
//                return isSetSub_categories();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBBookCategory)) {
//            return equals((BBBookCategory) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBBookCategory bBBookCategory) {
//        if (bBBookCategory == null) {
//            return false;
//        }
//        boolean isSetCategory_name = isSetCategory_name();
//        boolean isSetCategory_name2 = bBBookCategory.isSetCategory_name();
//        if ((isSetCategory_name || isSetCategory_name2) && (!isSetCategory_name || !isSetCategory_name2 || !this.category_name.equals(bBBookCategory.category_name))) {
//            return false;
//        }
//        boolean isSetSub_categories = isSetSub_categories();
//        boolean isSetSub_categories2 = bBBookCategory.isSetSub_categories();
//        if ((isSetSub_categories || isSetSub_categories2) && (!isSetSub_categories || !isSetSub_categories2 || !this.sub_categories.equals(bBBookCategory.sub_categories))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBBookCategory bBBookCategory) {
//        if (!getClass().equals(bBBookCategory.getClass())) {
//            return getClass().getName().compareTo(bBBookCategory.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetCategory_name()).compareTo(Boolean.valueOf(bBBookCategory.isSetCategory_name()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetCategory_name()) {
//            int a = C2121h.m5525a(this.category_name, bBBookCategory.category_name);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetSub_categories()).compareTo(Boolean.valueOf(bBBookCategory.isSetSub_categories()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetSub_categories()) {
//            int a2 = C2121h.m5526a((List) this.sub_categories, (List) bBBookCategory.sub_categories);
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
//        StringBuilder sb = new StringBuilder("BBBookCategory(");
//        sb.append("category_name:");
//        if (this.category_name == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.category_name);
//        }
//        sb.append(", ");
//        sb.append("sub_categories:");
//        if (this.sub_categories == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.sub_categories);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.category_name == null) {
//            throw new C2101g("Required field 'category_name' was not present! Struct: " + toString());
//        } else if (this.sub_categories == null) {
//            throw new C2101g("Required field 'sub_categories' was not present! Struct: " + toString());
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
