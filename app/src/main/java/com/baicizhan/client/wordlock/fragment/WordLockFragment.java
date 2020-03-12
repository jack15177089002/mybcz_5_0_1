//package com.baicizhan.client.wordlock.fragment;
//
//import android.app.Activity;
//import android.graphics.Bitmap;
//import android.graphics.Bitmap.Config;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.drawable.BitmapDrawable;
//import android.os.Bundle;
//import android.os.Handler;
////import android.support.p004v4.app.Fragment;
////import android.support.p004v4.app.FragmentTransaction;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.view.ViewGroup;
//import android.view.ViewStub;
//import android.view.ViewTreeObserver.OnPreDrawListener;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//
//import com.baicizhan.client.business.search.Word;
////import com.baicizhan.client.wordlock.R;
//import com.baicizhan.client.wordlock.activity.WordLockClient;
//import com.baicizhan.client.wordlock.data.p033db.LockDataHandler;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.DispMoreInfoEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.HelpGuideEvent;
//import com.baicizhan.client.wordlock.eventbus.WordLockEvents.ToggleControllerEvent;
//import com.baicizhan.client.wordlock.fragment.FirstSettingView.OnWordLockToggleListener;
//import com.baicizhan.client.wordlock.setting.Settings;
//import com.baicizhan.client.wordlock.util.FastBlur;
//import com.baicizhan.client.wordlock.view.DotsNavigation;
//import com.baicizhan.client.wordlock.view.PullToRefreshWordLine;
//import com.baicizhan.client.wordlock.view.WordLine;
//import com.jiongji.andriod.card.R;
//import com.p047d.p048a.Animator;
//import com.p047d.p048a.C1549b;
//import com.p047d.p048a.ObjectAnimator;
//import com.p047d.p050c.ViewHelper;
////import p000a.p001a.p002a.EventBus;
//
//public class WordLockFragment extends Fragment implements OnClickListener, OnTouchListener, OnWordLockToggleListener {
//    /* access modifiers changed from: private */
//    public View mBottomBar;
//    /* access modifiers changed from: private */
//    public TextView mBottomTip;
//    private DotsNavigation mDotsNav;
//    private FirstSettingView mFirstSetting;
//    private Handler mHandler = new Handler();
//    /* access modifiers changed from: private */
//    public View mMoreInfoFrame;
//    /* access modifiers changed from: private */
////    public MoreWordInfoFragment mMoreWordInfoFragment;
//    private OnWordLockListener mOnWordLockListener;
//    private View mRootView;
//    private ImageView mSearch;
//    private View mSearchFrame;
//    private LockDataHandler mSearchHistoryHandler;
//    /* access modifiers changed from: private */
//    public boolean mWillDisplayMore = false;
//    /* access modifiers changed from: private */
//    public WordLine mWordLine;
//    private PullToRefreshWordLine mWordLineWrapper;
//    /* access modifiers changed from: private */
//    public WordSearchFragment mWordSearchFragment;
//
//    public interface OnWordLockListener {
//        void onGuideUnlock();
//
//        void onWordLockFreeze(boolean z);
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        this.mOnWordLockListener = (WordLockClient) activity;
////        EventBus.m0a().mo5a((Object) this);
//        this.mSearchHistoryHandler = new LockDataHandler("WordLockSearch");
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        this.mRootView = (ViewGroup) layoutInflater.inflate(R.layout.wordlock_client_content, viewGroup, false);
//        FastBlur.applyBlur(getActivity(), this.mRootView);
//        this.mDotsNav = (DotsNavigation) this.mRootView.findViewById(R.id.wordlock_dots_nav);
////        this.mWordLine = (WordLine) this.mRootView.findViewById(R.id.wordlock_wordline);
//        this.mWordLine.init((WordLockClient) getActivity(), this.mDotsNav);
//        this.mWordLineWrapper = (PullToRefreshWordLine) this.mRootView.findViewById(R.id.wordlock_pull2refresh_wordline);
//        this.mWordLineWrapper.init((WordLockClient) getActivity());
//        this.mMoreInfoFrame = this.mRootView.findViewById(R.id.wordlock_more_info_frame);
//        this.mSearch = (ImageView) this.mRootView.findViewById(R.id.wordlock_search);
//        this.mSearch.setOnTouchListener(this);
//        updateSearchIcon();
//        this.mSearchFrame = this.mRootView.findViewById(R.id.wordlock_search_frame);
//        this.mBottomBar = this.mRootView.findViewById(R.id.wordlock_bottom_bar);
//        this.mBottomBar.setOnClickListener(this);
//        this.mBottomTip = (TextView) this.mRootView.findViewById(R.id.wordlock_op_tip);
//        if (Settings.isLockScreenFirstSet()) {
//            this.mFirstSetting = (FirstSettingView) ((ViewStub) this.mRootView.findViewById(R.id.wordlock_stub_first_settings)).inflate();
//            this.mFirstSetting.setOnWordLockToggleListener(this);
//            setShrink();
//        }
//        return this.mRootView;
//    }
//
//    private void updateSearchIcon() {
//        if (!Settings.doesWordSearchUsed()) {
//            this.mSearch.setImageResource(R.drawable.dict_search_white_new_default);
//        } else {
//            this.mSearch.setImageResource(R.drawable.dict_search_white_default);
//        }
//    }
//
//    private static void initBackground(final Activity activity, final View view) {
//        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
//            public final boolean onPreDraw() {
//                view.getViewTreeObserver().removeOnPreDrawListener(this);
//                view.buildDrawingCache();
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) activity.getWallpaper();
//                Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Config.ARGB_8888);
//                Canvas canvas = new Canvas(createBitmap);
//                Paint paint = new Paint();
//                paint.setFlags(2);
//                canvas.drawBitmap(bitmapDrawable.getBitmap(), 0.0f, 0.0f, paint);
//                view.setBackgroundDrawable(new BitmapDrawable(view.getResources(), createBitmap));
//                return true;
//            }
//        });
//    }
//
//    private void setShrink() {
//        ViewHelper.m3392d(this.mDotsNav, 0.9f);
//        ViewHelper.m3393e(this.mDotsNav, 0.9f);
//        ViewHelper.m3392d(this.mWordLine, 0.9f);
//        ViewHelper.m3393e(this.mWordLine, 0.9f);
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        this.mHandler.removeCallbacksAndMessages(null);
//    }
//
//    public void onDetach() {
//        super.onDetach();
////        EventBus.m0a().mo8b((Object) this);
//        this.mSearchHistoryHandler.destroy();
//    }
//
//    public void resetWordLine(boolean z, boolean z2) {
//        if (this.mWordLine != null) {
//            this.mWordLine.reset(z, z2);
//        }
//        removeMoreInfo();
//        removeSearchFrame();
//        if (this.mDotsNav.getVisibility() != 0) {
//            this.mDotsNav.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_in_short));
//            this.mDotsNav.setVisibility(0);
//        }
//    }
//
//    private void removeMoreInfo() {
//        if (this.mMoreInfoFrame != null) {
//            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_out);
//            this.mMoreInfoFrame.setVisibility(8);
//            this.mMoreInfoFrame.startAnimation(loadAnimation);
//            loadAnimation.setAnimationListener(new AnimationListener() {
//                public void onAnimationEnd(Animation animation) {
////                    Fragment a = WordLockFragment.this.getChildFragmentManager().mo312a("moreInfo");
////                    if (a != null) {
////                        WordLockFragment.this.removeChild(a);
////                        if (WordLockFragment.this.mMoreWordInfoFragment == a) {
////                            WordLockFragment.this.mMoreWordInfoFragment = null;
////                        }
////                        WordLockFragment.this.switchBottomTip(R.string.wordlock_op_unlock);
////                        WordLockFragment.this.activeBottomClickToBack(false);
////                    }
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//
//                public void onAnimationStart(Animation animation) {
//                }
//            });
//        }
//    }
//
//    private void removeSearchFrame() {
//        if (this.mSearchFrame != null && this.mWordSearchFragment != null) {
//            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_out);
//            this.mSearchFrame.setVisibility(8);
//            this.mSearchFrame.startAnimation(loadAnimation);
//            loadAnimation.setAnimationListener(new AnimationListener() {
//                public void onAnimationEnd(Animation animation) {
//                    WordLockFragment.this.mWordLine.setVisibility(0);
//                    WordLockFragment.this.mBottomBar.setVisibility(0);
////                    WordLockFragment.this.removeChild(WordLockFragment.this.mWordSearchFragment);
//                    WordLockFragment.this.mWordSearchFragment = null;
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//
//                public void onAnimationStart(Animation animation) {
//                }
//            });
//            freezeWordLock(false);
//        }
//    }
//
//    public void dispMore(long j) {
//        this.mWordLine.setEnabled(false);
//        this.mWillDisplayMore = true;
//        this.mHandler.postDelayed(new Runnable() {
//            public void run() {
//                if (WordLockFragment.this.mWillDisplayMore) {
//                    WordLockFragment.this.mMoreInfoFrame.setVisibility(0);
//                    WordLockFragment.this.mMoreInfoFrame.startAnimation(AnimationUtils.loadAnimation(WordLockFragment.this.getActivity(), R.anim.wordlock_fade_in));
////                    MoreWordInfoFragment newInstance = MoreWordInfoFragment.newInstance(WordLockFragment.this.mWordLine.getCurrentWord());
////                    WordLockFragment.this.addChild(R.id.wordlock_more_info_frame, newInstance, "moreInfo");
////                    WordLockFragment.this.mMoreWordInfoFragment = newInstance;
//                    WordLockFragment.this.switchBottomTip(R.string.wordlock_op_back);
//                    WordLockFragment.this.activeBottomClickToBack(true);
//                    NavigationManager.setNavingToMore(false);
//                }
//            }
//        }, j);
//    }
//
//    public void onPause() {
//        super.onPause();
//        this.mWillDisplayMore = false;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void back(final MoreWordInfoFragment moreWordInfoFragment) {
//        if (moreWordInfoFragment != null) {
//            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_out);
//            this.mMoreInfoFrame.setVisibility(8);
//            this.mMoreInfoFrame.startAnimation(loadAnimation);
//            loadAnimation.setAnimationListener(new AnimationListener() {
//                public void onAnimationEnd(Animation animation) {
////                    WordLockFragment.this.removeChild(moreWordInfoFragment);
////                    if (WordLockFragment.this.mMoreWordInfoFragment == moreWordInfoFragment) {
////                        WordLockFragment.this.mMoreWordInfoFragment = null;
////                    }
////                    NavigationManager.setNavingToWord(false);
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//
//                public void onAnimationStart(Animation animation) {
//                }
//            });
//        }
//        if (this.mWordLine != null) {
//            this.mWordLine.back();
//        }
//        switchBottomTip(R.string.wordlock_op_unlock);
//        activeBottomClickToBack(false);
//        this.mWordLine.setEnabled(true);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void cancelSearch(final WordSearchFragment wordSearchFragment) {
//        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_in);
////        if (this.mMoreWordInfoFragment != null) {
////            this.mMoreWordInfoFragment.setLockBack(false);
////            this.mMoreInfoFrame.startAnimation(loadAnimation);
////            this.mMoreInfoFrame.setVisibility(0);
////        } else {
////            this.mDotsNav.startAnimation(loadAnimation);
////            this.mDotsNav.setVisibility(0);
////        }
//        this.mWordLine.startAnimation(loadAnimation);
//        this.mWordLine.setVisibility(0);
//        this.mBottomBar.startAnimation(loadAnimation);
//        this.mBottomBar.setVisibility(0);
//        Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_out);
//        this.mSearchFrame.setVisibility(8);
//        loadAnimation2.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
////                WordLockFragment.this.removeChild(wordSearchFragment);
////                if (WordLockFragment.this.mWordSearchFragment == wordSearchFragment) {
////                    WordLockFragment.this.mWordSearchFragment = null;
////                }
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//        this.mSearchFrame.startAnimation(loadAnimation2);
//        freezeWordLock(false);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void selectSearchResult(final WordSearchFragment wordSearchFragment, final Word word) {
//        this.mBottomBar.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_in));
//        this.mBottomBar.setVisibility(0);
////        if (this.mMoreWordInfoFragment != null) {
////            this.mMoreWordInfoFragment.setLockBack(false);
//////            removeChild(this.mMoreWordInfoFragment);
////            this.mMoreWordInfoFragment = null;
////        }
//        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_out);
//        this.mSearchFrame.setVisibility(8);
//        loadAnimation.setAnimationListener(new AnimationListener() {
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationEnd(Animation animation) {
////                WordLockFragment.this.removeChild(wordSearchFragment);
//                if (WordLockFragment.this.mWordSearchFragment == wordSearchFragment) {
//                    WordLockFragment.this.mWordSearchFragment = null;
//                }
//                WordLockFragment.this.mWordLine.setVisibility(0);
//                WordLockFragment.this.mWordLine.fillSearchResult(word);
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//        this.mSearchFrame.startAnimation(loadAnimation);
//        freezeWordLock(false);
//        this.mSearchHistoryHandler.addSearchHistory(word);
//    }
//
//    public void onEventMainThread(DispMoreInfoEvent dispMoreInfoEvent) {
//        dispMore(dispMoreInfoEvent.getDelayed());
//    }
//
//    public void onEventMainThread(ToggleControllerEvent toggleControllerEvent) {
//        if (this.mDotsNav != null) {
//            boolean isDisplay = toggleControllerEvent.isDisplay();
//            this.mDotsNav.startAnimation(AnimationUtils.loadAnimation(getActivity(), isDisplay ? R.anim.wordlock_fade_in : R.anim.wordlock_fade_out));
//            this.mDotsNav.setVisibility(isDisplay ? 0 : 4);
//        }
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.wordlock_op_tip) {
////            EventBus.m0a().mo9c((Object) new KeyEvent(1, 4));
//        } else if (this.mOnWordLockListener != null) {
//            this.mOnWordLockListener.onGuideUnlock();
//        }
//    }
//
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        if (view.getId() == R.id.wordlock_search && motionEvent.getAction() == 0) {
//            if (!Settings.doesWordSearchUsed()) {
//                Settings.setWordSearchUsed(true);
//                updateSearchIcon();
//            }
//            goSearch();
//        }
//        return false;
//    }
//
//    private void goSearch() {
//        if (NavigationManager.canNavToSearch()) {
//            NavigationManager.setNavingToSearch(true);
//            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_out);
//            loadAnimation.setAnimationListener(new AnimationListener() {
//                public void onAnimationStart(Animation animation) {
//                }
//
//                public void onAnimationEnd(Animation animation) {
//                    NavigationManager.setNavingToSearch(false);
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//            });
////            if (this.mMoreWordInfoFragment != null) {
////                this.mMoreWordInfoFragment.setLockBack(true);
////                this.mMoreInfoFrame.startAnimation(loadAnimation);
////                this.mMoreInfoFrame.setVisibility(4);
////            } else {
////                this.mDotsNav.startAnimation(loadAnimation);
////                this.mDotsNav.setVisibility(4);
////            }
//            this.mWordLine.startAnimation(loadAnimation);
//            this.mWordLine.setVisibility(4);
//            this.mBottomBar.startAnimation(loadAnimation);
//            this.mBottomBar.setVisibility(4);
//            this.mSearchFrame.setVisibility(0);
//            this.mWordSearchFragment = WordSearchFragment.newInstance(com.baicizhan.client.business.search.Settings.hasHistory());
////            addChild(R.id.wordlock_search_frame, this.mWordSearchFragment, "search");
//            freezeWordLock(true);
//        }
//    }
//
//    private void freezeWordLock(boolean z) {
//        if (this.mOnWordLockListener != null) {
//            this.mOnWordLockListener.onWordLockFreeze(z);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void switchBottomTip(final int i) {
//        if (this.mBottomTip != null) {
//            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wordlock_fade_out_short);
//            this.mBottomTip.startAnimation(loadAnimation);
//            loadAnimation.setAnimationListener(new AnimationListener() {
//                public void onAnimationEnd(Animation animation) {
//                    WordLockFragment.this.mBottomTip.setText(i);
//                    WordLockFragment.this.mBottomTip.startAnimation(AnimationUtils.loadAnimation(WordLockFragment.this.getActivity(), R.anim.wordlock_fade_in_short));
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//
//                public void onAnimationStart(Animation animation) {
//                }
//            });
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void activeBottomClickToBack(boolean z) {
//        if (this.mBottomTip != null) {
//            if (z) {
//                this.mBottomTip.setOnClickListener(this);
//            } else {
//                this.mBottomTip.setOnClickListener(null);
//            }
//        }
//    }
//
//    public void onWordLockToggle(boolean z) {
//        if (z) {
//            scaleBack();
//        } else {
//            shrinkToFinish();
//        }
//    }
//
//    private void scaleBack() {
//        ViewHelper.m3390b(this.mDotsNav, (float) (this.mDotsNav.getWidth() / 2));
//        ViewHelper.m3391c(this.mDotsNav, (float) (this.mDotsNav.getHeight() / 2));
//        ViewHelper.m3390b(this.mWordLine, (float) (this.mWordLine.getWidth() / 2));
//        ViewHelper.m3391c(this.mWordLine, (float) (this.mWordLine.getHeight() / 2));
//        ObjectAnimator.m3360a(this.mDotsNav, "scaleX", 0.9f, 1.0f).mo16215a(300).mo16161a();
//        ObjectAnimator.m3360a(this.mDotsNav, "scaleY", 0.9f, 1.0f).mo16215a(300).mo16161a();
//        ObjectAnimator.m3360a(this.mWordLine, "scaleX", 0.9f, 1.0f).mo16215a(300).mo16161a();
//        ObjectAnimator.m3360a(this.mWordLine, "scaleY", 0.9f, 1.0f).mo16215a(300).mo16161a();
////        HelpGuideEvent helpGuideEvent = new HelpGuideEvent();
////        helpGuideEvent.setEventId(1);
////        EventBus.m0a().mo9c((Object) helpGuideEvent);
//    }
//
//    private void shrinkToFinish() {
//        ViewHelper.m3390b(getView(), (float) (getView().getWidth() / 2));
//        ViewHelper.m3391c(getView(), (float) (getView().getHeight() / 2));
//        ObjectAnimator.m3360a(getView(), "scaleX", 1.0f, 0.0f).mo16215a(300).mo16161a();
//        ObjectAnimator.m3360a(getView(), "scaleY", 1.0f, 0.0f).mo16215a(300).mo16161a();
//        ObjectAnimator a = ObjectAnimator.m3360a(getView(), "alpha", 1.0f, 0.0f).mo16215a(300);
//        a.mo16162a((C1549b) new C1549b() {
//            public void onAnimationCancel(Animator aVar) {
//            }
//
//            public void onAnimationEnd(Animator aVar) {
//                WordLockFragment.this.getActivity().finish();
//            }
//
//            public void onAnimationRepeat(Animator aVar) {
//            }
//
//            public void onAnimationStart(Animator aVar) {
//            }
//        });
//        a.mo16161a();
//    }
//
//    /* access modifiers changed from: private */
//    public void removeChild(Fragment fragment) {
////        FragmentTransaction a = getChildFragmentManager().mo313a();
////        a.mo181a(fragment);
////        a.mo186c();
//    }
//
//    /* access modifiers changed from: private */
//    public void addChild(int i, Fragment fragment, String str) {
////        FragmentTransaction a = getChildFragmentManager().mo313a();
////        a.mo180a(i, fragment, str);
////        a.mo186c();
//    }
//
//    public void onSaveInstanceState(Bundle bundle) {
//        bundle.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
//        super.onSaveInstanceState(bundle);
//    }
//}
