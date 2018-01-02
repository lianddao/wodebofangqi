package com.ushareit.listenit;

import android.content.res.AssetManager;
import java.io.InputStream;

public class vk extends va<InputStream> {
    protected /* synthetic */ Object mo3103a(AssetManager assetManager, String str) {
        return m26706b(assetManager, str);
    }

    public vk(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    protected InputStream m26706b(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }

    protected void m26704a(InputStream inputStream) {
        inputStream.close();
    }
}
