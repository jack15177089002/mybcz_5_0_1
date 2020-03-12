//package com.baicizhan.store;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AbsListView.LayoutParams;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.ImageView.ScaleType;
//import com.baicizhan.client.business.widget.KeepRatioImageView;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import java.util.List;
//
//public class ProductDetailAdapter extends BaseAdapter {
//    private Context mContext;
//    private List<String> mItemImages;
//
//    public ProductDetailAdapter(Context context) {
//        this.mContext = context;
//    }
//
//    public List<String> getItemImages() {
//        return this.mItemImages;
//    }
//
//    public void setItemImages(List<String> list) {
//        this.mItemImages = list;
//    }
//
//    public int getCount() {
//        if (this.mItemImages == null) {
//            return 0;
//        }
//        return this.mItemImages.size();
//    }
//
//    public String getItem(int i) {
//        return (String) this.mItemImages.get(i);
//    }
//
//    public long getItemId(int i) {
//        return (long) i;
//    }
//
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View view2;
//        if (view == 0) {
//            KeepRatioImageView keepRatioImageView = new KeepRatioImageView(this.mContext);
//            keepRatioImageView.setScaleType(ScaleType.FIT_XY);
//            keepRatioImageView.setLayoutParams(new LayoutParams(-1, -2));
//            view2 = keepRatioImageView;
//        } else {
//            view2 = view;
//        }
//        Picasso.with(this.mContext).load((String) this.mItemImages.get(i)).into((ImageView) view2, (Callback) null);
//        return view2;
//    }
//}
