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

public class EventTable extends AbstractTable {
    public static final String ACTION = "action";
    private static final int ACTION_COLUMN = 2;
    public static final String CATEGORY = "category";
    private static final int CATEGORY_COLUMN = 1;
    public static final String COUNT = "count";
    private static final int COUNT_COLUMN = 3;
    private static final int ID_COLUMN = 0;
    public static final String TABLE_NAME = "events";
    private static final int version = 1;

    public EventTable() {
        super(TABLE_NAME);
        addColumn(new Column("_id", COLUMN_TYPE.INTEGER, true));
        addColumn(new Column(CATEGORY, COLUMN_TYPE.TEXT));
        addColumn(new Column("action", COLUMN_TYPE.TEXT));
        addColumn(new Column(COUNT, COLUMN_TYPE.INTEGER));
        setVersion(1);
    }

    public Object insertEntry(Database database, Object data) {
        Event event = (Event) data;
        ContentValues cv = new ContentValues();
        cv.put(CATEGORY, event.getCategory());
        cv.put("action", event.getAction());
        cv.put(COUNT, Integer.valueOf(event.getCount()));
        try {
            event.setId(database.getDatabase().insert(TABLE_NAME, CATEGORY, cv));
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return event;
    }

    public Object updateEvent(Database database, Object data) {
        Event event = (Event) data;
        ContentValues cv = new ContentValues();
        cv.put(CATEGORY, event.getCategory());
        cv.put("action", event.getAction());
        cv.put(COUNT, Integer.valueOf(event.getCount()));
        try {
            if (((long) database.getDatabase().update(TABLE_NAME, cv, "_id=?", new String[]{String.valueOf(event.getId())})) <= 0) {
                Logger.error((Object) this, "Could not update Event Table entry for category " + event.getCategory());
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return event;
    }

    public void deleteEntry(Database database, Object data) {
        try {
            database.getDatabase().delete(TABLE_NAME, "_id=?", new String[]{String.valueOf(((Event) data).getId())});
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
            Cursor result = database.getDatabase().query(TABLE_NAME, this.projection, "category=?", new String[]{(String) data}, null, null, null);
            if (result.moveToFirst()) {
                Event event = fillEvent(result);
                result.close();
                return event;
            }
            result.close();
            return null;
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            return null;
        }
    }

    public List<Event> getAllEvents(Database database) {
        List<Event> events = new ArrayList();
        try {
            Cursor result = database.getDatabase().query(TABLE_NAME, this.projection, null, null, null, null, null);
            if (result.moveToFirst()) {
                while (!result.isAfterLast()) {
                    events.add(fillEvent(result));
                    result.moveToNext();
                }
                result.close();
            } else {
                result.close();
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return events;
    }

    public Event fillEvent(Cursor result) {
        Event event = new Event();
        event.setId(result.getLong(0));
        event.setCategory(result.getString(1));
        event.setAction(result.getString(2));
        event.setCount(result.getInt(3));
        return event;
    }

    public void deleteEvent(Database database, String category) {
        try {
            database.getDatabase().delete(TABLE_NAME, "category=?", new String[]{String.valueOf(category)});
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }
}
