package com.songbirdnest.soundboard;

import com.songbirdnest.stream.StreamException;

public interface SoundboardListener<Result> {
    void onFailure(String str, StreamException streamException);

    void onSuccess(Result result);
}
