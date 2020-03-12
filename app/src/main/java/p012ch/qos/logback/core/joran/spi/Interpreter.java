package p012ch.qos.logback.core.joran.spi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.joran.action.ImplicitAction;
import p012ch.qos.logback.core.joran.event.BodyEvent;
import p012ch.qos.logback.core.joran.event.EndEvent;
import p012ch.qos.logback.core.joran.event.StartEvent;

/* renamed from: ch.qos.logback.core.joran.spi.Interpreter */
public class Interpreter {
    private static List<Action> EMPTY_LIST = new Vector(0);
    Stack<List<Action>> actionListStack;
    private final CAI_WithLocatorSupport cai;
    private ElementPath elementPath;
    EventPlayer eventPlayer;
    private final ArrayList<ImplicitAction> implicitActions;
    private final InterpretationContext interpretationContext;
    Locator locator;
    private final RuleStore ruleStore;
    ElementPath skip = null;

    public Interpreter(Context context, RuleStore ruleStore2, ElementPath elementPath2) {
        this.cai = new CAI_WithLocatorSupport(context, this);
        this.ruleStore = ruleStore2;
        this.interpretationContext = new InterpretationContext(context, this);
        this.implicitActions = new ArrayList<>(3);
        this.elementPath = elementPath2;
        this.actionListStack = new Stack<>();
        this.eventPlayer = new EventPlayer(this);
    }

    public EventPlayer getEventPlayer() {
        return this.eventPlayer;
    }

    public void setInterpretationContextPropertiesMap(Map<String, String> map) {
        this.interpretationContext.setPropertiesMap(map);
    }

    public InterpretationContext getExecutionContext() {
        return getInterpretationContext();
    }

    public InterpretationContext getInterpretationContext() {
        return this.interpretationContext;
    }

    public void startDocument() {
    }

    public void startElement(StartEvent startEvent) {
        setDocumentLocator(startEvent.getLocator());
        startElement(startEvent.namespaceURI, startEvent.localName, startEvent.qName, startEvent.attributes);
    }

    private void startElement(String str, String str2, String str3, Attributes attributes) {
        String tagName = getTagName(str2, str3);
        this.elementPath.push(tagName);
        if (this.skip != null) {
            pushEmptyActionList();
            return;
        }
        List applicableActionList = getApplicableActionList(this.elementPath, attributes);
        if (applicableActionList != null) {
            this.actionListStack.add(applicableActionList);
            callBeginAction(applicableActionList, tagName, attributes);
            return;
        }
        pushEmptyActionList();
        this.cai.addError("no applicable action for [" + tagName + "], current ElementPath  is [" + this.elementPath + "]");
    }

    private void pushEmptyActionList() {
        this.actionListStack.add(EMPTY_LIST);
    }

    public void characters(BodyEvent bodyEvent) {
        setDocumentLocator(bodyEvent.locator);
        String text = bodyEvent.getText();
        List list = (List) this.actionListStack.peek();
        if (text != null) {
            String trim = text.trim();
            if (trim.length() > 0) {
                callBodyAction(list, trim);
            }
        }
    }

    public void endElement(EndEvent endEvent) {
        setDocumentLocator(endEvent.locator);
        endElement(endEvent.namespaceURI, endEvent.localName, endEvent.qName);
    }

    private void endElement(String str, String str2, String str3) {
        List<Action> list = (List) this.actionListStack.pop();
        if (this.skip != null) {
            if (this.skip.equals(this.elementPath)) {
                this.skip = null;
            }
        } else if (list != EMPTY_LIST) {
            callEndAction(list, getTagName(str2, str3));
        }
        this.elementPath.pop();
    }

    public Locator getLocator() {
        return this.locator;
    }

    public void setDocumentLocator(Locator locator2) {
        this.locator = locator2;
    }

    /* access modifiers changed from: 0000 */
    public String getTagName(String str, String str2) {
        if (str == null || str.length() <= 0) {
            return str2;
        }
        return str;
    }

    public void addImplicitAction(ImplicitAction implicitAction) {
        this.implicitActions.add(implicitAction);
    }

    /* access modifiers changed from: 0000 */
    public List<Action> lookupImplicitAction(ElementPath elementPath2, Attributes attributes, InterpretationContext interpretationContext2) {
        int size = this.implicitActions.size();
        for (int i = 0; i < size; i++) {
            ImplicitAction implicitAction = (ImplicitAction) this.implicitActions.get(i);
            if (implicitAction.isApplicable(elementPath2, attributes, interpretationContext2)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(implicitAction);
                return arrayList;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public List<Action> getApplicableActionList(ElementPath elementPath2, Attributes attributes) {
        List<Action> matchActions = this.ruleStore.matchActions(elementPath2);
        if (matchActions == null) {
            return lookupImplicitAction(elementPath2, attributes, this.interpretationContext);
        }
        return matchActions;
    }

    /* access modifiers changed from: 0000 */
    public void callBeginAction(List<Action> list, String str, Attributes attributes) {
        if (list != null) {
            for (Action begin : list) {
                try {
                    begin.begin(this.interpretationContext, str, attributes);
                } catch (ActionException e) {
                    this.skip = this.elementPath.duplicate();
                    this.cai.addError("ActionException in Action for tag [" + str + "]", e);
                } catch (RuntimeException e2) {
                    this.skip = this.elementPath.duplicate();
                    this.cai.addError("RuntimeException in Action for tag [" + str + "]", e2);
                }
            }
        }
    }

    private void callBodyAction(List<Action> list, String str) {
        if (list != null) {
            for (Action action : list) {
                try {
                    action.body(this.interpretationContext, str);
                } catch (ActionException e) {
                    this.cai.addError("Exception in end() methd for action [" + action + "]", e);
                }
            }
        }
    }

    private void callEndAction(List<Action> list, String str) {
        if (list != null) {
            for (Action end : list) {
                try {
                    end.end(this.interpretationContext, str);
                } catch (ActionException e) {
                    this.cai.addError("ActionException in Action for tag [" + str + "]", e);
                } catch (RuntimeException e2) {
                    this.cai.addError("RuntimeException in Action for tag [" + str + "]", e2);
                }
            }
        }
    }

    public RuleStore getRuleStore() {
        return this.ruleStore;
    }
}
