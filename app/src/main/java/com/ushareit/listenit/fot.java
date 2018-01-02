package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.ushareit.listenit.cutter.AudioCutterActivity;
import com.ushareit.listenit.cutter.RingEditActivity;

public class fot implements OnItemClickListener {
    final /* synthetic */ AudioCutterActivity f13118a;

    public fot(AudioCutterActivity audioCutterActivity) {
        this.f13118a = audioCutterActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (fpm.f13141d.contains(gyn.m23235e(this.f13118a.f9039q.m20227a(i).f14342j))) {
            Intent intent = new Intent(this.f13118a, RingEditActivity.class);
            intent.putExtra("songId", this.f13118a.f9039q.m20227a(i).f14334b);
            this.f13118a.startActivity(intent);
            fii.m19320f(this.f13118a, "navigation");
            return;
        }
        heb.m23597a(this.f13118a.getString(C0349R.string.cutter_list_not_support), 1).show();
    }
}
