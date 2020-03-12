//package com.baicizhan.main.plusreview.data;
//
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.framework.util.FileHelper;
//import java.io.File;
//import java.util.HashSet;
//import java.util.Set;
//
//public class RecognitionData {
//    public static final String OPEN_EARS_DB_NAME = "jiong100openears.sqlite";
//    public static final String OPEN_EARS_DIR = "dict_audios_of_word_level";
//    public static final String OPEN_EARS_PATH_PRE = "pack/info/dict_audios_of_word_level";
//    public static final String VOICE_MODEL_NAME = "hub4wsj_sc_8k";
//    public static final String VOICE_MODEL_PATH = PathUtil.getBaicizhanFile(VOICE_MODEL_NAME).getAbsolutePath();
//    public static final Set<String> VOICE_MODEL_SET;
//    private String dicPath;
//    private String dmpPath;
//    private int topicId;
//
//    static {
//        HashSet hashSet = new HashSet();
//        VOICE_MODEL_SET = hashSet;
//        hashSet.add(PathUtil.getBaicizhanFile("hub4wsj_sc_8k/feat.params").getAbsolutePath());
//        VOICE_MODEL_SET.add(PathUtil.getBaicizhanFile("hub4wsj_sc_8k/mdef").getAbsolutePath());
//        VOICE_MODEL_SET.add(PathUtil.getBaicizhanFile("hub4wsj_sc_8k/means").getAbsolutePath());
//        VOICE_MODEL_SET.add(PathUtil.getBaicizhanFile("hub4wsj_sc_8k/noisedict").getAbsolutePath());
//        VOICE_MODEL_SET.add(PathUtil.getBaicizhanFile("hub4wsj_sc_8k/sendump").getAbsolutePath());
//        VOICE_MODEL_SET.add(PathUtil.getBaicizhanFile("hub4wsj_sc_8k/transition_matrices").getAbsolutePath());
//        VOICE_MODEL_SET.add(PathUtil.getBaicizhanFile("hub4wsj_sc_8k/variances").getAbsolutePath());
//    }
//
//    public static boolean isOpenEarsDBExists() {
//        return PathUtil.getBaicizhanFile("jiong100openears.sqlite").exists();
//    }
//
//    public static boolean isVoiceModelFilesExists() {
//        File baicizhanFile = PathUtil.getBaicizhanFile(VOICE_MODEL_NAME);
//        if (!baicizhanFile.exists() || !baicizhanFile.isDirectory()) {
//            return false;
//        }
//        File[] listFiles = baicizhanFile.listFiles();
//        if (listFiles == null || listFiles.length != VOICE_MODEL_SET.size()) {
//            return false;
//        }
//        for (File file : listFiles) {
//            if (!VOICE_MODEL_SET.contains(file.getAbsolutePath()) || !file.exists()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean clearVoiceModelDir() {
//        return FileHelper.deleteDir(PathUtil.getBaicizhanFile(VOICE_MODEL_NAME));
//    }
//
//    public int getTopicId() {
//        return this.topicId;
//    }
//
//    public void setTopicId(int i) {
//        this.topicId = i;
//    }
//
//    public String getDicPath() {
//        return this.dicPath;
//    }
//
//    public void setDicPath(String str) {
//        this.dicPath = str;
//    }
//
//    public String getDmpPath() {
//        return this.dmpPath;
//    }
//
//    public void setDmpPath(String str) {
//        this.dmpPath = str;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("RecognitionData {");
//        sb.append("[topicId: ").append(this.topicId).append("]; [dicPath: ").append(this.dicPath).append("]; [dmpPath: ").append(this.dmpPath).append("]}");
//        return sb.toString();
//    }
//}
