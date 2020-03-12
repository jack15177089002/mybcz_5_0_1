//package com.baicizhan.learning_strategy.bean;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.baicizhan.learning_strategy.core.JsRuntime;
//import com.baicizhan.learning_strategy.util.JsExecutor;
//import com.baicizhan.learning_strategy.util.NativeObjectProxy;
//import com.baicizhan.main.receiver.LearnOperationReceiver;
//import org.mozilla.javascript.Context;
//import org.mozilla.javascript.NativeObject;
//
//public class ProblemProxy extends NativeObjectProxy {
//    public static ProblemProxy create() {
//        NativeObject createNativeObject = createNativeObject();
//        if (createNativeObject != null) {
//            return new ProblemProxy(createNativeObject);
//        }
//        return null;
//    }
//
//    /* JADX INFO: finally extract failed */
//    private static NativeObject createNativeObject() {
//        try {
//            Object execute = JsExecutor.execute(JsRuntime.getInstance().getContext(), JsRuntime.getInstance().getGlobalScriptable(), "new Problem()");
//            if (execute instanceof NativeObject) {
//                NativeObject cbVar = (NativeObject) execute;
//                Context.m6766c();
//                return cbVar;
//            }
//            Context.m6766c();
//            return null;
//        } catch (Throwable th) {
//            Context.m6766c();
//            throw th;
//        }
//    }
//
//    public ProblemProxy() {
//        this(createNativeObject());
//    }
//
//    @Deprecated
//    public ProblemProxy(NativeObject cbVar) {
//        super(cbVar);
//    }
//
//    public void clear() {
//        setId(0);
//        setWord(null);
//        setDeepLearning(false);
//        setGroupId(0);
//        setLastLearnedTime(0);
//        setLastScore(0);
//        setReviewMoreCount(0);
//        setScore(0);
//        setWrongCount(0);
//        setTodayNewLearned(false);
//    }
//
//    public void setTodayNewLearned(boolean z) {
//        putAttribute("todayNewLearned", Boolean.valueOf(z));
//    }
//
//    public boolean isTodayNewLearned() {
//        return getBooleanAttribute("todayNewLearned", false);
//    }
//
//    public int getId() {
//        return getIntAttribute(Columns.f2234ID, 0);
//    }
//
//    public void setId(int i) {
//        putAttribute(Columns.f2234ID, Integer.valueOf(i));
//    }
//
//    public String getWord() {
//        return getStringAttribute("word", null);
//    }
//
//    public void setWord(String str) {
//        putAttribute("word", str);
//    }
//
//    public int getGroupId() {
//        return getIntAttribute("groupId", 0);
//    }
//
//    public void setGroupId(int i) {
//        putAttribute("groupId", Integer.valueOf(i));
//    }
//
//    public int getScore() {
//        return getIntAttribute("score", 0);
//    }
//
//    public void setScore(int i) {
//        putAttribute("score", Integer.valueOf(i));
//    }
//
//    public int getLastScore() {
//        return getIntAttribute("lastScore", 0);
//    }
//
//    public void setLastScore(int i) {
//        putAttribute("lastScore", Integer.valueOf(i));
//    }
//
//    public int getWrongCount() {
//        return getIntAttribute("wrongCount", 0);
//    }
//
//    public void setWrongCount(int i) {
//        putAttribute("wrongCount", Integer.valueOf(i));
//    }
//
//    public int getReviewMoreCount() {
//        return getIntAttribute("reviewMoreCount", 0);
//    }
//
//    public void setReviewMoreCount(int i) {
//        putAttribute("reviewMoreCount", Integer.valueOf(i));
//    }
//
//    public long getLastLearnedTime() {
//        return getLongAttribute("lastLearnedTime", 0);
//    }
//
//    public void setLastLearnedTime(long j) {
//        putAttribute("lastLearnedTime", Long.valueOf(j));
//    }
//
//    public boolean isDeepLearning() {
//        return getBooleanAttribute("deepLearning", false);
//    }
//
//    public void setDeepLearning(boolean z) {
//        putAttribute("deepLearning", Boolean.valueOf(z));
//    }
//
//    public boolean isKilled() {
//        return invokeBoolean("isKilled", false, new Object[0]);
//    }
//
//    public void kill() {
//        invokeVoid(LearnOperationReceiver.ACTION_KILL, new Object[0]);
//    }
//
//    public void cancelKill() {
//        invokeVoid("cancelKill", new Object[0]);
//    }
//}
