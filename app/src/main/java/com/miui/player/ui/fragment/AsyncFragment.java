package com.miui.player.ui.fragment;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.OnlineMusicProxy.CacheListener;
import com.miui.player.ui.base.MusicBaseFragment;
import com.xiaomi.music.online.model.MetaList;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import miui.cache.RequestManager;
import miui.cache.RequestManager.Request;

public abstract class AsyncFragment<E extends Serializable, D extends MetaList<E>> extends MusicBaseFragment implements OnItemClickListener, Request<String, D, String>, CacheListener<D> {
    public static final int MSG_CACHE_LOADED = 1;
    static final String TAG = AsyncFragment.class.getName();
    protected DataAdapter<E, D> mAdapter;
    private final Handler mHandler = new C04961();
    protected AbsListView mList;
    protected AsyncLoadListener<D> mListener;
    protected int mLoadingCount;
    private int mLoadingPage = 1;
    private int mTotlePage = 1;

    class C04961 extends Handler {
        C04961() {
        }

        public void handleMessage(Message msg) {
            if (1 == msg.what && AsyncFragment.this.getActivity() != null && !AsyncFragment.this.getActivity().isFinishing()) {
                AsyncFragment.this.onCompleted((MetaList) msg.obj, false);
            }
        }
    }

    public static abstract class DataAdapter<T, D extends MetaList<T>> extends BaseAdapter {
        protected D mData;

        public boolean updateData(D data) {
            if (this.mData == data || data == null) {
                return false;
            }
            this.mData = data;
            notifyUpdate();
            return true;
        }

        public void notifyUpdate() {
            onDataChanged();
            notifyDataSetChanged();
        }

        public final boolean hasContent() {
            return this.mData != null && this.mData.isValid();
        }

        public int getCount() {
            return this.mData != null ? this.mData.size() : 0;
        }

        public T getItem(int position) {
            return this.mData.get(position);
        }

        public long getItemId(int position) {
            return 0;
        }

        protected void onDataChanged() {
        }

        public D getData() {
            return this.mData;
        }
    }

    static class OnlineRequest<K, V, R> implements Request<K, V, R> {
        private final K mKey;
        private final boolean mNeedCache;
        private final boolean mRemovable;
        private final R mRemoveKey;
        private WeakReference<Request<K, V, R>> mWorkRef;

        public OnlineRequest(Request<K, V, R> r) {
            this.mWorkRef = new WeakReference(r);
            this.mKey = r.getKey();
            this.mRemoveKey = r.getRemoveKey();
            this.mRemovable = r.isRemovable();
            this.mNeedCache = r.needCache();
        }

        public V computAsync() {
            Request<K, V, R> worker = (Request) this.mWorkRef.get();
            return worker != null ? worker.computAsync() : null;
        }

        public K getKey() {
            return this.mKey;
        }

        public R getRemoveKey() {
            return this.mRemoveKey;
        }

        public boolean isRemovable() {
            return this.mRemovable;
        }

        public boolean needCache() {
            return this.mNeedCache;
        }

        public void onCompleted(V value, boolean finalValue) {
            Request<K, V, R> worker = (Request) this.mWorkRef.get();
            if (worker != null) {
                worker.onCompleted(value, finalValue);
            }
        }

        public void onRemoved() {
            Request<K, V, R> worker = (Request) this.mWorkRef.get();
            if (worker != null) {
                worker.onRemoved();
            }
        }
    }

    protected abstract D doComput(int i);

    protected abstract RequestManager<String, D, String> getRequestManager();

    protected abstract void initializeAdapter(View view);

    public void onViewCreated(View view, Bundle icicle) {
        super.onViewCreated(view, icicle);
        this.mList = getListView();
        initializeAdapter(view);
        this.mList.setOnItemClickListener(this);
        this.mList.setAdapter(this.mAdapter);
        launch();
    }

    protected void launch() {
        RequestManager<String, D, String> mgr = getRequestManager();
        if (!mgr.isResumed()) {
            mgr.setup(true);
        }
        mgr.request(new OnlineRequest(this), false);
    }

    public void setAsyncLoadListener(AsyncLoadListener<D> l) {
        this.mListener = l;
    }

    public void onDestroyView() {
        this.mList.setAdapter(null);
        this.mAdapter = null;
        super.onDestroyView();
    }

    public String getRemoveKey() {
        return MetaManager.UNKNOWN_STRING;
    }

    public boolean isRemovable() {
        return false;
    }

    public boolean needCache() {
        return false;
    }

    public void onRemoved() {
    }

    public D computAsync() {
        return doComput(3);
    }

    protected Application getApplication() {
        Activity a = getActivity();
        return a != null ? a.getApplication() : null;
    }

    public void onCompleted(D data, boolean isFinal) {
        if (data != null) {
            this.mHandler.removeMessages(1);
        }
        if (!(this.mAdapter == null || data == null)) {
            if (this.mLoadingPage == 1) {
                this.mAdapter.updateData(data);
            } else if (this.mAdapter.getData() != null) {
                this.mAdapter.getData().update(data.getContent(), this.mLoadingPage);
                this.mAdapter.notifyUpdate();
            }
        }
        if (this.mListener != null) {
            this.mListener.onLoadFinished(data);
        }
        if (data != null && isFinal && needLoadingByPage() && this.mLoadingPage < this.mTotlePage) {
            this.mLoadingPage++;
            launch();
        }
    }

    public void onCacheLoaded(D data) {
        if (data != null) {
            this.mHandler.obtainMessage(1, data).sendToTarget();
        }
    }

    public void setLoadingCount(int count) {
        this.mLoadingCount = count;
        this.mTotlePage = ((this.mLoadingCount + 50) - 1) / 50;
    }

    protected boolean needLoadingByPage() {
        return false;
    }

    protected final int getLoadingPage() {
        return this.mLoadingPage;
    }

    protected final boolean isLastPage() {
        return this.mLoadingPage == this.mTotlePage;
    }
}
