package com.baicizhan.client.business.thrift;

import java.util.Locale;

public class BackupUrlPolicy implements UrlPolicy {
    private static final String URL_FORMAT = "%s%s/%d";
    private String domain;
    private String masterUrl;
    private String slaveUrl;

    public BackupUrlPolicy(String str, String str2, String str3) {
        this.domain = str;
        this.masterUrl = str2;
        this.slaveUrl = str3;
    }

    public void setMasterUrl(String str) {
        this.masterUrl = str;
    }

    public void setSlaveUrl(String str) {
        this.slaveUrl = str;
    }

    public String getUrl(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = this.masterUrl;
        if (i == i2 - 1 && this.slaveUrl != null) {
            str = this.slaveUrl;
        }
        return String.format(Locale.US, URL_FORMAT, new Object[]{str, this.domain, Long.valueOf(currentTimeMillis)});
    }
}
