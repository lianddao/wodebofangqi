package com.miui.player.util;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import com.miui.player.meta.MetaManager;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.ParseException;

public final class FileNameUtils {
    private static final Pattern FILE_NAME_FILTER = Pattern.compile("[:/|\t\"\\?\\*\\<\\>\\\\]+");
    private static final String LOG_TAG = "common/FileNameUtils";

    public static final class UriAndFileName {
        public String Filename;
        public String Mimetype;
        public URI Uri;
    }

    public static class WebAddress {
        static final int MATCH_GROUP_AUTHORITY = 2;
        static final int MATCH_GROUP_HOST = 3;
        static final int MATCH_GROUP_PATH = 5;
        static final int MATCH_GROUP_PORT = 4;
        static final int MATCH_GROUP_SCHEME = 1;
        static Pattern sAddressPattern = Pattern.compile("(?:(http|HTTP|https|HTTPS|file|FILE)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([-A-Za-z0-9%]+(?:\\.[-A-Za-z0-9%]+)*)?(?:\\:([0-9]+))?(\\/?.*)?");
        public String mAuthInfo;
        public String mHost;
        public String mPath;
        public int mPort;
        public String mScheme;

        public WebAddress(String address) throws ParseException {
            if (address == null) {
                throw new NullPointerException();
            }
            this.mScheme = MetaManager.UNKNOWN_STRING;
            this.mHost = MetaManager.UNKNOWN_STRING;
            this.mPort = -1;
            this.mPath = "/";
            this.mAuthInfo = MetaManager.UNKNOWN_STRING;
            Matcher m = sAddressPattern.matcher(address);
            if (m.matches()) {
                String t = m.group(1);
                if (t != null) {
                    this.mScheme = t;
                }
                t = m.group(2);
                if (t != null) {
                    this.mAuthInfo = t;
                }
                t = m.group(3);
                if (t != null) {
                    this.mHost = t;
                }
                t = m.group(4);
                if (t != null) {
                    try {
                        this.mPort = Integer.parseInt(t);
                    } catch (NumberFormatException e) {
                        throw new ParseException("Bad port");
                    }
                }
                t = m.group(5);
                if (t != null && t.length() > 0) {
                    if (t.charAt(0) == '/') {
                        this.mPath = t;
                    } else {
                        this.mPath = "/" + t;
                    }
                }
                if (this.mPort == 443 && this.mScheme.equals(MetaManager.UNKNOWN_STRING)) {
                    this.mScheme = "https";
                } else if (this.mPort == -1) {
                    if (this.mScheme.equals("https")) {
                        this.mPort = 443;
                    } else {
                        this.mPort = 80;
                    }
                }
                if (this.mScheme.equals(MetaManager.UNKNOWN_STRING)) {
                    this.mScheme = "http";
                    return;
                }
                return;
            }
            throw new ParseException("Bad address");
        }

        public String toString() {
            String port = MetaManager.UNKNOWN_STRING;
            if ((this.mPort != 443 && this.mScheme.equals("https")) || (this.mPort != 80 && this.mScheme.equals("http"))) {
                port = ":" + Integer.toString(this.mPort);
            }
            String authInfo = MetaManager.UNKNOWN_STRING;
            if (this.mAuthInfo.length() > 0) {
                authInfo = this.mAuthInfo + "@";
            }
            return this.mScheme + "://" + authInfo + this.mHost + port + this.mPath;
        }
    }

    public static final class WebAddressParserException extends ParseException {
        private static final long serialVersionUID = 8180187199011858163L;

        public WebAddressParserException(String detailMessage) {
            super(detailMessage);
        }

        public WebAddressParserException(String detailMessage, Exception e) {
            super(detailMessage + " 详细错误: " + e.toString());
        }
    }

    public static String getFileExtension(String filepath) {
        String s = new File(filepath).getName();
        int i = s.lastIndexOf(46);
        if (i <= 0 || i >= s.length() - 1) {
            return null;
        }
        return s.substring(i + 1).trim().toLowerCase();
    }

    public static String getFileExtensionFromUrl(String url) {
        UriAndFileName filename = guessFileName(url);
        if (filename == null || TextUtils.isEmpty(filename.Filename)) {
            return null;
        }
        String s = filename.Filename;
        int i = s.lastIndexOf(46);
        if (i <= 0 || i >= s.length() - 1) {
            return null;
        }
        return s.substring(i + 1).toLowerCase();
    }

    public static String regulateFileName(String src, String replace) {
        return FILE_NAME_FILTER.matcher(src).replaceAll(replace);
    }

    public static UriAndFileName guessFileName(String url) throws WebAddressParserException {
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url");
        }
        Log.v(LOG_TAG, "Starting download: " + url);
        UriAndFileName ret = new UriAndFileName();
        try {
            WebAddress webAddress = new WebAddress(new String(URLUtil.decode(url.getBytes())));
            String frag = null;
            String query = null;
            String path = webAddress.mPath;
            if (path.length() > 0) {
                int idx = path.lastIndexOf(35);
                if (idx != -1) {
                    frag = path.substring(idx + 1);
                    path = path.substring(0, idx);
                }
                idx = path.lastIndexOf(63);
                if (idx != -1) {
                    query = path.substring(idx + 1);
                    path = path.substring(0, idx);
                }
            }
            ret.Uri = new URI(webAddress.mScheme, webAddress.mAuthInfo, webAddress.mHost, webAddress.mPort, path, query, frag);
            String filename = path;
            String fileext = MetaManager.UNKNOWN_STRING;
            int filename_idx = path.lastIndexOf(47);
            if (-1 != filename_idx) {
                filename = path.substring(filename_idx + 1);
            }
            filename_idx = filename.lastIndexOf(46);
            if (-1 != filename_idx) {
                fileext = filename.substring(filename_idx + 1);
            }
            String contentDisposition = "attachment; filename=\"" + filename + "\"";
            ret.Mimetype = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileext);
            ret.Filename = URLUtil.guessFileName(url, contentDisposition, ret.Mimetype);
            return ret;
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Could not parse url for download: " + url, e);
            throw new WebAddressParserException(e.getMessage(), e);
        } catch (URISyntaxException e2) {
            Log.e(LOG_TAG, "Could not parse url for download: " + url, e2);
            throw new WebAddressParserException(e2.getMessage(), e2);
        }
    }
}
