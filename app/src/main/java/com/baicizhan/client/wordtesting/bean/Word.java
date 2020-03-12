package com.baicizhan.client.wordtesting.bean;

import com.baicizhan.main.auth.ThirdPartyUserInfo;
import java.util.Locale;
import org.mozilla.javascript.NativeObject;

public class Word {

    /* renamed from: m */
    private String f2392m;

    /* renamed from: p */
    private String f2393p;

    /* renamed from: r */
    private int f2394r;

    /* renamed from: s */
    private int f2395s;

    /* renamed from: w */
    private String f2396w;

    public Word() {
    }

    public Word(NativeObject cbVar) {
        try {
            this.f2395s = ((Integer) cbVar.get("s")).intValue();
        } catch (Exception e) {
        }
        try {
            this.f2394r = ((Integer) cbVar.get("r")).intValue();
        } catch (Exception e2) {
        }
        try {
            this.f2396w = (String) cbVar.get("w");
        } catch (Exception e3) {
        }
        try {
            this.f2392m = (String) cbVar.get(ThirdPartyUserInfo.GENDER_MALE);
        } catch (Exception e4) {
        }
        try {
            this.f2393p = (String) cbVar.get("p");
        } catch (Exception e5) {
        }
    }

    public String toString() {
        return String.format(Locale.CHINA, "<s:%d r:%d w:%s m:%s>", new Object[]{Integer.valueOf(this.f2395s), Integer.valueOf(this.f2394r), this.f2396w, this.f2392m});
    }

    public int getS() {
        return this.f2395s;
    }

    public void setS(int i) {
        this.f2395s = i;
    }

    public int getR() {
        return this.f2394r;
    }

    public void setR(int i) {
        this.f2394r = i;
    }

    public String getW() {
        return this.f2396w;
    }

    public void setW(String str) {
        this.f2396w = str;
    }

    public String getM() {
        return this.f2392m;
    }

    public void setM(String str) {
        this.f2392m = str;
    }

    public String getP() {
        return this.f2393p;
    }

    public void setP(String str) {
        this.f2393p = str;
    }
}
