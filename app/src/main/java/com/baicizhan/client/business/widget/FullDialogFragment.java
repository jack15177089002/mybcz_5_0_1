package com.baicizhan.client.business.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import androidx.fragment.app.DialogFragment;//import android.support.p004v4.app.DialogFragment

import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
import com.baicizhan.client.framework.util.Common;
import java.lang.ref.WeakReference;

public abstract class FullDialogFragment extends DialogFragment {
    /* access modifiers changed from: private */
    public boolean mCancelableOnTouchOutside = true;
    public TransitionManager mTransitionManager;

    public class TransitionManager {
        /* access modifiers changed from: private */
        public final WeakReference<FullDialogFragment> mFragment;
        /* access modifiers changed from: private */
        public boolean mInning = false;
        /* access modifiers changed from: private */
        public boolean mOutting = false;

        public TransitionManager(FullDialogFragment fullDialogFragment) {
            this.mFragment = new WeakReference<>(fullDialogFragment);
        }

        public void fadeIn(View view) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            if (view != null) {
                alphaAnimation.setAnimationListener(new AnimationListener() {
                    public void onAnimationEnd(Animation animation) {
                        TransitionManager.this.mInning = false;
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                        TransitionManager.this.mInning = true;
                    }
                });
                view.setVisibility(0);
                view.startAnimation(alphaAnimation);
            }
        }

        public void fadeOut(View view) {
            if (!this.mInning && !this.mOutting) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300);
                if (view != null) {
                    alphaAnimation.setAnimationListener(new AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            FullDialogFragment fullDialogFragment = (FullDialogFragment) TransitionManager.this.mFragment.get();
                            if (fullDialogFragment != null) {
                                TransitionManager.this.mOutting = false;
                                fullDialogFragment.superDismiss();
                            }
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            TransitionManager.this.mOutting = true;
                        }
                    });
                    view.setVisibility(4);
                    view.startAnimation(alphaAnimation);
                    return;
                }
                FullDialogFragment fullDialogFragment = (FullDialogFragment) this.mFragment.get();
                if (fullDialogFragment != null) {
                    fullDialogFragment.superDismiss();
                }
            }
        }

        public void overBackOnResume() {
            final FullDialogFragment fullDialogFragment = (FullDialogFragment) this.mFragment.get();
            if (fullDialogFragment != null) {
                fullDialogFragment.getDialog().setOnKeyListener(new OnKeyListener() {
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (4 != i) {
                            return false;
                        }
                        if (1 != keyEvent.getAction()) {
                            return true;
                        }
                        fullDialogFragment.dismiss();
                        return true;
                    }
                });
            }
        }

        public void cancelByMask(View view) {
            final FullDialogFragment fullDialogFragment = (FullDialogFragment) this.mFragment.get();
            if (fullDialogFragment != null) {
                view.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (fullDialogFragment.mCancelableOnTouchOutside) {
                            fullDialogFragment.dismiss();
                        }
                    }
                });
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTransitionManager = new TransitionManager(this);
        setStyle(1, R.style.NoFrameDialog);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(true);
        return onCreateDialog;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onResume() {
        super.onResume();
        getDialog().getWindow().setLayout(Common.getScreenWidth(getActivity()), Common.getScreenHeight(getActivity()));
    }

    public void superDismiss() {
        super.dismissAllowingStateLoss();
    }

    public void setCancelableOnTouchOutside(boolean z) {
        this.mCancelableOnTouchOutside = z;
    }
}
