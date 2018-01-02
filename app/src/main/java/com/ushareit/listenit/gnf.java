package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gnf {
    public static List<glg> m22471a(String str, int i) {
        String b = gno.m22524a().m22527b(str, i);
        List<glg> list = null;
        try {
            exw.m18454c("BusinessRequest", "searchNetSong request url:" + b);
            gnl a = gng.m22487a(b);
            if (a != null && a.m22508b()) {
                exw.m18454c("BusinessRequest", "searchNetSong response content:" + a);
                list = m22482d(a.m22507a());
            }
        } catch (Throwable e) {
            exw.m18450b("BusinessRequest", "searchNetSong has a error", e);
        }
        return list;
    }

    public static boolean m22476a(String str) {
        boolean z = false;
        String a = new gnm(str).m22516a();
        try {
            exw.m18454c("BusinessRequest", "searchAudioFile request url:" + a);
            gnl a2 = gng.m22487a(a);
            if (a2 != null && a2.m22508b()) {
                exw.m18454c("BusinessRequest", "searchAudioFile response content:" + a2);
                z = m22483e(a2.m22507a());
            }
        } catch (Throwable e) {
            exw.m18450b("BusinessRequest", "searchAudioFile has a error", e);
        }
        return z;
    }

    public static boolean m22474a(glg com_ushareit_listenit_glg) {
        boolean z = false;
        String b = new gnm(com_ushareit_listenit_glg).m22520b();
        try {
            exw.m18454c("BusinessRequest", "uploadBasicInfo request url:" + b);
            gnl b2 = gng.m22491b(b);
            if (b2 != null && b2.m22508b()) {
                exw.m18454c("BusinessRequest", "uploadBasicInfo response content:" + b2);
                z = m22483e(b2.m22507a());
            }
        } catch (Throwable e) {
            exw.m18450b("BusinessRequest", "uploadBasicInfo has a error", e);
        }
        return z;
    }

    public static boolean m22478a(String str, eyh com_ushareit_listenit_eyh, gnh com_ushareit_listenit_gnh) {
        String c = new gnm(str).m22521c();
        try {
            exw.m18454c("BusinessRequest", "uploadAudioFile request url:" + c);
            gnl a = gng.m22488a(c, com_ushareit_listenit_eyh, com_ushareit_listenit_gnh);
            if (a == null || !a.m22508b()) {
                return false;
            }
            boolean e = m22483e(a.m22507a());
            exw.m18454c("BusinessRequest", "uploadAudioFile response content:" + a);
            return e;
        } catch (Throwable e2) {
            exw.m18450b("BusinessRequest", "uploadAudioFile has a error", e2);
            return false;
        }
    }

    public static boolean m22477a(String str, int i, String str2, gnh com_ushareit_listenit_gnh) {
        String d = new gnm(str).m22522d();
        try {
            exw.m18454c("BusinessRequest", "downloadAudioFile request url:" + d);
            gnk a = gng.m22486a(d, str2, str, i, com_ushareit_listenit_gnh);
            if (a == null) {
                return false;
            }
            boolean b = a.m22504b();
            exw.m18454c("BusinessRequest", "downloadAudioFile response content:" + a);
            return b;
        } catch (Throwable e) {
            exw.m18450b("BusinessRequest", "downloadAudioFile has a error", e);
            return false;
        }
    }

    public static eyh m22470a(String str, String str2) {
        eyh com_ushareit_listenit_eyh = null;
        try {
            exw.m18454c("BusinessRequest", "downloadImage request url:" + str);
            gnk a = gng.m22485a(str, str2);
            exw.m18454c("BusinessRequest", "downloadImage: response=" + a);
            switch (a.m22503a()) {
                case 200:
                    com_ushareit_listenit_eyh = a.m22505c();
                    break;
            }
        } catch (Throwable e) {
            exw.m18450b("BusinessRequest", "downloadImage has a error", e);
        }
        return com_ushareit_listenit_eyh;
    }

    public static List<gnj> m22472a(String str, int i, int i2) {
        List<gnj> list = null;
        String a = new gnm().m22518a(str, i, i2);
        try {
            exw.m18454c("BusinessRequest", "searchAlbumInfo request url:" + a);
            gnl b = gng.m22491b(a);
            if (b != null && b.m22508b()) {
                exw.m18454c("BusinessRequest", "searchAlbumInfo: response=" + b);
                Object a2 = b.m22507a();
                if (!TextUtils.isEmpty(a2)) {
                    list = m22480b(a2);
                }
            }
        } catch (Throwable e) {
            exw.m18450b("BusinessRequest", "searchAlbumInfo has a error", e);
        }
        return list;
    }

    public static gnj m22479b(String str, String str2) {
        gnj com_ushareit_listenit_gnj = null;
        String a = new gnm().m22519a(str, str2);
        try {
            exw.m18443a("BusinessRequest", "getAlbumInfo request url:" + a);
            gnl b = gng.m22491b(a);
            if (b != null && b.m22508b()) {
                exw.m18443a("BusinessRequest", "getAlbumInfo: response=" + b);
                Object a2 = b.m22507a();
                if (!TextUtils.isEmpty(a2)) {
                    com_ushareit_listenit_gnj = m22481c(a2);
                }
            }
        } catch (Exception e) {
            exw.m18457e("BusinessRequest", "getAlbumInfo has a error=" + e.getMessage());
        }
        return com_ushareit_listenit_gnj;
    }

    private static List<gnj> m22480b(String str) {
        List<gnj> arrayList;
        Throwable e;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("results");
            if (jSONObject.getInt("opensearch:totalResults") <= 0) {
                return null;
            }
            arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("albummatches").getJSONArray("album");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    gnj com_ushareit_listenit_gnj = new gnj();
                    com_ushareit_listenit_gnj.f14449a = jSONObject2.getString("name");
                    com_ushareit_listenit_gnj.f14450b = jSONObject2.getString("artist");
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("image");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        m22473a(com_ushareit_listenit_gnj, jSONArray2.getJSONObject(i2));
                    }
                    if (m22475a(com_ushareit_listenit_gnj)) {
                        arrayList.add(com_ushareit_listenit_gnj);
                    }
                }
                return arrayList;
            } catch (JSONException e2) {
                e = e2;
                exw.m18450b("BusinessRequest", "Json parsing error", e);
                return arrayList;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            arrayList = null;
            e = th;
            exw.m18450b("BusinessRequest", "Json parsing error", e);
            return arrayList;
        }
    }

    private static gnj m22481c(String str) {
        gnj com_ushareit_listenit_gnj = new gnj();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("album")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("album");
                JSONArray jSONArray = jSONObject2.getJSONArray("image");
                for (int i = 0; i < jSONArray.length(); i++) {
                    m22473a(com_ushareit_listenit_gnj, jSONArray.getJSONObject(i));
                }
                com_ushareit_listenit_gnj.f14449a = jSONObject2.getString("name");
                com_ushareit_listenit_gnj.f14450b = jSONObject2.getString("artist");
                return com_ushareit_listenit_gnj;
            }
            Object string = jSONObject.getString("message");
            if (TextUtils.isEmpty(string)) {
                return com_ushareit_listenit_gnj;
            }
            exw.m18454c("BusinessRequest", string);
            return com_ushareit_listenit_gnj;
        } catch (Throwable e) {
            exw.m18450b("BusinessRequest", "Json parsing error", e);
            return null;
        }
    }

    private static List<glg> m22482d(String str) {
        List<glg> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("collection")) {
                return arrayList;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("collection");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                glg com_ushareit_listenit_glg = new glg();
                com_ushareit_listenit_glg.f14338f = jSONObject2.getString("title");
                com_ushareit_listenit_glg.f14339g = jSONObject2.getJSONObject("user").getString("username");
                com_ushareit_listenit_glg.f14343k = jSONObject2.getString("artwork_url");
                if (com_ushareit_listenit_glg.f14343k != null && com_ushareit_listenit_glg.f14343k.contains("-large.jpg")) {
                    com_ushareit_listenit_glg.f14343k = com_ushareit_listenit_glg.f14343k.replace("-large.jpg", "-t300x300.jpg");
                }
                com_ushareit_listenit_glg.f14337e = jSONObject2.getInt("duration");
                String str2 = jSONObject2.getString("uri") + "/stream";
                com_ushareit_listenit_glg.f14342j = gyn.m23261q(str2);
                com_ushareit_listenit_glg.f14354v = jSONObject2.getInt("playback_count");
                com_ushareit_listenit_glg.f14351s = (long) jSONObject2.getInt("likes_count");
                if (frg.m20692a(str2)) {
                    com_ushareit_listenit_glg.f14334b = frg.m20693b(str2);
                } else {
                    com_ushareit_listenit_glg.f14334b = gvj.m22916c();
                    frg.m20697c(com_ushareit_listenit_glg);
                }
                arrayList.add(com_ushareit_listenit_glg);
            }
            return arrayList;
        } catch (Throwable e) {
            exw.m18450b("BusinessRequest", "Json parsing error", e);
            return null;
        }
    }

    private static boolean m22483e(String str) {
        return !fbb.m18758a(str) && str.equals("true");
    }

    private static boolean m22475a(gnj com_ushareit_listenit_gnj) {
        return (TextUtils.isEmpty(com_ushareit_listenit_gnj.f14451c) && TextUtils.isEmpty(com_ushareit_listenit_gnj.f14452d) && TextUtils.isEmpty(com_ushareit_listenit_gnj.f14453e) && TextUtils.isEmpty(com_ushareit_listenit_gnj.f14454f)) ? false : true;
    }

    private static void m22473a(gnj com_ushareit_listenit_gnj, JSONObject jSONObject) {
        String string = jSONObject.getString("#text");
        String string2 = jSONObject.getString("size");
        if (string2.equals("small")) {
            com_ushareit_listenit_gnj.f14451c = string;
        } else if (string2.equals("medium")) {
            com_ushareit_listenit_gnj.f14452d = string;
        } else if (string2.equals("large")) {
            com_ushareit_listenit_gnj.f14453e = string;
        } else if (string2.equals("extralarge")) {
            com_ushareit_listenit_gnj.f14454f = string;
        }
    }
}
