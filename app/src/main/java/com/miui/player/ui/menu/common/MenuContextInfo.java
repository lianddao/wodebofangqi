package com.miui.player.ui.menu.common;

import com.miui.player.ui.controller.MultiChoiceController;

public abstract class MenuContextInfo<T> {
    public MultiChoiceController<T> mMultiChoiceController;

    public abstract boolean isValid();
}
