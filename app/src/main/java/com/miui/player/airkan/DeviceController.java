package com.miui.player.airkan;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.collect.Lists;
import com.milink.api.v1.type.DeviceType;
import com.miui.player.airkan.MilinkManager.DeviceListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeviceController {
    private static final int MSG_DELAY_DISCONNECT = 1;
    private static final int MSG_DELAY_REFRESH = 2;
    private static final int MSG_DEVICE_ADD = 101;
    private static final int MSG_DEVICE_DEL = 102;
    private static final int MSG_DEVICE_OPEN = 100;
    static final String TAG = "DeviceController";
    private static final DeviceController sInstance = new DeviceController();
    private Context mContext;
    private DeviceFilter mDeviceFilter = null;
    private MilinkManager mDeviceManager;
    private DeviceListener mDeviceManagerListener = new C03312();
    private boolean mDeviceOpen = false;
    private HashMap<String, String> mDevices = new HashMap();
    private final Handler mHandler = new C03301();
    private final List<WeakReference<DeviceChangedListener>> mListeners = Lists.newArrayList();
    private int mStatus = 0;

    public interface DeviceFilter {
        boolean supportDevice(Object obj);
    }

    class C03301 extends Handler {
        C03301() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    DeviceController.this.doClose(msg.arg1);
                    return;
                case 2:
                    DeviceController.this.refreshDevices();
                    return;
                case 100:
                    DeviceController.this.doServiceOpend();
                    return;
                case 101:
                    DeviceController.this.doDeviceAdded((String) msg.obj);
                    return;
                case 102:
                    DeviceController.this.doDeviceRemoved((String) msg.obj);
                    return;
                default:
                    return;
            }
        }
    }

    class C03312 implements DeviceListener {
        C03312() {
        }

        public void onOpen() {
            Log.v(DeviceController.TAG, "Open DeviceManagerService");
            DeviceController.this.mDeviceOpen = true;
            Message.obtain(DeviceController.this.mHandler, 100).sendToTarget();
        }

        public void onClose() {
            Log.v(DeviceController.TAG, "Close DeviceManagerService");
        }

        public void onDeviceFound(String deviceId, String name, DeviceType type) {
            DeviceController.this.mDevices.put(name, deviceId);
            Message.obtain(DeviceController.this.mHandler, 101, name).sendToTarget();
        }

        public void onDeviceLost(String deviceId) {
            String name = null;
            for (String dn : DeviceController.this.mDevices.keySet()) {
                if (((String) DeviceController.this.mDevices.get(dn)).equals(deviceId)) {
                    name = dn;
                    break;
                }
            }
            if (name != null) {
                DeviceController.this.mDevices.remove(name);
                Message.obtain(DeviceController.this.mHandler, 102, name).sendToTarget();
            }
        }
    }

    public interface DeviceChangedListener {
        void onDeviceAdded(String str);

        void onDeviceAvailable(List<String> list);

        void onDeviceRemoved(String str);
    }

    private DeviceController() {
    }

    public void initialize(Context context, DeviceFilter filter) {
        this.mContext = context;
        this.mDeviceFilter = filter;
    }

    private int findListener(DeviceChangedListener listener) {
        int i = 0;
        for (WeakReference<DeviceChangedListener> ref : this.mListeners) {
            if (ref.get() == listener) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean removeListener(DeviceChangedListener listener) {
        int index = findListener(listener);
        if (index < 0) {
            return false;
        }
        this.mListeners.remove(index);
        return true;
    }

    public boolean addListener(DeviceChangedListener listener) {
        if (findListener(listener) >= 0) {
            return false;
        }
        this.mListeners.add(new WeakReference(listener));
        return true;
    }

    public void open(int flag) {
        Log.i(TAG, String.format("open(), flag=%d, status=%d", new Object[]{Integer.valueOf(flag), Integer.valueOf(this.mStatus)}));
        this.mStatus |= flag;
        this.mHandler.removeMessages(1);
        if (this.mDeviceManager == null) {
            this.mDeviceManager = MilinkManager.instance();
            this.mDeviceManager.init(this.mContext);
            this.mDeviceManager.setDeviceListener(this.mDeviceManagerListener);
            this.mDeviceManager.open();
        } else if (this.mDeviceOpen) {
            this.mHandler.sendEmptyMessage(2);
        }
    }

    public void close(int flag) {
        Log.i(TAG, "close");
        this.mHandler.removeMessages(1);
        doClose(flag);
    }

    public void closeDelayed(int flag, long delayMillis) {
        Log.i(TAG, "closeDelayed " + delayMillis);
    }

    public boolean isOpened() {
        return this.mDeviceOpen;
    }

    public boolean isOpening() {
        return (this.mDeviceOpen || this.mDeviceManager == null) ? false : true;
    }

    public boolean refreshDevices() {
        if (!isOpened()) {
            return false;
        }
        queryDevices();
        return true;
    }

    void queryDevices() {
        doDeviceAvailable();
    }

    void doServiceOpend() {
        this.mDeviceOpen = true;
        queryDevices();
    }

    void doDeviceAvailable() {
        List<String> devices = new ArrayList(this.mDevices.keySet());
        if (!devices.isEmpty()) {
            for (WeakReference<DeviceChangedListener> ref : this.mListeners) {
                DeviceChangedListener listener = (DeviceChangedListener) ref.get();
                if (listener != null) {
                    listener.onDeviceAvailable(devices);
                }
            }
        }
    }

    void doDeviceAdded(String device) {
        if (this.mDeviceFilter == null || this.mDeviceFilter.supportDevice(device)) {
            for (WeakReference<DeviceChangedListener> ref : this.mListeners) {
                DeviceChangedListener listener = (DeviceChangedListener) ref.get();
                if (listener != null) {
                    listener.onDeviceAdded(device);
                }
            }
        }
    }

    void doDeviceRemoved(String device) {
        for (WeakReference<DeviceChangedListener> ref : this.mListeners) {
            DeviceChangedListener listener = (DeviceChangedListener) ref.get();
            if (listener != null) {
                listener.onDeviceRemoved(device);
            }
        }
    }

    void doClose(int flag) {
        Log.i(TAG, String.format("doClose(), flag=%d, status=%d", new Object[]{Integer.valueOf(flag), Integer.valueOf(this.mStatus)}));
        this.mStatus &= flag ^ -1;
        if (this.mStatus == 0 && isOpened()) {
            Log.i(TAG, "actual close, status=" + this.mStatus);
            this.mDeviceManager.close();
            this.mDeviceManager = null;
            this.mDeviceOpen = false;
        }
    }

    public String getDeviceByName(String name) {
        if (name == null) {
            return null;
        }
        return (String) this.mDevices.get(name);
    }

    public static DeviceController instance() {
        return sInstance;
    }
}
