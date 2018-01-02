package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.songbirdnest.mediaplayer.C0116R;

public class PlayIcon extends ImageView {
    private boolean isPlaying;

    class C04501 implements OnTouchListener {
        C04501() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (!PlayIcon.this.isPlaying) {
                switch (event.getAction()) {
                    case 0:
                        PlayIcon.this.setImageResource(C0116R.drawable.row_play_button_pressed);
                        break;
                    case 1:
                    case 3:
                        PlayIcon.this.setImageResource(C0116R.drawable.row_play_button);
                        break;
                    default:
                        PlayIcon.this.setImageResource(C0116R.drawable.row_play_button_pressed);
                        break;
                }
            }
            return false;
        }
    }

    public PlayIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        setImageResource(C0116R.drawable.row_play_button);
        setOnTouchListener(new C04501());
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        if (isPlaying) {
            setImageResource(C0116R.drawable.row_listening_button);
        } else {
            setImageResource(C0116R.drawable.row_play_button);
        }
        this.isPlaying = isPlaying;
    }
}
