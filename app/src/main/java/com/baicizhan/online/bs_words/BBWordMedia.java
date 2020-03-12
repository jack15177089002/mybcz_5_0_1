//package com.baicizhan.online.bs_words;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB.Columns;
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
//public class BBWordMedia implements Serializable, Cloneable, Comparable<BBWordMedia>, C2116f<BBWordMedia, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b AMR_AUDIO_PATH_FIELD_DESC = new C2097b(Columns.AMR_AUDIO_PATH, JceStruct.STRUCT_END, 3);
//    /* access modifiers changed from: private */
//    public static final C2097b FM_UPDATED_AT_FIELD_DESC = new C2097b("fm_updated_at", 10, 9);
//    /* access modifiers changed from: private */
//    public static final C2097b M4A_AUDIO_PATH_FIELD_DESC = new C2097b(Columns.M4A_AUDIO_PATH, JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBWordMedia");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b TV_PATH_FIELD_DESC = new C2097b(Columns.TV_PATH, JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b TV_UPDATED_AT_FIELD_DESC = new C2097b("tv_updated_at", 10, 10);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FIELD_DESC = new C2097b("word", JceStruct.STRUCT_END, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_MEAN_CN_FIELD_DESC = new C2097b("word_mean_cn", JceStruct.STRUCT_END, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_SENTENCE_FIELD_DESC = new C2097b("word_sentence", JceStruct.STRUCT_END, 8);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_TYPE_FIELD_DESC = new C2097b("word_type", JceStruct.STRUCT_END, 7);
//    private static final int __FM_UPDATED_AT_ISSET_ID = 1;
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    private static final int __TV_UPDATED_AT_ISSET_ID = 2;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String amr_audio_path;
//    public long fm_updated_at;
//    public String m4a_audio_path;
//    private _Fields[] optionals;
//    public int topic_id;
//    public String tv_path;
//    public long tv_updated_at;
//    public String word;
//    public String word_mean_cn;
//    public String word_sentence;
//    public String word_type;
//
//    class BBWordMediaStandardScheme extends C2110c<BBWordMedia> {
//        private BBWordMediaStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBWordMedia bBWordMedia) {
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
//                                bBWordMedia.topic_id = fVar.mo18513n();
//                                bBWordMedia.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMedia.m4a_audio_path = fVar.mo18516q();
//                                bBWordMedia.setM4a_audio_pathIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMedia.amr_audio_path = fVar.mo18516q();
//                                bBWordMedia.setAmr_audio_pathIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMedia.tv_path = fVar.mo18516q();
//                                bBWordMedia.setTv_pathIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMedia.word = fVar.mo18516q();
//                                bBWordMedia.setWordIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMedia.word_mean_cn = fVar.mo18516q();
//                                bBWordMedia.setWord_mean_cnIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMedia.word_type = fVar.mo18516q();
//                                bBWordMedia.setWord_typeIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMedia.word_sentence = fVar.mo18516q();
//                                bBWordMedia.setWord_sentenceIsSet(true);
//                                break;
//                            }
//                        case 9:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMedia.fm_updated_at = fVar.mo18514o();
//                                bBWordMedia.setFm_updated_atIsSet(true);
//                                break;
//                            }
//                        case 10:
//                            if (g.f5835b != 10) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBWordMedia.tv_updated_at = fVar.mo18514o();
//                                bBWordMedia.setTv_updated_atIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBWordMedia.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBWordMedia.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBWordMedia bBWordMedia) {
//            bBWordMedia.validate();
//            BBWordMedia.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBWordMedia.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBWordMedia.topic_id);
//            if (bBWordMedia.m4a_audio_path != null && bBWordMedia.isSetM4a_audio_path()) {
//                fVar.mo18496a(BBWordMedia.M4A_AUDIO_PATH_FIELD_DESC);
//                fVar.mo18495a(bBWordMedia.m4a_audio_path);
//            }
//            if (bBWordMedia.amr_audio_path != null && bBWordMedia.isSetAmr_audio_path()) {
//                fVar.mo18496a(BBWordMedia.AMR_AUDIO_PATH_FIELD_DESC);
//                fVar.mo18495a(bBWordMedia.amr_audio_path);
//            }
//            if (bBWordMedia.tv_path != null && bBWordMedia.isSetTv_path()) {
//                fVar.mo18496a(BBWordMedia.TV_PATH_FIELD_DESC);
//                fVar.mo18495a(bBWordMedia.tv_path);
//            }
//            if (bBWordMedia.word != null && bBWordMedia.isSetWord()) {
//                fVar.mo18496a(BBWordMedia.WORD_FIELD_DESC);
//                fVar.mo18495a(bBWordMedia.word);
//            }
//            if (bBWordMedia.word_mean_cn != null && bBWordMedia.isSetWord_mean_cn()) {
//                fVar.mo18496a(BBWordMedia.WORD_MEAN_CN_FIELD_DESC);
//                fVar.mo18495a(bBWordMedia.word_mean_cn);
//            }
//            if (bBWordMedia.word_type != null && bBWordMedia.isSetWord_type()) {
//                fVar.mo18496a(BBWordMedia.WORD_TYPE_FIELD_DESC);
//                fVar.mo18495a(bBWordMedia.word_type);
//            }
//            if (bBWordMedia.word_sentence != null && bBWordMedia.isSetWord_sentence()) {
//                fVar.mo18496a(BBWordMedia.WORD_SENTENCE_FIELD_DESC);
//                fVar.mo18495a(bBWordMedia.word_sentence);
//            }
//            if (bBWordMedia.isSetFm_updated_at()) {
//                fVar.mo18496a(BBWordMedia.FM_UPDATED_AT_FIELD_DESC);
//                fVar.mo18494a(bBWordMedia.fm_updated_at);
//            }
//            if (bBWordMedia.isSetTv_updated_at()) {
//                fVar.mo18496a(BBWordMedia.TV_UPDATED_AT_FIELD_DESC);
//                fVar.mo18494a(bBWordMedia.tv_updated_at);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBWordMediaStandardSchemeFactory implements C2109b {
//        private BBWordMediaStandardSchemeFactory() {
//        }
//
//        public BBWordMediaStandardScheme getScheme() {
//            return new BBWordMediaStandardScheme();
//        }
//    }
//
//    class BBWordMediaTupleScheme extends C2111d<BBWordMedia> {
//        private BBWordMediaTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBWordMedia bBWordMedia) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBWordMedia.topic_id);
//            BitSet bitSet = new BitSet();
//            if (bBWordMedia.isSetM4a_audio_path()) {
//                bitSet.set(0);
//            }
//            if (bBWordMedia.isSetAmr_audio_path()) {
//                bitSet.set(1);
//            }
//            if (bBWordMedia.isSetTv_path()) {
//                bitSet.set(2);
//            }
//            if (bBWordMedia.isSetWord()) {
//                bitSet.set(3);
//            }
//            if (bBWordMedia.isSetWord_mean_cn()) {
//                bitSet.set(4);
//            }
//            if (bBWordMedia.isSetWord_type()) {
//                bitSet.set(5);
//            }
//            if (bBWordMedia.isSetWord_sentence()) {
//                bitSet.set(6);
//            }
//            if (bBWordMedia.isSetFm_updated_at()) {
//                bitSet.set(7);
//            }
//            if (bBWordMedia.isSetTv_updated_at()) {
//                bitSet.set(8);
//            }
//            lVar.mo18527a(bitSet, 9);
//            if (bBWordMedia.isSetM4a_audio_path()) {
//                lVar.mo18495a(bBWordMedia.m4a_audio_path);
//            }
//            if (bBWordMedia.isSetAmr_audio_path()) {
//                lVar.mo18495a(bBWordMedia.amr_audio_path);
//            }
//            if (bBWordMedia.isSetTv_path()) {
//                lVar.mo18495a(bBWordMedia.tv_path);
//            }
//            if (bBWordMedia.isSetWord()) {
//                lVar.mo18495a(bBWordMedia.word);
//            }
//            if (bBWordMedia.isSetWord_mean_cn()) {
//                lVar.mo18495a(bBWordMedia.word_mean_cn);
//            }
//            if (bBWordMedia.isSetWord_type()) {
//                lVar.mo18495a(bBWordMedia.word_type);
//            }
//            if (bBWordMedia.isSetWord_sentence()) {
//                lVar.mo18495a(bBWordMedia.word_sentence);
//            }
//            if (bBWordMedia.isSetFm_updated_at()) {
//                lVar.mo18494a(bBWordMedia.fm_updated_at);
//            }
//            if (bBWordMedia.isSetTv_updated_at()) {
//                lVar.mo18494a(bBWordMedia.tv_updated_at);
//            }
//        }
//
//        public void read(C2100f fVar, BBWordMedia bBWordMedia) {
//            C2106l lVar = (C2106l) fVar;
//            bBWordMedia.topic_id = lVar.mo18513n();
//            bBWordMedia.setTopic_idIsSet(true);
//            BitSet b = lVar.mo18528b(9);
//            if (b.get(0)) {
//                bBWordMedia.m4a_audio_path = lVar.mo18516q();
//                bBWordMedia.setM4a_audio_pathIsSet(true);
//            }
//            if (b.get(1)) {
//                bBWordMedia.amr_audio_path = lVar.mo18516q();
//                bBWordMedia.setAmr_audio_pathIsSet(true);
//            }
//            if (b.get(2)) {
//                bBWordMedia.tv_path = lVar.mo18516q();
//                bBWordMedia.setTv_pathIsSet(true);
//            }
//            if (b.get(3)) {
//                bBWordMedia.word = lVar.mo18516q();
//                bBWordMedia.setWordIsSet(true);
//            }
//            if (b.get(4)) {
//                bBWordMedia.word_mean_cn = lVar.mo18516q();
//                bBWordMedia.setWord_mean_cnIsSet(true);
//            }
//            if (b.get(5)) {
//                bBWordMedia.word_type = lVar.mo18516q();
//                bBWordMedia.setWord_typeIsSet(true);
//            }
//            if (b.get(6)) {
//                bBWordMedia.word_sentence = lVar.mo18516q();
//                bBWordMedia.setWord_sentenceIsSet(true);
//            }
//            if (b.get(7)) {
//                bBWordMedia.fm_updated_at = lVar.mo18514o();
//                bBWordMedia.setFm_updated_atIsSet(true);
//            }
//            if (b.get(8)) {
//                bBWordMedia.tv_updated_at = lVar.mo18514o();
//                bBWordMedia.setTv_updated_atIsSet(true);
//            }
//        }
//    }
//
//    class BBWordMediaTupleSchemeFactory implements C2109b {
//        private BBWordMediaTupleSchemeFactory() {
//        }
//
//        public BBWordMediaTupleScheme getScheme() {
//            return new BBWordMediaTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        M4A_AUDIO_PATH(2, Columns.M4A_AUDIO_PATH),
//        AMR_AUDIO_PATH(3, Columns.AMR_AUDIO_PATH),
//        TV_PATH(4, Columns.TV_PATH),
//        WORD(5, "word"),
//        WORD_MEAN_CN(6, "word_mean_cn"),
//        WORD_TYPE(7, "word_type"),
//        WORD_SENTENCE(8, "word_sentence"),
//        FM_UPDATED_AT(9, "fm_updated_at"),
//        TV_UPDATED_AT(10, "tv_updated_at");
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
//                    return M4A_AUDIO_PATH;
//                case 3:
//                    return AMR_AUDIO_PATH;
//                case 4:
//                    return TV_PATH;
//                case 5:
//                    return WORD;
//                case 6:
//                    return WORD_MEAN_CN;
//                case 7:
//                    return WORD_TYPE;
//                case 8:
//                    return WORD_SENTENCE;
//                case 9:
//                    return FM_UPDATED_AT;
//                case 10:
//                    return TV_UPDATED_AT;
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
//        hashMap.put(C2110c.class, new BBWordMediaStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBWordMediaTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.M4A_AUDIO_PATH, new C2091a(Columns.M4A_AUDIO_PATH, 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.AMR_AUDIO_PATH, new C2091a(Columns.AMR_AUDIO_PATH, 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.TV_PATH, new C2091a(Columns.TV_PATH, 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WORD, new C2091a("word", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WORD_MEAN_CN, new C2091a("word_mean_cn", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WORD_TYPE, new C2091a("word_type", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WORD_SENTENCE, new C2091a("word_sentence", 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.FM_UPDATED_AT, new C2091a("fm_updated_at", 2, new C2092b(10, 0)));
//        enumMap.put(_Fields.TV_UPDATED_AT, new C2091a("tv_updated_at", 2, new C2092b(10, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBWordMedia.class, metaDataMap);
//    }
//
//    public BBWordMedia() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.M4A_AUDIO_PATH, _Fields.AMR_AUDIO_PATH, _Fields.TV_PATH, _Fields.WORD, _Fields.WORD_MEAN_CN, _Fields.WORD_TYPE, _Fields.WORD_SENTENCE, _Fields.FM_UPDATED_AT, _Fields.TV_UPDATED_AT};
//    }
//
//    public BBWordMedia(int i) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//    }
//
//    public BBWordMedia(BBWordMedia bBWordMedia) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.M4A_AUDIO_PATH, _Fields.AMR_AUDIO_PATH, _Fields.TV_PATH, _Fields.WORD, _Fields.WORD_MEAN_CN, _Fields.WORD_TYPE, _Fields.WORD_SENTENCE, _Fields.FM_UPDATED_AT, _Fields.TV_UPDATED_AT};
//        this.__isset_bitfield = bBWordMedia.__isset_bitfield;
//        this.topic_id = bBWordMedia.topic_id;
//        if (bBWordMedia.isSetM4a_audio_path()) {
//            this.m4a_audio_path = bBWordMedia.m4a_audio_path;
//        }
//        if (bBWordMedia.isSetAmr_audio_path()) {
//            this.amr_audio_path = bBWordMedia.amr_audio_path;
//        }
//        if (bBWordMedia.isSetTv_path()) {
//            this.tv_path = bBWordMedia.tv_path;
//        }
//        if (bBWordMedia.isSetWord()) {
//            this.word = bBWordMedia.word;
//        }
//        if (bBWordMedia.isSetWord_mean_cn()) {
//            this.word_mean_cn = bBWordMedia.word_mean_cn;
//        }
//        if (bBWordMedia.isSetWord_type()) {
//            this.word_type = bBWordMedia.word_type;
//        }
//        if (bBWordMedia.isSetWord_sentence()) {
//            this.word_sentence = bBWordMedia.word_sentence;
//        }
//        this.fm_updated_at = bBWordMedia.fm_updated_at;
//        this.tv_updated_at = bBWordMedia.tv_updated_at;
//    }
//
//    public BBWordMedia deepCopy() {
//        return new BBWordMedia(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        this.m4a_audio_path = null;
//        this.amr_audio_path = null;
//        this.tv_path = null;
//        this.word = null;
//        this.word_mean_cn = null;
//        this.word_type = null;
//        this.word_sentence = null;
//        setFm_updated_atIsSet(false);
//        this.fm_updated_at = 0;
//        setTv_updated_atIsSet(false);
//        this.tv_updated_at = 0;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBWordMedia setTopic_id(int i) {
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
//    public String getM4a_audio_path() {
//        return this.m4a_audio_path;
//    }
//
//    public BBWordMedia setM4a_audio_path(String str) {
//        this.m4a_audio_path = str;
//        return this;
//    }
//
//    public void unsetM4a_audio_path() {
//        this.m4a_audio_path = null;
//    }
//
//    public boolean isSetM4a_audio_path() {
//        return this.m4a_audio_path != null;
//    }
//
//    public void setM4a_audio_pathIsSet(boolean z) {
//        if (!z) {
//            this.m4a_audio_path = null;
//        }
//    }
//
//    public String getAmr_audio_path() {
//        return this.amr_audio_path;
//    }
//
//    public BBWordMedia setAmr_audio_path(String str) {
//        this.amr_audio_path = str;
//        return this;
//    }
//
//    public void unsetAmr_audio_path() {
//        this.amr_audio_path = null;
//    }
//
//    public boolean isSetAmr_audio_path() {
//        return this.amr_audio_path != null;
//    }
//
//    public void setAmr_audio_pathIsSet(boolean z) {
//        if (!z) {
//            this.amr_audio_path = null;
//        }
//    }
//
//    public String getTv_path() {
//        return this.tv_path;
//    }
//
//    public BBWordMedia setTv_path(String str) {
//        this.tv_path = str;
//        return this;
//    }
//
//    public void unsetTv_path() {
//        this.tv_path = null;
//    }
//
//    public boolean isSetTv_path() {
//        return this.tv_path != null;
//    }
//
//    public void setTv_pathIsSet(boolean z) {
//        if (!z) {
//            this.tv_path = null;
//        }
//    }
//
//    public String getWord() {
//        return this.word;
//    }
//
//    public BBWordMedia setWord(String str) {
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
//    public String getWord_mean_cn() {
//        return this.word_mean_cn;
//    }
//
//    public BBWordMedia setWord_mean_cn(String str) {
//        this.word_mean_cn = str;
//        return this;
//    }
//
//    public void unsetWord_mean_cn() {
//        this.word_mean_cn = null;
//    }
//
//    public boolean isSetWord_mean_cn() {
//        return this.word_mean_cn != null;
//    }
//
//    public void setWord_mean_cnIsSet(boolean z) {
//        if (!z) {
//            this.word_mean_cn = null;
//        }
//    }
//
//    public String getWord_type() {
//        return this.word_type;
//    }
//
//    public BBWordMedia setWord_type(String str) {
//        this.word_type = str;
//        return this;
//    }
//
//    public void unsetWord_type() {
//        this.word_type = null;
//    }
//
//    public boolean isSetWord_type() {
//        return this.word_type != null;
//    }
//
//    public void setWord_typeIsSet(boolean z) {
//        if (!z) {
//            this.word_type = null;
//        }
//    }
//
//    public String getWord_sentence() {
//        return this.word_sentence;
//    }
//
//    public BBWordMedia setWord_sentence(String str) {
//        this.word_sentence = str;
//        return this;
//    }
//
//    public void unsetWord_sentence() {
//        this.word_sentence = null;
//    }
//
//    public boolean isSetWord_sentence() {
//        return this.word_sentence != null;
//    }
//
//    public void setWord_sentenceIsSet(boolean z) {
//        if (!z) {
//            this.word_sentence = null;
//        }
//    }
//
//    public long getFm_updated_at() {
//        return this.fm_updated_at;
//    }
//
//    public BBWordMedia setFm_updated_at(long j) {
//        this.fm_updated_at = j;
//        setFm_updated_atIsSet(true);
//        return this;
//    }
//
//    public void unsetFm_updated_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetFm_updated_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setFm_updated_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public long getTv_updated_at() {
//        return this.tv_updated_at;
//    }
//
//    public BBWordMedia setTv_updated_at(long j) {
//        this.tv_updated_at = j;
//        setTv_updated_atIsSet(true);
//        return this;
//    }
//
//    public void unsetTv_updated_at() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetTv_updated_at() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setTv_updated_atIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
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
//            case M4A_AUDIO_PATH:
//                if (obj == null) {
//                    unsetM4a_audio_path();
//                    return;
//                } else {
//                    setM4a_audio_path((String) obj);
//                    return;
//                }
//            case AMR_AUDIO_PATH:
//                if (obj == null) {
//                    unsetAmr_audio_path();
//                    return;
//                } else {
//                    setAmr_audio_path((String) obj);
//                    return;
//                }
//            case TV_PATH:
//                if (obj == null) {
//                    unsetTv_path();
//                    return;
//                } else {
//                    setTv_path((String) obj);
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
//            case WORD_MEAN_CN:
//                if (obj == null) {
//                    unsetWord_mean_cn();
//                    return;
//                } else {
//                    setWord_mean_cn((String) obj);
//                    return;
//                }
//            case WORD_TYPE:
//                if (obj == null) {
//                    unsetWord_type();
//                    return;
//                } else {
//                    setWord_type((String) obj);
//                    return;
//                }
//            case WORD_SENTENCE:
//                if (obj == null) {
//                    unsetWord_sentence();
//                    return;
//                } else {
//                    setWord_sentence((String) obj);
//                    return;
//                }
//            case FM_UPDATED_AT:
//                if (obj == null) {
//                    unsetFm_updated_at();
//                    return;
//                } else {
//                    setFm_updated_at(((Long) obj).longValue());
//                    return;
//                }
//            case TV_UPDATED_AT:
//                if (obj == null) {
//                    unsetTv_updated_at();
//                    return;
//                } else {
//                    setTv_updated_at(((Long) obj).longValue());
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
//            case M4A_AUDIO_PATH:
//                return getM4a_audio_path();
//            case AMR_AUDIO_PATH:
//                return getAmr_audio_path();
//            case TV_PATH:
//                return getTv_path();
//            case WORD:
//                return getWord();
//            case WORD_MEAN_CN:
//                return getWord_mean_cn();
//            case WORD_TYPE:
//                return getWord_type();
//            case WORD_SENTENCE:
//                return getWord_sentence();
//            case FM_UPDATED_AT:
//                return Long.valueOf(getFm_updated_at());
//            case TV_UPDATED_AT:
//                return Long.valueOf(getTv_updated_at());
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
//            case M4A_AUDIO_PATH:
//                return isSetM4a_audio_path();
//            case AMR_AUDIO_PATH:
//                return isSetAmr_audio_path();
//            case TV_PATH:
//                return isSetTv_path();
//            case WORD:
//                return isSetWord();
//            case WORD_MEAN_CN:
//                return isSetWord_mean_cn();
//            case WORD_TYPE:
//                return isSetWord_type();
//            case WORD_SENTENCE:
//                return isSetWord_sentence();
//            case FM_UPDATED_AT:
//                return isSetFm_updated_at();
//            case TV_UPDATED_AT:
//                return isSetTv_updated_at();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBWordMedia)) {
//            return equals((BBWordMedia) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBWordMedia bBWordMedia) {
//        if (bBWordMedia == null || this.topic_id != bBWordMedia.topic_id) {
//            return false;
//        }
//        boolean isSetM4a_audio_path = isSetM4a_audio_path();
//        boolean isSetM4a_audio_path2 = bBWordMedia.isSetM4a_audio_path();
//        if ((isSetM4a_audio_path || isSetM4a_audio_path2) && (!isSetM4a_audio_path || !isSetM4a_audio_path2 || !this.m4a_audio_path.equals(bBWordMedia.m4a_audio_path))) {
//            return false;
//        }
//        boolean isSetAmr_audio_path = isSetAmr_audio_path();
//        boolean isSetAmr_audio_path2 = bBWordMedia.isSetAmr_audio_path();
//        if ((isSetAmr_audio_path || isSetAmr_audio_path2) && (!isSetAmr_audio_path || !isSetAmr_audio_path2 || !this.amr_audio_path.equals(bBWordMedia.amr_audio_path))) {
//            return false;
//        }
//        boolean isSetTv_path = isSetTv_path();
//        boolean isSetTv_path2 = bBWordMedia.isSetTv_path();
//        if ((isSetTv_path || isSetTv_path2) && (!isSetTv_path || !isSetTv_path2 || !this.tv_path.equals(bBWordMedia.tv_path))) {
//            return false;
//        }
//        boolean isSetWord = isSetWord();
//        boolean isSetWord2 = bBWordMedia.isSetWord();
//        if ((isSetWord || isSetWord2) && (!isSetWord || !isSetWord2 || !this.word.equals(bBWordMedia.word))) {
//            return false;
//        }
//        boolean isSetWord_mean_cn = isSetWord_mean_cn();
//        boolean isSetWord_mean_cn2 = bBWordMedia.isSetWord_mean_cn();
//        if ((isSetWord_mean_cn || isSetWord_mean_cn2) && (!isSetWord_mean_cn || !isSetWord_mean_cn2 || !this.word_mean_cn.equals(bBWordMedia.word_mean_cn))) {
//            return false;
//        }
//        boolean isSetWord_type = isSetWord_type();
//        boolean isSetWord_type2 = bBWordMedia.isSetWord_type();
//        if ((isSetWord_type || isSetWord_type2) && (!isSetWord_type || !isSetWord_type2 || !this.word_type.equals(bBWordMedia.word_type))) {
//            return false;
//        }
//        boolean isSetWord_sentence = isSetWord_sentence();
//        boolean isSetWord_sentence2 = bBWordMedia.isSetWord_sentence();
//        if ((isSetWord_sentence || isSetWord_sentence2) && (!isSetWord_sentence || !isSetWord_sentence2 || !this.word_sentence.equals(bBWordMedia.word_sentence))) {
//            return false;
//        }
//        boolean isSetFm_updated_at = isSetFm_updated_at();
//        boolean isSetFm_updated_at2 = bBWordMedia.isSetFm_updated_at();
//        if ((isSetFm_updated_at || isSetFm_updated_at2) && (!isSetFm_updated_at || !isSetFm_updated_at2 || this.fm_updated_at != bBWordMedia.fm_updated_at)) {
//            return false;
//        }
//        boolean isSetTv_updated_at = isSetTv_updated_at();
//        boolean isSetTv_updated_at2 = bBWordMedia.isSetTv_updated_at();
//        if ((isSetTv_updated_at || isSetTv_updated_at2) && (!isSetTv_updated_at || !isSetTv_updated_at2 || this.tv_updated_at != bBWordMedia.tv_updated_at)) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBWordMedia bBWordMedia) {
//        if (!getClass().equals(bBWordMedia.getClass())) {
//            return getClass().getName().compareTo(bBWordMedia.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBWordMedia.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBWordMedia.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetM4a_audio_path()).compareTo(Boolean.valueOf(bBWordMedia.isSetM4a_audio_path()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetM4a_audio_path()) {
//            int a2 = C2121h.m5525a(this.m4a_audio_path, bBWordMedia.m4a_audio_path);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetAmr_audio_path()).compareTo(Boolean.valueOf(bBWordMedia.isSetAmr_audio_path()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetAmr_audio_path()) {
//            int a3 = C2121h.m5525a(this.amr_audio_path, bBWordMedia.amr_audio_path);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetTv_path()).compareTo(Boolean.valueOf(bBWordMedia.isSetTv_path()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetTv_path()) {
//            int a4 = C2121h.m5525a(this.tv_path, bBWordMedia.tv_path);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetWord()).compareTo(Boolean.valueOf(bBWordMedia.isSetWord()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetWord()) {
//            int a5 = C2121h.m5525a(this.word, bBWordMedia.word);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetWord_mean_cn()).compareTo(Boolean.valueOf(bBWordMedia.isSetWord_mean_cn()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetWord_mean_cn()) {
//            int a6 = C2121h.m5525a(this.word_mean_cn, bBWordMedia.word_mean_cn);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetWord_type()).compareTo(Boolean.valueOf(bBWordMedia.isSetWord_type()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetWord_type()) {
//            int a7 = C2121h.m5525a(this.word_type, bBWordMedia.word_type);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetWord_sentence()).compareTo(Boolean.valueOf(bBWordMedia.isSetWord_sentence()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetWord_sentence()) {
//            int a8 = C2121h.m5525a(this.word_sentence, bBWordMedia.word_sentence);
//            if (a8 != 0) {
//                return a8;
//            }
//        }
//        int compareTo9 = Boolean.valueOf(isSetFm_updated_at()).compareTo(Boolean.valueOf(bBWordMedia.isSetFm_updated_at()));
//        if (compareTo9 != 0) {
//            return compareTo9;
//        }
//        if (isSetFm_updated_at()) {
//            int a9 = C2121h.m5523a(this.fm_updated_at, bBWordMedia.fm_updated_at);
//            if (a9 != 0) {
//                return a9;
//            }
//        }
//        int compareTo10 = Boolean.valueOf(isSetTv_updated_at()).compareTo(Boolean.valueOf(bBWordMedia.isSetTv_updated_at()));
//        if (compareTo10 != 0) {
//            return compareTo10;
//        }
//        if (isSetTv_updated_at()) {
//            int a10 = C2121h.m5523a(this.tv_updated_at, bBWordMedia.tv_updated_at);
//            if (a10 != 0) {
//                return a10;
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
//        StringBuilder sb = new StringBuilder("BBWordMedia(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        if (isSetM4a_audio_path()) {
//            sb.append(", ");
//            sb.append("m4a_audio_path:");
//            if (this.m4a_audio_path == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.m4a_audio_path);
//            }
//        }
//        if (isSetAmr_audio_path()) {
//            sb.append(", ");
//            sb.append("amr_audio_path:");
//            if (this.amr_audio_path == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.amr_audio_path);
//            }
//        }
//        if (isSetTv_path()) {
//            sb.append(", ");
//            sb.append("tv_path:");
//            if (this.tv_path == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.tv_path);
//            }
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
//        if (isSetWord_mean_cn()) {
//            sb.append(", ");
//            sb.append("word_mean_cn:");
//            if (this.word_mean_cn == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.word_mean_cn);
//            }
//        }
//        if (isSetWord_type()) {
//            sb.append(", ");
//            sb.append("word_type:");
//            if (this.word_type == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.word_type);
//            }
//        }
//        if (isSetWord_sentence()) {
//            sb.append(", ");
//            sb.append("word_sentence:");
//            if (this.word_sentence == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.word_sentence);
//            }
//        }
//        if (isSetFm_updated_at()) {
//            sb.append(", ");
//            sb.append("fm_updated_at:");
//            sb.append(this.fm_updated_at);
//        }
//        if (isSetTv_updated_at()) {
//            sb.append(", ");
//            sb.append("tv_updated_at:");
//            sb.append(this.tv_updated_at);
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
