package com.miui.player.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.util.Pair;
import com.baidu.music.download.DownloadStatus;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.Audio.AudioOutline;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.plugin.PlugInManager;
import com.miui.player.plugin.base.Parser;
import com.miui.player.plugin.base.PlugInInterface;
import com.miui.player.plugin.base.RequestListener;
import com.miui.player.plugin.onlineimage.ImageProvider;
import com.miui.player.plugin.onlinelyric.LyricProvider;
import com.miui.player.plugin.onlinemusic2.Album;
import com.miui.player.plugin.onlinemusic2.AlbumList;
import com.miui.player.plugin.onlinemusic2.Artist.ArtistDetail;
import com.miui.player.plugin.onlinemusic2.ArtistList;
import com.miui.player.plugin.onlinemusic2.AudioID3Info;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.plugin.onlinemusic2.AudioSearchResult;
import com.miui.player.plugin.onlinemusic2.Bill.BillDetail;
import com.miui.player.plugin.onlinemusic2.BillList;
import com.miui.player.plugin.onlinemusic2.ChannelList;
import com.miui.player.plugin.onlinemusic2.OnlineMusicPlugIn;
import com.miui.player.plugin.onlinemusic2.OnlineMusicWorker;
import com.miui.player.plugin.onlinemusic2.SearchSuggestion;
import com.miui.player.reporter.IPlayerReporter;
import com.miui.player.reporter.OnlinePlayStatus;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.MusicAnalyticsUtils;
import com.miui.player.util.StorageCache;
import com.miui.player.util.Utils;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import miui.cache.RequestManager;
import miui.cache.RequestManager.Request;
import miui.provider.MusicSearchProvider.MusicMeta;
import miui.util.ImageUtils;
import miui.util.InputStreamLoader;

public class OnlineMusicProxy {
    public static final int OPT_FROM_ALL = 3;
    public static final int OPT_FROM_CACHE = 1;
    public static final int OPT_FROM_NETWORK = 2;
    public static final int PAGE_NUM = 1;
    public static final int PAGE_SIZE = 50;
    static final String TAG = OnlineMusicProxy.class.getName();
    private static RequestManager<String, AudioList, String> sAudioListManager = null;

    public interface CacheListener<D> {
        void onCacheLoaded(D d);
    }

    private static class CacheWorker<T> implements RequestListener<T> {
        private final WeakReference<CacheListener<T>> mCacheListenerRef;
        private final int mRequestOpt;

        public CacheWorker(CacheListener<T> l, int opt) {
            this.mCacheListenerRef = new WeakReference(l);
            this.mRequestOpt = opt;
        }

        public void onFinished(String key, String raw, boolean success) {
            if (success && key != null && raw != null && this.mCacheListenerRef != null && ((CacheListener) this.mCacheListenerRef.get()) != null) {
                StorageCache.saveString(NetworkUtil.encode(key), StorageCache.TYPE_ONLINE_LIST, raw);
            }
        }

        public boolean onPrepared(String key, Parser<T, String> parser) {
            if (key == null || parser == null || this.mCacheListenerRef == null) {
                return false;
            }
            if ((this.mRequestOpt & 1) != 0) {
                CacheListener<T> l = (CacheListener) this.mCacheListenerRef.get();
                if (l != null) {
                    String s = StorageCache.readString(NetworkUtil.encode(key), StorageCache.TYPE_ONLINE_LIST);
                    T cached = null;
                    if (s != null) {
                        try {
                            cached = parser.parse(s);
                        } catch (Exception e) {
                            Log.e(OnlineMusicProxy.TAG, "onPrepare parse error!", e);
                        }
                    } else {
                        cached = null;
                    }
                    l.onCacheLoaded(cached);
                }
            }
            if ((this.mRequestOpt & 2) != 0) {
                return true;
            }
            return false;
        }
    }

    public static class PlayerReporter implements IPlayerReporter {
        public boolean postUserStart(Context context, Date date) {
            OnlineMusicWorker worker = OnlineMusicProxy.getWorker(context);
            if (worker != null) {
                return worker.postUserStart(date, Utils.getIMEI());
            }
            return false;
        }

        public boolean postLocalPlayStatus(Context context, Date date, int count) {
            OnlineMusicWorker worker = OnlineMusicProxy.getWorker(context);
            if (worker != null) {
                return worker.postLocalPlayStatus(date, count, Utils.getIMEI());
            }
            return false;
        }

        public boolean postOnlinePlayStatus(Context context, OnlinePlayStatus status) {
            OnlineMusicWorker worker = OnlineMusicProxy.getWorker(context);
            if (worker != null) {
                return worker.postOnlinePlayStatus(MusicApplication.getApplication(), status, Utils.getIMEI());
            }
            return false;
        }
    }

