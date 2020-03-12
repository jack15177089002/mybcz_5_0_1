package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.f.a.af */
final class NetworkRequestHandler extends RequestHandler {

    /* renamed from: a */
    private final Downloader f3621a;

    /* renamed from: b */
    private final Stats f3622b;

    public NetworkRequestHandler(Downloader vVar, Stats bbVar) {
        this.f3621a = vVar;
        this.f3622b = bbVar;
    }

    public final boolean canHandleRequest(Request auVar) {
        String scheme = auVar.f3676d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    /* JADX INFO: finally extract failed */
    public final C1580az load(Request auVar) {
        Bitmap decodeStream;
//        C1598w a = this.f3621a.mo16299a(auVar.f3676d, auVar.f3675c);
//        C1573an anVar = a.f3816c ? C1573an.DISK : C1573an.NETWORK;
//        Bitmap bitmap = a.f3815b;
//        if (bitmap != null) {
//            return new C1580az(bitmap, anVar);
//        }
//        InputStream inputStream = a.f3814a;
//        if (inputStream == null) {
//            return null;
//        }
//        if (a.f3817d == 0) {
//            C1584bj.m3556a(inputStream);
//            throw new IOException("Received response with 0 content-length header.");
//        }
//        if (anVar == C1573an.NETWORK && a.f3817d > 0) {
//            Stats bbVar = this.f3622b;
//            bbVar.f3725c.sendMessage(bbVar.f3725c.obtainMessage(4, Long.valueOf(a.f3817d)));
//        }
//        try {
//            MarkableInputStream acVar = new MarkableInputStream(inputStream);
//            long a2 = acVar.mo16285a(65536);
//            Options createBitmapOptions = createBitmapOptions(auVar);
//            boolean requiresInSampleSize = requiresInSampleSize(createBitmapOptions);
//            boolean c = C1584bj.m3566c((InputStream) acVar);
//            acVar.mo16286a(a2);
//            if (c) {
//                byte[] b = C1584bj.m3564b((InputStream) acVar);
//                if (requiresInSampleSize) {
//                    BitmapFactory.decodeByteArray(b, 0, b.length, createBitmapOptions);
//                    calculateInSampleSize(auVar.f3680h, auVar.f3681i, createBitmapOptions, auVar);
//                }
//                decodeStream = BitmapFactory.decodeByteArray(b, 0, b.length, createBitmapOptions);
//            } else {
//                if (requiresInSampleSize) {
//                    BitmapFactory.decodeStream(acVar, null, createBitmapOptions);
//                    calculateInSampleSize(auVar.f3680h, auVar.f3681i, createBitmapOptions, auVar);
//                    acVar.mo16286a(a2);
//                }
//                decodeStream = BitmapFactory.decodeStream(acVar, null, createBitmapOptions);
//                if (decodeStream == null) {
//                    throw new IOException("Failed to decode stream.");
//                }
//            }
//            C1580az azVar = new C1580az(decodeStream, anVar);
//            C1584bj.m3556a(inputStream);
//            return azVar;
//        } catch (Throwable th) {
//            C1584bj.m3556a(inputStream);
//            throw th;
//        }

        return null;
    }

    /* access modifiers changed from: 0000 */
    public final int getRetryCount() {
        return 2;
    }

    /* access modifiers changed from: 0000 */
    public final boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    /* access modifiers changed from: 0000 */
    public final boolean supportsReplay() {
        return true;
    }
}
