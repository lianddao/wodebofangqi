package com.songbirdnest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.songbirdnest.mediaplayer.service.SongbirdMedia;

public class APIReceiver extends BroadcastReceiver {
    public static final String CONST_ACTIVITY = "activity";
    public static final String CONST_CLASS = "class";
    public static final String CONST_INTENT = "intent";
    public static final String MENU_ADD = "com.songbirdnest.mediaplayer.METHOD.MENU.ADD_ITEM";
    private static final String MENU_PARAM = "com.songbirdnest.mediaplayer.PARAMS.MENU";
    public static final String MENU_REMOVE = "com.songbirdnest.mediaplayer.METHOD.MENU.REMOVE_ITEM";
    public static final String MENU_REMOVE_ALL = "com.songbirdnest.mediaplayer.METHOD.MENU.REMOVE_ALL_ITEMS";
    public static final String METHOD_FULL_SENSOR = "com.songbirdnest.mediaplayer.METHOD.UI.SET_FULL_SENSOR_ORIENTATION";
    private static final String METHOD_MENU = "com.songbirdnest.mediaplayer.METHOD.MENU";
    public static final String METHOD_NAME = "com.songbirdnest.mediaplayer.METHOD_NAME";
    public static final String METHOD_ROOT = "com.songbirdnest.mediaplayer.METHOD";
    private static final String METHOD_SETTING = "com.songbirdnest.mediaplayer.METHOD.SETTINGS";
    public static final String NEXT = "com.songbirdnest.mediaplayer.METHOD.NEXT";
    public static final String PARAM_CATEGORY_KEY = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS.CATEGORY_KEY";
    public static final String PARAM_CATEGORY_TITLE = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS.CATEGORY_TITLE";
    public static final String PARAM_CLEAN_PACKAGE = "com.songbirdnest.mediaplayer.PARAMS.REGISTER_FOR_CLEANUP.PACKAGE_NAME";
    public static final String PARAM_FULL_ENABLED = "com.songbirdnest.mediaplayer.PARAMS.UI.ENABLED";
    public static final String PARAM_ITEMS_STATE = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS_ITEMS_STATE";
    public static final String PARAM_ITEM_ACTION = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS.ITEM_ACTION";
    public static final String PARAM_ITEM_ACTION_TYPE = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS.ITEM_ACTION_TYPE";
    public static final String PARAM_ITEM_DESC = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS.ITEM_DESC";
    public static final String PARAM_ITEM_HEADER = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS.ITEM_HEADER";
    public static final String PARAM_ITEM_ICON = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS.ITEM_ICON";
    public static final String PARAM_ITEM_ID = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS.ITEM_ID";
    public static final String PARAM_MENU_ACTION = "com.songbirdnest.mediaplayer.PARAMS.MENU.ITEM_ACTION";
    public static final String PARAM_MENU_COMPONENT = "com.songbirdnest.mediaplayer.PARAMS.MENUITEM_COMPONENT";
    public static final String PARAM_MENU_ICON = "com.songbirdnest.mediaplayer.PARAMS.MENU.ITEM_ICON";
    public static final String PARAM_MENU_ID = "com.songbirdnest.mediaplayer.PARAMS.MENU.ITEM_ID";
    public static final String PARAM_MENU_TEXT = "com.songbirdnest.mediaplayer.PARAMS.MENU.ITEM_TEXT";
    public static final String PARAM_MENU_TYPE = "com.songbirdnest.mediaplayer.PARAMS.MENU.ITEM_ACTION_TYPE";
    public static final String PARAM_OPTIONS_STATE = "com.songbirdnest.mediaplayer.PARAMS.OPTIONS_MENU_ITEMS_STATE";
    public static final String PARAM_RESULT_ENTRY = "com.songbirdnest.mediaplayer.PARAMS.RESULT_ENTRY_POINT";
    public static final String PARAM_RESULT_INTENT = "com.songbirdnest.mediaplayer.RESULT.METHOD_INTENT";
    private static final String PARAM_ROOT = "com.songbirdnest.mediaplayer.PARAMS";
    public static final String PAUSE = "com.songbirdnest.mediaplayer.METHOD.PAUSE";
    public static final String PLAY = "com.songbirdnest.mediaplayer.METHOD.PLAY";
    public static final String PREVIOUS = "com.songbirdnest.mediaplayer.METHOD.PREVIOUS";
    public static final String REGISTER_CLEANUP = "com.songbirdnest.mediaplayer.METHOD.REGISTER_FOR_CLEANUP";
    public static final String RESULT = "com.songbirdnest.mediaplayer.RESULT";
    private static final String ROOTNAME = "com.songbirdnest.mediaplayer";
    public static final String SETTING_ADD_CATEGORY = "com.songbirdnest.mediaplayer.METHOD.SETTINGS.ADD_CATEGORY";
    public static final String SETTING_ADD_ITEM = "com.songbirdnest.mediaplayer.METHOD.SETTINGS.ADD_ITEM";
    private static final String SETTING_PARAM = "com.songbirdnest.mediaplayer.PARAMS.SETTINGS";
    public static final String SETTING_REMOVE_ALL_ITEMS = "com.songbirdnest.mediaplayer.METHOD.SETTINGS.REMOVE_ALL_ITEMS";
    public static final String SETTING_REMOVE_CATEGORY = "com.songbirdnest.mediaplayer.METHOD.SETTINGS.REMOVE_CATEGORY";
    public static final String SETTING_REMOVE_ITEM = "com.songbirdnest.mediaplayer.METHOD.SETTINGS.REMOVE_ITEM";
    public static final String SHOULD_RESUME = "com.songbirdnest.mediaplayer.PARAMS.PLAY_SHOULD_RESUME";

    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, SongbirdMedia.class);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            i.putExtras((Bundle) extras.clone());
            context.startService(i);
        }
    }
}
