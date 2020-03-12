package p012ch.qos.logback.core.joran.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Marker;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.joran.action.Action;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.spi.SimpleRuleStore */
public class SimpleRuleStore extends ContextAwareBase implements RuleStore {
    static String KLEENE_STAR = Marker.ANY_MARKER;
    HashMap<ElementSelector, List<Action>> rules = new HashMap<>();

    public SimpleRuleStore(Context context) {
        setContext(context);
    }

    public void addRule(ElementSelector elementSelector, Action action) {
        action.setContext(this.context);
        List list = (List) this.rules.get(elementSelector);
        if (list == null) {
            list = new ArrayList();
            this.rules.put(elementSelector, list);
        }
        list.add(action);
    }

    public void addRule(ElementSelector elementSelector, String str) {
        Action action;
        try {
            action = (Action) OptionHelper.instantiateByClassName(str, Action.class, this.context);
        } catch (Exception e) {
            addError("Could not instantiate class [" + str + "]", e);
            action = null;
        }
        if (action != null) {
            addRule(elementSelector, action);
        }
    }

    public List<Action> matchActions(ElementPath elementPath) {
        List<Action> fullPathMatch = fullPathMatch(elementPath);
        if (fullPathMatch != null) {
            return fullPathMatch;
        }
        List<Action> suffixMatch = suffixMatch(elementPath);
        if (suffixMatch != null) {
            return suffixMatch;
        }
        List<Action> prefixMatch = prefixMatch(elementPath);
        if (prefixMatch != null) {
            return prefixMatch;
        }
        List<Action> middleMatch = middleMatch(elementPath);
        if (middleMatch == null) {
            return null;
        }
        return middleMatch;
    }

    /* access modifiers changed from: 0000 */
    public List<Action> fullPathMatch(ElementPath elementPath) {
        for (ElementSelector elementSelector : this.rules.keySet()) {
            if (elementSelector.fullPathMatch(elementPath)) {
                return (List) this.rules.get(elementSelector);
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public List<Action> suffixMatch(ElementPath elementPath) {
        ElementSelector elementSelector = null;
        int i = 0;
        for (ElementSelector elementSelector2 : this.rules.keySet()) {
            if (isSuffixPattern(elementSelector2)) {
                int tailMatchLength = elementSelector2.getTailMatchLength(elementPath);
                if (tailMatchLength > i) {
                    elementSelector = elementSelector2;
                    i = tailMatchLength;
                }
            }
        }
        if (elementSelector != null) {
            return (List) this.rules.get(elementSelector);
        }
        return null;
    }

    private boolean isSuffixPattern(ElementSelector elementSelector) {
        return elementSelector.size() > 1 && elementSelector.get(0).equals(KLEENE_STAR);
    }

    /* access modifiers changed from: 0000 */
    public List<Action> prefixMatch(ElementPath elementPath) {
        ElementSelector elementSelector = null;
        int i = 0;
        for (ElementSelector elementSelector2 : this.rules.keySet()) {
            if (isKleeneStar(elementSelector2.peekLast())) {
                int prefixMatchLength = elementSelector2.getPrefixMatchLength(elementPath);
                if (prefixMatchLength == elementSelector2.size() - 1 && prefixMatchLength > i) {
                    elementSelector = elementSelector2;
                    i = prefixMatchLength;
                }
            }
        }
        if (elementSelector != null) {
            return (List) this.rules.get(elementSelector);
        }
        return null;
    }

    private boolean isKleeneStar(String str) {
        return KLEENE_STAR.equals(str);
    }

    /* access modifiers changed from: 0000 */
    public List<Action> middleMatch(ElementPath elementPath) {
        String str;
        int i;
        ElementSelector elementSelector = null;
        int i2 = 0;
        for (ElementSelector elementSelector2 : this.rules.keySet()) {
            String peekLast = elementSelector2.peekLast();
            if (elementSelector2.size() > 1) {
                str = elementSelector2.get(0);
            } else {
                str = null;
            }
            if (isKleeneStar(peekLast) && isKleeneStar(str)) {
                List copyOfPartList = elementSelector2.getCopyOfPartList();
                if (copyOfPartList.size() > 2) {
                    copyOfPartList.remove(0);
                    copyOfPartList.remove(copyOfPartList.size() - 1);
                }
                ElementSelector elementSelector3 = new ElementSelector(copyOfPartList);
                if (elementSelector3.isContainedIn(elementPath)) {
                    i = elementSelector3.size();
                } else {
                    i = 0;
                }
                if (i > i2) {
                    elementSelector = elementSelector2;
                    i2 = i;
                }
            }
        }
        if (elementSelector != null) {
            return (List) this.rules.get(elementSelector);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SimpleRuleStore ( rules = ").append(this.rules).append("   )");
        return sb.toString();
    }
}
