package com.baicizhan.client.business.logoload;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.baicizhan.client.business.logoload.LPDaos.Loading;
import com.baicizhan.client.business.logoload.LogoLoader.Callback;
import com.baicizhan.client.business.logoload.jsonbean.LogoPage;
import com.baicizhan.client.business.settings.Settings;
import com.baicizhan.client.business.usr.User;
import com.baicizhan.client.business.usr.UserAsyncTask;
import com.baicizhan.client.business.usr.UserLoadHandler;
import com.baicizhan.client.framework.network.NetworkUtils;
import com.baicizhan.client.framework.network.VolleyUtils;
import com.google.gson.Gson;//import com.p020b.p021a.Gson;
import com.google.gson.JsonSyntaxException;//import com.p020b.p021a.JsonSyntaxException;
import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
import java.lang.ref.WeakReference;

public class LogoPageLoading implements UserLoadHandler {
    private static final int GET_ONE_LOADED_LOADING = 0;
    private static final int GET_ONE_LOADING_PREFER_UNLOADED = 1;
    private static final int MARK_LOADED_FALSE = 3;
    private static final int MARK_LOADED_TRUE = 2;
    private static final String TAG = "LogoPageLoading";
    private static final int UPGRADDE = 4;
    private static final String URL = "http://www.baicizhan.com/api/ad/get_logo?access_token=%s";
    /* access modifiers changed from: private */
    public OnLoadCallback mCallback;
    private View mCandidate;
    private Context mContext;
    private Animation mFadeAnim;
    /* access modifiers changed from: private */
    public final LoadingHandler mHandler = new LoadingHandler(this);
    private View mPlaceHolder;
    private ImageView mTarget;

    final class DownloadCallback implements Callback {
        final WeakReference<LogoPageLoading> mLoading;

        DownloadCallback(LogoPageLoading logoPageLoading) {
            this.mLoading = new WeakReference<>(logoPageLoading);
        }

        public final void onDownloaded(Loading loading, boolean z) {
            LogoPageLoading logoPageLoading = (LogoPageLoading) this.mLoading.get();
            if (logoPageLoading == null) {
                Log.e(LogoPageLoading.TAG, "download callback exits for LogoPageLoading destroyed.");
            } else if (z && loading != null) {
                logoPageLoading.mHandler.markLoaded(loading.getUrl(), true, 2);
                Settings.setFirstPageLoadingUrl(loading.getUrl());
                Settings.setFirstPageLoadingDur(loading.getDuration());
            } else if (logoPageLoading.mCallback != null) {
                logoPageLoading.mCallback.onPreLoaded(false);
            }
        }
    }

    final class LoadingHandler extends LoadLogoPageHandler {
        final WeakReference<LogoPageLoading> mLoading;

        LoadingHandler(LogoPageLoading logoPageLoading) {
            this.mLoading = new WeakReference<>(logoPageLoading);
        }

        public final void onGetOneLoadedLoading(int i, Loading loading) {
            LogoPageLoading logoPageLoading = (LogoPageLoading) this.mLoading.get();
            if (logoPageLoading == null) {
                Log.e(LogoPageLoading.TAG, "load logo page handler exits for LogoPageLoading destroyed.");
                return;
            }
            Settings.setFirstPageLoadingUrl(loading != null ? loading.getUrl() : null);
            Settings.setFirstPageLoadingDur(loading != null ? loading.getDuration() : 0);
            logoPageLoading.mHandler.getOneLoadingPreferUnloaded(1);
        }

        public final void onGetOneLoadingPreferUnloaded(int i, Loading loading) {
            LogoPageLoading logoPageLoading = (LogoPageLoading) this.mLoading.get();
            if (logoPageLoading == null) {
                Log.e(LogoPageLoading.TAG, "load logo page handler exits for LogoPageLoading destroyed.");
            } else {
                logoPageLoading.doPreload(loading);
            }
        }

        public final void onMarkLoaded(int i) {
            LogoPageLoading logoPageLoading = (LogoPageLoading) this.mLoading.get();
            if (logoPageLoading == null) {
                Log.e(LogoPageLoading.TAG, "load logo page handler exits for LogoPageLoading destroyed.");
            } else if (logoPageLoading.mCallback == null) {
            } else {
                if (2 == i) {
                    logoPageLoading.mCallback.onPreLoaded(true);
                    logoPageLoading.preload();
                } else if (3 == i) {
                    logoPageLoading.mCallback.onLoaded(false, 0);
                }
            }
        }

