package com.ushareit.listenit;

import android.media.AudioManager.OnAudioFocusChangeListener;

class hgj implements OnAudioFocusChangeListener {
    final /* synthetic */ hgi f15413a;
    private boolean f15414b = false;

    hgj(hgi com_ushareit_listenit_hgi) {
        this.f15413a = com_ushareit_listenit_hgi;
    }

    public void onAudioFocusChange(int i) {
        if (this.f15413a.f15410c != null) {
            switch (i) {
                case -3:
                case -2:
                    if (this.f15413a.f15408a.mo2771b()) {
                        this.f15414b = true;
                        this.f15413a.f15410c.onAudioFocusChange(i);
                        return;
                    }
                    this.f15414b = false;
                    this.f15413a.f15411d.abandonAudioFocus(this.f15413a.f15412e);
                    return;
                case -1:
                    this.f15413a.f15411d.abandonAudioFocus(this.f15413a.f15412e);
                    if (this.f15413a.f15408a.mo2771b()) {
                        this.f15413a.f15410c.onAudioFocusChange(i);
                        return;
                    }
                    return;
                case 1:
                    if (this.f15414b) {
                        this.f15413a.f15410c.onAudioFocusChange(i);
                    }
                    this.f15414b = false;
                    return;
                default:
                    this.f15413a.f15410c.onAudioFocusChange(i);
                    return;
            }
        }
    }
}
