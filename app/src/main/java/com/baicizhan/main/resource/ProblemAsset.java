//package com.baicizhan.main.resource;
//
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.debug.DebugConfig;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class ProblemAsset {
//    public static final int OPTION_COUNT = 4;
//    public static final int TYPE_INVALID = 0;
//    public static final int TYPE_PIC_TO_CHINESE = 3;
//    public static final int TYPE_REVIEW_LISTEN = 4;
//    public static final int TYPE_REVIEW_MATCH = 7;
//    public static final int TYPE_REVIEW_READ = 5;
//    public static final int TYPE_REVIEW_WRITE = 6;
//    public static final int TYPE_SENTENCE_TO_PIC = 1;
//    public static final int TYPE_WORD_TO_PIC = 2;
//    private int availableCount;
//
//    /* renamed from: id */
//    private int f2404id;
//    private ArrayList<TopicRecord> optionRecords = new ArrayList<>(4);
//    private List<Integer> options = new ArrayList(4);
//
//    public ProblemAsset(int i, int[] iArr) {
//        this.f2404id = i;
//        this.options.add(Integer.valueOf(i));
//        this.optionRecords.add(null);
//        for (int valueOf : iArr) {
//            this.options.add(Integer.valueOf(valueOf));
//            this.optionRecords.add(null);
//        }
//        this.availableCount = 0;
//    }
//
//    public int getId() {
//        return this.f2404id;
//    }
//
//    public void setId(int i) {
//        this.f2404id = i;
//    }
//
//    public List<Integer> getOptions() {
//        return this.options;
//    }
//
//    public List<TopicRecord> getOptionRecords() {
//        return this.optionRecords;
//    }
//
//    public boolean addOptionRecord(TopicRecord topicRecord) {
//        int indexOf = this.options.indexOf(Integer.valueOf(topicRecord.topicId));
//        if (indexOf == -1) {
//            return false;
//        }
//        if (((TopicRecord) this.optionRecords.set(indexOf, topicRecord)) == null) {
//            this.availableCount++;
//        }
//        return true;
//    }
//
//    public TopicRecord getPrimary() {
//        int i = 0;
//        while (true) {
//            int i2 = i;
//            if (i2 >= this.optionRecords.size()) {
//                return null;
//            }
//            TopicRecord topicRecord = (TopicRecord) this.optionRecords.get(i2);
//            if (topicRecord.topicId == this.f2404id) {
//                return topicRecord;
//            }
//            i = i2 + 1;
//        }
//    }
//
//    public int getProgress() {
//        return (this.availableCount * 100) / this.options.size();
//    }
//
//    public boolean isComplete() {
//        return this.availableCount == this.options.size();
//    }
//
//    public void shuffle() {
//        TopicRecord primary = getPrimary();
//        Collections.shuffle(this.optionRecords);
//        if (DebugConfig.getsIntance().enable && DebugConfig.getsIntance().fixOptionPosition) {
//            this.optionRecords.remove(primary);
//            this.optionRecords.add(0, primary);
//        }
//    }
//}
