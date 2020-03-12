package com.baicizhan.client.framework.util.archive;

import com.baicizhan.client.framework.util.Cancelable;
import java.io.File;
import java.util.Locale;

public class TarUtils extends ICancel {
    private final String BASE_DIR = "";
    private final int BUFFER = 1024;
    private final String EXT = ".tar";
    private final String PATH = "/";

    public void archive(String str, String str2) {
        archive(new File(str), str2);
    }

    public void archive(File file, File file2) {
    }

    public void archive(File file) {
        archive(file, file.getParent() + file.getName() + ".tar");
    }

    public void archive(File file, String str) {
        archive(file, new File(str));
    }

    public void archive(String str) {
        archive(new File(str));
    }

    public String dearchive(File file, Cancelable cancelable) {
        return dearchive(file, true, cancelable);
    }

    public String dearchive(File file, boolean z, Cancelable cancelable) {
        String parent = file.getParent();
        String name = file.getName();
        int indexOf = name.toLowerCase(Locale.US).indexOf(".tar");
        if (indexOf >= 0) {
            name = name.substring(0, indexOf);
        }
        return dearchive(file, parent + "/" + name, z, cancelable);
    }

    public String dearchive(File file, File file2, Cancelable cancelable) {
        return dearchive(file, file2, true, cancelable);
    }

    public String dearchive(File file, File file2, boolean z, Cancelable cancelable) {
        return null;
    }

    public String dearchive(File file, String str, Cancelable cancelable) {
        return dearchive(file, str, true, cancelable);
    }

    public String dearchive(File file, String str, boolean z, Cancelable cancelable) {
        return dearchive(file, new File(str), z, cancelable);
    }

    public void dearchive(String str, boolean z, Cancelable cancelable) {
        dearchive(new File(str), z, cancelable);
    }

    public String dearchive(String str, String str2, boolean z, Cancelable cancelable) {
        return dearchive(new File(str), str2, z, cancelable);
    }

    private void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            fileProber(parentFile);
            parentFile.mkdir();
        }
    }
}
