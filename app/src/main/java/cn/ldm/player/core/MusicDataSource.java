package cn.ldm.player.core;

import android.content.Context;
import android.media.MediaMetadata;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 音乐数据源
 */
public final class MusicDataSource {

    private Context mContext;
    public final static String UNKNOWN = "unknown";
    public final static String MEDIA_ID_NOW_PLAYING = "__NOW_PLAYING__";
    private static MusicDataSource instance;
    private ConcurrentMap<String, MediaMetadata> mMusicListByTitle;
    private ConcurrentMap<String, Map<String, MediaMetadata>> mMusicListByArtist;   // ConcurrentMap<歌手,Map<专辑,元数据>>
    private ConcurrentMap<String, List<MediaMetadata>> mMusicListByAlbum;           // ConcurrentMap<专辑,List<元数据>>
    private ConcurrentMap<String, List<MediaMetadata>> mMusicListByPlaylist;        // ConcurrentMap<播放列表名,List<元数据>>
    private MediaMetadata.Builder mMediaMetadataBuilder;

    public static MusicDataSource getInstance(Context context) {
        synchronized (MusicDataSource.class) {
            if (instance == null) {
                instance = new MusicDataSource();
                instance.mContext = context;
                instance.mMediaMetadataBuilder = new MediaMetadata.Builder();
                instance.mMusicListByTitle = new ConcurrentHashMap<>();
                instance.mMusicListByArtist = new ConcurrentHashMap<>();
                instance.mMusicListByAlbum = new ConcurrentHashMap<>();
                instance.mMusicListByPlaylist = new ConcurrentHashMap<>();
//                instance.mMusicListByPlaylist.put(MEDIA_ID_NOW_PLAYING, new ArrayList<MediaMetadata>());

                ArrayList<MediaMetadata> result = new ArrayList<>();
                MusicScanner.getInstance(context).retrieveMedia(result);
                for (MediaMetadata metadata : result) {
                    instance.addMusicToTitleList(metadata);
                    instance.addMusicToAlbumList(metadata);
                    instance.addMusicToArtistList(metadata);
                }
                MusicScanner.getInstance(context).retrieveAllPlayList(instance.mMusicListByPlaylist, instance.mMusicListByTitle);
            }
            return instance;
        }
    }

    //region 按歌曲名归类。
    private void addMusicToTitleList(MediaMetadata metadata) {
        String thisMusic = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE);
        if (thisMusic == null) thisMusic = UNKNOWN;
        mMusicListByTitle.put(metadata.getString(MediaMetadata.METADATA_KEY_MEDIA_ID), metadata);
    }

    public void toStringTitleList() {
        for (Map.Entry<String, MediaMetadata> i : mMusicListByTitle.entrySet()) {
            Log.i("abc", "DISPLAY_TITLE = " + i.getValue().getDescription().getTitle());
        }
    }

    public ConcurrentMap<String, MediaMetadata> getMusicListByTitle() {
        return mMusicListByTitle;
    }
    //endregion

    //region 按音乐人归类。 ConcurrentMap<歌手,Map<专辑,元数据>>
    public ConcurrentMap<String, Map<String, MediaMetadata>> getMusicListByArtist() {
        if (mMusicListByArtist.size() == 0) return null;
        return mMusicListByArtist;
    }

    public void toStringArtistList() {
        for (Map.Entry<String, Map<String, MediaMetadata>> i : mMusicListByArtist.entrySet()) {
            Log.i("abc", "歌手：" + i.getKey());
            for (Map.Entry<String, MediaMetadata> j : i.getValue().entrySet()) {
                Log.i("abc", "专辑：" + j.getKey() + ", " + j.getValue().getDescription().getTitle().toString());
            }
            Log.i("abc", "---");
        }
    }

    private void addMusicToArtistList(MediaMetadata metadata) {
        String thisArtist = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
        if (thisArtist == null) thisArtist = UNKNOWN;
        String thisAlbum = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
        if (thisAlbum == null) thisAlbum = UNKNOWN;
        if (!mMusicListByArtist.containsKey(thisArtist))
            mMusicListByArtist.put(thisArtist, new ConcurrentHashMap<String, MediaMetadata>());
        Map<String, MediaMetadata> albumsMap = mMusicListByArtist.get(thisArtist);
        albumsMap.put(thisAlbum, metadata);
    }
    //endregion

    //region 按专辑归类。
    private void addMusicToAlbumList(MediaMetadata metadata) {
        String thisAlbum = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
        if (thisAlbum == null) thisAlbum = UNKNOWN;
        if (!mMusicListByAlbum.containsKey(thisAlbum)) {
            mMusicListByAlbum.put(thisAlbum, new ArrayList<MediaMetadata>());
        }
        mMusicListByAlbum.get(thisAlbum).add(metadata);
    }

    public void toStringAlbumList() {
        for (Map.Entry<String, List<MediaMetadata>> i : mMusicListByAlbum.entrySet()) {
            Log.i("abc", "专辑：" + i.getKey());
            for (MediaMetadata j : i.getValue()) Log.i("abc", j.getDescription().getTitle().toString());
            Log.i("abc", "---");
        }
    }

    public Map<String, List<MediaMetadata>> getMusicListByAlbum() {
        return mMusicListByAlbum;
    }
    //endregion

    //region 按播放列表归类
    public void toStringPlaylist() {
        for (Map.Entry<String, List<MediaMetadata>> i : mMusicListByPlaylist.entrySet()) {
            Log.i("abc", "播放列表名：" + i.getKey());
            for (MediaMetadata j : i.getValue()) {
                Log.i("abc", j.getDescription().getTitle().toString());
            }
            Log.i("abc", "---");
        }
    }
    //endregion
}
