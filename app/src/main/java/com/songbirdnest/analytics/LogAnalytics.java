package com.songbirdnest.analytics;

import android.content.Context;
import android.os.Environment;
import com.songbirdnest.mediaplayer.C0116R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public class LogAnalytics implements AnalyticsProvider {
    private static final String LOG_FOLDER = "log";
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    private static PrintWriter printWriter;

    private static class SingletonHolder {
        public static final LogAnalytics instance = new LogAnalytics();

        private SingletonHolder() {
        }
    }

    private LogAnalytics() {
    }

    public static AnalyticsProvider getInstance() {
        return SingletonHolder.instance;
    }

    public void init(Context aContext) {
        if (isLog(aContext)) {
            File root = new File(Environment.getExternalStorageDirectory(), LOG_FOLDER);
            if (!root.exists()) {
                root.mkdirs();
            }
            try {
                printWriter = new PrintWriter(new File(root, "SBAnalytics_" + timeStamp() + ".txt"));
            } catch (FileNotFoundException e) {
                printWriter = null;
                e.printStackTrace();
            }
            write("init", Analytics.getSessionParameters(aContext));
            write(Analytics.EVENT_DEVICEINFO, Analytics.getDeviceParameters());
        }
    }

    public void track(String aName) {
        write(Analytics.TRACK_KEY, aName);
    }

    public void trackEvent(String aCategory) {
        write("trackEvent", aCategory);
    }

    public void trackEvent(String aCategory, String aAction) {
        write("trackEvent", aCategory, aAction);
    }

    public void trackEvent(String aCategory, String aAction, Map<String, String> properties) {
        trackEvent(aCategory, aAction);
        write("Properties", (Map) properties);
    }

    public void trackError(String aCategory, Throwable aThrowable) {
        write("CRUMBS", Breadcrumbs.get());
        write("ERROR", Analytics.stackTrace(aThrowable));
    }

    public void queueEvent(String aCategory, String aAction, Map<String, String> properties) {
        trackEvent(aCategory, aAction);
        write("Properties", (Map) properties);
    }

    public void shutdown() {
        write("shutdown", "");
        close();
    }

    public void flush() {
        write("flush", "");
    }

    private void write(String tag, Map<String, String> parameters) {
        if (parameters != null) {
            write(tag, "parameters");
            for (Entry<String, String> entry : parameters.entrySet()) {
                write(tag, ((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            }
        }
    }

    public static void write(String tag, String string) {
        if (printWriter != null) {
            String line = timeStamp() + ": " + tag + ": [" + string + "] \n";
            printWriter.append(line);
            printWriter.flush();
            System.out.println("Analytics: " + line);
        }
    }

    public static void write(String tag, String string, String action) {
        if (printWriter != null) {
            String line = timeStamp() + ": " + tag + ": [" + string + ": " + action + "] \n";
            printWriter.append(line);
            printWriter.flush();
            System.out.println("Analytics: " + line);
        }
    }

    private static void close() {
        if (printWriter != null) {
            printWriter.append(timeStamp() + ": exit \n");
            printWriter.flush();
            printWriter.close();
            printWriter = null;
        }
    }

    private static String timeStamp() {
        return formatter.format(new Date());
    }

    private boolean isLog(Context aContext) {
        return Boolean.parseBoolean(aContext.getResources().getString(C0116R.string.log));
    }
}
