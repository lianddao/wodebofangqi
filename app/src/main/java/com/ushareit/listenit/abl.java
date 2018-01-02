package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;

public class abl implements aan<ParcelFileDescriptor> {
    private static final abm f4046a = new abm();
    private abm f4047b;
    private int f4048c;

    public abl() {
        this(f4046a, -1);
    }

    abl(abm com_ushareit_listenit_abm, int i) {
        this.f4047b = com_ushareit_listenit_abm;
        this.f4048c = i;
    }

    public Bitmap m5096a(ParcelFileDescriptor parcelFileDescriptor, ws wsVar, int i, int i2, ut utVar) {
        Bitmap frameAtTime;
        MediaMetadataRetriever a = this.f4047b.m5098a();
        a.setDataSource(parcelFileDescriptor.getFileDescriptor());
        if (this.f4048c >= 0) {
            frameAtTime = a.getFrameAtTime((long) this.f4048c);
        } else {
            frameAtTime = a.getFrameAtTime();
        }
        a.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    public String mo560a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
