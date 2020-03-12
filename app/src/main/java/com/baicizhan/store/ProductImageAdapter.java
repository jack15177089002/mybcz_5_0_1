//package com.baicizhan.store;
//
//import android.content.Context;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.ImageView.ScaleType;
//import com.baicizhan.client.business.util.ViewPagerAdapter;
//import com.baicizhan.client.business.widget.SquareImageView;
//import com.baicizhan.store.bean.KdtItemImage;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductImageAdapter extends ViewPagerAdapter {
//    private Context mContext;
//    private List<KdtItemImage> mImageList = new ArrayList();
//
//    public ProductImageAdapter(Context context) {
//        this.mContext = context;
//    }
//
//    public void setImageList(List<KdtItemImage> list) {
//        this.mImageList.clear();
//        if (list != null) {
//            this.mImageList.addAll(list);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public View getView(View view, int i) {
//        final SquareImageView squareImageView;
//        if (view == null) {
//            squareImageView = new SquareImageView(this.mContext);
//        } else {
//            squareImageView = (SquareImageView) view;
//        }
//        squareImageView.setScaleType(ScaleType.CENTER_INSIDE);
//        Picasso.with(this.mContext).load(((KdtItemImage) this.mImageList.get(i)).getUrl()).placeholder(C1392R.drawable.nativestore_loading_normal_default).into((ImageView) squareImageView, (Callback) new Callback() {
//            public void onSuccess() {
//                squareImageView.setScaleType(ScaleType.FIT_CENTER);
//            }
//
//            public void onError() {
//            }
//        });
//        return squareImageView;
//    }
//
//    public int getCount() {
//        return this.mImageList.size();
//    }
//}
