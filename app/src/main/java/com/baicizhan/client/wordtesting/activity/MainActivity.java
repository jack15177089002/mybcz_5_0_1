//package com.baicizhan.client.wordtesting.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.p004v4.app.FragmentActivity;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.framework.conf.Configure;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.wordtesting.C0933R;
//import com.baicizhan.client.wordtesting.C0933R.C0934id;
//import com.baicizhan.client.wordtesting.doc.Doc;
//import com.baicizhan.client.wordtesting.doc.DocSelector;
//import com.baicizhan.client.wordtesting.load.LoadDataAsyncTask;
//import com.baicizhan.client.wordtesting.load.LoadHandler;
//import com.baicizhan.client.wordtesting.load.Script;
//import com.baicizhan.client.wordtesting.user.User;
//import com.baicizhan.client.wordtesting.util.Constants;
//import com.baicizhan.client.wordtesting.view.CountDownView;
//import com.baicizhan.client.wordtesting.view.CountDownView.Handler;
//import com.umeng.p092a.MobclickAgent;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//public class MainActivity extends FragmentActivity implements LoadHandler {
//    /* access modifiers changed from: private */
//    public static final String LOADING_MSG = Configure.getInstance().getValue("wordtesting_logic", "msg.loading");
//    private static final String LOAD_FAILED_MSG = Configure.getInstance().getValue("wordtesting_logic", "msg.load_failed");
//    protected Button btnBye;
//    protected Button btnExit;
//    protected Button btnGoTesting;
//    protected Button btnOnceMore;
//    protected TextView[] btnOptions = new TextView[6];
//    protected CountDownView cdv;
//    protected ButtonTouchClickListener correctListener = new ButtonTouchClickListener(true);
//    protected View currentView;
//    /* access modifiers changed from: private */
//    public ActivityHelper helper = new ActivityHelper();
//    protected volatile boolean killMyself = false;
//    private View mBack;
//    private View mBao;
//    private DocSelector mDocSelector;
//    /* access modifiers changed from: private */
//    public boolean mGoStats = false;
//    private TextView mGossip;
//    private View mMask;
//    private View mShare;
//    /* access modifiers changed from: private */
//    public Set<String> mWrongWords = new HashSet();
//    private View mYangguo;
//    protected final int optionCount = 6;
//    protected View scoreView;
//    protected StartMode startMode = StartMode.USER_SELECT_TEST;
//    /* access modifiers changed from: private */
//    public LoadDataAsyncTask task = new LoadDataAsyncTask();
//    protected View testingView;
//    protected TextView textInfo;
//    protected TextView textWord;
//    protected Handler timeFinishedHandler = new Handler() {
//        public void onTimeFinished() {
//            MainActivity.this.showExpiredMsg();
//        }
//
//        public void onStart() {
//            MainActivity.this.hideExpiredMsg();
//        }
//    };
//    protected ButtonUnknownListener unknownListener = new ButtonUnknownListener();
//    protected User user;
//    protected View welcomeView;
//    protected ButtonTouchClickListener wrongListener = new ButtonTouchClickListener(false);
//
//    public class ButtonTouchClickListener implements OnClickListener, OnTouchListener {
//        private boolean correct;
//        private int touchButtonRcId;
//
//        public ButtonTouchClickListener(boolean z) {
//            this.correct = z;
//            this.touchButtonRcId = this.correct ? C0933R.drawable.wordtesting_opt_correct_button : C0933R.drawable.wordtesting_opt_wrong_button;
//        }
//
//        public boolean onTouch(View view, MotionEvent motionEvent) {
//            if (motionEvent.getAction() == 0) {
//                view.setBackgroundResource(this.touchButtonRcId);
//                MainActivity.this.detouchListeners();
//            }
//            return false;
//        }
//
//        public void onClick(View view) {
//            if (!this.correct || MainActivity.this.cdv.isExpired()) {
//                MainActivity.this.mWrongWords.add(MainActivity.this.textWord.getText().toString());
//            } else {
//                MainActivity.this.mWrongWords.remove(MainActivity.this.textWord.getText().toString());
//            }
//            MainActivity.this.helper.mo6326go(this.correct && !MainActivity.this.cdv.isExpired());
//        }
//    }
//
//    public class ButtonUnknownListener implements OnClickListener, OnTouchListener {
//        protected ButtonUnknownListener() {
//        }
//
//        public boolean onTouch(View view, MotionEvent motionEvent) {
//            TextView textView = (TextView) view;
//            if (motionEvent.getAction() == 0) {
//                textView.setBackgroundResource(C0933R.drawable.wordtesting_shape_btn_opt_unknown_hover);
//                textView.setTextColor(MainActivity.this.getResources().getColor(C0933R.color.wordtesting_btn_unknown_hover_stroke));
//            } else if (motionEvent.getAction() == 1) {
//                textView.setBackgroundResource(C0933R.drawable.wordtesting_shape_btn_opt_unknown);
//                textView.setTextColor(MainActivity.this.getResources().getColor(C0933R.color.wordtesting_btn_unknown_stroke));
//            }
//            return false;
//        }
//
//        public void onClick(View view) {
//            MainActivity.this.mWrongWords.add(MainActivity.this.textWord.getText().toString());
//            MainActivity.this.helper.mo6326go(false);
//        }
//    }
//
//    public enum StartMode {
//        SYSTEM_AUTO_TEST,
//        USER_SELECT_TEST,
//        START_FROM_EXIST
//    }
//
//    /* access modifiers changed from: protected */
//    public void showExpiredMsg() {
//        this.cdv.setVisibility(8);
//        this.cdv.invalidate();
//        findViewById(C0933R.C0934id.textExpired).setVisibility(0);
//    }
//
//    /* access modifiers changed from: protected */
//    public void hideExpiredMsg() {
//        findViewById(C0933R.C0934id.textExpired).setVisibility(8);
//        this.cdv.setVisibility(0);
//    }
//
//    /* access modifiers changed from: protected */
//    public void enableOptButtons(boolean z) {
//        for (TextView enabled : this.btnOptions) {
//            enabled.setEnabled(z);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void detouchListeners() {
//        for (TextView onTouchListener : this.btnOptions) {
//            onTouchListener.setOnTouchListener(null);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        boolean booleanExtra;
//        super.onCreate(bundle);
//        setTheme(C0933R.style.WordTestingFrame);
//        try {
//            Intent intent = getIntent();
//            String stringExtra = intent == null ? null : intent.getStringExtra("StartMode");
//            if (stringExtra != null) {
//                if (StartMode.SYSTEM_AUTO_TEST.toString().equals(stringExtra)) {
//                    this.startMode = StartMode.SYSTEM_AUTO_TEST;
//                } else if (StartMode.START_FROM_EXIST.toString().equals(stringExtra)) {
//                    this.startMode = StartMode.START_FROM_EXIST;
//                    this.user = (User) intent.getParcelableExtra(VocabStatsActivity.EXTRA_USER);
//                }
//            }
//        } catch (Exception e) {
//        }
//        try {
//            Intent intent2 = getIntent();
//            if (intent2 == null) {
//                booleanExtra = false;
//            } else {
//                booleanExtra = intent2.getBooleanExtra("KillMyself", false);
//            }
//            this.killMyself = booleanExtra;
//        } catch (Exception e2) {
//        }
//        this.helper.setActivity(this);
//        this.mDocSelector = new DocSelector();
//        this.mDocSelector.asyncGetDocs();
//        LayoutInflater from = LayoutInflater.from(this);
//        this.welcomeView = from.inflate(C0933R.layout.wordtesting_welcome, null);
//        this.testingView = from.inflate(C0933R.layout.wordtesting_testing, null);
//        this.scoreView = from.inflate(C0933R.layout.wordtesting_result, null);
//        if (StartMode.START_FROM_EXIST == this.startMode) {
//            this.helper.reNew();
//        } else {
//            showWelcomeView();
//        }
//    }
//
//    public void setContentView(View view) {
//        super.setContentView(view);
//        this.currentView = view;
//    }
//
//    /* access modifiers changed from: protected */
//    public void showWelcomeView() {
//        setContentView(this.welcomeView);
//        this.btnGoTesting = (Button) findViewById(C0933R.C0934id.btnGoTesting);
//        this.btnBye = (Button) findViewById(C0933R.C0934id.btnBye);
//        if (StartMode.SYSTEM_AUTO_TEST.equals(this.startMode)) {
//            findViewById(C0933R.C0934id.ivUserSelect).setVisibility(8);
//            findViewById(C0933R.C0934id.ivSystemAuto).setVisibility(0);
//        } else {
//            findViewById(C0933R.C0934id.ivUserSelect).setVisibility(0);
//            findViewById(C0933R.C0934id.ivSystemAuto).setVisibility(8);
//        }
//        this.btnGoTesting.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                OperationStats.statVocabTest();
//                OperationStats.getInstance().stat(MainActivity.this);
//                if (!Script.getInstance().isLoaded()) {
//                    Toast.makeText(MainActivity.this.getApplicationContext(), MainActivity.LOADING_MSG, 0).show();
//                }
//                MainActivity.this.btnGoTesting.setEnabled(false);
//                MainActivity.this.btnBye.setEnabled(false);
//                try {
//                    InputStream openRawResource = MainActivity.this.getResources().openRawResource(C0933R.raw.sample);
//                    InputStream openRawResource2 = MainActivity.this.getResources().openRawResource(C0933R.raw.ndata);
//                    MainActivity.this.task.execute(MainActivity.this.getApplicationContext(), openRawResource, openRawResource2, MainActivity.this);
//                } catch (Exception e) {
//                    C0789L.log.warn("execute load error", (Throwable) e);
//                }
//            }
//        });
//        this.btnBye.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                MainActivity.this.btnGoTesting.setEnabled(false);
//                MainActivity.this.btnBye.setEnabled(false);
//                MainActivity.this.helper.exit(MainActivity.this.killMyself);
//            }
//        });
//        try {
//            ((ProgressBar) findViewById(C0933R.C0934id.pbLoad)).setProgress(0);
//        } catch (Exception e) {
//            C0789L.log.warn("set progress error", (Throwable) e);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void showTestingView() {
//        setContentView(this.testingView);
//        this.textWord = (TextView) findViewById(C0933R.C0934id.textWord);
//        this.textInfo = (TextView) findViewById(C0933R.C0934id.textInfo);
//        this.cdv = (CountDownView) findViewById(C0933R.C0934id.cdv);
//        this.cdv.clearHandlers();
//        this.cdv.addHandler(this.timeFinishedHandler);
//        Class<C0934id> cls = C0934id.class;
//        int i = 0;
//        while (true) {
//            int i2 = i;
//            if (i2 < 6) {
//                try {
//                    this.btnOptions[i2] = (TextView) findViewById(cls.getField("btnOpt" + (i2 + 1)).getInt(cls));
//                    i = i2 + 1;
//                } catch (Exception e) {
//                    C0789L.log.warn("get button error", (Throwable) e);
//                    return;
//                }
//            } else {
//                return;
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void showScoreView(final int i) {
//        setContentView(this.scoreView);
//        this.btnOnceMore = (Button) findViewById(C0933R.C0934id.wordtesting_again);
//        this.btnOnceMore.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                MainActivity.this.helper.reNew();
//                OperationStats.statVocabAgain();
//            }
//        });
//        this.btnExit = (Button) findViewById(C0933R.C0934id.wordtesting_exit);
//        this.btnExit.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                MainActivity.this.mGoStats = true;
//                Intent intent = new Intent(MainActivity.this, VocabStatsActivity.class);
//                intent.setFlags(33554432);
//                intent.putExtra(VocabStatsActivity.EXTRA_FROM_RESULT, true);
//                intent.putExtra(VocabStatsActivity.EXTRA_USER, MainActivity.this.user);
//                MainActivity.this.startActivity(intent);
//                MainActivity.this.finish();
//            }
//        });
//        final Doc select = this.mDocSelector.select((long) i);
//        this.mGossip = (TextView) findViewById(C0933R.C0934id.wordtesting_chedan_text);
//        this.mGossip.setText(select != null ? select.getText() : "");
//        this.mMask = findViewById(C0933R.C0934id.wordtesting_mask);
//        this.mBack = findViewById(C0933R.C0934id.wordtesting_back);
//        this.mBack.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                MainActivity.this.setResult(-1, null);
//                MainActivity.this.helper.exit(MainActivity.this.killMyself);
//            }
//        });
//        this.mShare = findViewById(C0933R.C0934id.wordtesting_share);
//        this.mShare.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                ShareDialogFragment.newInstance().setScoreNum(i).setGossip(select != null ? select.getText() : null).show(MainActivity.this.getSupportFragmentManager(), "share");
//                OperationStats.statVocabShare();
//            }
//        });
//        this.mBao = findViewById(C0933R.C0934id.wordtesting_bo_head);
//        this.mBao.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                BaoguoGayFragment.newInstance().show(MainActivity.this.getSupportFragmentManager(), "baoguo");
//            }
//        });
//        this.mYangguo = findViewById(C0933R.C0934id.wordtesting_yangguo);
//        this.mYangguo.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                BaoguoGayFragment.newInstance().show(MainActivity.this.getSupportFragmentManager(), "baoguo");
//            }
//        });
//        ((TextView) findViewById(C0933R.C0934id.wordtesting_score_num)).setText(String.valueOf(i));
//    }
//
//    /* access modifiers changed from: protected */
//    public void showText(String str) {
//        this.textWord.setText(str);
//    }
//
//    /* access modifiers changed from: protected */
//    public void showInfo(String str) {
//        this.textInfo.setText(str);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        OperationStats.getInstance().stat(this);
//        if (!this.task.isCancelled()) {
//            this.task.cancel(true);
//        }
//        if (this.cdv != null) {
//            this.cdv.stop();
//        }
//        super.onDestroy();
//        if (!this.mGoStats) {
//            this.helper.exit(this.killMyself);
//        }
//    }
//
//    public void onSuccess(User user2) {
//        C0789L.log.warn("load success, user [{}]", (Object) user2);
//        this.user = user2;
//        this.helper.reNew();
//    }
//
//    public void onFailed() {
//        C0789L.log.warn("load failed");
//        Toast.makeText(getApplicationContext(), LOAD_FAILED_MSG, 0).show();
//        this.helper.exit(this.killMyself);
//    }
//
//    public void onProgress(int i) {
//        C0789L.log.debug("progress ... " + i);
//        if (this.currentView == this.welcomeView) {
//            try {
//                ((ProgressBar) findViewById(C0933R.C0934id.pbLoad)).setProgress(i);
//            } catch (Exception e) {
//                C0789L.log.warn("set progress error", (Throwable) e);
//            }
//        }
//    }
//
//    public void finish() {
//        writebackWords2Review();
//        if (this.helper.mScoreUpdated) {
//            Intent intent = new Intent();
//            intent.putExtra(Constants.RESULT_TEST_UPDATED, true);
//            setResult(-1, intent);
//        }
//        super.finish();
//    }
//
//    private void writebackWords2Review() {
//        if (!this.mWrongWords.isEmpty()) {
//            new ArrayList(this.mWrongWords.size()).addAll(this.mWrongWords);
//        }
//    }
//
//    public void onPause() {
//        if (this.mMask != null) {
//            this.mMask.setVisibility(0);
//        }
//        super.onPause();
//        MobclickAgent.m5132a((Context) this);
//    }
//
//    public void onResume() {
//        if (this.mMask != null) {
//            this.mMask.setVisibility(8);
//        }
//        super.onResume();
//        MobclickAgent.m5136b((Context) this);
//    }
//}
