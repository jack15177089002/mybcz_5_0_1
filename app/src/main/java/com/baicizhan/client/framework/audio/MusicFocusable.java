package com.baicizhan.client.framework.audio;

public interface MusicFocusable {
    void onGainedAudioFocus();

    void onLostAudioFocus(boolean z);
}
