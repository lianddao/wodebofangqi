package com.ushareit.listenit.popupview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gns;
import com.ushareit.listenit.gnu;
import com.ushareit.listenit.gnv;
import com.ushareit.listenit.gnw;
import com.ushareit.listenit.gnx;
import com.ushareit.listenit.gny;
import com.ushareit.listenit.gnz;
import com.ushareit.listenit.goa;
import com.ushareit.listenit.gob;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.guo;
import com.ushareit.listenit.gup;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gyp;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.het;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhx;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;
import java.util.ArrayList;
import java.util.List;

public class ActivePlaylistPopupView extends BasePopupView {
    private List<glg> f16115a = new ArrayList();
    private View f16116b;
    private DragSortListView f16117c;
    private gob f16118d;
    private TextView f16119e;
    private ImageView f16120f;
    private View f16121g;
    private gum f16122h;
    private String f16123i;
    private AddToPlaylistPopupView f16124j;
    private OnItemClickListener f16125k = new gnu(this);
    private het f16126l = new gnv(this);
    private OnClickListener f16127m = new gnw(this);
    private OnClickListener f16128n = new gnx(this);
    private OnClickListener f16129o = new gny(this);
    private gup f16130p = new gnz(this);
    private guo f16131q = new goa(this);

    public ActivePlaylistPopupView(Context context, String str) {
        super(context);
        m25526a(context, (ViewGroup) this);
        this.f16123i = str;
    }

    public void m25526a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_active_playlist, viewGroup);
        this.f16117c = (DragSortListView) inflate.findViewById(C0349R.id.list_view);
        this.f16120f = (ImageView) inflate.findViewById(C0349R.id.play_mode);
        this.f16119e = (TextView) inflate.findViewById(C0349R.id.title);
        this.f16116b = inflate.findViewById(C0349R.id.add_to_playlist);
        this.f16121g = inflate.findViewById(C0349R.id.clear);
        this.f16120f.setOnClickListener(this.f16127m);
        this.f16116b.setOnClickListener(this.f16128n);
        this.f16121g.setOnClickListener(this.f16129o);
        this.f16118d = new gob(this);
        this.f16117c.setDropListener(this.f16126l);
        this.f16117c.setOnItemClickListener(this.f16125k);
        m25515a(this.f16118d.getCount());
    }

    public void mo2995a(gum com_ushareit_listenit_gum) {
        this.f16122h = com_ushareit_listenit_gum;
        this.f16122h.mo2416a(this.f16131q);
        this.f16122h.mo2417a(this.f16130p);
        this.f16117c.setAdapter(this.f16118d);
        this.f16120f.setImageDrawable(m25518b(this.f16122h.mo2453j()));
        m25522d();
        super.mo2995a(com_ushareit_listenit_gum);
    }

    private void m25522d() {
        hhx.m23867a(new gns(this));
    }

    public boolean m25528a() {
        return this.f16124j != null ? this.f16124j.m25541a() : false;
    }

    public void mo2996b() {
        if (this.f16122h != null) {
            this.f16122h.mo2416a(this.f16131q);
            this.f16122h.mo2417a(this.f16130p);
            m25522d();
        }
        super.mo2996b();
    }

    public void mo2997c() {
        super.mo2997c();
    }

    protected void onDetachedFromWindow() {
        if (this.f16122h != null) {
            this.f16122h.mo2430b(this.f16131q);
            this.f16122h.mo2431b(this.f16130p);
        }
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int i, int i2) {
        gyn.m23224c(this.f16117c, (int) (((float) fbb.m18764d(getContext())) * 0.7f));
        super.onMeasure(i, i2);
    }

    public int getGravity() {
        return 80;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }

    private void m25515a(int i) {
        this.f16119e.setText(getResources().getString(C0349R.string.active_playlist_title, new Object[]{Integer.valueOf(i)}));
    }

    private int getCurrSongIndex() {
        if (!gyp.m23285b()) {
            return 0;
        }
        long l = gyp.m23298l();
        for (int i = 0; i < this.f16115a.size(); i++) {
            if (((glg) this.f16115a.get(i)).f14334b == l) {
                return i;
            }
        }
        return 0;
    }

    private int m25512a(boolean z) {
        return z ? C0349R.string.common_shuffle_enable_play : C0349R.string.common_shuffle_disable_play;
    }

    private Drawable m25518b(boolean z) {
        Drawable drawable = getResources().getDrawable(z ? C0349R.drawable.player_shuffle_enable_black_bg : C0349R.drawable.player_shuffle_disable_black_bg);
        int e = gzd.m23364e();
        if (e == 2) {
            if (z) {
                return hhe.m23348a(drawable, gzd.m23358b());
            }
            return drawable;
        } else if (e != 1) {
            return drawable;
        } else {
            if (z) {
                return hhe.m23351c(drawable, getResources().getColor(C0349R.color.common_text_color_orange_night_1));
            }
            return hhe.m23351c(drawable, getResources().getColor(C0349R.color.common_menu_icon_night));
        }
    }
}
