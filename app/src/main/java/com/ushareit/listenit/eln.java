package com.ushareit.listenit;

import com.mopub.mraid.MraidJavascriptCommand;
import com.mopub.mraid.PlacementType;

public enum eln extends MraidJavascriptCommand {
    public eln(String str, int i, String str2) {
        super(str, i, str2);
    }

    boolean mo2200a(PlacementType placementType) {
        return placementType == PlacementType.INLINE;
    }
}
