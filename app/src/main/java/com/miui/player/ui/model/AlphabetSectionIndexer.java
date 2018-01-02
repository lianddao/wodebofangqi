package com.miui.player.ui.model;

import android.widget.SectionIndexer;
import java.util.Arrays;

public class AlphabetSectionIndexer implements SectionIndexer {
    private final int mCount;
    private final int[] mPositions;
    private final String[] mSections;

    public AlphabetSectionIndexer(String[] sections, Integer[] counts) {
        if (sections == null || counts == null) {
            throw new NullPointerException();
        } else if (sections.length != counts.length) {
            throw new IllegalArgumentException("The sections and counts arrays must have the same length");
        } else {
            this.mPositions = new int[counts.length];
            this.mSections = sections;
            int position = 0;
            for (int i = 0; i < counts.length; i++) {
                this.mPositions[i] = position;
                position += counts[i].intValue();
            }
            this.mCount = position;
        }
    }

    public Object[] getSections() {
        return this.mSections;
    }

    public int getPositionForSection(int section) {
        if (section < 0 || section >= this.mSections.length) {
            return -1;
        }
        return this.mPositions[section];
    }

    public int getSectionForPosition(int position) {
        if (position < 0 || position >= this.mCount) {
            return -1;
        }
        int index = Arrays.binarySearch(this.mPositions, position);
        if (index >= 0) {
            int v = this.mPositions[index];
            while (index < this.mPositions.length - 1 && this.mPositions[index + 1] == v) {
                index++;
            }
        }
        return index < 0 ? (-index) - 2 : index;
    }
}
