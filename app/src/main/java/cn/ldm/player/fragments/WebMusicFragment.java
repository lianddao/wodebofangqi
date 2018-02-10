package cn.ldm.player.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import cn.ldm.player.R;
import cn.ldm.player.core.maicong.Music;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WebMusicFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WebMusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebMusicFragment extends Fragment {

    private static final String TAG = WebMusicFragment.class.getSimpleName();
    private OnFragmentInteractionListener mListener;

    public WebMusicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WebMusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebMusicFragment newInstance() {
        WebMusicFragment fragment = new WebMusicFragment();
        return fragment;
    }

    GetSongAsyncTask _asyncTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        //http://www.xiami.com/chart?spm=a1z1s.2943549.6827465.1.YB4YSL


        //        _asyncTask.execute();


    }


    class GetSongAsyncTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... strings) {
            Music music = new Music();
            return music.mc_get_song_by_name("a", "b", 1);
        }

        @Override
        protected void onPostExecute(String s) {
            Log.i(TAG, "onPostExecute: " + s);
        }
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    String post(String url) throws IOException {
//                RequestBody body = RequestBody.create(JSON);
        RequestBody body = new FormBody.Builder().add("input", "%E5%88%98%E5%BE%B7%E5%8D%8E")
                .add("filter", "name")
                .add("type", "xiami")
                .add("page", "1")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(":authority", "music.2333.me")
                .addHeader(":method", "POST")
                .addHeader(":path", "/")
                .addHeader(":scheme", "https")
                .addHeader("origin", "https://music.2333.me")
                .addHeader("referer", "https://music.2333.me/?name=%E5%88%98%E5%BE%B7%E5%8D%8E&type=xiami")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_web_music, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");
//        _asyncTask = new GetSongAsyncTask();
        //        _asyncTask.execute();
        Executors.newCachedThreadPool().submit(new Runnable() {
            @Override
            public void run() {
                Music music = new Music();
                Message message = Message.obtain();
                message.obj = music.mc_get_song_by_name("a", "b", 1);
                handler.sendMessage(message);
            }
        });
    }


    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Log.i(TAG, "handleMessage: " + msg.toString());
            return true;
        }
    });

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
    }
}
