package com.ushareit.listenit;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class grp extends Handler {
    private List<String> f14591a = new CopyOnWriteArrayList();
    private List<gry> f14592b = new ArrayList();
    private int f14593c = 1;
    private int f14594d = 0;
    private long f14595e = 0;
    private long f14596f = 0;
    private long f14597g = 0;
    private gzb f14598h = new grq(this);

    public void handleMessage(Message message) {
        if (m22608g()) {
            try {
                switch (message.what) {
                    case 1:
                        Bundle data = message.getData();
                        int i = data.getInt("key_progress_percent");
                        String string = data.getString("key_file_path");
                        if (this.f14594d < 99) {
                            if (i <= this.f14594d && System.currentTimeMillis() - this.f14597g > 80) {
                                i = this.f14594d + 1;
                                this.f14597g = System.currentTimeMillis();
                            } else if (i > this.f14594d) {
                                this.f14597g = System.currentTimeMillis();
                            }
                        }
                        int i2 = i > this.f14594d ? i : this.f14594d;
                        for (gry a : this.f14592b) {
                            a.mo2627a(string, i2);
                        }
                        this.f14594d = i2;
                        return;
                    case 2:
                        for (gry a2 : this.f14592b) {
                            a2.mo2628b(message.arg1, message.arg2);
                        }
                        return;
                    case 3:
                        for (gry a22 : this.f14592b) {
                            a22.mo2627a("", 100);
                            a22.mo2626a(message.arg1, message.arg2);
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    }

    public void m22610a(gry com_ushareit_listenit_gry) {
        if (!this.f14592b.contains(com_ushareit_listenit_gry)) {
            this.f14592b.add(com_ushareit_listenit_gry);
        }
    }

    public void m22613b(gry com_ushareit_listenit_gry) {
        if (this.f14592b.contains(com_ushareit_listenit_gry)) {
            this.f14592b.remove(com_ushareit_listenit_gry);
        }
    }

    public boolean m22612a() {
        return this.f14593c != 2;
    }

    public boolean m22614b() {
        return this.f14593c == 2;
    }

    public void m22615c() {
        this.f14591a.clear();
        this.f14594d = 0;
        this.f14596f = 0;
        this.f14593c = 2;
        this.f14595e = System.currentTimeMillis();
    }

    public void m22616d() {
        if (this.f14593c != 3) {
            this.f14593c = 3;
            if (grr.m22621a().m22649e()) {
                m22606e();
            }
            exw.m18443a("GlobalScanHandler", "sendScanFinishMessage: usedTime=" + (System.currentTimeMillis() - this.f14595e));
            if (m22608g()) {
                int d = frf.m20670d();
                int c = frf.m20665c() - d;
                Message obtainMessage = obtainMessage(3);
                obtainMessage.arg1 = d;
                obtainMessage.arg2 = c;
                sendMessage(obtainMessage);
                gyo.m23264a().m23265a(eys.m18562a());
            } else {
                fxh.m21245Y();
                gyo.m23264a().m23265a(eys.m18562a());
            }
            if (!grr.m22621a().m22650f()) {
                fii.m19291a(eys.m18562a(), System.currentTimeMillis() - this.f14595e, this.f14591a.size());
            }
            gyy.m23326a().m23330a(this.f14598h);
            gyy.m23326a().m23334c();
            this.f14591a.clear();
        }
    }

    private void m22606e() {
        int c = frf.m20665c() - frf.m20670d();
        if (c > 0) {
            gvj.m23004m(eys.m18562a(), c);
        }
    }

    public void m22611a(String str, int i) {
        if (m22607f()) {
            this.f14593c = 2;
            Message obtainMessage = obtainMessage(1, null);
            Bundle bundle = new Bundle();
            bundle.putString("key_file_path", str);
            bundle.putInt("key_progress_percent", i);
            obtainMessage.setData(bundle);
            sendMessage(obtainMessage);
        }
    }

    public synchronized void m22609a(glf com_ushareit_listenit_glf) {
        String str = com_ushareit_listenit_glf.f14309d;
        if (!this.f14591a.contains(str)) {
            if (!frf.m20676e(str)) {
                this.f14591a.add(str);
                frf.m20642a(com_ushareit_listenit_glf);
                if (m22608g()) {
                    Message obtainMessage = obtainMessage(2);
                    obtainMessage.arg1 = this.f14591a.size();
                    obtainMessage.arg2 = frf.m20655b();
                    sendMessage(obtainMessage);
                }
            }
        }
    }

    private boolean m22607f() {
        if (!m22608g() || System.currentTimeMillis() - this.f14596f <= 60) {
            return false;
        }
        this.f14596f = System.currentTimeMillis();
        return true;
    }

    private boolean m22608g() {
        return this.f14592b.size() > 0;
    }
}
