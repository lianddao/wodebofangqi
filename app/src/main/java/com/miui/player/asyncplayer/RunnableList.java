package com.miui.player.asyncplayer;

public interface RunnableList {

    public interface RemovableRunnable extends Runnable {
        boolean isRemovable();
    }

    void add(String str, RemovableRunnable removableRunnable, long j);

    void remove(String str);
}
