//package com.baicizhan.client.business.search;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.os.Parcelable.Creator;
//import android.text.TextUtils;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_LOCK_SEARCH_HISTORY_TB;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class Word implements Parcelable {
//    public static final Map<String, String> COLUMN_MAP;
//    public static final Creator<Word> CREATOR = new Creator<Word>() {
//        public final Word createFromParcel(Parcel parcel) {
//            return new Word(parcel);
//        }
//
//        public final Word[] newArray(int i) {
//            return new Word[i];
//        }
//    };
//    private static final int FLAG_BASE = 1;
//    private static final int FLAG_FROM_CACHE = 2;
//    private static final int FLAG_SEARCH = 4;
//    private String accent;
//    private String audio;
//    private int bookId;
//    private String cnexample;
//    private String cnmean;
//    private String enmean;
//    private String example;
//    private int flag = 0;
//
//    /* renamed from: id */
//    private String f2236id;
//    private String image;
//    private String root;
//    private String variants;
//    private String vivid;
//    private String word;
//    private String zpkPath;
//
//    static {
//        HashMap hashMap = new HashMap();
//        COLUMN_MAP = hashMap;
//        hashMap.put("bookId", "book_id");
//        COLUMN_MAP.put(Columns.f2234ID, "topic_id");
//        COLUMN_MAP.put("word", "word");
//        COLUMN_MAP.put("accent", "accent");
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.CNMEAN, WORD_LOCK_SEARCH_HISTORY_TB.Columns.CNMEAN);
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.AUDIO, WORD_LOCK_SEARCH_HISTORY_TB.Columns.AUDIO);
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.EXAMPLE, WORD_LOCK_SEARCH_HISTORY_TB.Columns.EXAMPLE);
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.CNEXAMPLE, WORD_LOCK_SEARCH_HISTORY_TB.Columns.CNEXAMPLE);
//        COLUMN_MAP.put("image", "image");
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.VIVID, WORD_LOCK_SEARCH_HISTORY_TB.Columns.VIVID);
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.ENMEAN, WORD_LOCK_SEARCH_HISTORY_TB.Columns.ENMEAN);
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.ROOT, WORD_LOCK_SEARCH_HISTORY_TB.Columns.ROOT);
//        COLUMN_MAP.put("zpkPath", "zpk_path");
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.FLAG, WORD_LOCK_SEARCH_HISTORY_TB.Columns.FLAG);
//    }
//
//    public int getBookId() {
//        return this.bookId;
//    }
//
//    public void setBookId(int i) {
//        this.bookId = i;
//    }
//
//    public String getId() {
//        return this.f2236id;
//    }
//
//    public void setId(String str) {
//        this.f2236id = str;
//    }
//
//    public String getWord() {
//        return this.word;
//    }
//
//    public void setWord(String str) {
//        this.word = str;
//    }
//
//    public String getAccent() {
//        return this.accent;
//    }
//
//    public void setAccent(String str) {
//        this.accent = str;
//    }
//
//    public String getCnmean() {
//        return this.cnmean;
//    }
//
//    public void setCnmean(String str) {
//        this.cnmean = str;
//    }
//
//    public String getAudio() {
//        return this.audio;
//    }
//
//    public void setAudio(String str) {
//        this.audio = str;
//    }
//
//    public String getExample() {
//        return this.example;
//    }
//
//    public void setExample(String str) {
//        this.example = str;
//    }
//
//    public String getCnexample() {
//        return this.cnexample;
//    }
//
//    public void setCnexample(String str) {
//        this.cnexample = str;
//    }
//
//    public String getImage() {
//        return this.image;
//    }
//
//    public void setImage(String str) {
//        this.image = str;
//    }
//
//    public String getVivid() {
//        return this.vivid;
//    }
//
//    public void setVivid(String str) {
//        this.vivid = str;
//    }
//
//    public String getEnmean() {
//        return this.enmean;
//    }
//
//    public void setEnmean(String str) {
//        this.enmean = str;
//    }
//
//    public String getRoot() {
//        return this.root;
//    }
//
//    public void setRoot(String str) {
//        this.root = str;
//    }
//
//    public String getZpkPath() {
//        return this.zpkPath;
//    }
//
//    public void setZpkPath(String str) {
//        this.zpkPath = str;
//    }
//
//    public String getVariants() {
//        return this.variants;
//    }
//
//    public void setVariants(String str) {
//        this.variants = str;
//    }
//
//    public boolean isBase() {
//        return (this.flag & 1) == 1;
//    }
//
//    public void setBase(boolean z) {
//        if (z) {
//            this.flag |= 1;
//        } else {
//            this.flag &= -2;
//        }
//    }
//
//    public boolean isFromCache() {
//        return (this.flag & 2) == 2;
//    }
//
//    public void setFromCache(boolean z) {
//        if (z) {
//            this.flag |= 2;
//        } else {
//            this.flag &= -3;
//        }
//    }
//
//    public boolean isSearch() {
//        return (this.flag & 4) == 4;
//    }
//
//    public void setSearch(boolean z) {
//        if (z) {
//            this.flag |= 4;
//        } else {
//            this.flag &= -5;
//        }
//    }
//
//    public int getFlag() {
//        return this.flag;
//    }
//
//    public static Set<String> splitVariants(String str) {
//        HashSet hashSet = new HashSet();
//        if (TextUtils.isEmpty(str)) {
//            return Collections.emptySet();
//        }
//        for (String trim : TextUtils.split(str, ",")) {
//            String trim2 = trim.trim();
//            if (trim2.length() > 0) {
//                hashSet.add(trim2);
//            }
//        }
//        return hashSet;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("word info {");
//        sb.append("[bookId : ").append(this.bookId).append("] [id : ").append(this.f2236id).append("] [word : ").append(this.word).append("] [accent : ").append(this.accent).append("] [cnmean : ").append(this.cnmean).append("] [audio : ").append(this.audio).append("] [example : ").append(this.example).append("] [cnexample : ").append(this.cnexample).append("] [image : ").append(this.image).append("] [vivid : ").append(this.vivid).append("] [enmean : ").append(this.enmean).append("] [root : ").append(this.root).append("]}");
//        return sb.toString();
//    }
//
//    public Word() {
//    }
//
//    public Word(Parcel parcel) {
//        this.bookId = parcel.readInt();
//        this.f2236id = parcel.readString();
//        this.word = parcel.readString();
//        this.accent = parcel.readString();
//        this.cnmean = parcel.readString();
//        this.audio = parcel.readString();
//        this.example = parcel.readString();
//        this.cnexample = parcel.readString();
//        this.image = parcel.readString();
//        this.vivid = parcel.readString();
//        this.enmean = parcel.readString();
//        this.root = parcel.readString();
//        this.zpkPath = parcel.readString();
//        this.variants = parcel.readString();
//        this.flag = parcel.readInt();
//    }
//
//    public int describeContents() {
//        return 0;
//    }
//
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt(this.bookId);
//        parcel.writeString(this.f2236id);
//        parcel.writeString(this.word);
//        parcel.writeString(this.accent);
//        parcel.writeString(this.cnmean);
//        parcel.writeString(this.audio);
//        parcel.writeString(this.example);
//        parcel.writeString(this.cnexample);
//        parcel.writeString(this.image);
//        parcel.writeString(this.vivid);
//        parcel.writeString(this.enmean);
//        parcel.writeString(this.root);
//        parcel.writeString(this.zpkPath);
//        parcel.writeString(this.variants);
//        parcel.writeInt(i);
//    }
//}
