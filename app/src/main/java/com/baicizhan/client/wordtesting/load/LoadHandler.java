package com.baicizhan.client.wordtesting.load;

import com.baicizhan.client.wordtesting.user.User;

public interface LoadHandler {
    void onFailed();

    void onProgress(int i);

    void onSuccess(User user);
}
