//package com.baicizhan.main.resource;
//
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.util.AuthCallback;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class TopicWaitingHall {
//    private static final String TAG = TopicWaitingHall.class.getSimpleName();
//    private AuthCallback<ProblemAsset> observer;
//    private Map<Integer, ProblemAsset> readyZone = new HashMap();
//    private AtomicInteger waiterCount = new AtomicInteger();
//    private Set<ProblemAsset> waitingZone = new HashSet();
//
//    public synchronized void clearup() {
//        this.waiterCount.set(0);
//        this.waitingZone.clear();
//        this.readyZone.clear();
//    }
//
//    public void setObserver(AuthCallback<ProblemAsset> authCallback) {
//        this.observer = authCallback;
//    }
//
//    public synchronized void notifyTopicFinish(TopicRecord topicRecord) {
//        if (topicRecord != null) {
//            Iterator it = this.waitingZone.iterator();
//            while (it.hasNext()) {
//                ProblemAsset problemAsset = (ProblemAsset) it.next();
//                if (problemAsset.addOptionRecord(topicRecord)) {
//                    if (this.observer != null) {
//                        this.observer.postProgress(problemAsset);
//                    }
//                    if (problemAsset.isComplete()) {
//                        this.readyZone.put(Integer.valueOf(problemAsset.getId()), problemAsset);
//                        if (this.observer != null) {
//                            this.observer.postSuccess(problemAsset);
//                        }
//                        it.remove();
//                    }
//                }
//            }
//        }
//    }
//
//    public synchronized void notifyTopicError(Throwable th) {
//        if (this.observer != null) {
//            this.observer.postError(th);
//        }
//    }
//
//    public synchronized void register(int i, ProblemAsset problemAsset) {
//        this.waitingZone.add(problemAsset);
//    }
//
//    public int getTotalWaiterCount() {
//        return this.waiterCount.get();
//    }
//
//    public int getReadyWaiterCount() {
//        return this.readyZone.size();
//    }
//
//    public void addWaiterCount(int i) {
//        this.waiterCount.addAndGet(i);
//    }
//
//    public void subWaiterCount(int i) {
//        this.waiterCount.addAndGet(-i);
//    }
//
//    public synchronized ProblemAsset tryCheckOut(int i) {
//        ProblemAsset problemAsset;
//        problemAsset = (ProblemAsset) this.readyZone.get(Integer.valueOf(i));
//        if (problemAsset != null) {
//            this.waiterCount.decrementAndGet();
//        }
//        return problemAsset;
//    }
//}
