package com.ushareit.listenit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.ushareit.listenit.cutter.AudioClipsActivity;

public class foj implements OnItemClickListener {
    final /* synthetic */ AudioClipsActivity f13099a;

    public foj(AudioClipsActivity audioClipsActivity) {
        this.f13099a = audioClipsActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        gkx a = this.f13099a.f9025q.m20218a(i);
        if (this.f13099a.f9017A != null) {
            if (this.f13099a.f9017A.mo2464u() == a.f14254a) {
                this.f13099a.f9017A.mo2442d();
            } else {
                this.f13099a.f9017A.mo2428b(new glg(a));
            }
            this.f13099a.f9025q.notifyDataSetChanged();
        }
    }
}
