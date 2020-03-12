//package com.baicizhan.store.bean;
//
//import java.io.Serializable;
//import java.util.List;
//import p012ch.qos.logback.core.CoreConstants;
//
//public class KdtItem implements Serializable {
//    private String alias;
//    private int cid;
//    private String delivery_template_fee;
//    private String desc;
//    private String detail_url;
//    private List<KdtItemImage> item_imgs;
//    private List<KdtItemTag> item_tags;
//    private int num;
//    private String num_iid;
//    private String origin_price;
//    private String outer_buy_url;
//    private String outer_id;
//    private String pic_thumb_url;
//    private String pic_url;
//    private String post_fee;
//    private int post_type;
//    private String price;
//    private int promotion_cid;
//    private int sold_num;
//    private String tag_ids;
//    private String title;
//
//    public String getNum_iid() {
//        return this.num_iid;
//    }
//
//    public void setNum_iid(String str) {
//        this.num_iid = str;
//    }
//
//    public String getAlias() {
//        return this.alias;
//    }
//
//    public void setAlias(String str) {
//        this.alias = str;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public void setTitle(String str) {
//        this.title = str;
//    }
//
//    public int getCid() {
//        return this.cid;
//    }
//
//    public void setCid(int i) {
//        this.cid = i;
//    }
//
//    public int getPromotion_cid() {
//        return this.promotion_cid;
//    }
//
//    public void setPromotion_cid(int i) {
//        this.promotion_cid = i;
//    }
//
//    public String getTag_ids() {
//        return this.tag_ids;
//    }
//
//    public void setTag_ids(String str) {
//        this.tag_ids = str;
//    }
//
//    public String getDesc() {
//        return this.desc;
//    }
//
//    public void setDesc(String str) {
//        this.desc = str;
//    }
//
//    public String getOrigin_price() {
//        return this.origin_price;
//    }
//
//    public void setOrigin_price(String str) {
//        this.origin_price = str;
//    }
//
//    public String getOuter_id() {
//        return this.outer_id;
//    }
//
//    public void setOuter_id(String str) {
//        this.outer_id = str;
//    }
//
//    public String getOuter_buy_url() {
//        return this.outer_buy_url;
//    }
//
//    public void setOuter_buy_url(String str) {
//        this.outer_buy_url = str;
//    }
//
//    public String getDetail_url() {
//        return this.detail_url;
//    }
//
//    public void setDetail_url(String str) {
//        this.detail_url = str;
//    }
//
//    public String getPic_url() {
//        return this.pic_url;
//    }
//
//    public void setPic_url(String str) {
//        this.pic_url = str;
//    }
//
//    public String getPic_thumb_url() {
//        return this.pic_thumb_url;
//    }
//
//    public void setPic_thumb_url(String str) {
//        this.pic_thumb_url = str;
//    }
//
//    public int getNum() {
//        return this.num;
//    }
//
//    public void setNum(int i) {
//        this.num = i;
//    }
//
//    public int getSold_num() {
//        return this.sold_num;
//    }
//
//    public void setSold_num(int i) {
//        this.sold_num = i;
//    }
//
//    public String getPrice() {
//        return this.price;
//    }
//
//    public void setPrice(String str) {
//        this.price = str;
//    }
//
//    public String getPost_fee() {
//        return this.post_fee;
//    }
//
//    public void setPost_fee(String str) {
//        this.post_fee = str;
//    }
//
//    public int getPost_type() {
//        return this.post_type;
//    }
//
//    public void setPost_type(int i) {
//        this.post_type = i;
//    }
//
//    public String getDelivery_template_fee() {
//        return this.delivery_template_fee;
//    }
//
//    public void setDelivery_template_fee(String str) {
//        this.delivery_template_fee = str;
//    }
//
//    public List<KdtItemImage> getItem_imgs() {
//        return this.item_imgs;
//    }
//
//    public void setItem_imgs(List<KdtItemImage> list) {
//        this.item_imgs = list;
//    }
//
//    public List<KdtItemTag> getItem_tags() {
//        return this.item_tags;
//    }
//
//    public void setItem_tags(List<KdtItemTag> list) {
//        this.item_tags = list;
//    }
//
//    public String toString() {
//        return "KdtItem{num_iid='" + this.num_iid + CoreConstants.SINGLE_QUOTE_CHAR + ", alias='" + this.alias + CoreConstants.SINGLE_QUOTE_CHAR + ", title='" + this.title + CoreConstants.SINGLE_QUOTE_CHAR + ", cid=" + this.cid + ", promotion_cid=" + this.promotion_cid + ", tag_ids='" + this.tag_ids + CoreConstants.SINGLE_QUOTE_CHAR + ", desc='" + this.desc + CoreConstants.SINGLE_QUOTE_CHAR + ", origin_price='" + this.origin_price + CoreConstants.SINGLE_QUOTE_CHAR + ", outer_id='" + this.outer_id + CoreConstants.SINGLE_QUOTE_CHAR + ", outer_buy_url='" + this.outer_buy_url + CoreConstants.SINGLE_QUOTE_CHAR + ", detail_url='" + this.detail_url + CoreConstants.SINGLE_QUOTE_CHAR + ", pic_url='" + this.pic_url + CoreConstants.SINGLE_QUOTE_CHAR + ", pic_thumb_url='" + this.pic_thumb_url + CoreConstants.SINGLE_QUOTE_CHAR + ", num=" + this.num + ", sold_num=" + this.sold_num + ", price='" + this.price + CoreConstants.SINGLE_QUOTE_CHAR + ", post_type=" + this.post_type + ", post_fee='" + this.post_fee + CoreConstants.SINGLE_QUOTE_CHAR + ", delivery_template_fee='" + this.delivery_template_fee + CoreConstants.SINGLE_QUOTE_CHAR + ", item_imgs=" + this.item_imgs + ", item_tags=" + this.item_tags + CoreConstants.CURLY_RIGHT;
//    }
//
//    public String getDisplayPostFee() {
//        if (this.post_type == 1) {
//            return this.post_fee;
//        }
//        if (this.delivery_template_fee == null) {
//            return "0.00";
//        }
//        String[] split = this.delivery_template_fee.split(",");
//        if (split.length <= 1) {
//            return this.delivery_template_fee;
//        }
//        return split[split.length - 1];
//    }
//}
