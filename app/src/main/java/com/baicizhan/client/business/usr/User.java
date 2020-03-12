package com.baicizhan.client.business.usr;

public class User {
    private String name;
    private String nickname;
    private String token;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getNickname() {
        if (this.nickname == null || this.nickname.length() == 0) {
            return this.name;
        }
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

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
