package p012ch.qos.logback.core.pattern;

import java.util.List;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.spi.ContextAware;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.spi.LifeCycle;
import p012ch.qos.logback.core.status.Status;

/* renamed from: ch.qos.logback.core.pattern.DynamicConverter */
public abstract class DynamicConverter<E> extends FormattingConverter<E> implements ContextAware, LifeCycle {
    ContextAwareBase cab = new ContextAwareBase(this);
    private List<String> optionList;
    protected boolean started = false;

    public void start() {
        this.started = true;
    }

    public void stop() {
        this.started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void setOptionList(List<String> list) {
        this.optionList = list;
    }

    public String getFirstOption() {
        if (this.optionList == null || this.optionList.size() == 0) {
            return null;
        }
        return (String) this.optionList.get(0);
    }

    public List<String> getOptionList() {
        return this.optionList;
    }

    public void setContext(Context context) {
        this.cab.setContext(context);
    }

    public Context getContext() {
        return this.cab.getContext();
    }

    public void addStatus(Status status) {
        this.cab.addStatus(status);
    }

    public void addInfo(String str) {
        this.cab.addInfo(str);
    }

    public void addInfo(String str, Throwable th) {
        this.cab.addInfo(str, th);
    }

    public void addWarn(String str) {
        this.cab.addWarn(str);
    }

    public void addWarn(String str, Throwable th) {
        this.cab.addWarn(str, th);
    }

    public void addError(String str) {
        this.cab.addError(str);
    }

    public void addError(String str, Throwable th) {
        this.cab.addError(str, th);
    }
}
