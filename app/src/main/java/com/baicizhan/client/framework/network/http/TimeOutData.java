package com.baicizhan.client.framework.network.http;

public class TimeOutData {
    private int[] mTimeOut;

    public TimeOutData(int i) {
        this.mTimeOut = null;
        this.mTimeOut = new int[1];
        this.mTimeOut[0] = i;
    }

    public TimeOutData(int i, int i2, int i3) {
        this.mTimeOut = null;
        this.mTimeOut = new int[3];
        this.mTimeOut[0] = i;
        this.mTimeOut[1] = i2;
        this.mTimeOut[2] = i3;
    }

    public int getTimeOut2G() {
        if (this.mTimeOut == null || this.mTimeOut.length != 3) {
            return 0;
        }
        return this.mTimeOut[0];
    }

    public int getTimeOut3G() {
        if (this.mTimeOut == null || this.mTimeOut.length != 3) {
            return 0;
        }
        return this.mTimeOut[1];
    }

    public int getTimeOutWifi() {
        if (this.mTimeOut == null || this.mTimeOut.length != 3) {
            return 0;
        }
        return this.mTimeOut[2];
    }

    public int getTimeOut() {
        if (this.mTimeOut == null || this.mTimeOut.length != 1) {
            return 0;
        }
        return this.mTimeOut[0];
    }

    public int getTimeOutAuto() {
        if (this.mTimeOut == null || this.mTimeOut.length != 3) {
            return 0;
        }
        switch (NetUtil.getStatusInfo()) {
            case TwoG:
                return this.mTimeOut[0];
            case ThreeG:
                return this.mTimeOut[1];
            case WIFI:
                return this.mTimeOut[2];
            default:
                return this.mTimeOut[2];
        }
    }
}
