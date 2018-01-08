package cn.ldm.player.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.ldm.player.R;


public class MediaBrowserFragment extends Fragment {

    private MediaItem mParentMediaItem;
    private InteractionListener mListener;
    private List<MediaItem> mMediaItems;
    private MediaItemAdapter mMediaItemAdapter;
    private MediaItemAdapter.OnMediaItemClickListener onMediaItemClickListener = new MediaItemAdapter.OnMediaItemClickListener() {
        @Override
        public void onClick(MediaItem mediaItem) {
            if (mediaItem.isBrowsable()) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, MediaBrowserFragment.newInstance(mediaItem));
                transaction.addToBackStack(null);
                transaction.commit();
            } else {
                Toast.makeText(getContext(), "播放歌曲", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public MediaBrowserFragment() {
        mMediaItems = new ArrayList<>();
        mMediaItemAdapter = new MediaItemAdapter(mMediaItems, onMediaItemClickListener);
    }

    public static MediaBrowserFragment newInstance(MediaItem parentMediaItem) {
        MediaBrowserFragment fragment = new MediaBrowserFragment();
        fragment.mParentMediaItem = parentMediaItem;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media_browser, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(mMediaItemAdapter);

            MediaBrowser mediaBrowser = mListener.getMediaBrowser();
            mediaBrowser.unsubscribe(mParentMediaItem.getMediaId());
            mediaBrowser.subscribe(mParentMediaItem.getMediaId(), new MediaBrowser.SubscriptionCallback() {
                @Override
                public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> children) {
                    mMediaItems.clear();
                    for (MediaItem item : children) {
                        mMediaItems.add(item);
                    }
                    mMediaItemAdapter.notifyDataSetChanged();
                }
            });
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteractionListener) {
            mListener = (InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface InteractionListener {
        MediaBrowser getMediaBrowser();
    }
}
