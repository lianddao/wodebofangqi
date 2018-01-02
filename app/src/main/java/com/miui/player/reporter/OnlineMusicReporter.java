package com.miui.player.reporter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.miui.player.ui.base.ApplicationHelper;
import com.miui.player.util.DateTimeHelper;
import com.miui.player.util.Strings;
import com.xiaomi.music.util.NetworkUtil;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class OnlineMusicReporter {
    private static final String DATA_PATTERN = "yyyyMMdd";
    private static final String KEY_USER_INFO = "user_info";
    private static final int MAX_QUEUE_SIZE = 10;
    private static final int MSG_LOCAL_PLAY_STATUS = 2;
    private static final int MSG_ONLINE_PLAY_STATUS = 3;
    private static final int MSG_USER_START = 1;
    static final String TAG = "OnlineMusicReporter";
    private static Handler sAsyncHandler = null;
    static Context sContext = null;
    private static LogQueue<UserInfo> sUserInfoQueue = null;

    interface LogFactory<T> {
        boolean add(T t, T t2);

        T create(String str);
    }

    static class LogQueue<T> {
        private final LogFactory<T> mFactory;
        private final String mKey;
        private final LinkedList<T> mList = new LinkedList();
        private final int mMaxSize;
        private final SharedPreferences mPreferences;

        public LogQueue(SharedPreferences sp, String key, LogFactory<T> factory, int size) {
            this.mPreferences = sp;
            this.mKey = key;
            this.mFactory = factory;
            this.mMaxSize = size;
            String pref = this.mPreferences.getString(key, null);
            if (pref != null) {
                try {
                    JSONArray array = new JSONArray(pref);
                    int len = array.length();
                    for (int i = 0; i < len; i++) {
                        T t = this.mFactory.create(array.getString(i));
                        if (t != null) {
                            this.mList.add(t);
                        }
                    }
                } catch (JSONException e) {
                }
            }
        }

        public int size() {
            return this.mList.size();
        }

        public T getFirst() {
            return this.mList.isEmpty() ? null : this.mList.getFirst();
        }

        public T removeFirst() {
            if (this.mList.isEmpty()) {
                return null;
            }
            return this.mList.removeFirst();
        }

        public boolean append(T t) {
            if (t == null || (!this.mList.isEmpty() && this.mFactory.add(this.mList.getLast(), t))) {
                return false;
            }
            this.mList.add(t);
            if (this.mList.size() > this.mMaxSize) {
                this.mList.removeFirst();
            }
            return true;
        }

        public void persist() {
            Editor editor = this.mPreferences.edit();
            editor.putString(this.mKey, new JSONArray(this.mList).toString());
            editor.apply();
        }
    }

    static class UserInfo {
        public static final String SEPARATOR = ",";
        public final String mDate;
        public int mTrackCount;

        public UserInfo(String date, int count) {
            this.mDate = date;
            this.mTrackCount = count;
        }

        public String toString() {
            return this.mDate + "," + this.mTrackCount;
        }
    }

    static class UserInfoFactory implements LogFactory<UserInfo> {
        UserInfoFactory() {
        }

        public boolean add(UserInfo first, UserInfo second) {
            if (!TextUtils.equals(first.mDate, second.mDate)) {
                return false;
            }
            first.mTrackCount += second.mTrackCount;
            return true;
        }

        public UserInfo create(String src) {
            List<String> array = Strings.seperateValues(src, ",");
            if (array.size() == 2) {
                String date = (String) array.get(0);
                try {
                    int count = Integer.valueOf((String) array.get(1)).intValue();
                    if (date != null && count >= 0) {
                        return new UserInfo(date, count);
                    }
                } catch (NumberFormatException e) {
                }
            }
            return null;
        }
    }

    public static void postUserStart(Context context) {
        getAsyncHandler(context).obtainMessage(1).sendToTarget();
    }

    public static void postLocalPlayStatus(Context context) {
        getAsyncHandler(context).obtainMessage(2).sendToTarget();
    }

    public static void postOnlinePlayStatus(Context context, OnlinePlayStatus status) {
        getAsyncHandler(context).obtainMessage(3, status).sendToTarget();
    }

    static void postUserStartAsync(Context context) {
        LogQueue<UserInfo> log = getUserInfoQueue(context);
        if (log.append(new UserInfo(DateTimeHelper.getCurrentString(DATA_PATTERN), 0))) {
            while (NetworkUtil.isActive(context) && log.size() > 1) {
                Date date = DateTimeHelper.fromString(((UserInfo) log.getFirst()).mDate, DATA_PATTERN);
                if (date != null) {
                    ApplicationHelper.instance().getReporter().postUserStart(context, date);
                }
                log.removeFirst();
            }
            log.persist();
        }
    }

    static void postLocalPlayStatusAsync(Context context) {
        LogQueue<UserInfo> log = getUserInfoQueue(context);
        if (log.append(new UserInfo(DateTimeHelper.getCurrentString(DATA_PATTERN), 1))) {
            while (NetworkUtil.isActive(context) && log.size() > 1) {
                UserInfo info = (UserInfo) log.getFirst();
                Date date = DateTimeHelper.fromString(info.mDate, DATA_PATTERN);
                boolean remove = true;
                if (date != null) {
                    remove = ApplicationHelper.instance().getReporter().postLocalPlayStatus(context, date, info.mTrackCount);
                }
                if (remove) {
                    log.removeFirst();
                }
            }
        }
        log.persist();
    }

    static void postOnlinePlayStatusAsync(Context context, OnlinePlayStatus status) {
        ApplicationHelper.instance().getReporter().postOnlinePlayStatus(context, status);
    }

    private static synchronized Handler getAsyncHandler(Context context) {
        Handler handler;
        synchronized (OnlineMusicReporter.class) {
            if (sAsyncHandler == null) {
                sContext = context.getApplicationContext();
                HandlerThread ht = new HandlerThread("online_reporter", 10);
                ht.start();
                sAsyncHandler = new Handler(ht.getLooper()) {
                    public void handleMessage(Message msg) {
                        if (OnlineMusicReporter.sContext == null) {
                            Log.e(OnlineMusicReporter.TAG, "sContext is null");
                            return;
                        }
                        switch (msg.what) {
                            case 1:
                                OnlineMusicReporter.postUserStartAsync(OnlineMusicReporter.sContext);
                                return;
                            case 2:
                                OnlineMusicReporter.postLocalPlayStatusAsync(OnlineMusicReporter.sContext);
                                return;
                            case 3:
                                OnlineMusicReporter.postOnlinePlayStatusAsync(OnlineMusicReporter.sContext, (OnlinePlayStatus) msg.obj);
                                return;
                            default:
                                throw new UnsupportedOperationException("bad msg type=" + msg.what);
                        }
                    }
                };
            }
            handler = sAsyncHandler;
        }
        return handler;
    }

    private static synchronized LogQueue<UserInfo> getUserInfoQueue(Context context) {
        LogQueue<UserInfo> logQueue;
        synchronized (OnlineMusicReporter.class) {
            if (sUserInfoQueue == null) {
                sUserInfoQueue = new LogQueue(PreferenceManager.getDefaultSharedPreferences(context), KEY_USER_INFO, new UserInfoFactory(), 10);
            }
            logQueue = sUserInfoQueue;
        }
        return logQueue;
    }
}
