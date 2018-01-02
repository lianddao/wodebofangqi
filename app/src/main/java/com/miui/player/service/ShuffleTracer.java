package com.miui.player.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.miui.player.meta.MetaManager;
import com.miui.player.util.CollectionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ShuffleTracer {
    private static final String PREF_SHUFFLE_IDX = "shuffle_index";
    private static final String PREF_SHUFFLE_VEC = "shuffle_vector";
    private final OnTraceableShufferExpand mListener;
    private final Random mRandom = new Random();
    public ArrayList<Integer> mShuffleRec = null;
    private int mTracer = 0;

    public interface OnTraceableShufferExpand {
        void onExpand();
    }

    public ShuffleTracer(OnTraceableShufferExpand l) {
        this.mListener = l;
    }

    public synchronized int getTracer() {
        return this.mTracer;
    }

    public synchronized int peekNext(int interval, int currentPos) {
        int i;
        if (interval <= 0) {
            i = -1;
        } else {
            expand(interval, currentPos);
            int tracer = this.mTracer + 1;
            if (tracer >= this.mShuffleRec.size()) {
                tracer = 0;
            }
            i = ((Integer) this.mShuffleRec.get(tracer)).intValue();
        }
        return i;
    }

    public synchronized int randNext(int interval, int currentPos) {
        int i;
        if (interval <= 0) {
            i = -1;
        } else {
            expand(interval, currentPos);
            this.mTracer++;
            if (this.mTracer < this.mShuffleRec.size()) {
                i = ((Integer) this.mShuffleRec.get(this.mTracer)).intValue();
            } else {
                this.mTracer = 0;
                i = ((Integer) this.mShuffleRec.get(this.mTracer)).intValue();
            }
        }
        return i;
    }

    public synchronized void clear() {
        this.mTracer = 0;
        this.mShuffleRec = null;
    }

    public synchronized int back(int interval, int currentPos) {
        int i;
        if (interval <= 0) {
            i = -1;
        } else {
            expand(interval, currentPos);
            this.mTracer--;
            if (this.mTracer >= 0) {
                i = ((Integer) this.mShuffleRec.get(this.mTracer)).intValue();
            } else {
                this.mTracer = this.mShuffleRec.size() - 1;
                i = ((Integer) this.mShuffleRec.get(this.mTracer)).intValue();
            }
        }
        return i;
    }

    public synchronized void load(SharedPreferences sp, int maxLen) {
        this.mShuffleRec = new ArrayList();
        read(this.mShuffleRec, sp.getString(PREF_SHUFFLE_VEC, MetaManager.UNKNOWN_STRING), maxLen);
        this.mTracer = 0;
        int size = this.mShuffleRec.size();
        if (size > 0) {
            int backHistory = sp.getInt(PREF_SHUFFLE_IDX, 0);
            if (backHistory < size) {
                this.mTracer = backHistory;
            }
        }
    }

    public synchronized void save(Editor ed, int interval, int first, boolean full) {
        if (interval > 0) {
            expand(interval, first);
            ed.putInt(PREF_SHUFFLE_IDX, this.mTracer);
            if (full) {
                ed.putString(PREF_SHUFFLE_VEC, serialize(this.mShuffleRec));
            }
        }
    }

    private void expand(int interval, int first) {
        boolean isExpand = false;
        int i;
        int j;
        int t;
        ArrayList<Integer> v;
        if (this.mShuffleRec == null || this.mShuffleRec.isEmpty()) {
            this.mRandom.setSeed(SystemClock.currentThreadTimeMillis());
            int[] rec = new int[interval];
            for (i = 0; i < interval; i++) {
                rec[i] = i;
            }
            for (i = 0; i < interval; i++) {
                j = this.mRandom.nextInt(interval - i) + i;
                t = rec[i];
                rec[i] = rec[j];
                rec[j] = t;
            }
            if (this.mShuffleRec == null) {
                v = new ArrayList(interval);
            } else {
                v = this.mShuffleRec;
            }
            if (first >= 0) {
                v.add(Integer.valueOf(first));
            }
            int idx = 0;
            while (idx < interval && rec[idx] != first) {
                v.add(Integer.valueOf(rec[idx]));
                idx++;
            }
            for (idx++; idx < interval; idx++) {
                v.add(Integer.valueOf(rec[idx]));
            }
            this.mShuffleRec = v;
            this.mTracer = 0;
            isExpand = true;
        } else if (this.mShuffleRec.size() > interval) {
            Iterator<Integer> it = this.mShuffleRec.iterator();
            while (it.hasNext()) {
                if (((Integer) it.next()).intValue() >= interval) {
                    it.remove();
                }
            }
            if (this.mTracer >= interval || this.mTracer < 0) {
                this.mTracer = 0;
            }
            isExpand = true;
        } else if (interval == this.mShuffleRec.size() + 1) {
            int value = interval - 1;
            int next = this.mTracer + 1;
            if (next == this.mShuffleRec.size()) {
                this.mShuffleRec.add(Integer.valueOf(value));
            } else {
                this.mShuffleRec.add(this.mRandom.nextInt(interval - next) + next, Integer.valueOf(value));
            }
            isExpand = true;
        } else if (interval > this.mShuffleRec.size() + 1) {
            v = this.mShuffleRec;
            v.ensureCapacity(interval);
            for (i = v.size(); i < interval; i++) {
                v.add(Integer.valueOf(i));
            }
            for (i = this.mTracer + 1; i < interval; i++) {
                j = this.mRandom.nextInt(interval - i) + i;
                t = ((Integer) v.get(j)).intValue();
                v.set(j, v.get(i));
                v.set(i, Integer.valueOf(t));
            }
            isExpand = true;
        }
        if (isExpand && this.mListener != null) {
            this.mListener.onExpand();
        }
    }

    private static String serialize(ArrayList<Integer> values) {
        ArrayList<Long> temp = new ArrayList(values.size());
        Iterator i$ = values.iterator();
        while (i$.hasNext()) {
            temp.add(Long.valueOf(((Integer) i$.next()).longValue()));
        }
        return CollectionHelper.compressToString(temp);
    }

    private static void read(ArrayList<Integer> v, String q, int maxLen) {
        ArrayList<Long> temp = new ArrayList();
        CollectionHelper.decodeFromString(temp, q, maxLen);
        v.ensureCapacity(temp.size());
        Iterator i$ = temp.iterator();
        while (i$.hasNext()) {
            v.add(Integer.valueOf(((Long) i$.next()).intValue()));
        }
    }
}
