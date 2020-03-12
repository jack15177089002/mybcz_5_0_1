//package com.baicizhan.client.p029fm.view;
//
//import android.os.Bundle;
////import android.support.p004v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TopicTextRenderHelper.TopicTextRender;
//import com.baicizhan.client.business.widget.WordErrFeedbackFragment;
//import com.baicizhan.client.business.widget.WordErrFeedbackFragment.Word;
////import com.baicizhan.client.p029fm.R;
//import com.baicizhan.client.p029fm.data.FmData;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.ClickEvent;
//import com.baicizhan.client.p029fm.eventbus.FmEvents.PopupEvent;
//import com.jiongji.andriod.card.R;
////import p000a.p001a.p002a.EventBus;
//
///* renamed from: com.baicizhan.client.fm.view.FmNormalFragment */
//public class FmNormalFragment extends Fragment implements OnClickListener, IFragmentUpdator {
//    private static final String KEY_FMDATA = "fmdata";
//    private TextView mCnmean;
//    private View mDivider;
//    private TextView mExample;
//    private FmData mFmData;
//    private Button mSendErr;
//    private TextView mWord;
//
//    public static FmNormalFragment createInstance(FmData fmData) {
//        FmNormalFragment fmNormalFragment = new FmNormalFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(KEY_FMDATA, fmData);
//        fmNormalFragment.setArguments(bundle);
//        return fmNormalFragment;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mFmData = getArguments() != null ? (FmData) getArguments().getParcelable(KEY_FMDATA) : null;
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fm_line_item_normal, viewGroup, false);
//        viewGroup2.setOnClickListener(this);
//        this.mDivider = viewGroup2.findViewById(R.id.fm_line_normal_divider);
//        this.mWord = (TextView) viewGroup2.findViewById(R.id.fm_line_word);
//        this.mCnmean = (TextView) viewGroup2.findViewById(R.id.fm_line_cnmean);
//        this.mExample = (TextView) viewGroup2.findViewById(R.id.fm_line_example);
//        this.mSendErr = (Button) viewGroup2.findViewById(R.id.fm_line_send_err);
//        this.mSendErr.setOnClickListener(this);
//        this.mWord.setText(this.mFmData.getWord());
//        this.mCnmean.setText(this.mFmData.getWordType() + ": " + this.mFmData.getCnmean());
//        TopicTextRender.with(this.mFmData.getExample()).clickable().into(this.mExample);
//        return viewGroup2;
//    }
//
//    public void onClick(View view) {
//        ClickEvent clickEvent = new ClickEvent();
//        clickEvent.setClickType(0);
////        EventBus.m0a().mo9c((Object) clickEvent);
//        if (view == this.mSendErr) {
//            PopupEvent popupEvent = new PopupEvent();
//            popupEvent.setState(0);
////            EventBus.m0a().mo9c((Object) popupEvent);
//            Word word = new Word();
//            word.setId(Integer.valueOf(this.mFmData.getWordid()).intValue());
//            word.setWord(this.mFmData.getWord());
//            WordErrFeedbackFragment.newInstance(word).show(getActivity().getSupportFragmentManager(), "feedback");
//        }
//    }
//
//    public void setEnabled(boolean z) {
//        int i;
//        if (getActivity() != null && !getActivity().isFinishing()) {
//            this.mDivider.setBackgroundColor(ThemeUtil.getThemeColorWithAttr(getActivity(), z ? R.attr.color_line_fm : R.attr.color_fm_disabled));
//            this.mWord.setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), z ? R.attr.color_fm_deep_blue : R.attr.color_fm_disabled));
//            this.mCnmean.setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), z ? R.attr.color_fm_firstcard : R.attr.color_fm_disabled));
//            this.mExample.setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), z ? R.attr.color_fm_firstcard : R.attr.color_fm_disabled));
//            Button button = this.mSendErr;
//            if (z) {
//                i = 0;
//            } else {
//                i = 4;
//            }
//            button.setVisibility(i);
//        }
//    }
//}
