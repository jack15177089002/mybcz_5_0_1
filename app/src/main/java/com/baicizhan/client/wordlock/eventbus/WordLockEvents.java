package com.baicizhan.client.wordlock.eventbus;

import android.graphics.Point;

public class WordLockEvents {

    public final class DispCnmeanEvent {
        private boolean display = false;

        public final boolean isDisplay() {
            return this.display;
        }

        public final void setDisplay(boolean z) {
            this.display = z;
        }
    }

    public final class DispMoreInfoEvent {
        private long delayed;

        public final long getDelayed() {
            return this.delayed;
        }

        public final void setDelayed(long j) {
            this.delayed = j;
        }
    }

    public static final class DropBackEvent {
        public static final int FROM_DROP_LAYER = 0;
        public static final int FROM_KILL_SPOT = 2;
        public static final int FROM_MORE_INFO_SPOT = 1;
        private long animdur;
        private int from = -1;

        public final long getAnimdur() {
            return this.animdur;
        }

        public final void setAnimdur(long j) {
            this.animdur = j;
        }

        public final int getFrom() {
            return this.from;
        }

        public final void setFrom(int i) {
            this.from = i;
        }
    }

    public final class HelpGuideEvent {
        public static final int EVENT_DISPLAY = 3;
        public static final int EVENT_HIDE = 2;
        public static final int EVENT_NEXT = 1;
        public static final int EVENT_PROCESSED = 0;
        private int eventId;

        public final int getEventId() {
            return this.eventId;
        }

        public final void setEventId(int i) {
            this.eventId = i;
        }
    }

    public final class KillTipEvent {
        private boolean showtip = false;

        public final boolean isShowtip() {
            return this.showtip;
        }

        public final void setShowtip(boolean z) {
            this.showtip = z;
        }
    }

    public final class KillWordEvent {
        private long animdur;
        private Point blastPoint = new Point();

        public final long getAnimdur() {
            return this.animdur;
        }

        public final void setAnimdur(long j) {
            this.animdur = j;
        }

        public final Point getBlastPoint() {
            return this.blastPoint;
        }

        public final void setBlastPoint(int i, int i2) {
            this.blastPoint.x = i;
            this.blastPoint.y = i2;
        }
    }

    public final class RefreshKilledWordCountEvent {
        private int deltaCount = -1;

        public final int getDeltaCount() {
            return this.deltaCount;
        }

        public final void setDeltaCount(int i) {
            this.deltaCount = i;
        }
    }

    public final class RefreshTopNEvent {
    }

    public static final class ToggleControllerEvent {
        private boolean display = false;

        public final boolean isDisplay() {
            return this.display;
        }

        public final void setDisplay(boolean z) {
            this.display = z;
        }
    }
}
