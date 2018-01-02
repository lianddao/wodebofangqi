package com.ushareit.listenit;

import android.content.Context;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class fbv extends fbt {
    private String f12406a;
    private int f12407b;

    private fbv() {
        super();
        this.f12406a = "";
        this.f12407b = -1;
    }

    public boolean mo2348a(Context context) {
        this.f12406a = context.getFilesDir().getAbsolutePath() + "/cmd/";
        File file = new File(this.f12406a);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = this.f12406a + "tmpFile";
        String str2 = this.f12406a + "permission_" + SystemClock.elapsedRealtime();
        try {
            new File(str2).createNewFile();
            m18819a("echo 'End' > " + str, str2);
        } catch (IOException e) {
            exw.m18449b("RootUtils", "loadPermission createNewFile(): " + e.toString());
        }
        m18825a(str2, 3, 2000);
        file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        file = new File(str);
        if (!file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }

    protected fbu mo2347a(Context context, String str) {
        return mo2349b(str);
    }

    protected fbu mo2349b(String str) {
        return m18824a(str, 1);
    }

    private fbu m18824a(String str, int i) {
        fbu com_ushareit_listenit_fbu = new fbu();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str2 = this.f12406a + "cmd_" + elapsedRealtime;
        String str3 = this.f12406a + "out_" + elapsedRealtime;
        String str4 = this.f12406a + "err_" + elapsedRealtime;
        try {
            new File(str2).createNewFile();
            new File(str3).createNewFile();
            new File(str4).createNewFile();
            m18819a(str + " 1> " + str3 + " 2> " + str4 + " \n", str2);
        } catch (IOException e) {
            exw.m18449b("RootUtils", "RootUtils createNewFile() failed: " + e.toString());
        }
        String str5 = "";
        if (i == 2) {
            str5 = m18827b(str2, "supercmdlocalsocket");
        } else if (i == 4) {
            str5 = m18827b(str2, "nac_safe_server");
        } else {
            str5 = m18825a(str2, 5, 3000);
        }
        if (fbr.m18812a("success", str5)) {
            com_ushareit_listenit_fbu.f12403a = m18829d(str3);
            com_ushareit_listenit_fbu.f12404b = m18829d(str4);
            com_ushareit_listenit_fbu.f12405c = fbr.m18811a(com_ushareit_listenit_fbu);
        } else {
            com_ushareit_listenit_fbu.f12405c = false;
            com_ushareit_listenit_fbu.f12404b.add(str5);
        }
        m18826a(str2, str3, str4);
        return com_ushareit_listenit_fbu;
    }

    private String m18825a(String str, int i, long j) {
        String str2 = "";
        for (int i2 = 0; i2 < i; i2++) {
            str2 = m18828c(str);
            if (fbr.m18812a("success", str2)) {
                break;
            }
            exw.m18449b("RootUtils", "RootUtils doRetryNacCommand failed:(" + i2 + "):" + str2);
            try {
                Thread.sleep(j);
            } catch (InterruptedException e) {
                exw.m18449b("RootUtils", "RootUtils doRetryNacCommand sleep() failed: " + e);
            }
        }
        return str2;
    }

    private String m18828c(String str) {
        Closeable printWriter;
        IOException e;
        Socket socket;
        IOException iOException;
        Throwable th;
        StringBuffer stringBuffer;
        String readLine;
        Closeable closeable = null;
        String str2 = "";
        Closeable bufferedReader;
        try {
            LocalSocketAddress localSocketAddress = new LocalSocketAddress("nac_server");
            LocalSocket localSocket = new LocalSocket();
            localSocket.connect(localSocketAddress);
            printWriter = new PrintWriter(localSocket.getOutputStream(), true);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(localSocket.getInputStream()));
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
                closeable = printWriter;
                try {
                    e.toString();
                    exw.m18449b("RootUtils", "RootUtils nac_server Socket() failed: " + e);
                    fbb.m18757a(closeable);
                    fbb.m18757a(bufferedReader);
                    try {
                        socket = new Socket("127.0.0.1", 30001);
                        printWriter = new PrintWriter(socket.getOutputStream(), true);
                        try {
                            closeable = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        } catch (IOException e3) {
                            closeable = bufferedReader;
                            iOException = e3;
                            try {
                                str2 = iOException.toString();
                                exw.m18449b("RootUtils", "RootUtils nac_ip Socket() failed: " + iOException);
                                fbb.m18757a(printWriter);
                                fbb.m18757a(closeable);
                                return str2;
                            } catch (Throwable th2) {
                                th = th2;
                                fbb.m18757a(printWriter);
                                fbb.m18757a(closeable);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            closeable = bufferedReader;
                            fbb.m18757a(printWriter);
                            fbb.m18757a(closeable);
                            throw th;
                        }
                        try {
                            printWriter.write(str);
                            printWriter.flush();
                            str2 = "";
                            stringBuffer = new StringBuffer();
                            while (true) {
                                readLine = closeable.readLine();
                                if (readLine != null) {
                                    break;
                                }
                                stringBuffer.append(readLine).append("\n");
                            }
                            str2 = stringBuffer.toString();
                            socket.close();
                            fbb.m18757a(printWriter);
                            fbb.m18757a(closeable);
                        } catch (IOException e32) {
                            iOException = e32;
                            str2 = iOException.toString();
                            exw.m18449b("RootUtils", "RootUtils nac_ip Socket() failed: " + iOException);
                            fbb.m18757a(printWriter);
                            fbb.m18757a(closeable);
                            return str2;
                        }
                    } catch (IOException e322) {
                        printWriter = closeable;
                        closeable = bufferedReader;
                        iOException = e322;
                        str2 = iOException.toString();
                        exw.m18449b("RootUtils", "RootUtils nac_ip Socket() failed: " + iOException);
                        fbb.m18757a(printWriter);
                        fbb.m18757a(closeable);
                        return str2;
                    } catch (Throwable th4) {
                        th = th4;
                        printWriter = closeable;
                        closeable = bufferedReader;
                        fbb.m18757a(printWriter);
                        fbb.m18757a(closeable);
                        throw th;
                    }
                    return str2;
                } catch (Throwable th5) {
                    th = th5;
                    fbb.m18757a(closeable);
                    fbb.m18757a(bufferedReader);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
                closeable = printWriter;
                fbb.m18757a(closeable);
                fbb.m18757a(bufferedReader);
                throw th;
            }
            try {
                printWriter.write(str);
                printWriter.flush();
                str2 = "";
                stringBuffer = new StringBuffer();
                while (true) {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    stringBuffer.append(readLine2).append("\n");
                }
                str2 = stringBuffer.toString();
                localSocket.close();
                fbb.m18757a(printWriter);
                fbb.m18757a(bufferedReader);
            } catch (IOException e4) {
                e322 = e4;
                closeable = printWriter;
                e322.toString();
                exw.m18449b("RootUtils", "RootUtils nac_server Socket() failed: " + e322);
                fbb.m18757a(closeable);
                fbb.m18757a(bufferedReader);
                socket = new Socket("127.0.0.1", 30001);
                printWriter = new PrintWriter(socket.getOutputStream(), true);
                closeable = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                printWriter.write(str);
                printWriter.flush();
                str2 = "";
                stringBuffer = new StringBuffer();
                while (true) {
                    readLine = closeable.readLine();
                    if (readLine != null) {
                        break;
                    }
                    stringBuffer.append(readLine).append("\n");
                }
                str2 = stringBuffer.toString();
                socket.close();
                fbb.m18757a(printWriter);
                fbb.m18757a(closeable);
                return str2;
            } catch (Throwable th7) {
                th = th7;
                closeable = printWriter;
                fbb.m18757a(closeable);
                fbb.m18757a(bufferedReader);
                throw th;
            }
        } catch (IOException e5) {
            e322 = e5;
            bufferedReader = null;
            e322.toString();
            exw.m18449b("RootUtils", "RootUtils nac_server Socket() failed: " + e322);
            fbb.m18757a(closeable);
            fbb.m18757a(bufferedReader);
            socket = new Socket("127.0.0.1", 30001);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            closeable = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.write(str);
            printWriter.flush();
            str2 = "";
            stringBuffer = new StringBuffer();
            while (true) {
                readLine = closeable.readLine();
                if (readLine != null) {
                    break;
                }
                stringBuffer.append(readLine).append("\n");
            }
            str2 = stringBuffer.toString();
            socket.close();
            fbb.m18757a(printWriter);
            fbb.m18757a(closeable);
            return str2;
        } catch (Throwable th8) {
            th = th8;
            bufferedReader = null;
            fbb.m18757a(closeable);
            fbb.m18757a(bufferedReader);
            throw th;
        }
        return str2;
    }

    private String m18827b(String str, String str2) {
        LocalSocket localSocket;
        PrintWriter printWriter;
        DataInputStream dataInputStream;
        Exception exception;
        String str3;
        Throwable th;
        DataInputStream dataInputStream2 = null;
        String str4 = "";
        try {
            LocalSocketAddress localSocketAddress;
            if ("nac_server".equals(str2)) {
                localSocketAddress = new LocalSocketAddress("nac_server");
            } else if ("supercmdlocalsocket".equals(str2)) {
                localSocketAddress = new LocalSocketAddress("supercmdlocalsocket");
            } else if ("nac_safe_server".equals(str2)) {
                localSocketAddress = new LocalSocketAddress("nac_safe_server");
            } else {
                localSocketAddress = new LocalSocketAddress("nac_server");
            }
            localSocket = new LocalSocket();
            try {
                localSocket.connect(localSocketAddress);
                localSocket.getOutputStream();
                printWriter = new PrintWriter(localSocket.getOutputStream(), true);
            } catch (Exception e) {
                printWriter = null;
                dataInputStream = null;
                exception = e;
                str3 = str4;
                try {
                    exw.m18457e("RootUtils", str2 + " error: " + exception.toString());
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    if (localSocket != null) {
                        localSocket.close();
                    }
                    return str3;
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (Exception e3) {
                            throw th;
                        }
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    if (localSocket != null) {
                        localSocket.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                printWriter = null;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                if (localSocket != null) {
                    localSocket.close();
                }
                throw th;
            }
            try {
                dataInputStream = new DataInputStream(localSocket.getInputStream());
            } catch (Exception e4) {
                dataInputStream = null;
                exception = e4;
                str3 = str4;
                exw.m18457e("RootUtils", str2 + " error: " + exception.toString());
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                if (localSocket != null) {
                    localSocket.close();
                }
                return str3;
            } catch (Throwable th4) {
                th = th4;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                if (localSocket != null) {
                    localSocket.close();
                }
                throw th;
            }
            try {
                printWriter.write(str);
                printWriter.flush();
                byte[] bArr = new byte[8];
                if (dataInputStream.read(bArr) > 0) {
                    String str5 = new String(bArr);
                    try {
                        exw.m18454c("RootUtils", str2 + " result: " + str5);
                        str3 = str5;
                    } catch (Exception e42) {
                        Exception exception2 = e42;
                        str3 = str5;
                        exception = exception2;
                        exw.m18457e("RootUtils", str2 + " error: " + exception.toString());
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        if (localSocket != null) {
                            localSocket.close();
                        }
                        return str3;
                    }
                }
                str3 = str4;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                if (localSocket != null) {
                    localSocket.close();
                }
            } catch (Exception e422) {
                exception = e422;
                str3 = str4;
                exw.m18457e("RootUtils", str2 + " error: " + exception.toString());
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                if (localSocket != null) {
                    localSocket.close();
                }
                return str3;
            }
        } catch (Exception e4222) {
            localSocket = null;
            printWriter = null;
            dataInputStream = null;
            exception = e4222;
            str3 = str4;
            exw.m18457e("RootUtils", str2 + " error: " + exception.toString());
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
            if (localSocket != null) {
                localSocket.close();
            }
            return str3;
        } catch (Throwable th5) {
            th = th5;
            localSocket = null;
            printWriter = null;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
            if (localSocket != null) {
                localSocket.close();
            }
            throw th;
        }
        return str3;
    }

    private void m18826a(String str, String str2, String str3) {
        File file;
        if (str != null) {
            file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        if (str2 != null) {
            file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        if (str3 != null) {
            file = new File(str3);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private List<String> m18829d(String str) {
        Exception e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        Closeable closeable = null;
        Closeable lineNumberReader;
        try {
            lineNumberReader = new LineNumberReader(new FileReader(str));
            while (true) {
                try {
                    String readLine = lineNumberReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            fbb.m18757a(lineNumberReader);
        } catch (Exception e3) {
            e = e3;
            lineNumberReader = null;
            try {
                e.printStackTrace();
                fbb.m18757a(lineNumberReader);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                closeable = lineNumberReader;
                fbb.m18757a(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fbb.m18757a(closeable);
            throw th;
        }
        return arrayList;
    }
}
