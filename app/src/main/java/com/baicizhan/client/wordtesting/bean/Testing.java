package com.baicizhan.client.wordtesting.bean;

import java.util.ArrayList;
import java.util.List;

public class Testing {
    private Word correct;
    private List<Word> options = new ArrayList();

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("word[" + this.correct + "]");
        stringBuffer.append(" ");
        stringBuffer.append("opts[");
        boolean z = true;
        for (Word word : this.options) {
            if (!z) {
                stringBuffer.append(",");
            } else {
                z = false;
            }
            stringBuffer.append(word);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public Word getCorrect() {
        return this.correct;
    }

    public void setCorrect(Word word) {
        this.correct = word;
    }

    public List<Word> getOptions() {
        return this.options;
    }

    public void addOption(Word word) {
        this.options.add(word);
    }
}
