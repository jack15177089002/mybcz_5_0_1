//package com.baicizhan.client.business.managers;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.KVHelper;
//import com.baicizhan.client.business.dataset.models.BookCategory;
//import com.baicizhan.client.business.dataset.models.BookCategory.SubCategory;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKRESOURCE.Columns;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.Profiler;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.online.bs_users.BBBookBasicInfo;
//import com.baicizhan.online.bs_users.BBBookCategory;
//import com.baicizhan.online.bs_users.BBBookListInfo;
//import com.baicizhan.online.bs_users.BBCheckInfo;
//import com.baicizhan.online.bs_users.BBSubCategory;
//import com.baicizhan.online.bs_users.BBUserSelectedBookInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import org.p100a.p101a.p107f.C2120g;
//
//public class BookListManager {
//    private static final String TAG = BookListManager.class.getSimpleName();
//    private static final BookListManager sInstance = new BookListManager();
//    private List<BookCategory> mBookCategory = Collections.emptyList();
//    private Map<Integer, BookRecord> mBooks = Collections.emptyMap();
//    private long mRemoteBookListVersion = 0;
//    private Map<Integer, BBUserSelectedBookInfo> mSelectedBookInfos = new ArrayMap();
//    private Profiler profiler = new Profiler();
//
//    public static BookListManager getInstance() {
//        return sInstance;
//    }
//
//    public List<BookRecord> getSelectedBooks() {
//        ArrayList arrayList = new ArrayList();
//        for (BookRecord bookRecord : this.mBooks.values()) {
//            if (bookRecord.dueTime > 0) {
//                arrayList.add(bookRecord);
//            }
//        }
//        return arrayList;
//    }
//
//    public BookRecord getBookById(int i) {
//        return (BookRecord) this.mBooks.get(Integer.valueOf(i));
//    }
//
//    public List<BookCategory> getBookCategory() {
//        return this.mBookCategory;
//    }
//
//    public void setRemoteBookListVersion(long j) {
//        this.mRemoteBookListVersion = j;
//    }
//
//    public boolean isReady() {
//        return this.mBookCategory.size() > 0 && this.mBooks.size() > 0 && this.mSelectedBookInfos.size() > 0;
//    }
//
//    public void clear() {
//        this.mBooks.clear();
//        this.mBookCategory.clear();
//        this.mSelectedBookInfos.clear();
//    }
//
//    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
//        if (loadBookListFromServer(r9, r10) != false) goto L_0x0050;
//     */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public void load(Context r9, com.baicizhan.online.bs_users.BSUsers.Client r10) {
//        /*
//            r8 = this;
//            r0 = 1
//            r1 = 0
//            java.lang.String r2 = "global.book_list_version"
//            long r2 = com.baicizhan.client.business.dataset.helpers.KVHelper.getLong(r9, r2)
//            java.lang.String r4 = TAG
//            java.lang.StringBuilder r5 = new java.lang.StringBuilder
//            java.lang.String r6 = "check book_list version "
//            r5.<init>(r6)
//            java.lang.StringBuilder r5 = r5.append(r2)
//            java.lang.String r6 = " - "
//            java.lang.StringBuilder r5 = r5.append(r6)
//            long r6 = r8.mRemoteBookListVersion
//            java.lang.StringBuilder r5 = r5.append(r6)
//            java.lang.String r5 = r5.toString()
//            com.baicizhan.client.business.util.LogWrapper.m2793d(r4, r5)
//            r4 = 0
//            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
//            if (r4 == 0) goto L_0x0034
//            long r4 = r8.mRemoteBookListVersion
//            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
//            if (r2 == 0) goto L_0x003b
//        L_0x0034:
//            boolean r2 = r8.loadBookListFromServer(r9, r10)
//            if (r2 == 0) goto L_0x003b
//            r1 = r0
//        L_0x003b:
//            if (r1 != 0) goto L_0x0096
//            boolean r1 = r8.loadBookListFromClient(r9)
//            if (r1 != 0) goto L_0x0094
//            java.lang.String r2 = TAG
//            java.lang.String r3 = "loadBookListFromClient failed, try server again"
//            com.baicizhan.client.business.util.LogWrapper.m2795i(r2, r3)
//            boolean r2 = r8.loadBookListFromServer(r9, r10)
//            if (r2 == 0) goto L_0x0094
//        L_0x0050:
//            if (r0 != 0) goto L_0x005a
//            java.lang.Exception r0 = new java.lang.Exception
//            java.lang.String r1 = "获取书列表失败"
//            r0.<init>(r1)
//            throw r0
//        L_0x005a:
//            java.lang.String r0 = TAG
//            java.lang.StringBuilder r1 = new java.lang.StringBuilder
//            java.lang.String r2 = "loadBookList size "
//            r1.<init>(r2)
//            java.util.Map<java.lang.Integer, com.baicizhan.client.business.dataset.models.BookRecord> r2 = r8.mBooks
//            int r2 = r2.size()
//            java.lang.StringBuilder r1 = r1.append(r2)
//            java.lang.String r1 = r1.toString()
//            com.baicizhan.client.business.util.LogWrapper.m2793d(r0, r1)
//            com.baicizhan.client.business.managers.StudyManager r0 = com.baicizhan.client.business.managers.StudyManager.getInstance()
//            boolean r0 = r0.isOfflined()
//            if (r0 != 0) goto L_0x0087
//            boolean r0 = com.baicizhan.client.framework.network.NetworkUtils.isNetworkAvailable(r9)
//            if (r0 == 0) goto L_0x0087
//            r8.updateSelectedBookInfos(r9, r10)
//        L_0x0087:
//            r8.mergeAllSelectedBookInfos()
//            java.util.Map<java.lang.Integer, com.baicizhan.client.business.dataset.models.BookRecord> r0 = r8.mBooks
//            java.util.Collection r0 = r0.values()
//            com.baicizhan.client.business.dataset.helpers.BookRecordHelper.saveAllBookRecord(r9, r0)
//            return
//        L_0x0094:
//            r0 = r1
//            goto L_0x0050
//        L_0x0096:
//            r0 = r1
//            goto L_0x0050
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.managers.BookListManager.load(android.content.Context, com.baicizhan.online.bs_users.BSUsers$Client):void");
//    }
//
//    private boolean loadBookListFromServer(Context context, Client client) {
//        try {
//            if (StudyManager.getInstance().isOfflined() || !NetworkUtils.isNetworkAvailable(context)) {
//                return false;
//            }
//            LogWrapper.m2793d(TAG, "<server> loadBookListFromServer");
//            BBBookListInfo bBBookListInfo = client.get_all_books_basic_info();
//            LogWrapper.m2793d(TAG, "thrift get_all_books_basic_info " + bBBookListInfo.books_info.size());
//            ArrayMap aVar = new ArrayMap(bBBookListInfo.getBooks_infoSize());
//            for (BBBookBasicInfo bBBookBasicInfo : bBBookListInfo.getBooks_info()) {
//                BookRecord bookRecord = new BookRecord();
//                bookRecord.bookId = bBBookBasicInfo.getId();
//                bookRecord.bookName = bBBookBasicInfo.getName();
//                bookRecord.wordCount = bBBookBasicInfo.total_words_count;
//                aVar.put(Integer.valueOf(bookRecord.bookId), bookRecord);
//            }
//            Cursor perform = QueryBuilder.query(ZBOOKRESOURCE.CONTENT_URI).projection("BOOK_ID", Columns.UPDATE_LOCAL_DATA, Columns.ROADMAP_VER, Columns.ZWORD_RADIO_UPDATE_TIME).perform(context);
//            if (perform != null) {
//                perform.moveToFirst();
//                while (!perform.isAfterLast()) {
//                    int i = perform.getInt(0);
//                    BookRecord bookRecord2 = (BookRecord) aVar.get(Integer.valueOf(i));
//                    if (bookRecord2 == null) {
//                        LogWrapper.m2797w(TAG, "book miss " + i);
//                    } else {
//                        bookRecord2.localBookResVer = perform.getLong(1);
//                        bookRecord2.localRoadmapVer = perform.getLong(2);
//                        bookRecord2.localRadioResVer = perform.getLong(3);
//                    }
//                    perform.moveToNext();
//                }
//                perform.close();
//            }
//            if (bBBookListInfo.getCategories_infoSize() > 0) {
//                ArrayList arrayList = new ArrayList(bBBookListInfo.getCategories_infoSize());
//                bBBookListInfo.getCategories_info();
//                for (BBBookCategory bBBookCategory : bBBookListInfo.getCategories_info()) {
//                    BookCategory bookCategory = new BookCategory();
//                    bookCategory.setCategoryName(bBBookCategory.getCategory_name());
//                    ArrayList arrayList2 = new ArrayList(bBBookCategory.getSub_categoriesSize());
//                    for (BBSubCategory bBSubCategory : bBBookCategory.getSub_categories()) {
//                        SubCategory subCategory = new SubCategory();
//                        subCategory.setSubName(bBSubCategory.getSub_name());
//                        subCategory.setBookIds(bBSubCategory.getBook_ids());
//                        arrayList2.add(subCategory);
//                    }
//                    bookCategory.setSubCategories(arrayList2);
//                    arrayList.add(bookCategory);
//                }
//                KVHelper.setJsonBean(context, KVHelper.KEY_GLOBAL_BOOK_CATEGORY, arrayList, new TypeToken<List<BookCategory>>() {
//                }.getType(), false);
//                this.mBooks = aVar;
//                this.mBookCategory = arrayList;
//            }
//            BBCheckInfo checkInfo = StudyManager.getInstance().getCheckInfo();
//            if (checkInfo != null) {
//                KVHelper.setLong(context, KVHelper.KEY_GLOBAL_BOOK_LIST_VERSION, checkInfo.getUpdate_at_of_book_info());
//            }
//            return true;
//        } catch (Exception e) {
//            if (!(e instanceof C2120g)) {
//                LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            }
//            return false;
//        }
//    }
//
//    private boolean loadBookListFromClient(Context context) {
//        List<BookRecord> allBookRecords = BookRecordHelper.getAllBookRecords(context);
//        if (CollectionUtils.isEmpty((Collection<?>) allBookRecords) || allBookRecords.size() < 68) {
//            LogWrapper.m2797w(TAG, "get book list from client empty ");
//            return false;
//        }
//        List<BookCategory> list = (List) KVHelper.getJsonBean(context, KVHelper.KEY_GLOBAL_BOOK_CATEGORY, new TypeToken<List<BookCategory>>() {
//        }.getType(), false);
//        if (CollectionUtils.isEmpty((Collection<?>) list)) {
//            return false;
//        }
//        ArrayMap aVar = new ArrayMap(allBookRecords.size());
//        for (BookRecord bookRecord : allBookRecords) {
//            aVar.put(Integer.valueOf(bookRecord.bookId), bookRecord);
//        }
//        this.mBooks = aVar;
//        this.mBookCategory = list;
//        return true;
//    }
//
//    private void updateSelectedBookInfos(Context context, Client client) {
//        if (this.mSelectedBookInfos.size() == 0 && NetworkUtils.isNetworkAvailable(context)) {
//            try {
//                this.profiler.openFunc(TAG, "get_all_selected_books_info");
//                List<BBUserSelectedBookInfo> list = client.get_all_selected_books_info();
//                this.profiler.closeAndPrintFunc(TAG, "get_all_selected_books_info");
//                if (list != null && list.size() > 0) {
//                    for (BBUserSelectedBookInfo bBUserSelectedBookInfo : list) {
//                        this.mSelectedBookInfos.put(Integer.valueOf(bBUserSelectedBookInfo.getBook_id()), bBUserSelectedBookInfo);
//                    }
//                }
//            } catch (Exception e) {
//                if (!(e instanceof C2120g)) {
//                    LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//                }
//            }
//        }
//    }
//
//    private void mergeSelectedBookInfo(BookRecord bookRecord) {
//        BBUserSelectedBookInfo bBUserSelectedBookInfo = (BBUserSelectedBookInfo) this.mSelectedBookInfos.get(Integer.valueOf(bookRecord.bookId));
//        if (bBUserSelectedBookInfo != null) {
//            bookRecord.updateSelectedInfo(bBUserSelectedBookInfo);
//        }
//    }
//
//    private void mergeAllSelectedBookInfos() {
//        try {
//            for (BookRecord bookRecord : this.mBooks.values()) {
//                bookRecord.dueTime = 0;
//                bookRecord.finishCount = 0;
//            }
//            for (BBUserSelectedBookInfo bBUserSelectedBookInfo : this.mSelectedBookInfos.values()) {
//                BookRecord bookRecord2 = (BookRecord) this.mBooks.get(Integer.valueOf(bBUserSelectedBookInfo.getBook_id()));
//                if (bookRecord2 != null) {
//                    bookRecord2.updateSelectedInfo(bBUserSelectedBookInfo);
//                }
//            }
//        } catch (Exception e) {
//            if (!(e instanceof C2120g)) {
//                LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            }
//        }
//    }
//
//    public BookRecord lazyLoadCurrentBookRecord(Context context, Client client, int i) {
//        BookRecord bookRecord = (BookRecord) this.mBooks.get(Integer.valueOf(i));
//        if (bookRecord != null) {
//            return bookRecord;
//        }
//        this.profiler.openFunc(TAG, "getBookRecordById");
//        BookRecord bookRecordById = BookRecordHelper.getBookRecordById(context, i);
//        this.profiler.closeAndPrintFunc(TAG, "getBookRecordById");
//        if (bookRecordById != null) {
//            return bookRecordById;
//        }
//        LogWrapper.m2794e(TAG, "bookRecord null");
//        try {
//            LogWrapper.m2793d(TAG, "try load");
//            this.profiler.openFunc(TAG, "load");
//            load(context, client);
//            this.profiler.closeAndPrintFunc(TAG, "load");
//            return (BookRecord) this.mBooks.get(Integer.valueOf(i));
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            return null;
//        }
//    }
//}
