//package com.baicizhan.main.fragment;
//
//import android.content.Context;
//import android.util.SparseArray;
//import android.view.ViewGroup;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.main.plusreview.fragment.ListenFragment;
//import com.baicizhan.main.plusreview.fragment.ReadFragment;
//import com.baicizhan.main.plusreview.fragment.WriteFragment;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PatternFactory {
//    private static final SparseArray<Class<?>> EXAMPLE_PATTERN_MAP;
//    private static final SparseArray<List<PatternBaseFragment>> FRAGMENT_INSTANCE_MAP = new SparseArray<>();
//
//    static {
//        SparseArray<Class<?>> sparseArray = new SparseArray<>();
//        EXAMPLE_PATTERN_MAP = sparseArray;
//        sparseArray.put(1, PatternSenToPicFragment.class);
//        EXAMPLE_PATTERN_MAP.put(2, PatternWordToPicFragment.class);
//        EXAMPLE_PATTERN_MAP.put(3, PatternPicToChinFragment.class);
//        EXAMPLE_PATTERN_MAP.put(4, ListenFragment.class);
//        EXAMPLE_PATTERN_MAP.put(5, ReadFragment.class);
//        EXAMPLE_PATTERN_MAP.put(6, WriteFragment.class);
//    }
//
//    public static PatternBaseFragment obtain(Context context, int i) {
//        PatternBaseFragment writeFragment;
//        List slot = getSlot(i);
//        if (slot.size() > 0) {
//            writeFragment = (PatternBaseFragment) slot.remove(slot.size() - 1);
//            if (writeFragment.getParent() != null) {
//                ((ViewGroup) writeFragment.getParent()).removeView(writeFragment);
//            }
//        } else {
//            switch (i) {
//                case 1:
//                    writeFragment = new PatternSenToPicFragment(context);
//                    break;
//                case 2:
//                    writeFragment = new PatternWordToPicFragment(context);
//                    break;
//                case 3:
//                    writeFragment = new PatternPicToChinFragment(context);
//                    break;
//                case 4:
//                    writeFragment = new ListenFragment(context);
//                    break;
//                case 5:
//                    writeFragment = new ReadFragment(context);
//                    break;
//                case 6:
//                    writeFragment = new WriteFragment(context);
//                    break;
//                default:
//                    throw new RuntimeException("invalid pattern type " + i);
//            }
//            writeFragment.setPatternType(i);
//        }
//        return writeFragment;
//    }
//
//    private static List<PatternBaseFragment> getSlot(int i) {
//        List<PatternBaseFragment> list = (List) FRAGMENT_INSTANCE_MAP.get(i);
//        if (list != null) {
//            return list;
//        }
//        ArrayList arrayList = new ArrayList(2);
//        FRAGMENT_INSTANCE_MAP.put(i, arrayList);
//        return arrayList;
//    }
//
//    public static void release(PatternBaseFragment patternBaseFragment) {
//        getSlot(patternBaseFragment.getPatternType()).add(patternBaseFragment);
//    }
//
//    public static void reserve(Context context, int i, int i2) {
//        for (int i3 = 0; i3 < i2; i3++) {
//            release(obtain(context, i));
//        }
//    }
//
//    public static void clear() {
//        LogWrapper.m2793d("leijie", "PatternFactory clear instances");
//        FRAGMENT_INSTANCE_MAP.clear();
//    }
//}
