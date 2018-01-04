package cn.ldm.player.activities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;


public  class PermissionActivity extends Activity {

    private static final int REQUEST_PERMISSION_CODE = 0;
    private static final String[] REQUEST_PERMISSION_NAME = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    private ArrayList<String> REQUEST_PERMISSION_NAME_ARRAY;

    {
        REQUEST_PERMISSION_NAME_ARRAY = new ArrayList<>();
        for (int i = 0; i < REQUEST_PERMISSION_NAME.length; i++)
            REQUEST_PERMISSION_NAME_ARRAY.add(REQUEST_PERMISSION_NAME[i]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断当前已获得的权限
        for (int i = 0; i < REQUEST_PERMISSION_NAME_ARRAY.size(); i++) {
            if (checkSelfPermission(REQUEST_PERMISSION_NAME[i]) == PackageManager.PERMISSION_GRANTED) {
                REQUEST_PERMISSION_NAME_ARRAY.remove(i);
            }
        }

        if (REQUEST_PERMISSION_NAME_ARRAY.size() > 0) {
            Log.i("abc", "需要申请 " + REQUEST_PERMISSION_NAME_ARRAY.size() + " 个权限");
            String[] requests = new String[REQUEST_PERMISSION_NAME_ARRAY.size()];
            try {
                requestPermissions(REQUEST_PERMISSION_NAME_ARRAY.toArray(requests), REQUEST_PERMISSION_CODE);
            } catch (Exception ex) {
                Log.i("abc", ex.toString());
            }
            return;
        }

        initApp();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_CODE) {
            boolean b = true;
            for (int i = 0; i < REQUEST_PERMISSION_NAME_ARRAY.size(); i++) {
                if (grantResults.length == 0 || grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    Log.i("abc", REQUEST_PERMISSION_NAME_ARRAY.get(i) + " 失败");
                    b = b && false;
                } else {
                    Log.i("abc", REQUEST_PERMISSION_NAME_ARRAY.get(i) + " 成功");
                    b = b && true;
                }
            }

            if (b == false) {
                finish();
                Log.i("abc", "权限不足,退出应用");
                return;
            } else {
                Log.i("abc", "成功授予所有权限");
                initApp();
            }
        }
    }

    public  void initApp(){
        Log.i("abc","initApp()");
    }
}
