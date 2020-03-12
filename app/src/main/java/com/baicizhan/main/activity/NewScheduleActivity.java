//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.AbsListView;
//import android.widget.AbsListView.OnScrollListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.AdapterView.OnItemSelectedListener;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.models.BookCategory;
//import com.baicizhan.client.business.dataset.models.BookCategory.SubCategory;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.managers.BookListManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.ColorStateListUtils;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.business.widget.RoundedButton;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.customview.NoScrollGridView;
//import com.baicizhan.main.utils.BczDialogRecycler;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class NewScheduleActivity extends Activity implements OnClickListener {
//    private static final int DIALOG_EXIT = 1;
//    private static final String TAG = NewScheduleActivity.class.getSimpleName();
//    private AudioPlayer mAudioPlayer;
//    /* access modifiers changed from: private */
//    public ListView mBookCategories;
//    private BookCategoryAdapter mCategoryAdapter;
//    private ListView mCategoryNavigators;
//    private boolean mCreateNewTask;
//    /* access modifiers changed from: private */
//    public BczDialogRecycler mDialogRecycler = new BczDialogRecycler();
//    /* access modifiers changed from: private */
//    public NavigatorAdapter mNavigatorAdapter;
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//    /* access modifiers changed from: private */
//    public BookRecord mSelectedBook;
//
//    class BookCategoryAdapter extends BaseAdapter {
//        List<BookCategory> mCategories = Collections.emptyList();
//        int[] mSubCategoryIndex;
//
//        BookCategoryAdapter() {
//        }
//
//        public void update(List<BookCategory> list) {
//            this.mCategories = list;
//            this.mSubCategoryIndex = new int[list.size()];
//            int i = 0;
//            while (true) {
//                int i2 = i;
//                if (i2 < list.size()) {
//                    this.mSubCategoryIndex[i2] = ((BookCategory) list.get(i2)).getSubCategories().size() / 2;
//                    i = i2 + 1;
//                } else {
//                    notifyDataSetChanged();
//                    return;
//                }
//            }
//        }
//
//        public int getCount() {
//            return this.mCategories.size();
//        }
//
//        public Object getItem(int i) {
//            return this.mCategories.get(i);
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public View getView(final int i, View view, ViewGroup viewGroup) {
//            final BookCategoryViewHolder bookCategoryViewHolder;
//            Context context = viewGroup.getContext();
//            if (view == null) {
//                view = LayoutInflater.from(context).inflate(R.layout.book_category_item_view, viewGroup, false);
//                bookCategoryViewHolder = new BookCategoryViewHolder();
//                bookCategoryViewHolder.category = (TextView) view.findViewById(R.id.book_category);
//                bookCategoryViewHolder.publisher = (RoundedButton) view.findViewById(R.id.publisher);
//                bookCategoryViewHolder.bookGrid = (NoScrollGridView) view.findViewById(R.id.book_grid);
//                bookCategoryViewHolder.bookGridAdapter = new BookGridAdapter();
//                bookCategoryViewHolder.bookGrid.setAdapter(bookCategoryViewHolder.bookGridAdapter);
//                bookCategoryViewHolder.bookGrid.setOnItemClickListener(new OnItemClickListener() {
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
//                        BookRecord bookRecord = (BookRecord) ((BaseAdapter) adapterView.getAdapter()).getItem(i);
//                        if (bookRecord.dueTime <= 0 && bookRecord.getRemainCount() != 0 && bookRecord.bookId != StudyManager.getInstance().getCurrentBookId()) {
//                            NewScheduleActivity.this.onSelectBook(bookRecord);
//                            BookCategoryAdapter.this.notifyDataSetChanged();
//                            adapterView.setSelection(i);
//                        }
//                    }
//                });
//                view.setTag(bookCategoryViewHolder);
//            } else {
//                bookCategoryViewHolder = (BookCategoryViewHolder) view.getTag();
//            }
//            int requestedColumnWidth = bookCategoryViewHolder.bookGrid.getRequestedColumnWidth() + bookCategoryViewHolder.bookGrid.getRequestedHorizontalSpacing();
//            if (requestedColumnWidth != 0) {
//                int width = NewScheduleActivity.this.mBookCategories.getWidth();
//                bookCategoryViewHolder.bookGrid.getLayoutParams().width = width - (width % requestedColumnWidth);
//            }
//            BookCategory bookCategory = (BookCategory) this.mCategories.get(i);
//            bookCategoryViewHolder.bookCategory = bookCategory;
//            bookCategoryViewHolder.category.setText(bookCategory.getCategoryName());
//            if (bookCategory.getSubCategories().size() == 1) {
//                bookCategoryViewHolder.publisher.setVisibility(4);
//            } else {
//                bookCategoryViewHolder.publisher.setVisibility(0);
//                bookCategoryViewHolder.publisher.setFillColor(ColorStateListUtils.getSimpleColorStateList(0, ThemeUtil.getThemeColorWithAttr(context, R.attr.color_trans_grey_g2)));
//                bookCategoryViewHolder.publisher.setOnClickListener(new OnClickListener() {
//                    public void onClick(View view) {
//                        BookCategory bookCategory = bookCategoryViewHolder.bookCategory;
//                        ArrayList arrayList = new ArrayList(bookCategory.getSubCategories().size());
//                        for (SubCategory subName : bookCategory.getSubCategories()) {
//                            arrayList.add(subName.getSubName());
//                        }
//                        PublisherSelectionDialog publisherSelectionDialog = new PublisherSelectionDialog(view.getContext());
//                        publisherSelectionDialog.setPublishers(BookCategoryAdapter.this.mSubCategoryIndex[i], arrayList);
//                        publisherSelectionDialog.setOnItemSelectedListener(new OnItemSelectedListener() {
//                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
//                                bookCategoryViewHolder.showSubCategory(i);
//                                BookCategoryAdapter.this.mSubCategoryIndex[i] = i;
//                            }
//
//                            public void onNothingSelected(AdapterView<?> adapterView) {
//                            }
//                        });
//                        publisherSelectionDialog.setCancelable(true);
//                        publisherSelectionDialog.show();
//                    }
//                });
//            }
//            bookCategoryViewHolder.showSubCategory(this.mSubCategoryIndex[i]);
//            return view;
//        }
//    }
//
//    class BookCategoryViewHolder {
//        BookCategory bookCategory;
//        NoScrollGridView bookGrid;
//        BookGridAdapter bookGridAdapter;
//        TextView category;
//        RoundedButton publisher;
//
//        BookCategoryViewHolder() {
//        }
//
//        public void showSubCategory(int i) {
//            SubCategory subCategory = (SubCategory) this.bookCategory.getSubCategories().get(i);
//            this.publisher.setText(subCategory.getSubName());
//            this.bookGridAdapter.update(subCategory.getBookIds());
//        }
//    }
//
//    class BookGridAdapter extends BaseAdapter {
//        List<Integer> mBookIds = Collections.emptyList();
//
//        BookGridAdapter() {
//        }
//
//        private boolean isCurrentBook(BookRecord bookRecord) {
//            return bookRecord.bookId == StudyManager.getInstance().getCurrentBookId();
//        }
//
//        public void update(List<Integer> list) {
//            this.mBookIds = list;
//            notifyDataSetChanged();
//        }
//
//        public int getCount() {
//            return this.mBookIds.size();
//        }
//
//        public Object getItem(int i) {
//            return BookListManager.getInstance().getBookById(((Integer) this.mBookIds.get(i)).intValue());
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            BookViewHolder bookViewHolder;
//            if (view == null) {
//                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_item_view, viewGroup, false);
//                bookViewHolder = new BookViewHolder();
//                bookViewHolder.parent = view;
//                bookViewHolder.bookName = (TextView) view.findViewById(R.id.book_name);
//                bookViewHolder.wordCount = (TextView) view.findViewById(R.id.book_word_count);
//                bookViewHolder.bookStatus = (ImageView) view.findViewById(R.id.book_status);
//                view.setTag(bookViewHolder);
//            } else {
//                bookViewHolder = (BookViewHolder) view.getTag();
//            }
//            BookRecord bookRecord = (BookRecord) getItem(i);
//            if (bookRecord != null) {
//                if (NewScheduleActivity.this.mSelectedBook == null || NewScheduleActivity.this.mSelectedBook.bookId != bookRecord.bookId) {
//                    bookViewHolder.parent.setBackgroundResource(R.drawable.book_icon_normal_default);
//                } else {
//                    bookViewHolder.parent.setBackgroundResource(R.drawable.book_touch_normal_default);
//                }
//                bookViewHolder.bookStatus.setVisibility(4);
//                if (bookRecord.dueTime > 0) {
//                    bookViewHolder.bookStatus.setVisibility(0);
//                    bookViewHolder.bookStatus.setImageResource(R.drawable.book_tips_sel_normal_default);
//                }
//                if (isCurrentBook(bookRecord)) {
//                    bookViewHolder.bookStatus.setVisibility(0);
//                    bookViewHolder.bookStatus.setImageResource(R.drawable.book_tips_learning_normal_default);
//                }
//                if (CommonUtils.getBookRemainCount(bookRecord) == 0) {
//                    bookViewHolder.bookStatus.setVisibility(0);
//                    bookViewHolder.bookStatus.setImageResource(R.drawable.book_tips_complete_normal_default);
//                }
//                bookViewHolder.bookId = bookRecord.bookId;
//                if (bookRecord.bookName.startsWith("象形9000")) {
//                    bookViewHolder.bookName.setText(bookRecord.bookName.substring(0, 6) + "\n" + bookRecord.bookName.substring(6));
//                } else {
//                    bookViewHolder.bookName.setText(bookRecord.bookName);
//                }
//                bookViewHolder.wordCount.setText(CommonUtils.getBookWordDesc(bookRecord.wordCount));
//            }
//            return view;
//        }
//    }
//
//    class BookViewHolder {
//        int bookId;
//        TextView bookName;
//        ImageView bookStatus;
//        View parent;
//        TextView wordCount;
//
//        BookViewHolder() {
//        }
//    }
//
//    class NavigatorAdapter extends BaseAdapter {
//        private List<BookCategory> mCategories;
//        private int mItemHeight;
//        private int mSelected;
//
//        private NavigatorAdapter() {
//            this.mCategories = Collections.emptyList();
//            this.mSelected = -1;
//            this.mItemHeight = 0;
//        }
//
//        public void update(Context context, List<BookCategory> list) {
//            this.mCategories = list;
//            this.mItemHeight = ((DisplayUtils.getDisplayPixelSize(context).y - DisplayUtils.dpToPx(context, 35.0f)) - (list.size() - 1)) / list.size();
//            notifyDataSetChanged();
//        }
//
//        public void setSelected(int i) {
//            if (this.mSelected != i) {
//                this.mSelected = i;
//                notifyDataSetChanged();
//            }
//        }
//
//        public int getCount() {
//            return this.mCategories.size();
//        }
//
//        public Object getItem(int i) {
//            return this.mCategories.get(i);
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            TextView textView;
//            Context context = viewGroup.getContext();
//            if (view == null) {
//                TextView textView2 = (TextView) LayoutInflater.from(context).inflate(R.layout.book_category_navigator_view, viewGroup, false);
//                LayoutParams layoutParams = textView2.getLayoutParams();
//                layoutParams.height = this.mItemHeight;
//                textView2.setLayoutParams(layoutParams);
//                textView = textView2;
//            } else {
//                textView = (TextView) view;
//            }
//            textView.setText(((BookCategory) this.mCategories.get(i)).getCategoryName());
//            textView.setBackgroundColor(i == this.mSelected ? ThemeUtil.getThemeColorWithAttr(context, R.attr.color_blue_btn_pressed) : ThemeUtil.getThemeColorWithAttr(context, R.attr.color_blue_btn));
//            return textView;
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_new_schedule);
//            this.mCreateNewTask = getIntent().getBooleanExtra(NewSchedulePickDateActivity.EXTRA_CREATE_NEW_TASK, false);
//            this.mAudioPlayer = new AudioPlayer(this);
//            this.mCategoryNavigators = (ListView) findViewById(R.id.book_category_navigators);
//            this.mNavigatorAdapter = new NavigatorAdapter();
//            this.mBookCategories = (ListView) findViewById(R.id.book_categories);
//            this.mCategoryAdapter = new BookCategoryAdapter();
//            this.mProgressDialog = CommonUtils.createProgressDialog(this);
//            if (BookListManager.getInstance().isReady()) {
//                onBookListLoaded();
//            } else {
//                C10511 r0 = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//                    /* access modifiers changed from: protected */
//                    public Integer doInBackground(Client client) {
//                        BookListManager.getInstance().load(NewScheduleActivity.this, client);
//                        return Integer.valueOf(0);
//                    }
//
//                    /* access modifiers changed from: protected */
//                    public void onError(Exception exc) {
//                        NewScheduleActivity.this.mProgressDialog.dismiss();
//                        BczDialog create = new Builder(NewScheduleActivity.this).setMessage((CharSequence) "获取书列表失败，请检查您的网络").setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                NewScheduleActivity.this.finish();
//                            }
//                        }).create();
//                        create.show();
//                        NewScheduleActivity.this.mDialogRecycler.replace(1, create);
//                    }
//
//                    /* access modifiers changed from: protected */
//                    public void onResult(Integer num) {
//                        NewScheduleActivity.this.mProgressDialog.dismiss();
//                        NewScheduleActivity.this.onBookListLoaded();
//                    }
//                };
//                r0.setTag(TAG);
//                BaicizhanThrifts.getProxy().add(r0);
//                this.mProgressDialog.setCancelable(false);
//                this.mProgressDialog.show();
//            }
//            findViewById(R.id.back).setOnClickListener(this);
//        }
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
//    /* access modifiers changed from: private */
//    public void onBookListLoaded() {
//        List bookCategory = BookListManager.getInstance().getBookCategory();
//        if (bookCategory != null) {
//            this.mCategoryNavigators.setAdapter(this.mNavigatorAdapter);
//            this.mBookCategories.setAdapter(this.mCategoryAdapter);
//            this.mCategoryAdapter.update(bookCategory);
//            this.mNavigatorAdapter.update(this, bookCategory);
//            this.mCategoryNavigators.setOnItemClickListener(new OnItemClickListener() {
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
//                    NewScheduleActivity.this.mBookCategories.smoothScrollToPosition(i);
//                }
//            });
//            this.mBookCategories.setOnScrollListener(new OnScrollListener() {
//                public void onScrollStateChanged(AbsListView absListView, int i) {
//                }
//
//                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
//                    for (int i4 = 0; i4 < NewScheduleActivity.this.mBookCategories.getChildCount(); i4++) {
//                        if (NewScheduleActivity.this.mBookCategories.getChildAt(i4).getTop() >= (-DisplayUtils.dpToPx(absListView.getContext(), 36.0f))) {
//                            NewScheduleActivity.this.mNavigatorAdapter.setSelected(i4 + i);
//                            return;
//                        }
//                    }
//                }
//            });
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onSelectBook(BookRecord bookRecord) {
//        this.mSelectedBook = bookRecord;
//        this.mAudioPlayer.newPlayRaw(R.raw.select_book);
//        if (bookRecord.bookId != StudyManager.getInstance().getCurrentBookId()) {
//            Intent intent = new Intent(this, NewSchedulePickDateActivity.class);
//            intent.putExtra(NewSchedulePickDateActivity.EXTRA_CREATE_NEW_TASK, this.mCreateNewTask);
//            intent.putExtra("book_id", bookRecord.bookId);
//            intent.putExtra(NewSchedulePickDateActivity.EXTRA_BOOK_NAME, bookRecord.bookName);
//            intent.putExtra("word_count", bookRecord.wordCount);
//            startActivity(intent);
//        }
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.back) {
//            finish();
//        }
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
//}
