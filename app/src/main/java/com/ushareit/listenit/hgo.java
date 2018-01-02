package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class hgo extends Handler {
    final /* synthetic */ hgk f15434a;

    hgo(hgk com_ushareit_listenit_hgk, Looper looper) {
        this.f15434a = com_ushareit_listenit_hgk;
        super(looper);
    }

    public void handleMessage(Message message) {
        hgw a = this.f15434a.f15423i.mo2494a((String) message.obj);
        if (a != null) {
            int i;
            switch (message.what) {
                case 0:
                    for (hgp a2 : this.f15434a.f15421g) {
                        a2.mo2473a(a);
                    }
                    break;
                case 1:
                    for (hgp a22 : this.f15434a.f15421g) {
                        a22.mo2476a(a, message.arg1 == 1);
                    }
                    break;
                case 2:
                    for (hgp a222 : this.f15434a.f15421g) {
                        a222.mo2477b(a);
                    }
                    break;
                case 3:
                    for (hgp a2222 : this.f15434a.f15421g) {
                        a2222.mo2478c(a);
                    }
                    break;
                case 4:
                    for (hgp a22222 : this.f15434a.f15421g) {
                        a22222.mo2479d(a);
                    }
                    break;
                case 5:
                    for (hgp a222222 : this.f15434a.f15421g) {
                        a222222.mo2480e(a);
                    }
                    break;
                case 6:
                    i = message.arg1;
                    for (hgp a2222222 : this.f15434a.f15421g) {
                        a2222222.mo2475a(a, (long) i);
                    }
                    break;
                case 7:
                    for (hgp a22222222 : this.f15434a.f15421g) {
                        a22222222.mo2481f(a);
                    }
                    break;
                case 8:
                    for (hgp a222222222 : this.f15434a.f15421g) {
                        a222222222.mo2472a();
                    }
                    break;
                case 9:
                    i = message.arg1;
                    for (hgp a2222222222 : this.f15434a.f15421g) {
                        a2222222222.mo2474a(a, i);
                    }
                    break;
            }
            super.handleMessage(message);
        }
    }
}
