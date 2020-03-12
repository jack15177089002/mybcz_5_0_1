//package com.baicizhan.store;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ListAdapter;
//import android.widget.TextView;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.store.api.YouZanStore;
//import com.baicizhan.store.bean.KdtItem;
//import com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView;
//import java.util.List;
//
//public class InternalStoreActivity extends Activity implements OnItemClickListener {
//    /* access modifiers changed from: private */
//    public ProductGridAdapter mAdapter;
//    /* access modifiers changed from: private */
//    public TextView mEmptyView;
//    /* access modifiers changed from: private */
//    public StickyGridHeadersGridView mItemsGrid;
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setContentView(C1392R.layout.store_main);
//        this.mProgressDialog = new BczLoadingDialog(this);
//        this.mProgressDialog.setMessage(getText(C1392R.string.loading_progress));
//        this.mProgressDialog.setCancelable(false);
//        this.mItemsGrid = (StickyGridHeadersGridView) findViewById(C1392R.C1393id.items_grid);
//        this.mItemsGrid.setAreHeadersSticky(false);
//        this.mAdapter = new ProductGridAdapter(this);
//        this.mItemsGrid.setAdapter((ListAdapter) this.mAdapter);
//        this.mItemsGrid.setOnItemClickListener(this);
//        this.mEmptyView = (TextView) findViewById(C1392R.C1393id.empty_text);
//        this.mEmptyView.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                InternalStoreActivity.this.loadProducts();
//            }
//        });
//        loadProducts();
//        OperationStats.statNativeIndex();
//    }
//
//    /* access modifiers changed from: private */
//    public void loadProducts() {
//        this.mEmptyView.setVisibility(8);
//        this.mItemsGrid.setVisibility(4);
//        this.mProgressDialog.show();
//        new Thread() {
//            public void run() {
//                try {
//                    InternalStoreActivity.this.loadFinished(YouZanStore.getAllSoldItems());
//                } catch (Exception e) {
//                    InternalStoreActivity.this.loadFinished(null);
//                }
//            }
//        }.start();
//    }
//
//    /* access modifiers changed from: private */
//    public void loadFinished(final List<KdtItem> list) {
//        runOnUiThread(new Runnable() {
//            public void run() {
//                InternalStoreActivity.this.mAdapter.setItems(list);
//                InternalStoreActivity.this.mProgressDialog.cancel();
//                if (InternalStoreActivity.this.mAdapter.getCount() == 0) {
//                    InternalStoreActivity.this.mEmptyView.setVisibility(0);
//                    InternalStoreActivity.this.mItemsGrid.setVisibility(4);
//                } else {
//                    InternalStoreActivity.this.mEmptyView.setVisibility(8);
//                    InternalStoreActivity.this.mItemsGrid.setVisibility(0);
//                }
//                InternalStoreActivity.this.mProgressDialog.cancel();
//                InternalStoreActivity.this.mAdapter.notifyDataSetChanged();
//            }
//        });
//    }
//
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
//        KdtItem item = this.mAdapter.getItem(i);
//        Intent intent = new Intent(this, StoreItemDetailActivity.class);
//        intent.putExtra(StoreItemDetailActivity.EXTRA_STORE_ITEM, item);
//        intent.addFlags(268435456);
//        startActivity(intent);
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
//        OperationStats.getInstance().stat(this);
//    }
//}
