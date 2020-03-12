//package com.baicizhan.client.p029fm.data;
//
//import android.text.TextUtils;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.p029fm.util.FmUtil;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.data.FmMidList */
//public class FmMidList implements ITargetList<String> {
//    private List<String> mDatas;
//    private String mHome = PathUtil.getBaicizhanAppRoot();
//
//    public FmMidList(List<String> list) {
//        this.mDatas = list;
//    }
//
//    public void setDatas(List<String> list) {
//        this.mDatas = list;
//    }
//
//    public int size() {
//        if (this.mDatas == null) {
//            return 0;
//        }
//        return this.mDatas.size();
//    }
//
//    public boolean isEmpty() {
//        if (this.mDatas == null) {
//            return true;
//        }
//        return this.mDatas.isEmpty();
//    }
//
//    public String get(int i) {
//        if (this.mDatas == null) {
//            return null;
//        }
//        return (String) this.mDatas.get(i);
//    }
//
//    public String getLocalPath(int i) {
//        return getLocalPathFromData(get(i));
//    }
//
//    private String getLocalPathFromData(String str) {
//        if (str == null) {
//            return null;
//        }
//        String reformFmPath = FmUtil.reformFmPath(this.mHome + str);
//        if (reformFmPath == null) {
//            return null;
//        }
//        File file = new File(reformFmPath);
//        if (file.exists()) {
//            return file.getAbsolutePath();
//        }
//        return null;
//    }
//
//    public String getSavedPath(int i, boolean z) {
//        return FmUtil.reformFmPath(this.mHome + getPath(i, z));
//    }
//
//    public String getPath(int i, boolean z) {
//        return get(i);
//    }
//
//    public void extractOfflines() {
//        if (this.mDatas != null) {
//            ArrayList arrayList = new ArrayList();
//            for (String str : this.mDatas) {
//                if (!TextUtils.isEmpty(getLocalPathFromData(str))) {
//                    arrayList.add(str);
//                }
//            }
//            this.mDatas = arrayList;
//        }
//    }
//
//    public void clear() {
//        if (this.mDatas != null) {
//            this.mDatas.clear();
//        }
//    }
//}
