//package com.baicizhan.client.wordtesting.activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Process;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.theme.ThemeActivity;
//import com.baicizhan.client.business.view.StrokeButton;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.wordtesting.C0933R;
//import com.baicizhan.client.wordtesting.load.LoadDataAsyncTask;
//import com.baicizhan.client.wordtesting.load.LoadHandler;
//import com.baicizhan.client.wordtesting.user.User;
//import java.io.InputStream;
//
//public class AutoPopActivity extends ThemeActivity implements OnClickListener, LoadHandler {
//    private StrokeButton mDontTest;
//    private View mExit;
//    private boolean mLoading = false;
//    private LoadDataAsyncTask mScriptLoader = new LoadDataAsyncTask();
//    private ProgressBar mScriptLoadingProg;
//    private Button mToTest;
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setContentView(C0933R.layout.wordtesting_auto_pop);
//        initViews();
//    }
//
//    private void initViews() {
//        this.mToTest = (Button) findViewById(C0933R.C0934id.wordtesting_to_test);
//        this.mDontTest = (StrokeButton) findViewById(C0933R.C0934id.wordtesting_exit);
//        this.mExit = findViewById(C0933R.C0934id.wordtesting_close);
//        this.mScriptLoadingProg = (ProgressBar) findViewById(C0933R.C0934id.wordtesting_auto_pop_load_prog);
//        this.mToTest.setOnClickListener(this);
//        this.mDontTest.setOnClickListener(this);
//        this.mExit.setOnClickListener(this);
//    }
//
//    public void onSuccess(User user) {
//        this.mLoading = false;
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(33554432);
//        intent.putExtra("StartMode", "START_FROM_EXIST");
//        intent.putExtra(VocabStatsActivity.EXTRA_USER, user);
//        startActivity(intent);
//        finish();
//        this.mScriptLoadingProg.setVisibility(8);
//    }
//
//    public void onFailed() {
//        this.mLoading = false;
//        Toast.makeText(this, getString(C0933R.string.wordtesting_stats_load_failed), 0).show();
//        this.mToTest.setEnabled(true);
//        this.mToTest.setText(C0933R.string.wordtesting_auto_pop_test);
//        this.mScriptLoadingProg.setVisibility(8);
//    }
//
//    public void onProgress(int i) {
//        this.mScriptLoadingProg.setProgress(i);
//    }
//
//    public void onClick(View view) {
//        if (view == this.mExit || view == this.mDontTest) {
//            finish();
//            if (this.mLoading) {
//                System.exit(0);
//            }
//        } else if (view == this.mToTest) {
//            OperationStats.statVocabTest();
//            OperationStats.getInstance().stat(this);
//            this.mToTest.setEnabled(false);
//            this.mToTest.setText(C0933R.string.wordtesting_stats_start_load);
//            this.mScriptLoadingProg.setVisibility(0);
//            try {
//                InputStream openRawResource = getResources().openRawResource(C0933R.raw.sample);
//                InputStream openRawResource2 = getResources().openRawResource(C0933R.raw.ndata);
//                this.mScriptLoader.execute(this, openRawResource, openRawResource2, this);
//                this.mLoading = true;
//            } catch (Exception e) {
//                C0789L.log.warn("execute load error", (Throwable) e);
//                this.mScriptLoadingProg.setVisibility(8);
//            }
//        }
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        if (this.mLoading) {
//            Process.killProcess(Process.myPid());
//        }
//    }
//}
