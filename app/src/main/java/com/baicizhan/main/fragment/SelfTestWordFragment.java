//package com.baicizhan.main.fragment;
//
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.jiongji.andriod.card.R;
//
//public class SelfTestWordFragment extends Fragment {
//    private TopicRecord mRecord;
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        return layoutInflater.inflate(R.layout.selftest_word_item, viewGroup, false);
//    }
//
//    public void onViewCreated(View view, Bundle bundle) {
//        TextView textView = (TextView) view.findViewById(R.id.selftest_word);
//        if (this.mRecord == null) {
//            textView.setText("");
//            view.setTag(null);
//            return;
//        }
//        textView.setText(this.mRecord.word);
//        view.setTag(this.mRecord);
//    }
//
//    public TopicRecord getRecord() {
//        return this.mRecord;
//    }
//
//    public void setRecord(TopicRecord topicRecord) {
//        this.mRecord = topicRecord;
//    }
//}
