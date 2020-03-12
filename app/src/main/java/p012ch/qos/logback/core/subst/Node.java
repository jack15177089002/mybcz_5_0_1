package p012ch.qos.logback.core.subst;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.core.subst.Node */
public class Node {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$subst$Node$Type;
    Object defaultPart;
    Node next;
    Object payload;
    Type type;

    /* renamed from: ch.qos.logback.core.subst.Node$Type */
    enum Type {
        LITERAL,
        VARIABLE
    }

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

    public Node(Type type2, Object obj) {
        this.type = type2;
        this.payload = obj;
    }

    public Node(Type type2, Object obj, Object obj2) {
        this.type = type2;
        this.payload = obj;
        this.defaultPart = obj2;
    }

    /* access modifiers changed from: 0000 */
    public void append(Node node) {
        if (node != null) {
            while (this.next != null) {
                this = this.next;
            }
            this.next = node;
        }
    }

    public String toString() {
        switch ($SWITCH_TABLE$ch$qos$logback$core$subst$Node$Type()[this.type.ordinal()]) {
            case 1:
                return "Node{type=" + this.type + ", payload='" + this.payload + "'}";
            case 2:
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                if (this.defaultPart != null) {
                    recursive((Node) this.defaultPart, sb2);
                }
                recursive((Node) this.payload, sb);
                String str = "Node{type=" + this.type + ", payload='" + sb.toString() + "'";
                if (this.defaultPart != null) {
                    str = new StringBuilder(String.valueOf(str)).append(", defaultPart=").append(sb2.toString()).toString();
                }
                return new StringBuilder(String.valueOf(str)).append(CoreConstants.CURLY_RIGHT).toString();
            default:
                return null;
        }
    }

    public void dump() {
        System.out.print(toString());
        System.out.print(" -> ");
        if (this.next != null) {
            this.next.dump();
        } else {
            System.out.print(" null");
        }
    }

    /* access modifiers changed from: 0000 */
    public void recursive(Node node, StringBuilder sb) {
        while (node != null) {
            sb.append(node.toString()).append(" --> ");
            node = node.next;
        }
        sb.append("null ");
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node node = (Node) obj;
        if (this.type != node.type) {
            return false;
        }
        if (this.payload == null ? node.payload != null : !this.payload.equals(node.payload)) {
            return false;
        }
        if (this.defaultPart == null ? node.defaultPart != null : !this.defaultPart.equals(node.defaultPart)) {
            return false;
        }
        if (this.next != null) {
            if (this.next.equals(node.next)) {
                return true;
            }
        } else if (node.next == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (this.type != null) {
            i = this.type.hashCode();
        } else {
            i = 0;
        }
        int i5 = i * 31;
        if (this.payload != null) {
            i2 = this.payload.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i2 + i5) * 31;
        if (this.defaultPart != null) {
            i3 = this.defaultPart.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i3 + i6) * 31;
        if (this.next != null) {
            i4 = this.next.hashCode();
        }
        return i7 + i4;
    }
}
