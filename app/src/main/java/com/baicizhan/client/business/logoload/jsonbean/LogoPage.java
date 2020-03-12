package com.baicizhan.client.business.logoload.jsonbean;

import java.util.List;

public class LogoPage {
    private List<Page> data;
    private ErrorInfo error;
    private int version;

    public class Page {
        private long begin;
        private long duration;
        private long end;
        private String url;

        public long getBegin() {
            return this.begin;
        }

        public void setBegin(long j) {
            this.begin = j;
        }

        public long getEnd() {
            return this.end;
        }

        public void setEnd(long j) {
            this.end = j;
        }

        public long getDuration() {
            return this.duration;
        }

        public void setDuration(long j) {
            this.duration = j;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{begin : ");
            sb.append(this.begin).append("; end : ").append(this.end).append("; duration : ").append(this.duration).append("; url : ").append(this.url);
            return sb.toString();
        }
    }

    public ErrorInfo getError() {
        return this.error;
    }

    public void setError(ErrorInfo errorInfo) {
        this.error = errorInfo;
    }

    public List<Page> getData() {
        return this.data;
    }

    public void setData(List<Page> list) {
        this.data = list;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public boolean isValid() {
        return (this.error == null || this.data == null) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Logo Page [");
        sb.append(this.error.toString()).append("]\n[").append(this.data.toString()).append("]\n[").append(this.version).append("]");
        return sb.toString();
    }
}
