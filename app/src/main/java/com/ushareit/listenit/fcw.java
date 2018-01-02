package com.ushareit.listenit;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import java.util.ArrayList;
import java.util.List;

public final class fcw {
    public static final String[] f12448a = new String[]{"_id"};
    public static final String[] f12449b = new String[]{"_id", "_data"};

    public static int m18867a(Context context) {
        return m18869b(context, fcg.PHOTO, Media.EXTERNAL_CONTENT_URI);
    }

    public static List<fcb> m18870b(Context context) {
        return m18868a(context, fcg.PHOTO, Media.EXTERNAL_CONTENT_URI);
    }

    public static int m18871c(Context context) {
        return m18869b(context, fcg.MUSIC, Audio.Media.EXTERNAL_CONTENT_URI);
    }

    public static List<fcb> m18872d(Context context) {
        return m18868a(context, fcg.MUSIC, Audio.Media.EXTERNAL_CONTENT_URI);
    }

    public static int m18873e(Context context) {
        return m18869b(context, fcg.VIDEO, Video.Media.EXTERNAL_CONTENT_URI);
    }

    public static List<fcb> m18874f(Context context) {
        return m18868a(context, fcg.VIDEO, Video.Media.EXTERNAL_CONTENT_URI);
    }

    private static int m18869b(Context context, fcg com_ushareit_listenit_fcg, Uri uri) {
        String[] strArr = f12448a;
        String a = fco.m18855a(com_ushareit_listenit_fcg);
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(uri, strArr, a, null, null);
        if (query == null) {
            exw.m18456d("MediaItemLoadHelper", "getContentTotalCount: URI = " + uri + ", NonZeroItems Cursor is null");
            throw new fch(0, "cursor is null");
        }
        try {
            int count = 0 + query.getCount();
            fbb.m18756a(query);
            query = contentResolver.query(uri, f12449b, fco.m18857b(com_ushareit_listenit_fcg), null, null);
            if (query == null) {
                exw.m18456d("MediaItemLoadHelper", "getContentTotalCount: URI = " + uri + ", ZeroItems Cursor is null");
                throw new fch(0, "cursor is null");
            }
            int i = count;
            while (query.moveToNext()) {
                try {
                    if (!fco.m18856a(com_ushareit_listenit_fcg, eyh.m18491a(query.getString(1)).mo2332g())) {
                        i++;
                    }
                } catch (Exception e) {
                    throw new fch(0, "");
                } catch (Throwable th) {
                    fbb.m18756a(query);
                }
            }
            fbb.m18756a(query);
            return i;
        } catch (Exception e2) {
            throw new fch(0, "");
        } catch (Throwable th2) {
            fbb.m18756a(query);
        }
    }

    public static List<fcb> m18868a(Context context, fcg com_ushareit_listenit_fcg, Uri uri) {
        List<fcb> arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(uri, fcq.m18862a(com_ushareit_listenit_fcg), fco.m18858c(com_ushareit_listenit_fcg), null, fco.m18859d(com_ushareit_listenit_fcg));
        if (query == null) {
            exw.m18456d("MediaItemLoadHelper", "loadAllContentItems: URI = " + uri + ", NonZeroItems Cursor is null");
            throw new fch(0, "cursor is null");
        }
        while (query.moveToNext()) {
            try {
                fcb a = fcq.m18861a(context, com_ushareit_listenit_fcg, query);
                if (!(a == null || fco.m18856a(com_ushareit_listenit_fcg, a.m18345d()))) {
                    arrayList.add(a);
                }
            } catch (Exception e) {
                throw new fch(0, "");
            } catch (Throwable th) {
                fbb.m18756a(query);
            }
        }
        fbb.m18756a(query);
        return arrayList;
    }
}
