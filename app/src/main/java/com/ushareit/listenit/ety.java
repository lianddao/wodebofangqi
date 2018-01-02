package com.ushareit.listenit;

import android.content.Context;
import com.umeng.analytics.C0154a;
import java.util.Date;

public class ety {
    private Context f11852a;
    private eza f11853b = eyx.m18573b(this.f11852a);
    private eua f11854c;
    private long f11855d = ((long) eud.m17973a().m17984c());
    private int f11856e;
    private long f11857f;
    private long f11858g;
    private etz f11859h = new etz(this, true, false, null);

    public ety(Context context) {
        this.f11852a = context;
        long currentTimeMillis = System.currentTimeMillis();
        exz com_ushareit_listenit_eug = new eug(this.f11852a);
        this.f11856e = com_ushareit_listenit_eug.m17988a("upload_times_per_circle", 0);
        this.f11857f = com_ushareit_listenit_eug.m17989a("last_upload_time", 0);
        this.f11858g = com_ushareit_listenit_eug.m17989a("last_upload_succeed_time", 0);
        if (euh.m18002a(currentTimeMillis, com_ushareit_listenit_eug.m17989a("start_time_per_circle", 0)) != 0) {
            exw.m18449b("BeylaManager.UploadPolicy", "restart a upload circle!");
            this.f11856e = 0;
            com_ushareit_listenit_eug.m17996b("start_time_per_circle", currentTimeMillis);
            com_ushareit_listenit_eug.m17995b("upload_times_per_circle", this.f11856e);
        }
    }

    public void m17957a(eua com_ushareit_listenit_eua) {
        this.f11854c = com_ushareit_listenit_eua;
        if (this.f11854c == eua.CONNECTED) {
            this.f11853b = eyx.m18573b(this.f11852a);
        }
        Object obj = (this.f11854c == eua.IN_HOMEPAGE || this.f11854c == eua.PAGE_IN_EVENT || this.f11854c == eua.PAGE_OUT_EVENT || this.f11854c == eua.UNHANDLE_EXCEPTION_EVENT || this.f11854c == eua.CUSTOM_EVENT) ? 1 : null;
        if (obj != null) {
            this.f11855d++;
        }
        if (com_ushareit_listenit_eua == eua.QUIT_APP) {
            euc.m17969a(this.f11852a, this.f11858g);
        }
    }

    public void m17958a(boolean z, boolean z2, Exception exception) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f11857f = currentTimeMillis;
        if (z || this.f11859h.f11860a) {
            this.f11859h = new etz(this, z, z2, exception);
        } else {
            etz com_ushareit_listenit_etz = this.f11859h;
            com_ushareit_listenit_etz.f11863d++;
        }
        if (z) {
            this.f11858g = currentTimeMillis;
            this.f11855d = (long) eud.m17973a().m17984c();
        }
        this.f11856e++;
        exz com_ushareit_listenit_eug = new eug(this.f11852a);
        com_ushareit_listenit_eug.m17995b("upload_times_per_circle", this.f11856e);
        com_ushareit_listenit_eug.m17996b("last_upload_time", this.f11857f);
        com_ushareit_listenit_eug.m17996b("last_upload_succeed_time", this.f11858g);
    }

    public boolean m17959a() {
        boolean z = false;
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f11856e > 50) {
            exw.m18449b("BeylaManager.UploadPolicy", "up load times had over the max 50, can not upload!");
            return false;
        } else if (this.f11853b == eza.OFFLINE || this.f11853b == eza.UNKNOWN) {
            if (this.f11855d <= 0 || this.f11857f == 0 || Math.abs(currentTimeMillis - this.f11857f) <= C0154a.f2953i) {
                z2 = false;
            }
            exw.m18449b("BeylaManager.UploadPolicy", "network is offline or unknown," + (z2 ? " can upload!" : " can not upload!"));
            return z2;
        } else if (this.f11854c == eua.ENTER_APP && this.f11855d > 0 && Math.abs(currentTimeMillis - this.f11857f) > 300000) {
            exw.m18449b("BeylaManager.UploadPolicy", "enter app, can upload!");
            return true;
        } else if (this.f11855d > 0 && this.f11854c == eua.IN_HOMEPAGE && Math.abs(currentTimeMillis - this.f11858g) > 30000) {
            exw.m18449b("BeylaManager.UploadPolicy", "upload in homepage!");
            return true;
        } else if (this.f11854c == eua.QUIT_APP && this.f11855d > 0) {
            exw.m18449b("BeylaManager.UploadPolicy", "quit app, can upload!");
            return true;
        } else if (this.f11855d > 1024 && this.f11859h.f11860a && Math.abs(currentTimeMillis - this.f11857f) > 300000) {
            exw.m18449b("BeylaManager.UploadPolicy", "cached events count had over than MAX count(1024), can upload!");
            return true;
        } else if (this.f11854c == eua.CONTINUE_UPLOAD) {
            exu.m18430a(this.f11859h);
            exw.m18443a("BeylaManager.UploadPolicy", "last result:" + this.f11859h.toString());
            if (this.f11859h.f11860a) {
                if (this.f11855d > 1024 || this.f11859h.f11861b) {
                    z = true;
                }
            } else if (this.f11859h.f11863d < 2) {
                z = true;
            }
            exw.m18449b("BeylaManager.UploadPolicy", "continue to upload," + (z ? " can upload!" : " can not upload!"));
            return z;
        } else {
            if (this.f11855d > 0 && Math.abs(currentTimeMillis - this.f11857f) > 7200000) {
                z = true;
            }
            exw.m18449b("BeylaManager.UploadPolicy", z ? "current had over than default interval, can upload!" : "current is not time to default interval, can not upload!");
            return z;
        }
    }

    public int m17960b() {
        return 1024;
    }

    public long m17961c() {
        return this.f11859h.f11860a ? 0 : 10000;
    }

    public String toString() {
        return "UploadPolicy [mNetType=" + this.f11853b + ", mHint=" + this.f11854c + ", mEventCount=" + this.f11855d + ", mUploadTimesPerCircle=" + this.f11856e + ", mLastUploadTime=" + fbp.m18799a("yyyy:MM:dd HH:mm:ss", new Date(this.f11857f)) + ", mLastResult=" + this.f11859h + "]";
    }
}
