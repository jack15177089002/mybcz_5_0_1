//package com.baicizhan.client.fight.customview;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout.LayoutParams;
//import android.widget.TextView;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.PicassoUtil;
////import com.baicizhan.client.fight.R;
//import com.baicizhan.client.fight.jsonbean.Result;
//import com.baicizhan.client.fight.jsonbean.Score;
//import com.baicizhan.client.fight.jsonbean.UserInfo;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.jiongji.andriod.card.R;
//
//import java.util.Locale;
//
//public class VSScoreView extends LinearLayout {
//    public static final String TAG = "VSScoreView";
//    private static final String TIME_FORMAT = "%.1f";
//    TextView mCountMe;
//    TextView mCountPart;
//    ImageView mImageMe;
//    ImageView mImagePart;
//    TextView mNickNameMe;
//    TextView mNickNamePart;
//    ImageView mTitle;
//    TextView mUseTimeMe;
//    TextView mUseTimePart;
//    TextView mUseTimeUnitMe;
//    TextView mUseTimeUnitPart;
//
//    public VSScoreView(Context context) {
//        super(context);
//    }
//
//    public VSScoreView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mTitle = (ImageView) findViewById(R.id.vs_score_title);
//        this.mImageMe = (ImageView) findViewById(R.id.vs_score_user_image_me);
//        this.mImagePart = (ImageView) findViewById(R.id.vs_score_user_image_part);
//        this.mNickNameMe = (TextView) findViewById(R.id.vs_score_nickname_me);
//        this.mNickNamePart = (TextView) findViewById(R.id.vs_score_nickname_part);
//        this.mCountMe = (TextView) findViewById(R.id.vs_score_count_me);
//        this.mCountPart = (TextView) findViewById(R.id.vs_score_count_part);
//        this.mUseTimeMe = (TextView) findViewById(R.id.vs_score_usetime_me);
//        this.mUseTimePart = (TextView) findViewById(R.id.vs_score_usetime_part);
//        this.mUseTimeUnitMe = (TextView) findViewById(R.id.vs_score_usetime_unit_me);
//        this.mUseTimeUnitPart = (TextView) findViewById(R.id.vs_score_usetime_unit_part);
//        setCountLine(0, 70.0f, 0, 70.0f);
//    }
//
//    public void setVSScore(Result result, UserInfo userInfo, UserInfo userInfo2) {
//        if (userInfo != null && userInfo2 != null && result != null) {
//            PicassoUtil.loadAccountUserImage(getContext(), Settings.getString(Settings.PREF_BAICIZHAN_PATH), userInfo.getImage(), this.mImageMe, R.drawable.userinfo_photo_normal_default);
//            this.mNickNameMe.setText(userInfo.getDisplayName());
//            PicassoUtil.loadUserImage(getContext(), this.mImagePart, userInfo2.getImage());
//            this.mNickNamePart.setText(userInfo2.getDisplayName());
//            Score a = result.getA();
//            Score b = result.getB();
//            int useTimeSecond = (a.getUseTimeSecond() / 100) * 100;
//            int useTimeSecond2 = (b.getUseTimeSecond() / 100) * 100;
//            if (useTimeSecond == useTimeSecond2) {
//                if (1 == result.getRes()) {
//                    useTimeSecond2 += 100;
//                } else if (-1 == result.getRes()) {
//                    useTimeSecond += 100;
//                }
//            }
//            if (1 == result.getRes()) {
//                this.mTitle.setImageResource(R.drawable.fight_youwin);
//            } else if (-1 == result.getRes()) {
//                this.mTitle.setImageResource(R.drawable.fight_youlose);
//            } else {
//                this.mTitle.setImageResource(R.drawable.fight_draw);
//            }
//            setCountLine(a.getCorrectCount(), ((float) useTimeSecond) / 1000.0f, b.getCorrectCount(), ((float) useTimeSecond2) / 1000.0f);
//        }
//    }
//
//    private void setCountLine(int i, float f, int i2, float f2) {
//        this.mCountMe.setText(Integer.toString(i));
//        this.mCountPart.setText(Integer.toString(i2));
//        String format = String.format(Locale.US, TIME_FORMAT, new Object[]{Float.valueOf(f)});
//        String format2 = String.format(Locale.US, TIME_FORMAT, new Object[]{Float.valueOf(f2)});
//        this.mUseTimeMe.setText(format);
//        this.mUseTimePart.setText(format2);
//        if (format.charAt(format.length() - 1) == '1') {
//            LayoutParams layoutParams = (LayoutParams) this.mUseTimeUnitMe.getLayoutParams();
//            layoutParams.leftMargin -= DisplayUtils.dpToPx(getContext(), 5.0f);
//            this.mUseTimeUnitMe.setLayoutParams(layoutParams);
//        }
//        if (format2.charAt(format2.length() - 1) == '1') {
//            LayoutParams layoutParams2 = (LayoutParams) this.mUseTimeUnitPart.getLayoutParams();
//            layoutParams2.leftMargin -= DisplayUtils.dpToPx(getContext(), 5.0f);
//            this.mUseTimeUnitPart.setLayoutParams(layoutParams2);
//        }
//    }
//}
