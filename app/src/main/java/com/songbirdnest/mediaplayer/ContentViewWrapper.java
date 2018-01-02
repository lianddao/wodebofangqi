package com.songbirdnest.mediaplayer;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.util.MediaUtils;
import java.util.HashMap;
import java.util.Map;

public class ContentViewWrapper implements OnClickListener {
    public static final int ALBUM_POSITION = 4;
    public static final int ARTIST_POSITION = 2;
    public static final int GENRE_POSITION = 5;
    public static final int PLAYLIST_POSITION = 1;
    public static final int PODCAST_POSITION = 6;
    public static final int SONG_POSITION = 3;
    public static final int VIDEO_POSITION = 7;
    protected Activity activity;
    protected ImageView homeIcon;
    protected HOME_ITEMS home_item;
    protected LinearLayout mainContainer;
    protected TextView mainText;
    protected TextView secondaryText;

    public ContentViewWrapper(Activity activity) {
        this.activity = activity;
    }

    public ImageView getHomeIcon() {
        return this.homeIcon;
    }

    public LinearLayout getMainContainer() {
        return this.mainContainer;
    }

    public TextView getMainText() {
        return this.mainText;
    }

    public TextView getSecondaryText() {
        return this.secondaryText;
    }

    public HOME_ITEMS getHomeItem() {
        return this.home_item;
    }

    public void setHomeItem(HOME_ITEMS home_item) {
        this.home_item = home_item;
    }

    public void setContentView(View contentView) {
        this.mainText = (TextView) contentView.findViewById(C0116R.id.main_text);
        this.secondaryText = (TextView) contentView.findViewById(C0116R.id.secondary_text);
        this.mainContainer = (LinearLayout) contentView.findViewById(C0116R.id.container);
        this.homeIcon = (ImageView) contentView.findViewById(C0116R.id.home_icon);
        this.mainContainer.setOnClickListener(this);
        this.mainContainer.setTag(this);
    }

    public void onClick(View v) {
        ContentViewWrapper contentViewWrapper = (ContentViewWrapper) v.getTag();
        if (contentViewWrapper != null) {
            Intent i = new Intent(this.activity, contentViewWrapper.home_item.viewClass);
            i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, contentViewWrapper.home_item.intentViewValue);
            if (this.home_item.equals(HOME_ITEMS.FRIENDS_VIEW)) {
                Map<String, String> properties = new HashMap();
                properties.put(Analytics.FROM_KEY, Analytics.HOME_VALUE);
                Analytics.get().trackEvent(Analytics.EVENT_SONGBIRD_ME_ENTRY, null, properties);
            }
            this.activity.startActivity(i);
        }
    }

    public void setText() {
        if (this.homeIcon != null) {
            this.homeIcon.setImageResource(this.home_item.iconResourceId);
            this.mainText.setText(this.home_item.mainTextResourceId);
            switch (this.home_item.ordinal()) {
                case 1:
                    this.secondaryText.setText("(" + Integer.toString(MediaUtils.getPlaylistTotal(this.activity)) + ")");
                    return;
                case 2:
                    this.secondaryText.setText("(" + Integer.toString(MediaUtils.getArtistTotal(this.activity)) + ")");
                    return;
                case 3:
                    this.secondaryText.setText("(" + Integer.toString(MediaUtils.getSongTotal(this.activity)) + ")");
                    return;
                case 4:
                    this.secondaryText.setText("(" + Integer.toString(MediaUtils.getAlbumTotal(this.activity)) + ")");
                    return;
                case 5:
                    this.secondaryText.setText("(" + Integer.toString(MediaUtils.getGenreTotal(this.activity)) + ")");
                    return;
                case 6:
                    this.secondaryText.setText("(" + Integer.toString(MediaUtils.getPodcastTotal(this.activity)) + ")");
                    return;
                case 7:
                    this.secondaryText.setText("(" + Integer.toString(MediaUtils.getVideoTotal(this.activity)) + ")");
                    return;
                default:
                    if (this.home_item.secondaryTextResourceId != 0) {
                        this.secondaryText.setText(this.home_item.secondaryTextResourceId);
                        return;
                    }
                    return;
            }
        }
    }
}
