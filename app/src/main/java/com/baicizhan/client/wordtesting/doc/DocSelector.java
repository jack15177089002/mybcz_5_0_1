package com.baicizhan.client.wordtesting.doc;

import java.util.ArrayList;
import java.util.List;

public class DocSelector implements DocLoadHandler {
    private static final String[] DEF_DOCS = {"你的英语水平相当于美国文盲或者2岁以内的小孩。他们说，拥有这个词汇量的人，多半是那种喝酸奶不舔盖的土豪", "你的英语进行日常生活的简单表达都没有问题呢，美国小朋友能说的，你也行的", "超赞的说，你的英语水平已达到平均值啦！你造吗，全球非英语母语的人群平均水平也就4500左右~", "你的英语水平已经能独自出国旅行，进个外企什么的，也是妥妥的~全球非英语母语的人群平均水平也就4500，你已经超过啦！", "恭喜你！你的英语水平听歌秒懂歌词，看美剧不要字幕什么的根本不是问题啦~~这差不多是美国本土中学生的英语水平哦", "作为英语非母语的人群，只有不超过10%的人拥有这个词汇量，我猜你是英语老师？或者高能学霸？还是哈佛的女博士？", "Oh~My~Godness！你是歪果仁吧！！！你喜欢中国吗？原生美国人也差不多就这个词汇量啊！"};
    private List<Doc> mDocs;

    public void asyncGetDocs() {
        DocAsyncTask.getTask(this, false).execute(false);
    }

    public Doc select(long j) {
        int grade = getGrade(j);
        if (this.mDocs == null || this.mDocs.isEmpty()) {
            int length = DEF_DOCS.length;
            if (grade < 0 || grade >= length) {
                throw new RuntimeException("Fatal error: you input a illegal score value: " + j);
            }
            Doc doc = new Doc();
            doc.setGrade(grade);
            doc.setText(DEF_DOCS[grade]);
            return doc;
        }
        int size = this.mDocs.size();
        if (grade < 0 || grade >= size) {
            throw new RuntimeException("Fatal error: you input a illegal score value: " + j);
        }
        Doc doc2 = (Doc) this.mDocs.get(grade);
        if (doc2 != null && doc2.getText() != null) {
            return doc2;
        }
        doc2.setText(DEF_DOCS[grade]);
        return doc2;
    }

    private static int getGrade(long j) {
        if (j >= 0 && j < 2000) {
            return 0;
        }
        if (j >= 2000 && j < 4000) {
            return 1;
        }
        if (j >= 4000 && j < 5500) {
            return 2;
        }
        if (j >= 5500 && j < 8000) {
            return 3;
        }
        if (j >= 8000 && j < 12000) {
            return 4;
        }
        if (j >= 12000 && j < 15000) {
            return 5;
        }
        if (j >= 15000) {
            return 6;
        }
        return -1;
    }

    public void onError(Void voidR) {
    }

    public void onProgress(int i) {
    }

    public void onSuccess(List<Doc> list) {
        if (list == null || list.isEmpty()) {
            this.mDocs = new ArrayList(7);
            for (int i = 0; i < 7; i++) {
                Doc doc = new Doc();
                doc.setText(DEF_DOCS[i]);
                doc.setGrade(i);
                this.mDocs.add(doc);
            }
            return;
        }
        this.mDocs = list;
    }
}
