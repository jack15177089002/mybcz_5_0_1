package p012ch.qos.logback.core.subst;

import java.util.Iterator;
import java.util.Stack;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.spi.PropertyContainer;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.subst.NodeToStringTransformer */
public class NodeToStringTransformer {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$subst$Node$Type;
    final Node node;
    final PropertyContainer propertyContainer0;
    final PropertyContainer propertyContainer1;

    static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$subst$Node$Type() {
        int[] iArr = $SWITCH_TABLE$ch$qos$logback$core$subst$Node$Type;
        if (iArr == null) {
            iArr = new int[Type.values().length];
            try {
                iArr[Type.LITERAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Type.VARIABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $SWITCH_TABLE$ch$qos$logback$core$subst$Node$Type = iArr;
        }
        return iArr;
    }

    public NodeToStringTransformer(Node node2, PropertyContainer propertyContainer, PropertyContainer propertyContainer2) {
        this.node = node2;
        this.propertyContainer0 = propertyContainer;
        this.propertyContainer1 = propertyContainer2;
    }

    public NodeToStringTransformer(Node node2, PropertyContainer propertyContainer) {
        this(node2, propertyContainer, null);
    }

    public static String substituteVariable(String str, PropertyContainer propertyContainer, PropertyContainer propertyContainer2) {
        return new NodeToStringTransformer(tokenizeAndParseString(str), propertyContainer, propertyContainer2).transform();
    }

    private static Node tokenizeAndParseString(String str) {
        return new Parser(new Tokenizer(str).tokenize()).parse();
    }

    public String transform() {
        StringBuilder sb = new StringBuilder();
        compileNode(this.node, sb, new Stack());
        return sb.toString();
    }

    private void compileNode(Node node2, StringBuilder sb, Stack<Node> stack) {
        while (node2 != null) {
            switch ($SWITCH_TABLE$ch$qos$logback$core$subst$Node$Type()[node2.type.ordinal()]) {
                case 1:
                    handleLiteral(node2, sb);
                    break;
                case 2:
                    handleVariable(node2, sb, stack);
                    break;
            }
            node2 = node2.next;
        }
    }

    private void handleVariable(Node node2, StringBuilder sb, Stack<Node> stack) {
        if (haveVisitedNodeAlready(node2, stack)) {
            stack.push(node2);
            throw new IllegalArgumentException(constructRecursionErrorMessage(stack));
        }
        stack.push(node2);
        StringBuilder sb2 = new StringBuilder();
        compileNode((Node) node2.payload, sb2, stack);
        String sb3 = sb2.toString();
        String lookupKey = lookupKey(sb3);
        if (lookupKey != null) {
            compileNode(tokenizeAndParseString(lookupKey), sb, stack);
            stack.pop();
        } else if (node2.defaultPart == null) {
            sb.append(new StringBuilder(String.valueOf(sb3)).append(CoreConstants.UNDEFINED_PROPERTY_SUFFIX).toString());
            stack.pop();
        } else {
            Node node3 = (Node) node2.defaultPart;
            StringBuilder sb4 = new StringBuilder();
            compileNode(node3, sb4, stack);
            stack.pop();
            sb.append(sb4.toString());
        }
    }

    private String lookupKey(String str) {
        String property = this.propertyContainer0.getProperty(str);
        if (property != null) {
            return property;
        }
        if (this.propertyContainer1 != null) {
            String property2 = this.propertyContainer1.getProperty(str);
            if (property2 != null) {
                return property2;
            }
        }
        String systemProperty = OptionHelper.getSystemProperty(str, null);
        if (systemProperty != null) {
            return systemProperty;
        }
        String env = OptionHelper.getEnv(str);
        if (env == null) {
            return null;
        }
        return env;
    }

    private void handleLiteral(Node node2, StringBuilder sb) {
        sb.append((String) node2.payload);
    }

    private String variableNodeValue(Node node2) {
        return (String) ((Node) node2.payload).payload;
    }

    private String constructRecursionErrorMessage(Stack<Node> stack) {
        StringBuilder sb = new StringBuilder("Circular variable reference detected while parsing input [");
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            Node node2 = (Node) it.next();
            sb.append("${").append(variableNodeValue(node2)).append("}");
            if (stack.lastElement() != node2) {
                sb.append(" --> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean haveVisitedNodeAlready(Node node2, Stack<Node> stack) {
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            if (equalNodes(node2, (Node) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean equalNodes(Node node2, Node node3) {
        if (node2.type != null && !node2.type.equals(node3.type)) {
            return false;
        }
        if (node2.payload != null && !node2.payload.equals(node3.payload)) {
            return false;
        }
        if (node2.defaultPart == null || node2.defaultPart.equals(node3.defaultPart)) {
            return true;
        }
        return false;
    }
}
