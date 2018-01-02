package com.ushareit.listenit;

import java.io.IOException;
import java.io.InputStream;

class ezj implements Runnable {
    final /* synthetic */ ezw f12251a;
    final /* synthetic */ InputStream f12252b;
    final /* synthetic */ ezi f12253c;

    ezj(ezi com_ushareit_listenit_ezi, ezw com_ushareit_listenit_ezw, InputStream inputStream) {
        this.f12253c = com_ushareit_listenit_ezi;
        this.f12251a = com_ushareit_listenit_ezw;
        this.f12252b = inputStream;
    }

    public void run() {
        String str;
        StringBuilder append;
        boolean z;
        ezw com_ushareit_listenit_ezw;
        boolean z2 = true;
        exw.m18443a("DownloaderEx", "download large file begin url = " + this.f12253c.f12240b);
        long b = this.f12253c.f12242d;
        while (b < this.f12253c.f12243e && !Thread.currentThread().isInterrupted()) {
            try {
                long j;
                ezu com_ushareit_listenit_ezu = null;
                while (com_ushareit_listenit_ezu == null) {
                    com_ushareit_listenit_ezu = this.f12251a.m18644a(1000);
                }
                if (this.f12253c.f12243e - b > ((long) com_ushareit_listenit_ezu.f12262b)) {
                    j = (long) com_ushareit_listenit_ezu.f12262b;
                } else {
                    j = this.f12253c.f12243e - b;
                }
                int a = ezi.m18618b(this.f12252b, com_ushareit_listenit_ezu.f12261a, 0, (int) j);
                this.f12253c.f12239a.m18653a(a);
                if (a < 0) {
                    break;
                }
                com_ushareit_listenit_ezu.f12263c = a;
                b += (long) a;
                this.f12251a.m18645a(com_ushareit_listenit_ezu);
            } catch (InterruptedException e) {
                str = "DownloaderEx";
                append = new StringBuilder().append("download large file finish:");
                if (b == this.f12253c.f12243e) {
                    z = true;
                } else {
                    z = false;
                }
                exw.m18443a(str, append.append(z).toString());
                com_ushareit_listenit_ezw = this.f12251a;
                if (b != this.f12253c.f12243e) {
                    z2 = false;
                }
                com_ushareit_listenit_ezw.m18648a(z2);
                return;
            } catch (IOException e2) {
                exw.m18456d("DownloaderEx", "download file error:" + e2.getMessage());
                str = "DownloaderEx";
                append = new StringBuilder().append("download large file finish:");
                if (b == this.f12253c.f12243e) {
                    z = true;
                } else {
                    z = false;
                }
                exw.m18443a(str, append.append(z).toString());
                com_ushareit_listenit_ezw = this.f12251a;
                if (b != this.f12253c.f12243e) {
                    z2 = false;
                }
                com_ushareit_listenit_ezw.m18648a(z2);
                return;
            } catch (RuntimeException e3) {
                exw.m18456d("DownloaderEx", "download file runtime exception:" + e3.getMessage());
                str = "DownloaderEx";
                append = new StringBuilder().append("download large file finish:");
                if (b == this.f12253c.f12243e) {
                    z = true;
                } else {
                    z = false;
                }
                exw.m18443a(str, append.append(z).toString());
                com_ushareit_listenit_ezw = this.f12251a;
                if (b != this.f12253c.f12243e) {
                    z2 = false;
                }
                com_ushareit_listenit_ezw.m18648a(z2);
                return;
            } catch (Throwable th) {
                Throwable th2 = th;
                String str2 = "DownloaderEx";
                StringBuilder append2 = new StringBuilder().append("download large file finish:");
                if (b == this.f12253c.f12243e) {
                    z = true;
                } else {
                    z = false;
                }
                exw.m18443a(str2, append2.append(z).toString());
                com_ushareit_listenit_ezw = this.f12251a;
                if (b != this.f12253c.f12243e) {
                    z2 = false;
                }
                com_ushareit_listenit_ezw.m18648a(z2);
            }
        }
        exw.m18443a("DownloaderEx", "download large file finish:" + (b == this.f12253c.f12243e));
        com_ushareit_listenit_ezw = this.f12251a;
        if (b != this.f12253c.f12243e) {
            z2 = false;
        }
        com_ushareit_listenit_ezw.m18648a(z2);
    }
}
