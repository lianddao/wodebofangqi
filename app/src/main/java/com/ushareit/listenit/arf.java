package com.ushareit.listenit;

import java.net.Socket;

final class arf implements Runnable {
    final /* synthetic */ ara f5226a;
    private final Socket f5227b;

    public arf(ara com_ushareit_listenit_ara, Socket socket) {
        this.f5226a = com_ushareit_listenit_ara;
        this.f5227b = socket;
    }

    public void run() {
        this.f5226a.m6858a(this.f5227b);
    }
}
