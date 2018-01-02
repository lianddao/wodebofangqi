package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.audiofx.BassBoost;
import android.media.audiofx.Equalizer;
import android.media.audiofx.PresetReverb;
import android.media.audiofx.Virtualizer;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

@TargetApi(9)
public class fum {
    private static fum f13522k;
    private gky f13523a;
    private Equalizer f13524b;
    private Virtualizer f13525c;
    private BassBoost f13526d;
    private PresetReverb f13527e;
    private short f13528f;
    private boolean f13529g = false;
    private List<gky> f13530h = new ArrayList();
    private String f13531i;
    private int f13532j = 0;

    public static fum m20996a() {
        if (f13522k == null) {
            f13522k = new fum();
        }
        return f13522k;
    }

    public void m21004a(Context context, int i) {
        if (gyn.m23226c()) {
            m21000k(i);
            m21009c();
            m21006a(gvj.m22935d());
        }
    }

    private void m21000k(int i) {
        try {
            this.f13524b = new Equalizer(0, i);
            this.f13528f = (short) (this.f13524b.getBandLevelRange()[1] / 15);
            this.f13532j = this.f13524b.getNumberOfBands();
        } catch (Throwable e) {
            this.f13532j = 0;
            exw.m18457e("EqualizerHelper", "initEqualizer error!=" + exw.m18438a(e));
        }
        try {
            this.f13526d = new BassBoost(0, i);
        } catch (Throwable e2) {
            exw.m18457e("EqualizerHelper", "initEqualizer error!=" + exw.m18438a(e2));
            fik.m19340a(eys.m18562a(), e2.getMessage());
        }
        try {
            this.f13527e = new PresetReverb(0, i);
        } catch (Throwable e22) {
            exw.m18457e("EqualizerHelper", "initEqualizer error!=" + exw.m18438a(e22));
            fik.m19340a(eys.m18562a(), e22.getMessage());
        }
        try {
            this.f13525c = new Virtualizer(0, i);
        } catch (Throwable e222) {
            exw.m18457e("EqualizerHelper", "initEqualizer error!=" + exw.m18438a(e222));
            fik.m19340a(eys.m18562a(), e222.getMessage());
        }
    }

    public void m21002a(int i) {
        if (this.f13532j >= 1) {
            try {
                if (this.f13524b != null) {
                    this.f13524b.setBandLevel((short) 0, (short) (this.f13528f * i));
                }
            } catch (Exception e) {
                exw.m18457e("EqualizerHelper", "setEq60HzBandLevel error, level=" + i);
            }
        }
    }

    public void m21008b(int i) {
        if (this.f13532j >= 2) {
            try {
                if (this.f13524b != null) {
                    this.f13524b.setBandLevel((short) 1, (short) (this.f13528f * i));
                }
            } catch (Exception e) {
                exw.m18457e("EqualizerHelper", "setEq230HzBandLevel error, level=" + i);
            }
        }
    }

    public void m21010c(int i) {
        if (this.f13532j >= 3) {
            try {
                if (this.f13524b != null) {
                    this.f13524b.setBandLevel((short) 2, (short) (this.f13528f * i));
                }
            } catch (Exception e) {
                exw.m18457e("EqualizerHelper", "setEq910HzBandLevel error, level=" + i);
            }
        }
    }

    public void m21012d(int i) {
        if (this.f13532j >= 4) {
            try {
                if (this.f13524b != null) {
                    this.f13524b.setBandLevel((short) 3, (short) (this.f13528f * i));
                }
            } catch (Exception e) {
                exw.m18457e("EqualizerHelper", "setEq3600HzBandLevel error, level=" + i);
            }
        }
    }

    public void m21014e(int i) {
        if (this.f13532j >= 5) {
            try {
                if (this.f13524b != null) {
                    this.f13524b.setBandLevel((short) 4, (short) (this.f13528f * i));
                }
            } catch (Exception e) {
                exw.m18457e("EqualizerHelper", "setEq14000HzBandLevel error, level=" + i);
            }
        }
    }

    public void m21016f(int i) {
        if (m21017g().m22287j() != i) {
            try {
                if (this.f13525c != null) {
                    this.f13525c.setStrength((short) i);
                }
            } catch (Throwable e) {
                exw.m18457e("EqualizerHelper", "setVirtualerStrength error, strength=" + i + ", error=" + exw.m18438a(e));
            }
            m21017g().m22284h(i);
        }
    }

    public void m21018g(int i) {
        if (m21017g().m22285i() != i) {
            try {
                if (this.f13526d != null) {
                    this.f13526d.setStrength((short) i);
                }
            } catch (Throwable e) {
                exw.m18457e("EqualizerHelper", "setBassBootStrength error, strength=" + i + ", error=" + exw.m18438a(e));
            }
            m21017g().m22282g(i);
        }
    }

    public void m21019h(int i) {
        if (m21017g().m22288k() != i) {
            try {
                if (this.f13527e != null) {
                    this.f13527e.setPreset((short) i);
                }
            } catch (Throwable e) {
                exw.m18457e("EqualizerHelper", "setReverbPreset error, preset=" + i + ", error=" + exw.m18438a(e));
            }
            m21017g().m22286i(i);
        }
    }

