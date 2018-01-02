package com.ushareit.listenit;

import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class gnm extends TreeMap<String, String> {
    private String f14460a;
    private glg f14461b;
    private String f14462c;
    private String f14463d;
    private String f14464e;
    private String f14465f;
    private String f14466g;
    private String f14467h;
    private String f14468i;
    private String f14469j;
    private String f14470k;

    gnm() {
    }

    gnm(String str) {
        this.f14460a = str.toLowerCase();
    }

    gnm(glg com_ushareit_listenit_glg) {
        this.f14461b = com_ushareit_listenit_glg;
    }

    String m22516a() {
        put("version", String.valueOf(gxj.m23089b()));
        put("audio_md5", this.f14460a);
        return m22510b("http://listenitapi.ushareit.com/audiofile/search");
    }

    String m22520b() {
        this.f14460a = this.f14461b.m22362h().toLowerCase();
        this.f14462c = m22512c(this.f14461b.f14340h);
        this.f14463d = m22512c(this.f14461b.f14339g);
        this.f14464e = String.valueOf(this.f14461b.f14346n);
        this.f14465f = String.valueOf(this.f14461b.f14337e);
        this.f14466g = m22512c(this.f14461b.f14345m);
        this.f14467h = m22512c(this.f14461b.f14347o);
        this.f14468i = m22512c(this.f14461b.mo2562c());
        this.f14469j = String.valueOf(this.f14461b.f14344l);
        this.f14470k = String.valueOf(gxj.m23089b());
        return m22511b("http://listenitapi.ushareit.com/baseinfo/upload" + "?" + m22514e(), m22515f());
    }

    String m22521c() {
        put("audio_md5", this.f14460a);
        put("version", String.valueOf(gxj.m23089b()));
        String a = m22509a((Map) this);
        return m22511b("http://listenitapi.ushareit.com/audiofile/upload" + "?" + a, a);
    }

    String m22522d() {
        put("audio_md5", this.f14460a);
        put("version", String.valueOf(gxj.m23089b()));
        String a = m22509a((Map) this);
        return m22511b("http://listenitapi.ushareit.com/audiofile/download" + "?" + a, a);
    }

    public String m22518a(String str, int i, int i2) {
        put("method", "album.search");
        put("album", m22513d(str));
        put("page", String.valueOf(i));
        put("limit", String.valueOf(i2));
        return m22517a("http://ws.audioscrobbler.com/2.0/" + "?" + m22509a((Map) this));
    }

    public String m22519a(String str, String str2) {
        put("method", "album.getinfo");
        put("album", m22513d(str2));
        put("artist", m22513d(str));
        return m22517a("http://ws.audioscrobbler.com/2.0/" + "?" + m22509a((Map) this));
    }

    public String m22517a(String str) {
        return (str + "api_key=b2b695290653d435d1acb2903fafadbf") + "&format=json";
    }

    private String m22510b(String str) {
        String a = m22509a((Map) this);
        return m22511b(str + "?" + a, a);
    }

    private String m22509a(Map<String, String> map) {
        if (map.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append("&");
        }
        return stringBuilder.toString();
    }

    private String m22514e() {
        put("title", m22513d(this.f14468i));
        put("artist", m22513d(this.f14463d));
        put("album", m22513d(this.f14462c));
        put("genre", m22513d(this.f14466g));
        put("duration", this.f14465f);
        put("size", this.f14469j);
        put("bitrate", this.f14464e);
        put("mimetype", m22513d(this.f14467h));
        put("version", this.f14470k);
        put("audio_md5", this.f14460a);
        return m22509a((Map) this);
    }

    private String m22515f() {
        clear();
        put("title", this.f14468i);
        put("artist", this.f14463d);
        put("album", this.f14462c);
        put("genre", this.f14466g);
        put("duration", this.f14465f);
        put("size", this.f14469j);
        put("bitrate", this.f14464e);
        put("mimetype", this.f14467h);
        put("version", this.f14470k);
        put("audio_md5", this.f14460a);
        return m22509a((Map) this);
    }

    private String m22511b(String str, String str2) {
        return str + "token" + "=" + gyk.m23155b(str2 + "f1865edb52a9cb0b65c36e193fe96e908c30e98d990abce6885fed50cd205eab").toLowerCase();
    }

    private String m22512c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            switch (c) {
                case CtaButton.HEIGHT_DIPS /*38*/:
                    stringBuilder.append(" ");
                    break;
                case '\'':
                    stringBuilder.append("\\'");
                    break;
                case '=':
                    stringBuilder.append(" ");
                    break;
                default:
                    stringBuilder.append(c);
                    break;
            }
        }
        return stringBuilder.toString();
    }

    private String m22513d(String str) {
        return ezm.m18633a(str);
    }
}
