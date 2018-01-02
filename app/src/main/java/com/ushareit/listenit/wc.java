package com.ushareit.listenit;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

class wc implements uv {
    private final String f17100a;
    private final int f17101b;
    private final int f17102c;
    private final ux f17103d;
    private final ux f17104e;
    private final uz f17105f;
    private final uy f17106g;
    private final adb f17107h;
    private final uu f17108i;
    private final uv f17109j;
    private String f17110k;
    private int f17111l;
    private uv f17112m;

    public wc(String str, uv uvVar, int i, int i2, ux uxVar, ux uxVar2, uz uzVar, uy uyVar, adb com_ushareit_listenit_adb, uu uuVar) {
        this.f17100a = str;
        this.f17109j = uvVar;
        this.f17101b = i;
        this.f17102c = i2;
        this.f17103d = uxVar;
        this.f17104e = uxVar2;
        this.f17105f = uzVar;
        this.f17106g = uyVar;
        this.f17107h = com_ushareit_listenit_adb;
        this.f17108i = uuVar;
    }

    public uv m26766a() {
        if (this.f17112m == null) {
            this.f17112m = new wj(this.f17100a, this.f17109j);
        }
        return this.f17112m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        wc wcVar = (wc) obj;
        if (!this.f17100a.equals(wcVar.f17100a) || !this.f17109j.equals(wcVar.f17109j) || this.f17102c != wcVar.f17102c || this.f17101b != wcVar.f17101b) {
            return false;
        }
        if (((this.f17105f == null ? 1 : 0) ^ (wcVar.f17105f == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f17105f != null && !this.f17105f.mo557a().equals(wcVar.f17105f.mo557a())) {
            return false;
        }
        int i;
        if (this.f17104e == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (wcVar.f17104e == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f17104e != null && !this.f17104e.mo566a().equals(wcVar.f17104e.mo566a())) {
            return false;
        }
        if (this.f17103d == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (wcVar.f17103d == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f17103d != null && !this.f17103d.mo566a().equals(wcVar.f17103d.mo566a())) {
            return false;
        }
        if (this.f17106g == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (wcVar.f17106g == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f17106g != null && !this.f17106g.mo551a().equals(wcVar.f17106g.mo551a())) {
            return false;
        }
        if (this.f17107h == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (wcVar.f17107h == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f17107h != null && !this.f17107h.mo589a().equals(wcVar.f17107h.mo589a())) {
            return false;
        }
        if (this.f17108i == null) {
            i = 1;
        } else {
            i = 0;
        }
        if ((i ^ (wcVar.f17108i == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f17108i == null || this.f17108i.mo551a().equals(wcVar.f17108i.mo551a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        if (this.f17111l == 0) {
            int hashCode;
            this.f17111l = this.f17100a.hashCode();
            this.f17111l = (this.f17111l * 31) + this.f17109j.hashCode();
            this.f17111l = (this.f17111l * 31) + this.f17101b;
            this.f17111l = (this.f17111l * 31) + this.f17102c;
            this.f17111l = (this.f17103d != null ? this.f17103d.mo566a().hashCode() : 0) + (this.f17111l * 31);
            int i2 = this.f17111l * 31;
            if (this.f17104e != null) {
                hashCode = this.f17104e.mo566a().hashCode();
            } else {
                hashCode = 0;
            }
            this.f17111l = hashCode + i2;
            i2 = this.f17111l * 31;
            if (this.f17105f != null) {
                hashCode = this.f17105f.mo557a().hashCode();
            } else {
                hashCode = 0;
            }
            this.f17111l = hashCode + i2;
            i2 = this.f17111l * 31;
            if (this.f17106g != null) {
                hashCode = this.f17106g.mo551a().hashCode();
            } else {
                hashCode = 0;
            }
            this.f17111l = hashCode + i2;
            i2 = this.f17111l * 31;
            if (this.f17107h != null) {
                hashCode = this.f17107h.mo589a().hashCode();
            } else {
                hashCode = 0;
            }
            this.f17111l = hashCode + i2;
            hashCode = this.f17111l * 31;
            if (this.f17108i != null) {
                i = this.f17108i.mo551a().hashCode();
            }
            this.f17111l = hashCode + i;
        }
        return this.f17111l;
    }

    public String toString() {
        if (this.f17110k == null) {
            String a;
            StringBuilder append = new StringBuilder().append("EngineKey{").append(this.f17100a).append('+').append(this.f17109j).append("+[").append(this.f17101b).append('x').append(this.f17102c).append("]+").append('\'');
            if (this.f17103d != null) {
                a = this.f17103d.mo566a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.f17104e != null) {
                a = this.f17104e.mo566a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.f17105f != null) {
                a = this.f17105f.mo557a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.f17106g != null) {
                a = this.f17106g.mo551a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.f17107h != null) {
                a = this.f17107h.mo589a();
            } else {
                a = "";
            }
            append = append.append(a).append('\'').append('+').append('\'');
            if (this.f17108i != null) {
                a = this.f17108i.mo551a();
            } else {
                a = "";
            }
            this.f17110k = append.append(a).append('\'').append('}').toString();
        }
        return this.f17110k;
    }

    public void mo583a(MessageDigest messageDigest) {
        byte[] array = ByteBuffer.allocate(8).putInt(this.f17101b).putInt(this.f17102c).array();
        this.f17109j.mo583a(messageDigest);
        messageDigest.update(this.f17100a.getBytes("UTF-8"));
        messageDigest.update(array);
        messageDigest.update((this.f17103d != null ? this.f17103d.mo566a() : "").getBytes("UTF-8"));
        messageDigest.update((this.f17104e != null ? this.f17104e.mo566a() : "").getBytes("UTF-8"));
        messageDigest.update((this.f17105f != null ? this.f17105f.mo557a() : "").getBytes("UTF-8"));
        messageDigest.update((this.f17106g != null ? this.f17106g.mo551a() : "").getBytes("UTF-8"));
        messageDigest.update((this.f17108i != null ? this.f17108i.mo551a() : "").getBytes("UTF-8"));
    }
}
