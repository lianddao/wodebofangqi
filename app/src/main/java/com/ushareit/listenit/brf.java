package com.ushareit.listenit;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class brf implements brh {
    private final ContentResolver f7496a;
    private final bsf<? super brf> f7497b;
    private Uri f7498c;
    private AssetFileDescriptor f7499d;
    private InputStream f7500e;
    private long f7501f;
    private boolean f7502g;

    public brf(Context context, bsf<? super brf> com_ushareit_listenit_bsf__super_com_ushareit_listenit_brf) {
        this.f7496a = context.getContentResolver();
        this.f7497b = com_ushareit_listenit_bsf__super_com_ushareit_listenit_brf;
    }

    public long mo1088a(brk com_ushareit_listenit_brk) {
        try {
            this.f7498c = com_ushareit_listenit_brk.f7504a;
            this.f7499d = this.f7496a.openAssetFileDescriptor(this.f7498c, "r");
            this.f7500e = new FileInputStream(this.f7499d.getFileDescriptor());
            if (this.f7500e.skip(com_ushareit_listenit_brk.f7507d) < com_ushareit_listenit_brk.f7507d) {
                throw new EOFException();
            }
            if (com_ushareit_listenit_brk.f7508e != -1) {
                this.f7501f = com_ushareit_listenit_brk.f7508e;
            } else {
                this.f7501f = (long) this.f7500e.available();
                if (this.f7501f == 0) {
                    this.f7501f = -1;
                }
            }
            this.f7502g = true;
            if (this.f7497b != null) {
                this.f7497b.mo1098a((Object) this, com_ushareit_listenit_brk);
            }
            return this.f7501f;
        } catch (IOException e) {
            throw new brg(e);
        }
    }

    public int mo1087a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f7501f == 0) {
            return -1;
        }
        try {
            if (this.f7501f != -1) {
                i2 = (int) Math.min(this.f7501f, (long) i2);
            }
            int read = this.f7500e.read(bArr, i, i2);
            if (read != -1) {
                if (this.f7501f != -1) {
                    this.f7501f -= (long) read;
                }
                if (this.f7497b != null) {
                    this.f7497b.mo1097a((Object) this, read);
                }
                return read;
            } else if (this.f7501f == -1) {
                return -1;
            } else {
                throw new brg(new EOFException());
            }
        } catch (IOException e) {
            throw new brg(e);
        }
    }

    public void mo1089a() {
        this.f7498c = null;
        try {
            if (this.f7500e != null) {
                this.f7500e.close();
            }
            this.f7500e = null;
            try {
                if (this.f7499d != null) {
                    this.f7499d.close();
                }
                this.f7499d = null;
                if (this.f7502g) {
                    this.f7502g = false;
                    if (this.f7497b != null) {
                        this.f7497b.mo1096a(this);
                    }
                }
            } catch (IOException e) {
                throw new brg(e);
            } catch (Throwable th) {
                this.f7499d = null;
                if (this.f7502g) {
                    this.f7502g = false;
                    if (this.f7497b != null) {
                        this.f7497b.mo1096a(this);
                    }
                }
            }
        } catch (IOException e2) {
            throw new brg(e2);
        } catch (Throwable th2) {
            this.f7500e = null;
            try {
                if (this.f7499d != null) {
                    this.f7499d.close();
                }
                this.f7499d = null;
                if (this.f7502g) {
                    this.f7502g = false;
                    if (this.f7497b != null) {
                        this.f7497b.mo1096a(this);
                    }
                }
            } catch (IOException e22) {
                throw new brg(e22);
            } catch (Throwable th3) {
                this.f7499d = null;
                if (this.f7502g) {
                    this.f7502g = false;
                    if (this.f7497b != null) {
                        this.f7497b.mo1096a(this);
                    }
                }
            }
        }
    }
}
