package com.ushareit.listenit.settings;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.euo;
import com.ushareit.listenit.fac;
import com.ushareit.listenit.fah;
import com.ushareit.listenit.fan;
import com.ushareit.listenit.fjk;
import com.ushareit.listenit.fqk;
import com.ushareit.listenit.gva;
import com.ushareit.listenit.gvb;
import com.ushareit.listenit.gvc;
import com.ushareit.listenit.gvd;
import com.ushareit.listenit.gve;
import com.ushareit.listenit.gvf;
import com.ushareit.listenit.gvg;
import com.ushareit.listenit.gvh;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.widget.SwitchButton;

public class ProductSettingsActivity extends fjk {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0349R.layout.settings_product_activity);
        setTitle(C0349R.string.setting_name);
        m5103d(8);
        SwitchButton switchButton = (SwitchButton) findViewById(C0349R.id.settings_logger_level);
        switchButton.setCheckedImmediately(gva.m22851a(this));
        switchButton.setOnCheckedChangeListener(new gvb(this));
        switchButton = (SwitchButton) findViewById(C0349R.id.settings_use_dev_server);
        switchButton.setCheckedImmediately(fan.m18727a(this));
        switchButton.setOnCheckedChangeListener(new gvc(this));
        switchButton = (SwitchButton) findViewById(C0349R.id.settings_show_nearby);
        switchButton.setCheckedImmediately(fqk.m20381g());
        switchButton.setOnCheckedChangeListener(new gvd(this));
        switchButton = (SwitchButton) findViewById(C0349R.id.settings_show_discovery);
        switchButton.setCheckedImmediately(gvj.m23028r());
        switchButton.setOnCheckedChangeListener(new gve(this));
        EditText editText = (EditText) findViewById(C0349R.id.settings_discovery_data);
        editText.setText(gvj.m23029s());
        editText.addTextChangedListener(new gvf(this));
        editText = (EditText) findViewById(C0349R.id.settings_discovery_data_country);
        editText.setText(gvj.m23032t());
        editText.addTextChangedListener(new gvg(this));
        m26073j();
        m26074p();
        m26075q();
    }

    protected void onStop() {
        super.onStop();
    }

    public boolean mo539h() {
        return false;
    }

    public boolean mo540i() {
        return false;
    }

    private void m26073j() {
        ((TextView) findViewById(C0349R.id.display_channel_info)).setText("Channel: " + fac.m18682a());
    }

    private void m26074p() {
        ((TextView) findViewById(C0349R.id.display_device_id)).setText("Device Id: " + fah.m18702a(getApplicationContext()));
    }

    private void m26075q() {
        findViewById(C0349R.id.display_cloud_config).setOnClickListener(new gvh(this));
    }

    private String m26072b(String str) {
        if (euo.m18015a((Context) this, str)) {
            return str + ":" + euo.m18021b(this, str) + "\n";
        }
        return str + ":" + "NULL" + "\n";
    }
}
