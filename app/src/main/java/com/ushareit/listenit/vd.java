package com.ushareit.listenit;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;

public class vd extends va<ParcelFileDescriptor> {
    protected /* synthetic */ Object mo3103a(AssetManager assetManager, String str) {
        return m26683b(assetManager, str);
    }

    public vd(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    protected ParcelFileDescriptor m26683b(AssetManager assetManager, String str) {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    protected void m26681a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }
}
