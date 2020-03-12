//package com.baicizhan.main.phrasetraining.data.load;
//
//import android.content.res.AssetManager;
//import android.text.TextUtils;
//import com.baicizhan.main.phrasetraining.data.bean.Phrase;
//import com.baicizhan.main.phrasetraining.data.bean.TopicPatterns;
//import com.baicizhan.main.phrasetraining.data.bean.TopicPatterns.Topic;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//
//public class PLContext {
//    public static final int ERR_DATA = -1;
//    public static final int ERR_NET = -2;
//    public static final int ERR_NET_OFFLINE = -3;
//    public static final int ERR_NET_USR_REJECT = -4;
//    public static final int NO_ERR = 0;
//    static final float SIZE_PER_PHRASE = 0.15f;
//    AssetManager mAM;
//    IPhraseLoader mCallback;
//    List<Integer> mGroupIds;
//    List<TopicPatterns> mPatternsList = new ArrayList();
//    List<Map<Integer, Phrase>> mPhrasesList = new ArrayList();
//
//    PLContext() {
//    }
//
//    /* access modifiers changed from: 0000 */
//    public boolean fillPhrases() {
//        if (this.mAM == null || this.mGroupIds == null || this.mGroupIds.isEmpty()) {
//            return false;
//        }
//        List<TopicPatterns> topicPatterns = TopicPatterns.getTopicPatterns(this.mAM);
//        List<Phrase> prasesList = Phrase.getPrasesList(this.mAM);
//        for (Integer intValue : this.mGroupIds) {
//            int intValue2 = intValue.intValue();
//            for (TopicPatterns topicPatterns2 : topicPatterns) {
//                if (topicPatterns2 != null && intValue2 == topicPatterns2.getGroupId()) {
//                    this.mPatternsList.add(topicPatterns2);
//                    HashSet hashSet = new HashSet();
//                    for (Topic topic : topicPatterns2.getArrTopics()) {
//                        hashSet.add(Integer.valueOf(topic.getTopicId()));
//                        String groupedTopicIds = topic.getGroupedTopicIds();
//                        if (!TextUtils.isEmpty(groupedTopicIds)) {
//                            for (String valueOf : groupedTopicIds.split(",")) {
//                                hashSet.add(Integer.valueOf(valueOf));
//                            }
//                        }
//                    }
//                    HashMap hashMap = new HashMap(prasesList.size());
//                    for (Phrase phrase : prasesList) {
//                        if (phrase != null && hashSet.contains(Integer.valueOf(phrase.getTopicId()))) {
//                            hashMap.put(Integer.valueOf(phrase.getTopicId()), phrase);
//                        }
//                    }
//                    this.mPhrasesList.add(hashMap);
//                }
//            }
//        }
//        return true;
//    }
//}
