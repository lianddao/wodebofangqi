package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class ScreenKeyboardCaller extends EditText {
    private boolean firstTime = true;
    private Handler tempHandler;

    public ScreenKeyboardCaller(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        if (this.firstTime) {
            this.tempHandler.sendEmptyMessage(1);
            this.firstTime = false;
        }
        super.onDraw(canvas);
    }

    public void setHandler(Handler inHandle) {
        this.tempHandler = inHandle;
    }

    public void clearShow() {
        this.firstTime = true;
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Log.i("ScreenKeyboard", "Create Input Connection");
        return super.onCreateInputConnection(outAttrs);
    }
}
