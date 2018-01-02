package com.songbirdnest.database.cookies;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BasicClientCookie2;

public class SoundboardCookie extends BasicClientCookie2 {
    protected long id;

    public SoundboardCookie(String name, String value) {
        super(name, value);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void fillCookie(Cookie cookie) {
        if (cookie instanceof BasicClientCookie) {
            BasicClientCookie basicClientCookie = (BasicClientCookie) cookie;
            setComment(basicClientCookie.getComment());
            setCommentURL(basicClientCookie.getCommentURL());
            setDomain(basicClientCookie.getDomain());
            setPath(basicClientCookie.getPath());
            setExpiryDate(basicClientCookie.getExpiryDate());
            setVersion(basicClientCookie.getVersion());
            setSecure(basicClientCookie.isSecure());
        }
    }
}
