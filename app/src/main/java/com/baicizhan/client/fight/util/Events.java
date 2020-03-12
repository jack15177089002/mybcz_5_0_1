package com.baicizhan.client.fight.util;

import com.baicizhan.client.fight.jsonbean.UserInfo;

public class Events {

    public class OnGetAccount {
    }

    public class OnGetTotalScore {
    }

    public static class OnSelectRival {
        public UserInfo rival;
        public Type type;

        public enum Type {
            TYPE_CHALLENGE,
            TYPE_ACCEPT
        }

        public OnSelectRival(Type type2, UserInfo userInfo) {
            this.type = type2;
            this.rival = userInfo;
        }

        public String toString() {
            return "OnSelectRival [type=" + this.type + ", rival=" + this.rival + "]";
        }
    }
}
