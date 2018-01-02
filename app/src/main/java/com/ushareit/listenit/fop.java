package com.ushareit.listenit;

import com.ushareit.listenit.cutter.AudioCutterActivity;
import java.util.List;

public class fop extends hhw {
    List<glg> f13113a = null;
    final /* synthetic */ AudioCutterActivity f13114b;

    public fop(AudioCutterActivity audioCutterActivity) {
        this.f13114b = audioCutterActivity;
    }

    public void execute() {
        this.f13113a = fqs.m20467e();
    }

    public void callback() {
        if (this.f13113a != null) {
            if (this.f13113a.size() == 0) {
                this.f13114b.m12798j();
            }
            this.f13114b.f9039q.m20228a(this.f13113a);
            this.f13114b.f9031A.m27002a(this.f13113a, 0);
            this.f13114b.f9038p.setVisibility(8);
        }
    }
}
