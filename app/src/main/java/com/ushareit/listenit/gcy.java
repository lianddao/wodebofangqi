package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class gcy {
    private static gcy f13932a;
    private boolean f13933b = true;
    private int f13934c = 0;
    private long f13935d = 0;
    private int f13936e = 0;
    private long f13937f = 0;
    private boolean f13938g = false;
    private List<gcz> f13939h = new ArrayList();

    private gcy() {
    }

    public static gcy m21713a() {
        if (f13932a == null) {
            synchronized (gcy.class) {
                if (f13932a == null) {
                    f13932a = new gcy();
                }
            }
        }
        return f13932a;
    }

    public void m21719a(gcz com_ushareit_listenit_gcz) {
        if (com_ushareit_listenit_gcz != null && !this.f13939h.contains(com_ushareit_listenit_gcz)) {
            this.f13939h.add(com_ushareit_listenit_gcz);
        }
    }

    public boolean m21722b(gcz com_ushareit_listenit_gcz) {
        return this.f13939h.remove(com_ushareit_listenit_gcz);
    }

    public void m21718a(Intent intent, Context context) {
        if (intent != null) {
            m21715b(intent);
            int intExtra = intent.getIntExtra("plugged", 0);
            if (intExtra == 1) {
                m21713a().m21716b(intent, context);
            } else if (intExtra == 2 || intExtra == 4) {
                m21713a().m21717c(intent, context);
            } else {
                m21713a().m21714a(intent);
            }
        }
    }

    private void m21716b(Intent intent, Context context) {
        long j = 0;
        if (intent != null) {
            int intExtra = intent.getIntExtra("plugged", 0);
            if (intExtra == 1) {
                int i;
                int intExtra2 = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                if (this.f13934c != -1 && !this.f13933b && this.f13935d > 0 && intExtra2 - this.f13934c > 0) {
                    long currentTimeMillis = (long) (((float) (System.currentTimeMillis() - this.f13935d)) / ((float) (intExtra2 - this.f13934c)));
                    Log.d("BatteryChangedHelper", "BATTERY_PLUGGED_AC perPowerTime :" + currentTimeMillis);
                    gvj.m22919c(currentTimeMillis);
                }
                if (!this.f13933b) {
                    j = System.currentTimeMillis();
                }
                this.f13935d = j;
                if (this.f13933b) {
                    i = -1;
                } else {
                    i = intExtra2;
                }
                this.f13934c = i;
                String a = gda.m21726a(context, intExtra2, intExtra);
                for (gcz a2 : this.f13939h) {
                    a2.mo2647a(intExtra2, a);
                }
                if (this.f13933b) {
                    this.f13933b = false;
                }
                if (intExtra2 - this.f13934c < 0) {
                    this.f13933b = true;
                }
            }
        }
    }

    private void m21717c(Intent intent, Context context) {
        long j = 0;
        if (intent != null) {
            int intExtra = intent.getIntExtra("plugged", 0);
            if (intExtra == 2 || intExtra == 4) {
                int i;
                int intExtra2 = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                if (this.f13936e != -1 && !this.f13933b && this.f13937f > 0 && intExtra2 - this.f13936e > 0) {
                    long currentTimeMillis = (long) (((float) (System.currentTimeMillis() - this.f13937f)) / ((float) (intExtra2 - this.f13936e)));
                    Log.d("BatteryChangedHelper", "BATTERY_PLUGGED_USB perPowerTime :" + currentTimeMillis);
                    gvj.m22939e(currentTimeMillis);
                }
                if (!this.f13933b) {
                    j = System.currentTimeMillis();
                }
                this.f13937f = j;
                if (this.f13933b) {
                    i = -1;
                } else {
                    i = intExtra2;
                }
                this.f13936e = i;
                String a = gda.m21726a(context, intExtra2, intExtra);
                for (gcz a2 : this.f13939h) {
                    a2.mo2647a(intExtra2, a);
                }
                if (this.f13933b) {
                    this.f13933b = false;
                }
                if (intExtra2 - this.f13936e < 0) {
                    this.f13933b = true;
                }
            }
        }
    }

    private void m21714a(Intent intent) {
        if (intent != null) {
            int intExtra = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
            for (gcz a : this.f13939h) {
                a.mo2647a(intExtra, "");
            }
        }
    }

    private void m21715b(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        boolean z = intExtra == 2 || intExtra == 5;
        this.f13938g = z;
        exw.m18454c("1024", "mIsCharging:" + this.f13938g);
    }

    public void m21720a(boolean z) {
        for (gcz a : this.f13939h) {
            a.mo2648a(z);
        }
    }

    public boolean m21721b() {
        return this.f13938g;
    }
}
