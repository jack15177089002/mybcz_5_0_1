//package com.baicizhan.main.wordlist.eventbus;
//
//import com.baicizhan.main.wordlist.view.WordListDataManager.OrderedWord;
//
//public class WordListEvents {
//
//    public final class WordListEditEvent {
//        public static final int EVENT_CANCEL_KILL_WORD = 1;
//        public static final int EVENT_KILL_WORD = 0;
//        private int eventCode = -1;
//        private OrderedWord word;
//
//        public final int getEventCode() {
//            return this.eventCode;
//        }
//
//        public final void setEventCode(int i) {
//            this.eventCode = i;
//        }
//
//        public final OrderedWord getWord() {
//            return this.word;
//        }
//
//        public final void setWord(OrderedWord orderedWord) {
//            this.word = orderedWord;
//        }
//    }
//
//    public final class WordListHeaderEvent {
//        private int curNav;
//        private boolean editMode = false;
//        private int wordCount;
//
//        public final boolean isEditMode() {
//            return this.editMode;
//        }
//
//        public final void setEditMode(boolean z) {
//            this.editMode = z;
//        }
//
//        public final int getWordCount() {
//            return this.wordCount;
//        }
//
//        public final void setWordCount(int i) {
//            this.wordCount = i;
//        }
//
//        public final int getCurNav() {
//            return this.curNav;
//        }
//
//        public final void setCurNav(int i) {
//            this.curNav = i;
//        }
//    }
//
//    public final class WordListNavChangeEvent {
//        private int position;
//
//        public final int getPosition() {
//            return this.position;
//        }
//
//        public final void setPosition(int i) {
//            this.position = i;
//        }
//    }
//}
