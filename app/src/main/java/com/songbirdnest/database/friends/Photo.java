package com.songbirdnest.database.friends;

public class Photo {
    protected String facebook_id;
    protected String facebook_url;
    protected long id;
    protected long lastAccessed;
    protected String local_path;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFacebookId() {
        return this.facebook_id;
    }

    public void setFacebookId(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getFacebookURL() {
        return this.facebook_url;
    }

    public void setFacebookURL(String facebook_url) {
        this.facebook_url = facebook_url;
    }

    public String getLocalPath() {
        return this.local_path;
    }

    public void setLocalPath(String local_path) {
        this.local_path = local_path;
    }

    public long getLastAccessed() {
        return this.lastAccessed;
    }

    public void setLastAccessed(long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }
}
