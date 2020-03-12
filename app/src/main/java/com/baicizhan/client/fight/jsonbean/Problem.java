package com.baicizhan.client.fight.jsonbean;

import com.baicizhan.client.business.jsonbean.IBean;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Problem implements IBean, Serializable {
    public static final int TYPE_SELECT_CN = 2;
    public static final int TYPE_SELECT_IMAGE = 1;
    public static final int TYPE_SELECT_VOICE = 3;
    private static final long serialVersionUID = -2395388784919859624L;
    private int answer;
    private List<Option> options;
    private String title;
    private int topicId;
    private int type;
    private String voice;

    public class Option implements Serializable {
        private static final long serialVersionUID = -1144934296505884916L;
        private String imageUrl;
        private String meanCn;
        private String word;

        public Option() {
        }

        public Option(String str, String str2) {
            this.imageUrl = str;
            this.meanCn = str2;
        }

        public String getImageUrl() {
            return this.imageUrl;
        }

        public void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public String getMeanCn() {
            return this.meanCn;
        }

        public void setMeanCn(String str) {
            this.meanCn = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\nimageUrl: ").append(this.imageUrl).append("\nmeanCn: ").append(this.meanCn);
            return sb.toString();
        }

        public String getWord() {
            return this.word;
        }

        public void setWord(String str) {
            this.word = str;
        }
    }

    public Problem() {
    }

    public Problem(String str, int i, int i2, Option... optionArr) {
        this.title = str;
        this.type = i;
        this.answer = i2;
        if (optionArr != null) {
            this.options = Arrays.asList(optionArr);
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<Option> getOptions() {
        return this.options;
    }

    public void setOptions(List<Option> list) {
        this.options = list;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getAnswer() {
        return this.answer;
    }

    public void setAnswer(int i) {
        this.answer = i;
    }

    public String getVoice() {
        return this.voice;
    }

    public void setVoice(String str) {
        this.voice = str;
    }

    public int getTopicId() {
        return this.topicId;
    }

    public void setTopicId(int i) {
        this.topicId = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("title: ").append(this.title).append("\noptions: ").append(this.options).append("\ntype: ").append(this.type).append("\nanswer: ").append(this.answer).append("\nvoice: ").append(this.voice);
        return sb.toString();
    }

    public boolean isValide() {
        return this.title != null && this.options != null && this.voice != null && this.type > 0 && this.answer > 0 && !this.title.equals("") && !this.voice.equals("") && !this.options.isEmpty();
    }
}
