package com.ushareit.listenit;

import android.database.Cursor;
import android.net.Uri;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class fzp implements vc<InputStream> {
    private gla f13775a;
    private fzu<InputStream> f13776b;
    private vc<InputStream> f13777c;
    private String f13778d;

    public /* synthetic */ Object mo584a(tv tvVar) {
        return m21429b(tvVar);
    }

    public fzp(gla com_ushareit_listenit_gla, String str, fzu com_ushareit_listenit_fzu) {
        this.f13775a = com_ushareit_listenit_gla;
        this.f13776b = com_ushareit_listenit_fzu;
        this.f13778d = str;
    }

    public InputStream m21429b(tv tvVar) {
        this.f13777c = m21424d();
        return this.f13777c != null ? (InputStream) this.f13777c.mo584a(tvVar) : null;
    }

    private vc<InputStream> m21424d() {
        List<glg> arrayList = new ArrayList();
        if (this.f13775a instanceof glg) {
            arrayList.add((glg) this.f13775a);
        } else {
            arrayList.addAll(fqs.m20453a(this.f13775a));
        }
        if (arrayList.size() == 0) {
            return this.f13776b.mo2632a(Integer.valueOf(C0349R.drawable.default_albumart_gray));
        }
        int i = 10;
        int i2 = -1;
        String str = null;
        String str2 = null;
        for (glg com_ushareit_listenit_glg : arrayList) {
            if (i == 0) {
                break;
            }
            i--;
            String str3 = com_ushareit_listenit_glg.f14343k;
            String str4 = "albumid:";
            if (!fbb.m18763c(str3) && str3.startsWith("albumid:") && str3.length() > "albumid:".length()) {
                try {
                    str3 = m21418a(Integer.parseInt(str3.substring("albumid:".length(), str3.length())));
                    if (!gyn.m23248i(str3)) {
                        str3 = "" + gyn.m23169a((gla) com_ushareit_listenit_glg);
                    }
                } catch (Exception e) {
                }
            }
            if (m21426e(str3)) {
                if (i2 == -1) {
                    i2 = (int) (Long.parseLong(str3) % 18);
                }
                if (!m21425d(str3)) {
                    continue;
                } else if (m21423c(com_ushareit_listenit_glg.f14340h) && m21423c(com_ushareit_listenit_glg.f14339g)) {
                    str2 = com_ushareit_listenit_glg.f14340h;
                    str = com_ushareit_listenit_glg.f14339g;
                }
            } else if (gyn.m23260p(str3)) {
                str = m21419a(com_ushareit_listenit_glg);
                String m = gyn.m23255m(str);
                if (m21422b(m)) {
                    return this.f13776b.mo2633a(m);
                }
                try {
                    fzw a = this.f13776b.mo2631a(Uri.parse(com_ushareit_listenit_glg.f14343k));
                    InputStream b = a.m21452b(tv.NORMAL);
                    if (b == null) {
                        return null;
                    }
                    m21420a(gyn.m23260p(com_ushareit_listenit_glg.f14342j), b, a.m21455d(), str);
                    return a;
                } catch (Throwable th) {
                    exw.m18457e("MediaFetcher", "loadData error=" + th.getMessage());
                    return null;
                }
            } else if (m21422b(str3)) {
                return this.f13776b.mo2633a(str3);
            }
            if (!fbb.m18763c(com_ushareit_listenit_glg.f14340h)) {
                str3 = gyn.m23255m(com_ushareit_listenit_glg.f14340h);
                if (m21422b(str3)) {
                    return this.f13776b.mo2633a(str3);
                }
            }
            if (gyn.m23260p(com_ushareit_listenit_glg.f14342j)) {
                continue;
            } else {
                byte[] a2 = m21421a(com_ushareit_listenit_glg.f14342j);
                if (a2 != null && a2.length > 0) {
                    return this.f13776b.mo2634a(a2);
                }
            }
        }
        if (fbb.m18763c(str) || fbb.m18763c(str2)) {
            if (i2 < 0 || i2 >= 18) {
                i2 = 1;
            }
            return this.f13776b.mo2632a(Integer.valueOf(gyn.f14929a[i2]));
        } else if (!gvk.m23054d()) {
            return null;
        } else {
            gnj b2 = gnf.m22479b(str, str2);
            if (b2 == null) {
                return null;
            }
            String a3 = b2.m22500a();
            if (fbb.m18763c(a3)) {
                if (i2 < 0 || i2 >= 18) {
                    i2 = 1;
                }
                frf.m20649a(str2, "" + (((System.currentTimeMillis() / 18) * 18) + ((long) i2)));
                return this.f13776b.mo2632a(Integer.valueOf(gyn.f14929a[i2]));
            }
            try {
                fzw a4 = this.f13776b.mo2631a(Uri.parse(a3));
                InputStream b3 = a4.m21452b(tv.HIGH);
                if (b3 == null) {
                    return null;
                }
                m21420a(false, b3, a4.m21455d(), str2);
                return a4;
            } catch (Exception e2) {
                exw.m18457e("MediaFetcher", "loadData error=" + e2.getMessage());
                return null;
            }
        }
    }

    private String m21419a(glg com_ushareit_listenit_glg) {
        return com_ushareit_listenit_glg.f14338f + " - " + com_ushareit_listenit_glg.f14339g;
    }

    private boolean m21422b(String str) {
        File file = new File(str);
        return file.exists() && file.length() > 0;
    }

    private void m21420a(boolean z, InputStream inputStream, int i, String str) {
        if (inputStream != null && i > 0 && !fbb.m18763c(str)) {
            hhx.m23867a(new fzq(this, inputStream, i, str, z));
        }
    }

    private boolean m21423c(String str) {
        return (fbb.m18763c(str) || eys.m18562a().getResources().getString(C0349R.string.unknown).equals(str)) ? false : true;
    }

    public void mo585a() {
        if (this.f13777c != null) {
            this.f13777c.mo585a();
        }
    }

    public String mo586b() {
        return this.f13778d;
    }

    public void mo587c() {
        if (this.f13777c != null) {
            this.f13777c.mo587c();
        }
    }

    private boolean m21425d(String str) {
        if (fbb.m18763c(str) || str.length() > 2) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0 || parseInt >= 18) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean m21426e(String str) {
        if (fbb.m18763c(str) || str.length() > 20) {
            return false;
        }
        try {
            if (Long.parseLong(str) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static synchronized byte[] m21421a(String str) {
        byte[] bArr;
        synchronized (fzp.class) {
            bArr = null;
            gyl com_ushareit_listenit_gyl = new gyl();
            try {
                if (com_ushareit_listenit_gyl.m23160a(str)) {
                    bArr = com_ushareit_listenit_gyl.m23161a();
                    if (com_ushareit_listenit_gyl != null) {
                        com_ushareit_listenit_gyl.m23162b();
                    }
                } else {
                    if (com_ushareit_listenit_gyl != null) {
                        com_ushareit_listenit_gyl.m23162b();
                    }
                }
            } catch (Exception e) {
                exw.m18457e("MediaFetcher", "retrieveAlbumArt error, path=" + str);
                if (com_ushareit_listenit_gyl != null) {
                    com_ushareit_listenit_gyl.m23162b();
                }
            } catch (Throwable th) {
                if (com_ushareit_listenit_gyl != null) {
                    com_ushareit_listenit_gyl.m23162b();
                }
            }
        }
        return bArr;
    }

    private String m21418a(int i) {
        Cursor query = eys.m18562a().getContentResolver().query(Uri.parse("content://media/external/audio/albums/" + i), new String[]{"album_art"}, null, null, null);
        if (query != null && query.getCount() > 0 && query.getColumnCount() > 0) {
            query.moveToNext();
            String string = query.getString(0);
            query.close();
            return string;
        } else if (query == null) {
            return null;
        } else {
            query.close();
            return null;
        }
    }
}
