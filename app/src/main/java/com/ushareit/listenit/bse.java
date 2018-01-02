package com.ushareit.listenit;

import java.io.IOException;

public final class bse extends IOException {
    public bse(Exception exception) {
        super("Unexpected " + exception.getClass().getSimpleName() + ": " + exception.getMessage(), exception);
    }
}
