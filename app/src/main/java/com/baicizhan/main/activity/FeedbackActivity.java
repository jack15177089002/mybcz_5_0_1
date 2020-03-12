//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.TextView.OnEditorActionListener;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.wordtesting.activity.VocabStatsActivity;
//import com.baicizhan.main.adapter.FeedbackAdapter;
//import com.baicizhan.main.adapter.FeedbackAdapter.RetryEvent;
//import com.jiongji.andriod.card.R;
//import com.umeng.p094b.FeedbackAgent;
//import com.umeng.p094b.SyncListener;
//import com.umeng.p094b.p095a.C2036h;
//import com.umeng.p094b.p095a.C2037k;
//import com.umeng.p094b.p095a.Conversation;
//import com.umeng.p094b.p095a.Reply;
//import com.umeng.p094b.p095a.Store;
//import com.umeng.p094b.p096b.FbClient;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import p000a.p001a.p002a.EventBus;
//
//public class FeedbackActivity extends Activity implements OnClickListener {
//    private FeedbackAdapter mAdapter;
//    /* access modifiers changed from: private */
//    public FeedbackAgent mAgent;
//    private ListView mContentList;
//    private Conversation mConversation;
//    /* access modifiers changed from: private */
//    public EditText mInputEdit;
//    private String mUserAvatar = "";
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_feedback);
//            init();
//        }
//    }
//
//    private void init() {
//        initAgent();
//        ImageView imageView = (ImageView) findViewById(R.id.back);
//        this.mContentList = (ListView) findViewById(R.id.feedback_content_list);
//        this.mInputEdit = (EditText) findViewById(R.id.feedback_edit);
//        Button button = (Button) findViewById(R.id.feedback_sendBtn);
//        this.mInputEdit.setOnEditorActionListener(new OnEditorActionListener() {
//            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                FeedbackActivity.this.mInputEdit.append("\n");
//                if (i == 4) {
//                    FeedbackActivity.this.sendMessage();
//                }
//                return true;
//            }
//        });
//        ThemeResUtil.setBackgroundShape(this, this.mInputEdit, R.attr.color_comment_input, 4.0f);
//        ThemeResUtil.setBackgroundShape((Context) this, (View) button, (int) R.attr.color_button_mail_login, (int) R.attr.color_progress, 4.0f);
//        imageView.setOnClickListener(this);
//        button.setOnClickListener(this);
//        this.mAdapter = new FeedbackAdapter(this, this.mUserAvatar);
//        this.mContentList.setAdapter(this.mAdapter);
//        this.mContentList.setDividerHeight(0);
//        syncMsgList();
//    }
//
//    private void initAgent() {
//        this.mAgent = new FeedbackAgent(this);
//        UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//        if (currentUser != null) {
//            if (!TextUtils.isEmpty(currentUser.getImage())) {
//                this.mUserAvatar = currentUser.getImage();
//            }
//            C2037k a = this.mAgent.f5464b.mo18289a();
//            Map<String, String> map = a.f5503d;
//            if (map == null) {
//                map = new HashMap<>();
//            }
//            map.put("类型", currentUser.getVerboseLoginType());
//            map.put("邮箱", getUserEmail(currentUser));
//            a.f5503d = map;
//            this.mAgent.f5464b.f5497d.edit().putString(VocabStatsActivity.EXTRA_USER, a.mo18294a().toString()).putLong("last_update_at", System.currentTimeMillis()).apply();
//            new Thread(new Runnable() {
//                public void run() {
//                    FeedbackAgent access$200 = FeedbackActivity.this.mAgent;
//                    new FbClient(access$200.f5463a).mo18300a(Store.m5180a(access$200.f5463a).mo18289a().mo18294a());
//                }
//            }).start();
//        }
//        this.mConversation = this.mAgent.mo18273a();
//        this.mConversation.f5468c = new C2036h() {
//            public void onChange() {
//                FeedbackActivity.this.refreshList();
//            }
//        };
//    }
//
//    private static String getUserEmail(UserRecord userRecord) {
//        String str = null;
//        if (userRecord != null) {
//            str = userRecord.getEmail();
//        }
//        if (TextUtils.isEmpty(str)) {
//            return Settings.getString(Settings.PREF_USER_EMAIL);
//        }
//        return str;
//    }
//
//    /* access modifiers changed from: private */
//    public void refreshList() {
//        if (this.mContentList != null && this.mAdapter != null) {
//            this.mAdapter.setMsgList(this.mConversation.f5466a);
//            this.mAdapter.notifyDataSetChanged();
//            this.mContentList.setSelection(this.mAdapter.getCount() - 1);
//            int count = this.mAdapter.getCount();
//            if (count > Settings.getInt(Settings.PREF_FEEDBACK_COUNT)) {
//                Settings.putInt(Settings.PREF_FEEDBACK_COUNT, count);
//            }
//        }
//    }
//
//    private void syncMsgList() {
//        this.mConversation.mo18276a((SyncListener) null);
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.back /*2131296287*/:
//                finish();
//                return;
//            case R.id.feedback_sendBtn /*2131296330*/:
//                sendMessage();
//                return;
//            default:
//                return;
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void sendMessage() {
//        Reply iVar;
//        String obj = this.mInputEdit.getText().toString();
//        if (obj.trim().length() > 0) {
//            this.mInputEdit.getEditableText().clear();
//            Conversation aVar = this.mConversation;
//            String b = Conversation.m5169b();
//            String str = "text_reply";
//            if (aVar.f5467b || aVar.f5466a.size() > 0) {
//                iVar = new Reply(obj, b, "user_reply", new Date().getTime(), str, -1.0f);
//            } else {
//                iVar = new Reply(obj, b, "new_feedback", new Date().getTime(), str, -1.0f);
//                aVar.f5467b = true;
//            }
//            iVar.f5492g = "will_sent";
//            aVar.mo18275a(iVar);
//            refreshList();
//            syncMsgList();
//            return;
//        }
//        Toast.makeText(this, R.string.feedback_send_empty, 0).show();
//    }
//
//    public void onEventMainThread(RetryEvent retryEvent) {
//        syncMsgList();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//        EventBus.m0a().mo5a((Object) this);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//        EventBus.m0a().mo8b((Object) this);
//    }
//}
