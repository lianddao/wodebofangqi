package cn.ldm.player.loader;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

import cn.ldm.player.model.Playlist;
import cn.ldm.player.model.Song;
import cn.ldm.player.tool.MusicTool;
import cn.ldm.player.tool.ToolConfig;

import static cn.ldm.player.Config.SmartPlaylistType.LastAdded;
import static cn.ldm.player.Config.SmartPlaylistType.RecentlyPlayed;
import static cn.ldm.player.Config.SmartPlaylistType.TopTracks;
import static cn.ldm.player.tool.ToolConfig.VOLUME_EXTERNAL;

/**
 * 用于查询 {@link MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI} 并返回用户设备上的播放列表。
 */

public class PlaylistLoader extends WrappedAsyncTaskLoader<List<Playlist>> {

    private final ArrayList<Playlist> mPlaylistList = new ArrayList<>();

    public PlaylistLoader(Context context) {
        super(context);
    }

    public List<Playlist> loadInBackground() {
        // 将默认播放列表添加到适配器
        makeDefaultPlaylist();
        Cursor cursor = makePlaylistCursor(getContext());
        if (cursor != null && cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(0);
                String name = cursor.getString(1);
                int songCount = getSongCountForPlaylist(id);
                Playlist playlist = new Playlist(id, name, songCount);
                mPlaylistList.add(playlist);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
            cursor = null;
        }
        return mPlaylistList;
    }

    public static Cursor makePlaylistCursor(Context context) {
        return context.getContentResolver().query(
                MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                new String[]{BaseColumns._ID, MediaStore.Audio.PlaylistsColumns.NAME},
                null,
                null,
                null
        );
    }

    /**
     * 获取播放列表的歌曲数量。
     *
     * @param playlistId 播放列表的id
     * @return 播放列表中的歌曲数量
     */
    public int getSongCountForPlaylist(long playlistId) {
        Cursor c = getContext().getContentResolver().query(
                MediaStore.Audio.Playlists.Members.getContentUri(VOLUME_EXTERNAL, playlistId),
                new String[]{BaseColumns._ID},
                ToolConfig.MUSIC_ONLY_SELECTION,
                null,
                null
        );

        if (c != null) {
            int count = 0;
            if (c.moveToFirst()) {
                count = c.getCount();
            }
            c.close();
            c = null;
            return count;
        }

        return 0;
    }

    public List<Song> getSongForPlaylist(long playlistId) {
        Cursor cursor = getContext().getContentResolver().query(
                MediaStore.Audio.Playlists.Members.getContentUri(VOLUME_EXTERNAL, playlistId),
                null,
                ToolConfig.MUSIC_ONLY_SELECTION,
                null,
                null
        );
        List<Song> result = null;
        if (cursor != null && cursor.getCount() > 0) {
            result = new ArrayList<>(cursor.getCount());
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                long duration = MusicTool.getSecond(cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)));
                int year = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.YEAR));
                String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                Song song = new Song(id, title, artist, album, -1, duration, year, data);
                result.add(song);
            }
        }
        cursor.close();
        return result;
    }


    /**
     * 添加默认的播放列表
     */
    private void makeDefaultPlaylist() {
        Resources resources = getContext().getResources();
        //最后添加
        mPlaylistList.add(new Playlist(LastAdded.mId, resources.getString(LastAdded.mTitleId), 0));
        //最近播放
        mPlaylistList.add(new Playlist(RecentlyPlayed.mId, resources.getString(RecentlyPlayed.mTitleId), 0));
        //最爱
        mPlaylistList.add(new Playlist(TopTracks.mId, resources.getString(TopTracks.mTitleId), 0));
    }

}
