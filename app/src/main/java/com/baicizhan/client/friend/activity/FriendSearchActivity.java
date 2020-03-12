//package com.baicizhan.client.friend.activity;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.graphics.drawable.GradientDrawable;
//import android.os.Bundle;
////import android.support.p004v4.app.FragmentActivity;
//import android.text.Editable;
//import android.text.TextUtils;
//import android.text.TextWatcher;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnFocusChangeListener;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.GridView;
//import android.widget.TextView;
//import android.widget.TextView.OnEditorActionListener;
//import android.widget.Toast;
//
//import androidx.fragment.app.FragmentActivity;
//
//import com.android.volley.DefaultRetryPolicy;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.VolleyError;
//import com.baicizhan.client.business.jsonbean.ErrorInfo;
//import com.baicizhan.client.business.jsonbean.Response;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.GsonRequest;
//import com.baicizhan.client.framework.network.VolleyUtils;
//import com.baicizhan.client.framework.util.DisplayUtils;
////import com.baicizhan.client.friend.R;
//import com.baicizhan.client.friend.adapter.FriendSuggestionAdapter;
//import com.baicizhan.client.friend.adapter.FriendSuggestionAdapter.Mode;
//import com.baicizhan.client.friend.model.FriendRecord;
//import com.baicizhan.client.friend.utils.FriendManager;
//import com.baicizhan.client.friend.utils.FriendURL;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import com.umeng.p092a.MobclickAgent;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Locale;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class FriendSearchActivity extends FragmentActivity implements OnClickListener {
//    public static final String EXTRA_SEARCH_KEY = "search_key";
//    private static final int SEARCH_KEY_MAX_LENGTH = 10;
//    public static final String TAG = FriendSearchActivity.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public FriendSuggestionAdapter mGridApdater;
//    private BczLoadingDialog mProgressDialog;
//    private EditText mSearchBox;
//    /* access modifiers changed from: private */
//    public View mSearchEntry;
//    /* access modifiers changed from: private */
//    public TextView mSearchName;
//    /* access modifiers changed from: private */
//    public View mSearchSmallLens;
//    /* access modifiers changed from: private */
//    public View mSuggestion;
//    private TextWatcher mTextWatcher = new TextWatcher() {
//        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//        }
//
//        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//        }
//
//        public void afterTextChanged(Editable editable) {
//            FriendSearchActivity.this.mSearchName.setText(editable.toString());
//        }
//    };
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            getWindow().setSoftInputMode(3);
//            setContentView(R.layout.friend_search_activity);
//            initViews();
//            List suggestFriends = FriendManager.getInstance().getSuggestFriends();
//            if (suggestFriends.size() > 0) {
//                this.mGridApdater.update(suggestFriends);
//            }
//            fetchSuggestFriends();
//        }
//    }
//
//    private void initViews() {
//        View findViewById = findViewById(R.id.search_frame);
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(0);
//        gradientDrawable.setColor(getResources().getColor(R.color.business_dc4));
//        gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(this, 4.0f));
//        C1604j.m3631a(findViewById, gradientDrawable);
//        this.mSearchSmallLens = findViewById(R.id.search_small_lens);
//        this.mSearchBox = (EditText) findViewById(R.id.search_box);
//        this.mSearchBox.setImeOptions(268435459);
//        this.mSearchBox.setOnEditorActionListener(new OnEditorActionListener() {
//            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                if (i == 4 || (keyEvent != null && keyEvent.getKeyCode() == 66)) {
//                    FriendSearchActivity.this.search();
//                }
//                return false;
//            }
//        });
//        this.mSearchBox.addTextChangedListener(this.mTextWatcher);
//        this.mSearchBox.setOnFocusChangeListener(new OnFocusChangeListener() {
//            public void onFocusChange(View view, boolean z) {
//                if (z) {
//                    FriendSearchActivity.this.mSearchEntry.setVisibility(0);
//                    FriendSearchActivity.this.mSuggestion.setVisibility(4);
//                    FriendSearchActivity.this.mSearchSmallLens.setVisibility(4);
//                }
//            }
//        });
//        this.mSearchEntry = findViewById(R.id.search_entry);
//        this.mSearchName = (TextView) this.mSearchEntry.findViewById(R.id.search_name);
//        this.mSearchEntry.setVisibility(4);
//        this.mSearchEntry.setOnClickListener(this);
//        findViewById(R.id.search_button).setOnClickListener(this);
//        findViewById(R.id.back).setOnClickListener(this);
//        ((TextView) findViewById(R.id.name)).setText(String.format(Locale.CHINA, "我的ID: %s", new Object[]{Settings.getDisplayNickName()}));
//        this.mGridApdater = new FriendSuggestionAdapter(this, Mode.SYSTEM);
//        this.mSuggestion = findViewById(R.id.system_suggestion);
//        GridView gridView = (GridView) findViewById(R.id.suggestion_grid);
//        gridView.setEmptyView(findViewById(R.id.empty_view));
//        gridView.setAdapter(this.mGridApdater);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onResume() {
//        super.onResume();
//        if (!TextUtils.isEmpty(this.mSearchBox.getText().toString())) {
//            this.mSearchBox.requestFocus();
//        }
//        try {
//            MobclickAgent.m5136b((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onPause() {
//        super.onPause();
//        try {
//            MobclickAgent.m5132a((Context) this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onRestoreInstanceState(Bundle bundle) {
//        super.onRestoreInstanceState(bundle);
//        String string = bundle.getString(EXTRA_SEARCH_KEY);
//        if (!TextUtils.isEmpty(string) && this.mSearchName != null) {
//            this.mSearchBox.setText(string);
//            this.mSearchName.setText(string);
//            if (!this.mSearchBox.isFocused()) {
//                this.mSearchBox.requestFocus();
//            }
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        bundle.putString(EXTRA_SEARCH_KEY, this.mSearchBox.getText().toString());
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_GET_SUGGEST_FRIENDS);
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_APPLY_FRIEND);
//    }
//
//    public void onBackPressed() {
//        if (this.mProgressDialog != null) {
//            dismissDialog();
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    private View getContentView() {
//        return ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
//    }
//
//    private void fetchSuggestFriends() {
//        try {
//            GsonRequest gsonRequest = new GsonRequest(1, FriendURL.getURL(FriendURL.ACTION_GET_SUGGEST_FRIENDS), new TypeToken<Response<LinkedList<FriendRecord>>>() {
//            }.getType(), new JSONObject().put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).toString(), new Listener<Response<LinkedList<FriendRecord>>>() {
//                public void onResponse(Response<LinkedList<FriendRecord>> response) {
//                    if (response.getErrorInfo().getCode() == 0) {
//                        LinkedList linkedList = (LinkedList) response.getTypedData();
//                        FriendManager.getInstance().setSuggestFriends(linkedList);
//                        FriendSearchActivity.this.mGridApdater.update(linkedList);
//                    }
//                }
//            }, new ErrorListener() {
//                public void onErrorResponse(VolleyError volleyError) {
//                    FriendManager.reportError(FriendSearchActivity.this, volleyError);
//                }
//            });
//            gsonRequest.setTag(FriendURL.ACTION_GET_SUGGEST_FRIENDS);
//            VolleyUtils.send(gsonRequest, new DefaultRetryPolicy(10000, 0, 0.0f));
//        } catch (JSONException e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//    }
//
//    private void showDialog() {
//        this.mProgressDialog = BczLoadingDialog.show(this, "查询中，请稍后", true);
//        getContentView().setEnabled(false);
//    }
//
//    /* access modifiers changed from: private */
//    public void dismissDialog() {
//        if (this.mProgressDialog != null) {
//            this.mProgressDialog.dismiss();
//            this.mProgressDialog = null;
//        }
//        VolleyUtils.cancelAllTagRequest(FriendURL.ACTION_GET_SUGGEST_FRIENDS);
//        getContentView().setEnabled(true);
//    }
//
//    /* access modifiers changed from: private */
//    public void search() {
//        int i;
//        String str = null;
//        String trim = this.mSearchBox.getText().toString().trim();
//        if (TextUtils.isEmpty(trim)) {
//            i = R.string.friend_error_search_key_empty;
//        } else if (trim.length() > 10) {
//            i = R.string.friend_error_search_key_too_long;
//        } else {
//            i = -1;
//        }
//        if (i != -1) {
//            new Builder(this).setTitle((CharSequence) str).setMessage(i).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.dismiss();
//                }
//            }).setCancelable(true).show();
//            this.mSearchBox.setText("");
//            this.mSearchName.setText("");
//            return;
//        }
//        String url = FriendURL.getURL(FriendURL.ACTION_SEARCH_USER);
//        Type type = new TypeToken<Response<ArrayList<FriendRecord>>>() {
//        }.getType();
//        try {
//            str = new JSONObject().put("partial", trim).put(BaicizhanCookieInflator.ACCESS_TOKEN, Settings.getString(Settings.PREF_USER_TOKEN)).toString();
//        } catch (JSONException e) {
//            C0789L.log.error(Log.getStackTraceString(e));
//        }
//        VolleyUtils.send(new GsonRequest(1, url, type, str, new Listener<Response<ArrayList<FriendRecord>>>() {
//            public void onResponse(Response<ArrayList<FriendRecord>> response) {
//                FriendSearchActivity.this.dismissDialog();
//                ErrorInfo errorInfo = response.getErrorInfo();
//                ArrayList arrayList = (ArrayList) response.getTypedData();
//                if (!errorInfo.equals(ErrorInfo.NO_ERROR)) {
//                    Toast.makeText(FriendSearchActivity.this, errorInfo.getMsg(), 0).show();
//                } else if (arrayList != null) {
//                    FriendSearchActivity.this.onSearchResult(arrayList);
//                }
//            }
//        }, new ErrorListener() {
//            public void onErrorResponse(VolleyError volleyError) {
//                FriendManager.reportError(FriendSearchActivity.this, volleyError);
//                FriendSearchActivity.this.dismissDialog();
//            }
//        }), new DefaultRetryPolicy(15000, 0, 0.0f));
//        showDialog();
//    }
//
//    /* access modifiers changed from: private */
//    public void onSearchResult(ArrayList<FriendRecord> arrayList) {
//        if (arrayList.size() > 0) {
//            Intent intent = new Intent(this, FriendSearchResultActivity.class);
//            intent.putExtra(FriendSearchResultActivity.EXTRA_SEARCH_RESULT, arrayList);
//            startActivity(intent);
//            return;
//        }
//        new Builder(this).setTitle((CharSequence) null).setMessage((CharSequence) "查无此人，请确认是否输入正确").setPositiveButton((CharSequence) "确定", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        }).setCancelable(true).show();
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.search_button || id == R.id.search_entry) {
//            search();
//        } else if (id == R.id.back) {
//            onBackPressed();
//        }
//    }
//}
