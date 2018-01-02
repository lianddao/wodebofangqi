package com.songbirdnest.mediaplayer.service;

import android.media.audiofx.Equalizer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class EqualizerSettings implements Parcelable {
    public static final Creator<EqualizerSettings> CREATOR = new C01881();
    protected short[] bandLevels = new short[5];
    protected int[] centerFrequencies = new int[5];
    protected short curPreset = (short) 0;
    protected boolean enabled = true;
    protected short maxEQLevel = (short) 0;
    protected short minEQLevel = (short) 0;
    protected short numBands = (short) 5;
    protected PRESET_TYPE preset_type = PRESET_TYPE.SYSTEM;
    protected List<String> presets = new ArrayList();

    static class C01881 implements Creator<EqualizerSettings> {
        C01881() {
        }

        public EqualizerSettings createFromParcel(Parcel in) {
            EqualizerSettings equalizerSettings = new EqualizerSettings();
            equalizerSettings.readFromParcel(in);
            return equalizerSettings;
        }

        public EqualizerSettings[] newArray(int size) {
            return new EqualizerSettings[size];
        }
    }

    public enum PRESET_TYPE {
        SYSTEM,
        CUSTOM
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public short getCurPreset() {
        return this.curPreset;
    }

    public short getMaxEQLevel() {
        return this.maxEQLevel;
    }

    public short getMinEQLevel() {
        return this.minEQLevel;
    }

    public List<String> getPresets() {
        return this.presets;
    }

    public short getNumberOfBands() {
        return this.numBands;
    }

    public int getCenterFreq(short band) {
        if (band < this.centerFrequencies.length) {
            return this.centerFrequencies[band];
        }
        return 0;
    }

    public short getCurrentPreset() {
        return this.curPreset;
    }

    public void usePreset(short preset) {
        this.curPreset = preset;
    }

    public void setPresetType(PRESET_TYPE type) {
        this.preset_type = type;
    }

    public PRESET_TYPE getPresetType() {
        return this.preset_type;
    }

    public void setBandLevel(short band, short level) {
        if (band < this.bandLevels.length) {
            this.bandLevels[band] = level;
        }
    }

    public short getBandLevel(short band) {
        if (band < this.bandLevels.length) {
            return this.bandLevels[band];
        }
        return (short) 0;
    }

    public void setup(Equalizer equalizer) {
        short i;
        setBandArraySize(equalizer.getNumberOfBands());
        for (i = (short) 0; i < this.numBands; i = (short) (i + 1)) {
            this.bandLevels[i] = equalizer.getBandLevel(i);
            this.centerFrequencies[i] = equalizer.getCenterFreq(i);
        }
        this.curPreset = equalizer.getCurrentPreset();
        this.minEQLevel = equalizer.getBandLevelRange()[0];
        this.maxEQLevel = equalizer.getBandLevelRange()[1];
        short numberOfPresets = equalizer.getNumberOfPresets();
        this.presets.clear();
        for (i = (short) 0; i < numberOfPresets; i = (short) (i + 1)) {
            this.presets.add(equalizer.getPresetName(i));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        short i;
        dest.writeInt(this.curPreset);
        dest.writeString(this.preset_type.name());
        dest.writeInt(this.numBands);
        for (i = (short) 0; i < this.numBands; i++) {
            dest.writeInt(this.bandLevels[i]);
        }
        for (i = (short) 0; i < this.numBands; i++) {
            dest.writeInt(this.centerFrequencies[i]);
        }
        dest.writeInt(this.minEQLevel);
        dest.writeInt(this.maxEQLevel);
        dest.writeInt(this.enabled ? 1 : 0);
        dest.writeStringList(this.presets);
    }

    public void readFromParcel(Parcel parcel) {
        short i;
        boolean z = true;
        this.curPreset = (short) parcel.readInt();
        this.preset_type = PRESET_TYPE.valueOf(parcel.readString());
        setBandArraySize((short) parcel.readInt());
        for (i = (short) 0; i < this.numBands; i++) {
            this.bandLevels[i] = (short) parcel.readInt();
        }
        for (i = (short) 0; i < this.numBands; i++) {
            this.centerFrequencies[i] = parcel.readInt();
        }
        this.minEQLevel = (short) parcel.readInt();
        this.maxEQLevel = (short) parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.enabled = z;
        parcel.readStringList(this.presets);
    }

    private void setBandArraySize(short bands) {
        this.numBands = bands;
        if (bands > this.bandLevels.length) {
            this.bandLevels = new short[bands];
            this.centerFrequencies = new int[bands];
        }
    }
}
