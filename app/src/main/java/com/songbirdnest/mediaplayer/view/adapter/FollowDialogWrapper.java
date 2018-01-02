package com.songbirdnest.mediaplayer.view.adapter;

import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.ItemDelegate;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.stream.StreamException;

public class FollowDialogWrapper {
    public TextView mArtistInfo = ((TextView) this.mDialog.findViewById(C0116R.id.following_artist_info));
    public TextView mComment = ((TextView) this.mDialog.findViewById(C0116R.id.following_comment));
    protected Dialog mDialog;
    public TextView mFollowingState = ((TextView) this.mDialog.findViewById(C0116R.id.following_state));
    public TextView mLike = ((TextView) this.mDialog.findViewById(C0116R.id.following_like));
    protected ImageView mStar = ((ImageView) this.mDialog.findViewById(C0116R.id.following_star));

    public interface Delegate {
        void likeToggle(String str);
    }

    static class BackgroundUpdate implements SoundboardListener<String> {
        BackgroundUpdate() {
        }

        public void onSuccess(String result) {
            Log.i(FollowDialogWrapper.class.getSimpleName(), "Like posted");
        }

        public void onFailure(String message, StreamException exception) {
            Log.e(FollowDialogWrapper.class.getSimpleName(), "Failed to update", exception);
        }
    }

    public enum DisplayItems {
        FollowingState,
        ArtistInfo,
        Comment,
        Like
    }

    public FollowDialogWrapper(Dialog pDialog) {
        this.mDialog = pDialog;
        this.mDialog.getWindow().requestFeature(1);
        this.mDialog.setContentView(C0116R.layout.following_dialog);
        this.mDialog.getWindow().setLayout(-1, -2);
    }

    public void hideOptions(DisplayItems... pItem) {
        for (DisplayItems aItem : pItem) {
            switch (aItem) {
                case FollowingState:
                    hideUnFollow();
                    break;
                case ArtistInfo:
                    hideArtist();
                    break;
                case Comment:
                    hideComment();
                    break;
                case Like:
                    hideLike();
                    break;
                default:
                    break;
            }
        }
    }

    public void setupLike(final ItemDelegate pDelegate, final Delegate pFeedRetriever) {
        if (pDelegate.isLiked()) {
            this.mLike.setText(C0116R.string.soundboard_unlike);
            this.mStar.setImageResource(C0116R.drawable.like_menu);
        } else {
            this.mLike.setText(C0116R.string.soundboard_like);
            this.mStar.setImageResource(C0116R.drawable.unlike_menu);
        }
        this.mLike.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                FollowDialogWrapper.this.mDialog.dismiss();
                if (pDelegate.isLiked()) {
                    SoundboardServer.get().unlikeFeedItem(pDelegate.getFeedID(), new BackgroundUpdate());
                } else {
                    SoundboardServer.get().likeFeedItem(pDelegate.getFeedID(), new BackgroundUpdate());
                }
                pFeedRetriever.likeToggle(pDelegate.getFeedID());
                Analytics.getAnalytics().track(Analytics.EVENT_WHATS_NEW_LIKE);
            }
        });
    }

    protected void hideLike() {
        this.mLike.setVisibility(8);
        this.mStar.setVisibility(8);
    }

    protected void hideArtist() {
        this.mArtistInfo.setVisibility(8);
    }

    protected void hideComment() {
        this.mComment.setVisibility(8);
    }

    protected void hideUnFollow() {
        this.mFollowingState.setVisibility(8);
    }

    public void follow() {
        this.mFollowingState.setText(C0116R.string.follow);
    }

    public void unFollow() {
        this.mFollowingState.setText(C0116R.string.unfollow);
    }
}
