package com.ushareit.listenit.musicfolders;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fjk;
import com.ushareit.listenit.gkz;
import com.ushareit.listenit.gli;
import com.ushareit.listenit.glj;
import com.ushareit.listenit.glk;
import com.ushareit.listenit.gll;
import com.ushareit.listenit.gse;
import com.ushareit.listenit.gzc;
import com.ushareit.listenit.hhx;
import java.util.List;

public class MusicFoldersActivity extends fjk {
    private View f15970n;
    private ListView f15971o;
    private gll f15972p;
    private View f15973q;
    private View f15974r;
    private View f15975s;
    private int f15976t = 0;
    private OnItemClickListener f15977y = new glj(this);
    private OnClickListener f15978z = new glk(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gzc.m23341a((Activity) this, (int) C0349R.color.common_actionbar_color);
        setContentView(C0349R.layout.popup_view_audio_folder);
        setTitle(C0349R.string.setting_music_folders_title);
        m5103d(8);
        this.f15971o = (ListView) findViewById(C0349R.id.list_view);
        this.f15973q = findViewById(C0349R.id.progress_view);
        this.f15974r = findViewById(C0349R.id.progress_bar);
        this.f15975s = findViewById(C0349R.id.no_audio_folder);
        this.f15970n = findViewById(C0349R.id.confirm);
        this.f15970n.setOnClickListener(this.f15978z);
        this.f15972p = new gll();
        this.f15971o.setAdapter(this.f15972p);
        this.f15971o.setOnItemClickListener(this.f15977y);
        m25088j();
    }

    private void m25088j() {
        hhx.m23867a(new gli(this));
    }

    private void m25081a(List<gkz> list) {
        for (gkz com_ushareit_listenit_gkz : list) {
            com_ushareit_listenit_gkz.m20775a(!gse.m22670a().m22674b(com_ushareit_listenit_gkz.f14279c));
        }
    }

    private void m25084c(int i) {
        this.f15976t = ((this.f15976t >> i) & 1) == 1 ? this.f15976t & ((1 << i) ^ -1) : this.f15976t | (1 << i);
    }

    private boolean m25089p() {
        return this.f15976t > 0;
    }

    public boolean mo539h() {
        return false;
    }

    public boolean mo540i() {
        return false;
    }
}
