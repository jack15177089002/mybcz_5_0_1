//package com.baicizhan.client.business.managers;
//
//import android.content.Context;
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.os.Looper;
//import android.os.Message;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlaySateListener;
//import java.io.File;
//
//public class AsyncAudioPlayer {
//    public static final int MSG_PAUSE = 5;
//    public static final int MSG_PLAY_ASSET = 2;
//    public static final int MSG_PLAY_FILE = 1;
//    public static final int MSG_PLAY_RAW = 3;
//    public static final int MSG_STOP = 4;
//    private static final String TAG = AsyncAudioPlayer.class.getSimpleName();
//    private AudioPlayer mAudioPlayer;
//    private Handler mWorkerHandler;
//    private HandlerThread mWorkerThread = new HandlerThread(TAG);
//
//    class AudioPlayData {
//        public OnPlaySateListener listener;
//        public Object target;
//
//        private AudioPlayData() {
//        }
//    }
//
//    class AudioPlayHandler extends Handler {
//        private AudioPlayer audioPlayer;
//
//        AudioPlayHandler(Looper looper, AudioPlayer audioPlayer2) {
//            super(looper);
//            this.audioPlayer = audioPlayer2;
//        }
//
//        public void handleMessage(Message message) {
//            switch (message.what) {
//                case 1:
//                case 2:
//                case 3:
//                    AudioPlayData audioPlayData = (AudioPlayData) message.obj;
//                    this.audioPlayer.setOnPlaySateListener(audioPlayData.listener);
//                    if (message.what == 1) {
//                        this.audioPlayer.newPlay((File) audioPlayData.target);
//                        return;
//                    } else if (message.what == 2) {
//                        this.audioPlayer.newPlayAssets((String) audioPlayData.target, false);
//                        return;
//                    } else if (message.what == 3) {
//                        this.audioPlayer.newPlayRaw(((Integer) audioPlayData.target).intValue());
//                        return;
//                    } else {
//                        return;
//                    }
//                case 4:
//                    this.audioPlayer.stop();
//                    return;
//                case 5:
//                    this.audioPlayer.pause();
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    public AsyncAudioPlayer(Context context) {
//        this.mAudioPlayer = new AudioPlayer(context);
//        this.mWorkerThread.start();
//        this.mWorkerHandler = new AudioPlayHandler(this.mWorkerThread.getLooper(), this.mAudioPlayer);
//    }
//
//    public void destroy() {
//        this.mAudioPlayer.stop();
//        this.mWorkerHandler.removeCallbacksAndMessages(null);
//        this.mWorkerThread.quit();
//    }
//
//    public void newPlay(File file, OnPlaySateListener onPlaySateListener) {
//        AudioPlayData audioPlayData = new AudioPlayData();
//        audioPlayData.target = file;
//        audioPlayData.listener = onPlaySateListener;
//        this.mWorkerHandler.sendMessage(this.mWorkerHandler.obtainMessage(1, audioPlayData));
//    }
//
//    public void newPlayAsset(String str, OnPlaySateListener onPlaySateListener) {
//        AudioPlayData audioPlayData = new AudioPlayData();
//        audioPlayData.target = str;
//        audioPlayData.listener = onPlaySateListener;
//        this.mWorkerHandler.sendMessage(this.mWorkerHandler.obtainMessage(2, audioPlayData));
//    }
//
//    public void newPlayRaw(int i, OnPlaySateListener onPlaySateListener) {
//        AudioPlayData audioPlayData = new AudioPlayData();
//        audioPlayData.target = Integer.valueOf(i);
//        audioPlayData.listener = onPlaySateListener;
//        this.mWorkerHandler.sendMessage(this.mWorkerHandler.obtainMessage(3, audioPlayData));
//    }
//}