        public final void onUpgrade(int i) {
            LogoPageLoading logoPageLoading = (LogoPageLoading) this.mLoading.get();
            if (logoPageLoading != null && logoPageLoading.mCallback != null) {
                logoPageLoading.mCallback.onUpgraded(true);
                logoPageLoading.preload();
            } else if (logoPageLoading == null) {
                Log.e(LogoPageLoading.TAG, "load logo page handler exits for LogoPageLoading destroyed.");
            }
        }
    }

    public interface OnLoadCallback {
        void onLoaded(boolean z, long j);

        void onPreLoaded(boolean z);

        void onUpgraded(boolean z);
    }

    final class UpgradeErrListener implements ErrorListener {
        final WeakReference<LogoPageLoading> mLoading;

        UpgradeErrListener(LogoPageLoading logoPageLoading) {
            this.mLoading = new WeakReference<>(logoPageLoading);
        }

        public final void onErrorResponse(VolleyError volleyError) {
            LogoPageLoading logoPageLoading = (LogoPageLoading) this.mLoading.get();
            if (logoPageLoading == null) {
                Log.e(LogoPageLoading.TAG, "logo upgrade exits for LogoPageLoading destroyed.");
            } else if (logoPageLoading.mCallback != null) {
                logoPageLoading.mCallback.onUpgraded(false);
                logoPageLoading.mCallback.onPreLoaded(false);
            }
        }
    }

    final class UpgradeListener implements Listener<String> {
        final WeakReference<LogoPageLoading> mLoading;

        UpgradeListener(LogoPageLoading logoPageLoading) {
            this.mLoading = new WeakReference<>(logoPageLoading);
        }

        public final void onResponse(String str) {
            LogoPageLoading logoPageLoading = (LogoPageLoading) this.mLoading.get();
            if (logoPageLoading == null) {
                Log.e(LogoPageLoading.TAG, "logo upgrade exits for LogoPageLoading destroyed. ");
                return;
            }
            Log.d(LogoPageLoading.TAG, "logo upgrade response data: " + str);
            try {
//                LogoPage logoPage = (LogoPage) new Gson().fromJson(str, new TypeToken<LogoPage>() {
//                }.getType());
//                if (logoPage != null && logoPage.isValid()) {
//                    LogoLoadingAdapter logoLoadingAdapter = new LogoLoadingAdapter(logoPage);
//                    logoPageLoading.mHandler.upgrade(logoLoadingAdapter.getLoadings(), logoLoadingAdapter.getVersion(), 4);
//                    if (logoLoadingAdapter.getLoadings() == null || logoLoadingAdapter.getLoadings().isEmpty()) {
//                        Settings.setFirstPageLoadingUrl(null);
//                        Settings.setFirstPageLoadingDur(0);
//                    }
//                } else if (logoPageLoading.mCallback != null) {
//                    logoPageLoading.mCallback.onUpgraded(false);
//                    logoPageLoading.mCallback.onPreLoaded(false);
//                }
            } catch (JsonSyntaxException e) {
                if (logoPageLoading.mCallback != null) {
                    logoPageLoading.mCallback.onUpgraded(false);
                    logoPageLoading.mCallback.onPreLoaded(false);
                }
            } catch (IllegalStateException e2) {
                if (logoPageLoading.mCallback != null) {
                    logoPageLoading.mCallback.onUpgraded(false);
                    logoPageLoading.mCallback.onPreLoaded(false);
                }
            }
        }
    }

    public LogoPageLoading with(Context context) {
        if (context == null) {
            throw new RuntimeException("A null context instance is passed.");
        }
        this.mContext = context;
        this.mFadeAnim = new AlphaAnimation(0.0f, 1.0f);
        this.mFadeAnim.setDuration(600);
        return this;
    }

    public LogoPageLoading setPlaceHolder(View view) {
        this.mPlaceHolder = view;
        return this;
    }

    public LogoPageLoading setTarget(ImageView imageView) {
        this.mTarget = imageView;
        if (this.mTarget != null) {
            this.mTarget.setScaleType(ScaleType.CENTER_CROP);
        }
        return this;
    }

