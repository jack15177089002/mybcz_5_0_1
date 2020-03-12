package p012ch.qos.logback.core.joran.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import org.xml.sax.Locator;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.joran.event.InPlayListener;
import p012ch.qos.logback.core.joran.event.SaxEvent;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.spi.PropertyContainer;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.spi.InterpretationContext */
public class InterpretationContext extends ContextAwareBase implements PropertyContainer {
    DefaultNestedComponentRegistry defaultNestedComponentRegistry = new DefaultNestedComponentRegistry();
    Interpreter joranInterpreter;
    final List<InPlayListener> listenerList = new ArrayList();
    Map<String, Object> objectMap;
    Stack<Object> objectStack;
    Map<String, String> propertiesMap;

    public InterpretationContext(Context context, Interpreter interpreter) {
        this.context = context;
        this.joranInterpreter = interpreter;
        this.objectStack = new Stack<>();
        this.objectMap = new HashMap(5);
        this.propertiesMap = new HashMap(5);
    }

    public DefaultNestedComponentRegistry getDefaultNestedComponentRegistry() {
        return this.defaultNestedComponentRegistry;
    }

    public Map<String, String> getCopyOfPropertyMap() {
        return new HashMap(this.propertiesMap);
    }

    /* access modifiers changed from: 0000 */
    public void setPropertiesMap(Map<String, String> map) {
        this.propertiesMap = map;
    }

    /* access modifiers changed from: 0000 */
    public String updateLocationInfo(String str) {
        Locator locator = this.joranInterpreter.getLocator();
        if (locator != null) {
            return new StringBuilder(String.valueOf(str)).append(locator.getLineNumber()).append(":").append(locator.getColumnNumber()).toString();
        }
        return str;
    }

    public Locator getLocator() {
        return this.joranInterpreter.getLocator();
    }

    public Interpreter getJoranInterpreter() {
        return this.joranInterpreter;
    }

    public Stack<Object> getObjectStack() {
        return this.objectStack;
    }

    public boolean isEmpty() {
        return this.objectStack.isEmpty();
    }

    public Object peekObject() {
        return this.objectStack.peek();
    }

    public void pushObject(Object obj) {
        this.objectStack.push(obj);
    }

    public Object popObject() {
        return this.objectStack.pop();
    }

    public Object getObject(int i) {
        return this.objectStack.get(i);
    }

    public Map<String, Object> getObjectMap() {
        return this.objectMap;
    }

    public void addSubstitutionProperty(String str, String str2) {
        if (str != null && str2 != null) {
            this.propertiesMap.put(str, str2.trim());
        }
    }

    public void addSubstitutionProperties(Properties properties) {
        if (properties != null) {
            for (String str : properties.keySet()) {
                addSubstitutionProperty(str, properties.getProperty(str));
            }
        }
    }

    public String getProperty(String str) {
        String str2 = (String) this.propertiesMap.get(str);
        return str2 != null ? str2 : this.context.getProperty(str);
    }

    public String subst(String str) {
        if (str == null) {
            return null;
        }
        return OptionHelper.substVars(str, this, this.context);
    }

    public boolean isListenerListEmpty() {
        return this.listenerList.isEmpty();
    }

    public void addInPlayListener(InPlayListener inPlayListener) {
        if (this.listenerList.contains(inPlayListener)) {
            addWarn("InPlayListener " + inPlayListener + " has been already registered");
        } else {
            this.listenerList.add(inPlayListener);
        }
    }

    public boolean removeInPlayListener(InPlayListener inPlayListener) {
        return this.listenerList.remove(inPlayListener);
    }

    /* access modifiers changed from: 0000 */
    public void fireInPlay(SaxEvent saxEvent) {
        for (InPlayListener inPlay : this.listenerList) {
            inPlay.inPlay(saxEvent);
        }
    }
}
