package com.miui.player.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMediaPlaybackService extends IInterface {

    public static abstract class Stub extends Binder implements IMediaPlaybackService {
        private static final String DESCRIPTOR = "com.miui.player.service.IMediaPlaybackService";
        static final int TRANSACTION_addToCurrentPlaylist = 3;
        static final int TRANSACTION_adjustVolume = 52;
        static final int TRANSACTION_backward = 53;
        static final int TRANSACTION_duration = 15;
        static final int TRANSACTION_enqueue = 23;
        static final int TRANSACTION_forward = 54;
        static final int TRANSACTION_getAbsolutePath = 45;
        static final int TRANSACTION_getAlbumId = 20;
        static final int TRANSACTION_getAlbumName = 19;
        static final int TRANSACTION_getArtistId = 22;
        static final int TRANSACTION_getArtistName = 21;
        static final int TRANSACTION_getAudioId = 28;
        static final int TRANSACTION_getAudioIdByPos = 47;
        static final int TRANSACTION_getAudioSessionId = 38;
        static final int TRANSACTION_getBufferedPercent = 41;
        static final int TRANSACTION_getBufferedPosition = 40;
        static final int TRANSACTION_getChannelName = 30;
        static final int TRANSACTION_getConnectedDevice = 50;
        static final int TRANSACTION_getLyricStatus = 43;
        static final int TRANSACTION_getOnlineId = 29;
        static final int TRANSACTION_getPath = 27;
        static final int TRANSACTION_getPlayingFilePath = 46;
        static final int TRANSACTION_getQueue = 24;
        static final int TRANSACTION_getQueuePosition = 5;
        static final int TRANSACTION_getQueueSize = 6;
        static final int TRANSACTION_getRepeatMode = 37;
        static final int TRANSACTION_getShowLink = 55;
        static final int TRANSACTION_getShuffleMode = 32;
        static final int TRANSACTION_getTrackName = 18;
        static final int TRANSACTION_getUpdateVersion = 44;
        static final int TRANSACTION_isBlocking = 39;
        static final int TRANSACTION_isBuffering = 8;
        static final int TRANSACTION_isConnectCompleted = 51;
        static final int TRANSACTION_isPlaying = 7;
        static final int TRANSACTION_moveQueueItem = 25;
        static final int TRANSACTION_next = 13;
        static final int TRANSACTION_open = 1;
        static final int TRANSACTION_openList = 2;
        static final int TRANSACTION_pause = 10;
        static final int TRANSACTION_play = 11;
        static final int TRANSACTION_playAll = 4;
        static final int TRANSACTION_position = 16;
        static final int TRANSACTION_prev = 12;
        static final int TRANSACTION_quit = 14;
        static final int TRANSACTION_removeTrack = 35;
        static final int TRANSACTION_removeTracks = 34;
        static final int TRANSACTION_removeTracksBatch = 33;
        static final int TRANSACTION_scanFiles = 48;
        static final int TRANSACTION_seek = 17;
        static final int TRANSACTION_setConnectedDevice = 49;
        static final int TRANSACTION_setQueuePosition = 26;
        static final int TRANSACTION_setRepeatMode = 36;
        static final int TRANSACTION_setShuffleMode = 31;
        static final int TRANSACTION_stop = 9;
        static final int TRANSACTION_updateEqualizerBands = 42;

        private static class Proxy implements IMediaPlaybackService {
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

            public boolean open(long[] list, int position) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLongArray(list);
                    _data.writeInt(position);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() == 0) {
                        _result = false;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean openList(long[] list, int position, boolean forceShuffle, String channelName) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLongArray(list);
                    _data.writeInt(position);
                    if (forceShuffle) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    _data.writeString(channelName);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() == 0) {
                        _result = false;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void addToCurrentPlaylist(long[] list, int action) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLongArray(list);
                    _data.writeInt(action);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void playAll(long[] list, int position, boolean forceShuffle, int history, boolean directly, String channelName) throws RemoteException {
                int i = 1;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLongArray(list);
                    _data.writeInt(position);
                    _data.writeInt(forceShuffle ? 1 : 0);
                    _data.writeInt(history);
                    if (!directly) {
                        i = 0;
                    }
                    _data.writeInt(i);
                    _data.writeString(channelName);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getQueuePosition() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getQueueSize() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
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
                    this.mRemote.transact(7, _data, _reply, 0);
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

            public boolean isBuffering() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, _data, _reply, 0);
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

            public void stop() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, _data, _reply, 0);
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
                    this.mRemote.transact(10, _data, _reply, 0);
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
                    this.mRemote.transact(11, _data, _reply, 0);
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
                    this.mRemote.transact(12, _data, _reply, 0);
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
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void quit(boolean enableDelay) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (enableDelay) {
                        i = 1;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long duration() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long position() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long seek(long pos) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(pos);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
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
                    this.mRemote.transact(18, _data, _reply, 0);
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
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long getAlbumId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
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
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long getArtistId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void enqueue(long[] list, int action) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLongArray(list);
                    _data.writeInt(action);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long[] getQueue() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                    long[] _result = _reply.createLongArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void moveQueueItem(int from, int to) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(from);
                    _data.writeInt(to);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setQueuePosition(int index) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(index);
                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getPath() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long getAudioId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getOnlineId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(29, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getChannelName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(30, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setShuffleMode(int shufflemode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(shufflemode);
                    this.mRemote.transact(31, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getShuffleMode() throws RemoteException {
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

            public int removeTracksBatch(int[] posArr) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeIntArray(posArr);
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int removeTracks(int first, int last) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(first);
                    _data.writeInt(last);
                    this.mRemote.transact(34, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int removeTrack(long id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(id);
                    this.mRemote.transact(35, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setRepeatMode(int repeatmode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(repeatmode);
                    this.mRemote.transact(36, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getRepeatMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(37, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getAudioSessionId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(38, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isBlocking() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isBlocking, _data, _reply, 0);
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

            public long getBufferedPosition() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBufferedPosition, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public float getBufferedPercent() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getBufferedPercent, _data, _reply, 0);
                    _reply.readException();
                    float _result = _reply.readFloat();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void updateEqualizerBands(int[] levels) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeIntArray(levels);
                    this.mRemote.transact(Stub.TRANSACTION_updateEqualizerBands, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getLyricStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getLyricStatus, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public int getUpdateVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getUpdateVersion, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getAbsolutePath() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAbsolutePath, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getPlayingFilePath() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getPlayingFilePath, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long getAudioIdByPos(int pos) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(pos);
                    this.mRemote.transact(Stub.TRANSACTION_getAudioIdByPos, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void scanFiles(String[] paths, String[] mimeTypes) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringArray(paths);
                    _data.writeStringArray(mimeTypes);
                    this.mRemote.transact(Stub.TRANSACTION_scanFiles, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void setConnectedDevice(String device) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(device);
                    this.mRemote.transact(Stub.TRANSACTION_setConnectedDevice, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getConnectedDevice() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(50, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isConnectCompleted() throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isConnectCompleted, _data, _reply, 0);
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

            public boolean adjustVolume(boolean raise) throws RemoteException {
                boolean _result = true;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    int i;
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (raise) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    _data.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_adjustVolume, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() == 0) {
                        _result = false;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void backward() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_backward, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void forward() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_forward, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String getShowLink() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getShowLink, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaPlaybackService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IMediaPlaybackService)) {
                return new Proxy(obj);
            }
            return (IMediaPlaybackService) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _result;
            int _result2;
            long _result3;
            String _result4;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    _result = open(data.createLongArray(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    _result = openList(data.createLongArray(), data.readInt(), data.readInt() != 0, data.readString());
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    addToCurrentPlaylist(data.createLongArray(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    playAll(data.createLongArray(), data.readInt(), data.readInt() != 0, data.readInt(), data.readInt() != 0, data.readString());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getQueuePosition();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getQueueSize();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isPlaying();
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isBuffering();
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    stop();
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    pause();
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    play();
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    prev();
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    next();
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    quit(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = duration();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = position();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = seek(data.readLong());
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getTrackName();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getAlbumName();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getAlbumId();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 21:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getArtistName();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 22:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getArtistId();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 23:
                    data.enforceInterface(DESCRIPTOR);
                    enqueue(data.createLongArray(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface(DESCRIPTOR);
                    long[] _result5 = getQueue();
                    reply.writeNoException();
                    reply.writeLongArray(_result5);
                    return true;
                case 25:
                    data.enforceInterface(DESCRIPTOR);
                    moveQueueItem(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface(DESCRIPTOR);
                    setQueuePosition(data.readInt());
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getPath();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 28:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getAudioId();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 29:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getOnlineId();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 30:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getChannelName();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 31:
                    data.enforceInterface(DESCRIPTOR);
                    setShuffleMode(data.readInt());
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getShuffleMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 33:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = removeTracksBatch(data.createIntArray());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 34:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = removeTracks(data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 35:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = removeTrack(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 36:
                    data.enforceInterface(DESCRIPTOR);
                    setRepeatMode(data.readInt());
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getRepeatMode();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 38:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getAudioSessionId();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_isBlocking /*39*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isBlocking();
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case TRANSACTION_getBufferedPosition /*40*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getBufferedPosition();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case TRANSACTION_getBufferedPercent /*41*/:
                    data.enforceInterface(DESCRIPTOR);
                    float _result6 = getBufferedPercent();
                    reply.writeNoException();
                    reply.writeFloat(_result6);
                    return true;
                case TRANSACTION_updateEqualizerBands /*42*/:
                    data.enforceInterface(DESCRIPTOR);
                    updateEqualizerBands(data.createIntArray());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getLyricStatus /*43*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getLyricStatus();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getUpdateVersion /*44*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result2 = getUpdateVersion();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case TRANSACTION_getAbsolutePath /*45*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getAbsolutePath();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case TRANSACTION_getPlayingFilePath /*46*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getPlayingFilePath();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case TRANSACTION_getAudioIdByPos /*47*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result3 = getAudioIdByPos(data.readInt());
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case TRANSACTION_scanFiles /*48*/:
                    data.enforceInterface(DESCRIPTOR);
                    scanFiles(data.createStringArray(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case TRANSACTION_setConnectedDevice /*49*/:
                    data.enforceInterface(DESCRIPTOR);
                    setConnectedDevice(data.readString());
                    reply.writeNoException();
                    return true;
                case 50:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getConnectedDevice();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case TRANSACTION_isConnectCompleted /*51*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = isConnectCompleted();
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case TRANSACTION_adjustVolume /*52*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result = adjustVolume(data.readInt() != 0);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case TRANSACTION_backward /*53*/:
                    data.enforceInterface(DESCRIPTOR);
                    backward();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_forward /*54*/:
                    data.enforceInterface(DESCRIPTOR);
                    forward();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_getShowLink /*55*/:
                    data.enforceInterface(DESCRIPTOR);
                    _result4 = getShowLink();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void addToCurrentPlaylist(long[] jArr, int i) throws RemoteException;

    boolean adjustVolume(boolean z) throws RemoteException;

    void backward() throws RemoteException;

    long duration() throws RemoteException;

    void enqueue(long[] jArr, int i) throws RemoteException;

    void forward() throws RemoteException;

    String getAbsolutePath() throws RemoteException;

    long getAlbumId() throws RemoteException;

    String getAlbumName() throws RemoteException;

    long getArtistId() throws RemoteException;

    String getArtistName() throws RemoteException;

    long getAudioId() throws RemoteException;

    long getAudioIdByPos(int i) throws RemoteException;

    int getAudioSessionId() throws RemoteException;

    float getBufferedPercent() throws RemoteException;

    long getBufferedPosition() throws RemoteException;

    String getChannelName() throws RemoteException;

    String getConnectedDevice() throws RemoteException;

    int getLyricStatus() throws RemoteException;

    String getOnlineId() throws RemoteException;

    String getPath() throws RemoteException;

    String getPlayingFilePath() throws RemoteException;

    long[] getQueue() throws RemoteException;

    int getQueuePosition() throws RemoteException;

    int getQueueSize() throws RemoteException;

    int getRepeatMode() throws RemoteException;

    String getShowLink() throws RemoteException;

    int getShuffleMode() throws RemoteException;

    String getTrackName() throws RemoteException;

    int getUpdateVersion() throws RemoteException;

    boolean isBlocking() throws RemoteException;

    boolean isBuffering() throws RemoteException;

    boolean isConnectCompleted() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void moveQueueItem(int i, int i2) throws RemoteException;

    void next() throws RemoteException;

    boolean open(long[] jArr, int i) throws RemoteException;

    boolean openList(long[] jArr, int i, boolean z, String str) throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void playAll(long[] jArr, int i, boolean z, int i2, boolean z2, String str) throws RemoteException;

    long position() throws RemoteException;

    void prev() throws RemoteException;

    void quit(boolean z) throws RemoteException;

    int removeTrack(long j) throws RemoteException;

    int removeTracks(int i, int i2) throws RemoteException;

    int removeTracksBatch(int[] iArr) throws RemoteException;

    void scanFiles(String[] strArr, String[] strArr2) throws RemoteException;

    long seek(long j) throws RemoteException;

    void setConnectedDevice(String str) throws RemoteException;

    void setQueuePosition(int i) throws RemoteException;

    void setRepeatMode(int i) throws RemoteException;

    void setShuffleMode(int i) throws RemoteException;

    void stop() throws RemoteException;

    void updateEqualizerBands(int[] iArr) throws RemoteException;
}
