package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.ushareit.listenit.main.MainActivity;
import java.util.ArrayList;

public class gta extends fji {
    private gal f14691a;
    private ViewGroup aA;
    private Runnable aB = new gtp(this);
    private OnClickListener aC = new gtq(this);
    private TextWatcher aD = new gtr(this);
    private String aE = null;
    private OnClickListener aF = new gtu(this);
    private OnClickListener aG = new gtv(this);
    private OnClickListener aH = new gtc(this);
    private OnEditorActionListener aI = new gtd(this);
    private OnClickListener aJ = new gte(this);
    private OnClickListener aK = new gtf(this);
    private OnClickListener aL = new gtg(this);
    private OnClickListener aM = new gth(this);
    private guo aN = new gti(this);
    private OnScrollListener aO = new gtj(this);
    private gsp aP = new gtk(this);
    private OnClickListener aQ = new gtl(this);
    private fmb aR = new gtn(this);
    private fml aS = new gto(this);
    private View aj;
    private View ak;
    private View al;
    private Button am;
    private EditText an;
    private ImageView ao;
    private ImageView ap;
    private ImageView aq;
    private View ar;
    private InputMethodManager as;
    private SparseArray<ArrayList<gla>> at = new SparseArray();
    private SparseIntArray au;
    private SparseIntArray av;
    private gum aw;
    private boolean ax = false;
    private boolean ay = false;
    private boolean az = false;
    private gsz f14692b;
    private ExpandableListView f14693c;
    private ListView f14694d;
    private gsx f14695e;
    private gsj f14696f;
    private View f14697g;
    private View f14698h;
    private View f14699i;

    public gta() {
        m19526a(false);
        this.ay = true;
        this.f14692b = new gsz();
        fiv.m19443a(m1326l(), "all");
        this.az = fqo.m20421c();
    }

    public gta(gal com_ushareit_listenit_gal) {
        m19526a(false);
        this.f14691a = com_ushareit_listenit_gal;
        this.ay = false;
        this.f14692b = new gsz();
        this.au = new SparseIntArray();
        this.au.put(0, C0349R.string.search_fragment_edit_hint_songs);
        this.au.put(1, C0349R.string.search_fragment_edit_hint_artists);
        this.au.put(2, C0349R.string.search_fragment_edit_hint_albums);
        this.au.put(3, C0349R.string.search_fragment_edit_hint_folders);
        this.au.put(5, C0349R.string.search_fragment_edit_hint_in_artist);
        this.au.put(6, C0349R.string.search_fragment_edit_hint_in_album);
        this.au.put(7, C0349R.string.search_fragment_edit_hint_in_folder);
        this.av = new SparseIntArray();
        this.av.put(1, C0349R.string.search_fragment_header_artists);
        this.av.put(2, C0349R.string.search_fragment_header_albums);
        this.av.put(3, C0349R.string.search_fragment_header_folders);
        this.az = fqo.m20421c();
        fiv.m19443a(m1326l(), gyn.m23181a(this.f14691a.mo2565a()));
    }

