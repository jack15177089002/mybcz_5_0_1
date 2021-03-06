package p012ch.qos.logback.classic.spi;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;
import p012ch.qos.logback.classic.Level;

/* renamed from: ch.qos.logback.classic.spi.LoggingEventVO */
public class LoggingEventVO implements ILoggingEvent, Serializable {
    private static final int NULL_ARGUMENT_ARRAY = -1;
    private static final String NULL_ARGUMENT_ARRAY_ELEMENT = "NULL_ARGUMENT_ARRAY_ELEMENT";
    private static final long serialVersionUID = 6553722650255690312L;
    private transient Object[] argumentArray;
    private StackTraceElement[] callerDataArray;
    private transient String formattedMessage;
    private transient Level level;
    private LoggerContextVO loggerContextVO;
    private String loggerName;
    private Marker marker;
    private Map<String, String> mdcPropertyMap;
    private String message;
    private String threadName;
    private ThrowableProxyVO throwableProxy;
    private long timeStamp;

    public static LoggingEventVO build(ILoggingEvent iLoggingEvent) {
        LoggingEventVO loggingEventVO = new LoggingEventVO();
        loggingEventVO.loggerName = iLoggingEvent.getLoggerName();
        loggingEventVO.loggerContextVO = iLoggingEvent.getLoggerContextVO();
        loggingEventVO.threadName = iLoggingEvent.getThreadName();
        loggingEventVO.level = iLoggingEvent.getLevel();
        loggingEventVO.message = iLoggingEvent.getMessage();
        loggingEventVO.argumentArray = iLoggingEvent.getArgumentArray();
        loggingEventVO.marker = iLoggingEvent.getMarker();
        loggingEventVO.mdcPropertyMap = iLoggingEvent.getMDCPropertyMap();
        loggingEventVO.timeStamp = iLoggingEvent.getTimeStamp();
        loggingEventVO.throwableProxy = ThrowableProxyVO.build(iLoggingEvent.getThrowableProxy());
        if (iLoggingEvent.hasCallerData()) {
            loggingEventVO.callerDataArray = iLoggingEvent.getCallerData();
        }
        return loggingEventVO;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public LoggerContextVO getLoggerContextVO() {
        return this.loggerContextVO;
    }

    public String getLoggerName() {
        return this.loggerName;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getMessage() {
        return this.message;
    }

    public String getFormattedMessage() {
        if (this.formattedMessage != null) {
            return this.formattedMessage;
        }
        if (this.argumentArray != null) {
            this.formattedMessage = MessageFormatter.arrayFormat(this.message, this.argumentArray).getMessage();
        } else {
            this.formattedMessage = this.message;
        }
        return this.formattedMessage;
    }

    public Object[] getArgumentArray() {
        return this.argumentArray;
    }

    public IThrowableProxy getThrowableProxy() {
        return this.throwableProxy;
    }

    public StackTraceElement[] getCallerData() {
        return this.callerDataArray;
    }

    public boolean hasCallerData() {
        return this.callerDataArray != null;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public long getContextBirthTime() {
        return this.loggerContextVO.getBirthTime();
    }

    public LoggerContextVO getContextLoggerRemoteView() {
        return this.loggerContextVO;
    }

    public Map<String, String> getMDCPropertyMap() {
        return this.mdcPropertyMap;
    }

    public Map<String, String> getMdc() {
        return this.mdcPropertyMap;
    }

    public void prepareForDeferredProcessing() {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.level.levelInt);
        if (this.argumentArray != null) {
            objectOutputStream.writeInt(this.argumentArray.length);
            for (int i = 0; i < this.argumentArray.length; i++) {
                if (this.argumentArray[i] != null) {
                    objectOutputStream.writeObject(this.argumentArray[i].toString());
                } else {
                    objectOutputStream.writeObject(NULL_ARGUMENT_ARRAY_ELEMENT);
                }
            }
            return;
        }
        objectOutputStream.writeInt(-1);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.level = Level.toLevel(objectInputStream.readInt());
        int readInt = objectInputStream.readInt();
        if (readInt != -1) {
            this.argumentArray = new String[readInt];
            for (int i = 0; i < readInt; i++) {
                Object readObject = objectInputStream.readObject();
                if (!NULL_ARGUMENT_ARRAY_ELEMENT.equals(readObject)) {
                    this.argumentArray[i] = readObject;
                }
            }
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.message == null ? 0 : this.message.hashCode()) + 31) * 31;
        if (this.threadName != null) {
            i = this.threadName.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (this.timeStamp ^ (this.timeStamp >>> 32)));
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
        LoggingEventVO loggingEventVO = (LoggingEventVO) obj;
        if (this.message == null) {
            if (loggingEventVO.message != null) {
                return false;
            }
        } else if (!this.message.equals(loggingEventVO.message)) {
            return false;
        }
        if (this.loggerName == null) {
            if (loggingEventVO.loggerName != null) {
                return false;
            }
        } else if (!this.loggerName.equals(loggingEventVO.loggerName)) {
            return false;
        }
        if (this.threadName == null) {
            if (loggingEventVO.threadName != null) {
                return false;
            }
        } else if (!this.threadName.equals(loggingEventVO.threadName)) {
            return false;
        }
        if (this.timeStamp != loggingEventVO.timeStamp) {
            return false;
        }
        if (this.marker == null) {
            if (loggingEventVO.marker != null) {
                return false;
            }
        } else if (!this.marker.equals(loggingEventVO.marker)) {
            return false;
        }
        if (this.mdcPropertyMap == null) {
            if (loggingEventVO.mdcPropertyMap != null) {
                return false;
            }
            return true;
        } else if (!this.mdcPropertyMap.equals(loggingEventVO.mdcPropertyMap)) {
            return false;
        } else {
            return true;
        }
    }
}
