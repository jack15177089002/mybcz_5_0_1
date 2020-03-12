//package com.baicizhan.main.utils;
//
//import android.app.Dialog;
//import android.util.SparseArray;
//
//public class BczDialogRecycler {
//    SparseArray<Dialog> mDialogs = new SparseArray<>();
//
//    public void replace(int i, Dialog dialog) {
//        Dialog dialog2 = (Dialog) this.mDialogs.get(i);
//        if (dialog2 != null) {
//            dialog2.dismiss();
//        }
//        this.mDialogs.put(i, dialog);
//    }
//
//    public Dialog get(int i) {
//        return (Dialog) this.mDialogs.get(i);
//    }
//
//    public void destroy() {
//        int i = 0;
//        while (true) {
//            int i2 = i;
//            if (i2 < this.mDialogs.size()) {
//                ((Dialog) this.mDialogs.valueAt(i2)).dismiss();
//                i = i2 + 1;
//            } else {
//                return;
//            }
//        }
//    }
//}
