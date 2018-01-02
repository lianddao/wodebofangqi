package com.miui.player.util;

import com.baidu.music.helper.PreferencesHelper;
import com.miui.player.meta.MetaManager;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public class CollectionHelper {
    public static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public interface Predication<T> {
        boolean predicate(T t);
    }

    private static class CollectionCaster<S, D> extends AbstractCollection<D> {
        private final Collection<S> mSrcCollection;

        static class IteratorCaster<S, D> implements Iterator<D> {
            private final Iterator<S> mIterator;

            IteratorCaster(Iterator<S> it) {
                this.mIterator = it;
            }

            public boolean hasNext() {
                return this.mIterator.hasNext();
            }

            public D next() {
                return this.mIterator.next();
            }

            public void remove() {
                this.mIterator.remove();
            }
        }

        public CollectionCaster(Collection<S> src) {
            this.mSrcCollection = src;
        }

        public Iterator<D> iterator() {
            return new IteratorCaster(this.mSrcCollection.iterator());
        }

        public int size() {
            return this.mSrcCollection.size();
        }
    }

    static class LongCollection extends AbstractCollection<Long> {
        private final int mLen;
        private final long[] mSrc;

        static class LongIterator implements Iterator<Long> {
            private int mCounter = 0;
            private final int mLen;
            private final long[] mSrc;

            public LongIterator(long[] src, int len) {
                this.mSrc = src;
                this.mLen = len;
            }

            public boolean hasNext() {
                return this.mCounter < this.mLen;
            }

            public Long next() {
                long[] jArr = this.mSrc;
                int i = this.mCounter;
                this.mCounter = i + 1;
                return Long.valueOf(jArr[i]);
            }

            public void remove() {
                throw new UnsupportedOperationException("unsupported remove from ArrayIterator");
            }
        }

        LongCollection(long[] src, int len) {
            this.mSrc = src;
            if (len <= 0) {
                this.mLen = src.length;
                return;
            }
            if (len >= src.length) {
                len = src.length;
            }
            this.mLen = len;
        }

        public Iterator<Long> iterator() {
            return new LongIterator(this.mSrc, this.mLen);
        }

        public int size() {
            return this.mLen;
        }
    }

    public static <D, S> Collection<D> castTo(Collection<S> src) {
        if (src == null) {
            return null;
        }
        return new CollectionCaster(src);
    }

    public static Collection<Long> asLongCollection(long[] src, int len) {
        return new LongCollection(src, len);
    }

    public static <T> int difference(Collection<T> from, Collection<T> to, Predication<T> pred) {
        if (from == null || to == null) {
            return 0;
        }
        int oldSize = to.size();
        if (pred != null) {
            for (T v : from) {
                if (!(pred == null || !pred.predicate(v) || to.contains(v))) {
                    to.add(v);
                }
            }
        } else {
            for (T v2 : from) {
                if (!to.contains(v2)) {
                    to.add(v2);
                }
            }
        }
        return to.size() - oldSize;
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static String compressToString(long[] values, int len) {
        return compressToString(asLongCollection(values, len));
    }

    public static String compressToString(Collection<Long> values) {
        if (values == null || values.isEmpty()) {
            return MetaManager.UNKNOWN_STRING;
        }
        StringBuilder sb = new StringBuilder();
        for (Long longValue : values) {
            long n = longValue.longValue();
            if (n == 0) {
                sb.append("0;");
            } else {
                while (n != 0) {
                    int digit = (int) (15 & n);
                    n >>= 4;
                    sb.append(HEX_DIGITS[digit]);
                }
                sb.append(PreferencesHelper.SPLIT_CHAR);
            }
        }
        return sb.toString();
    }

    public static void decodeFromString(Collection<Long> values, String q, int maxLen) {
        values.clear();
        if (q != null) {
            int qlen = q.length();
            if (qlen > 1) {
                long n = 0;
                int shift = 0;
                for (int i = 0; i < qlen; i++) {
                    char c = q.charAt(i);
                    if (c != ';') {
                        if (c >= '0' && c <= '9') {
                            n += (long) ((c - 48) << shift);
                        } else if (c < 'a' || c > 'f') {
                            values.clear();
                            return;
                        } else {
                            n += (long) (((c + 10) - 97) << shift);
                        }
                        shift += 4;
                    } else if (maxLen <= 0 || n < ((long) maxLen)) {
                        values.add(Long.valueOf(n));
                        n = 0;
                        shift = 0;
                    } else {
                        values.clear();
                        return;
                    }
                }
            }
        }
    }

    public static String compressToJson(Collection<String> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        return new JSONArray(values).toString();
    }

    public static void decodeFromJson(Collection<String> values, String q) {
        values.clear();
        if (q != null) {
            try {
                JSONArray array = new JSONArray(q);
                int size = array.length();
                for (int i = 0; i < size; i++) {
                    values.add(array.getString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
