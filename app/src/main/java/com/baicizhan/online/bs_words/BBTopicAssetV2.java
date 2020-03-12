//package com.baicizhan.online.bs_words;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_TOPIC_DATA_INFO.Columns;
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
//public class BBTopicAssetV2 implements Serializable, Cloneable, Comparable<BBTopicAssetV2>, C2116f<BBTopicAssetV2, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b ACCENT_FIELD_DESC = new C2097b("accent", JceStruct.STRUCT_END, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b ASSET_PACK_PATH_FIELD_DESC = new C2097b("asset_pack_path", JceStruct.STRUCT_END, 17);
//    /* access modifiers changed from: private */
//    public static final C2097b DEFORMATION_DESC_FIELD_DESC = new C2097b(Columns.DEFORMATION_DESC, JceStruct.STRUCT_END, 12);
//    /* access modifiers changed from: private */
//    public static final C2097b DEFORMATION_IMG_FIELD_DESC = new C2097b(Columns.DEFORMATION_IMG, JceStruct.STRUCT_END, 11);
//    /* access modifiers changed from: private */
//    public static final C2097b IMAGE_FILE_FIELD_DESC = new C2097b("image_file", JceStruct.STRUCT_END, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b MEAN_CN_FIELD_DESC = new C2097b("mean_cn", JceStruct.STRUCT_END, 8);
//    /* access modifiers changed from: private */
//    public static final C2097b MEAN_EN_FIELD_DESC = new C2097b("mean_en", JceStruct.STRUCT_END, 9);
//    /* access modifiers changed from: private */
//    public static final C2097b SENTENCE_AUDIO_FIELD_DESC = new C2097b("sentence_audio", JceStruct.STRUCT_END, 15);
//    /* access modifiers changed from: private */
//    public static final C2097b SENTENCE_FIELD_DESC = new C2097b("sentence", JceStruct.STRUCT_END, 13);
//    /* access modifiers changed from: private */
//    public static final C2097b SENTENCE_TRANS_FIELD_DESC = new C2097b("sentence_trans", JceStruct.STRUCT_END, 14);
//    /* access modifiers changed from: private */
//    public static final C2097b SHORT_PHRASE_FIELD_DESC = new C2097b("short_phrase", JceStruct.STRUCT_END, 10);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBTopicAssetV2");
//    /* access modifiers changed from: private */
//    public static final C2097b TOPIC_ID_FIELD_DESC = new C2097b("topic_id", 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATE_FLAG_FIELD_DESC = new C2097b("update_flag", JceStruct.STRUCT_END, 16);
//    /* access modifiers changed from: private */
//    public static final C2097b UPDATE_FLAG_MD5_FIELD_DESC = new C2097b(TOPICRESOURCE.Columns.UPDATE_FLAG_MD5, JceStruct.STRUCT_END, 18);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_AUDIO_FIELD_DESC = new C2097b("word_audio", JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_ETYMA_FIELD_DESC = new C2097b(Columns.WORD_ETYMA, JceStruct.STRUCT_END, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_FIELD_DESC = new C2097b("word", JceStruct.STRUCT_END, 2);
//    /* access modifiers changed from: private */
//    public static final C2097b WORD_VARIANTS_FIELD_DESC = new C2097b("word_variants", JceStruct.STRUCT_END, 3);
//    private static final int __TOPIC_ID_ISSET_ID = 0;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String accent;
//    public String asset_pack_path;
//    public String deformation_desc;
//    public String deformation_img;
//    public String image_file;
//    public String mean_cn;
//    public String mean_en;
//    public String sentence;
//    public String sentence_audio;
//    public String sentence_trans;
//    public String short_phrase;
//    public int topic_id;
//    public String update_flag;
//    public String update_flag_md5;
//    public String word;
//    public String word_audio;
//    public String word_etyma;
//    public String word_variants;
//
//    class BBTopicAssetV2StandardScheme extends C2110c<BBTopicAssetV2> {
//        private BBTopicAssetV2StandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBTopicAssetV2 bBTopicAssetV2) {
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
//                                bBTopicAssetV2.topic_id = fVar.mo18513n();
//                                bBTopicAssetV2.setTopic_idIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.word = fVar.mo18516q();
//                                bBTopicAssetV2.setWordIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.word_variants = fVar.mo18516q();
//                                bBTopicAssetV2.setWord_variantsIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.word_audio = fVar.mo18516q();
//                                bBTopicAssetV2.setWord_audioIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.word_etyma = fVar.mo18516q();
//                                bBTopicAssetV2.setWord_etymaIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.image_file = fVar.mo18516q();
//                                bBTopicAssetV2.setImage_fileIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.accent = fVar.mo18516q();
//                                bBTopicAssetV2.setAccentIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.mean_cn = fVar.mo18516q();
//                                bBTopicAssetV2.setMean_cnIsSet(true);
//                                break;
//                            }
//                        case 9:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.mean_en = fVar.mo18516q();
//                                bBTopicAssetV2.setMean_enIsSet(true);
//                                break;
//                            }
//                        case 10:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.short_phrase = fVar.mo18516q();
//                                bBTopicAssetV2.setShort_phraseIsSet(true);
//                                break;
//                            }
//                        case 11:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.deformation_img = fVar.mo18516q();
//                                bBTopicAssetV2.setDeformation_imgIsSet(true);
//                                break;
//                            }
//                        case 12:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.deformation_desc = fVar.mo18516q();
//                                bBTopicAssetV2.setDeformation_descIsSet(true);
//                                break;
//                            }
//                        case 13:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.sentence = fVar.mo18516q();
//                                bBTopicAssetV2.setSentenceIsSet(true);
//                                break;
//                            }
//                        case 14:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.sentence_trans = fVar.mo18516q();
//                                bBTopicAssetV2.setSentence_transIsSet(true);
//                                break;
//                            }
//                        case 15:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.sentence_audio = fVar.mo18516q();
//                                bBTopicAssetV2.setSentence_audioIsSet(true);
//                                break;
//                            }
//                        case 16:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.update_flag = fVar.mo18516q();
//                                bBTopicAssetV2.setUpdate_flagIsSet(true);
//                                break;
//                            }
//                        case 17:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.asset_pack_path = fVar.mo18516q();
//                                bBTopicAssetV2.setAsset_pack_pathIsSet(true);
//                                break;
//                            }
//                        case 18:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBTopicAssetV2.update_flag_md5 = fVar.mo18516q();
//                                bBTopicAssetV2.setUpdate_flag_md5IsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBTopicAssetV2.isSetTopic_id()) {
//                        throw new C2101g("Required field 'topic_id' was not found in serialized data! Struct: " + toString());
//                    }
//                    bBTopicAssetV2.validate();
//                    return;
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBTopicAssetV2 bBTopicAssetV2) {
//            bBTopicAssetV2.validate();
//            BBTopicAssetV2.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBTopicAssetV2.TOPIC_ID_FIELD_DESC);
//            fVar.mo18493a(bBTopicAssetV2.topic_id);
//            if (bBTopicAssetV2.word != null) {
//                fVar.mo18496a(BBTopicAssetV2.WORD_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.word);
//            }
//            if (bBTopicAssetV2.word_variants != null) {
//                fVar.mo18496a(BBTopicAssetV2.WORD_VARIANTS_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.word_variants);
//            }
//            if (bBTopicAssetV2.word_audio != null) {
//                fVar.mo18496a(BBTopicAssetV2.WORD_AUDIO_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.word_audio);
//            }
//            if (bBTopicAssetV2.word_etyma != null) {
//                fVar.mo18496a(BBTopicAssetV2.WORD_ETYMA_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.word_etyma);
//            }
//            if (bBTopicAssetV2.image_file != null) {
//                fVar.mo18496a(BBTopicAssetV2.IMAGE_FILE_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.image_file);
//            }
//            if (bBTopicAssetV2.accent != null) {
//                fVar.mo18496a(BBTopicAssetV2.ACCENT_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.accent);
//            }
//            if (bBTopicAssetV2.mean_cn != null) {
//                fVar.mo18496a(BBTopicAssetV2.MEAN_CN_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.mean_cn);
//            }
//            if (bBTopicAssetV2.mean_en != null) {
//                fVar.mo18496a(BBTopicAssetV2.MEAN_EN_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.mean_en);
//            }
//            if (bBTopicAssetV2.short_phrase != null) {
//                fVar.mo18496a(BBTopicAssetV2.SHORT_PHRASE_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.short_phrase);
//            }
//            if (bBTopicAssetV2.deformation_img != null) {
//                fVar.mo18496a(BBTopicAssetV2.DEFORMATION_IMG_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.deformation_img);
//            }
//            if (bBTopicAssetV2.deformation_desc != null) {
//                fVar.mo18496a(BBTopicAssetV2.DEFORMATION_DESC_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.deformation_desc);
//            }
//            if (bBTopicAssetV2.sentence != null) {
//                fVar.mo18496a(BBTopicAssetV2.SENTENCE_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.sentence);
//            }
//            if (bBTopicAssetV2.sentence_trans != null) {
//                fVar.mo18496a(BBTopicAssetV2.SENTENCE_TRANS_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.sentence_trans);
//            }
//            if (bBTopicAssetV2.sentence_audio != null) {
//                fVar.mo18496a(BBTopicAssetV2.SENTENCE_AUDIO_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.sentence_audio);
//            }
//            if (bBTopicAssetV2.update_flag != null) {
//                fVar.mo18496a(BBTopicAssetV2.UPDATE_FLAG_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.update_flag);
//            }
//            if (bBTopicAssetV2.asset_pack_path != null) {
//                fVar.mo18496a(BBTopicAssetV2.ASSET_PACK_PATH_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.asset_pack_path);
//            }
//            if (bBTopicAssetV2.update_flag_md5 != null) {
//                fVar.mo18496a(BBTopicAssetV2.UPDATE_FLAG_MD5_FIELD_DESC);
//                fVar.mo18495a(bBTopicAssetV2.update_flag_md5);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBTopicAssetV2StandardSchemeFactory implements C2109b {
//        private BBTopicAssetV2StandardSchemeFactory() {
//        }
//
//        public BBTopicAssetV2StandardScheme getScheme() {
//            return new BBTopicAssetV2StandardScheme();
//        }
//    }
//
//    class BBTopicAssetV2TupleScheme extends C2111d<BBTopicAssetV2> {
//        private BBTopicAssetV2TupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBTopicAssetV2 bBTopicAssetV2) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBTopicAssetV2.topic_id);
//            lVar.mo18495a(bBTopicAssetV2.word);
//            lVar.mo18495a(bBTopicAssetV2.word_variants);
//            lVar.mo18495a(bBTopicAssetV2.word_audio);
//            lVar.mo18495a(bBTopicAssetV2.word_etyma);
//            lVar.mo18495a(bBTopicAssetV2.image_file);
//            lVar.mo18495a(bBTopicAssetV2.accent);
//            lVar.mo18495a(bBTopicAssetV2.mean_cn);
//            lVar.mo18495a(bBTopicAssetV2.mean_en);
//            lVar.mo18495a(bBTopicAssetV2.short_phrase);
//            lVar.mo18495a(bBTopicAssetV2.deformation_img);
//            lVar.mo18495a(bBTopicAssetV2.deformation_desc);
//            lVar.mo18495a(bBTopicAssetV2.sentence);
//            lVar.mo18495a(bBTopicAssetV2.sentence_trans);
//            lVar.mo18495a(bBTopicAssetV2.sentence_audio);
//            lVar.mo18495a(bBTopicAssetV2.update_flag);
//            lVar.mo18495a(bBTopicAssetV2.asset_pack_path);
//            lVar.mo18495a(bBTopicAssetV2.update_flag_md5);
//        }
//
//        public void read(C2100f fVar, BBTopicAssetV2 bBTopicAssetV2) {
//            C2106l lVar = (C2106l) fVar;
//            bBTopicAssetV2.topic_id = lVar.mo18513n();
//            bBTopicAssetV2.setTopic_idIsSet(true);
//            bBTopicAssetV2.word = lVar.mo18516q();
//            bBTopicAssetV2.setWordIsSet(true);
//            bBTopicAssetV2.word_variants = lVar.mo18516q();
//            bBTopicAssetV2.setWord_variantsIsSet(true);
//            bBTopicAssetV2.word_audio = lVar.mo18516q();
//            bBTopicAssetV2.setWord_audioIsSet(true);
//            bBTopicAssetV2.word_etyma = lVar.mo18516q();
//            bBTopicAssetV2.setWord_etymaIsSet(true);
//            bBTopicAssetV2.image_file = lVar.mo18516q();
//            bBTopicAssetV2.setImage_fileIsSet(true);
//            bBTopicAssetV2.accent = lVar.mo18516q();
//            bBTopicAssetV2.setAccentIsSet(true);
//            bBTopicAssetV2.mean_cn = lVar.mo18516q();
//            bBTopicAssetV2.setMean_cnIsSet(true);
//            bBTopicAssetV2.mean_en = lVar.mo18516q();
//            bBTopicAssetV2.setMean_enIsSet(true);
//            bBTopicAssetV2.short_phrase = lVar.mo18516q();
//            bBTopicAssetV2.setShort_phraseIsSet(true);
//            bBTopicAssetV2.deformation_img = lVar.mo18516q();
//            bBTopicAssetV2.setDeformation_imgIsSet(true);
//            bBTopicAssetV2.deformation_desc = lVar.mo18516q();
//            bBTopicAssetV2.setDeformation_descIsSet(true);
//            bBTopicAssetV2.sentence = lVar.mo18516q();
//            bBTopicAssetV2.setSentenceIsSet(true);
//            bBTopicAssetV2.sentence_trans = lVar.mo18516q();
//            bBTopicAssetV2.setSentence_transIsSet(true);
//            bBTopicAssetV2.sentence_audio = lVar.mo18516q();
//            bBTopicAssetV2.setSentence_audioIsSet(true);
//            bBTopicAssetV2.update_flag = lVar.mo18516q();
//            bBTopicAssetV2.setUpdate_flagIsSet(true);
//            bBTopicAssetV2.asset_pack_path = lVar.mo18516q();
//            bBTopicAssetV2.setAsset_pack_pathIsSet(true);
//            bBTopicAssetV2.update_flag_md5 = lVar.mo18516q();
//            bBTopicAssetV2.setUpdate_flag_md5IsSet(true);
//        }
//    }
//
//    class BBTopicAssetV2TupleSchemeFactory implements C2109b {
//        private BBTopicAssetV2TupleSchemeFactory() {
//        }
//
//        public BBTopicAssetV2TupleScheme getScheme() {
//            return new BBTopicAssetV2TupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        TOPIC_ID(1, "topic_id"),
//        WORD(2, "word"),
//        WORD_VARIANTS(3, "word_variants"),
//        WORD_AUDIO(4, "word_audio"),
//        WORD_ETYMA(5, Columns.WORD_ETYMA),
//        IMAGE_FILE(6, "image_file"),
//        ACCENT(7, "accent"),
//        MEAN_CN(8, "mean_cn"),
//        MEAN_EN(9, "mean_en"),
//        SHORT_PHRASE(10, "short_phrase"),
//        DEFORMATION_IMG(11, Columns.DEFORMATION_IMG),
//        DEFORMATION_DESC(12, Columns.DEFORMATION_DESC),
//        SENTENCE(13, "sentence"),
//        SENTENCE_TRANS(14, "sentence_trans"),
//        SENTENCE_AUDIO(15, "sentence_audio"),
//        UPDATE_FLAG(16, "update_flag"),
//        ASSET_PACK_PATH(17, "asset_pack_path"),
//        UPDATE_FLAG_MD5(18, TOPICRESOURCE.Columns.UPDATE_FLAG_MD5);
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
//                    return WORD;
//                case 3:
//                    return WORD_VARIANTS;
//                case 4:
//                    return WORD_AUDIO;
//                case 5:
//                    return WORD_ETYMA;
//                case 6:
//                    return IMAGE_FILE;
//                case 7:
//                    return ACCENT;
//                case 8:
//                    return MEAN_CN;
//                case 9:
//                    return MEAN_EN;
//                case 10:
//                    return SHORT_PHRASE;
//                case 11:
//                    return DEFORMATION_IMG;
//                case 12:
//                    return DEFORMATION_DESC;
//                case 13:
//                    return SENTENCE;
//                case 14:
//                    return SENTENCE_TRANS;
//                case 15:
//                    return SENTENCE_AUDIO;
//                case 16:
//                    return UPDATE_FLAG;
//                case 17:
//                    return ASSET_PACK_PATH;
//                case 18:
//                    return UPDATE_FLAG_MD5;
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
//        hashMap.put(C2110c.class, new BBTopicAssetV2StandardSchemeFactory());
//        schemes.put(C2111d.class, new BBTopicAssetV2TupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.TOPIC_ID, new C2091a("topic_id", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.WORD, new C2091a("word", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WORD_VARIANTS, new C2091a("word_variants", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WORD_AUDIO, new C2091a("word_audio", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.WORD_ETYMA, new C2091a(Columns.WORD_ETYMA, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.IMAGE_FILE, new C2091a("image_file", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.ACCENT, new C2091a("accent", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.MEAN_CN, new C2091a("mean_cn", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.MEAN_EN, new C2091a("mean_en", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.SHORT_PHRASE, new C2091a("short_phrase", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.DEFORMATION_IMG, new C2091a(Columns.DEFORMATION_IMG, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.DEFORMATION_DESC, new C2091a(Columns.DEFORMATION_DESC, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.SENTENCE, new C2091a("sentence", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.SENTENCE_TRANS, new C2091a("sentence_trans", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.SENTENCE_AUDIO, new C2091a("sentence_audio", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.UPDATE_FLAG, new C2091a("update_flag", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.ASSET_PACK_PATH, new C2091a("asset_pack_path", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.UPDATE_FLAG_MD5, new C2091a(TOPICRESOURCE.Columns.UPDATE_FLAG_MD5, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBTopicAssetV2.class, metaDataMap);
//    }
//
//    public BBTopicAssetV2() {
//        this.__isset_bitfield = 0;
//    }
//
//    public BBTopicAssetV2(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
//        this();
//        this.topic_id = i;
//        setTopic_idIsSet(true);
//        this.word = str;
//        this.word_variants = str2;
//        this.word_audio = str3;
//        this.word_etyma = str4;
//        this.image_file = str5;
//        this.accent = str6;
//        this.mean_cn = str7;
//        this.mean_en = str8;
//        this.short_phrase = str9;
//        this.deformation_img = str10;
//        this.deformation_desc = str11;
//        this.sentence = str12;
//        this.sentence_trans = str13;
//        this.sentence_audio = str14;
//        this.update_flag = str15;
//        this.asset_pack_path = str16;
//        this.update_flag_md5 = str17;
//    }
//
//    public BBTopicAssetV2(BBTopicAssetV2 bBTopicAssetV2) {
//        this.__isset_bitfield = 0;
//        this.__isset_bitfield = bBTopicAssetV2.__isset_bitfield;
//        this.topic_id = bBTopicAssetV2.topic_id;
//        if (bBTopicAssetV2.isSetWord()) {
//            this.word = bBTopicAssetV2.word;
//        }
//        if (bBTopicAssetV2.isSetWord_variants()) {
//            this.word_variants = bBTopicAssetV2.word_variants;
//        }
//        if (bBTopicAssetV2.isSetWord_audio()) {
//            this.word_audio = bBTopicAssetV2.word_audio;
//        }
//        if (bBTopicAssetV2.isSetWord_etyma()) {
//            this.word_etyma = bBTopicAssetV2.word_etyma;
//        }
//        if (bBTopicAssetV2.isSetImage_file()) {
//            this.image_file = bBTopicAssetV2.image_file;
//        }
//        if (bBTopicAssetV2.isSetAccent()) {
//            this.accent = bBTopicAssetV2.accent;
//        }
//        if (bBTopicAssetV2.isSetMean_cn()) {
//            this.mean_cn = bBTopicAssetV2.mean_cn;
//        }
//        if (bBTopicAssetV2.isSetMean_en()) {
//            this.mean_en = bBTopicAssetV2.mean_en;
//        }
//        if (bBTopicAssetV2.isSetShort_phrase()) {
//            this.short_phrase = bBTopicAssetV2.short_phrase;
//        }
//        if (bBTopicAssetV2.isSetDeformation_img()) {
//            this.deformation_img = bBTopicAssetV2.deformation_img;
//        }
//        if (bBTopicAssetV2.isSetDeformation_desc()) {
//            this.deformation_desc = bBTopicAssetV2.deformation_desc;
//        }
//        if (bBTopicAssetV2.isSetSentence()) {
//            this.sentence = bBTopicAssetV2.sentence;
//        }
//        if (bBTopicAssetV2.isSetSentence_trans()) {
//            this.sentence_trans = bBTopicAssetV2.sentence_trans;
//        }
//        if (bBTopicAssetV2.isSetSentence_audio()) {
//            this.sentence_audio = bBTopicAssetV2.sentence_audio;
//        }
//        if (bBTopicAssetV2.isSetUpdate_flag()) {
//            this.update_flag = bBTopicAssetV2.update_flag;
//        }
//        if (bBTopicAssetV2.isSetAsset_pack_path()) {
//            this.asset_pack_path = bBTopicAssetV2.asset_pack_path;
//        }
//        if (bBTopicAssetV2.isSetUpdate_flag_md5()) {
//            this.update_flag_md5 = bBTopicAssetV2.update_flag_md5;
//        }
//    }
//
//    public BBTopicAssetV2 deepCopy() {
//        return new BBTopicAssetV2(this);
//    }
//
//    public void clear() {
//        setTopic_idIsSet(false);
//        this.topic_id = 0;
//        this.word = null;
//        this.word_variants = null;
//        this.word_audio = null;
//        this.word_etyma = null;
//        this.image_file = null;
//        this.accent = null;
//        this.mean_cn = null;
//        this.mean_en = null;
//        this.short_phrase = null;
//        this.deformation_img = null;
//        this.deformation_desc = null;
//        this.sentence = null;
//        this.sentence_trans = null;
//        this.sentence_audio = null;
//        this.update_flag = null;
//        this.asset_pack_path = null;
//        this.update_flag_md5 = null;
//    }
//
//    public int getTopic_id() {
//        return this.topic_id;
//    }
//
//    public BBTopicAssetV2 setTopic_id(int i) {
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
//    public String getWord() {
//        return this.word;
//    }
//
//    public BBTopicAssetV2 setWord(String str) {
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
//    public String getWord_variants() {
//        return this.word_variants;
//    }
//
//    public BBTopicAssetV2 setWord_variants(String str) {
//        this.word_variants = str;
//        return this;
//    }
//
//    public void unsetWord_variants() {
//        this.word_variants = null;
//    }
//
//    public boolean isSetWord_variants() {
//        return this.word_variants != null;
//    }
//
//    public void setWord_variantsIsSet(boolean z) {
//        if (!z) {
//            this.word_variants = null;
//        }
//    }
//
//    public String getWord_audio() {
//        return this.word_audio;
//    }
//
//    public BBTopicAssetV2 setWord_audio(String str) {
//        this.word_audio = str;
//        return this;
//    }
//
//    public void unsetWord_audio() {
//        this.word_audio = null;
//    }
//
//    public boolean isSetWord_audio() {
//        return this.word_audio != null;
//    }
//
//    public void setWord_audioIsSet(boolean z) {
//        if (!z) {
//            this.word_audio = null;
//        }
//    }
//
//    public String getWord_etyma() {
//        return this.word_etyma;
//    }
//
//    public BBTopicAssetV2 setWord_etyma(String str) {
//        this.word_etyma = str;
//        return this;
//    }
//
//    public void unsetWord_etyma() {
//        this.word_etyma = null;
//    }
//
//    public boolean isSetWord_etyma() {
//        return this.word_etyma != null;
//    }
//
//    public void setWord_etymaIsSet(boolean z) {
//        if (!z) {
//            this.word_etyma = null;
//        }
//    }
//
//    public String getImage_file() {
//        return this.image_file;
//    }
//
//    public BBTopicAssetV2 setImage_file(String str) {
//        this.image_file = str;
//        return this;
//    }
//
//    public void unsetImage_file() {
//        this.image_file = null;
//    }
//
//    public boolean isSetImage_file() {
//        return this.image_file != null;
//    }
//
//    public void setImage_fileIsSet(boolean z) {
//        if (!z) {
//            this.image_file = null;
//        }
//    }
//
//    public String getAccent() {
//        return this.accent;
//    }
//
//    public BBTopicAssetV2 setAccent(String str) {
//        this.accent = str;
//        return this;
//    }
//
//    public void unsetAccent() {
//        this.accent = null;
//    }
//
//    public boolean isSetAccent() {
//        return this.accent != null;
//    }
//
//    public void setAccentIsSet(boolean z) {
//        if (!z) {
//            this.accent = null;
//        }
//    }
//
//    public String getMean_cn() {
//        return this.mean_cn;
//    }
//
//    public BBTopicAssetV2 setMean_cn(String str) {
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
//    public String getMean_en() {
//        return this.mean_en;
//    }
//
//    public BBTopicAssetV2 setMean_en(String str) {
//        this.mean_en = str;
//        return this;
//    }
//
//    public void unsetMean_en() {
//        this.mean_en = null;
//    }
//
//    public boolean isSetMean_en() {
//        return this.mean_en != null;
//    }
//
//    public void setMean_enIsSet(boolean z) {
//        if (!z) {
//            this.mean_en = null;
//        }
//    }
//
//    public String getShort_phrase() {
//        return this.short_phrase;
//    }
//
//    public BBTopicAssetV2 setShort_phrase(String str) {
//        this.short_phrase = str;
//        return this;
//    }
//
//    public void unsetShort_phrase() {
//        this.short_phrase = null;
//    }
//
//    public boolean isSetShort_phrase() {
//        return this.short_phrase != null;
//    }
//
//    public void setShort_phraseIsSet(boolean z) {
//        if (!z) {
//            this.short_phrase = null;
//        }
//    }
//
//    public String getDeformation_img() {
//        return this.deformation_img;
//    }
//
//    public BBTopicAssetV2 setDeformation_img(String str) {
//        this.deformation_img = str;
//        return this;
//    }
//
//    public void unsetDeformation_img() {
//        this.deformation_img = null;
//    }
//
//    public boolean isSetDeformation_img() {
//        return this.deformation_img != null;
//    }
//
//    public void setDeformation_imgIsSet(boolean z) {
//        if (!z) {
//            this.deformation_img = null;
//        }
//    }
//
//    public String getDeformation_desc() {
//        return this.deformation_desc;
//    }
//
//    public BBTopicAssetV2 setDeformation_desc(String str) {
//        this.deformation_desc = str;
//        return this;
//    }
//
//    public void unsetDeformation_desc() {
//        this.deformation_desc = null;
//    }
//
//    public boolean isSetDeformation_desc() {
//        return this.deformation_desc != null;
//    }
//
//    public void setDeformation_descIsSet(boolean z) {
//        if (!z) {
//            this.deformation_desc = null;
//        }
//    }
//
//    public String getSentence() {
//        return this.sentence;
//    }
//
//    public BBTopicAssetV2 setSentence(String str) {
//        this.sentence = str;
//        return this;
//    }
//
//    public void unsetSentence() {
//        this.sentence = null;
//    }
//
//    public boolean isSetSentence() {
//        return this.sentence != null;
//    }
//
//    public void setSentenceIsSet(boolean z) {
//        if (!z) {
//            this.sentence = null;
//        }
//    }
//
//    public String getSentence_trans() {
//        return this.sentence_trans;
//    }
//
//    public BBTopicAssetV2 setSentence_trans(String str) {
//        this.sentence_trans = str;
//        return this;
//    }
//
//    public void unsetSentence_trans() {
//        this.sentence_trans = null;
//    }
//
//    public boolean isSetSentence_trans() {
//        return this.sentence_trans != null;
//    }
//
//    public void setSentence_transIsSet(boolean z) {
//        if (!z) {
//            this.sentence_trans = null;
//        }
//    }
//
//    public String getSentence_audio() {
//        return this.sentence_audio;
//    }
//
//    public BBTopicAssetV2 setSentence_audio(String str) {
//        this.sentence_audio = str;
//        return this;
//    }
//
//    public void unsetSentence_audio() {
//        this.sentence_audio = null;
//    }
//
//    public boolean isSetSentence_audio() {
//        return this.sentence_audio != null;
//    }
//
//    public void setSentence_audioIsSet(boolean z) {
//        if (!z) {
//            this.sentence_audio = null;
//        }
//    }
//
//    public String getUpdate_flag() {
//        return this.update_flag;
//    }
//
//    public BBTopicAssetV2 setUpdate_flag(String str) {
//        this.update_flag = str;
//        return this;
//    }
//
//    public void unsetUpdate_flag() {
//        this.update_flag = null;
//    }
//
//    public boolean isSetUpdate_flag() {
//        return this.update_flag != null;
//    }
//
//    public void setUpdate_flagIsSet(boolean z) {
//        if (!z) {
//            this.update_flag = null;
//        }
//    }
//
//    public String getAsset_pack_path() {
//        return this.asset_pack_path;
//    }
//
//    public BBTopicAssetV2 setAsset_pack_path(String str) {
//        this.asset_pack_path = str;
//        return this;
//    }
//
//    public void unsetAsset_pack_path() {
//        this.asset_pack_path = null;
//    }
//
//    public boolean isSetAsset_pack_path() {
//        return this.asset_pack_path != null;
//    }
//
//    public void setAsset_pack_pathIsSet(boolean z) {
//        if (!z) {
//            this.asset_pack_path = null;
//        }
//    }
//
//    public String getUpdate_flag_md5() {
//        return this.update_flag_md5;
//    }
//
//    public BBTopicAssetV2 setUpdate_flag_md5(String str) {
//        this.update_flag_md5 = str;
//        return this;
//    }
//
//    public void unsetUpdate_flag_md5() {
//        this.update_flag_md5 = null;
//    }
//
//    public boolean isSetUpdate_flag_md5() {
//        return this.update_flag_md5 != null;
//    }
//
//    public void setUpdate_flag_md5IsSet(boolean z) {
//        if (!z) {
//            this.update_flag_md5 = null;
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
//            case WORD:
//                if (obj == null) {
//                    unsetWord();
//                    return;
//                } else {
//                    setWord((String) obj);
//                    return;
//                }
//            case WORD_VARIANTS:
//                if (obj == null) {
//                    unsetWord_variants();
//                    return;
//                } else {
//                    setWord_variants((String) obj);
//                    return;
//                }
//            case WORD_AUDIO:
//                if (obj == null) {
//                    unsetWord_audio();
//                    return;
//                } else {
//                    setWord_audio((String) obj);
//                    return;
//                }
//            case WORD_ETYMA:
//                if (obj == null) {
//                    unsetWord_etyma();
//                    return;
//                } else {
//                    setWord_etyma((String) obj);
//                    return;
//                }
//            case IMAGE_FILE:
//                if (obj == null) {
//                    unsetImage_file();
//                    return;
//                } else {
//                    setImage_file((String) obj);
//                    return;
//                }
//            case ACCENT:
//                if (obj == null) {
//                    unsetAccent();
//                    return;
//                } else {
//                    setAccent((String) obj);
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
//            case MEAN_EN:
//                if (obj == null) {
//                    unsetMean_en();
//                    return;
//                } else {
//                    setMean_en((String) obj);
//                    return;
//                }
//            case SHORT_PHRASE:
//                if (obj == null) {
//                    unsetShort_phrase();
//                    return;
//                } else {
//                    setShort_phrase((String) obj);
//                    return;
//                }
//            case DEFORMATION_IMG:
//                if (obj == null) {
//                    unsetDeformation_img();
//                    return;
//                } else {
//                    setDeformation_img((String) obj);
//                    return;
//                }
//            case DEFORMATION_DESC:
//                if (obj == null) {
//                    unsetDeformation_desc();
//                    return;
//                } else {
//                    setDeformation_desc((String) obj);
//                    return;
//                }
//            case SENTENCE:
//                if (obj == null) {
//                    unsetSentence();
//                    return;
//                } else {
//                    setSentence((String) obj);
//                    return;
//                }
//            case SENTENCE_TRANS:
//                if (obj == null) {
//                    unsetSentence_trans();
//                    return;
//                } else {
//                    setSentence_trans((String) obj);
//                    return;
//                }
//            case SENTENCE_AUDIO:
//                if (obj == null) {
//                    unsetSentence_audio();
//                    return;
//                } else {
//                    setSentence_audio((String) obj);
//                    return;
//                }
//            case UPDATE_FLAG:
//                if (obj == null) {
//                    unsetUpdate_flag();
//                    return;
//                } else {
//                    setUpdate_flag((String) obj);
//                    return;
//                }
//            case ASSET_PACK_PATH:
//                if (obj == null) {
//                    unsetAsset_pack_path();
//                    return;
//                } else {
//                    setAsset_pack_path((String) obj);
//                    return;
//                }
//            case UPDATE_FLAG_MD5:
//                if (obj == null) {
//                    unsetUpdate_flag_md5();
//                    return;
//                } else {
//                    setUpdate_flag_md5((String) obj);
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
//            case WORD:
//                return getWord();
//            case WORD_VARIANTS:
//                return getWord_variants();
//            case WORD_AUDIO:
//                return getWord_audio();
//            case WORD_ETYMA:
//                return getWord_etyma();
//            case IMAGE_FILE:
//                return getImage_file();
//            case ACCENT:
//                return getAccent();
//            case MEAN_CN:
//                return getMean_cn();
//            case MEAN_EN:
//                return getMean_en();
//            case SHORT_PHRASE:
//                return getShort_phrase();
//            case DEFORMATION_IMG:
//                return getDeformation_img();
//            case DEFORMATION_DESC:
//                return getDeformation_desc();
//            case SENTENCE:
//                return getSentence();
//            case SENTENCE_TRANS:
//                return getSentence_trans();
//            case SENTENCE_AUDIO:
//                return getSentence_audio();
//            case UPDATE_FLAG:
//                return getUpdate_flag();
//            case ASSET_PACK_PATH:
//                return getAsset_pack_path();
//            case UPDATE_FLAG_MD5:
//                return getUpdate_flag_md5();
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
//            case WORD:
//                return isSetWord();
//            case WORD_VARIANTS:
//                return isSetWord_variants();
//            case WORD_AUDIO:
//                return isSetWord_audio();
//            case WORD_ETYMA:
//                return isSetWord_etyma();
//            case IMAGE_FILE:
//                return isSetImage_file();
//            case ACCENT:
//                return isSetAccent();
//            case MEAN_CN:
//                return isSetMean_cn();
//            case MEAN_EN:
//                return isSetMean_en();
//            case SHORT_PHRASE:
//                return isSetShort_phrase();
//            case DEFORMATION_IMG:
//                return isSetDeformation_img();
//            case DEFORMATION_DESC:
//                return isSetDeformation_desc();
//            case SENTENCE:
//                return isSetSentence();
//            case SENTENCE_TRANS:
//                return isSetSentence_trans();
//            case SENTENCE_AUDIO:
//                return isSetSentence_audio();
//            case UPDATE_FLAG:
//                return isSetUpdate_flag();
//            case ASSET_PACK_PATH:
//                return isSetAsset_pack_path();
//            case UPDATE_FLAG_MD5:
//                return isSetUpdate_flag_md5();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBTopicAssetV2)) {
//            return equals((BBTopicAssetV2) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBTopicAssetV2 bBTopicAssetV2) {
//        if (bBTopicAssetV2 == null || this.topic_id != bBTopicAssetV2.topic_id) {
//            return false;
//        }
//        boolean isSetWord = isSetWord();
//        boolean isSetWord2 = bBTopicAssetV2.isSetWord();
//        if ((isSetWord || isSetWord2) && (!isSetWord || !isSetWord2 || !this.word.equals(bBTopicAssetV2.word))) {
//            return false;
//        }
//        boolean isSetWord_variants = isSetWord_variants();
//        boolean isSetWord_variants2 = bBTopicAssetV2.isSetWord_variants();
//        if ((isSetWord_variants || isSetWord_variants2) && (!isSetWord_variants || !isSetWord_variants2 || !this.word_variants.equals(bBTopicAssetV2.word_variants))) {
//            return false;
//        }
//        boolean isSetWord_audio = isSetWord_audio();
//        boolean isSetWord_audio2 = bBTopicAssetV2.isSetWord_audio();
//        if ((isSetWord_audio || isSetWord_audio2) && (!isSetWord_audio || !isSetWord_audio2 || !this.word_audio.equals(bBTopicAssetV2.word_audio))) {
//            return false;
//        }
//        boolean isSetWord_etyma = isSetWord_etyma();
//        boolean isSetWord_etyma2 = bBTopicAssetV2.isSetWord_etyma();
//        if ((isSetWord_etyma || isSetWord_etyma2) && (!isSetWord_etyma || !isSetWord_etyma2 || !this.word_etyma.equals(bBTopicAssetV2.word_etyma))) {
//            return false;
//        }
//        boolean isSetImage_file = isSetImage_file();
//        boolean isSetImage_file2 = bBTopicAssetV2.isSetImage_file();
//        if ((isSetImage_file || isSetImage_file2) && (!isSetImage_file || !isSetImage_file2 || !this.image_file.equals(bBTopicAssetV2.image_file))) {
//            return false;
//        }
//        boolean isSetAccent = isSetAccent();
//        boolean isSetAccent2 = bBTopicAssetV2.isSetAccent();
//        if ((isSetAccent || isSetAccent2) && (!isSetAccent || !isSetAccent2 || !this.accent.equals(bBTopicAssetV2.accent))) {
//            return false;
//        }
//        boolean isSetMean_cn = isSetMean_cn();
//        boolean isSetMean_cn2 = bBTopicAssetV2.isSetMean_cn();
//        if ((isSetMean_cn || isSetMean_cn2) && (!isSetMean_cn || !isSetMean_cn2 || !this.mean_cn.equals(bBTopicAssetV2.mean_cn))) {
//            return false;
//        }
//        boolean isSetMean_en = isSetMean_en();
//        boolean isSetMean_en2 = bBTopicAssetV2.isSetMean_en();
//        if ((isSetMean_en || isSetMean_en2) && (!isSetMean_en || !isSetMean_en2 || !this.mean_en.equals(bBTopicAssetV2.mean_en))) {
//            return false;
//        }
//        boolean isSetShort_phrase = isSetShort_phrase();
//        boolean isSetShort_phrase2 = bBTopicAssetV2.isSetShort_phrase();
//        if ((isSetShort_phrase || isSetShort_phrase2) && (!isSetShort_phrase || !isSetShort_phrase2 || !this.short_phrase.equals(bBTopicAssetV2.short_phrase))) {
//            return false;
//        }
//        boolean isSetDeformation_img = isSetDeformation_img();
//        boolean isSetDeformation_img2 = bBTopicAssetV2.isSetDeformation_img();
//        if ((isSetDeformation_img || isSetDeformation_img2) && (!isSetDeformation_img || !isSetDeformation_img2 || !this.deformation_img.equals(bBTopicAssetV2.deformation_img))) {
//            return false;
//        }
//        boolean isSetDeformation_desc = isSetDeformation_desc();
//        boolean isSetDeformation_desc2 = bBTopicAssetV2.isSetDeformation_desc();
//        if ((isSetDeformation_desc || isSetDeformation_desc2) && (!isSetDeformation_desc || !isSetDeformation_desc2 || !this.deformation_desc.equals(bBTopicAssetV2.deformation_desc))) {
//            return false;
//        }
//        boolean isSetSentence = isSetSentence();
//        boolean isSetSentence2 = bBTopicAssetV2.isSetSentence();
//        if ((isSetSentence || isSetSentence2) && (!isSetSentence || !isSetSentence2 || !this.sentence.equals(bBTopicAssetV2.sentence))) {
//            return false;
//        }
//        boolean isSetSentence_trans = isSetSentence_trans();
//        boolean isSetSentence_trans2 = bBTopicAssetV2.isSetSentence_trans();
//        if ((isSetSentence_trans || isSetSentence_trans2) && (!isSetSentence_trans || !isSetSentence_trans2 || !this.sentence_trans.equals(bBTopicAssetV2.sentence_trans))) {
//            return false;
//        }
//        boolean isSetSentence_audio = isSetSentence_audio();
//        boolean isSetSentence_audio2 = bBTopicAssetV2.isSetSentence_audio();
//        if ((isSetSentence_audio || isSetSentence_audio2) && (!isSetSentence_audio || !isSetSentence_audio2 || !this.sentence_audio.equals(bBTopicAssetV2.sentence_audio))) {
//            return false;
//        }
//        boolean isSetUpdate_flag = isSetUpdate_flag();
//        boolean isSetUpdate_flag2 = bBTopicAssetV2.isSetUpdate_flag();
//        if ((isSetUpdate_flag || isSetUpdate_flag2) && (!isSetUpdate_flag || !isSetUpdate_flag2 || !this.update_flag.equals(bBTopicAssetV2.update_flag))) {
//            return false;
//        }
//        boolean isSetAsset_pack_path = isSetAsset_pack_path();
//        boolean isSetAsset_pack_path2 = bBTopicAssetV2.isSetAsset_pack_path();
//        if ((isSetAsset_pack_path || isSetAsset_pack_path2) && (!isSetAsset_pack_path || !isSetAsset_pack_path2 || !this.asset_pack_path.equals(bBTopicAssetV2.asset_pack_path))) {
//            return false;
//        }
//        boolean isSetUpdate_flag_md5 = isSetUpdate_flag_md5();
//        boolean isSetUpdate_flag_md52 = bBTopicAssetV2.isSetUpdate_flag_md5();
//        if ((isSetUpdate_flag_md5 || isSetUpdate_flag_md52) && (!isSetUpdate_flag_md5 || !isSetUpdate_flag_md52 || !this.update_flag_md5.equals(bBTopicAssetV2.update_flag_md5))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBTopicAssetV2 bBTopicAssetV2) {
//        if (!getClass().equals(bBTopicAssetV2.getClass())) {
//            return getClass().getName().compareTo(bBTopicAssetV2.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetTopic_id()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetTopic_id()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetTopic_id()) {
//            int a = C2121h.m5522a(this.topic_id, bBTopicAssetV2.topic_id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetWord()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetWord()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetWord()) {
//            int a2 = C2121h.m5525a(this.word, bBTopicAssetV2.word);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetWord_variants()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetWord_variants()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetWord_variants()) {
//            int a3 = C2121h.m5525a(this.word_variants, bBTopicAssetV2.word_variants);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetWord_audio()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetWord_audio()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetWord_audio()) {
//            int a4 = C2121h.m5525a(this.word_audio, bBTopicAssetV2.word_audio);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetWord_etyma()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetWord_etyma()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetWord_etyma()) {
//            int a5 = C2121h.m5525a(this.word_etyma, bBTopicAssetV2.word_etyma);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetImage_file()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetImage_file()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetImage_file()) {
//            int a6 = C2121h.m5525a(this.image_file, bBTopicAssetV2.image_file);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetAccent()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetAccent()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetAccent()) {
//            int a7 = C2121h.m5525a(this.accent, bBTopicAssetV2.accent);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetMean_cn()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetMean_cn()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetMean_cn()) {
//            int a8 = C2121h.m5525a(this.mean_cn, bBTopicAssetV2.mean_cn);
//            if (a8 != 0) {
//                return a8;
//            }
//        }
//        int compareTo9 = Boolean.valueOf(isSetMean_en()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetMean_en()));
//        if (compareTo9 != 0) {
//            return compareTo9;
//        }
//        if (isSetMean_en()) {
//            int a9 = C2121h.m5525a(this.mean_en, bBTopicAssetV2.mean_en);
//            if (a9 != 0) {
//                return a9;
//            }
//        }
//        int compareTo10 = Boolean.valueOf(isSetShort_phrase()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetShort_phrase()));
//        if (compareTo10 != 0) {
//            return compareTo10;
//        }
//        if (isSetShort_phrase()) {
//            int a10 = C2121h.m5525a(this.short_phrase, bBTopicAssetV2.short_phrase);
//            if (a10 != 0) {
//                return a10;
//            }
//        }
//        int compareTo11 = Boolean.valueOf(isSetDeformation_img()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetDeformation_img()));
//        if (compareTo11 != 0) {
//            return compareTo11;
//        }
//        if (isSetDeformation_img()) {
//            int a11 = C2121h.m5525a(this.deformation_img, bBTopicAssetV2.deformation_img);
//            if (a11 != 0) {
//                return a11;
//            }
//        }
//        int compareTo12 = Boolean.valueOf(isSetDeformation_desc()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetDeformation_desc()));
//        if (compareTo12 != 0) {
//            return compareTo12;
//        }
//        if (isSetDeformation_desc()) {
//            int a12 = C2121h.m5525a(this.deformation_desc, bBTopicAssetV2.deformation_desc);
//            if (a12 != 0) {
//                return a12;
//            }
//        }
//        int compareTo13 = Boolean.valueOf(isSetSentence()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetSentence()));
//        if (compareTo13 != 0) {
//            return compareTo13;
//        }
//        if (isSetSentence()) {
//            int a13 = C2121h.m5525a(this.sentence, bBTopicAssetV2.sentence);
//            if (a13 != 0) {
//                return a13;
//            }
//        }
//        int compareTo14 = Boolean.valueOf(isSetSentence_trans()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetSentence_trans()));
//        if (compareTo14 != 0) {
//            return compareTo14;
//        }
//        if (isSetSentence_trans()) {
//            int a14 = C2121h.m5525a(this.sentence_trans, bBTopicAssetV2.sentence_trans);
//            if (a14 != 0) {
//                return a14;
//            }
//        }
//        int compareTo15 = Boolean.valueOf(isSetSentence_audio()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetSentence_audio()));
//        if (compareTo15 != 0) {
//            return compareTo15;
//        }
//        if (isSetSentence_audio()) {
//            int a15 = C2121h.m5525a(this.sentence_audio, bBTopicAssetV2.sentence_audio);
//            if (a15 != 0) {
//                return a15;
//            }
//        }
//        int compareTo16 = Boolean.valueOf(isSetUpdate_flag()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetUpdate_flag()));
//        if (compareTo16 != 0) {
//            return compareTo16;
//        }
//        if (isSetUpdate_flag()) {
//            int a16 = C2121h.m5525a(this.update_flag, bBTopicAssetV2.update_flag);
//            if (a16 != 0) {
//                return a16;
//            }
//        }
//        int compareTo17 = Boolean.valueOf(isSetAsset_pack_path()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetAsset_pack_path()));
//        if (compareTo17 != 0) {
//            return compareTo17;
//        }
//        if (isSetAsset_pack_path()) {
//            int a17 = C2121h.m5525a(this.asset_pack_path, bBTopicAssetV2.asset_pack_path);
//            if (a17 != 0) {
//                return a17;
//            }
//        }
//        int compareTo18 = Boolean.valueOf(isSetUpdate_flag_md5()).compareTo(Boolean.valueOf(bBTopicAssetV2.isSetUpdate_flag_md5()));
//        if (compareTo18 != 0) {
//            return compareTo18;
//        }
//        if (isSetUpdate_flag_md5()) {
//            int a18 = C2121h.m5525a(this.update_flag_md5, bBTopicAssetV2.update_flag_md5);
//            if (a18 != 0) {
//                return a18;
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
//        StringBuilder sb = new StringBuilder("BBTopicAssetV2(");
//        sb.append("topic_id:");
//        sb.append(this.topic_id);
//        sb.append(", ");
//        sb.append("word:");
//        if (this.word == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word);
//        }
//        sb.append(", ");
//        sb.append("word_variants:");
//        if (this.word_variants == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word_variants);
//        }
//        sb.append(", ");
//        sb.append("word_audio:");
//        if (this.word_audio == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word_audio);
//        }
//        sb.append(", ");
//        sb.append("word_etyma:");
//        if (this.word_etyma == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.word_etyma);
//        }
//        sb.append(", ");
//        sb.append("image_file:");
//        if (this.image_file == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.image_file);
//        }
//        sb.append(", ");
//        sb.append("accent:");
//        if (this.accent == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.accent);
//        }
//        sb.append(", ");
//        sb.append("mean_cn:");
//        if (this.mean_cn == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.mean_cn);
//        }
//        sb.append(", ");
//        sb.append("mean_en:");
//        if (this.mean_en == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.mean_en);
//        }
//        sb.append(", ");
//        sb.append("short_phrase:");
//        if (this.short_phrase == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.short_phrase);
//        }
//        sb.append(", ");
//        sb.append("deformation_img:");
//        if (this.deformation_img == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.deformation_img);
//        }
//        sb.append(", ");
//        sb.append("deformation_desc:");
//        if (this.deformation_desc == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.deformation_desc);
//        }
//        sb.append(", ");
//        sb.append("sentence:");
//        if (this.sentence == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.sentence);
//        }
//        sb.append(", ");
//        sb.append("sentence_trans:");
//        if (this.sentence_trans == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.sentence_trans);
//        }
//        sb.append(", ");
//        sb.append("sentence_audio:");
//        if (this.sentence_audio == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.sentence_audio);
//        }
//        sb.append(", ");
//        sb.append("update_flag:");
//        if (this.update_flag == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.update_flag);
//        }
//        sb.append(", ");
//        sb.append("asset_pack_path:");
//        if (this.asset_pack_path == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.asset_pack_path);
//        }
//        sb.append(", ");
//        sb.append("update_flag_md5:");
//        if (this.update_flag_md5 == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.update_flag_md5);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.word == null) {
//            throw new C2101g("Required field 'word' was not present! Struct: " + toString());
//        } else if (this.word_variants == null) {
//            throw new C2101g("Required field 'word_variants' was not present! Struct: " + toString());
//        } else if (this.word_audio == null) {
//            throw new C2101g("Required field 'word_audio' was not present! Struct: " + toString());
//        } else if (this.word_etyma == null) {
//            throw new C2101g("Required field 'word_etyma' was not present! Struct: " + toString());
//        } else if (this.image_file == null) {
//            throw new C2101g("Required field 'image_file' was not present! Struct: " + toString());
//        } else if (this.accent == null) {
//            throw new C2101g("Required field 'accent' was not present! Struct: " + toString());
//        } else if (this.mean_cn == null) {
//            throw new C2101g("Required field 'mean_cn' was not present! Struct: " + toString());
//        } else if (this.mean_en == null) {
//            throw new C2101g("Required field 'mean_en' was not present! Struct: " + toString());
//        } else if (this.short_phrase == null) {
//            throw new C2101g("Required field 'short_phrase' was not present! Struct: " + toString());
//        } else if (this.deformation_img == null) {
//            throw new C2101g("Required field 'deformation_img' was not present! Struct: " + toString());
//        } else if (this.deformation_desc == null) {
//            throw new C2101g("Required field 'deformation_desc' was not present! Struct: " + toString());
//        } else if (this.sentence == null) {
//            throw new C2101g("Required field 'sentence' was not present! Struct: " + toString());
//        } else if (this.sentence_trans == null) {
//            throw new C2101g("Required field 'sentence_trans' was not present! Struct: " + toString());
//        } else if (this.sentence_audio == null) {
//            throw new C2101g("Required field 'sentence_audio' was not present! Struct: " + toString());
//        } else if (this.update_flag == null) {
//            throw new C2101g("Required field 'update_flag' was not present! Struct: " + toString());
//        } else if (this.asset_pack_path == null) {
//            throw new C2101g("Required field 'asset_pack_path' was not present! Struct: " + toString());
//        } else if (this.update_flag_md5 == null) {
//            throw new C2101g("Required field 'update_flag_md5' was not present! Struct: " + toString());
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
