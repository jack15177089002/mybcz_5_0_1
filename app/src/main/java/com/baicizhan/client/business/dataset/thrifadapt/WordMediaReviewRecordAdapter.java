//package com.baicizhan.client.business.dataset.thrifadapt;
//
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
////import com.baicizhan.online.bs_users.BBUserWordMedia;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WordMediaReviewRecordAdapter {
//    private WordMediaReviewRecordAdapter() {
//    }
//
////    public static List<TopicLearnRecord> fromList(List<BBUserWordMedia> list) {
////        if (list == null) {
////            return null;
////        }
////        ArrayList arrayList = new ArrayList(list.size());
////        for (BBUserWordMedia bBUserWordMedia : list) {
////            TopicLearnRecord topicLearnRecord = new TopicLearnRecord();
////            topicLearnRecord.topicId = bBUserWordMedia.topic_id;
////            topicLearnRecord.radioState = bBUserWordMedia.fm_view_times;
////            topicLearnRecord.radioTVState = bBUserWordMedia.tv_view_times;
////            topicLearnRecord.radioSkipState = TopicLearnRecord.mergeTVSkipVlaue(bBUserWordMedia.is_tv_skip, TopicLearnRecord.mergeFmSkipValue(bBUserWordMedia.is_fm_skip, 0));
////            arrayList.add(topicLearnRecord);
////        }
////        return arrayList;
////    }
//
////    public static List<BBUserWordMedia> toList(List<TopicLearnRecord> list) {
////        if (list == null) {
////            return null;
////        }
////        ArrayList arrayList = new ArrayList(list.size());
////        for (TopicLearnRecord topicLearnRecord : list) {
////            BBUserWordMedia bBUserWordMedia = new BBUserWordMedia();
////            bBUserWordMedia.topic_id = topicLearnRecord.topicId;
////            bBUserWordMedia.fm_view_times = topicLearnRecord.radioState;
////            bBUserWordMedia.tv_view_times = topicLearnRecord.radioTVState;
////            bBUserWordMedia.is_fm_skip = TopicLearnRecord.isFmSkipped(topicLearnRecord.radioSkipState);
////            bBUserWordMedia.is_tv_skip = TopicLearnRecord.isTVSkipped(topicLearnRecord.radioSkipState);
////            arrayList.add(bBUserWordMedia);
////        }
////        return arrayList;
////    }
//}
