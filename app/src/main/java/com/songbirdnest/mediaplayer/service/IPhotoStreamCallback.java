package com.songbirdnest.mediaplayer.service;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPhotoStreamCallback extends IInterface {

    public static abstract class Stub extends Binder implements IPhotoStreamCallback {
        private static final String DESCRIPTOR = "com.songbirdnest.mediaplayer.service.IPhotoStreamCallback";
        static final int TRANSACTION_imageDone = 1;

        private static class Proxy implements IPhotoStreamCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void imageDone(Bitmap aBitmap) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (aBitmap != null) {
                        _data.writeInt(1);
                        aBitmap.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPhotoStreamCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IPhotoStreamCallback)) {
                return new Proxy(obj);
            }
            return (IPhotoStreamCallback) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    Bitmap _arg0;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (Bitmap) Bitmap.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    imageDone(_arg0);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void imageDone(Bitmap bitmap) throws RemoteException;
}
