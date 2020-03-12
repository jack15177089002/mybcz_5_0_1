package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture<T> implements ErrorListener, Listener<T>, Future<T> {
    private VolleyError mException;
    private Request<?> mRequest;
    private T mResult;
    private boolean mResultReceived = false;

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    private RequestFuture() {
    }

    public void setRequest(Request<?> request) {
        this.mRequest = request;
    }

    public synchronized boolean cancel(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.mRequest != null) {
                if (!isDone()) {
                    this.mRequest.cancel();
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public T get() {
        try {
            return doGet(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public T get(long j, TimeUnit timeUnit) {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized T doGet(Long l) {
        T t = null;
        if (this.mException != null) {
            try {
                throw new ExecutionException(this.mException);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } else if (this.mResultReceived) {
            t = this.mResult;
        } else {
            if (l == null) {
                try {
                    wait(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (l.longValue() > 0) {
                try {
                    wait(l.longValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (this.mException != null) {
                try {
                    throw new ExecutionException(this.mException);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            } else if (!this.mResultReceived) {
                try {
                    throw new TimeoutException();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            } else {
                t = this.mResult;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        if (this.mRequest == null) {
            return false;
        }
        return this.mRequest.isCanceled();
    }

    public synchronized boolean isDone() {
        return this.mResultReceived || this.mException != null || isCancelled();
    }

    public synchronized void onResponse(T t) {
        this.mResultReceived = true;
        this.mResult = t;
        notifyAll();
    }

    public synchronized void onErrorResponse(VolleyError volleyError) {
        this.mException = volleyError;
        notifyAll();
    }
}
