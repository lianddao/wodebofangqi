package com.ushareit.listenit;

final class aau extends aas {
    aau() {
    }

    protected int mo559a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
        int max = Math.max(1, Integer.highestOneBit(ceil));
        if (max >= ceil) {
            i5 = 0;
        }
        return max << i5;
    }

    public String mo560a() {
        return "AT_MOST.com.bumptech.glide.load.data.bitmap";
    }
}
