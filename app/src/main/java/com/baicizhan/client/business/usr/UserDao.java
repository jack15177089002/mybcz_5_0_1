package com.baicizhan.client.business.usr;

import com.baicizhan.client.framework.p031db.BaseDao;

public class UserDao extends BaseDao {
    public UserDao(String str) {
        super(str);
    }

    public User getUser() {
        return (User) queryOne("select USER as name, ZUSERNICKNAME as nickname, ZSESSION as token from ZLOGINUSER where ZSAVESTATUS = 1", User.class, new Object[0]);
    }
}
