package com.baicizhan.client.p029fm.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.baicizhan.client.fm.service.IFmService */
public interface IFmService extends IInterface {

    /* renamed from: com.baicizhan.client.fm.service.IFmService$Stub */
    public abstract class Stub extends Binder implements IFmService {
        private static final String DESCRIPTOR = "com.baicizhan.client.fm.service.IFmService";
        static final int TRANSACTION_close = 2;
        static final int TRANSACTION_launch = 1;
        static final int TRANSACTION_newPlay = 3;
        static final int TRANSACTION_newPlayMid = 4;
        static final int TRANSACTION_newPlayPath = 5;
        static final int TRANSACTION_pause = 9;
        static final int TRANSACTION_play = 6;
        static final int TRANSACTION_playMore = 13;
        static final int TRANSACTION_playNext = 7;
        static final int TRANSACTION_playPrev = 8;
        static final int TRANSACTION_setPlayLimit = 14;
        static final int TRANSACTION_setPlayQuality = 12;
        static final int TRANSACTION_stop = 10;
        static final int TRANSACTION_toggle = 11;

        /* renamed from: com.baicizhan.client.fm.service.IFmService$Stub$Proxy */
        class Proxy implements IFmService {
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

            public void launch(IFmServiceCallback iFmServiceCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFmServiceCallback != null ? iFmServiceCallback.asBinder() : null);
                    try {
                        this.mRemote.transact(1, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void close(IFmServiceCallback iFmServiceCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFmServiceCallback != null ? iFmServiceCallback.asBinder() : null);
                    try {
                        this.mRemote.transact(2, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void newPlay(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
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

            public void newPlayMid(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    try {
                        this.mRemote.transact(4, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void newPlayPath(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    try {
                        this.mRemote.transact(5, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void play() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        this.mRemote.transact(6, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void playNext() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        this.mRemote.transact(7, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void playPrev() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        this.mRemote.transact(8, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        this.mRemote.transact(9, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stop() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        this.mRemote.transact(10, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void toggle() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        this.mRemote.transact(11, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayQuality(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    try {
                        this.mRemote.transact(12, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void playMore() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        this.mRemote.transact(13, obtain, obtain2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayLimit(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    try {
                        this.mRemote.transact(14, obtain, obtain2, 0);
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

        public  IFmService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IFmService)) {
                return new Proxy(iBinder);
            }
            return (IFmService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
//                    launch(com.baicizhan.client.p029fm.service.IFmServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
//                    close(com.baicizhan.client.p029fm.service.IFmServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    newPlay(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    newPlayMid(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    newPlayPath(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    play();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    playNext();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    playPrev();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    stop();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    toggle();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPlayQuality(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    playMore();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPlayLimit(parcel.readInt());
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

    void close(IFmServiceCallback iFmServiceCallback);

    void launch(IFmServiceCallback iFmServiceCallback);

    void newPlay(int i);

    void newPlayMid(int i);

    void newPlayPath(String str);

    void pause();

    void play();

    void playMore();

    void playNext();

    void playPrev();

    void setPlayLimit(int i);

    void setPlayQuality(boolean z);

    void stop();

    void toggle();
}
