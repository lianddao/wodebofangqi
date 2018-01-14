package cn.ldm.player.core;

import android.content.Context;
import android.media.MediaMetadata;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import cn.ldm.player.services.MyMediaBrowserService;

/**
 * '音乐元数据'数据源
 */
public final class MusicMetadataDataSource {

    private Context mContext;
    public final static String UNKNOWN = "unknown";
    private static MusicMetadataDataSource instance;
    private ArrayList<MediaMetadata> mMusicList;
    private ConcurrentMap<String, MediaMetadata> mMusicListByTitle;
    private ConcurrentMap<String, Map<String, MediaMetadata>> mMusicListByArtist;   // ConcurrentMap<歌手,Map<专辑,元数据>>
    private ConcurrentMap<String, List<MediaMetadata>> mMusicListByAlbum;           // ConcurrentMap<专辑,List<元数据>>
    private ConcurrentMap<String, List<MediaMetadata>> mMusicListByPlaylist;        // ConcurrentMap<播放列表名,List<元数据>>

    public static MusicMetadataDataSource getInstance(Context context) {
        synchronized (MusicMetadataDataSource.class) {
            if (instance == null) {
                instance = new MusicMetadataDataSource();
                instance.mContext = context;
                instance.mMusicList = new ArrayList<>();
                instance.mMusicListByTitle = new ConcurrentHashMap<>();
                instance.mMusicListByArtist = new ConcurrentHashMap<>();
                instance.mMusicListByAlbum = new ConcurrentHashMap<>();
                instance.mMusicListByPlaylist = new ConcurrentHashMap<>();
                instance.mMusicListByPlaylist.put("最近添加的音乐", new ArrayList<MediaMetadata>());

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
        mMusicList.add(metadata);
    }

    public void toStringTitleList() {
        for (Map.Entry<String, MediaMetadata> i : mMusicListByTitle.entrySet()) {
            Log.i("abc", "DISPLAY_TITLE = " + i.getValue().getDescription().getTitle());
        }
    }

    public ConcurrentMap<String, MediaMetadata> getMusicListByTitle() {
        return mMusicListByTitle;
    }

    public Iterable<MediaMetadata> getMusicList() {
        return mMusicList;
    }
    //endregion

    //region 按音乐人归类。 ConcurrentMap<歌手,Map<专辑,元数据>>
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

    public ConcurrentMap<String, Map<String, MediaMetadata>> getMusicListByArtist() {
        if (mMusicListByArtist.size() == 0) return null;
        return mMusicListByArtist;
    }

    public Map<String, MediaMetadata> getMusicListByArtist(String artist) {
        return mMusicListByArtist.get(artist);
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


    public Iterable<MediaMetadata> getMusicListByAlbumForArtist(String artist, String album) {
        if (mMusicListByArtist.get(artist).containsKey(album)) {
            return mMusicListByAlbum.get(album);
        }
        return null;
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

    public Iterable<MediaMetadata> getMusicListByAlbum(String album) {
        return mMusicListByAlbum.get(album);
    }
    //endregion

    //region 按播放列表归类
    public Map<String, List<MediaMetadata>> getMusicListByPlaylist() {
        return mMusicListByPlaylist;
    }

    public List<MediaMetadata> getMusicListByPlaylist(String playlistName) {
        return mMusicListByPlaylist.get(playlistName);
    }

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
