package com.miui.player.effect.dirac;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import java.util.List;
import miui.os.Build;

public class DiracHeadsetAdapter extends BaseAdapter {
    private final Headset[] mList;

    static class Headset {
        final int mImageRes;
        final int mNameRes;
        final int mType;

        public Headset(int imageRes, int nameRes, int type) {
            this.mImageRes = imageRes;
            this.mNameRes = nameRes;
            this.mType = type;
        }
    }

    static class ViewHolder {
        final ImageView mHeadsetImage;
        final TextView mHeadsetName;

        public ViewHolder(View view) {
            this.mHeadsetImage = (ImageView) view.findViewById(C0329R.id.headset_image);
            this.mHeadsetName = (TextView) view.findViewById(C0329R.id.headset_name);
        }
    }

    public DiracHeadsetAdapter(DiracUtils diracUtils) {
        List<Pair<Integer, Integer>> list = diracUtils.getHeadseIdsAndTypes();
        this.mList = new Headset[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Pair<Integer, Integer> pair = (Pair) list.get(i);
            int headsetId = ((Integer) pair.first).intValue();
            this.mList[i] = new Headset(getHeadsetDrawableRes(headsetId), getHeadsetStringRes(headsetId), ((Integer) pair.second).intValue());
        }
    }

    public int getCount() {
        return this.mList.length;
    }

    public Object getItem(int position) {
        return this.mList[position];
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), C0329R.layout.dirac_headset_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        Headset headset = (Headset) getItem(position);
        ViewHolder vh = (ViewHolder) convertView.getTag();
        vh.mHeadsetImage.setImageResource(headset.mImageRes);
        vh.mHeadsetName.setText(headset.mNameRes);
        return convertView;
    }

    public int getHeadsetPositon(int type) {
        for (int i = 0; i < getCount(); i++) {
            if (type == getHeadsetType(i)) {
                return i;
            }
        }
        return -1;
    }

    public int getHeadsetType(int postion) {
        return ((Headset) getItem(postion)).mType;
    }

    private int getHeadsetDrawableRes(int headsetId) {
        switch (headsetId) {
            case 1:
                return C0329R.drawable.headset_earbuds;
            case 2:
                return C0329R.drawable.headset_in_ear;
            case 3:
                return C0329R.drawable.headset_piston_100;
            case 5:
                return C0329R.drawable.headset_general_earbuds;
            case 6:
                return C0329R.drawable.headset_general_inear;
            case 7:
                return C0329R.drawable.headset_youth;
            case 8:
                return C0329R.drawable.headset_piston_2;
            default:
                return 0;
        }
    }

    private int getHeadsetStringRes(int headsetId) {
        switch (headsetId) {
            case 1:
                return C0329R.string.dirac_mode_earbuds;
            case 2:
                return C0329R.string.dirac_mode_in_ear;
            case 3:
                return C0329R.string.dirac_mode_piston_100;
            case 5:
                if (Build.IS_MI2A) {
                    return C0329R.string.dirac_mode_general;
                }
                return C0329R.string.dirac_mode_general_earbuds;
            case 6:
                return C0329R.string.dirac_mode_general_inear;
            case 7:
                return C0329R.string.dirac_mode_piston_youth;
            case 8:
                return C0329R.string.dirac_mode_piston_2;
            default:
                return 0;
        }
    }
}
