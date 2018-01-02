package com.miui.player.ui.menu.common;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.miui.player.ui.DialogCallback;
import com.miui.player.ui.controller.MultiChoiceController.MultiChoiceItemProvider;

public interface MenuManager<T> extends MultiChoiceItemProvider<T>, DialogCallback, OnMenuItemClickListener {
    boolean onContextItemSelected(MenuItem menuItem);

    boolean onCreateOptionsMenu(Menu menu);

    boolean onOptionsItemSelected(MenuItem menuItem);

    boolean onPrepareOptionsMenu(Menu menu);
}
