package com.ushareit.listenit;

import android.content.Context;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;

class fbx extends fbt {
    private String f12413a;

    private fbx() {
        super();
    }

    public boolean mo2348a(Context context) {
        this.f12413a = m18833a();
        return !this.f12413a.equals("");
    }

    protected fbu mo2347a(Context context, String str) {
        return mo2349b(str);
    }

    protected fbu mo2349b(String str) {
        Closeable bufferedReader;
        Closeable bufferedReader2;
        Exception e;
        Throwable th;
        Closeable closeable = null;
        exw.m18449b("RootUtils", "[AS.Root] " + str);
        fbu com_ushareit_listenit_fbu = new fbu();
        try {
            Process exec = Runtime.getRuntime().exec(this.f12413a);
            OutputStream outputStream = exec.getOutputStream();
            outputStream.write((str + "\n").getBytes());
            outputStream.flush();
            outputStream.close();
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            try {
                String readLine;
                bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
                while (true) {
                    try {
                        readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            com_ushareit_listenit_fbu.f12404b.add(readLine);
                        } else {
                            while (true) {
                            }
                            com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
                            fbb.m18757a(bufferedReader);
                            fbb.m18757a(bufferedReader2);
                            return com_ushareit_listenit_fbu;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        closeable = bufferedReader;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = bufferedReader2;
                    }
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    com_ushareit_listenit_fbu.f12403a.add(readLine);
                } else {
                    com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(bufferedReader2);
                    return com_ushareit_listenit_fbu;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader2 = null;
                closeable = bufferedReader;
                try {
                    exw.m18456d("RootUtils", "RootUtils root " + e.toString());
                    com_ushareit_listenit_fbu.f12404b.add(e.toString());
                    fbb.m18757a(closeable);
                    fbb.m18757a(bufferedReader2);
                    return com_ushareit_listenit_fbu;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = closeable;
                    closeable = bufferedReader2;
                    fbb.m18757a(bufferedReader);
                    fbb.m18757a(closeable);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fbb.m18757a(bufferedReader);
                fbb.m18757a(closeable);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader2 = null;
            exw.m18456d("RootUtils", "RootUtils root " + e.toString());
            com_ushareit_listenit_fbu.f12404b.add(e.toString());
            fbb.m18757a(closeable);
            fbb.m18757a(bufferedReader2);
            return com_ushareit_listenit_fbu;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            fbb.m18757a(bufferedReader);
            fbb.m18757a(closeable);
            throw th;
        }
    }

    private String m18833a() {
        this.f12413a = "";
        for (String file : System.getenv("PATH").split(":")) {
            File file2 = new File(file, "su");
            if (file2.exists() && m18834a(file2)) {
                this.f12413a = file2.getAbsolutePath();
                return file2.getAbsolutePath();
            }
        }
        return "";
    }

    private boolean m18834a(File file) {
        String str = this.f12413a;
        this.f12413a = file.getAbsolutePath();
        fbu a = m18817a("pm install /system/.NOT_EXIST_APPLICATION");
        if (m18821a(a.f12404b, "INSTALL_FAILED_INVALID_URI") || m18821a(a.f12404b, "INSTALL_FAILED_INSUFFICIENT_STORAGE")) {
            return true;
        }
        this.f12413a = str;
        return false;
    }
}
