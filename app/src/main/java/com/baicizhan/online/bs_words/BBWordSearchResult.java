//package com.baicizhan.online.bs_words;
//
//import com.p052e.p053a.p054a.JceStruct;
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
//public class BBWordSearchResult implements Serializable, Cloneable, Comparable<BBWordSearchResult>, C2116f<BBWordSearchResult, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b MEAN_CN_FIELD_DESC = new C2097b("mean_cn", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordSearchResult");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FIELD_DESC = new C2097b("word", JceStruct.STRUCT_END, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_LEVEL_ID_FIELD_DESC = new C2097b("word_level_id", 8, 3);
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    private static final int __WORD_LEVEL_ID_ISSET_ID = 1;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String mean_cn;
//    public int topic_id;
//    public String word;
//    public int word_level_id;
//
//    class BBWordSearchResultStandardScheme extends C2110c<BBWordSearchResult> {
//        private BBWordSearchResultStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordSearchResult bBWordSearchResult) {
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
//                                bBWordSearchResult.word = fVar.mo18516q();
//                                bBWordSearchResult.setWordIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordSearchResult.topic_id = fVar.mo18513n();
//                                bBWordSearchResult.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordSearchResult.word_level_id = fVar.mo18513n();
//                                bBWordSearchResult.setWord_level_idIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordSearchResult.mean_cn = fVar.mo18516q();
//                                bBWordSearchResult.setMean_cnIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBWordSearchResult.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBWordSearchResult.isSetWord_level_id()) {
//                        throw new C2101g("Required field 'word_level_id' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBWordSearchResult.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordSearchResult bBWordSearchResult) {
//            bBWordSearchResult.validate();
//            BBWordSearchResult.STRUCT_DESC;
//            fVar.mo18490a();
//            if (bBWordSearchResult.word != null) {
//                fVar.mo18496a(BBWordSearchResult.WORD_FIELD_DESC);
//                fVar.mo18495a(bBWordSearchResult.word);
//            }
//            fVar.mo18496a(BBWordSearchResult.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordSearchResult.topic_id);
//            fVar.mo18496a(BBWordSearchResult.WORD_LEVEL_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordSearchResult.word_level_id);
//            if (bBWordSearchResult.mean_cn != null) {
//                fVar.mo18496a(BBWordSearchResult.MEAN_CN_FIELD_DESC);
//                fVar.mo18495a(bBWordSearchResult.mean_cn);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordSearchResultStandardSchemeFactory implements C2109b {
//        private BBWordSearchResultStandardSchemeFactory() {
//        }
//
//        public BBWordSearchResultStandardScheme getScheme() {
//            return new BBWordSearchResultStandardScheme();
//        }
//    }
//
//    class BBWordSearchResultTupleScheme extends C2111d<BBWordSearchResult> {
//        private BBWordSearchResultTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordSearchResult bBWordSearchResult) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18495a(bBWordSearchResult.word);
//            lVar.mo18493a(bBWordSearchResult.topic_id);
//            lVar.mo18493a(bBWordSearchResult.word_level_id);
//            lVar.mo18495a(bBWordSearchResult.mean_cn);
//        }
//
//        public void read(C2100f fVar, BBWordSearchResult bBWordSearchResult) {
//            C2106l lVar = (C2106l) fVar;
//            bBWordSearchResult.word = lVar.mo18516q();
//            bBWordSearchResult.setWordIsSet(true);
//            bBWordSearchResult.topic_id = lVar.mo18513n();
//            bBWordSearchResult.setTopic_idIsSet(true);
//            bBWordSearchResult.word_level_id = lVar.mo18513n();
//            bBWordSearchResult.setWord_level_idIsSet(true);
//            bBWordSearchResult.mean_cn = lVar.mo18516q();
//            bBWordSearchResult.setMean_cnIsSet(true);
//        }
//    }
//
//    class BBWordSearchResultTupleSchemeFactory implements C2109b {
//        private BBWordSearchResultTupleSchemeFactory() {
//        }
//
//        public BBWordSearchResultTupleScheme getScheme() {
//            return new BBWordSearchResultTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        WORD(1, "word"),
//        TOPIC_ID(2, "topic_id"),
//        WORD_LEVEL_ID(3, "word_level_id"),
//        MEAN_CN(4, "mean_cn");
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
//                    return WORD;
//                case 2:
//                    return TOPIC_ID;
//                case 3:
//                    return WORD_LEVEL_ID;
//                case 4:
//                    return MEAN_CN;
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
//        hashMap.put(C2110c.class, new BBWordSearchResultStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordSearchResultTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.WORD, new C2091a("word", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.WORD_LEVEL_ID, new C2091a("word_level_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.MEAN_CN, new C2091a("mean_cn", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordSearchResult.class, metaDataMap);
//    }
//
//    public BBWordSearchResult() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBWordSearchResult(String str, int i, int i2, String str2) {
//        this();
//        this.word = str;
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.word_level_id = i2;
//        setWord_level_idIsSet(true);
//        this.mean_cn = str2;
//    }
//
//    public BBWordSearchResult(BBWordSearchResult bBWordSearchResult) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBWordSearchResult.__isset_bitfield;
//        if (bBWordSearchResult.isSetWord()) {
//            this.word = bBWordSearchResult.word;
//        }
//        this.topic_id = bBWordSearchResult.topic_id;
//        this.word_level_id = bBWordSearchResult.word_level_id;
//        if (bBWordSearchResult.isSetMean_cn()) {
//            this.mean_cn = bBWordSearchResult.mean_cn;
//        }
//    }
//
//    public BBWordSearchResult deepCopy() {
//        return new BBWordSearchResult(this);
//    }
//
//    public void clear() {
//        this.word = null;
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        setWord_level_idIsSet(false);
//        this.word_level_id = 0;
//        this.mean_cn = null;
//    }
//
//    public String getWord() {
//        return this.word;
//    }
//
//    public BBWordSearchResult setWord(String str) {
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
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBWordSearchResult setTopic_id(int i) {
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
//    public int getWord_level_id() {
//        return this.word_level_id;
//    }
//
//    public BBWordSearchResult setWord_level_id(int i) {
//        this.word_level_id = i;
//        setWord_level_idIsSet(true);
//        return this;
//    }
//
//    public void unsetWord_level_id() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetWord_level_id() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setWord_level_idIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public String getMean_cn() {
//        return this.mean_cn;
//    }
//
//    public BBWordSearchResult setMean_cn(String str) {
//        this.mean_cn = str;
//        return this;
//    }
//
//    public void unsetMean_cn() {
//        this.mean_cn = null;
//    }
//
//    public boolean isSetMean_cn() {
//        return this.mean_cn != null;
//    }
//
//    public void setMean_cnIsSet(boolean z) {
//        if (!z) {
//            this.mean_cn = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case WORD:
//                if (obj == null) {
//                    unsetWord();
//                    return;
//                } else {
//                    setWord((String) obj);
//                    return;
//                }
//            case TOPIC_ID:
//                if (obj == null) {
//                    unsetTopic_id();
//                    return;
//                } else {
//                    setTopic_id(((Integer) obj).intValue());
//                    return;
//                }
//            case WORD_LEVEL_ID:
//                if (obj == null) {
//                    unsetWord_level_id();
//                    return;
//                } else {
//                    setWord_level_id(((Integer) obj).intValue());
//                    return;
//                }
//            case MEAN_CN:
//                if (obj == null) {
//                    unsetMean_cn();
//                    return;
//                } else {
//                    setMean_cn((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case WORD:
//                return getWord();
//            case TOPIC_ID:
//                return Integer.valueOf(getTopic_id());
//            case WORD_LEVEL_ID:
//                return Integer.valueOf(getWord_level_id());
//            case MEAN_CN:
//                return getMean_cn();
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
//            case WORD:
//                return isSetWord();
//            case TOPIC_ID:
//                return isSetTopic_id();
//            case WORD_LEVEL_ID:
//                return isSetWord_level_id();
//            case MEAN_CN:
//                return isSetMean_cn();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordSearchResult)) {
//            return equals((BBWordSearchResult) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordSearchResult bBWordSearchResult) {
//        if (bBWordSearchResult == null) {
//            return false;
//        }
//        boolean isSetWord = isSetWord();
//        boolean isSetWord2 = bBWordSearchResult.isSetWord();
//        if (((isSetWord || isSetWord2) && (!isSetWord || !isSetWord2 || !this.word.equals(bBWordSearchResult.word))) || this.topic_id != bBWordSearchResult.topic_id || this.word_level_id != bBWordSearchResult.word_level_id) {
//            return false;
//        }
//        boolean isSetMean_cn = isSetMean_cn();
//        boolean isSetMean_cn2 = bBWordSearchResult.isSetMean_cn();
//        if ((isSetMean_cn || isSetMean_cn2) && (!isSetMean_cn || !isSetMean_cn2 || !this.mean_cn.equals(bBWordSearchResult.mean_cn))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordSearchResult bBWordSearchResult) {
//        if (!getClass().equals(bBWordSearchResult.getClass())) {
//            return getClass().getName().compareTo(bBWordSearchResult.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetWord()).compareTo(Boolean.valueOf(bBWordSearchResult.isSetWord()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetWord()) {
//            int a = C2121h.m5525a(this.word, bBWordSearchResult.word);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBWordSearchResult.isSetTopic_id()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetTopic_id()) {
//            int a2 = C2121h.m5522a(this.topic_id, bBWordSearchResult.topic_id);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetWord_level_id()).compareTo(Boolean.valueOf(bBWordSearchResult.isSetWord_level_id()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetWord_level_id()) {
//            int a3 = C2121h.m5522a(this.word_level_id, bBWordSearchResult.word_level_id);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetMean_cn()).compareTo(Boolean.valueOf(bBWordSearchResult.isSetMean_cn()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetMean_cn()) {
//            int a4 = C2121h.m5525a(this.mean_cn, bBWordSearchResult.mean_cn);
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
//        StringBuilder sb = new StringBuilder("BBWordSearchResult(");
//        sb.append("word:");
//        if (this.word == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word);
//        }
//        sb.append(", ");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("word_level_id:");
//        sb.append(this.word_level_id);
//        sb.append(", ");
//        sb.append("mean_cn:");
//        if (this.mean_cn == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.mean_cn);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.word == null) {
//            throw new C2101g("Required field 'word' was not present! Struct: " + toString());
//        } else if (this.mean_cn == null) {
//            throw new C2101g("Required field 'mean_cn' was not present! Struct: " + toString());
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
