//package com.baicizhan.client.business.util;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.os.Message;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baidu.location.BDLocation;
//import com.baidu.location.C1398a;
//import com.baidu.location.C1456d;
//import com.baidu.location.C1509h;
//import com.baidu.location.C1527j;
//import com.baidu.location.p039e.C1468ag;
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.Expose;//import com.p020b.p021a.p022a.Expose;
//
//public class LocationUtils {
//    private static final int LOCATION_SCAN_SPAN = 120000;
//    private static final String PREF_CITY = "PREF_CITY";
//    private static final String PREF_DISTINCT = "PREF_DISTINCT";
//    private static final String PREF_LATITITUDE = "PREF_LATITUDE";
//    private static final String PREF_LONGTITUDE = "PREF_LONGTITUDE";
//    private static final String PREF_PROVINCE = "PREF_PROVINCE";
//    public static final String TAG = LocationUtils.class.getSimpleName();
//    private static LocationUtils singleton = null;
//    /* access modifiers changed from: private */
//    public LocationInfo mLocation = null;
//    private C1456d mLocationClient = null;
//    private C1398a mLocationListener = null;
//    private boolean mLocationStarted = false;
//    private SharedPreferences mPref;
//
//    public class LocationInfo {
//        @Expose
//        public String city;
//        @Expose
//        public String district;
//        @Expose
//        public double latitude;
//        @Expose
//        public double longitude;
//        @Expose
//        public String province;
//
//        public String toString() {
//            return "Position [longitude=" + this.longitude + ", latitude=" + this.latitude + ", province=" + this.province + ", city=" + this.city + ", district=" + this.district + "]";
//        }
//
//        public  LocationInfo fromBDLocation(BDLocation bDLocation) {
//            LocationInfo locationInfo = new LocationInfo();
//            locationInfo.longitude = bDLocation.f2608d;
//            locationInfo.latitude = bDLocation.f2607c;
//            locationInfo.province = bDLocation.f2617m.f3417c;
//            locationInfo.city = bDLocation.f2617m.f3418d;
//            locationInfo.district = bDLocation.f2617m.f3420f;
//            return locationInfo;
//        }
//    }
//
//    public static LocationUtils with(Context context) {
//        if (singleton == null) {
//            synchronized (LocationUtils.class) {
//                singleton = new LocationUtils(context.getApplicationContext());
//            }
//        }
//        return singleton;
//    }
//
//    /* access modifiers changed from: private */
//    public static String locationToString(BDLocation bDLocation) {
//        StringBuffer stringBuffer = new StringBuffer(256);
//        stringBuffer.append("[time : ");
//        stringBuffer.append(bDLocation.f2606b);
//        stringBuffer.append(", error code : ");
//        stringBuffer.append(bDLocation.f2605a);
//        stringBuffer.append(", latitude : ");
//        stringBuffer.append(bDLocation.f2607c);
//        stringBuffer.append(", lontitude : ");
//        stringBuffer.append(bDLocation.f2608d);
//        stringBuffer.append(", radius : ");
//        stringBuffer.append(bDLocation.f2610f);
//        if (bDLocation.f2605a == 61) {
//            stringBuffer.append(", speed : ");
//            stringBuffer.append(bDLocation.f2609e);
//            stringBuffer.append(", satellite : ");
//            bDLocation.f2611g = true;
//            stringBuffer.append(bDLocation.f2612h);
//        } else if (bDLocation.f2605a == 161) {
//            stringBuffer.append(", province " + bDLocation.f2617m.f3417c).append(", city " + bDLocation.f2617m.f3418d).append(", district " + bDLocation.f2617m.f3420f).append(", street " + bDLocation.f2617m.f3421g).append(", street number " + bDLocation.f2617m.f3422h);
//            stringBuffer.append(", addr : ");
//            stringBuffer.append(bDLocation.f2617m.f3423i);
//        }
//        stringBuffer.append("]");
//        return stringBuffer.toString();
//    }
//
//    private LocationUtils(Context context) {
//        C0789L.log.debug("initialize ");
//        this.mPref = context.getSharedPreferences(TAG, 0);
//        this.mLocationClient = new C1456d(context.getApplicationContext());
//        this.mLocationListener = new C1398a() {
//            public void onReceiveLocation(BDLocation bDLocation) {
//                int i = bDLocation.f2605a;
//                if (i == 65 || i == 161 || i == 61 || i == 66) {
//                    LogWrapper.m2795i(LocationUtils.TAG, "BDLocation success: " + LocationUtils.locationToString(bDLocation));
//                    LocationUtils.this.saveLastLocation(bDLocation);
////                    LocationUtils.this.mLocation = LocationInfo.fromBDLocation(bDLocation);
//                } else {
//                    LogWrapper.m2795i(LocationUtils.TAG, "BDLocation failed " + i + ", using last location!!! " + LocationUtils.locationToString(bDLocation));
//                }
//                LogWrapper.m2795i(LocationUtils.TAG, "BDLocation use position " + LocationUtils.this.mLocation);
//                LocationUtils.this.stop();
//            }
//        };
//        C1456d dVar = this.mLocationClient;
//        C1398a aVar = this.mLocationListener;
//        if (aVar == null) {
//            throw new IllegalStateException("please set a non-null listener");
//        }
//        Message obtainMessage = dVar.f2996g.obtainMessage(5);
//        obtainMessage.obj = aVar;
//        obtainMessage.sendToTarget();
//        C1509h hVar = new C1509h();
//        hVar.mo16079a(C1527j.Battery_Saving);
//        String lowerCase = "gcj02".toLowerCase();
//        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
//            hVar.f3301a = lowerCase;
//        }
//        hVar.f3304d = LOCATION_SCAN_SPAN;
//        hVar.f3302b = "all";
//        C1456d dVar2 = this.mLocationClient;
//        if (dVar2.f3015z == null) {
//            dVar2.f3015z = new C1468ag(dVar2.f2994e, hVar, dVar2);
//            dVar2.f3015z.mo16032a();
//        }
//        Message obtainMessage2 = dVar2.f2996g.obtainMessage(3);
//        obtainMessage2.obj = hVar;
//        obtainMessage2.sendToTarget();
//        restoreLastLocation();
//    }
//
//    private void restoreLastLocation() {
//        C0789L.log.info("restoreLastLocation");
//        BDLocation bDLocation = this.mLocationClient.f2999j;
//        if (bDLocation != null) {
////            this.mLocation = LocationInfo.fromBDLocation(bDLocation);
//            C0789L.log.info("restoreLastLocation from lastKnowLocation " + this.mLocation);
//            return;
//        }
//        LocationInfo locationInfo = new LocationInfo();
//        locationInfo.longitude = Double.valueOf(this.mPref.getString(PREF_LONGTITUDE, "104.079668")).doubleValue();
//        locationInfo.latitude = Double.valueOf(this.mPref.getString(PREF_LATITITUDE, "30.647047")).doubleValue();
//        locationInfo.province = this.mPref.getString(PREF_PROVINCE, "四川省");
//        locationInfo.city = this.mPref.getString(PREF_CITY, "成都市");
//        locationInfo.district = this.mPref.getString(PREF_DISTINCT, "锦江区");
//        this.mLocation = locationInfo;
//        C0789L.log.info("restoreLastLocation from pref " + this.mLocation);
//    }
//
//    /* access modifiers changed from: private */
//    public void saveLastLocation(BDLocation bDLocation) {
//        this.mPref.edit().putString(PREF_LONGTITUDE, Double.toString(bDLocation.f2608d)).putString(PREF_LATITITUDE, Double.toString(bDLocation.f2607c)).putString(PREF_PROVINCE, bDLocation.f2617m.f3417c).putString(PREF_CITY, bDLocation.f2617m.f3418d).putString(PREF_DISTINCT, bDLocation.f2617m.f3420f).apply();
//    }
//
//    public LocationInfo getLocation() {
//        return this.mLocation;
//    }
//
//    public void start() {
//        if (this.mLocationClient != null && !this.mLocationStarted && !this.mLocationClient.f2993d) {
//            LogWrapper.m2793d(TAG, "LocationClient.start");
//            this.mLocationStarted = true;
//            C1456d dVar = this.mLocationClient;
//            dVar.f3012w = false;
//            dVar.f2996g.obtainMessage(1).sendToTarget();
//            C1456d dVar2 = this.mLocationClient;
//            if (!(dVar2.f2995f == null || dVar2.f2997h == null || dVar2.f2998i == null || dVar2.f2998i.size() <= 0)) {
//                dVar2.f2996g.obtainMessage(12).sendToTarget();
//            }
//            C1456d dVar3 = this.mLocationClient;
//            if (dVar3.f2995f != null && dVar3.f2997h != null && dVar3.f2998i != null && dVar3.f2998i.size() > 0 && System.currentTimeMillis() - dVar3.f2990a >= 1000) {
//                Message obtainMessage = dVar3.f2996g.obtainMessage(4);
//                obtainMessage.arg1 = 0;
//                obtainMessage.sendToTarget();
//            }
//        }
//    }
//
//    public void stop() {
//        if (this.mLocationClient != null && this.mLocationStarted && this.mLocationClient.f2993d) {
//            LogWrapper.m2793d(TAG, "LocationClient.stop");
//            this.mLocationStarted = false;
//            C1456d dVar = this.mLocationClient;
//            dVar.f3012w = true;
//            dVar.f2996g.obtainMessage(2).sendToTarget();
//            dVar.f3015z = null;
//            this.mLocationClient = null;
//        }
//    }
//}
