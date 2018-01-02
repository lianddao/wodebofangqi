package com.miui.player.cloud;

import android.accounts.Account;
import android.content.Context;
import java.util.Arrays;
import java.util.List;
import miui.provider.MicloudPushProvider;
import miui.provider.MicloudPushProvider.Watermark;

public class MusicCloudPushProvider extends MicloudPushProvider {
    public static final String AUTHORITY = "com.miui.player.cloud.push";
    public static final String WATER_MARK_NAME = "micloud.music.playlist.sync";

    protected List<Watermark> getWatermarkList(Context context, Account account) {
        Watermark wm = new Watermark(WATER_MARK_NAME, MusicSyncHelper.getCurrentVersion(context), "p");
        return Arrays.asList(new Watermark[]{wm});
    }

    protected String getAuthority() {
        return AUTHORITY;
    }
}
