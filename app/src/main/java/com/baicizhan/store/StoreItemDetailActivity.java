//package com.baicizhan.store;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.net.Uri;
//import android.os.Bundle;
//import androidx.viewpager.widget.ViewPager;// import android.support.p004v4.view.ViewPager;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.business.widget.CirPageIndicator;
//import com.baicizhan.store.api.YouZanStore;
//import com.baicizhan.store.bean.KdtItem;
//
//public class StoreItemDetailActivity extends Activity {
//    public static final String EXTRA_STORE_ITEM = "extra_store_item";
//    public static final String EXTRA_STORE_ITEM_OUTTER_ID = "extra_store_item_outter_id";
//    public static final String TMALL_BASE_URL = "http://detail.tmall.com/item.htm?id=";
//    private ProductDetailAdapter mAdapter;
//    private Button mBuyBtn;
//    /* access modifiers changed from: private */
//    public View mBuyLayout;
//    /* access modifiers changed from: private */
//    public TextView mFailTip;
//    private CirPageIndicator mIndicator;
//    /* access modifiers changed from: private */
//    public ListView mList;
//    private TextView mNum;
//    private TextView mOriginPrice;
//    private String mOutterId;
//    private TextView mPostFee;
//    private TextView mPrice;
//    private ViewPager mProductImagePager;
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//    /* access modifiers changed from: private */
//    public View mShadow;
//    private TextView mTitle;
//
//    public static Intent getStartIntent(Context context, String str) {
//        Intent intent = new Intent(context, StoreItemDetailActivity.class);
//        intent.putExtra(EXTRA_STORE_ITEM_OUTTER_ID, str);
//        return intent;
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setContentView(C1392R.layout.store_item_detail_main);
//        init();
//    }
//
//    private void init() {
//        KdtItem kdtItem = (KdtItem) getIntent().getSerializableExtra(EXTRA_STORE_ITEM);
//        if (kdtItem == null) {
//            this.mOutterId = getIntent().getStringExtra(EXTRA_STORE_ITEM_OUTTER_ID);
//            if (TextUtils.isEmpty(this.mOutterId)) {
//                throw new IllegalStateException("必须通过 EXTRA_STORE_ITEM 传入商品数据!");
//            }
//        }
//        this.mList = (ListView) findViewById(C1392R.C1393id.product_detail_list);
//        this.mBuyBtn = (Button) findViewById(C1392R.C1393id.buy_btn);
//        ThemeResUtil.setBackgroundColorShape(this, this.mBuyBtn, Color.parseColor("#ff6600"), Color.parseColor("#ef6d16"), 4.0f);
//        this.mBuyLayout = findViewById(C1392R.C1393id.buy_layout);
//        this.mShadow = findViewById(C1392R.C1393id.shadow);
//        this.mFailTip = (TextView) findViewById(C1392R.C1393id.fail_tip);
//        this.mFailTip.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                StoreItemDetailActivity.this.loadProduct();
//            }
//        });
//        this.mProgressDialog = new BczLoadingDialog(this);
//        this.mProgressDialog.setMessage(getText(C1392R.string.loading_progress));
//        this.mProgressDialog.setCancelable(false);
//        if (kdtItem == null) {
//            this.mList.setVisibility(8);
//            this.mBuyLayout.setVisibility(8);
//            this.mShadow.setVisibility(8);
//            loadProduct();
//            return;
//        }
//        feed(kdtItem);
//    }
//
//    /* access modifiers changed from: private */
//    public void loadProduct() {
//        this.mFailTip.setVisibility(8);
//        this.mProgressDialog.show();
//        final String str = this.mOutterId;
//        new Thread() {
//            public void run() {
//                try {
//                    StoreItemDetailActivity.this.loadFinished(YouZanStore.getSoldItem(str));
//                } catch (Exception e) {
//                    StoreItemDetailActivity.this.loadFinished(null);
//                }
//            }
//        }.start();
//    }
//
//    /* access modifiers changed from: private */
//    public void loadFinished(final KdtItem kdtItem) {
//        runOnUiThread(new Runnable() {
//            public void run() {
//                StoreItemDetailActivity.this.mProgressDialog.cancel();
//                if (kdtItem == null) {
//                    StoreItemDetailActivity.this.mFailTip.setVisibility(0);
//                    return;
//                }
//                StoreItemDetailActivity.this.mList.setVisibility(0);
//                StoreItemDetailActivity.this.mBuyLayout.setVisibility(0);
//                StoreItemDetailActivity.this.mShadow.setVisibility(0);
//                StoreItemDetailActivity.this.feed(kdtItem);
//            }
//        });
//    }
//
//    /* access modifiers changed from: private */
//    public void feed(final KdtItem kdtItem) {
//        View inflate = View.inflate(this, C1392R.layout.store_item_detail_header, null);
//        this.mProductImagePager = (ViewPager) inflate.findViewById(C1392R.C1393id.product_image_pager);
//        this.mIndicator = (CirPageIndicator) inflate.findViewById(C1392R.C1393id.product_image_indicator);
//        this.mTitle = (TextView) inflate.findViewById(C1392R.C1393id.product_title);
//        this.mPrice = (TextView) inflate.findViewById(C1392R.C1393id.product_price);
//        this.mOriginPrice = (TextView) inflate.findViewById(C1392R.C1393id.product_origin_price);
//        this.mNum = (TextView) inflate.findViewById(C1392R.C1393id.product_num);
//        this.mPostFee = (TextView) inflate.findViewById(C1392R.C1393id.product_post_fee);
//        ProductImageAdapter productImageAdapter = new ProductImageAdapter(this);
//        productImageAdapter.setImageList(kdtItem.getItem_imgs());
//        this.mProductImagePager.setAdapter(productImageAdapter);
//        this.mIndicator.setViewPager(this.mProductImagePager);
//        if (productImageAdapter.getCount() <= 1) {
//            this.mIndicator.setVisibility(4);
//        }
//        this.mOriginPrice.getPaint().setFlags(16);
//        this.mTitle.setText(kdtItem.getTitle());
//        this.mPrice.setText(kdtItem.getPrice());
//        if (!TextUtils.isEmpty(kdtItem.getOrigin_price())) {
//            this.mOriginPrice.setText(kdtItem.getOrigin_price());
//        }
//        this.mNum.setText(String.valueOf(kdtItem.getNum()));
//        this.mPostFee.setText("￥" + kdtItem.getDisplayPostFee());
//        this.mList.addHeaderView(inflate);
//        this.mAdapter = new ProductDetailAdapter(this);
//        this.mAdapter.setItemImages(YouZanStore.parseDescImageList(kdtItem.getDesc()));
//        this.mList.setAdapter(this.mAdapter);
//        this.mBuyBtn.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                StoreItemDetailActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(StoreItemDetailActivity.TMALL_BASE_URL).append(kdtItem.getOuter_id()).toString())));
//            }
//        });
//        OperationStats.statNative(kdtItem.getOuter_id());
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
//}
