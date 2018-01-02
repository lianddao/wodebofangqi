package com.ushareit.listenit;

import java.io.IOException;

public class dgb extends IOException {
    dgb(int i, int i2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
    }
}
