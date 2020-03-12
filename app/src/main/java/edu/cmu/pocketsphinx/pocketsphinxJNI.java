package edu.cmu.pocketsphinx;

class pocketsphinxJNI {
    public static final native void Config_setBoolean(long j, Config aVar, String str, boolean z);

    public static final native void Config_setFloat(long j, Config aVar, String str, double d);

    public static final native void Config_setInt(long j, Config aVar, String str, int i);

    public static final native void Config_setString(long j, Config aVar, String str, String str2);

    public static final native int Decoder_endUtt(long j, Decoder bVar);

    public static final native long Decoder_getHyp(long j, Decoder bVar);

    public static final native int Decoder_processRaw__SWIG_1(long j, Decoder bVar, short[] sArr, long j2, boolean z, boolean z2);

    public static final native int Decoder_startUtt__SWIG_0(long j, Decoder bVar);

    public static final native String Hypothesis_hypstr_get(long j, Hypothesis cVar);

    public static final native void delete_Config(long j);

    public static final native void delete_Decoder(long j);

    public static final native void delete_Hypothesis(long j);

    public static final native long new_Config__SWIG_0();

    public static final native long new_Decoder__SWIG_0();

    public static final native long new_Decoder__SWIG_1(long j, Config aVar);
}
