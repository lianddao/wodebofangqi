package cn.ldm.player.fragments;

import android.app.Fragment;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import cn.ldm.player.R;
import cn.ldm.player.core.MusicScanner;
import cn.ldm.player.model.SongInfo;


public class PlayingFragment extends Fragment {

    private static final String TAG = PlayingFragment.class.getSimpleName();
    private InteractionListener mListener;
    private ImageView imgAlbum, imgPlayPause, imgPrev, imgNext;
    private SeekBar seekBar;
    private TextView txtTitle, txtSubtitle, txtPlayTime, txtTotalTime;
    private SongInfo _currentSong;

    public PlayingFragment() {
    }

    public static PlayingFragment newInstance() {
        PlayingFragment fragment = new PlayingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playing, container, false);
        imgAlbum = (ImageView) view.findViewById(R.id.imgAlbum);
        imgPlayPause = (ImageView) view.findViewById(R.id.imgPlayPause);
        imgPrev = (ImageView) view.findViewById(R.id.imgPrev);
        imgNext = (ImageView) view.findViewById(R.id.imgNext);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtSubtitle = (TextView) view.findViewById(R.id.txtSubtitle);
        txtPlayTime = (TextView) view.findViewById(R.id.txtPlayTime);
        txtTotalTime = (TextView) view.findViewById(R.id.txtTotalTime);


        MediaSession.Token token = (MediaSession.Token)getActivity().getIntent().getParcelableExtra("token");
        MediaController mediaController = new MediaController(getActivity(),token);
        MediaMetadata metadata = mediaController.getMetadata();
        _currentSong = SongInfo.make(metadata);
        imgAlbum.setImageBitmap(MusicScanner.getInstance(getActivity()).retrieveAlbumArt(_currentSong.getMediaMetadata()));
        txtTitle.setText(_currentSong.getTitle());
        txtSubtitle.setText(_currentSong.getSubtitle());

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
        MediaSession.Token getMediaSessionToken();
    }
}
