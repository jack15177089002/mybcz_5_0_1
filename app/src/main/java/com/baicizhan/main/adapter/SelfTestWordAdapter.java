//package com.baicizhan.main.adapter;
//
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentStatePagerAdapter;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.main.fragment.SelfTestWordFragment;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SelfTestWordAdapter extends FragmentStatePagerAdapter {
//    private List<TopicRecord> mList = new ArrayList();
//
//    public SelfTestWordAdapter(C0066v vVar) {
//        super(vVar);
//    }
//
//    public void setRecordList(List<TopicRecord> list) {
//        this.mList.clear();
//        this.mList.addAll(list);
//    }
//
//    public List<TopicRecord> getRecordList() {
//        return this.mList;
//    }
//
//    public void addRecord(TopicRecord topicRecord) {
//        this.mList.add(topicRecord);
//    }
//
//    public void removeRecord(TopicRecord topicRecord) {
//        Log.d("wsgfz", "before:" + this.mList);
//        if (topicRecord != null) {
//            this.mList.remove(topicRecord);
//        }
//        Log.d("wsgfz", "after" + this.mList);
//    }
//
//    public void removeRecord(int i) {
//        this.mList.remove(i);
//    }
//
//    public int getCount() {
//        return this.mList.size();
//    }
//
//    public Fragment getItem(int i) {
//        SelfTestWordFragment selfTestWordFragment = new SelfTestWordFragment();
//        selfTestWordFragment.setRecord((TopicRecord) this.mList.get(i));
//        return selfTestWordFragment;
//    }
//
//    public TopicRecord getData(int i) {
//        if (i < 0 || i >= this.mList.size()) {
//            return null;
//        }
//        return (TopicRecord) this.mList.get(i);
//    }
//}
