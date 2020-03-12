//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.AbsListView.LayoutParams;
//import android.widget.BaseAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.helpers.MiscRecordHelper;
//import com.baicizhan.client.business.dataset.models.NoticeFinishRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.jiongji.andriod.card.R;
//import java.util.Collections;
//import java.util.List;
//
//public class EverydayNoticeActivity extends Activity implements OnClickListener {
//    AsyncTask<Context, Integer, List<NoticeFinishRecord>> mLoadTask = new AsyncTask<Context, Integer, List<NoticeFinishRecord>>() {
//        /* access modifiers changed from: protected */
//        public List<NoticeFinishRecord> doInBackground(Context... contextArr) {
//            return MiscRecordHelper.getAllNoticeFinishRecords(EverydayNoticeActivity.this);
//        }
//
//        /* access modifiers changed from: protected */
//        public void onPostExecute(List<NoticeFinishRecord> list) {
//            super.onPostExecute(list);
//            EverydayNoticeActivity.this.mNoticeAdapter.update(list);
//        }
//    };
//    NoticeAdapter mNoticeAdapter;
//    ListView mNoticeListView;
//
//    class NoticeAdapter extends BaseAdapter {
//        private List<NoticeFinishRecord> mNoticeList = Collections.emptyList();
//
//        NoticeAdapter() {
//        }
//
//        public void update(List<NoticeFinishRecord> list) {
//            this.mNoticeList = list;
//            notifyDataSetChanged();
//        }
//
//        public int getCount() {
//            return this.mNoticeList.size();
//        }
//
//        public Object getItem(int i) {
//            return this.mNoticeList.get(i);
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            NoticeFinishRecord noticeFinishRecord = (NoticeFinishRecord) getItem(i);
//            if (view == null) {
//                if (noticeFinishRecord.person == 1) {
//                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.everyday_notice_item_left, viewGroup, false);
//                } else {
//                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.everyday_notice_item_right, viewGroup, false);
//                }
//            }
//            ((TextView) view.findViewById(R.id.notice_content)).setText(noticeFinishRecord.content);
//            return view;
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_everyday_notice);
//            findViewById(R.id.back).setOnClickListener(this);
//            findViewById(R.id.notice_setting).setOnClickListener(this);
//            this.mNoticeListView = (ListView) findViewById(R.id.notice_list);
//            View view = new View(this);
//            view.setLayoutParams(new LayoutParams(-1, DisplayUtils.dpToPx(this, 15.0f)));
//            this.mNoticeAdapter = new NoticeAdapter();
//            this.mNoticeListView.addHeaderView(view);
//            this.mNoticeListView.setAdapter(this.mNoticeAdapter);
//            this.mNoticeListView.setHeaderDividersEnabled(false);
//            this.mLoadTask.execute(new Context[0]);
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
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.back) {
//            finish();
//        } else if (id == R.id.notice_setting) {
//            startActivity(new Intent(this, EverydayNoticeSettingActivity.class));
//        }
//    }
//}
