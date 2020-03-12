//package com.baicizhan.client.wordtesting.view;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Handler;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.book.Book;
//import com.baicizhan.client.business.book.BookMap;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.wordtesting.C0933R;
//import com.baicizhan.client.wordtesting.activity.MainActivity;
//import com.baicizhan.client.wordtesting.activity.VocabStatsActivity;
//import com.baicizhan.client.wordtesting.bean.VocabStats;
//import com.baicizhan.client.wordtesting.bean.VocabStats.StatsContent;
//import com.baicizhan.client.wordtesting.bean.VocabStats.VocabEndPoint;
//import com.baicizhan.client.wordtesting.load.LoadDataAsyncTask;
//import com.baicizhan.client.wordtesting.load.LoadHandler;
//import com.baicizhan.client.wordtesting.user.User;
//import java.io.InputStream;
//import java.lang.ref.WeakReference;
//import java.math.BigDecimal;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import p012ch.qos.logback.classic.Level;
//
//public class VocabStatsView extends RelativeLayout implements OnClickListener, LoadHandler {
//    private View mBGView;
//    private View mBack;
//    private boolean mFromResult = false;
//    private Handler mHandler = new Handler();
//    private boolean mLoading;
//    /* access modifiers changed from: private */
//    public TextView mLoadingTip;
//    private MoonView mMoon;
//    private TextView[] mScores;
//    private LoadDataAsyncTask mScriptLoader = new LoadDataAsyncTask();
//    private ProgressBar mScriptLoadingProg;
//    private StarView[] mStars;
//    private Button mToTest;
//    private User mUser;
//    private List<Float> mVXPercents = new ArrayList(5);
//    private TextView mVXTitle;
//    private VocabStatsCurveView mVocabStatsCurveView;
//    private TextView[] mVocabs;
//
//    class LoadingInRun implements Runnable {
//        final WeakReference<VocabStatsView> mVocabStatsView;
//
//        LoadingInRun(VocabStatsView vocabStatsView) {
//            this.mVocabStatsView = new WeakReference<>(vocabStatsView);
//        }
//
//        public void run() {
//            final VocabStatsView vocabStatsView = (VocabStatsView) this.mVocabStatsView.get();
//            if (vocabStatsView != null) {
//                vocabStatsView.mLoadingTip.setVisibility(0);
//                Animation loadAnimation = AnimationUtils.loadAnimation(vocabStatsView.getContext(), C0933R.anim.wordtesting_stats_loading_fadein);
//                loadAnimation.setAnimationListener(new AnimationListener() {
//                    public void onAnimationEnd(Animation animation) {
//                        if (vocabStatsView.getState() != 0) {
//                            vocabStatsView.hideTip(0);
//                        }
//                    }
//
//                    public void onAnimationRepeat(Animation animation) {
//                    }
//
//                    public void onAnimationStart(Animation animation) {
//                    }
//                });
//                vocabStatsView.mLoadingTip.startAnimation(loadAnimation);
//            }
//        }
//    }
//
//    class LoadingOutRun implements Runnable {
//        final WeakReference<VocabStatsView> mVocabStatsView;
//
//        LoadingOutRun(VocabStatsView vocabStatsView) {
//            this.mVocabStatsView = new WeakReference<>(vocabStatsView);
//        }
//
//        public void run() {
//            VocabStatsView vocabStatsView = (VocabStatsView) this.mVocabStatsView.get();
//            if (vocabStatsView != null && 8 != vocabStatsView.mLoadingTip.getVisibility()) {
//                vocabStatsView.mLoadingTip.startAnimation(AnimationUtils.loadAnimation(vocabStatsView.getContext(), C0933R.anim.wordtesting_stats_loading_fadeout));
//                vocabStatsView.mLoadingTip.setVisibility(8);
//            }
//        }
//    }
//
//    public VocabStatsView(Context context) {
//        super(context);
//    }
//
//    public VocabStatsView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void setFromResult(boolean z) {
//        this.mFromResult = z;
//    }
//
//    public void setUser(User user) {
//        this.mUser = user;
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mVocabStatsCurveView = (VocabStatsCurveView) findViewById(C0933R.C0934id.wordtesting_stats_curve);
//        this.mBGView = findViewById(C0933R.C0934id.wordtesting_stats_bg);
//        this.mMoon = (MoonView) findViewById(C0933R.C0934id.wordtesting_stats_moon);
//        this.mVXTitle = (TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx_title);
//        this.mVXTitle.setVisibility(4);
//        this.mStars = new StarView[]{(StarView) findViewById(C0933R.C0934id.wordtesting_stats_star_1), (StarView) findViewById(C0933R.C0934id.wordtesting_stats_star_2), (StarView) findViewById(C0933R.C0934id.wordtesting_stats_star_3), (StarView) findViewById(C0933R.C0934id.wordtesting_stats_star_4), (StarView) findViewById(C0933R.C0934id.wordtesting_stats_star_5), (StarView) findViewById(C0933R.C0934id.wordtesting_stats_star_6), (StarView) findViewById(C0933R.C0934id.wordtesting_stats_star_7)};
//        this.mVocabs = new TextView[]{(TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx1_count), (TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx2_count), (TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx3_count), (TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx4_count), (TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx5_count)};
//        this.mScores = new TextView[]{(TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx1_score), (TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx2_score), (TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx3_score), (TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx4_score), (TextView) findViewById(C0933R.C0934id.wordtesting_stats_vx5_score)};
//        this.mBack = findViewById(C0933R.C0934id.wordtesting_stats_back);
//        this.mToTest = (Button) findViewById(C0933R.C0934id.wordtesting_start_test);
//        this.mBack.setOnClickListener(this);
//        this.mToTest.setOnClickListener(this);
//        this.mLoadingTip = (TextView) findViewById(C0933R.C0934id.wordtesting_stats_loading_tip);
//        this.mScriptLoadingProg = (ProgressBar) findViewById(C0933R.C0934id.wordtesting_stats_load_prog);
//    }
//
//    private void spaceEffect(long j) {
//        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C0933R.anim.wordtesting_stats_bg_fadein);
//        loadAnimation.setStartOffset(j);
//        this.mBGView.setVisibility(0);
//        this.mBGView.startAnimation(loadAnimation);
//        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C0933R.anim.wordtesting_stats_bg_fadein);
//        loadAnimation2.setStartOffset(2000 + j);
//        this.mMoon.setVisibility(0);
//        this.mMoon.setEarthColor(-16775672);
//        this.mMoon.startAnimation(loadAnimation2);
//        for (StarView starView : this.mStars) {
//            long random = 3000 + j + ((long) ((int) (1000.0d * Math.random())));
//            starView.setSpaceColor(-16775672);
//            starView.startShine(random);
//        }
//    }
//
//    public void present(VocabStats vocabStats, Book book) {
//        int i;
//        if (vocabStats != null && vocabStats.isValid()) {
//            boolean isIELTS = isIELTS(book);
//            StatsContent data = vocabStats.getData();
//            List<Integer> vocabCurve = data.getVocabCurve();
//            ArrayList arrayList = new ArrayList();
//            int i2 = Level.ALL_INT;
//            Iterator it = vocabCurve.iterator();
//            int i3 = Integer.MAX_VALUE;
//            while (true) {
//                i = i2;
//                if (!it.hasNext()) {
//                    break;
//                }
//                i2 = ((Integer) it.next()).intValue();
//                if (i2 < i3) {
//                    i3 = i2;
//                }
//                if (i2 <= i) {
//                    i2 = i;
//                }
//            }
//            for (Integer intValue : vocabCurve) {
//                this.mVXPercents.add(Float.valueOf(BigDecimal.valueOf((double) ((i != i3 ? (((float) (intValue.intValue() - i3)) * 0.8f) / ((float) (i - i3)) : 0.0f) + 0.2f)).setScale(3, 1).floatValue()));
//            }
//            int i4 = ((i - i3) + 4) / 4;
//            if (i != i3) {
//                for (int i5 = 0; i5 < this.mVocabs.length; i5++) {
//                    this.mVocabs[i5].setText(((i4 * i5) + i3));
//                    arrayList.add(Integer.valueOf((i4 * i5) + i3));
//                }
//            } else {
//                this.mVocabs[0].setText(String.valueOf(i3));
//            }
//            List coordinate = data.getCoordinate();
//            if (coordinate != null && 1 == coordinate.size()) {
//                coordinate.add(coordinate.get(0));
//            }
//            if (coordinate == null || 2 != coordinate.size()) {
//                adaptVXSWithoutScores();
//            } else {
//                int vocabulary = ((VocabEndPoint) coordinate.get(0)).getVocabulary();
//                int vocabulary2 = ((VocabEndPoint) coordinate.get(1)).getVocabulary();
//                float score = ((VocabEndPoint) coordinate.get(0)).getScore();
//                float score2 = ((VocabEndPoint) coordinate.get(1)).getScore();
//                if (vocabulary != vocabulary2) {
//                    int i6 = 0;
//                    while (true) {
//                        int i7 = i6;
//                        if (i7 >= this.mScores.length) {
//                            break;
//                        }
//                        float intValue2 = score + ((((float) (((Integer) arrayList.get(i7)).intValue() - vocabulary)) * (score2 - score)) / ((float) (vocabulary2 - vocabulary)));
//                        String str = ((int) intValue2);
//                        if (isIELTS) {
//                            str = new DecimalFormat("#.00").format((double) intValue2);
//                        }
//                        this.mScores[i7].setText(getContext().getString(C0933R.string.wordtesting_stats_vx_score, new Object[]{str}));
//                        i6 = i7 + 1;
//                    }
//                } else {
//                    String str2 = ((int) score);
//                    if (isIELTS) {
//                        str2 = new DecimalFormat("#.00").format((double) score);
//                    }
//                    this.mScores[0].setText(getContext().getString(C0933R.string.wordtesting_stats_vx_score, new Object[]{str2}));
//                }
//            }
//            this.mVXTitle.setVisibility(0);
//            this.mVXTitle.startAnimation(AnimationUtils.loadAnimation(getContext(), C0933R.anim.wordtesting_stats_vx_fadein));
//            for (int length = this.mScores.length - 1; length >= 0; length--) {
//                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C0933R.anim.wordtesting_stats_vx_fadein);
//                loadAnimation.setStartOffset((long) ((this.mScores.length - length) * 100));
//                this.mScores[length].startAnimation(loadAnimation);
//                this.mVocabs[length].startAnimation(loadAnimation);
//            }
//            this.mVocabStatsCurveView.start(this.mVXPercents, String.valueOf(vocabCurve.get(vocabCurve.size() - 1)));
//        }
//    }
//
//    private void adaptVXSWithoutScores() {
//        int dip2px = Common.dip2px(getContext(), 8.0f);
//        for (int i = 0; i < this.mScores.length; i++) {
//            this.mVocabs[i].setGravity(21);
//            this.mVocabs[i].setPadding(0, 0, dip2px, 0);
//        }
//        this.mVXTitle.setGravity(21);
//        this.mVXTitle.setPadding(0, 0, dip2px, 0);
//    }
//
//    private static boolean isIELTS(Book book) {
//        if (book != null && 5 == BookMap.toId(book.getId())) {
//            return true;
//        }
//        return false;
//    }
//
//    public void onClick(View view) {
//        Context context = getContext();
//        if (view == this.mBack) {
//            if (context != null && (context instanceof VocabStatsActivity)) {
//                ((VocabStatsActivity) context).finish(true);
//            }
//        } else if (view == this.mToTest) {
//            OperationStats.statVocabTest();
//            OperationStats.getInstance().stat(getContext());
//            if (this.mFromResult) {
//                goTest(this.mUser);
//                return;
//            }
//            this.mToTest.setEnabled(false);
//            this.mToTest.setText(C0933R.string.wordtesting_stats_start_load);
//            this.mScriptLoadingProg.setVisibility(0);
//            try {
//                InputStream openRawResource = getResources().openRawResource(C0933R.raw.sample);
//                InputStream openRawResource2 = getResources().openRawResource(C0933R.raw.ndata);
//                this.mScriptLoader.execute(getContext(), openRawResource, openRawResource2, this);
//                this.mLoading = true;
//            } catch (Exception e) {
//                C0789L.log.warn("execute load error", (Throwable) e);
//                this.mScriptLoadingProg.setVisibility(8);
//            }
//        }
//    }
//
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        this.mHandler.removeCallbacksAndMessages(null);
//    }
//
//    public void showTip(int i, long j, boolean z) {
//        if (this.mLoadingTip != null) {
//            this.mLoadingTip.setText(i);
//            doShowTip(j, z);
//        }
//    }
//
//    public void showTip(CharSequence charSequence, long j, boolean z) {
//        if (this.mLoadingTip != null) {
//            this.mLoadingTip.setText(charSequence);
//            doShowTip(j, z);
//        }
//    }
//
//    private void doShowTip(long j, boolean z) {
//        this.mHandler.postDelayed(new LoadingInRun(this), 500 + j);
//        if (z) {
//            this.mHandler.postDelayed(new LoadingOutRun(this), 2500 + j);
//        }
//    }
//
//    public void hideTip(long j) {
//        if (this.mLoadingTip != null && this.mLoadingTip.getVisibility() == 0) {
//            this.mHandler.postDelayed(new LoadingOutRun(this), j);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public int getState() {
//        Context context = getContext();
//        if (context == null || !(context instanceof VocabStatsActivity)) {
//            return 0;
//        }
//        return ((VocabStatsActivity) context).getState();
//    }
//
//    public void onSuccess(User user) {
//        this.mLoading = false;
//        goTest(user);
//        this.mScriptLoadingProg.setVisibility(8);
//    }
//
//    private void goTest(User user) {
//        Context context = getContext();
//        if (context != null && (context instanceof Activity)) {
//            Activity activity = (Activity) context;
//            Intent intent = new Intent(activity, MainActivity.class);
//            intent.setFlags(33554432);
//            intent.putExtra("StartMode", "START_FROM_EXIST");
//            intent.putExtra(VocabStatsActivity.EXTRA_USER, user);
//            activity.startActivity(intent);
//            activity.finish();
//        }
//    }
//
//    public void onFailed() {
//        this.mLoading = false;
//        C0789L.log.warn("load failed");
//        Toast.makeText(getContext(), getContext().getString(C0933R.string.wordtesting_stats_load_failed), 0).show();
//        this.mToTest.setEnabled(true);
//        this.mToTest.setText(C0933R.string.wordtesting_stats_start_test);
//        this.mScriptLoadingProg.setVisibility(8);
//    }
//
//    public void onProgress(int i) {
//        this.mScriptLoadingProg.setProgress(i);
//    }
//
//    public boolean isLoading() {
//        return this.mLoading;
//    }
//
//    public void destroy() {
//        if (!this.mScriptLoader.isCancelled()) {
//            this.mScriptLoader.cancel(true);
//        }
//    }
//
//    public void release() {
//        this.mScriptLoader.cancel(this);
//    }
//}
