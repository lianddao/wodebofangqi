package com.songbirdnest.soundboard.task;

import com.songbirdnest.soundboard.SoundboardServer;

public class ReauthorizeSoundboard implements Runnable {
    public void run() {
        SoundboardServer.get().reauthorizeSoundboard();
    }
}
