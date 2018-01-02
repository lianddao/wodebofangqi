package com.ushareit.listenit;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class brb implements brh {
    private final AssetManager f7490a;
    private final bsf<? super brb> f7491b;
    private Uri f7492c;
    private InputStream f7493d;
    private long f7494e;
    private boolean f7495f;

    public brb(Context context, bsf<? super brb> com_ushareit_listenit_bsf__super_com_ushareit_listenit_brb) {
        this.f7490a = context.getAssets();
        this.f7491b = com_ushareit_listenit_bsf__super_com_ushareit_listenit_brb;
    }

    public long mo1088a(brk com_ushareit_listenit_brk) {
        try {
            this.f7492c = com_ushareit_listenit_brk.f7504a;
            String path = this.f7492c.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.f7493d = this.f7490a.open(path, 1);
            if (this.f7493d.skip(com_ushareit_listenit_brk.f7507d) < com_ushareit_listenit_brk.f7507d) {
                throw new EOFException();
            }
            if (com_ushareit_listenit_brk.f7508e != -1) {
                this.f7494e = com_ushareit_listenit_brk.f7508e;
            } else {
                this.f7494e = (long) this.f7493d.available();
                if (this.f7494e == 2147483647L) {
                    this.f7494e = -1;
                }
            }
            this.f7495f = true;
            if (this.f7491b != null) {
                this.f7491b.mo1098a((Object) this, com_ushareit_listenit_brk);
            }
            return this.f7494e;
        } catch (IOException e) {
            throw new brc(e);
        }
    }

    public int mo1087a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f7494e == 0) {
            return -1;
        }
        try {
            if (this.f7494e != -1) {
                i2 = (int) Math.min(this.f7494e, (long) i2);
            }
            int read = this.f7493d.read(bArr, i, i2);
            if (read != -1) {
                if (this.f7494e != -1) {
                    this.f7494e -= (long) read;
                }
                if (this.f7491b != null) {
                    this.f7491b.mo1097a((Object) this, read);
                }
                return read;
            } else if (this.f7494e == -1) {
                return -1;
            } else {
                throw new brc(new EOFException());
            }
        } catch (IOException e) {
            throw new brc(e);
        }
    }

    public void mo1089a() {
        this.f7492c = null;
        try {
            if (this.f7493d != null) {
                this.f7493d.close();
            }
            this.f7493d = null;
            if (this.f7495f) {
                this.f7495f = false;
                if (this.f7491b != null) {
                    this.f7491b.mo1096a(this);
                }
            }
        } catch (IOException e) {
            throw new brc(e);
        } catch (Throwable th) {
            this.f7493d = null;
            if (this.f7495f) {
                this.f7495f = false;
                if (this.f7491b != null) {
                    this.f7491b.mo1096a(this);
                }
            }
        }
    }
}
