package com.baicizhan.client.wordtesting.user;

import com.baicizhan.client.framework.p031db.BaseDao;

public class UserDao extends BaseDao {
    public UserDao(String str) {
        super(str);
    }

    public User getCurrentUser() {
        return (User) queryOne("select USER as name, ZSESSION as token from ZLOGINUSER where ZSAVESTATUS = 1", User.class, new Object[0]);
    }
}
