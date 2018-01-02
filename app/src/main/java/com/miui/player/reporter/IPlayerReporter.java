package com.miui.player.reporter;

import android.content.Context;
import java.util.Date;

public interface IPlayerReporter {
    boolean postLocalPlayStatus(Context context, Date date, int i);

    boolean postOnlinePlayStatus(Context context, OnlinePlayStatus onlinePlayStatus);

    boolean postUserStart(Context context, Date date);
}
