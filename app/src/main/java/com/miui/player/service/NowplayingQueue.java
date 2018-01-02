package com.miui.player.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NowplayingQueue {
    private static final String[] EMPTY = new String[0];
    public static final String INVALID_ID = null;
    private static final String PREF_QUEUE_POS_PREFIX = "queue_pos";
    private static final String PREF_QUEUE_PREFIX = "queue";
    private static final String PREF_REPEAT_MODE = "repeatmode";
    private static final String PREF_SHUFFLE_MODE = "shufflemode";
    private String[] mAudioIds = EMPTY;
    private int mPosition = 0;
    private final String mQueuePosPref;
    private final String mQueuePref;
    private final Random mRandom = new Random(System.currentTimeMillis());
    private int mRepeatMode = 0;
    private int mShuffleMode = 0;
    private final ShuffleTracer mTracer = new ShuffleTracer(null);

    public NowplayingQueue(int id) {
        this.mQueuePref = PREF_QUEUE_PREFIX + id;
        this.mQueuePosPref = PREF_QUEUE_POS_PREFIX + id;
    }

    public void read(SharedPreferences sp) {
        setRepeatMode(sp.getInt(PREF_REPEAT_MODE, this.mRepeatMode));
        setShuffleMode(sp.getInt(PREF_SHUFFLE_MODE, this.mShuffleMode));
        int pos = sp.getInt(this.mQueuePosPref, 0);
        String raw = sp.getString(this.mQueuePref, null);
        ArrayList<String> temp = new ArrayList();
        CollectionHelper.decodeFromJson(temp, raw);
        String[] ids = new String[temp.size()];
        temp.toArray(ids);
        setAudioIds(ids, pos, 4);
    }

    public void save(Editor editor, boolean full) {
        editor.putInt(PREF_REPEAT_MODE, this.mRepeatMode);
        editor.putInt(PREF_SHUFFLE_MODE, this.mShuffleMode);
        editor.putInt(this.mQueuePosPref, this.mPosition);
        if (full) {
            editor.putString(this.mQueuePref, CollectionHelper.compressToJson(Arrays.asList(this.mAudioIds)));
        }
    }

    public void clear() {
        this.mAudioIds = EMPTY;
        this.mPosition = 0;
    }

    public boolean setPosition(int pos) {
        boolean changed = false;
        int old = this.mPosition;
        if (pos < 0) {
            this.mPosition = this.mRandom.nextInt(this.mAudioIds.length);
        } else if (pos < this.mAudioIds.length) {
            this.mPosition = pos;
        } else if (this.mPosition >= this.mAudioIds.length) {
            this.mPosition = 0;
        }
        if (this.mPosition != old) {
            changed = true;
        }
        if (changed) {
            this.mTracer.clear();
        }
        return changed;
    }

    public boolean setAudioIds(String[] ids, int pos, int action) {
        if ((ids == null || ids.length == 0) && this.mAudioIds.length == 0) {
            return false;
        }
        if (ids == null || ids.length == 0) {
            this.mAudioIds = EMPTY;
            this.mPosition = 0;
            return true;
        }
        if (this.mAudioIds.length == 0 && action != 4) {
            action = 4;
        }
        boolean changed = true;
        String[] newQueue;
        switch (action) {
            case 1:
            case 2:
                newQueue = new String[(ids.length + this.mAudioIds.length)];
                System.arraycopy(this.mAudioIds, 0, newQueue, 0, this.mPosition + 1);
                System.arraycopy(ids, 0, newQueue, this.mPosition + 1, ids.length);
                int remain = (this.mAudioIds.length - this.mPosition) - 1;
                System.arraycopy(this.mAudioIds, this.mPosition + 1, newQueue, newQueue.length - remain, remain);
                this.mAudioIds = newQueue;
                break;
            case 3:
                newQueue = new String[(ids.length + this.mAudioIds.length)];
                System.arraycopy(this.mAudioIds, 0, newQueue, 0, this.mAudioIds.length);
                System.arraycopy(ids, 0, newQueue, this.mAudioIds.length, ids.length);
                this.mAudioIds = newQueue;
                break;
            case 4:
                this.mAudioIds = new String[ids.length];
                System.arraycopy(ids, 0, this.mAudioIds, 0, ids.length);
                this.mTracer.clear();
                break;
            default:
                changed = false;
                break;
        }
        setPosition(pos);
        return changed;
    }

    public String next(boolean force) {
        int[] newPosition = new int[1];
        String id = nextInternel(newPosition, force, true);
        if (id != INVALID_ID) {
            this.mPosition = newPosition[0];
        }
        return id;
    }

    public String peekNext(boolean force) {
        return nextInternel(null, force, false);
    }

    public String prev() {
        int[] newPosition = new int[1];
        String id = prevInternel(newPosition);
        if (id != INVALID_ID) {
            this.mPosition = newPosition[0];
        }
        return id;
    }

    public String peek() {
        if (this.mAudioIds.length == 0) {
            return INVALID_ID;
        }
        return this.mAudioIds[this.mPosition];
    }

    public boolean setShuffleMode(int shuffleMode) {
        if (this.mShuffleMode == shuffleMode) {
            return false;
        }
        this.mShuffleMode = shuffleMode;
        this.mTracer.clear();
        return true;
    }

    public boolean setRepeatMode(int repeatMode) {
        if (this.mRepeatMode == repeatMode) {
            return false;
        }
        this.mRepeatMode = repeatMode;
        return true;
    }

    public int getShuffleMode() {
        return this.mShuffleMode;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public String[] getQueue() {
        String[] ret = new String[this.mAudioIds.length];
        System.arraycopy(this.mAudioIds, 0, ret, 0, ret.length);
        return ret;
    }

    public int position() {
        return this.mPosition;
    }

    public int size() {
        return this.mAudioIds.length;
    }

    public boolean move(int index1, int index2) {
        int len = this.mAudioIds.length;
        index1 = Utils.clamp(index1, 0, len - 1);
        index2 = Utils.clamp(index2, 0, len - 1);
        String tmp;
        if (index1 < index2) {
            tmp = this.mAudioIds[index1];
            System.arraycopy(this.mAudioIds, index1 + 1, this.mAudioIds, index1, index2 - index1);
            this.mAudioIds[index2] = tmp;
            if (this.mPosition == index1) {
                this.mPosition = index2;
                return true;
            } else if (this.mPosition < index1 || this.mPosition > index2) {
                return true;
            } else {
                this.mPosition--;
                return true;
            }
        } else if (index2 >= index1) {
            return false;
        } else {
            tmp = this.mAudioIds[index1];
            System.arraycopy(this.mAudioIds, index2, this.mAudioIds, index2 + 1, index1 - index2);
            this.mAudioIds[index2] = tmp;
            if (this.mPosition == index1) {
                this.mPosition = index2;
                return true;
            } else if (this.mPosition < index2 || this.mPosition > index1) {
                return true;
            } else {
                this.mPosition++;
                return true;
            }
        }
    }

    public int remove(String[] list) {
        return 0;
    }

    private String nextInternel(int[] newPosition, boolean force, boolean move) {
        if (this.mAudioIds.length == 0) {
            return INVALID_ID;
        }
        int len = this.mAudioIds.length;
        int pos = this.mPosition;
        if (!force && this.mRepeatMode == 1) {
            return this.mAudioIds[pos];
        }
        if (this.mShuffleMode != 1) {
            pos++;
            if (pos >= len) {
                if (this.mRepeatMode == 2) {
                    return INVALID_ID;
                }
                pos = 0;
            }
        } else if (move) {
            pos = this.mTracer.randNext(len, pos);
        } else {
            pos = this.mTracer.peekNext(len, pos);
        }
        if (newPosition != null) {
            newPosition[0] = pos;
        }
        return this.mAudioIds[pos];
    }

    private String prevInternel(int[] newPosition) {
        if (this.mAudioIds.length == 0) {
            return INVALID_ID;
        }
        int len = this.mAudioIds.length;
        int pos = this.mPosition;
        if (this.mShuffleMode == 1) {
            pos = this.mTracer.back(len, pos);
        } else {
            pos--;
            if (pos < 0) {
                pos = len - 1;
            }
        }
        if (newPosition != null) {
            newPosition[0] = pos;
        }
        return this.mAudioIds[pos];
    }
}
