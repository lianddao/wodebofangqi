
package cn.ldm.player.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;


/**
 * 一个经过包装的 {@link AsyncTaskLoader}
 * @param <D>
 */
public abstract class WrappedAsyncTaskLoader<D> extends AsyncTaskLoader<D> {

    private D mData;

    public WrappedAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public void deliverResult(D data) {
        if (!isReset()) {
            this.mData = data;
            super.deliverResult(data);
        } else {
            // 加载程序停止时进入异步查询
        }
    }

    @Override
    protected void onStartLoading() {
        if (this.mData != null) {
            deliverResult(this.mData);
        } else if (takeContentChanged() || this.mData == null) {
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading() {
        // 如果可能，尝试取消当前的加载任务。
        cancelLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
        // 确保装载器已停止
        onStopLoading();
        this.mData = null;
    }
}
