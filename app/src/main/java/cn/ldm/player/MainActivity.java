package cn.ldm.player;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.ldm.player.activities.PermissionActivity;
import cn.ldm.player.services.MyMediaBrowserService;

public class MainActivity extends PermissionActivity {

    private String PARENT_ITEM = "PARENT_ITEM";
    private ListView listView;
    private MediaItemAdapter adapter;
    private MediaBrowser mediaBrowser;
    private MediaItem mParentItem;
    private MediaItem DEFAULT_PARENT_ITEM = new MediaBrowser.MediaItem(
            new MediaDescription.Builder()
                    .setMediaId(MyMediaBrowserService.MEDIA_ID_MUSIC_BY_ALBUM)
                    .build(),
            MediaBrowser.MediaItem.FLAG_BROWSABLE
    );
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            String xx = MyMediaBrowserService.MEDIA_ID_MUSIC_BY_ALBUM + MyMediaBrowserService.CATEGORY_SEPARATOR + adapter.getItem(position).getDescription().getTitle();
            if (adapter.getItem(position).isBrowsable()) {
                mParentItem = new MediaBrowser.MediaItem(new MediaDescription.Builder().setMediaId(xx).build(), MediaItem.FLAG_BROWSABLE);
                                intent.putExtra(PARENT_ITEM, mParentItem);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
//                count++;
                mediaBrowser.subscribe(mParentItem.getMediaId(), new MediaBrowser.SubscriptionCallback() {
                    @Override
                    public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> children) {
                        adapter.clear();
                        adapter.notifyDataSetInvalidated();
                        for (MediaItem item : children) {
                            adapter.add(item);
                            Log.i("abc", item.getDescription().getTitle().toString());
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
            } else {
                Toast.makeText(MainActivity.this, "播放" + adapter.getItem(position).getDescription().getTitle(), Toast.LENGTH_SHORT).show();
            }
        }
    };
    private MediaBrowser.ConnectionCallback mediaBrowserConnectionCallback = new MediaBrowser.ConnectionCallback() {
        @Override
        public void onConnected() {
            mediaBrowser.subscribe(mParentItem.getMediaId(), new MediaBrowser.SubscriptionCallback() {
                @Override
                public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> children) {
                    adapter.clear();
                    adapter.notifyDataSetInvalidated();
                    for (MediaItem item : children) {
                        adapter.add(item);
                        Log.i("abc", item.getDescription().getTitle().toString());
                    }
                    adapter.notifyDataSetChanged();
                }
            });
        }

        @Override
        public void onConnectionFailed() {
            Log.i("abc", "onConnectionFailed");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("xxx", "onCreate");
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(android.R.id.list);
        adapter = new MediaItemAdapter(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClickListener);
        if (savedInstanceState != null) {
            mParentItem = savedInstanceState.getParcelable(PARENT_ITEM);
        } else if (getIntent() != null) {
            mParentItem = getIntent().getParcelableExtra(PARENT_ITEM);
        }
        if (mParentItem == null) {
            mParentItem = DEFAULT_PARENT_ITEM;
        }
        mediaBrowser = new MediaBrowser(this, new ComponentName(this, MyMediaBrowserService.class), mediaBrowserConnectionCallback, null);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(PARENT_ITEM, mParentItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void initApp() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaBrowser.connect();
    }

    @Override
    protected void onStop() {
        mediaBrowser.disconnect();
        super.onStop();
    }

//    int count = 0;
//
//    @Override
//    public void onBackPressed() {
//        Log.i("abc", "onBackPressed");
//        count--;
//        if (count == -1)
//            super.onBackPressed();
//        else return;
//    }

    private class MediaItemAdapter extends ArrayAdapter<MediaItem> {
        public MediaItemAdapter(@NonNull Context context, int resource) {
            super(context, resource);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            }
            ((TextView) convertView.findViewById(android.R.id.text1)).setText(adapter.getItem(position).getDescription().getTitle());
            return convertView;
        }
    }

}
