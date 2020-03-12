//package com.baicizhan.client.friend.adapter;
//
//import android.content.Context;
//import android.graphics.drawable.GradientDrawable;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.GsonRequest;
//import com.baicizhan.client.framework.network.VolleyUtils;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.model.FriendRecord;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.utils.FriendURL;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.lang.reflect.Type;
//import java.util.Collections;
//import java.util.List;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class FriendSuggestionAdapter extends BaseAdapter {
//    public static final String TAG = FriendSuggestionAdapter.class.getSimpleName();
//    private String mBookLabel;
//    /* access modifiers changed from: private */
//    public Context mContext;
//    private LayoutInflater mInflator;
//    private List<FriendRecord> mItems = Collections.emptyList();
//    private Mode mMode;
//    private String mVocabularyLabel;
//
//    public enum Mode {
//        SYSTEM,
//        SEARCH
//    }
//
//    class ViewHolder {
//        public View invite;
//        public View invited;
//        public TextView name;
//        public TextView text1;
//        public TextView text2;
//        public ImageView thumb;
//
//        ViewHolder() {
//        }
//    }
//
//    public FriendSuggestionAdapter(Context context, Mode mode) {
//        this.mContext = context;
//        this.mInflator = LayoutInflater.from(context);
//        this.mMode = mode;
//        this.mBookLabel = context.getString(R.string.friend_current_book_label);
//        this.mVocabularyLabel = context.getString(R.string.friend_current_vocabulary_label);
//    }
//
//    public void update(List<FriendRecord> list) {
//        this.mItems = list;
//        notifyDataSetChanged();
//    }
//
//    public int getCount() {
//        return this.mItems.size();
//    }
//
//    public Object getItem(int i) {
//        return this.mItems.get(i);
//    }
//
//    public long getItemId(int i) {
//        return (long) i;
//    }
//
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        if (view == null) {
//            view = generateView(i, viewGroup);
//        }
//        fillView(i, view);
//        return view;
//    }
//
//    private View generateView(int i, ViewGroup viewGroup) {
//        View inflate = this.mInflator.inflate(this.mMode == Mode.SYSTEM ? R.layout.friend_suggestion_item : R.layout.friend_search_item, viewGroup, false);
//        ViewHolder viewHolder = new ViewHolder();
//        viewHolder.thumb = (ImageView) inflate.findViewById(R.id.thumb);
//        viewHolder.name = (TextView) inflate.findViewById(R.id.name);
//        viewHolder.text1 = (TextView) inflate.findViewById(R.id.text1);
//        viewHolder.text2 = (TextView) inflate.findViewById(R.id.text2);
//        viewHolder.invite = inflate.findViewById(R.id.invite);
//        viewHolder.invited = inflate.findViewById(R.id.invited);
//        inflate.setTag(viewHolder);
//        return inflate;
//    }
//
//    private void fillView(final int i, View view) {
//        final ViewHolder viewHolder = (ViewHolder) view.getTag();
//        FriendRecord friendRecord = (FriendRecord) this.mItems.get(i);
//        PicassoUtil.loadUserImage(this.mContext, viewHolder.thumb, friendRecord.getImage());
//        viewHolder.name.setText(friendRecord.getLocalName());
//        if (this.mMode == Mode.SYSTEM) {
//            viewHolder.text1.setText(this.mBookLabel + friendRecord.getBook());
//            viewHolder.text2.setText(friendRecord.getReason());
//            View view2 = (View) viewHolder.thumb.getParent();
//            GradientDrawable gradientDrawable = new GradientDrawable();
//            gradientDrawable.setStroke(1, this.mContext.getResources().getColor(R.color.business_dc3));
//            gradientDrawable.setShape(0);
//            gradientDrawable.setColor(0);
//            C1604j.m3631a(view2, gradientDrawable);
//        } else {
//            String accountType = friendRecord.getAccountType();
//            int i2 = R.drawable.friend_icon_mail;
//            if (accountType.equals("renren")) {
//                i2 = R.drawable.friend_icon_renren;
//            } else if (accountType.equals("weibo")) {
//                i2 = R.drawable.friend_icon_weibo;
//            } else if (accountType.equals("weixin")) {
//                i2 = R.drawable.friend_icon_weixin;
//            }
//            viewHolder.name.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
//            viewHolder.text1.setText(this.mBookLabel + friendRecord.getBook());
//            if (friendRecord.getVocabulary() == 0) {
//                viewHolder.text2.setText(this.mVocabularyLabel + this.mContext.getString(R.string.friend_vocabulary_zero));
//            } else {
//                viewHolder.text2.setText(this.mVocabularyLabel + friendRecord.getVocabulary());
//            }
//        }
//        viewHolder.invite.setSelected(false);
//        viewHolder.invite.setEnabled(true);
//        if (FriendManager.getInstance().hasInvited(friendRecord.getPublicKey())) {
//            viewHolder.invite.setVisibility(4);
//            viewHolder.invited.setVisibility(0);
//            return;
//        }
//        viewHolder.invite.setVisibility(0);
//        viewHolder.invited.setVisibility(4);
//        viewHolder.invite.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                FriendRecord friendRecord = (FriendRecord) FriendSuggestionAdapter.this.getItem(i);
//                if (friendRecord != null) {
//                    view.setSelected(true);
//                    view.setEnabled(false);
//                    FriendSuggestionAdapter.this.applyFriend(friendRecord, viewHolder);
//                }
//            }
//        });
//    }
//
//    /* access modifiers changed from: private */
//    public void applyFriend(final FriendRecord friendRecord, final ViewHolder viewHolder) {
//        String url = FriendURL.getURL(FriendURL.ACTION_APPLY_FRIEND);
//        Type type = new TypeToken<Response<Object>>() {
//        }.getType();
//        String str = null;
//        try {
//            str = new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).put("target", friendRecord.getPublicKey()).toString();
//        } catch (JSONException e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//        GsonRequest gsonRequest = new GsonRequest(1, url, type, str, new Listener<Response<Object>>() {
//            public void onResponse(Response<Object> response) {
//                ErrorInfo errorInfo = response.getErrorInfo();
//                if (errorInfo.getCode() == 0) {
//                    Toast.makeText(FriendSuggestionAdapter.this.mContext, errorInfo.getMsg(), 0).show();
//                    FriendManager.getInstance().addInvited(friendRecord.getPublicKey());
//                    viewHolder.invite.setVisibility(4);
//                    viewHolder.invited.setVisibility(0);
//                    return;
//                }
//                Toast.makeText(FriendSuggestionAdapter.this.mContext, errorInfo.getMsg(), 0).show();
//                viewHolder.invite.setSelected(false);
//                viewHolder.invite.setEnabled(true);
//            }
//        }, new ErrorListener() {
//            public void onErrorResponse(VolleyError volleyError) {
//                FriendManager.reportError(FriendSuggestionAdapter.this.mContext, volleyError);
//                viewHolder.invite.setSelected(false);
//                viewHolder.invite.setEnabled(true);
//            }
//        });
//        gsonRequest.setTag(FriendURL.ACTION_APPLY_FRIEND);
//        VolleyUtils.send(gsonRequest);
//    }
//}
