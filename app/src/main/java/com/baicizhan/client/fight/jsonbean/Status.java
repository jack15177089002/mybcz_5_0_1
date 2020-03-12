package com.baicizhan.client.fight.jsonbean;

import java.io.Serializable;

public class Status implements Serializable {
    private static final long serialVersionUID = 3522088620952552966L;

    /* renamed from: id */
    private C0746ID f2273id = C0746ID.NULL;

    /* renamed from: com.baicizhan.client.fight.jsonbean.Status$ID */
    public enum C0746ID {
        NULL,
        JOINED,
        MATCHED,
        GET_PROBLEM_DONE,
        READY,
        STARTED,
        SUBMITTED,
        FINISHED
    }

    public C0746ID getID() {
        return this.f2273id;
    }

    public void changeToNextStatus() {
        this.f2273id = getNextStatus();
    }

    public C0746ID getNextStatus() {
        int i;
        int i2 = 0;
        C0746ID[] values = C0746ID.values();
        int i3 = 0;
        while (true) {
            if (values == null || i3 >= values.length) {
                i = 0;
            } else if (values[i3].equals(this.f2273id)) {
                i = i3 + 1;
                break;
            } else {
                i3++;
            }
        }
        i = 0;
        if (i < values.length) {
            i2 = i;
        }
        return values[i2];
    }

    public boolean changeToStatus(C0746ID id) {
        if (id == null) {
            return false;
        }
        C0746ID nextStatus = getNextStatus();
        if (!this.f2273id.equals(id) && !nextStatus.equals(id)) {
            return false;
        }
        this.f2273id = id;
        return true;
    }
}
