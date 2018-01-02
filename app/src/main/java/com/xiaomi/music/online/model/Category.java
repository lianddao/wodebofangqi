package com.xiaomi.music.online.model;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = 1;
    public final String mDescription;
    public final String mId;
    public final String mName;

    public Category(String id, String name, String description) {
        this.mId = id;
        this.mName = name;
        this.mDescription = description;
    }

    public static Category createCategory(String id, String name, String description) {
        return new Category(id, name, description);
    }
}
