//package com.baicizhan.client.wordlock.util;
//
//import android.annotation.TargetApi;
//import android.app.ActivityManager;
//import android.app.ActivityManager.RunningTaskInfo;
//import android.content.Context;
//import android.os.Build.VERSION;
//import android.text.SpannableString;
//import android.text.TextPaint;
//import android.text.TextUtils;
//import android.text.style.MetricAffectingSpan;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.StringUtil;
//import com.baicizhan.client.framework.device.DeviceInfo;
//import com.baicizhan.client.framework.util.Common;
////import com.baicizhan.client.wordlock.BuildConfig;
//import com.baicizhan.client.wordlock.util.ColorAccent.Element;
//import com.tencent.android.tpush.common.Constants;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Locale;
//
//public class Utils {
//    public static final int DEV_H_480DP = 480;
//    public static final int DEV_H_592DP = 592;
//    public static final int DEV_H_640DP = 640;
//
//    class RedSpan extends MetricAffectingSpan {
//        private RedSpan() {
//        }
//
//        public void updateMeasureState(TextPaint textPaint) {
//        }
//
//        public void updateDrawState(TextPaint textPaint) {
//            textPaint.setColor(-65536);
//        }
//    }
//
//    private Utils() {
//    }
//
//    public static void reSizeText(Context context, TextView textView, String str, int i, float f) {
//        textView.setTextSize(0, reSizeTextSize(textView, textView.getPaint(), (float) context.getResources().getDimensionPixelSize(i), str, (int) (((float) Common.getScreenWidth(context)) * f)));
//    }
//
//    public static float reSizeTextSize(TextView textView, TextPaint textPaint, float f, String str, int i) {
//        return reSizeTextSize(textView, textPaint, f, str, i, -1, 1);
//    }
//
//    public static float reSizeTextSize(TextView textView, TextPaint textPaint, float f, String str, int i, int i2, int i3) {
//        float f2 = f;
//        while (f2 > 0.0f) {
//            textPaint.setTextSize(f2);
//            float lineHeight = (float) textView.getLineHeight();
//            float measureText = textPaint.measureText(str);
//            if (measureText >= ((float) (i3 * i))) {
//                f2 -= 2.0f;
//            } else if (i2 <= 0 || measureText < ((float) i) || lineHeight * ((float) i3) < ((float) i2)) {
//                return f2;
//            } else {
//                f2 -= 1.0f;
//            }
//        }
//        return 0.0f;
//    }
//
//    public static final List<String> removeRepeated(List<String> list) {
//        if (list == null || list.isEmpty()) {
//            return list;
//        }
//        HashSet hashSet = new HashSet(list.size());
//        hashSet.addAll(list);
//        ArrayList arrayList = new ArrayList(hashSet.size());
//        arrayList.addAll(hashSet);
//        return arrayList;
//    }
//
//    public static final String correctResSuffix(String str) {
//        if (str == null) {
//            return null;
//        }
//        int indexOf = str.toLowerCase(Locale.ENGLISH).indexOf(".");
//        if (indexOf >= 0) {
//            return str.substring(0, indexOf) + PathUtil.BAICIZHAN_RESOURCE_EXTENSION;
//        }
//        return null;
//    }
//
//    @TargetApi(11)
//    public static void moveToFront(Context context) {
//        if (VERSION.SDK_INT >= 11) {
//            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
//            List runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
//            int i = 0;
////            while (true) {
////                int i2 = i;
////                if (i2 < runningTasks.size()) {
////                    if (((RunningTaskInfo) runningTasks.get(i2)).baseActivity.toShortString().indexOf(BuildConfig.APPLICATION_ID) >= 0) {
////                        activityManager.moveTaskToFront(((RunningTaskInfo) runningTasks.get(i2)).id, 1);
////                    }
////                    i = i2 + 1;
////                } else {
////                    return;
////                }
////            }
//        }
//    }
//
//    public static boolean shouldFullScreen() {
//        String str = DeviceInfo.PHONE_MODEL;
//        if (str != null && str.toLowerCase(Locale.US).contains("xiaomi")) {
//            return true;
//        }
//        return false;
//    }
//
//    public static void setStressedAccentColor(TextView textView, String str) {
//        Element element;
//        String trim = str.trim();
//        if (TextUtils.isEmpty(trim)) {
//            textView.setText("");
//            return;
//        }
//        List accentPos = ColorAccent.getAccentPos(trim);
//        if (accentPos == null || accentPos.size() <= 0) {
//            textView.setText(trim);
//            return;
//        }
//        if (accentPos.size() > 1) {
//            element = (Element) accentPos.get(1);
//        } else {
//            element = (Element) accentPos.get(0);
//        }
//        SpannableString spannableString = new SpannableString(trim);
//        if (element != null && element.start < element.end) {
////            spannableString.setSpan(new RedSpan(), element.start, element.end, 33);
//        }
//        textView.setText(spannableString);
//    }
//
//    public static boolean setStressedWordColor(TextView textView, String str, String str2) {
//        if (TextUtils.isEmpty(str)) {
//            textView.setText("");
//            return false;
//        } else if (!StringUtil.isAllLetters(str)) {
//            textView.setText(str);
//            return false;
//        } else if (TextUtils.isEmpty(str2)) {
//            textView.setText(str);
//            return false;
//        } else {
//            Element wordPos = ColorAccent.getWordPos(str, str2.trim());
//            if (wordPos == null || wordPos.start >= wordPos.end) {
//                textView.setText(str);
//                return false;
//            }
//            SpannableString spannableString = new SpannableString(str);
////            spannableString.setSpan(new RedSpan(), wordPos.start, wordPos.end, 33);
//            textView.setText(spannableString);
//            return true;
//        }
//    }
//
//    public static void setSpritzText(TextView textView, String str) {
//        int i;
//        if (TextUtils.isEmpty(str)) {
//            textView.setText("");
//        } else if (!StringUtil.isAllLetters(str)) {
//            textView.setText(str);
//        } else {
//            switch (str.length()) {
//                case 1:
//                case 2:
//                    i = 0;
//                    break;
//                case 3:
//                case 4:
//                case 5:
//                    i = 1;
//                    break;
//                case 6:
//                case 7:
//                    i = 2;
//                    break;
//                default:
//                    i = 3;
//                    break;
//            }
//            SpannableString spannableString = new SpannableString(str);
//            spannableString.setSpan(new MetricAffectingSpan() {
//                public final void updateMeasureState(TextPaint textPaint) {
//                }
//
//                public final void updateDrawState(TextPaint textPaint) {
//                    textPaint.setColor(-65536);
//                }
//            }, i, i + 1, 33);
//            textView.setText(spannableString);
//        }
//    }
//}
