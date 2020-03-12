package p012ch.qos.logback.core;

import p012ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.LayoutBase */
public abstract class LayoutBase<E> extends ContextAwareBase implements Layout<E> {
    String fileFooter;
    String fileHeader;
    String presentationFooter;
    String presentationHeader;
    protected boolean started;

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }

    public void start() {
        this.started = true;
    }

    public void stop() {
        this.started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public String getFileHeader() {
        return this.fileHeader;
    }

    public String getPresentationHeader() {
        return this.presentationHeader;
    }

    public String getPresentationFooter() {
        return this.presentationFooter;
    }

    public String getFileFooter() {
        return this.fileFooter;
    }

    public String getContentType() {
        return "text/plain";
    }

    public void setFileHeader(String str) {
        this.fileHeader = str;
    }

    public void setFileFooter(String str) {
        this.fileFooter = str;
    }

    public void setPresentationHeader(String str) {
        this.presentationHeader = str;
    }

    public void setPresentationFooter(String str) {
        this.presentationFooter = str;
    }
}
