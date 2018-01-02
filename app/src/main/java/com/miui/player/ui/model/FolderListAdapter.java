package com.miui.player.ui.model;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.fragment.FolderListFragment;
import com.miui.player.util.FolderProvider.Columns;
import miui.widget.AlphabetFastIndexer;

public class FolderListAdapter extends SectionCursorAdapter {
    public static final String[] FOLDER_COLUMNS = Columns.ALL_COLUMNS;
    public static final int SORT_KEY_IDX = Columns.SORT_KEY_IDX;
    private int mCountIdx;
    private final FolderListFragment mFragment;
    private final MultiChoiceController<String> mMultiChoiceController;
    private int mPathIdx;
    private int mTitleIdx;

    static class ViewHolder {
        TextView count;
        ImageView enterIndicator;
        ImageView listTextSeparator;
        TextView path;
        TextView title;

        ViewHolder() {
        }
    }

    public FolderListAdapter(Context context, FolderListFragment currentFragment, int layout, Cursor cursor, AlphabetFastIndexer fastIndexer, MultiChoiceController<String> controller) {
        super(context, layout, cursor, fastIndexer, "title");
        this.mFragment = currentFragment;
        this.mMultiChoiceController = controller;
        getColumnIndices(cursor);
    }

    private void getColumnIndices(Cursor cursor) {
        if (cursor != null) {
            this.mTitleIdx = cursor.getColumnIndexOrThrow("title");
            this.mPathIdx = cursor.getColumnIndexOrThrow("path");
            this.mCountIdx = cursor.getColumnIndexOrThrow(Columns.COUNT);
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.newView(context, cursor, parent);
        ViewHolder vh = new ViewHolder();
        vh.title = (TextView) v.findViewById(C0329R.id.primary_text);
        vh.count = (TextView) v.findViewById(C0329R.id.secondary_first_text);
        vh.listTextSeparator = (ImageView) v.findViewById(C0329R.id.list_text_separator);
        vh.path = (TextView) v.findViewById(C0329R.id.secondary_second_text);
        vh.enterIndicator = (ImageView) v.findViewById(C0329R.id.enter_indicator);
        v.setTag(vh);
        return v;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        ViewHolder vh = (ViewHolder) view.getTag();
        vh.title.setText(cursor.getString(this.mTitleIdx));
        vh.count.setText(UIHelper.format(context.getResources().getQuantityText(C0329R.plurals.Ntracks_format, cursor.getInt(this.mCountIdx)).toString(), Integer.valueOf(count)));
        vh.listTextSeparator.setVisibility(0);
        vh.path.setText(UIHelper.getDisplayFolderPath(cursor.getString(this.mPathIdx)));
        this.mMultiChoiceController.bindItemView(view, cursor.getPosition());
        this.mMultiChoiceController.setVisibilityAuto(vh.enterIndicator, 8);
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
}
