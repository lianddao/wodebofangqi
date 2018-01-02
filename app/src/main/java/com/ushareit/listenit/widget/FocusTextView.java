package com.ushareit.listenit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import com.ushareit.listenit.theme.entry.CustomThemeTextView;

public class FocusTextView extends CustomThemeTextView {
    public FocusTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @ExportedProperty(category = "focus")
    public boolean isFocused() {
        return true;
    }
}
