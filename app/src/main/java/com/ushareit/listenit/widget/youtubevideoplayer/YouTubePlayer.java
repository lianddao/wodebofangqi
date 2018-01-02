package com.ushareit.listenit.widget.youtubevideoplayer;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.hfc;
import com.ushareit.listenit.hfd;
import com.ushareit.listenit.hfe;
import com.ushareit.listenit.hff;
import com.ushareit.listenit.hfg;
import com.ushareit.listenit.hfh;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class YouTubePlayer extends WebView {
    private Set<hfh> f17473a;
    private final Handler f17474b;

    public YouTubePlayer(Context context) {
        this(context, null);
    }

    public YouTubePlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YouTubePlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17474b = new Handler(Looper.getMainLooper());
        this.f17473a = new HashSet();
    }

    protected void m27098a(hfh com_ushareit_listenit_hfh) {
        if (com_ushareit_listenit_hfh != null) {
            this.f17473a.add(com_ushareit_listenit_hfh);
        }
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        addJavascriptInterface(new YouTubePlayerBridge(this), "YouTubePlayerBridge");
        settings.setCacheMode(-1);
        if (VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        loadDataWithBaseURL("https://www.youtube.com", getVideoPlayerHTML(), "text/html", "utf-8", null);
        setWebChromeClient(new hfc(this));
    }

    private String getVideoPlayerHTML() {
        try {
            InputStream openRawResource = getResources().openRawResource(C0349R.raw.player);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, "utf-8"));
            StringBuilder stringBuilder = new StringBuilder("");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine).append("\n");
                } else {
                    openRawResource.close();
                    return stringBuilder.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    protected void m27099a(String str, float f) {
        this.f17474b.post(new hfd(this, str, f));
    }

    protected void m27096a() {
        this.f17474b.post(new hfe(this));
    }

    protected void m27100b() {
        this.f17474b.post(new hff(this));
    }

    protected void m27097a(int i) {
        this.f17474b.post(new hfg(this, i));
    }

    public Set<hfh> getListeners() {
        return this.f17473a;
    }

    protected boolean m27101b(hfh com_ushareit_listenit_hfh) {
        return this.f17473a.add(com_ushareit_listenit_hfh);
    }
}
