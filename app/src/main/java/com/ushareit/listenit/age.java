package com.ushareit.listenit;

import java.net.Socket;

final class age implements Runnable {
    final /* synthetic */ agb f4321a;
    private final Socket f4322b;

    public age(agb com_ushareit_listenit_agb, Socket socket) {
        this.f4321a = com_ushareit_listenit_agb;
        this.f4322b = socket;
    }

    public void run() {
        this.f4321a.m5540a(this.f4322b);
    }
}
