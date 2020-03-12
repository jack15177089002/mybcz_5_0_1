package org.slf4j.android;

public class AndroidProperties {
    private static final AndroidProperties sInstance = new AndroidProperties();
    private String mPackage;
    private String mVersionCode;
    private String mVersionName;

    public static AndroidProperties getInstance() {
        return sInstance;
    }

    private AndroidProperties() {
    }

    public String getVersionName() {
        return this.mVersionName;
    }

    public AndroidProperties setVersionName(String str) {
        this.mVersionName = str;
        return this;
    }

    public String getVersionCode() {
        return this.mVersionCode;
    }

    public AndroidProperties setVersionCode(String str) {
        this.mVersionCode = str;
        return this;
    }

    public String getPackage() {
        return this.mPackage;
    }

    public AndroidProperties setPackage(String str) {
        this.mPackage = str;
        return this;
    }
}
