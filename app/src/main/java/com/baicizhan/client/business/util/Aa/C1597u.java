package com.baicizhan.client.business.util.Aa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

/* renamed from: com.f.a.u */
/* compiled from: Dispatcher */
final class C1597u extends BroadcastReceiver {

    /* renamed from: a */
    final Dispatcher f3813a;

    C1597u(Dispatcher qVar) {
        this.f3813a = qVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    Dispatcher qVar = this.f3813a;
                    qVar.f3802i.sendMessage(qVar.f3802i.obtainMessage(10, intent.getBooleanExtra("state", false) ? 1 : 0, 0));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) C1584bj.m3550a(context, "connectivity");
                Dispatcher qVar2 = this.f3813a;
//                qVar2.f3802i.sendMessage(qVar2.f3802i.obtainMessage(9, connectivityManager.getActiveNetworkInfo()));
            }
        }
    }
}
