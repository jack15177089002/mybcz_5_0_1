//package com.baicizhan.learning_strategy.core;
//
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.learning_strategy.impl.LearningManagerProxy;
//import com.baicizhan.learning_strategy.util.C0975L;
//import com.baicizhan.learning_strategy.util.JsExecutor;
//import java.io.File;
//import java.io.FileReader;
//import java.io.Reader;
//import java.util.HashSet;
//import java.util.Set;
//import org.mozilla.javascript.Context;
//import org.mozilla.javascript.NativeObject;
//import org.mozilla.javascript.Scriptable;
//
//public class DirLoader implements Loader {
//    private String dir = null;
//
//    public DirLoader(String str) {
//        this.dir = str;
//    }
//
//    /* JADX INFO: finally extract failed */
//    public synchronized LearningManager load() {
//        LearningManager learningManager = null;
//        synchronized (this) {
//            Scriptable globalScriptable = JsRuntime.getInstance().getGlobalScriptable();
//            Context context = JsRuntime.getInstance().getContext();
//            try {
//                HashSet hashSet = new HashSet();
//                listFiles(hashSet, new File(this.dir));
//                if (!loadFiles(context, globalScriptable, hashSet)) {
//                    Context.m6766c();
//                } else {
//                    learningManager = genarateLearningManager(context, globalScriptable);
//                    Context.m6766c();
//                }
//            } catch (Throwable th) {
//                Context.m6766c();
//                throw th;
//            }
//        }
//        return learningManager;
//    }
//
//    private LearningManager genarateLearningManager(Context lVar, Scriptable drVar) {
//        Object execute = JsExecutor.execute(lVar, drVar, "new LearningManager()");
//        if (execute instanceof NativeObject) {
//            return new LearningManagerProxy((NativeObject) execute);
//        }
//        return null;
//    }
//
//    private void listFiles(Set<File> set, File file) {
//        if (file.exists()) {
//            if (file.isDirectory()) {
//                String[] list = file.list();
//                if (list != null) {
//                    for (String file2 : list) {
//                        listFiles(set, new File(file, file2));
//                    }
//                }
//            } else if (file.isFile()) {
//                set.add(file);
//            }
//        }
//    }
//
//    private boolean loadFiles(Context lVar, Scriptable drVar, Set<File> set) {
//        FileReader fileReader;
//        FileReader fileReader2;
//        HashSet hashSet = new HashSet();
//        for (int size = set.size() + 1; size > 0 && hashSet.size() != set.size(); size--) {
//            for (File file : set) {
//                if (!hashSet.contains(file)) {
//                    try {
//                        fileReader = new FileReader(file);
//                        try {
//                            lVar.mo19133a(drVar, (Reader) fileReader);
//                            hashSet.add(file);
//                            C0975L.log.info(String.format("load success [%s]", new Object[]{file}));
//                            try {
//                                fileReader.close();
//                            } catch (Exception e) {
//                            }
//                        } catch (Throwable th) {
//                            th = th;
//                            try {
//                                fileReader.close();
//                            } catch (Exception e2) {
//                            }
//                            throw th;
//                        }
//                    } catch (Throwable th2) {
//                        th = th2;
//                        fileReader = null;
//                        fileReader.close();
//                        throw th;
//                    }
//                }
//            }
//        }
//        set.removeAll(hashSet);
//        for (File file2 : set) {
//            C0975L.log.error(String.format("file load failed[%s]", new Object[]{file2}));
//        }
//        return set.isEmpty();
//    }
//}
