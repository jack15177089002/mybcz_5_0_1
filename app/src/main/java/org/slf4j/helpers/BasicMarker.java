package org.slf4j.helpers;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.slf4j.Marker;

public class BasicMarker implements Marker {
    private static String CLOSE = " ]";
    private static String OPEN = "[ ";
    private static String SEP = ", ";
    private static final long serialVersionUID = 1803952589649545191L;
    private final String name;
    private List<Marker> refereceList;

    BasicMarker(String str) {
        if (str == null) {
            throw new IllegalArgumentException("A marker name cannot be null");
        }
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void add(Marker marker) {
        if (marker == null) {
            throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
        } else if (!contains(marker)) {
            if (!marker.contains((Marker) this)) {
                if (this.refereceList == null) {
                    this.refereceList = new Vector();
                }
                this.refereceList.add(marker);
            }
        }
    }

    public synchronized boolean hasReferences() {
        return this.refereceList != null && this.refereceList.size() > 0;
    }

    public boolean hasChildren() {
        return hasReferences();
    }

    public synchronized Iterator<Marker> iterator() {
        Iterator<Marker> it;
        if (this.refereceList != null) {
            it = this.refereceList.iterator();
        } else {
            it = Collections.EMPTY_LIST.iterator();
        }
        return it;
    }

    public synchronized boolean remove(Marker marker) {
        boolean z;
        if (this.refereceList == null) {
            z = false;
        } else {
            int size = this.refereceList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                } else if (marker.equals((Marker) this.refereceList.get(i))) {
                    this.refereceList.remove(i);
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        return z;
    }

    public boolean contains(Marker marker) {
        if (marker == null) {
            throw new IllegalArgumentException("Other cannot be null");
        } else if (equals(marker)) {
            return true;
        } else {
            if (!hasReferences()) {
                return false;
            }
            for (int i = 0; i < this.refereceList.size(); i++) {
                if (((Marker) this.refereceList.get(i)).contains(marker)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean contains(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Other cannot be null");
        } else if (this.name.equals(str)) {
            return true;
        } else {
            if (!hasReferences()) {
                return false;
            }
            for (int i = 0; i < this.refereceList.size(); i++) {
                if (((Marker) this.refereceList.get(i)).contains(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Marker)) {
            return false;
        }
        return this.name.equals(((Marker) obj).getName());
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        if (!hasReferences()) {
            return getName();
        }
        Iterator it = iterator();
        StringBuffer stringBuffer = new StringBuffer(getName());
        stringBuffer.append(' ').append(OPEN);
        while (it.hasNext()) {
            stringBuffer.append(((Marker) it.next()).getName());
            if (it.hasNext()) {
                stringBuffer.append(SEP);
            }
        }
        stringBuffer.append(CLOSE);
        return stringBuffer.toString();
    }
}
