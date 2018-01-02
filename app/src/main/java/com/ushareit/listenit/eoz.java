package com.ushareit.listenit;

import java.util.Comparator;

public final class eoz implements Comparator<byte[]> {
    public int compare(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }
}
