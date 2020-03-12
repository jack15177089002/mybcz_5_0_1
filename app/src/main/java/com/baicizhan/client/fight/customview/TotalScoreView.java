//package com.baicizhan.client.fight.customview;
//
//import android.content.Context;
//import android.content.res.Resources;
//import android.graphics.Point;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.ViewTreeObserver.OnPreDrawListener;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;
//import android.widget.TextView;
//import com.android.volley.Request.Priority;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.PicassoUtil;
////import com.baicizhan.client.fight.R;
//import com.baicizhan.client.fight.VSManager;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.fight.jsonbean.UserScore;
//import com.baicizhan.client.fight.util.Constants;
//import com.baicizhan.client.fight.util.Events.OnGetTotalScore;
//import com.baicizhan.client.fight.util.GsonRequest;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.Locale;
////import p000a.p001a.p002a.EventBus;
//
//public class TotalScoreView extends LinearLayout {
//    private static final String TAG = "TotalScoreView";
//    private TextView mBookAndVocabulary;
//    /* access modifiers changed from: private */
//    public TextView[] mCounts;
//    private ImageView mImage;
//    private TextView mLoseCount;
//    private TextView mNickName;
//    private TextView mWinCount;
//
//    public TotalScoreView(Context context) {
//        super(context);
//    }
//
//    public TotalScoreView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mImage = (ImageView) findViewById(R.id.vs_total_score_user_image);
//        this.mNickName = (TextView) findViewById(R.id.vs_total_score_user_name);
//        this.mWinCount = (TextView) findViewById(R.id.vs_total_score_win_count);
//        this.mLoseCount = (TextView) findViewById(R.id.vs_total_score_lose_count);
//        this.mCounts = new TextView[]{this.mWinCount, this.mLoseCount};
//        this.mBookAndVocabulary = (TextView) findViewById(R.id.vs_total_score_book_and_vocabulary);
//        this.mWinCount.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
//            private boolean isMeasured = false;
//
//            public boolean onPreDraw() {
//                TextView[] access$000;
//                if (!this.isMeasured) {
//                    for (TextView textView : TotalScoreView.this.mCounts) {
//                        float measureText = textView.getPaint().measureText(textView.getText().toString());
//                        int measuredWidth = (textView.getMeasuredWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
//                        if (((float) measuredWidth) < measureText) {
//                            textView.setTextScaleX(((float) measuredWidth) / (measureText + 1.0f));
//                        }
//                    }
//                    this.isMeasured = true;
//                }
//                return true;
//            }
//        });
//        adjustSize();
//        this.mWinCount.setText("0");
//        this.mLoseCount.setText("0");
//    }
//
//    public void adjustSize() {
//        Point displayDpSize = DisplayUtils.getDisplayDpSize(getContext());
//        Resources resources = getContext().getResources();
//        if (displayDpSize.x <= 480) {
//            int dpToPx = DisplayUtils.dpToPx(getContext(), 10.0f);
//            setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
//            LayoutParams layoutParams = (LayoutParams) this.mImage.getLayoutParams();
//            layoutParams.width = resources.getDimensionPixelSize(R.dimen.fight_total_score_image_size_small);
//            layoutParams.height = resources.getDimensionPixelSize(R.dimen.fight_total_score_image_size_small);
//        }
//    }
//
//    public void setUserInfo(UserInfo userInfo) {
//        if (userInfo != null) {
//            PicassoUtil.loadAccountUserImage(getContext(), Settings.getString(Settings.PREF_BAICIZHAN_PATH), userInfo.getImage(), this.mImage, R.drawable.userinfo_photo_normal_default);
//            this.mNickName.setText(userInfo.getDisplayName());
//        }
//    }
//
//    public void setTotalScore(UserScore userScore) {
//        if (userScore != null) {
//            this.mWinCount.setText(Integer.toString(userScore.getWinCount()));
//            this.mLoseCount.setText(Integer.toString(userScore.getLoseCount()));
//            String book = userScore.getBook();
//            int vocabulary = userScore.getVocabulary();
//            if (!TextUtils.isEmpty(book) && this.mBookAndVocabulary.getVisibility() == 0) {
//                if (vocabulary > 0) {
//                    this.mBookAndVocabulary.setText(String.format(Locale.CHINA, "%s 词汇量:%d", new Object[]{book, Integer.valueOf(vocabulary)}));
//                    return;
//                }
//                this.mBookAndVocabulary.setText(String.format(Locale.CHINA, "%s 词汇量:未知", new Object[]{book}));
//            }
//        }
//    }
//
//    public void hideBook() {
//        this.mBookAndVocabulary.setVisibility(8);
//    }
//
//    public void refreshTotalScore() {
//        UserInfo avatar = VSManager.getInstance().getAvatar();
//        setTotalScore(VSManager.getInstance().getTotalScore());
//        GsonRequest gsonRequest = new GsonRequest(0, Constants.getQueryTotalScoreUrl(avatar), new TypeToken<Response<UserScore>>() {
//        }.getType(), null, new Listener<Response<UserScore>>() {
//            public void onResponse(Response<UserScore> response) {
//                UserScore userScore = (UserScore) response.getData();
//                VSManager.getInstance().setTotalScore(userScore);
//                TotalScoreView.this.setTotalScore(userScore);
////                EventBus.m0a().mo9c((Object) new OnGetTotalScore());
//            }
//        }, new ErrorListener() {
//            public void onErrorResponse(VolleyError volleyError) {
//                C0789L.log.debug("error " + volleyError.getMessage());
//                VSManager.getInstance().isInfoPanelSynced = false;
//            }
//        });
//        gsonRequest.setTag(TAG);
//        gsonRequest.setPriority(Priority.HIGH);
//        VolleyUtils.send(gsonRequest);
//    }
//
//    public void onDestroy() {
//        VolleyUtils.cancelAllTagRequest(TAG);
//    }
//}
