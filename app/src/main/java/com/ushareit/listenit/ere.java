package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

class ere extends Handler {
    private ere() {
    }

    public void handleMessage(Message message) {
        ArrayList arrayList;
        Object obj;
        ArrayList arrayList2;
        int size;
        int i;
        eqy com_ushareit_listenit_eqy;
        ArrayList arrayList3 = (ArrayList) eqy.f11486i.get();
        ArrayList arrayList4 = (ArrayList) eqy.f11488k.get();
        switch (message.what) {
            case 0:
                arrayList = (ArrayList) eqy.f11487j.get();
                if (arrayList3.size() > 0 || arrayList4.size() > 0) {
                    obj = null;
                } else {
                    int i2 = 1;
                }
                while (arrayList.size() > 0) {
                    arrayList2 = (ArrayList) arrayList.clone();
                    arrayList.clear();
                    size = arrayList2.size();
                    for (i = 0; i < size; i++) {
                        com_ushareit_listenit_eqy = (eqy) arrayList2.get(i);
                        if (com_ushareit_listenit_eqy.f11513y == 0) {
                            com_ushareit_listenit_eqy.m17379t();
                        } else {
                            arrayList4.add(com_ushareit_listenit_eqy);
                        }
                    }
                }
                break;
            case 1:
                obj = 1;
                break;
            default:
                return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        arrayList = (ArrayList) eqy.f11490m.get();
        arrayList2 = (ArrayList) eqy.f11489l.get();
        size = arrayList4.size();
        for (i = 0; i < size; i++) {
            com_ushareit_listenit_eqy = (eqy) arrayList4.get(i);
            if (com_ushareit_listenit_eqy.mo2251b(currentAnimationTimeMillis)) {
                arrayList.add(com_ushareit_listenit_eqy);
            }
        }
        size = arrayList.size();
        if (size > 0) {
            for (i = 0; i < size; i++) {
                com_ushareit_listenit_eqy = (eqy) arrayList.get(i);
                com_ushareit_listenit_eqy.m17379t();
                com_ushareit_listenit_eqy.f11510v = true;
                arrayList4.remove(com_ushareit_listenit_eqy);
            }
            arrayList.clear();
        }
        i = arrayList3.size();
        int i3 = 0;
        while (i3 < i) {
            int i4;
            eqy com_ushareit_listenit_eqy2 = (eqy) arrayList3.get(i3);
            if (com_ushareit_listenit_eqy2.m17395f(currentAnimationTimeMillis)) {
                arrayList2.add(com_ushareit_listenit_eqy2);
            }
            if (arrayList3.size() == i) {
                i4 = i3 + 1;
                i3 = i;
            } else {
                i--;
                arrayList2.remove(com_ushareit_listenit_eqy2);
                i4 = i3;
                i3 = i;
            }
            i = i3;
            i3 = i4;
        }
        if (arrayList2.size() > 0) {
            for (i3 = 0; i3 < arrayList2.size(); i3++) {
                ((eqy) arrayList2.get(i3)).mo2254h();
            }
            arrayList2.clear();
        }
        if (obj == null) {
            return;
        }
        if (!arrayList3.isEmpty() || !arrayList4.isEmpty()) {
            sendEmptyMessageDelayed(1, Math.max(0, eqy.f11494z - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
        }
    }
}
