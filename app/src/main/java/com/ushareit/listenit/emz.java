package com.ushareit.listenit;

import com.mopub.nativeads.MoPubRecyclerAdapter;
import com.mopub.nativeads.MoPubRecyclerAdapter.ContentChangeStrategy;

public class emz extends rz {
    final /* synthetic */ MoPubRecyclerAdapter f11285a;

    public emz(MoPubRecyclerAdapter moPubRecyclerAdapter) {
        this.f11285a = moPubRecyclerAdapter;
    }

    public void onChanged() {
        this.f11285a.f2658c.setItemCount(this.f11285a.f2659d.getItemCount());
        this.f11285a.notifyDataSetChanged();
    }

    public void onItemRangeChanged(int i, int i2) {
        int adjustedPosition = this.f11285a.f2658c.getAdjustedPosition((i + i2) - 1);
        int adjustedPosition2 = this.f11285a.f2658c.getAdjustedPosition(i);
        this.f11285a.notifyItemRangeChanged(adjustedPosition2, (adjustedPosition - adjustedPosition2) + 1);
    }

    public void onItemRangeInserted(int i, int i2) {
        int i3 = 0;
        int adjustedPosition = this.f11285a.f2658c.getAdjustedPosition(i);
        int itemCount = this.f11285a.f2659d.getItemCount();
        this.f11285a.f2658c.setItemCount(itemCount);
        itemCount = i + i2 >= itemCount ? 1 : 0;
        if (ContentChangeStrategy.KEEP_ADS_FIXED == this.f11285a.f2662g || (ContentChangeStrategy.INSERT_AT_END == this.f11285a.f2662g && itemCount != 0)) {
            this.f11285a.notifyDataSetChanged();
            return;
        }
        while (i3 < i2) {
            this.f11285a.f2658c.insertItem(i);
            i3++;
        }
        this.f11285a.notifyItemRangeInserted(adjustedPosition, i2);
    }

    public void onItemRangeRemoved(int i, int i2) {
        int i3 = 0;
        int adjustedPosition = this.f11285a.f2658c.getAdjustedPosition(i);
        int itemCount = this.f11285a.f2659d.getItemCount();
        this.f11285a.f2658c.setItemCount(itemCount);
        int i4 = i + i2 >= itemCount ? 1 : 0;
        if (ContentChangeStrategy.KEEP_ADS_FIXED == this.f11285a.f2662g || (ContentChangeStrategy.INSERT_AT_END == this.f11285a.f2662g && i4 != 0)) {
            this.f11285a.notifyDataSetChanged();
            return;
        }
        i4 = this.f11285a.f2658c.getAdjustedCount(itemCount + i2);
        while (i3 < i2) {
            this.f11285a.f2658c.removeItem(i);
            i3++;
        }
        i4 -= this.f11285a.f2658c.getAdjustedCount(itemCount);
        this.f11285a.notifyItemRangeRemoved(adjustedPosition - (i4 - i2), i4);
    }

    public void onItemRangeMoved(int i, int i2, int i3) {
        this.f11285a.notifyDataSetChanged();
    }
}
