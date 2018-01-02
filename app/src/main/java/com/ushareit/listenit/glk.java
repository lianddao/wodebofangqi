package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.musicfolders.MusicFoldersActivity;
import java.util.ArrayList;
import java.util.List;

public class glk implements OnClickListener {
    final /* synthetic */ MusicFoldersActivity f14363a;

    public glk(MusicFoldersActivity musicFoldersActivity) {
        this.f14363a = musicFoldersActivity;
    }

    public void onClick(View view) {
        List<gkz> a = this.f14363a.f15972p.m22366a();
        List arrayList = new ArrayList();
        for (gkz com_ushareit_listenit_gkz : a) {
            if (!com_ushareit_listenit_gkz.m20780f()) {
                arrayList.add(com_ushareit_listenit_gkz.f14279c);
            }
        }
        if (gse.m22670a().m22675b(arrayList)) {
            this.f14363a.finish();
            return;
        }
        gse.m22670a().m22672a(arrayList);
        gse.m22670a().m22673b();
        this.f14363a.finish();
    }
}
