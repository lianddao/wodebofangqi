package com.songbirdnest.mediaplayer.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.Songbird;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;
import java.util.HashMap;
import java.util.Map;

public class TopMenu {
    private Activity mActivity;
    private HomeButtonClickListener mHomeButtonClickListener;
    private Dialog mMoreDialog;

    public interface HomeButtonClickListener {
        void onHomeButtonClicked();
    }

    class C04021 implements OnClickListener {
        C04021() {
        }

        public void onClick(View v) {
            TopMenu.this.showMoreDialog();
        }
    }

    class C04043 implements OnClickListener {
        C04043() {
        }

        public void onClick(View v) {
            TopMenu.this.fireIntent("Search");
        }
    }

    class C04054 implements OnClickListener {
        C04054() {
        }

        public void onClick(View v) {
            TopMenu.this.fireIntent(Constants.CONTENT_VIEW_GENRE_LIST);
        }
    }

    class C04065 implements OnClickListener {
        C04065() {
        }

        public void onClick(View v) {
            TopMenu.this.fireIntent(Constants.CONTENT_VIEW_ALBUM_LIST);
        }
    }

    class C04076 implements OnClickListener {
        C04076() {
        }

        public void onClick(View v) {
            TopMenu.this.fireIntent(Constants.CONTENT_VIEW_VIDEO_LIST);
        }
    }

    class C04087 implements OnClickListener {
        C04087() {
        }

        public void onClick(View v) {
            TopMenu.this.fireIntent(Constants.CONTENT_VIEW_PODCAST_LIST);
        }
    }

    class C04098 implements OnClickListener {
        C04098() {
        }

        public void onClick(View v) {
            Map<String, String> properties = new HashMap();
            properties.put(Analytics.FROM_KEY, Analytics.MORE_VALUE);
            Analytics.get().trackEvent(Analytics.EVENT_SONGBIRD_ME_ENTRY, null, properties);
            TopMenu.this.fireIntent("Friends");
        }
    }

    public TopMenu(Activity aActivity) {
        this.mActivity = aActivity;
        ((Button) this.mActivity.findViewById(C0116R.id.top_menu_songbird_logo)).setOnClickListener(createOnClickListener(Constants.TOP_MENU_HOME));
        ((Button) this.mActivity.findViewById(C0116R.id.top_menu_playlist)).setOnClickListener(createOnClickListener(Constants.CONTENT_VIEW_PLAYLIST_LIST));
        ((Button) this.mActivity.findViewById(C0116R.id.top_menu_song)).setOnClickListener(createOnClickListener(Constants.CONTENT_VIEW_SONG_LIST));
        ((Button) this.mActivity.findViewById(C0116R.id.top_menu_artist)).setOnClickListener(createOnClickListener(Constants.CONTENT_VIEW_ARTIST_LIST));
        ((Button) this.mActivity.findViewById(C0116R.id.top_menu_more)).setOnClickListener(new C04021());
    }

    public void setHomeButtonClickListener(HomeButtonClickListener aListener) {
        this.mHomeButtonClickListener = aListener;
    }

    public OnClickListener createOnClickListener(final String aViewKey) {
        return new OnClickListener() {
            public void onClick(View v) {
                TopMenu.this.fireIntent(aViewKey);
            }
        };
    }

    private void fireIntent(String aViewKey) {
        if (this.mMoreDialog != null) {
            this.mMoreDialog.dismiss();
        }
        if (aViewKey.equals(Constants.TOP_MENU_HOME)) {
            Intent i = new Intent(this.mActivity, Songbird.class);
            i.addFlags(67108864);
            this.mActivity.startActivity(i);
            this.mActivity.overridePendingTransition(C0116R.anim.slide_left, C0116R.anim.slide_right);
            if (this.mHomeButtonClickListener != null) {
                this.mHomeButtonClickListener.onHomeButtonClicked();
                return;
            }
            return;
        }
        i = new Intent(this.mActivity, ContentBrowser.class);
        i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, aViewKey);
        this.mActivity.startActivity(i);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mMoreDialog != null) {
            this.mMoreDialog.dismiss();
        }
    }

    private void showMoreDialog() {
        if (this.mMoreDialog == null) {
            View view = LayoutInflater.from(this.mActivity).inflate(C0116R.layout.more_dialog, null);
            this.mMoreDialog = new Dialog(this.mActivity);
            this.mMoreDialog.getWindow().requestFeature(1);
            this.mMoreDialog.setContentView(view);
            this.mMoreDialog.setCanceledOnTouchOutside(true);
            ((LinearLayout) view.findViewById(C0116R.id.search_dialog_item)).setOnClickListener(new C04043());
            ((LinearLayout) view.findViewById(C0116R.id.genre_dialog_item)).setOnClickListener(new C04054());
            ((LinearLayout) view.findViewById(C0116R.id.album_dialog_item)).setOnClickListener(new C04065());
            ((LinearLayout) view.findViewById(C0116R.id.video_dialog_item)).setOnClickListener(new C04076());
            LinearLayout layout = (LinearLayout) view.findViewById(C0116R.id.podcast_dialog_item);
            layout.setVisibility(Utils.getPodcastVisibility());
            layout.setOnClickListener(new C04087());
            layout = (LinearLayout) view.findViewById(C0116R.id.friend_dialog_item);
            layout.setVisibility(Utils.getFriendsVisibility());
            layout.setOnClickListener(new C04098());
        }
        this.mMoreDialog.show();
        Analytics.getAnalytics().track(Analytics.EVENT_MUSIC_MORE);
    }
}
