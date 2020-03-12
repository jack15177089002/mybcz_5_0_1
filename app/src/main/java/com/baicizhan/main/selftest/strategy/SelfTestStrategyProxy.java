//package com.baicizhan.main.selftest.strategy;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategy.OnSelftTestInitListener;
//import com.baicizhan.main.selftest.strategy.SelfTestStrategy.Result;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class SelfTestStrategyProxy implements OnSelftTestInitListener {
//    public static Result CACHE_INIT_RESULT;
//    private BczDialog mAskDialg;
//    /* access modifiers changed from: private */
//    public OnSelfTestDataListener mOnSelfTestDataListener;
//    /* access modifiers changed from: private */
//    public SelfTestStrategy mStrategy;
//
//    public interface OnSelfTestDataListener {
//        void onContinueHistory(Result result);
//
//        void onExit();
//
//        void onSelfTestInit(Result result);
//
//        void onSelfTestReset(Result result);
//    }
//
//    public SelfTestStrategyProxy(Context context, OnSelfTestDataListener onSelfTestDataListener) {
//        this.mOnSelfTestDataListener = onSelfTestDataListener;
//        this.mStrategy = SelfTestStrategy.born(context.getApplicationContext()).setInitListener(this);
//    }
//
//    public void init() {
//        this.mStrategy.init();
//    }
//
//    public Result save(List<Integer> list) {
//        return this.mStrategy.save(list);
//    }
//
//    public void askResetToday(Context context, final List<Integer> list) {
//        if (!this.mStrategy.hasHistory()) {
//            askResetAll(context, list);
//            return;
//        }
//        C12151 r0 = new OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Result save = SelfTestStrategyProxy.this.save(list != null ? new ArrayList(list) : null);
//                if (SelfTestStrategyProxy.this.mOnSelfTestDataListener != null) {
//                    SelfTestStrategyProxy.this.mOnSelfTestDataListener.onContinueHistory(save);
//                }
//            }
//        };
//        C12162 r1 = new OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                SelfTestStrategyProxy.this.mStrategy.resetToday(list);
//            }
//        };
//        this.mAskDialg = new Builder(context).setMessage((int) R.string.selftest_today_tested).setPositiveButton((int) R.string.selftest_continue_history, (OnClickListener) r0).setNegativeButton((int) R.string.selftest_reset_today, (OnClickListener) r1).setNeutralButton((int) R.string.selftest_exit, (OnClickListener) new OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                SelfTestStrategyProxy.this.save(list != null ? new ArrayList(list) : null);
//                if (SelfTestStrategyProxy.this.mOnSelfTestDataListener != null) {
//                    SelfTestStrategyProxy.this.mOnSelfTestDataListener.onExit();
//                }
//            }
//        }).create();
//        this.mAskDialg.setCancelable(false);
//        this.mAskDialg.setCanceledOnTouchOutside(false);
//        this.mAskDialg.show();
//    }
//
//    public void askResetAll(Context context, final List<Integer> list) {
//        this.mAskDialg = new Builder(context).setMessage((int) R.string.selftest_all_tested).setPositiveButton((int) R.string.selftest_exit, (OnClickListener) new OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                SelfTestStrategyProxy.this.save(list != null ? new ArrayList(list) : null);
//                if (SelfTestStrategyProxy.this.mOnSelfTestDataListener != null) {
//                    SelfTestStrategyProxy.this.mOnSelfTestDataListener.onExit();
//                }
//            }
//        }).setNegativeButton((int) R.string.selftest_reset_all, (OnClickListener) new OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                SelfTestStrategyProxy.this.mStrategy.resetAll(null);
//            }
//        }).create();
//        this.mAskDialg.setCancelable(false);
//        this.mAskDialg.setCanceledOnTouchOutside(false);
//        this.mAskDialg.show();
//    }
//
//    public void onSelfTestInit(Result result) {
//        if (this.mOnSelfTestDataListener != null) {
//            this.mOnSelfTestDataListener.onSelfTestInit(result);
//        }
//    }
//
//    public void onSelfTestReset(Result result) {
//        if (this.mOnSelfTestDataListener != null) {
//            this.mOnSelfTestDataListener.onSelfTestReset(result);
//        }
//    }
//
//    public static List<Integer> getWordIds(List<Integer> list, int i, int i2) {
//        if (list == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList();
//        int size = list.size();
//        int i3 = 0;
//        while (i < size) {
//            arrayList.add(list.get(i));
//            i3++;
//            if (i3 == i2) {
//                return arrayList;
//            }
//            i++;
//        }
//        return arrayList;
//    }
//
//    public static List<Integer> getWordIds(List<Integer> list, int i) {
//        if (list == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList();
//        int i2 = 0;
//        Iterator it = list.iterator();
//        while (true) {
//            int i3 = i2;
//            if (!it.hasNext()) {
//                break;
//            }
//            arrayList.add(Integer.valueOf(((Integer) it.next()).intValue()));
//            i2 = i3 + 1;
//            if (i2 == i) {
//                break;
//            }
//        }
//        return arrayList;
//    }
//}
