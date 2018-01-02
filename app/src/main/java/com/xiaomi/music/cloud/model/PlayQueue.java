package com.xiaomi.music.cloud.model;

import com.google.android.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayQueue {
    public static final PlayQueue EMPTY = new PlayQueue(Collections.unmodifiableList(new ArrayList()));
    private final List<String> mQueue = Lists.newArrayList();

    public PlayQueue(List<String> queue) {
        if (queue != null) {
            this.mQueue.addAll(queue);
        }
    }

    public List<String> getQueue() {
        return Collections.unmodifiableList(this.mQueue);
    }

    public String toString() {
        if (this.mQueue.isEmpty()) {
            return String.format("PlayQueue[size=%d]", new Object[]{Integer.valueOf(this.mQueue.size())});
        }
        return String.format("PlayQueue[size=%d, first=%s, last=%s]", new Object[]{Integer.valueOf(this.mQueue.size()), this.mQueue.get(0), this.mQueue.get(this.mQueue.size() - 1)});
    }
}
