package p012ch.qos.logback.classic.spi;

import java.io.Serializable;

/* renamed from: ch.qos.logback.classic.spi.ClassPackagingData */
public class ClassPackagingData implements Serializable {
    private static final long serialVersionUID = -804643281218337001L;
    final String codeLocation;
    private final boolean exact;
    final String version;

    public ClassPackagingData(String str, String str2) {
        this.codeLocation = str;
        this.version = str2;
        this.exact = true;
    }

    public ClassPackagingData(String str, String str2, boolean z) {
        this.codeLocation = str;
        this.version = str2;
        this.exact = z;
    }

    public String getCodeLocation() {
        return this.codeLocation;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isExact() {
        return this.exact;
    }

    public int hashCode() {
        return (this.codeLocation == null ? 0 : this.codeLocation.hashCode()) + 31;
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
        ClassPackagingData classPackagingData = (ClassPackagingData) obj;
        if (this.codeLocation == null) {
            if (classPackagingData.codeLocation != null) {
                return false;
            }
        } else if (!this.codeLocation.equals(classPackagingData.codeLocation)) {
            return false;
        }
        if (this.exact != classPackagingData.exact) {
            return false;
        }
        if (this.version == null) {
            if (classPackagingData.version != null) {
                return false;
            }
            return true;
        } else if (!this.version.equals(classPackagingData.version)) {
            return false;
        } else {
            return true;
        }
    }
}
