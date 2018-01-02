package com.miui.player.ui.model;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.plugin.onlinemusic2.Bill;
import com.miui.player.plugin.onlinemusic2.Bill.BillDetail;
import com.miui.player.plugin.onlinemusic2.BillList;
import com.miui.player.ui.fragment.AsyncFragment.DataAdapter;
import java.util.List;

public class BillListAdapter extends DataAdapter<Bill, BillList> {
    static final int[] PREVIEW_ID_ARR = new int[]{C0329R.id.song_item_preview_1, C0329R.id.song_item_preview_2, C0329R.id.song_item_preview_3, C0329R.id.song_item_preview_4};
    static final int[] PREVIEW_NUM_ARR = new int[]{C0329R.drawable.bill_preview_num_1, C0329R.drawable.bill_preview_num_2, C0329R.drawable.bill_preview_num_3, C0329R.drawable.bill_preview_num_4};
    static List<Pair<BillDetail, AudioList>> sBillDetailList = null;
    private final LayoutInflater mInflater;
    private final BillDetailRequester mRequester;

    public interface BillDetailRequester {
        void request(String[] strArr, int i);
    }

    static class PreviewHolder {
        public final ImageView mImageViewNum;
        public final TextView mTextViewArtist;
        public final TextView mTextViewTrack;

        public PreviewHolder(View view) {
            this.mImageViewNum = (ImageView) view.findViewById(C0329R.id.track_number);
            this.mTextViewTrack = (TextView) view.findViewById(C0329R.id.track_name);
            this.mTextViewArtist = (TextView) view.findViewById(C0329R.id.artist_name);
        }
    }

    static class ViewHolder {
        public final PreviewHolder[] mPreviewHolders = new PreviewHolder[BillListAdapter.PREVIEW_ID_ARR.length];
        public final View[] mPreviews = new View[BillListAdapter.PREVIEW_ID_ARR.length];
        public final TextView mTextViewTitle;

        public ViewHolder(View view) {
            this.mTextViewTitle = (TextView) view.findViewById(C0329R.id.billboard_name);
            for (int i = 0; i < BillListAdapter.PREVIEW_ID_ARR.length; i++) {
                View v = view.findViewById(BillListAdapter.PREVIEW_ID_ARR[i]);
                this.mPreviews[i] = v;
                this.mPreviewHolders[i] = new PreviewHolder(v);
            }
        }
    }

    public BillListAdapter(Context context, BillDetailRequester requester) {
        this.mInflater = LayoutInflater.from(context);
        this.mRequester = requester;
    }

    private String[] getRequestIdList() {
        List<Bill> bl = ((BillList) this.mData).getContent();
        String[] ids = new String[bl.size()];
        int i = 0;
        for (Bill bill : bl) {
            int i2 = i + 1;
            ids[i] = bill.mOutline.mId;
            i = i2;
        }
        return ids;
    }

    public void respose(List<Pair<BillDetail, AudioList>> result) {
        if (result != null) {
            sBillDetailList = result;
            if (hasContent()) {
                bindDetailList((BillList) this.mData, result);
                notifyDataSetChanged();
            }
        }
    }

    static void bindDetailList(BillList bl, List<Pair<BillDetail, AudioList>> detailList) {
        for (Bill bill : bl.getContent()) {
            String bid = bill.mOutline.mId;
            for (Pair<BillDetail, AudioList> pair : detailList) {
                if (pair.first != null && TextUtils.equals(bid, ((BillDetail) pair.first).mType)) {
                    bill.mBillDetail = (BillDetail) pair.first;
                    bill.mAudioList = (AudioList) pair.second;
                }
            }
        }
    }

    protected void onDataChanged() {
        if (hasContent()) {
            if (sBillDetailList != null) {
                bindDetailList((BillList) this.mData, sBillDetailList);
                notifyDataSetChanged();
            }
            String[] list = getRequestIdList();
            if (list != null && list.length > 0) {
                this.mRequester.request(list, PREVIEW_ID_ARR.length);
            }
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        List<Audio> al = null;
        View view = convertView;
        if (view == null) {
            view = this.mInflater.inflate(C0329R.layout.bill_item, null);
            view.setTag(new ViewHolder(view));
        }
        ViewHolder vh = (ViewHolder) view.getTag();
        Bill bill = (Bill) ((BillList) this.mData).get(position);
        vh.mTextViewTitle.setText(bill.mOutline.mName);
        if (bill.mAudioList != null) {
            al = bill.mAudioList.getContent();
        }
        int i = 0;
        if (al != null) {
            int len = Math.min(al.size(), PREVIEW_ID_ARR.length);
            while (i < len) {
                View v = vh.mPreviews[i];
                setPreviewItem(i, v, vh.mPreviewHolders[i], (Audio) al.get(i));
                v.setVisibility(0);
                i++;
            }
        }
        while (i < PREVIEW_ID_ARR.length) {
            vh.mPreviews[i].setVisibility(4);
            i++;
        }
        return view;
    }

    private void setPreviewItem(int num, View pi, PreviewHolder ph, Audio audio) {
        String artist;
        ph.mImageViewNum.setImageResource(PREVIEW_NUM_ARR[num]);
        ph.mTextViewTrack.setText(audio.mOutline.mTitle);
        if (audio.mDetail != null) {
            artist = audio.mDetail.mArtistName;
        } else {
            artist = null;
        }
        ph.mTextViewArtist.setText(artist);
    }
}
