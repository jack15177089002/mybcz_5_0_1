package com.baicizhan.client.p029fm.eventbus;

/* renamed from: com.baicizhan.client.fm.eventbus.FmEvents */
public class FmEvents {

    /* renamed from: com.baicizhan.client.fm.eventbus.FmEvents$ClickEvent */
    public static final class ClickEvent {
        public static final int TYPE_CONTENT = 0;
        public static final int TYPE_CTRL = 1;
        private int clickType = -1;

        public final int getClickType() {
            return this.clickType;
        }

        public final void setClickType(int i) {
            this.clickType = i;
        }
    }

    /* renamed from: com.baicizhan.client.fm.eventbus.FmEvents$ListenMoreEvent */
    public final class ListenMoreEvent {
    }

    /* renamed from: com.baicizhan.client.fm.eventbus.FmEvents$PopupEvent */
    public static final class PopupEvent {
        public static final int STATE_DISMISS = 1;
        public static final int STATE_SHOW = 0;
        private int state = -1;

        public final int getState() {
            return this.state;
        }

        public final void setState(int i) {
            this.state = i;
        }
    }
}