    public View mo2388a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m1328m().getWindow().setSoftInputMode(16);
        if (this.ay) {
            this.aA = (ViewGroup) layoutInflater.inflate(C0349R.layout.all_search_fragment, viewGroup, false);
            m22743b(this.aA);
        } else {
            this.aA = (ViewGroup) layoutInflater.inflate(C0349R.layout.classified_search_fragment, viewGroup, false);
            m22746c(this.aA);
        }
        m22738a(this.aA);
        if (gyn.m23217b()) {
            gyn.m23224c(this.ak, fbb.m18766e(m1326l()));
        } else {
            this.aA.removeView(this.ak);
        }
        mo2607d();
        return this.aA;
    }

    private void m22738a(View view) {
        this.al = view.findViewById(C0349R.id.nothing_search_result);
        this.ao = (ImageView) view.findViewById(C0349R.id.back);
        this.ak = view.findViewById(C0349R.id.status_fake_bar);
        this.ap = (ImageView) view.findViewById(C0349R.id.search);
        this.an = (EditText) view.findViewById(C0349R.id.edit);
        this.am = (Button) view.findViewById(C0349R.id.globle_search);
        this.aq = (ImageView) view.findViewById(C0349R.id.search_delete);
        Button button = (Button) view.findViewById(C0349R.id.cloud_search);
        this.an.setHint(m1275a(m22765U()));
        this.an.setFilters(new InputFilter[]{new LengthFilter(40)});
        this.an.requestFocus();
        this.an.setFocusable(true);
        this.an.addTextChangedListener(this.aD);
        this.an.setOnEditorActionListener(this.aI);
        this.ao.setOnClickListener(this.aF);
        this.ap.setOnClickListener(this.aG);
        this.am.setOnClickListener(this.aH);
        this.aq.setVisibility(4);
        this.aq.setOnClickListener(this.aC);
        if (this.az && (this.ay || this.f14691a.mo2565a() == 0)) {
            button.setVisibility(0);
            button.setOnClickListener(this.aQ);
            return;
        }
        button.setVisibility(8);
    }

    public int m22765U() {
        if (this.ay) {
            return C0349R.string.search_fragment_search_hint;
        }
        int a = this.f14691a.mo2565a();
        return this.au.indexOfKey(a) >= 0 ? this.au.get(a) : C0349R.string.search_fragment_edit_hint_in_playlist;
    }

    public void mo2607d() {
        if (m1326l() != null && (m1326l() instanceof MainActivity)) {
            if (this.ay) {
                fez.m19057a(m1326l(), this.f14693c);
            } else {
                fez.m19057a(m1326l(), this.f14694d);
            }
        }
    }

    private void m22743b(View view) {
        this.ar = view.findViewById(C0349R.id.search_views);
        this.f14693c = (ExpandableListView) view.findViewById(C0349R.id.list_view);
        this.f14697g = view.findViewById(C0349R.id.search_songs);
        this.f14698h = view.findViewById(C0349R.id.search_artists);
        this.f14699i = view.findViewById(C0349R.id.search_album);
        this.aj = view.findViewById(C0349R.id.search_folder);
        this.f14696f = new gsj(m1326l());
        this.f14693c.setAdapter(this.f14696f);
        if (this.az) {
            this.f14696f.m22697a(this.aP);
        }
        this.f14696f.m22696a(new gtw(this, new gax()));
        this.f14696f.m22700b(new gtw(this, new gah()));
        this.f14696f.m22702c(new gtw(this, new gaj()));
        this.f14696f.m22703d(new gtw(this, new gao()));
        this.f14697g.setOnClickListener(this.aJ);
        this.f14698h.setOnClickListener(this.aK);
        this.f14699i.setOnClickListener(this.aL);
        this.aj.setOnClickListener(this.aM);
        this.f14693c.setOnScrollListener(this.aO);
    }

    private void m22746c(View view) {
        this.f14694d = (ListView) view.findViewById(C0349R.id.list_view);
        View inflate = View.inflate(m1326l(), C0349R.layout.search_fragment_list_group_view, null);
        TextView textView = (TextView) inflate.findViewById(C0349R.id.search_result_group_name);
        inflate.findViewById(C0349R.id.online_search_view).setVisibility(8);
        textView.setText(m1275a(m22769c(this.f14691a.mo2565a())));
        this.f14695e = new gsx(m1326l(), this.f14691a);
        this.f14695e.m22725a(new gtw(this, this.f14691a));
        this.f14694d.addHeaderView(inflate);
        this.f14694d.setAdapter(this.f14695e);
        this.f14694d.setOnScrollListener(this.aO);
    }

    public int m22769c(int i) {
        return this.av.indexOfKey(i) >= 0 ? this.av.get(i) : C0349R.string.search_fragment_header_songs;
    }

    public void mo2548a(gum com_ushareit_listenit_gum) {
        this.aw = com_ushareit_listenit_gum;
        com_ushareit_listenit_gum.mo2416a(this.aN);
    }

    public void mo201x() {
        this.ax = false;
        if (this.aw != null) {
            this.aw.mo2416a(this.aN);
            if (gef.m21805a().m21835e()) {
                flw.m19819a().m19830a(this.aR);
                fmc.m19867a().m19887a(this.aS);
            }
        }
        this.an.postDelayed(this.aB, 400);
        m22735V();
        super.mo201x();
    }

    public void mo202y() {
        if (this.aw != null) {
            this.aw.mo2430b(this.aN);
            if (gef.m21805a().m21835e()) {
                flw.m19819a().m19836b(this.aR);
                fmc.m19867a().m19892b(this.aS);
            }
        }
        super.mo202y();
    }

    public void mo2550c() {
        hhx.m23867a(new gtb(this));
    }

    private void m22735V() {
        hhx.m23867a(new gtm(this));
    }

    private void m22736W() {
        this.f14692b.m22732a();
        if (this.ay) {
            this.f14692b.m22733a(0, (ArrayList) fqs.m20466d());
            this.f14692b.m22733a(1, (ArrayList) fqs.m20471g());
            this.f14692b.m22733a(2, (ArrayList) fqs.m20477j());
            this.f14692b.m22733a(3, (ArrayList) fqs.m20479l());
            return;
        }
        this.f14692b.m22733a(this.f14691a.mo2565a(), (ArrayList) this.f14691a.mo2568d());
    }

    public boolean mo2549b() {
        fio.m19367b(m1326l(), "back");
        return false;
    }

    public void mo174g() {
        if (!this.ax) {
            m22737X();
        }
        super.mo174g();
    }

    public void mo175h() {
        if (VERSION.SDK_INT >= 11) {
            m1328m().getWindow().setSoftInputMode(48);
        } else {
            m1328m().getWindow().setSoftInputMode(0);
        }
        super.mo175h();
    }

    public void mo171e() {
        m22737X();
        super.mo171e();
    }

    private void m22737X() {
        if (this.as == null) {
            this.as = (InputMethodManager) m1326l().getSystemService("input_method");
        }
        if (this.an.getWindowToken() != null) {
            this.as.hideSoftInputFromWindow(this.an.getWindowToken(), 0);
        }
    }

    private void m22747c(String str) {
        if (this.ay) {
            m22749d(str);
        } else {
            m22751e(str);
        }
    }

    private void m22749d(String str) {
        this.aE = str;
        hhx.m23867a(new gts(this, str));
    }

    private void m22751e(String str) {
        hhx.m23867a(new gtt(this, str));
    }
}
