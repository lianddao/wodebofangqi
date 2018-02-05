package cn.ldm.player.model;


import android.database.Cursor;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.provider.MediaStore;

public class SongInfo {

    private static final String FIELDS_DATA = MediaMetadata.METADATA_KEY_ART_URI;
    private MediaMetadata _mediaMetadata;
    private MediaBrowser.MediaItem _mediaItem;
    private String _id, _title, _subtitle, _album, _artist;
    private Uri _uri;
    private long _duration;

    public static SongInfo make(MediaMetadata metadata) {
        SongInfo info = new SongInfo();
        info._id = metadata.getString(MediaMetadata.METADATA_KEY_MEDIA_ID);
        info._title = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE);
        info._subtitle = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_SUBTITLE);
        info._album = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
        info._artist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
        info._uri = Uri.parse(metadata.getString(FIELDS_DATA));
        info._duration = metadata.getLong(MediaMetadata.METADATA_KEY_DURATION);
        info._mediaMetadata = metadata;
        info._mediaItem = new MediaBrowser.MediaItem(
                new MediaDescription.Builder()
                        .setMediaId(info._id)
                        .setMediaUri(info._uri)
                        .setTitle(info._title)
                        .setSubtitle(info._subtitle)
                        .build(),
                MediaBrowser.MediaItem.FLAG_PLAYABLE);
        return info;
    }

    private SongInfo() {}

    public SongInfo(Cursor cursor) {
        _id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
        _title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
        _artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
        _album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
        _duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
        String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
        _uri = Uri.parse(data);
        _mediaMetadata = new MediaMetadata.Builder()
                .putString(MediaMetadata.METADATA_KEY_MEDIA_ID, _id)
                .putString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE, _title)
                .putString(MediaMetadata.METADATA_KEY_ARTIST, _artist)
                .putString(MediaMetadata.METADATA_KEY_ALBUM, _album)
                .putString(MediaMetadata.METADATA_KEY_DISPLAY_SUBTITLE, _artist + " - " + _album)
                .putLong(MediaMetadata.METADATA_KEY_DURATION, _duration)
                .putString(FIELDS_DATA, data)
                .build();
        _mediaItem = new MediaBrowser.MediaItem(
                new MediaDescription.Builder()
                        .setMediaId(_id)
                        .setMediaUri(_uri)
                        .setTitle(_title)
                        .setSubtitle(_subtitle)
                        .build(),
                MediaBrowser.MediaItem.FLAG_PLAYABLE);
    }

    @Override
    public String toString() {
        return _id + "," + _title;
    }

    public MediaMetadata getMediaMetadata() {
        return _mediaMetadata;
    }

    public void setMediaMetadata(MediaMetadata mediaMetadata) {
        _mediaMetadata = mediaMetadata;
    }

    public MediaBrowser.MediaItem getMediaItem() {
        return _mediaItem;
    }

    public void setMediaItem(MediaBrowser.MediaItem mediaItem) {
        _mediaItem = mediaItem;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getSubtitle() {
        return _subtitle;
    }

    public void setSubtitle(String subtitle) {
        _subtitle = subtitle;
    }

    public String getAlbum() {
        return _album;
    }

    public void setAlbum(String album) {
        _album = album;
    }

    public String getArtist() {
        return _artist;
    }

    public void setArtist(String artist) {
        _artist = artist;
    }

    public Uri getUri() {
        return _uri;
    }

    public void setUri(Uri uri) {
        _uri = uri;
    }
}