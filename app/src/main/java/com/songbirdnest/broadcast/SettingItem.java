package com.songbirdnest.broadcast;

import android.content.ComponentName;
import android.graphics.Bitmap;
import java.io.Serializable;

public class SettingItem implements Serializable {
    private static final long serialVersionUID = 1;
    SerialBitmap mBitmap;
    String mCategoryKey;
    String mCategoryTitle;
    String mClassName;
    String mItemAction;
    String mItemActionType;
    String mItemDesc;
    String mItemHeader;
    String mItemID;
    String mPackageName;

    SettingItem() {
    }

    public SettingItem(String iItemID, String iItemHeader, String iItemActionType, String iItemAction, String iCategoryKey, ComponentName iComponent) {
        if (iComponent != null) {
            this.mPackageName = iComponent.getPackageName();
            this.mClassName = iComponent.getClassName();
        }
        this.mItemID = iItemID;
        this.mItemHeader = iItemHeader;
        this.mItemAction = iItemAction;
        this.mItemActionType = iItemActionType;
        this.mCategoryKey = iCategoryKey;
    }

    public String getItemID() {
        return this.mItemID;
    }

    public void setItemID(String mItemID) {
        this.mItemID = mItemID;
    }

    public String getItemHeader() {
        return this.mItemHeader;
    }

    public void setItemHeader(String mItemHeader) {
        this.mItemHeader = mItemHeader;
    }

    public String getItemDesc() {
        return this.mItemDesc;
    }

    public void setItemDesc(String mItemDesc) {
        this.mItemDesc = mItemDesc;
    }

    public Bitmap getBitmap() {
        if (this.mBitmap == null) {
            return null;
        }
        return this.mBitmap.bitmap;
    }

    public void setBitmap(Bitmap mBitmap) {
        this.mBitmap = new SerialBitmap(mBitmap);
    }

    public String getItemActionType() {
        return this.mItemActionType;
    }

    public void setItemActionType(String mItemActionType) {
        this.mItemActionType = mItemActionType;
    }

    public String getItemAction() {
        return this.mItemAction;
    }

    public void setItemAction(String mItemAction) {
        this.mItemAction = mItemAction;
    }

    public String getCategoryKey() {
        return this.mCategoryKey;
    }

    public void setCategoryKey(String mCategoryKey) {
        this.mCategoryKey = mCategoryKey;
    }

    public String getmCategoryTitle() {
        return this.mCategoryTitle;
    }

    public void setmCategoryTitle(String mCategoryTitle) {
        this.mCategoryTitle = mCategoryTitle;
    }

    public ComponentName getComponent() {
        if (this.mPackageName == null || this.mClassName == null) {
            return null;
        }
        return new ComponentName(this.mPackageName, this.mClassName);
    }
}
