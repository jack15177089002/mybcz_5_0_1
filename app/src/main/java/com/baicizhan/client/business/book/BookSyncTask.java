package com.baicizhan.client.business.book;

import com.baicizhan.client.business.BusinessAppHandler;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
import com.baicizhan.client.business.dataset.models.ScheduleRecord;
import com.baicizhan.client.framework.log.C0789L;

public class BookSyncTask {
    private BookSyncTask() {
    }

    public static Book getBook() {
        try {
//            ScheduleRecord currentSchedule = BookRecordHelper.getCurrentSchedule(BusinessAppHandler.getApp());
//            if (currentSchedule == null) {
//                return null;
//            }
//            Book book = new Book();
//            book.setId(currentSchedule.bookId);
//            return book;
        } catch (Exception e) {
            C0789L.log.warn("get book from db error", (Throwable) e);
            return null;
        }

        return null;
    }
}
