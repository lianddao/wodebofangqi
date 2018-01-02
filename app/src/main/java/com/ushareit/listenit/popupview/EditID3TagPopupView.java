package com.ushareit.listenit.popupview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ak;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.goq;
import com.ushareit.listenit.gor;
import com.ushareit.listenit.gos;
import com.ushareit.listenit.got;
import com.ushareit.listenit.gou;
import com.ushareit.listenit.gov;
import com.ushareit.listenit.gow;
import com.ushareit.listenit.gox;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.widget.LineEditView;
import java.math.BigDecimal;

public class EditID3TagPopupView extends BasePopupView {
    private LineEditView f16161a;
    private LineEditView f16162b;
    private LineEditView f16163c;
    private View f16164d;
    private TextView f16165e;
    private TextView f16166f;
    private TextView f16167g;
    private View f16168h;
    private TextView f16169i;
    private TextView f16170j;
    private TextView f16171k;
    private TextView f16172l;
    private View f16173m;
    private InputMethodManager f16174n;
    private gox f16175o;
    private Context f16176p;
    private glg f16177q;
    private boolean f16178r = false;
    private int f16179s;
    private OnClickListener f16180t = new goq(this);
    private OnClickListener f16181u = new gor(this);
    private TextWatcher f16182v = new gos(this);
    private TextWatcher f16183w = new got(this);
    private TextWatcher f16184x = new gou(this);
    private OnEditorActionListener f16185y = new gov(this);
    private Runnable f16186z = new gow(this);

    public EditID3TagPopupView(Context context, int i) {
        super(context);
        this.f16176p = context;
        this.f16179s = i;
        m25577a(context, (ViewGroup) this);
    }

    public void m25577a(Context context, ViewGroup viewGroup) {
        ((ak) context).getWindow().setSoftInputMode(16);
        View inflate = View.inflate(context, C0349R.layout.popup_view_id3_tag_edit, viewGroup);
        this.f16161a = (LineEditView) inflate.findViewById(C0349R.id.name_edit);
        this.f16162b = (LineEditView) inflate.findViewById(C0349R.id.artist_edit);
        this.f16163c = (LineEditView) inflate.findViewById(C0349R.id.album_edit);
        this.f16165e = (TextView) inflate.findViewById(C0349R.id.submit);
        this.f16166f = (TextView) inflate.findViewById(C0349R.id.cancel);
        this.f16167g = (TextView) inflate.findViewById(C0349R.id.song_duration);
        this.f16169i = (TextView) inflate.findViewById(C0349R.id.song_size);
        this.f16168h = inflate.findViewById(C0349R.id.song_size_views);
        this.f16170j = (TextView) inflate.findViewById(C0349R.id.song_path);
        this.f16164d = inflate.findViewById(C0349R.id.song_path_area);
        this.f16171k = (TextView) inflate.findViewById(C0349R.id.song_name_text);
        this.f16172l = (TextView) inflate.findViewById(C0349R.id.song_artist_text);
        this.f16173m = inflate.findViewById(C0349R.id.song_album_area);
        this.f16165e.setOnClickListener(this.f16181u);
        this.f16166f.setOnClickListener(this.f16180t);
    }

    public void setOnID3TagListener(gox com_ushareit_listenit_gox) {
        this.f16175o = com_ushareit_listenit_gox;
    }

