//package com.baicizhan.online.bs_words;
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
//public class BBWordMediaHalftimeList implements Serializable, Cloneable, Comparable<BBWordMediaHalftimeList>, C2116f<BBWordMediaHalftimeList, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordMediaHalftimeList");
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FM_HALFTIME_LIST_FIELD_DESC = new C2097b("word_fm_halftime_list", 15, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FM_HEAD_LIST_FIELD_DESC = new C2097b("word_fm_head_list", 15, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FM_TAIL_LIST_FIELD_DESC = new C2097b("word_fm_tail_list", 15, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_TV_HALFTIME_LIST_FIELD_DESC = new C2097b("word_tv_halftime_list", 15, 2);
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    public List<String> word_fm_halftime_list;
//    public List<String> word_fm_head_list;
//    public List<String> word_fm_tail_list;
//    public List<String> word_tv_halftime_list;
//
//    class BBWordMediaHalftimeListStandardScheme extends C2110c<BBWordMediaHalftimeList> {
//        private BBWordMediaHalftimeListStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordMediaHalftimeList bBWordMediaHalftimeList) {
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
//                                bBWordMediaHalftimeList.word_fm_halftime_list = new ArrayList(i.f5838b);
//                                for (int i2 = 0; i2 < i.f5838b; i2++) {
//                                    bBWordMediaHalftimeList.word_fm_halftime_list.add(fVar.mo18516q());
//                                }
//                                bBWordMediaHalftimeList.setWord_fm_halftime_listIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i3 = fVar.mo18508i();
//                                bBWordMediaHalftimeList.word_tv_halftime_list = new ArrayList(i3.f5838b);
//                                for (int i4 = 0; i4 < i3.f5838b; i4++) {
//                                    bBWordMediaHalftimeList.word_tv_halftime_list.add(fVar.mo18516q());
//                                }
//                                bBWordMediaHalftimeList.setWord_tv_halftime_listIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i5 = fVar.mo18508i();
//                                bBWordMediaHalftimeList.word_fm_head_list = new ArrayList(i5.f5838b);
//                                for (int i6 = 0; i6 < i5.f5838b; i6++) {
//                                    bBWordMediaHalftimeList.word_fm_head_list.add(fVar.mo18516q());
//                                }
//                                bBWordMediaHalftimeList.setWord_fm_head_listIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 15) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                C2098c i7 = fVar.mo18508i();
//                                bBWordMediaHalftimeList.word_fm_tail_list = new ArrayList(i7.f5838b);
//                                for (int i8 = 0; i8 < i7.f5838b; i8++) {
//                                    bBWordMediaHalftimeList.word_fm_tail_list.add(fVar.mo18516q());
//                                }
//                                bBWordMediaHalftimeList.setWord_fm_tail_listIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    bBWordMediaHalftimeList.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordMediaHalftimeList bBWordMediaHalftimeList) {
//            bBWordMediaHalftimeList.validate();
//            BBWordMediaHalftimeList.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBWordMediaHalftimeList.word_fm_halftime_list != null) {
//                fVar.mo18496a(BBWordMediaHalftimeList.WORD_FM_HALFTIME_LIST_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.STRUCT_END, bBWordMediaHalftimeList.word_fm_halftime_list.size()));
//                for (String a : bBWordMediaHalftimeList.word_fm_halftime_list) {
//                    fVar.mo18495a(a);
//                }
//            }
//            if (bBWordMediaHalftimeList.word_tv_halftime_list != null) {
//                fVar.mo18496a(BBWordMediaHalftimeList.WORD_TV_HALFTIME_LIST_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.STRUCT_END, bBWordMediaHalftimeList.word_tv_halftime_list.size()));
//                for (String a2 : bBWordMediaHalftimeList.word_tv_halftime_list) {
//                    fVar.mo18495a(a2);
//                }
//            }
//            if (bBWordMediaHalftimeList.word_fm_head_list != null) {
//                fVar.mo18496a(BBWordMediaHalftimeList.WORD_FM_HEAD_LIST_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.STRUCT_END, bBWordMediaHalftimeList.word_fm_head_list.size()));
//                for (String a3 : bBWordMediaHalftimeList.word_fm_head_list) {
//                    fVar.mo18495a(a3);
//                }
//            }
//            if (bBWordMediaHalftimeList.word_fm_tail_list != null) {
//                fVar.mo18496a(BBWordMediaHalftimeList.WORD_FM_TAIL_LIST_FIELD_DESC);
//                fVar.mo18497a(new C2098c(JceStruct.STRUCT_END, bBWordMediaHalftimeList.word_fm_tail_list.size()));
//                for (String a4 : bBWordMediaHalftimeList.word_fm_tail_list) {
//                    fVar.mo18495a(a4);
//                }
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordMediaHalftimeListStandardSchemeFactory implements C2109b {
//        private BBWordMediaHalftimeListStandardSchemeFactory() {
//        }
//
//        public BBWordMediaHalftimeListStandardScheme getScheme() {
//            return new BBWordMediaHalftimeListStandardScheme();
//        }
//    }
//
//    class BBWordMediaHalftimeListTupleScheme extends C2111d<BBWordMediaHalftimeList> {
//        private BBWordMediaHalftimeListTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordMediaHalftimeList bBWordMediaHalftimeList) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBWordMediaHalftimeList.word_fm_halftime_list.size());
//            for (String a : bBWordMediaHalftimeList.word_fm_halftime_list) {
//                lVar.mo18495a(a);
//            }
//            lVar.mo18493a(bBWordMediaHalftimeList.word_tv_halftime_list.size());
//            for (String a2 : bBWordMediaHalftimeList.word_tv_halftime_list) {
//                lVar.mo18495a(a2);
//            }
//            lVar.mo18493a(bBWordMediaHalftimeList.word_fm_head_list.size());
//            for (String a3 : bBWordMediaHalftimeList.word_fm_head_list) {
//                lVar.mo18495a(a3);
//            }
//            lVar.mo18493a(bBWordMediaHalftimeList.word_fm_tail_list.size());
//            for (String a4 : bBWordMediaHalftimeList.word_fm_tail_list) {
//                lVar.mo18495a(a4);
//            }
//        }
//
//        public void read(C2100f fVar, BBWordMediaHalftimeList bBWordMediaHalftimeList) {
//            C2106l lVar = (C2106l) fVar;
//            C2098c cVar = new C2098c(JceStruct.STRUCT_END, lVar.mo18513n());
//            bBWordMediaHalftimeList.word_fm_halftime_list = new ArrayList(cVar.f5838b);
//            for (int i = 0; i < cVar.f5838b; i++) {
//                bBWordMediaHalftimeList.word_fm_halftime_list.add(lVar.mo18516q());
//            }
//            bBWordMediaHalftimeList.setWord_fm_halftime_listIsSet(true);
//            C2098c cVar2 = new C2098c(JceStruct.STRUCT_END, lVar.mo18513n());
//            bBWordMediaHalftimeList.word_tv_halftime_list = new ArrayList(cVar2.f5838b);
//            for (int i2 = 0; i2 < cVar2.f5838b; i2++) {
//                bBWordMediaHalftimeList.word_tv_halftime_list.add(lVar.mo18516q());
//            }
//            bBWordMediaHalftimeList.setWord_tv_halftime_listIsSet(true);
//            C2098c cVar3 = new C2098c(JceStruct.STRUCT_END, lVar.mo18513n());
//            bBWordMediaHalftimeList.word_fm_head_list = new ArrayList(cVar3.f5838b);
//            for (int i3 = 0; i3 < cVar3.f5838b; i3++) {
//                bBWordMediaHalftimeList.word_fm_head_list.add(lVar.mo18516q());
//            }
//            bBWordMediaHalftimeList.setWord_fm_head_listIsSet(true);
//            C2098c cVar4 = new C2098c(JceStruct.STRUCT_END, lVar.mo18513n());
//            bBWordMediaHalftimeList.word_fm_tail_list = new ArrayList(cVar4.f5838b);
//            for (int i4 = 0; i4 < cVar4.f5838b; i4++) {
//                bBWordMediaHalftimeList.word_fm_tail_list.add(lVar.mo18516q());
//            }
//            bBWordMediaHalftimeList.setWord_fm_tail_listIsSet(true);
//        }
//    }
//
//    class BBWordMediaHalftimeListTupleSchemeFactory implements C2109b {
//        private BBWordMediaHalftimeListTupleSchemeFactory() {
//        }
//
//        public BBWordMediaHalftimeListTupleScheme getScheme() {
//            return new BBWordMediaHalftimeListTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        WORD_FM_HALFTIME_LIST(1, "word_fm_halftime_list"),
//        WORD_TV_HALFTIME_LIST(2, "word_tv_halftime_list"),
//        WORD_FM_HEAD_LIST(3, "word_fm_head_list"),
//        WORD_FM_TAIL_LIST(4, "word_fm_tail_list");
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
//                    return WORD_FM_HALFTIME_LIST;
//                case 2:
//                    return WORD_TV_HALFTIME_LIST;
//                case 3:
//                    return WORD_FM_HEAD_LIST;
//                case 4:
//                    return WORD_FM_TAIL_LIST;
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
//        hashMap.put(C2110c.class, new BBWordMediaHalftimeListStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordMediaHalftimeListTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.WORD_FM_HALFTIME_LIST, new C2091a("word_fm_halftime_list", 1, new C2093c(new C2092b(JceStruct.STRUCT_END, 0))));
//        enumMap.put(_Fields.WORD_TV_HALFTIME_LIST, new C2091a("word_tv_halftime_list", 1, new C2093c(new C2092b(JceStruct.STRUCT_END, 0))));
//        enumMap.put(_Fields.WORD_FM_HEAD_LIST, new C2091a("word_fm_head_list", 1, new C2093c(new C2092b(JceStruct.STRUCT_END, 0))));
//        enumMap.put(_Fields.WORD_FM_TAIL_LIST, new C2091a("word_fm_tail_list", 1, new C2093c(new C2092b(JceStruct.STRUCT_END, 0))));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordMediaHalftimeList.class, metaDataMap);
//    }
//
//    public BBWordMediaHalftimeList() {
//    }
//
//    public BBWordMediaHalftimeList(List<String> list, List<String> list2, List<String> list3, List<String> list4) {
//        this();
//        this.word_fm_halftime_list = list;
//        this.word_tv_halftime_list = list2;
//        this.word_fm_head_list = list3;
//        this.word_fm_tail_list = list4;
//    }
//
//    public BBWordMediaHalftimeList(BBWordMediaHalftimeList bBWordMediaHalftimeList) {
//        if (bBWordMediaHalftimeList.isSetWord_fm_halftime_list()) {
//            this.word_fm_halftime_list = new ArrayList(bBWordMediaHalftimeList.word_fm_halftime_list);
//        }
//        if (bBWordMediaHalftimeList.isSetWord_tv_halftime_list()) {
//            this.word_tv_halftime_list = new ArrayList(bBWordMediaHalftimeList.word_tv_halftime_list);
//        }
//        if (bBWordMediaHalftimeList.isSetWord_fm_head_list()) {
//            this.word_fm_head_list = new ArrayList(bBWordMediaHalftimeList.word_fm_head_list);
//        }
//        if (bBWordMediaHalftimeList.isSetWord_fm_tail_list()) {
//            this.word_fm_tail_list = new ArrayList(bBWordMediaHalftimeList.word_fm_tail_list);
//        }
//    }
//
//    public BBWordMediaHalftimeList deepCopy() {
//        return new BBWordMediaHalftimeList(this);
//    }
//
//    public void clear() {
//        this.word_fm_halftime_list = null;
//        this.word_tv_halftime_list = null;
//        this.word_fm_head_list = null;
//        this.word_fm_tail_list = null;
//    }
//
//    public int getWord_fm_halftime_listSize() {
//        if (this.word_fm_halftime_list == null) {
//            return 0;
//        }
//        return this.word_fm_halftime_list.size();
//    }
//
//    public Iterator<String> getWord_fm_halftime_listIterator() {
//        if (this.word_fm_halftime_list == null) {
//            return null;
//        }
//        return this.word_fm_halftime_list.iterator();
//    }
//
//    public void addToWord_fm_halftime_list(String str) {
//        if (this.word_fm_halftime_list == null) {
//            this.word_fm_halftime_list = new ArrayList();
//        }
//        this.word_fm_halftime_list.add(str);
//    }
//
//    public List<String> getWord_fm_halftime_list() {
//        return this.word_fm_halftime_list;
//    }
//
//    public BBWordMediaHalftimeList setWord_fm_halftime_list(List<String> list) {
//        this.word_fm_halftime_list = list;
//        return this;
//    }
//
//    public void unsetWord_fm_halftime_list() {
//        this.word_fm_halftime_list = null;
//    }
//
//    public boolean isSetWord_fm_halftime_list() {
//        return this.word_fm_halftime_list != null;
//    }
//
//    public void setWord_fm_halftime_listIsSet(boolean z) {
//        if (!z) {
//            this.word_fm_halftime_list = null;
//        }
//    }
//
//    public int getWord_tv_halftime_listSize() {
//        if (this.word_tv_halftime_list == null) {
//            return 0;
//        }
//        return this.word_tv_halftime_list.size();
//    }
//
//    public Iterator<String> getWord_tv_halftime_listIterator() {
//        if (this.word_tv_halftime_list == null) {
//            return null;
//        }
//        return this.word_tv_halftime_list.iterator();
//    }
//
//    public void addToWord_tv_halftime_list(String str) {
//        if (this.word_tv_halftime_list == null) {
//            this.word_tv_halftime_list = new ArrayList();
//        }
//        this.word_tv_halftime_list.add(str);
//    }
//
//    public List<String> getWord_tv_halftime_list() {
//        return this.word_tv_halftime_list;
//    }
//
//    public BBWordMediaHalftimeList setWord_tv_halftime_list(List<String> list) {
//        this.word_tv_halftime_list = list;
//        return this;
//    }
//
//    public void unsetWord_tv_halftime_list() {
//        this.word_tv_halftime_list = null;
//    }
//
//    public boolean isSetWord_tv_halftime_list() {
//        return this.word_tv_halftime_list != null;
//    }
//
//    public void setWord_tv_halftime_listIsSet(boolean z) {
//        if (!z) {
//            this.word_tv_halftime_list = null;
//        }
//    }
//
//    public int getWord_fm_head_listSize() {
//        if (this.word_fm_head_list == null) {
//            return 0;
//        }
//        return this.word_fm_head_list.size();
//    }
//
//    public Iterator<String> getWord_fm_head_listIterator() {
//        if (this.word_fm_head_list == null) {
//            return null;
//        }
//        return this.word_fm_head_list.iterator();
//    }
//
//    public void addToWord_fm_head_list(String str) {
//        if (this.word_fm_head_list == null) {
//            this.word_fm_head_list = new ArrayList();
//        }
//        this.word_fm_head_list.add(str);
//    }
//
//    public List<String> getWord_fm_head_list() {
//        return this.word_fm_head_list;
//    }
//
//    public BBWordMediaHalftimeList setWord_fm_head_list(List<String> list) {
//        this.word_fm_head_list = list;
//        return this;
//    }
//
//    public void unsetWord_fm_head_list() {
//        this.word_fm_head_list = null;
//    }
//
//    public boolean isSetWord_fm_head_list() {
//        return this.word_fm_head_list != null;
//    }
//
//    public void setWord_fm_head_listIsSet(boolean z) {
//        if (!z) {
//            this.word_fm_head_list = null;
//        }
//    }
//
//    public int getWord_fm_tail_listSize() {
//        if (this.word_fm_tail_list == null) {
//            return 0;
//        }
//        return this.word_fm_tail_list.size();
//    }
//
//    public Iterator<String> getWord_fm_tail_listIterator() {
//        if (this.word_fm_tail_list == null) {
//            return null;
//        }
//        return this.word_fm_tail_list.iterator();
//    }
//
//    public void addToWord_fm_tail_list(String str) {
//        if (this.word_fm_tail_list == null) {
//            this.word_fm_tail_list = new ArrayList();
//        }
//        this.word_fm_tail_list.add(str);
//    }
//
//    public List<String> getWord_fm_tail_list() {
//        return this.word_fm_tail_list;
//    }
//
//    public BBWordMediaHalftimeList setWord_fm_tail_list(List<String> list) {
//        this.word_fm_tail_list = list;
//        return this;
//    }
//
//    public void unsetWord_fm_tail_list() {
//        this.word_fm_tail_list = null;
//    }
//
//    public boolean isSetWord_fm_tail_list() {
//        return this.word_fm_tail_list != null;
//    }
//
//    public void setWord_fm_tail_listIsSet(boolean z) {
//        if (!z) {
//            this.word_fm_tail_list = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case WORD_FM_HALFTIME_LIST:
//                if (obj == null) {
//                    unsetWord_fm_halftime_list();
//                    return;
//                } else {
//                    setWord_fm_halftime_list((List) obj);
//                    return;
//                }
//            case WORD_TV_HALFTIME_LIST:
//                if (obj == null) {
//                    unsetWord_tv_halftime_list();
//                    return;
//                } else {
//                    setWord_tv_halftime_list((List) obj);
//                    return;
//                }
//            case WORD_FM_HEAD_LIST:
//                if (obj == null) {
//                    unsetWord_fm_head_list();
//                    return;
//                } else {
//                    setWord_fm_head_list((List) obj);
//                    return;
//                }
//            case WORD_FM_TAIL_LIST:
//                if (obj == null) {
//                    unsetWord_fm_tail_list();
//                    return;
//                } else {
//                    setWord_fm_tail_list((List) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case WORD_FM_HALFTIME_LIST:
//                return getWord_fm_halftime_list();
//            case WORD_TV_HALFTIME_LIST:
//                return getWord_tv_halftime_list();
//            case WORD_FM_HEAD_LIST:
//                return getWord_fm_head_list();
//            case WORD_FM_TAIL_LIST:
//                return getWord_fm_tail_list();
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
//            case WORD_FM_HALFTIME_LIST:
//                return isSetWord_fm_halftime_list();
//            case WORD_TV_HALFTIME_LIST:
//                return isSetWord_tv_halftime_list();
//            case WORD_FM_HEAD_LIST:
//                return isSetWord_fm_head_list();
//            case WORD_FM_TAIL_LIST:
//                return isSetWord_fm_tail_list();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordMediaHalftimeList)) {
//            return equals((BBWordMediaHalftimeList) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordMediaHalftimeList bBWordMediaHalftimeList) {
//        if (bBWordMediaHalftimeList == null) {
//            return false;
//        }
//        boolean isSetWord_fm_halftime_list = isSetWord_fm_halftime_list();
//        boolean isSetWord_fm_halftime_list2 = bBWordMediaHalftimeList.isSetWord_fm_halftime_list();
//        if ((isSetWord_fm_halftime_list || isSetWord_fm_halftime_list2) && (!isSetWord_fm_halftime_list || !isSetWord_fm_halftime_list2 || !this.word_fm_halftime_list.equals(bBWordMediaHalftimeList.word_fm_halftime_list))) {
//            return false;
//        }
//        boolean isSetWord_tv_halftime_list = isSetWord_tv_halftime_list();
//        boolean isSetWord_tv_halftime_list2 = bBWordMediaHalftimeList.isSetWord_tv_halftime_list();
//        if ((isSetWord_tv_halftime_list || isSetWord_tv_halftime_list2) && (!isSetWord_tv_halftime_list || !isSetWord_tv_halftime_list2 || !this.word_tv_halftime_list.equals(bBWordMediaHalftimeList.word_tv_halftime_list))) {
//            return false;
//        }
//        boolean isSetWord_fm_head_list = isSetWord_fm_head_list();
//        boolean isSetWord_fm_head_list2 = bBWordMediaHalftimeList.isSetWord_fm_head_list();
//        if ((isSetWord_fm_head_list || isSetWord_fm_head_list2) && (!isSetWord_fm_head_list || !isSetWord_fm_head_list2 || !this.word_fm_head_list.equals(bBWordMediaHalftimeList.word_fm_head_list))) {
//            return false;
//        }
//        boolean isSetWord_fm_tail_list = isSetWord_fm_tail_list();
//        boolean isSetWord_fm_tail_list2 = bBWordMediaHalftimeList.isSetWord_fm_tail_list();
//        if ((isSetWord_fm_tail_list || isSetWord_fm_tail_list2) && (!isSetWord_fm_tail_list || !isSetWord_fm_tail_list2 || !this.word_fm_tail_list.equals(bBWordMediaHalftimeList.word_fm_tail_list))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordMediaHalftimeList bBWordMediaHalftimeList) {
//        if (!getClass().equals(bBWordMediaHalftimeList.getClass())) {
//            return getClass().getName().compareTo(bBWordMediaHalftimeList.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetWord_fm_halftime_list()).compareTo(Boolean.valueOf(bBWordMediaHalftimeList.isSetWord_fm_halftime_list()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetWord_fm_halftime_list()) {
//            int a = C2121h.m5526a((List) this.word_fm_halftime_list, (List) bBWordMediaHalftimeList.word_fm_halftime_list);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetWord_tv_halftime_list()).compareTo(Boolean.valueOf(bBWordMediaHalftimeList.isSetWord_tv_halftime_list()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetWord_tv_halftime_list()) {
//            int a2 = C2121h.m5526a((List) this.word_tv_halftime_list, (List) bBWordMediaHalftimeList.word_tv_halftime_list);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetWord_fm_head_list()).compareTo(Boolean.valueOf(bBWordMediaHalftimeList.isSetWord_fm_head_list()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetWord_fm_head_list()) {
//            int a3 = C2121h.m5526a((List) this.word_fm_head_list, (List) bBWordMediaHalftimeList.word_fm_head_list);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetWord_fm_tail_list()).compareTo(Boolean.valueOf(bBWordMediaHalftimeList.isSetWord_fm_tail_list()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetWord_fm_tail_list()) {
//            int a4 = C2121h.m5526a((List) this.word_fm_tail_list, (List) bBWordMediaHalftimeList.word_fm_tail_list);
//            if (a4 != 0) {
//                return a4;
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
//        StringBuilder sb = new StringBuilder("BBWordMediaHalftimeList(");
//        sb.append("word_fm_halftime_list:");
//        if (this.word_fm_halftime_list == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word_fm_halftime_list);
//        }
//        sb.append(", ");
//        sb.append("word_tv_halftime_list:");
//        if (this.word_tv_halftime_list == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word_tv_halftime_list);
//        }
//        sb.append(", ");
//        sb.append("word_fm_head_list:");
//        if (this.word_fm_head_list == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word_fm_head_list);
//        }
//        sb.append(", ");
//        sb.append("word_fm_tail_list:");
//        if (this.word_fm_tail_list == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word_fm_tail_list);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.word_fm_halftime_list == null) {
//            throw new C2101g("Required field 'word_fm_halftime_list' was not present! Struct: " + toString());
//        } else if (this.word_tv_halftime_list == null) {
//            throw new C2101g("Required field 'word_tv_halftime_list' was not present! Struct: " + toString());
//        } else if (this.word_fm_head_list == null) {
//            throw new C2101g("Required field 'word_fm_head_list' was not present! Struct: " + toString());
//        } else if (this.word_fm_tail_list == null) {
//            throw new C2101g("Required field 'word_fm_tail_list' was not present! Struct: " + toString());
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
