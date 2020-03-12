package p012ch.qos.logback.core.pattern.parser;

import java.util.List;

/* renamed from: ch.qos.logback.core.pattern.parser.SimpleKeywordNode */
public class SimpleKeywordNode extends FormattingNode {
    List<String> optionList;

    SimpleKeywordNode(Object obj) {
        super(1, obj);
    }

    protected SimpleKeywordNode(int i, Object obj) {
        super(i, obj);
    }

    public List<String> getOptions() {
        return this.optionList;
    }

    public void setOptions(List<String> list) {
        this.optionList = list;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof SimpleKeywordNode)) {
            return false;
        }
        SimpleKeywordNode simpleKeywordNode = (SimpleKeywordNode) obj;
        if (this.optionList != null) {
            return this.optionList.equals(simpleKeywordNode.optionList);
        }
        if (simpleKeywordNode.optionList == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.optionList == null) {
            stringBuffer.append("KeyWord(" + this.value + "," + this.formatInfo + ")");
        } else {
            stringBuffer.append("KeyWord(" + this.value + ", " + this.formatInfo + "," + this.optionList + ")");
        }
        stringBuffer.append(printNext());
        return stringBuffer.toString();
    }
}
