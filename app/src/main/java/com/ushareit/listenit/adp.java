package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import java.util.HashSet;

@TargetApi(11)
public class adp extends Fragment {
    private final ade f4164a;
    private final adt f4165b;
    private tw f4166c;
    private final HashSet<adp> f4167d;
    private adp f4168e;

    public adp() {
        this(new ade());
    }

    @SuppressLint({"ValidFragment"})
    adp(ade com_ushareit_listenit_ade) {
        this.f4165b = new adr();
        this.f4167d = new HashSet();
        this.f4164a = com_ushareit_listenit_ade;
    }

    public void m5291a(tw twVar) {
        this.f4166c = twVar;
    }

    ade m5290a() {
        return this.f4164a;
    }

    public tw m5292b() {
        return this.f4166c;
    }

    public adt m5293c() {
        return this.f4165b;
    }

    private void m5288a(adp com_ushareit_listenit_adp) {
        this.f4167d.add(com_ushareit_listenit_adp);
    }

    private void m5289b(adp com_ushareit_listenit_adp) {
        this.f4167d.remove(com_ushareit_listenit_adp);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f4168e = ads.m5294a().m5297a(getActivity().getFragmentManager());
        if (this.f4168e != this) {
            this.f4168e.m5288a(this);
        }
    }

    public void onDetach() {
        super.onDetach();
        if (this.f4168e != null) {
            this.f4168e.m5289b(this);
            this.f4168e = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.f4164a.m5268a();
    }

    public void onStop() {
        super.onStop();
        this.f4164a.m5270b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f4164a.m5271c();
    }

    public void onTrimMemory(int i) {
        if (this.f4166c != null) {
            this.f4166c.m26483a(i);
        }
    }

    public void onLowMemory() {
        if (this.f4166c != null) {
            this.f4166c.m26482a();
        }
    }
}
