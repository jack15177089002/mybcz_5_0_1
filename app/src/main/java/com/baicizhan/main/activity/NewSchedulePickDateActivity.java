//package com.baicizhan.main.activity;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentActivity;
//import android.support.p004v4.app.FragmentTransaction;
//import android.text.style.ForegroundColorSpan;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.managers.BookListManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.SimpleSpannableBuilder;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.main.fragment.ScheduleDefaultFragment;
//import com.baicizhan.main.fragment.ScheduleDefaultFragment.OnDefaultScheduleSetListener;
//import com.baicizhan.main.fragment.SchedulePickerFragment;
//import com.baicizhan.main.fragment.SchedulePickerFragment.OnPickListener;
//import com.baicizhan.online.bs_users.BBSelectedBookInfo;
//import com.baicizhan.online.bs_users.BBUserSelectedBookInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.baicizhan.online.structs.BELogicException;
//import com.jiongji.andriod.card.R;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Locale;
//import java.util.concurrent.TimeUnit;
//
//public class NewSchedulePickDateActivity extends FragmentActivity implements OnClickListener, OnDefaultScheduleSetListener {
//    private static final int DEF_MINUTES_PER_DAY = ((int) Math.ceil(16.5d));
//    private static final int DEF_WORD_COUNT_PER_DAY = 25;
//    private static final float ESTIMATE_WORD_COSUME_TIME = 0.66f;
//    public static final String EXTRA_BOOK_ID = "book_id";
//    public static final String EXTRA_BOOK_NAME = "book_name";
//    public static final String EXTRA_CREATE_NEW_TASK = "create_new_task";
//    public static final String EXTRA_WORD_COUNT = "word_count";
//    /* access modifiers changed from: private */
//    public static final String TAG = NewSchedulePickDateActivity.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public int mBookId;
//    private String mBookName;
//    private View mConfirm;
//    private boolean mCreateNewTask = false;
//    /* access modifiers changed from: private */
//    public long mDueTime;
//    private BczDialog mMergeDialog;
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//    private TextView mScheduleDesc;
//    private View mScheduleInitDescs;
//    private SchedulePickerFragment mSchedulePickerFragment;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_new_schedule_pick_date);
//            Intent intent = getIntent();
//            this.mCreateNewTask = intent.getBooleanExtra(EXTRA_CREATE_NEW_TASK, false);
//            this.mBookId = intent.getIntExtra("book_id", 0);
//            this.mBookName = intent.getStringExtra(EXTRA_BOOK_NAME);
//            int intExtra = intent.getIntExtra("word_count", 0);
//            refreshDueTime((intExtra % 25 == 0 ? 0 : 1) + (intExtra / 25));
//            findViewById(R.id.back).setOnClickListener(this);
//            this.mConfirm = findViewById(R.id.confirm);
//            this.mConfirm.setOnClickListener(this);
//            this.mScheduleInitDescs = findViewById(R.id.schedule_init_descs);
//            initDefDescs();
//            this.mScheduleDesc = (TextView) findViewById(R.id.schedule_desc);
//            this.mSchedulePickerFragment = new SchedulePickerFragment();
//            Bundle bundle2 = new Bundle();
//            bundle2.putInt("word_count", intExtra);
//            bundle2.putInt(SchedulePickerFragment.EXTRA_MODE, 1);
//            this.mSchedulePickerFragment.setArguments(bundle2);
//            this.mSchedulePickerFragment.setOnPickListener(new OnPickListener() {
//                public void onPick(int i, int i2, int i3) {
//                    NewSchedulePickDateActivity.this.updateDesc(i, i2, i3);
//                }
//            });
//            C0066v supportFragmentManager = getSupportFragmentManager();
//            if (this.mCreateNewTask) {
//                supportFragmentManager.mo313a().mo179a((int) R.id.schedule_picker_placeholder, (Fragment) ScheduleDefaultFragment.newInstance()).mo183b();
//                this.mScheduleInitDescs.setVisibility(0);
//                this.mScheduleDesc.setVisibility(8);
//                this.mConfirm.setVisibility(8);
//            } else {
//                supportFragmentManager.mo313a().mo179a((int) R.id.schedule_picker_placeholder, (Fragment) this.mSchedulePickerFragment).mo183b();
//                this.mScheduleInitDescs.setVisibility(8);
//                this.mScheduleDesc.setVisibility(0);
//            }
//            this.mProgressDialog = new BczLoadingDialog(this);
//        }
//    }
//
//    private void initDefDescs() {
//        int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(this, R.attr.color_text_blue);
//        TextView textView = (TextView) this.mScheduleInitDescs.findViewById(R.id.schedule_init_main);
//        SimpleSpannableBuilder simpleSpannableBuilder = new SimpleSpannableBuilder();
//        simpleSpannableBuilder.append("少侠，计划每天背").append(Integer.toString(25), new ForegroundColorSpan(themeColorWithAttr)).append("个单词？");
//        textView.setText(simpleSpannableBuilder.build());
//        ((TextView) this.mScheduleInitDescs.findViewById(R.id.schedule_init_sub)).setText(getString(R.string.schedule_init_sub, new Object[]{Integer.valueOf(DEF_MINUTES_PER_DAY)}));
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//    }
//
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        if (this.mProgressDialog != null) {
//            this.mProgressDialog.dismiss();
//        }
//        if (this.mMergeDialog != null) {
//            this.mMergeDialog.dismiss();
//        }
//        BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.back) {
//            finish();
//        } else if (id == R.id.confirm) {
//            selectSchedule();
//        }
//    }
//
//    private void refreshDueTime(int i) {
//        Calendar instance = Calendar.getInstance();
//        instance.add(5, i);
//        this.mDueTime = TimeUnit.SECONDS.convert(instance.getTime().getTime(), TimeUnit.MILLISECONDS);
//    }
//
//    /* access modifiers changed from: private */
//    public void updateDesc(int i, int i2, int i3) {
//        Calendar instance = Calendar.getInstance();
//        instance.add(5, i2);
//        Date time = instance.getTime();
//        this.mDueTime = TimeUnit.SECONDS.convert(time.getTime(), TimeUnit.MILLISECONDS);
//        int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(this, R.attr.color_progress);
//        SimpleSpannableBuilder simpleSpannableBuilder = new SimpleSpannableBuilder();
//        simpleSpannableBuilder.append("我计划 ").append(Integer.toString(i2), new ForegroundColorSpan(themeColorWithAttr)).append(" 天，每天背 ").append(Integer.toString(i3), new ForegroundColorSpan(themeColorWithAttr)).append(" 个单词\n").append("完成 ").append(String.format(Locale.CHINA, "%s（%d个单词）\n", new Object[]{this.mBookName, Integer.valueOf(i)}), new ForegroundColorSpan(themeColorWithAttr)).append("计划完成时间 ").append(TimeUtil.getDateString(time), new ForegroundColorSpan(themeColorWithAttr));
//        this.mScheduleDesc.setText(simpleSpannableBuilder.build());
//    }
//
//    private void selectSchedule() {
//        BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
//        C10592 r0 = new ThriftRequest<Client, BBSelectedBookInfo>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public BBSelectedBookInfo doInBackground(Client client) {
//                return client.select_book_v2(NewSchedulePickDateActivity.this.mBookId, NewSchedulePickDateActivity.this.mDueTime);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                NewSchedulePickDateActivity.this.mProgressDialog.dismiss();
//                if (exc instanceof BELogicException) {
//                    NewSchedulePickDateActivity.this.onSelectScheduleError(((BELogicException) exc).message);
//                    return;
//                }
//                NewSchedulePickDateActivity.this.onSelectScheduleError("网络不畅，请稍后再试");
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(BBSelectedBookInfo bBSelectedBookInfo) {
//                NewSchedulePickDateActivity.this.mProgressDialog.dismiss();
//                if (bBSelectedBookInfo != null) {
//                    BBUserSelectedBookInfo book_info = bBSelectedBookInfo.getBook_info();
//                    BookRecord bookById = BookListManager.getInstance().getBookById(book_info.getBook_id());
//                    if (bookById == null) {
//                        LogWrapper.m2794e(NewSchedulePickDateActivity.TAG, "empty book record " + book_info.getBook_id());
//                        return;
//                    }
//                    bookById.updateSelectedInfo(book_info);
//                    int need_merge_count = bBSelectedBookInfo.getNeed_merge_count();
//                    StudyManager.getInstance().addRefreshRequestFlag(1);
//                    if (need_merge_count > 0) {
//                        NewSchedulePickDateActivity.this.hintMergeAlreadyLearnedWords(need_merge_count);
//                    } else {
//                        NewSchedulePickDateActivity.this.onSelectScheduleSuccess();
//                    }
//                }
//            }
//        };
//        r0.setTag(TAG);
//        BaicizhanThrifts.getProxy().add(r0);
//        this.mProgressDialog.show();
//    }
//
//    /* access modifiers changed from: private */
//    public void onSelectScheduleError(String str) {
//        Toast.makeText(this, str, 0).show();
//    }
//
//    /* access modifiers changed from: private */
//    public void hintMergeAlreadyLearnedWords(int i) {
//        C10603 r0 = new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                if (i == -1) {
//                    NewSchedulePickDateActivity.this.mergeAlreadyLearnedWords();
//                } else {
//                    NewSchedulePickDateActivity.this.onSelectScheduleSuccess();
//                }
//            }
//        };
//        this.mMergeDialog = new Builder(this).setTitle((CharSequence) "提示").setMessage((CharSequence) String.format(Locale.CHINA, "你要选择的计划有%d个单词曾在其他计划里面学过", new Object[]{Integer.valueOf(i)})).setPositiveButton((CharSequence) "导入学习记录", (DialogInterface.OnClickListener) r0).setNegativeButton((CharSequence) "不导入重学", (DialogInterface.OnClickListener) r0).setCancelable(false).create();
//        this.mMergeDialog.show();
//    }
//
//    /* access modifiers changed from: private */
//    public void mergeAlreadyLearnedWords() {
//        C10614 r0 = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                int i;
//                int merge_already_learned_words = client.merge_already_learned_words(NewSchedulePickDateActivity.this.mBookId);
//                if (merge_already_learned_words < 0) {
//                    i = 5000;
//                } else {
//                    i = merge_already_learned_words + 2000;
//                }
//                LogWrapper.m2793d(NewSchedulePickDateActivity.TAG, "mergeAlreadyLearned wait " + i);
//                Thread.sleep((long) i);
//                return Integer.valueOf(0);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                NewSchedulePickDateActivity.this.mProgressDialog.dismiss();
//                NewSchedulePickDateActivity.this.onSelectScheduleSuccess();
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                NewSchedulePickDateActivity.this.mProgressDialog.dismiss();
//                NewSchedulePickDateActivity.this.onSelectScheduleSuccess();
//            }
//        };
//        r0.setTag(TAG);
//        this.mProgressDialog.setMessage((CharSequence) "导入中...");
//        this.mProgressDialog.show();
//        BaicizhanThrifts.getProxy().add(r0);
//    }
//
//    /* access modifiers changed from: private */
//    public void onSelectScheduleSuccess() {
//        Intent intent = new Intent(this, MainTabActivity.class);
//        if (this.mCreateNewTask) {
//            intent.setFlags(268468224);
//        } else {
//            intent.setFlags(67108864);
//        }
//        startActivity(intent);
//    }
//
//    public void onDefaultScheduleSet(boolean z, Fragment fragment) {
//        if (z) {
//            selectSchedule();
//            return;
//        }
//        this.mScheduleInitDescs.setVisibility(8);
//        this.mScheduleDesc.setVisibility(0);
//        this.mConfirm.setVisibility(0);
//        FragmentTransaction a = getSupportFragmentManager().mo313a();
//        a.mo178a((int) R.anim.alpha_fade_in, (int) R.anim.alpha_fade_out);
//        a.mo184b(R.id.schedule_picker_placeholder, this.mSchedulePickerFragment);
//        a.mo183b();
//    }
//}
