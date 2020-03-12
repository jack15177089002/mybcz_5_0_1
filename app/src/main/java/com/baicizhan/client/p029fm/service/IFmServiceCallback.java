package com.baicizhan.client.p029fm.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baicizhan.client.fm.service.IFmServiceCallback */
public interface IFmServiceCallback extends IInterface {

    /* renamed from: com.baicizhan.client.fm.service.IFmServiceCallback$Stub */
    public abstract class Stub extends Binder implements IFmServiceCallback {
        private static final String DESCRIPTOR = "com.baicizhan.client.fm.service.IFmServiceCallback";
        static final int TRANSACTION_onFmServiceLaunched = 1;
        static final int TRANSACTION_onPlayLimitSet = 2;
        static final int TRANSACTION_onPlayStateChanged = 3;

        /* renamed from: com.baicizhan.client.fm.service.IFmServiceCallback$Stub$Proxy */
        class Proxy implements IFmServiceCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onFmServiceLaunched(boolean z, List<String> list, List<String> list2, int i) {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeStringList(list);
                    obtain.writeStringList(list2);
                    obtain.writeInt(i);
                    try {
                        this.mRemote.transact(1, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                    obtain2.readStringList(list);
                    obtain2.readStringList(list2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPlayLimitSet(int i, List<String> list, List<String> list2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStringList(list);
                    obtain.writeStringList(list2);
                    try {
                        this.mRemote.transact(2, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                    obtain2.readStringList(list);
                    obtain2.readStringList(list2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPlayStateChanged(int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    try {
                        this.mRemote.transact(3, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public IFmServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IFmServiceCallback)) {
                return new Proxy(iBinder);
            }
            return (IFmServiceCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean z = parcel.readInt() != 0;
                    ArrayList createStringArrayList = parcel.createStringArrayList();
                    ArrayList createStringArrayList2 = parcel.createStringArrayList();
                    onFmServiceLaunched(z, createStringArrayList, createStringArrayList2, parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStringList(createStringArrayList);
                    parcel2.writeStringList(createStringArrayList2);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int readInt = parcel.readInt();
                    ArrayList createStringArrayList3 = parcel.createStringArrayList();
                    ArrayList createStringArrayList4 = parcel.createStringArrayList();
                    onPlayLimitSet(readInt, createStringArrayList3, createStringArrayList4);
                    parcel2.writeNoException();
                    parcel2.writeStringList(createStringArrayList3);
                    parcel2.writeStringList(createStringArrayList4);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayStateChanged(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    try {
                        return super.onTransact(i, parcel, parcel2, i2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
            }
            return false;
        }
    }

    void onFmServiceLaunched(boolean z, List<String> list, List<String> list2, int i);

    void onPlayLimitSet(int i, List<String> list, List<String> list2);

    void onPlayStateChanged(int i, int i2, int i3);
}
