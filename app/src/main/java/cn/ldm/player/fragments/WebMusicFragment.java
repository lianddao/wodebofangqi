package cn.ldm.player.fragments;

import android.app.Fragment;
import android.content.Context;
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.ldm.player.R;
import cn.ldm.player.core.maicong.KuGou;
import okhttp3.MediaType;


public class WebMusicFragment extends Fragment {

    private static final String TAG = WebMusicFragment.class.getSimpleName();
    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private WebMusicListAdapter _mediaItemAdapter;
    private List<MediaBrowser.MediaItem> _mediaItems;
    private ImageView imgAlbum;
    private TextView txtTitle, txtSubtitle;

    public WebMusicFragment() {
    }

    public static WebMusicFragment newInstance() {
        WebMusicFragment fragment = new WebMusicFragment();
        fragment._mediaItems = new ArrayList<>();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _mediaItemAdapter = new WebMusicListAdapter(getActivity(), _mediaItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_music, container, false);
        imgAlbum = (ImageView) view.findViewById(R.id.imgAlbum);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtSubtitle = (TextView) view.findViewById(R.id.txtSubtitle);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setAdapter(_mediaItemAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getMediaController().registerCallback(new MediaController.Callback() {
            @Override
            public void onMetadataChanged(@Nullable MediaMetadata metadata) {
                imgAlbum.setImageBitmap(metadata.getBitmap(MediaMetadata.METADATA_KEY_ART));
                txtTitle.setText(metadata.getDescription().getTitle());
                txtSubtitle.setText(metadata.getDescription().getSubtitle());
            }

            @Override
            public void onPlaybackStateChanged(@NonNull PlaybackState state) {
                Log.i(TAG, "onPlaybackStateChanged: ");
            }
        });
        new KuGou(new KuGou.Callback() {
            @Override
            public void onPostExecute(Object result) {
                ArrayList<MediaBrowser.MediaItem> items = (ArrayList<MediaBrowser.MediaItem>) result;
                _mediaItems.clear();
                _mediaItems.addAll(items);
                _mediaItemAdapter.notifyDataSetChanged();
            }
        });
    }


    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

        MediaBrowser getMediaBrowser();
    }
}
