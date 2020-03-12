//package com.baicizhan.client.wordtesting.activity;
//
//import android.os.Process;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.android.volley.Response.Listener;
//import com.android.volley.toolbox.StringRequest;
//import com.baicizhan.client.framework.conf.Configure;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.baicizhan.client.wordtesting.C0933R;
//import com.baicizhan.client.wordtesting.bean.Result;
//import com.baicizhan.client.wordtesting.bean.Testing;
//import com.baicizhan.client.wordtesting.bean.Word;
//import com.baicizhan.client.wordtesting.load.Script;
//import com.baicizhan.client.wordtesting.user.User;
//import java.util.List;
//import java.util.Locale;
//
//public class ActivityHelper {
//    private MainActivity activity;
//    boolean mScoreUpdated = false;
//    private int mSteps = 0;
//
//    private boolean check() {
//        return this.activity != null;
//    }
//
//    /* access modifiers changed from: protected */
//    /* renamed from: go */
//    public synchronized void mo6326go(boolean z) {
//        int i = 1;
//        synchronized (this) {
//            if (check()) {
//                this.activity.cdv.stop();
//                this.activity.enableOptButtons(false);
//                Result submit = submit(z);
//                if (submit == null) {
//                    processError("go-submit", "提交结果失败");
//                } else if (!submit.isFinished()) {
//                    if (next(submit)) {
//                        this.activity.cdv.start();
//                        while (true) {
//                            this.activity.getClass();
//                            if (i >= 6) {
//                                break;
//                            }
//                            this.activity.btnOptions[i].setBackgroundResource(C0933R.drawable.wordtesting_opt_normal_button);
//                            i++;
//                        }
//                    } else {
//                        processError("go-next", "获取下一题失败");
//                    }
//                } else {
//                    this.mScoreUpdated = true;
//                }
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public boolean next(Result result) {
//        String str;
//        if (!check()) {
//            return false;
//        }
//        Testing next = Script.getInstance().getNext();
//        if (next == null || next.getCorrect() == null) {
//            this.activity.showText("500 client internal error");
//            C0789L.log.warn("get next error");
//            return false;
//        }
//        this.activity.showText(next.getCorrect().getW());
//        if (result != null) {
//            int sampelCount = result.getSampelCount() + 1;
//            if (sampelCount >= 3) {
//                str = String.format(Locale.CHINA, "当前第 %d 个单词. 少侠的词汇量大概在 %d - %d 个左右", new Object[]{Integer.valueOf(sampelCount), Integer.valueOf(result.getMinSize()), Integer.valueOf(result.getMaxSize())});
//            } else {
//                str = String.format(Locale.CHINA, "当前第 %d 个单词", new Object[]{Integer.valueOf(sampelCount)});
//            }
//            this.mSteps = sampelCount;
//        } else {
//            str = "当前第 1 个单词";
//            this.mSteps = 1;
//        }
//        this.activity.showInfo(str);
//        TextView textView = this.activity.btnOptions[0];
//        textView.setText("不认识");
//        textView.setOnClickListener(this.activity.unknownListener);
//        textView.setOnTouchListener(this.activity.unknownListener);
//        List options = next.getOptions();
//        C0789L.log.debug("opt count : " + options.size());
//        int i = 1;
//        while (true) {
//            this.activity.getClass();
//            if (i < 6) {
//                Word word = (Word) options.get(i - 1);
//                TextView textView2 = this.activity.btnOptions[i];
//                String replaceAll = word.getM().replaceAll("[\r\n]+", " ");
//                if (replaceAll == null) {
//                    replaceAll = "";
//                }
//                if (replaceAll.length() > 30) {
//                    replaceAll = replaceAll.substring(0, 30) + "...";
//                    C0789L.log.info("word testing word too long, original [{}], replaced [{}]", (Object) word.getM(), (Object) replaceAll);
//                }
//                textView2.setText(replaceAll);
//                if (word.getR() == next.getCorrect().getR()) {
//                    textView2.setOnTouchListener(this.activity.correctListener);
//                    textView2.setOnClickListener(this.activity.correctListener);
//                } else {
//                    textView2.setOnTouchListener(this.activity.wrongListener);
//                    textView2.setOnClickListener(this.activity.wrongListener);
//                }
//                textView2.setBackgroundResource(C0933R.drawable.wordtesting_opt_normal_button);
//                i++;
//            } else {
//                this.activity.enableOptButtons(true);
//                return true;
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public Result submit(boolean z) {
//        if (!check()) {
//            return null;
//        }
//        Result submit = Script.getInstance().submit(z);
//        if (submit == null) {
//            this.activity.showText("500 client internal error");
//            C0789L.log.warn("submit get null res");
//            return null;
//        } else if (!submit.isFinished()) {
//            return submit;
//        } else {
//            complete(submit);
//            return submit;
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void exit(boolean z) {
//        if (check()) {
//            Script.getInstance().destroy();
//            if (!this.activity.isFinishing()) {
//                this.activity.finish();
//            }
//            Process.killProcess(Process.myPid());
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public synchronized void reNew() {
//        if (check()) {
//            this.activity.showTestingView();
//            if (!Script.getInstance().init()) {
//                C0789L.log.warn("init error");
//                this.activity.showText("init error");
//            } else if (!next(null)) {
//                processError("go-next", "获取下一题失败");
//            } else {
//                this.activity.cdv.start();
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void complete(Result result) {
//        if (check() && result != null) {
//            this.activity.showScoreView(result.getSize());
//            sendScore(result);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void sendScore(Result result) {
//        try {
//            User user = this.activity.user;
//            if (user == null) {
//                C0789L.log.warn("user is null");
//                return;
//            }
//            String value = Configure.getInstance().getValue("wordtesting_logic", "url.score");
//            String format = String.format(Locale.CHINA, value, new Object[]{System.currentTimeMillis(), Integer.valueOf(result.getSize()), user.getToken(), Integer.valueOf(this.mSteps)});
//            StringRequest stringRequest = new StringRequest(format, new Listener<String>() {
//                public void onResponse(String str) {
//                    C0789L.log.info("score resp:[{}]", (Object) str);
//                }
//            }, null);
//            C0789L.log.info("sending to server [{}] ...", (Object) format);
//            VolleyUtils.send(stringRequest);
//            C0789L.log.info("send to server done");
//        } catch (Throwable th) {
//            C0789L.log.warn(String.format("send score [%s] error", new Object[]{result}), th);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void processError(String str, String str2) {
//        if (check()) {
//            C0789L.log.warn("process error {} {}", (Object) str, (Object) str2);
//            Toast.makeText(this.activity.getApplicationContext(), str2, 0).show();
//            exit(this.activity.killMyself);
//        }
//    }
//
//    public MainActivity getActivity() {
//        return this.activity;
//    }
//
//    public void setActivity(MainActivity mainActivity) {
//        this.activity = mainActivity;
//    }
//}
