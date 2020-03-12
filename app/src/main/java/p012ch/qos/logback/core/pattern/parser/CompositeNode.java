package p012ch.qos.logback.core.pattern.parser;

/* renamed from: ch.qos.logback.core.pattern.parser.CompositeNode */
public class CompositeNode extends SimpleKeywordNode {
    Node childNode;

    CompositeNode(String str) {
        super(2, str);
    }

    public Node getChildNode() {
        return this.childNode;
    }

    public void setChildNode(Node node) {
        this.childNode = node;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof CompositeNode)) {
            return false;
        }
        CompositeNode compositeNode = (CompositeNode) obj;
        if (this.childNode != null) {
            return this.childNode.equals(compositeNode.childNode);
        }
        if (compositeNode.childNode == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.childNode != null) {
            stringBuffer.append("CompositeNode(" + this.childNode + ")");
        } else {
            stringBuffer.append("CompositeNode(no child)");
        }
        stringBuffer.append(printNext());
        return stringBuffer.toString();
    }
}