    public void m21007b() {
        if (VERSION.SDK_INT >= 9) {
            m20997h();
            try {
                if (this.f13524b != null) {
                    this.f13524b.release();
                    this.f13524b = null;
                }
                if (this.f13525c != null) {
                    this.f13525c.release();
                    this.f13525c = null;
                }
                if (this.f13526d != null) {
                    this.f13526d.release();
                    this.f13526d = null;
                }
                if (this.f13527e != null) {
                    this.f13527e.release();
                    this.f13527e = null;
                }
                f13522k = null;
            } catch (Exception e) {
                exw.m18457e("EqualizerHelper", "release error=" + e);
            }
        }
    }

    private void m20997h() {
        if (!fik.m19344b(eys.m18562a())) {
            try {
                String str = "";
                for (short s = (short) 0; s < this.f13532j; s = (short) (s + 1)) {
                    str = str + "(" + this.f13524b.getCenterFreq(s) + "-";
                    String str2 = str;
                    for (int i : this.f13524b.getBandFreqRange(s)) {
                        str2 = str2 + "-" + i;
                    }
                    str = str2 + "), ";
                }
                fik.m19339a(eys.m18562a(), this.f13532j, str);
            } catch (Exception e) {
            }
        }
    }

    public void m21006a(boolean z) {
        this.f13529g = z;
        gvj.m22902a(z);
        try {
            if (this.f13524b != null) {
                this.f13524b.setEnabled(z);
            }
        } catch (Throwable e) {
            exw.m18457e("EqualizerHelper", "enableEqualizer, error=" + exw.m18438a(e));
        }
        try {
            if (this.f13525c != null) {
                this.f13525c.setEnabled(z);
            }
        } catch (Throwable e2) {
            exw.m18457e("EqualizerHelper", "enableEqualizer, error=" + exw.m18438a(e2));
        }
        try {
            if (this.f13526d != null) {
                this.f13526d.setEnabled(z);
            }
        } catch (Throwable e22) {
            exw.m18457e("EqualizerHelper", "enableEqualizer, error=" + exw.m18438a(e22));
        }
        try {
            if (this.f13527e != null) {
                this.f13527e.setEnabled(z);
            }
        } catch (Throwable e222) {
            exw.m18457e("EqualizerHelper", "enableEqualizer, error=" + exw.m18438a(e222));
        }
    }

    public void m21020i(int i) {
        gvj.m22929d(eys.m18562a(), i);
    }

    public void m21005a(gky com_ushareit_listenit_gky) {
        m21017g().m22272b(com_ushareit_listenit_gky.m22275d());
        m21017g().m22274c(com_ushareit_listenit_gky.m22277e());
        m21017g().m22276d(com_ushareit_listenit_gky.m22279f());
        m21017g().m22278e(com_ushareit_listenit_gky.m22281g());
        m21017g().m22280f(com_ushareit_listenit_gky.m22283h());
        m21020i(m21017g().m22271b());
    }

    public void m21009c() {
        gky e = m21013e();
        try {
            m21002a(e.m22275d());
            m21008b(e.m22277e());
            m21010c(e.m22279f());
            m21012d(e.m22281g());
            m21014e(e.m22283h());
        } catch (Throwable e2) {
            exw.m18457e("EqualizerHelper", "applyUserSelectedEqualizer error=" + exw.m18438a(e2));
        }
        gky g = m21017g();
        try {
            if (this.f13526d != null) {
                this.f13526d.setStrength((short) g.m22285i());
            }
        } catch (Throwable e22) {
            exw.m18457e("EqualizerHelper", "applyUserSelectedEqualizer error=" + exw.m18438a(e22));
        }
        try {
            if (this.f13525c != null) {
                this.f13525c.setStrength((short) g.m22287j());
            }
        } catch (Throwable e222) {
            exw.m18457e("EqualizerHelper", "applyUserSelectedEqualizer error=" + exw.m18438a(e222));
        }
        try {
            if (this.f13527e != null) {
                this.f13527e.setPreset((short) g.m22288k());
            }
        } catch (Throwable e2222) {
            exw.m18457e("EqualizerHelper", "applyUserSelectedEqualizer error=" + exw.m18438a(e2222));
        }
    }

    public List<gky> m21011d() {
        if (this.f13530h.size() > 0 && !m20998i()) {
            return this.f13530h;
        }
        m20999j();
        return this.f13530h;
    }

    private boolean m20998i() {
        String language = eys.m18562a().getResources().getConfiguration().locale.getLanguage();
        boolean z = fbb.m18763c(this.f13531i) || !language.equals(this.f13531i);
        if (!z) {
            language = this.f13531i;
        }
        this.f13531i = language;
        return z;
    }

