package com.miui.player.ui.model;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ResourceCursorAdapter;
import android.widget.SectionIndexer;
import com.miui.player.util.SectionCursor;
import com.miui.player.util.SectionCursor.SectionInfo;
import miui.widget.AlphabetFastIndexer;

public class SectionCursorAdapter extends ResourceCursorAdapter implements SectionIndexer {
    private static final int MIN_ITEM_COUNT = 9;
    private boolean mAutoRefresh = true;
    private final AlphabetFastIndexer mFastScroller;
    private AlphabetSectionIndexer mIndexer;
    private final String mTitleCol;
    private int mTitleIdx = -1;

    private class OnScrollerDecorator implements OnScrollListener {
        private final OnScrollListener mListener;

        public OnScrollerDecorator(OnScrollListener l) {
            if (SectionCursorAdapter.this.mFastScroller != null) {
                l = SectionCursorAdapter.this.mFastScroller.decorateScrollListener(l);
            }
            this.mListener = l;
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (this.mListener != null) {
                this.mListener.onScrollStateChanged(view, scrollState);
            }
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (this.mListener != null) {
                this.mListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
            if (SectionCursorAdapter.this.mFastScroller != null) {
                Cursor cursor = SectionCursorAdapter.this.getCursor();
                if (cursor != null && cursor.moveToPosition(firstVisibleItem)) {
                    String title = cursor.getString(SectionCursorAdapter.this.mTitleIdx);
                    if (!TextUtils.isEmpty(title)) {
                        String keyword = title.trim();
                        if (keyword.length() > 0) {
                            SectionCursorAdapter.this.mFastScroller.drawThumb(keyword.substring(0, 1));
                        }
                    }
                }
            }
        }
    }

    public SectionCursorAdapter(Context context, int layout, Cursor c, AlphabetFastIndexer fastIndexer, String titleCol) {
        super(context, layout, c, false);
        this.mFastScroller = fastIndexer;
        this.mTitleCol = titleCol;
    }

    public void bindView(View view, Context context, Cursor cursor) {
    }

    public void changeCursor(Cursor cursor) {
        super.changeCursor(cursor);
        if (cursor instanceof SectionCursor) {
            SectionInfo info = ((SectionCursor) cursor).getSectionInfo();
            this.mIndexer = new AlphabetSectionIndexer(info.mTitles, info.mCounts);
            this.mTitleIdx = cursor.getColumnIndex(this.mTitleCol);
            if (this.mAutoRefresh && this.mFastScroller != null) {
                this.mFastScroller.setVisibility(cursor.getCount() >= 9 ? 0 : 8);
                return;
            }
            return;
        }
        this.mIndexer = null;
        this.mTitleIdx = -1;
    }

    public int getPositionForSection(int section) {
        if (this.mIndexer != null) {
            return this.mIndexer.getPositionForSection(section);
        }
        return -1;
    }

    public int getSectionForPosition(int position) {
        if (this.mIndexer != null) {
            return this.mIndexer.getSectionForPosition(position);
        }
        return -1;
    }

    public Object[] getSections() {
        if (this.mIndexer != null) {
            return this.mIndexer.getSections();
        }
        return null;
    }

    public OnScrollListener decorateScrollListener(OnScrollListener l) {
        return new OnScrollerDecorator(l);
    }

    public void setAutoRefreshEnable(boolean enable) {
        this.mAutoRefresh = enable;
    }
}
