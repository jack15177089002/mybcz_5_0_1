//package com.baicizhan.main.activity;
//
//import android.app.Dialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.res.ColorStateList;
//import android.graphics.Canvas;
//import android.graphics.drawable.GradientDrawable;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.text.TextUtils;
//import android.text.style.AbsoluteSizeSpan;
//import android.text.style.TextAppearanceSpan;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewTreeObserver.OnPreDrawListener;
//import android.view.animation.TranslateAnimation;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.dataset.models.OfflineStateRecord;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.download_service.DownloadService;
//import com.baicizhan.client.business.event.BEvents.FeedbackNewEvent;
//import com.baicizhan.client.business.event.BEvents.FriendTabRedDotEvent;
//import com.baicizhan.client.business.logoload.LogoPagePreloadService;
//import com.baicizhan.client.business.managers.AdManager;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.CrashManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.thrift.ThriftRequest.Priority;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.LocationUtils;
//import com.baicizhan.client.business.util.LocationUtils.LocationInfo;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.business.util.SimpleSpannableBuilder;
//import com.baicizhan.client.business.util.StorageUtils;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.business.widget.RoundedButton;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.log.LSwitcher;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.wordtesting.util.Constants;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.learning_strategy.iface.SequenceStrategy;
//import com.baicizhan.main.activity.SchedulePrepareRequest.PrepareException;
//import com.baicizhan.main.auth.WeixinLogin;
//import com.baicizhan.main.customview.LeftSlidingMenuView;
//import com.baicizhan.main.customview.MainBottomTab;
//import com.baicizhan.main.customview.MainReviewGuider;
//import com.baicizhan.main.customview.OfflineDownloadView;
//import com.baicizhan.main.fmtv.FmTvEnter;
//import com.baicizhan.main.notifymsg.activity.NotifyMsgListActivity;
//import com.baicizhan.main.notifymsg.data.NotifyMsgGetter;
//import com.baicizhan.main.notifymsg.data.NotifyMsgGetter.OnNotifyMsgGetListener;
//import com.baicizhan.main.notifymsg.data.NotifyMsgRecord;
//import com.baicizhan.main.phrasetraining.activity.PhraseGroupActivity;
//import com.baicizhan.main.plusreview.activity.PlusReviewEnter;
//import com.baicizhan.main.resource.OfflineResourceRepo;
//import com.baicizhan.main.resource.OfflineResourceRepo.DLState;
//import com.baicizhan.main.resource.OfflineResourceRepo.OfflineResourceListener;
//import com.baicizhan.main.resource.OfflineResourceRepo.RepoState;
//import com.baicizhan.main.resource.TopicResourceManager;
//import com.baicizhan.main.stats.appscan.APPScaner;
//import com.baicizhan.main.stats.study.StudyStats;
//import com.baicizhan.main.upgrade.UpgradeManager;
//import com.baicizhan.main.utils.BczDialogRecycler;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.main.utils.GoStoreUtil;
//import com.baicizhan.main.utils.GuideFlags;
//import com.baicizhan.main.utils.MainEvents.UploadClickEvent;
//import com.baicizhan.main.utils.MainEvents.UploadStatusEvent;
//import com.baicizhan.main.utils.NoticeManager;
//import com.baicizhan.online.bs_users.BBUserExtInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jeremyfeinstein.slidingmenu.lib.C1644m;
//import com.jeremyfeinstein.slidingmenu.lib.C1645n;
//import com.jeremyfeinstein.slidingmenu.lib.C1647p;
//import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
//import com.jeremyfeinstein.slidingmenu.lib.p058a.SlidingFragmentActivity;
//import com.jiongji.andriod.card.R;
//import com.umeng.p094b.FeedbackAgent;
//import com.umeng.p094b.SyncListener;
//import com.umeng.p094b.p095a.Conversation;
//import com.umeng.p094b.p095a.Reply;
//import com.umeng.update.UmengUpdateAgent;
//import java.lang.ref.WeakReference;
//import java.util.List;
//import java.util.Locale;
//import java.util.concurrent.TimeUnit;
//import org.p100a.p101a.p107f.C2120g;
//import p000a.p001a.p002a.EventBus;
//
//public class MainTabActivity extends SlidingFragmentActivity implements OnClickListener {
//    private static final int DIALOG_ID_EXIT = 4;
//    private static final int DIALOG_ID_FORCE_SELECT_SCHEDULE = 1;
//    private static final int DIALOG_ID_INSUFFIENT_SPACE = 3;
//    private static final int DIALOG_ID_MOBILE_DOWNLOAD = 6;
//    private static final int DIALOG_ID_NETWORK_INVALID = 5;
//    private static final int DIALOG_ID_OFFLINE_DOWNLOAD = 7;
//    private static final int DIALOG_ID_TOPIC_RES_INCOMPLETE = 2;
//    private static final int DIALOG_ID_WANT_MORE = 8;
//    public static final int REQUEST_FOR_MENU = 1;
//    public static final int REQUEST_FOR_SCHEDULE_MANAGEMENT = 4;
//    public static final int REQUEST_FOR_SETTINGS = 2;
//    public static final int REQUEST_FOR_TEST = 3;
//    public static final int RESULT_FINISH_PARENT = 2;
//    public static final int RESULT_RELOAD_THEME = 3;
//    /* access modifiers changed from: private */
//    public static final String TAG = MainTabActivity.class.getSimpleName();
//    private static final long USER_INFO_REFRESH_TIMEOUT = TimeUnit.MILLISECONDS.convert(30, TimeUnit.MINUTES);
//    private boolean isResumed;
//    /* access modifiers changed from: private */
//    public boolean isUploading = false;
//    private TextView mBookName;
//    /* access modifiers changed from: private */
//    public MainBottomTab mBottomTab;
//    private View mCelebrateButton;
//    private int mCurrentThemeId;
//    private TextView mDailyNewCount;
//    /* access modifiers changed from: private */
//    public BczDialogRecycler mDialogRecycler = new BczDialogRecycler();
//    private View mFinishButtons;
//    /* access modifiers changed from: private */
//    public ImageView mGotoNotifyMsg;
//    private Handler mHandler = new Handler(Looper.getMainLooper());
//    /* access modifiers changed from: private */
//    public boolean mHaveNewNotify = false;
//    private TextView mInstruction;
//    /* access modifiers changed from: private */
//    public LeftSlidingMenuView mLeftSlidingMenu;
//    /* access modifiers changed from: private */
//    public LocationInfo mLocationInfo;
//    ThriftRequest<Client, Integer> mLowPriorityRequest = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//        /* access modifiers changed from: protected */
//        public Integer doInBackground(Client client) {
//            int i;
//            NoticeManager.getsInstance().update(MainTabActivity.this, client);
//            AdManager.getInstance().init(client);
//            UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//            BBUserExtInfo bBUserExtInfo = new BBUserExtInfo();
//            bBUserExtInfo.setAvatar(currentUser.getImage());
//            if (MainTabActivity.this.mLocationInfo != null) {
//                bBUserExtInfo.setProvince(MainTabActivity.this.mLocationInfo.province);
//                bBUserExtInfo.setCity(MainTabActivity.this.mLocationInfo.city);
//                bBUserExtInfo.setDistrict(MainTabActivity.this.mLocationInfo.district);
//                bBUserExtInfo.setLatitude(MainTabActivity.this.mLocationInfo.latitude);
//                bBUserExtInfo.setLongitude(MainTabActivity.this.mLocationInfo.longitude);
//            }
//            if (PropertyHelper.getBoolean("portrait_mode")) {
//                i = 1;
//            } else {
//                i = 0;
//            }
//            bBUserExtInfo.setScreen_mod(i);
//            client.save_user_ext_info(bBUserExtInfo);
//            return Integer.valueOf(0);
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Exception exc) {
//            if (!(exc instanceof C2120g)) {
//                LogWrapper.m2794e(MainTabActivity.TAG, Log.getStackTraceString(exc));
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public void onResult(Integer num) {
//        }
//    };
//    private boolean mLowPriorityRequestProcessed = false;
//    /* access modifiers changed from: private */
//    public MainReviewGuider mMainReviewGuider;
//    private NotifyMsgGetter mNotifyMsgGetter;
//    private NotifyPullCallback mNotifyRefreshCallback;
//    /* access modifiers changed from: private */
//    public boolean mOfflineDownloadHinted = false;
//    private OfflineDownloadView mOfflineDownloadView;
//    private RoundedButton mPhraseTraining;
//    private AudioPlayer mPlayer;
//    private boolean mPopupDisplayed = false;
//    /* access modifiers changed from: private */
//    public TextView mPopupMessage;
//    private Handler mPrepareHandler = new PrepareHandler(this);
//    ThriftRequest<?, ?> mPrepareRequest;
//    private BczLoadingDialog mProgressDialog;
//    private TextView mRemainDays;
//    private ImageView mReviewButton;
//    private ProgressBar mScheduleProgressBar;
//    private TextView mScheduleProgressText;
//    private ImageView mStartStudyButton;
//    private StudyManager mStudyManager;
//    private C1644m mTransformer = new C1644m() {
//        public void transformCanvas(Canvas canvas, float f) {
//            float f2 = (float) ((((double) f) * 0.25d) + 0.75d);
//            canvas.scale(f2, f2, 0.0f, (float) (canvas.getHeight() / 2));
//        }
//    };
//    private UpgradeManager mUpgradeManager;
//    private View mWantMoreButton;
//    private ImageView mWordRadioButton;
//
//    class NotifyPullCallback implements OnNotifyMsgGetListener {
//        final WeakReference<MainTabActivity> mActivity;
//
//        private NotifyPullCallback(MainTabActivity mainTabActivity) {
//            this.mActivity = new WeakReference<>(mainTabActivity);
//        }
//
//        public void onGetNotifyMsg(List<NotifyMsgRecord> list, int i, boolean z, int i2) {
//            MainTabActivity mainTabActivity = (MainTabActivity) this.mActivity.get();
//            if (mainTabActivity != null && i2 == 0) {
//                mainTabActivity.mHaveNewNotify = true;
//                mainTabActivity.mGotoNotifyMsg.setImageDrawable(ThemeUtil.getThemeDrawableWithAttr(mainTabActivity, R.attr.drawable_main_study_new_message));
//            }
//        }
//    }
//
//    class PrepareHandler extends Handler {
//        private WeakReference<MainTabActivity> activity;
//
//        PrepareHandler(MainTabActivity mainTabActivity) {
//            this.activity = new WeakReference<>(mainTabActivity);
//        }
//
//        public void handleMessage(Message message) {
//            super.handleMessage(message);
//            MainTabActivity mainTabActivity = (MainTabActivity) this.activity.get();
//            if (mainTabActivity != null) {
//                switch (message.what) {
//                    case 1:
//                        if (message.obj != null && (message.obj instanceof String)) {
//                            mainTabActivity.showProgressDialog((String) message.obj);
//                            return;
//                        }
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    private void checkResource(int i) {
//        TopicResourceManager instance = TopicResourceManager.getInstance();
//        if (instance.getBookId() != i) {
//            instance.reInit(this, i);
//            instance.getOfflineResRepo().setOfflineResourceListener(new OfflineResourceListener() {
//                public void onStateChanged(OfflineResourceRepo offlineResourceRepo) {
//                    MainTabActivity.this.updateOfflineStatus();
//                }
//
//                public void onError(String str) {
//                    Toast.makeText(MainTabActivity.this, str, 0).show();
//                }
//            });
//        }
//    }
//
//    private void updateOfflineDownloadProgress(OfflineResourceRepo offlineResourceRepo) {
//        int currentProgress = offlineResourceRepo.getCurrentProgress();
//        float currentProgressSize = offlineResourceRepo.getCurrentProgressSize();
//        float totalSize = offlineResourceRepo.getTotalSize();
//        this.mOfflineDownloadView.setProgress(currentProgress);
//        this.mOfflineDownloadView.setText((CharSequence) String.format(Locale.CHINA, "%.2fM/%.2fM", new Object[]{Float.valueOf(currentProgressSize), Float.valueOf(totalSize)}));
//    }
//
//    /* access modifiers changed from: private */
//    public void updateOfflineStatus() {
//        OfflineResourceRepo offlineResRepo = TopicResourceManager.getInstance().getOfflineResRepo();
//        RepoState repoState = offlineResRepo.getRepoState();
//        DLState dLState = offlineResRepo.getDLState();
//        switch (dLState) {
//            case STATE_PREPARE:
//                this.mOfflineDownloadView.setProgress(0);
//                this.mOfflineDownloadView.setText((CharSequence) "准备下载");
//                return;
//            case STATE_RUNNING:
//                updateOfflineDownloadProgress(offlineResRepo);
//                return;
//            case STATE_PAUSE:
//            case STATE_FAIL:
//                this.mOfflineDownloadView.pause();
//                this.mOfflineDownloadView.setText((CharSequence) "点击恢复下载");
//                return;
//            default:
//                this.mOfflineDownloadView.setVisibility(0);
//                this.mOfflineDownloadView.init();
//                switch (repoState) {
//                    case STATE_RES_COMPLETED:
//                        if (dLState == DLState.STATE_FINISH) {
//                            this.mOfflineDownloadView.complete();
//                            this.mOfflineDownloadView.setText((CharSequence) "离线包下载已完成");
//                            return;
//                        }
//                        this.mOfflineDownloadView.setVisibility(4);
//                        return;
//                    case STATE_TEXT_INCOMPLETE:
//                        this.mOfflineDownloadView.setText((CharSequence) "下载离线单词包");
//                        return;
//                    case STATE_INIT:
//                    case STATE_TEXT_COMPLETED:
//                        this.mOfflineDownloadView.setText((CharSequence) "单词资源检测中...");
//                        return;
//                    case STATE_MEDIA_INCOMPLETE:
//                        this.mOfflineDownloadView.setText((CharSequence) "单词资源缺失，点击修复");
//                        if (this.isResumed) {
//                            notifyResourceIncomplete();
//                            return;
//                        }
//                        return;
//                    default:
//                        return;
//                }
//        }
//    }
//
//    private void notifyResourceIncomplete() {
//        Dialog dialog = this.mDialogRecycler.get(2);
//        if (dialog == null) {
//            dialog = new Builder(this).setMessage((int) R.string.main_resource_incomplete_message).setPositiveButton((int) R.string.main_resource_update_now, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    MainTabActivity.this.mOfflineDownloadHinted = true;
//                    TopicResourceManager.getInstance().setMobileOfflineDownloadEnabled(true);
//                    TopicResourceManager.getInstance().getOfflineResRepo().resumeOfflineDownload();
//                }
//            }).setNegativeButton((int) R.string.main_resource_update_later, (DialogInterface.OnClickListener) null).setCancelable(false).create();
//            this.mDialogRecycler.replace(2, dialog);
//        }
//        dialog.show();
//    }
//
//    /* access modifiers changed from: private */
//    public void forceSelectSchedule() {
//        LogWrapper.m2793d(TAG, "forceSelectSchedule " + StudyManager.getInstance().getCurrentSchedule());
//        String msg_tip = this.mStudyManager.getUserLimit().getSelect_date_tip().getMsg_tip();
//        BczDialog create = new Builder(this).setTitle((int) R.string.attention).setMessage((CharSequence) msg_tip).setPositiveButton((CharSequence) "确定", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                if (i == -1) {
//                    MainTabActivity.this.startScheduleManagement(true);
//                }
//                dialogInterface.dismiss();
//            }
//        }).setCancelable(false).create();
//        create.show();
//        this.mDialogRecycler.replace(1, create);
//    }
//
//    private boolean hasSchedule() {
//        StudyManager instance = StudyManager.getInstance();
//        return (instance.getLearningManager() == null || instance.getCurrentSchedule() == null || instance.getCurrentBook() == null) ? false : true;
//    }
//
//    /* access modifiers changed from: private */
//    public void onPrepared() {
//        boolean z;
//        if (!this.mPopupDisplayed) {
//            popupWelcomeMessage();
//        }
//        if (!hasSchedule()) {
//            selfExit();
//            return;
//        }
//        checkResource(StudyManager.getInstance().getCurrentBookId());
//        updateOfflineStatus();
//        BookRecord currentBook = this.mStudyManager.getCurrentBook();
//        int i = currentBook.bookId;
//        if (this.mStudyManager.getLearningManager() != null) {
//            SequenceStrategy sequenceStrategy = this.mStudyManager.getLearningManager().getSequenceStrategy();
//            if (sequenceStrategy != null) {
//                int newLearningCount = sequenceStrategy.getNewLearningCount();
//                int reviewCount = sequenceStrategy.getReviewCount();
//                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.T2);
//                this.mBookName.setText(currentBook.bookName);
//                this.mRemainDays.setText(new SimpleSpannableBuilder().append(Integer.toString(currentBook.getRemainDays())).append("天", new AbsoluteSizeSpan(dimensionPixelSize)).build());
//                this.mDailyNewCount.setText(new SimpleSpannableBuilder().append(Integer.toString(this.mStudyManager.getTodayNewCount())).append("个", new AbsoluteSizeSpan(dimensionPixelSize)).build());
//                int totalTableSize = LearnRecordManager.getInstance().getTotalTableSize();
//                currentBook.finishCount = totalTableSize;
//                this.mScheduleProgressText.setText(getScheduleProgressString(totalTableSize, currentBook.wordCount));
//                this.mScheduleProgressBar.setProgress((totalTableSize * 100) / currentBook.wordCount);
//                UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//                if (totalTableSize != 0 || currentUser.getIsNewUser() <= 0) {
//                    this.mBottomTab.setRightTabsVisible(true);
//                    this.mWordRadioButton.setVisibility(0);
//                } else {
//                    this.mBottomTab.setRightTabsVisible(false);
//                    this.mWordRadioButton.setVisibility(8);
//                }
//                if (newLearningCount == 0 && reviewCount == 0) {
//                    NoticeManager.markNoticedToday(true);
//                    this.mInstruction.setText("今日计划完成 你可以");
//                    if (totalTableSize == this.mStudyManager.getRoadmapSize()) {
//                        z = true;
//                    } else {
//                        z = false;
//                    }
//                    showReviewPanel(z);
//                } else {
//                    this.mInstruction.setText(String.format(Locale.CHINA, "今日需学习%d/%d 今日需复习%d", new Object[]{Integer.valueOf(newLearningCount), Integer.valueOf(this.mStudyManager.getTodayNewCount()), Integer.valueOf(reviewCount)}));
//                    showStudyPanel();
//                }
//                if (i == 16 || i == 31) {
//                    this.mPhraseTraining.setVisibility(0);
//                } else {
//                    this.mPhraseTraining.setVisibility(8);
//                }
//                uploadLearnRecord();
//                if (!this.mLowPriorityRequestProcessed) {
//                    processLowPriorityRequest();
//                    this.mLowPriorityRequestProcessed = true;
//                }
//            }
//        }
//    }
//
//    private void uploadLearnRecord() {
//        final int currentBookId = this.mStudyManager.getCurrentBookId();
//        C10465 r1 = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                EventBus.m0a().mo9c((Object) new UploadStatusEvent(3));
//                LearnRecordManager.getInstance().upload(MainTabActivity.this.getApplicationContext(), currentBookId, client);
//                return Integer.valueOf(0);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                if (StudyManager.getInstance().getCurrentBookId() == currentBookId) {
//                    EventBus.m0a().mo9c((Object) new UploadStatusEvent(2));
//                    MainTabActivity.this.isUploading = false;
//                }
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                if (StudyManager.getInstance().getCurrentBookId() == currentBookId) {
//                    EventBus.m0a().mo9c((Object) new UploadStatusEvent(1));
//                    MainTabActivity.this.isUploading = false;
//                }
//            }
//        };
//        r1.setTag(TAG);
//        BaicizhanThrifts.getProxy().add(r1);
//        this.isUploading = true;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        LogWrapper.m2793d(TAG, "onCreate");
//        WeixinLogin.putLastLoginInfo(null);
//        initViews();
//        this.mStudyManager = StudyManager.getInstance();
//        this.mPlayer = new AudioPlayer(this);
//        this.mHandler.post(new Runnable() {
//            public void run() {
//                try {
//                    EventBus.m0a().mo5a((Object) MainTabActivity.this);
//                    UmengUpdateAgent.m5234a(MainTabActivity.this);
//                } catch (Exception e) {
//                    LogWrapper.m2794e(MainTabActivity.TAG, Log.getStackTraceString(e));
//                }
//            }
//        });
//        this.mHandler.postDelayed(new Runnable() {
//            public void run() {
//                MainTabActivity.this.delayedInit();
//            }
//        }, 2000);
//    }
//
//    /* access modifiers changed from: private */
//    public void delayedInit() {
//        setVolumeControlStream(3);
//        LocationUtils.with(this).start();
//        this.mUpgradeManager = new UpgradeManager(this);
//        this.mUpgradeManager.tryUpgrade(true);
//        DownloadService.getInstance().init(3);
//        CrashManager.getInstance().checkAndUpload();
//        LogoPagePreloadService.start(this);
//        LSwitcher.toggle(true);
//        FriendManager.getInstance().startFriendBackgroundJobs();
//        fetchNewFeedback();
//        APPScaner.born(this).scan();
//        StudyStats.getsInstance().stat(this);
//        this.mNotifyRefreshCallback = new NotifyPullCallback();
//        this.mNotifyMsgGetter = NotifyMsgGetter.born(this).setListener(this.mNotifyRefreshCallback);
//        this.mNotifyMsgGetter.getNotifyMsg(2, 0);
//    }
//
//    private void ensureAvailableSpace() {
//        String string = PropertyHelper.getString(PropertyHelper.APP_ROOT);
//        if (!TextUtils.isEmpty(string)) {
//            long availableBytes = StorageUtils.getAvailableBytes(string);
//            if (availableBytes < 10485760) {
//                BczDialog create = new Builder(this).setTitle((int) R.string.attention).setMessage((CharSequence) getString(R.string.main_insufficient_storage_space, new Object[]{Long.valueOf(10)})).setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        MainTabActivity.this.selfExit();
//                    }
//                }).setCancelable(false).create();
//                create.show();
//                this.mDialogRecycler.replace(3, create);
//            } else if (availableBytes < CommonUtils.WARNING_AVAILABLE_BYTES) {
//                BczDialog create2 = new Builder(this).setTitle((int) R.string.attention).setMessage((CharSequence) getString(R.string.main_warning_insufficient_storage_space, new Object[]{Long.valueOf(30)})).setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) null).create();
//                create2.show();
//                this.mDialogRecycler.replace(3, create2);
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onResume() {
//        int i;
//        boolean z = false;
//        super.onResume();
//        LogWrapper.m2793d(TAG, "onResume");
//        if (StudyManager.getInstance().getCurrentUser() == null) {
//            selfExit();
//            return;
//        }
//        UMStats.traceOnActivityResume(this);
//        OperationStats.getInstance().stat(this);
//        if (TopicResourceManager.getInstance().getOfflineResRepo().getRepoState() == RepoState.STATE_MEDIA_INCOMPLETE) {
//            notifyResourceIncomplete();
//        }
//        if (this.mNotifyMsgGetter != null) {
//            this.mNotifyMsgGetter.getNotifyMsg(2, 0);
//        }
//        this.isResumed = true;
//        ensureAvailableSpace();
//        int takeRefreshRequestFlag = this.mStudyManager.takeRefreshRequestFlag();
//        long j = Settings.getLong(Settings.PREF_LAST_USER_INFO_TIME);
//        long currentTimeMillis = System.currentTimeMillis();
//        if (currentTimeMillis - j > USER_INFO_REFRESH_TIMEOUT || TimeUtil.getBetweenDays(currentTimeMillis, j) > 0) {
//            z = true;
//        }
//        if (!hasSchedule() || takeRefreshRequestFlag > 0 || (NetworkUtils.isNetworkAvailable(this) && (this.mStudyManager.isOfflined() || z))) {
//            Settings.putLong(Settings.PREF_LAST_USER_INFO_TIME, currentTimeMillis);
//            if (z) {
//                i = takeRefreshRequestFlag | 1;
//            } else {
//                i = takeRefreshRequestFlag;
//            }
//            LogWrapper.m2793d(TAG, "doRefresh");
//            doRefresh(i);
//            return;
//        }
//        LogWrapper.m2793d(TAG, "onPrepared");
//        onPrepared();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//        this.isResumed = false;
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        LogWrapper.m2793d(TAG, "onDestroy");
//        EventBus.m0a().mo8b((Object) this);
//        if (this.mProgressDialog != null) {
//            this.mProgressDialog.dismiss();
//        }
//        this.mDialogRecycler.destroy();
//        if (this.mPlayer != null) {
//            this.mPlayer.destroy();
//        }
//        if (this.mPrepareRequest != null) {
//            this.mPrepareRequest.cancel();
//        }
//        GoStoreUtil.getInstance().destroy();
//        LocationUtils.with(this).stop();
//        if (this.mUpgradeManager != null) {
//            this.mUpgradeManager.destroy();
//        }
//        this.mHandler.removeCallbacksAndMessages(null);
//    }
//
//    public void onActivityResult(int i, int i2, Intent intent) {
//        if (!isFinishing()) {
//            super.onActivityResult(i, i2, intent);
//            if (i == 3 && i2 == -1 && intent != null && intent.getBooleanExtra(Constants.RESULT_TEST_UPDATED, false)) {
//                StudyManager.getInstance().addRefreshRequestFlag(1);
//            }
//            switch (i2) {
//                case 2:
//                    Settings.putLong(Settings.PREF_LAST_USER_INFO_TIME, 0);
//                    selfExit();
//                    return;
//                case 3:
//                    if (this.mCurrentThemeId != ThemeUtil.getCurrentSettingThemeId()) {
//                        ThemeUtil.updateTheme(this);
//                        return;
//                    }
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    public void onBackPressed() {
//        BczDialog create = new Builder(this).setTitle((CharSequence) "退出程序").setMessage((CharSequence) "客官，您这是要退出百词斩？").setNegativeButton((int) R.string.main_alert_negative_cancel, (DialogInterface.OnClickListener) null).setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                switch (i) {
//                    case -2:
//                        dialogInterface.dismiss();
//                        return;
//                    case -1:
//                        dialogInterface.dismiss();
//                        DownloadService.getInstance().shutdown();
//                        Settings.putLong(Settings.PREF_LAST_USER_INFO_TIME, 0);
//                        MainTabActivity.this.selfExit();
//                        CommonUtils.killAllProcess(MainTabActivity.this);
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }).create();
//        create.show();
//        this.mDialogRecycler.replace(4, create);
//    }
//
//    /* access modifiers changed from: private */
//    public void selfExit() {
//        LogWrapper.m2793d(TAG, "selfExit");
//        StudyManager.getInstance().clearCurrentScheduleData();
//        FriendManager.getInstance().reset();
//        FriendManager.getInstance().stopFriendBackgroundJobs();
//        BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
//        TopicResourceManager.getInstance().release();
//        Settings.putLong(Settings.PREF_LAST_USER_INFO_TIME, 0);
//        finish();
//    }
//
//    private void initViews() {
//        this.mCurrentThemeId = ThemeUtil.getCurrentSettingThemeId();
//        getWindow().setBackgroundDrawableResource(R.color.C24);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        setContentView((int) R.layout.activity_main_tab);
//        initSlidingMenu();
//        this.mBottomTab = (MainBottomTab) findViewById(R.id.main_tabs);
//        this.mBottomTab.init(this);
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(0);
//        gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(this, 20.0f));
//        gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_main_window_bg));
//        C1604j.m3631a(findViewById(R.id.left_card), gradientDrawable);
//        this.mRemainDays = (TextView) findViewById(R.id.remain_days);
//        this.mDailyNewCount = (TextView) findViewById(R.id.daily_new_count);
//        this.mBookName = (TextView) findViewById(R.id.book_name);
//        this.mScheduleProgressText = (TextView) findViewById(R.id.schedule_progress_text);
//        this.mScheduleProgressBar = (ProgressBar) findViewById(R.id.schedule_progress_view);
//        ThemeResUtil.setBaicizhanProgress(this, this.mScheduleProgressBar);
//        this.mInstruction = (TextView) findViewById(R.id.schedule_instruction);
//        this.mPopupMessage = (TextView) findViewById(R.id.popup_message_text);
//        GradientDrawable gradientDrawable2 = new GradientDrawable();
//        gradientDrawable2.setShape(0);
//        gradientDrawable2.setCornerRadius((float) DisplayUtils.dpToPx(this, 4.0f));
//        gradientDrawable2.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_welcome_bg));
//        gradientDrawable2.setStroke(DisplayUtils.dpToPx(this, 1.0f), ThemeUtil.getThemeColorWithAttr(this, R.attr.color_welcome_bg2));
//        C1604j.m3631a(this.mPopupMessage, gradientDrawable2);
//        this.mFinishButtons = findViewById(R.id.finish_buttons);
//        this.mWantMoreButton = this.mFinishButtons.findViewById(R.id.want_more_button);
//        this.mWantMoreButton.setOnClickListener(this);
//        this.mCelebrateButton = this.mFinishButtons.findViewById(R.id.celebrate_button);
//        this.mCelebrateButton.setOnClickListener(this);
//        this.mFinishButtons.findViewById(R.id.daka_button).setOnClickListener(this);
//        this.mStartStudyButton = (ImageView) findViewById(R.id.start_study_button);
//        this.mStartStudyButton.setOnClickListener(this);
//        this.mReviewButton = (ImageView) findViewById(R.id.review_button);
//        this.mReviewButton.setOnClickListener(this);
//        this.mWordRadioButton = (ImageView) findViewById(R.id.word_radio_button);
//        this.mWordRadioButton.setOnClickListener(this);
//        this.mProgressDialog = new BczLoadingDialog(this);
//        this.mProgressDialog.setCancelable(false);
//        int[][] iArr = {new int[]{16842919, 16842910}, new int[0]};
//        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_button_oval) & 16777215) | 1275068416, 0});
//        this.mPhraseTraining = (RoundedButton) findViewById(R.id.phrase_training);
//        this.mPhraseTraining.setOnClickListener(this);
//        this.mPhraseTraining.setFillColor(colorStateList);
//        RoundedButton roundedButton = (RoundedButton) findViewById(R.id.change_schedule);
//        roundedButton.setOnClickListener(this);
//        roundedButton.setFillColor(colorStateList);
//        this.mOfflineDownloadView = (OfflineDownloadView) findViewById(R.id.offline_download_view);
//        this.mOfflineDownloadView.setOnClickListener(this);
//        showStudyPanel();
//        this.mGotoNotifyMsg = (ImageView) findViewById(R.id.main_goto_notify_msg);
//        this.mGotoNotifyMsg.setOnClickListener(this);
//        this.mMainReviewGuider = (MainReviewGuider) findViewById(R.id.main_review_guide);
//    }
//
//    private void initSlidingMenu() {
//        this.mLeftSlidingMenu = (LeftSlidingMenuView) LayoutInflater.from(this).inflate(R.layout.left_sliding_menu_view, null, false);
//        setBehindContentView((View) this.mLeftSlidingMenu);
//        SlidingMenu slidingMenu = getSlidingMenu();
//        slidingMenu.setShadowWidth(slidingMenu.getWidth());
//        slidingMenu.setBehindOffset((int) (((double) Common.getScreenWidth(this)) * 0.382d));
//        slidingMenu.setFadeDegree(1.0f);
//        slidingMenu.setTouchModeAbove(1);
//        slidingMenu.setBehindScrollScale(0.0f);
//        slidingMenu.setBehindCanvasTransformer(this.mTransformer);
//        slidingMenu.setOnOpenListener(new C1647p() {
//            public void onOpen() {
//                MainTabActivity.this.mLeftSlidingMenu.onOpen();
//                MainTabActivity.this.mBottomTab.setSettingSelected(true);
//                if (MainTabActivity.this.mMainReviewGuider != null) {
//                    MainTabActivity.this.mMainReviewGuider.gone();
//                }
//            }
//        });
//        slidingMenu.setOnCloseListener(new C1645n() {
//            public void onClose() {
//                MainTabActivity.this.mBottomTab.setSettingSelected(false);
//            }
//        });
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void showProgressDialog(String str) {
//        this.mProgressDialog.setMessage((CharSequence) str);
//        this.mProgressDialog.show();
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void hideProgressDialog() {
//        this.mProgressDialog.hide();
//    }
//
//    private void processLowPriorityRequest() {
//        this.mLocationInfo = LocationUtils.with(this).getLocation();
//        this.mLowPriorityRequest.setTag(TAG);
//        this.mLowPriorityRequest.setPriority(Priority.LOW);
//        BaicizhanThrifts.getProxy().add(this.mLowPriorityRequest);
//        PicassoUtil.loadAccountUserImage(this, PathUtil.getBaicizhanAppRoot(), this.mStudyManager.getCurrentUser().getImage(), null, 0);
//    }
//
//    private CharSequence getScheduleProgressString(int i, int i2) {
//        SimpleSpannableBuilder simpleSpannableBuilder = new SimpleSpannableBuilder();
//        simpleSpannableBuilder.append("已完成 ", new TextAppearanceSpan(null, 0, getResources().getDimensionPixelSize(R.dimen.T2), ThemeUtil.getThemeColorStateListWithAttr(this, R.attr.color_button_oval), null));
//        simpleSpannableBuilder.append(Integer.toString(i), new TextAppearanceSpan(null, 0, getResources().getDimensionPixelSize(R.dimen.T5), ThemeUtil.getThemeColorStateListWithAttr(this, R.attr.color_text_blue), null));
//        simpleSpannableBuilder.append(" / " + Integer.toString(i2), new TextAppearanceSpan(null, 0, getResources().getDimensionPixelSize(R.dimen.T5), ThemeUtil.getThemeColorStateListWithAttr(this, R.attr.color_main_text2), null));
//        return simpleSpannableBuilder.build();
//    }
//
//    private void popupWelcomeMessage() {
//        TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
//        translateAnimation.setDuration(300);
//        this.mGotoNotifyMsg.setVisibility(0);
//        this.mGotoNotifyMsg.startAnimation(translateAnimation);
//        UserRecord currentUser = this.mStudyManager.getCurrentUser();
//        if (currentUser != null && currentUser.getIsNewUser() <= 0) {
//            LogWrapper.m2793d(TAG, "popupWelcomMessage" + currentUser);
//            this.mPopupDisplayed = true;
//            this.mPopupMessage.setText(String.format("欢迎回来，%s", new Object[]{currentUser.getDisplayName()}));
//            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
//            translateAnimation2.setDuration(150);
//            this.mPopupMessage.setVisibility(0);
//            this.mPopupMessage.startAnimation(translateAnimation2);
//            this.mPopupMessage.postDelayed(new Runnable() {
//                public void run() {
//                    MainTabActivity.this.mPopupMessage.startAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f));
//                    MainTabActivity.this.mPopupMessage.setVisibility(4);
//                }
//            }, 3000);
//        }
//    }
//
//    private void showStudyPanel() {
//        this.mStartStudyButton.setVisibility(0);
//        this.mFinishButtons.setVisibility(8);
//        this.mReviewButton.setVisibility(8);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void showReviewPanel(boolean z) {
//        this.mStartStudyButton.setVisibility(8);
//        this.mFinishButtons.setVisibility(0);
//        this.mReviewButton.setVisibility(0);
//        if (z) {
//            this.mWantMoreButton.setVisibility(8);
//            this.mCelebrateButton.setVisibility(0);
//        } else {
//            this.mWantMoreButton.setVisibility(0);
//            this.mCelebrateButton.setVisibility(8);
//        }
//        checkGuide();
//    }
//
//    private void checkGuide() {
//        if (GuideFlags.guideEnabled(2048) && GuideFlags.needCheckGuides()) {
//            this.mMainReviewGuider.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
//                public boolean onPreDraw() {
//                    MainTabActivity.this.showMainGuide();
//                    MainTabActivity.this.mMainReviewGuider.getViewTreeObserver().removeOnPreDrawListener(this);
//                    return true;
//                }
//            });
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void showMainGuide() {
//        if (this.mMainReviewGuider.getVisibility() != 0) {
//            this.mMainReviewGuider.setVisibility(0);
//            this.mMainReviewGuider.setPKLocation((ImageView) this.mBottomTab.findViewById(R.id.main_tab_pk)).setPlusreviewLocation(this.mReviewButton).setFmTvLocation(this.mWordRadioButton).showUp();
//        }
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.phrase_training /*2131296363*/:
//                phraseTraining();
//                return;
//            case R.id.change_schedule /*2131296364*/:
//                startScheduleManagement(false);
//                return;
//            case R.id.offline_download_view /*2131296366*/:
//                toggleDownload();
//                return;
//            case R.id.daka_button /*2131296370*/:
//                daka();
//                return;
//            case R.id.want_more_button /*2131296371*/:
//                tryWantMore();
//                return;
//            case R.id.celebrate_button /*2131296372*/:
//                dance();
//                return;
//            case R.id.review_button /*2131296373*/:
//                review();
//                return;
//            case R.id.start_study_button /*2131296374*/:
//                startStudy();
//                return;
//            case R.id.word_radio_button /*2131296375*/:
//                wordRadio();
//                return;
//            case R.id.main_goto_notify_msg /*2131296377*/:
//                gotoNotifyMsg();
//                return;
//            default:
//                return;
//        }
//    }
//
//    private void phraseTraining() {
//        PhraseGroupActivity.start(this);
//    }
//
//    public void startScheduleManagement(boolean z) {
//        if (CommonUtils.ensureNetworkAvailable(this)) {
//            Intent intent = new Intent(this, ScheduleManagementActivity.class);
//            intent.putExtra(ScheduleManagementActivity.EXTRA_REQUIRE_SCHEDULE, z);
//            startActivity(intent);
//        }
//    }
//
//    private void toggleDownload() {
//        OfflineResourceRepo offlineResRepo = TopicResourceManager.getInstance().getOfflineResRepo();
//        if (offlineResRepo.getDLState() == DLState.STATE_RUNNING) {
//            offlineResRepo.pauseOfflineDownload();
//            Log.d(TAG, "try pause");
//            return;
//        }
//        RepoState repoState = offlineResRepo.getRepoState();
//        Log.d(TAG, "try resume " + repoState);
//        if (repoState == RepoState.STATE_TEXT_INCOMPLETE || repoState == RepoState.STATE_MEDIA_INCOMPLETE) {
//            checkMobileOfflineDownloadEnabled();
//        }
//    }
//
//    private void doRefresh(int i) {
//        if (this.mPrepareRequest != null) {
//            this.mPrepareRequest.cancel();
//        }
//        this.mPrepareRequest = new SchedulePrepareRequest(BaicizhanThrifts.USERS, getApplicationContext(), this.mPrepareHandler, i) {
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                MainTabActivity.this.hideProgressDialog();
//                if (exc instanceof PrepareException) {
//                    switch (((PrepareException) exc).getCode()) {
//                        case 1:
//                            MainTabActivity.this.selfExit();
//                            break;
//                        case 2:
//                            MainTabActivity.this.forceSelectSchedule();
//                            break;
//                        case 3:
//                            if (!NetworkUtils.isNetworkAvailable(MainTabActivity.this)) {
//                                BczDialog create = new Builder(MainTabActivity.this).setMessage((CharSequence) "请联网，选择学习计划后，才能继续使用").setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialogInterface, int i) {
//                                        MainTabActivity.this.selfExit();
//                                    }
//                                }).create();
//                                create.show();
//                                MainTabActivity.this.mDialogRecycler.replace(1, create);
//                                break;
//                            } else {
//                                Intent intent = new Intent(this.context, NewScheduleActivity.class);
//                                intent.putExtra(NewSchedulePickDateActivity.EXTRA_CREATE_NEW_TASK, true);
//                                MainTabActivity.this.startActivity(intent);
//                                MainTabActivity.this.selfExit();
//                                break;
//                            }
//                        default:
//                            Toast.makeText(MainTabActivity.this, exc.getMessage(), 1).show();
//                            break;
//                    }
//                    LogWrapper.m2793d(MainTabActivity.TAG, "PrepareException " + exc.toString());
//                    return;
//                }
//                LogWrapper.m2794e(MainTabActivity.TAG, "onError " + Log.getStackTraceString(exc));
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                MainTabActivity.this.hideProgressDialog();
//                MainTabActivity.this.onPrepared();
//                UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//                if (currentUser != null) {
//                    Settings.putString(Settings.PREF_USER_EMAIL, currentUser.getEmail());
//                    Settings.putString(Settings.PREF_USER_PUBLIC_KEY, currentUser.getPublicKey());
//                    Settings.putString(Settings.PREF_USER_TOKEN, currentUser.getToken());
//                    Settings.putString(Settings.PREF_USER_NAME, currentUser.getUser());
//                    Settings.putString(Settings.PREF_USER_NICKNAME, currentUser.getDisplayName());
//                    Settings.putString(Settings.PREF_USER_IMAGE_URL, currentUser.getImage());
//                }
//            }
//        };
//        BaicizhanThrifts.getProxy().add(this.mPrepareRequest);
//        showProgressDialog("初始化数据中，请稍候");
//    }
//
//    private void checkMobileOfflineDownloadEnabled() {
//        int activeNetworkType = NetworkUtils.getActiveNetworkType(this);
//        LogWrapper.m2793d(TAG, "checkMobileOfflineDownloadEnabled " + activeNetworkType);
//        if (activeNetworkType == 3 || activeNetworkType == 2 || activeNetworkType == 1) {
//            if (!TopicResourceManager.getInstance().isMobileOfflineDownloadEnabled()) {
//                C103816 r0 = new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if (i == -1) {
//                            TopicResourceManager.getInstance().setMobileProblemDownloadEnabled(true);
//                            MainTabActivity.this.confirmOfflineDownload();
//                        }
//                    }
//                };
//                BczDialog create = new Builder(this).setMessage((int) R.string.main_alert_message_download_problem).setPositiveButton((int) R.string.main_alert_positive_wealthy, (DialogInterface.OnClickListener) r0).setNegativeButton((int) R.string.main_alert_negative_giveup, (DialogInterface.OnClickListener) r0).setCancelable(false).create();
//                create.setCancelable(false);
//                create.show();
//                this.mDialogRecycler.replace(6, create);
//                return;
//            }
//            confirmOfflineDownload();
//        } else if (activeNetworkType == 0) {
//            confirmOfflineDownload();
//        } else {
//            BczDialog create2 = new Builder(this).setTitle((int) R.string.attention).setMessage((CharSequence) "检测不到网络，请联网后重试").setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) null).setCancelable(true).create();
//            create2.show();
//            this.mDialogRecycler.replace(5, create2);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void confirmOfflineDownload() {
//        LogWrapper.m2793d(TAG, "confirmOfflineDownload " + this.mOfflineDownloadHinted);
//        if (this.mOfflineDownloadHinted) {
//            TopicResourceManager.getInstance().getOfflineResRepo().resumeOfflineDownload();
//            return;
//        }
//        C103917 r0 = new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                if (i == -1) {
//                    MainTabActivity.this.mOfflineDownloadHinted = true;
//                    TopicResourceManager.getInstance().getOfflineResRepo().resumeOfflineDownload();
//                }
//            }
//        };
//        UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//        BczDialog create = new Builder(this).setMessage((CharSequence) getString(R.string.main_offline_download_tip, new Object[]{currentUser.getVerboseSex()})).setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) r0).setNegativeButton((int) R.string.main_alert_negative_giveup, (DialogInterface.OnClickListener) r0).create();
//        create.show();
//        this.mDialogRecycler.replace(7, create);
//    }
//
//    private void daka() {
//        if (CommonUtils.ensureNetworkAvailable(this)) {
//            Intent intent = new Intent(this, DakaActivity.class);
//            intent.putExtra("portrait_mode", false);
//            startActivity(intent);
//        }
//    }
//
//    private void tryWantMore() {
//        UserRecord currentUser = this.mStudyManager.getCurrentUser();
//        if (currentUser != null) {
//            BczDialog create = new Builder(this).setTitle((int) R.string.attention).setMessage((CharSequence) getString(R.string.main_want_more_message, new Object[]{currentUser})).setPositiveButton((CharSequence) "废话!给爷再来25", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    if (i == -1) {
//                        MainTabActivity.this.wantMore(25);
//                    }
//                }
//            }).setNegativeButton((CharSequence) "算了", (DialogInterface.OnClickListener) null).create();
//            create.show();
//            this.mDialogRecycler.replace(8, create);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void wantMore(int i) {
//        OfflineStateRecord currentOfflineState = this.mStudyManager.getCurrentOfflineState();
//        if (currentOfflineState != null) {
//            int todayNewLearnedCount = LearnRecordManager.getInstance().getTodayNewLearnedCount();
//            int i2 = StudyManager.getInstance().getCurrentSchedule().dailyNewCount;
//            int remainCount = LearnRecordManager.getInstance().getRemainCount();
//            int min = Math.min(remainCount, i) + todayNewLearnedCount;
//            int i3 = min - i2;
//            LogWrapper.m2793d(TAG, "wantMore compute: 今日已新学 " + todayNewLearnedCount + ", 计划新学 " + i2 + ", 想要今天新学 " + min + ", 剩余 " + remainCount + ", 实际加量个数 " + i3);
//            this.mStudyManager.setTodayNewCount(min);
//            currentOfflineState.wantMoreCount = i3;
//            BookRecordHelper.saveOfflineState(this, currentOfflineState);
//            LearningManager learningManager = this.mStudyManager.getLearningManager();
//            learningManager.setSequenceModeNewAndReview(min, ConstantsUtil.NEW_AND_REVIEW_EXTRA_ARGS);
//            learningManager.setTypeModeLearning(null);
//            onPrepared();
//            startStudy();
//        }
//    }
//
//    private void startStudy() {
//        startActivity(new Intent(this, PrepareLearningActivity.class));
//        if (PropertyHelper.getBoolean(PropertyHelper.SOUND_EFFECT, true)) {
//            this.mPlayer.newPlayRaw(R.raw.chop);
//        }
//        UMStats.statStudyClick(this);
//        OperationStats.statRecite();
//    }
//
//    private void dance() {
//        startActivity(new Intent(this, DanceActivity.class));
//    }
//
//    private void gotoNotifyMsg() {
//        NotifyMsgListActivity.start(this, this.mHaveNewNotify);
//        this.mGotoNotifyMsg.setImageDrawable(ThemeUtil.getThemeDrawableWithAttr(this, R.attr.drawable_main_study_message));
//        this.mHaveNewNotify = false;
//        OperationStats.statNotification();
//    }
//
//    private void review() {
//        PlusReviewEnter.start(this);
//        UMStats.statPlusreviewClick(this);
//        OperationStats.statReview();
//    }
//
//    private void wordRadio() {
//        FmTvEnter.start(this);
//        UMStats.statFmTvClick(this);
//        OperationStats.statMedia();
//    }
//
//    public void toggleDrawer() {
//        toggle();
//    }
//
//    public void onEventMainThread(UploadClickEvent uploadClickEvent) {
//        Log.i(TAG, "onEventMainThread " + uploadClickEvent);
//        if (!this.isUploading) {
//            uploadLearnRecord();
//        }
//    }
//
//    public void onEventMainThread(FriendTabRedDotEvent friendTabRedDotEvent) {
//        this.mBottomTab.showFriendRedDot();
//    }
//
//    public void onEventMainThread(FeedbackNewEvent feedbackNewEvent) {
//        boolean isShowRedDot = feedbackNewEvent.isShowRedDot();
//        this.mBottomTab.showSettingRedDot(isShowRedDot);
//        this.mLeftSlidingMenu.showFeedbackRedDot(isShowRedDot);
//    }
//
//    private void fetchNewFeedback() {
//        final Conversation a = new FeedbackAgent(this).mo18273a();
//        a.mo18276a((SyncListener) new SyncListener() {
//            public void onReceiveDevReply(List<Reply> list) {
//                int i = Settings.getInt(Settings.PREF_FEEDBACK_COUNT);
//                int i2 = 0;
//                List<Reply> list2 = a.f5466a;
//                if (list2 != null) {
//                    i2 = list2.size();
//                }
//                if (i2 > i) {
//                    Settings.putInt(Settings.PREF_FEEDBACK_COUNT, i2);
//                    EventBus.m0a().mo9c((Object) new FeedbackNewEvent(true));
//                }
//            }
//
//            public void onSendUserReply(List<Reply> list) {
//            }
//        });
//    }
//}
