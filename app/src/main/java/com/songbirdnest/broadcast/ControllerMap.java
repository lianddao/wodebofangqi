package com.songbirdnest.broadcast;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.mediaplayer.widgets.IconPreference;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class ControllerMap {
    HashMap<String, String> cleanupList;
    HashMap<String, ExternalController> controllerMap;

    public ControllerMap() {
        Log.i(getClass().getSimpleName(), "New Prefernce");
        this.controllerMap = new HashMap();
        this.cleanupList = new HashMap();
    }

    public ControllerMap(InputStream inStream) {
        Log.i(getClass().getSimpleName(), "Reading Preference");
        openPreferences(inStream);
    }

    public void removeMenuItems(String mCallback) {
        if (this.controllerMap.containsKey(mCallback)) {
            ExternalController targetControl = (ExternalController) this.controllerMap.get(mCallback);
            if (targetControl != null) {
                targetControl.getMenuList().clear();
            }
        }
    }

    public void writePreferences(OutputStream outStream) throws IOException {
        ObjectOutput output = new ObjectOutputStream(new BufferedOutputStream(outStream, FacebookAPI.FACEBOOK_AUTHORIZE_RESULT_CODE));
        Stack<Object> persistMap = new Stack();
        persistMap.push(this.controllerMap);
        persistMap.push(this.cleanupList);
        output.writeObject(persistMap);
        output.close();
    }

    private void openPreferences(InputStream stream) {
        try {
            Object objectChecking = new ObjectInputStream(stream).readObject();
            Log.i(getClass().getSimpleName(), "Read in type " + objectChecking.getClass());
            if (objectChecking.getClass().equals(Stack.class)) {
                Log.i(getClass().getSimpleName(), "New Style");
                Stack<Object> persistMap = (Stack) objectChecking;
                this.cleanupList = (HashMap) persistMap.pop();
                this.controllerMap = (HashMap) persistMap.pop();
            } else {
                Log.i(getClass().getSimpleName(), "Old Style");
                this.controllerMap = (HashMap) objectChecking;
                this.cleanupList = new HashMap();
            }
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }
        if (this.cleanupList == null) {
            this.cleanupList = new HashMap();
        }
        if (this.controllerMap == null) {
            this.controllerMap = new HashMap();
        }
    }

    public void processMenuAdd(String mItemID, String mItemText, Bitmap mItemIcon, String mItemActionType, String mItemAction, ComponentName mItemComponent, String mCallback) {
        if (!this.controllerMap.containsKey(mCallback)) {
            this.controllerMap.put(mCallback, new ExternalController());
        }
        ExternalController targetController = (ExternalController) this.controllerMap.get(mCallback);
        Iterator i$ = targetController.getMenuList().iterator();
        while (i$.hasNext()) {
            MenuItem m = (MenuItem) i$.next();
            if (m.getItemId().equals(mItemID)) {
                targetController.getMenuList().remove(m);
                break;
            }
        }
        targetController.getMenuList().add(new MenuItem(mItemID, mItemText, mItemIcon, mItemActionType, mItemAction, mItemComponent));
    }

    public boolean processSettingNewItem(String mItemId, String mItemHeader, String mItemDesc, Bitmap mItemIcon, String mItemActionType, String mItemAction, String mCatKey, String mCatTitle, ComponentName mComponent, String mCallback) {
        if (!this.controllerMap.containsKey(mCallback)) {
            return false;
        }
        ExternalController targetController = (ExternalController) this.controllerMap.get(mCallback);
        SettingItem setItem = new SettingItem(mItemId, mItemHeader, mItemActionType, mItemAction, mCatKey, mComponent);
        if (mItemIcon != null) {
            setItem.setBitmap(mItemIcon);
        }
        if (mItemDesc != null) {
            setItem.setItemDesc(mItemDesc);
        }
        if (mCatTitle != null) {
            setItem.setmCategoryTitle(mCatTitle);
        }
        Iterator i$ = targetController.getSettingsList().iterator();
        while (i$.hasNext()) {
            SettingCategory c = (SettingCategory) i$.next();
            if (c.getmCategoryKey().equals(mCatKey)) {
                removeDupItem(mItemId, c.getItemList());
                c.getItemList().add(setItem);
            }
        }
        return true;
    }

    private void removeDupItem(String itemID, ArrayList<SettingItem> inList) {
        Iterator i$ = inList.iterator();
        while (i$.hasNext()) {
            SettingItem i = (SettingItem) i$.next();
            if (i.getItemID().equals(itemID)) {
                inList.remove(i);
                return;
            }
        }
    }

    public void processSettingNewCat(String mCatKey, String mCatTitle, String mCallback) {
        if (!this.controllerMap.containsKey(mCallback)) {
            this.controllerMap.put(mCallback, new ExternalController());
        }
        ExternalController targetController = (ExternalController) this.controllerMap.get(mCallback);
        Iterator i$ = targetController.getSettingsList().iterator();
        while (i$.hasNext()) {
            SettingCategory c = (SettingCategory) i$.next();
            if (c.getmCategoryKey().equals(mCatKey)) {
                targetController.getSettingsList().remove(c);
            }
        }
        targetController.getSettingsList().add(new SettingCategory(mCatKey, mCatTitle));
    }

    public void removeCategory(String mCatKey, String mCallback) {
        ExternalController targetControl = (ExternalController) this.controllerMap.get(mCallback);
        if (targetControl != null) {
            Iterator i$ = targetControl.getSettingsList().iterator();
            while (i$.hasNext()) {
                SettingCategory cat = (SettingCategory) i$.next();
                if (cat.getmCategoryKey().equals(mCatKey)) {
                    targetControl.getSettingsList().remove(cat);
                }
            }
        }
    }

    public void removeSettingItem(String mItemId, String mCallback) {
        ExternalController targetControl = (ExternalController) this.controllerMap.get(mCallback);
        if (targetControl != null) {
            Iterator it = targetControl.getSettingsList().iterator();
            while (it.hasNext()) {
                SettingCategory cat = (SettingCategory) it.next();
                Iterator i$ = cat.getItemList().iterator();
                while (i$.hasNext()) {
                    SettingItem item = (SettingItem) i$.next();
                    if (item.getItemID().equals(mItemId)) {
                        cat.getItemList().remove(item);
                        return;
                    }
                }
            }
        }
    }

    public void processMenuRemove(String mItemID, String mCallback) {
        ExternalController targetControl = (ExternalController) this.controllerMap.get(mCallback);
        if (targetControl != null) {
            ArrayList<MenuItem> menuArray = targetControl.getMenuList();
            Iterator i$ = menuArray.iterator();
            while (i$.hasNext()) {
                MenuItem i = (MenuItem) i$.next();
                if (i.getItemId().equals(mItemID)) {
                    menuArray.remove(i);
                    return;
                }
            }
        }
    }

    public void clearCustomSettings(String mCallback) {
        ExternalController targetControl = (ExternalController) this.controllerMap.get(mCallback);
        if (targetControl != null) {
            targetControl.settingsList.clear();
        }
    }

    public void addPackageCheck(String packageName, String mCallback) {
        Log.i(getClass().getSimpleName(), "Adding package: <" + packageName + "> with callback: " + mCallback);
        this.cleanupList.put(packageName, mCallback);
    }

    public void packageDeleted(String packageName) {
        String packageString = packageName.substring(8);
        Log.i(getClass().getSimpleName(), "Delete Package: <" + packageString + "> cleanupList size: " + this.cleanupList.keySet().size());
        if (this.cleanupList.keySet().contains(packageString)) {
            Log.i(getClass().getSimpleName(), "Found: " + packageString);
            String mCallback = (String) this.cleanupList.get(packageString);
            Log.i(getClass().getSimpleName(), "Callback found:<" + mCallback + ">");
            Log.i(getClass().getSimpleName(), "Controlelr contains Key:<" + this.controllerMap.containsKey(mCallback) + ">");
            this.cleanupList.remove(packageString);
            this.controllerMap.remove(mCallback);
        }
    }

    public void addPreferences(PreferenceScreen inScreen) {
        for (ExternalController c : this.controllerMap.values()) {
            Iterator it = c.settingsList.iterator();
            while (it.hasNext()) {
                SettingCategory cat = (SettingCategory) it.next();
                PreferenceCategory inCat = new PreferenceCategory(inScreen.getContext());
                inCat.setTitle(cat.mCategoryTitle);
                inCat.setKey(inCat.getKey());
                inScreen.addPreference(inCat);
                Iterator i$ = cat.itemList.iterator();
                while (i$.hasNext()) {
                    Preference pItem;
                    final SettingItem item = (SettingItem) i$.next();
                    if (item.getBitmap() != null) {
                        pItem = new IconPreference(inScreen.getContext());
                        ((IconPreference) pItem).setBitmap(item.getBitmap());
                    } else {
                        pItem = new Preference(inScreen.getContext());
                    }
                    pItem.setTitle(item.getItemHeader());
                    pItem.setSummary(item.getItemDesc());
                    pItem.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                        public boolean onPreferenceClick(Preference preference) {
                            Intent i;
                            if (item.getItemActionType().equals(APIReceiver.CONST_ACTIVITY)) {
                                i = new Intent(item.getItemAction());
                                i.setFlags(268435456);
                                preference.getContext().startActivity(i);
                            } else if (item.getItemActionType().equals(APIReceiver.CONST_CLASS)) {
                                i = new Intent();
                                i.setComponent(item.getComponent());
                                i.setFlags(268435456);
                                preference.getContext().startActivity(i);
                            } else if (item.getItemActionType().equals(APIReceiver.CONST_INTENT)) {
                                preference.getContext().sendBroadcast(new Intent(item.getItemAction()));
                            }
                            return true;
                        }
                    });
                    inScreen.addPreference(pItem);
                }
            }
        }
    }

    public void addMenuItems(Menu inMenu, final Context inContext) {
        for (ExternalController x : this.controllerMap.values()) {
            Iterator i$ = x.menuList.iterator();
            while (i$.hasNext()) {
                final MenuItem iMenuItem = (MenuItem) i$.next();
                MenuItem item = inMenu.add(iMenuItem.getItemText());
                item.setIcon(new BitmapDrawable(iMenuItem.getItemIcon()));
                item.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent i;
                        if (iMenuItem.getItemActionType().equals(APIReceiver.CONST_ACTIVITY)) {
                            i = new Intent(iMenuItem.getItemAction());
                            i.setFlags(268435456);
                            inContext.startActivity(i);
                        } else if (iMenuItem.getItemActionType().equals(APIReceiver.CONST_INTENT)) {
                            inContext.sendBroadcast(new Intent(iMenuItem.getItemAction()));
                        } else if (iMenuItem.getItemActionType().equals(APIReceiver.CONST_CLASS)) {
                            i = new Intent();
                            i.setComponent(iMenuItem.getmComponent());
                            i.setFlags(268435456);
                            inContext.startActivity(i);
                        }
                        return true;
                    }
                });
            }
        }
    }
}
