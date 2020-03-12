package com.baicizhan.client.business.book;

import com.baicizhan.client.framework.asynctask.LAsyncTask;
import com.baicizhan.client.framework.util.Common;

public class BookAsyncTask extends LAsyncTask<Void, Void, Book> {
    private final BookLoadHandler mHandler;

    BookAsyncTask(BookLoadHandler bookLoadHandler) {
        setKey(genKey(bookLoadHandler.getClass()));
        parallelTask(1);
        this.mHandler = bookLoadHandler;
    }

    /* access modifiers changed from: protected */
    public Book doInBackground(Void... voidArr) {
        return BookSyncTask.getBook();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Book book) {
        if (this.mHandler == null || book == null) {
            this.mHandler.onError(null);
        } else {
            this.mHandler.onSuccess(book);
        }
    }

    private static final String genKey(Class<?> cls) {
        return Common.md5(BookAsyncTask.class.getName() + " : " + cls.getName());
    }

    public static final BookAsyncTask getTask(BookLoadHandler bookLoadHandler) {
        String genKey = genKey(bookLoadHandler.getClass());
        LAsyncTask searchTask = searchTask(genKey);
        if (searchTask != null) {
            searchTask.cancel();
            removeAllTask(0, genKey);
        }
        return new BookAsyncTask(bookLoadHandler);
    }
}
