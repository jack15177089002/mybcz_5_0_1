package com.baicizhan.client.wordtesting.util;

import com.baicizhan.client.framework.device.DeviceInfo;

public class Constants {
    public static final String RESULT_TEST_UPDATED = "result_test_updated";

    public static boolean isMI2S() {
        return "MI 2S - Xiaomi".equals(DeviceInfo.PHONE_MODEL);
    }
}
