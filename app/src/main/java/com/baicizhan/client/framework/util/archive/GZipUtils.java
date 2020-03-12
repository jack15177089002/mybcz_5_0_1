package com.baicizhan.client.framework.util.archive;

import com.baicizhan.client.framework.util.Cancelable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipUtils extends ICancel {
    public final int BUFFER = 1024;
    public final String EXT = ".gz";

    public byte[] compress(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        compress((InputStream) byteArrayInputStream, (OutputStream) byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    public void compress(File file) {
        compress(file, true);
    }

    public void compress(File file, boolean z) {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file.getPath() + ".gz");
        compress((InputStream) fileInputStream, (OutputStream) fileOutputStream);
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        if (z) {
            file.delete();
        }
    }

    public void compress(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read == -1 || isCanceled()) {
                gZIPOutputStream.finish();
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
            } else {
                gZIPOutputStream.write(bArr, 0, read);
            }
        }
        gZIPOutputStream.finish();
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
    }

    public void compress(String str) {
        compress(str, true);
    }

    public void compress(String str, boolean z) {
        compress(new File(str), z);
    }

    public byte[] decompress(byte[] bArr, Cancelable cancelable) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decompress((InputStream) byteArrayInputStream, (OutputStream) byteArrayOutputStream, cancelable);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    public String decompress(File file, Cancelable cancelable) {
        return decompress(file, true, cancelable);
    }

    public String decompress(File file, boolean z, Cancelable cancelable) {
        return decompress(file, (String) null, z, cancelable);
    }

    public String decompress(File file, File file2, Cancelable cancelable) {
        return decompress(file, file2, true, cancelable);
    }

    public String decompress(String str, String str2, Cancelable cancelable) {
        return decompress(str, str2, true, cancelable);
    }

    public String decompress(String str, String str2, boolean z, Cancelable cancelable) {
        return decompress(new File(str), str2, z, cancelable);
    }

    public String decompress(File file, File file2, boolean z, Cancelable cancelable) {
        if (file2 != null) {
            return decompress(file, file2.getAbsolutePath(), z, cancelable);
        }
        return decompress(file, (String) null, z, cancelable);
    }

    public String decompress(File file, String str, boolean z, Cancelable cancelable) {
        if (str == null) {
            str = file.getPath().replace(".gz", "");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        decompress((InputStream) fileInputStream, (OutputStream) fileOutputStream, cancelable);
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        if (z && !isCanceled()) {
            file.delete();
        }
        return str;
    }

    public void decompress(InputStream inputStream, OutputStream outputStream, Cancelable cancelable) {
        this.mCancle = cancelable;
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr, 0, 1024);
            if (read == -1 || isCanceled()) {
                gZIPInputStream.close();
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
        gZIPInputStream.close();
    }

    public String decompress(String str, Cancelable cancelable) {
        return decompress(str, true, cancelable);
    }

    public String decompress(String str, boolean z, Cancelable cancelable) {
        return decompress(new File(str), z, cancelable);
    }
}
