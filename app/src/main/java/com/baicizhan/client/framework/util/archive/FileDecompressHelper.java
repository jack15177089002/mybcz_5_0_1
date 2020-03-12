package com.baicizhan.client.framework.util.archive;

import com.baicizhan.client.framework.util.Cancelable;
import java.io.File;

public class FileDecompressHelper {
    public final String decompTarGz(String str, String str2, boolean z, Cancelable cancelable) {
        if (str.toLowerCase().lastIndexOf(".tar.gz") <= 0) {
            throw new IllegalArgumentException("Incorrect .tar.gz file type.");
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            throw new IllegalArgumentException(str + " is not a valid .tar.gz file.");
        }
        File file2 = new File(new GZipUtils().decompress(file, z, cancelable));
        if (file2.exists() && !file2.isDirectory()) {
            return new TarUtils().dearchive(file2, str2, z, cancelable);
        }
        throw new RuntimeException(str + " is not tared correctly.");
    }

    public final String decompTarGz(String str, String str2, Cancelable cancelable) {
        if (str.toLowerCase().lastIndexOf(".tar.gz") <= 0) {
            throw new IllegalArgumentException("Incorrect .tar.gz file type.");
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            throw new IllegalArgumentException(str + " is not a valid .tar.gz file.");
        }
        File file2 = new File(new GZipUtils().decompress(file, cancelable));
        if (file2.exists() && !file2.isDirectory()) {
            return new TarUtils().dearchive(file2, str2, cancelable);
        }
        throw new RuntimeException(str + " is not tared correctly.");
    }

    public final String decompTarGz(String str, boolean z, Cancelable cancelable) {
        if (str.toLowerCase().lastIndexOf(".tar.gz") <= 0) {
            throw new IllegalArgumentException("Incorrect .tar.gz file type.");
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            throw new IllegalArgumentException(str + " is not a valid .tar.gz file.");
        }
        File file2 = new File(new GZipUtils().decompress(file, z, cancelable));
        if (file2.exists() && !file2.isDirectory()) {
            return new TarUtils().dearchive(file2, z, cancelable);
        }
        throw new RuntimeException(str + " is not tared correctly.");
    }

    public final String decompTarGz(String str, Cancelable cancelable) {
        if (str.toLowerCase().lastIndexOf(".tar.gz") <= 0) {
            throw new IllegalArgumentException("Incorrect .tar.gz file type.");
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            throw new IllegalArgumentException(str + " is not a valid .tar.gz file.");
        }
        File file2 = new File(new GZipUtils().decompress(file, cancelable));
        if (file2.exists() && !file2.isDirectory()) {
            return new TarUtils().dearchive(file2, cancelable);
        }
        throw new RuntimeException(str + " is not tared correctly.");
    }

    public final String decompTarGz(File file, File file2, boolean z, Cancelable cancelable) {
        File file3 = new File(new GZipUtils().decompress(file, z, cancelable));
        if (file3.exists() && !file3.isDirectory()) {
            return new TarUtils().dearchive(file3, file2, z, cancelable);
        }
        throw new RuntimeException(file + " is not tared correctly.");
    }

    public final String decompTarGz(File file, File file2, Cancelable cancelable) {
        File file3 = new File(new GZipUtils().decompress(file, cancelable));
        if (file3.exists() && !file3.isDirectory()) {
            return new TarUtils().dearchive(file3, file2, cancelable);
        }
        throw new RuntimeException(file + " is not tared correctly.");
    }

    public final String decompTarGz(File file, boolean z, Cancelable cancelable) {
        File file2 = new File(new GZipUtils().decompress(file, z, cancelable));
        if (file2.exists() && !file2.isDirectory()) {
            return new TarUtils().dearchive(file2, z, cancelable);
        }
        throw new RuntimeException(file + " is not tared correctly.");
    }

    public final String decompTarGz(File file, Cancelable cancelable) {
        File file2 = new File(new GZipUtils().decompress(file, cancelable));
        if (file2.exists() && !file2.isDirectory()) {
            return new TarUtils().dearchive(file2, cancelable);
        }
        throw new RuntimeException(file + " is not tared correctly.");
    }

    public final String decompGz(String str, String str2, boolean z, Cancelable cancelable) {
        return new GZipUtils().decompress(str, str2, z, cancelable);
    }

    public final String decompGz(String str, boolean z, Cancelable cancelable) {
        return new GZipUtils().decompress(str, z, cancelable);
    }

    public final String decompGz(String str, String str2, Cancelable cancelable) {
        return new GZipUtils().decompress(str, str2, cancelable);
    }

    public final String decompGz(String str, Cancelable cancelable) {
        return new GZipUtils().decompress(str, cancelable);
    }

    public final String decompGz(File file, File file2, boolean z, Cancelable cancelable) {
        return new GZipUtils().decompress(file, file2, z, cancelable);
    }

    public final String decompGz(File file, boolean z, Cancelable cancelable) {
        return new GZipUtils().decompress(file, z, cancelable);
    }

    public final String decompGz(File file, File file2, Cancelable cancelable) {
        return new GZipUtils().decompress(file, file2, cancelable);
    }

    public final String decompGz(File file, Cancelable cancelable) {
        return new GZipUtils().decompress(file, cancelable);
    }

    public final String decompZip(String str, String str2, boolean z, Cancelable cancelable) {
        return new ZipUtils().decompress(str, str2, z, cancelable);
    }

    public final String decompZip(String str, String str2, Cancelable cancelable) {
        return new ZipUtils().decompress(str, str2, true, cancelable);
    }

    public final String decompZip(String str, boolean z, Cancelable cancelable) {
        return new ZipUtils().decompress(str, z, cancelable);
    }

    public final String decompZip(String str, Cancelable cancelable) {
        return new ZipUtils().decompress(str, cancelable);
    }

    public final String decompZip(File file, File file2, boolean z, Cancelable cancelable) {
        return new ZipUtils().decompress(file, file2, z, cancelable);
    }

    public final String decompZip(File file, File file2, Cancelable cancelable) {
        return new ZipUtils().decompress(file, file2, true, cancelable);
    }

    public final String decompZip(File file, boolean z, Cancelable cancelable) {
        return new ZipUtils().decompress(file, z, cancelable);
    }

    public final String decompZip(File file, Cancelable cancelable) {
        return new ZipUtils().decompress(file, cancelable);
    }
}
