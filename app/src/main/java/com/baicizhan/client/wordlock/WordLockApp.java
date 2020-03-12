//package com.baicizhan.client.wordlock;
//
//import com.baicizhan.client.framework.BaseApp;
//import com.baicizhan.client.framework.handler.AbstractAppHandler;
//import com.baicizhan.client.wordlock.activity.WordLockClient;
//import java.lang.ref.WeakReference;
//
//public class WordLockApp extends BaseApp {
//    private static boolean sKillOnDestroy = false;
//    private WeakReference<WordLockClient> mClient = new WeakReference<>(null);
//
//    public AbstractAppHandler[] getRawHandlers() {
//        return new AbstractAppHandler[]{new WordLockAppHandler()};
//    }
//
//    public WordLockClient getClient() {
//        return (WordLockClient) this.mClient.get();
//    }
//
//    public void setClient(WordLockClient wordLockClient) {
//        this.mClient = new WeakReference<>(wordLockClient);
//    }
//
//    public static void setKillOnDestroy(boolean z) {
//        sKillOnDestroy = z;
//    }
//
//    public static boolean killOnDestroy() {
//        return sKillOnDestroy;
//    }
//}
