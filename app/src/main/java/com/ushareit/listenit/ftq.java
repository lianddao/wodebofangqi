package com.ushareit.listenit;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

class ftq implements OnTouchListener {
    TextView f13492a = null;
    ImageView f13493b = null;
    final /* synthetic */ ftl f13494c;

    ftq(ftl com_ushareit_listenit_ftl) {
        this.f13494c = com_ushareit_listenit_ftl;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        m20974a(view);
        switch (motionEvent.getAction()) {
            case 0:
                this.f13492a.setTextColor(this.f13494c.m1329n().getColor(C0349R.color.use_mobile_data_note_press));
                this.f13493b.setImageDrawable(this.f13494c.m1329n().getDrawable(C0349R.drawable.play_mobile_data_press));
                break;
            case 1:
            case 3:
                this.f13492a.setTextColor(this.f13494c.m1329n().getColor(C0349R.color.boost_value_text_color));
                this.f13493b.setImageDrawable(this.f13494c.m1329n().getDrawable(C0349R.drawable.play_mobile_data_normal));
                break;
        }
        return false;
    }

    private void m20974a(View view) {
        if (this.f13492a == null) {
            this.f13492a = (TextView) view.findViewById(C0349R.id.play_mobile_data_note_tv);
        }
        if (this.f13493b == null) {
            this.f13493b = (ImageView) view.findViewById(C0349R.id.mobile_play);
        }
    }
}
