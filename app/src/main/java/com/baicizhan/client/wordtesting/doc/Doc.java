package com.baicizhan.client.wordtesting.doc;

public class Doc {
    private int grade;
    private String text;

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public String toString() {
        return "Doc [text : " + this.text + "]; [grade : " + this.grade + "]";
    }
}
