package com.baicizhan.client.p029fm.data;

/* renamed from: com.baicizhan.client.fm.data.FmData_old */
public class FmData_old {
    String accent;
    String cnmean;
    String example;
    String fmid;
    String hdpath;
    String path;
    String word;
    String wordid;

    public String getWordid() {
        return this.wordid;
    }

    public String getFmid() {
        return this.fmid;
    }

    public String getWord() {
        return this.word;
    }

    public String getAccent() {
        return this.accent;
    }

    public String getCnmean() {
        return this.cnmean;
    }

    public String getExample() {
        return this.example;
    }

    public String getPath() {
        return this.path;
    }

    public String getHdpath() {
        return this.hdpath;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FmData {");
        sb.append("wordid:").append(this.wordid).append(", fmid:").append(this.fmid).append(", word:").append(this.word).append(", accent:").append(this.accent).append(", cnmean:").append(this.cnmean).append(", example:").append(this.example).append(", path:").append(this.path).append(", hdpath:").append(this.hdpath).append("}");
        return sb.toString();
    }
}
