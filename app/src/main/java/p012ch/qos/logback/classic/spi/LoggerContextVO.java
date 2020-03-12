package p012ch.qos.logback.classic.spi;

import java.io.Serializable;
import java.util.Map;
import p012ch.qos.logback.classic.LoggerContext;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.classic.spi.LoggerContextVO */
public class LoggerContextVO implements Serializable {
    private static final long serialVersionUID = 5488023392483144387L;
    final long birthTime;
    final String name;
    final Map<String, String> propertyMap;

    public LoggerContextVO(LoggerContext loggerContext) {
        this.name = loggerContext.getName();
        this.propertyMap = loggerContext.getCopyOfPropertyMap();
        this.birthTime = loggerContext.getBirthTime();
    }

    public LoggerContextVO(String str, Map<String, String> map, long j) {
        this.name = str;
        this.propertyMap = map;
        this.birthTime = j;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, String> getPropertyMap() {
        return this.propertyMap;
    }

    public long getBirthTime() {
        return this.birthTime;
    }

    public String toString() {
        return "LoggerContextVO{name='" + this.name + CoreConstants.SINGLE_QUOTE_CHAR + ", propertyMap=" + this.propertyMap + ", birthTime=" + this.birthTime + CoreConstants.CURLY_RIGHT;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoggerContextVO)) {
            return false;
        }
        LoggerContextVO loggerContextVO = (LoggerContextVO) obj;
        if (this.birthTime != loggerContextVO.birthTime) {
            return false;
        }
        if (this.name == null ? loggerContextVO.name != null : !this.name.equals(loggerContextVO.name)) {
            return false;
        }
        if (this.propertyMap != null) {
            if (this.propertyMap.equals(loggerContextVO.propertyMap)) {
                return true;
            }
        } else if (loggerContextVO.propertyMap == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (this.name != null) {
            i = this.name.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * 31;
        if (this.propertyMap != null) {
            i2 = this.propertyMap.hashCode();
        }
        return ((i3 + i2) * 31) + ((int) (this.birthTime ^ (this.birthTime >>> 32)));
    }
}
