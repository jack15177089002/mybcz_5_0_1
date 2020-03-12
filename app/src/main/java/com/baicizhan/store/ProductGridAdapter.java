//package com.baicizhan.store;
//
//import android.content.Context;
//import android.os.Build.VERSION;
//import android.text.Html;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AbsListView.LayoutParams;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.ImageView.ScaleType;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.PicassoUtil.Corners;
//import com.baicizhan.client.business.util.PicassoUtil.RoundedTransformation;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.widget.KeepRatioImageView;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.store.bean.KdtItem;
//import com.baicizhan.store.bean.KdtItemTag;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.Transformation;
//import com.tonicartos.widget.stickygridheaders.StickyGridHeadersBaseAdapter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedHashMap;
//import java.util.List;
//
//public class ProductGridAdapter extends BaseAdapter implements StickyGridHeadersBaseAdapter {
//    public static final String PRICE_FORMAT = "￥ <b>%s</b>";
//    public static final int[] TAG_IMAGES = {C1392R.drawable.store_header, C1392R.drawable.store_header_book, C1392R.drawable.store_header_xiangxing, C1392R.drawable.store_header_xianliang, C1392R.drawable.store_header_zhoubian, C1392R.drawable.store_header_kids};
//    public static final List<String> TAG_NAMES = Arrays.asList(new String[]{"", "百词斩单词书系列", "百词斩象形系列", "百词斩限量系列", "百词斩周边系列", "百词斩KIDS儿童系列"});
//    private Context mContext;
//    private LayoutInflater mInflater;
//    private List<KdtItem> mItems = new ArrayList();
//    private LinkedHashMap<String, List<KdtItem>> mItemsMap = new LinkedHashMap<>();
//    private RoundedTransformation mTransformation;
//
//    class ViewHolder {
//        ImageView productImg;
//        TextView productPrice;
//        TextView productTitle;
//
//        private ViewHolder() {
//        }
//    }
//
//    public ProductGridAdapter(Context context) {
//        this.mContext = context;
//        this.mInflater = LayoutInflater.from(context);
//        this.mTransformation = new RoundedTransformation(DisplayUtils.dpToPx(context, 4.0f), Corners.TOP);
//        for (String put : TAG_NAMES) {
//            this.mItemsMap.put(put, new ArrayList());
//        }
//    }
//
//    public List<KdtItem> getItems() {
//        return this.mItems;
//    }
//
//    public void setItems(List<KdtItem> list) {
//        for (List clear : this.mItemsMap.values()) {
//            clear.clear();
//        }
//        this.mItems.clear();
//        if (list != null && list.size() != 0) {
//            for (KdtItem kdtItem : list) {
//                String str = (String) TAG_NAMES.get(0);
//                List item_tags = kdtItem.getItem_tags();
//                if (item_tags != null && item_tags.size() > 0) {
//                    String name = ((KdtItemTag) item_tags.get(0)).getName();
//                    if (TAG_NAMES.contains(name)) {
//                        str = name;
//                    }
//                }
//                ((List) this.mItemsMap.get(str)).add(kdtItem);
//            }
//            for (List addAll : this.mItemsMap.values()) {
//                this.mItems.addAll(addAll);
//            }
//        }
//    }
//
//    public int getCount() {
//        return this.mItems.size();
//    }
//
//    public KdtItem getItem(int i) {
//        return (KdtItem) this.mItems.get(i);
//    }
//
//    public long getItemId(int i) {
//        return (long) i;
//    }
//
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        if (view == null) {
//            view = this.mInflater.inflate(C1392R.layout.store_grid_item, null);
//            ThemeResUtil.setShape(this.mContext, view, -1, 4);
//            ViewHolder viewHolder = new ViewHolder();
//            viewHolder.productImg = (ImageView) view.findViewById(C1392R.C1393id.product_image);
//            viewHolder.productTitle = (TextView) view.findViewById(C1392R.C1393id.product_title);
//            viewHolder.productPrice = (TextView) view.findViewById(C1392R.C1393id.product_price);
//            view.setTag(viewHolder);
//            View findViewById = view.findViewById(C1392R.C1393id.divider);
//            if (VERSION.SDK_INT >= 11) {
//                findViewById.setLayerType(1, null);
//            }
//        }
//        if (!(view.getTag() instanceof ViewHolder)) {
//            C0789L.log.error("product grid adapter getView error, convert view tag [{}], position [{}]", view.getTag(), (Object) Integer.valueOf(i));
//        } else {
//            final ViewHolder viewHolder2 = (ViewHolder) view.getTag();
//            KdtItem item = getItem(i);
//            viewHolder2.productImg.setScaleType(ScaleType.CENTER_INSIDE);
//            Picasso.with(this.mContext).load(item.getPic_url()).mo16332a((Transformation) this.mTransformation).placeholder(C1392R.drawable.nativestore_loading_normal_default).into(viewHolder2.productImg, (Callback) new Callback() {
//                public void onSuccess() {
//                    viewHolder2.productImg.setScaleType(ScaleType.FIT_CENTER);
//                }
//
//                public void onError() {
//                }
//            });
//            viewHolder2.productTitle.setText(item.getTitle());
//            viewHolder2.productPrice.setText(Html.fromHtml(String.format(PRICE_FORMAT, new Object[]{item.getPrice()})));
//        }
//        return view;
//    }
//
//    public int getCountForHeader(int i) {
//        return ((List) this.mItemsMap.get(TAG_NAMES.get(i))).size();
//    }
//
//    public int getNumHeaders() {
//        return this.mItemsMap.size();
//    }
//
//    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
//        View view2;
//        if (view == 0) {
//            KeepRatioImageView keepRatioImageView = new KeepRatioImageView(this.mContext);
//            keepRatioImageView.setScaleType(ScaleType.FIT_XY);
//            keepRatioImageView.setLayoutParams(new LayoutParams(-1, -2));
//            view2 = keepRatioImageView;
//        } else {
//            view2 = view;
//        }
//        ((ImageView) view2).setImageResource(TAG_IMAGES[i]);
//        return view2;
//    }
//}
