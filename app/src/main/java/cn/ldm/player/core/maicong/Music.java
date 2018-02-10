package cn.ldm.player.core.maicong;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by LDM on 2018.02.10.0010.
 */

public class Music {

    private static final String TAG = Music.class.getSimpleName();

    // 获取音频信息 - 关键词搜索
    public void mc_get_song_by_name(String query, String site, int page) {
        if (query == null || query.isEmpty()) {
            return;
        }

    }

//    JSONObject netease=new JSONObject()

    // 音频数据接口地址
    public void mc_song_urls(String value, String type, String site, int page) {
        if (value == null || value.isEmpty()) {
            return;
        }
        String query = type == "query" ? value : "";
        String songid = (type == "songid" || type == "lrc") ? value : "";
        try {
            JSONArray radio_search_urls = new JSONArray("");
        } catch (Exception ex) {
            Log.e(TAG, "mc_song_urls: " + ex.toString());
        }
    }

    public void encode_netease_data(String data){
        String key="7246674226682325323F5E6544673A51";
//        String data=
    }
}
