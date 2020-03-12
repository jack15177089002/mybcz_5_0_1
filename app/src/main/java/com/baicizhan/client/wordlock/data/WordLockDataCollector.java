package com.baicizhan.client.wordlock.data;

public class WordLockDataCollector {
    private int mKilledWordCount;

    static class WordLockDataCollectorHolder {
        /* access modifiers changed from: private */
        public  final WordLockDataCollector INSTANCE = new WordLockDataCollector();

        private WordLockDataCollectorHolder() {
        }
    }

    private WordLockDataCollector() {
        this.mKilledWordCount = 0;
    }

    public static WordLockDataCollector getInstance() {
        WordLockDataCollectorHolder wordLockDataCollectorHolder = new WordLockDataCollectorHolder();
        return wordLockDataCollectorHolder.INSTANCE;
    }

    public int getKilledWordCount() {
        return this.mKilledWordCount;
    }

    public void setKilledWordCount(int i) {
        this.mKilledWordCount = i;
    }

    public void addKilledWordCount(int i) {
        this.mKilledWordCount += i;
    }
}