    private void m25564a() {
        if (this.f16177q != null) {
            if (gyn.m23260p(this.f16177q.f14342j)) {
                this.f16161a.setVisibility(8);
                this.f16162b.setVisibility(8);
                this.f16163c.setVisibility(8);
                this.f16171k.setVisibility(0);
                this.f16172l.setVisibility(0);
                this.f16173m.setVisibility(8);
            } else {
                this.f16161a.m26315a(this.f16182v);
                this.f16161a.postDelayed(this.f16186z, 400);
                this.f16162b.m26315a(this.f16183w);
                this.f16163c.m26315a(this.f16184x);
                this.f16163c.setOnEditorActionListener(this.f16185y);
            }
            if (gyn.m23260p(this.f16177q.f14342j)) {
                this.f16171k.setText(this.f16177q.f14338f);
                this.f16172l.setText(this.f16177q.f14339g);
                this.f16167g.setText(gyn.m23182a((long) this.f16177q.f14337e));
                this.f16169i.setText(this.f16177q.f14344l > 0 ? m25563a(this.f16177q.f14344l) : getResources().getString(C0349R.string.unknown));
                this.f16164d.setVisibility(8);
                this.f16166f.setVisibility(8);
                return;
            }
            this.f16161a.setText(this.f16177q.f14338f);
            this.f16162b.setText(this.f16177q.f14339g);
            this.f16163c.setText(this.f16177q.f14340h);
            this.f16167g.setText(gyn.m23182a((long) this.f16177q.f14337e));
            this.f16169i.setText(m25563a(this.f16177q.f14344l));
            this.f16170j.setText(this.f16177q.f14342j);
        }
    }

    private String m25563a(int i) {
        return String.valueOf(new BigDecimal((((double) i) / 1024.0d) / 1024.0d).setScale(2, 4).doubleValue()) + getResources().getString(C0349R.string.popup_id3_tag_edit_unit);
    }

    public void mo2997c() {
        m25569a(this.f16163c);
        super.mo2997c();
    }

    public void mo2995a(gum com_ushareit_listenit_gum) {
        super.mo2995a(com_ushareit_listenit_gum);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public int getGravity() {
        return 17;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
        if (com_ushareit_listenit_gla != null) {
            this.f16177q = (glg) com_ushareit_listenit_gla;
            m25564a();
        }
    }

    public void setTitle(String str) {
    }

    @SuppressLint({"InlinedApi"})
    protected void onDetachedFromWindow() {
        if (this.f16176p != null) {
            if (VERSION.SDK_INT >= 11) {
                ((ak) this.f16176p).getWindow().setSoftInputMode(48);
            } else {
                ((ak) this.f16176p).getWindow().setSoftInputMode(0);
            }
            super.onDetachedFromWindow();
        }
    }

    private void m25565a(glg com_ushareit_listenit_glg) {
        String obj = this.f16161a.getText().toString();
        if (!(fbb.m18763c(obj) || com_ushareit_listenit_glg.f14338f.equals(obj))) {
            com_ushareit_listenit_glg.f14338f = obj;
            this.f16178r = true;
        }
        obj = this.f16162b.getText().toString();
        if (!(fbb.m18763c(obj) || com_ushareit_listenit_glg.f14338f.equals(obj))) {
            com_ushareit_listenit_glg.f14339g = obj;
            this.f16178r = true;
        }
        obj = this.f16163c.getText().toString();
        if (!fbb.m18763c(obj) && !com_ushareit_listenit_glg.f14338f.equals(obj)) {
            com_ushareit_listenit_glg.f14340h = obj;
            this.f16178r = true;
        }
    }

    private void m25569a(LineEditView lineEditView) {
        if (this.f16174n == null) {
            this.f16174n = (InputMethodManager) getContext().getSystemService("input_method");
        }
        if (lineEditView.getWindowToken() != null) {
            this.f16174n.hideSoftInputFromWindow(lineEditView.getWindowToken(), 0);
        }
    }

    private void m25570a(boolean z) {
        if (z) {
            this.f16165e.setEnabled(true);
            if (gzd.m23364e() == 1) {
                this.f16165e.setTextColor(getResources().getColorStateList(C0349R.color.common_text_orange_bg_night));
            } else if (gzd.m23364e() == 2) {
                this.f16165e.setTextColor(gzd.m23355a());
            } else {
                this.f16165e.setTextColor(getResources().getColorStateList(C0349R.color.common_text_orange_bg));
            }
        }
    }
}
