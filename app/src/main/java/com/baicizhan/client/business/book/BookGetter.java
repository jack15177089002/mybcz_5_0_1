package com.baicizhan.client.business.book;

public class BookGetter implements BookLoadHandler {
    private onGetBookListener mListener;

    public interface onGetBookListener {
        void onGetBook(Book book);
    }

    public void asyncGet(onGetBookListener ongetbooklistener) {
        this.mListener = ongetbooklistener;
        BookAsyncTask.getTask(this).execute(new Void[0]);
    }

    public void onError(Void voidR) {
        if (this.mListener != null) {
            this.mListener.onGetBook(null);
        }
    }

    public void onProgress(int i) {
    }

    public void onSuccess(Book book) {
        if (this.mListener != null) {
            this.mListener.onGetBook(book);
        }
    }
}
