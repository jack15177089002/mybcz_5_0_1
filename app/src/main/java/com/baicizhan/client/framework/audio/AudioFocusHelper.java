//package com.baicizhan.client.framework.audio;
//
//import android.content.Context;
//import android.media.AudioManager;
//import android.media.AudioManager.OnAudioFocusChangeListener;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_LOCK_SEARCH_HISTORY_TB.Columns;
//
//public class AudioFocusHelper implements OnAudioFocusChangeListener {
//    AudioManager mAM;
//    MusicFocusable mFocusable;
//
//    public AudioFocusHelper(Context context, MusicFocusable musicFocusable) {
//        this.mAM = (AudioManager) context.getSystemService(Columns.AUDIO);
//        this.mFocusable = musicFocusable;
//    }
//
//    public boolean requestFocus() {
//        return 1 == this.mAM.requestAudioFocus(this, 3, 1);
//    }
//
//    public boolean abandonFocus() {
//        return 1 == this.mAM.abandonAudioFocus(this);
//    }
//
//    public void onAudioFocusChange(int i) {
//        if (this.mFocusable != null) {
//            switch (i) {
//                case -3:
//                    this.mFocusable.onLostAudioFocus(true);
//                    return;
//                case -2:
//                case -1:
//                    this.mFocusable.onLostAudioFocus(false);
//                    return;
//                case 1:
//                    this.mFocusable.onGainedAudioFocus();
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//}
