package com.miui.player.meta;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.service.ServiceHelper;
import com.miui.player.util.FileNameUtils;
import entagged.audioformats.AudioFile;
import entagged.audioformats.AudioFileIO;
import entagged.audioformats.Tag;
import entagged.audioformats.exceptions.CannotReadException;
import entagged.audioformats.exceptions.CannotWriteException;
import java.io.File;

public class MediaFileManager {

    public interface MediaEditInfoFactory {
        MediaEditInfo create(String str, String str2, String str3, String str4);
    }

    public static class AlbumEditInfoFactory implements MediaEditInfoFactory {
        private final String mAlbum;

        public AlbumEditInfoFactory(String newAlbum) {
            this.mAlbum = newAlbum;
        }

        public MediaEditInfo create(String path, String tr, String ar, String al) {
            return new MediaEditInfo(path, tr, ar, this.mAlbum);
        }
    }

    public static class ArtistEditInfoFactory implements MediaEditInfoFactory {
        private final String mArtist;

        public ArtistEditInfoFactory(String newArtist) {
            this.mArtist = newArtist;
        }

        public MediaEditInfo create(String path, String tr, String ar, String al) {
            return new MediaEditInfo(path, tr, this.mArtist, al);
        }
    }

    public static class MediaEditInfo {
        public final String mNewAlbum;
        public final String mNewArtist;
        public final String mNewTitle;
        public final String mPath;

        public MediaEditInfo(String path, String newTitle, String newArtist, String newAlbum) {
            this.mPath = path;
            this.mNewTitle = newTitle;
            this.mNewArtist = newArtist;
            this.mNewAlbum = newAlbum;
        }
    }

    public static class TrackEditInfoFactory implements MediaEditInfoFactory {
        private final String mAlbum;
        private final String mArtist;
        private final String mTrack;

        public TrackEditInfoFactory(String tr, String ar, String al) {
            this.mTrack = tr;
            this.mArtist = ar;
            this.mAlbum = al;
        }

        public MediaEditInfo create(String path, String tr, String ar, String al) {
            return new MediaEditInfo(path, this.mTrack, this.mArtist, this.mAlbum);
        }
    }

    public static String getMIMEType(File file) {
        String ext = FileNameUtils.getFileExtension(file.getAbsolutePath());
        return ext != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext) : ext;
    }

    public static String getMIMEType(String path) {
        String ext = FileNameUtils.getFileExtension(path);
        return ext != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext) : ext;
    }

    public static boolean doCorrect(File file, String title, String artist, String album) {
        if (TextUtils.isEmpty(title) || file == null || !file.exists()) {
            return false;
        }
        boolean isModified = false;
        try {
            AudioFile audio = AudioFileIO.read(file);
            Tag t = audio.getTag();
            if (!title.equals(t.getFirstTitle())) {
                t.setTitle(title);
                isModified = true;
            }
            if (!(artist == null || artist.equals(t.getFirstArtist()))) {
                t.setArtist(artist);
                isModified = true;
            }
            if (!(album == null || album.equals(t.getFirstAlbum()))) {
                t.setAlbum(album);
                isModified = true;
            }
            if (!isModified) {
                return isModified;
            }
            audio.commit();
            return isModified;
        } catch (OutOfMemoryError e) {
            return false;
        } catch (CannotReadException e2) {
            return false;
        } catch (CannotWriteException e3) {
            return false;
        }
    }

    public static void batchCorretId3Async(final Context context, final MediaEditInfo[] editInfo) {
        if (context != null && editInfo != null && editInfo.length != 0) {
            new AsyncTask<Void, MediaEditInfo, Void>() {
                final String[] mArgs = new String[1];
                final ContentValues mValues = new ContentValues();

                protected Void doInBackground(Void... params) {
                    for (MediaEditInfo info : editInfo) {
                        File f = new File(info.mPath);
                        MediaFileManager.doCorrect(f, info.mNewTitle, info.mNewArtist, info.mNewAlbum);
                        if (MediaFileManager.getMIMEType(f) != null) {
                            publishProgress(new MediaEditInfo[]{info});
                        }
                    }
                    return null;
                }

                protected void onProgressUpdate(MediaEditInfo... infoArr) {
                    if (infoArr != null && infoArr.length > 0) {
                        MediaEditInfo info = infoArr[0];
                        ServiceHelper.scanFiles(context, new String[]{info.mPath}, new String[]{MediaFileManager.getMIMEType(info.mPath)});
                        ContentValues v = this.mValues;
                        v.clear();
                        if (!TextUtils.isEmpty(info.mNewTitle)) {
                            v.put("title", info.mNewTitle);
                        }
                        if (!TextUtils.isEmpty(info.mNewAlbum)) {
                            v.put("album", info.mNewAlbum);
                        }
                        if (!TextUtils.isEmpty(info.mNewArtist)) {
                            v.put("artist", info.mNewArtist);
                        }
                        this.mArgs[0] = String.valueOf(info.mPath);
                        context.getContentResolver().update(MiuiPlaylistsAudioMap.EXTERNAL_URI, v, "_data=?", this.mArgs);
                    }
                }
            }.execute(new Void[0]);
        }
    }

    public static boolean correctID3(Context context, File file, String title, String artist, String album) {
        return correctID3(context, file, title, artist, album, false);
    }

    public static boolean correctID3(Context context, File file, String title, String artist, String album, boolean forceScan) {
        if (!doCorrect(file, title, artist, album) && !forceScan) {
            return false;
        }
        if (getMIMEType(file) == null) {
            return false;
        }
        ServiceHelper.scanFiles(context, new String[]{file.getAbsolutePath()}, new String[]{getMIMEType(file)});
        return true;
    }
}
