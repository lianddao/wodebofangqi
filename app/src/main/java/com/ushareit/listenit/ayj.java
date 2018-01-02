package com.ushareit.listenit;

import android.net.Uri;
import android.view.View;

public interface ayj {
    void mo113a(boolean z);

    void mo117c();

    void mo118d();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    ayk getState();

    ayk getTargetState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void pause();

    void seekTo(int i);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z);

    void setRequestedVolume(float f);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(ayl com_ushareit_listenit_ayl);

    void setup(Uri uri);

    void start();
}
