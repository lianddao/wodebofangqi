package com.miui.player.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.provider.MediaStore.Audio.Media;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;
import com.android.internal.view.menu.MenuBuilder;
import com.baidu.music.download.db.DBConfig;
import com.google.android.collect.Lists;
import com.miui.player.C0329R;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.OnlineMusicProxy;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.provider.PlaylistHelper;
import com.miui.player.service.ServiceHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.controller.MultiChoiceController.ItemViewBinder;
import com.miui.player.ui.fragment.OnlineSongListFragment.SongGroupRequest;
import com.miui.player.ui.menu.common.BaseMenuId;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Strings;
import entagged.audioformats.AudioFileIO;
import entagged.audioformats.exceptions.CannotReadException;
import java.io.File;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import miui.v5.widget.Views;
import miui.widget.GuidePopupWindow;

public class UIHelper implements BaseMenuId {
    public static final String DST_PLAYLIST_KEY = "dst_playlist";
    private static final int MSG_TOAST = 0;
    static final int[] SD_ERROR_INDICATORS = new int[]{C0329R.id.sd_message, C0329R.id.sd_icon, C0329R.id.error_layout, C0329R.id.error_msg};
    static final int[] SD_USABLE_INDICATORS = new int[]{16908298, C0329R.id.normal_state};
    private static final String TAG = UIHelper.class.getCanonicalName();
    private static String mLastSdStatus;
    private static StringBuilder sFormatBuilder = new StringBuilder();
    private static Formatter sFormatter = new Formatter(sFormatBuilder);
    private static final Handler sHandler = new Handler(MusicApplication.getApplication().getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (msg.obj != null) {
                        Toast.makeText(MusicApplication.getApplication(), msg.obj.toString(), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private static final Object[] sTimeArgs = new Object[5];

    static class C04662 implements OnCancelListener {
        C04662() {
        }

        public void onCancel(DialogInterface dialog) {
        }
    }

    public static class CheckBoxItemBinder implements ItemViewBinder {
        public final int mCheckBoxId;

        public CheckBoxItemBinder(int checkBoxId) {
            this.mCheckBoxId = checkBoxId;
        }

        public boolean bindView(View view, boolean isSelected, boolean isMultiChoice) {
            CheckBox checkBox = (CheckBox) view.findViewById(this.mCheckBoxId);
            if (isMultiChoice) {
                checkBox.setVisibility(0);
                checkBox.setChecked(isSelected);
                checkBox.setClickable(false);
                checkBox.setFocusable(false);
                checkBox.setOnCheckedChangeListener(null);
            } else {
                checkBox.setVisibility(8);
            }
            return isMultiChoice;
        }
    }

    static class ImageFactory implements ViewFactory {
        private final Context mContext;
        private final int mDefaultId;
        private boolean mIsFirst = true;
        private final LayoutParams mLayoutParams;
        private final ScaleType mScaleType;

        public ImageFactory(Context context, LayoutParams params, ScaleType scaleType, int dftId) {
            this.mContext = context;
            this.mLayoutParams = params;
            this.mScaleType = scaleType;
            this.mDefaultId = dftId;
        }

        public View makeView() {
            ImageView iv = new ImageView(this.mContext);
            iv.setScaleType(this.mScaleType);
            iv.setLayoutParams(this.mLayoutParams);
            if (this.mIsFirst) {
                this.mIsFirst = false;
                iv.setImageResource(this.mDefaultId);
            }
            return iv;
        }
    }

    public static class ListViewPositionWrap {
        private int mLastListPosCourse = -1;
        private int mLastListPosFine = -1;

        public void saveListPosition(ListView lv) {
            if (lv != null) {
                this.mLastListPosCourse = lv.getFirstVisiblePosition();
                View cv = lv.getChildAt(0);
                if (cv != null) {
                    this.mLastListPosFine = cv.getTop();
                }
            }
        }

        public void restoreListPosition(ListView lv) {
            if (lv != null && this.mLastListPosCourse >= 0) {
                lv.setSelectionFromTop(this.mLastListPosCourse, this.mLastListPosFine);
            }
        }
    }

    public static class MaskItemBinder implements ItemViewBinder {
        private final int mCheckBoxId;
        private final int mMaskId;

        public MaskItemBinder(int checkBoxId, int maskId) {
            this.mCheckBoxId = checkBoxId;
            this.mMaskId = maskId;
        }

        public boolean bindView(View view, boolean isSelected, boolean isMultiChoice) {
            View checkBox = view.findViewById(this.mCheckBoxId);
            View checkMask = view.findViewById(this.mMaskId);
            if (isMultiChoice && isSelected) {
                checkMask.setSelected(true);
                checkBox.setVisibility(0);
            } else {
                checkMask.setSelected(false);
                checkBox.setVisibility(8);
            }
            return isMultiChoice;
        }
    }

    public static class SubMenuBuilder implements OnMenuItemClickListener, OnClickListener {
        private final Context mContext;
        private AlertDialog mDialog;
        private Builder mDialogBuilder;
        private final OnMenuItemClickListener mListener;
        private final MenuItem mParentMenu;
        private final Menu mSubMenu = new MenuBuilder(this.mContext).addSubMenu(0, 0, 0, MetaManager.UNKNOWN_STRING);

        public SubMenuBuilder(Context context, MenuItem menu, OnMenuItemClickListener l) {
            this.mContext = context;
            this.mListener = l;
            this.mParentMenu = menu.setOnMenuItemClickListener(this);
        }

        public MenuItem add(int groupId, int itemId, int order, int title) {
            return this.mSubMenu.add(groupId, itemId, order, title);
        }

        public MenuItem add(int groupId, int itemId, int order, String title) {
            return this.mSubMenu.add(groupId, itemId, order, title);
        }

        public void build() {
            int size = this.mSubMenu.size();
            CharSequence[] titles = new CharSequence[size];
            for (int i = 0; i < size; i++) {
                titles[i] = this.mSubMenu.getItem(i).getTitle();
            }
            this.mDialogBuilder = new Builder(this.mContext).setCancelable(true).setTitle(this.mParentMenu.getTitle()).setItems(titles, this);
        }

        public boolean onMenuItemClick(MenuItem item) {
            this.mDialog = this.mDialogBuilder.show();
            return true;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.mDialog.dismiss();
            MenuItem item = this.mSubMenu.getItem(which);
            if (item != null) {
                this.mListener.onMenuItemClick(item);
            }
        }
    }

    public static void makePlaylistMenu(Context context, Menu sub, Intent extras, long excludeId) {
        sub.clear();
        if (excludeId != 0) {
            sub.add(1, 12, 0, C0329R.string.queue).setIntent(extras);
        }
        sub.add(1, 4, 0, C0329R.string.new_playlist).setIntent(extras);
        Context context2 = context;
        Cursor cur = SqlUtils.query(context2, MiuiPlaylists.EXTERNAL_URI, new String[]{"_id", "name"}, String.format("(%s!='') AND (%s=%d) AND (%s!=%d) AND (%s!=?)", new Object[]{"name", "list_type", Integer.valueOf(0), "_id", Long.valueOf(excludeId), "mi_sync_playlist_state"}), new String[]{String.valueOf(1)}, "name");
        if (cur != null) {
            while (cur.moveToNext()) {
                try {
                    Intent intent = new Intent();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    intent.putExtra(DST_PLAYLIST_KEY, cur.getLong(0));
                    sub.add(1, 3, 0, cur.getString(1)).setIntent(intent);
                } finally {
                    cur.close();
                }
            }
        }
    }

    public static void makePlaylistMenu(Context context, Menu sub, Intent extras) {
        makePlaylistMenu(context, sub, extras, -1);
    }

    public static void makePlaylistMenuProxy(Context context, MenuItem item, Intent extras, OnMenuItemClickListener l) {
        makePlaylistMenuProxy(context, item, extras, -1, l);
    }

    public static void makePlaylistMenuProxy(Context context, MenuItem item, Intent extras, long excludeId, OnMenuItemClickListener l) {
        SubMenuBuilder sub = new SubMenuBuilder(context, item, l);
        if (excludeId != 0) {
            sub.add(1, 12, 0, (int) C0329R.string.queue).setIntent(extras);
        }
        sub.add(1, 4, 0, (int) C0329R.string.new_playlist).setIntent(extras);
        Context context2 = context;
        Cursor cur = SqlUtils.query(context2, MiuiPlaylists.EXTERNAL_URI, new String[]{"_id", "name"}, String.format("(%s!='') AND (%s=%d) AND (%s!=%d) AND (%s!=?)", new Object[]{"name", "list_type", Integer.valueOf(0), "_id", Long.valueOf(excludeId), "mi_sync_playlist_state"}), new String[]{String.valueOf(1)}, "name");
        if (cur != null) {
            while (cur.moveToNext()) {
                try {
                    Intent intent = new Intent();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    intent.putExtra(DST_PLAYLIST_KEY, cur.getLong(0));
                    sub.add(1, 3, 0, cur.getString(1)).setIntent(intent);
                } finally {
                    cur.close();
                }
            }
        }
        sub.build();
    }

    public static void displayDatabaseError(Activity a) {
        if (!a.isFinishing()) {
            int message;
            View v;
            String status = Environment.getExternalStorageState();
            if (Environment.isExternalStorageRemovable()) {
                message = C0329R.string.sdcard_error_message;
            } else {
                message = C0329R.string.sdcard_error_message_nosdcard;
            }
            if (status.equals("shared") || status.equals("unmounted")) {
                if (Environment.isExternalStorageRemovable()) {
                    message = C0329R.string.sdcard_busy_message;
                } else {
                    message = C0329R.string.sdcard_busy_message_nosdcard;
                }
            } else if (status.equals("removed")) {
                if (Environment.isExternalStorageRemovable()) {
                    message = C0329R.string.sdcard_missing_message;
                } else {
                    message = C0329R.string.sdcard_missing_message_nosdcard;
                }
            } else if (status.equals("mounted")) {
                Intent intent = new Intent();
                intent.setClass(a, ScanningProgress.class);
                a.startActivityForResult(intent, 11);
            } else if (!TextUtils.equals(mLastSdStatus, status)) {
                mLastSdStatus = status;
                Log.d(TAG, "sd card: " + status);
            }
            for (int id : SD_ERROR_INDICATORS) {
                v = a.findViewById(id);
                if (v != null) {
                    v.setVisibility(0);
                }
            }
            for (int id2 : SD_USABLE_INDICATORS) {
                v = a.findViewById(id2);
                if (v != null) {
                    v.setVisibility(8);
                }
            }
            TextView tv = (TextView) a.findViewById(C0329R.id.sd_message);
            if (tv != null) {
                tv.setText(message);
            }
        }
    }

    public static void hideDatabaseError(Activity a) {
        for (int id : SD_ERROR_INDICATORS) {
            View v = a.findViewById(id);
            if (v != null) {
                v.setVisibility(8);
            }
        }
        for (int id2 : SD_USABLE_INDICATORS) {
            v = a.findViewById(id2);
            if (v != null) {
                v.setVisibility(0);
            }
        }
    }

    public static void notifyAddToPlaylist(Context context, long playlistId, int size) {
        toastSafe(context.getResources().getQuantityString(FavoriteCache.isFavoritePlaylistId(context, playlistId) ? C0329R.plurals.NNNtrackstofavoriteplaylist : C0329R.plurals.NNNtrackstoplaylist, size, new Object[]{Integer.valueOf(size)}));
    }

    public static void notifyRemoveFromPlaylist(Context context, long playlistId, int size) {
        Toast.makeText(context, context.getResources().getQuantityString(FavoriteCache.isFavoritePlaylistId(context, playlistId) ? C0329R.plurals.Ntracks_remove_from_favorite_playlist : C0329R.plurals.Ntracks_remove_from_playlist, size, new Object[]{Integer.valueOf(size)}), 0).show();
    }

    public static String format(String format, Object... args) {
        sFormatBuilder.setLength(0);
        return sFormatter.format(Locale.getDefault(), format, args).toString();
    }

    public static String makeAlbumsLabel(Context context, int numalbums, int numsongs, String artist) {
        boolean isUnknown = MetaManager.isUnknowName(artist);
        Resources r = context.getResources();
        if (isUnknown) {
            return format(r.getQuantityText(C0329R.plurals.Ntracks_format, numsongs).toString(), Integer.valueOf(numsongs));
        }
        String album = format(r.getQuantityText(C0329R.plurals.Nalbums_format, numalbums).toString(), Integer.valueOf(numalbums));
        String track = format(r.getQuantityText(C0329R.plurals.Ntracks_format, numsongs).toString(), Integer.valueOf(numsongs));
        return format(r.getString(C0329R.string.artist_details_format), album, track);
    }

    public static String makeAlbumsSongsLabel(Context context, int numalbums, int numsongs, boolean isUnknown) {
        StringBuilder songs_albums = new StringBuilder();
        Resources r = context.getResources();
        if (!isUnknown) {
            songs_albums.append(r.getQuantityString(C0329R.plurals.Nalbums_format, numalbums, new Object[]{Integer.valueOf(numalbums)}));
            songs_albums.append(context.getString(C0329R.string.albumsongseparator));
        }
        songs_albums.append(r.getQuantityString(C0329R.plurals.Ntracks_format, numsongs, new Object[]{Integer.valueOf(numsongs)}));
        return songs_albums.toString();
    }

    public static void setChildEnabled(ViewGroup parent, boolean enabled) {
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            parent.getChildAt(i).setEnabled(enabled);
        }
    }

    public static View makeSpecialView(ViewGroup root, int headerId, int iconId, int textId) {
        return makeSpecialView(root, headerId, iconId, root.getContext().getText(textId), 0);
    }

    public static View makeSpecialView(ViewGroup root, int headerId, int iconId, int textId, int leftMargin) {
        return makeSpecialView(root, headerId, iconId, root.getContext().getText(textId), leftMargin);
    }

    public static View makeSpecialView(ViewGroup root, int headerId, int iconId, CharSequence text, int leftMargin) {
        View view = Views.inflate(root.getContext(), C0329R.layout.picker_list_header, root, false);
        if (leftMargin != 0) {
            View v = view.findViewById(C0329R.id.container);
            MarginLayoutParams marginParams = (MarginLayoutParams) v.getLayoutParams();
            marginParams.leftMargin = leftMargin;
            v.setLayoutParams(marginParams);
        }
        ((ImageView) view.findViewById(C0329R.id.icon)).setImageResource(iconId);
        ((TextView) view.findViewById(C0329R.id.name)).setText(text);
        view.setTag(Integer.valueOf(headerId));
        return view;
    }

    public static ImageView getSpecialViewIconView(View specialView) {
        if (specialView != null) {
            return (ImageView) specialView.findViewById(C0329R.id.icon);
        }
        return null;
    }

    public static boolean updateSpecialViewIcon(View specialView, int iconId) {
        if (specialView != null) {
            ImageView icon = (ImageView) specialView.findViewById(C0329R.id.icon);
            if (icon != null) {
                icon.setImageResource(iconId);
                return true;
            }
        }
        return false;
    }

    public static void updateSpecialViewText(View specialView, int resId) {
        if (specialView != null) {
            TextView textView = (TextView) specialView.findViewById(C0329R.id.name);
            if (textView != null) {
                textView.setText(resId);
            }
        }
    }

    public static CharSequence getDescript(Context context, CharSequence ar, CharSequence al) {
        boolean hasArtist;
        boolean hasAlbum;
        ar = MetaManager.getLocaleArtistName(context, ar);
        al = MetaManager.getLocaleAlbumName(context, al);
        CharSequence showName = MetaManager.UNKNOWN_STRING;
        if (TextUtils.isEmpty(ar)) {
            hasArtist = false;
        } else {
            hasArtist = true;
        }
        if (TextUtils.isEmpty(al)) {
            hasAlbum = false;
        } else {
            hasAlbum = true;
        }
        if (hasArtist && hasAlbum) {
            return format(context.getString(C0329R.string.album_artist_format), al, ar);
        } else if (hasArtist) {
            return ar;
        } else {
            if (hasAlbum) {
                return al;
            }
            return showName;
        }
    }

    public static boolean sendByChooser(Context context, long audioId) {
        Uri uri = ContentUris.withAppendedId(Media.EXTERNAL_CONTENT_URI, audioId);
        Cursor c = SqlUtils.query(context, uri, new String[]{DBConfig.SIZE}, null, null, null, 1);
        if (c == null) {
            return false;
        }
        try {
            if (c.moveToFirst()) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", uri);
                intent.setDataAndType(null, "audio/*");
                String size = Strings.formatSize(c.getLong(0));
                context.startActivity(Intent.createChooser(intent, context.getString(C0329R.string.send_to) + (size != null ? "(" + size + ")" : MetaManager.UNKNOWN_STRING)));
            }
            c.close();
            return true;
        } catch (Throwable th) {
            c.close();
        }
    }

    public static long getFileDuration(String filePath) {
        try {
            return (long) (AudioFileIO.read(new File(filePath)).getLength() * 1000);
        } catch (CannotReadException e) {
            return 0;
        }
    }

    public static String makeTimeString(Context context, long millsSecs, int formatId) {
        long secs = (500 + millsSecs) / 1000;
        if (secs >= 3600) {
            formatId = C0329R.string.durationformatlong;
        }
        String durationformat = context.getString(formatId);
        Object[] timeArgs = sTimeArgs;
        timeArgs[0] = Long.valueOf(secs / 3600);
        timeArgs[1] = Long.valueOf(secs / 60);
        timeArgs[2] = Long.valueOf((secs / 60) % 60);
        timeArgs[3] = Long.valueOf(secs);
        timeArgs[4] = Long.valueOf(secs % 60);
        return format(durationformat, timeArgs).toString();
    }

    public static String makeTimeString(Context context, long millsSecs) {
        return makeTimeString(context, millsSecs, C0329R.string.durationformatshort);
    }

    public static void setRingtone(Context context, long id) {
        ContentResolver resolver = context.getContentResolver();
        Uri ringUri = ContentUris.withAppendedId(Media.EXTERNAL_CONTENT_URI, id);
        try {
            ContentValues values = new ContentValues(2);
            values.put("is_ringtone", "1");
            values.put("is_alarm", "1");
            resolver.update(ringUri, values, null, null);
            String[] cols = new String[]{"_id", "_data", "title"};
            String where = "_id=" + id;
            Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, cols, where, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1) {
                        cursor.moveToFirst();
                        System.putString(resolver, "ringtone", ringUri.toString());
                        Toast.makeText(context, context.getString(C0329R.string.ringtone_set, new Object[]{cursor.getString(2)}), 0).show();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (UnsupportedOperationException e) {
            Log.e(TAG, "couldn't set ringtone flag for id " + id);
        }
    }

    public static boolean unregistBroadcastReceiverSafe(Context context, BroadcastReceiver receiver) {
        try {
            context.unregisterReceiver(receiver);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void setPadding(View v, int l, int t, int r, int b) {
        if (l < 0) {
            l = v.getPaddingLeft();
        }
        if (t < 0) {
            t = v.getPaddingTop();
        }
        if (r < 0) {
            r = v.getPaddingRight();
        }
        if (b < 0) {
            b = v.getPaddingBottom();
        }
        v.setPadding(l, t, r, b);
    }

    public static void addSubsequentAnimation(Animation first, final View view, final Animation second, final AnimationListener l) {
        first.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
                if (l != null) {
                    l.onAnimationStart(animation);
                }
            }

            public void onAnimationRepeat(Animation animation) {
                if (l != null) {
                    l.onAnimationRepeat(animation);
                }
            }

            public void onAnimationEnd(Animation animation) {
                if (l != null) {
                    l.onAnimationEnd(animation);
                }
                if (view != null && second != null) {
                    view.startAnimation(second);
                }
            }
        });
    }

    public static int getListViewHeaderCount(AdapterView<?> v) {
        if (v instanceof ListView) {
            return ((ListView) v).getHeaderViewsCount();
        }
        return 0;
    }

    public static int getListViewFooterCount(AdapterView<?> v) {
        if (v instanceof ListView) {
            return ((ListView) v).getFooterViewsCount();
        }
        return 0;
    }

    public static String getDisplayFolderPath(String raw) {
        for (String prefix : new String[]{"/storage/", "/mnt/"}) {
            if (raw.startsWith(prefix)) {
                return raw.substring(prefix.length() - 1);
            }
        }
        return raw;
    }

    public static boolean toggleCurrentAudioFavorite(Context context) {
        boolean favorite;
        String onlineId = ServiceHelper.getCurrentOnlineId();
        long audioId = ServiceHelper.getCurrentAudioId();
        long plid = FavoriteCache.getFavoritePlaylistId(context);
        if (onlineId == null) {
            if (FavoriteCache.localContains(context, audioId)) {
                favorite = false;
            } else {
                favorite = true;
            }
            if (favorite) {
                PlaylistHelper.addToPlaylist(context, new long[]{audioId}, plid, true);
            } else {
                PlaylistHelper.removeMembers(context, new long[]{audioId}, plid);
            }
        } else {
            if (FavoriteCache.onlineContains(context, onlineId)) {
                favorite = false;
            } else {
                favorite = true;
            }
            if (favorite) {
                PlaylistHelper.addToPlaylist(context, new long[]{audioId}, plid, true);
            } else {
                List<String> onlineIds = Lists.newArrayList();
                onlineIds.add(onlineId);
                PlaylistHelper.removeOnlineMembers(context, onlineIds, OnlineMusicProxy.getProviderName(context), plid);
            }
        }
        return favorite;
    }

    public static ViewFactory makeImageFactory(Context context, int width, int height, ScaleType scaleType, int dftId) {
        return makeImageFactory(context, new LayoutParams(-1, -1), scaleType, dftId);
    }

    public static ViewFactory makeImageFactory(Context context, LayoutParams params, ScaleType scaleType, int dftId) {
        return new ImageFactory(context, params, scaleType, dftId);
    }

    public static void measureHeightByBackground(View view) {
        setLayoutHeight(view, view.getBackground().getIntrinsicHeight());
    }

    public static void setLayoutHeight(View view, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = height;
        view.setLayoutParams(params);
    }

    public static int getActivityHeight(Activity a) {
        DisplayMetrics metric = new DisplayMetrics();
        a.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.heightPixels - a.getResources().getDimensionPixelSize(101318675);
    }

    public static ItemViewBinder createBinderForList(int checkBoxId) {
        return new CheckBoxItemBinder(checkBoxId);
    }

    public static ItemViewBinder createBinderForGrid(int checkBoxId, int maskId) {
        return new MaskItemBinder(checkBoxId, maskId);
    }

    public static void startPlaybackView(Activity a) {
        if (ServiceHelper.isMusicLoaded()) {
            a.startActivity(new Intent("com.miui.player.PLAYBACK_VIEWER").setFlags(67108864));
        } else {
            Toast.makeText(a, C0329R.string.music_not_loaded, 0).show();
        }
    }

    public static void setViewAlpha(View view, float alpha) {
        if (view != null) {
            view.setAlpha(alpha);
            view.setVisibility(alpha > 0.0f ? 0 : 8);
        }
    }

    public static void showDialogForLyricSearch(Activity a, DialogCallback callback, String album, String artist, String track, String filePath, long localId) {
        Bundle lrcSearchBundle = new Bundle();
        lrcSearchBundle.putString(MediaEditDialog.DIALOG_TITLE, a.getString(C0329R.string.lyric_download));
        lrcSearchBundle.putString(MediaEditDialog.RAW_ALBUM_NAME, MetaManager.getRawName(album));
        lrcSearchBundle.putString(MediaEditDialog.RAW_ARTIST_NAME, MetaManager.getRawName(artist));
        lrcSearchBundle.putString(MediaEditDialog.RAW_TRACK_NAME, track);
        if (localId >= 0) {
            lrcSearchBundle.putString(MediaEditDialog.RAW_FILE_PATH, filePath);
            lrcSearchBundle.putBoolean(MediaEditDialog.MODIFY_ID3_ENABLED, true);
        }
        new MediaEditDialog(a, lrcSearchBundle, callback, 23).show();
    }

    public static ProgressDialog showDownloadDialog(Context context, int titleId) {
        ProgressDialog downloadFreezeDialog = ProgressDialog.show(context, MetaManager.UNKNOWN_STRING, context.getString(titleId));
        downloadFreezeDialog.setCancelable(true);
        downloadFreezeDialog.setOnCancelListener(new C04662());
        return downloadFreezeDialog;
    }

    public static void makeOnlineActionBarCustomView(final Activity a) {
        attachGotoNowplayingIcon(a, C0329R.layout.online_action_bar_custom_view);
        a.getActionBar().getCustomView().findViewById(101384367).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                a.finish();
            }
        });
    }

    public static void attachGotoNowplayingIcon(Activity a) {
        attachGotoNowplayingIcon(a, C0329R.layout.goto_nowplaying_icon);
    }

    public static void attachGotoNowplayingIcon(final Activity a, int layoutId) {
        ActionBar actionBar = a.getActionBar();
        actionBar.setCustomView(layoutId);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.getCustomView().findViewById(C0329R.id.goto_nowplaying_icon).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UIHelper.startPlaybackView(a);
            }
        });
    }

    public static float regularRotation(float rotation) {
        rotation %= 360.0f;
        if (rotation < 0.0f) {
            return rotation + 360.0f;
        }
        return rotation;
    }

    public static float clamp(float v, float min, float max) {
        return Math.max(min, Math.min(v, max));
    }

    public static int clamp(int v, int min, int max) {
        return Math.max(min, Math.min(v, max));
    }

    public static boolean removeChildPreference(PreferenceGroup preferenceGroup, String key) {
        Preference preference = preferenceGroup.findPreference(key);
        if (preference != null) {
            return removeChildPreference(preferenceGroup, preference);
        }
        return false;
    }

    public static boolean removeChildPreference(PreferenceGroup preferenceGroup, Preference preference) {
        if (preferenceGroup.removePreference(preference)) {
            return true;
        }
        int childCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < childCount; i++) {
            Preference childPreference = preferenceGroup.getPreference(i);
            if ((childPreference instanceof PreferenceGroup) && removeChildPreference((PreferenceGroup) childPreference, preference)) {
                return true;
            }
        }
        return false;
    }

    public static void showConfirmAlert(Activity activity, int customViewLayoutId, int confirmTextId) {
        Builder builder = new Builder(activity).setPositiveButton(C0329R.string.confirm, null);
        if (customViewLayoutId > 0) {
            builder.setView((ViewGroup) activity.getLayoutInflater().inflate(customViewLayoutId, null));
        }
        if (confirmTextId > 0) {
            builder.setPositiveButton(confirmTextId, null);
        }
        builder.show();
    }

    public static void toastSafe(int resId, Object... formatArgs) {
        toastSafe(MusicApplication.getApplication().getString(resId, formatArgs));
    }

    public static void toastSafe(String toastString) {
        sHandler.sendMessage(sHandler.obtainMessage(0, toastString));
    }

    public static void showUserGuide(Activity activity, View anchor, int offsetX, int offsetY, String preferenceKey, int stringResourceId) {
        Context context = MusicApplication.getApplication();
        if (PreferenceCache.getPrefAsBoolean(context, preferenceKey)) {
            PreferenceCache.setPrefAsBoolean(context, preferenceKey, false);
            final Activity activity2 = activity;
            final View view = anchor;
            final int i = stringResourceId;
            final int i2 = offsetX;
            final int i3 = offsetY;
            new Handler() {
                public void handleMessage(Message msg) {
                    if (!activity2.isFinishing()) {
                        GuidePopupWindow popupGuide = new GuidePopupWindow(view.getContext());
                        popupGuide.setGuideText(i);
                        popupGuide.setOutsideTouchable(true);
                        popupGuide.enableOutSideWindowTouchDismiss(false);
                        popupGuide.show(view, i2, i3, false);
                    }
                }
            }.sendEmptyMessageDelayed(0, 1000);
        }
    }

    public static void playChannel(Activity activity, String channelId, String channelName) {
        if (TextUtils.equals(ServiceHelper.getChannelName(), channelName)) {
            startPlaybackView(activity);
            return;
        }
        ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setIndeterminate(false);
        if (!OnlineMusicProxy.request(activity, new SongGroupRequest(activity, channelId, channelName, dialog))) {
            dialog.setMessage(activity.getString(C0329R.string.load_audio_in_process));
            dialog.setIndeterminate(true);
            dialog.show();
        }
    }

    public static boolean maskWindowCorner(Context context) {
        return System.getInt(context.getContentResolver(), "show_rounded_corners", context.getResources().getInteger(101187594)) != 0;
    }
}
