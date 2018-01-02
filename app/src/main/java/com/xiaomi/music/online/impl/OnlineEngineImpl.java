package com.xiaomi.music.online.impl;

import android.content.Context;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.OnlineEngine;
import com.xiaomi.music.online.impl.parser.CategoryListParser;
import com.xiaomi.music.online.impl.parser.SongGroupListParser;
import com.xiaomi.music.online.impl.parser.SongGroupListParser.SongGroupParser;
import com.xiaomi.music.online.impl.parser.SongListParser;
import com.xiaomi.music.online.model.CategoryList;
import com.xiaomi.music.online.model.ResourceSearchInfo;
import com.xiaomi.music.online.model.ResourceSearchResult;
import com.xiaomi.music.online.model.Song;
import com.xiaomi.music.online.model.SongGroup;
import com.xiaomi.music.online.model.SongGroupList;
import com.xiaomi.music.online.model.SongLink;
import com.xiaomi.music.online.model.SongList;
import com.xiaomi.music.util.NetworkUtil;
import com.xiaomi.music.util.Utils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class OnlineEngineImpl implements OnlineEngine {
    JSONObject mConfig;

    public OnlineEngineImpl(Context context, JSONObject config) {
        this.mConfig = config;
    }

    public JSONObject getConfig() {
        return this.mConfig;
    }

    public Result<CategoryList> getCategoryList(Context context) {
        String url = OnlineConstants.URL_CATEGORY_LIST;
        return OnlineNetworkUtils.request(context, OnlineConstants.URL_CATEGORY_LIST, null, new CategoryListParser());
    }

    public Result<SongGroupList> getSongGroupList(Context context, String categoryId) {
        return OnlineNetworkUtils.request(context, OnlineConstants.URL_SONG_GROUP_LIST + categoryId, null, new SongGroupListParser());
    }

    public Result<SongGroup> getSongGroup(Context context, String songGroupId) {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put("size", Integer.toString(1));
        return OnlineNetworkUtils.request(context, OnlineConstants.URL_SONG_GROUP + songGroupId, nameValues, new SongGroupParser());
    }

    public Result<SongList> getSongList(Context context, String songGroupId, int limit) {
        SongList songList = new SongList(Lists.newArrayList());
        int errorCode = -1;
        int totalPage = Utils.ceil(limit, 10);
        Map<String, String> nameValues = Maps.newHashMap();
        for (int pn = 1; pn <= totalPage; pn++) {
            nameValues.clear();
            nameValues.put("size", Integer.toString(10));
            nameValues.put(OnlineConstants.KEY_PAGE_NUM, Integer.toString(pn));
            Result<SongList> songs = OnlineNetworkUtils.request(context, OnlineConstants.URL_SONG_GROUP + songGroupId, nameValues, new SongListParser());
            if (songs.mErrorCode == 1) {
                errorCode = songs.mErrorCode;
                if (((SongList) songs.mData).getContent().isEmpty()) {
                    break;
                }
                songList.update(((SongList) songs.mData).getContent(), pn);
            }
        }
        return Result.create(errorCode, songList);
    }

    public Result<Song> getSongDetail(Context context, String songId) {
        List<String> songIds = Lists.newArrayList();
        songIds.add(songId);
        Result<SongList> list = getSongsDetail(context, songIds);
        int errCode = list.mErrorCode;
        Song song = null;
        if (list.mData != null && ((SongList) list.mData).size() > 0) {
            song = (Song) ((SongList) list.mData).get(0);
        }
        return Result.create(errCode, song);
    }

    public Result<SongList> getSongsDetail(Context context, Collection<String> songIds) {
        SongList songList = new SongList(Lists.newArrayList());
        int errorCode = -1;
        int size = songIds.size();
        Iterator<String> iterator = songIds.iterator();
        List<String> ids = Lists.newArrayList();
        int start = 0;
        int pn = 1;
        while (start < size) {
            int pn2;
            int end = Math.min(size, start + 10);
            ids.clear();
            for (int i = start; i < end; i++) {
                ids.add(iterator.next());
            }
            Result<SongList> songs = OnlineNetworkUtils.request(context, OnlineConstants.URL_SONG_DETAIL + NetworkUtil.concat("/", ids), null, new SongListParser());
            if (songs.mErrorCode == 1) {
                errorCode = songs.mErrorCode;
                pn2 = pn + 1;
                songList.update(((SongList) songs.mData).getContent(), pn);
            } else {
                pn2 = pn;
            }
            start = end;
            pn = pn2;
        }
        return Result.create(errorCode, songList);
    }

    public Result<SongList> search(Context context, String key) {
        return OnlineNetworkUtils.request(context, OnlineConstants.URL_SEARCH + NetworkUtil.encode(key), null, new SongListParser());
    }

    public Result<SongList> getSongsDetailByBaiduOnlineIds(Context context, Collection<String> onlineIds) {
        SongList songList = new SongList(Lists.newArrayList());
        int errorCode = -1;
        int size = onlineIds.size();
        Iterator<String> iterator = onlineIds.iterator();
        List<String> ids = Lists.newArrayList();
        int start = 0;
        int pn = 1;
        while (start < size) {
            int pn2;
            int end = Math.min(size, start + 10);
            ids.clear();
            for (int i = start; i < end; i++) {
                ids.add(iterator.next());
            }
            Result<SongList> songs = OnlineNetworkUtils.request(context, OnlineConstants.URL_SONG_DETAIL_BY_ONLINE_ID + NetworkUtil.concat("/", ids), null, new SongListParser());
            if (songs.mErrorCode == 1) {
                errorCode = songs.mErrorCode;
                pn2 = pn + 1;
                songList.update(((SongList) songs.mData).getContent(), pn);
            } else {
                pn2 = pn;
            }
            start = end;
            pn = pn2;
        }
        return Result.create(errorCode, songList);
    }

    public Result<SongGroupList> getRecommendList(Context context) {
        String url = OnlineConstants.URL_RECOMMEND_SONG_GROUP_LIST;
        return OnlineNetworkUtils.request(context, OnlineConstants.URL_RECOMMEND_SONG_GROUP_LIST, null, new SongGroupListParser());
    }

    public Result<SongGroupList> getBillList(Context context) {
        String url = OnlineConstants.URL_BILL_SONG_GROUP_LIST;
        return OnlineNetworkUtils.request(context, OnlineConstants.URL_BILL_SONG_GROUP_LIST, null, new SongGroupListParser());
    }

    public Result<SongGroupList> getChannelList(Context context) {
        String url = OnlineConstants.URL_CHANNEL_SONG_GROUP_LIST;
        return OnlineNetworkUtils.request(context, OnlineConstants.URL_CHANNEL_SONG_GROUP_LIST, null, new SongGroupListParser());
    }

    public Result<List<ResourceSearchResult>> searchResource(Context context, ResourceSearchInfo searchInfo) {
        return ResourceEngine.getInstance().search(context, searchInfo);
    }

    public Result<List<SongLink>> getMusicLink(Context context, String cpId, String cpSongId, int bitRate) {
        return SongLinkEngine.getInstance().getMusicLinks(context, cpId, cpSongId, bitRate);
    }
}
