//package com.baicizhan.main.utils;
//
//import android.content.Context;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.RoadmapRecord;
//import com.baicizhan.client.business.util.FileUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class RoadmapUtils {
//    public static final String ROADMAP_DIR = "roadmap/";
//    static final Pattern ROADMAP_PATTERN = Pattern.compile("\\{\"(.*?)\":(.*?),\"(.*?)\":(.*?)\\}");
//    private static final String TAG = RoadmapUtils.class.getSimpleName();
//
//    private static String getRoadmapName(int i) {
//        return String.format("road_map_%d", new Object[]{Integer.valueOf(i)});
//    }
//
//    private static List<RoadmapRecord> loadRoadmapByJsonFormat(String str) {
//        ArrayList arrayList = new ArrayList();
//        Matcher matcher = ROADMAP_PATTERN.matcher(str);
//        while (matcher.find()) {
//            RoadmapRecord roadmapRecord = new RoadmapRecord();
//            for (int i = 1; i <= 4; i += 2) {
//                String group = matcher.group(i);
//                String group2 = matcher.group(i + 1);
//                if (group.charAt(0) == 'w') {
//                    roadmapRecord.f2231id = Integer.valueOf(group2).intValue();
//                } else if (group.charAt(0) == 'o') {
//                    String[] split = TextUtils.split(group2.substring(1, group2.length() - 1), ",");
//                    int[] iArr = new int[split.length];
//                    for (int i2 = 0; i2 < split.length; i2++) {
//                        iArr[i2] = Integer.valueOf(split[i2]).intValue();
//                    }
//                    roadmapRecord.options = iArr;
//                }
//            }
//            arrayList.add(roadmapRecord);
//        }
//        return arrayList;
//    }
//
//    private static List<RoadmapRecord> loadRoadmapBySimpleFormat(String str) {
//        ArrayList arrayList = new ArrayList();
//        Scanner scanner = new Scanner(str);
//        while (scanner.hasNextLine()) {
//            String trim = scanner.nextLine().trim();
//            RoadmapRecord roadmapRecord = new RoadmapRecord();
//            try {
//                String[] split = TextUtils.split(trim, " ");
//                roadmapRecord.f2231id = Integer.parseInt(split[0]);
//                roadmapRecord.options = new int[(split.length - 1)];
//                for (int i = 1; i < split.length; i++) {
//                    roadmapRecord.options[i - 1] = Integer.parseInt(split[i]);
//                }
//                arrayList.add(roadmapRecord);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return arrayList;
//    }
//
//    public static List<RoadmapRecord> loadRoadmap(Context context, int i) {
//        List<RoadmapRecord> emptyList;
//        InputStream inputStream = null;
//        String roadmapName = getRoadmapName(i);
//        try {
//            File baicizhanFile = PathUtil.getBaicizhanFile(new File(ROADMAP_DIR, roadmapName + PathUtil.BAICIZHAN_RESOURCE_EXTENSION).getPath());
//            if (baicizhanFile == null || !baicizhanFile.exists()) {
//                inputStream = context.getAssets().open(new File(ROADMAP_DIR, roadmapName + ".json").getPath());
//            } else {
//                inputStream = new FileInputStream(baicizhanFile);
//            }
//            String readAll = FileUtils.readAll(inputStream);
//            if (TextUtils.isEmpty(readAll)) {
//                emptyList = Collections.emptyList();
//            } else if (readAll.contains("[")) {
//                emptyList = loadRoadmapByJsonFormat(readAll);
//                FileUtils.closeQuitely(inputStream);
//            } else {
//                emptyList = loadRoadmapBySimpleFormat(readAll);
//                FileUtils.closeQuitely(inputStream);
//            }
//        } catch (Exception e) {
//            Log.e(TAG, Log.getStackTraceString(e));
//            emptyList = Collections.emptyList();
//        } finally {
//            FileUtils.closeQuitely(inputStream);
//        }
//        return emptyList;
//    }
//
//    public static boolean saveRoadmap(int i, List<RoadmapRecord> list) {
//        try {
//            Gson kVar = new Gson();
//            File baicizhanFile = PathUtil.getBaicizhanFile(new File(ROADMAP_DIR, getRoadmapName(i) + PathUtil.BAICIZHAN_RESOURCE_EXTENSION).getPath());
//            if (!baicizhanFile.getParentFile().exists()) {
//                baicizhanFile.getParentFile().mkdirs();
//            }
//            String a = kVar.mo3213a((Object) list, new TypeToken<List<RoadmapRecord>>() {
//            }.getType());
//            LogWrapper.m2793d(TAG, "save roadmap " + baicizhanFile.getAbsolutePath() + " length " + a.length());
//            FileUtils.stringToFile(baicizhanFile.getAbsolutePath(), a);
//            return true;
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            return false;
//        }
//    }
//}
