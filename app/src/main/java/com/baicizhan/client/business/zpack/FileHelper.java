package com.baicizhan.client.business.zpack;

import java.io.File;
import java.io.IOException;

public class FileHelper {
    public static void deleteFile(String str) {
        deleteFile(new File(str));
    }

    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            for (File deleteFile : file.listFiles()) {
                deleteFile(deleteFile);
            }
        }
        file.delete();
    }

    public static boolean renameFile(String str, String str2) {
        return new File(str).renameTo(new File(str2));
    }

    public static boolean mkdir(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            return true;
        }
        return file.mkdir();
    }

    public static boolean makePath(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static boolean createFile(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf > 0 && !makePath(str.substring(0, lastIndexOf + 1))) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return false;
        }
        try {
            file.createNewFile();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String[] splitext(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            return new String[]{str.substring(0, lastIndexOf), str.substring(lastIndexOf + 1)};
        }
        return new String[]{str, ""};
    }
}
