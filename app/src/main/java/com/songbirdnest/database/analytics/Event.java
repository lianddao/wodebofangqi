package com.songbirdnest.database.analytics;

import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Event {
    protected String action;
    protected String category;
    protected int count;
    protected long id;
    protected List<Property> properties = new ArrayList();

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Property> getProperties() {
        return this.properties;
    }

    public void addProperties(Map<String, String> mappedProperties) {
        if (mappedProperties != null) {
            for (String key : mappedProperties.keySet()) {
                Property property = new Property();
                property.setEventId(this.id);
                property.setKey(key);
                property.setValue((String) mappedProperties.get(key));
                this.properties.add(property);
            }
        }
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property) {
        this.properties.add(property);
    }

    public void clearProperties() {
        this.properties.clear();
    }

    public void incrementCount() {
        this.count++;
    }

    public void setJSONProperties(JSONObject jsonObject) {
        try {
            if (this.action != null) {
                jsonObject.put("action", this.action);
            }
            jsonObject.put(EventTable.COUNT, this.count);
            for (Property property : this.properties) {
                jsonObject.put(property.getKey(), property.getValue());
            }
        } catch (JSONException e) {
            Logger.error((Object) this, "Problems setting JSON Properties");
        }
    }
}
