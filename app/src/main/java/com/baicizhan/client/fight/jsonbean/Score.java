package com.baicizhan.client.fight.jsonbean;

import com.baicizhan.client.business.jsonbean.IBean;
import com.google.gson.annotations.Expose;//import com.p020b.p021a.p022a.Expose;
import java.io.Serializable;
import java.util.List;

public class Score implements IBean, Serializable {
    private static final long serialVersionUID = 5709990327478129059L;
    @Expose
    private int correctCount = 0;
    @Expose
    private List<Detail> details;
    @Expose
    private int localResult = -100;
    @Expose
    private int useTimeSecond = 0;

    public class Detail implements Serializable {
        @Expose
        public static final int RIGHT = 0;
        @Expose
        public static final int WRONG = -1;
        private static final long serialVersionUID = -5618244897613352864L;
        @Expose

        /* renamed from: id */
        public int f2272id;
        @Expose
        public int res;
    }

    public int compareTo(Score score) {
        if (score == null || this.correctCount > score.correctCount) {
            return 1;
        }
        if (this.correctCount < score.correctCount) {
            return -1;
        }
        if (this.useTimeSecond < score.useTimeSecond) {
            return 1;
        }
        if (this.useTimeSecond > score.useTimeSecond) {
            return -1;
        }
        return 0;
    }

    public int getCorrectCount() {
        return this.correctCount;
    }

    public void setCorrectCount(int i) {
        this.correctCount = i;
    }

    public int getUseTimeSecond() {
        return this.useTimeSecond;
    }

    public void setUseTimeSecond(int i) {
        this.useTimeSecond = i;
    }

    public List<Detail> getDetails() {
        return this.details;
    }

    public void setDetails(List<Detail> list) {
        this.details = list;
    }

    public boolean isValide() {
        return this.correctCount > 0 && this.useTimeSecond > 0;
    }

    public int getLocalResult() {
        return this.localResult;
    }

    public void setLocalResult(int i) {
        this.localResult = i;
    }

    public String toString() {
        return "Score [correctCount=" + this.correctCount + ", useTimeSecond=" + this.useTimeSecond + ", details=" + this.details + ", localResult=" + this.localResult + "]";
    }
}
