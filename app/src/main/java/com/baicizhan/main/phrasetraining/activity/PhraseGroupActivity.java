//package com.baicizhan.main.phrasetraining.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.p008v7.widget.C0244al;
//import android.support.p008v7.widget.C0266bg;
//import android.support.p008v7.widget.C0289v;
//import android.support.p008v7.widget.GridLayoutManager;
//import android.support.p008v7.widget.RecyclerView;
//import android.util.SparseArray;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.StoragePathDetector;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.main.phrasetraining.data.IDownloadController;
//import com.baicizhan.main.phrasetraining.data.bean.PhraseGroup;
//import com.baicizhan.main.phrasetraining.data.bean.PhraseGroup.Phrase;
//import com.baicizhan.main.phrasetraining.data.load.PhraseGroupLoader;
//import com.baicizhan.main.phrasetraining.data.load.PhraseGroupLoader.Builder;
//import com.baicizhan.main.phrasetraining.data.load.PhraseGroupLoader.OnPhraseGroupLoadListener;
//import com.baicizhan.main.phrasetraining.view.PhraseGroupHeader;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PhraseGroupActivity extends Activity implements OnPhraseGroupLoadListener {
//    /* access modifiers changed from: private */
//    public PhraseGroupAdapter mAdapter;
//    /* access modifiers changed from: private */
//    public List<PhraseGroup> mDatas;
//    private DelayLoadProgressRun mDelayLoadProgressRun;
//    /* access modifiers changed from: private */
//    public WeakReference<IDownloadController> mDownloadCtrl;
//    private RecyclerView mGroupGrid;
//    /* access modifiers changed from: private */
//    public ArrayList<Integer> mGroupIds;
//    private Handler mHandler = new Handler();
//    private View mHome;
//    /* access modifiers changed from: private */
//    public ImageView mLoadProgress;
//    private PhraseGroupLoader mLoader;
//    /* access modifiers changed from: private */
//    public SparseArray<Boolean> mStudyTags;
//
//    class DelayLoadProgressRun implements Runnable {
//        final WeakReference<PhraseGroupActivity> mActivity;
//
//        DelayLoadProgressRun(PhraseGroupActivity phraseGroupActivity) {
//            this.mActivity = new WeakReference<>(phraseGroupActivity);
//        }
//
//        public void run() {
//            PhraseGroupActivity phraseGroupActivity = (PhraseGroupActivity) this.mActivity.get();
//            if (phraseGroupActivity != null) {
//                phraseGroupActivity.mLoadProgress.setVisibility(0);
//            }
//        }
//    }
//
//    class PhraseGroupAdapter extends C0244al<PhraseGroupViewHolder> {
//        private static final int ITEM_VIEW_TYPE_HEADER = 0;
//        private static final int ITEM_VIEW_TYPE_ITEM_LEFT = 1;
//        private static final int ITEM_VIEW_TYPE_ITEM_RIGHT = 2;
//
//        private PhraseGroupAdapter() {
//        }
//
//        public int getItemCount() {
//            return PhraseGroupActivity.this.mDatas.size() + 1;
//        }
//
//        public void onBindViewHolder(PhraseGroupViewHolder phraseGroupViewHolder, final int i) {
//            if (!isHeader(i)) {
//                phraseGroupViewHolder.mGroupIndex.setText(PhraseGroupActivity.this.getString(R.string.phrase_group_course, new Object[]{String.format("%02d", new Object[]{Integer.valueOf(i)})}));
//                int i2 = 0;
//                for (Phrase word : ((PhraseGroup) PhraseGroupActivity.this.mDatas.get(i - 1)).getPhrases()) {
//                    phraseGroupViewHolder.mGroupPhrases[i2].setText(word.getWord());
//                    i2++;
//                }
//                while (i2 < phraseGroupViewHolder.mGroupPhrases.length) {
//                    phraseGroupViewHolder.mGroupPhrases[i2].setText("");
//                    i2++;
//                }
//                phraseGroupViewHolder.mCard.setOnClickListener(new OnClickListener() {
//                    public void onClick(View view) {
//                        PhraseTrainingActivity.start(PhraseGroupActivity.this, PhraseGroupActivity.this.mGroupIds, i - 1);
//                    }
//                });
//                if (((Boolean) PhraseGroupActivity.this.mStudyTags.get(((PhraseGroup) PhraseGroupActivity.this.mDatas.get(i - 1)).getGroupId())).booleanValue()) {
//                    phraseGroupViewHolder.mLearnt.setVisibility(0);
//                } else {
//                    phraseGroupViewHolder.mLearnt.setVisibility(8);
//                }
//            }
//        }
//
//        public PhraseGroupViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//            if (i == 0) {
//                ArrayList arrayList = new ArrayList(PhraseGroupActivity.this.mDatas.size());
//                for (PhraseGroup groupId : PhraseGroupActivity.this.mDatas) {
//                    arrayList.add(Integer.valueOf(groupId.getGroupId()));
//                }
//                PhraseGroupHeader phraseGroupHeader = (PhraseGroupHeader) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.phrase_group_header, viewGroup, false);
//                phraseGroupHeader.init(arrayList);
//                PhraseGroupActivity.this.mDownloadCtrl = new WeakReference(phraseGroupHeader);
//                return new PhraseGroupViewHolder(phraseGroupHeader);
//            } else if (1 == i) {
//                return new PhraseGroupViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.phrase_group_card_left, viewGroup, false));
//            } else {
//                return new PhraseGroupViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.phrase_group_card_right, viewGroup, false));
//            }
//        }
//
//        public int getItemViewType(int i) {
//            if (isHeader(i)) {
//                return 0;
//            }
//            if (i % 2 == 0) {
//                return 2;
//            }
//            return 1;
//        }
//
//        public boolean isHeader(int i) {
//            return i == 0;
//        }
//    }
//
//    class PhraseGroupViewHolder extends C0266bg {
//        private static final int MAX_PHRASES_PER_GROUP = 8;
//        /* access modifiers changed from: private */
//        public View mCard;
//        /* access modifiers changed from: private */
//        public TextView mGroupIndex;
//        /* access modifiers changed from: private */
//        public TextView[] mGroupPhrases;
//        /* access modifiers changed from: private */
//        public View mLearnt;
//
//        public PhraseGroupViewHolder(View view) {
//            super(view);
//            if (!(view instanceof PhraseGroupHeader)) {
//                this.mCard = view.findViewById(R.id.phrase_group_card);
//                ThemeResUtil.setCardBg(view.getContext(), this.mCard);
//                this.mGroupIndex = (TextView) view.findViewById(R.id.phrase_group_index);
//                ThemeResUtil.setProgress(view.getContext(), this.mGroupIndex);
//                this.mGroupPhrases = new TextView[8];
//                for (int i = 0; i < 8; i++) {
//                    this.mGroupPhrases[i] = (TextView) view.findViewById(PhraseGroupActivity.this.getResources().getIdentifier("phrase_group_phrase_" + i, Columns.f2234ID, StoragePathDetector.PACKAGE_NAME));
//                }
//                this.mLearnt = view.findViewById(R.id.phrase_group_learnt);
//            }
//        }
//    }
//
//    public static void start(Context context) {
//        context.startActivity(new Intent(context, PhraseGroupActivity.class));
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView(R.layout.activity_phrase_training_group);
//        initViews();
//    }
//
//    public void onStart() {
//        super.onStart();
//        this.mLoader.load();
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
//    public void onDestroy() {
//        super.onDestroy();
//        if (this.mDownloadCtrl != null) {
//            IDownloadController iDownloadController = (IDownloadController) this.mDownloadCtrl.get();
//            if (iDownloadController != null) {
//                iDownloadController.cancel();
//            }
//        }
//    }
//
//    private void initViews() {
//        this.mHome = findViewById(R.id.phrase_group_home);
//        this.mHome.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                PhraseGroupActivity.this.finish();
//            }
//        });
//        this.mGroupGrid = (RecyclerView) findViewById(R.id.phrase_group_grid);
//        this.mGroupGrid.setHasFixedSize(true);
//        this.mGroupGrid.setLayoutManager(new GridLayoutManager());
//        this.mGroupGrid.setVisibility(8);
//        this.mLoadProgress = (ImageView) findViewById(R.id.phrase_group_load_progress);
//        this.mDelayLoadProgressRun = new DelayLoadProgressRun(this);
//        this.mHandler.postDelayed(this.mDelayLoadProgressRun, 500);
//        this.mLoader = new Builder().setAssetManager(getAssets()).setCallback(this).build();
//    }
//
//    public void onLoaded(boolean z, List<PhraseGroup> list, SparseArray<Boolean> sparseArray) {
//        this.mHandler.removeCallbacks(this.mDelayLoadProgressRun);
//        if (this.mLoadProgress.getVisibility() == 0) {
//            this.mLoadProgress.setVisibility(8);
//            this.mLoadProgress.startAnimation(AnimationUtils.loadAnimation(this, 17432577));
//        }
//        if (this.mGroupGrid.getVisibility() != 0) {
//            this.mGroupGrid.setVisibility(0);
//            this.mGroupGrid.startAnimation(AnimationUtils.loadAnimation(this, 17432576));
//        }
//        if (!z) {
//            Toast.makeText(this, R.string.phrase_training_load_failed, 0).show();
//            return;
//        }
//        this.mDatas = list;
//        this.mStudyTags = sparseArray;
//        this.mGroupIds = new ArrayList<>(this.mDatas.size());
//        for (PhraseGroup groupId : this.mDatas) {
//            this.mGroupIds.add(Integer.valueOf(groupId.getGroupId()));
//        }
//        if (this.mAdapter == null) {
//            this.mAdapter = new PhraseGroupAdapter();
//            final GridLayoutManager sVar = new GridLayoutManager();
//            sVar.f894g = new C0289v() {
//                public int getSpanSize(int i) {
//                    if (PhraseGroupActivity.this.mAdapter.isHeader(i)) {
//                        return sVar.f889b;
//                    }
//                    return 1;
//                }
//            };
//            this.mGroupGrid.setLayoutManager(sVar);
//            this.mGroupGrid.setAdapter(this.mAdapter);
//            return;
//        }
//        this.mAdapter.notifyDataSetChanged();
//    }
//}
