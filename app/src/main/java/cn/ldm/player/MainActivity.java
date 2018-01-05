package cn.ldm.player;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cn.ldm.player.activities.PermissionActivity;
import cn.ldm.player.services.MyMediaBrowserService;

public class MainActivity extends PermissionActivity {

    private ListView listView;
    private ArrayAdapter<MediaItem> adapter;
    private MediaBrowser mediaBrowser;
    private MediaItem mParentItem = new MediaBrowser.MediaItem(new MediaDescription.Builder()
            .setMediaId(MyMediaBrowserService.MEDIA_ID_MUSIC_BY_ALBUM)
            .build(),
            MediaBrowser.MediaItem.FLAG_BROWSABLE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(android.R.id.list);
        adapter = new ArrayAdapter<MediaItem>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                intent.putExtra("PARENT_ITEM", adapter.getItem(position));
                startActivity(intent);
            }
        });
        if (getIntent() != null && getIntent().getAction() != Intent.ACTION_MAIN) {
            mParentItem = getIntent().getExtras().getParcelable("PARENT_ITEM");
        }
        mediaBrowser = new MediaBrowser(
                this,
                new ComponentName(this, MyMediaBrowserService.class),
                new MediaBrowser.ConnectionCallback() {
                    @Override
                    public void onConnected() {
                        Log.i("abc", "已连接到媒体浏览服务");
                        mediaBrowser.subscribe(mParentItem.getMediaId(), new MediaBrowser.SubscriptionCallback() {
                            @Override
                            public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> children) {
                                Log.i("abc", "parentId = " + parentId);
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
                },
                null
        );
    }

    @Override
    public void initApp() {
        Log.i("abc", "initApp");
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
}
