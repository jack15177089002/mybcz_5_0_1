package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.f.a.ah */
public class Picasso {

    /* renamed from: a */
    static final Handler f3624a = new C1568ai(Looper.getMainLooper());

    /* renamed from: b */
    static Picasso f3625b = null;

    /* renamed from: c */
    final C1575ap f3626c;

    /* renamed from: d */
    final List<RequestHandler> f3627d;

    /* renamed from: e */
    final Context f3628e;

    /* renamed from: f */
    final Dispatcher f3629f;

    /* renamed from: g */
    final Cache f3630g;

    /* renamed from: h */
    final Stats f3631h;

    /* renamed from: i */
    final Map<Object, Action> f3632i;

    /* renamed from: j */
    final Map<ImageView, DeferredRequestCreator> f3633j;

    /* renamed from: k */
    final ReferenceQueue<Object> f3634k;

    /* renamed from: l */
    boolean f3635l;

    /* renamed from: m */
    volatile boolean f3636m;

    /* renamed from: n */
    boolean f3637n;

    /* renamed from: o */
    private final C1572am f3638o;

    /* renamed from: p */
    private final C1570ak f3639p;

    Picasso(Context context, Dispatcher qVar, Cache kVar, C1572am amVar, C1575ap apVar, List<RequestHandler> list, Stats bbVar, boolean z, boolean z2) {
        this.f3628e = context;
        this.f3629f = qVar;
        this.f3630g = kVar;
        this.f3638o = amVar;
        this.f3626c = apVar;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new ResourceRequestHandler(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new ContactsPhotoRequestHandler(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new ContentStreamRequestHandler(context));
        arrayList.add(new AssetRequestHandler(context));
        arrayList.add(new FileRequestHandler(context));
        arrayList.add(new NetworkRequestHandler(qVar.f3797d, bbVar));
        this.f3627d = Collections.unmodifiableList(arrayList);
        this.f3631h = bbVar;
        this.f3632i = new WeakHashMap();
        this.f3633j = new WeakHashMap();
        this.f3635l = z;
        this.f3636m = z2;
        this.f3634k = new ReferenceQueue<>();
        this.f3639p = new C1570ak(this.f3634k, f3624a);
        this.f3639p.start();
    }

    /* renamed from: a */
    public final RequestCreator mo16301a(Uri uri) {
        return new RequestCreator(this, uri, 0);
    }

    /* renamed from: a */
    public final RequestCreator mo16303a(String str) {
        if (str == null) {
            return new RequestCreator(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return mo16301a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    /* renamed from: a */
    public final RequestCreator mo16302a(File file) {
        if (file == null) {
            return new RequestCreator(this, null, 0);
        }
        return mo16301a(Uri.fromFile(file));
    }

    /* renamed from: a */
    public final RequestCreator mo16300a(int i) {
        if (i != 0) {
            return new RequestCreator(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16305a(Action aVar) {
        Object c = aVar.mo16279c();
        if (!(c == null || this.f3632i.get(c) == aVar)) {
            mo16306a(c);
            this.f3632i.put(c, aVar);
        }
        mo16308b(aVar);
    }

    /* renamed from: b */
    public final void mo16308b(Action aVar) {
        Dispatcher qVar = this.f3629f;
        qVar.f3802i.sendMessage(qVar.f3802i.obtainMessage(1, aVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final Bitmap mo16307b(String str) {
        Bitmap a = this.f3630g.mo16281a(str);
        if (a != null) {
            this.f3631h.mo16337a();
        } else {
            this.f3631h.f3725c.sendEmptyMessage(1);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16304a(Bitmap bitmap, C1573an anVar, Action aVar) {
        if (!aVar.f3599k) {
            if (!aVar.f3598j) {
                this.f3632i.remove(aVar.mo16279c());
            }
            if (bitmap == null) {
                aVar.mo16276a();
                if (this.f3636m) {
//                    C1584bj.m3557a("Main", "errored", aVar.f3590b.mo16321a());
                }
            } else if (anVar == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                aVar.mo16277a(bitmap, anVar);
                if (this.f3636m) {
//                    C1584bj.m3558a("Main", "completed", aVar.f3590b.mo16321a(), "from " + anVar);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo16306a(Object obj) {
        C1584bj.m3555a();
        Action aVar = (Action) this.f3632i.remove(obj);
        if (aVar != null) {
            aVar.mo16278b();
            Dispatcher qVar = this.f3629f;
            qVar.f3802i.sendMessage(qVar.f3802i.obtainMessage(2, aVar));
        }
        if (obj instanceof ImageView) {
            DeferredRequestCreator pVar = (DeferredRequestCreator) this.f3633j.remove((ImageView) obj);
            if (pVar != null) {
                pVar.f3793c = null;
                ImageView imageView = (ImageView) pVar.f3792b.get();
                if (imageView != null) {
                    ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(pVar);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static Picasso m3504a(Context context) {
        if (f3625b == null) {
            synchronized (Picasso.class) {
                if (f3625b == null) {
                    f3625b = new C1569aj(context).mo16310a();
                }
            }
        }
        return f3625b;
    }

    /* renamed from: a */
    public static void m3505a(Picasso ahVar) {
        synchronized (Picasso.class) {
            if (f3625b != null) {
                throw new IllegalStateException("Singleton instance already exists.");
            }
            f3625b = ahVar;
        }
    }
}
