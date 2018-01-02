package com.songbirdnest.mediaplayer.view.adapter;

import java.util.Comparator;

public class ListCompare implements Comparator<Object[]> {
    static int absDiff(int pValue) {
        if (pValue > 0) {
            return pValue * -1;
        }
        return pValue;
    }

    public int compare(Object[] lhs, Object[] rhs) {
        int lhsDiff = absDiff(((Integer) lhs[0]).intValue());
        int rhsDiff = absDiff(((Integer) rhs[0]).intValue());
        if (lhsDiff > rhsDiff) {
            return 1;
        }
        return lhsDiff < rhsDiff ? -1 : 0;
    }
}
