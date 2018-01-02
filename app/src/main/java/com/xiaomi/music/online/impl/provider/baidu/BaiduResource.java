package com.xiaomi.music.online.impl.provider.baidu;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.music.model.Album;
import com.baidu.music.model.Artist;
import com.baidu.music.model.LrcPic;
import com.baidu.music.model.LrcPicList;
import com.baidu.music.model.Music;
import com.baidu.music.onlinedata.MusicManager.MusicListener;
import com.google.android.collect.Lists;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.impl.ResourceManager;
import com.xiaomi.music.online.model.ResourceSearchInfo;
import com.xiaomi.music.online.model.ResourceSearchResult;
import com.xiaomi.music.online.model.ResourceSearchResult.Builder;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.Numbers;
import com.xiaomi.music.util.ThreadManager.BlockingRequest;
import java.util.Arrays;
import java.util.List;

public class BaiduResource implements ResourceManager {
    static final String TAG = "BaiduResource";
    private static final BaiduResource sInstance = new BaiduResource();

    private BaiduResource() {
    }

    public static BaiduResource instance() {
        return sInstance;
    }

    public int getId() {
        return 1;
    }

    public Result<List<ResourceSearchResult>> search(Context context, ResourceSearchInfo info) {
        List<ResourceSearchResult> data = null;
        if (Numbers.toInt(info.mCpId, 0) == getId()) {
            String audio = info.mCpSongId;
            if (!TextUtils.isEmpty(audio) && (info.mSearchType == 1 || info.mSearchType == 2)) {
                data = searchByAudioId(context, info.mSearchType, audio);
                if (!(data == null || data.isEmpty())) {
                    MusicLog.m399i(TAG, "Get by audio id");
                    return Result.create(1, data);
                }
            }
            if (!TextUtils.isEmpty(info.mAlbumId) && info.mSearchType == 1) {
                data = searchByAlbumId(context, info.mSearchType, info.mAlbumId);
                if (!(data == null || data.isEmpty())) {
                    MusicLog.m399i(TAG, "Get by album id");
                    return Result.create(1, data);
                }
            }
            if (!TextUtils.isEmpty(info.mArtistId) && info.mSearchType == 0) {
                data = searchByArtistId(context, info.mSearchType, info.mArtistId);
                if (!(data == null || data.isEmpty())) {
                    MusicLog.m399i(TAG, "Get by artist id");
                    return Result.create(1, data);
                }
            }
        }
        if (!TextUtils.isEmpty(info.mTrackName)) {
            data = searchByTrack(context, info.mSearchType, info.mTrackName, info.mArtistName);
            if (!(data == null || data.isEmpty())) {
                MusicLog.m399i(TAG, "Get by track name");
                return Result.create(1, data);
            }
        }
        if (info.mSearchType == 1 && !TextUtils.isEmpty(info.mAlbumName)) {
            data = searchByAlbumName(context, info.mSearchType, info.mAlbumName, info.mArtistName);
            if (!(data == null || data.isEmpty())) {
                MusicLog.m399i(TAG, "Get by album name");
                return Result.create(1, data);
            }
        }
        return Result.create(-1, data);
    }

    private List<ResourceSearchResult> searchByAlbumName(Context context, int type, String album, String artist) {
        String url = BaiduEngine.get(context).getSearchManager(context).searchAlbumPictureSync(album, artist);
        if (TextUtils.isEmpty(url) || !isUsableResult(type, url, null, null)) {
            return null;
        }
        new Builder(type).setAlbumUrl(url);
        return Arrays.asList(new ResourceSearchResult[]{builder.build()});
    }

    private List<ResourceSearchResult> searchByArtistId(Context context, int type, String artistIdStr) {
        Artist ar = BaiduEngine.get(context).getArtistManager(context).getArtistSync(context, Numbers.toInt(artistIdStr, 0));
        if (ar == null || ar.getErrorCode() != 50000 || TextUtils.isEmpty(ar.mAvatarBig)) {
            return null;
        }
        new Builder(type).setAvatarUrl(ar.mAvatarBig);
        return Arrays.asList(new ResourceSearchResult[]{builder.build()});
    }