    public LogoPageLoading setCandidate(View view) {
        this.mCandidate = view;
        return this;
    }

    public LogoPageLoading setCallback(OnLoadCallback onLoadCallback) {
        this.mCallback = onLoadCallback;
        return this;
    }

    public LogoPageLoading preload() {
        checkContextNull();
        this.mHandler.getOneLoadedLoading(0);
        return this;
    }

    public LogoPageLoading load() {
        checkContextNull();
        if (this.mTarget != null) {
            this.mTarget.setVisibility(8);
            if (this.mCandidate != null) {
                this.mCandidate.setVisibility(8);
            }
            if (this.mPlaceHolder != null) {
                this.mPlaceHolder.setVisibility(0);
            }
            doLoad(Settings.getFirstPageLoadingUrl(), Settings.getFirstPageLoadingDur());
        }
        return this;
    }

    private void doLoad(String str, final long j) {
        if (str == null) {
            if (!dispCandidate() && this.mCallback != null) {
                this.mCallback.onLoaded(false, 0);
            }
        } else if (new LogoLoader().localLoad(this.mContext, str, this.mTarget)) {
            Log.d("whiz", "local load success");
            this.mTarget.setVisibility(0);
            if (this.mFadeAnim != null) {
                this.mTarget.startAnimation(this.mFadeAnim);
                this.mFadeAnim.setAnimationListener(new AnimationListener() {
                    public void onAnimationEnd(Animation animation) {
                        if (LogoPageLoading.this.mCallback != null) {
                            Log.d("whiz", "local load success and callback after anim");
                            LogoPageLoading.this.mCallback.onLoaded(true, j);
                        }
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }
                });
            } else if (this.mCallback != null) {
                Log.d("whiz", "local load success and callback");
                this.mCallback.onLoaded(true, j);
            }
        } else {
            Settings.setFirstPageLoadingUrl(null);
            Settings.setFirstPageLoadingDur(0);
            this.mHandler.markLoaded(str, false, 3);
            Log.d("whiz", "local load failed");
            if (!dispCandidate() && this.mCallback != null) {
                this.mCallback.onLoaded(false, 0);
            }
        }
    }

    private boolean dispCandidate() {
        if (this.mCandidate == null) {
            return false;
        }
        this.mCandidate.setVisibility(0);
        if (this.mFadeAnim != null) {
            this.mCandidate.startAnimation(this.mFadeAnim);
            this.mFadeAnim.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (LogoPageLoading.this.mCallback != null) {
                        LogoPageLoading.this.mCallback.onLoaded(false, 0);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
        } else if (this.mCallback != null) {
            this.mCallback.onLoaded(false, 0);
        }
        return true;
    }

    public LogoPageLoading upgrade() {
        if (NetworkUtils.isSmoothNetwork(this.mContext)) {
            UserAsyncTask.getTask(this).execute(new Void[0]);
        } else if (this.mCallback != null) {
            this.mCallback.onUpgraded(false);
            this.mCallback.onPreLoaded(false);
        }
        return this;
    }

    public void destroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void doupgrade(String str) {
        VolleyUtils.send(new StringRequest(String.format(URL, new Object[]{str}), new UpgradeListener(this), new UpgradeErrListener(this)));
    }

    /* access modifiers changed from: private */
    public void doPreload(Loading loading) {
        if (loading != null && NetworkUtils.isSmoothNetwork(this.mContext)) {
            new LogoLoader().download(loading, new DownloadCallback(this));
        } else if (this.mCallback != null) {
            this.mCallback.onPreLoaded(false);
        }
    }

    private void checkContextNull() {
        if (this.mContext == null) {
            throw new RuntimeException("Not a valide context.");
        }
    }

    public void onError(Void voidR) {
        if (this.mCallback != null) {
            this.mCallback.onUpgraded(false);
            this.mCallback.onPreLoaded(false);
        }
    }

    public void onProgress(int i) {
    }

    public void onSuccess(User user) {
        if (user != null) {
            doupgrade(user.getToken());
        } else if (this.mCallback != null) {
            this.mCallback.onUpgraded(false);
            this.mCallback.onPreLoaded(false);
        }
    }
}
