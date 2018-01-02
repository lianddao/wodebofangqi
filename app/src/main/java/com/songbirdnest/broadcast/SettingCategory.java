package com.songbirdnest.broadcast;

import java.io.Serializable;
import java.util.ArrayList;

public class SettingCategory implements Serializable {
    private static final long serialVersionUID = 1;
    ArrayList<SettingItem> itemList;
    String mCategoryKey;
    String mCategoryTitle;

    SettingCategory() {
    }

    public SettingCategory(String iCategoryKey, String iCateoryTitle) {
        this.mCategoryKey = iCategoryKey;
        this.mCategoryTitle = iCateoryTitle;
        this.itemList = new ArrayList();
    }

    public ArrayList<SettingItem> getItemList() {
        return this.itemList;
    }

    public String getmCategoryKey() {
        return this.mCategoryKey;
    }

    public String getmCategoryTitle() {
        return this.mCategoryTitle;
    }
}
