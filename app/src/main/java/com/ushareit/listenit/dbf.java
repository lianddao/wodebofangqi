package com.ushareit.listenit;

import java.io.Reader;
import java.io.StringReader;

public final class dbf {
    public dba m13720a(dfu com_ushareit_listenit_dfu) {
        String valueOf;
        boolean p = com_ushareit_listenit_dfu.m13896p();
        com_ushareit_listenit_dfu.m13882a(true);
        try {
            dba a = ddc.m13831a(com_ushareit_listenit_dfu);
            com_ushareit_listenit_dfu.m13882a(p);
            return a;
        } catch (Throwable e) {
            valueOf = String.valueOf(com_ushareit_listenit_dfu);
            throw new dbe(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed parsing JSON source: ").append(valueOf).append(" to Json").toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(com_ushareit_listenit_dfu);
            throw new dbe(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed parsing JSON source: ").append(valueOf).append(" to Json").toString(), e2);
        } catch (Throwable th) {
            com_ushareit_listenit_dfu.m13882a(p);
        }
    }

    public dba m13721a(Reader reader) {
        try {
            dfu com_ushareit_listenit_dfu = new dfu(reader);
            dba a = m13720a(com_ushareit_listenit_dfu);
            if (a.m13698k() || com_ushareit_listenit_dfu.mo1718f() == dfw.END_DOCUMENT) {
                return a;
            }
            throw new dbj("Did not consume the entire document.");
        } catch (Throwable e) {
            throw new dbj(e);
        } catch (Throwable e2) {
            throw new dbb(e2);
        } catch (Throwable e22) {
            throw new dbj(e22);
        }
    }

    public dba m13722a(String str) {
        return m13721a(new StringReader(str));
    }
}
