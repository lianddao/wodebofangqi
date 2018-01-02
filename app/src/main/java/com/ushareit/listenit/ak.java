package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ak extends af implements C0004p, C0005s {
    final Handler f433c = new al(this);
    final ap f434d = ap.m6525a(new am(this));
    boolean f435e;
    boolean f436f;
    boolean f437g;
    boolean f438h;
    boolean f439i;
    boolean f440j;
    boolean f441k;
    int f442l;
    gh<String> f443m;

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f434d.m6541c();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.f443m.m21987a(i4);
            this.f443m.m21993c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            ah a = this.f434d.m6527a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.mo200a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f434d.m6528a().mo801c()) {
            mo63a();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f434d.m6529a(configuration);
    }

    public void onCreate(Bundle bundle) {
        this.f434d.m6531a(null);
        super.onCreate(bundle);
        an anVar = (an) getLastNonConfigurationInstance();
        if (anVar != null) {
            this.f434d.m6532a(anVar.f4909c);
        }
        if (bundle != null) {
            this.f434d.m6530a(bundle.getParcelable("android:support:fragments"), anVar != null ? anVar.f4908b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f442l = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f443m = new gh(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f443m.m21991b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f443m == null) {
            this.f443m = new gh();
            this.f442l = 0;
        }
        this.f434d.m6544f();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f434d.m6536a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View mo64a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f434d.m6526a(view, str, context, attributeSet);
    }

    public void onDestroy() {
        super.onDestroy();
        m703a(false);
        this.f434d.m6551m();
        this.f434d.m6555q();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f434d.m6552n();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f434d.m6537a(menuItem);
            case 6:
                return this.f434d.m6540b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f434d.m6539b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.f436f = false;
        if (this.f433c.hasMessages(2)) {
            this.f433c.removeMessages(2);
            mo544b();
        }
        this.f434d.m6548j();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f434d.m6541c();
    }

    public void onResume() {
        super.onResume();
        this.f433c.sendEmptyMessage(2);
        this.f436f = true;
        this.f434d.m6553o();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f433c.removeMessages(2);
        mo544b();
        this.f434d.m6553o();
    }

    public void mo544b() {
        this.f434d.m6547i();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f440j) {
            this.f440j = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m704a(view, menu) | this.f434d.m6535a(menu);
    }

    protected boolean m704a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f437g) {
            m703a(true);
        }
        Object c = m706c();
        ba e = this.f434d.m6543e();
        gg s = this.f434d.m6557s();
        if (e == null && s == null && c == null) {
            return null;
        }
        Object anVar = new an();
        anVar.f4907a = c;
        anVar.f4908b = e;
        anVar.f4909c = s;
        return anVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable d = this.f434d.m6542d();
        if (d != null) {
            bundle.putParcelable("android:support:fragments", d);
        }
        if (this.f443m.m21989b() > 0) {
            bundle.putInt("android:support:next_request_index", this.f442l);
            int[] iArr = new int[this.f443m.m21989b()];
            String[] strArr = new String[this.f443m.m21989b()];
            for (int i = 0; i < this.f443m.m21989b(); i++) {
                iArr[i] = this.f443m.m21994d(i);
                strArr[i] = (String) this.f443m.m21995e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    public void onStart() {
        super.onStart();
        this.f437g = false;
        this.f438h = false;
        this.f433c.removeMessages(1);
        if (!this.f435e) {
            this.f435e = true;
            this.f434d.m6545g();
        }
        this.f434d.m6541c();
        this.f434d.m6553o();
        this.f434d.m6554p();
        this.f434d.m6546h();
        this.f434d.m6556r();
    }

    public void onStop() {
        super.onStop();
        this.f437g = true;
        this.f433c.sendEmptyMessage(1);
        this.f434d.m6549k();
    }

    public Object m706c() {
        return null;
    }

    public void m707d() {
        if (VERSION.SDK_INT >= 11) {
            C0367t.m26247a(this);
        } else {
            this.f440j = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f435e);
            printWriter.print("mResumed=");
            printWriter.print(this.f436f);
            printWriter.print(" mStopped=");
            printWriter.print(this.f437g);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f438h);
            this.f434d.m6533a(str2, fileDescriptor, printWriter, strArr);
            this.f434d.m6528a().mo799a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m696a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f435e);
            printWriter.print("mResumed=");
            printWriter.print(this.f436f);
            printWriter.print(" mStopped=");
            printWriter.print(this.f437g);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f438h);
            this.f434d.m6533a(str2, fileDescriptor, printWriter, strArr);
            this.f434d.m6528a().mo799a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m696a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    private static String m693a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (CtaButton.BACKGROUND_COLOR & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m696a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(m693a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m696a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void m703a(boolean z) {
        if (!this.f438h) {
            this.f438h = true;
            this.f439i = z;
            this.f433c.removeMessages(1);
            m708e();
        } else if (z) {
            this.f434d.m6554p();
            this.f434d.m6534a(true);
        }
    }

    void m708e() {
        this.f434d.m6534a(this.f439i);
        this.f434d.m6550l();
    }

    public void m701a(ah ahVar) {
    }

    public ar m709f() {
        return this.f434d.m6528a();
    }

    public bp m710g() {
        return this.f434d.m6538b();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.b || i == -1)) {
            ad.m689b(i);
        }
        super.startActivityForResult(intent, i);
    }

    public final void mo65a(int i) {
        if (!this.f441k && i != -1) {
            ad.m689b(i);
        }
    }

    public void mo66a(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.f443m.m21987a(i3);
            this.f443m.m21993c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            ah a = this.f434d.m6527a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                a.m1279a(i & 65535, strArr, iArr);
            }
        }
    }

    public void m702a(ah ahVar, Intent intent, int i, Bundle bundle) {
        this.b = true;
        if (i == -1) {
            try {
                C0364n.m25142a(this, intent, -1, bundle);
            } finally {
                this.b = false;
            }
        } else {
            ad.m689b(i);
            C0364n.m25142a(this, intent, ((m697b(ahVar) + 1) << 16) + (65535 & i), bundle);
            this.b = false;
        }
    }

    private int m697b(ah ahVar) {
        if (this.f443m.m21989b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f443m.m21996f(this.f442l) >= 0) {
            this.f442l = (this.f442l + 1) % 65534;
        }
        int i = this.f442l;
        this.f443m.m21991b(i, ahVar.f1015q);
        this.f442l = (this.f442l + 1) % 65534;
        return i;
    }

    private void m694a(ah ahVar, String[] strArr, int i) {
        if (i == -1) {
            C0364n.m25143a(this, strArr, i);
            return;
        }
        ad.m689b(i);
        try {
            this.f441k = true;
            C0364n.m25143a(this, strArr, ((m697b(ahVar) + 1) << 16) + (65535 & i));
        } finally {
            this.f441k = false;
        }
    }
}
