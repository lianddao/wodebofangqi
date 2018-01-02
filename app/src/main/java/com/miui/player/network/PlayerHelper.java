package com.miui.player.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.miui.player.asyncplayer.IPlayerHelper;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.plugin.onlinepay.AccountPermissionHelper;
import com.miui.player.provider.OnlineAudioDetailHelper;
import com.miui.player.provider.PlayerProvider;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.StorageConfig;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayerHelper implements IPlayerHelper {
    private static final String[] PROJECTION = new String[]{"_data", "mi_online_id", "title", "artist", "album"};

    public com.miui.player.asyncplayer.RemoteMediaInfo getRemoteMediaInfo(Context r19, String r20) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r18 = this;
        r10 = -1;
        r1 = android.net.Uri.parse(r20);	 Catch:{ Exception -> 0x0012 }
        r10 = android.content.ContentUris.parseId(r1);	 Catch:{ Exception -> 0x0012 }
        r1 = com.miui.player.provider.PlayerProvider.isOnlineAudio(r10);
        if (r1 != 0) goto L_0x0015;
    L_0x0010:
        r15 = 0;
    L_0x0011:
        return r15;
    L_0x0012:
        r14 = move-exception;
        r15 = 0;
        goto L_0x0011;
    L_0x0015:
        r12 = 0;
        r15 = 0;
        r1 = com.miui.player.provider.PlayerStore.MiuiNowPlayingAudio.EXTERNAL_URI;	 Catch:{ all -> 0x006a }
        r2 = android.content.ContentUris.withAppendedId(r1, r10);	 Catch:{ all -> 0x006a }
        r1 = r19.getContentResolver();	 Catch:{ all -> 0x006a }
        r3 = PROJECTION;	 Catch:{ all -> 0x006a }
        r4 = 0;	 Catch:{ all -> 0x006a }
        r5 = 0;	 Catch:{ all -> 0x006a }
        r6 = 0;	 Catch:{ all -> 0x006a }
        r12 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x006a }
        if (r12 != 0) goto L_0x0033;
    L_0x002c:
        r15 = 0;
        if (r12 == 0) goto L_0x0011;
    L_0x002f:
        r12.close();
        goto L_0x0011;
    L_0x0033:
        r1 = r12.moveToFirst();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x003d;	 Catch:{ all -> 0x006a }
    L_0x0039:
        r15 = 0;	 Catch:{ all -> 0x006a }
        if (r12 == 0) goto L_0x0011;	 Catch:{ all -> 0x006a }
    L_0x003c:
        goto L_0x002f;	 Catch:{ all -> 0x006a }
    L_0x003d:
        r1 = 1;	 Catch:{ all -> 0x006a }
        r16 = r12.getString(r1);	 Catch:{ all -> 0x006a }
        r1 = 2;	 Catch:{ all -> 0x006a }
        r17 = r12.getString(r1);	 Catch:{ all -> 0x006a }
        r1 = 3;	 Catch:{ all -> 0x006a }
        r9 = r12.getString(r1);	 Catch:{ all -> 0x006a }
        r1 = 4;	 Catch:{ all -> 0x006a }
        r7 = r12.getString(r1);	 Catch:{ all -> 0x006a }
        r1 = "mp3";	 Catch:{ all -> 0x006a }
        r0 = r17;	 Catch:{ all -> 0x006a }
        r8 = com.miui.player.meta.MetaManager.getMetaFileName(r0, r9, r1);	 Catch:{ all -> 0x006a }
        r0 = r17;	 Catch:{ all -> 0x006a }
        r13 = getDetails(r0, r9, r7);	 Catch:{ all -> 0x006a }
        r15 = new com.miui.player.asyncplayer.RemoteMediaInfo;	 Catch:{ all -> 0x006a }
        r1 = 0;	 Catch:{ all -> 0x006a }
        r0 = r16;	 Catch:{ all -> 0x006a }
        r15.<init>(r0, r8, r13, r1);	 Catch:{ all -> 0x006a }
        if (r12 == 0) goto L_0x0011;
    L_0x0069:
        goto L_0x002f;
    L_0x006a:
        r1 = move-exception;
        if (r12 == 0) goto L_0x0070;
    L_0x006d:
        r12.close();
    L_0x0070:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.network.PlayerHelper.getRemoteMediaInfo(android.content.Context, java.lang.String):com.miui.player.asyncplayer.RemoteMediaInfo");
    }

    public Pair<AudioDetail, List<AudioLink>> requestAudioDetail(Context context, String audioId) {
        String cpSongId = OnlineAudioDetailHelper.queryCpSongId(context, audioId);
        if (cpSongId != null) {
            int preBitRate = PreferenceCache.getPrefAsInteger(context, PreferenceCache.PREF_TRACK_BIT_RATE).intValue();
            for (int bitRate : StorageConfig.BIT_RATES_SORTED) {
                if (preBitRate >= bitRate && AccountPermissionHelper.allowMusic(StorageConfig.getUserChoice(bitRate))) {
                    Pair<AudioDetail, List<AudioLink>> pair = OnlineMusicProxy.requestAudioDetail(context, cpSongId, bitRate, null, 2);
                    if (!(pair == null || pair.second == null)) {
                        return pair;
                    }
                }
            }
        }
        return null;
    }

    public boolean isOnlineAudio(String path) {
        try {
            return PlayerProvider.isOnlineAudio(Long.parseLong(Uri.parse(path).getLastPathSegment()));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isValidGlobalId(String globalId) {
        return !TextUtils.isEmpty(globalId);
    }

    public Uri getLocalUriToPlay(String path) {
        return Uri.parse(path);
    }

    private static String getDetails(String tr, String ar, String al) {
        JSONObject details = new JSONObject();
        try {
            details.put("album", al);
            details.put("artist", ar);
            details.put("track", tr);
        } catch (JSONException e) {
        }
        return details.toString();
    }
}
