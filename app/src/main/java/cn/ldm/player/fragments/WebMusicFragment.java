package cn.ldm.player.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.ldm.player.R;
import cn.ldm.player.activities.PlayingActivity;
import cn.ldm.player.core.MusicScanner;
import cn.ldm.player.core.maicong.KuGou;


public class WebMusicFragment extends Fragment {

    private static final String TAG = WebMusicFragment.class.getSimpleName();
    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private WebMusicListAdapter _mediaItemAdapter;
    private List<MediaBrowser.MediaItem> _mediaItems;
    private ImageView imgAlbum, imgPlayPause, imgNext;
    private TextView txtTitle, txtSubtitle;

    public WebMusicFragment() {
    }

    public static WebMusicFragment newInstance() {
        WebMusicFragment fragment = new WebMusicFragment();
        fragment._mediaItems = new ArrayList<>();
        return fragment;
    }

    private MediaController.Callback _mediaControllerCallback = new MediaController.Callback() {
        //region 在网络媒体浏览的时候,存在正在播放本地音乐的情况
        @Override
        public void onMetadataChanged(@Nullable MediaMetadata metadata) {
            Bitmap bitmap;
            if (metadata.containsKey("URL")){
                bitmap = metadata.getBitmap(MediaMetadata.METADATA_KEY_ART);
            }else {
                bitmap = MusicScanner.getInstance(getActivity()).retrieveAlbumArt(metadata);
            }
            imgAlbum.setImageBitmap(metadata.getBitmap(MediaMetadata.METADATA_KEY_ART));
            txtTitle.setText(metadata.getDescription().getTitle());
            txtSubtitle.setText(metadata.getDescription().getSubtitle());
        }

        @Override
        public void onPlaybackStateChanged(@NonNull PlaybackState state) {
            switch (state.getState()) {
                case PlaybackState.STATE_PAUSED:
                    imgPlayPause.setImageResource(android.R.drawable.ic_media_play);
                    break;
                default:
                    imgPlayPause.setImageResource(android.R.drawable.ic_media_pause);
                    break;
            }
        }
        //endregion
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _mediaItemAdapter = new WebMusicListAdapter(getActivity(), _mediaItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_music, container, false);
        imgAlbum = (ImageView) view.findViewById(R.id.imgAlbum);
        imgPlayPause = (ImageView) view.findViewById(R.id.imgPlayPause);
        imgNext = (ImageView) view.findViewById(R.id.imgNext);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtSubtitle = (TextView) view.findViewById(R.id.txtSubtitle);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setAdapter(_mediaItemAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        imgAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaController mediaController = getActivity().getMediaController();
                MediaMetadata metadata = mediaController.getMetadata();
                Intent intent = new Intent(getActivity(), PlayingActivity.class);
                intent.putExtra("token", mListener.getMediaBrowser().getSessionToken());
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getMediaController().registerCallback(_mediaControllerCallback);
        KuGou.main(new KuGou.Callback() {
            @Override
            public void onPostExecute(Object result) {
                ArrayList<MediaBrowser.MediaItem> items = (ArrayList<MediaBrowser.MediaItem>) result;
                _mediaItems.clear();
                _mediaItems.addAll(items);
                _mediaItemAdapter.notifyDataSetChanged();
            }
        });
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);

        MediaBrowser getMediaBrowser();
    }


}
