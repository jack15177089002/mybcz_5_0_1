package com.baicizhan.client.fight.util;

import android.content.Context;
import com.android.volley.NoConnectionError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
//import com.baicizhan.client.fight.R;
import com.jiongji.andriod.card.R;

import java.util.Locale;

public class VSUtils {
    public static String volleyErrorToTip(Context context, VolleyError volleyError) {
        if (volleyError instanceof NoConnectionError) {
            return context.getString(R.string.fight_tip_err_net_diabled);
        }
        if (volleyError instanceof TimeoutError) {
            return context.getString(R.string.fight_tip_err_timeout);
        }
        return context.getString(R.string.fight_tip_err_net_unspec);
    }

    public static String getDisplayDistance(double d) {
        if (d <= 1.0d) {
            if (d >= 0.1d) {
                return String.format(Locale.CHINA, "<%d00米", new Object[]{Integer.valueOf((int) (10.0d * d))});
            }
            return String.format(Locale.CHINA, "<%d0米", new Object[]{Integer.valueOf(Math.max((int) (100.0d * d), 1))});
        } else if (d > 10.0d) {
            return ">10公里";
        } else {
            return String.format(Locale.CHINA, "<%d公里", new Object[]{Integer.valueOf((int) Math.ceil(d))});
        }
    }

    public static String getDisplayVocabulary(int i) {
        Locale locale = Locale.CHINA;
        String str = "词汇量 %s";
        Object[] objArr = new Object[1];
        objArr[0] = i == 0 ? "未知" : Integer.toString(i);
        return String.format(locale, str, objArr);
    }
}
