package p012ch.qos.logback.core.status;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.core.status.StatusUtil */
public class StatusUtil {

    /* renamed from: sm */
    StatusManager f1671sm;

    public StatusUtil(StatusManager statusManager) {
        this.f1671sm = statusManager;
    }

    public StatusUtil(Context context) {
        this.f1671sm = context.getStatusManager();
    }

    public static boolean contextHasStatusListener(Context context) {
        StatusManager statusManager = context.getStatusManager();
        if (statusManager == null) {
            return false;
        }
        List copyOfStatusListenerList = statusManager.getCopyOfStatusListenerList();
        if (copyOfStatusListenerList == null || copyOfStatusListenerList.size() == 0) {
            return false;
        }
        return true;
    }

    public static List<Status> filterStatusListByTimeThreshold(List<Status> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (Status status : list) {
            if (status.getDate().longValue() >= j) {
                arrayList.add(status);
            }
        }
        return arrayList;
    }

    public void addStatus(Status status) {
        if (this.f1671sm != null) {
            this.f1671sm.add(status);
        }
    }

    public void addInfo(Object obj, String str) {
        addStatus(new InfoStatus(str, obj));
    }

    public void addWarn(Object obj, String str) {
        addStatus(new WarnStatus(str, obj));
    }

    public void addError(Object obj, String str, Throwable th) {
        addStatus(new ErrorStatus(str, obj, th));
    }

    public boolean hasXMLParsingErrors(long j) {
        return containsMatch(j, 2, CoreConstants.XML_PARSING);
    }

    public boolean noXMLParsingErrorsOccurred(long j) {
        return !hasXMLParsingErrors(j);
    }

    public int getHighestLevel(long j) {
        int i = 0;
        for (Status status : filterStatusListByTimeThreshold(this.f1671sm.getCopyOfStatusList(), j)) {
            if (status.getLevel() > i) {
                i = status.getLevel();
            }
        }
        return i;
    }

    public boolean isErrorFree(long j) {
        return 2 > getHighestLevel(j);
    }

    public boolean containsMatch(long j, int i, String str) {
        List<Status> filterStatusListByTimeThreshold = filterStatusListByTimeThreshold(this.f1671sm.getCopyOfStatusList(), j);
        Pattern compile = Pattern.compile(str);
        for (Status status : filterStatusListByTimeThreshold) {
            if (i == status.getLevel() && compile.matcher(status.getMessage()).lookingAt()) {
                return true;
            }
        }
        return false;
    }

    public boolean containsMatch(int i, String str) {
        return containsMatch(0, i, str);
    }

    public boolean containsMatch(String str) {
        Pattern compile = Pattern.compile(str);
        for (Status message : this.f1671sm.getCopyOfStatusList()) {
            if (compile.matcher(message.getMessage()).lookingAt()) {
                return true;
            }
        }
        return false;
    }

    public int matchCount(String str) {
        Pattern compile = Pattern.compile(str);
        int i = 0;
        for (Status message : this.f1671sm.getCopyOfStatusList()) {
            if (compile.matcher(message.getMessage()).lookingAt()) {
                i++;
            }
        }
        return i;
    }

    public boolean containsException(Class<?> cls) {
        for (Status throwable : this.f1671sm.getCopyOfStatusList()) {
            Throwable throwable2 = throwable.getThrowable();
            if (throwable2 != null && throwable2.getClass().getName().equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    public long timeOfLastReset() {
        List copyOfStatusList = this.f1671sm.getCopyOfStatusList();
        if (copyOfStatusList == null) {
            return -1;
        }
        for (int size = copyOfStatusList.size() - 1; size >= 0; size--) {
            Status status = (Status) copyOfStatusList.get(size);
            if (CoreConstants.RESET_MSG_PREFIX.equals(status.getMessage())) {
                return status.getDate().longValue();
            }
        }
        return -1;
    }
}
