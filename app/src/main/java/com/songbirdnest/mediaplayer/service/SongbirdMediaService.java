package com.songbirdnest.mediaplayer.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.Playlist;
import java.util.List;

public interface SongbirdMediaService extends IInterface {

    public static abstract class Stub extends Binder implements SongbirdMediaService {
        private static final String DESCRIPTOR = "com.songbirdnest.mediaplayer.service.SongbirdMediaService";
        static final int TRANSACTION_duration = 20;
        static final int TRANSACTION_getAlbumName = 30;
        static final int TRANSACTION_getArtistName = 31;
        static final int TRANSACTION_getAudioId = 38;
        static final int TRANSACTION_getCurrentItem = 34;
        static final int TRANSACTION_getCurrentListActivity = 2;
        static final int TRANSACTION_getCurrentListToken = 4;
        static final int TRANSACTION_getCurrentSongToken = 32;
        static final int TRANSACTION_getEQSettings = 44;
        static final int TRANSACTION_getListPosition = 3;
        static final int TRANSACTION_getPhotoImage = 28;
        static final int TRANSACTION_getPhotostream = 26;
        static final int TRANSACTION_getPhotostreamSize = 27;
        static final int TRANSACTION_getPlayableListSize = 9;
        static final int TRANSACTION_getRandom = 24;
        static final int TRANSACTION_getRepeat = 14;
        static final int TRANSACTION_getTrackID = 33;
        static final int TRANSACTION_getTrackName = 29;
        static final int TRANSACTION_isEQEnabled = 40;
        static final int TRANSACTION_isPaused = 6;
        static final int TRANSACTION_isPlaying = 5;
        static final int TRANSACTION_next = 19;
        static final int TRANSACTION_pause = 16;
        static final int TRANSACTION_play = 17;
        static final int TRANSACTION_position = 21;
        static final int TRANSACTION_prev = 18;
        static final int TRANSACTION_registerCallback = 35;
        static final int TRANSACTION_reset = 37;
        static final int TRANSACTION_saveEQSettings = 45;
        static final int TRANSACTION_seek = 22;
        static final int TRANSACTION_setBandLevel = 43;
        static final int TRANSACTION_setCurrentList = 1;
        static final int TRANSACTION_setEQEnabled = 39;
        static final int TRANSACTION_setLastActivity = 7;
        static final int TRANSACTION_setPhotostream = 25;
        static final int TRANSACTION_setPlayableList = 10;
        static final int TRANSACTION_setPlayableListPosition = 8;
        static final int TRANSACTION_setPlayablePlaylist = 12;
        static final int TRANSACTION_setPresetType = 42;
        static final int TRANSACTION_setRandom = 23;
        static final int TRANSACTION_setRepeat = 13;
        static final int TRANSACTION_setShuffledPlayableList = 11;
        static final int TRANSACTION_stop = 15;
        static final int TRANSACTION_unregisterCallback = 36;
        static final int TRANSACTION_usePreset = 41;

        private static class Proxy implements SongbirdMediaService {
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

