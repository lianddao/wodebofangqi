package com.ushareit.listenit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.about.AboutActivity;
import com.ushareit.listenit.musicfolders.MusicFoldersActivity;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.LockScreenSettingPopupView;
import com.ushareit.listenit.settings.FullScanActivity;
import com.ushareit.listenit.settings.UserSettingsActivity;

public class gvy implements OnClickListener {
    final /* synthetic */ UserSettingsActivity f14810a;

    public gvy(UserSettingsActivity userSettingsActivity) {
        this.f14810a = userSettingsActivity;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0349R.id.facebook:
                fad.m18687a(this.f14810a, "486281904897348", "bestLISTENit");
                fii.m19297a(this.f14810a.getApplicationContext(), "facebook", "from_navigation");
                return;
            case C0349R.id.feedback:
                gxw.m23113a(this.f14810a, "Listenit@ushareit.com", null);
                fii.m19297a(this.f14810a.getApplicationContext(), "feedback", "from_navigation");
                return;
            case C0349R.id.setting_full_scan_sdcard:
                this.f14810a.startActivity(new Intent(this.f14810a, FullScanActivity.class));
                fii.m19295a(this.f14810a, "FullScanSdcard");
                fii.m19316d(this.f14810a, "setting");
                return;
            case C0349R.id.setting_audio_folder:
                this.f14810a.startActivity(new Intent(this.f14810a, MusicFoldersActivity.class));
                fii.m19295a(this.f14810a, "audio_folder");
                return;
            case C0349R.id.setting_lockscreen:
                BasePopupView lockScreenSettingPopupView = new LockScreenSettingPopupView(this.f14810a);
                lockScreenSettingPopupView.setSettingOkListener(this.f14810a.ac);
                gyn.m23197a(this.f14810a, new fyi(lockScreenSettingPopupView));
                fii.m19295a(this.f14810a, "LockScreen");
                return;
            case C0349R.id.about:
                this.f14810a.m26080a(new Intent(this.f14810a, AboutActivity.class));
                fii.m19297a(this.f14810a.getApplicationContext(), "about", "from_navigation");
                return;
            default:
                return;
        }
    }
}
