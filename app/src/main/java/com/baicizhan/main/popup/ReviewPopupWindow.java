//package com.baicizhan.main.popup;
//
//import android.content.Context;
//import android.content.res.ColorStateList;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.PopupWindow;
//import android.widget.TextView;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.ColorStateListUtils;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.selftest.activity.SelfTestActivity;
//import com.baicizhan.main.selftest.activity.WalkListenEnter;
//import com.baicizhan.main.wordlist.activity.WordListActivity;
//import com.jiongji.andriod.card.R;
//
//public class ReviewPopupWindow extends PopupWindow {
//    private OnClickListener mClickListener = new OnClickListener() {
//        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.item_wordlist /*2131296989*/:
//                    WordListActivity.start(ReviewPopupWindow.this.mContext);
//                    OperationStats.statMenuList();
//                    ReviewPopupWindow.this.dismiss();
//                    return;
//                case R.id.item_walkandlisten /*2131296991*/:
//                    WalkListenEnter.start(ReviewPopupWindow.this.mContext);
//                    OperationStats.statMenuListen();
//                    ReviewPopupWindow.this.dismiss();
//                    return;
//                case R.id.item_selfcheck /*2131296993*/:
//                    SelfTestActivity.start(ReviewPopupWindow.this.mContext);
//                    OperationStats.statMenuCheck();
//                    ReviewPopupWindow.this.dismiss();
//                    return;
//                default:
//                    return;
//            }
//        }
//    };
//    /* access modifiers changed from: private */
//    public Context mContext;
//
//    public ReviewPopupWindow(Context context) {
//        super(context);
//        this.mContext = context;
//        init();
//    }
//
//    private void init() {
//        setWidth(DisplayUtils.dpToPx(this.mContext, 115.0f));
//        setHeight(DisplayUtils.dpToPx(this.mContext, 140.0f));
//        setFocusable(true);
//        setTouchable(true);
//        setOutsideTouchable(false);
//        setAnimationStyle(2131492866);
//        setBackgroundDrawable(this.mContext.getResources().getDrawable(17170445));
//        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.popup_review, null);
//        ThemeResUtil.setBackgroundShape(this.mContext, inflate.findViewById(R.id.items_bg), R.attr.color_common_white, 4.0f);
//        inflate.findViewById(R.id.item_wordlist).setOnClickListener(this.mClickListener);
//        inflate.findViewById(R.id.item_walkandlisten).setOnClickListener(this.mClickListener);
//        inflate.findViewById(R.id.item_selfcheck).setOnClickListener(this.mClickListener);
//        ColorStateList simpleThemeColorStateListWithAttr = ColorStateListUtils.getSimpleThemeColorStateListWithAttr(this.mContext, R.attr.color_button_text, R.attr.color_progress);
//        ((TextView) inflate.findViewById(R.id.item_wordlist_txt)).setTextColor(simpleThemeColorStateListWithAttr);
//        ((TextView) inflate.findViewById(R.id.item_walkandlisten_txt)).setTextColor(simpleThemeColorStateListWithAttr);
//        ((TextView) inflate.findViewById(R.id.item_selfcheck_txt)).setTextColor(simpleThemeColorStateListWithAttr);
//        setContentView(inflate);
//    }
//}
