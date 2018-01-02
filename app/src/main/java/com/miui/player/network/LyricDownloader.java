package com.miui.player.network;

import android.content.Context;
import android.util.Log;
import com.google.android.collect.Lists;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.plugin.PlugInManager;
import com.miui.player.plugin.base.PlugInInterface;
import com.miui.player.plugin.onlinelyric.LyricContent;
import com.miui.player.plugin.onlinelyric.LyricContentFactory;
import com.miui.player.plugin.onlinelyric.LyricItemInfo;
import com.miui.player.plugin.onlinelyric.LyricPlugIn;
import com.miui.player.plugin.onlinelyric.LyricProvider;
import com.miui.player.provider.OnlineAudioDetailHelper;
import com.miui.player.service.LyricManager;
import com.miui.player.util.ThreadManager;
import com.xiaomi.music.util.StreamHelper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ClientProtocolException;

public class LyricDownloader {
    private static final String TAG = LyricDownloader.class.getName();

    public static abstract class LyricAsyncCallback implements Runnable {
        protected List<LyricItemInfo> mInfoList;
        protected LyricProvider mProvider;

        public abstract boolean isAutoChoose();

        public void setLyricItemInfo(LyricProvider provider, List<LyricItemInfo> info) {
            this.mProvider = provider;
            this.mInfoList = info;
        }
    }

    public static class LyricAsyncSaveCallback extends LyricAsyncCallback {
        final String mArtistName;
        final Context mContext;
        final String mTrackName;

        public LyricAsyncSaveCallback(Context context, String track, String artist) {
            this.mTrackName = track;
            this.mArtistName = artist;
            this.mContext = context;
        }

        public boolean isAutoChoose() {
            return true;
        }

        public void run() {
            if (this.mInfoList != null && !this.mInfoList.isEmpty()) {
                LyricContent content = ((LyricItemInfo) this.mInfoList.get(0)).getContent();
                if (content != null) {
                    LyricManager.saveLyricFile(this.mContext, this.mTrackName, this.mArtistName, content);
                }
            }
        }
    }

    static boolean request(LyricProvider provider, LyricAsyncCallback callback) throws ClientProtocolException, URISyntaxException, IOException {
        List<LyricItemInfo> infoList = provider.requestList();
        if (infoList == null || infoList.isEmpty()) {
            return false;
        }
        if (callback.isAutoChoose()) {
            for (LyricItemInfo info : infoList) {
                if (provider.requestItem(info)) {
                    List<LyricItemInfo> newList = new ArrayList(1);
                    newList.add(info);
                    callback.setLyricItemInfo(provider, newList);
                    return true;
                }
            }
            return false;
        }
        callback.setLyricItemInfo(provider, infoList);
        return true;
    }

    static boolean downloadBySearchInfo(Context context, LyricSearchInfo searchInfo, LyricAsyncCallback callback) {
        boolean success = false;
        try {
            LyricProvider provider = OnlineMusicProxy.createLyricProvider(context, searchInfo);
            if (provider != null) {
                success = request(provider, callback);
            }
            if (!success) {
                provider = createProvider(context, searchInfo);
                if (provider != null) {
                    success = request(provider, callback);
                }
            }
            callback.run();
            statistics(success);
            return success;
        } catch (ClientProtocolException e) {
            callback.run();
            statistics(false);
            return false;
        } catch (URISyntaxException e2) {
            callback.run();
            statistics(false);
            return false;
        } catch (IOException e3) {
            callback.run();
            statistics(false);
            return false;
        } catch (Throwable th) {
            callback.run();
            statistics(false);
        }
    }

    static boolean downloadByOnlineId(Context context, String onlineId, LyricAsyncCallback cbk) {
        if (onlineId == null) {
            return false;
        }
        InputStream is = null;
        try {
            String url = OnlineAudioDetailHelper.queryLyricURL(context, onlineId);
            if (url != null) {
                LyricItemInfo info = new LyricItemInfo();
                info.setLink(url);
                is = OnlineMusicProxy.requestStream(context, url);
                if (is != null) {
                    byte[] content = StreamHelper.toByteArray(is);
                    if (content != null) {
                        info.setContent(LyricContentFactory.create(content));
                        cbk.setLyricItemInfo(null, Lists.newArrayList(new LyricItemInfo[]{info}));
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                        }
                    }
                    cbk.run();
                    return true;
                } else if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e2) {
                    }
                }
            } else if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                }
            }
        } catch (IOException e4) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e5) {
                }
            }
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e6) {
                }
            }
            cbk.run();
        }
        cbk.run();
        return false;
    }

    public static void downloadAsync(Context context, LyricSearchInfo searchInfo, LyricAsyncCallback callback) {
        downloadAsync(context, null, searchInfo, callback);
    }

    public static void downloadAsync(Context context, String onlineId, LyricAsyncCallback cbk) {
        downloadAsync(context, onlineId, null, cbk);
    }

    public static void downloadAsync(final Context context, final String onlineId, final LyricSearchInfo searchInfo, final LyricAsyncCallback cbk) {
        if (onlineId != null || searchInfo != null) {
            ThreadManager.postNetworkRequest(new Runnable() {
                public void run() {
                    boolean success = false;
                    if (onlineId != null) {
                        success = LyricDownloader.downloadByOnlineId(context, onlineId, cbk);
                    }
                    if (!success && searchInfo != null) {
                        LyricDownloader.downloadBySearchInfo(context, searchInfo, cbk);
                    }
                }
            });
        }
    }

    public static boolean download(final LyricProvider provider, final LyricItemInfo item, final LyricAsyncCallback callback) {
        if (provider == null) {
            return false;
        }
        ThreadManager.postNetworkRequest(new Runnable() {
            public void run() {
                boolean success = false;
                try {
                    if (provider.requestItem(item)) {
                        ArrayList<LyricItemInfo> infoList = new ArrayList(1);
                        infoList.add(item);
                        callback.setLyricItemInfo(provider, infoList);
                        success = true;
                    }
                    callback.run();
                } catch (ClientProtocolException e) {
                    callback.run();
                } catch (URISyntaxException e2) {
                    callback.run();
                } catch (IOException e3) {
                    callback.run();
                } catch (Throwable th) {
                    callback.run();
                    LyricDownloader.statistics(false);
                }
                LyricDownloader.statistics(success);
            }
        });
        return true;
    }

    static LyricProvider createProvider(Context context, LyricSearchInfo info) {
        PlugInInterface pii = PlugInManager.instance(0).getPlugInInterface();
        try {
            if (pii instanceof LyricPlugIn) {
                return ((LyricPlugIn) pii).create(info);
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return null;
    }

    static void statistics(boolean success) {
        PlugInManager mgr = PlugInManager.tryToGetInstance(0);
        if (mgr != null) {
            mgr.statistics(success);
        }
    }
}
