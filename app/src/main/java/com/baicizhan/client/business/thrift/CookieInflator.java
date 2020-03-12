package com.baicizhan.client.business.thrift;

public interface CookieInflator {
    String getCookie();

    boolean hasKey(String str);

    void put(String str, String str2);

    void remove(String str);
}
