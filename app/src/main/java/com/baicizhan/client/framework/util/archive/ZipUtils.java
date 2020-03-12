package com.baicizhan.client.framework.util.archive;

import com.baicizhan.client.framework.util.Cancelable;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils extends ICancel {
    private final int BUFFER = 1024;
    public final String EXT = ".zip";

    public String decompress(String str, Cancelable cancelable) {
        return decompress(str, true, cancelable);
    }

    public String decompress(String str, boolean z, Cancelable cancelable) {
        return decompress(new File(str), z, cancelable);
    }

    public String decompress(File file, Cancelable cancelable) {
        return decompress(file, true, cancelable);
    }

    public String decompress(File file, boolean z, Cancelable cancelable) {
        return decompress(file, file.getPath().replace(".zip", ""), z, cancelable);
    }

    public String decompress(File file, File file2, Cancelable cancelable) {
        return decompress(file, file2, true, cancelable);
    }

    public String decompress(File file, File file2, boolean z, Cancelable cancelable) {
        this.mCancle = cancelable;
        ZipInputStream zipInputStream = new ZipInputStream(new CheckedInputStream(new FileInputStream(file), new CRC32()));
        decompress(file2, zipInputStream);
        zipInputStream.close();
        if (z && !isCanceled()) {
            file.delete();
        }
        return file2.getAbsolutePath();
    }

    public String decompress(File file, String str, Cancelable cancelable) {
        return decompress(file, str, true, cancelable);
    }

    public String decompress(File file, String str, boolean z, Cancelable cancelable) {
        return decompress(file, new File(str), z, cancelable);
    }

    public String decompress(String str, String str2, Cancelable cancelable) {
        return decompress(str, str2, true, cancelable);
    }

    public String decompress(String str, String str2, boolean z, Cancelable cancelable) {
        return decompress(new File(str), str2, z, cancelable);
    }

    private void decompress(File file, ZipInputStream zipInputStream) {
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null && !isCanceled()) {
                File file2 = new File(file.getPath() + File.separator + nextEntry.getName());
                fileProber(file2);
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    decompressFile(file2, zipInputStream);
                }
                zipInputStream.closeEntry();
            } else {
                return;
            }
        }
    }

    private void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            fileProber(parentFile);
            parentFile.mkdir();
        }
    }

    private void decompressFile(File file, ZipInputStream zipInputStream) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1 || isCanceled()) {
                bufferedOutputStream.close();
            } else {
                bufferedOutputStream.write(bArr, 0, read);
            }
        }
        bufferedOutputStream.close();
    }
}
