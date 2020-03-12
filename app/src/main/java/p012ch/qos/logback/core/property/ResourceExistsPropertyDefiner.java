package p012ch.qos.logback.core.property;

import p012ch.qos.logback.core.PropertyDefinerBase;
import p012ch.qos.logback.core.util.Loader;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.property.ResourceExistsPropertyDefiner */
public class ResourceExistsPropertyDefiner extends PropertyDefinerBase {
    String resourceStr;

    public String getResource() {
        return this.resourceStr;
    }

    public void setResource(String str) {
        this.resourceStr = str;
    }

    public String getPropertyValue() {
        if (OptionHelper.isEmpty(this.resourceStr)) {
            addError("The \"resource\" property must be set.");
            return null;
        }
        return booleanAsStr(Loader.getResourceBySelfClassLoader(this.resourceStr) != null);
    }
}
