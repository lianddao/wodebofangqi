package cn.ldm.player.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaController;
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
import cn.ldm.player.services.MyMediaBrowserService;


public class MusicListFragment extends Fragment {

    private static final String TAG = MusicListFragment.class.getSimpleName();
    private MediaItem _parentMediaItem;
    private InteractionListener mListener;
    private List<MediaItem> _mediaItems;
    private MediaItemAdapter _mediaItemAdapter;

    public MusicListFragment() {
        _mediaItems = new ArrayList<>();
        _mediaItemAdapter = new MediaItemAdapter(_mediaItems, new MediaItemAdapter.OnMediaItemClickListener() {
            @Override
            public void onClick(MediaItem mediaItem) {
                if (mediaItem.isBrowsable()) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, MusicListFragment.newInstance(mediaItem));
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else {
//                    String mediaId = MyMediaBrowserService.filterMediaId(mediaItem.getMediaId());
//                    getActivity().getMediaController().getTransportControls().playFromMediaId(mediaId, null);
                }
            }
        });
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
            //            recyclerView.setLayoutManager(new LinearLayoutManager(context)); 或在在布局文件中使用 app:layoutManager="LinearLayoutManager"
            recyclerView.setAdapter(_mediaItemAdapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

            MediaBrowser mediaBrowser = mListener.getMediaBrowser();
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

            MediaController mediaController = getActivity().getMediaController();
            if (mediaController != null) {
                mediaController.registerCallback(new MediaController.Callback() {
                    @Override
                    public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                        Log.i(TAG, "onMetadataChanged: " + metadata.getDescription().getTitle());
                    }

                    @Override
                    public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                        Log.i(TAG, "onPlaybackStateChanged: " + state.toString());
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
