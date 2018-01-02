package com.miui.player.util;

import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.StreamHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StorageCache {
    public static final long CACHE_LIFE = 604800000;
    private static final String TAG = StorageCache.class.getName();
    private static final String[] TYPE_LIST = new String[]{null, TYPE_ONLINE_LIST};
    public static final String TYPE_ONLINE_LIST = "online_list";
    private static final InputStreamWorker sInputStreamWorker = new InputStreamWorker();
    private static final ReadWriteLock sReadWriteLock = new ReentrantReadWriteLock();
    private static final StringWorker sStringWorker = new StringWorker();

    public interface IPersist<T> {
        boolean persist(T t, OutputStream outputStream);
    }

    public interface IRestore<T> {
        T restore(InputStream inputStream);
    }

    public interface Worker<T> extends IPersist<T>, IRestore<T> {
    }

    public static class InputStreamWorker implements Worker<InputStream> {
        public boolean persist(InputStream data, OutputStream os) {
            return FileOperations.copyFile(data, os);
        }

        public InputStream restore(InputStream is) {
            return is;
        }
    }

    public static class StringWorker implements Worker<String> {
        public boolean persist(String data, OutputStream os) {
            try {
                StreamHelper.wirteStringToStream(os, data);
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public String restore(InputStream is) {
            try {
                return StreamHelper.toString(is);
            } catch (IOException e) {
                return null;
            }
        }
    }

    public static void trim() {
        for (String t : TYPE_LIST) {
            File root = getDir(t, false);
            if (root != null) {
                long current = System.currentTimeMillis();
                trim(root, current - CACHE_LIFE, current);
            }
        }
    }

    private static void trim(File root, long min, long max) {
        File[] files = root.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f != null) {
                    if (f.isDirectory()) {
                        trim(f, min, max);
                    } else {
                        long lastModified = f.lastModified();
                        if (lastModified < min || lastModified > max) {
                            f.delete();
                        }
                    }
                }
            }
        }
    }

    public static File peekFile(String key, String type) {
        File f = getFile(key, type, false);
        return (f == null || !f.exists()) ? null : f;
    }

    private static File getDir(String type, boolean autoCreate) {
        File root;
        if (TYPE_ONLINE_LIST.equals(type)) {
            root = StorageUtils.getInternelTemp();
        } else {
            root = StorageUtils.getExternalTemp();
        }
        File dir = type == null ? root : new File(root, type);
        if (!autoCreate || dir.exists() || dir.mkdirs()) {
            return dir;
        }
        MusicLog.m404w(TAG, "make temp dir filed, type=" + type);
        return null;
    }

    private static File getFile(String key, String type, boolean createDir) {
        File dir = getDir(type, createDir);
        if (dir == null) {
            return null;
        }
        File result = new File(dir, key);
        if (!result.exists()) {
            return result;
        }
        result.setLastModified(System.currentTimeMillis());
        return result;
    }

    public static <T> File save(String key, String type, T data, IPersist<T> worker) {
        Throwable th;
        if (key == null || data == null) {
            return null;
        }
        File file = getFile(key, type, true);
        if (file == null) {
            return null;
        }
        BufferedOutputStream bos = null;
        Lock lock = sReadWriteLock.writeLock();
        lock.lock();
        try {
            BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                if (worker.persist(data, bos2)) {
                    StreamHelper.closeSafe(bos2);
                    lock.unlock();
                    return file;
                }
                file.delete();
                StreamHelper.closeSafe(bos2);
                lock.unlock();
                bos = bos2;
                return null;
            } catch (FileNotFoundException e) {
                bos = bos2;
                StreamHelper.closeSafe(bos);
                lock.unlock();
                return null;
            } catch (Throwable th2) {
                th = th2;
                bos = bos2;
                StreamHelper.closeSafe(bos);
                lock.unlock();
                throw th;
            }
        } catch (FileNotFoundException e2) {
            StreamHelper.closeSafe(bos);
            lock.unlock();
            return null;
        } catch (Throwable th3) {
            th = th3;
            StreamHelper.closeSafe(bos);
            lock.unlock();
            throw th;
        }
    }

    public static <T> T read(String key, String type, IRestore<T> worker) {
        Throwable th;
        T t = null;
        if (key != null) {
            File file = getFile(key, type, false);
            if (file != null && file.exists()) {
                BufferedInputStream bis = null;
                Lock lock = sReadWriteLock.readLock();
                lock.lock();
                try {
                    BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        t = worker.restore(bis2);
                        StreamHelper.closeSafe(bis2);
                        lock.unlock();
                    } catch (FileNotFoundException e) {
                        bis = bis2;
                        StreamHelper.closeSafe(bis);
                        lock.unlock();
                        return t;
                    } catch (Throwable th2) {
                        th = th2;
                        bis = bis2;
                        StreamHelper.closeSafe(bis);
                        lock.unlock();
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    StreamHelper.closeSafe(bis);
                    lock.unlock();
                    return t;
                } catch (Throwable th3) {
                    th = th3;
                    StreamHelper.closeSafe(bis);
                    lock.unlock();
                    throw th;
                }
            }
        }
        return t;
    }

    public static File saveString(String key, String type, String data) {
        return save(key, type, data, sStringWorker);
    }

    public static String readString(String key, String type) {
        return (String) read(key, type, sStringWorker);
    }

    public static File saveInputStream(String key, String type, InputStream data) {
        return save(key, type, data, sInputStreamWorker);
    }

    public static InputStream readInputStream(String key, String type) {
        return (InputStream) read(key, type, sInputStreamWorker);
    }
}
