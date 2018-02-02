package cn.ldm.player.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.ldm.player.R;


public class MusicListFragment extends Fragment {

    private static final String TAG = MusicListFragment.class.getSimpleName();
    private MediaItem _parentMediaItem;
    private InteractionListener mListener;
    private List<MediaItem> _mediaItems = new ArrayList<>();
    private MusicListAdapter _mediaItemAdapter = new MusicListAdapter(_mediaItems);

    public MusicListFragment() {
    }

    public static MusicListFragment newInstance(MediaItem parentMediaItem) {
        MusicListFragment fragment = new MusicListFragment();
        fragment._parentMediaItem = parentMediaItem;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media_browser, container, false);

        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;

            /*
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            或在在布局文件中使用 app:layoutManager="LinearLayoutManager"
            * */

            recyclerView.setAdapter(_mediaItemAdapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

            final MediaBrowser mediaBrowser = mListener.getMediaBrowser();
            mediaBrowser.unsubscribe(_parentMediaItem.getMediaId());
            mediaBrowser.subscribe(_parentMediaItem.getMediaId(), new MediaBrowser.SubscriptionCallback() {
                @Override
                public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> children) {
                    _mediaItems.clear();
                    for (MediaItem item : children) {
                        _mediaItems.add(item);
                    }
                    _mediaItemAdapter.notifyDataSetChanged();
                }
            });

            if (getActivity().getMediaController() != null) {
                getActivity().getMediaController().registerCallback(new MediaController.Callback() {
                    @Override
                    public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                        Log.i(TAG, "onMetadataChanged: " + metadata.getDescription().getTitle());
                    }

                    @Override
                    public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                    }

                    @Override
                    public void onQueueChanged(@Nullable List<MediaSession.QueueItem> queue) {
                        Log.i(TAG, "onQueueChanged: " + queue.size());
                    }
                });
            }
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteractionListener) {
            mListener = (InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " 必须实现接口: InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
        mListener = null;
    }

    //谁需要外来数据,谁就声明接口
    public interface InteractionListener {
        MediaBrowser getMediaBrowser();
    }
}
