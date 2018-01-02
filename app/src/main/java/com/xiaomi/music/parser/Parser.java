package com.xiaomi.music.parser;

public interface Parser<T, F> {
    T parse(F f) throws Throwable;
}
