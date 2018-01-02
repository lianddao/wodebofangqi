package com.ushareit.listenit.popupview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.frf;
import com.ushareit.listenit.fzi;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gox;
import com.ushareit.listenit.gqg;
import com.ushareit.listenit.gqh;
import com.ushareit.listenit.gqj;
import com.ushareit.listenit.gqk;
import com.ushareit.listenit.gql;
import com.ushareit.listenit.gqm;
import com.ushareit.listenit.gqo;
import com.ushareit.listenit.gqq;
import com.ushareit.listenit.gqr;
import com.ushareit.listenit.gqs;
import com.ushareit.listenit.gqu;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gyp;

public class NormalPlayerMenu extends FrameLayout {
    public Runnable f16235a = new gqg(this);
    private View f16236b;
    private View f16237c;
    private View f16238d;
    private View f16239e;
    private View f16240f;
    private View f16241g;
    private View f16242h;
    private View f16243i;
    private View f16244j;
    private View f16245k;
    private gox f16246l;
    private gqu f16247m;
    private OnClickListener f16248n = new gqj(this);
    private OnClickListener f16249o = new gqk(this);
    private OnClickListener f16250p = new gql(this);
    private OnClickListener f16251q = new gqm(this);
    private OnClickListener f16252r = new gqo(this);
    private OnClickListener f16253s = new gqq(this);
    private OnClickListener f16254t = new gqr(this);
    private OnClickListener f16255u = new gqs(this);
    private OnClickListener f16256v = new gqh(this);

    public NormalPlayerMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25609a(context);
    }

    public NormalPlayerMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25609a(context);
    }

    public NormalPlayerMenu(Context context) {
        super(context);
        m25609a(context);
    }

    private void m25609a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.normal_player_menu, this);
        this.f16236b = inflate.findViewById(C0349R.id.menu);
        this.f16237c = inflate.findViewById(C0349R.id.edit_song_info);
        this.f16238d = inflate.findViewById(C0349R.id.sleep_timer);
        this.f16239e = inflate.findViewById(C0349R.id.share);
        this.f16240f = inflate.findViewById(C0349R.id.delete);
        this.f16241g = inflate.findViewById(C0349R.id.set_as_ringtone);
        this.f16242h = inflate.findViewById(C0349R.id.edit_lyric);
        this.f16243i = inflate.findViewById(C0349R.id.change_album_art);
        this.f16244j = inflate.findViewById(C0349R.id.go_to_album);
        this.f16245k = inflate.findViewById(C0349R.id.go_to_artist);
        this.f16237c.setOnClickListener(this.f16248n);
        this.f16238d.setOnClickListener(this.f16249o);
        this.f16239e.setOnClickListener(this.f16250p);
        this.f16240f.setOnClickListener(this.f16251q);
        this.f16241g.setOnClickListener(this.f16252r);
        this.f16242h.setOnClickListener(this.f16253s);
        this.f16243i.setOnClickListener(this.f16254t);
        this.f16244j.setOnClickListener(this.f16255u);
        this.f16245k.setOnClickListener(this.f16256v);
        if (!fzi.f13764a) {
            this.f16243i.setVisibility(8);
        }
        glg o = gyp.m23301o();
        if (o != null && gyn.m23260p(o.f14342j)) {
            this.f16243i.setVisibility(8);
            this.f16240f.setVisibility(8);
            this.f16241g.setVisibility(8);
            this.f16244j.setVisibility(8);
            this.f16245k.setVisibility(8);
        }
        post(this.f16235a);
    }

    public void setOnID3TagListener(gox com_ushareit_listenit_gox) {
        this.f16246l = com_ushareit_listenit_gox;
    }

    public void setOnDismissListener(gqu com_ushareit_listenit_gqu) {
        this.f16247m = com_ushareit_listenit_gqu;
    }

    private void m25610a(ConfirmPopupView confirmPopupView) {
        String string = getContext().getResources().getString(C0349R.string.confirm_view_delete_song_title, new Object[]{Integer.valueOf(1)});
        String string2 = getContext().getResources().getString(C0349R.string.confirm_view_delete_song_content);
        String string3 = getContext().getResources().getString(C0349R.string.confirm_view_delete_local_file);
        confirmPopupView.m25554a().setTitle(string);
        confirmPopupView.m25556d().setContent(string2);
        confirmPopupView.m25557f().setSelectDesc(string3);
    }

    private void m25613a(boolean z, glg com_ushareit_listenit_glg) {
        gyp.m23287c(com_ushareit_listenit_glg);
        frf.m20681g(com_ushareit_listenit_glg);
        if (z) {
            gyn.m23216b(com_ushareit_listenit_glg);
        }
    }

    private void m25608a() {
        if (this.f16247m != null) {
            this.f16247m.mo2750a();
        }
    }
}
