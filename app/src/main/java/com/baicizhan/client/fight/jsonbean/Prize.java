package com.baicizhan.client.fight.jsonbean;

import com.google.gson.annotations.Expose;//import com.p020b.p021a.p022a.Expose;
import java.io.Serializable;

public class Prize implements Serializable {
    private static final long serialVersionUID = -4151219851345435676L;
    @Expose
    private String data;
    @Expose

    /* renamed from: id */
    private int f2269id;
    @Expose
    private String weiboUrl;
    @Expose
    private String weixinTitle;

    public int getId() {
        return this.f2269id;
    }

    public void setId(int i) {
        this.f2269id = i;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getWeiboUrl() {
        return this.weiboUrl;
    }

    public void setWeiboUrl(String str) {
        this.weiboUrl = str;
    }

    public String getWeixinTitle() {
        return this.weixinTitle;
    }

    public void setWeixinTitle(String str) {
        this.weixinTitle = str;
    }

    public String toString() {
        return "Prize [id=" + this.f2269id + ", data=" + this.data + "]";
    }
}
