package com.songbirdnest.broadcast;

import java.io.Serializable;
import java.util.ArrayList;

public class ExternalController implements Serializable {
    private static final long serialVersionUID = 1;
    ArrayList<MenuItem> menuList = new ArrayList();
    ArrayList<SettingCategory> settingsList = new ArrayList();

    public ArrayList<SettingCategory> getSettingsList() {
        return this.settingsList;
    }

    public ArrayList<MenuItem> getMenuList() {
        return this.menuList;
    }
}