            public void setCurrentList(String activity, String token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(activity);
                    _data.writeString(token);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getCurrentListActivity() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getListPosition() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getCurrentListToken() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isPlaying() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isPaused() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setLastActivity(Intent myActivity) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (myActivity != null) {
                        _data.writeInt(1);
                        myActivity.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setPlayableListPosition(int aPosition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aPosition);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getPlayableListSize() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setPlayableList(List<PlayableItem> aList, int aPosition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedList(aList);
                    _data.writeInt(aPosition);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setShuffledPlayableList(List<PlayableItem> aList) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedList(aList);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setPlayablePlaylist(Playlist aPlaylist, int aPlaylistPosition, boolean aShuffle) throws RemoteException {
                int i = 1;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (aPlaylist != null) {
                        _data.writeInt(1);
                        aPlaylist.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(aPlaylistPosition);
                    if (!aShuffle) {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setRepeat(int state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(state);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getRepeat() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void stop() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void pause() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void play() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void prev() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void next() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int duration() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int position() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_position, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int seek(int aPosition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aPosition);
                    this.mRemote.transact(Stub.TRANSACTION_seek, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setRandom(int aRandom) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aRandom);
                    this.mRemote.transact(Stub.TRANSACTION_setRandom, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getRandom() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getRandom, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setPhotostream(int aPhotostreamState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(aPhotostreamState);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getPhotostream() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPhotostream, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getPhotostreamSize() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPhotostreamSize, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void getPhotoImage(IPhotoStreamCallback aPhotoStreamCallback, int aTargetImage) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(aPhotoStreamCallback != null ? aPhotoStreamCallback.asBinder() : null);
                    _data.writeInt(aTargetImage);
                    this.mRemote.transact(Stub.TRANSACTION_getPhotoImage, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getTrackName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getTrackName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getAlbumName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAlbumName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getArtistName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getArtistName, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getCurrentSongToken() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getTrackID() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public PlayableItem getCurrentItem() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    PlayableItem _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentItem, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (PlayableItem) PlayableItem.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void registerCallback(IMediaEventCallback aCallback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(aCallback != null ? aCallback.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void unregisterCallback(IMediaEventCallback aCallback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(aCallback != null ? aCallback.asBinder() : null);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void reset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_reset, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAudioId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioId, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setEQEnabled(boolean enabled) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (enabled) {
                        i = 1;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_setEQEnabled, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isEQEnabled() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isEQEnabled, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void usePreset(int preset) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(preset);
                    this.mRemote.transact(Stub.TRANSACTION_usePreset, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setPresetType(int presetType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(presetType);
                    this.mRemote.transact(Stub.TRANSACTION_setPresetType, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setBandLevel(int band, int level) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    _data.writeInt(level);
                    this.mRemote.transact(Stub.TRANSACTION_setBandLevel, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public EqualizerSettings getEQSettings() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    EqualizerSettings _result;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getEQSettings, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = (EqualizerSettings) EqualizerSettings.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void saveEQSettings() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_saveEQSettings, _data, _reply, 0);
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

        public static SongbirdMediaService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof SongbirdMediaService)) {
                return new Proxy(obj);
            }
            return (SongbirdMediaService) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = 0;
            String _result;
            int _result2;
            boolean _result3;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    setCurrentList(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getCurrentListActivity();
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getListPosition();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getCurrentListToken();
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = isPlaying();
                    reply.writeNoException();
                    if (_result3) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = isPaused();
                    reply.writeNoException();
                    if (_result3) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 7:
                    Intent _arg0;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (Intent) Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    setLastActivity(_arg0);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    setPlayableListPosition(data.readInt());
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPlayableListSize();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    setPlayableList(data.createTypedArrayList(PlayableItem.CREATOR), data.readInt());
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    setShuffledPlayableList(data.createTypedArrayList(PlayableItem.CREATOR));
                    reply.writeNoException();
                    return true;
                case 12:
                    Playlist _arg02;
                    boolean _arg2;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = (Playlist) Playlist.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    int _arg1 = data.readInt();
                    if (data.readInt() != 0) {
                        _arg2 = true;
                    } else {
                        _arg2 = false;
                    }
                    setPlayablePlaylist(_arg02, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    setRepeat(data.readInt());
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getRepeat();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    stop();
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    pause();
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    play();
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    prev();
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    next();
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = duration();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_position /*21*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = position();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_seek /*22*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = seek(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setRandom /*23*/:
                    data.enforceInterface(DESCRIPTOR);
                    setRandom(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getRandom /*24*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getRandom();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 25:
                    data.enforceInterface(DESCRIPTOR);
                    setPhotostream(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getPhotostream /*26*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPhotostream();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getPhotostreamSize /*27*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getPhotostreamSize();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getPhotoImage /*28*/:
                    data.enforceInterface(DESCRIPTOR);
                    getPhotoImage(IPhotoStreamCallback.Stub.asInterface(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getTrackName /*29*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getTrackName();
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case TRANSACTION_getAlbumName /*30*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getAlbumName();
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case TRANSACTION_getArtistName /*31*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = getArtistName();
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getCurrentSongToken();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 33:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getTrackID();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getCurrentItem /*34*/:
                    data.enforceInterface(DESCRIPTOR);
                    PlayableItem _result4 = getCurrentItem();
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(1);
                        _result4.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_registerCallback /*35*/:
                    data.enforceInterface(DESCRIPTOR);
                    registerCallback(IMediaEventCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_unregisterCallback /*36*/:
                    data.enforceInterface(DESCRIPTOR);
                    unregisterCallback(IMediaEventCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TRANSACTION_reset /*37*/:
                    data.enforceInterface(DESCRIPTOR);
                    reset();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getAudioId /*38*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAudioId();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_setEQEnabled /*39*/:
                    boolean _arg03;
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg03 = true;
                    } else {
                        _arg03 = false;
                    }
                    setEQEnabled(_arg03);
                    reply.writeNoException();
                    return true;
                case TRANSACTION_isEQEnabled /*40*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = isEQEnabled();
                    reply.writeNoException();
                    if (_result3) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case TRANSACTION_usePreset /*41*/:
                    data.enforceInterface(DESCRIPTOR);
                    usePreset(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setPresetType /*42*/:
                    data.enforceInterface(DESCRIPTOR);
                    setPresetType(data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setBandLevel /*43*/:
                    data.enforceInterface(DESCRIPTOR);
                    setBandLevel(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getEQSettings /*44*/:
                    data.enforceInterface(DESCRIPTOR);
                    EqualizerSettings _result5 = getEQSettings();
                    reply.writeNoException();
                    if (_result5 != null) {
                        reply.writeInt(1);
                        _result5.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TRANSACTION_saveEQSettings /*45*/:
                    data.enforceInterface(DESCRIPTOR);
                    saveEQSettings();
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

    int duration() throws RemoteException;

    String getAlbumName() throws RemoteException;

    String getArtistName() throws RemoteException;

    int getAudioId() throws RemoteException;

    PlayableItem getCurrentItem() throws RemoteException;

    String getCurrentListActivity() throws RemoteException;

    String getCurrentListToken() throws RemoteException;

    int getCurrentSongToken() throws RemoteException;

    EqualizerSettings getEQSettings() throws RemoteException;

    int getListPosition() throws RemoteException;

    void getPhotoImage(IPhotoStreamCallback iPhotoStreamCallback, int i) throws RemoteException;

    int getPhotostream() throws RemoteException;

    int getPhotostreamSize() throws RemoteException;

    int getPlayableListSize() throws RemoteException;

    int getRandom() throws RemoteException;

    int getRepeat() throws RemoteException;

    int getTrackID() throws RemoteException;

    String getTrackName() throws RemoteException;

    boolean isEQEnabled() throws RemoteException;

    boolean isPaused() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void next() throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    int position() throws RemoteException;

    void prev() throws RemoteException;

    void registerCallback(IMediaEventCallback iMediaEventCallback) throws RemoteException;

    void reset() throws RemoteException;

    void saveEQSettings() throws RemoteException;

    int seek(int i) throws RemoteException;

    void setBandLevel(int i, int i2) throws RemoteException;

    void setCurrentList(String str, String str2) throws RemoteException;

    void setEQEnabled(boolean z) throws RemoteException;

    void setLastActivity(Intent intent) throws RemoteException;

    void setPhotostream(int i) throws RemoteException;

    void setPlayableList(List<PlayableItem> list, int i) throws RemoteException;

    void setPlayableListPosition(int i) throws RemoteException;

    void setPlayablePlaylist(Playlist playlist, int i, boolean z) throws RemoteException;

    void setPresetType(int i) throws RemoteException;

    void setRandom(int i) throws RemoteException;

    void setRepeat(int i) throws RemoteException;

    void setShuffledPlayableList(List<PlayableItem> list) throws RemoteException;

    void stop() throws RemoteException;

    void unregisterCallback(IMediaEventCallback iMediaEventCallback) throws RemoteException;

    void usePreset(int i) throws RemoteException;
}
