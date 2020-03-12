package com.baicizhan.client.friend.utils;

public class FriendEvents {

    public class FeedUpdateEvent {
        private  final FeedUpdateEvent sInstance = new FeedUpdateEvent();

        public  FeedUpdateEvent newInstance() {
            return sInstance;
        }
    }

    public class FoldTitleBarEvent {
        public boolean isFold;

        public FoldTitleBarEvent(boolean z) {
            this.isFold = z;
        }
    }

    public class FriendWeekUpdateEvent {
        private  final FriendWeekUpdateEvent sInstance = new FriendWeekUpdateEvent();

        public  FriendWeekUpdateEvent newInstance() {
            return sInstance;
        }
    }

    public class FriendsUpdateEvent {
        private  final FriendsUpdateEvent sInstance = new FriendsUpdateEvent();

        public  FriendsUpdateEvent newInstance() {
            return sInstance;
        }
    }

    public class NotificationUpdateEvent {
        private  final NotificationUpdateEvent sInstance = new NotificationUpdateEvent();

        public  NotificationUpdateEvent newInstance() {
            return sInstance;
        }
    }
}
