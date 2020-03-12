//package com.baicizhan.main.activity;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentActivity;
//import android.support.p008v7.widget.C0244al;
//import android.support.p008v7.widget.C0266bg;
//import android.support.p008v7.widget.LinearLayoutManager;
//import android.support.p008v7.widget.RecyclerView;
//import android.text.style.ForegroundColorSpan;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.BookListManager;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.SimpleSpannableBuilder;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.main.fragment.SchedulePickerFragment;
//import com.baicizhan.main.fragment.SchedulePickerFragment.OnPickListener;
//import com.baicizhan.main.utils.BczDialogRecycler;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_users.BBUserSelectedBookInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.jiongji.andriod.card.R;
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.List;
//import java.util.Locale;
//
//public class ScheduleManagementActivity extends FragmentActivity implements OnClickListener {
//    private static final int DIALOG_CONFIRM_RESET_OR_DELETE = 2;
//    private static final int DIALOG_EXIT = 1;
//    public static final String EXTRA_REQUIRE_SCHEDULE = "require_schedule";
//    private static final String TAG = ScheduleManagementActivity.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public AudioPlayer mAudioPlayer;
//    /* access modifiers changed from: private */
//    public BookAdapter mBookAdapter;
//    /* access modifiers changed from: private */
//    public List<BookRecord> mBooks = Collections.emptyList();
//    /* access modifiers changed from: private */
//    public BczDialogRecycler mDialogRecycler = new BczDialogRecycler();
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//    private boolean mRequireSchedule;
//    private TextView mScheduleDesc;
//    private long mScheduleEndTime;
//    private SchedulePickerFragment mSchedulePickerFragment = new SchedulePickerFragment();
//    private int mScheduleWordCount;
//    private BookRecord mSelectedBookRecord;
//    private RecyclerView mSelectedBooksView;
//
//    class BookAdapter extends C0244al<ViewHolder> {
//        private static final int OP_ADD = 0;
//        private static final int OP_SUB = 1;
//        List<BookRecord> mBooks = Collections.emptyList();
//        OpMode mOpMode = OpMode.NORMAL;
//        int mSelectedPosition = -1;
//        private int minusResId;
//        private int otherBookTextColor;
//        private int otherCountTextColor;
//        private int plusResId;
//        private int selectedBookTextColor;
//
//        public BookAdapter() {
//            this.selectedBookTextColor = ThemeUtil.getThemeColorWithAttr(ScheduleManagementActivity.this, R.attr.color_common_white);
//            this.otherBookTextColor = ThemeUtil.getThemeColorWithAttr(ScheduleManagementActivity.this, R.attr.color_fm_deep_blue);
//            this.otherCountTextColor = ThemeUtil.getThemeColorWithAttr(ScheduleManagementActivity.this, R.attr.color_button_text_mediabar);
//            this.plusResId = ThemeUtil.getThemeResourceIdWithAttr(ScheduleManagementActivity.this, R.attr.drawable_android_plan_plus);
//            this.minusResId = ThemeUtil.getThemeResourceIdWithAttr(ScheduleManagementActivity.this, R.attr.drawable_android_plan_minus);
//        }
//
//        public void update(List<BookRecord> list) {
//            this.mBooks = list;
//            notifyDataSetChanged();
//        }
//
//        public void setOpMode(OpMode opMode) {
//            this.mOpMode = opMode;
//            notifyDataSetChanged();
//        }
//
//        public OpMode getOpMode() {
//            return this.mOpMode;
//        }
//
//        public int getItemCount() {
//            return this.mBooks.size() + 2;
//        }
//
//        public long getItemId(int i) {
//            if (i < this.mBooks.size()) {
//                return (long) ((BookRecord) this.mBooks.get(i)).bookId;
//            }
//            return (long) (this.mBooks.size() - i);
//        }
//
//        public int getSelection() {
//            return this.mSelectedPosition;
//        }
//
//        public void setSelectionItem(int i) {
//            if (i != 0) {
//                int i2 = 0;
//                while (true) {
//                    int i3 = i2;
//                    if (i3 < this.mBooks.size()) {
//                        if (((BookRecord) this.mBooks.get(i3)).bookId == i) {
//                            setSelection(i3);
//                        }
//                        i2 = i3 + 1;
//                    } else {
//                        return;
//                    }
//                }
//            }
//        }
//
//        public void setSelection(int i) {
//            if (i != this.mSelectedPosition) {
//                this.mSelectedPosition = i;
//                ScheduleManagementActivity.this.onSelectBook((BookRecord) this.mBooks.get(i));
//                notifyDataSetChanged();
//            }
//        }
//
//        private boolean isCurrentBook(BookRecord bookRecord) {
//            return StudyManager.getInstance().getCurrentBookId() == bookRecord.bookId;
//        }
//
//        public void onBindViewHolder(ViewHolder viewHolder, final int i) {
//            final OpMode opMode;
//            if (i < this.mBooks.size()) {
//                BookRecord bookRecord = (BookRecord) this.mBooks.get(i);
//                if (bookRecord.bookName.startsWith("象形9000")) {
//                    viewHolder.bookName.setText(bookRecord.bookName.substring(0, 6) + "\n" + bookRecord.bookName.substring(6));
//                } else {
//                    viewHolder.bookName.setText(bookRecord.bookName);
//                }
//                viewHolder.wordCount.setText(CommonUtils.getBookWordDesc(bookRecord.wordCount));
//                viewHolder.background.setOnClickListener(new OnClickListener() {
//                    public void onClick(View view) {
//                        ScheduleManagementActivity.this.mAudioPlayer.newPlayRaw(R.raw.select_book);
//                        BookAdapter.this.setSelection(i);
//                    }
//                });
//                boolean isCurrentBook = isCurrentBook(bookRecord);
//                if (this.mOpMode == OpMode.NORMAL) {
//                    viewHolder.resetOrDelete.setVisibility(4);
//                } else if (this.mOpMode == OpMode.RESET) {
//                    viewHolder.resetOrDelete.setVisibility(0);
//                    viewHolder.resetOrDelete.setImageResource(R.drawable.reset_plan_normal_default);
//                    viewHolder.resetOrDelete.setOnClickListener(new OnClickListener() {
//                        public void onClick(View view) {
//                            ScheduleManagementActivity.this.onBookOperation((BookRecord) BookAdapter.this.mBooks.get(i), OpMode.RESET);
//                        }
//                    });
//                } else if (this.mOpMode == OpMode.DELETE) {
//                    viewHolder.resetOrDelete.setVisibility(0);
//                    if (isCurrentBook) {
//                        viewHolder.resetOrDelete.setImageResource(R.drawable.reset_plan_normal_default);
//                        opMode = OpMode.RESET;
//                    } else {
//                        viewHolder.resetOrDelete.setImageResource(R.drawable.delete_plan_normal_default);
//                        opMode = OpMode.DELETE;
//                    }
//                    viewHolder.resetOrDelete.setOnClickListener(new OnClickListener() {
//                        public void onClick(View view) {
//                            ScheduleManagementActivity.this.onBookOperation((BookRecord) BookAdapter.this.mBooks.get(i), opMode);
//                        }
//                    });
//                }
//                if (i == this.mSelectedPosition) {
//                    viewHolder.background.setBackgroundResource(R.drawable.book_touch_normal_default);
//                    viewHolder.bookName.setTextColor(this.selectedBookTextColor);
//                    viewHolder.wordCount.setTextColor(this.selectedBookTextColor);
//                } else {
//                    viewHolder.background.setBackgroundResource(R.drawable.book_icon_normal_default);
//                    viewHolder.bookName.setTextColor(this.otherBookTextColor);
//                    viewHolder.wordCount.setTextColor(this.otherCountTextColor);
//                }
//                viewHolder.bookStatus.setVisibility(4);
//                if (isCurrentBook) {
//                    viewHolder.background.setBackgroundResource(R.drawable.book_learning_normal_default);
//                    viewHolder.bookStatus.setVisibility(0);
//                    viewHolder.bookStatus.setImageResource(R.drawable.book_tips_learning_normal_default);
//                }
//                if (CommonUtils.getBookRemainCount(bookRecord) == 0) {
//                    viewHolder.bookStatus.setVisibility(0);
//                    viewHolder.bookStatus.setImageResource(R.drawable.book_tips_complete_normal_default);
//                    return;
//                }
//                return;
//            }
//            viewHolder.bookName.setText("");
//            viewHolder.wordCount.setText("");
//            viewHolder.resetOrDelete.setVisibility(4);
//            viewHolder.bookStatus.setVisibility(4);
//            int size = i - this.mBooks.size();
//            if (size == 0) {
//                viewHolder.background.setBackgroundResource(this.plusResId);
//                viewHolder.background.setOnClickListener(new OnClickListener() {
//                    public void onClick(View view) {
//                        ScheduleManagementActivity.this.startActivity(new Intent(ScheduleManagementActivity.this, NewScheduleActivity.class));
//                    }
//                });
//            } else if (size == 1) {
//                viewHolder.background.setBackgroundResource(this.minusResId);
//                viewHolder.background.setOnClickListener(new OnClickListener() {
//                    public void onClick(View view) {
//                        if (BookAdapter.this.mOpMode == OpMode.DELETE) {
//                            BookAdapter.this.setOpMode(OpMode.NORMAL);
//                        } else {
//                            BookAdapter.this.setOpMode(OpMode.DELETE);
//                        }
//                    }
//                });
//            }
//        }
//
//        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_item_manage_view, viewGroup, false));
//        }
//    }
//
//    enum OpMode {
//        NORMAL,
//        RESET,
//        DELETE
//    }
//
//    class ViewHolder extends C0266bg {
//        public View background;
//        public TextView bookName;
//        public ImageView bookStatus;
//        public ImageView resetOrDelete;
//        public TextView wordCount;
//
//        public ViewHolder(View view) {
//            super(view);
//            this.background = view.findViewById(R.id.background);
//            this.bookName = (TextView) view.findViewById(R.id.book_name);
//            this.wordCount = (TextView) view.findViewById(R.id.book_word_count);
//            this.resetOrDelete = (ImageView) view.findViewById(R.id.book_reset_or_delete);
//            this.bookStatus = (ImageView) view.findViewById(R.id.book_status);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_schedule_management);
//            this.mRequireSchedule = getIntent().getBooleanExtra(EXTRA_REQUIRE_SCHEDULE, false);
//            this.mAudioPlayer = new AudioPlayer(this);
//            initViews();
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//        loadBooks();
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
//        if (this.mAudioPlayer != null) {
//            this.mAudioPlayer.destroy();
//        }
//        if (this.mProgressDialog != null) {
//            this.mProgressDialog.dismiss();
//        }
//        this.mDialogRecycler.destroy();
//        BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
//    }
//
//    public void onBackPressed() {
//        super.onBackPressed();
//        cancelManagement();
//    }
//
//    private void cancelManagement() {
//        if (this.mRequireSchedule) {
//            finish();
//            CommonUtils.killAllProcess(this);
//            return;
//        }
//        finish();
//        overridePendingTransition(R.anim.alpha_fade_in, R.anim.business_push_right_out);
//    }
//
//    private void initViews() {
//        findViewById(R.id.back).setOnClickListener(this);
//        findViewById(R.id.confirm).setOnClickListener(this);
//        findViewById(R.id.reset).setOnClickListener(this);
//        this.mScheduleDesc = (TextView) findViewById(R.id.schedule_desc);
//        this.mProgressDialog = new BczLoadingDialog(this);
//        this.mProgressDialog.setCancelable(true);
//        getSupportFragmentManager().mo313a().mo179a((int) R.id.schedule_picker_placeholder, (Fragment) this.mSchedulePickerFragment).mo183b();
//        this.mSchedulePickerFragment.setOnPickListener(new OnPickListener() {
//            public void onPick(int i, int i2, int i3) {
//                ScheduleManagementActivity.this.updateScheduleDesc(i, i2, i3);
//            }
//        });
//        this.mSelectedBooksView = (RecyclerView) findViewById(R.id.selected_books);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
//        linearLayoutManager.mo1072a(0);
//        this.mSelectedBooksView.setLayoutManager(linearLayoutManager);
//        this.mBookAdapter = new BookAdapter();
//        this.mBookAdapter.setHasStableIds(true);
//        this.mSelectedBooksView.setAdapter(this.mBookAdapter);
//    }
//
//    /* access modifiers changed from: private */
//    public void updateScheduleDesc(int i, int i2, int i3) {
//        Calendar instance = Calendar.getInstance();
//        instance.add(5, i2);
//        int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(this, R.attr.color_progress);
//        SimpleSpannableBuilder simpleSpannableBuilder = new SimpleSpannableBuilder();
//        simpleSpannableBuilder.append(this.mSelectedBookRecord.bookName, new ForegroundColorSpan(themeColorWithAttr)).append(String.format(Locale.CHINA, "（剩余%d个单词），", new Object[]{Integer.valueOf(i)})).append("计划完成时间").append(TimeUtil.getDateString(instance.getTime()), new ForegroundColorSpan(themeColorWithAttr));
//        this.mScheduleEndTime = instance.getTimeInMillis() / 1000;
//        this.mScheduleWordCount = i3;
//        this.mScheduleDesc.setText(simpleSpannableBuilder.build());
//    }
//
//    private void loadBooks() {
//        if (this.mBooks.size() <= 0) {
//            if (BookListManager.getInstance().isReady()) {
//                onBookListLoaded();
//                return;
//            }
//            C10672 r0 = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//                /* access modifiers changed from: protected */
//                public Integer doInBackground(Client client) {
//                    BookListManager.getInstance().load(ScheduleManagementActivity.this, client);
//                    return Integer.valueOf(0);
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                    ScheduleManagementActivity.this.mProgressDialog.hide();
//                    BczDialog create = new Builder(ScheduleManagementActivity.this).setMessage((CharSequence) "获取书列表失败，请检查您的网络").setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            ScheduleManagementActivity.this.finish();
//                        }
//                    }).create();
//                    create.show();
//                    ScheduleManagementActivity.this.mDialogRecycler.replace(1, create);
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(Integer num) {
//                    ScheduleManagementActivity.this.mProgressDialog.hide();
//                    ScheduleManagementActivity.this.onBookListLoaded();
//                }
//            };
//            r0.setTag(TAG);
//            BaicizhanThrifts.getProxy().add(r0);
//            this.mProgressDialog.setMessage((CharSequence) "获取书列表中，请稍候...");
//            this.mProgressDialog.setCancelable(false);
//            this.mProgressDialog.show();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onBookListLoaded() {
//        this.mBooks = BookListManager.getInstance().getSelectedBooks();
//        this.mBookAdapter.update(this.mBooks);
//        this.mBookAdapter.setSelectionItem(StudyManager.getInstance().getCurrentBookId());
//        this.mSelectedBooksView.mo1100a(this.mBookAdapter.getSelection());
//    }
//
//    /* access modifiers changed from: private */
//    public void onSelectBook(BookRecord bookRecord) {
//        this.mSelectedBookRecord = bookRecord;
//        int bookRemainCount = CommonUtils.getBookRemainCount(bookRecord);
//        Bundle bundle = new Bundle();
//        if (bookRemainCount == 0) {
//            bundle.putInt(SchedulePickerFragment.EXTRA_MODE, 2);
//            bundle.putInt("word_count", bookRecord.wordCount);
//        } else {
//            bundle.putInt(SchedulePickerFragment.EXTRA_MODE, 1);
//            bundle.putInt("word_count", bookRemainCount);
//            int remainDays = bookRecord.getRemainDays();
//            if (remainDays > 0) {
//                bundle.putInt(SchedulePickerFragment.EXTRA_SCHEDULE_DAY_COUNT, remainDays);
//            }
//        }
//        this.mSchedulePickerFragment.updateView(bundle);
//    }
//
//    /* access modifiers changed from: private */
//    public void onBookOperation(final BookRecord bookRecord, final OpMode opMode) {
//        UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//        Object[] objArr = new Object[4];
//        objArr[0] = bookRecord.bookName;
//        objArr[1] = Integer.valueOf(bookRecord.finishCount);
//        objArr[2] = opMode == OpMode.DELETE ? "删" : "重置";
//        objArr[3] = currentUser.getVerboseSex();
//        BczDialog create = new Builder(this).setTitle((int) R.string.attention).setMessage((CharSequence) getString(R.string.main_alert_message_delete_schedule, objArr)).setPositiveButton(opMode == OpMode.DELETE ? R.string.main_alert_positive_delete_schedule : R.string.main_alert_positive_reset_schedule, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                if (i == -1) {
//                    ScheduleManagementActivity.this.deleteResetBookFromServer(bookRecord, opMode);
//                }
//            }
//        }).setNegativeButton((int) R.string.main_alert_negative_common, (DialogInterface.OnClickListener) null).create();
//        create.show();
//        this.mDialogRecycler.replace(2, create);
//    }
//
//    /* access modifiers changed from: private */
//    public void deleteResetBookFromServer(final BookRecord bookRecord, final OpMode opMode) {
//        C10704 r0 = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                if (opMode == OpMode.DELETE) {
//                    bookRecord.dueTime = 0;
//                    int delete_done_score_data = client.delete_done_score_data(bookRecord.bookId);
//                    if (delete_done_score_data == 0) {
//                        BookRecordHelper.deleteScheduleData(ScheduleManagementActivity.this.getApplicationContext(), bookRecord.bookId, true);
//                    }
//                    return Integer.valueOf(delete_done_score_data);
//                }
//                int reset_done_score_data = client.reset_done_score_data(bookRecord.bookId);
//                BookRecordHelper.deleteScheduleData(ScheduleManagementActivity.this.getApplicationContext(), bookRecord.bookId, false);
//                StudyManager.getInstance().clearCurrentScheduleData();
//                LearnRecordManager.getInstance().clear();
//                Thread.sleep((long) (bookRecord.wordCount + 1000));
//                return Integer.valueOf(reset_done_score_data);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                ScheduleManagementActivity.this.mProgressDialog.hide();
//                CommonUtils.toastThriftErrorMsg(ScheduleManagementActivity.this, exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                ScheduleManagementActivity.this.mProgressDialog.hide();
//                if (bookRecord.bookId == StudyManager.getInstance().getCurrentBookId()) {
//                    ScheduleManagementActivity.this.markScheduleDirty();
//                }
//                if (opMode == OpMode.DELETE) {
//                    ScheduleManagementActivity.this.mBookAdapter.setOpMode(OpMode.NORMAL);
//                    ScheduleManagementActivity.this.mBooks.remove(bookRecord);
//                    ScheduleManagementActivity.this.mBookAdapter.update(ScheduleManagementActivity.this.mBooks);
//                    return;
//                }
//                ScheduleManagementActivity.this.overridePendingTransition(R.anim.alpha_fade_in, R.anim.business_push_right_out);
//                ScheduleManagementActivity.this.finish();
//            }
//        };
//        r0.setTag(TAG);
//        BaicizhanThrifts.getProxy().add(r0);
//        this.mProgressDialog.setMessage((CharSequence) "处理中，请稍候");
//        this.mProgressDialog.show();
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.back) {
//            cancelManagement();
//        } else if (id == R.id.reset) {
//            if (this.mBookAdapter.getOpMode() == OpMode.RESET) {
//                this.mBookAdapter.setOpMode(OpMode.NORMAL);
//            } else {
//                this.mBookAdapter.setOpMode(OpMode.RESET);
//            }
//        } else if (id == R.id.confirm && this.mSelectedBookRecord != null) {
//            changeCurrentBook(this.mSelectedBookRecord.bookId, this.mScheduleEndTime, this.mScheduleWordCount);
//        }
//    }
//
//    private void changeCurrentBook(int i, long j, int i2) {
//        final int i3 = i;
//        final long j2 = j;
//        final int i4 = i2;
//        C10715 r0 = new ThriftRequest<Client, BBUserSelectedBookInfo>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public BBUserSelectedBookInfo doInBackground(Client client) {
//                return client.select_book(i3, j2);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                ScheduleManagementActivity.this.mProgressDialog.hide();
//                CommonUtils.toastThriftErrorMsg(ScheduleManagementActivity.this, exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(BBUserSelectedBookInfo bBUserSelectedBookInfo) {
//                ScheduleManagementActivity.this.mProgressDialog.dismiss();
//                if (bBUserSelectedBookInfo != null) {
//                    BookRecord bookById = BookListManager.getInstance().getBookById(bBUserSelectedBookInfo.getBook_id());
//                    if (bookById != null) {
//                        bookById.updateSelectedInfo(bBUserSelectedBookInfo);
//                    }
//                    if (CommonUtils.getBookRemainCount(bookById) == 0) {
//                        Settings.putInt(Settings.PREF_COMPLETE_REVIEW_COUNT, i4);
//                    }
//                    ScheduleManagementActivity.this.markScheduleDirty();
//                    ScheduleManagementActivity.this.finish();
//                    ScheduleManagementActivity.this.overridePendingTransition(R.anim.alpha_fade_in, R.anim.business_push_right_out);
//                }
//            }
//        };
//        this.mProgressDialog.setMessage((CharSequence) "设置计划中...");
//        this.mProgressDialog.show();
//        r0.setTag(TAG);
//        BaicizhanThrifts.getProxy().add(r0);
//    }
//
//    /* access modifiers changed from: private */
//    public void markScheduleDirty() {
//        StudyManager.getInstance().addRefreshRequestFlag(1);
//    }
//}
