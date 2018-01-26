package cn.ldm.player.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import cn.ldm.player.R;

public class ServiceTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_service_test);
//        Intent intent=new Intent(this,MyService.class);
//        startService(intent);
        setContentView(R.layout.bottom_playing);
    }
}
