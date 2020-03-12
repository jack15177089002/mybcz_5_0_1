//package com.baicizhan.client.push;
//
//import android.content.Context;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.push.PushManager.PushListener;
////import com.tencent.android.tpush.XGPushBaseReceiver;
////import com.tencent.android.tpush.XGPushClickedResult;
////import com.tencent.android.tpush.XGPushRegisterResult;
////import com.tencent.android.tpush.XGPushShowedResult;
////import com.tencent.android.tpush.XGPushTextMessage;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class PushReceiver extends XGPushBaseReceiver {
//    private static final String CUSTOM_KEY_EXTDATA = "extData";
//    private static final String CUSTOM_KEY_MSG = "msg";
//    private static final String CUSTOM_KEY_MSGTYPE = "msgType";
//    public static final String TAG = PushReceiver.class.getSimpleName();
//
//    public void onNotifactionClickedResult(Context context, XGPushClickedResult xGPushClickedResult) {
//    }
//
//    public void onNotifactionShowedResult(Context context, XGPushShowedResult xGPushShowedResult) {
//    }
//
//    public void onRegisterResult(Context context, int i, XGPushRegisterResult xGPushRegisterResult) {
//        Log.d(TAG, "onRegisterResult errorCode " + i + " " + xGPushRegisterResult);
//    }
//
//    public void onUnregisterResult(Context context, int i) {
//        Log.d(TAG, "onUnregisterResult " + i);
//    }
//
//    public void onSetTagResult(Context context, int i, String str) {
//    }
//
//    public void onDeleteTagResult(Context context, int i, String str) {
//    }
//
//    public void onTextMessage(Context context, XGPushTextMessage xGPushTextMessage) {
//        String customContent = xGPushTextMessage.getCustomContent();
//        if (!TextUtils.isEmpty(customContent)) {
//            try {
//                JSONObject jSONObject = new JSONObject(customContent);
//                String string = jSONObject.getString("msgType");
//                String string2 = jSONObject.getString(CUSTOM_KEY_MSG);
//                JSONObject jSONObject2 = new JSONObject(jSONObject.getString(CUSTOM_KEY_EXTDATA));
//                PushListener findPushListener = PushManager.getInstance().findPushListener(string);
//                LogWrapper.m2793d(TAG, "onTextMessage " + string + ", " + string + ", " + jSONObject2);
//                findPushListener.onPush(string, string2, jSONObject2);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
