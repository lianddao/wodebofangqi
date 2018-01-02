package com.miui.player.plugin.base;

import android.util.Log;
import android.util.Pair;
import com.google.android.collect.Lists;
import com.miui.player.meta.MetaManager;
import com.xiaomi.music.util.StreamHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parsers {
    public static final String KEY_JSONOBJECT_ITER = "json_iter_key_tag";
    static final String TAG = Parsers.class.getName();

    static class ComposeParserForArray<T> implements Parser<List<T>, JSONArray> {
        private final Parser<T, JSONObject> mElementParser;

        public ComposeParserForArray(Parser<T, JSONObject> parser) {
            this.mElementParser = parser;
        }

        public List<T> parse(JSONArray src) {
            return Parsers.parserArray(src, this.mElementParser);
        }
    }

    static class ComposeParserForObject<T> implements Parser<List<T>, JSONObject> {
        private final ElementComparator<String> mComparator;
        private final Parser<T, JSONObject> mElementParser;

        public ComposeParserForObject(Parser<T, JSONObject> parser, ElementComparator<String> comparator) {
            this.mElementParser = parser;
            this.mComparator = comparator;
        }

        public List<T> parse(JSONObject src) {
            return Parsers.parserObject(src, this.mComparator, this.mElementParser);
        }
    }

    static class ConverterParser<D, F, T> implements Parser<D, F> {
        private final Parser<D, T> mActual;
        private final TypeConverter<F, T> mConverter;

        public ConverterParser(Parser<D, T> parser, TypeConverter<F, T> converter) {
            this.mActual = parser;
            this.mConverter = converter;
        }

        public D parse(F src) {
            if (this.mActual != null) {
                T t = this.mConverter.convert(src);
                if (t != null) {
                    return this.mActual.parse(t);
                }
            }
            return null;
        }
    }

    public interface TypeConverter<F, T> {
        T convert(F f);
    }

    static class ConverterProxy<F, M, T> implements TypeConverter<F, T> {
        private final TypeConverter<F, M> mFirst;
        private final TypeConverter<M, T> mSecond;

        public ConverterProxy(TypeConverter<F, M> first, TypeConverter<M, T> second) {
            this.mFirst = first;
            this.mSecond = second;
        }

        public T convert(F src) {
            M tmp = this.mFirst.convert(src);
            return tmp != null ? this.mSecond.convert(tmp) : null;
        }
    }

    public interface ElementComparator<T> {
        boolean isEqual(T t);
    }

    static class FilterJSONArrayFromJSONObject implements TypeConverter<JSONObject, JSONArray> {
        private final String mKey;

        public FilterJSONArrayFromJSONObject(String key) {
            this.mKey = key;
        }

        public JSONArray convert(JSONObject src) {
            JSONArray jSONArray = null;
            if (src != null) {
                try {
                    jSONArray = src.getJSONArray(this.mKey);
                } catch (JSONException e) {
                }
            }
            return jSONArray;
        }
    }

    static class FilterJSONObjectFromJSONArray implements TypeConverter<JSONArray, JSONObject> {
        private final ElementComparator<JSONObject> mComparator;

        public FilterJSONObjectFromJSONArray(ElementComparator<JSONObject> comparator) {
            this.mComparator = comparator;
        }

        public JSONObject convert(JSONArray src) {
            if (src == null) {
                return null;
            }
            int len = src.length();
            int i = 0;
            while (i < len) {
                try {
                    JSONObject obj = src.getJSONObject(i);
                    if (this.mComparator.isEqual(obj)) {
                        return obj;
                    }
                    i++;
                } catch (JSONException e) {
                }
            }
            return null;
        }
    }

    static class FilterJSONObjectFromJSONObject implements TypeConverter<JSONObject, JSONObject> {
        private final String mKey;

        public FilterJSONObjectFromJSONObject(String key) {
            this.mKey = key;
        }

        public JSONObject convert(JSONObject src) {
            if (src == null) {
                return null;
            }
            try {
                JSONObject v = src.getJSONObject(this.mKey);
                if (v != null) {
                    String key = src.optString(Parsers.KEY_JSONOBJECT_ITER, null);
                    if (key == null) {
                        return v;
                    }
                    v.put(Parsers.KEY_JSONOBJECT_ITER, key);
                    return v;
                }
            } catch (JSONException e) {
            }
            return null;
        }
    }

    static class IteratorForJSONArray implements Iterator<JSONObject> {
        private final JSONArray mArray;
        private int mIndex = 0;

        public IteratorForJSONArray(JSONArray array) {
            this.mArray = array;
        }

        public boolean hasNext() {
            return this.mIndex < this.mArray.length();
        }

        public JSONObject next() {
            try {
                JSONArray jSONArray = this.mArray;
                int i = this.mIndex;
                this.mIndex = i + 1;
                return jSONArray.getJSONObject(i);
            } catch (JSONException e) {
                Log.d(Parsers.TAG, MetaManager.UNKNOWN_STRING, e);
                return null;
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static class IteratorForJSONObject implements Iterator<JSONObject> {
        private final JSONObject mJSONObject;
        private final Iterator<String> mKeyIter;

        public IteratorForJSONObject(JSONObject json, ElementComparator<String> comparator) {
            this.mJSONObject = json;
            List<String> keys = Lists.newArrayList();
            Iterator<String> iter = json.keys();
            while (iter.hasNext()) {
                String k = (String) iter.next();
                if (comparator == null || comparator.isEqual(k)) {
                    keys.add(k);
                }
            }
            this.mKeyIter = keys.iterator();
        }

        public boolean hasNext() {
            return this.mKeyIter.hasNext();
        }

        public JSONObject next() {
            String key = (String) this.mKeyIter.next();
            if (key != null) {
                try {
                    JSONObject obj = this.mJSONObject.getJSONObject(key);
                    if (obj != null) {
                        obj.put(Parsers.KEY_JSONOBJECT_ITER, key);
                        return obj;
                    }
                } catch (JSONException e) {
                    Log.d(Parsers.TAG, MetaManager.UNKNOWN_STRING, e);
                }
            }
            return null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static class JSONObjectFromString implements TypeConverter<String, JSONObject> {
        JSONObjectFromString() {
        }

        public JSONObject convert(String src) {
            try {
                return new JSONObject(src);
            } catch (JSONException e) {
                return null;
            }
        }
    }

    static class PairParser<T1, T2> implements Parser<Pair<T1, T2>, JSONObject> {
        private final Parser<T1, JSONObject> mFirst;
        private final Parser<T2, JSONObject> mSecond;

        public PairParser(Parser<T1, JSONObject> first, Parser<T2, JSONObject> second) {
            this.mFirst = first;
            this.mSecond = second;
        }

        public Pair<T1, T2> parse(JSONObject src) {
            Object first = null;
            if (this.mFirst != null) {
                first = this.mFirst.parse(src);
            }
            T2 second = null;
            if (this.mSecond != null) {
                second = this.mSecond.parse(src);
            }
            return Pair.create(first, second);
        }
    }

    public static <T1, T2> Parser<Pair<T1, T2>, JSONObject> createPairParser(Parser<T1, JSONObject> first, Parser<T2, JSONObject> second) {
        return new PairParser(first, second);
    }

    public static <D, F, T> Parser<D, F> createConverterParserProxy(Parser<D, T> parser, TypeConverter<F, T> converter) {
        return new ConverterParser(parser, converter);
    }

    public static <T> Parser<T, JSONObject> createParserProxyForArray(String key, Parser<T, JSONArray> parser) {
        return createConverterParserProxy(parser, createArrayTypeConverter(key));
    }

    public static <T> Parser<T, JSONObject> createParserProxyForObject(String key, Parser<T, JSONObject> parser) {
        return createConverterParserProxy(parser, createObjectTypeConverter(key));
    }

    public static <T> Parser<T, String> createParserForString(Parser<T, JSONObject> parser) {
        return createConverterParserProxy(parser, new JSONObjectFromString());
    }

    public static <T> Parser<T, JSONArray> createParserProxyForElement(ElementComparator<JSONObject> comparator, Parser<T, JSONObject> parser) {
        return createConverterParserProxy(parser, createElementTypeConverter(comparator));
    }

    public static <T> Parser<List<T>, JSONObject> createComposeParserProxy(ElementComparator<String> comparator, Parser<T, JSONObject> parser) {
        return new ComposeParserForObject(parser, comparator);
    }

    public static <T> Parser<List<T>, JSONArray> createComposeParserProxy(Parser<T, JSONObject> parser) {
        return new ComposeParserForArray(parser);
    }

    public static <F, M, T> TypeConverter<F, T> createConvterProxy(TypeConverter<F, M> first, TypeConverter<M, T> second) {
        return new ConverterProxy(first, second);
    }

    public static TypeConverter<JSONObject, JSONArray> createArrayTypeConverter(String key) {
        return new FilterJSONArrayFromJSONObject(key);
    }

    public static TypeConverter<JSONObject, JSONObject> createObjectTypeConverter(String key) {
        return new FilterJSONObjectFromJSONObject(key);
    }

    public static TypeConverter<JSONArray, JSONObject> createElementTypeConverter(ElementComparator<JSONObject> comparator) {
        return new FilterJSONObjectFromJSONArray(comparator);
    }

    public static <T> Pair<String, T> parse(InputStream is, Parser<T, String> parser) {
        try {
            String src = StreamHelper.toString(is);
            if (src != null) {
                return Pair.create(src, parser.parse(src));
            }
        } catch (IOException e) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
        }
        return null;
    }

    public static <T, S> List<T> parserIterator(Iterator<S> iter, Parser<T, S> parser) {
        List<T> ret = Lists.newArrayList();
        while (iter.hasNext()) {
            S entry = iter.next();
            if (entry != null) {
                T ele = parser.parse(entry);
                if (ele != null) {
                    ret.add(ele);
                }
            }
        }
        return ret;
    }

    public static <T> List<T> parserArray(JSONArray jsonArr, Parser<T, JSONObject> parser) {
        return parserIterator(new IteratorForJSONArray(jsonArr), parser);
    }

    public static <T> List<T> parserObject(JSONObject json, ElementComparator<String> comparator, Parser<T, JSONObject> parser) {
        return parserIterator(new IteratorForJSONObject(json, comparator), parser);
    }
}
