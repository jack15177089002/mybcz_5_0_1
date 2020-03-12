package com.baicizhan.client.framework;

import com.baicizhan.client.framework.device.DeviceInfo;
import com.baicizhan.client.framework.handler.AbstractAppHandler;
import com.baicizhan.client.framework.network.VolleyUtils;
import org.slf4j.android.AndroidProperties;

public class BaseAppHandler extends AbstractAppHandler {
    public void onCreate() {
        VolleyUtils.initialize(getApp());
        DeviceInfo.init();
        initAndroidPropertiesForLogback();
    }

    private static final void initAndroidPropertiesForLogback() {
        AndroidProperties.getInstance().setPackage(getApp().getPackageName()).setVersionCode(DeviceInfo.getBaicizhanVersionCode()).setVersionName(DeviceInfo.getBaicizhanVersionName());
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
