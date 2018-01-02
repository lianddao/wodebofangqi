package com.ushareit.listenit;

import java.io.Writer;

public final class ddc {
    public static dba m13831a(dfu com_ushareit_listenit_dfu) {
        Object obj = 1;
        try {
            com_ushareit_listenit_dfu.mo1718f();
            obj = null;
            return (dba) dek.f9686P.mo1401b(com_ushareit_listenit_dfu);
        } catch (Throwable e) {
            if (obj != null) {
                return dbc.f9489a;
            }
            throw new dbj(e);
        } catch (Throwable e2) {
            throw new dbj(e2);
        } catch (Throwable e22) {
            throw new dbb(e22);
        } catch (Throwable e222) {
            throw new dbj(e222);
        }
    }

    public static Writer m13832a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new dde(appendable, null);
    }

    public static void m13833a(dba com_ushareit_listenit_dba, dfx com_ushareit_listenit_dfx) {
        dek.f9686P.mo1400a(com_ushareit_listenit_dfx, com_ushareit_listenit_dba);
    }
}
