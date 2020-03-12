package edu.cmu.pocketsphinx;

import android.os.Bundle;

/* renamed from: edu.cmu.pocketsphinx.d */
public interface RecognitionListener {
    void onError(int i);

    void onPartialResults(Bundle bundle);

    void onResults(Bundle bundle);
}
