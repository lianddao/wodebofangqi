package cn.ldm.player.services;

import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.ldm.player.core.MusicMetadataDataSource;


/**
 * 我的媒体浏览服务
 */
public class MyMediaBrowserService extends MediaBrowserService {

    public final static String MEDIA_ID_ROOT = "__ROOT__";
    public final static String MEDIA_ID_MUSIC_BY_TITLE = "__BY_TITLE__";
    public final static String MEDIA_ID_MUSIC_BY_ARTIST = "__BY_ARTIST__";
    public final static String MEDIA_ID_MUSIC_BY_ALBUM = "__BY_ALBUM__";

    private MediaSession mSession;

    //region 当运行mediaBrowser.subscribe(..)时,才运行
    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        Log.i("abc", "onGetRoot");
        return new BrowserRoot(MEDIA_ID_ROOT, null);// 知道 __ROOT__ 的人可以浏览
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaItem>> result) {
        Log.i("abc", "onLoadChildren");
        if (parentId == null) {
            result.sendResult(null);
            return;
        }
        result.detach();
        // 获取本地或网络文件
        MusicMetadataDataSource dataSource = MusicMetadataDataSource.getInstance(this);
        List<MediaItem> mediaItems = new ArrayList<>();
        switch (parentId) {
            case MEDIA_ID_ROOT:
                //region ..
                Log.i("abc", "根据'__ROOT__'组织数据");
                mediaItems.add(
                        new MediaItem(
                                new MediaDescription.Builder()
                                        .setMediaId(MEDIA_ID_MUSIC_BY_TITLE)
                                        .setTitle("Titles")
                                        .build(),
                                MediaItem.FLAG_BROWSABLE)
                );
                mediaItems.add(
                        new MediaItem(
                                new MediaDescription.Builder()
                                        .setMediaId(MEDIA_ID_MUSIC_BY_ARTIST)
                                        .setTitle("Artists")
                                        .build(),
                                MediaItem.FLAG_BROWSABLE)
                );
                mediaItems.add(
                        new MediaItem(
                                new MediaDescription.Builder()
                                        .setMediaId(MEDIA_ID_MUSIC_BY_ALBUM)
                                        .setTitle("Albums")
                                        .build(),
                                MediaItem.FLAG_BROWSABLE)
                );
                //endregion
                break;
            case MEDIA_ID_MUSIC_BY_TITLE:
                Log.i("abc", "根据'__BY_TITLE__'组织数据");
                for (Map.Entry<String, MediaMetadata> entry : dataSource.getMusicListByTitle().entrySet()) {
                    MediaItem item = new MediaItem(
                            new MediaDescription.Builder()
                                    .setMediaId(MEDIA_ID_MUSIC_BY_TITLE + CATEGORY_SEPARATOR + entry.getValue().getDescription().getTitle())
                                    .setTitle(entry.getKey())
                                    .build(),
                            MediaItem.FLAG_BROWSABLE
                    );
                    mediaItems.add(item);
                }
                break;
            case MEDIA_ID_MUSIC_BY_ALBUM:
                //region ..
                Log.i("abc", "根据'__BY_ALBUM__'组织数据");
                for (Map.Entry<String, List<MediaMetadata>> entry : dataSource.getMusicListByAlbum().entrySet()) {
                    MediaItem item = new MediaItem(
                            new MediaDescription.Builder()
                                    .setMediaId(MEDIA_ID_MUSIC_BY_ALBUM + CATEGORY_SEPARATOR + entry.getKey())
                                    .setTitle(entry.getKey())
                                    .build(),
                            MediaItem.FLAG_BROWSABLE
                    );

                    mediaItems.add(item);
                }
                //endregion
                break;
            default:
                Log.i("abc", "根据'__BY_ALBUM_专辑名称'组织数据");
                if (parentId.startsWith(MEDIA_ID_MUSIC_BY_ALBUM)) {
                    String album = parentId.split(String.valueOf(CATEGORY_SEPARATOR))[1];
                    for (MediaMetadata metadata : dataSource.getMusicListByAlbum(album)) {
                        MediaItem item = new MediaItem(
                                new MediaDescription.Builder()
                                        .setMediaId(MEDIA_ID_MUSIC_BY_ALBUM + (char) 31 + album + LEAF_SEPARATOR + metadata.getDescription().getMediaId())
                                        .setTitle(album)
                                        .build(),
                                MediaItem.FLAG_BROWSABLE
                        );
                        mediaItems.add(item);
                    }
                }
                break;
        }
        result.sendResult(mediaItems);
    }
    //endregion

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("abc", MyMediaBrowserService.class.getName());
        mSession = new MediaSession(this, MyMediaBrowserService.class.getName());
        setSessionToken(mSession.getSessionToken());
    }

    private static final char CATEGORY_SEPARATOR = 31;  //单元分隔符 US ␟
    private static final char LEAF_SEPARATOR = 30;      //记录分隔符 RS ␞

}
