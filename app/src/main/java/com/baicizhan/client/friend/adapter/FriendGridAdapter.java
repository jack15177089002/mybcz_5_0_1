//package com.baicizhan.client.friend.adapter;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.text.SpannableStringBuilder;
//import android.text.style.ForegroundColorSpan;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.view.animation.LayoutAnimationController;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
//import android.widget.ViewSwitcher;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.CircleImageView;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.GsonRequest;
//import com.baicizhan.client.framework.network.VolleyUtils;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.model.FriendRecord;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.utils.FriendURL;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import com.p047d.p048a.Animator;
//import com.p047d.p048a.C1548at;
//import com.p047d.p048a.ValueAnimator;
//import com.p047d.p050c.ViewHelper;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class FriendGridAdapter extends BaseAdapter {
//    public static final String TAG = FriendGridAdapter.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public final int BLUE_COLOR;
//    private final int TRANSPARENT_COLOR = 0;
//    String mBookLabel;
//    Context mContext;
//    long mCurrentOpenedPosition = -1;
//    List<FriendRecord> mFriends = new ArrayList();
//    LayoutInflater mInflater;
//    ForegroundColorSpan mLabelSpan;
//    String mVocabularyLabel;
//
//    class ViewHolder {
//        public Animator animator;
//        public View delete;
//        public ViewGroup infos;
//        public TextView name;
//        public ViewGroup operations;
//        int position;
//        public ViewSwitcher switcher;
//        public TextView text1;
//        public TextView text2;
//        public CircleImageView thumb;
//
//        ViewHolder() {
//        }
//    }
//
//    public FriendGridAdapter(Context context) {
//        this.mContext = context;
//        this.mInflater = LayoutInflater.from(context);
//        this.mBookLabel = context.getString(R.string.friend_current_book_label);
//        this.mVocabularyLabel = context.getString(R.string.friend_current_vocabulary_label);
//        this.mLabelSpan = new ForegroundColorSpan(context.getResources().getColor(R.color.business_dt4));
//        this.BLUE_COLOR = context.getResources().getColor(R.color.business_dc8);
//    }
//
//    public int getCount() {
//        return this.mFriends.size();
//    }
//
//    public Object getItem(int i) {
//        return this.mFriends.get(i);
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
//        fillValues(i, view);
//        return view;
//    }
//
//    public void fillValues(final int i, View view) {
//        String num;
//        FriendRecord friendRecord = (FriendRecord) this.mFriends.get(i);
//        final ViewHolder viewHolder = (ViewHolder) view.getTag();
//        PicassoUtil.loadUserImage(this.mContext, viewHolder.thumb, friendRecord.getImage());
//        viewHolder.name.setText(friendRecord.getLocalName());
//        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mBookLabel);
//        spannableStringBuilder.setSpan(this.mLabelSpan, 0, spannableStringBuilder.length(), 33);
//        spannableStringBuilder.append(friendRecord.getBook());
//        viewHolder.text1.setText(spannableStringBuilder);
//        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.mVocabularyLabel);
//        spannableStringBuilder2.setSpan(this.mLabelSpan, 0, spannableStringBuilder2.length(), 33);
//        if (friendRecord.getVocabulary() == 0) {
//            num = this.mContext.getString(R.string.friend_vocabulary_zero);
//        } else {
//            num = Integer.toString(friendRecord.getVocabulary());
//        }
//        spannableStringBuilder2.append(num);
//        viewHolder.text2.setText(spannableStringBuilder2);
//        viewHolder.delete.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                FriendGridAdapter.this.confirmDeleteFriend((FriendRecord) FriendGridAdapter.this.getItem(i));
//            }
//        });
//        view.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                if (FriendGridAdapter.this.isOpened(viewHolder)) {
//                    FriendGridAdapter.this.mCurrentOpenedPosition = -1;
//                    FriendGridAdapter.this.closeItem(viewHolder);
//                    return;
//                }
//                FriendGridAdapter.this.openItem(viewHolder);
//                FriendGridAdapter.this.mCurrentOpenedPosition = (long) i;
//                FriendGridAdapter.this.notifyDataSetChanged();
//            }
//        });
//        if (((long) i) != this.mCurrentOpenedPosition) {
//            closeItem(viewHolder);
//        } else {
//            openItem(viewHolder);
//        }
//        viewHolder.position = i;
//    }
//
//    public View generateView(int i, ViewGroup viewGroup) {
//        View inflate = this.mInflater.inflate(R.layout.friend_grid_item, viewGroup, false);
//        ViewHolder viewHolder = new ViewHolder();
//        viewHolder.switcher = (ViewSwitcher) inflate.findViewById(R.id.switcher);
//        viewHolder.infos = (ViewGroup) inflate.findViewById(R.id.infos);
//        viewHolder.operations = (ViewGroup) inflate.findViewById(R.id.operations);
//        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, 17432578);
//        loadAnimation.setDuration(150);
//        viewHolder.operations.setLayoutAnimation(new LayoutAnimationController(loadAnimation));
//        viewHolder.thumb = (CircleImageView) inflate.findViewById(R.id.thumb);
//        viewHolder.thumb.setBorderColor(0);
//        viewHolder.name = (TextView) inflate.findViewById(R.id.name);
//        viewHolder.text1 = (TextView) inflate.findViewById(R.id.text1);
//        viewHolder.text2 = (TextView) inflate.findViewById(R.id.text2);
//        viewHolder.delete = inflate.findViewById(R.id.delete);
//        inflate.setTag(viewHolder);
//        return inflate;
//    }
//
//    /* access modifiers changed from: private */
//    public void confirmDeleteFriend(final FriendRecord friendRecord) {
////        C08133 r0 = new DialogInterface.OnClickListener() {
////            public void onClick(DialogInterface dialogInterface, int i) {
////                if (i == -1) {
////                    FriendGridAdapter.this.deleteFriend(friendRecord);
////                } else if (i == -2) {
////                    FriendGridAdapter.this.mCurrentOpenedPosition = -1;
////                    FriendGridAdapter.this.notifyDataSetChanged();
////                }
////            }
////        };
////        new Builder(this.mContext).setTitle((CharSequence) null).setMessage(R.string.friend_confirm_delete_message).setPositiveButton((CharSequence) "确定", (DialogInterface.OnClickListener) r0).setNegativeButton(R.string.friend_operation_cancel, (DialogInterface.OnClickListener) r0).setCancelable(true).show();
//    }
//
//    /* access modifiers changed from: private */
//    public void deleteFriend(FriendRecord friendRecord) {
//        String url = FriendURL.getURL(FriendURL.ACTION_DELETE_FRIEND);
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
//                    Toast.makeText(FriendGridAdapter.this.mContext, "删除成功", 0).show();
//                } else {
//                    Toast.makeText(FriendGridAdapter.this.mContext, "删除失败,原因:" + errorInfo.getMsg(), 0).show();
//                }
//            }
//        }, new ErrorListener() {
//            public void onErrorResponse(VolleyError volleyError) {
//                FriendManager.reportError(FriendGridAdapter.this.mContext, volleyError);
//            }
//        });
//        gsonRequest.setTag(FriendURL.ACTION_DELETE_FRIEND);
//        VolleyUtils.send(gsonRequest);
//        FriendManager.getInstance().removeFriend(friendRecord);
//        FriendManager.getInstance().removeInvited(friendRecord.getPublicKey());
//        this.mCurrentOpenedPosition = -1;
//        update();
//    }
//
//    public void update() {
//        this.mFriends.clear();
//        this.mFriends.addAll(FriendManager.getInstance().getFriends().values());
//        notifyDataSetChanged();
//    }
//
//    /* access modifiers changed from: private */
//    public boolean isOpened(ViewHolder viewHolder) {
//        return viewHolder.switcher.getDisplayedChild() == 1;
//    }
//
//    public void openItem(final ViewHolder viewHolder) {
//        if (!isOpened(viewHolder)) {
//            viewHolder.switcher.showNext();
//            ((ViewGroup) viewHolder.switcher.getChildAt(1)).startLayoutAnimation();
//            ValueAnimator b = ValueAnimator.m3296b(0, 255);
//            viewHolder.switcher.getChildAt(0).setVisibility(0);
//            b.mo16184a((C1548at) new C1548at() {
//                public void onAnimationUpdate(ValueAnimator amVar) {
//                    int intValue = ((Integer) amVar.mo16192g()).intValue();
//                    viewHolder.thumb.setBorderColor((FriendGridAdapter.this.BLUE_COLOR & 16777215) | (intValue << 24));
//                    float f = ((float) (255 - (intValue * 2))) / 255.0f;
//                    if (f < 0.0f) {
//                        f = 0.0f;
//                    }
//                    ViewHelper.m3389a(viewHolder.infos, f);
//                }
//            });
//            b.mo16188b(200);
//            b.mo16161a();
//            viewHolder.animator = b;
//        }
//    }
//
//    @SuppressLint({"NewApi"})
//    public void closeItem(ViewHolder viewHolder) {
//        if (isOpened(viewHolder)) {
//            if (viewHolder.animator != null) {
//                viewHolder.animator.mo16164b();
//            }
//            viewHolder.switcher.showNext();
//            viewHolder.thumb.setBorderColor(0);
//            ViewHelper.m3389a(viewHolder.infos, 1.0f);
//        }
//    }
//}
