package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.ads.C0016g;
import com.facebook.ads.af;
import com.facebook.ads.an;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAdView;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alc extends amp implements amn {
    private static final String f4637a = alc.class.getSimpleName();
    private View f4638b;
    private buo f4639c;
    private amq f4640d;
    private NativeAdView f4641e;
    private View f4642f;
    private boolean f4643g;
    private Uri f4644h;
    private Uri f4645i;
    private String f4646j;
    private String f4647k;
    private String f4648l;
    private String f4649m;

    private void m6007a(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    public void mo669a(int i) {
    }

    public void mo670a(Context context, amq com_ushareit_listenit_amq, apa com_ushareit_listenit_apa, Map<String, Object> map) {
        boolean z;
        boolean z2;
        atz.m7169a(context, aut.m7225a(mo699z()) + " Loading");
        JSONObject jSONObject = (JSONObject) map.get("data");
        String optString = jSONObject.optString("ad_unit_id");
        JSONArray optJSONArray = jSONObject.optJSONArray("creative_types");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i = 0;
            z = false;
            z2 = false;
            while (i < length) {
                try {
                    String string = optJSONArray.getString(i);
                    if (string != null) {
                        boolean z3 = true;
                        switch (string.hashCode()) {
                            case 704091517:
                                if (string.equals("app_install")) {
                                    z3 = false;
                                    break;
                                }
                                break;
                            case 883765328:
                                if (string.equals("page_post")) {
                                    z3 = true;
                                    break;
                                }
                                break;
                        }
                        switch (z3) {
                            case false:
                                z2 = true;
                                break;
                            case true:
                                z = true;
                                break;
                            default:
                                break;
                        }
                    }
                    i++;
                } catch (JSONException e) {
                    atz.m7169a(context, aut.m7225a(mo699z()) + " AN server error");
                    com_ushareit_listenit_amq.mo94a(this, C0016g.f612d);
                    return;
                }
            }
        }
        z = false;
        z2 = false;
        if (TextUtils.isEmpty(optString) || !(z2 || z)) {
            atz.m7169a(context, aut.m7225a(mo699z()) + " AN server error");
            com_ushareit_listenit_amq.mo94a(this, C0016g.f612d);
            return;
        }
        this.f4640d = com_ushareit_listenit_amq;
        btw com_ushareit_listenit_btw = new btw(context, optString);
        if (z2) {
            com_ushareit_listenit_btw.m9844a(new ald(this, context));
        }
        if (z) {
            com_ushareit_listenit_btw.m9845a(new ale(this, context));
        }
        com_ushareit_listenit_btw.m9842a(new alf(this, context)).m9843a(new bus().m9906a(true).m9903a()).m9841a().m9840a(new btz().m9848a());
    }

    public void mo671a(View view, List<View> list) {
        this.f4638b = view;
        if (mo677d() && view != null) {
            ViewGroup viewGroup;
            int i;
            int i2 = -1;
            ViewGroup viewGroup2 = null;
            while (true) {
                ViewGroup viewGroup3 = (ViewGroup) view.getParent();
                if (viewGroup3 == null) {
                    Log.e(f4637a, "View must have valid parent for AdMob registration, skipping registration. Impressions and clicks will not be logged.");
                    return;
                }
                if (viewGroup3 instanceof NativeAdView) {
                    viewGroup = (ViewGroup) viewGroup3.getParent();
                    if (viewGroup == null) {
                        Log.e(f4637a, "View must have valid parent for AdMob registration, skipping registration. Impressions and clicks will not be logged.");
                        return;
                    }
                    int indexOfChild = viewGroup.indexOfChild(viewGroup3);
                    viewGroup3.removeView(view);
                    viewGroup.removeView(viewGroup3);
                    viewGroup.addView(view, indexOfChild);
                    i = i2;
                    viewGroup = viewGroup2;
                } else {
                    viewGroup = viewGroup3;
                    i = viewGroup3.indexOfChild(view);
                }
                if (viewGroup != null) {
                    break;
                }
                i2 = i;
                viewGroup2 = viewGroup;
            }
            View nativeContentAdView = this.f4639c instanceof buv ? new NativeContentAdView(view.getContext()) : new NativeAppInstallAdView(view.getContext());
            if (view instanceof ViewGroup) {
                nativeContentAdView.setLayoutParams(view.getLayoutParams());
            }
            m6007a(view);
            nativeContentAdView.addView(view);
            viewGroup.removeView(nativeContentAdView);
            viewGroup.addView(nativeContentAdView, i);
            this.f4641e = nativeContentAdView;
            this.f4641e.setNativeAd(this.f4639c);
            this.f4642f = new View(view.getContext());
            this.f4641e.addView(this.f4642f);
            this.f4642f.setVisibility(8);
            if (this.f4641e instanceof NativeContentAdView) {
                ((NativeContentAdView) this.f4641e).setCallToActionView(this.f4642f);
            } else if (this.f4641e instanceof NativeAppInstallAdView) {
                ((NativeAppInstallAdView) this.f4641e).setCallToActionView(this.f4642f);
            }
            OnClickListener com_ushareit_listenit_alg = new alg(this);
            for (View onClickListener : list) {
                onClickListener.setOnClickListener(com_ushareit_listenit_alg);
            }
        }
    }

    public void mo672a(amq com_ushareit_listenit_amq) {
        this.f4640d = com_ushareit_listenit_amq;
    }

    public void mo673a(Map<String, String> map) {
        if (mo677d() && this.f4640d != null) {
            this.f4640d.mo95b(this);
        }
    }

    public void mo674b() {
        mo676c();
        this.f4640d = null;
        this.f4639c = null;
        this.f4643g = false;
        this.f4644h = null;
        this.f4645i = null;
        this.f4646j = null;
        this.f4647k = null;
        this.f4648l = null;
        this.f4649m = null;
    }

    public void mo675b(Map<String, String> map) {
    }

    public void mo676c() {
        m6007a(this.f4642f);
        this.f4642f = null;
        if (this.f4638b != null) {
            View view = (ViewGroup) this.f4638b.getParent();
            if ((view instanceof NativeContentAdView) || (view instanceof NativeAppInstallAdView)) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    int indexOfChild = viewGroup.indexOfChild(view);
                    m6007a(this.f4638b);
                    m6007a(view);
                    viewGroup.addView(this.f4638b, indexOfChild);
                }
            }
            this.f4638b = null;
        }
        this.f4641e = null;
    }

    public boolean mo677d() {
        return this.f4643g && this.f4639c != null;
    }

    public boolean mo678e() {
        return false;
    }

    public boolean mo679f() {
        return false;
    }

    public boolean mo680g() {
        return false;
    }

    public boolean mo681h() {
        return false;
    }

    public int mo682i() {
        return 0;
    }

    public int mo683j() {
        return 0;
    }

    public int mo684k() {
        return 0;
    }

    public an mo685l() {
        return (!mo677d() || this.f4645i == null) ? null : new an(this.f4645i.toString(), 50, 50);
    }

    public an mo686m() {
        return (!mo677d() || this.f4644h == null) ? null : new an(this.f4644h.toString(), 1200, 600);
    }

    public String mo687n() {
        return this.f4646j;
    }

    public String mo688o() {
        return this.f4647k;
    }

    public String mo689p() {
        return this.f4648l;
    }

    public an mo690q() {
        return null;
    }

    public String mo691r() {
        return null;
    }

    public String mo692s() {
        return null;
    }

    public String mo693t() {
        return null;
    }

    public String mo694u() {
        return null;
    }

    public atm mo695v() {
        return atm.UNKNOWN;
    }

    public String mo696w() {
        return null;
    }

    public List<af> mo697x() {
        return null;
    }

    public String mo698y() {
        return null;
    }

    public alj mo699z() {
        return alj.ADMOB;
    }
}
