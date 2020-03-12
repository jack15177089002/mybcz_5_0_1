package com.baicizhan.client.business.dataset.thrifadapt;

import com.baicizhan.client.framework.log.C0789L;
import java.util.ArrayList;
import java.util.List;

public class PrimaryAdapter {
    private PrimaryAdapter() {
    }

    public static List<Integer> toList(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        try {
            for (String valueOf : list) {
                arrayList.add(Integer.valueOf(Integer.valueOf(valueOf).intValue()));
            }
            return arrayList;
        } catch (NumberFormatException e) {
            C0789L.log.error("invalid convert. ", (Throwable) e);
            return null;
        }
    }
}
