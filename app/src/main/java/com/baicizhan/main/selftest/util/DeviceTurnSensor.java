//package com.baicizhan.main.selftest.util;
//
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import java.lang.ref.WeakReference;
//
//public class DeviceTurnSensor {
//    public static final int DIRECTION_FACE_DOWN = 1;
//    public static final int DIRECTION_FACE_UP = 0;
//    private static final int MSG_DIRECTION_CHANGED = 0;
//    /* access modifiers changed from: private */
//    public int mDirection = 0;
//    private boolean mEnabled = false;
//    private SensorEventHandler mHandler;
//    /* access modifiers changed from: private */
//    public OnDirectionChangeListener mListener;
//    private Sensor mSensor;
//    private SensorEventListener mSensorListener = new SensorEventListener() {
//        private float lastZ;
//
//        public void onSensorChanged(SensorEvent sensorEvent) {
//            float f = sensorEvent.values[2];
//            if (f <= -0.7f) {
//                if (1 != DeviceTurnSensor.this.mDirection) {
//                    DeviceTurnSensor.this.sendDirecitonChangeEvent(1);
//                    DeviceTurnSensor.this.mDirection = 1;
//                }
//            } else if (f >= 7.0f && f <= 11.0f) {
//                if (Math.abs(f - this.lastZ) >= 0.25f) {
//                    this.lastZ = f;
//                } else if (DeviceTurnSensor.this.mDirection != 0) {
//                    DeviceTurnSensor.this.sendDirecitonChangeEvent(0);
//                    DeviceTurnSensor.this.mDirection = 0;
//                }
//            }
//        }
//
//        public void onAccuracyChanged(Sensor sensor, int i) {
//        }
//    };
//    private SensorManager mSensorManager;
//
//    public interface OnDirectionChangeListener {
//        void onDirectionChanged(int i);
//    }
//
//    class SensorEventHandler extends Handler {
//        final WeakReference<DeviceTurnSensor> mSensor;
//
//        SensorEventHandler(DeviceTurnSensor deviceTurnSensor) {
//            super(Looper.getMainLooper());
//            this.mSensor = new WeakReference<>(deviceTurnSensor);
//        }
//
//        public void handleMessage(Message message) {
//            DeviceTurnSensor deviceTurnSensor = (DeviceTurnSensor) this.mSensor.get();
//            if (deviceTurnSensor != null) {
//                switch (message.what) {
//                    case 0:
//                        if (deviceTurnSensor.mListener != null) {
//                            deviceTurnSensor.mListener.onDirectionChanged(message.arg1);
//                            return;
//                        }
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    private DeviceTurnSensor() {
//    }
//
//    public static DeviceTurnSensor createInstance(Context context, OnDirectionChangeListener onDirectionChangeListener) {
//        DeviceTurnSensor deviceTurnSensor = new DeviceTurnSensor();
//        deviceTurnSensor.mSensorManager = (SensorManager) context.getSystemService("sensor");
//        deviceTurnSensor.mSensor = deviceTurnSensor.mSensorManager.getDefaultSensor(1);
//        deviceTurnSensor.mListener = onDirectionChangeListener;
//        deviceTurnSensor.mHandler = new SensorEventHandler(deviceTurnSensor);
//        return deviceTurnSensor;
//    }
//
//    public void setEnabled(boolean z) {
//        if (this.mEnabled != z) {
//            this.mEnabled = z;
//            if (z) {
//                this.mSensorManager.registerListener(this.mSensorListener, this.mSensor, 2);
//                return;
//            }
//            this.mSensorManager.unregisterListener(this.mSensorListener);
//            this.mHandler.removeMessages(0);
//        }
//    }
//
//    public int getDirection() {
//        return this.mDirection;
//    }
//
//    /* access modifiers changed from: private */
//    public void sendDirecitonChangeEvent(int i) {
//        Message obtainMessage = this.mHandler.obtainMessage(0);
//        obtainMessage.arg1 = i;
//        this.mHandler.sendMessage(obtainMessage);
//    }
//}
