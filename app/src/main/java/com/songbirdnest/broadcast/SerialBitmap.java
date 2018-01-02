package com.songbirdnest.broadcast;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialBitmap implements Serializable {
    private static final long serialVersionUID = 784182513973647266L;
    public Bitmap bitmap;

    SerialBitmap(Bitmap inMap) {
        this.bitmap = inMap;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        this.bitmap.compress(CompressFormat.PNG, 0, byteStream);
        byte[] bitmapBytes = byteStream.toByteArray();
        out.write(bitmapBytes, 0, bitmapBytes.length);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        while (true) {
            int b = in.read();
            if (b != -1) {
                byteStream.write(b);
            } else {
                byte[] bitmapBytes = byteStream.toByteArray();
                this.bitmap = BitmapFactory.decodeByteArray(bitmapBytes, 0, bitmapBytes.length);
                return;
            }
        }
    }
}
