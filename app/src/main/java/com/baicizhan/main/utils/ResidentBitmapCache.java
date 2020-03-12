//package com.baicizhan.main.utils;
//
//import android.content.Context;
//import android.content.res.Resources;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import android.widget.ImageView;
//import com.jiongji.andriod.card.R;
//import java.util.Map;
//
//public class ResidentBitmapCache {
//    public static final int[] LEARN_RESIDENT_RESOURCES = {R.drawable.right_mid_normal_default, R.drawable.wrong_mid_normal_default, R.drawable.right_big_normal_default, R.drawable.wrong_big_normal_default, R.drawable.satus_eye_normal_default, R.drawable.satus_slash_normal_default, R.drawable.satus_right_normal_default, R.drawable.satus_wrong_normal_default, R.drawable.image_broke_normal_default};
//    private static Map<Integer, Bitmap> bitmapCache = new ArrayMap();
//
//    public static void preload(Context context, int... iArr) {
//        Resources resources = context.getResources();
//        for (int i : iArr) {
//            if (!bitmapCache.containsKey(Integer.valueOf(i))) {
//                put(resources, i);
//            }
//        }
//    }
//
//    private static void put(Resources resources, int i) {
//        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
//        if (decodeResource != null) {
//            bitmapCache.put(Integer.valueOf(i), decodeResource);
//        }
//    }
//
//    public static void release() {
//        bitmapCache.clear();
//    }
//
//    public static void setImageResource(ImageView imageView, int i) {
//        imageView.setImageBitmap(getBitmap(imageView.getContext(), i));
//    }
//
//    public static Bitmap getBitmap(Context context, int i) {
//        Bitmap bitmap = (Bitmap) bitmapCache.get(Integer.valueOf(i));
//        if (bitmap != null) {
//            return bitmap;
//        }
//        put(context.getResources(), i);
//        return (Bitmap) bitmapCache.get(Integer.valueOf(i));
//    }
//}
