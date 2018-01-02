package com.miui.player.ui.model;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.ui.fragment.PlaylistFragment;
import com.miui.player.util.SectionCursor;
import com.miui.player.util.SectionCursor.CursorConverter;
import com.miui.player.util.SectionCursor.ElementConverter;
import com.xiaomi.music.util.MusicLog;
import miui.widget.AlphabetFastIndexer;

public class PlaylistListAdapter extends SectionCursorAdapter {
    public static final String[] PLAYLIST_COLUMNS = new String[]{"_id", "name"};
    private static final String TAG = "PlaylistListAdapter";
    private final PlaylistFragment mFragment;
    private int mIdIdx;
    private final Resources mResources;
    private int mTitleIdx;

    static class PlaylistElementConverter implements ElementConverter {
        PlaylistElementConverter() {
        }

        public boolean parse(Cursor cursor, Object[] colVals) {
            colVals[0] = Integer.valueOf(cursor.getInt(0));
            colVals[1] = cursor.getString(1);
            return true;
        }
    }

    public static CursorConverter createCursorConverter() {
        return SectionCursor.createCursorConverter(new PlaylistElementConverter(), 1);
    }

    public PlaylistListAdapter(Context context, PlaylistFragment currentFragment, int layout, Cursor cursor, AlphabetFastIndexer fastIndexer) {
        super(context, layout, cursor, fastIndexer, "name");
        this.mFragment = currentFragment;
        this.mResources = context.getResources();
        getColumnIndices(cursor);
    }

    private void getColumnIndices(Cursor cursor) {
        if (cursor != null) {
            this.mTitleIdx = cursor.getColumnIndexOrThrow("name");
            this.mIdIdx = cursor.getColumnIndexOrThrow("_id");
        }
    }

    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        long id = cursor.getLong(this.mIdIdx);
        TextView numText = (TextView) view.findViewById(C0329R.id.secondary_first_text);
        ((TextView) view.findViewById(C0329R.id.primary_text)).setText(cursor.getString(this.mTitleIdx));
        int type = PlaylistHelper.getOnlinePlaylistType(context, id);
        if (type == -1) {
            numText.setVisibility(0);
            int count = this.mFragment.getPresetRecordCount((int) id);
            numText.setText(this.mResources.getQuantityString(C0329R.plurals.Ntracks_format, count, new Object[]{Integer.valueOf(count)}));
            return;
        }
        String secondText = getOnlinePlaylistTitle(type);
        if (secondText != null) {
            numText.setVisibility(0);
            numText.setText(secondText);
            return;
        }
        numText.setVisibility(8);
    }

    public void changeCursor(Cursor cursor) {
        if (!(this.mFragment.isActivityWorking() || cursor == null)) {
            cursor.close();
            cursor = null;
        }
        if (this.mFragment.swapCursor(cursor)) {
            getColumnIndices(cursor);
        }
        super.changeCursor(cursor);
    }

    private String getOnlinePlaylistTitle(int type) {
        String typeString;
        switch (type) {
            case 101:
                typeString = this.mContext.getString(C0329R.string.channel);
                break;
            case 102:
                typeString = this.mContext.getString(C0329R.string.billboard);
                break;
            case 103:
                typeString = this.mContext.getString(C0329R.string.recommend);
                break;
            default:
                typeString = null;
                MusicLog.m395d(TAG, "It's not a online playlist, invalid list type!");
                break;
        }
        if (typeString == null) {
            return null;
        }
        return String.format("%s - %s", new Object[]{this.mContext.getString(C0329R.string.online_title), typeString});
    }
}
