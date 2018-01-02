package com.ushareit.listenit;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bv {
    private static final cf f7787a;

    private static void m9933b(bt btVar, ArrayList<bw> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            btVar.mo1567a((bw) it.next());
        }
    }

    private static void m9935c(bu buVar, cp cpVar) {
        if (cpVar == null) {
            return;
        }
        if (cpVar instanceof bz) {
            bz bzVar = (bz) cpVar;
            dd.m13826a(buVar, bzVar.d, bzVar.f, bzVar.e, bzVar.f7955a);
        } else if (cpVar instanceof cc) {
            cc ccVar = (cc) cpVar;
            dd.m13827a(buVar, ccVar.d, ccVar.f, ccVar.e, ccVar.f8085a);
        } else if (cpVar instanceof by) {
            by byVar = (by) cpVar;
            dd.m13825a(buVar, byVar.d, byVar.f, byVar.e, byVar.f7940a, byVar.f7941b, byVar.f7942c);
        } else if (!(cpVar instanceof cd)) {
        }
    }

    private static void m9936d(bu buVar, cp cpVar) {
        if (cpVar == null) {
            return;
        }
        if (cpVar instanceof cd) {
            cd cdVar = (cd) cpVar;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            List arrayList4 = new ArrayList();
            List arrayList5 = new ArrayList();
            for (ce ceVar : cdVar.f8142c) {
                arrayList.add(ceVar.m10945a());
                arrayList2.add(Long.valueOf(ceVar.m10946b()));
                arrayList3.add(ceVar.m10947c());
                arrayList4.add(ceVar.m10948d());
                arrayList5.add(ceVar.m10949e());
            }
            cu.m12697a(buVar, cdVar.f8140a, cdVar.f8141b, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
            return;
        }
        m9935c(buVar, cpVar);
    }

    static {
        if (fc.m18842a()) {
            f7787a = new ci();
        } else if (VERSION.SDK_INT >= 21) {
            f7787a = new ch();
        } else if (VERSION.SDK_INT >= 20) {
            f7787a = new cg();
        } else if (VERSION.SDK_INT >= 19) {
            f7787a = new co();
        } else if (VERSION.SDK_INT >= 16) {
            f7787a = new cn();
        } else if (VERSION.SDK_INT >= 14) {
            f7787a = new cm();
        } else if (VERSION.SDK_INT >= 11) {
            f7787a = new cl();
        } else if (VERSION.SDK_INT >= 9) {
            f7787a = new ck();
        } else {
            f7787a = new cj();
        }
    }
}
