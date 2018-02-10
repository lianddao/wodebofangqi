package cn.ldm.player.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import cn.ldm.player.R;
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

    AsyncTask _asyncTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //http://www.xiami.com/chart?spm=a1z1s.2943549.6827465.1.YB4YSL

        _asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
//                    return run("input=%E5%88%98%E5%BE%B7%E5%8D%8E&filter=name&type=xiami&page=1");
                    return post("https://music.2333.me/?name=%E5%88%98%E5%BE%B7%E5%8D%8E&type=xiami");
                } catch (IOException ex) {
                    Log.e(TAG, "onCreate: " + ex.toString());
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Object o) {
                Log.i(TAG, "onPostExecute: " + o.toString());
            }
        };
        _asyncTask.execute();
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
        //        RequestBody body = RequestBody.create(JSON);
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
                .addHeader("origin","https://music.2333.me")
                .addHeader("referer","https://music.2333.me/?name=%E5%88%98%E5%BE%B7%E5%8D%8E&type=xiami")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web_music, container, false);
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
    }
}
