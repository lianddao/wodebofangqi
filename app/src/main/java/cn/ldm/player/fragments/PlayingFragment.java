package cn.ldm.player.fragments;

import android.app.Fragment;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.ldm.player.R;
import cn.ldm.player.core.MusicScanner;
import cn.ldm.player.model.SongInfo;
import cn.ldm.player.tool.MusicTool;
import cn.ldm.player.ui.MediaSeekBar;


public class PlayingFragment extends Fragment implements MediaSeekBar.TimeChangeListener {

    private static final String TAG = PlayingFragment.class.getSimpleName();
    private ImageView imgAlbum, imgPlayPause, imgPrev, imgNext;
    private MediaSeekBar seekBar;
    private TextView txtTitle, txtSubtitle, txtPlayTime, txtTotalTime;
    private SongInfo _currentSong;

    @DrawableRes
    private int RES_PLAYING = android.R.drawable.ic_media_play, RES_PAUSE = android.R.drawable.ic_media_pause;

    private MediaController _mediaController;

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
        seekBar = (MediaSeekBar) view.findViewById(R.id.seekBar);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtSubtitle = (TextView) view.findViewById(R.id.txtSubtitle);
        txtPlayTime = (TextView) view.findViewById(R.id.txtPlayTime);
        txtTotalTime = (TextView) view.findViewById(R.id.txtTotalTime);
        _mediaController = getActivity().getMediaController();
        updateUi();
        //region MediaController 注册回调
        _mediaController.registerCallback(new MediaController.Callback() {
            @Override
            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                updateUi();
            }

            @Override
            public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                switch (state.getState()) {
                    case PlaybackState.STATE_PAUSED:
                        Log.i(TAG, " 播放已经暂停");
                        imgPlayPause.setImageResource(android.R.drawable.ic_media_play);
                        break;
                    case PlaybackState.STATE_STOPPED:
                        Log.i(TAG, " 播放已经停止");
                        imgPlayPause.setImageResource(android.R.drawable.ic_media_play);
                        txtPlayTime.setText(MusicTool.getDisplayTime(0));
                        break;
                    case PlaybackState.STATE_PLAYING:
                        Log.i(TAG, " 正在播放");
                        imgPlayPause.setImageResource(android.R.drawable.ic_media_pause);
                        break;
                    default:
                        break;
                }
            }
        });
        //endregion
        //region 单击事件
        imgPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (_mediaController.getPlaybackState().getState()) {
                    case PlaybackState.STATE_PLAYING:
                        _mediaController.getTransportControls().pause();
                        break;
                    case PlaybackState.STATE_PAUSED:
                    case PlaybackState.STATE_STOPPED:
                        _mediaController.getTransportControls().play();
                        break;
                    default:
                        break;
                }
            }
        });

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mediaController.getTransportControls().skipToNext();
            }
        });

        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mediaController.getTransportControls().skipToPrevious();
            }
        });
        //endregion

        return view;
    }

    private void updateUi(){
        MediaMetadata metadata = _mediaController.getMetadata();
        _currentSong = SongInfo.make(metadata);
        imgAlbum.setImageBitmap(MusicScanner.getInstance(getActivity()).retrieveAlbumArt(_currentSong.getMediaMetadata()));
        txtTitle.setText(_currentSong.getTitle());
        txtSubtitle.setText(_currentSong.getSubtitle());

        seekBar.setMax((int) metadata.getLong(MediaMetadata.METADATA_KEY_DURATION));
        seekBar.setProgress((int) _mediaController.getPlaybackState().getPosition());
        seekBar.startAnimator(seekBar.getContext(), this);
        imgPlayPause.setImageResource(RES_PAUSE);
        txtPlayTime.setText("0");
        txtTotalTime.setText(seekBar.getMax() + "");
    }

    private void updateNotification(){

    }

    @Override
    public void onProgressChanged(MediaSeekBar seekBar) {
        txtPlayTime.setText(MusicTool.getDisplayTime(seekBar.getProgress()));
        txtTotalTime.setText(MusicTool.getDisplayTime(seekBar.getMax()));
    }
}
