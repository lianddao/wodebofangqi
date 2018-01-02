package com.ushareit.listenit;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.MediaStore.Audio.Genres;
import android.provider.MediaStore.Audio.Media;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class grz {
    private static grz f14622a;
    private Map<String, String> f14623b = new HashMap();
    private int f14624c = 0;
    private List<String> f14625d = new ArrayList();

    private grz() {
    }

    public static grz m22656a() {
        if (f14622a == null) {
            f14622a = new grz();
        }
        return f14622a;
    }

    public String m22663a(Context context, String str) {
        int b = m22665b(context);
        if (this.f14624c != b) {
            this.f14624c = b;
            m22666b();
        }
        String str2 = (String) this.f14623b.get(str);
        return !fbb.m18763c(str2) ? str2 : context.getString(C0349R.string.unknown);
    }

    public void m22666b() {
        Context a = eys.m18562a();
        Cursor query = a.getContentResolver().query(Genres.EXTERNAL_CONTENT_URI, new String[]{"_id", "name"}, null, null, null);
        if (gyn.m23200a(query)) {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                String string = query.getString(0);
                String string2 = query.getString(1);
                Cursor query2 = a.getContentResolver().query(m22655a(string), new String[]{"_data"}, null, null, null);
                if (gyn.m23200a(query2)) {
                    for (int i = 0; i < query2.getCount(); i++) {
                        query2.moveToPosition(i);
                        this.f14623b.put(query2.getString(0), string2);
                    }
                    query2.close();
                }
                query.moveToNext();
            }
            query.close();
        }
    }

    private Uri m22655a(String str) {
        return Uri.parse(Genres.EXTERNAL_CONTENT_URI.toString() + "/" + str + "/" + "members");
    }

    public Cursor m22661a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String str = "is_music!=0 OR (is_notification=0 AND is_alarm=0 AND is_ringtone=0 )";
        Cursor query = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, str, null, null);
        Cursor query2 = contentResolver.query(Media.INTERNAL_CONTENT_URI, null, str, null, null);
        return new MergeCursor(new Cursor[]{query, query2});
    }

    public String m22662a(Context context, Uri uri) {
        String str = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        } catch (SecurityException e) {
            if (str != null) {
                str.close();
            }
            Object obj = str;
        }
        if (gyn.m23200a(query)) {
            try {
                str = query.getString(0);
            } catch (Exception e2) {
            }
            query.close();
        }
        return str;
    }

    public int m22665b(Context context) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, null, null, null);
            if (!gyn.m23200a(query)) {
                return 0;
            }
            int count = query.getCount();
            query.close();
            return count;
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        }
    }

    public boolean m22668b(Context context, String str) {
        boolean z;
        String[] strArr = new String[]{"_id"};
        String str2 = "_data=?";
        String[] strArr2 = new String[]{str};
        Cursor query = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, strArr, str2, strArr2, null);
        if (!gyn.m23200a(query)) {
            query = context.getContentResolver().query(Media.INTERNAL_CONTENT_URI, strArr, str2, strArr2, null);
            if (!gyn.m23200a(query)) {
                return false;
            }
        }
        if (query.getCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        query.close();
        return z;
    }

    public glf m22669c(Context context, String str) {
        String[] strArr = new String[]{str};
        Cursor query = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, null, "_data=?", strArr, null);
        if (!gyn.m23200a(query)) {
            return null;
        }
        glf com_ushareit_listenit_glf = new glf(query);
        query.close();
        return com_ushareit_listenit_glf;
    }

    public void m22664a(String str, int i) {
        Uri contentUriForPath = Media.getContentUriForPath(str);
        String str2 = "_data=?";
        Cursor query = eys.m18562a().getContentResolver().query(contentUriForPath, new String[]{"_id"}, "_data=?", new String[]{str}, null);
        if (gyn.m23200a(query)) {
            m22659b(ContentUris.withAppendedId(contentUriForPath, Long.valueOf(query.getString(0)).longValue()), i);
        } else {
            gyn.m23188a(eys.m18562a(), new File(str), new gsa(this, i));
        }
        if (query != null) {
            query.close();
        }
    }

    public void m22667b(String str, int i) {
        Uri contentUriForPath = Media.getContentUriForPath(str);
        String str2 = "_data=?";
        Cursor query = eys.m18562a().getContentResolver().query(contentUriForPath, new String[]{"_id"}, "_data=?", new String[]{str}, null);
        if (gyn.m23200a(query)) {
            m22657a(ContentUris.withAppendedId(contentUriForPath, Long.valueOf(query.getString(0)).longValue()), i);
        } else {
            gyn.m23188a(eys.m18562a(), new File(str), new gsc(this, i));
        }
        if (query != null) {
            query.close();
        }
    }

    private void m22657a(Uri uri, int i) {
        int i2 = C0349R.string.toast_set_as_ringtone;
        if (uri != null) {
            try {
                if (ContentUris.parseId(uri) >= 0) {
                    ContentValues contentValues = new ContentValues();
                    switch (i) {
                        case 1:
                            contentValues.put("is_ringtone", Boolean.valueOf(true));
                            contentValues.put("is_notification", Boolean.valueOf(false));
                            contentValues.put("is_alarm", Boolean.valueOf(false));
                            break;
                        case 2:
                            contentValues.put("is_notification", Boolean.valueOf(true));
                            contentValues.put("is_ringtone", Boolean.valueOf(false));
                            contentValues.put("is_alarm", Boolean.valueOf(false));
                            i2 = C0349R.string.toast_set_as_notification;
                            break;
                        case 4:
                            contentValues.put("is_alarm", Boolean.valueOf(true));
                            contentValues.put("is_ringtone", Boolean.valueOf(false));
                            contentValues.put("is_notification", Boolean.valueOf(false));
                            i2 = C0349R.string.toast_set_as_alarm;
                            break;
                    }
                    contentValues.put("is_music", Boolean.valueOf(false));
                    eys.m18562a().getContentResolver().update(uri, contentValues, null, null);
                    RingtoneManager.setActualDefaultRingtoneUri(eys.m18562a(), i, uri);
                    heb.m23596a(i2, 0).show();
                }
            } catch (Throwable e) {
                exw.m18457e("MediaStoreHelper", "setMediaStoreAudioAsDefaultRingtone error=" + exw.m18438a(e));
            }
        }
    }

    private void m22659b(Uri uri, int i) {
        if (uri != null) {
            try {
                if (ContentUris.parseId(uri) >= 0) {
                    ContentValues contentValues = new ContentValues();
                    switch (i) {
                        case 1:
                            contentValues.put("is_ringtone", Boolean.valueOf(true));
                            contentValues.put("is_notification", Boolean.valueOf(false));
                            contentValues.put("is_alarm", Boolean.valueOf(false));
                            break;
                        case 2:
                            contentValues.put("is_notification", Boolean.valueOf(true));
                            contentValues.put("is_ringtone", Boolean.valueOf(false));
                            contentValues.put("is_alarm", Boolean.valueOf(false));
                            break;
                        case 4:
                            contentValues.put("is_alarm", Boolean.valueOf(true));
                            contentValues.put("is_ringtone", Boolean.valueOf(false));
                            contentValues.put("is_notification", Boolean.valueOf(false));
                            break;
                    }
                    contentValues.put("is_music", Boolean.valueOf(false));
                    eys.m18562a().getContentResolver().update(uri, contentValues, null, null);
                }
            } catch (Throwable e) {
                exw.m18457e("MediaStoreHelper", "setMediaStoreAudioAsDefaultRingtone error=" + exw.m18438a(e));
            }
        }
    }
}
