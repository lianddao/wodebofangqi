package com.songbirdnest.broadcast;

import android.content.ComponentName;
import android.graphics.Bitmap;
import java.io.Serializable;

public class MenuItem implements Serializable {
    private static final long serialVersionUID = 1;
    ComponentName mComponent;
    String mItemAction;
    String mItemActionType;
    SerialBitmap mItemIcon;
    String mItemId;
    String mItemText;

    public ComponentName getmComponent() {
        return this.mComponent;
    }

    MenuItem() {
    }

    public MenuItem(String iItemId, String iItemText, Bitmap iItemIcon, String iActionType, String iAction, ComponentName iComponent) {
        this.mItemId = iItemId;
        this.mItemText = iItemText;
        this.mItemIcon = new SerialBitmap(iItemIcon);
        this.mItemActionType = iActionType;
        this.mItemAction = iAction;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public String getItemText() {
        return this.mItemText;
    }

    public Bitmap getItemIcon() {
        return this.mItemIcon.bitmap;
    }

    public String getItemActionType() {
        return this.mItemActionType;
    }

    public String getItemAction() {
        return this.mItemAction;
    }

    public void setItemId(String mItemId) {
        this.mItemId = mItemId;
    }

    public void setItemText(String mItemText) {
        this.mItemText = mItemText;
    }

    public void setItemIcon(SerialBitmap mItemIcon) {
        this.mItemIcon = mItemIcon;
    }

    public void setItemActionType(String mItemActionType) {
        this.mItemActionType = mItemActionType;
    }

    public void setItemAction(String mItemAction) {
        this.mItemAction = mItemAction;
    }
}
