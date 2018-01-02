package com.ushareit.listenit;

import android.content.Context;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public final class fbr {
    private static fbw f12395a = fbw.UNLOAD;
    private static fbw f12396b = fbw.UNLOAD;
    private static fbw f12397c = fbw.UNLOAD;
    private static fbv f12398d = new fbv();
    private static fbz f12399e = new fbz();
    private static fbx f12400f = new fbx();
    private static fca f12401g = new fca();

    public static int m18807a() {
        int i;
        if (f12395a == fbw.HAS_PERMISSION) {
            i = 2;
        } else {
            i = 0;
        }
        if (f12397c == fbw.HAS_PERMISSION) {
            i |= 4;
        }
        if (f12396b == fbw.HAS_PERMISSION) {
            i |= 8;
        }
        if (i != 0) {
            return i;
        }
        if (f12395a == fbw.NO_PERMISSION || f12397c == fbw.NO_PERMISSION || f12396b == fbw.NO_PERMISSION) {
            return 0;
        }
        return -1;
    }

    public static void m18810a(Context context) {
        if (f12395a == fbw.UNLOAD) {
            f12395a = fbw.LOADING;
            f12396b = fbw.LOADING;
            f12395a = f12398d.mo2348a(context) ? fbw.HAS_PERMISSION : fbw.NO_PERMISSION;
            f12396b = f12399e.mo2348a(context) ? fbw.HAS_PERMISSION : fbw.NO_PERMISSION;
            exw.m18449b("RootUtils", "RootUtils, nac: " + f12395a + ", security:" + f12396b);
        }
    }

    public static int m18808a(Context context, String str) {
        int i = -1;
        int a = m18807a();
        if (a <= 0) {
            exw.m18449b("RootUtils", "RootUtils quietInstallPackage(): Has no quiet install permission.");
            return -1;
        }
        File file = new File(str);
        if (file == null || !file.exists()) {
            return 4;
        }
        int a2;
        if ((a & 2) != 0) {
            a2 = f12398d.m18815a(context, fby.NAC, str);
            if (a2 == 0) {
                return 0;
            }
        }
        a2 = -1;
        int a3;
        if ((a & 8) != 0) {
            a3 = f12399e.m18815a(context, fby.SECURITY, str);
            if (a3 == 0) {
                return 0;
            }
        }
        a3 = -1;
        if ((a & 4) != 0) {
            i = f12400f.m18815a(context, fby.ROOT, str);
            if (i == 0) {
                return 0;
            }
        }
        if (a3 >= i) {
            i = a3;
        }
        if (i < a2) {
            return a2;
        }
        return i;
    }

    public static fbu m18813b(Context context, String str) {
        int a = m18807a();
        if (a <= 1) {
            return new fbu();
        }
        if ((a & 2) != 0) {
            return f12398d.m18817a(str);
        }
        if ((a & 4) != 0) {
            return f12400f.m18817a(str);
        }
        return new fbu();
    }

    protected static boolean m18811a(fbu com_ushareit_listenit_fbu) {
        if (com_ushareit_listenit_fbu.f12404b.size() == 0 || (com_ushareit_listenit_fbu.f12404b.size() > 0 && ((String) com_ushareit_listenit_fbu.f12404b.get(0)).equals(""))) {
            return true;
        }
        if (com_ushareit_listenit_fbu.f12403a.size() <= 0 || !m18812a("Success", (String) com_ushareit_listenit_fbu.f12403a.get(0))) {
            return false;
        }
        return true;
    }

    protected static boolean m18812a(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        int length = str.length();
        if (length > str2.length() || !str.equalsIgnoreCase(str2.substring(0, length))) {
            return false;
        }
        return true;
    }

    public static fbu m18809a(String str) {
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
        Closeable bufferedReader;
        Closeable bufferedReader2;
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
                            com_ushareit_listenit_fbu.f12405c = m18811a(com_ushareit_listenit_fbu);
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
                    com_ushareit_listenit_fbu.f12405c = m18811a(com_ushareit_listenit_fbu);
                    return com_ushareit_listenit_fbu;
                }
            } catch (InterruptedException e7) {
                e = e7;
                bufferedReader2 = null;
                closeable = bufferedReader;
                try {
                    com_ushareit_listenit_fbu.f12404b.add(e.getMessage());
                    exw.m18457e("RootUtils", e.getMessage());
                    fbb.m18757a(closeable);
                    fbb.m18757a(bufferedReader2);
                    com_ushareit_listenit_fbu.f12405c = m18811a(com_ushareit_listenit_fbu);
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
                    com_ushareit_listenit_fbu.f12404b.add(e2.getMessage());
                    exw.m18457e("RootUtils", e2.getMessage());
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(closeable);
                    com_ushareit_listenit_fbu.f12405c = m18811a(com_ushareit_listenit_fbu);
                    return com_ushareit_listenit_fbu;
                } catch (Throwable th4) {
                    th = th4;
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(closeable);
                    throw th;
                }
            } catch (RuntimeException e9) {
                e3 = e9;
                com_ushareit_listenit_fbu.f12404b.add(e3.getMessage());
                exw.m18457e("RootUtils", e3.getMessage());
                fbb.m18757a(bufferedReader);
                fbb.m18757a(closeable);
                com_ushareit_listenit_fbu.f12405c = m18811a(com_ushareit_listenit_fbu);
                return com_ushareit_listenit_fbu;
            }
        } catch (InterruptedException e10) {
            e = e10;
            bufferedReader2 = null;
            com_ushareit_listenit_fbu.f12404b.add(e.getMessage());
            exw.m18457e("RootUtils", e.getMessage());
            fbb.m18757a(closeable);
            fbb.m18757a(bufferedReader2);
            com_ushareit_listenit_fbu.f12405c = m18811a(com_ushareit_listenit_fbu);
            return com_ushareit_listenit_fbu;
        } catch (IOException e11) {
            e2 = e11;
            bufferedReader = null;
            com_ushareit_listenit_fbu.f12404b.add(e2.getMessage());
            exw.m18457e("RootUtils", e2.getMessage());
            fbb.m18757a(bufferedReader);
            fbb.m18757a(closeable);
            com_ushareit_listenit_fbu.f12405c = m18811a(com_ushareit_listenit_fbu);
            return com_ushareit_listenit_fbu;
        } catch (RuntimeException e12) {
            e3 = e12;
            bufferedReader = null;
            com_ushareit_listenit_fbu.f12404b.add(e3.getMessage());
            exw.m18457e("RootUtils", e3.getMessage());
            fbb.m18757a(bufferedReader);
            fbb.m18757a(closeable);
            com_ushareit_listenit_fbu.f12405c = m18811a(com_ushareit_listenit_fbu);
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
