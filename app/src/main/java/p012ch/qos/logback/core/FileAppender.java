package p012ch.qos.logback.core;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import p012ch.qos.logback.core.recovery.ResilientFileOutputStream;
import p012ch.qos.logback.core.util.EnvUtil;
import p012ch.qos.logback.core.util.FileUtil;

/* renamed from: ch.qos.logback.core.FileAppender */
public class FileAppender<E> extends OutputStreamAppender<E> {
    public boolean append = true;
    public String fileName = null;
    private boolean initialized = false;
    private boolean lazyInit = false;
    private boolean prudent = false;

    public void setFile(String str) {
        if (str == null) {
            this.fileName = null;
        } else {
            this.fileName = str.trim();
        }
    }

    public boolean isAppend() {
        return this.append;
    }

    public final String rawFileProperty() {
        return this.fileName;
    }

    public String getFile() {
        return this.fileName;
    }

    public void start() {
        boolean z = false;
        String file = getFile();
        if (file != null) {
            String absoluteFilePath = getAbsoluteFilePath(file);
            addInfo("File property is set to [" + absoluteFilePath + "]");
            if (this.prudent && !isAppend()) {
                setAppend(true);
                addWarn("Setting \"Append\" property to true on account of \"Prudent\" mode");
            }
            if (!this.lazyInit) {
                try {
                    openFile(absoluteFilePath);
                } catch (IOException e) {
                    addError("openFile(" + absoluteFilePath + "," + this.append + ") failed", e);
                    z = true;
                }
            } else {
                setOutputStream(new NOPOutputStream());
            }
        } else {
            addError("\"File\" property not set for appender named [" + this.name + "]");
            z = true;
        }
        if (!z) {
            super.start();
        }
    }

    public boolean openFile(String str) {
        String absoluteFilePath = getAbsoluteFilePath(str);
        synchronized (this.lock) {
            File file = new File(absoluteFilePath);
            if (FileUtil.isParentDirectoryCreationRequired(file) && !FileUtil.createMissingParentDirectories(file)) {
                addError("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
            }
            ResilientFileOutputStream resilientFileOutputStream = new ResilientFileOutputStream(file, this.append);
            resilientFileOutputStream.setContext(this.context);
            setOutputStream(resilientFileOutputStream);
        }
        return true;
    }

    public boolean isPrudent() {
        return this.prudent;
    }

    public void setPrudent(boolean z) {
        this.prudent = z;
    }

    public void setAppend(boolean z) {
        this.append = z;
    }

    public boolean getLazy() {
        return this.lazyInit;
    }

    public void setLazy(boolean z) {
        this.lazyInit = z;
    }

    /* JADX INFO: finally extract failed */
    private void safeWrite(E e) {
        FileChannel channel = ((ResilientFileOutputStream) getOutputStream()).getChannel();
        if (channel != null) {
            FileLock fileLock = null;
            try {
                FileLock lock = channel.lock();
                long position = channel.position();
                long size = channel.size();
                if (size != position) {
                    channel.position(size);
                }
                super.writeOut(e);
                if (lock != null) {
                    lock.release();
                }
            } catch (Throwable th) {
                if (fileLock != null) {
                    fileLock.release();
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void writeOut(E e) {
        if (this.prudent) {
            safeWrite(e);
        } else {
            super.writeOut(e);
        }
    }

    public void subAppend(E e) {
        if (!this.initialized && this.lazyInit) {
            this.initialized = true;
            try {
                openFile(getFile());
            } catch (IOException e2) {
                this.started = false;
                addError("openFile(" + this.fileName + "," + this.append + ") failed", e2);
            }
        }
        super.subAppend(e);
    }

    /* access modifiers changed from: protected */
    public String getAbsoluteFilePath(String str) {
        if (!EnvUtil.isAndroidOS() || new File(str).isAbsolute()) {
            return str;
        }
        return FileUtil.prefixRelativePath(this.context.getProperty(CoreConstants.DATA_DIR_KEY), str);
    }
}
