package cn.ldm.player.core.maicong;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedOutputStream;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by LDM on 2018.02.10.0010.
 */

public class Music {

    private static final String TAG = Music.class.getSimpleName();

    private static final String SEARCH_URL__XIA_MI = "{\n" +
            "  \"xiami\": {\n" +
            "    \"method\": \"GET\",\n" +
            "    \"url\": \"http://api.xiami.com/web\",\n" +
            "    \"referer\": \"http://m.xiami.com\",\n" +
            "    \"proxy\": \"false\",\n" +
            "    \"body\": {\n" +
            "      \"key\": \"abc\",\n" +
            "      \"v\": \"2.0\",\n" +
            "      \"app_key\": 1,\n" +
            "      \"r\": \"search/songs\",\n" +
            "      \"page\": 1,\n" +
            "      \"limit\": 10\n" +
            "    },\n" +
            "    \"user-agent\": \"Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1\"\n" +
            "  }\n" +
            "}";
    private static final String SONG_URL__XIA_MI = "{\n" +
            "  \"xiami\": {\n" +
            "    \"method\": \"GET\",\n" +
            "    \"url\": \"http://www.xiami.com/song/playlist/id/$songid/type/0/cat/json\",\n" +
            "    \"referer\": \"http://www.xiami.com\",\n" +
            "    \"proxy\": \"false\"\n" +
            "  }\n" +
            "}";


    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public String mc_curl(String... args) {
        try {
            JSONObject jsonObject = new JSONObject(args[0]);
            String url = jsonObject.getJSONObject("xiami").getString("url");
            String referer = jsonObject.getJSONObject("xiami").getString("referer");
            String agent = jsonObject.getJSONObject("xiami").getString("user-agent");
            String body = jsonObject.getJSONObject("xiami").getString("body");

            RequestBody requestBody = new FormBody.Builder()
                    .add("keyword", "abc")
                    .add("format", "json")
                    .add("page","0")
                    .add("pagesize","10")
                    .build();
//            requestBody = RequestBody.create(JSON, body);
            Request request = new Request.Builder()
                    .url("http://mobilecdn.kugou.com/api/v3/search/song")
                    .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.50 Safari/537.36")
                    .addHeader("referer", "http://m.kugou.com/v2/static/html/search.html")
                    .addHeader("proxy", "false")
                    .addHeader("X-Requested-With", "XMLHttpRequest")
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception ex) {
            Log.e(TAG, "mc_curl: " + ex.toString());
            return null;
        }
    }

    // 获取音频信息 - 关键词搜索
    public String mc_get_song_by_name(String query, String site, int page) {
        if (query == null || query.isEmpty()) {
            return "NULL";
        }
        String search_url = mc_song_urls("来生缘", "query", "xiami", 1);
        Object result = mc_curl(search_url);
        return result.toString();
    }

    //    JSONObject netease=new JSONObject()

    // 音频数据接口地址
    public String mc_song_urls(String value, String type, String site, int page) {
        if (value == null || value.isEmpty()) {
            return "";
        }
        String query = type == "query" ? value : "";
        String songid = (type == "songid" || type == "lrc") ? value : "";
        return SEARCH_URL__XIA_MI;
    }

    public void encode_netease_data(String data) {
        String key = "7246674226682325323F5E6544673A51";
        //        String data=
    }
}
