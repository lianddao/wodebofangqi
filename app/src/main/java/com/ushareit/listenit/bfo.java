package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class bfo implements bfj {
    private final Handler f6059a;
    private final bfq<?> f6060b;
    private final CopyOnWriteArraySet<bfk> f6061c;
    private final bgf f6062d;
    private final bge f6063e;
    private boolean f6064f;
    private boolean f6065g;
    private int f6066h;
    private int f6067i;
    private boolean f6068j;
    private bgd f6069k;
    private Object f6070l;
    private bfs f6071m;
    private int f6072n;
    private long f6073o;

    @SuppressLint({"HandlerLeak"})
    public bfo(bfx[] com_ushareit_listenit_bfxArr, bqo<?> com_ushareit_listenit_bqo_, bfv com_ushareit_listenit_bfv) {
        Log.i("ExoPlayerImpl", "Init 2.0.3");
        bsg.m9654a((Object) com_ushareit_listenit_bfxArr);
        bsg.m9658b(com_ushareit_listenit_bfxArr.length > 0);
        this.f6065g = false;
        this.f6066h = 1;
        this.f6061c = new CopyOnWriteArraySet();
        this.f6062d = new bgf();
        this.f6063e = new bge();
        this.f6059a = new bfp(this);
        this.f6071m = new bfs(0, 0);
        this.f6060b = new bfq(com_ushareit_listenit_bfxArr, com_ushareit_listenit_bqo_, com_ushareit_listenit_bfv, this.f6065g, this.f6059a, this.f6071m);
    }

    public void mo891a(bfk com_ushareit_listenit_bfk) {
        this.f6061c.add(com_ushareit_listenit_bfk);
    }

    public void mo895b(bfk com_ushareit_listenit_bfk) {
        this.f6061c.remove(com_ushareit_listenit_bfk);
    }

    public int mo888a() {
        return this.f6066h;
    }

    public void mo892a(bod com_ushareit_listenit_bod) {
        m8056a(com_ushareit_listenit_bod, true, true);
    }

    public void m8056a(bod com_ushareit_listenit_bod, boolean z, boolean z2) {
        if (z2 && !(this.f6069k == null && this.f6070l == null)) {
            this.f6069k = null;
            this.f6070l = null;
            Iterator it = this.f6061c.iterator();
            while (it.hasNext()) {
                ((bfk) it.next()).mo112a(null, null);
            }
        }
        this.f6060b.m8109a(com_ushareit_listenit_bod, z);
    }

    public void mo893a(boolean z) {
        if (this.f6065g != z) {
            this.f6065g = z;
            this.f6060b.m8111a(z);
            Iterator it = this.f6061c.iterator();
            while (it.hasNext()) {
                ((bfk) it.next()).mo114a(z, this.f6066h);
            }
        }
    }

    public boolean mo897b() {
        return this.f6065g;
    }

    public void mo898c() {
        mo889a(mo902g());
    }

    public void mo889a(int i) {
        if (this.f6069k == null) {
            this.f6072n = i;
            this.f6073o = -9223372036854775807L;
            this.f6064f = true;
            return;
        }
        bsg.m9653a(i, 0, this.f6069k.mo1051a());
        this.f6067i++;
        this.f6072n = i;
        this.f6073o = 0;
        this.f6060b.m8106a(this.f6069k.m8214a(i, this.f6062d).f6166f, -9223372036854775807L);
    }

    public void mo890a(long j) {
        m8051a(mo902g(), j);
    }

    public void m8051a(int i, long j) {
        if (j == -9223372036854775807L) {
            mo889a(i);
        } else if (this.f6069k == null) {
            this.f6072n = i;
            this.f6073o = j;
            this.f6064f = true;
        } else {
            bsg.m9653a(i, 0, this.f6069k.mo1051a());
            this.f6067i++;
            this.f6072n = i;
            this.f6073o = j;
            this.f6069k.m8214a(i, this.f6062d);
            int i2 = this.f6062d.f6166f;
            long c = this.f6062d.m8224c() + j;
            long a = this.f6069k.m8212a(i2, this.f6063e).m8217a();
            while (a != -9223372036854775807L && c >= a && i2 < this.f6062d.f6167g) {
                c -= a;
                i2++;
                a = this.f6069k.m8212a(i2, this.f6063e).m8217a();
            }
            this.f6060b.m8106a(i2, bfg.m8006b(c));
            Iterator it = this.f6061c.iterator();
            while (it.hasNext()) {
                ((bfk) it.next()).mo119e();
            }
        }
    }

    public void mo899d() {
        this.f6060b.m8105a();
    }

    public void mo900e() {
        this.f6060b.m8113b();
        this.f6059a.removeCallbacksAndMessages(null);
    }

    public void mo894a(bfm... com_ushareit_listenit_bfmArr) {
        this.f6060b.m8112a(com_ushareit_listenit_bfmArr);
    }

    public void mo896b(bfm... com_ushareit_listenit_bfmArr) {
        this.f6060b.m8115b(com_ushareit_listenit_bfmArr);
    }

    public int mo902g() {
        if (this.f6069k == null || this.f6067i > 0) {
            return this.f6072n;
        }
        return this.f6069k.m8212a(this.f6071m.f6124a, this.f6063e).f6158c;
    }

    public long mo903h() {
        if (this.f6069k == null) {
            return -9223372036854775807L;
        }
        return this.f6069k.m8214a(mo902g(), this.f6062d).m8223b();
    }

    public long mo904i() {
        if (this.f6069k == null || this.f6067i > 0) {
            return this.f6073o;
        }
        this.f6069k.m8212a(this.f6071m.f6124a, this.f6063e);
        return this.f6063e.m8220c() + bfg.m8005a(this.f6071m.f6126c);
    }

    public long mo905j() {
        if (this.f6069k == null || this.f6067i > 0) {
            return this.f6073o;
        }
        this.f6069k.m8212a(this.f6071m.f6124a, this.f6063e);
        return this.f6063e.m8220c() + bfg.m8005a(this.f6071m.f6127d);
    }

    public int mo906k() {
        long j = 100;
        if (this.f6069k == null) {
            return 0;
        }
        int i;
        long j2 = mo905j();
        long h = mo903h();
        if (j2 == -9223372036854775807L || h == -9223372036854775807L) {
            i = 0;
        } else {
            if (h != 0) {
                j = (100 * j2) / h;
            }
            i = (int) j;
        }
        return i;
    }

    public bgd mo901f() {
        return this.f6069k;
    }

    void m8053a(Message message) {
        Iterator it;
        switch (message.what) {
            case 1:
                this.f6066h = message.arg1;
                it = this.f6061c.iterator();
                while (it.hasNext()) {
                    ((bfk) it.next()).mo114a(this.f6065g, this.f6066h);
                }
                return;
            case 2:
                boolean z;
                if (message.arg1 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.f6068j = z;
                it = this.f6061c.iterator();
                while (it.hasNext()) {
                    ((bfk) it.next()).mo116b(this.f6068j);
                }
                return;
            case 3:
                int i = this.f6067i - 1;
                this.f6067i = i;
                if (i == 0) {
                    this.f6071m = (bfs) message.obj;
                    it = this.f6061c.iterator();
                    while (it.hasNext()) {
                        ((bfk) it.next()).mo119e();
                    }
                    return;
                }
                return;
            case 4:
                if (this.f6067i == 0) {
                    this.f6071m = (bfs) message.obj;
                    it = this.f6061c.iterator();
                    while (it.hasNext()) {
                        ((bfk) it.next()).mo119e();
                    }
                    return;
                }
                return;
            case 5:
                Pair pair = (Pair) message.obj;
                this.f6069k = (bgd) pair.first;
                this.f6070l = pair.second;
                if (this.f6064f) {
                    this.f6064f = false;
                    m8051a(this.f6072n, this.f6073o);
                }
                it = this.f6061c.iterator();
                while (it.hasNext()) {
                    ((bfk) it.next()).mo112a(this.f6069k, this.f6070l);
                }
                return;
            case 6:
                bfi com_ushareit_listenit_bfi = (bfi) message.obj;
                Iterator it2 = this.f6061c.iterator();
                while (it2.hasNext()) {
                    ((bfk) it2.next()).mo111a(com_ushareit_listenit_bfi);
                }
                return;
            default:
                return;
        }
    }
}
