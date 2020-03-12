package com.baicizhan.client.business.usr;

import com.baicizhan.client.framework.asynctask.LAsyncTask;
import com.baicizhan.client.framework.util.Common;

public class UserAsyncTask extends LAsyncTask<Void, Void, User> {
    private final UserLoadHandler mHandler;

    UserAsyncTask(UserLoadHandler userLoadHandler) {
        setKey(genKey(userLoadHandler.getClass()));
        parallelTask(1);
        this.mHandler = userLoadHandler;
    }

    /* access modifiers changed from: protected */
    public User doInBackground(Void... voidArr) {
//        return UserSyncTask.getUser();
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(User user) {
        if (this.mHandler == null || user == null) {
            this.mHandler.onError(null);
        } else {
            this.mHandler.onSuccess(user);
        }
    }

    private static final String genKey(Class<?> cls) {
        return Common.md5(UserAsyncTask.class.getName() + " : " + cls.getName());
    }

    public static final UserAsyncTask getTask(UserLoadHandler userLoadHandler) {
        String genKey = genKey(userLoadHandler.getClass());
        LAsyncTask searchTask = searchTask(genKey);
        if (searchTask != null) {
            searchTask.cancel();
            removeAllTask(0, genKey);
        }
        return new UserAsyncTask(userLoadHandler);
    }
}
