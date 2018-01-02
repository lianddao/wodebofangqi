package com.miui.player.ui.controller;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ListView;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.CollectionHelper;
import java.util.HashSet;
import java.util.Set;
import miui.v5.view.EditActionMode;

public class MultiChoiceController<T> implements MultiChoiceModeListener {
    static final String TAG = MultiChoiceController.class.getName();
    private Menu mActionMenu;
    private EditActionMode mActionMode;
    private final Set<T> mCachedSet;
    private final MultiChoiceItemProvider<T> mCallback;
    private final int mIgnoreHeaderCount;
    private ItemViewBinder mItemViewBinder;
    private final AbsListView mListView;
    private ModeChangedListener mModeChangedListener;
    private boolean mUpdateLocked;

    public interface ModeChangedListener {
        void onModeChanged(boolean z, AbsListView absListView);
    }

    public interface ItemViewBinder {
        boolean bindView(View view, boolean z, boolean z2);
    }

    public interface MultiChoiceItemProvider<E> {
        void createActionMenu(Menu menu, Set<E> set);

        CharSequence getSelectionMsg(int i);

        void handleActionItem(MenuItem menuItem, Set<E> set);

        E keyAt(int i);

        void notifyDataSetChanged();

        void prepareActionMenu(Menu menu, Set<E> set);
    }

    public MultiChoiceController(AbsListView lv, int ignoreHeaderCount, MultiChoiceItemProvider<T> callback) {
        this.mUpdateLocked = false;
        this.mCachedSet = new HashSet();
        this.mListView = lv;
        this.mIgnoreHeaderCount = ignoreHeaderCount;
        lv.setChoiceMode(3);
        lv.setMultiChoiceModeListener(this);
        this.mCallback = callback;
    }

    public MultiChoiceController(AbsListView lv, MultiChoiceItemProvider<T> callback) {
        this(lv, 0, callback);
    }

    public void setOnModeChangedListener(ModeChangedListener l) {
        this.mModeChangedListener = l;
    }

    public void setItemViewBinder(ItemViewBinder itemBinder) {
        this.mItemViewBinder = itemBinder;
    }

    private int getHeaderViewCount() {
        return UIHelper.getListViewHeaderCount(this.mListView);
    }

    private int getFooterViewCount() {
        return UIHelper.getListViewFooterCount(this.mListView);
    }

    public int selectAll() {
        AbsListView lv = this.mListView;
        int oldCount = lv.getCheckedItemCount();
        int headerCount = getHeaderViewCount() + this.mIgnoreHeaderCount;
        int total = lv.getCount() - getFooterViewCount();
        this.mUpdateLocked = true;
        for (int i = headerCount; i < total; i++) {
            lv.setItemChecked(i, true);
        }
        this.mUpdateLocked = false;
        updateMenu();
        this.mCallback.notifyDataSetChanged();
        if (this.mActionMode != null) {
            updateSelectionBar(total - headerCount);
        }
        return lv.getCheckedItemCount() - oldCount;
    }

    public int clean() {
        AbsListView lv = this.mListView;
        int count = lv.getCheckedItemCount();
        lv.clearChoices();
        this.mCachedSet.clear();
        updateMenu();
        this.mCallback.notifyDataSetChanged();
        if (this.mActionMode != null) {
            updateSelectionBar(0);
        }
        return count;
    }

    public boolean enter() {
        AbsListView v = this.mListView;
        if (v instanceof ListView) {
            ListView lv = (ListView) v;
            if (lv.getCount() <= lv.getHeaderViewsCount()) {
                return false;
            }
            lv.setItemChecked(-1, true);
            return true;
        }
        v.setItemChecked(-1, true);
        return true;
    }

    public boolean leave() {
        if (this.mActionMode == null) {
            return false;
        }
        this.mActionMode.finish();
        return true;
    }

    public boolean isEnabled() {
        return this.mActionMenu != null;
    }

    public void setVisibilityAuto(View view, int visibility) {
        if (isEnabled()) {
            view.setVisibility(visibility);
        } else {
            view.setVisibility(visibility == 0 ? 8 : 0);
        }
    }

    public boolean isAllSelected() {
        return this.mListView.getCount() <= ((this.mCachedSet.size() + getHeaderViewCount()) + getFooterViewCount()) + this.mIgnoreHeaderCount;
    }

    public boolean bindItemView(View itemView, int position) {
        if (this.mItemViewBinder == null) {
            return false;
        }
        return this.mItemViewBinder.bindView(itemView, this.mListView.isItemChecked(getHeaderViewCount() + position), isEnabled());
    }

    boolean setItemChecked(int position, boolean value) {
        if (this.mUpdateLocked || !isEnabled()) {
            return false;
        }
        this.mCallback.notifyDataSetChanged();
        return true;
    }

    public Set<T> getCachedSet() {
        return this.mCachedSet;
    }

    private void keepMultiChoiceState(boolean checked) {
        if (!checked && this.mCachedSet.isEmpty()) {
            this.mListView.setItemChecked(-1, true);
        }
    }

    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        if (this.mActionMenu != null) {
            Set<T> keys = this.mCachedSet;
            if (position < this.mIgnoreHeaderCount + getHeaderViewCount() || position >= this.mListView.getCount() - getFooterViewCount()) {
                keepMultiChoiceState(checked);
                return;
            }
            position -= getHeaderViewCount();
            T key = this.mCallback.keyAt(position);
            if (key != null) {
                if (checked) {
                    keys.add(key);
                } else {
                    keys.remove(key);
                }
            }
            if (!this.mUpdateLocked) {
                setItemChecked(position, checked);
                updateMenu();
                keepMultiChoiceState(checked);
            }
        }
    }

    public void updateMenu() {
        if (this.mActionMode != null) {
            this.mActionMode.invalidate();
            updateSelectionBar(this.mCachedSet.size());
        }
    }

    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        this.mCallback.handleActionItem(item, this.mCachedSet);
        return true;
    }

    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        this.mActionMode = (EditActionMode) mode;
        this.mActionMenu = menu;
        if (this.mModeChangedListener != null) {
            this.mModeChangedListener.onModeChanged(true, this.mListView);
        }
        this.mCallback.createActionMenu(menu, this.mCachedSet);
        updateSelectionBar(this.mCachedSet.size());
        return true;
    }

    public void onDestroyActionMode(ActionMode mode) {
        this.mCachedSet.clear();
        this.mActionMode = null;
        this.mActionMenu = null;
        if (this.mModeChangedListener != null) {
            this.mModeChangedListener.onModeChanged(false, this.mListView);
        }
    }

    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        this.mActionMenu = menu;
        if (this.mCallback != null) {
            boolean isEnabled = true;
            if (CollectionHelper.isEmpty(this.mCachedSet)) {
                isEnabled = false;
            }
            for (int i = 0; i < menu.size(); i++) {
                menu.getItem(i).setEnabled(isEnabled);
            }
            if (isEnabled) {
                this.mCallback.prepareActionMenu(menu, this.mCachedSet);
            }
        }
        return true;
    }

    private void updateTitleText(int size) {
        if (size == 0) {
            this.mActionMode.setTitle(101450235);
            return;
        }
        this.mActionMode.setTitle(String.format(MusicApplication.getApplication().getResources().getQuantityString(101711888, size), new Object[]{Integer.valueOf(size)}));
    }

    private void updateSelectionBar(int size) {
        if (this.mActionMode != null) {
            updateTitleText(size);
            this.mActionMode.setButton(16908314, isAllSelected() ? 101450234 : 101450237);
        }
    }
}
