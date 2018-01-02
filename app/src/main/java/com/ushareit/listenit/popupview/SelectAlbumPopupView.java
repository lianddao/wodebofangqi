package com.ushareit.listenit.popupview;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fig;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.fju;
import com.ushareit.listenit.frf;
import com.ushareit.listenit.fzi;
import com.ushareit.listenit.gkv;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gra;
import com.ushareit.listenit.grb;
import com.ushareit.listenit.grc;
import com.ushareit.listenit.gyn;
import java.io.File;

public class SelectAlbumPopupView extends BasePopupView {
    private String f16264a = "SelectAlbumPopupView";
    private String f16265b;
    private String f16266c;
    private fjf f16267d;
    private File f16268e = null;
    private glg f16269f;
    private OnClickListener f16270g = new gra(this);
    private OnClickListener f16271h = new grb(this);
    private fju f16272i = new grc(this);

    public SelectAlbumPopupView(Context context, gla com_ushareit_listenit_gla, String str) {
        super(context);
        if (com_ushareit_listenit_gla != null) {
            if (com_ushareit_listenit_gla instanceof glg) {
                this.f16269f = (glg) com_ushareit_listenit_gla;
                this.f16265b = this.f16269f.f14340h;
            } else if (com_ushareit_listenit_gla instanceof gkv) {
                this.f16265b = ((gkv) com_ushareit_listenit_gla).f14244c;
            } else {
                return;
            }
            this.f16266c = str;
            this.f16267d = (fjf) getContext();
            m25644a(context, (ViewGroup) this);
        }
    }

    public void m25644a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_change_album_art, viewGroup);
        View findViewById = inflate.findViewById(C0349R.id.user_album);
        View findViewById2 = inflate.findViewById(C0349R.id.user_internet);
        findViewById.setOnClickListener(this.f16271h);
        findViewById2.setOnClickListener(this.f16270g);
        if (!fzi.f13764a) {
            findViewById2.setVisibility(8);
            inflate.findViewById(C0349R.id.divider).setVisibility(8);
        }
        fig.m19280b(eys.m18562a(), this.f16266c);
    }

    public int getGravity() {
        return 17;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }

    private void m25640a(String str) {
        if (!fbb.m18763c(str)) {
            if (this.f16269f != null) {
                frf.m20646a(this.f16269f, str);
            } else {
                frf.m20649a(this.f16265b, str);
            }
            fig.m19278a(eys.m18562a(), "local");
        }
    }

    private int m25635a(Uri uri) {
        int dimension = (int) getResources().getDimension(C0349R.dimen.common_dimens_36dp);
        dimension = (Math.min(fbb.m18762c(getContext()), fbb.m18764d(getContext())) - dimension) - dimension;
        try {
            Options a = gyn.m23178a(getContext().getContentResolver().openInputStream(uri));
            if (a.outWidth > 0 && a.outHeight > 0) {
                dimension = Math.min(Math.min(a.outWidth, a.outHeight), dimension);
            }
        } catch (Exception e) {
            exw.m18457e(this.f16264a, "getCropAlbumArtSize, decode inputStream error");
        }
        return dimension;
    }
}
