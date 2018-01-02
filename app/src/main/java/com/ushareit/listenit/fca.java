package com.ushareit.listenit;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

public class fca extends fbt {
    protected fca() {
        super();
    }

    public boolean mo2348a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || (applicationInfo.flags & 1) == 0) ? false : true;
    }

    protected fbu mo2347a(Context context, String str) {
        return mo2349b(str);
    }

    public fbu mo2349b(String str) {
        Closeable bufferedReader;
        Closeable bufferedReader2;
        InterruptedException e;
        IOException e2;
        RuntimeException e3;
        Throwable th;
        Closeable closeable = null;
        fbu com_ushareit_listenit_fbu = new fbu();
        String[] split = str.split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replaceAll("\"", "");
        }
        try {
            Process start = new ProcessBuilder(split).start();
            start.waitFor();
            bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            try {
                String readLine;
                bufferedReader2 = new BufferedReader(new InputStreamReader(start.getErrorStream()));
                while (true) {
                    try {
                        readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            com_ushareit_listenit_fbu.f12404b.add(readLine);
                        } else {
                            while (true) {
                            }
                            start.destroy();
                            fbb.m18757a(bufferedReader);
                            fbb.m18757a(bufferedReader2);
                            com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
                            exw.m18449b("RootUtils", "RootUtils system error:" + com_ushareit_listenit_fbu.f12404b);
                            return com_ushareit_listenit_fbu;
                        }
                    } catch (InterruptedException e4) {
                        e = e4;
                        closeable = bufferedReader;
                    } catch (IOException e5) {
                        e2 = e5;
                        closeable = bufferedReader2;
                    } catch (RuntimeException e6) {
                        e3 = e6;
                        closeable = bufferedReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = bufferedReader2;
                    }
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    com_ushareit_listenit_fbu.f12403a.add(readLine);
                } else {
                    start.destroy();
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(bufferedReader2);
                    com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
                    exw.m18449b("RootUtils", "RootUtils system error:" + com_ushareit_listenit_fbu.f12404b);
                    return com_ushareit_listenit_fbu;
                }
            } catch (InterruptedException e7) {
                e = e7;
                bufferedReader2 = null;
                closeable = bufferedReader;
                try {
                    exw.m18457e("RootUtils", "RootUtils system " + e.getMessage());
                    fbb.m18757a(closeable);
                    fbb.m18757a(bufferedReader2);
                    com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
                    exw.m18449b("RootUtils", "RootUtils system error:" + com_ushareit_listenit_fbu.f12404b);
                    return com_ushareit_listenit_fbu;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = closeable;
                    closeable = bufferedReader2;
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(closeable);
                    throw th;
                }
            } catch (IOException e8) {
                e2 = e8;
                try {
                    exw.m18457e("RootUtils", "RootUtils system " + e2.getMessage());
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(closeable);
                    com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
                    exw.m18449b("RootUtils", "RootUtils system error:" + com_ushareit_listenit_fbu.f12404b);
                    return com_ushareit_listenit_fbu;
                } catch (Throwable th4) {
                    th = th4;
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(closeable);
                    throw th;
                }
            } catch (RuntimeException e9) {
                e3 = e9;
                exw.m18457e("RootUtils", "RootUtils system " + e3.getMessage());
                fbb.m18757a(bufferedReader);
                fbb.m18757a(closeable);
                com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
                exw.m18449b("RootUtils", "RootUtils system error:" + com_ushareit_listenit_fbu.f12404b);
                return com_ushareit_listenit_fbu;
            }
        } catch (InterruptedException e10) {
            e = e10;
            bufferedReader2 = null;
            exw.m18457e("RootUtils", "RootUtils system " + e.getMessage());
            fbb.m18757a(closeable);
            fbb.m18757a(bufferedReader2);
            com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
            exw.m18449b("RootUtils", "RootUtils system error:" + com_ushareit_listenit_fbu.f12404b);
            return com_ushareit_listenit_fbu;
        } catch (IOException e11) {
            e2 = e11;
            bufferedReader = null;
            exw.m18457e("RootUtils", "RootUtils system " + e2.getMessage());
            fbb.m18757a(bufferedReader);
            fbb.m18757a(closeable);
            com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
            exw.m18449b("RootUtils", "RootUtils system error:" + com_ushareit_listenit_fbu.f12404b);
            return com_ushareit_listenit_fbu;
        } catch (RuntimeException e12) {
            e3 = e12;
            bufferedReader = null;
            exw.m18457e("RootUtils", "RootUtils system " + e3.getMessage());
            fbb.m18757a(bufferedReader);
            fbb.m18757a(closeable);
            com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
            exw.m18449b("RootUtils", "RootUtils system error:" + com_ushareit_listenit_fbu.f12404b);
            return com_ushareit_listenit_fbu;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            fbb.m18757a(bufferedReader);
            fbb.m18757a(closeable);
            throw th;
        }
    }
}
