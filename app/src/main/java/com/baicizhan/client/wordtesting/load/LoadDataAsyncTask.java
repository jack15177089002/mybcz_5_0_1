//package com.baicizhan.client.wordtesting.load;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import com.baicizhan.client.business.book.BookSyncTask;
//import com.baicizhan.client.business.usr.UserSyncTask;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.util.Timer;
//import com.baicizhan.client.wordtesting.load.Script.ProgressHandler;
//import com.baicizhan.client.wordtesting.user.User;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//public class LoadDataAsyncTask extends AsyncTask<LoadHandler, Integer, Boolean> {
//    private InputStream data;
//    private List<LoadHandler> handlers = new ArrayList();
//    private ProgressHandler progressHandler = new ProgressHandler() {
//        public void handle(int i) {
//            LoadDataAsyncTask.this.publishProgress(new Integer[]{Integer.valueOf(i)});
//        }
//    };
//    private InputStream script;
//    private User user;
//
//    public AsyncTask<LoadHandler, Integer, Boolean> execute(Context context, InputStream inputStream, InputStream inputStream2, LoadHandler... loadHandlerArr) {
//        this.script = inputStream;
//        this.data = inputStream2;
//        return super.execute(loadHandlerArr);
//    }
//
//    /* access modifiers changed from: protected */
//    public Boolean doInBackground(LoadHandler... loadHandlerArr) {
//        Throwable e;
//        int i;
//        if (this.script == null || this.data == null) {
//            C0789L.log.warn("script or data is null");
//            return Boolean.valueOf(false);
//        }
//        C0789L.log.info("begin loading data...");
//        Timer timer = new Timer();
//        timer.start();
//        this.handlers.clear();
//        int i2 = 0;
//        while (loadHandlerArr != null && i2 < loadHandlerArr.length) {
//            this.handlers.add(loadHandlerArr[i2]);
//            i2++;
//        }
//        try {
//            com.baicizhan.client.business.usr.User user2 = UserSyncTask.getUser();
//            this.user = new User();
//            this.user.setToken(user2.getToken());
//            this.user.setName(user2.getName());
//            C0789L.log.debug("user ==> {} {}", (Object) this.user.getName(), (Object) this.user.getToken());
//            i = BookSyncTask.getBook().getId();
//            try {
//                C0789L.log.debug("current book is [{}]", (Object) Integer.valueOf(i));
//            } catch (Exception e2) {
//                e = e2;
//                C0789L.log.warn("get user from db error", e);
//                Script.getInstance().setProgressHandler(this.progressHandler);
//                boolean load = Script.getInstance().load(i, this.script, this.data);
//                C0789L.log.info("load done res [{}], use time [{}]", (Object) Boolean.valueOf(load), (Object) Long.valueOf(timer.stop()));
//                return Boolean.valueOf(load);
//            }
//        } catch (Exception e3) {
//            Throwable th = e3;
//            i = 0;
//            e = th;
//        }
//        Script.getInstance().setProgressHandler(this.progressHandler);
//        boolean load2 = Script.getInstance().load(i, this.script, this.data);
//        C0789L.log.info("load done res [{}], use time [{}]", (Object) Boolean.valueOf(load2), (Object) Long.valueOf(timer.stop()));
//        return Boolean.valueOf(load2);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onPreExecute() {
//        super.onPreExecute();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onPostExecute(Boolean bool) {
//        super.onPostExecute(bool);
//        for (LoadHandler loadHandler : this.handlers) {
//            if (bool == null || !bool.booleanValue()) {
//                loadHandler.onFailed();
//            } else {
//                loadHandler.onSuccess(this.user);
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onProgressUpdate(Integer... numArr) {
//        super.onProgressUpdate(numArr);
//        if (numArr != null && numArr.length > 0) {
//            for (LoadHandler onProgress : this.handlers) {
//                onProgress.onProgress(numArr[0].intValue());
//            }
//        }
//    }
//
//    public void cancel(LoadHandler loadHandler) {
//        this.handlers.remove(loadHandler);
//        cancel(true);
//    }
//}
