package com.songbirdnest.mediaplayer.view.adapter;

public class PositionCache<T> {
    protected int mPosition;
    protected T mValue;

    public PositionCache(int pPosition, T pCache) {
        this.mValue = pCache;
        this.mPosition = pPosition;
    }

    public T getValue() {
        return this.mValue;
    }

    public int getPosition() {
        return this.mPosition;
    }
}
