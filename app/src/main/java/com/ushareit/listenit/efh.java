package com.ushareit.listenit;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.io.IOException;

public class efh extends eal {
    static IOException f10951a = new IOException("The operation was canceled.");
    static final /* synthetic */ boolean f10952b = (!efh.class.desiredAssertionStatus());
    private final int f10953c;
    private final int f10954d;
    private String f10955e;
    private Throwable f10956f;

    efh(int i, Throwable th, int i2) {
        this.f10955e = m16971a(i);
        this.f10956f = th;
        this.f10953c = i;
        this.f10954d = i2;
        String str = this.f10955e;
        String valueOf = String.valueOf(Integer.toString(this.f10953c));
        String valueOf2 = String.valueOf(Integer.toString(this.f10954d));
        Log.e("StorageException", new StringBuilder(((String.valueOf(str).length() + 52) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append("StorageException has occurred.\n").append(str).append("\n Code: ").append(valueOf).append(" HttpResult: ").append(valueOf2).toString());
        if (this.f10956f != null) {
            Log.e("StorageException", this.f10956f.getMessage(), this.f10956f);
        }
    }

    efh(Status status) {
        this(m16972b(status), null, 0);
    }

    efh(Throwable th, int i) {
        this(m16973b(th, i), th, i);
    }

    public static efh m16969a(Status status) {
        cfi.m11080a((Object) status);
        cfi.m11089b(!status.m2257f());
        return new efh(status);
    }

    public static efh m16970a(Throwable th, int i) {
        return th instanceof efh ? (efh) th : (m16974b(i) && th == null) ? null : new efh(th, i);
    }

    static String m16971a(int i) {
        switch (i) {
            case -13040:
                return "The operation was cancelled.";
            case -13031:
                return "Object has a checksum which does not match. Please retry the operation.";
            case -13030:
                return "The operation retry limit has been exceeded.";
            case -13021:
                return "User does not have permission to access this object.";
            case -13020:
                return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
            case -13013:
                return "Quota for bucket exceeded, please view quota on www.firebase.google.com/storage.";
            case -13012:
                return "Project does not exist.";
            case -13011:
                return "Bucket does not exist.";
            case -13010:
                return "Object does not exist at location.";
            case -13000:
                return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
            default:
                return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
        }
    }

    private static int m16972b(Status status) {
        return status.m2258g() ? -13040 : status == Status.f1689d ? -13030 : -13000;
    }

    private static int m16973b(Throwable th, int i) {
        if (th == f10951a) {
            return -13040;
        }
        switch (i) {
            case -2:
                return -13030;
            case 401:
                return -13020;
            case 403:
                return -13021;
            case 404:
                return -13010;
            default:
                return -13000;
        }
    }

    private static boolean m16974b(int i) {
        return i == 0 || (i >= 200 && i < 300);
    }

    public Throwable getCause() {
        return this.f10956f == this ? null : this.f10956f;
    }

    public String getMessage() {
        return this.f10955e;
    }
}
