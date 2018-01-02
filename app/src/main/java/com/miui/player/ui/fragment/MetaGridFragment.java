package com.miui.player.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.miui.player.C0329R;
import com.miui.player.network.StatHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.model.MetaAdapter.SongGroupMetaAdapter;
import com.miui.player.util.Actions;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.model.MetaList;
import com.xiaomi.music.online.model.SongGroup;
import com.xiaomi.music.online.model.SongGroupList;
import com.xiaomi.music.statistics.impl.StatUrls;
import miui.cache.RequestManager;

public abstract class MetaGridFragment extends ListFragmentWithLoading<SongGroup, SongGroupList> {

    public static class BillGridFragment extends MetaGridFragment {
        static final RequestManager<String, SongGroupList, String> sRequestManager = RequestManager.create(1, null);

        public /* bridge */ /* synthetic */ MetaList doComput(int x0) {
            return super.doComput(x0);
        }

        public /* bridge */ /* synthetic */ Object getKey() {
            return super.getKey();
        }

        protected int getLoadFailedId() {
            return C0329R.string.load_bill_failed;
        }

        protected int getLoadInProcessId() {
            return C0329R.string.load_bill_in_process;
        }

        protected RequestManager<String, SongGroupList, String> getRequestManager() {
            return sRequestManager;
        }

        protected Result<SongGroupList> getResult() {
            return MusicEngine.get(getActivity()).getOnlineEngine().getBillList(MusicApplication.getApplication());
        }

        protected int getPlaylistType() {
            return 102;
        }
    }

    public static class ChannelGridFragment extends MetaGridFragment {
        static final RequestManager<String, SongGroupList, String> sRequestManager = RequestManager.create(1, null);

        public /* bridge */ /* synthetic */ MetaList doComput(int x0) {
            return super.doComput(x0);
        }

        public /* bridge */ /* synthetic */ Object getKey() {
            return super.getKey();
        }

        protected int getLoadFailedId() {
            return C0329R.string.load_channel_failed;
        }

        protected int getLoadInProcessId() {
            return C0329R.string.load_channel_in_process;
        }

        protected RequestManager<String, SongGroupList, String> getRequestManager() {
            return sRequestManager;
        }

        protected Result<SongGroupList> getResult() {
            return MusicEngine.get(getActivity()).getOnlineEngine().getChannelList(MusicApplication.getApplication());
        }

        protected int getPlaylistType() {
            return 101;
        }
    }

    public static class RecommendGridFragment extends MetaGridFragment {
        static final RequestManager<String, SongGroupList, String> sRequestManager = RequestManager.create(1, null);

        public /* bridge */ /* synthetic */ MetaList doComput(int x0) {
            return super.doComput(x0);
        }

        public /* bridge */ /* synthetic */ Object getKey() {
            return super.getKey();
        }

        protected int getLoadFailedId() {
            return C0329R.string.load_recommend_failed;
        }

        protected int getLoadInProcessId() {
            return C0329R.string.load_recommend_in_process;
        }

        protected RequestManager<String, SongGroupList, String> getRequestManager() {
            return sRequestManager;
        }

        protected Result<SongGroupList> getResult() {
            return MusicEngine.get(getActivity()).getOnlineEngine().getRecommendList(MusicApplication.getApplication());
        }

        protected int getPlaylistType() {
            return 103;
        }
    }

    protected abstract int getPlaylistType();

    protected abstract Result<SongGroupList> getResult();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        return inflater.inflate(C0329R.layout.meta_grid_fragment, container, false);
    }

    protected void initializeAdapter(View container) {
        this.mAdapter = new SongGroupMetaAdapter(getActivity());
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (this.mAdapter != null) {
            int listType = getPlaylistType();
            SongGroup songGroup = (SongGroup) this.mAdapter.getItem(position);
            Intent intent = new Intent(Actions.ACTION_BROWSER);
            intent.setDataAndType(Uri.EMPTY, Actions.MIME_TYPE_ONLINE_PREVIEW_SONG_GROUP);
            intent.putExtra(Actions.KEY_AUDIO_LIST_SONG_GROUP, songGroup);
            intent.putExtra(Actions.KEY_PLAYLIST_TYPE, listType);
            startActivity(intent);
            String type = null;
            switch (listType) {
                case 101:
                    type = StatUrls.CLICK_TYPE_FM;
                    break;
                case 102:
                    type = "list";
                    break;
                case 103:
                    type = "recommend";
                    break;
            }
            StatHelper.uploadClickList(type, songGroup.mId, songGroup.mName);
        }
    }

    public String getKey() {
        return getClass().getName();
    }

    public SongGroupList computAsync() {
        return doComput(3);
    }

    public SongGroupList doComput(int opt) {
        Result<SongGroupList> result = getResult();
        if (result.mErrorCode == 1) {
            return result.mData;
        }
        return null;
    }

    public boolean needCache() {
        return true;
    }
}
