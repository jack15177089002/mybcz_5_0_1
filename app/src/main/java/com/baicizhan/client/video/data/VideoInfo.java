//package com.baicizhan.client.video.data;
//
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//
//public class VideoInfo {
//    private VideoInfo mInitedOne;
//    private boolean mMidfield = false;
//    private String mPath;
//    private int mSkipped;
//    private int mViewed;
//    private String mWord;
//    private int mWordId;
//
//    public boolean isMidfield() {
//        return this.mMidfield;
//    }
//
//    public void setMidfield(boolean z) {
//        this.mMidfield = z;
//    }
//
//    public int getWordId() {
//        return this.mWordId;
//    }
//
//    public void setWordId(int i) {
//        this.mWordId = i;
//    }
//
//    public int getViewedCount() {
//        return this.mViewed;
//    }
//
//    public void setViewedCount(int i) {
//        this.mViewed = i;
//    }
//
//    public void accumViewed() {
//        this.mViewed++;
//    }
//
//    public boolean isSkipped() {
//        return TopicLearnRecord.isFmSkipped(this.mSkipped);
//    }
//
//    public int getSkipValue() {
//        return this.mSkipped;
//    }
//
//    public void setSkipped(boolean z) {
//        this.mSkipped = TopicLearnRecord.mergeFmSkipValue(z, this.mSkipped);
//    }
//
//    public boolean shouldPost() {
//        if (this.mInitedOne == null) {
//            return false;
//        }
//        if (this.mViewed == this.mInitedOne.mViewed && this.mSkipped == this.mInitedOne.mSkipped) {
//            return false;
//        }
//        return true;
//    }
//
//    public String getPath() {
//        return this.mPath;
//    }
//
//    public void setPath(String str) {
//        this.mPath = str;
//    }
//
//    public String getWord() {
//        return this.mWord;
//    }
//
//    public void setWord(String str) {
//        this.mWord = str;
//    }
//
//    public VideoInfo getInitedOne() {
//        return this.mInitedOne;
//    }
//
//    public void setInitedOne(VideoInfo videoInfo) {
//        this.mInitedOne = new VideoInfo();
//        this.mInitedOne.mMidfield = videoInfo.mMidfield;
//        this.mInitedOne.mPath = videoInfo.mPath;
//        this.mInitedOne.mSkipped = videoInfo.mSkipped;
//        this.mInitedOne.mViewed = videoInfo.mViewed;
//        this.mInitedOne.mWord = videoInfo.mWord;
//        this.mInitedOne.mWordId = videoInfo.mWordId;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("[word : ");
//        sb.append(this.mWord).append("; word_id : ").append(this.mWordId).append("; viewed : ").append(this.mViewed).append("; skipped : ").append(this.mSkipped).append("; path : ").append(this.mPath).append("]");
//        return sb.toString();
//    }
//}