    private void m20999j() {
        gky g = m21017g();
        g.m22266a(0);
        g.m22268a(m21001l(C0349R.string.equalizer_preset_custom));
        this.f13530h.clear();
        this.f13530h.add(g);
        this.f13530h.add(new gky(1, m21001l(C0349R.string.equalizer_preset_normal), 3, 0, 0, 0, 3, 0, 0, 0));
        this.f13530h.add(new gky(2, m21001l(C0349R.string.equalizer_preset_pop), -1, 2, 5, 1, -2, 0, 0, 0));
        this.f13530h.add(new gky(3, m21001l(C0349R.string.equalizer_preset_rock), 5, 3, -1, 3, 5, 0, 0, 0));
        this.f13530h.add(new gky(4, m21001l(C0349R.string.equalizer_preset_jazz), 4, 2, -2, 2, 5, 0, 0, 0));
        this.f13530h.add(new gky(5, m21001l(C0349R.string.equalizer_preset_dance), 6, 0, 2, 4, 1, 0, 0, 0));
        this.f13530h.add(new gky(6, m21001l(C0349R.string.equalizer_preset_classical), 5, 3, -2, 4, 4, 0, 0, 0));
        this.f13530h.add(new gky(7, m21001l(C0349R.string.equalizer_preset_straightness), 0, 0, 0, 0, 0, 0, 0, 0));
        this.f13530h.add(new gky(8, m21001l(C0349R.string.equalizer_preset_folk), 3, 0, 0, 2, -1, 0, 0, 0));
        this.f13530h.add(new gky(9, m21001l(C0349R.string.equalizer_preset_heavymetal), 4, 1, 9, 3, 0, 0, 0, 0));
        this.f13530h.add(new gky(10, m21001l(C0349R.string.equalizer_preset_hiphop), 5, 3, 0, 1, 3, 0, 0, 0));
        this.f13530h.add(new gky(11, m21001l(C0349R.string.equalizer_preset_acoustic), 5, 3, 2, 4, 4, 0, 0, 0));
        this.f13530h.add(new gky(12, m21001l(C0349R.string.equalizer_preset_bassboost), 6, 4, 1, 0, 0, 0, 0, 0));
        this.f13530h.add(new gky(13, m21001l(C0349R.string.equalizer_preset_trebleboost), 0, 0, 1, 4, 6, 0, 0, 0));
        this.f13530h.add(new gky(14, m21001l(C0349R.string.equalizer_preset_volcalboost), 6, 3, 1, 3, 6, 0, 0, 0));
        this.f13530h.add(new gky(15, m21001l(C0349R.string.equalizer_preset_headphone), -3, -2, 3, 2, -1, 0, 0, 0));
        this.f13530h.add(new gky(16, m21001l(C0349R.string.equalizer_preset_deep), 6, 5, 0, 3, 0, 0, 0, 0));
        this.f13530h.add(new gky(17, m21001l(C0349R.string.equalizer_preset_electronic), 5, 0, 3, 0, -4, 0, 0, 0));
        this.f13530h.add(new gky(18, m21001l(C0349R.string.equalizer_preset_latin), 5, 0, 0, 0, 5, 0, 0, 0));
        this.f13530h.add(new gky(19, m21001l(C0349R.string.equalizer_preset_loud), 3, 0, -1, 0, 3, 0, 0, 0));
        this.f13530h.add(new gky(20, m21001l(C0349R.string.equalizer_preset_lounge), 5, 0, -1, -4, 3, 0, 0, 0));
        this.f13530h.add(new gky(21, m21001l(C0349R.string.equalizer_preset_piano), -3, 0, 3, -1, 1, 0, 0, 0));
        this.f13530h.add(new gky(22, m21001l(C0349R.string.equalizer_preset_rb), 3, 2, 2, 4, 4, 0, 0, 0));
    }

    private String m21001l(int i) {
        return eys.m18562a().getResources().getString(i);
    }

    public gky m21013e() {
        gky j = m21021j(gvj.m23008n(eys.m18562a()));
        j.m22282g(m21017g().m22285i());
        j.m22284h(m21017g().m22287j());
        j.m22286i(m21017g().m22288k());
        return j;
    }

    public gky m21021j(int i) {
        for (gky com_ushareit_listenit_gky : m21011d()) {
            if (i == com_ushareit_listenit_gky.m22271b()) {
                return com_ushareit_listenit_gky;
            }
        }
        return null;
    }

    public List<String> m21015f() {
        List<String> arrayList = new ArrayList();
        arrayList.add(m21001l(C0349R.string.reverb_preset_none));
        arrayList.add(m21001l(C0349R.string.reverb_preset_smallroom));
        arrayList.add(m21001l(C0349R.string.reverb_preset_mediumroom));
        arrayList.add(m21001l(C0349R.string.reverb_preset_largeroom));
        arrayList.add(m21001l(C0349R.string.reverb_preset_mediumhall));
        arrayList.add(m21001l(C0349R.string.reverb_preset_largehall));
        arrayList.add(m21001l(C0349R.string.reverb_preset_plate));
        return arrayList;
    }

    public void m21003a(Context context) {
        gvj.m22896a(context, this.f13523a);
    }

    public gky m21017g() {
        if (this.f13523a == null) {
            this.f13523a = gvj.m23003m(eys.m18562a());
        }
        return this.f13523a;
    }
}
