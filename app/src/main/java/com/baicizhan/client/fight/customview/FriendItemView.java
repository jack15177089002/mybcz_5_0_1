package com.baicizhan.client.fight.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import com.baicizhan.client.business.util.PicassoUtil;
import com.baicizhan.client.business.widget.CircleImageView;
//import com.baicizhan.client.fight.R;
import com.baicizhan.client.fight.VSManager;
import com.baicizhan.client.fight.jsonbean.FriendInfo;
import com.jiongji.andriod.card.R;
import com.p013a.p014a.SwipeLayout;

public class FriendItemView extends SwipeLayout {
    public Button deleteFriend;
    public CircleImageView image;
    public TextView loseCount;
    int mAvatarBorderColor;
    Paint mDividerPaint;
    int mFriendBorderColor;
    public TextView nickName;
    public TextView rankingNumber;
    public TextView winCount;

    public FriendItemView(Context context) {
        this(context, null);
    }

    public FriendItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FriendItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDividerPaint = new Paint(1);
        this.mDividerPaint.setColor(context.getResources().getColor(R.color.fight_def_blue_color));
        this.mDividerPaint.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.fight_friend_rank_divider_height));
        this.mAvatarBorderColor = context.getResources().getColor(R.color.fight_def_blue_color);
        this.mFriendBorderColor = context.getResources().getColor(R.color.fight_def_gray_color);
        setSwipeEnabled(false);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.rankingNumber = (TextView) findViewById(R.id.friend_ranking_number);
        this.image = (CircleImageView) findViewById(R.id.friend_image);
        this.nickName = (TextView) findViewById(R.id.friend_nickname);
        this.winCount = (TextView) findViewById(R.id.friend_score_win_count);
        this.loseCount = (TextView) findViewById(R.id.friend_score_lose_count);
        this.deleteFriend = (Button) findViewById(R.id.delete_friend);
    }

    public void updateData(int i, int i2, FriendInfo friendInfo) {
        this.rankingNumber.setText(Integer.toString(friendInfo.getRank()));
        this.rankingNumber.getBackground().setAlpha(i2);
        this.mDividerPaint.setAlpha(i2);
        PicassoUtil.loadUserImage(getContext(), this.image, friendInfo.getImage());
        this.winCount.setText(Integer.toString(friendInfo.getWinCount()));
        this.loseCount.setText(Integer.toString(friendInfo.getLoseCount()));
        if (friendInfo.isSelf()) {
            setBackgroundColor(this.mAvatarBorderColor);
            getBackground().setAlpha(20);
            this.nickName.setText(VSManager.getInstance().getAvatar().getDisplayName());
            this.nickName.setTextColor(this.mAvatarBorderColor);
            this.image.setBorderColor(this.mAvatarBorderColor);
            return;
        }
        setBackgroundColor(0);
        this.nickName.setText(friendInfo.getDisplayName());
        this.nickName.setTextColor(this.mFriendBorderColor);
        this.image.setBorderColor(this.mFriendBorderColor);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        float height = ((float) getHeight()) - this.mDividerPaint.getStrokeWidth();
        canvas.drawLine(0.0f, height, (float) getWidth(), height, this.mDividerPaint);
    }
}
