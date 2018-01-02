package com.ushareit.listenit;

class hai implements Runnable {
    final /* synthetic */ had f15049a;
    private int f15050b = 0;

    hai(had com_ushareit_listenit_had) {
        this.f15049a = com_ushareit_listenit_had;
    }

    public void run() {
        int i;
        String str = ".";
        for (i = 0; i < this.f15050b; i++) {
            str = str + ".";
        }
        for (i = this.f15050b + 1; i < 3; i++) {
            str = str + " ";
        }
        this.f15049a.f15039p.setText(this.f15049a.f15040q.getString(C0349R.string.sync_syncing) + str);
        this.f15050b = (this.f15050b + 1) % 3;
        this.f15049a.f15039p.removeCallbacks(this);
        this.f15049a.f15039p.postDelayed(this, 1000);
    }
}
