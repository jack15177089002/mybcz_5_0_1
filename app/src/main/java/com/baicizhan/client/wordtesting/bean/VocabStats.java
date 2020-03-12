package com.baicizhan.client.wordtesting.bean;

import com.baicizhan.client.framework.log.C0789L;
import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
import java.util.Iterator;
import java.util.List;
import p012ch.qos.logback.classic.Level;

public class VocabStats {
    private StatsContent data;
    private ErrorInfo error;

    public class StatsContent {
        /* access modifiers changed from: private */
        public List<VocabEndPoint> coordinate;
        /* access modifiers changed from: private */
        public List<Integer> vocabCurve;

        public List<Integer> getVocabCurve() {
            return this.vocabCurve;
        }

        public void setVocabCurve(List<Integer> list) {
            this.vocabCurve = list;
        }

        public List<VocabEndPoint> getCoordinate() {
            return this.coordinate;
        }

        public void setCoordinate(List<VocabEndPoint> list) {
            this.coordinate = list;
        }

        public String toString() {
            return this.vocabCurve.toString() + "\n" + this.coordinate.toString();
        }
    }

    public class VocabEndPoint {
        private float score;
        private int vocabulary;

        public int getVocabulary() {
            return this.vocabulary;
        }

        public void setVocabulary(int i) {
            this.vocabulary = i;
        }

        public float getScore() {
            return this.score;
        }

        public void setScore(float f) {
            this.score = f;
        }

        public String toString() {
            return "{vocabulary: " + this.vocabulary + "}\n{score: " + this.score + "}";
        }
    }

    public ErrorInfo getError() {
        return this.error;
    }

    public void setError(ErrorInfo errorInfo) {
        this.error = errorInfo;
    }

    public StatsContent getData() {
        return this.data;
    }

    public void setData(StatsContent statsContent) {
        this.data = statsContent;
    }

    public boolean isValid() {
        int i;
        if (this.error == null || this.data == null) {
            C0789L.log.error("vocab stats data from net is null");
            return false;
        } else if (this.error.getCode() != 0) {
            C0789L.log.error("vocab stats data from net is illegal, err code is [{}]", (Object) Integer.valueOf(this.error.getCode()));
            return false;
        } else if (this.data.vocabCurve == null || this.data.vocabCurve.isEmpty()) {
            return false;
        } else {
            int i2 = Level.ALL_INT;
            Iterator it = this.data.vocabCurve.iterator();
            int i3 = Integer.MAX_VALUE;
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = ((Integer) it.next()).intValue();
                if (i2 < i3) {
                    i3 = i2;
                }
                if (i2 <= i) {
                    i2 = i;
                }
            }
            if (this.data.coordinate != null) {
                if (2 == this.data.coordinate.size()) {
                    if (i3 != ((VocabEndPoint) this.data.coordinate.get(0)).getVocabulary()) {
                        C0789L.log.error("vocab stats data from net is inconsistence");
                        return false;
                    } else if (i != ((VocabEndPoint) this.data.coordinate.get(1)).getVocabulary()) {
                        C0789L.log.error("vocab stats data from net is inconsistence");
                        return false;
                    } else if (i3 == i && ((VocabEndPoint) this.data.coordinate.get(0)).getScore() != ((VocabEndPoint) this.data.coordinate.get(1)).getScore()) {
                        C0789L.log.error("vocab stats data from net is inconsistence");
                        return false;
                    }
                } else if (1 == this.data.coordinate.size()) {
                    if (i3 != i) {
                        return false;
                    }
                } else if (this.data.coordinate.size() > 2) {
                    return false;
                }
            }
            return true;
        }
    }

    public String toString() {
        return "Vocab stats [" + this.error.toString() + "]\n[" + this.data.toString();
    }

    public static VocabStats newSampleInstance() {
//        return (VocabStats) new Gson().fromJson("{\"error\":{\"code\":0,\"msg\":\"\"},\"data\":{\"vocabCurve\":[4000,5000,4090,6000,7000,9000,4500,6600,5609,7700],\"coordinate\":[{\"vocabulary\":4000,\"score\":60.5},{\"vocabulary\":9000,\"score\":90}]}}", new TypeToken<VocabStats>() {
//        }.getType());

        return null;
    }
}
