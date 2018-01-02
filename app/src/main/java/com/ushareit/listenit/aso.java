package com.ushareit.listenit;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class aso implements SensorEventListener {
    private aso() {
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == asm.f5325b) {
            asm.f5327d = sensorEvent.values;
        } else if (sensorEvent.sensor == asm.f5326c) {
            asm.f5328e = sensorEvent.values;
        }
        asm.m6977a(this);
    }
}
