package com.miui.player.plugin.onlinemusic2.baidu;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.Pair;
import com.baidu.music.audiofp.AudioFP;
import com.baidu.music.audiofp.AudioFPException;
import com.baidu.music.model.Music;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import com.miui.player.meta.Audio;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.Audio.AudioOutline;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.plugin.base.Parsers;
import com.miui.player.plugin.base.Parsers.ElementComparator;
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
import com.miui.player.plugin.onlinemusic2.Channel.ChannelDetail;
import com.miui.player.plugin.onlinemusic2.ChannelList;
import com.miui.player.plugin.onlinemusic2.OnlineMusicWorker;
import com.miui.player.plugin.onlinemusic2.SearchSuggestion;
import com.miui.player.plugin.onlinemusic2.baidu.BaiduConstants.OrderBys;
import com.miui.player.plugin.onlinemusic2.baidu.parser.AlbumListParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.AlbumListParser.AlbumParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.ArtistListParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.ArtistListParser.ArtistParser.ArtistDetailParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.AudioListParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.AudioListParser.AudioParser.AudioDetailParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.AudioListParser.AudioParser.AudioLinkListParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.BaiduNetwork;
import com.miui.player.plugin.onlinemusic2.baidu.parser.BillListParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.BillListParser.BillParser.BillDetailParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.ChannelListParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.ChannelListParser.ChannelParser.ChannelDetailParser;
import com.miui.player.plugin.onlinemusic2.baidu.parser.SearchSuggestionParser;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper;
import com.miui.player.plugin.onlinesync.TokenManager;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkManager;
import com.miui.player.reporter.OnlinePlayStatus;
import com.miui.player.ui.OnlineMusicBrowser;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.DateTimeHelper;
import com.miui.player.util.Strings;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.model.Song;
import com.xiaomi.music.online.model.SongList;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.NetworkUtil;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class BaiduWorker implements OnlineMusicWorker {
    static final String TAG = BaiduWorker.class.getName();

    class C03621 implements ElementComparator<String> {
        C03621() {
        }

        public boolean isEqual(String src) {
            return src != null && BillListParser.BILLBOARD_KEY_PATTERN.matcher(src).matches();
        }
    }

    class C03632 implements ElementComparator<String> {
        C03632() {
        }

        public boolean isEqual(String src) {
            return src != null && BillListParser.BILLBOARD_KEY_PATTERN.matcher(src).matches();
        }
    }

    class C03643 implements ElementComparator<JSONObject> {
        C03643() {
        }

        public boolean isEqual(JSONObject json) {
            return json != null && json.optInt("cid", 0) == 1;
        }
    }

    public BillList requestBillList(RequestListener<BillList> l) {
        String url = "http://openapi.baidu.com/rest/2.0/music/billboard/catalog?";
        return (BillList) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/billboard/catalog?", null, Parsers.createParserProxyForArray("bill_list", new BillListParser()), l);
    }

    public List<Pair<BillDetail, AudioList>> requestBillDetails(String[] types, int pageNum, int pageSize, RequestListener<List<Pair<BillDetail, AudioList>>> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        nameValues.put("type", Strings.concat(",", types));
        return (List) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/billboard/billlist?", nameValues, Parsers.createComposeParserProxy(new C03621(), Parsers.createPairParser(Parsers.createParserProxyForObject(OnlineMusicBrowser.TAG_BILLBOARD, new BillDetailParser()), Parsers.createParserProxyForArray("song_list", new AudioListParser()))), l);
    }

    public List<AudioList> requestAudioListOfBill(String[] types, int pageNum, int pageSize, RequestListener<List<AudioList>> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        nameValues.put("type", Strings.concat(",", types));
        return (List) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/billboard/billlist?", nameValues, Parsers.createComposeParserProxy(new C03632(), Parsers.createParserProxyForArray("song_list", new AudioListParser())), l);
    }

    public Pair<AudioDetail, List<AudioLink>> requestAudioDetail(String audioId, RequestListener<Pair<AudioDetail, List<AudioLink>>> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_AUDIO_ID, audioId);
        return (Pair) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/song/info?", nameValues, Parsers.createPairParser(Parsers.createParserProxyForObject("songinfo", new AudioDetailParser()), Parsers.createParserProxyForObject("songurl", new AudioLinkListParser())), l);
    }

    public Pair<AudioDetail, List<AudioLink>> requestAudioDetail(String audioId, int bitRate, RequestListener<Pair<AudioDetail, List<AudioLink>>> l) {
        String url;
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_AUDIO_ID, audioId);
        if (TokenManager.getAccessToken() != null) {
            url = "https://openapi.baidu.com/rest/2.0/music/song/getInfos?";
            nameValues.put("access_token", TokenManager.getAccessToken());
            nameValues.put(BaiduConstants.KEY_BIT_RATE, Integer.toString(bitRate));
        } else {
            url = "http://openapi.baidu.com/rest/2.0/music/song/info?";
        }
        return (Pair) BaiduNetwork.request(url, nameValues, Parsers.createPairParser(Parsers.createParserProxyForObject("songinfo", new AudioDetailParser()), Parsers.createParserProxyForObject("songurl", new AudioLinkListParser())), l);
    }

    public ArtistList requestArtistList(int orderBy, int pageNum, int pageSize, RequestListener<ArtistList> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        nameValues.put(BaiduConstants.KEY_ORDER, String.valueOf(OrderBys.translateToBaidu(orderBy)));
        return (ArtistList) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/artist/artistlist?", nameValues, Parsers.createParserProxyForArray("artist", new ArtistListParser()), l);
    }

    public Pair<ArtistDetail, AudioList> requestArtistDetail(String artistId, RequestListener<Pair<ArtistDetail, AudioList>> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_ARTIST_ID, artistId);
        return (Pair) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/artist/info?", nameValues, Parsers.createPairParser(new ArtistDetailParser(), null), l);
    }

    public AudioList requestAudioListOfArtist(String artistId, int pageNum, int pageSize, RequestListener<AudioList> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_ORDER, "2");
        nameValues.put(BaiduConstants.KEY_ARTIST_ID, artistId);
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        return (AudioList) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/artist/songlist?", nameValues, Parsers.createParserProxyForArray("songlist", new AudioListParser()), l);
    }

    public AlbumList requestAlbumList(int pageNum, int pageSize, RequestListener<AlbumList> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        return (AlbumList) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/plaza/recommendalbum?", nameValues, Parsers.createConverterParserProxy(new AlbumListParser(), Parsers.createConvterProxy(Parsers.createObjectTypeConverter("plaze_album_list"), Parsers.createConvterProxy(Parsers.createObjectTypeConverter("RM"), Parsers.createConvterProxy(Parsers.createObjectTypeConverter("album_list"), Parsers.createArrayTypeConverter("list"))))), l);
    }

    public AlbumList requestAlbumListOfArtist(String artistId, int pageNum, int pageSize, RequestListener<AlbumList> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        nameValues.put(BaiduConstants.KEY_ARTIST_ID, artistId);
        return (AlbumList) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/artist/albumlist?", nameValues, Parsers.createParserProxyForArray("albumlist", new AlbumListParser()), l);
    }

    public Pair<Album, AudioList> requestAlbum(String albumId, RequestListener<Pair<Album, AudioList>> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_ALBUM_ID, albumId);
        return (Pair) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/album/info?", nameValues, Parsers.createPairParser(Parsers.createParserProxyForObject("albumInfo", new AlbumParser()), Parsers.createParserProxyForArray("songlist", new AudioListParser())), l);
    }

    public AudioList requestAudioListOfAlbum(String albumId, RequestListener<AudioList> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_ALBUM_ID, albumId);
        return (AudioList) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/album/info?", nameValues, Parsers.createParserProxyForArray("songlist", new AudioListParser()), l);
    }

    public ChannelList requestChannelList(RequestListener<ChannelList> l) {
        return (ChannelList) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/radio/catalog?", null, Parsers.createConverterParserProxy(new ChannelListParser(), Parsers.createConvterProxy(Parsers.createArrayTypeConverter("catalog"), Parsers.createConvterProxy(Parsers.createElementTypeConverter(new C03643()), Parsers.createArrayTypeConverter("channellist")))), l);
    }

    public Pair<ChannelDetail, AudioList> requestChannelDetail(String channelid, int pageNum, int pageSize, RequestListener<Pair<ChannelDetail, AudioList>> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_CHANNEL_ID, channelid);
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        return (Pair) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/radio/songlist?", nameValues, Parsers.createPairParser(Parsers.createParserProxyForObject("channelinfo", new ChannelDetailParser()), Parsers.createParserProxyForObject("channelinfo", Parsers.createParserProxyForArray("songlist", new AudioListParser()))), l);
    }

    public AudioList requestAudioListOfChannel(String channelid, int pageNum, int pageSize, RequestListener<AudioList> requestListener) {
        Context context = MusicApplication.getApplication();
        return songListResultToAudioList(MusicEngine.get(context).getOnlineEngine().getSongList(context, channelid, pageSize));
    }

    public AudioList queryAudio(Context context, String keywords, int pageNum, int pageSize, RequestListener<AudioSearchResult> requestListener) {
        return songListResultToAudioList(MusicEngine.get(context).getOnlineEngine().search(context, keywords));
    }

    public SearchSuggestion queryAudioSuggestion(String keywords, RequestListener<SearchSuggestion> l) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("query", keywords);
        return (SearchSuggestion) BaiduNetwork.request("http://openapi.baidu.com/rest/2.0/music/search/suggestion?", nameValues, new SearchSuggestionParser(), l);
    }

    public LyricProvider createLyricProvider(LyricSearchInfo searchInfo) {
        return new BaiduLyricProvider(searchInfo);
    }

    public ImageProvider createImageProvider(ImageSearchInfo searchInfo, int type) {
        return new BaiduImageProvider(searchInfo);
    }

    public InputStream requestStream(String url) {
        return BaiduNetwork.requestRaw(url);
    }

    public String getIdentifyForAlbum(String albumId) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_ALBUM_ID, albumId);
        return NetworkUtil.concatAsUrl("http://openapi.baidu.com/rest/2.0/music/album/info?", nameValues);
    }

    public String getIdentifyForArtist(String artistId, int pageNum, int pageSize) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_ARTIST_ID, artistId);
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        return NetworkUtil.concatAsUrl("http://openapi.baidu.com/rest/2.0/music/artist/songlist?", nameValues);
    }

    public String getIdentifyForBill(String[] types, int pageNum, int pageSize) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        nameValues.put("type", Strings.concat(",", types));
        return NetworkUtil.concatAsUrl("http://openapi.baidu.com/rest/2.0/music/billboard/billlist?", nameValues);
    }

    public String getIdentifyForChannel(String channelid, int pageNum, int pageSize) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(BaiduConstants.KEY_CHANNEL_ID, channelid);
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        return NetworkUtil.concatAsUrl("http://openapi.baidu.com/rest/2.0/music/radio/songlist?", nameValues);
    }

    public String getIdentifyForSearch(String keywords, int pageNum, int pageSize) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("query", keywords);
        nameValues.put("page_no", String.valueOf(pageNum));
        nameValues.put("page_size", String.valueOf(pageSize));
        return NetworkUtil.concatAsUrl("http://openapi.baidu.com/rest/2.0/music/search/common?", nameValues);
    }

    public Bitmap getLogo() {
        return null;
    }

    public boolean postUserStart(Date date, String imei) {
        StringBuilder sb = new StringBuilder(String.format(BaiduConstants.STASTICS_LOG, new Object[]{imei, "peoplecount"}));
        sb.append("&date=").append(DateTimeHelper.toString(date, "yyyy-MM-dd"));
        return BaiduNetwork.touch(sb.toString());
    }

    public boolean postLocalPlayStatus(Date date, int count, String imei) {
        StringBuilder sb = new StringBuilder(String.format(BaiduConstants.STASTICS_LOG, new Object[]{imei, "localPlayCount"}));
        sb.append("&songCount=").append(count).append("&date=").append(DateTimeHelper.toString(date, "yyyy-MM-dd"));
        return BaiduNetwork.touch(sb.toString());
    }

    public boolean postOnlinePlayStatus(Context context, OnlinePlayStatus status, String imei) {
        int err = status.mError;
        if (err == 0 && AccountPermissionHelper.allowUHDMusic()) {
            MusicEngine.get(context).getStatEngine().uploadPlayDuration(context, status.mPlayDurationInMs / 1000);
        }
        String type;
        StringBuilder sb;
        if (err >= 0 && err < 1000) {
            int flag;
            if (err == 1) {
                type = "connectiong";
                flag = 2;
            } else if (err == 0) {
                type = "playend";
                flag = 2;
            } else if (err == 3) {
                type = "60play";
                flag = 0;
            } else if (err == 2) {
                type = "playstart";
                flag = 0;
            } else {
                type = "linkfail";
                flag = 1;
            }
            sb = new StringBuilder(String.format(BaiduConstants.STASTICS_LOG, new Object[]{imei, type}));
            sb.append("&songId=").append(status.mOnlineId).append("&link=").append(NetworkUtil.encode(status.mURL)).append("&bitrate=").append(status.mBitrate);
            if (flag == 1) {
                sb.append("&error=").append(status.mError);
            } else if (flag == 2) {
                sb.append("&auto=").append(status.mAutoSkip ? 1 : 0).append("&playduration=").append(status.mPlayDurationInMs).append("&ct=").append(status.mConnectTimeInMs).append("&bc=").append(status.mBufferCount).append("&st=").append(status.mStayTimeInMs);
            }
            return BaiduNetwork.touch(sb.toString());
        } else if (err < 1000 || err > OnlinePlayStatus.STATUS_DOWNLOAD_END) {
            Log.e(TAG, "post online status failed with status=" + status.mError);
            return false;
        } else {
            int downloadFailed;
            type = "dl";
            if (err == 1002) {
                downloadFailed = 1;
            } else {
                downloadFailed = 0;
            }
            sb = new StringBuilder(String.format(BaiduConstants.STASTICS_LOG, new Object[]{imei, "dl"}));
            sb.append("&status=").append(downloadFailed);
            return BaiduNetwork.touch(sb.toString());
        }
    }

    public AudioID3Info queryAudioID3(Context context, String path) {
        MusicLog.m395d(TAG, "audio path=" + path);
        if (!BaiduSdkManager.initSdkEnvironment()) {
            return null;
        }
        try {
            Music music = new AudioFP(context).searchMusic(path);
            if (music != null && music.getErrorCode() == 50000) {
                AudioID3Info audioID3Info = new AudioID3Info();
                audioID3Info.mOnlineId = music.mId;
                audioID3Info.mTitle = music.mTitle;
                audioID3Info.mArtistName = music.mArtist;
                audioID3Info.mLyricURL = music.mLrcLink;
                audioID3Info.mVersion = music.mVersion;
                audioID3Info.mAlbumName = music.mAlbumTitle;
                return audioID3Info;
            }
        } catch (AudioFPException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AudioList requestAudioListOfGroup(Context context, String key, int pageNum, int pageSize, RequestListener<AudioList> requestListener) {
        return songListResultToAudioList(MusicEngine.get(context).getOnlineEngine().getSongList(context, key, pageSize));
    }

    public static AudioList songListResultToAudioList(Result<SongList> r) {
        if (r.mErrorCode != 1 || r.mData == null || !((SongList) r.mData).isValid()) {
            return null;
        }
        List<Audio> audios = Lists.newArrayList();
        for (Song s : ((SongList) r.mData).getContent()) {
            audios.add(songToAudio(s));
        }
        return new AudioList(audios);
    }

    static Audio songToAudio(Song song) {
        AudioOutline outline = new AudioOutline(song.mId, song.mName);
        AudioDetail detail = new AudioDetail();
        detail.mArtistName = song.mArtistName;
        detail.mAlbumName = song.mAlbumName;
        detail.mCpId = song.mCpId;
        detail.mCpSongId = song.mCpSongId;
        detail.mDurationInSec = song.mDuration;
        Audio r = new Audio(outline);
        r.mDetail = detail;
        return r;
    }
}
