package com.baicizhan.client.wordlock.stat;

public class UserToken {
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "token=" + this.token;
    }
}
