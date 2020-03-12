//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.EditText;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.MiscRecordHelper;
//import com.baicizhan.client.business.dataset.models.TopicBriefRecord;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask.Listener;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.main.resource.TopicDownloadTask;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.baicizhan.main.utils.RoadmapUtils;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Map;
//
//public class DebugActivity extends Activity implements OnClickListener {
//    private static final String TAG = DebugActivity.class.getSimpleName();
//    private EditText mInBox;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setContentView(R.layout.activity_debug);
//        this.mInBox = (EditText) findViewById(R.id.inbox);
//        findViewById(R.id.show_wiki).setOnClickListener(this);
//        findViewById(R.id.modify_roadmap).setOnClickListener(this);
//    }
//
//    private void showWiki() {
//        Log.d(TAG, "showWiki");
//        int i = -1;
//        String trim = this.mInBox.getText().toString().trim();
//        try {
//            i = Integer.valueOf(trim).intValue();
//        } catch (Exception e) {
//            TopicBriefRecord topicBriefRecordByWord = MiscRecordHelper.getTopicBriefRecordByWord(this, trim);
//            if (topicBriefRecordByWord != null) {
//                i = topicBriefRecordByWord.topicId;
//            }
//        }
//        if (!StudyManager.getInstance().getCurrentRoadmap().containsKey(Integer.valueOf(i))) {
//            Toast.makeText(this, "输入正确的单词或者单词id", 0).show();
//            return;
//        }
//        Toast.makeText(this, "单词id: " + i, 1).show();
//        TopicResourceManager.getInstance().downloadTopic(i, new Listener() {
//            public void onError(AbstractDownloadTask abstractDownloadTask, Throwable th) {
//                Toast.makeText(DebugActivity.this, "下载失败噜~~~", 0).show();
//            }
//
//            public void onSuccess(AbstractDownloadTask abstractDownloadTask) {
//                TopicDownloadTask topicDownloadTask = (TopicDownloadTask) abstractDownloadTask;
//                Intent intent = new Intent(DebugActivity.this, SingleWikiActivity.class);
//                intent.putExtra(SingleWikiActivity.EXTRA_TOPIC_RECORD, topicDownloadTask.getResult());
//                DebugActivity.this.startActivity(intent);
//            }
//        });
//    }
//
//    private void modifyRoadmap() {
//        ArrayList arrayList = new ArrayList();
//        try {
//            for (String valueOf : this.mInBox.getText().toString().split("[, ]+")) {
//                arrayList.add(Integer.valueOf(valueOf));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (arrayList.size() == 0) {
//            Toast.makeText(this, "请输入单词id列表，以逗号或者空格分隔", 0).show();
//            return;
//        }
//        LinkedList linkedList = new LinkedList();
//        linkedList.addAll(StudyManager.getInstance().getRoadmapOrder());
//        for (int size = arrayList.size() - 1; size >= 0; size--) {
//            int intValue = ((Integer) arrayList.get(size)).intValue();
//            int indexOf = linkedList.indexOf(Integer.valueOf(intValue));
//            if (indexOf >= 0) {
//                linkedList.remove(indexOf);
//                linkedList.add(0, Integer.valueOf(intValue));
//            }
//        }
//        StudyManager.getInstance().setRoadmapOrder(linkedList);
//        ArrayList arrayList2 = new ArrayList(linkedList.size());
//        Map currentRoadmap = StudyManager.getInstance().getCurrentRoadmap();
//        Iterator it = linkedList.iterator();
//        while (it.hasNext()) {
//            arrayList2.add(currentRoadmap.get(Integer.valueOf(((Integer) it.next()).intValue())));
//        }
//        RoadmapUtils.saveRoadmap(StudyManager.getInstance().getCurrentBookId(), arrayList2);
//        Toast.makeText(this, "修改成功", 0).show();
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.show_wiki /*2131296306*/:
//                showWiki();
//                return;
//            case R.id.modify_roadmap /*2131296307*/:
//                modifyRoadmap();
//                return;
//            default:
//                return;
//        }
//    }
//}
