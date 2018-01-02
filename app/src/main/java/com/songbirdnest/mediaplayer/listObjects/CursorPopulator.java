package com.songbirdnest.mediaplayer.listObjects;

import android.database.Cursor;
import java.util.ArrayList;

public class CursorPopulator {
    String mColumn;
    String mKey;
    ArrayList<String> mKeyList;
    ArrayList<String> mUniqueList;

    public CursorPopulator(Cursor aCursor, String aTargetColumn, String aTargetKey) {
        this.mColumn = aTargetColumn;
        this.mKey = aTargetKey;
        this.mUniqueList = new ArrayList(aCursor.getCount());
        this.mKeyList = new ArrayList(aCursor.getCount());
        processCursor(aCursor);
        aCursor.close();
    }

    private void processCursor(Cursor aCursor) {
        String tempKey = "";
        while (aCursor.moveToNext()) {
            int columnID = aCursor.getColumnIndexOrThrow(this.mKey);
            if (!aCursor.getString(columnID).equals(tempKey)) {
                tempKey = aCursor.getString(columnID);
                this.mKeyList.add(tempKey);
                this.mUniqueList.add(aCursor.getString(aCursor.getColumnIndexOrThrow(this.mColumn)));
            }
        }
    }

    public String getKey(int position) {
        return (String) this.mKeyList.get(position);
    }

    public int getCount() {
        return this.mUniqueList.size();
    }

    public String getUnique(int position) {
        return (String) this.mUniqueList.get(position);
    }
}
