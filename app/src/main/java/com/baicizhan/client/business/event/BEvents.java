package com.baicizhan.client.business.event;

import com.baicizhan.client.framework.event.AsyncUIEvent;

public class BEvents {

    public final class FeedbackNewEvent {
        private boolean showRedDot;

        public FeedbackNewEvent(boolean z) {
            this.showRedDot = z;
        }

        public final boolean isShowRedDot() {
            return this.showRedDot;
        }
    }

    public final class FriendTabRedDotEvent {
    }

    public final class WordScoreUpdatedEvent extends AsyncUIEvent<Void, Void> {
        public WordScoreUpdatedEvent(int i) {
            super(i);
        }
    }

    public final class WordTestEvent extends AsyncUIEvent<Void, Void> {
        public WordTestEvent(int i) {
            super(i);
        }
    }

    public final class WordTvReadStatusEvent extends AsyncUIEvent<Void, Void> {
        public WordTvReadStatusEvent(int i) {
            super(i);
        }
    }
}
