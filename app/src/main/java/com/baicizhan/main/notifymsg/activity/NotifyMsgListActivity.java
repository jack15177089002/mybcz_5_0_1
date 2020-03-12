//package com.baicizhan.main.notifymsg.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.p004v4.widget.C0210av;
//import android.support.p004v4.widget.SwipeRefreshLayout;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.AbsListView;
//import android.widget.AbsListView.OnScrollListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.main.notifymsg.data.NotifyMsgGetter;
//import com.baicizhan.main.notifymsg.data.NotifyMsgGetter.OnNotifyMsgGetListener;
//import com.baicizhan.main.notifymsg.data.NotifyMsgRecord;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import java.lang.ref.WeakReference;
//import java.util.List;
//
//public class NotifyMsgListActivity extends Activity {
//    private static final String ARG_HAS_NEW = "has_new";
//    /* access modifiers changed from: private */
//    public MessageAdapter mAdapter;
//    /* access modifiers changed from: private */
//    public DispRefreshingRun mDispRefreshingRun = new DispRefreshingRun();
//    /* access modifiers changed from: private */
//    public boolean mHasNew = false;
//    private ListView mListView;
//    /* access modifiers changed from: private */
//    public NotifyMsgGetter mMessageGetter;
//    /* access modifiers changed from: private */
//    public List<NotifyMsgRecord> mMessages;
//    private MessageGetCallback mMsgCallback;
//    /* access modifiers changed from: private */
//    public SwipeRefreshLayout mSwipeRefreshLayout;
//    /* access modifiers changed from: private */
//    public boolean mUpdated = false;
//
//    class DispRefreshingRun implements Runnable {
//        private DispRefreshingRun() {
//        }
//
//        public void run() {
//            NotifyMsgListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
//        }
//    }
//
//    class MessageAdapter extends BaseAdapter {
//        private MessageAdapter() {
//        }
//
//        public int getCount() {
//            if (NotifyMsgListActivity.this.mMessages != null) {
//                return NotifyMsgListActivity.this.mMessages.size();
//            }
//            return 0;
//        }
//
//        public NotifyMsgRecord getItem(int i) {
//            if (NotifyMsgListActivity.this.mMessages != null) {
//                return (NotifyMsgRecord) NotifyMsgListActivity.this.mMessages.get(i);
//            }
//            return null;
//        }
//
//        public long getItemId(int i) {
//            return (long) i;
//        }
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            ViewHolder viewHolder;
//            if (view == null) {
//                view = NotifyMsgListActivity.this.getLayoutInflater().inflate(R.layout.notify_message_list_item, null);
//                ViewHolder viewHolder2 = new ViewHolder();
//                viewHolder2.avatar = (ImageView) view.findViewById(R.id.notify_msg_avatar);
//                viewHolder2.title = (TextView) view.findViewById(R.id.notify_msg_title);
//                viewHolder2.subtitle = (TextView) view.findViewById(R.id.notify_msg_subtitle);
//                view.setTag(viewHolder2);
//                viewHolder = viewHolder2;
//            } else {
//                viewHolder = (ViewHolder) view.getTag();
//            }
//            bindItem(viewHolder, getItem(i));
//            return view;
//        }
//
//        private void bindItem(ViewHolder viewHolder, NotifyMsgRecord notifyMsgRecord) {
//            int i;
//            switch (notifyMsgRecord.getType()) {
//                case 2:
//                    i = R.drawable.activity_normal_default;
//                    break;
//                case 3:
//                    i = R.drawable.baoguo_normal_default;
//                    break;
//                default:
//                    i = R.drawable.system_normal_default;
//                    break;
//            }
//            String imgUrl = notifyMsgRecord.getImgUrl();
//            if (TextUtils.isEmpty(imgUrl)) {
//                imgUrl = "null";
//            }
//            Picasso.with((Context) NotifyMsgListActivity.this).load(imgUrl).placeholder(i).into(viewHolder.avatar, (Callback) null);
//            if (notifyMsgRecord.getRead() == 0) {
//                viewHolder.title.setTextColor(ThemeUtil.getThemeColorWithAttr(NotifyMsgListActivity.this, R.attr.color_message_title));
//            } else {
//                viewHolder.title.setTextColor(ThemeUtil.getThemeColorWithAttr(NotifyMsgListActivity.this, R.attr.color_message_read));
//            }
//            viewHolder.title.setText(notifyMsgRecord.getTitle());
//            viewHolder.subtitle.setText(notifyMsgRecord.getTitleDesc());
//        }
//    }
//
//    class MessageGetCallback implements OnNotifyMsgGetListener {
//        private final WeakReference<NotifyMsgListActivity> mActivity;
//
//        private MessageGetCallback(NotifyMsgListActivity notifyMsgListActivity) {
//            this.mActivity = new WeakReference<>(notifyMsgListActivity);
//        }
//
//        public void onGetNotifyMsg(List<NotifyMsgRecord> list, int i, boolean z, int i2) {
//            NotifyMsgListActivity notifyMsgListActivity = (NotifyMsgListActivity) this.mActivity.get();
//            if (notifyMsgListActivity != null) {
//                switch (i2) {
//                    case -3:
//                    case -2:
//                        notifyMsgListActivity.loadFailed(R.string.notify_msg_load_no_data);
//                        return;
//                    case -1:
//                        notifyMsgListActivity.loadFailed(R.string.notify_msg_load_no_networks);
//                        return;
//                    default:
//                        notifyMsgListActivity.mMessages = list;
//                        notifyMsgListActivity.mAdapter.notifyDataSetChanged();
//                        if (i2 == 0 && i != 3) {
//                            if (!notifyMsgListActivity.mHasNew || z) {
//                                notifyMsgListActivity.mSwipeRefreshLayout.removeCallbacks(notifyMsgListActivity.mDispRefreshingRun);
//                                notifyMsgListActivity.mSwipeRefreshLayout.setRefreshing(false);
//                            } else {
//                                notifyMsgListActivity.mMessageGetter.getNotifyMsg(1, 0);
//                            }
//                            notifyMsgListActivity.mHasNew = false;
//                        } else if (i2 != 0) {
//                            notifyMsgListActivity.mHasNew = false;
//                            notifyMsgListActivity.mSwipeRefreshLayout.removeCallbacks(notifyMsgListActivity.mDispRefreshingRun);
//                            notifyMsgListActivity.mSwipeRefreshLayout.setRefreshing(false);
//                        }
//                        if (!notifyMsgListActivity.mUpdated) {
//                            notifyMsgListActivity.mUpdated = true;
//                            notifyMsgListActivity.mMessageGetter.getNotifyMsg(3, 0);
//                            return;
//                        }
//                        return;
//                }
//            }
//        }
//    }
//
//    class ViewHolder {
//        /* access modifiers changed from: private */
//        public ImageView avatar;
//        /* access modifiers changed from: private */
//        public TextView subtitle;
//        /* access modifiers changed from: private */
//        public TextView title;
//
//        private ViewHolder() {
//        }
//    }
//
//    public static void start(Context context, boolean z) {
//        Intent intent = new Intent(context, NotifyMsgListActivity.class);
//        intent.putExtra(ARG_HAS_NEW, z);
//        context.startActivity(intent);
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView(R.layout.notify_message_list);
//        initViews();
//    }
//
//    public void onResume() {
//        super.onResume();
//        int i = this.mMessages != null ? this.mMessages.size() : 0;
//        if (this.mHasNew) {
//            this.mSwipeRefreshLayout.post(this.mDispRefreshingRun);
//        }
//        this.mMessageGetter.getNotifyMsg(0, i);
//    }
//
//    private void initViews() {
//        findViewById(R.id.notify_msg_back).setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                NotifyMsgListActivity.this.finish();
//            }
//        });
//        this.mListView = (ListView) findViewById(R.id.notify_msg_list);
//        this.mAdapter = new MessageAdapter();
//        this.mListView.setAdapter(this.mAdapter);
//        this.mListView.setOnScrollListener(new OnScrollListener() {
//            public void onScrollStateChanged(AbsListView absListView, int i) {
//                int i2;
//                if (i == 0) {
//                    if (absListView.getLastVisiblePosition() + 1 == ((ListAdapter) absListView.getAdapter()).getCount()) {
//                        NotifyMsgListActivity.this.mMessageGetter.getNotifyMsg(0, NotifyMsgListActivity.this.mMessages != null ? NotifyMsgListActivity.this.mMessages.size() : 0);
//                    }
//                } else if (2 == i) {
//                    if (NotifyMsgListActivity.this.mMessages != null) {
//                        i2 = NotifyMsgListActivity.this.mMessages.size();
//                    } else {
//                        i2 = 0;
//                    }
//                    NotifyMsgListActivity.this.mMessageGetter.getNotifyMsg(0, i2);
//                }
//            }
//
//            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
//            }
//        });
//        this.mMsgCallback = new MessageGetCallback();
//        this.mMessageGetter = NotifyMsgGetter.born(this).setListener(this.mMsgCallback);
//        this.mListView.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
//                NotifyMsgActivity.start(NotifyMsgListActivity.this, NotifyMsgListActivity.this.mAdapter.getItem(i), StudyManager.getInstance().getCurrentUser().getToken());
//            }
//        });
//        this.mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.notify_msg_list_swipe);
//        this.mSwipeRefreshLayout.setColorSchemeColors(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_message_head));
//        this.mSwipeRefreshLayout.setOnRefreshListener(new C0210av() {
//            public void onRefresh() {
//                NotifyMsgListActivity.this.mMessageGetter.getNotifyMsg(1, 0);
//            }
//        });
//        this.mHasNew = getIntent().getBooleanExtra(ARG_HAS_NEW, this.mHasNew);
//    }
//
//    /* access modifiers changed from: private */
//    public void loadFailed(int i) {
//        Toast.makeText(this, i, 0).show();
//        this.mSwipeRefreshLayout.removeCallbacks(this.mDispRefreshingRun);
//        this.mSwipeRefreshLayout.setRefreshing(false);
//    }
//}
