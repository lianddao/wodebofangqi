package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.main.navigation.NavigationView;
import com.ushareit.listenit.theme.ThemeSettingsActivity;

public class gjh implements OnClickListener {
    final /* synthetic */ NavigationView f14195a;

    public gjh(NavigationView navigationView) {
        this.f14195a = navigationView;
    }

    public void onClick(View view) {
        this.f14195a.getContext().startActivity(new Intent(this.f14195a.getContext(), ThemeSettingsActivity.class));
        fii.m19295a(this.f14195a.getContext(), "color_theme");
    }
}
