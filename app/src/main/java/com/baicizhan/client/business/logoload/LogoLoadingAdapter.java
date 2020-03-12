package com.baicizhan.client.business.logoload;

import com.baicizhan.client.business.logoload.LPDaos.Loading;
import com.baicizhan.client.business.logoload.jsonbean.LogoPage;
import com.baicizhan.client.business.logoload.jsonbean.LogoPage.Page;
import java.util.ArrayList;
import java.util.List;

public class LogoLoadingAdapter {
    private List<Loading> mLoadings;
    private int mVersion;

    public List<Loading> getLoadings() {
        return this.mLoadings;
    }

    public void setLoadings(List<Loading> list) {
        this.mLoadings = list;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public LogoLoadingAdapter(LogoPage logoPage) {
        if (logoPage != null) {
            adapt(logoPage);
        }
    }

    public void setLogoPage(LogoPage logoPage) {
        if (logoPage != null) {
            adapt(logoPage);
        }
    }

    private void adapt(LogoPage logoPage) {
        this.mLoadings = new ArrayList(logoPage.getData().size());
//        for (Page page : logoPage.getData()) {
//            Loading loading = new Loading();
//            loading.setStart(page.getBegin());
//            loading.setEnd(page.getEnd());
//            loading.setDuration(page.getDuration());
//            loading.setUrl(page.getUrl());
//            this.mLoadings.add(loading);
//        }
        this.mVersion = logoPage.getVersion();
    }
}
