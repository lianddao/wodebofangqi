package com.miui.player.ui.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import com.miui.player.ui.controller.MultiChoiceController;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.ui.menu.common.MenuContextInfo;
import com.miui.player.ui.menu.common.MenuManager;
import java.util.Set;

public abstract class BaseMenuManager<T> implements MenuManager<T>, BaseMenuId {
    protected Activity mActivity;
    private BaseAdapter mAdapter;
    private final Context mContext;
    private Set<T> mSelected;
    private final int mSelectionMsgId;

    protected abstract T getKeyFromItem(Object obj);

    public BaseMenuManager(Activity a, int msgId) {
        this.mActivity = a;
        this.mSelectionMsgId = msgId;
        this.mContext = a;
    }

    public void setAdapter(BaseAdapter adapter) {
        this.mAdapter = adapter;
    }

    protected MenuContextInfo<T> getContextInfo() {
        return null;
    }

    protected Set<T> getLastSelected() {
        return this.mSelected;
    }

    public void prepareActionMenu(Menu menu, Set<T> set) {
    }

    public void handleActionItem(MenuItem item, Set<T> selected) {
        this.mSelected = selected;
        MenuContextInfo<T> ctx = getContextInfo();
        if (ctx != null && ctx.mMultiChoiceController != null) {
            MultiChoiceController<T> mcc = ctx.mMultiChoiceController;
            switch (item.getItemId()) {
                case 16908313:
                    mcc.leave();
                    return;
                case 16908314:
                    if (mcc.isAllSelected()) {
                        mcc.clean();
                        return;
                    } else {
                        mcc.selectAll();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public final CharSequence getSelectionMsg(int size) {
        return this.mContext.getResources().getQuantityString(this.mSelectionMsgId, size, new Object[]{Integer.valueOf(size)});
    }

    public final void notifyDataSetChanged() {
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public final T keyAt(int position) {
        if (this.mAdapter != null) {
            Object obj = this.mAdapter.getItem(position);
            if (obj != null) {
                return getKeyFromItem(obj);
            }
        }
        return null;
    }

    public boolean onContextItemSelected(MenuItem item) {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void onDialogResult(int requestCode, boolean confirm, Intent intent) {
    }

    public boolean onMenuItemClick(MenuItem item) {
        if (getContextInfo() != null) {
            MultiChoiceController<T> mcc = getContextInfo().mMultiChoiceController;
            if (mcc != null) {
                handleActionItem(item, mcc.getCachedSet());
            }
        }
        return true;
    }
}
