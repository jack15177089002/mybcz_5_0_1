package com.baicizhan.client.business.widget;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.baicizhan.client.business.BusinessAppHandler;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
import com.baicizhan.client.business.util.SystemUtil;
import com.baicizhan.client.business.util.ThemeResUtil;
import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.online.bs_users.BSUsers.Client;

public class WordErrFeedbackFragment extends FullDialogFragment implements OnClickListener, OnTouchListener {
    private static final String ARG_WORD = "word";
    private static final int FB_LIMIT = 400;
    private View mCancel;
    private EditText mFBContent;
    private OnFBFragmentInteractionListener mListener;
    private View mSubmit;
    /* access modifiers changed from: private */
    public Word mWord;

    public interface OnFBFragmentInteractionListener {
        void onFBDetach();
    }

    public static class Word implements Parcelable {
        public  final Creator<Word> CREATOR = new Creator<Word>() {
            public final Word createFromParcel(Parcel parcel) {
                return new Word(parcel);
            }

            public final Word[] newArray(int i) {
                return new Word[i];
            }
        };

        /* renamed from: id */
        private int f2241id;
        private String word;

        public int getId() {
            return this.f2241id;
        }

        public void setId(int i) {
            this.f2241id = i;
        }

        public String getWord() {
            return this.word;
        }

        public void setWord(String str) {
            this.word = str;
        }

        public Word() {
        }

        public Word(Parcel parcel) {
            this.f2241id = parcel.readInt();
            this.word = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2241id);
            parcel.writeString(this.word);
        }
    }

    public static WordErrFeedbackFragment newInstance(Word word) {
        WordErrFeedbackFragment wordErrFeedbackFragment = new WordErrFeedbackFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("word", word);
        wordErrFeedbackFragment.setArguments(bundle);
        return wordErrFeedbackFragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (OnFBFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mWord = getArguments() != null ? (Word) getArguments().getParcelable("word") : null;
        setCancelableOnTouchOutside(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_word_error_feedback, viewGroup);
        inflate.findViewById(R.id.fb_window).setOnClickListener(this);
        ((TextView) inflate.findViewById(R.id.fb_title)).setText(getString(R.string.word_error_feedback_title, this.mWord.getWord()));
        ((TextView) inflate.findViewById(R.id.fb_limit)).setText(getString(R.string.word_error_feedback_limit, Integer.valueOf(FB_LIMIT)));
        this.mSubmit = inflate.findViewById(R.id.fb_submit);
        ThemeResUtil.setSubmitBtnShape(getActivity(), this.mSubmit);
        this.mSubmit.setOnClickListener(this);
        this.mCancel = inflate.findViewById(R.id.fb_cancel);
        this.mCancel.setOnClickListener(this);
        this.mFBContent = (EditText) inflate.findViewById(R.id.fb_edit);
        this.mFBContent.setMaxLines(FB_LIMIT);
        this.mFBContent.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2) {
                    WordErrFeedbackFragment.this.submit(WordErrFeedbackFragment.this.mWord.getId());
                } else {
                    SystemUtil.hideIME(textView);
                }
                return true;
            }
        });
        View findViewById = inflate.findViewById(R.id.fb_bg_mask);
        this.mTransitionManager.cancelByMask(findViewById);
        this.mTransitionManager.fadeIn(inflate);
        findViewById.setOnTouchListener(this);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        this.mTransitionManager.overBackOnResume();
    }

    public void dismiss() {
        this.mTransitionManager.fadeOut(getView());
    }

    public void onDetach() {
        super.onDetach();
        if (this.mListener != null) {
            this.mListener.onFBDetach();
        }
        this.mListener = null;
    }

    public void onClick(View view) {
        if (view == this.mSubmit) {
            submit(this.mWord.getId());
        } else if (view == this.mCancel) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public void submit(final int i) {
        SystemUtil.hideIME(this.mFBContent);
        final String obj = this.mFBContent.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            toast(R.string.word_error_feedback_no_content);
            dismiss();
        } else if (!NetworkUtils.isNetworkAvailable(getActivity())) {
            toast(R.string.word_error_feedback_failed_net);
            dismiss();
        } else {
            toast(R.string.word_error_feedback_start);
//            BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//                /* access modifiers changed from: protected */
//                public Integer doInBackground(Client client) {
//                    return Integer.valueOf(client.add_word_friend_feedback(i, obj));
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                    WordErrFeedbackFragment.toast(R.string.word_error_feedback_failed);
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(Integer num) {
//                    if (num.intValue() == 0) {
//                        WordErrFeedbackFragment.toast(R.string.word_error_feedback_success);
//                    } else {
//                        WordErrFeedbackFragment.toast(R.string.word_error_feedback_failed);
//                    }
//                }
//            });
            dismiss();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        SystemUtil.hideIME(view);
        return false;
    }

    /* access modifiers changed from: private */
    public static void toast(int i) {
        Application app = BusinessAppHandler.getApp();
        if (app != null) {
            Toast.makeText(app, i, 0).show();
        }
    }
}
