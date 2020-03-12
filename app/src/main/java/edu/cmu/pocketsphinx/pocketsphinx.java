package edu.cmu.pocketsphinx;

public class pocketsphinx {
    public static void setLogfile(String path) {
        pocketsphinxJNI.setLogfile(path);
    }
}
