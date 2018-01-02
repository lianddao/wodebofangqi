package com.ushareit.listenit;

import android.content.Context;
import android.widget.Toast;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mraid.MraidNativeCommandHandler;

public class elq implements elt {
    final /* synthetic */ Context f11215a;
    final /* synthetic */ elv f11216b;
    final /* synthetic */ MraidNativeCommandHandler f11217c;

    public elq(MraidNativeCommandHandler mraidNativeCommandHandler, Context context, elv com_ushareit_listenit_elv) {
        this.f11217c = mraidNativeCommandHandler;
        this.f11215a = context;
        this.f11216b = com_ushareit_listenit_elv;
    }

    public void onSuccess() {
        MoPubLog.m2753d("Image successfully saved.");
    }

    public void onFailure() {
        Toast.makeText(this.f11215a, "Image failed to download.", 0).show();
        MoPubLog.m2753d("Error downloading and saving image file.");
        this.f11216b.onFailure(new ekx("Error downloading and saving image file."));
    }
}
