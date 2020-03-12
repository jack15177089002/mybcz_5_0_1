//package com.baicizhan.client.p029fm.service.proxy;
//
//import android.util.Log;
//
///* renamed from: com.baicizhan.client.fm.service.proxy.FmPlayerProxy */
//public class FmPlayerProxy {
//    FmServiceProxy mServiceProxy;
//
//    FmPlayerProxy() {
//    }
//
//    public void newPlay(int i) {
//        Log.d("whiz", "new play in proxy, index: " + i + "; service proxy: " + this.mServiceProxy);
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.newPlay(i);
//        }
//    }
//
//    public void newPlayMid(int i) {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.newPlayMid(i);
//        }
//    }
//
//    public void newPlay(String str) {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.newPlay(str);
//        }
//    }
//
//    public void play() {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.play();
//        }
//    }
//
//    public void playNext() {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.playNext();
//        }
//    }
//
//    public void playPrev() {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.playPrev();
//        }
//    }
//
//    public void pause() {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.pause();
//        }
//    }
//
//    public void stop() {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.stop();
//        }
//    }
//
//    public void toggle() {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.toggle();
//        }
//    }
//
//    public void setPlayQuality(boolean z) {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.setPlayQuality(z);
//        }
//    }
//
//    public void setPlayLimit(int i) {
//        if (this.mServiceProxy != null) {
//            this.mServiceProxy.setPlayLimit(i);
//        }
//    }
//}
