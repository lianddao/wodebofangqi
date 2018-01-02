package com.songbirdnest.database.analytics;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.songbirdnest.database.AbstractTable;
import com.songbirdnest.database.Column;
import com.songbirdnest.database.Column.COLUMN_TYPE;
import com.songbirdnest.database.Database;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.List;

public class PropertyTable extends AbstractTable {
    public static final String EVENT_ID = "event_id";
    private static final int EVENT_ID_COLUMN = 1;
    private static final int ID_COLUMN = 0;
    public static final String KEY = "key";
    private static final int KEY_COLUMN = 2;
    public static final String TABLE_NAME = "properties";
    public static final String VALUE = "value";
    private static final int VALUE_COLUMN = 3;
    private static final int version = 1;

    public PropertyTable() {
        super(TABLE_NAME);
        addColumn(new Column("_id", COLUMN_TYPE.INTEGER, true));
        addColumn(new Column(EVENT_ID, COLUMN_TYPE.INTEGER));
        addColumn(new Column("key", COLUMN_TYPE.TEXT));
        addColumn(new Column("value", COLUMN_TYPE.TEXT));
        setVersion(1);
    }

    public Object insertEntry(Database database, Object data) {
        Property property = (Property) data;
        ContentValues cv = new ContentValues();
        cv.put(EVENT_ID, Long.valueOf(property.getEventId()));
        cv.put("key", property.getKey());
        cv.put("value", property.getValue());
        try {
            property.setId(database.getDatabase().insert(TABLE_NAME, EVENT_ID, cv));
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return property;
    }

    public Object updateProperty(Database database, Object data) {
        Property property = (Property) data;
        ContentValues cv = new ContentValues();
        cv.put(EVENT_ID, Long.valueOf(property.getEventId()));
        cv.put("key", property.getKey());
        cv.put("value", property.getValue());
        try {
            if (((long) database.getDatabase().update(TABLE_NAME, cv, "_id=?", new String[]{String.valueOf(property.getId())})) <= 0) {
                Logger.error((Object) this, "Could not update Property Table entry for property " + property.getKey());
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return property;
    }

    public void deleteEntry(Database database, Object data) {
        try {
            database.getDatabase().delete(TABLE_NAME, "_id=?", new String[]{String.valueOf(((Property) data).getId())});
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public void deleteAllEntries(Database database) {
        try {
            database.getDatabase().delete(TABLE_NAME, null, null);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public Object getEntry(Database database, Object data) {
        try {
            Cursor result = database.getDatabase().query(TABLE_NAME, this.projection, "_id=?", new String[]{String.valueOf((Long) data)}, null, null, null);
            if (result.moveToFirst()) {
                Property property = fillProperty(result);
                result.close();
                return property;
            }
            result.close();
            return null;
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            return null;
        }
    }

    public Object getAllProperties(Database database, Object data) {
        Long id = (Long) data;
        List<Property> properties = new ArrayList();
        try {
            Cursor result = database.getDatabase().query(TABLE_NAME, this.projection, "event_id=?", new String[]{String.valueOf(id)}, null, null, null);
            if (result.moveToFirst()) {
                while (!result.isAfterLast()) {
                    properties.add(fillProperty(result));
                    result.moveToNext();
                }
                result.close();
            } else {
                result.close();
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return properties;
    }

    public Property fillProperty(Cursor result) {
        Property property = new Property();
        property.setId(result.getLong(0));
        property.setEventId((long) result.getInt(1));
        property.setKey(result.getString(2));
        property.setValue(result.getString(3));
        return property;
    }
}
