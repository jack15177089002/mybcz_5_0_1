package com.baicizhan.store.api;

//import com.tencent.android.tpush.common.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KdtApiProtocol {
    public static final int ALLOWED_DEVIATE_SECONDS = 600;
    public static final String APP_ID_KEY = "app_id";
    public static final int ERR_EMPTY_SIGNATURE = 40004;
    public static final int ERR_INVALID_APP = 40002;
    public static final int ERR_INVALID_APP_ID = 40001;
    public static final int ERR_INVALID_METHOD = 40007;
    public static final int ERR_INVALID_METHOD_NAME = 40006;
    public static final int ERR_INVALID_SIGNATURE = 40005;
    public static final int ERR_INVALID_TEAM = 40008;
    public static final int ERR_INVALID_TIMESTAMP = 40003;
    public static final int ERR_LOGIC = 50000;
    public static final int ERR_PARAMETER = 41000;
    public static final int ERR_SYSTEM = -1;
    public static final String FORMAT_KEY = "format";
    public static final String METHOD_KEY = "method";
    public static final String SIGN_KEY = "sign";
    public static final String SIGN_METHOD_KEY = "sign_method";
    public static final String TIMESTAMP_KEY = "timestamp";
    public static final String VERSION_KEY = "v";

    public static String sign(String str, HashMap<String, String> hashMap) {
        Object[] array = hashMap.keySet().toArray();
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= array.length) {
                break;
            }
            arrayList.add((String) array[i2]);
            i = i2 + 1;
        }
        Collections.sort(arrayList);
        String str2 = str;
        for (String str3 : arrayList) {
            str2 = str2 + str3 + ((String) hashMap.get(str3));
        }
        return hash(str2 + str);
    }

    private static String hash(String str) {
        String str2 = "";
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
//            for (byte b : digest) {
//                stringBuffer.append(Integer.toString((b & Constants.NETWORK_TYPE_UNCONNECTED) + 256, 16).substring(1));
//            }
            return stringBuffer.toString().toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            return str2;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str2;
        }
    }
}
