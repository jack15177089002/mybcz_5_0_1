//package com.baicizhan.online.bs_words;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.io.Serializable;
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
//public class BBSimilarWordVote implements Serializable, Cloneable, Comparable<BBSimilarWordVote>, C2116f<BBSimilarWordVote, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b BOOK_ID_FIELD_DESC = new C2097b("book_id", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_SIMILAR_FIELD_DESC = new C2097b("is_similar", 2, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b SIMILAR_WORD_ID_FIELD_DESC = new C2097b("similar_word_id", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBSimilarWordVote");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    private static final int __BOOK_ID_ISSET_ID = 1;
//    private static final int __IS_SIMILAR_ISSET_ID = 3;
//    private static final int __SIMILAR_WORD_ID_ISSET_ID = 2;
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public int book_id;
//    public boolean is_similar;
//    public int similar_word_id;
//    public int topic_id;
//
//    class BBSimilarWordVoteStandardScheme extends C2110c<BBSimilarWordVote> {
//        private BBSimilarWordVoteStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBSimilarWordVote bBSimilarWordVote) {
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
//                                bBSimilarWordVote.topic_id = fVar.mo18513n();
//                                bBSimilarWordVote.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSimilarWordVote.book_id = fVar.mo18513n();
//                                bBSimilarWordVote.setBook_idIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSimilarWordVote.similar_word_id = fVar.mo18513n();
//                                bBSimilarWordVote.setSimilar_word_idIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 2) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSimilarWordVote.is_similar = fVar.mo18510k();
//                                bBSimilarWordVote.setIs_similarIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBSimilarWordVote.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBSimilarWordVote.isSetBook_id()) {
//                        throw new C2101g("Required field 'book_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBSimilarWordVote.isSetSimilar_word_id()) {
//                        throw new C2101g("Required field 'similar_word_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBSimilarWordVote.isSetIs_similar()) {
//                        throw new C2101g("Required field 'is_similar' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBSimilarWordVote.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBSimilarWordVote bBSimilarWordVote) {
//            bBSimilarWordVote.validate();
//            BBSimilarWordVote.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBSimilarWordVote.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBSimilarWordVote.topic_id);
//            fVar.mo18496a(BBSimilarWordVote.BOOK_ID_FIELD_DESC);
//            fVar.mo18493a(bBSimilarWordVote.book_id);
//            fVar.mo18496a(BBSimilarWordVote.SIMILAR_WORD_ID_FIELD_DESC);
//            fVar.mo18493a(bBSimilarWordVote.similar_word_id);
//            fVar.mo18496a(BBSimilarWordVote.IS_SIMILAR_FIELD_DESC);
//            fVar.mo18500a(bBSimilarWordVote.is_similar);
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBSimilarWordVoteStandardSchemeFactory implements C2109b {
//        private BBSimilarWordVoteStandardSchemeFactory() {
//        }
//
//        public BBSimilarWordVoteStandardScheme getScheme() {
//            return new BBSimilarWordVoteStandardScheme();
//        }
//    }
//
//    class BBSimilarWordVoteTupleScheme extends C2111d<BBSimilarWordVote> {
//        private BBSimilarWordVoteTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBSimilarWordVote bBSimilarWordVote) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBSimilarWordVote.topic_id);
//            lVar.mo18493a(bBSimilarWordVote.book_id);
//            lVar.mo18493a(bBSimilarWordVote.similar_word_id);
//            lVar.mo18500a(bBSimilarWordVote.is_similar);
//        }
//
//        public void read(C2100f fVar, BBSimilarWordVote bBSimilarWordVote) {
//            C2106l lVar = (C2106l) fVar;
//            bBSimilarWordVote.topic_id = lVar.mo18513n();
//            bBSimilarWordVote.setTopic_idIsSet(true);
//            bBSimilarWordVote.book_id = lVar.mo18513n();
//            bBSimilarWordVote.setBook_idIsSet(true);
//            bBSimilarWordVote.similar_word_id = lVar.mo18513n();
//            bBSimilarWordVote.setSimilar_word_idIsSet(true);
//            bBSimilarWordVote.is_similar = lVar.mo18510k();
//            bBSimilarWordVote.setIs_similarIsSet(true);
//        }
//    }
//
//    class BBSimilarWordVoteTupleSchemeFactory implements C2109b {
//        private BBSimilarWordVoteTupleSchemeFactory() {
//        }
//
//        public BBSimilarWordVoteTupleScheme getScheme() {
//            return new BBSimilarWordVoteTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        BOOK_ID(2, "book_id"),
//        SIMILAR_WORD_ID(3, "similar_word_id"),
//        IS_SIMILAR(4, "is_similar");
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
//                    return BOOK_ID;
//                case 3:
//                    return SIMILAR_WORD_ID;
//                case 4:
//                    return IS_SIMILAR;
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
//        hashMap.put(C2110c.class, new BBSimilarWordVoteStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBSimilarWordVoteTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.BOOK_ID, new C2091a("book_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SIMILAR_WORD_ID, new C2091a("similar_word_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.IS_SIMILAR, new C2091a("is_similar", 1, new C2092b(2, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBSimilarWordVote.class, metaDataMap);
//    }
//
//    public BBSimilarWordVote() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBSimilarWordVote(int i, int i2, int i3, boolean z) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.book_id = i2;
//        setBook_idIsSet(true);
//        this.similar_word_id = i3;
//        setSimilar_word_idIsSet(true);
//        this.is_similar = z;
//        setIs_similarIsSet(true);
//    }
//
//    public BBSimilarWordVote(BBSimilarWordVote bBSimilarWordVote) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBSimilarWordVote.__isset_bitfield;
//        this.topic_id = bBSimilarWordVote.topic_id;
//        this.book_id = bBSimilarWordVote.book_id;
//        this.similar_word_id = bBSimilarWordVote.similar_word_id;
//        this.is_similar = bBSimilarWordVote.is_similar;
//    }
//
//    public BBSimilarWordVote deepCopy() {
//        return new BBSimilarWordVote(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        setBook_idIsSet(false);
//        this.book_id = 0;
//        setSimilar_word_idIsSet(false);
//        this.similar_word_id = 0;
//        setIs_similarIsSet(false);
//        this.is_similar = false;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBSimilarWordVote setTopic_id(int i) {
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
//    public int getBook_id() {
//        return this.book_id;
//    }
//
//    public BBSimilarWordVote setBook_id(int i) {
//        this.book_id = i;
//        setBook_idIsSet(true);
//        return this;
//    }
//
//    public void unsetBook_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetBook_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setBook_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getSimilar_word_id() {
//        return this.similar_word_id;
//    }
//
//    public BBSimilarWordVote setSimilar_word_id(int i) {
//        this.similar_word_id = i;
//        setSimilar_word_idIsSet(true);
//        return this;
//    }
//
//    public void unsetSimilar_word_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetSimilar_word_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setSimilar_word_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public boolean isIs_similar() {
//        return this.is_similar;
//    }
//
//    public BBSimilarWordVote setIs_similar(boolean z) {
//        this.is_similar = z;
//        setIs_similarIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_similar() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetIs_similar() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setIs_similarIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
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
//            case BOOK_ID:
//                if (obj == null) {
//                    unsetBook_id();
//                    return;
//                } else {
//                    setBook_id(((Integer) obj).intValue());
//                    return;
//                }
//            case SIMILAR_WORD_ID:
//                if (obj == null) {
//                    unsetSimilar_word_id();
//                    return;
//                } else {
//                    setSimilar_word_id(((Integer) obj).intValue());
//                    return;
//                }
//            case IS_SIMILAR:
//                if (obj == null) {
//                    unsetIs_similar();
//                    return;
//                } else {
//                    setIs_similar(((Boolean) obj).booleanValue());
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
//            case BOOK_ID:
//                return Integer.valueOf(getBook_id());
//            case SIMILAR_WORD_ID:
//                return Integer.valueOf(getSimilar_word_id());
//            case IS_SIMILAR:
//                return Boolean.valueOf(isIs_similar());
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
//            case BOOK_ID:
//                return isSetBook_id();
//            case SIMILAR_WORD_ID:
//                return isSetSimilar_word_id();
//            case IS_SIMILAR:
//                return isSetIs_similar();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBSimilarWordVote)) {
//            return equals((BBSimilarWordVote) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBSimilarWordVote bBSimilarWordVote) {
//        if (bBSimilarWordVote != null && this.topic_id == bBSimilarWordVote.topic_id && this.book_id == bBSimilarWordVote.book_id && this.similar_word_id == bBSimilarWordVote.similar_word_id && this.is_similar == bBSimilarWordVote.is_similar) {
//            return true;
//        }
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBSimilarWordVote bBSimilarWordVote) {
//        if (!getClass().equals(bBSimilarWordVote.getClass())) {
//            return getClass().getName().compareTo(bBSimilarWordVote.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBSimilarWordVote.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBSimilarWordVote.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetBook_id()).compareTo(Boolean.valueOf(bBSimilarWordVote.isSetBook_id()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetBook_id()) {
//            int a2 = C2121h.m5522a(this.book_id, bBSimilarWordVote.book_id);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetSimilar_word_id()).compareTo(Boolean.valueOf(bBSimilarWordVote.isSetSimilar_word_id()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetSimilar_word_id()) {
//            int a3 = C2121h.m5522a(this.similar_word_id, bBSimilarWordVote.similar_word_id);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetIs_similar()).compareTo(Boolean.valueOf(bBSimilarWordVote.isSetIs_similar()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetIs_similar()) {
//            int a4 = C2121h.m5529a(this.is_similar, bBSimilarWordVote.is_similar);
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
//        StringBuilder sb = new StringBuilder("BBSimilarWordVote(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("book_id:");
//        sb.append(this.book_id);
//        sb.append(", ");
//        sb.append("similar_word_id:");
//        sb.append(this.similar_word_id);
//        sb.append(", ");
//        sb.append("is_similar:");
//        sb.append(this.is_similar);
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
