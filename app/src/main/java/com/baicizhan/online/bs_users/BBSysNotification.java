//package com.baicizhan.online.bs_users;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.NOTIFY_MESSAGE_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.p052e.p053a.p054a.JceStruct;
//import com.tencent.android.tpush.common.MessageKey;
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
//public class BBSysNotification implements Serializable, Cloneable, Comparable<BBSysNotification>, C2116f<BBSysNotification, _Fields> {
//    /* access modifiers changed from: private */
//    public static final C2097b CONTENT_FIELD_DESC = new C2097b(MessageKey.MSG_CONTENT, JceStruct.STRUCT_END, 6);
//    /* access modifiers changed from: private */
//    public static final C2097b HEAD_IMG_FIELD_DESC = new C2097b("head_img", JceStruct.STRUCT_END, 10);
//    /* access modifiers changed from: private */
//    public static final C2097b ID_FIELD_DESC = new C2097b(Columns.f2234ID, 8, 1);
//    /* access modifiers changed from: private */
//    public static final C2097b IMG_URL_FIELD_DESC = new C2097b(NOTIFY_MESSAGE_TB.Columns.IMG_URL, JceStruct.STRUCT_END, 5);
//    /* access modifiers changed from: private */
//    public static final C2097b IS_HIDDEN_FIELD_DESC = new C2097b(NOTIFY_MESSAGE_TB.Columns.IS_HIDDEN, 8, 7);
//    /* access modifiers changed from: private */
//    public static final C2097b LIKE_TIMES_FIELD_DESC = new C2097b("like_times", 8, 9);
//    /* access modifiers changed from: private */
//    public static final C2097b NOTIFICATION_TYPE_FIELD_DESC = new C2097b("notification_type", 8, 2);
//    /* access modifiers changed from: private */
//    public static final C2105k STRUCT_DESC = new C2105k("BBSysNotification");
//    /* access modifiers changed from: private */
//    public static final C2097b TIME_FIELD_DESC = new C2097b("time", 8, 8);
//    /* access modifiers changed from: private */
//    public static final C2097b TITLE_DESC_FIELD_DESC = new C2097b(NOTIFY_MESSAGE_TB.Columns.TITLE_DESC, JceStruct.STRUCT_END, 4);
//    /* access modifiers changed from: private */
//    public static final C2097b TITLE_FIELD_DESC = new C2097b("title", JceStruct.STRUCT_END, 3);
//    private static final int __ID_ISSET_ID = 0;
//    private static final int __IS_HIDDEN_ISSET_ID = 2;
//    private static final int __LIKE_TIMES_ISSET_ID = 4;
//    private static final int __NOTIFICATION_TYPE_ISSET_ID = 1;
//    private static final int __TIME_ISSET_ID = 3;
//    public static final Map<_Fields, C2091a> metaDataMap;
//    private static final Map<Class<? extends C2108a>, C2109b> schemes;
//    private byte __isset_bitfield;
//    public String content;
//    public String head_img;
//
//    /* renamed from: id */
//    public int f2419id;
//    public String img_url;
//    public int is_hidden;
//    public int like_times;
//    public int notification_type;
//    private _Fields[] optionals;
//    public int time;
//    public String title;
//    public String title_desc;
//
//    class BBSysNotificationStandardScheme extends C2110c<BBSysNotification> {
//        private BBSysNotificationStandardScheme() {
//        }
//
//        public void read(C2100f fVar, BBSysNotification bBSysNotification) {
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
//                                bBSysNotification.f2419id = fVar.mo18513n();
//                                bBSysNotification.setIdIsSet(true);
//                                break;
//                            }
//                        case 2:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSysNotification.notification_type = fVar.mo18513n();
//                                bBSysNotification.setNotification_typeIsSet(true);
//                                break;
//                            }
//                        case 3:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSysNotification.title = fVar.mo18516q();
//                                bBSysNotification.setTitleIsSet(true);
//                                break;
//                            }
//                        case 4:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSysNotification.title_desc = fVar.mo18516q();
//                                bBSysNotification.setTitle_descIsSet(true);
//                                break;
//                            }
//                        case 5:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSysNotification.img_url = fVar.mo18516q();
//                                bBSysNotification.setImg_urlIsSet(true);
//                                break;
//                            }
//                        case 6:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSysNotification.content = fVar.mo18516q();
//                                bBSysNotification.setContentIsSet(true);
//                                break;
//                            }
//                        case 7:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSysNotification.is_hidden = fVar.mo18513n();
//                                bBSysNotification.setIs_hiddenIsSet(true);
//                                break;
//                            }
//                        case 8:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSysNotification.time = fVar.mo18513n();
//                                bBSysNotification.setTimeIsSet(true);
//                                break;
//                            }
//                        case 9:
//                            if (g.f5835b != 8) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSysNotification.like_times = fVar.mo18513n();
//                                bBSysNotification.setLike_timesIsSet(true);
//                                break;
//                            }
//                        case 10:
//                            if (g.f5835b != 11) {
//                                C2103i.m5498a(fVar, g.f5835b);
//                                break;
//                            } else {
//                                bBSysNotification.head_img = fVar.mo18516q();
//                                bBSysNotification.setHead_imgIsSet(true);
//                                break;
//                            }
//                        default:
//                            C2103i.m5498a(fVar, g.f5835b);
//                            break;
//                    }
//                } else {
//                    fVar.mo18505f();
//                    if (!bBSysNotification.isSetId()) {
//                        throw new C2101g("Required field 'id' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBSysNotification.isSetNotification_type()) {
//                        throw new C2101g("Required field 'notification_type' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBSysNotification.isSetIs_hidden()) {
//                        throw new C2101g("Required field 'is_hidden' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBSysNotification.isSetTime()) {
//                        throw new C2101g("Required field 'time' was not found in serialized data! Struct: " + toString());
//                    } else if (!bBSysNotification.isSetLike_times()) {
//                        throw new C2101g("Required field 'like_times' was not found in serialized data! Struct: " + toString());
//                    } else {
//                        bBSysNotification.validate();
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void write(C2100f fVar, BBSysNotification bBSysNotification) {
//            bBSysNotification.validate();
//            BBSysNotification.STRUCT_DESC;
//            fVar.mo18490a();
//            fVar.mo18496a(BBSysNotification.ID_FIELD_DESC);
//            fVar.mo18493a(bBSysNotification.f2419id);
//            fVar.mo18496a(BBSysNotification.NOTIFICATION_TYPE_FIELD_DESC);
//            fVar.mo18493a(bBSysNotification.notification_type);
//            if (bBSysNotification.title != null) {
//                fVar.mo18496a(BBSysNotification.TITLE_FIELD_DESC);
//                fVar.mo18495a(bBSysNotification.title);
//            }
//            if (bBSysNotification.title_desc != null) {
//                fVar.mo18496a(BBSysNotification.TITLE_DESC_FIELD_DESC);
//                fVar.mo18495a(bBSysNotification.title_desc);
//            }
//            if (bBSysNotification.img_url != null && bBSysNotification.isSetImg_url()) {
//                fVar.mo18496a(BBSysNotification.IMG_URL_FIELD_DESC);
//                fVar.mo18495a(bBSysNotification.img_url);
//            }
//            if (bBSysNotification.content != null) {
//                fVar.mo18496a(BBSysNotification.CONTENT_FIELD_DESC);
//                fVar.mo18495a(bBSysNotification.content);
//            }
//            fVar.mo18496a(BBSysNotification.IS_HIDDEN_FIELD_DESC);
//            fVar.mo18493a(bBSysNotification.is_hidden);
//            fVar.mo18496a(BBSysNotification.TIME_FIELD_DESC);
//            fVar.mo18493a(bBSysNotification.time);
//            fVar.mo18496a(BBSysNotification.LIKE_TIMES_FIELD_DESC);
//            fVar.mo18493a(bBSysNotification.like_times);
//            if (bBSysNotification.head_img != null) {
//                fVar.mo18496a(BBSysNotification.HEAD_IMG_FIELD_DESC);
//                fVar.mo18495a(bBSysNotification.head_img);
//            }
//            fVar.mo18502c();
//            fVar.mo18501b();
//        }
//    }
//
//    class BBSysNotificationStandardSchemeFactory implements C2109b {
//        private BBSysNotificationStandardSchemeFactory() {
//        }
//
//        public BBSysNotificationStandardScheme getScheme() {
//            return new BBSysNotificationStandardScheme();
//        }
//    }
//
//    class BBSysNotificationTupleScheme extends C2111d<BBSysNotification> {
//        private BBSysNotificationTupleScheme() {
//        }
//
//        public void write(C2100f fVar, BBSysNotification bBSysNotification) {
//            C2106l lVar = (C2106l) fVar;
//            lVar.mo18493a(bBSysNotification.f2419id);
//            lVar.mo18493a(bBSysNotification.notification_type);
//            lVar.mo18495a(bBSysNotification.title);
//            lVar.mo18495a(bBSysNotification.title_desc);
//            lVar.mo18495a(bBSysNotification.content);
//            lVar.mo18493a(bBSysNotification.is_hidden);
//            lVar.mo18493a(bBSysNotification.time);
//            lVar.mo18493a(bBSysNotification.like_times);
//            BitSet bitSet = new BitSet();
//            if (bBSysNotification.isSetImg_url()) {
//                bitSet.set(0);
//            }
//            if (bBSysNotification.isSetHead_img()) {
//                bitSet.set(1);
//            }
//            lVar.mo18527a(bitSet, 2);
//            if (bBSysNotification.isSetImg_url()) {
//                lVar.mo18495a(bBSysNotification.img_url);
//            }
//            if (bBSysNotification.isSetHead_img()) {
//                lVar.mo18495a(bBSysNotification.head_img);
//            }
//        }
//
//        public void read(C2100f fVar, BBSysNotification bBSysNotification) {
//            C2106l lVar = (C2106l) fVar;
//            bBSysNotification.f2419id = lVar.mo18513n();
//            bBSysNotification.setIdIsSet(true);
//            bBSysNotification.notification_type = lVar.mo18513n();
//            bBSysNotification.setNotification_typeIsSet(true);
//            bBSysNotification.title = lVar.mo18516q();
//            bBSysNotification.setTitleIsSet(true);
//            bBSysNotification.title_desc = lVar.mo18516q();
//            bBSysNotification.setTitle_descIsSet(true);
//            bBSysNotification.content = lVar.mo18516q();
//            bBSysNotification.setContentIsSet(true);
//            bBSysNotification.is_hidden = lVar.mo18513n();
//            bBSysNotification.setIs_hiddenIsSet(true);
//            bBSysNotification.time = lVar.mo18513n();
//            bBSysNotification.setTimeIsSet(true);
//            bBSysNotification.like_times = lVar.mo18513n();
//            bBSysNotification.setLike_timesIsSet(true);
//            BitSet b = lVar.mo18528b(2);
//            if (b.get(0)) {
//                bBSysNotification.img_url = lVar.mo18516q();
//                bBSysNotification.setImg_urlIsSet(true);
//            }
//            if (b.get(1)) {
//                bBSysNotification.head_img = lVar.mo18516q();
//                bBSysNotification.setHead_imgIsSet(true);
//            }
//        }
//    }
//
//    class BBSysNotificationTupleSchemeFactory implements C2109b {
//        private BBSysNotificationTupleSchemeFactory() {
//        }
//
//        public BBSysNotificationTupleScheme getScheme() {
//            return new BBSysNotificationTupleScheme();
//        }
//    }
//
//    public enum _Fields implements C2124m {
//        ID(1, Columns.f2234ID),
//        NOTIFICATION_TYPE(2, "notification_type"),
//        TITLE(3, "title"),
//        TITLE_DESC(4, NOTIFY_MESSAGE_TB.Columns.TITLE_DESC),
//        IMG_URL(5, NOTIFY_MESSAGE_TB.Columns.IMG_URL),
//        CONTENT(6, MessageKey.MSG_CONTENT),
//        IS_HIDDEN(7, NOTIFY_MESSAGE_TB.Columns.IS_HIDDEN),
//        TIME(8, "time"),
//        LIKE_TIMES(9, "like_times"),
//        HEAD_IMG(10, "head_img");
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
//                    return ID;
//                case 2:
//                    return NOTIFICATION_TYPE;
//                case 3:
//                    return TITLE;
//                case 4:
//                    return TITLE_DESC;
//                case 5:
//                    return IMG_URL;
//                case 6:
//                    return CONTENT;
//                case 7:
//                    return IS_HIDDEN;
//                case 8:
//                    return TIME;
//                case 9:
//                    return LIKE_TIMES;
//                case 10:
//                    return HEAD_IMG;
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
//        hashMap.put(C2110c.class, new BBSysNotificationStandardSchemeFactory());
//        schemes.put(C2111d.class, new BBSysNotificationTupleSchemeFactory());
//        EnumMap enumMap = new EnumMap(_Fields.class);
//        enumMap.put(_Fields.ID, new C2091a(Columns.f2234ID, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.NOTIFICATION_TYPE, new C2091a("notification_type", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.TITLE, new C2091a("title", 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.TITLE_DESC, new C2091a(NOTIFY_MESSAGE_TB.Columns.TITLE_DESC, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.IMG_URL, new C2091a(NOTIFY_MESSAGE_TB.Columns.IMG_URL, 2, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.CONTENT, new C2091a(MessageKey.MSG_CONTENT, 1, new C2092b(JceStruct.STRUCT_END, 0)));
//        enumMap.put(_Fields.IS_HIDDEN, new C2091a(NOTIFY_MESSAGE_TB.Columns.IS_HIDDEN, 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.TIME, new C2091a("time", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.LIKE_TIMES, new C2091a("like_times", 1, new C2092b(8, 0)));
//        enumMap.put(_Fields.HEAD_IMG, new C2091a("head_img", 3, new C2092b(JceStruct.STRUCT_END, 0)));
//        metaDataMap = Collections.unmodifiableMap(enumMap);
//        C2091a.m5430a(BBSysNotification.class, metaDataMap);
//    }
//
//    public BBSysNotification() {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.IMG_URL};
//    }
//
//    public BBSysNotification(int i, int i2, String str, String str2, String str3, int i3, int i4, int i5, String str4) {
//        this();
//        this.f2419id = i;
//        setIdIsSet(true);
//        this.notification_type = i2;
//        setNotification_typeIsSet(true);
//        this.title = str;
//        this.title_desc = str2;
//        this.content = str3;
//        this.is_hidden = i3;
//        setIs_hiddenIsSet(true);
//        this.time = i4;
//        setTimeIsSet(true);
//        this.like_times = i5;
//        setLike_timesIsSet(true);
//        this.head_img = str4;
//    }
//
//    public BBSysNotification(BBSysNotification bBSysNotification) {
//        this.__isset_bitfield = 0;
//        this.optionals = new _Fields[]{_Fields.IMG_URL};
//        this.__isset_bitfield = bBSysNotification.__isset_bitfield;
//        this.f2419id = bBSysNotification.f2419id;
//        this.notification_type = bBSysNotification.notification_type;
//        if (bBSysNotification.isSetTitle()) {
//            this.title = bBSysNotification.title;
//        }
//        if (bBSysNotification.isSetTitle_desc()) {
//            this.title_desc = bBSysNotification.title_desc;
//        }
//        if (bBSysNotification.isSetImg_url()) {
//            this.img_url = bBSysNotification.img_url;
//        }
//        if (bBSysNotification.isSetContent()) {
//            this.content = bBSysNotification.content;
//        }
//        this.is_hidden = bBSysNotification.is_hidden;
//        this.time = bBSysNotification.time;
//        this.like_times = bBSysNotification.like_times;
//        if (bBSysNotification.isSetHead_img()) {
//            this.head_img = bBSysNotification.head_img;
//        }
//    }
//
//    public BBSysNotification deepCopy() {
//        return new BBSysNotification(this);
//    }
//
//    public void clear() {
//        setIdIsSet(false);
//        this.f2419id = 0;
//        setNotification_typeIsSet(false);
//        this.notification_type = 0;
//        this.title = null;
//        this.title_desc = null;
//        this.img_url = null;
//        this.content = null;
//        setIs_hiddenIsSet(false);
//        this.is_hidden = 0;
//        setTimeIsSet(false);
//        this.time = 0;
//        setLike_timesIsSet(false);
//        this.like_times = 0;
//        this.head_img = null;
//    }
//
//    public int getId() {
//        return this.f2419id;
//    }
//
//    public BBSysNotification setId(int i) {
//        this.f2419id = i;
//        setIdIsSet(true);
//        return this;
//    }
//
//    public void unsetId() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -2);
//    }
//
//    public boolean isSetId() {
//        return C2090b.m5429a(this.__isset_bitfield, 0);
//    }
//
//    public void setIdIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 0, z);
//    }
//
//    public int getNotification_type() {
//        return this.notification_type;
//    }
//
//    public BBSysNotification setNotification_type(int i) {
//        this.notification_type = i;
//        setNotification_typeIsSet(true);
//        return this;
//    }
//
//    public void unsetNotification_type() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -3);
//    }
//
//    public boolean isSetNotification_type() {
//        return C2090b.m5429a(this.__isset_bitfield, 1);
//    }
//
//    public void setNotification_typeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 1, z);
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public BBSysNotification setTitle(String str) {
//        this.title = str;
//        return this;
//    }
//
//    public void unsetTitle() {
//        this.title = null;
//    }
//
//    public boolean isSetTitle() {
//        return this.title != null;
//    }
//
//    public void setTitleIsSet(boolean z) {
//        if (!z) {
//            this.title = null;
//        }
//    }
//
//    public String getTitle_desc() {
//        return this.title_desc;
//    }
//
//    public BBSysNotification setTitle_desc(String str) {
//        this.title_desc = str;
//        return this;
//    }
//
//    public void unsetTitle_desc() {
//        this.title_desc = null;
//    }
//
//    public boolean isSetTitle_desc() {
//        return this.title_desc != null;
//    }
//
//    public void setTitle_descIsSet(boolean z) {
//        if (!z) {
//            this.title_desc = null;
//        }
//    }
//
//    public String getImg_url() {
//        return this.img_url;
//    }
//
//    public BBSysNotification setImg_url(String str) {
//        this.img_url = str;
//        return this;
//    }
//
//    public void unsetImg_url() {
//        this.img_url = null;
//    }
//
//    public boolean isSetImg_url() {
//        return this.img_url != null;
//    }
//
//    public void setImg_urlIsSet(boolean z) {
//        if (!z) {
//            this.img_url = null;
//        }
//    }
//
//    public String getContent() {
//        return this.content;
//    }
//
//    public BBSysNotification setContent(String str) {
//        this.content = str;
//        return this;
//    }
//
//    public void unsetContent() {
//        this.content = null;
//    }
//
//    public boolean isSetContent() {
//        return this.content != null;
//    }
//
//    public void setContentIsSet(boolean z) {
//        if (!z) {
//            this.content = null;
//        }
//    }
//
//    public int getIs_hidden() {
//        return this.is_hidden;
//    }
//
//    public BBSysNotification setIs_hidden(int i) {
//        this.is_hidden = i;
//        setIs_hiddenIsSet(true);
//        return this;
//    }
//
//    public void unsetIs_hidden() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -5);
//    }
//
//    public boolean isSetIs_hidden() {
//        return C2090b.m5429a(this.__isset_bitfield, 2);
//    }
//
//    public void setIs_hiddenIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 2, z);
//    }
//
//    public int getTime() {
//        return this.time;
//    }
//
//    public BBSysNotification setTime(int i) {
//        this.time = i;
//        setTimeIsSet(true);
//        return this;
//    }
//
//    public void unsetTime() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -9);
//    }
//
//    public boolean isSetTime() {
//        return C2090b.m5429a(this.__isset_bitfield, 3);
//    }
//
//    public void setTimeIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 3, z);
//    }
//
//    public int getLike_times() {
//        return this.like_times;
//    }
//
//    public BBSysNotification setLike_times(int i) {
//        this.like_times = i;
//        setLike_timesIsSet(true);
//        return this;
//    }
//
//    public void unsetLike_times() {
//        this.__isset_bitfield = (byte) (this.__isset_bitfield & -17);
//    }
//
//    public boolean isSetLike_times() {
//        return C2090b.m5429a(this.__isset_bitfield, 4);
//    }
//
//    public void setLike_timesIsSet(boolean z) {
//        this.__isset_bitfield = (byte) C2090b.m5428a(this.__isset_bitfield, 4, z);
//    }
//
//    public String getHead_img() {
//        return this.head_img;
//    }
//
//    public BBSysNotification setHead_img(String str) {
//        this.head_img = str;
//        return this;
//    }
//
//    public void unsetHead_img() {
//        this.head_img = null;
//    }
//
//    public boolean isSetHead_img() {
//        return this.head_img != null;
//    }
//
//    public void setHead_imgIsSet(boolean z) {
//        if (!z) {
//            this.head_img = null;
//        }
//    }
//
//    public void setFieldValue(_Fields _fields, Object obj) {
//        switch (_fields) {
//            case ID:
//                if (obj == null) {
//                    unsetId();
//                    return;
//                } else {
//                    setId(((Integer) obj).intValue());
//                    return;
//                }
//            case NOTIFICATION_TYPE:
//                if (obj == null) {
//                    unsetNotification_type();
//                    return;
//                } else {
//                    setNotification_type(((Integer) obj).intValue());
//                    return;
//                }
//            case TITLE:
//                if (obj == null) {
//                    unsetTitle();
//                    return;
//                } else {
//                    setTitle((String) obj);
//                    return;
//                }
//            case TITLE_DESC:
//                if (obj == null) {
//                    unsetTitle_desc();
//                    return;
//                } else {
//                    setTitle_desc((String) obj);
//                    return;
//                }
//            case IMG_URL:
//                if (obj == null) {
//                    unsetImg_url();
//                    return;
//                } else {
//                    setImg_url((String) obj);
//                    return;
//                }
//            case CONTENT:
//                if (obj == null) {
//                    unsetContent();
//                    return;
//                } else {
//                    setContent((String) obj);
//                    return;
//                }
//            case IS_HIDDEN:
//                if (obj == null) {
//                    unsetIs_hidden();
//                    return;
//                } else {
//                    setIs_hidden(((Integer) obj).intValue());
//                    return;
//                }
//            case TIME:
//                if (obj == null) {
//                    unsetTime();
//                    return;
//                } else {
//                    setTime(((Integer) obj).intValue());
//                    return;
//                }
//            case LIKE_TIMES:
//                if (obj == null) {
//                    unsetLike_times();
//                    return;
//                } else {
//                    setLike_times(((Integer) obj).intValue());
//                    return;
//                }
//            case HEAD_IMG:
//                if (obj == null) {
//                    unsetHead_img();
//                    return;
//                } else {
//                    setHead_img((String) obj);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public Object getFieldValue(_Fields _fields) {
//        switch (_fields) {
//            case ID:
//                return Integer.valueOf(getId());
//            case NOTIFICATION_TYPE:
//                return Integer.valueOf(getNotification_type());
//            case TITLE:
//                return getTitle();
//            case TITLE_DESC:
//                return getTitle_desc();
//            case IMG_URL:
//                return getImg_url();
//            case CONTENT:
//                return getContent();
//            case IS_HIDDEN:
//                return Integer.valueOf(getIs_hidden());
//            case TIME:
//                return Integer.valueOf(getTime());
//            case LIKE_TIMES:
//                return Integer.valueOf(getLike_times());
//            case HEAD_IMG:
//                return getHead_img();
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
//            case ID:
//                return isSetId();
//            case NOTIFICATION_TYPE:
//                return isSetNotification_type();
//            case TITLE:
//                return isSetTitle();
//            case TITLE_DESC:
//                return isSetTitle_desc();
//            case IMG_URL:
//                return isSetImg_url();
//            case CONTENT:
//                return isSetContent();
//            case IS_HIDDEN:
//                return isSetIs_hidden();
//            case TIME:
//                return isSetTime();
//            case LIKE_TIMES:
//                return isSetLike_times();
//            case HEAD_IMG:
//                return isSetHead_img();
//            default:
//                throw new IllegalStateException();
//        }
//    }
//
//    public boolean equals(Object obj) {
//        if (obj != null && (obj instanceof BBSysNotification)) {
//            return equals((BBSysNotification) obj);
//        }
//        return false;
//    }
//
//    public boolean equals(BBSysNotification bBSysNotification) {
//        if (bBSysNotification == null || this.f2419id != bBSysNotification.f2419id || this.notification_type != bBSysNotification.notification_type) {
//            return false;
//        }
//        boolean isSetTitle = isSetTitle();
//        boolean isSetTitle2 = bBSysNotification.isSetTitle();
//        if ((isSetTitle || isSetTitle2) && (!isSetTitle || !isSetTitle2 || !this.title.equals(bBSysNotification.title))) {
//            return false;
//        }
//        boolean isSetTitle_desc = isSetTitle_desc();
//        boolean isSetTitle_desc2 = bBSysNotification.isSetTitle_desc();
//        if ((isSetTitle_desc || isSetTitle_desc2) && (!isSetTitle_desc || !isSetTitle_desc2 || !this.title_desc.equals(bBSysNotification.title_desc))) {
//            return false;
//        }
//        boolean isSetImg_url = isSetImg_url();
//        boolean isSetImg_url2 = bBSysNotification.isSetImg_url();
//        if ((isSetImg_url || isSetImg_url2) && (!isSetImg_url || !isSetImg_url2 || !this.img_url.equals(bBSysNotification.img_url))) {
//            return false;
//        }
//        boolean isSetContent = isSetContent();
//        boolean isSetContent2 = bBSysNotification.isSetContent();
//        if (((isSetContent || isSetContent2) && (!isSetContent || !isSetContent2 || !this.content.equals(bBSysNotification.content))) || this.is_hidden != bBSysNotification.is_hidden || this.time != bBSysNotification.time || this.like_times != bBSysNotification.like_times) {
//            return false;
//        }
//        boolean isSetHead_img = isSetHead_img();
//        boolean isSetHead_img2 = bBSysNotification.isSetHead_img();
//        if ((isSetHead_img || isSetHead_img2) && (!isSetHead_img || !isSetHead_img2 || !this.head_img.equals(bBSysNotification.head_img))) {
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
//
//    public int compareTo(BBSysNotification bBSysNotification) {
//        if (!getClass().equals(bBSysNotification.getClass())) {
//            return getClass().getName().compareTo(bBSysNotification.getClass().getName());
//        }
//        int compareTo = Boolean.valueOf(isSetId()).compareTo(Boolean.valueOf(bBSysNotification.isSetId()));
//        if (compareTo != 0) {
//            return compareTo;
//        }
//        if (isSetId()) {
//            int a = C2121h.m5522a(this.f2419id, bBSysNotification.f2419id);
//            if (a != 0) {
//                return a;
//            }
//        }
//        int compareTo2 = Boolean.valueOf(isSetNotification_type()).compareTo(Boolean.valueOf(bBSysNotification.isSetNotification_type()));
//        if (compareTo2 != 0) {
//            return compareTo2;
//        }
//        if (isSetNotification_type()) {
//            int a2 = C2121h.m5522a(this.notification_type, bBSysNotification.notification_type);
//            if (a2 != 0) {
//                return a2;
//            }
//        }
//        int compareTo3 = Boolean.valueOf(isSetTitle()).compareTo(Boolean.valueOf(bBSysNotification.isSetTitle()));
//        if (compareTo3 != 0) {
//            return compareTo3;
//        }
//        if (isSetTitle()) {
//            int a3 = C2121h.m5525a(this.title, bBSysNotification.title);
//            if (a3 != 0) {
//                return a3;
//            }
//        }
//        int compareTo4 = Boolean.valueOf(isSetTitle_desc()).compareTo(Boolean.valueOf(bBSysNotification.isSetTitle_desc()));
//        if (compareTo4 != 0) {
//            return compareTo4;
//        }
//        if (isSetTitle_desc()) {
//            int a4 = C2121h.m5525a(this.title_desc, bBSysNotification.title_desc);
//            if (a4 != 0) {
//                return a4;
//            }
//        }
//        int compareTo5 = Boolean.valueOf(isSetImg_url()).compareTo(Boolean.valueOf(bBSysNotification.isSetImg_url()));
//        if (compareTo5 != 0) {
//            return compareTo5;
//        }
//        if (isSetImg_url()) {
//            int a5 = C2121h.m5525a(this.img_url, bBSysNotification.img_url);
//            if (a5 != 0) {
//                return a5;
//            }
//        }
//        int compareTo6 = Boolean.valueOf(isSetContent()).compareTo(Boolean.valueOf(bBSysNotification.isSetContent()));
//        if (compareTo6 != 0) {
//            return compareTo6;
//        }
//        if (isSetContent()) {
//            int a6 = C2121h.m5525a(this.content, bBSysNotification.content);
//            if (a6 != 0) {
//                return a6;
//            }
//        }
//        int compareTo7 = Boolean.valueOf(isSetIs_hidden()).compareTo(Boolean.valueOf(bBSysNotification.isSetIs_hidden()));
//        if (compareTo7 != 0) {
//            return compareTo7;
//        }
//        if (isSetIs_hidden()) {
//            int a7 = C2121h.m5522a(this.is_hidden, bBSysNotification.is_hidden);
//            if (a7 != 0) {
//                return a7;
//            }
//        }
//        int compareTo8 = Boolean.valueOf(isSetTime()).compareTo(Boolean.valueOf(bBSysNotification.isSetTime()));
//        if (compareTo8 != 0) {
//            return compareTo8;
//        }
//        if (isSetTime()) {
//            int a8 = C2121h.m5522a(this.time, bBSysNotification.time);
//            if (a8 != 0) {
//                return a8;
//            }
//        }
//        int compareTo9 = Boolean.valueOf(isSetLike_times()).compareTo(Boolean.valueOf(bBSysNotification.isSetLike_times()));
//        if (compareTo9 != 0) {
//            return compareTo9;
//        }
//        if (isSetLike_times()) {
//            int a9 = C2121h.m5522a(this.like_times, bBSysNotification.like_times);
//            if (a9 != 0) {
//                return a9;
//            }
//        }
//        int compareTo10 = Boolean.valueOf(isSetHead_img()).compareTo(Boolean.valueOf(bBSysNotification.isSetHead_img()));
//        if (compareTo10 != 0) {
//            return compareTo10;
//        }
//        if (isSetHead_img()) {
//            int a10 = C2121h.m5525a(this.head_img, bBSysNotification.head_img);
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
//        StringBuilder sb = new StringBuilder("BBSysNotification(");
//        sb.append("id:");
//        sb.append(this.f2419id);
//        sb.append(", ");
//        sb.append("notification_type:");
//        sb.append(this.notification_type);
//        sb.append(", ");
//        sb.append("title:");
//        if (this.title == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.title);
//        }
//        sb.append(", ");
//        sb.append("title_desc:");
//        if (this.title_desc == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.title_desc);
//        }
//        if (isSetImg_url()) {
//            sb.append(", ");
//            sb.append("img_url:");
//            if (this.img_url == null) {
//                sb.append("null");
//            } else {
//                sb.append(this.img_url);
//            }
//        }
//        sb.append(", ");
//        sb.append("content:");
//        if (this.content == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.content);
//        }
//        sb.append(", ");
//        sb.append("is_hidden:");
//        sb.append(this.is_hidden);
//        sb.append(", ");
//        sb.append("time:");
//        sb.append(this.time);
//        sb.append(", ");
//        sb.append("like_times:");
//        sb.append(this.like_times);
//        sb.append(", ");
//        sb.append("head_img:");
//        if (this.head_img == null) {
//            sb.append("null");
//        } else {
//            sb.append(this.head_img);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    public void validate() {
//        if (this.title == null) {
//            throw new C2101g("Required field 'title' was not present! Struct: " + toString());
//        } else if (this.title_desc == null) {
//            throw new C2101g("Required field 'title_desc' was not present! Struct: " + toString());
//        } else if (this.content == null) {
//            throw new C2101g("Required field 'content' was not present! Struct: " + toString());
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
