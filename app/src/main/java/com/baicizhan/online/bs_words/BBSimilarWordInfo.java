//package com.baicizhan.online.bs_words;
//
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
//public class BBSimilarWordInfo implements Serializable, Cloneable, Comparable<BBSimilarWordInfo>, C2116f<BBSimilarWordInfo, BBSimilarWordInfo._Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b SIMILAR_WORD_BOOK_ID_FIELD_DESC = new C2097b("similar_word_book_id", 8, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b SIMILAR_WORD_ID_FIELD_DESC = new C2097b("similar_word_id", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBSimilarWordInfo");
//    /* access modifiers changed from: private */
//    public static final C2097b TIPS_FIELD_DESC = new C2097b("tips", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FIELD_DESC = new C2097b("word", JceStruct.STRUCT_END, 5);
//    private static final int __SIMILAR_WORD_BOOK_ID_ISSET_ID = 2;
//    private static final int __SIMILAR_WORD_ID_ISSET_ID = 1;
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    private _Fields[] optionals;
//    public int similar_word_book_id;
//    public int similar_word_id;
//    public String tips;
//    public int topic_id;
//    public String word;
//
//    class BBSimilarWordInfoStandardScheme extends C2110c<BBSimilarWordInfo> {
//        private BBSimilarWordInfoStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBSimilarWordInfo bBSimilarWordInfo) {
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
//                                bBSimilarWordInfo.topic_id = fVar.mo18513n();
//                                bBSimilarWordInfo.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSimilarWordInfo.similar_word_id = fVar.mo18513n();
//                                bBSimilarWordInfo.setSimilar_word_idIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSimilarWordInfo.similar_word_book_id = fVar.mo18513n();
//                                bBSimilarWordInfo.setSimilar_word_book_idIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSimilarWordInfo.tips = fVar.mo18516q();
//                                bBSimilarWordInfo.setTipsIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSimilarWordInfo.word = fVar.mo18516q();
//                                bBSimilarWordInfo.setWordIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBSimilarWordInfo.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBSimilarWordInfo.isSetSimilar_word_id()) {
//                        throw new C2101g("Required field 'similar_word_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBSimilarWordInfo.isSetSimilar_word_book_id()) {
//                        throw new C2101g("Required field 'similar_word_book_id' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBSimilarWordInfo.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBSimilarWordInfo bBSimilarWordInfo) {
//            bBSimilarWordInfo.validate();
////            BBSimilarWordInfo.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBSimilarWordInfo.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBSimilarWordInfo.topic_id);
//            fVar.mo18496a(BBSimilarWordInfo.SIMILAR_WORD_ID_FIELD_DESC);
//            fVar.mo18493a(bBSimilarWordInfo.similar_word_id);
//            fVar.mo18496a(BBSimilarWordInfo.SIMILAR_WORD_BOOK_ID_FIELD_DESC);
//            fVar.mo18493a(bBSimilarWordInfo.similar_word_book_id);
//            if (bBSimilarWordInfo.tips != null) {
//                fVar.mo18496a(BBSimilarWordInfo.TIPS_FIELD_DESC);
//                fVar.mo18495a(bBSimilarWordInfo.tips);
//            }
//            if (bBSimilarWordInfo.word != null && bBSimilarWordInfo.isSetWord()) {
//                fVar.mo18496a(BBSimilarWordInfo.WORD_FIELD_DESC);
//                fVar.mo18495a(bBSimilarWordInfo.word);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBSimilarWordInfoStandardSchemeFactory implements C2109b {
//        private BBSimilarWordInfoStandardSchemeFactory() {
//        }
//
//        public BBSimilarWordInfoStandardScheme getScheme() {
//            return new BBSimilarWordInfoStandardScheme();
//        }
//    }
//
//    class BBSimilarWordInfoTupleScheme extends C2111d<BBSimilarWordInfo> {
//        private BBSimilarWordInfoTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBSimilarWordInfo bBSimilarWordInfo) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBSimilarWordInfo.topic_id);
//            lVar.mo18493a(bBSimilarWordInfo.similar_word_id);
//            lVar.mo18493a(bBSimilarWordInfo.similar_word_book_id);
//            lVar.mo18495a(bBSimilarWordInfo.tips);
//            BitSet bitSet = new BitSet();
//            if (bBSimilarWordInfo.isSetWord()) {
//                bitSet.set(0);
//            }
//            lVar.mo18527a(bitSet, 1);
//            if (bBSimilarWordInfo.isSetWord()) {
//                lVar.mo18495a(bBSimilarWordInfo.word);
//            }
//        }
//
//        public void read(C2100f fVar, BBSimilarWordInfo bBSimilarWordInfo) {
//            C2106l lVar = (C2106l) fVar;
//            bBSimilarWordInfo.topic_id = lVar.mo18513n();
//            bBSimilarWordInfo.setTopic_idIsSet(true);
//            bBSimilarWordInfo.similar_word_id = lVar.mo18513n();
//            bBSimilarWordInfo.setSimilar_word_idIsSet(true);
//            bBSimilarWordInfo.similar_word_book_id = lVar.mo18513n();
//            bBSimilarWordInfo.setSimilar_word_book_idIsSet(true);
//            bBSimilarWordInfo.tips = lVar.mo18516q();
//            bBSimilarWordInfo.setTipsIsSet(true);
//            if (lVar.mo18528b(1).get(0)) {
//                bBSimilarWordInfo.word = lVar.mo18516q();
//                bBSimilarWordInfo.setWordIsSet(true);
//            }
//        }
//    }
//
//    class BBSimilarWordInfoTupleSchemeFactory implements C2109b {
//        private BBSimilarWordInfoTupleSchemeFactory() {
//        }
//
//        public BBSimilarWordInfoTupleScheme getScheme() {
//            return new BBSimilarWordInfoTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        SIMILAR_WORD_ID(2, "similar_word_id"),
//        SIMILAR_WORD_BOOK_ID(3, "similar_word_book_id"),
//        TIPS(4, "tips"),
//        WORD(5, "word");
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
//                    return SIMILAR_WORD_ID;
//                case 3:
//                    return SIMILAR_WORD_BOOK_ID;
//                case 4:
//                    return TIPS;
//                case 5:
//                    return WORD;
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
//        hashMap.put(C2110c.class, new BBSimilarWordInfoStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBSimilarWordInfoTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SIMILAR_WORD_ID, new C2091a("similar_word_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.SIMILAR_WORD_BOOK_ID, new C2091a("similar_word_book_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.TIPS, new C2091a("tips", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WORD, new C2091a("word", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBSimilarWordInfo.class, metaDataMap);
//    }
//
//    public BBSimilarWordInfo() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.WORD};
//    }
//
//    public BBSimilarWordInfo(int i, int i2, int i3, String str) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.similar_word_id = i2;
//        setSimilar_word_idIsSet(true);
//        this.similar_word_book_id = i3;
//        setSimilar_word_book_idIsSet(true);
//        this.tips = str;
//    }
//
//    public BBSimilarWordInfo(BBSimilarWordInfo bBSimilarWordInfo) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.WORD};
//        this.__isset_bitfield = bBSimilarWordInfo.__isset_bitfield;
//        this.topic_id = bBSimilarWordInfo.topic_id;
//        this.similar_word_id = bBSimilarWordInfo.similar_word_id;
//        this.similar_word_book_id = bBSimilarWordInfo.similar_word_book_id;
//        if (bBSimilarWordInfo.isSetTips()) {
//            this.tips = bBSimilarWordInfo.tips;
//        }
//        if (bBSimilarWordInfo.isSetWord()) {
//            this.word = bBSimilarWordInfo.word;
//        }
//    }
//
//    public BBSimilarWordInfo deepCopy() {
//        return new BBSimilarWordInfo(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        setSimilar_word_idIsSet(false);
//        this.similar_word_id = 0;
//        setSimilar_word_book_idIsSet(false);
//        this.similar_word_book_id = 0;
//        this.tips = null;
//        this.word = null;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBSimilarWordInfo setTopic_id(int i) {
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
//    public int getSimilar_word_id() {
//        return this.similar_word_id;
//    }
//
//    public BBSimilarWordInfo setSimilar_word_id(int i) {
//        this.similar_word_id = i;
//        setSimilar_word_idIsSet(true);
//        return this;
//    }
//
//    public void unsetSimilar_word_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetSimilar_word_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setSimilar_word_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public int getSimilar_word_book_id() {
//        return this.similar_word_book_id;
//    }
//
//    public BBSimilarWordInfo setSimilar_word_book_id(int i) {
//        this.similar_word_book_id = i;
//        setSimilar_word_book_idIsSet(true);
//        return this;
//    }
//
//    public void unsetSimilar_word_book_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetSimilar_word_book_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setSimilar_word_book_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public String getTips() {
//        return this.tips;
//    }
//
//    public BBSimilarWordInfo setTips(String str) {
//        this.tips = str;
//        return this;
//    }
//
//    public void unsetTips() {
//        this.tips = null;
//    }
//
//    public boolean isSetTips() {
//        return this.tips != null;
//    }
//
//    public void setTipsIsSet(boolean z) {
//        if (!z) {
//            this.tips = null;
//        }
//    }
//
//    public String getWord() {
//        return this.word;
//    }
//
//    public BBSimilarWordInfo setWord(String str) {
//        this.word = str;
//        return this;
//    }
//
//    public void unsetWord() {
//        this.word = null;
//    }
//
//    public boolean isSetWord() {
//        return this.word != null;
//    }
//
//    public void setWordIsSet(boolean z) {
//        if (!z) {
//            this.word = null;
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
//            case SIMILAR_WORD_ID:
//                if (obj == null) {
//                    unsetSimilar_word_id();
//                    return;
//                } else {
//                    setSimilar_word_id(((Integer) obj).intValue());
//                    return;
//                }
//            case SIMILAR_WORD_BOOK_ID:
//                if (obj == null) {
//                    unsetSimilar_word_book_id();
//                    return;
//                } else {
//                    setSimilar_word_book_id(((Integer) obj).intValue());
//                    return;
//                }
//            case TIPS:
//                if (obj == null) {
//                    unsetTips();
//                    return;
//                } else {
//                    setTips((String) obj);
//                    return;
//                }
//            case WORD:
//                if (obj == null) {
//                    unsetWord();
//                    return;
//                } else {
//                    setWord((String) obj);
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
//            case SIMILAR_WORD_ID:
//                return Integer.valueOf(getSimilar_word_id());
//            case SIMILAR_WORD_BOOK_ID:
//                return Integer.valueOf(getSimilar_word_book_id());
//            case TIPS:
//                return getTips();
//            case WORD:
//                return getWord();
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
//            case SIMILAR_WORD_ID:
//                return isSetSimilar_word_id();
//            case SIMILAR_WORD_BOOK_ID:
//                return isSetSimilar_word_book_id();
//            case TIPS:
//                return isSetTips();
//            case WORD:
//                return isSetWord();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBSimilarWordInfo)) {
//            return equals((BBSimilarWordInfo) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBSimilarWordInfo bBSimilarWordInfo) {
//        if (bBSimilarWordInfo == null || this.topic_id != bBSimilarWordInfo.topic_id || this.similar_word_id != bBSimilarWordInfo.similar_word_id || this.similar_word_book_id != bBSimilarWordInfo.similar_word_book_id) {
//            return false;
//        }
//        boolean isSetTips = isSetTips();
//        boolean isSetTips2 = bBSimilarWordInfo.isSetTips();
//        if ((isSetTips || isSetTips2) && (!isSetTips || !isSetTips2 || !this.tips.equals(bBSimilarWordInfo.tips))) {
//            return false;
//        }
//        boolean isSetWord = isSetWord();
//        boolean isSetWord2 = bBSimilarWordInfo.isSetWord();
//        if ((isSetWord || isSetWord2) && (!isSetWord || !isSetWord2 || !this.word.equals(bBSimilarWordInfo.word))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBSimilarWordInfo bBSimilarWordInfo) {
//        if (!getClass().equals(bBSimilarWordInfo.getClass())) {
//            return getClass().getName().compareTo(bBSimilarWordInfo.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBSimilarWordInfo.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBSimilarWordInfo.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetSimilar_word_id()).compareTo(Boolean.valueOf(bBSimilarWordInfo.isSetSimilar_word_id()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetSimilar_word_id()) {
//            int a2 = C2121h.m5522a(this.similar_word_id, bBSimilarWordInfo.similar_word_id);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetSimilar_word_book_id()).compareTo(Boolean.valueOf(bBSimilarWordInfo.isSetSimilar_word_book_id()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetSimilar_word_book_id()) {
//            int a3 = C2121h.m5522a(this.similar_word_book_id, bBSimilarWordInfo.similar_word_book_id);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetTips()).compareTo(Boolean.valueOf(bBSimilarWordInfo.isSetTips()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetTips()) {
//            int a4 = C2121h.m5525a(this.tips, bBSimilarWordInfo.tips);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetWord()).compareTo(Boolean.valueOf(bBSimilarWordInfo.isSetWord()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetWord()) {
//            int a5 = C2121h.m5525a(this.word, bBSimilarWordInfo.word);
//            if (a5 != 0) {
//                return a5;
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
//        StringBuilder sb = new StringBuilder("BBSimilarWordInfo(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("similar_word_id:");
//        sb.append(this.similar_word_id);
//        sb.append(", ");
//        sb.append("similar_word_book_id:");
//        sb.append(this.similar_word_book_id);
//        sb.append(", ");
//        sb.append("tips:");
//        if (this.tips == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.tips);
//        }
//        if (isSetWord()) {
//            sb.append(", ");
//            sb.append("word:");
//            if (this.word == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.word);
//            }
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.tips == null) {
//            throw new C2101g("Required field 'tips' was not present! Struct: " + toString());
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
