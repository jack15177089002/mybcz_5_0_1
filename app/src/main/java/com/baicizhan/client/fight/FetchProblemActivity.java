//package com.baicizhan.client.fight;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.fight.VSManager.RivalType;
//import com.baicizhan.client.fight.VSManager.VSState;
//import com.baicizhan.client.fight.jsonbean.Problem;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.fight.util.Constants;
//import com.baicizhan.client.fight.util.VSRequest;
//import com.baicizhan.client.fight.util.VSRequest.OnPollingTimeoutListener;
//import com.baicizhan.client.fight.util.VSRequest.OnResponseListener;
//import com.baicizhan.client.framework.log.C0789L;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.LinkedList;
//import java.util.List;
//
//public class FetchProblemActivity extends Activity {
//    private static final int DELAY_SHOW_DOWNLOAD_PROBLEM = 3000;
//    private static final String TAG = "FetchProblemActivity";
//    ImageView mAvatarImage;
//    TextView mAvatarNickname;
//    View mDownloadProblemFrame;
//    ProgressBar mDownloadProgress;
//    Handler mHandler = new Handler();
//    VSRequest<?> mPollingStartRequest;
//    View mProblemRangeFrame;
//    ImageView mRivalImage;
//    TextView mRivalNickname;
//    private ErrorListener mVolleyErrorListener = new ErrorListener() {
//        public void onErrorResponse(VolleyError volleyError) {
//            VSManager.getInstance().reportVolleyError(FetchProblemActivity.this, volleyError);
//            FetchProblemActivity.this.finish();
//        }
//    };
//
//    /* access modifiers changed from: private */
//    public void showErrorTip(CharSequence charSequence) {
//        Toast.makeText(this, charSequence, 0).show();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(C0691R.layout.fight_activity_fetch_problem);
//            this.mProblemRangeFrame = findViewById(C0691R.id.problem_range);
//            this.mDownloadProblemFrame = findViewById(C0691R.id.download_problem);
//            this.mAvatarImage = (ImageView) findViewById(C0691R.id.match_me_head);
//            this.mAvatarNickname = (TextView) findViewById(C0691R.id.match_me_nick);
//            this.mRivalImage = (ImageView) findViewById(C0691R.id.match_part_head);
//            this.mRivalNickname = (TextView) findViewById(C0691R.id.match_part_nick);
//            this.mDownloadProgress = (ProgressBar) findViewById(C0691R.id.down_img_prog);
//            UserInfo avatar = VSManager.getInstance().getAvatar();
//            UserInfo rival = VSManager.getInstance().getRival();
//            if (avatar == null || rival == null) {
//                finish();
//                return;
//            }
//            PicassoUtil.loadAccountUserImage(this, Settings.getString(Settings.PREF_BAICIZHAN_PATH), avatar.getImage(), this.mAvatarImage, C0691R.drawable.userinfo_photo_normal_default);
//            PicassoUtil.loadUserImage(this, this.mRivalImage, rival.getImage());
//            this.mAvatarNickname.setText(avatar.getDisplayName());
//            this.mRivalNickname.setText(rival.getDisplayName());
//            this.mHandler.postDelayed(new Runnable() {
//                public void run() {
//                    FetchProblemActivity.this.mDownloadProblemFrame.setVisibility(0);
//                    FetchProblemActivity.this.mProblemRangeFrame.setVisibility(8);
//                    if (VSManager.getInstance().getRivalType() == RivalType.ONLINE) {
//                        FetchProblemActivity.this.getProblemUrl();
//                    } else {
//                        FetchProblemActivity.this.downloadProblemResource(VSManager.getInstance().getProblems());
//                    }
//                }
//            }, 3000);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        this.mHandler.removeCallbacksAndMessages(null);
//    }
//
//    private void setErrorTip(int i) {
//        Toast.makeText(this, i, 0).show();
//    }
//
//    /* access modifiers changed from: private */
//    public void onServerError(ErrorInfo errorInfo) {
//        VSManager.getInstance().reportServerError(this, errorInfo);
//        finish();
//    }
//
//    /* access modifiers changed from: private */
//    public void getProblemUrl() {
//        new VSRequest(TAG, Constants.getProblemUrl(VSManager.getInstance().getAvatar()), new TypeToken<Response<String>>() {
//        }.getType(), (OnResponseListener<T>) new OnResponseListener<String>() {
//            public boolean onResponse(ErrorInfo errorInfo, String str) {
//                if (errorInfo.getCode() == 0) {
//                    FetchProblemActivity.this.onGetProblemUrl(str.replace(".json?", ".gz?"));
//                } else {
//                    FetchProblemActivity.this.onServerError(errorInfo);
//                }
//                return true;
//            }
//        }, this.mVolleyErrorListener).start();
//    }
//
//    /* access modifiers changed from: private */
//    public void onGetProblemUrl(String str) {
//        C0789L.log.info("get problem url " + str);
//        pullProblem(str);
//    }
//
//    private void pullProblem(String str) {
//        new VSRequest(TAG, str, new TypeToken<Response<LinkedList<Problem>>>() {
//        }.getType(), (OnResponseListener<T>) new OnResponseListener<LinkedList<Problem>>() {
//            public boolean onResponse(ErrorInfo errorInfo, LinkedList<Problem> linkedList) {
//                if (errorInfo.getCode() == 0) {
//                    FetchProblemActivity.this.downloadProblemResource(linkedList);
//                } else {
//                    FetchProblemActivity.this.onServerError(errorInfo);
//                }
//                return true;
//            }
//        }, this.mVolleyErrorListener).start();
//    }
//
//    /* access modifiers changed from: private */
//    public void downloadProblemResource(List<Problem> list) {
//        if (list == null || list.size() == 0) {
//            finish();
//            return;
//        }
//        VSManager.getInstance().setProblems(list);
//        onDownloadSuccess();
//    }
//
//    private void onDownloadSuccess() {
//        this.mDownloadProgress.setProgress(100);
//        if (VSManager.getInstance().getRivalType() == RivalType.ONLINE) {
//            new VSRequest(TAG, Constants.getReadyUrl(VSManager.getInstance().getAvatar()), new TypeToken<Response<Object>>() {
//            }.getType(), (OnResponseListener<T>) new OnResponseListener<Object>() {
//                public boolean onResponse(ErrorInfo errorInfo, Object obj) {
//                    if (errorInfo.getCode() == 0) {
//                        FetchProblemActivity.this.pollingStart();
//                    } else {
//                        FetchProblemActivity.this.onServerError(errorInfo);
//                    }
//                    return true;
//                }
//            }, this.mVolleyErrorListener).start();
//            return;
//        }
//        setErrorTip(C0691R.string.fight_tip_on_ready);
//        this.mHandler.postDelayed(new Runnable() {
//            public void run() {
//                FetchProblemActivity.this.start();
//            }
//        }, 1000);
//    }
//
//    /* access modifiers changed from: private */
//    public void pollingStart() {
//        VSManager.getInstance().setState(VSState.READY);
//        setErrorTip(C0691R.string.fight_tip_on_ready);
//        this.mPollingStartRequest = new VSRequest<>(TAG, Constants.getStartUrl(VSManager.getInstance().getAvatar()), new TypeToken<Response<Object>>() {
//        }.getType(), (OnResponseListener<T>) new OnResponseListener<Object>() {
//            public boolean onResponse(ErrorInfo errorInfo, Object obj) {
//                if (errorInfo.getCode() == 0) {
//                    FetchProblemActivity.this.start();
//                    return true;
//                } else if (errorInfo.equals(ErrorInfo.WAITING)) {
//                    return false;
//                } else {
//                    FetchProblemActivity.this.onServerError(errorInfo);
//                    return true;
//                }
//            }
//        }, this.mVolleyErrorListener);
//        this.mPollingStartRequest.setPollingInterval(1500);
//        this.mPollingStartRequest.setPollingTimeout(30000);
//        this.mPollingStartRequest.setOnPollingTimeoutListener(new OnPollingTimeoutListener() {
//            public void onPollingTimeout() {
//                FetchProblemActivity.this.showErrorTip(FetchProblemActivity.this.getString(C0691R.string.fight_tip_wait_start_timeout));
//                C0789L.log.error("pollingStart timeout");
//                FetchProblemActivity.this.finish();
//            }
//        });
//        this.mPollingStartRequest.start();
//    }
//
//    /* access modifiers changed from: private */
//    public void start() {
//        startActivity(new Intent(this, VSActivity.class));
//        finish();
//    }
//}
