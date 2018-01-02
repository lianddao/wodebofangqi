package com.miui.player.plugin.onlinemusic2;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.plugin.base.RequestListener;
import com.miui.player.plugin.onlineimage.ImageProvider;
import com.miui.player.plugin.onlinelyric.LyricProvider;
import com.miui.player.plugin.onlinemusic2.Artist.ArtistDetail;
import com.miui.player.plugin.onlinemusic2.Bill.BillDetail;
import com.miui.player.plugin.onlinemusic2.Channel.ChannelDetail;
import com.miui.player.reporter.OnlinePlayStatus;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public interface OnlineMusicWorker {
    ImageProvider createImageProvider(ImageSearchInfo imageSearchInfo, int i);

    LyricProvider createLyricProvider(LyricSearchInfo lyricSearchInfo);

    String getIdentifyForAlbum(String str);

    String getIdentifyForArtist(String str, int i, int i2);

    String getIdentifyForBill(String[] strArr, int i, int i2);

    String getIdentifyForChannel(String str, int i, int i2);

    String getIdentifyForSearch(String str, int i, int i2);

    Bitmap getLogo();

    boolean postLocalPlayStatus(Date date, int i, String str);

    boolean postOnlinePlayStatus(Context context, OnlinePlayStatus onlinePlayStatus, String str);

    boolean postUserStart(Date date, String str);

    AudioList queryAudio(Context context, String str, int i, int i2, RequestListener<AudioSearchResult> requestListener);

    AudioID3Info queryAudioID3(Context context, String str);

    SearchSuggestion queryAudioSuggestion(String str, RequestListener<SearchSuggestion> requestListener);

    Pair<Album, AudioList> requestAlbum(String str, RequestListener<Pair<Album, AudioList>> requestListener);

    AlbumList requestAlbumList(int i, int i2, RequestListener<AlbumList> requestListener);

    AlbumList requestAlbumListOfArtist(String str, int i, int i2, RequestListener<AlbumList> requestListener);

    Pair<ArtistDetail, AudioList> requestArtistDetail(String str, RequestListener<Pair<ArtistDetail, AudioList>> requestListener);

    ArtistList requestArtistList(int i, int i2, int i3, RequestListener<ArtistList> requestListener);

    Pair<AudioDetail, List<AudioLink>> requestAudioDetail(String str, int i, RequestListener<Pair<AudioDetail, List<AudioLink>>> requestListener);

    Pair<AudioDetail, List<AudioLink>> requestAudioDetail(String str, RequestListener<Pair<AudioDetail, List<AudioLink>>> requestListener);

    AudioList requestAudioListOfAlbum(String str, RequestListener<AudioList> requestListener);

    AudioList requestAudioListOfArtist(String str, int i, int i2, RequestListener<AudioList> requestListener);

    List<AudioList> requestAudioListOfBill(String[] strArr, int i, int i2, RequestListener<List<AudioList>> requestListener);

    AudioList requestAudioListOfChannel(String str, int i, int i2, RequestListener<AudioList> requestListener);

    AudioList requestAudioListOfGroup(Context context, String str, int i, int i2, RequestListener<AudioList> requestListener);

    List<Pair<BillDetail, AudioList>> requestBillDetails(String[] strArr, int i, int i2, RequestListener<List<Pair<BillDetail, AudioList>>> requestListener);

    BillList requestBillList(RequestListener<BillList> requestListener);

    Pair<ChannelDetail, AudioList> requestChannelDetail(String str, int i, int i2, RequestListener<Pair<ChannelDetail, AudioList>> requestListener);

    ChannelList requestChannelList(RequestListener<ChannelList> requestListener);

    InputStream requestStream(String str);
}
