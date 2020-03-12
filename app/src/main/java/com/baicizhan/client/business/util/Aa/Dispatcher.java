package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.f.a.q */
final class Dispatcher {

    /* renamed from: a */
    final C1596t f3794a = new C1596t();

    /* renamed from: b */
    final Context f3795b;

    /* renamed from: c */
    final ExecutorService f3796c;

    /* renamed from: d */
    final Downloader f3797d;

    /* renamed from: e */
    final Map<String, BitmapHunter> f3798e;

    /* renamed from: f */
    final Map<Object, Action> f3799f;

    /* renamed from: g */
    final Map<Object, Action> f3800g;

    /* renamed from: h */
    final Set<Object> f3801h;

    /* renamed from: i */
    final Handler f3802i;

    /* renamed from: j */
    final Handler f3803j;

    /* renamed from: k */
    final Cache f3804k;

    /* renamed from: l */
    final Stats f3805l;

    /* renamed from: m */
    final List<BitmapHunter> f3806m;

    /* renamed from: n */
    final C1597u f3807n;

    /* renamed from: o */
    final boolean f3808o;

    /* renamed from: p */
    boolean f3809p;

    Dispatcher(Context context, ExecutorService executorService, Handler handler, Downloader vVar, Cache kVar, Stats bbVar) {
        this.f3794a.start();
        this.f3795b = context;
        this.f3796c = executorService;
        this.f3798e = new LinkedHashMap();
        this.f3799f = new WeakHashMap();
        this.f3800g = new WeakHashMap();
        this.f3801h = new HashSet();
        this.f3802i = new C1594r(this.f3794a.getLooper(), this);
        this.f3797d = vVar;
        this.f3803j = handler;
        this.f3804k = kVar;
        this.f3805l = bbVar;
        this.f3806m = new ArrayList(4);
        this.f3809p = C1584bj.m3567d(this.f3795b);
        this.f3808o = C1584bj.m3563b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f3807n = new C1597u(this);
        C1597u uVar = this.f3807n;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        if (uVar.f3813a.f3808o) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        uVar.f3813a.f3795b.registerReceiver(uVar, intentFilter);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16357a(BitmapHunter dVar) {
        this.f3802i.sendMessage(this.f3802i.obtainMessage(6, dVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16356a(Action aVar, boolean z) {
        if (this.f3801h.contains(aVar.f3597i)) {
            this.f3800g.put(aVar.mo16279c(), aVar);
//            if (aVar.f3589a.f3636m) {
//                C1584bj.m3558a("Dispatcher", "paused", aVar.f3590b.mo16321a(), "because tag '" + aVar.f3597i + "' is paused");
//                return;
//            }
            return;
        }
        BitmapHunter dVar = (BitmapHunter) this.f3798e.get(aVar.f3596h);
//        if (dVar != null) {
//            boolean z2 = dVar.f3765b.f3636m;
//            Request auVar = aVar.f3590b;
//            if (dVar.f3773j == null) {
//                dVar.f3773j = aVar;
//                if (!z2) {
//                    return;
//                }
//                if (dVar.f3774k == null || dVar.f3774k.isEmpty()) {
//                    C1584bj.m3558a("Hunter", "joined", auVar.mo16321a(), "to empty hunter");
//                } else {
//                    C1584bj.m3558a("Hunter", "joined", auVar.mo16321a(), C1584bj.m3554a(dVar, "to "));
//                }
//            } else {
//                if (dVar.f3774k == null) {
//                    dVar.f3774k = new ArrayList(3);
//                }
//                dVar.f3774k.add(aVar);
//                if (z2) {
//                    C1584bj.m3558a("Hunter", "joined", auVar.mo16321a(), C1584bj.m3554a(dVar, "to "));
//                }
//                int i = aVar.f3590b.f3689q;
//                if (i - 1 > dVar.f3781r - 1) {
//                    dVar.f3781r = i;
//                }
//            }
//        } else if (!this.f3796c.isShutdown()) {
//            BitmapHunter a = BitmapHunter.m3570a(aVar.f3589a, this, this.f3804k, this.f3805l, aVar);
//            a.f3776m = this.f3796c.submit(a);
//            this.f3798e.put(aVar.f3596h, a);
//            if (z) {
//                this.f3799f.remove(aVar.mo16279c());
//            }
//            if (aVar.f3589a.f3636m) {
//                C1584bj.m3557a("Dispatcher", "enqueued", aVar.f3590b.mo16321a());
//            }
//        } else if (aVar.f3589a.f3636m) {
//            C1584bj.m3558a("Dispatcher", "ignored", aVar.f3590b.mo16321a(), "because shut down");
//        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16359a(Object obj) {
        if (this.f3801h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator it = this.f3800g.values().iterator();
            while (it.hasNext()) {
                Action aVar = (Action) it.next();
                if (aVar.f3597i.equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                    it.remove();
                }
            }
            if (arrayList != null) {
                this.f3803j.sendMessage(this.f3803j.obtainMessage(13, arrayList));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo16360b(BitmapHunter dVar) {
        NetworkInfo networkInfo;
        boolean z;
        boolean shouldRetry;
        boolean z2 = true;
        if (!dVar.mo16346b()) {
            if (this.f3796c.isShutdown()) {
                mo16358a(dVar, false);
                return;
            }
            if (this.f3808o) {
                networkInfo = ((ConnectivityManager) C1584bj.m3550a(this.f3795b, "connectivity")).getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            boolean z3 = networkInfo != null && networkInfo.isConnected();
            boolean z4 = this.f3809p;
            if (dVar.f3780q > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                shouldRetry = false;
            } else {
                dVar.f3780q--;
                shouldRetry = dVar.f3772i.shouldRetry(z4, networkInfo);
            }
            boolean supportsReplay = dVar.f3772i.supportsReplay();
            if (!shouldRetry) {
                if (!this.f3808o || !supportsReplay) {
                    z2 = false;
                }
                mo16358a(dVar, z2);
                if (z2) {
                    m3588d(dVar);
                }
            } else if (!this.f3808o || z3) {
//                if (dVar.f3765b.f3636m) {
//                    C1584bj.m3557a("Dispatcher", "retrying", C1584bj.m3553a(dVar));
//                }
                dVar.f3776m = this.f3796c.submit(dVar);
            } else {
                mo16358a(dVar, supportsReplay);
                if (supportsReplay) {
                    m3588d(dVar);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16358a(BitmapHunter dVar, boolean z) {
//        if (dVar.f3765b.f3636m) {
//            C1584bj.m3558a("Dispatcher", "batched", C1584bj.m3553a(dVar), "for error" + (z ? " (will replay)" : ""));
//        }
        this.f3798e.remove(dVar.f3769f);
        mo16361c(dVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16355a(NetworkInfo networkInfo) {
        if (this.f3796c instanceof PicassoExecutorService) {
            PicassoExecutorService asVar = (PicassoExecutorService) this.f3796c;
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                switch (networkInfo.getType()) {
                    case 0:
                        switch (networkInfo.getSubtype()) {
                            case 1:
                            case 2:
                                asVar.mo16318a(1);
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 12:
                                asVar.mo16318a(2);
                                break;
                            case 13:
                            case 14:
                            case 15:
                                asVar.mo16318a(3);
                                break;
                            default:
                                asVar.mo16318a(3);
                                break;
                        }
                    case 1:
                    case 6:
                    case 9:
                        asVar.mo16318a(4);
                        break;
                    default:
                        asVar.mo16318a(3);
                        break;
                }
            } else {
                asVar.mo16318a(3);
            }
        }
        if (networkInfo != null && networkInfo.isConnected() && !this.f3799f.isEmpty()) {
            Iterator it = this.f3799f.values().iterator();
            while (it.hasNext()) {
                Action aVar = (Action) it.next();
                it.remove();
//                if (aVar.f3589a.f3636m) {
//                    C1584bj.m3557a("Dispatcher", "replaying", aVar.f3590b.mo16321a());
//                }
                mo16356a(aVar, false);
            }
        }
    }

    /* renamed from: d */
    private void m3588d(BitmapHunter dVar) {
        Action aVar = dVar.f3773j;
        if (aVar != null) {
            m3586a(aVar);
        }
        List<Action> list = dVar.f3774k;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                m3586a((Action) list.get(i));
            }
        }
    }

    /* renamed from: a */
    private void m3586a(Action aVar) {
        Object c = aVar.mo16279c();
        if (c != null) {
            aVar.f3598j = true;
            this.f3799f.put(c, aVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo16361c(BitmapHunter dVar) {
        if (!dVar.mo16346b()) {
            this.f3806m.add(dVar);
            if (!this.f3802i.hasMessages(7)) {
                this.f3802i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    /* renamed from: a */
    static void m3587a(List<BitmapHunter> list) {
//        if (!list.isEmpty() && ((BitmapHunter) list.get(0)).f3765b.f3636m) {
//            StringBuilder sb = new StringBuilder();
//            for (BitmapHunter dVar : list) {
//                if (sb.length() > 0) {
//                    sb.append(", ");
//                }
//                sb.append(C1584bj.m3553a(dVar));
//            }
//            C1584bj.m3557a("Dispatcher", "delivered", sb.toString());
//        }
    }
}