    private List<ResourceSearchResult> searchByAlbumId(Context context, int type, String album) {
        Album al = BaiduEngine.get(context).getAlbumManager(context).getAlbum(context, Long.parseLong(album));
        if (al == null || al.getErrorCode() != 50000 || !isUsableResult(type, al.mPic1000, null, null)) {
            return null;
        }
        new Builder(type).setAlbumUrl(al.mPic1000);
        return Arrays.asList(new ResourceSearchResult[]{builder.build()});
    }

    private static boolean isTrackMatch(String tr1, String tr2) {
        if (tr1 == null || tr2 == null) {
            return false;
        }
        return tr1.toLowerCase().equals(tr2.toLowerCase());
    }

    private static boolean isArtistMatch(String ar1, String ar2) {
        if (ar1 == null || ar2 == null) {
            return true;
        }
        String lowAr1 = ar1.toLowerCase();
        String lowAr2 = ar2.toLowerCase();
        if (lowAr1.contains(lowAr2) || lowAr2.contains(lowAr1)) {
            return true;
        }
        return false;
    }

    private List<ResourceSearchResult> searchByTrack(Context context, int type, String track, String artist) {
        LrcPicList list = BaiduEngine.get(context).getSearchManager(context).getLyricPic(context, track, artist);
        if (list != null && list.getErrorCode() == 50000) {
            List<LrcPic> lrcpics = list.getItems();
            if (lrcpics != null) {
                List<ResourceSearchResult> newArrayList = Lists.newArrayList();
                for (LrcPic lp : lrcpics) {
                    boolean trackMatch = isTrackMatch(track, lp.getTitle());
                    boolean artistMatch = isArtistMatch(artist, lp.getAuthor());
                    Builder builder = null;
                    if (trackMatch && artistMatch) {
                        builder = new Builder(type);
                        builder.setAlbumId(lp.getAlbumID());
                        builder.setAlbumUrl(lp.getPicHuge());
                        builder.setArtistId(lp.getArtistID());
                        builder.setAvatarUrl(lp.getAvatarBig());
                        builder.setLyricUrl(lp.getLrclink());
                    } else if (trackMatch && type == 2) {
                        builder = new Builder(type);
                        builder.setLyricUrl(lp.getLrclink());
                    } else if (artistMatch && type == 0 && type == 1) {
                        builder = new Builder(type);
                        builder.setAlbumId(lp.getAlbumID());
                        builder.setAlbumUrl(lp.getPicHuge());
                        builder.setArtistId(lp.getArtistID());
                        builder.setAvatarUrl(lp.getAvatarBig());
                    }
                    if (builder != null) {
                        newArrayList.add(builder.build());
                    }
                }
                return newArrayList;
            }
        }
        return null;
    }

    private List<ResourceSearchResult> searchByAudioId(Context context, int type, String audio) {
        final long audioId = Long.parseLong(audio);
        final Context context2 = context;
        Music music = (Music) new BlockingRequest<Music>(new Handler(context.getMainLooper())) {

            class C05441 implements MusicListener {
                C05441() {
                }

                public void onGetMusic(Music music) {
                    C05451.this.setResult(music);
                }

                public void onGetMusicBitrate(Music arg0) {
                }
            }

            public void run() {
                BaiduEngine.get(context2).getMusicManager(context2).getMusicInfo(audioId, new C05441());
            }
        }.getResult();
        if (music == null || music.getErrorCode() != 50000 || !isUsableResult(type, music.mPicHuge, null, music.mLrcLink)) {
            return null;
        }
        Builder builder = new Builder(type);
        builder.setAlbumId(music.mAlbumId);
        builder.setAlbumUrl(music.mPicHuge);
        builder.setArtistId(music.mArtistId);
        builder.setLyricUrl(music.mLrcLink);
        return Arrays.asList(new ResourceSearchResult[]{builder.build()});
    }

    private boolean isUsableResult(int searchType, String albumUrl, String avatarUrl, String lyricUrl) {
        if (searchType == 1) {
            if (TextUtils.isEmpty(albumUrl)) {
                return false;
            }
            return true;
        } else if (searchType == 0) {
            if (TextUtils.isEmpty(avatarUrl)) {
                return false;
            }
            return true;
        } else if (searchType != 2) {
            return false;
        } else {
            if (TextUtils.isEmpty(lyricUrl)) {
                return false;
            }
            return true;
        }
    }
}
