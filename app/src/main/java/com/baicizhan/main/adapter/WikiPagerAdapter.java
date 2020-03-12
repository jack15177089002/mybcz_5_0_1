//package com.baicizhan.main.adapter;
//
//import androidx.fragment.app.FragmentManager;//import android.support.p004v4.app.C0066v;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentStatePagerAdapter;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.main.fragment.WikiFragment;
//import com.baicizhan.main.fragment.WikiFragment.WikiListener;
//import com.baicizhan.main.resource.TopicResourceManager;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class WikiPagerAdapter extends FragmentStatePagerAdapter {
//    private static final String TAG = WikiPagerAdapter.class.getSimpleName();
//    private Set<WeakReference<WikiFragment>> mAllFragments = new HashSet();
//    List<WikiEntry> mEntries = Collections.emptyList();
//    C0066v mFragmentManager;
//    WikiListener mListener;
//    private int mStyle;
//
//    public class WikiEntry {
//        public int patternType;
//        public int topicId;
//
//        public WikiEntry(int i, int i2) {
//            this.topicId = i;
//            this.patternType = i2;
//        }
//    }
//
//    public WikiPagerAdapter(C0066v vVar, WikiListener wikiListener, List<WikiEntry> list) {
//        super(vVar);
//        this.mListener = wikiListener;
//        this.mFragmentManager = vVar;
//        this.mEntries = new ArrayList();
//        this.mEntries.addAll(list);
//    }
//
//    public void setStyle(int i) {
//        this.mStyle = i;
//    }
//
//    public Fragment getItem(int i) {
//        WikiEntry wikiEntry = (WikiEntry) this.mEntries.get(i);
//        TopicRecord integratedTopicRecord = TopicResourceManager.getInstance().getIntegratedTopicRecord(wikiEntry.topicId);
//        if (integratedTopicRecord == null) {
//            integratedTopicRecord = TopicResourceManager.getInstance().getExistTopicRecord(wikiEntry.topicId);
//            if (integratedTopicRecord == null) {
//                LogWrapper.m2794e(TAG, "WikiFragment topic null: " + wikiEntry.topicId);
//            }
//        }
//        WikiFragment instance = WikiFragment.getInstance(integratedTopicRecord, this.mStyle, wikiEntry.patternType);
//        instance.setWikiListener(this.mListener);
//        this.mAllFragments.add(new WeakReference(instance));
//        return instance;
//    }
//
//    public int getCount() {
//        return this.mEntries.size();
//    }
//
//    public void stopMedia() {
//        for (WeakReference weakReference : this.mAllFragments) {
//            WikiFragment wikiFragment = (WikiFragment) weakReference.get();
//            if (wikiFragment != null) {
//                wikiFragment.stopMedia();
//            }
//        }
//    }
//}
