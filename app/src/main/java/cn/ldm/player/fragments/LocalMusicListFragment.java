package cn.ldm.player.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.ldm.player.R;
import cn.ldm.player.activities.PlayingActivity;
import cn.ldm.player.model.SongInfo;


public class LocalMusicListFragment extends Fragment {

    private static final String TAG = LocalMusicListFragment.class.getSimpleName();
    private InteractionListener mListener;
    private MediaItem _parentMediaItem;
    private MediaController _mediaController;
    private List<MediaItem> _mediaItems;
    private LocalMusicListAdapter _mediaItemAdapter;
    private RecyclerView recyclerView;
    private TextView txtTitle, txtSubtitle;
    private ImageView imgAlbum, imgPlayPause, imgNext;

    @DrawableRes
    private int RES_IMG_PLAYING = android.R.drawable.ic_media_play, RES_IMG_PAUSE = android.R.drawable.ic_media_pause;

    public LocalMusicListFragment() {
    }

    public static LocalMusicListFragment newInstance(MediaItem parentMediaItem) {
        LocalMusicListFragment fragment = new LocalMusicListFragment();
        fragment._parentMediaItem = parentMediaItem;
        fragment._mediaItems = new ArrayList<>();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _mediaItemAdapter = new LocalMusicListAdapter(getActivity(), _mediaItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media_browser, container, false);
        //region findViewById
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtSubtitle = (TextView) view.findViewById(R.id.txtSubtitle);
        imgAlbum = (ImageView) view.findViewById(R.id.imgAlbum);
        imgPlayPause = (ImageView) view.findViewById(R.id.imgPlayPause);
        imgNext = (ImageView) view.findViewById(R.id.imgNext);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        //endregion
        //region 单击事件
        imgPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (_mediaController.getPlaybackState().getState()) {
                    case PlaybackState.STATE_PAUSED:
                        _mediaController.getTransportControls().play();
                        break;
                    case PlaybackState.STATE_PLAYING:
                        _mediaController.getTransportControls().pause();
                        break;
                    case PlaybackState.STATE_STOPPED:
                        break;
                    default:
                        break;
                }
            }
        });

        imgAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaController mediaController = _mediaController;
                MediaMetadata metadata = mediaController.getMetadata();
                Intent intent = new Intent(getActivity(), PlayingActivity.class);
                intent.putExtra("token", mListener.getMediaBrowser().getSessionToken());
                startActivity(intent);
            }
        });

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mediaController.getTransportControls().skipToNext();
            }
        });
        //endregion

            /*
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            或在在布局文件中使用 app:layoutManager="LinearLayoutManager"
            * */

        recyclerView.setAdapter(_mediaItemAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        //region MediaBrowser 订阅
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
        //endregion

        //region 注册媒体控制器回调
        _mediaController = getActivity().getMediaController();
        _mediaController.registerCallback(_callback);
        //endregion

        return view;
    }

    private final MediaController.Callback _callback = new MediaController.Callback() {
        @Override
        public void onMetadataChanged(@Nullable MediaMetadata metadata) {
            Log.i(TAG, "onMetadataChanged: ");
            SongInfo songInfo = SongInfo.make(metadata);
            txtTitle.setText(songInfo.getTitle());
            txtSubtitle.setText(songInfo.getSubtitle());
            imgAlbum.setImageBitmap(songInfo.retrieveAlbumArt(getActivity()));
        }

        @Override
        public void onPlaybackStateChanged(@NonNull PlaybackState state) {
            switch (state.getState()) {
                case PlaybackState.STATE_PAUSED:
                    imgPlayPause.setImageResource(RES_IMG_PLAYING);
                    break;
                case PlaybackState.STATE_PLAYING:
                    imgPlayPause.setImageResource(RES_IMG_PAUSE);
                    break;
                default:
                    imgPlayPause.setImageResource(RES_IMG_PLAYING);
                    break;
            }
        }
    };

    @Override
    public void onStart() {
        super.onStart();
        mListener.localMusicFragmentONStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
        mListener.localMusicFragmentOnStopCall(_parentMediaItem);
        _mediaController.unregisterCallback(_callback);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: ");
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

        void localMusicFragmentOnStopCall(MediaItem mediaItem);

        void localMusicFragmentONStart();
    }
}
