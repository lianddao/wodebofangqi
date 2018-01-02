package com.songbirdnest.database.analytics;

public class Property {
    protected long event_id;
    protected long id;
    protected String key;
    protected String value;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEventId() {
        return this.event_id;
    }

    public void setEventId(long event_id) {
        this.event_id = event_id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
