package com.songbirdnest.database.analytics;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.songbirdnest.database.Database;
import com.songbirdnest.database.cookies.CookieDatabase;
import com.songbirdnest.util.Logger;
import java.util.List;

public class AnalyticsDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "events.db";
    private static final int version = 1;
    private Context context;
    protected boolean created = false;
    private SQLiteDatabase database;
    private Database eventDatabase;
    private EventTable eventTable;
    protected boolean opened = false;
    private PropertyTable propertyTable;

    public AnalyticsDBHelper(Context context) {
        super(context, DATABASE, null, 1);
        this.context = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(SQLiteDatabase r5) {
        /*
        r4 = this;
        r2 = 1;
        r4.created = r2;
        r2 = "SELECT name FROM sqlite_master WHERE type='table' AND name='events'";
        r3 = 0;
        r0 = r5.rawQuery(r2, r3);
        r4.database = r5;
        r4.createLocalDB();
        r2 = r0.getCount();	 Catch:{ SQLiteException -> 0x001e }
        if (r2 != 0) goto L_0x001a;
    L_0x0015:
        r2 = r4.eventDatabase;	 Catch:{ SQLiteException -> 0x001e }
        r2.createDatabase();	 Catch:{ SQLiteException -> 0x001e }
    L_0x001a:
        r0.close();
    L_0x001d:
        return;
    L_0x001e:
        r1 = move-exception;
        r2 = r1.getMessage();	 Catch:{ all -> 0x002a }
        com.songbirdnest.util.Logger.error(r4, r2);	 Catch:{ all -> 0x002a }
        r0.close();
        goto L_0x001d;
    L_0x002a:
        r2 = move-exception;
        r0.close();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.songbirdnest.database.analytics.AnalyticsDBHelper.onCreate(android.database.sqlite.SQLiteDatabase):void");
    }

    public synchronized void open() {
        if (this.opened) {
            Logger.error((Object) this, "DB Already opened");
        }
        this.opened = true;
        this.database = getWritableDatabase();
        if (this.created) {
            createLocalDB();
        } else {
            onCreate(this.database);
        }
    }

    private void createLocalDB() {
        this.eventDatabase = new AnalyticsDB(this.database);
        this.eventTable = (EventTable) this.eventDatabase.getTable(EventTable.TABLE_NAME);
        this.propertyTable = (PropertyTable) this.eventDatabase.getTable(PropertyTable.TABLE_NAME);
    }

    public synchronized void close() {
        if (this.opened && this.database != null) {
            super.close();
        }
        this.opened = false;
    }

    public static int getVersion() {
        return 1;
    }

    public void dropDatabase() {
        this.eventDatabase.dropDatabase();
        onCreate(this.database);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.database = db;
        this.eventDatabase = new CookieDatabase(db);
        if (oldVersion != newVersion) {
            dropDatabase();
        }
    }

    public void cleanEvents() {
        if (!this.opened) {
            open();
        }
        this.eventTable.deleteAllEntries(this.eventDatabase);
        this.propertyTable.deleteAllEntries(this.eventDatabase);
    }

    public List<Event> getAllEvents(boolean includeProperties) {
        if (!this.opened) {
            open();
        }
        List<Event> events = this.eventTable.getAllEvents(this.eventDatabase);
        if (includeProperties) {
            for (Event event : events) {
                event.setProperties((List) this.propertyTable.getAllProperties(this.eventDatabase, Long.valueOf(event.getId())));
            }
        }
        return events;
    }

    public Event addEvent(Event event) {
        if (!this.opened) {
            open();
        }
        Event updatedEvent = (Event) this.eventTable.insertEntry(this.eventDatabase, event);
        for (Property property : updatedEvent.getProperties()) {
            property.setEventId(updatedEvent.getId());
            this.propertyTable.insertEntry(this.eventDatabase, property);
        }
        return updatedEvent;
    }

    public void deleteEvent(String category) {
        if (!this.opened) {
            open();
        }
        this.eventTable.deleteEvent(this.eventDatabase, category);
    }

    public Event updateEvent(Event event) {
        if (!this.opened) {
            open();
        }
        Event updatedEvent = (Event) this.eventTable.updateEvent(this.eventDatabase, event);
        for (Property property : updatedEvent.getProperties()) {
            property.setEventId(updatedEvent.getId());
            this.propertyTable.updateProperty(this.eventDatabase, property);
        }
        return updatedEvent;
    }
}
