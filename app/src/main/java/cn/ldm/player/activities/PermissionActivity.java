package cn.ldm.player.activities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

public abstract class PermissionActivity extends Activity {

    private static final String tag = PermissionActivity.class.getSimpleName();
    private static final int REQUEST_PERMISSION_CODE = 0;
    private static final String[] REQUEST_PERMISSION_NAME = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_CONTACTS
    };
    private ArrayList<String> mRequestPermissionNameArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //组织需要申请的权限
        mRequestPermissionNameArray = new ArrayList<>();
        for (int i = 0; i < REQUEST_PERMISSION_NAME.length; i++) {
            if (checkSelfPermission(REQUEST_PERMISSION_NAME[i]) == PackageManager.PERMISSION_DENIED) {
                Log.i(tag, "组织需要申请的权限" + REQUEST_PERMISSION_NAME[i]);
                mRequestPermissionNameArray.add(REQUEST_PERMISSION_NAME[i]);
            } else {
                Log.i(tag, "已获得的权限:" + REQUEST_PERMISSION_NAME[i]);
            }
        }

        if (mRequestPermissionNameArray.size() > 0) {
            Log.i(tag, "需要申请 " + mRequestPermissionNameArray.size() + " 个权限");
            String[] requests = new String[mRequestPermissionNameArray.size()];
            requestPermissions(mRequestPermissionNameArray.toArray(requests), REQUEST_PERMISSION_CODE);
            return;
        }

        initAppAfterRequestPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_CODE) {
            boolean b = true;
            for (int i = 0; i < mRequestPermissionNameArray.size(); i++) {
                if (grantResults.length == 0 || grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(tag, mRequestPermissionNameArray.get(i) + " 失败");
                    b = b && false;
                } else {
                    Log.i(tag, mRequestPermissionNameArray.get(i) + " 成功");
                    b = b && true;
                }
            }

            if (b == false) {
                finish();
                Log.i(tag, "权限不足,退出应用");
                return;
            } else {
                Log.i(tag, "成功授予所有权限");
                initAppAfterRequestPermission();
            }
        }
    }

    public abstract void initAppAfterRequestPermission();
}
