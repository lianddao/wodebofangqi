package com.ushareit.listenit;

final class hhy extends hia {
    final /* synthetic */ hhw f15475a;
    final /* synthetic */ int f15476b;

    public void run() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = java.lang.Thread.currentThread();
        r0 = r0 instanceof com.ushareit.listenit.hhq;
        if (r0 == 0) goto L_0x0011;
    L_0x0008:
        r0 = java.lang.Thread.currentThread();
        r0 = (com.ushareit.listenit.hhq) r0;
        r0.m23865a();
    L_0x0011:
        r0 = r3.f15475a;
        r0 = r0.isCancelled();
        if (r0 == 0) goto L_0x001a;
    L_0x0019:
        return;
    L_0x001a:
        r0 = r3.f15475a;	 Catch:{ Throwable -> 0x002f, all -> 0x0043 }
        r0.execute();	 Catch:{ Throwable -> 0x002f, all -> 0x0043 }
        r0 = r3.f15475a;
        r0 = r0.isCancelled();
        if (r0 != 0) goto L_0x0019;
    L_0x0027:
        r0 = r3.f15475a;
        r1 = r3.f15476b;
        com.ushareit.listenit.hhx.m23877c(r0, r1);
        goto L_0x0019;
    L_0x002f:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Throwable -> 0x002f, all -> 0x0043 }
        r0 = r3.f15475a;
        r0 = r0.isCancelled();
        if (r0 != 0) goto L_0x0019;
    L_0x003b:
        r0 = r3.f15475a;
        r1 = r3.f15476b;
        com.ushareit.listenit.hhx.m23877c(r0, r1);
        goto L_0x0019;
    L_0x0043:
        r0 = move-exception;
        r1 = r3.f15475a;
        r1 = r1.isCancelled();
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = r3.f15475a;
        r2 = r3.f15476b;
        com.ushareit.listenit.hhx.m23877c(r1, r2);
    L_0x0053:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.hhy.run():void");
    }

    hhy(int i, hhw com_ushareit_listenit_hhw, int i2) {
        this.f15475a = com_ushareit_listenit_hhw;
        this.f15476b = i2;
        super(i);
    }
}
