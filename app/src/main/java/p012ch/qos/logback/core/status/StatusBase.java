package p012ch.qos.logback.core.status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ch.qos.logback.core.status.StatusBase */
public abstract class StatusBase implements Status {
    private static final List<Status> EMPTY_LIST = new ArrayList(0);
    List<Status> childrenList;
    long date;
    int level;
    final String message;
    final Object origin;
    Throwable throwable;

    StatusBase(int i, String str, Object obj) {
        this(i, str, obj, null);
    }

    StatusBase(int i, String str, Object obj, Throwable th) {
        this.level = i;
        this.message = str;
        this.origin = obj;
        this.throwable = th;
        this.date = System.currentTimeMillis();
    }

    public synchronized void add(Status status) {
        if (status == null) {
            throw new NullPointerException("Null values are not valid Status.");
        }
        if (this.childrenList == null) {
            this.childrenList = new ArrayList();
        }
        this.childrenList.add(status);
    }

    public synchronized boolean hasChildren() {
        return this.childrenList != null && this.childrenList.size() > 0;
    }

    public synchronized Iterator<Status> iterator() {
        Iterator<Status> it;
        if (this.childrenList != null) {
            it = this.childrenList.iterator();
        } else {
            it = EMPTY_LIST.iterator();
        }
        return it;
    }

    public synchronized boolean remove(Status status) {
        boolean remove;
        if (this.childrenList == null) {
            remove = false;
        } else {
            remove = this.childrenList.remove(status);
        }
        return remove;
    }

    public int getLevel() {
        return this.level;
    }

    public synchronized int getEffectiveLevel() {
        int i;
        int i2 = this.level;
        Iterator it = iterator();
        i = i2;
        while (it.hasNext()) {
            int effectiveLevel = ((Status) it.next()).getEffectiveLevel();
            if (effectiveLevel > i) {
                i = effectiveLevel;
            }
        }
        return i;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getOrigin() {
        return this.origin;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public Long getDate() {
        return Long.valueOf(this.date);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (getEffectiveLevel()) {
            case 0:
                stringBuffer.append("INFO");
                break;
            case 1:
                stringBuffer.append("WARN");
                break;
            case 2:
                stringBuffer.append("ERROR");
                break;
        }
        if (this.origin != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.origin);
            stringBuffer.append(" -");
        }
        stringBuffer.append(" ");
        stringBuffer.append(this.message);
        if (this.throwable != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.throwable);
        }
        return stringBuffer.toString();
    }

    public int hashCode() {
        return (this.message == null ? 0 : this.message.hashCode()) + ((this.level + 31) * 31);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        StatusBase statusBase = (StatusBase) obj;
        if (this.level != statusBase.level) {
            return false;
        }
        if (this.message == null) {
            if (statusBase.message != null) {
                return false;
            }
            return true;
        } else if (!this.message.equals(statusBase.message)) {
            return false;
        } else {
            return true;
        }
    }
}
