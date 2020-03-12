package com.baicizhan.client.fight.jsonbean;

import java.io.Serializable;

public class SubmitReply implements Serializable {
    private static final long serialVersionUID = 6643630705881610102L;
    private Prize prize;
    private String prompt;
    private String share_detail_url_weibo;
    private String share_detail_url_weixin;

    public String getPrompt() {
        return this.prompt;
    }

    public void setPrompt(String str) {
        this.prompt = str;
    }

    public String getShareDetailURLWeixin() {
        return this.share_detail_url_weixin;
    }

    public void setShareDetailURLWeixin(String str) {
        this.share_detail_url_weixin = str;
    }

    public String getShareDetailURLWeibo() {
        return this.share_detail_url_weibo;
    }

    public void setShareDetailURLWeibo(String str) {
        this.share_detail_url_weibo = str;
    }

    public Prize getPrize() {
        return this.prize;
    }

    public void setPrize(Prize prize2) {
        this.prize = prize2;
    }
}
