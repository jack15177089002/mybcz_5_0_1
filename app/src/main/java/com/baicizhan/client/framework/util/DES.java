package com.baicizhan.client.framework.util;

import android.annotation.SuppressLint;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DES {
    private static final String ALGORITHM = "DESede";
    private static final String PROVIDER = "Desede/CBC/PKCS5Padding";
    private static final String encoding = "utf-8";

    /* renamed from: iv */
    private static final String f2305iv = "ohComein";
    private static final String secretKey = "boboLetmeinImTeacherLily";

    @SuppressLint({"TrulyRandom"})
    public static byte[] encrypt(String str) {
        SecretKey generateSecret = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(new DESedeKeySpec(secretKey.getBytes()));
        Cipher instance = Cipher.getInstance(PROVIDER);
        instance.init(1, generateSecret, new IvParameterSpec(f2305iv.getBytes()));
        return instance.doFinal(str.getBytes(encoding));
    }

    public static String decrypt(byte[] bArr) {
        SecretKey generateSecret = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(new DESedeKeySpec(secretKey.getBytes()));
        Cipher instance = Cipher.getInstance(PROVIDER);
        instance.init(2, generateSecret, new IvParameterSpec(f2305iv.getBytes()));
        return new String(instance.doFinal(bArr), encoding);
    }
}
