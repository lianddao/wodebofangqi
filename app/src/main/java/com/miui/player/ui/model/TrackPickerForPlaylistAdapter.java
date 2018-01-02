package com.miui.player.ui.model;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.TrackPickerForPlaylist;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.fragment.TrackPickerForPlaylistFragment;
import com.miui.player.util.SectionCursor;
import com.miui.player.util.SectionCursor.CursorConverter;
import com.miui.player.util.SectionCursor.ElementConverter;
import com.miui.player.util.Utils;
import java.util.HashSet;
import miui.widget.AlphabetFastIndexer;

public class TrackPickerForPlaylistAdapter extends SectionCursorAdapter {
    public static final String[] TRACK_PICKER_COLUMNS = new String[]{"_id", "title", "artist", "duration"};
    private TrackPickerForPlaylist mActivity;
    private int mArtistIdx;
    private int mAudioIdIdx;
    private int mDurationIdx;
    private TrackPickerForPlaylistFragment mFragment;
    private int mMaxSelectableCount;
    private long mPlaylistId;
    private final HashSet<Long> mPreviousAudioList = new HashSet();
    private final HashSet<Long> mSelectedAudioList = new HashSet();
    private int mTitleIdx;

    static class TrackElementConverter implements ElementConverter {
        TrackElementConverter() {
        }

        public boolean parse(Cursor cursor, Object[] array) {
            array[0] = Integer.valueOf(cursor.getInt(0));
            array[1] = cursor.getString(1);
            array[2] = cursor.getString(2);
            array[3] = Integer.valueOf(cursor.getInt(3));
            return true;
        }
    }

    public static class ViewHolder {
        TextView artistName;
        CheckBox checkBox;
        TextView durationText;
        ImageView textSeparator;
        TextView trackName;
    }

    public static CursorConverter createCursorConverter() {
        return SectionCursor.createCursorConverter(new TrackElementConverter(), 1);
    }

    public TrackPickerForPlaylistAdapter(Context context, TrackPickerForPlaylistFragment fragment, int layout, long playlistId, Cursor cursor, AlphabetFastIndexer fastIndexer) {
        super(context, layout, cursor, fastIndexer, "title");
        this.mActivity = (TrackPickerForPlaylist) fragment.getActivity();
        this.mFragment = fragment;
        this.mPlaylistId = playlistId;
        getColumnIndices(cursor);
    }

    private void getColumnIndices(Cursor cursor) {
        if (cursor != null) {
            this.mTitleIdx = cursor.getColumnIndexOrThrow("title");
            this.mArtistIdx = cursor.getColumnIndexOrThrow("artist");
            this.mDurationIdx = cursor.getColumnIndexOrThrow("duration");
            this.mAudioIdIdx = cursor.getColumnIndexOrThrow("_id");
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.newView(context, cursor, parent);
        ViewHolder vh = new ViewHolder();
        vh.trackName = (TextView) v.findViewById(C0329R.id.primary_text);
        vh.durationText = (TextView) v.findViewById(C0329R.id.secondary_first_text);
        vh.textSeparator = (ImageView) v.findViewById(C0329R.id.list_text_separator);
        vh.textSeparator.setVisibility(0);
        vh.artistName = (TextView) v.findViewById(C0329R.id.secondary_second_text);
        vh.checkBox = (CheckBox) v.findViewById(C0329R.id.track_check_box);
        vh.checkBox.setClickable(false);
        v.setTag(vh);
        return v;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        ViewHolder vh = (ViewHolder) view.getTag();
        String trackDuration = UIHelper.makeTimeString(this.mContext, (long) cursor.getInt(this.mDurationIdx));
        vh.trackName.setText(cursor.getString(this.mTitleIdx));
        vh.artistName.setText(cursor.getString(this.mArtistIdx));
        vh.durationText.setText(trackDuration);
        long audioId = cursor.getLong(this.mAudioIdIdx);
        if (this.mPreviousAudioList.contains(Long.valueOf(audioId))) {
            vh.checkBox.setEnabled(false);
            vh.checkBox.setChecked(true);
            return;
        }
        vh.checkBox.setEnabled(true);
        vh.checkBox.setChecked(this.mSelectedAudioList.contains(Long.valueOf(audioId)));
    }

    public void changeCursor(Cursor cursor) {
        if (this.mActivity.isFinishing() && cursor != null) {
            cursor.close();
            cursor = null;
        }
        if (this.mFragment.swapCursor(cursor)) {
            super.changeCursor(cursor);
            getColumnIndices(cursor);
            if (cursor != null) {
                updatePrevAudioList();
                this.mMaxSelectableCount = cursor.getCount() - this.mPreviousAudioList.size();
            }
        }
        super.changeCursor(cursor);
    }

    public int getSelectedSize() {
        return this.mSelectedAudioList.size();
    }

    public boolean toggle(long id) {
        HashSet<Long> selected = this.mSelectedAudioList;
        if (selected.contains(Long.valueOf(id))) {
            selected.remove(Long.valueOf(id));
            return false;
        }
        selected.add(Long.valueOf(id));
        return true;
    }

    public void clearSelectAudioList() {
        this.mSelectedAudioList.clear();
    }

    public boolean isSelectAll() {
        return this.mSelectedAudioList.size() == this.mMaxSelectableCount;
    }

    public boolean selectAll() {
        Cursor cursor = getCursor();
        if (cursor == null) {
            return false;
        }
        int position = cursor.getPosition();
        HashSet<Long> prevList = this.mPreviousAudioList;
        HashSet<Long> selected = this.mSelectedAudioList;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            long audioId = cursor.getLong(0);
            if (!prevList.contains(Long.valueOf(audioId))) {
                selected.add(Long.valueOf(audioId));
            }
            cursor.moveToNext();
        }
        cursor.moveToPosition(position);
        return true;
    }

    private void updatePrevAudioList() {
        long[] audioIdList = null;
        if (this.mPlaylistId > 0) {
            audioIdList = PlaylistHelper.getLocalTrackListForPlaylist(this.mActivity, this.mPlaylistId);
        } else if (this.mPlaylistId == 0) {
            audioIdList = ServiceHelper.getQueue();
        }
        HashSet<Long> list = this.mPreviousAudioList;
        if (audioIdList != null) {
            for (long valueOf : audioIdList) {
                list.add(Long.valueOf(valueOf));
            }
        }
    }

    public long[] getSelectAudioList() {
        Cursor cursor = getCursor();
        if (cursor == null) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        HashSet<Long> list = this.mSelectedAudioList;
        long[] audioList = new long[list.size()];
        int position = cursor.getPosition();
        int index = 0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            long audioId = cursor.getLong(0);
            if (list.contains(Long.valueOf(audioId))) {
                int index2 = index + 1;
                audioList[index] = audioId;
                index = index2;
            }
            cursor.moveToNext();
        }
        cursor.moveToPosition(position);
        return audioList;
    }

    public int getMaxSelectableCount() {
        return this.mMaxSelectableCount;
    }
}