    public static RequestManager<String, AudioList, String> getAudioListRequestManager(Context context) {
        synchronized (OnlineMusicProxy.class) {
            if (sAudioListManager == null) {
                sAudioListManager = RequestManager.create(context.getResources().getInteger(C0329R.integer.online_audio_list_cache_size), null);
                sAudioListManager.setup(true);
            }
        }
        return sAudioListManager;
    }

    public static boolean request(Context context, Request<String, AudioList, String> r) {
        return getAudioListRequestManager(context).request(r);
    }

    public static Pair<AudioDetail, List<AudioLink>> requestAudioDetail(Context context, String audioId, CacheListener<Pair<AudioDetail, List<AudioLink>>> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestAudioDetail(audioId, newCacheWorker(l, opt));
        }
        return null;
    }

    public static Pair<AudioDetail, List<AudioLink>> requestAudioDetail(Context context, String audioId, int bitRate, CacheListener<Pair<AudioDetail, List<AudioLink>>> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestAudioDetail(audioId, bitRate, newCacheWorker(l, opt));
        }
        return null;
    }

    public static BillList requestBillList(Context context, CacheListener<BillList> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestBillList(newCacheWorker(l, opt));
        }
        return null;
    }

    public static String getUrlForBill(Context context, String[] types, int pageNum, int pageSize) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.getIdentifyForBill(types, pageNum, pageSize);
        }
        return null;
    }

    public static List<Pair<BillDetail, AudioList>> requestBillDetail(Context context, String[] types, int pageNum, int pageSize, CacheListener<List<Pair<BillDetail, AudioList>>> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestBillDetails(types, pageNum, pageSize, newCacheWorker(l, opt));
        }
        return null;
    }

    public static List<AudioList> requestAudioListOfBill(Context context, String[] types, int pageNum, int pageSize, CacheListener<List<AudioList>> l, int opt) {
        OnlineMusicWorker worker;
        String[] arr$ = types;
        int len$ = arr$.length;
        int i$ = 0;
        while (i$ < len$) {
            String type = arr$[i$];
            if (type == null || !type.trim().equals("2")) {
                i$++;
            } else {
                if (pageSize >= DownloadStatus.STATUS_URL_NOT_FOUND) {
                    pageSize = DownloadStatus.STATUS_URL_NOT_FOUND;
                }
                worker = getWorker(context);
                if (worker == null) {
                    return worker.requestAudioListOfBill(types, pageNum, pageSize, newCacheWorker(l, opt));
                }
                return null;
            }
        }
        worker = getWorker(context);
        if (worker == null) {
            return null;
        }
        return worker.requestAudioListOfBill(types, pageNum, pageSize, newCacheWorker(l, opt));
    }

    public static AudioList requestAudioListOfGroup(Context context, String key, int pageNum, int pageSize, CacheListener<AudioList> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker == null) {
            return null;
        }
        return worker.requestAudioListOfGroup(context, key, pageNum, pageSize, newCacheWorker(l, opt));
    }

    public static ArtistList requestArtistList(Context context, int orderBy, int pageNum, int pageSize, CacheListener<ArtistList> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestArtistList(orderBy, pageNum, pageSize, newCacheWorker(l, opt));
        }
        return null;
    }

    public static String getUrlForArtist(Context context, String artistId, int pageNum, int pageSize) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.getIdentifyForArtist(artistId, pageNum, pageSize);
        }
        return null;
    }

    public static Pair<ArtistDetail, AudioList> requestArtistDetail(Context context, String artistId, CacheListener<Pair<ArtistDetail, AudioList>> l, int opt) {
        OnlineMusicWorker plugIn = getWorker(context);
        if (plugIn != null) {
            return plugIn.requestArtistDetail(artistId, newCacheWorker(l, opt));
        }
        return null;
    }

    public static AudioList requestAudioListOfArtist(Context context, String artistId, int pageNum, int pageSize, CacheListener<AudioList> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestAudioListOfArtist(artistId, pageNum, pageSize, newCacheWorker(l, opt));
        }
        return null;
    }

    public static AlbumList requestAlbumList(Context context, int pageNum, int pageSize, CacheListener<AlbumList> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestAlbumList(pageNum, pageSize, newCacheWorker(l, opt));
        }
        return null;
    }

    public static AlbumList requestAlbumListOfArtist(Context context, String artistId, int pageNum, int pageSize, CacheListener<AlbumList> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestAlbumListOfArtist(artistId, pageNum, pageSize, newCacheWorker(l, opt));
        }
        return null;
    }

    public static String getUrlForAlbum(Context context, String albumId) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.getIdentifyForAlbum(albumId);
        }
        return null;
    }

    public static Pair<Album, AudioList> requestAlbum(Context context, String albumId, CacheListener<Pair<Album, AudioList>> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestAlbum(albumId, newCacheWorker(l, opt));
        }
        return null;
    }

    public static AudioList requestAudioListOfAlbum(Context context, String albumId, CacheListener<AudioList> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestAudioListOfAlbum(albumId, newCacheWorker(l, opt));
        }
        return null;
    }

    public static ChannelList requestChannelList(Context context, CacheListener<ChannelList> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestChannelList(newCacheWorker(l, opt));
        }
        return null;
    }

    public static AudioList requestAudioListOfChannel(Context context, String channelId, int pageNum, int pageSize, CacheListener<AudioList> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestAudioListOfChannel(channelId, pageNum, pageSize, newCacheWorker(l, opt));
        }
        return null;
    }

    public static String getUrlForChannel(Context context, String channelId, int pageNum, int pageSize) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.getIdentifyForChannel(channelId, pageNum, pageSize);
        }
        return null;
    }

    public static String getUrlForSearch(Context context, String keywords, int pageNum, int pageSize) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.getIdentifyForSearch(keywords, pageNum, pageSize);
        }
        return null;
    }

    public static AudioList queryAudio(Context context, String keywords, int pageNum, int pageSize, CacheListener<AudioSearchResult> l, int opt) {
        MusicAnalyticsUtils.trackOnlineSearch(keywords);
        OnlineMusicWorker worker = getWorker(context);
        if (worker == null) {
            return null;
        }
        return worker.queryAudio(context, keywords, pageNum, pageSize, newCacheWorker(l, opt));
    }

    public static SearchSuggestion queryAudioSuggestion(Context context, String keywords, CacheListener<SearchSuggestion> l, int opt) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.queryAudioSuggestion(keywords, newCacheWorker(l, opt));
        }
        return null;
    }

    public static InputStream requestStream(Context context, String url) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.requestStream(url);
        }
        return null;
    }

    public static Bitmap requestBitmap(Context context, String url, int w, int h) {
        String key = NetworkUtil.encode(url);
        File f = StorageCache.peekFile(key, null);
        Bitmap bm = null;
        if (f != null) {
            bm = ImageUtils.getBitmap(new InputStreamLoader(f.getAbsolutePath()), w, h);
        }
        if (bm != null) {
            return bm;
        }
        InputStream is = requestStream(context, url);
        if (is != null) {
            f = StorageCache.saveInputStream(key, null, is);
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        if (f != null) {
            return ImageUtils.getBitmap(new InputStreamLoader(f.getAbsolutePath()), w, h);
        }
        return bm;
    }

    public static String getProviderName(Context context) {
        PlugInInterface pii = PlugInManager.instance(2).getPlugInInterface();
        return pii != null ? pii.getName() : null;
    }

    public static Bitmap getProviderLogo(Context context) {
        OnlineMusicWorker worker = getWorker(context);
        Bitmap logo = null;
        if (worker != null) {
            logo = worker.getLogo();
        }
        if (logo == null) {
            return ((BitmapDrawable) context.getResources().getDrawable(C0329R.drawable.online_music_logo)).getBitmap();
        }
        return logo;
    }

    public static LyricProvider createLyricProvider(Context context, LyricSearchInfo searchInfo) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.createLyricProvider(searchInfo);
        }
        return null;
    }

    public static ImageProvider createImageProvider(Context context, ImageSearchInfo searchInfo, int type) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.createImageProvider(searchInfo, type);
        }
        return null;
    }

    public static Audio newAudio(MusicMeta meta) {
        if (meta != null) {
            return newAudio(meta.mOnlineId, meta.mTitle, meta.mArtistName, meta.mAlbumName);
        }
        return null;
    }

    public static Audio newAudio(String id, String title, String ar, String al) {
        if (id == null || title == null) {
            return null;
        }
        AudioOutline outline = new AudioOutline(id, title);
        AudioDetail detail = new AudioDetail();
        detail.mArtistName = ar;
        detail.mAlbumName = al;
        Audio audio = new Audio(outline);
        audio.mDetail = detail;
        return audio;
    }

    public static AudioID3Info queryAudioID3(Context context, String path) {
        OnlineMusicWorker worker = getWorker(context);
        if (worker != null) {
            return worker.queryAudioID3(context, path);
        }
        return null;
    }

    public static OnlineMusicWorker getWorker(Context context) {
        PlugInInterface pii = PlugInManager.instance(2).getPlugInInterface();
        if (pii instanceof OnlineMusicPlugIn) {
            return ((OnlineMusicPlugIn) pii).getWorker();
        }
        return null;
    }

    private static <T> RequestListener<T> newCacheWorker(CacheListener<T> l, int opt) {
        return new CacheWorker(l, opt);
    }
}
