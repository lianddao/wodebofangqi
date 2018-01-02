package com.songbirdnest.database.cookies;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.songbirdnest.database.AbstractTable;
import com.songbirdnest.database.Column;
import com.songbirdnest.database.Column.COLUMN_TYPE;
import com.songbirdnest.database.Database;
import com.songbirdnest.util.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;

public class CookieTable extends AbstractTable {
    public static final String COOKIE_COMMENT = "cookieComment";
    private static final int COOKIE_COMMENT_COLUMN = 3;
    public static final String COOKIE_COMMENT_URL = "cookieCommentUrl";
    private static final int COOKIE_COMMENT_URL_COLUMN = 4;
    public static final String COOKIE_DOMAIN = "cookieDomain";
    private static final int COOKIE_DOMAIN_COLUMN = 5;
    public static final String COOKIE_EXPIRY_DATE = "cookieExpiryDate";
    private static final int COOKIE_EXPIRY_DATE_COLUMN = 6;
    public static final String COOKIE_PATH = "cookiePath";
    private static final int COOKIE_PATH_COLUMN = 7;
    public static final String COOKIE_VERSION = "cookieVersion";
    private static final int COOKIE_VERSION_COLUMN = 9;
    public static final String ID = "_id";
    private static final int ID_COLUMN = 0;
    public static final String IS_SECURE = "isSecure";
    private static final int IS_SECURE_COLUMN = 8;
    public static final String NAME = "name";
    private static final int NAME_COLUMN = 1;
    public static final String TABLE_NAME = "cookies";
    public static final String VALUE = "value";
    private static final int VALUE_COLUMN = 2;
    private static final int version = 1;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy");

    public CookieTable() {
        super(TABLE_NAME);
        addColumn(new Column("_id", COLUMN_TYPE.INTEGER, true));
        addColumn(new Column(NAME, COLUMN_TYPE.TEXT));
        addColumn(new Column("value", COLUMN_TYPE.TEXT));
        addColumn(new Column(COOKIE_COMMENT, COLUMN_TYPE.TEXT));
        addColumn(new Column(COOKIE_COMMENT_URL, COLUMN_TYPE.TEXT));
        addColumn(new Column(COOKIE_DOMAIN, COLUMN_TYPE.TEXT));
        addColumn(new Column(COOKIE_EXPIRY_DATE, COLUMN_TYPE.TEXT));
        addColumn(new Column(COOKIE_PATH, COLUMN_TYPE.TEXT));
        addColumn(new Column(IS_SECURE, COLUMN_TYPE.INTEGER));
        addColumn(new Column(COOKIE_VERSION, COLUMN_TYPE.INTEGER));
        setVersion(1);
    }

    public Object insertEntry(Database database, Object data) {
        SoundboardCookie cookie = (SoundboardCookie) data;
        ContentValues cv = new ContentValues();
        cv.put(NAME, cookie.getName());
        cv.put("value", cookie.getValue());
        cv.put(COOKIE_COMMENT, cookie.getComment());
        cv.put(COOKIE_COMMENT_URL, cookie.getCommentURL());
        cv.put(COOKIE_DOMAIN, cookie.getDomain());
        Date expiryDate = cookie.getExpiryDate();
        if (expiryDate != null) {
            cv.put(COOKIE_EXPIRY_DATE, this.dateFormat.format(expiryDate));
        }
        cv.put(COOKIE_PATH, cookie.getPath());
        cv.put(IS_SECURE, Integer.valueOf(cookie.isSecure() ? 1 : 0));
        cv.put(COOKIE_VERSION, Integer.valueOf(cookie.getVersion()));
        try {
            cookie.setId(database.getDatabase().insert(TABLE_NAME, NAME, cv));
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return cookie;
    }

    public void deleteEntry(Database database, Object data) {
        try {
            database.getDatabase().delete(TABLE_NAME, "_id=?", new String[]{String.valueOf(((SoundboardCookie) data).getId())});
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
            Cursor result = database.getDatabase().query(TABLE_NAME, this.projection, "name=?", new String[]{(String) data}, null, null, null);
            if (result.moveToFirst()) {
                SoundboardCookie cookie = fillCookie(result);
                result.close();
                return cookie;
            }
            result.close();
            return null;
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            return null;
        }
    }

    public List<SoundboardCookie> getAllCookies(Database database) {
        List<SoundboardCookie> soundboardCookies = new ArrayList();
        try {
            Cursor result = database.getDatabase().query(TABLE_NAME, this.projection, null, null, null, null, null);
            if (result.moveToFirst()) {
                while (!result.isAfterLast()) {
                    soundboardCookies.add(fillCookie(result));
                    result.moveToNext();
                }
                result.close();
            } else {
                result.close();
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return soundboardCookies;
    }

    public SoundboardCookie fillCookie(Cursor result) {
        boolean z = true;
        SoundboardCookie cookie = new SoundboardCookie(result.getString(1), result.getString(2));
        cookie.setId(result.getLong(0));
        cookie.setComment(result.getString(3));
        cookie.setCommentURL(result.getString(4));
        cookie.setDomain(result.getString(5));
        try {
            String dateString = result.getString(6);
            if (dateString != null && dateString.length() > 0) {
                cookie.setExpiryDate(this.dateFormat.parse(dateString));
            }
        } catch (ParseException e) {
            Logger.error((Object) this, "Problems parsing Date");
        }
        cookie.setPath(result.getString(7));
        if (result.getInt(8) != 1) {
            z = false;
        }
        cookie.setSecure(z);
        cookie.setVersion(result.getInt(9));
        return cookie;
    }

    public void addCookieStore(Database cookieDatabase, CookieStore cookieStore) {
        for (Cookie cookie : cookieStore.getCookies()) {
            if (cookie.getValue() != null) {
                SoundboardCookie soundboardCookie = new SoundboardCookie(cookie.getName(), cookie.getValue());
                soundboardCookie.fillCookie(cookie);
                insertEntry(cookieDatabase, soundboardCookie);
            } else {
                Logger.error((Object) this, "addCookieStore. Not adding cookie " + cookie.getName() + " because of null value");
            }
        }
    }

    public CookieStore getCookieStore(Database cookieDatabase) {
        CookieStore store = new BasicCookieStore();
        for (SoundboardCookie soundboardCookie : getAllCookies(cookieDatabase)) {
            store.addCookie(soundboardCookie);
        }
        return store;
    }
}
