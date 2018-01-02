package com.miui.player.ui.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridLayout;
import android.widget.ListAdapter;
import com.miui.player.C0329R;
import com.miui.player.service.ShakeListener;

public class GridPreference extends Preference {
    private static final int TAG_INFO = 2130903076;
    private ListAdapter mAdapter;
    private final OnClickListener mClickListener;
    private DataSetObserver mDataSetObserver;
    private OnItemClickListener mItemClickListener;
    private int mLastCheckedChild;
    private boolean mLastEnabled;

    public interface OnItemClickListener {
        void onItemClick(GridPreference gridPreference, int i);
    }

    class C05281 implements OnClickListener {
        C05281() {
        }

        public void onClick(View v) {
            if (GridPreference.this.mItemClickListener != null) {
                GridPreference.this.mItemClickListener.onItemClick(GridPreference.this, ((Integer) v.getTag(2130903076)).intValue());
            }
        }
    }

    final class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        public void onChanged() {
            GridPreference.this.update();
        }

        public void onInvalidated() {
            GridPreference.this.update();
        }
    }

    public GridPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mLastEnabled = true;
        this.mLastCheckedChild = -1;
        this.mClickListener = new C05281();
        setLayoutResource(2130903076);
    }

    public GridPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridPreference(Context context) {
        this(context, null);
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        int paddingHorizon = view.getResources().getDimensionPixelSize(C0329R.dimen.grid_preference_padding_horizon);
        view.setPadding(paddingHorizon, view.getPaddingTop(), paddingHorizon, view.getPaddingBottom());
        updateGrid(view);
        super.setEnabled(this.mLastEnabled);
        setAllChildrenEnabled(view, this.mLastEnabled);
        if (this.mLastCheckedChild >= 0 && this.mAdapter != null && this.mLastCheckedChild < this.mAdapter.getCount()) {
            setAllChildrenSelected(view, false);
            setChildSelected(view, this.mLastCheckedChild, true);
        }
    }

    public void setAdapter(ListAdapter adapter) {
        if (!(this.mAdapter == null || this.mDataSetObserver == null)) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
            this.mDataSetObserver = null;
        }
        this.mAdapter = adapter;
        if (this.mAdapter != null) {
            this.mDataSetObserver = new MyDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
        }
        update();
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        this.mItemClickListener = l;
    }

    public void update() {
        notifyChanged();
    }

    private GridLayout getGridView(View root) {
        return (GridLayout) root.findViewById(16908298);
    }

    private void updateGrid(View root) {
        GridLayout grid = getGridView(root);
        if (this.mAdapter == null || grid.getColumnCount() == 0) {
            grid.removeAllViews();
            return;
        }
        int backgroundRes;
        int adapterCount = this.mAdapter.getCount();
        int childCount = grid.getChildCount();
        int reuseCount = Math.min(adapterCount, childCount);
        int index = 0;
        while (index < reuseCount) {
            View v = grid.getChildAt(index);
            if (v == this.mAdapter.getView(index, v, grid)) {
                v.setTag(2130903076, Integer.valueOf(index));
                index++;
            } else {
                throw new UnsupportedOperationException("convert view must be reused!");
            }
        }
        while (index < adapterCount) {
            v = this.mAdapter.getView(index, null, grid);
            grid.addView(v);
            v.setOnClickListener(this.mClickListener);
            v.setTag(2130903076, Integer.valueOf(index));
            index++;
        }
        if (index < childCount) {
            grid.removeViews(index, childCount - index);
        }
        if (adapterCount == 7 || adapterCount == 8) {
            backgroundRes = C0329R.drawable.headset_grid_bg_8;
        } else if (adapterCount == 5 || adapterCount == 6) {
            backgroundRes = C0329R.drawable.headset_grid_bg_6;
        } else if (adapterCount == 3 || adapterCount == 4) {
            backgroundRes = C0329R.drawable.headset_grid_bg_4;
        } else {
            backgroundRes = 0;
        }
        grid.setBackgroundResource(backgroundRes);
        grid.requestLayout();
    }

    public void setEnabled(boolean enabled) {
        this.mLastEnabled = enabled;
        update();
    }

    private void setAllChildrenEnabled(View root, boolean enabled) {
        GridLayout grid = getGridView(root);
        grid.setAlpha(enabled ? ShakeListener.ACCELATION_FACTOR_X : 0.3f);
        for (int i = 0; i < grid.getChildCount(); i++) {
            grid.getChildAt(i).setEnabled(enabled);
        }
    }

    private void setAllChildrenSelected(View root, boolean selected) {
        GridLayout grid = getGridView(root);
        for (int i = 0; i < grid.getChildCount(); i++) {
            grid.getChildAt(i).setSelected(selected);
        }
    }

    private void setChildSelected(View root, int index, boolean selected) {
        getGridView(root).getChildAt(index).setSelected(selected);
    }

    public void setChildSelected(int index) {
        this.mLastCheckedChild = index;
        update();
    }
}
