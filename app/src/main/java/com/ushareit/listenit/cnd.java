package com.ushareit.listenit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cnd implements ctv {
    static final /* synthetic */ boolean f8494a = (!cnd.class.desiredAssertionStatus());
    private static final Charset f8495b = Charset.forName("UTF-8");
    private final SQLiteDatabase f8496c;
    private final cvy f8497d;
    private boolean f8498e;
    private long f8499f = 0;

    public cnd(Context context, cqd com_ushareit_listenit_cqd, String str) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            this.f8497d = com_ushareit_listenit_cqd.m12268a("Persistence");
            this.f8496c = m11826a(context, encode);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private int m11823a(cqq com_ushareit_listenit_cqq, List<String> list, int i) {
        int i2 = i + 1;
        String c = m11840c(com_ushareit_listenit_cqq);
        if (((String) list.get(i)).startsWith(c)) {
            while (i2 < list.size() && ((String) list.get(i2)).equals(m11828a(com_ushareit_listenit_cqq, i2 - i))) {
                i2++;
            }
            if (i2 < list.size()) {
                String str = (String) list.get(i2);
                String valueOf = String.valueOf(c);
                c = String.valueOf(".part-");
                if (str.startsWith(c.length() != 0 ? valueOf.concat(c) : new String(valueOf))) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return i2 - i;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }

    private int m11824a(String str, cqq com_ushareit_listenit_cqq) {
        String a = m11829a(m11840c(com_ushareit_listenit_cqq));
        return this.f8496c.delete(str, "path >= ? AND path < ?", new String[]{r1, a});
    }

    private Cursor m11825a(cqq com_ushareit_listenit_cqq, String[] strArr) {
        String c = m11840c(com_ushareit_listenit_cqq);
        String a = m11829a(c);
        String[] strArr2 = new String[(com_ushareit_listenit_cqq.m12348i() + 3)];
        String valueOf = String.valueOf(m11838b(com_ushareit_listenit_cqq, strArr2));
        String valueOf2 = String.valueOf(" OR (path > ? AND path < ?)");
        valueOf2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        strArr2[com_ushareit_listenit_cqq.m12348i() + 1] = c;
        strArr2[com_ushareit_listenit_cqq.m12348i() + 2] = a;
        return this.f8496c.query("serverCache", strArr, valueOf2, strArr2, null, null, "path");
    }

    private SQLiteDatabase m11826a(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new cng(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (Throwable e) {
            if (e instanceof SQLiteDatabaseLockedException) {
                throw new ecf("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
            }
            throw e;
        }
    }

    private cxa m11827a(byte[] bArr) {
        try {
            return cxd.m13275a(cyg.m13372b(new String(bArr, f8495b)));
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Could not deserialize node: ";
            String valueOf = String.valueOf(new String(bArr, f8495b));
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        }
    }

    private String m11828a(cqq com_ushareit_listenit_cqq, int i) {
        String valueOf = String.valueOf(m11840c(com_ushareit_listenit_cqq));
        String valueOf2 = String.valueOf(String.format(".part-%04d", new Object[]{Integer.valueOf(i)}));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private static String m11829a(String str) {
        if (f8494a || str.endsWith("/")) {
            String valueOf = String.valueOf(str.substring(0, str.length() - 1));
            return new StringBuilder(String.valueOf(valueOf).length() + 1).append(valueOf).append('0').toString();
        }
        throw new AssertionError("Path keys must end with a '/'");
    }

    private String m11830a(Collection<Long> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Long longValue : collection) {
            long longValue2 = longValue.longValue();
            if (obj == null) {
                stringBuilder.append(",");
            }
            stringBuilder.append(longValue2);
            obj = null;
        }
        return stringBuilder.toString();
    }

    private static List<byte[]> m11831a(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / i) + 1;
        List<byte[]> arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            int min = Math.min(i, bArr.length - (i2 * i));
            Object obj = new byte[min];
            System.arraycopy(bArr, i2 * i, obj, 0, min);
            arrayList.add(obj);
        }
        return arrayList;
    }

    private void m11832a(cqq com_ushareit_listenit_cqq, long j, String str, byte[] bArr) {
        m11842g();
        this.f8496c.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        if (bArr.length >= 262144) {
            List a = m11831a(bArr, 262144);
            for (int i = 0; i < a.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(j));
                contentValues.put("path", m11840c(com_ushareit_listenit_cqq));
                contentValues.put(VastExtensionXmlManager.TYPE, str);
                contentValues.put("part", Integer.valueOf(i));
                contentValues.put("node", (byte[]) a.get(i));
                this.f8496c.insertWithOnConflict("writes", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("id", Long.valueOf(j));
        contentValues2.put("path", m11840c(com_ushareit_listenit_cqq));
        contentValues2.put(VastExtensionXmlManager.TYPE, str);
        contentValues2.put("part", null);
        contentValues2.put("node", bArr);
        this.f8496c.insertWithOnConflict("writes", null, contentValues2, 5);
    }

    private void m11833a(cqq com_ushareit_listenit_cqq, cqq com_ushareit_listenit_cqq2, cui<Long> com_ushareit_listenit_cui_java_lang_Long, cui<Long> com_ushareit_listenit_cui_java_lang_Long2, ctw com_ushareit_listenit_ctw, List<cyp<cqq, cxa>> list) {
        if (com_ushareit_listenit_cui_java_lang_Long.m12746b() != null) {
            if (((Integer) com_ushareit_listenit_ctw.m12685a(Integer.valueOf(0), new cne(this, com_ushareit_listenit_cui_java_lang_Long2))).intValue() > 0) {
                cqq a = com_ushareit_listenit_cqq.m12337a(com_ushareit_listenit_cqq2);
                if (this.f8497d.m13094a()) {
                    this.f8497d.m13093a(String.format("Need to rewrite %d nodes below path %s", new Object[]{Integer.valueOf(r0), a}), new Object[0]);
                }
                com_ushareit_listenit_ctw.m12685a(null, new cnf(this, com_ushareit_listenit_cui_java_lang_Long2, list, com_ushareit_listenit_cqq2, m11837b(a)));
                return;
            }
            return;
        }
        Iterator it = com_ushareit_listenit_cui_java_lang_Long.m12749c().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            cwc com_ushareit_listenit_cwc = (cwc) entry.getKey();
            ctw a2 = com_ushareit_listenit_ctw.m12684a((cwc) entry.getKey());
            m11833a(com_ushareit_listenit_cqq, com_ushareit_listenit_cqq2.m12338a(com_ushareit_listenit_cwc), (cui) entry.getValue(), com_ushareit_listenit_cui_java_lang_Long2.m12742a(com_ushareit_listenit_cwc), a2, list);
        }
    }

    private void m11834a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            i = 0;
            i2 = 0;
            for (cwz com_ushareit_listenit_cwz : com_ushareit_listenit_cxa) {
                i2 += m11824a("serverCache", com_ushareit_listenit_cqq.m12338a(com_ushareit_listenit_cwz.m13267c()));
                i = m11839c(com_ushareit_listenit_cqq.m12338a(com_ushareit_listenit_cwz.m13267c()), com_ushareit_listenit_cwz.m13268d()) + i;
            }
        } else {
            i2 = m11824a("serverCache", com_ushareit_listenit_cqq);
            i = m11839c(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa);
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), com_ushareit_listenit_cqq.toString(), Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    private byte[] m11835a(Object obj) {
        try {
            return cyg.m13365a(obj).getBytes(f8495b);
        } catch (Throwable e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private byte[] m11836a(List<byte[]> list) {
        int i = 0;
        for (byte[] length : list) {
            i = length.length + i;
        }
        Object obj = new byte[i];
        i = 0;
        for (byte[] length2 : list) {
            System.arraycopy(length2, 0, obj, i, length2.length);
            i = length2.length + i;
        }
        return obj;
    }

    private cxa m11837b(cqq com_ushareit_listenit_cqq) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = m11825a(com_ushareit_listenit_cqq, new String[]{"path", "value"});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (a.moveToNext()) {
            try {
                arrayList.add(a.getString(0));
                arrayList2.add(a.getBlob(1));
            } finally {
                a.close();
            }
        }
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis5 = System.currentTimeMillis();
        cxa j = cwr.m13215j();
        Object obj = null;
        Map hashMap = new HashMap();
        int i = 0;
        while (i < arrayList2.size()) {
            int a2;
            cqq com_ushareit_listenit_cqq2;
            cxa a3;
            Object obj2;
            cxa com_ushareit_listenit_cxa;
            if (((String) arrayList.get(i)).endsWith(".part-0000")) {
                String str = (String) arrayList.get(i);
                cqq com_ushareit_listenit_cqq3 = new cqq(str.substring(0, str.length() - ".part-0000".length()));
                a2 = m11823a(com_ushareit_listenit_cqq3, arrayList, i);
                if (this.f8497d.m13094a()) {
                    this.f8497d.m13093a("Loading split node with " + a2 + " parts.", new Object[0]);
                }
                byte[] a4 = m11836a(arrayList2.subList(i, i + a2));
                a2 = (i + a2) - 1;
                com_ushareit_listenit_cqq2 = com_ushareit_listenit_cqq3;
                a3 = m11827a(a4);
            } else {
                cxa a5 = m11827a((byte[]) arrayList2.get(i));
                cqq com_ushareit_listenit_cqq4 = new cqq((String) arrayList.get(i));
                a3 = a5;
                a2 = i;
                com_ushareit_listenit_cqq2 = com_ushareit_listenit_cqq4;
            }
            if (com_ushareit_listenit_cqq2.m12346g() != null && com_ushareit_listenit_cqq2.m12346g().m13145e()) {
                hashMap.put(com_ushareit_listenit_cqq2, a3);
                obj2 = obj;
                com_ushareit_listenit_cxa = j;
            } else if (com_ushareit_listenit_cqq2.m12340b(com_ushareit_listenit_cqq)) {
                cyr.m13388a(obj == null, "Descendants of path must come after ancestors.");
                Object obj3 = obj;
                com_ushareit_listenit_cxa = a3.mo1629a(cqq.m12333a(com_ushareit_listenit_cqq2, com_ushareit_listenit_cqq));
                obj2 = obj3;
            } else if (com_ushareit_listenit_cqq.m12340b(com_ushareit_listenit_cqq2)) {
                obj2 = 1;
                com_ushareit_listenit_cxa = j.mo1630a(cqq.m12333a(com_ushareit_listenit_cqq, com_ushareit_listenit_cqq2), a3);
            } else {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", new Object[]{com_ushareit_listenit_cqq2, com_ushareit_listenit_cqq}));
            }
            i = a2 + 1;
            j = com_ushareit_listenit_cxa;
            obj = obj2;
        }
        for (Entry entry : hashMap.entrySet()) {
            j = j.mo1630a(cqq.m12333a(com_ushareit_listenit_cqq, (cqq) entry.getKey()), (cxa) entry.getValue());
        }
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
        long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(cyn.m13377b(j)), com_ushareit_listenit_cqq, Long.valueOf(currentTimeMillis7), Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis6)}), new Object[0]);
        }
        return j;
    }

    private static String m11838b(cqq com_ushareit_listenit_cqq, String[] strArr) {
        if (f8494a || strArr.length >= com_ushareit_listenit_cqq.m12348i() + 1) {
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder("(");
            while (!com_ushareit_listenit_cqq.m12347h()) {
                stringBuilder.append("path");
                stringBuilder.append(" = ? OR ");
                strArr[i] = m11840c(com_ushareit_listenit_cqq);
                com_ushareit_listenit_cqq = com_ushareit_listenit_cqq.m12345f();
                i++;
            }
            stringBuilder.append("path");
            stringBuilder.append(" = ?)");
            strArr[i] = m11840c(cqq.m12332a());
            return stringBuilder.toString();
        }
        throw new AssertionError();
    }

    private int m11839c(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        long a = cyn.m13376a(com_ushareit_listenit_cxa);
        if (!(com_ushareit_listenit_cxa instanceof cwf) || a <= 16384) {
            m11841d(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa);
            return 1;
        }
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", new Object[]{com_ushareit_listenit_cqq, Long.valueOf(a), Integer.valueOf(16384)}), new Object[0]);
        }
        int i = 0;
        for (cwz com_ushareit_listenit_cwz : com_ushareit_listenit_cxa) {
            i = m11839c(com_ushareit_listenit_cqq.m12338a(com_ushareit_listenit_cwz.m13267c()), com_ushareit_listenit_cwz.m13268d()) + i;
        }
        if (!com_ushareit_listenit_cxa.mo1640f().mo1635b()) {
            m11841d(com_ushareit_listenit_cqq.m12338a(cwc.m13142c()), com_ushareit_listenit_cxa.mo1640f());
            i++;
        }
        m11841d(com_ushareit_listenit_cqq, cwr.m13215j());
        return i + 1;
    }

    private static String m11840c(cqq com_ushareit_listenit_cqq) {
        return com_ushareit_listenit_cqq.m12347h() ? "/" : String.valueOf(com_ushareit_listenit_cqq.toString()).concat("/");
    }

    private void m11841d(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        byte[] a = m11835a(com_ushareit_listenit_cxa.mo1632a(true));
        if (a.length >= 262144) {
            List a2 = m11831a(a, 262144);
            if (this.f8497d.m13094a()) {
                this.f8497d.m13093a("Saving huge leaf node with " + a2.size() + " parts.", new Object[0]);
            }
            for (int i = 0; i < a2.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("path", m11828a(com_ushareit_listenit_cqq, i));
                contentValues.put("value", (byte[]) a2.get(i));
                this.f8496c.insertWithOnConflict("serverCache", null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("path", m11840c(com_ushareit_listenit_cqq));
        contentValues2.put("value", a);
        this.f8496c.insertWithOnConflict("serverCache", null, contentValues2, 5);
    }

    private void m11842g() {
        cyr.m13388a(this.f8498e, "Transaction expected to already be in progress.");
    }

    public cxa mo1463a(cqq com_ushareit_listenit_cqq) {
        return m11837b(com_ushareit_listenit_cqq);
    }

    public List<csz> mo1464a() {
        String[] strArr = new String[]{"id", "path", VastExtensionXmlManager.TYPE, "part", "node"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f8496c.query("writes", strArr, null, null, null, null, "id, part");
        List<csz> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                byte[] blob;
                Object com_ushareit_listenit_csz;
                long j = query.getLong(0);
                cqq com_ushareit_listenit_cqq = new cqq(query.getString(1));
                String string = query.getString(2);
                if (query.isNull(3)) {
                    blob = query.getBlob(4);
                } else {
                    List arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(query.getBlob(4));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } while (query.getLong(0) == j);
                    query.moveToPrevious();
                    blob = m11836a(arrayList2);
                }
                Object b = cyg.m13372b(new String(blob, f8495b));
                if ("o".equals(string)) {
                    com_ushareit_listenit_csz = new csz(j, com_ushareit_listenit_cqq, cxd.m13275a(b), true);
                } else if ("m".equals(string)) {
                    com_ushareit_listenit_csz = new csz(j, com_ushareit_listenit_cqq, cpz.m12233a((Map) b));
                } else {
                    String str = "Got invalid write type: ";
                    String valueOf = String.valueOf(string);
                    throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
                arrayList.add(com_ushareit_listenit_csz);
            } catch (Throwable e) {
                throw new RuntimeException("Failed to load writes", e);
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Loaded %d writes in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public Set<cwc> mo1465a(Set<Long> set) {
        String[] strArr = new String[]{"key"};
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf("id IN (");
        String valueOf2 = String.valueOf(m11830a((Collection) set));
        Cursor query = this.f8496c.query(true, "trackedKeys", strArr, new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append(valueOf2).append(")").toString(), null, null, null, null, null);
        Set<cwc> hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(cwc.m13139a(query.getString(0)));
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", new Object[]{Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return hashSet;
    }

    public void mo1466a(long j) {
        m11842g();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.f8496c.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Deleted %d write(s) with writeId %d in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(j), Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public void mo1467a(long j, Set<cwc> set) {
        m11842g();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        this.f8496c.delete("trackedKeys", "id = ?", new String[]{valueOf});
        for (cwc com_ushareit_listenit_cwc : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", com_ushareit_listenit_cwc.m13144d());
            this.f8496c.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Set %d tracked query keys for tracked query %d in %dms", new Object[]{Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo1468a(long j, Set<cwc> set, Set<cwc> set2) {
        m11842g();
        long currentTimeMillis = System.currentTimeMillis();
        String str = "id = ? AND key = ?";
        String valueOf = String.valueOf(j);
        for (cwc com_ushareit_listenit_cwc : set2) {
            this.f8496c.delete("trackedKeys", str, new String[]{valueOf, com_ushareit_listenit_cwc.m13144d()});
        }
        for (cwc com_ushareit_listenit_cwc2 : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", com_ushareit_listenit_cwc2.m13144d());
            this.f8496c.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", new Object[]{Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo1469a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz) {
        m11842g();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = com_ushareit_listenit_cpz.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            i += m11824a("serverCache", com_ushareit_listenit_cqq.m12337a((cqq) entry.getKey()));
            i2 = m11839c(com_ushareit_listenit_cqq.m12337a((cqq) entry.getKey()), (cxa) entry.getValue()) + i2;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), com_ushareit_listenit_cqq.toString(), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo1470a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz, long j) {
        m11842g();
        long currentTimeMillis = System.currentTimeMillis();
        cqq com_ushareit_listenit_cqq2 = com_ushareit_listenit_cqq;
        long j2 = j;
        m11832a(com_ushareit_listenit_cqq2, j2, "m", m11835a(com_ushareit_listenit_cpz.m12241a(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Persisted user merge in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo1471a(cqq com_ushareit_listenit_cqq, ctw com_ushareit_listenit_ctw) {
        if (com_ushareit_listenit_ctw.m12686a()) {
            m11842g();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor a = m11825a(com_ushareit_listenit_cqq, new String[]{"rowid", "path"});
            cui com_ushareit_listenit_cui = new cui(null);
            cui com_ushareit_listenit_cui2 = new cui(null);
            while (a.moveToNext()) {
                long j = a.getLong(0);
                cqq com_ushareit_listenit_cqq2 = new cqq(a.getString(1));
                cvy com_ushareit_listenit_cvy;
                String valueOf;
                String valueOf2;
                if (com_ushareit_listenit_cqq.m12340b(com_ushareit_listenit_cqq2)) {
                    cqq a2 = cqq.m12333a(com_ushareit_listenit_cqq, com_ushareit_listenit_cqq2);
                    if (com_ushareit_listenit_ctw.m12687a(a2)) {
                        com_ushareit_listenit_cui = com_ushareit_listenit_cui.m12741a(a2, Long.valueOf(j));
                    } else if (com_ushareit_listenit_ctw.m12688b(a2)) {
                        com_ushareit_listenit_cui2 = com_ushareit_listenit_cui2.m12741a(a2, Long.valueOf(j));
                    } else {
                        com_ushareit_listenit_cvy = this.f8497d;
                        valueOf = String.valueOf(com_ushareit_listenit_cqq);
                        valueOf2 = String.valueOf(com_ushareit_listenit_cqq2);
                        com_ushareit_listenit_cvy.m13090a(new StringBuilder((String.valueOf(valueOf).length() + 88) + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" and have data at ").append(valueOf2).append(" that isn't marked for pruning or keeping. Ignoring.").toString());
                    }
                } else {
                    com_ushareit_listenit_cvy = this.f8497d;
                    valueOf = String.valueOf(com_ushareit_listenit_cqq);
                    valueOf2 = String.valueOf(com_ushareit_listenit_cqq2);
                    com_ushareit_listenit_cvy.m13090a(new StringBuilder((String.valueOf(valueOf).length() + 67) + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" but we have data stored higher up at ").append(valueOf2).append(". Ignoring.").toString());
                }
            }
            int i = 0;
            int i2 = 0;
            if (!com_ushareit_listenit_cui.m12753d()) {
                List<cyp> arrayList = new ArrayList();
                m11833a(com_ushareit_listenit_cqq, cqq.m12332a(), com_ushareit_listenit_cui, com_ushareit_listenit_cui2, com_ushareit_listenit_ctw, arrayList);
                Collection e = com_ushareit_listenit_cui.m12755e();
                String valueOf3 = String.valueOf(m11830a(e));
                this.f8496c.delete("serverCache", new StringBuilder(String.valueOf(valueOf3).length() + 11).append("rowid IN (").append(valueOf3).append(")").toString(), null);
                for (cyp com_ushareit_listenit_cyp : arrayList) {
                    m11839c(com_ushareit_listenit_cqq.m12337a((cqq) com_ushareit_listenit_cyp.m13380a()), (cxa) com_ushareit_listenit_cyp.m13381b());
                }
                i = e.size();
                i2 = arrayList.size();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.f8497d.m13094a()) {
                this.f8497d.m13093a(String.format("Pruned %d rows with %d nodes resaved in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)}), new Object[0]);
            }
        }
    }

    public void mo1472a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        m11842g();
        m11834a(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa, false);
    }

    public void mo1473a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, long j) {
        m11842g();
        long currentTimeMillis = System.currentTimeMillis();
        cqq com_ushareit_listenit_cqq2 = com_ushareit_listenit_cqq;
        long j2 = j;
        m11832a(com_ushareit_listenit_cqq2, j2, "o", m11835a(com_ushareit_listenit_cxa.mo1632a(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Persisted user overwrite in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void mo1474a(cua com_ushareit_listenit_cua) {
        m11842g();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(com_ushareit_listenit_cua.f8980a));
        contentValues.put("path", m11840c(com_ushareit_listenit_cua.f8981b.m13002a()));
        contentValues.put("queryParams", com_ushareit_listenit_cua.f8981b.m13003b().m12998p());
        contentValues.put("lastUse", Long.valueOf(com_ushareit_listenit_cua.f8982c));
        contentValues.put("complete", Boolean.valueOf(com_ushareit_listenit_cua.f8983d));
        contentValues.put("active", Boolean.valueOf(com_ushareit_listenit_cua.f8984e));
        this.f8496c.insertWithOnConflict("trackedQueries", null, contentValues, 5);
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Saved new tracked query in %dms", new Object[]{Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public long mo1475b() {
        long j = null;
        Cursor rawQuery = this.f8496c.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", new Object[]{"value", "path", "serverCache"}), null);
        try {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                return j;
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    public void mo1476b(long j) {
        m11842g();
        String valueOf = String.valueOf(j);
        this.f8496c.delete("trackedQueries", "id = ?", new String[]{valueOf});
        this.f8496c.delete("trackedKeys", "id = ?", new String[]{valueOf});
    }

    public void mo1477b(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        m11842g();
        m11834a(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa, true);
    }

    public List<cua> mo1478c() {
        String[] strArr = new String[]{"id", "path", "queryParams", "lastUse", "complete", "active"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f8496c.query("trackedQueries", strArr, null, null, null, null, "id");
        List<cua> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new cua(query.getLong(0), cvg.m13001a(new cqq(query.getString(1)), cyg.m13368a(query.getString(2))), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Loaded %d tracked queries in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public void mo1479c(long j) {
        m11842g();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.valueOf(false));
        contentValues.put("lastUse", Long.valueOf(j));
        this.f8496c.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Reset active tracked queries in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public Set<cwc> mo1480d(long j) {
        return mo1465a(Collections.singleton(Long.valueOf(j)));
    }

    public void mo1481d() {
        cyr.m13388a(!this.f8498e, "runInTransaction called when an existing transaction is already in progress.");
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a("Starting transaction.", new Object[0]);
        }
        this.f8496c.beginTransaction();
        this.f8498e = true;
        this.f8499f = System.currentTimeMillis();
    }

    public void mo1482e() {
        this.f8496c.endTransaction();
        this.f8498e = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f8499f;
        if (this.f8497d.m13094a()) {
            this.f8497d.m13093a(String.format("Transaction completed. Elapsed: %dms", new Object[]{Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public void mo1483f() {
        this.f8496c.setTransactionSuccessful();
    }
}
