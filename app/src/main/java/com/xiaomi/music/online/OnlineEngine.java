package com.xiaomi.music.online;

import android.content.Context;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.model.CategoryList;
import com.xiaomi.music.online.model.ResourceSearchInfo;
import com.xiaomi.music.online.model.ResourceSearchResult;
import com.xiaomi.music.online.model.Song;
import com.xiaomi.music.online.model.SongGroup;
import com.xiaomi.music.online.model.SongGroupList;
import com.xiaomi.music.online.model.SongLink;
import com.xiaomi.music.online.model.SongList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

public interface OnlineEngine {
    Result<SongGroupList> getBillList(Context context);

    Result<CategoryList> getCategoryList(Context context);

    Result<SongGroupList> getChannelList(Context context);

    JSONObject getConfig();

    Result<List<SongLink>> getMusicLink(Context context, String str, String str2, int i);

    Result<SongGroupList> getRecommendList(Context context);

    Result<Song> getSongDetail(Context context, String str);

    Result<SongGroup> getSongGroup(Context context, String str);

    Result<SongGroupList> getSongGroupList(Context context, String str);

    Result<SongList> getSongList(Context context, String str, int i);

    Result<SongList> getSongsDetail(Context context, Collection<String> collection);

    Result<SongList> getSongsDetailByBaiduOnlineIds(Context context, Collection<String> collection);

    Result<SongList> search(Context context, String str);

    Result<List<ResourceSearchResult>> searchResource(Context context, ResourceSearchInfo resourceSearchInfo);
}
