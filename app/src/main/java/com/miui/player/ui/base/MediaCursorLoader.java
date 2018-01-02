package com.miui.player.ui.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader.ForceLoadContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.miui.player.util.SqlUtils;
import com.xiaomi.music.util.MusicLog;

public class MediaCursorLoader extends CursorLoader {
    private static final String TAG = "MediaCursorLoader";
    private final MediaLoaderInfo mLoaderInfo;
    private final ForceLoadContentObserver mObserver = new ForceLoadContentObserver(this);

    public interface CursorDecorator {
        Cursor decorate(Cursor cursor, QueryArgs queryArgs);

        boolean isRawCursorClosable();
    }

    public static class MediaLoaderInfo {
        public final CursorDecorator mDecorator;
        public final QueryArgs mQueryArgs;

        public MediaLoaderInfo(CursorDecorator decorator, QueryArgs args) {
            this.mDecorator = decorator;
            this.mQueryArgs = args;
        }
    }

    public static class QueryArgs {
        public final int mLimit;
        public final String[] mProjection;
        public final ContentResolver mResolver;
        public final String mSelection;
        public final String[] mSelectionArgs;
        final SelectionDecorator mSelectionDecorator;
        public final String mSortOrder;
        public final Uri mUri;

        public QueryArgs(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, SelectionDecorator selectionDecorator) {
            this(MusicApplication.getApplication().getContentResolver(), uri, projection, selection, selectionArgs, sortOrder, selectionDecorator, 0);
        }

        public QueryArgs(ContentResolver r, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, SelectionDecorator selectionDecorator) {
            this(r, uri, projection, selection, selectionArgs, sortOrder, selectionDecorator, 0);
        }

        public QueryArgs(ContentResolver r, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, SelectionDecorator selectionDecorator, int limit) {
            this.mResolver = r;
            this.mUri = uri;
            this.mProjection = projection;
            this.mSelection = selection;
            this.mSelectionArgs = selectionArgs;
            this.mSortOrder = sortOrder;
            this.mLimit = limit;
            this.mSelectionDecorator = selectionDecorator;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("uri=").append(this.mUri);
            sb.append(" projection=(");
            if (this.mProjection != null) {
                for (String proj : this.mProjection) {
                    sb.append(proj).append(" ");
                }
            }
            sb.append(")");
            sb.append(" selection=").append(this.mSelection);
            sb.append(" sargs=(");
            if (this.mSelectionArgs != null) {
                for (String arg : this.mSelectionArgs) {
                    sb.append(arg).append(" ");
                }
            }
            sb.append(")");
            sb.append(" sort=").append(this.mSortOrder);
            sb.append(" limit=").append(this.mLimit);
            return sb.toString();
        }
    }

    public static class Selection {
        public final String[] mArgs;
        public final String mWhere;

        public Selection(String selection, String[] args) {
            this.mWhere = selection;
            this.mArgs = args;
        }
    }

    public static abstract class SelectionDecorator {
        private final SelectionDecorator mDecorated;

        protected abstract Selection doDecorate(String str, String[] strArr);

        public SelectionDecorator(SelectionDecorator decorated) {
            this.mDecorated = decorated;
        }

        public final Selection decorate(String where, String[] args) {
            if (this.mDecorated != null) {
                Selection selection = this.mDecorated.decorate(where, args);
                if (selection != null) {
                    where = selection.mWhere;
                    args = selection.mArgs;
                } else {
                    where = null;
                    args = null;
                }
            }
            return doDecorate(where, args);
        }
    }

    public MediaCursorLoader(Context context, MediaLoaderInfo info) {
        super(context, info.mQueryArgs.mUri, info.mQueryArgs.mProjection, info.mQueryArgs.mSelection, info.mQueryArgs.mSelectionArgs, info.mQueryArgs.mSortOrder);
        this.mLoaderInfo = info;
    }

    public Cursor loadInBackground() {
        Cursor decorated;
        long c = System.currentTimeMillis();
        QueryArgs args = this.mLoaderInfo.mQueryArgs;
        String selection = null;
        String[] selectionArgs = null;
        SelectionDecorator decorator = args.mSelectionDecorator;
        if (decorator != null) {
            Selection s = decorator.decorate(args.mSelection, args.mSelectionArgs);
            if (s != null) {
                selection = s.mWhere;
                selectionArgs = s.mArgs;
            }
        } else {
            selection = args.mSelection;
            selectionArgs = args.mSelectionArgs;
        }
        Cursor cursor = SqlUtils.query(getContext(), args.mUri, args.mProjection, selection, selectionArgs, args.mSortOrder, args.mLimit);
        CursorDecorator decoder = this.mLoaderInfo.mDecorator;
        if (decoder != null) {
            decorated = decoder.decorate(cursor, args);
            if (decoder.isRawCursorClosable()) {
                if (cursor != null) {
                    cursor.close();
                }
                if (decorated != null) {
                    decorated.setNotificationUri(args.mResolver, args.mUri);
                }
            }
        } else {
            decorated = cursor;
        }
        if (decorated != null) {
            decorated.registerContentObserver(this.mObserver);
        }
        MusicLog.m401p(TAG, "load " + args.mUri + " costs time=" + (System.currentTimeMillis() - c));
        return decorated;
    }
}
