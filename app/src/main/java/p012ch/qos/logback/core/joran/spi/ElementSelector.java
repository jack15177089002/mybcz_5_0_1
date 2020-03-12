package p012ch.qos.logback.core.joran.spi;

import java.util.List;

/* renamed from: ch.qos.logback.core.joran.spi.ElementSelector */
public class ElementSelector extends ElementPath {
    public ElementSelector() {
    }

    public ElementSelector(List<String> list) {
        super(list);
    }

    public ElementSelector(String str) {
        super(str);
    }

    public boolean fullPathMatch(ElementPath elementPath) {
        if (elementPath.size() != size()) {
            return false;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (!equalityCheck(get(i), elementPath.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int getTailMatchLength(ElementPath elementPath) {
        if (elementPath == null) {
            return 0;
        }
        int size = this.partList.size();
        int size2 = elementPath.partList.size();
        if (size == 0 || size2 == 0) {
            return 0;
        }
        int i = size <= size2 ? size : size2;
        int i2 = 1;
        int i3 = 0;
        while (i2 <= i && equalityCheck((String) this.partList.get(size - i2), (String) elementPath.partList.get(size2 - i2))) {
            i3++;
            i2++;
        }
        return i3;
    }

    public boolean isContainedIn(ElementPath elementPath) {
        if (elementPath == null) {
            return false;
        }
        return elementPath.toStableString().contains(toStableString());
    }

    public int getPrefixMatchLength(ElementPath elementPath) {
        int i = 0;
        if (elementPath == null) {
            return 0;
        }
        int size = this.partList.size();
        int size2 = elementPath.partList.size();
        if (size == 0 || size2 == 0) {
            return 0;
        }
        int i2 = size <= size2 ? size : size2;
        int i3 = 0;
        while (i3 < i2 && equalityCheck((String) this.partList.get(i3), (String) elementPath.partList.get(i3))) {
            i3++;
            i++;
        }
        return i;
    }

    private boolean equalityCheck(String str, String str2) {
        return str.equalsIgnoreCase(str2);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ElementSelector)) {
            return false;
        }
        ElementSelector elementSelector = (ElementSelector) obj;
        if (elementSelector.size() != size()) {
            return false;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (!equalityCheck(get(i), elementSelector.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < size(); i2++) {
            i ^= get(i2).toLowerCase().hashCode();
        }
        return i;
    }
}
