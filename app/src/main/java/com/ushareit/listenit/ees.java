package com.ushareit.listenit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class ees {
    SharedPreferences f10903a;
    Context f10904b;

    public ees(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public ees(Context context, String str) {
        this.f10904b = context;
        this.f10903a = context.getSharedPreferences(str, 4);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        m16879e(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private String m16877a(String str, String str2) {
        String valueOf = String.valueOf("|S|");
        return new StringBuilder(((String.valueOf(str).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()).append(str).append(valueOf).append(str2).toString();
    }

    private String m16878c(String str, String str2, String str3) {
        String valueOf = String.valueOf("|T|");
        return new StringBuilder((((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(valueOf).append(str2).append("|").append(str3).toString();
    }

    private void m16879e(String str) {
        File file = new File(cix.m11420a(this.f10904b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !m16887b()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.m2554a(this.f10904b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String str2 = "InstanceID/Store";
                    String str3 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                }
            }
        }
    }

    private void m16880f(String str) {
        Editor edit = this.f10903a.edit();
        for (String str2 : this.f10903a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public SharedPreferences m16881a() {
        return this.f10903a;
    }

    public synchronized eet m16882a(String str, String str2, String str3) {
        return eet.m16891a(this.f10903a.getString(m16878c(str, str2, str3), null));
    }

    synchronized KeyPair m16883a(String str) {
        KeyPair a;
        a = eej.m16845a();
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = this.f10903a.edit();
        edit.putString(m16877a(str, "|P|"), FirebaseInstanceId.m2553a(a.getPublic().getEncoded()));
        edit.putString(m16877a(str, "|K|"), FirebaseInstanceId.m2553a(a.getPrivate().getEncoded()));
        edit.putString(m16877a(str, "cre"), Long.toString(currentTimeMillis));
        edit.commit();
        return a;
    }

    public synchronized void m16884a(String str, String str2, String str3, String str4, String str5) {
        String a = eet.m16892a(str4, str5, System.currentTimeMillis());
        if (a != null) {
            Editor edit = this.f10903a.edit();
            edit.putString(m16878c(str, str2, str3), a);
            edit.commit();
        }
    }

    synchronized void m16885b(String str) {
        m16880f(String.valueOf(str).concat("|"));
    }

    public synchronized void m16886b(String str, String str2, String str3) {
        String c = m16878c(str, str2, str3);
        Editor edit = this.f10903a.edit();
        edit.remove(c);
        edit.commit();
    }

    public synchronized boolean m16887b() {
        return this.f10903a.getAll().isEmpty();
    }

    public synchronized void m16888c() {
        this.f10903a.edit().clear().commit();
    }

    public synchronized void m16889c(String str) {
        m16880f(String.valueOf(str).concat("|T|"));
    }

    public synchronized KeyPair m16890d(String str) {
        KeyPair keyPair;
        Object e;
        String string = this.f10903a.getString(m16877a(str, "|P|"), null);
        String string2 = this.f10903a.getString(m16877a(str, "|K|"), null);
        if (string == null || string2 == null) {
            keyPair = null;
        } else {
            try {
                byte[] decode = Base64.decode(string, 8);
                byte[] decode2 = Base64.decode(string2, 8);
                KeyFactory instance = KeyFactory.getInstance("RSA");
                keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (InvalidKeySpecException e2) {
                e = e2;
                string = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(string).length() + 19).append("Invalid key stored ").append(string).toString());
                FirebaseInstanceId.m2554a(this.f10904b, this);
                keyPair = null;
                return keyPair;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                string = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(string).length() + 19).append("Invalid key stored ").append(string).toString());
                FirebaseInstanceId.m2554a(this.f10904b, this);
                keyPair = null;
                return keyPair;
            }
        }
        return keyPair;
    }
}
