package com.ushareit.listenit;

public class ezs extends eyq {
    private final String f12256a;

    public ezs(int i, String str) {
        super(i, str);
        this.f12256a = null;
    }

    public ezs(int i, Throwable th) {
        super(i, th);
        this.f12256a = null;
    }

    public ezs(int i, String str, String str2) {
        super(i, str);
        this.f12256a = str2;
    }

    public ezs(int i, Throwable th, String str) {
        super(i, th);
        this.f12256a = str;
    }

    public final int mo2345a() {
        return super.mo2345a();
    }

    public final String m18640b() {
        switch (mo2345a()) {
            case 6:
                return "remote_" + getMessage();
            case 13:
                return "local_" + getMessage();
            default:
                return m18638a(mo2345a());
        }
    }

    private static String m18638a(int i) {
        switch (i) {
            case 0:
                return "general_error";
            case 1:
                return "network_error";
            case 2:
                return "download_error";
            case 3:
                return "upload_error";
            case 4:
                return "badfile";
            case 5:
                return "file_not_found";
            case 7:
                return "not_enough_space";
            case 8:
                return "canceled";
            case 9:
                return "target_not_support_receive_collection";
            case 11:
                return "target_not_support_filetype";
            case 12:
                return "can_not_create_file";
            case 14:
                return "network_unreachable";
            default:
                return "unknown";
        }
    }
}
